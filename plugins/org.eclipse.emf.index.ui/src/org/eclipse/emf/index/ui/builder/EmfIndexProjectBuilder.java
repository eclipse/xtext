/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.builder;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.resource.impl.IndexBuilderImpl;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexProjectBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.eclipse.emf.index.ui.emfIndexBuilder";

	private static final String MARKER_TYPE = "org.eclipse.emf.index.ui.emfIndexProblem";

	private IIndexStore index = IIndexStore.INSTANCE;

	private IndexBuilderImpl indexBuilder = new IndexBuilderImpl(index);

	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		}
		else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			}
			else {
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
		}
		catch (CoreException e) {
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
			try {
				deleteMarkers(file);
				Set<String> keySet = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet();
				if (keySet.contains(file.getFileExtension())) {
					URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					Resource.Factory emfResourceFactory = Resource.Factory.Registry.INSTANCE.getFactory(resourceURI);
					if (emfResourceFactory != null) {
						if (isDeleted)
							indexBuilder.resourceDeleted(resourceURI);
						else
							indexBuilder.resourceChanged(resourceURI);
						return true;
					}
				}
			}
			catch (Exception e) {
				addMarker(file, e.getMessage(), 0, IMarker.SEVERITY_ERROR);
				EmfIndexUIPlugin.getDefault().getLog().log(
						new Status(IStatus.ERROR, EmfIndexUIPlugin.PLUGIN_ID, "Cannot index resource "
								+ resource.getFullPath().toString(), e));
			}
		}
		return false;
	}

	private void addMarker(IFile file, String message, int lineNumber, int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		}
		catch (CoreException e) {
		}
	}

	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		}
		catch (CoreException ce) {
		}
	}
}
