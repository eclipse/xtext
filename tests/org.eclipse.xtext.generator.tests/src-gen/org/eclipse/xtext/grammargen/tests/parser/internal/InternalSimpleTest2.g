
grammar InternalSimpleTest2;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;

}

@parser::members {

private IElementFactory factory;
public InternalSimpleTest2Parser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

public CompositeNode createCompositeNode(EObject currentGrammarElement,
		CompositeNode parentNode) {
	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
	compositeNode.setGrammarElement(currentGrammarElement);
	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
	compositeNode.setGrammarElement(currentGrammarElement);
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
	
public void associateNodeWithAstElement(AbstractNode node, EObject astElement) {
	node.setElement(astElement);
	if(astElement instanceof EObject) {
		EObject eObject = (EObject) astElement;
		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
		adapter.setParserNode(node); 
	}
}
	
private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.grammargen.tests.SimpleTest2Constants.getSimpleTest2Grammar();
}

parse returns [EObject current] :
	ruleModel {$current=$ruleModel.current;} EOF {appendTrailingHiddenTokens(currentNode);};


ruleModel returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.0")
, currentNode); }
	
(
	lv_contents=
ruleChild
 {if ($current==null) {
	$current = factory.create("Model");}
	factory.add($current, "contents",lv_contents);
	associateNodeWithAstElement(currentNode, $current);
	}
)* { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleChild returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(grammar.eResource().getEObject("//@parserRules.1")
, currentNode); }
	
(
(
(
(
(
(
	lv_optional=
'optional'  {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "optional",lv_optional);
	associateNodeWithAstElement(currentNode, $current);
createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0")
, currentNode, 
"optional");}
)?
'keyword' {createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1")
, currentNode, 
null);})
(
	lv_name=
RULE_ID{createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
	lv_number=
RULE_INT{createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal")
, currentNode, 
"number");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "number",lv_number);
	associateNodeWithAstElement(currentNode, $current);
	}
))
'{' {createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1")
, currentNode, 
null);})
'}' {createLeafNode(grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1")
, currentNode, 
null);}) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };



RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ANY_OTHER : .;


