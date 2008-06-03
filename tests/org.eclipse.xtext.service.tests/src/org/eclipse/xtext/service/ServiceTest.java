/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;


import junit.framework.TestCase;

import org.eclipse.xtext.service.internal.GenericSingletonLanguageServiceFactory;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ServiceTest extends TestCase {

    private ILanguageDescriptor myLanguageDescriptor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ServiceRegistry.resetInternal();
        LanguageDescriptorFactory.resetInternal();
        myLanguageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor("xx", "yy", "zz", null);
    }

    public void testServiceRegistry() throws Exception {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(service);
    }
    
    public void testServiceInjection() throws Exception {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new MyLanguageServiceFactory());
        
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNull(service);

        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
    }
    
    public void testLanguageDescriptorInjection() throws Exception {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(service.getLanguageDescriptor());
    }
    
    public void testAnnotationInheritance() {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InheritingServiceFactory());
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InheritingService service = ServiceRegistry.getService(myLanguageDescriptor, InheritingService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
    }
    
    public void testCircularDependency() throws InterruptedException {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new CircularDependencyFactory0());
        ServiceRegistry.registerFactory(myLanguageDescriptor, new CircularDependencyFactory1());
        ResolverThread thread = new ResolverThread();
        thread.start();
        thread.join(1000);
        assertNotNull(thread.service);
    }
    
    class ResolverThread extends Thread {
        volatile ILanguageService service;
        
        @Override
        public void run() {
            service = ServiceRegistry.getService(myLanguageDescriptor, CircularDependencyService0.class);
        }
    }
    
    public void testSingletonServiceFactory() {
        class SomeLanguageService extends InjectedLanguageService {};
        ILanguageService languageService = new SomeLanguageService();
        ServiceRegistry.registerService(myLanguageDescriptor, languageService, InjectedLanguageService.class);
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(languageService, service);
    }

    public void testPriority() throws Exception {
        InjectedLanguageService injectedLanguageService0 = new InjectedLanguageService();
        InjectedLanguageService injectedLanguageService1 = new InjectedLanguageService();
        GenericSingletonLanguageServiceFactory factory0 = new GenericSingletonLanguageServiceFactory(injectedLanguageService0, InjectedLanguageService.class);
        ILanguageServiceFactory factory = ServiceRegistry.registerFactory(myLanguageDescriptor, factory0);
        assertNull(factory);
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(injectedLanguageService0, service);
        GenericSingletonLanguageServiceFactory factory1 = new GenericSingletonLanguageServiceFactory(injectedLanguageService1, InjectedLanguageService.class);
        factory = ServiceRegistry.registerFactory(myLanguageDescriptor, factory1);
        assertEquals(factory0, factory);
        service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(injectedLanguageService1, service);
        factory = ServiceRegistry.registerFactory(myLanguageDescriptor, factory0, ServiceRegistry.PRIORITY_MAX);
        assertEquals(null, factory);
        service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertEquals(injectedLanguageService0, service);
    }
    
}
