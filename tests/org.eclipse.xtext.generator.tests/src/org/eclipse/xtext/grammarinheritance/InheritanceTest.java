package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class InheritanceTest extends AbstractGeneratorTest {
	static {
		ServiceRegistry.registerService(IAbstractTestLanguage.SCOPE,
				IValueConverterService.class, AbstractTestLanguageValueConverters.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ConcreteTestLanguageStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
		EObject model = getModel("model 23.34 : element A element B");
		assertEquals(23.34, invokeWithXtend("magicNumber", model));
		assertWithXtend("'A'", "elements.get(0).name", model);
		assertWithXtend("'B'", "elements.get(1).name", model);
	}
}
