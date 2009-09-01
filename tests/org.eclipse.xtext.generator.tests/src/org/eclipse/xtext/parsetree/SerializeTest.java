package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class SerializeTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	public void testUncompleteComment() throws Exception {
	    String model ="a /* comment *";
	    checkSerialize(model, 1);
	}
	
	public void testSimple() throws Exception {
	    String model = "/* foo */ x + y * ( /* stuff */ a /* end  */\n * b)";
        int x = model.length();
		while (x>0) {
			checkSerialize(model.substring(0,x--), UNKNOWN_EXPECTATION);
		}
	}
	
	private void checkSerialize(String model, int expectedErrors) throws Exception {
		CompositeNode node = getRootNodeAndExpect(model, expectedErrors);
		String serialize = node.serialize();
		assertEquals(model, serialize);
	}
}
