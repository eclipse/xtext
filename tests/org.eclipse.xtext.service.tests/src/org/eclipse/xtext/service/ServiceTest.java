package org.eclipse.xtext.service;

import junit.framework.TestCase;

public class ServiceTest extends TestCase {

    private LanguageDescriptor myLanguageDescriptor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myLanguageDescriptor = new LanguageDescriptor("xx", "yy");
    }

    public void testServiceRegistry() throws Exception {
        ServiceRegistry.reset();
        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(service);
    }
    
    public void testServiceInjection() throws Exception {
        ServiceRegistry.reset();
        ServiceRegistry.registerFactory(myLanguageDescriptor, new MyLanguageServiceFactory());
        
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNull(service);

        ServiceRegistry.registerFactory(myLanguageDescriptor, new InjectedLanguageServiceFactory());
        service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
        assertNotNull(service.getAttr());
    }
}
