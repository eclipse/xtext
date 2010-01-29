/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;

import com.google.inject.Inject;

/**
 * @author Michael Clay
 */
public class JavaClassPathResourceForIEditorInputFactory implements IResourceForEditorInputFactory {

	@Inject
	private IStorage2UriMapper storageToUriMapper;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IExternalContentProvider externalContentProvider;

	public Resource createResource(IEditorInput editorInput) {
		try {
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editorInput).getStorage();
				if (storage instanceof IFile) {
					return createResourceFor((IFile) storage);
				} else if (storage instanceof IJarEntryResource) {
					return createResourceFor((IJarEntryResource) storage);
				}
			}
			throw new IllegalArgumentException("Couldn't create EMF Resource for input " + editorInput);
		} catch (CoreException e) {
			throw new WrappedException(e);
		}
	}

	private Resource createResourceFor(IJarEntryResource storage) {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = storageToUriMapper.getUri(storage);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = getResource(resourceSet, uri);
		resource.setValidationDisabled(true);
		return resource;
	}

	protected void configureResourceSet(ResourceSet resourceSet, URI primaryURI) {
		// TODO: Filter external content - primary resource should not use dirty state
		externalContentSupport.configureResourceSet(resourceSet, externalContentProvider);
	}

	private XtextResource getResource(ResourceSet resourceSet, URI uri) {
		Resource aResource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + uri
					+ " does not yield an XtextResource. Make sure the right resource factory has been registered.");
		return (XtextResource) aResource;
	}

	protected ResourceSet getResourceSet(IStorage storage) {
		return resourceSetProvider.get(storage instanceof IFile ? ((IFile) storage).getProject() : null);
	}

	private Resource createResourceFor(IFile storage) {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = getResource(resourceSet, uri);
		resource.setValidationDisabled(false);
		return resource;
	}

}