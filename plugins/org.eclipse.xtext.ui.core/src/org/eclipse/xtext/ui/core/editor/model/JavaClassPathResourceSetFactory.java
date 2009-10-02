/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class JavaClassPathResourceSetFactory implements IResourceForEditorInputFactory {
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	public Resource createResource(IEditorInput editorInput) {
		IFile file = ResourceUtil.getFile(editorInput);

		XtextResourceSet resourceSet = resourceSetProvider.get();
		if (file != null) {
			// TODO find a way to identify a project for an IStorageEditorInput
			IJavaProject javaProject = getIJavaProject(file);
			if (javaProject != null) {
				resourceSet.setClasspathUriResolver(new JdtClasspathUriResolver());
				resourceSet.setClasspathURIContext(javaProject);
			}
		}

		IPath path = null;
		Resource aResource = null;
		URI uri = null;
		if (file != null) {
			path = file.getFullPath();
			uri = URI.createPlatformResourceURI(path.toString(), true);
		}
		else if (editorInput instanceof XtextReadonlyEditorInput) {
			uri = ((XtextReadonlyEditorInput) editorInput).getURI();
		}
		else {
			IStorageEditorInput storageInput = (IStorageEditorInput) editorInput;
			try {
				// TODO get the FQN of the resource
				path = storageInput.getStorage().getFullPath();
				uri = URI.createPlatformResourceURI(path.toString(), true);
			}
			catch (CoreException e) {
				throw new WrappedException(e);
			}
		}

		aResource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + path
					+ " does not yield an XtextResource. Make sure the right resource factory has been registered.");
		XtextResource resource = (XtextResource) aResource;
		if (resource instanceof LazyLinkingResource)
			((LazyLinkingResource) resource).setEagerLinking(true);
		resource.setValidationDisabled(file == null);
		return resource;
	}
	
	private IJavaProject getIJavaProject(IResource resource) {
		IJavaProject create = JavaCore.create(resource.getProject());
		if (create.exists())
			return create;
		return null;
	}
	
}