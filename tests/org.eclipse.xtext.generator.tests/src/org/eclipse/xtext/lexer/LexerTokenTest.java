package org.eclipse.xtext.lexer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.BuiltinRules;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.core.parser.ITokenTypes;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.lexer.parser.LexerLanguageASTFactory;

public class LexerTokenTest extends AbstractGeneratorTest {

	public void testLexerTokens() throws Exception {
		AbstractNode rootNode = getRootNode("xyz A CCC BB");
		EList<LeafNode> leafNodes = rootNode.getLeafNodes();
		assertTrue(GrammarUtil.isLexerRuleCall(leafNodes.get(0).getGrammarElement()));
		assertEquals(BuiltinRules.BUILTIN_ID, GrammarUtil.calledRule((RuleCall) leafNodes.get(0).getGrammarElement()));
		assertEquals(ITokenTypes.IDENTIFIER, leafNodes.get(0).tokenType());
		checkIsWhitespace(leafNodes.get(1));
		checkIsDefinedRule(leafNodes.get(2), "EXPLICITTOKENTYPE", LexerLanguageTokenTypes.X);
		checkIsWhitespace(leafNodes.get(3));
		checkIsDefinedRule(leafNodes.get(4), "IMPLICITTOKENTYPE", LexerLanguageTokenTypes.IMPLICITTOKENTYPE);
		checkIsWhitespace(leafNodes.get(5));
		checkIsDefinedRule(leafNodes.get(6), "STRING", LexerLanguageTokenTypes.STRING);
		
	}
	
	private void checkIsDefinedRule(LeafNode leafNode, String ruleName, String tokenType) {
		assertTrue(GrammarUtil.isLexerRuleCall(leafNode.getGrammarElement()));
		AbstractRule calledRule = GrammarUtil.calledRule((RuleCall) leafNode.getGrammarElement());
		assertFalse(BuiltinRules.getBuiltinLexerRules().contains(calledRule));
		assertEquals(ruleName, calledRule.getName());
		assertEquals(tokenType, leafNode.tokenType());
	}
	
	private void checkIsWhitespace(LeafNode leafNode) {
		assertEquals(BuiltinRules.BUILTIN_WS, leafNode.getGrammarElement());
		assertEquals(ITokenTypes.WHITESPACE, leafNode.tokenType());
	}
	
	private EObject getRootAstElement(String model) throws Exception {
		EObject object = (EObject) parse(model, new LexerLanguageASTFactory());
		return object;
	}
	
	private AbstractNode getRootNode(String model) throws Exception {
		EObject object = getRootAstElement(model);
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		return node;
	}

	@Override
	protected Class<?> getTheClass() {
		return LexerLanguage.class;
	}
}
