/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.LazyStringInputStream;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Convenience to create resource from text.
 * Useful if you want to avoid calls to {@link Resource#getContents()} before
 * all resources are available in the resource set.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 * @deprecated Use org.eclipse.xtext.testing.util.ResourceHelper instead
 */
@Deprecated(forRemoval = true)
public class ResourceHelper {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceFactory resourceFactory;

	private String fileExtension;
	
	@Inject
	public void setFileExtensionProvider(FileExtensionProvider extensionProvider) {
		fileExtension = extensionProvider.getPrimaryFileExtension();
	}
	
	void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Resource resource(InputStream in, URI uriToUse, Map<?, ?> options, ResourceSet resourceSet) {
		Resource resource = resourceFactory.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			resource.load(in, options);
			return resource;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public Resource resource(CharSequence text) throws Exception {
		return resource(text, createResourceSet());
	}

	public Resource resource(CharSequence text, ResourceSet resourceSetToUse) throws Exception {
		return resource(getAsStream(text), computeUnusedUri(resourceSetToUse), null, resourceSetToUse);
	}

	public Resource resource(CharSequence text, URI uriToUse, ResourceSet resourceSetToUse) throws Exception {
		return resource(getAsStream(text), uriToUse, null, resourceSetToUse);
	}
	
	/**
	 * @since 2.8
	 */
	public Resource resource(CharSequence text, URI uriToUse) throws Exception {
		return resource(getAsStream(text), uriToUse, null, createResourceSet());
	}

	protected URI computeUnusedUri(ResourceSet resourceSet) {
		String name = "__synthetic";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			URI syntheticUri = URI.createURI(name + i + "." + fileExtension);
			if (resourceSet.getResource(syntheticUri, false) == null)
				return syntheticUri;
		}
		throw new IllegalStateException();
	}

	protected InputStream getAsStream(CharSequence text) {
		return new LazyStringInputStream(text == null ? "" : text.toString());
	}
	
	protected String getFileExtension() {
		return fileExtension;
	}
	
	protected XtextResourceSet createResourceSet() {
		return resourceSetProvider.get();
	}

}
