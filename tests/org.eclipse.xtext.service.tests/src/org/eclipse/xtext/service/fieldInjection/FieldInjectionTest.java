package org.eclipse.xtext.service.fieldInjection;

import org.eclipse.xtext.service.AbstractServiceTest;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;

public class FieldInjectionTest extends AbstractServiceTest {
    private ILanguageDescriptor languageDescriptor;

    @Inject
    private IService privateService;
    @Inject
    protected IService protectedService;
    @Inject
    public IService publicService;

    public void testSimple() throws Exception {
        languageDescriptor = new ILanguageDescriptor() {

            public String getId() {
                return "foo";
            }

            public String getName() {
                return "Foo";
            }

            public String getNameSpace() {
                return "bar";
            }

            public ILanguageDescriptor getSuperLanguage() {
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
