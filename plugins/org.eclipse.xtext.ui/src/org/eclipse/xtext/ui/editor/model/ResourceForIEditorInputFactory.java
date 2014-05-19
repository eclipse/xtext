/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class ResourceForIEditorInputFactory implements IResourceForEditorInputFactory {

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IResourceFactory resourceFactory;

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IExternalContentProvider externalContentProvider;
	
	@Inject(optional = true)
	private IWorkspace workspace;
	
	/**
	 * @throws IllegalArgumentException
	 *             if no resource can be provided for the given input.
	 */
	public Resource createResource(IEditorInput editorInput) {
		try {
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editorInput).getStorage();
				Resource result = createResource(storage);
				if (result != null)
					return result;
			} else if (editorInput instanceof IURIEditorInput) {
				Resource result = createResource(((IURIEditorInput) editorInput).getURI());
				if (result != null)
					return result;
			}
		} catch (CoreException e) {
			throw new WrappedException(e);
		}
		throw new IllegalArgumentException("Couldn't create EMF Resource for input " + editorInput);
	}

	/**
	 * @since 2.3
	 */
	protected Resource createResource(java.net.URI uri) {
		ResourceSet resourceSet = getResourceSet(null);
		URI emfUri = URI.createURI(uri.toString());
		configureResourceSet(resourceSet, emfUri);
		XtextResource resource = (XtextResource) resourceFactory.createResource(emfUri);
		resourceSet.getResources().add(resource);
		resource.setValidationDisabled(true);
		return resource;
	}

	protected Resource createResource(IStorage storage) throws CoreException {
		return createResourceFor(storage);
	}

	protected Resource createResourceFor(IStorage storage) throws CoreException {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		configureResourceSet(resourceSet, uri);
		URI uriForResource = uri; 
		if (!uri.isPlatform()) {
			uriForResource = resourceSet.getURIConverter().normalize(uri);
		}
		XtextResource resource = (XtextResource) resourceFactory.createResource(uriForResource);
		resourceSet.getResources().add(resource);
		resource.setValidationDisabled(isValidationDisabled(uri, storage));
		return resource;
	}

	/**
	 * @param uri 
	 * @since 2.5
	 */
	protected boolean isValidationDisabled(URI uri, IStorage storage) {
		return false;
	}

	/**
	 * @since 2.4
	 */
	protected boolean isValidationDisabled(IStorage storage) {
		return isValidationDisabled(null, storage);
	}

	protected XtextResource createResource(ResourceSet resourceSet, URI uri) {
		//TODO use the resource factory directly (injected), since the use might open any file with this editor.
		Resource aResource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + uri
					+ " does not yield an XtextResource. Make sure the file name extension is correct (case matters).");
		return (XtextResource) aResource;
	}

	protected ResourceSet getResourceSet(/* @Nullable */ IStorage storage) {
		if (storage instanceof IFile) {
			return resourceSetProvider.get(((IFile) storage).getProject());
		}
		if (workspace != null && storage != null) {
			IPath path = storage.getFullPath();
			if (path != null && !path.isEmpty()) {
				String firstSegment = path.segment(0);
				if (firstSegment != null) {
					IProject project = workspace.getRoot().getProject(firstSegment);
					if (project.isAccessible()) {
						return resourceSetProvider.get(project);
					}
				}
			}
		}
		return resourceSetProvider.get(null);
	}

	protected void configureResourceSet(ResourceSet resourceSet, URI primaryURI) {
		// TODO: Filter external content - primary resource should not use dirty state
		externalContentSupport.configureResourceSet(resourceSet, externalContentProvider);
	}

	protected IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	protected IExternalContentSupport getExternalContentSupport() {
		return externalContentSupport;
	}

	protected IExternalContentProvider getExternalContentProvider() {
		return externalContentProvider;
	}
	
	/**
	 * @since 2.4
	 */
	protected IResourceFactory getResourceFactory() {
		return resourceFactory;
	}
}
