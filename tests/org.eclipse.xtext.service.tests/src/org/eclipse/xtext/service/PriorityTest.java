/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.xtext.service.examples.InjectedLanguageService;
import org.eclipse.xtext.service.examples.InjectedLanguageService2;
import org.eclipse.xtext.service.examples.InjectedLanguageServiceFactory;
import org.eclipse.xtext.service.examples.InjectedLanguageServiceFactory2;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class PriorityTest extends AbstractServiceTest {

    public void testRegisterSamePriority() throws Exception {
        ILanguageServiceFactory factory0 = new InjectedLanguageServiceFactory();
        ILanguageServiceFactory factory = (ILanguageServiceFactory) ServiceRegistry.registerFactory(myLanguageDescriptor, factory0);
        assertNull(factory);
        ILanguageServiceFactory factory1 = new InjectedLanguageServiceFactory2();
        factory = (ILanguageServiceFactory) ServiceRegistry.registerFactory(myLanguageDescriptor, factory1);
        assertEquals(factory0, factory);
        ILanguageService service1 = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);        
        assertTrue(service1 instanceof InjectedLanguageService2);
    }
    
    public void testRegisterHigherPriority() throws Exception { 
        ILanguageServiceFactory factory0 = new InjectedLanguageServiceFactory();
        ILanguageServiceFactory factory = (ILanguageServiceFactory) ServiceRegistry.registerFactory(myLanguageDescriptor, factory0);
        assertNull(factory);
        ILanguageServiceFactory factory1 = new InjectedLanguageServiceFactory2();
        factory = (ILanguageServiceFactory) ServiceRegistry.registerFactory(myLanguageDescriptor, factory1);
        assertEquals(factory0, factory);        
        factory = (ILanguageServiceFactory) ServiceRegistry.registerFactory(myLanguageDescriptor, factory0, ServiceRegistry.PRIORITY_MAX);
        assertEquals(factory1, factory);
        ILanguageService service2 = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertTrue(service2 instanceof InjectedLanguageService);
        assertFalse(service2 instanceof InjectedLanguageService2);
    }
}
