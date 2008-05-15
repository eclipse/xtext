package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class HiddenTokensTest extends AbstractGeneratorTest {

	public void testWhitespaceIsIncluded() throws Exception {
		EObject object = (EObject) parse("generate foo 'bar'\nFoo : name=ID (bars+=Bar)*;\nBar : x=STRING;",new XtextGrammarTestASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		assertNotNull(node);
	}
	
	@Override
	protected Class<?> getTheClass() {
		return XtextGrammarTest.class;
	}
}
