
grammar InternalXtextGrammarTest;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
}

@parser::members {

private IElementFactory factory;
public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

private CompositeNode currentNode;

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
	
	public void associateNodeWithAstElement(AbstractNode node, Object astElement) {
		node.setElement(astElement);
		if(astElement instanceof EObject) {
			EObject eObject = (EObject) astElement;
			NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
			adapter.setParserNode(node); 
		}
	}

}

parse returns [Object current] :
	{ currentNode = ParsetreeFactory.eINSTANCE.createCompositeNode(); }
	ruleGrammar {$current=$ruleGrammar.current;} EOF;


ruleGrammar returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_metamodelDeclarations=
ruleAbstractMetamodelDeclaration
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "metamodelDeclarations",lv_metamodelDeclarations);
	associateNodeWithAstElement(currentNode, $current);}
)*
(
	lv_parserRules=
ruleParserRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "parserRules",lv_parserRules);
	associateNodeWithAstElement(currentNode, $current);}
)*)
(
(
'lexing' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
':' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})
(
	lv_lexerRules=
ruleLexerRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "lexerRules",lv_lexerRules);
	associateNodeWithAstElement(currentNode, $current);}
)+)?) { currentNode = currentNode.getParent(); };

ruleAbstractRule returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}
|
this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;}
) { currentNode = currentNode.getParent(); };

ruleAbstractMetamodelDeclaration returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}
|
this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;}
) { currentNode = currentNode.getParent(); };

ruleGeneratedMetamodel returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
'generate' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
))
(
	lv_nsURI=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"nsURI");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "nsURI",lv_nsURI);
	associateNodeWithAstElement(currentNode, $current);}
))
(
'as' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);}
))?) { currentNode = currentNode.getParent(); };

ruleReferencedMetamodel returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
'import' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_uri=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"uri");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "uri",lv_uri);
	associateNodeWithAstElement(currentNode, $current);}
))
(
'as' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);}
))?) { currentNode = currentNode.getParent(); };

ruleLexerRule returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
)
':' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})
(
	lv_body=
RULE_LEXER_BODY{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"body");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "body",lv_body);
	associateNodeWithAstElement(currentNode, $current);}
)) { currentNode = currentNode.getParent(); };

ruleParserRule returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
(
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
)
(
'returns' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_type=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "type",lv_type);
	associateNodeWithAstElement(currentNode, $current);}
))?)
':' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})
(
	lv_alternatives=
ruleAlternatives
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "alternatives",lv_alternatives);
	associateNodeWithAstElement(currentNode, $current);}
))
';' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) { currentNode = currentNode.getParent(); };

ruleTypeRef returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_alias=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);}
)
'::' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})?
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
)) { currentNode = currentNode.getParent(); };

ruleAlternatives returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_Group=ruleGroup{$current = $this_Group.current;}

(
(
(
	{temp=factory.create("Alternatives");
	 factory.add(temp, "groups",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentNode, $current);}
)
'|' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})
(
	lv_groups=
ruleGroup
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "groups",lv_groups);
	associateNodeWithAstElement(currentNode, $current);}
))*) { currentNode = currentNode.getParent(); };

ruleGroup returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}

(
(
	{temp=factory.create("Group");
	 factory.add(temp, "abstractTokens",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentNode, $current);}
)
(
	lv_abstractTokens=
ruleAbstractToken
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "abstractTokens",lv_abstractTokens);
	associateNodeWithAstElement(currentNode, $current);}
))*) { currentNode = currentNode.getParent(); };

ruleAbstractToken returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
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
'?' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}|
'*' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})|
'+' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.set($current, "cardinality",lv_cardinality);
	associateNodeWithAstElement(currentNode, $current);}
)?) { currentNode = currentNode.getParent(); };

ruleAssignment returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_feature=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentNode, $current);}
)
(
	lv_operator=
(
(
'+=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}|
'=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})|
'?=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentNode, $current);}
))
(
	lv_terminal=
ruleAbstractTerminal
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "terminal",lv_terminal);
	associateNodeWithAstElement(currentNode, $current);}
)) { currentNode = currentNode.getParent(); };

ruleAction returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
(
'{' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
'current' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
'=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})?)
(
	lv_typeName=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "typeName",lv_typeName);
	associateNodeWithAstElement(currentNode, $current);}
))
(
(
(
'.' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
(
	lv_feature=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentNode, $current);}
))
(
	lv_operator=
(
'=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}|
'+=' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentNode, $current);}
))
'current' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);})?)
'}' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) { currentNode = currentNode.getParent(); };

ruleAbstractTerminal returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
this_Keyword=ruleKeyword{$current = $this_Keyword.current;}
|
this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;}
)|
this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;}
) { currentNode = currentNode.getParent(); };

ruleParenthesizedElement returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
'(' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}
this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;}
)
')' {createLeafNode(input.LT(-1).getText(), null, currentNode, 
null);}) { currentNode = currentNode.getParent(); };

ruleKeyword returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_value=
RULE_STRING{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"value");}
 {if ($current==null) {
	$current = factory.create("Keyword");}
	factory.set($current, "value",lv_value);
	associateNodeWithAstElement(currentNode, $current);}
) { currentNode = currentNode.getParent(); };

ruleRuleCall returns [Object current=null] : {Object temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_name=
RULE_ID{createLeafNode(input.LT(-1).getText(), null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("RuleCall");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);}
) { currentNode = currentNode.getParent(); };



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_ANY_OTHER : .;


