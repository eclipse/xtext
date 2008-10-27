package org.eclipse.xtext.valueconverter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class Bug250313 extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Bug250313StandaloneSetup.doSetup();
		with(Bug250313StandaloneSetup.class);
	}
	public void testCheckValueConversion() throws Exception {
		//TODO fix bug 250131
//		EObject model = getModel("#2 'str'");
//		assertWithXtend("'str'", "this.ref2", model);
	}
}
