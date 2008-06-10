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
import org.eclipse.xtext.service.examples.InjectedLanguageServiceFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class RegistrationTest extends AbstractServiceTest {
    
    public void testServiceRegistry() throws Exception {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(service);
    }

    public void testSingletonServiceFactory() {
        class SomeLanguageService extends InjectedLanguageService {
        }
        ;
        ILanguageService languageService = new SomeLanguageService();
        ServiceRegistry.registerService(myLanguageDescriptor, languageService, InjectedLanguageService.class);
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(languageService, service);
        service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(languageService, service);
    }
}
