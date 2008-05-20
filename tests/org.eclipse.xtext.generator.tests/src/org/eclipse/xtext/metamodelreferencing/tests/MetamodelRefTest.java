package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;

public class MetamodelRefTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextPackage.eINSTANCE.getRuleCall(); // register Xtext EPackage
	}
	
	public void testStuff() throws Exception {
		Object parse = getModel("foo 'bar'");
		assertWithXtend("'SimpleTest::Foo'","metaType.name",parse);
		assertWithXtend("'xtext::RuleCall'","nameRefs.first().metaType.name",parse);
	}
	
}
