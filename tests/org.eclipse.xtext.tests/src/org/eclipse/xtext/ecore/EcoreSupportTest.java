/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

import junit.framework.TestCase;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreSupportTest extends TestCase {
	
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

	public void testSimple() throws Exception {
		final ResourceServiceProviderRegistryImpl registry = new ResourceServiceProviderRegistryImpl();
		EcoreSupport support = new EcoreSupport();
		support.setGuiceModule(new EcoreRuntimeModuleForTest(registry));
		
		assertNull(registry.getExtensionToFactoryMap().get("ecore"));
		support.preInvoke();
		IResourceServiceProvider rsp = (IResourceServiceProvider) registry.getExtensionToFactoryMap().get("ecore");
		assertNotNull(rsp.getResourceDescriptionManager());
	}
}
