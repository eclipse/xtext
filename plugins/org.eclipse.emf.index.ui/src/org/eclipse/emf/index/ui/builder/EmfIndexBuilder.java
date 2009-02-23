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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.eclipse.emf.index.ui.emfIndexBuilder";

	private static final String MARKER_TYPE = "org.eclipse.emf.index.ui.emfIndexProblem";

	private IIndexStore index = IIndexStore.eINSTANCE;

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
					tryIndexResource(resource);
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
						tryIndexResource(resource);
						break;
					case IResourceDelta.REMOVED:
						// TODO implement
						break;
				}
				return resource instanceof IContainer;
			}
		});
	}

	protected boolean tryIndexResource(IResource resource) {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			try {
				deleteMarkers(file);
				Set<String> keySet = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet();
				if (keySet.contains(file.getFileExtension())) {
					URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					Resource.Factory emfResourceFactory = Resource.Factory.Registry.INSTANCE.getFactory(resourceURI);
					if (emfResourceFactory != null) {
						// TODO remove dependency to xtext
						IJavaProject javaProject = getJavaProject();
						ResourceSet resourceSet = null;
						if(javaProject.exists()) {
							resourceSet = new XtextResourceSet();
							((XtextResourceSet) resourceSet).setClasspathUriResolver(new JdtClasspathUriResolver());
							((XtextResourceSet) resourceSet).setClasspathURIContext(javaProject);
						} else {
							resourceSet = new ResourceSetImpl();
						}
						Resource emfResource = resourceSet.getResource(resourceURI, true);
						EList<EObject> contents = emfResource.getContents();
						boolean isIndexAsInstance = true;
						if (!contents.isEmpty() && contents.get(0) instanceof EPackage) {
							isIndexAsInstance = false;
							for (EObject eObject : contents) {
								if (eObject instanceof EPackage)
									index.indexFeeder().index((EPackage) eObject, true);
								else
									isIndexAsInstance = true;
							}
						}
						if (isIndexAsInstance) {
							index.indexFeeder().index(emfResource, false);
						}
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

	private IJavaProject getJavaProject() {
		return JavaCore.create(getProject());
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
