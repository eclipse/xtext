package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

public class EnumAndReferenceTest extends AbstractXtextTests {

	private ParserTestHelper helper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EnumAndReferenceTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY));
	}
	
	@Override
	protected void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}
	
	public void testSemantic() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals("Hoo", model.getName());
		assertNotNull(model.getRef());
		assertEquals(model, model.getRef());
	}
	
	public void testNodes() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(model);
		
		CompositeNode node = nodeAdapter.getParserNode();
		assertNotNull(node);
		//System.out.println(node.getChildren().size());
		AbstractNode firstChild = node.getChildren().get(0);
		//System.out.println(firstChild);
		assertTrue(node.getChildren().size() > 1);
	}
	
}
