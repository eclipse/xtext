/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.resource;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UriValidatorBug406208Test implements IStorage, IResourceServiceProvider.Registry {

	@Test
	public void testExtensionIsEncoded() throws Exception {
		UriValidator validator = new UriValidator();
		new ReflectExtensions().set(validator, "registry", this);
		Assert.assertTrue(validator.isPossiblyManaged(this));
	}
	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		throw new UnsupportedOperationException();
	}

	public InputStream getContents() throws CoreException {
		throw new UnsupportedOperationException();
	}

	public IPath getFullPath() {
		return new Path("fileName.file extension");
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public boolean isReadOnly() {
		throw new UnsupportedOperationException();
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		throw new UnsupportedOperationException();
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		throw new UnsupportedOperationException();
	}

	public Map<String, Object> getContentTypeToFactoryMap() {
		return Collections.emptyMap();
	}

	public Map<String, Object> getExtensionToFactoryMap() {
		return Collections.singletonMap("file%20extension", new Object());
	}

	public Map<String, Object> getProtocolToFactoryMap() {
		throw new UnsupportedOperationException();
	}

}
