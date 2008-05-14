
grammar InternalXtextGrammarTest;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.EObject;
}

@parser::members {

private IElementFactory factory;
public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory) {
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
	ruleGrammar {$current=$ruleGrammar.current;} EOF;


ruleGrammar returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
	lv_metamodelDeclarations=
ruleAbstractMetamodelDeclaration
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "metamodelDeclarations",lv_metamodelDeclarations);
	associateNodeWithAstElement(currentParserNode, $current);}
)*
(
	lv_parserRules=
ruleParserRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "parserRules",lv_parserRules);
	associateNodeWithAstElement(currentParserNode, $current);}
)*)
(
(
'lexing' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
':' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
(
	lv_lexerRules=
ruleLexerRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "lexerRules",lv_lexerRules);
	associateNodeWithAstElement(currentParserNode, $current);}
)+)?) { currentParserNode = currentParserNode.getParent(); };

ruleAbstractRule returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}
|
this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;}
) { currentParserNode = currentParserNode.getParent(); };

ruleAbstractMetamodelDeclaration returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}
|
this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;}
) { currentParserNode = currentParserNode.getParent(); };

ruleGeneratedMetamodel returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
'generate' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
	lv_nsURI=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"nsURI");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "nsURI",lv_nsURI);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
'as' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentParserNode, $current);}
))?) { currentParserNode = currentParserNode.getParent(); };

ruleReferencedMetamodel returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
'import' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_uri=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"uri");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "uri",lv_uri);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
'as' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentParserNode, $current);}
))?) { currentParserNode = currentParserNode.getParent(); };

ruleLexerRule returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
)
':' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
(
	lv_body=
RULE_LEXER_BODY{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"body");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "body",lv_body);
	associateNodeWithAstElement(currentParserNode, $current);}
)) { currentParserNode = currentParserNode.getParent(); };

ruleParserRule returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
(
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
)
(
'returns' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_type=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "type",lv_type);
	associateNodeWithAstElement(currentParserNode, $current);}
))?)
':' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
(
	lv_alternatives=
ruleAlternatives
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "alternatives",lv_alternatives);
	associateNodeWithAstElement(currentParserNode, $current);}
))
';' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) { currentParserNode = currentParserNode.getParent(); };

ruleTypeRef returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentParserNode, $current);}
)
'::' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})?
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
)) { currentParserNode = currentParserNode.getParent(); };

ruleAlternatives returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
this_Group=ruleGroup{$current = $this_Group.current;}

(
(
(
	{temp=factory.create("Alternatives");
	 factory.add(temp, "groups",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentParserNode, $current);}
)
'|' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})
(
	lv_groups=
ruleGroup
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "groups",lv_groups);
	associateNodeWithAstElement(currentParserNode, $current);}
))*) { currentParserNode = currentParserNode.getParent(); };

ruleGroup returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}

(
(
	{temp=factory.create("Group");
	 factory.add(temp, "abstractTokens",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentParserNode, $current);}
)
(
	lv_abstractTokens=
ruleAbstractToken
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "abstractTokens",lv_abstractTokens);
	associateNodeWithAstElement(currentParserNode, $current);}
))*) { currentParserNode = currentParserNode.getParent(); };

ruleAbstractToken returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
this_Assignment=ruleAssignment{$current = $this_Assignment.current;}
|
this_Action=ruleAction{$current = $this_Action.current;}
)|
this_AbstractTerminal=ruleAbstractTerminal{$current = $this_AbstractTerminal.current;}
)
(
	lv_cardinality=
(
(
'?' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}|
'*' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})|
'+' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.set($current, "cardinality",lv_cardinality);
	associateNodeWithAstElement(currentParserNode, $current);}
)?) { currentParserNode = currentParserNode.getParent(); };

ruleAssignment returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
	lv_feature=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentParserNode, $current);}
)
(
	lv_operator=
(
(
'+=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}|
'=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})|
'?=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
	lv_terminal=
ruleAbstractTerminal
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "terminal",lv_terminal);
	associateNodeWithAstElement(currentParserNode, $current);}
)) { currentParserNode = currentParserNode.getParent(); };

ruleAction returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
(
(
'{' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
'current' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
'=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})?)
(
	lv_typeName=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "typeName",lv_typeName);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
(
(
'.' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
(
	lv_feature=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentParserNode, $current);}
))
(
	lv_operator=
(
'=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}|
'+=' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentParserNode, $current);}
))
'current' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);})?)
'}' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) { currentParserNode = currentParserNode.getParent(); };

ruleAbstractTerminal returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
this_Keyword=ruleKeyword{$current = $this_Keyword.current;}
|
this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;}
)|
this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;}
) { currentParserNode = currentParserNode.getParent(); };

ruleParenthesizedElement returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
(
'(' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}
this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;}
)
')' {createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
null);}) { currentParserNode = currentParserNode.getParent(); };

ruleKeyword returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
	lv_value=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"value");}
 {if ($current==null) {
	$current = factory.create("Keyword");}
	factory.set($current, "value",lv_value);
	associateNodeWithAstElement(currentParserNode, $current);}
) { currentParserNode = currentParserNode.getParent(); };

ruleRuleCall returns [Object current=null] : {Object temp=null; currentParserNode=createCompositeNode(null, currentParserNode); }
	
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentParserNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("RuleCall");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentParserNode, $current);}
) { currentParserNode = currentParserNode.getParent(); };



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


