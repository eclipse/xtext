package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class HiddenTokensTest extends AbstractGeneratorTest {

	public void testWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}

	
	public void testWhitespaceIsIncluded2() throws Exception {
		String model = "element foo;\nelement bar;/* foo bar */ element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
	public void testTrailingWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;  /* holla */ \n// stuff\n";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
	public void testPrecedingWhitespaceIsIncluded() throws Exception {
		String model = "//honolulu\n\t element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		assertEquals(node.serialize(),model);
	}
	
	private AbstractNode getRootNode(String model) throws Exception {
		EObject object = (EObject) parse(model,new DummyLanguageASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		return node;
	}
	@Override
	protected Class<?> getTheClass() {
		return DummyLanguage.class;
	}
}
