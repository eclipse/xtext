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
import org.eclipse.xtext.service.examples.InjectedService;
import org.eclipse.xtext.service.examples.InjectedServiceFactory;
import org.eclipse.xtext.service.examples.MyService;
import org.eclipse.xtext.service.examples.MyServiceFactory;
import org.eclipse.xtext.service.examples.SamplePatient;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class DependencyInjectionTest extends AbstractServiceTest {

   
    public void testIncompleteDependencies() throws Exception {
        ServiceRegistry.registerFactory(myScope, new MyServiceFactory());

        try {
            ServiceRegistry.getService(myScope, MyService.class);
            fail("Exepction expected due to unresolvable dependency");
        } catch (Exception e) {
            // normal behaviour
        }
    }
    
    public void testCompleteDependencies() {
        ServiceRegistry.registerFactory(myScope, new MyServiceFactory());
        ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory());
        MyService service = ServiceRegistry.getService(myScope, MyService.class);
        assertNotNull("Dependencies are now registered, so service shouldn't be null, nor an exception should be thrown", service);
        assertNotNull(service.getInjectedService());
    }

    public void testLanguageDescriptorInjection() throws Exception {
        ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory());
        InjectedService service = ServiceRegistry.getService(myScope, InjectedService.class);
        assertNotNull(service.scope);
    }

    public void testAnnotationInheritance() {
        ServiceRegistry.registerFactory(myScope, new InheritingServiceFactory());
        ServiceRegistry.registerFactory(myScope, new InjectedServiceFactory());
        InheritingService service = ServiceRegistry.getService(myScope, InheritingService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
    }

    public void testCircularDependency() throws InterruptedException {
        ServiceRegistry.registerFactory(myScope, new CircularDependencyFactory0());
        ServiceRegistry.registerFactory(myScope, new CircularDependencyFactory1());
        ResolverThread thread = new ResolverThread();
        thread.start();
        thread.join(1000);
        assertNotNull(thread.service);
    }

    class ResolverThread extends Thread {
        volatile Object service;

        @Override
        public void run() {
            service = ServiceRegistry.getService(myScope, CircularDependencyService0.class);
        }
    }

   public void testNonServiceInjection() throws Exception {
       ServiceRegistry.registerService(myScope, InjectedService.class, InjectedService.class);
       SamplePatient samplePatient = new SamplePatient();
       ServiceRegistry.injectServices(myScope, samplePatient);
   }
    
}
