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
public class NestedServiceScopesTest extends AbstractServiceTest {

    public void testInheritance() throws Exception {
        IServiceScope subLanguage = ServiceScopeFactory.createScope("zzzzz", myScope);
        ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory());
        InjectedService subService = ServiceRegistry.getService(subLanguage, InjectedService.class);
        assertNotNull(subService);
        InjectedService superService = ServiceRegistry.getService(myScope, InjectedService.class);
        assertNotNull(superService);
        assertNotSame(subService, superService);
        InjectedService subService1 = ServiceRegistry.getService(subLanguage, InjectedService.class);
        assertEquals(subService, subService1);
        InjectedService superService1 = ServiceRegistry.getService(myScope, InjectedService.class);
        assertEquals(superService, superService1);
    }
}
