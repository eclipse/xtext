package org.eclipse.xtext.service.fieldInjection;

import org.eclipse.xtext.service.AbstractServiceTest;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;

public class FieldInjectionTest extends AbstractServiceTest {
    private IServiceScope languageDescriptor;

    @Inject
    private IService privateService;
    @Inject
    protected IService protectedService;
    @Inject
    public IService publicService;

    public void testSimple() throws Exception {
        languageDescriptor = new IServiceScope() {

            public String getId() {
                return "foo";
            }

            public IServiceScope getParentScope() {
                return null;
            }
        };
        ServiceRegistry.registerFactory(languageDescriptor, new ServiceFactory());
        assertNull(privateService);
        assertNull(protectedService);
        assertNull(publicService);
        ServiceRegistry.injectServices(languageDescriptor, this);
        assertNotNull(privateService);
        assertNotNull(protectedService);
        assertNotNull(publicService);
    }
}
