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
import org.eclipse.xtext.service.examples.InjectedServiceFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class RegistrationTest extends AbstractServiceTest {
    
    public void testServiceRegistry() throws Exception {
        ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory());
        InjectedService service = ServiceRegistry.getService(myScope, InjectedService.class);
        assertNotNull(service);
    }

    public void testSingletonServiceFactory() {
        ServiceRegistry.registerService(myScope, InjectedService.class, SomeLanguageService.class);
        InjectedService service = ServiceRegistry.getService(myScope, InjectedService.class);
        assertNotNull(service);
        InjectedService service1 = ServiceRegistry.getService(myScope, InjectedService.class);
        assertEquals(service, service1);
    }

    public static class SomeLanguageService extends InjectedService {
    }
}
