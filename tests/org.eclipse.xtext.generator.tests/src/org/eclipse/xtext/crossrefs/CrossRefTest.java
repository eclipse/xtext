package org.eclipse.xtext.crossrefs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class CrossRefTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangAStandaloneSetup.class);
	}
	
	public void testSimple() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		System.out.println(invokeWithXtend("types.collect(e|e.name+' '+e.extends.name).toString(',')", model));
		assertWithXtend("'B'", "types.first().extends.name", model);
		assertWithXtend("types.first()", "types.first().extends.extends", model);
	}
}
