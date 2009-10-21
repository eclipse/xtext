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
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;
import org.eclipse.xtext.ui.core.util.JdtURIUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class JavaClassPathResourceForIEditorInputFactory implements IResourceForEditorInputFactory {

	@Inject
	private JdtURIUtil jdtURIUtil;
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	public Resource createResource(IEditorInput editorInput) {
		try {
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editorInput).getStorage();
				if (storage instanceof IFile) {
					return createResourceFor((IFile) storage);
				} else {
					return createResourceFor((IJarEntryResource) storage);
				}
			}
			throw new IllegalArgumentException("Couldn't create EMF Resource for input "+editorInput);
		} catch (CoreException e) {
			throw new WrappedException(e);
		}
	}

	private Resource createResourceFor(IJarEntryResource storage) {
		XtextResourceSet resourceSet = getResourceSet(storage);
		URI uri = jdtURIUtil.getURI(storage);
		XtextResource resource = getResource(resourceSet, uri);
		resource.setValidationDisabled(true);
		return resource;
	}

	private XtextResource getResource(XtextResourceSet resourceSet, URI uri) {
		Resource aResource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + uri
					+ " does not yield an XtextResource. Make sure the right resource factory has been registered.");
		return (XtextResource) aResource;
	}

	protected XtextResourceSet getResourceSet(IStorage storage) {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		if (storage==null)
			return resourceSet;
		IJavaProject javaProject = getIJavaProject(storage);
		if (javaProject != null) {
			resourceSet.setClasspathUriResolver(new JdtClasspathUriResolver());
			resourceSet.setClasspathURIContext(javaProject);
		}
		return resourceSet;
	}

	private Resource createResourceFor(IFile storage) {
		XtextResourceSet resourceSet = getResourceSet(storage);
		URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(),true);
		XtextResource resource = getResource(resourceSet, uri);
		resource.setValidationDisabled(false);
		return resource;
	}

	private IJavaProject getIJavaProject(IStorage storage) {
		IJavaProject jp = null;
		if (storage instanceof IFile) {
			jp = JavaCore.create(((IFile) storage).getProject());
		} else if (storage instanceof IJarEntryResource) {
			jp = ((IJarEntryResource) storage).getPackageFragmentRoot().getJavaProject();
		}
		if (jp != null && jp.exists())
			return jp;
		return null;
	}

}