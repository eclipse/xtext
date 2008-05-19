
grammar InternalDummyLanguage;

@lexer::header {
package org.eclipse.xtext.dummy.parser.internal;
}

@parser::header {
package org.eclipse.xtext.dummy.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;

}

@parser::members {

private IElementFactory factory;
public InternalDummyLanguageParser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

public CompositeNode createCompositeNode(EObject grammarElement, CompositeNode parentNode) {
	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
	compositeNode.setGrammarElement(grammarElement);
	return compositeNode;
}

public Object createLeafNode(EObject currentGrammarElement, CompositeNode parentNode, String feature) {
	Token token = input.LT(-1);
	Token tokenBefore = input.LT(-2);
	int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
	if (indexOfTokenBefore+1<token.getTokenIndex()) {
		for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
			Token hidden = input.get(x);
			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
			leafNode.setText(hidden.getText());
			leafNode.setHidden(true);
			parentNode.getChildren().add(leafNode);
		}
	}
	LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		leafNode.setText(token.getText());
	leafNode.setGrammarElement(currentGrammarElement);
	leafNode.setFeature(feature);
	parentNode.getChildren().add(leafNode);
	return leafNode;
}

private void appendTrailingHiddenTokens(CompositeNode parentNode) {
	Token tokenBefore = input.LT(-1);
	int size = input.size();
	if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
		for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
			Token hidden = input.get(x);
			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
			leafNode.setText(hidden.getText());
			leafNode.setHidden(true);
			parentNode.getChildren().add(leafNode);
		}
	}
}
	
public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
	assert node.getElement() == null || node.getElement() == astElement;
	node.setElement(astElement);
	if(astElement instanceof EObject) {
		EObject eObject = (EObject) astElement;
		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
		adapter.setParserNode(node); 
	}
}
	
private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.dummy.DummyLanguageConstants.getDummyLanguageGrammar();
}

parse returns [EObject current] : {currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@96d333 (name: Model)
grammar.eResource().getEObject("//@parserRules.0"), currentNode);}
	ruleModel {$current=$ruleModel.current;} EOF {appendTrailingHiddenTokens(currentNode);};



// Rule Model
ruleModel returns [EObject current=null] : { EObject temp=null; }
(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@97381c (cardinality: null) (name: Element)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal"), currentNode);} 
	lv_elements=ruleElement
 
{ if ($current==null) {
     $current = factory.create("Model");
  }
  factory.add($current, "elements", lv_elements);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
)* ;


// Rule Element
ruleElement returns [EObject current=null] : { EObject temp=null; }
(((((
	
	lv_optional='optional'  
{ if ($current==null) {
     $current = factory.create("Element");
  }
  factory.set($current, "optional", true);
createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@94fa66 (cardinality: null) (value: 'optional')
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"optional");  
  associateNodeWithAstElement(currentNode, $current); }
)?'element' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@cf9df7 (cardinality: null) (value: "element")
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@2a79bc (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("Element");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
))(
	
	lv_descriptions=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@4e410d (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"descriptions"); }
 
{ if ($current==null) {
     $current = factory.create("Element");
  }
  factory.add($current, "descriptions", lv_descriptions);
  
  associateNodeWithAstElement(currentNode, $current); }
)*)';' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f06b1b (cardinality: null) (value: ';')
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1"), currentNode,null); }) ;



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


