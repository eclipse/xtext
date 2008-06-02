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
    }
    
    public void testCompoundFactory() throws Exception {
        ServiceRegistry.registerFactory(new CompoundLanguageServiceFactory());
        
        MyLanguageService service = ServiceRegistry.getService(myLanguageDescriptor, MyLanguageService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
    }
    
    public void testAnnotationInheritance() {
        ServiceRegistry.registerFactory(new InheritingServiceFactory());
        ServiceRegistry.registerFactory(new InjectedLanguageServiceFactory());
        InheritingService service = ServiceRegistry.getService(myLanguageDescriptor, InheritingService.class);
        assertNotNull(service);
        assertNotNull(service.getInjectedService());
    }
    
    public void testCircularDependency() throws InterruptedException {
        ServiceRegistry.registerFactory(new CircularDependencyFactory0());
        ServiceRegistry.registerFactory(new CircularDependencyFactory1());
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
