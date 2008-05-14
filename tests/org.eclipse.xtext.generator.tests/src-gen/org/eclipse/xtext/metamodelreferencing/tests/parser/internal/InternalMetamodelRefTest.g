
grammar InternalMetamodelRefTest;

@lexer::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;
}

@parser::members {

private IElementFactory factory;
public InternalMetamodelRefTestParser(TokenStream input, IElementFactory factory) {
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
	ruleFoo {$current=$ruleFoo.current;} EOF;


ruleFoo returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("Foo");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
)
(
	lv_nameRefs=
ruleNameRef
 {if ($current==null) {
	$current = factory.create("Foo");}
	factory.add($current, "nameRefs",lv_nameRefs);
	associateNodeWithAstElement(currentParserNode, $current);}
)*) { currentParserNode = currentParserNode.getParent(); };

ruleNameRef returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
	lv_name=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("xtext::RuleCall");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
) { currentParserNode = currentParserNode.getParent(); };



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ANY_OTHER : .;


