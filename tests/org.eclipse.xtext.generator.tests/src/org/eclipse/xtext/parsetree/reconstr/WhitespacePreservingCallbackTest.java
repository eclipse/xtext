package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class WhitespacePreservingCallbackTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ComplexReconstrTestStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
		check("a");
	}

	public void testHiddenInBetween() throws Exception {
		check("a \t /* foo bar */ + b");
	}

	private void check(String m1) throws Exception {
		assertEquals(m1, parseAndSerialize(m1));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = (EObject) getModel(model);
		IParseTreeConstructor con = getParseTreeConstructor();
		WhitespacePreservingCallback cb = new WhitespacePreservingCallback(getValueConverterService());
		con.update(result, cb);
		return cb.toString();
	}
}
