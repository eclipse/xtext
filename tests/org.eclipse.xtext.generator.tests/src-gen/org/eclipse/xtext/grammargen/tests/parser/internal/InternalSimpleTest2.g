
grammar InternalSimpleTest2;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;
}

@parser::members {

private IElementFactory factory;
public InternalSimpleTest2Parser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

private CompositeNode currentParserNode;

	public CompositeNode createCompositeNode(EObject currentGrammarElement,
			CompositeNode parentNode) {
		CompositeNode compositeNode = ParsetreeFactory.eINSTANCE
				.createCompositeNode();
		compositeNode.setGrammarElement(currentGrammarElement);
		parentNode.getChildren().add(compositeNode);
		return compositeNode;
	}

	public Object createLeafNode(String text, EObject currentGrammarElement,
			CompositeNode parentNode, String feature) {
		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		leafNode.setText(text);
		leafNode.setGrammarElement(currentGrammarElement);
		leafNode.setFeature(feature);
		parentNode.getChildren().add(leafNode);
		return leafNode;
	}
	
	public void associateNodeWithAstElement(AbstractParserNode node, Object astElement) {
		node.setElement(astElement);
		if(astElement instanceof EObject) {
			EObject eObject = (EObject) astElement;
			ParserNodeAdapter adapter = (org.eclipse.xtext.parsetree.ParserNodeAdapter) 
				org.eclipse.xtext.parsetree.ParserNodeAdapterFactory.INSTANCE.adapt(eObject, 
					org.eclipse.xtext.parsetree.AbstractParserNode.class);
			adapter.setParserNode(node); 
		}
	}

}

parse returns [Object current] :
	{ currentParserNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); }
	ruleModel {$current=$ruleModel.current;} EOF;


ruleModel returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
	lv_contents=
ruleChild
 {if ($current==null) {
	$current = factory.create("Model");}
	factory.add($current, "contents",lv_contents);
	associateNodeWithAstElement(currentParserNode, $current);}
)* { currentParserNode = currentParserNode.getParent(); };

ruleChild returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
(
(
(
	lv_optional=
'optional' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);} {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "optional",lv_optional);
	associateNodeWithAstElement(currentParserNode, $current);}
)?
'keyword' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
	lv_number=
RULE_INT{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"number");}
 {if ($current==null) {
	$current = factory.create("Child");}
	factory.set($current, "number",lv_number);
	associateNodeWithAstElement(currentParserNode, $current);}
))
'{' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
'}' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) { currentParserNode = currentParserNode.getParent(); };



RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


