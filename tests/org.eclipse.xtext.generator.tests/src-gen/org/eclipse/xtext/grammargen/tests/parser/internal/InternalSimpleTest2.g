
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
	parentNode.getChildren().add(compositeNode);
	return compositeNode;
}

	public Object createLeafNode(EObject currentGrammarElement,
		CompositeNode parentNode, String feature) {
		Token token = input.LT(-1);
		Token tokenBefore = input.LT(-2);
		int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : 0;
		if (indexOfTokenBefore+1<token.getTokenIndex()) {
			for (int x = token.getTokenIndex()-1; x>indexOfTokenBefore;x--) {
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
	
public void associateNodeWithAstElement(AbstractNode node, Object astElement) {
	node.setElement(astElement);
	if(astElement instanceof EObject) {
		EObject eObject = (EObject) astElement;
		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
		adapter.setParserNode(node); 
	}
}
	
private CompositeNode currentNode;
private CompositeNode rootNode;

public CompositeNode getRootNode() {
	return rootNode;
}

}

parse returns [EObject current] :
	{ rootNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); 
	currentNode = rootNode; }
	ruleModel {$current=$ruleModel.current;} EOF;


ruleModel returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_contents=
ruleChild
 {if ($current==null) {
	$current = factory.create("Model");}
	factory.add($current, "contents",lv_contents);
	associateNodeWithAstElement(currentNode, $current);}
)* { currentNode = currentNode.getParent(); };

ruleChild returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
(
(
(
	lv_optional=
'optional' {createLeafNode(null, currentNode, 
null);} {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "optional",lv_optional);
	associateNodeWithAstElement(currentNode, $current);}
)?
'keyword' {createLeafNode(null, currentNode, 
null);})
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
))
(
	lv_number=
RULE_INT{createLeafNode(null, currentNode, 
"number");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "number",lv_number);
	associateNodeWithAstElement(currentNode, $current);}
))
'{' {createLeafNode(null, currentNode, 
null);})
'}' {createLeafNode(null, currentNode, 
null);}) { currentNode = currentNode.getParent(); };



RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_ANY_OTHER : .;


