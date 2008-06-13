package org.eclipse.xtext.service.fieldInjection;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;

import junit.framework.TestCase;

public class FieldInjectionTest extends TestCase {
	private ServiceRegistry serviceRegistry;
	private ILanguageDescriptor languageDescriptor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		serviceRegistry = new ServiceRegistry();
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
			}};
		serviceRegistry.registerFactory(languageDescriptor, new ServiceFactory());
	}
	
	@Inject
	private IService privateService;
	@Inject
	protected IService protectedService;
	@Inject
	public IService publicService;
	
	public void testSimple() throws Exception {
		assertNull(privateService);
		assertNull(protectedService);
		assertNull(publicService);
		serviceRegistry.injectServices(languageDescriptor, this);
		assertNotNull(privateService);
		assertNotNull(protectedService);
		assertNotNull(publicService);
	}
}
