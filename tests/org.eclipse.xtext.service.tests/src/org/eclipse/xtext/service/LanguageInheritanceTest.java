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
public class LanguageInheritanceTest extends AbstractServiceTest {

    public void testInheritance() throws Exception {
        ILanguageDescriptor subLanguage = LanguageDescriptorFactory.createLanguageDescriptor("zzzzz", "StupidName", "", myLanguageDescriptor);
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InjectedLanguageService subService = ServiceRegistry.getService(subLanguage, InjectedLanguageService.class);
        assertNotNull(subService);
        InjectedLanguageService superService = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(superService);
        assertNotSame(subService, superService);
        InjectedLanguageService subService1 = ServiceRegistry.getService(subLanguage, InjectedLanguageService.class);
        assertEquals(subService, subService1);
        InjectedLanguageService superService1 = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(superService, superService1);
    }
}
