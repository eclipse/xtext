/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;

/**
 * @author Michael Clay
 * @author Jan Koehnlein
 */
public class JavaClassPathResourceForIEditorInputFactory extends ResourceForIEditorInputFactory {

	@Inject
	private IStorage2UriMapper storageToUriMapper;

	@Override
	protected Resource createResource(IStorage storage) throws CoreException {
		if (storage instanceof IJarEntryResource) {
			return createResourceFor((IJarEntryResource) storage);
		}
		return super.createResource(storage);
	}

	protected Resource createResourceFor(IJarEntryResource storage) {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = storageToUriMapper.getUri(storage);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = createResource(resourceSet, uri);
		resource.setValidationDisabled(isValidationDisabled(storage));
		return resource;
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	protected boolean isValidationDisabled(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			return true;
		}
		return super.isValidationDisabled(storage);
	}

	@Override
	protected ResourceSet getResourceSet(@Nullable IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			IPackageFragmentRoot root = ((IJarEntryResource) storage).getPackageFragmentRoot();
			if (root != null) {
				IJavaProject project = root.getJavaProject();
				if (project != null)
					return getResourceSetProvider().get(project.getProject());
			}
		} 
		return super.getResourceSet(storage);
	}
}