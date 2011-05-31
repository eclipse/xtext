/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public class EMFBasedPersister implements PersistedStateProvider {

	private final static Logger log = Logger.getLogger(EMFBasedPersister.class);

	@Inject
	private IWorkspace workspace;

	@Inject
	private IBuilderState builderState;

	@Inject
	private BuildScheduler buildManager;
	
	private Resource.Factory factory;

	private IPath cachedPath;
	
	public Iterable<IResourceDescription> load() {
		try {
			File location = getBuilderStateLocation();
			if (location != null && location.exists()) {
				try {
					Resource resource = createResource();
					if (resource != null) {
						resource.load(null);
						EcoreUtil.resolveAll(resource);
						return loadFromResource(resource);
					}
					if (workspace != null && workspace.isAutoBuilding()) {
						scheduleRecoveryBuild();
					}
				} finally {
					location.delete();
				}
			} else {
				if (workspace != null && workspace.isAutoBuilding()) {
					scheduleRecoveryBuild();
				}
			}
		} catch (Exception e) {
			log.error("Error while loading persistable builder state.", e);
			log.error("Triggering a full build.");
			scheduleRecoveryBuild();
			throw new WrappedException(e);
		} finally {
			try {
				if (workspace != null) {
					workspace.addSaveParticipant(Activator.getDefault(), new ISaveParticipant() {
	
						public void saving(ISaveContext context) throws CoreException {
							if (context.getKind() == ISaveContext.FULL_SAVE)
								save(builderState.getAllResourceDescriptions());
						}
	
						public void rollback(ISaveContext context) {
						}
	
						public void prepareToSave(ISaveContext context) throws CoreException {
						}
	
						public void doneSaving(ISaveContext context) {
						}
					});
				}
			} catch (CoreException e) {
				log.error("Error adding builder state save participant", e);
			}
		}
		return Collections.emptySet();
	}

	public Iterable<IResourceDescription> loadFromResource(Resource resource) {
		return Iterables.filter(resource.getContents(), IResourceDescription.class);
	}

	public void save(Iterable<IResourceDescription> descriptions) {
		Resource res = createResource();
		if (res != null) {
			saveToResource(res, descriptions);
			try {
				res.save(null);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
	}

	public Resource createResource() {
		URI fileURI = getBuilderStateURI();
		if (fileURI == null)
			return null;
		Resource res = getFactory().createResource(fileURI);
		return res;
	}

	public void saveToResource(Resource res, Iterable<IResourceDescription> descriptions) {
		Iterables.addAll(res.getContents(), Iterables.filter(descriptions, EObject.class));
	}

	public URI getBuilderStateURI() {
		File location = getBuilderStateLocation();
		if (location == null)
			return null;
		URI fileURI = URI.createFileURI(location.getAbsolutePath());
		return fileURI;
	}

	protected File getBuilderStateLocation() {
		Activator activator = Activator.getDefault();
		if (activator == null) {
			if (cachedPath != null)
				return cachedPath.toFile();
			return null;
		}
		IPath path = activator.getStateLocation().append("builder.state");
		cachedPath = path;
		return path.toFile();
	}

	public void setFactory(Resource.Factory factory) {
		this.factory = factory;
	}

	public Resource.Factory getFactory() {
		if (factory == null)
			factory = new XMIResourceFactoryImpl();
		return factory;
	}

	protected void scheduleRecoveryBuild() {
		Iterable<IProject> projects = Lists.newArrayList(workspace.getRoot().getProjects());
		buildManager.scheduleBuildIfNecessary(projects, IBuildFlag.RECOVERY_BUILD);
	}

}
