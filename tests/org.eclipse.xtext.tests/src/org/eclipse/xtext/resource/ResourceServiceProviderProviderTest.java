/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ResourceServiceProviderProviderTest {

	public static class TestResourceServiceProviderExecutableExtensionFactory implements IExecutableExtensionFactory {
		@Override
		public Object create() throws CoreException {
			return new TestResourceServiceProviderProvider();
		}
	}

	private static class TestResourceServiceProvider extends DefaultResourceServiceProvider {
		private URI uri;
		private String contentType;

		public TestResourceServiceProvider(URI uri, String contentType) {
			super();
			this.uri = uri;
			this.contentType = contentType;
		}
	}

	public static class TestResourceServiceProviderProvider implements IResourceServiceProvider.Provider {
		@Override
		public IResourceServiceProvider get(URI uri, String contentType) {
			return new TestResourceServiceProvider(uri, contentType);
		}
	}

	@Test
	public void testResourceServiceProviderProvider() {
		String contenttype = "mycontent";
		String ext = "TestResourceServiceProviderProvider";
		URI uri = URI.createFileURI("foofile." + ext);
		Registry registry = IResourceServiceProvider.Registry.INSTANCE;

		// the file extension is registered via plugin.xml
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri, contenttype);
		Assert.assertTrue(resourceServiceProvider instanceof TestResourceServiceProvider);
		TestResourceServiceProvider provider = (TestResourceServiceProvider) resourceServiceProvider;
		Assert.assertEquals(uri, provider.uri);
		Assert.assertEquals(contenttype, provider.contentType);
	}
	
	@Test
	public void testResourceServiceProviderProviderWithExecutableExtensionFactory() {
		String contenttype = "mycontent";
		String ext = "TestResourceServiceProviderExecutableExtensionFactory";
		URI uri = URI.createFileURI("foofile." + ext);
		Registry registry = IResourceServiceProvider.Registry.INSTANCE;
		
		// the file extension is registered via plugin.xml
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri, contenttype);
		Assert.assertTrue(resourceServiceProvider instanceof TestResourceServiceProvider);
		TestResourceServiceProvider provider = (TestResourceServiceProvider) resourceServiceProvider;
		Assert.assertEquals(uri, provider.uri);
		Assert.assertEquals(contenttype, provider.contentType);
	}
}
