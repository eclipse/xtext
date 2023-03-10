/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;

/**
 * @author Michael Clay
 * @author Jan Koehnlein
 */
public class JavaClassPathResourceForIEditorInputFactory extends ResourceForIEditorInputFactory {

	@Inject
	private IStorage2UriMapper storageToUriMapper;
	
	/**
	 * @since 2.5
	 */
	public IStorage2UriMapper getStorageToUriMapper() {
		return storageToUriMapper;
	}

	@Override
	protected Resource createResource(IStorage storage) throws CoreException {
		if (storage instanceof IJarEntryResource) {
			Resource result = createResourceFor((IJarEntryResource) storage);
			if (result == null) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot create resource for storage with path " + storage.getFullPath()));
			}
			return result;
		}
		return super.createResource(storage);
	}

	protected Resource createResourceFor(IJarEntryResource storage) {
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = storageToUriMapper.getUri(storage);
		if (uri == null) {
			return null;
		}
		configureResourceSet(resourceSet, uri);
		XtextResource resource = createResource(resourceSet, uri);
		resource.setValidationDisabled(isValidationDisabled(uri, storage));
		return resource;
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	protected boolean isValidationDisabled(URI uri, IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			return true;
		}
		return super.isValidationDisabled(uri, storage);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	protected boolean isValidationDisabled(IStorage storage) {
		return isValidationDisabled(null, storage);
	}

	@Override
	protected ResourceSet getResourceSet(/* @Nullable */ IStorage storage) {
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