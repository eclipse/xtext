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
import java.util.List;

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
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
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
	
	@Override
	public Iterable<IResourceDescription> load() {
		File location = getBuilderStateLocation();
		try {
			if (location != null && location.exists()) {
				try {
					Resource resource = createResource();
					if (resource != null) {
						try {
							resource.load(null);
						} catch (IOException exception) {
							if (exception.getMessage().contains("Invalid signature")) {
								resource.unload();
								resource.load(Collections.singletonMap(XMLResource.OPTION_BINARY, Boolean.FALSE));
							} else {
								throw exception;
							}
						}
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
			log.warn("Error while loading persistable builder state from '"+location+"'. This could happen after an upgrade or if the persisted index state got corrupted. Triggering a full build. Problem was : "+e.getMessage()+" ("+e.getClass().getSimpleName()+")");
			scheduleRecoveryBuild();
		} finally {
			try {
				if (workspace != null) {
					addSaveParticipant();
				}
			} catch (CoreException e) {
				log.error("Error adding builder state save participant", e);
			}
		}
		return Collections.emptySet();
	}

	@SuppressWarnings("all")
	protected void addSaveParticipant() throws CoreException {
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

	public Iterable<IResourceDescription> loadFromResource(Resource resource) {
		List<IResourceDescription> result = Lists.newArrayList(
				Iterables.filter(resource.getContents(), IResourceDescription.class));
		resource.getContents().clear();
		return result;
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
		if (factory == null) {
			factory = new XMIResourceFactoryImpl() {
				@Override
				public Resource createResource(URI uri) {
					ResourceDescriptionResource resourceDescriptionResource = new ResourceDescriptionResource(uri);
					NoOpURIHandler uriHandler = new NoOpURIHandler();
					resourceDescriptionResource.getDefaultSaveOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
					resourceDescriptionResource.getDefaultSaveOptions().put(BinaryResourceImpl.OPTION_VERSION, BinaryResourceImpl.BinaryIO.Version.VERSION_1_1);
					resourceDescriptionResource.getDefaultSaveOptions().put(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 10000);
					resourceDescriptionResource.getDefaultSaveOptions().put(BinaryResourceImpl.OPTION_STYLE_DATA_CONVERTER, Boolean.TRUE);
					resourceDescriptionResource.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);

					resourceDescriptionResource.getDefaultLoadOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
					resourceDescriptionResource.getDefaultLoadOptions().put(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 10000);
					resourceDescriptionResource.getDefaultLoadOptions().put(BinaryResourceImpl.OPTION_EAGER_PROXY_RESOLUTION, Boolean.TRUE);
					resourceDescriptionResource.getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
					return resourceDescriptionResource;
				}
			};
		}
		return factory;
	}

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	private static class NoOpURIHandler implements XMLResource.URIHandler {
		@Override
		public void setBaseURI(URI uri) {
		}
	
		@Override
		public URI resolve(URI uri) {
			return uri;
		}
	
		@Override
		public URI deresolve(URI uri) {
			return uri;
		}
	}

	private static class ResourceDescriptionResource extends XMIResourceImpl {

		public ResourceDescriptionResource(URI uri) {
			super(uri);
		}

		@Override
		public void attached(EObject eObject) {
			// Ignore.
		}
		
		@Override
		public void detached(EObject eObject) {
			// Ignore.
		}

		@Override
		protected boolean useIDs() {
			return false;
		}
	}

	protected void scheduleRecoveryBuild() {
		Iterable<IProject> projects = Lists.newArrayList(workspace.getRoot().getProjects());
		buildManager.scheduleBuildIfNecessary(projects, IBuildFlag.RECOVERY_BUILD);
	}

}
