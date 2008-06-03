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
}
