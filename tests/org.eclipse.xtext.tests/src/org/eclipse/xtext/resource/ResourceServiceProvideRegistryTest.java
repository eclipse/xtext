/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author efftinge - Initial contribution and API
 */
public class ResourceServiceProvideRegistryTest {

	@Test
	public void testUninstallBadProvider() {
		final IResourceServiceProvider.Provider provider = new IResourceServiceProvider.Provider() {
			public IResourceServiceProvider get(URI uri, String contentType) {
				throw new NullPointerException();
			}
		};
		
		IResourceServiceProvider.Registry reg = new ResourceServiceProviderRegistryImpl();
		reg.getExtensionToFactoryMap().put("foo", provider);
		
		assertEquals(1, reg.getExtensionToFactoryMap().size());
		assertNull(reg.getResourceServiceProvider(URI.createURI("hubba.foo")));
		assertEquals(0, reg.getExtensionToFactoryMap().size());
	}
}
