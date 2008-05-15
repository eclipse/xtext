package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class HiddenTokensTest extends AbstractGeneratorTest {

	public void testWhitespaceIsIncluded() throws Exception {
		String model = "generate foo 'bar'\nFoo : name=ID (bars+=Bar)*;\nBar : x=STRING;";
		EObject object = (EObject) parse(model,new XtextGrammarTestASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		assertEquals(node.serialize(),model);
	}
	
	public void testWhitespaceIsIncluded2() throws Exception {
		String model = "generate foo /* foo bar */ 'bar'\n\t\t   //Foo : name=ID (bars+=Bar)*;\nBar : x=STRING;";
		EObject object = (EObject) parse(model,new XtextGrammarTestASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		assertEquals(node.serialize(),model);
	}
	
	@Override
	protected Class<?> getTheClass() {
		return XtextGrammarTest.class;
	}
}
