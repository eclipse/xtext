/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.builder;

import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexProjectBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.eclipse.emf.index.ui.emfIndexBuilder";

	@Inject
	private ResourceIndexer.Registry indexerRegistry;

	@Inject
	private Provider<IndexFeeder> feederProvider;

	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new IResourceVisitor() {
				public boolean visit(IResource resource) {
					tryIndexResource(resource, false);
					return resource instanceof IContainer;
				}
			});
		} catch (CoreException e) {
			EmfIndexUIPlugin.logError("Error during full build", e);
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept(new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				IResource resource = delta.getResource();
				switch (delta.getKind()) {
				case IResourceDelta.ADDED:
				case IResourceDelta.CHANGED:
					tryIndexResource(resource, false);
					break;
				case IResourceDelta.REMOVED:
					tryIndexResource(resource, true);
					break;
				}
				return resource instanceof IContainer;
			}
		});
	}

	protected boolean tryIndexResource(IResource resource, boolean isDeleted) {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			if (file.isDerived())
				return false;
			try {
				ResourceIndexer indexer = indexerRegistry.getIndexerFor(file.getFileExtension());
				if (indexer != null) {
					URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					IndexFeeder feeder = feederProvider.get();
					if (isDeleted)
						indexer.resourceDeleted(resourceURI, feeder);
					else
						indexer.resourceChanged(resourceURI, feeder);
					feeder.commit();
					return true;
				}
			} catch (Exception e) {
				EmfIndexUIPlugin.logError("Cannot index resource " + resource.getFullPath().toString(), e);
			}
		}
		return false;
	}

}
