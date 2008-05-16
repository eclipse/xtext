package org.eclipse.xtext.parsetree;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;

public class NodeModelTest extends AbstractGeneratorTest {

	public void testNavigabilityAst2Node() throws Exception {
		String model = "element foo 'dummdidumm'; optional element bar;";
		EObject object = (EObject) parse(model,new DummyLanguageASTFactory());
		checkNavigabilityAst2Node(object);
		for(Iterator<EObject> i = object.eAllContents(); i.hasNext();) {
			checkNavigabilityAst2Node(i.next());
		}
	}

	public void testNavigabilityNode2Ast() throws Exception {
		String model = "element foo 'dummdidumm'; optional element bar;";
		EObject object = (EObject) parse(model,new DummyLanguageASTFactory());
		EList<Adapter> adapters = object.eAdapters();
		assert(adapters.size()==1);
		NodeAdapter adapter = (NodeAdapter) adapters.get(0);
		CompositeNode rootNode = adapter.getParserNode();
		assertTrue(rootNode.eContainer() == null);
		checkNavigabilityNode2Ast(rootNode);
		for(Iterator<EObject> i = rootNode.eAllContents(); i.hasNext();) {
			checkNavigabilityNode2Ast((AbstractNode) i.next());
		}
	}
	
	public void testGrammarElement() throws Exception {
		AbstractNode rootNode = getRootNode("element foo 'dummdidumm'; optional element bar;");
		EObject rootGrammarElement = rootNode.getGrammarElement();
		assertTrue(rootGrammarElement instanceof ParserRule);
		for (Iterator<EObject> i = rootNode.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof CompositeNode) {
				CompositeNode compositeNode = (CompositeNode) next;
				EObject grammarElement = compositeNode.getGrammarElement();
				assertTrue(isParserRuleCall(grammarElement));
			} else if (next instanceof LeafNode) {
				LeafNode leafNode = (LeafNode) next;
				EObject grammarElement = leafNode.getGrammarElement();
				assertTrue(grammarElement == null // Whitespace
						|| grammarElement instanceof Keyword // Keyword
						|| isLexerRuleCall(grammarElement));	
			}
		}
	}

	private void checkNavigabilityAst2Node(EObject object) {
		EList<Adapter> adapters = object.eAdapters();
		assertEquals(1, adapters.size());
		NodeAdapter adapter = (NodeAdapter) adapters.get(0);
		AbstractNode parsetreeNode = adapter.getParserNode();
		assertEquals(object, parsetreeNode.getElement());
	}
	
	private void checkNavigabilityNode2Ast(AbstractNode node) {
		EObject astElement = node.getElement();
		if(astElement != null) {
			EList<Adapter> adapters = astElement.eAdapters();
			assertEquals(1, adapters.size());
			NodeAdapter adapter = (NodeAdapter) adapters.get(0);
			assertEquals(node,adapter.getParserNode());
		}
		else {
			assert(node.getGrammarElement() == null || node.getGrammarElement() instanceof Keyword || isLexerRuleCall(node.getGrammarElement()));
		}
	}
	
	public void testTokenTexts() throws Exception {
		Pattern whitespacePattern = Pattern.compile("\\s*");
		String model = "element foo 'dummdidumm' ; optional element bar ;";
		String[] tokenTexts = model.split(" ");
		int tokenIndex = 0;
		AbstractNode rootNode = getRootNode(model);
		for(Iterator<EObject> i = rootNode.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof LeafNode) {
				LeafNode leafNode = (LeafNode) next;
				String tokenText = leafNode.getText();
				if(!whitespacePattern.matcher(tokenText).matches()) {
					assertEquals(tokenTexts[tokenIndex++], tokenText);
				}
			}
		}
	}
	
	private boolean isLexerRuleCall(EObject element) {
		return element instanceof RuleCall && ! isParserRuleCall(element);
	}
	
	private boolean isParserRuleCall(EObject element) {
		if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			Grammar g = (Grammar) ruleCall.eResource().getContents().get(0);
			for(ParserRule p : g.getParserRules()) {
				if(ruleCall.getName().equals(p.getName())) {
					return true;
				}
			}			
		}
		return false;
	}
	
	private AbstractNode getRootNode(String model) throws Exception {
		EObject object = (EObject) parse(model, new DummyLanguageASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		return node;
	}

	@Override
	protected Class<?> getTheClass() {
		return DummyLanguage.class;
	}

	
}
