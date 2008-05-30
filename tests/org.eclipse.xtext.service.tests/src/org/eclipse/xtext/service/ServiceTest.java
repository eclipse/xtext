package org.eclipse.xtext.service;


import junit.framework.TestCase;

public class ServiceTest extends TestCase {

    private ILanguageDescriptor myLanguageDescriptor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ServiceRegistry.resetInternal();
        LanguageDescriptorFactory.resetInternal();
        myLanguageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor("xx", "yy", "zz");
    }

    public void testServiceRegistry() throws Exception {
        ServiceRegistry.registerFactory(new InjectedLanguageServiceFactory());
        InjectedLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, InjectedLanguageService.class);
        assertNotNull(service);
    }
    
    public void testServiceInjection() throws Exception {
        ServiceRegistry.registerFactory(new MyLanguageServiceFactory());
        
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNull(service);

        ServiceRegistry.registerFactory(new InjectedLanguageServiceFactory());
        service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
        assertNotNull(service.getAttr());
    }
    
    public void testCompoundFactory() throws Exception {
        ServiceRegistry.registerFactory(new CompoundLanguageServiceFactory());
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
        assertNotNull(service.getAttr());
    }
}
