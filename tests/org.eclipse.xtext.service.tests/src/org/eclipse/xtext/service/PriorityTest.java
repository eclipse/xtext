/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.xtext.service.examples.InjectedService;
import org.eclipse.xtext.service.examples.InjectedService2;
import org.eclipse.xtext.service.examples.InjectedServiceFactory;
import org.eclipse.xtext.service.examples.InjectedServiceFactory2;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PriorityTest extends AbstractServiceTest {

	public void testRegisterSamePriority() throws Exception {
		IServiceFactory factory0 = new InjectedServiceFactory();
		ServiceRegistry.registerFactory(myScope, factory0);
		try {
			ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory2());
			fail("IllegalStateException expected");
		} catch (IllegalStateException e) {
			// expected
		}
		Object service1 = ServiceRegistry.getService(myScope, InjectedService.class);
		assertFalse(service1 instanceof InjectedService2);
	}

	public void testRegisterHigherPriority() throws Exception {
		IServiceFactory factory0 = new InjectedServiceFactory();
		ServiceRegistry.registerFactory(myScope, factory0);
		IServiceFactory factory1 = new InjectedServiceFactory2();
		try {
			ServiceRegistry.registerFactory(myScope, factory1);
			fail();
		} catch (IllegalStateException e) {
			// expected
		}
		ServiceRegistry.registerFactory(myScope, factory1, ServiceRegistry.PRIORITY_MAX);
		Object service2 = ServiceRegistry.getService(myScope, InjectedService.class);
		assertTrue(service2 instanceof InjectedService2);
	}
}
