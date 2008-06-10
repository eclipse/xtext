/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;


import org.eclipse.xtext.service.examples.CircularDependencyFactory0;
import org.eclipse.xtext.service.examples.CircularDependencyFactory1;
import org.eclipse.xtext.service.examples.CircularDependencyService0;
import org.eclipse.xtext.service.examples.InheritingService;
import org.eclipse.xtext.service.examples.InheritingServiceFactory;
import org.eclipse.xtext.service.examples.InjectedLanguageService;
import org.eclipse.xtext.service.examples.InjectedLanguageServiceFactory;
import org.eclipse.xtext.service.examples.MyLanguageService;
import org.eclipse.xtext.service.examples.MyLanguageServiceFactory;
import org.eclipse.xtext.service.examples.SamplePatient;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class DependencyInjectionTest extends AbstractServiceTest {

   
    public void testIncompleteDependencies() throws Exception {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new MyLanguageServiceFactory());

        try {
            ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
            fail("Exepction expected due to unresolvable dependency");
        } catch (Exception e) {
            // normal behaviour
        }
    }
    
    public void testCompleteDependencies() {
        ServiceRegistry.registerFactory(myLanguageDescriptor, new MyLanguageServiceFactory());
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull("Dependencies are now registered, so service shouldn't be null, nor an exception should be thrown", service);
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

   public void testNonServiceInjection() throws Exception {
       ServiceRegistry.registerService(myLanguageDescriptor, new InjectedLanguageService(), InjectedLanguageService.class);
       SamplePatient samplePatient = new SamplePatient();
       ServiceRegistry.injectServices(myLanguageDescriptor, samplePatient);
   }
    
}
