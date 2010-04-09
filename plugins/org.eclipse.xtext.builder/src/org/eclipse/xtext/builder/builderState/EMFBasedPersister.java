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
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
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
public class EMFBasedPersister implements PersistableResourceDescriptionsImpl.PersistedStateProvider {

	private final static Logger log = Logger.getLogger(EMFBasedPersister.class);

	@Inject(optional=true)
	private IWorkbench workbench;

	@Inject
	private IWorkspace workspace;

	@Inject
	private IBuilderState builderState;

	@Inject
	private BuildScheduler buildManager;
	
	private Resource.Factory factory;

	public Iterable<IResourceDescription> load() {
		try {
			if (getBuilderStateLocation().exists()) {
				try {
					Resource resource = createResource();
					resource.load(null);
					return loadFromResource(resource);
				} finally {
					getBuilderStateLocation().delete();
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
			if (workbench != null) {
				workbench.addWorkbenchListener(new IWorkbenchListener() {
					public boolean preShutdown(IWorkbench workbench, boolean forced) {
						save(builderState.getAllResourceDescriptions());
						return true;
					}

					public void postShutdown(IWorkbench workbench) {
						// do nothing.
					}
				});
			}
		}
		return Collections.emptySet();
	}

	public Iterable<IResourceDescription> loadFromResource(Resource resource) {
		return Iterables.filter(resource.getContents(), IResourceDescription.class);
	}

	public void save(Iterable<IResourceDescription> descriptions) {
		Resource res = createResource();
		saveToResource(res, descriptions);
		try {
			res.save(null);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public Resource createResource() {
		URI fileURI = getBuilderStateURI();
		Resource res = getFactory().createResource(fileURI);
		return res;
	}

	public void saveToResource(Resource res, Iterable<IResourceDescription> descriptions) {
		Iterables.addAll(res.getContents(), Iterables.filter(descriptions, EObject.class));
	}

	public URI getBuilderStateURI() {
		URI fileURI = URI.createFileURI(getBuilderStateLocation().getAbsolutePath());
		return fileURI;
	}

	protected File getBuilderStateLocation() {
		return Activator.getDefault().getStateLocation().append("builder.state").toFile();
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
