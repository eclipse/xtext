/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
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
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IExternalContentProvider externalContentProvider;

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
			}
		} catch (CoreException e) {
			throw new WrappedException(e);
		}
		throw new IllegalArgumentException("Couldn't create EMF Resource for input " + editorInput);
	}

	protected Resource createResource(IStorage storage) throws CoreException {
		if (storage instanceof IFile)
			return createResourceFor((IFile) storage);
		return null;
	}

	protected Resource createResourceFor(IFile storage) throws CoreException {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = createResource(resourceSet, uri);
		resource.setValidationDisabled(false);
		return resource;
	}

	protected XtextResource createResource(ResourceSet resourceSet, URI uri) {
		Resource aResource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + uri
					+ " does not yield an XtextResource. Make sure the file name extension is correct (case matters).");
		return (XtextResource) aResource;
	}

	protected ResourceSet getResourceSet(IStorage storage) {
		if (storage instanceof IFile) {
			return resourceSetProvider.get(((IFile) storage).getProject());
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

}
