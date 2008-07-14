package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class SerializeTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsStandaloneSetup.class);
	}
	
	public void testUncompleteComment() throws Exception {
	    String model ="a /* comment *";
	    checkSerialize(model);
	}
	
	public void testSimple() throws Exception {
	    String model = "/* foo */ x + y * ( /* stuff */ a /* end  */\n * b)";
        int x = model.length();
		while (x>0) {
			checkSerialize(model.substring(0,x--));
		}
	}
	
	private void checkSerialize(String model) throws Exception {
		CompositeNode node = getRootNode(model);
		String serialize = node.serialize();
		assertEquals(model, serialize);
	}
}
