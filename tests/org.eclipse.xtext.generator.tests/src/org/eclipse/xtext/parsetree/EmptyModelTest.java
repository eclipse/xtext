package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.testlanguages.OptionalEmptyLanguage;

public class EmptyModelTest extends AbstractGeneratorTest {
	
	public void testParseEmpty() throws Exception {
		EObject model = getModel("");
		assertNull(model);
		model = getModel("hallo welt");
		assertWithXtend("'welt'", "child.name", model);
	}
	
	@Override
	protected Class<?> getTheClass() {
		return OptionalEmptyLanguage.class;
	}
}
