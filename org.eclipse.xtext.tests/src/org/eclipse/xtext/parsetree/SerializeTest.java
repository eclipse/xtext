package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class SerializeTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testUncompleteComment() throws Exception {
	    String model ="a /* comment *";
	    checkSerialize(model, 1);
	}
	
	@Test public void testSimple() throws Exception {
	    String model = "/* foo */ x + y * ( /* stuff */ a /* end  */\n * b)";
        int x = model.length();
		while (x>0) {
			checkSerialize(model.substring(0,x--), UNKNOWN_EXPECTATION);
		}
	}
	
	private void checkSerialize(String model, int expectedErrors) throws Exception {
		ICompositeNode node = getRootNodeAndExpect(model, expectedErrors);
		String serialize = node.getText();
		assertEquals(model, serialize);
	}
}
