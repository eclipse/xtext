/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreSupportTest extends Assert {
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class EcoreRuntimeModuleForTest extends EcoreRuntimeModule {
		private final ResourceServiceProviderRegistryImpl registry;

		public EcoreRuntimeModuleForTest(ResourceServiceProviderRegistryImpl registry) {
			this.registry = registry;
		}

		public IResourceServiceProvider.Registry bindRSPRegistry() {
			return registry;
		}
	}

	@Test public void testSimple() throws Exception {
		final ResourceServiceProviderRegistryImpl registry = new ResourceServiceProviderRegistryImpl();
		EcoreSupport support = new EcoreSupport();
		support.setGuiceModule(new EcoreRuntimeModuleForTest(registry));
		
		assertNull(registry.getExtensionToFactoryMap().get("ecore"));
		support.preInvoke();
		IResourceServiceProvider rsp = (IResourceServiceProvider) registry.getExtensionToFactoryMap().get("ecore");
		assertNotNull(rsp.getResourceDescriptionManager());
	}
}
