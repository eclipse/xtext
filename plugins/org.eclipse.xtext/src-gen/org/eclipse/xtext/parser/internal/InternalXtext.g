
grammar InternalXtext;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
}

@parser::members {
private IElementFactory factory;
public InternalXtextParser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

}

parse returns [Object current] :
	ruleGrammar {$current=$ruleGrammar.current;} EOF;


ruleGrammar returns [Object current=null] : {Object temp=null;}
	
(
(
(
	lv_metamodelDeclarations=
ruleAbstractMetamodelDeclaration {if ($current==null) {$current = factory.create("Grammar");}factory.add($current, "metamodelDeclarations",lv_metamodelDeclarations);}
)*
(
	lv_parserRules=
ruleParserRule {if ($current==null) {$current = factory.create("Grammar");}factory.add($current, "parserRules",lv_parserRules);}
)*)
(
(
'lexing'
':')
(
	lv_lexerRules=
ruleLexerRule {if ($current==null) {$current = factory.create("Grammar");}factory.add($current, "lexerRules",lv_lexerRules);}
)+)?);

ruleAbstractRule returns [Object current=null] : {Object temp=null;}
	
(
this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}|
this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;});

ruleAbstractMetamodelDeclaration returns [Object current=null] : {Object temp=null;}
	
(
this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}|
this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;});

ruleGeneratedMetamodel returns [Object current=null] : {Object temp=null;}
	
(
(
(
'generate'
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("GeneratedMetamodel");}factory.set($current, "name",lv_name);}
))
(
	lv_nsURI=
RULE_STRING {if ($current==null) {$current = factory.create("GeneratedMetamodel");}factory.set($current, "nsURI",lv_nsURI);}
))
(
'as'
(
	lv_alias=
RULE_ID {if ($current==null) {$current = factory.create("GeneratedMetamodel");}factory.set($current, "alias",lv_alias);}
))?);

ruleReferencedMetamodel returns [Object current=null] : {Object temp=null;}
	
(
(
'import'
(
	lv_uri=
RULE_STRING {if ($current==null) {$current = factory.create("ReferencedMetamodel");}factory.set($current, "uri",lv_uri);}
))
(
'as'
(
	lv_alias=
RULE_ID {if ($current==null) {$current = factory.create("ReferencedMetamodel");}factory.set($current, "alias",lv_alias);}
))?);

ruleLexerRule returns [Object current=null] : {Object temp=null;}
	
(
(
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("LexerRule");}factory.set($current, "name",lv_name);}
)
':')
(
	lv_body=
RULE_LEXER_BODY {if ($current==null) {$current = factory.create("LexerRule");}factory.set($current, "body",lv_body);}
));

ruleParserRule returns [Object current=null] : {Object temp=null;}
	
(
(
(
(
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("ParserRule");}factory.set($current, "name",lv_name);}
)
(
'returns'
(
	lv_type=
ruleTypeRef {if ($current==null) {$current = factory.create("ParserRule");}factory.set($current, "type",lv_type);}
))?)
':')
(
	lv_alternatives=
ruleAlternatives {if ($current==null) {$current = factory.create("ParserRule");}factory.set($current, "alternatives",lv_alternatives);}
))
';');

ruleTypeRef returns [Object current=null] : {Object temp=null;}
	
(
(
(
	lv_alias=
RULE_ID {if ($current==null) {$current = factory.create("TypeRef");}factory.set($current, "alias",lv_alias);}
)
'::')?
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("TypeRef");}factory.set($current, "name",lv_name);}
));

ruleAlternatives returns [Object current=null] : {Object temp=null;}
	
(
this_Group=ruleGroup{$current = $this_Group.current;}
(
(
(
	{temp=factory.create("Alternatives");
	 factory.add(temp, "groups",$current);
	 $current = temp; temp = null;}
)
'|')
(
	lv_groups=
ruleGroup {if ($current==null) {$current = factory.create("AbstractElement");}factory.add($current, "groups",lv_groups);}
))*);

ruleGroup returns [Object current=null] : {Object temp=null;}
	
(
this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}
(
(
	{temp=factory.create("Group");
	 factory.add(temp, "abstractTokens",$current);
	 $current = temp; temp = null;}
)
(
	lv_abstractTokens=
ruleAbstractToken {if ($current==null) {$current = factory.create("AbstractElement");}factory.add($current, "abstractTokens",lv_abstractTokens);}
))*);

ruleAbstractToken returns [Object current=null] : {Object temp=null;}
	
(
(
(
this_Assignment=ruleAssignment{$current = $this_Assignment.current;}|
this_Action=ruleAction{$current = $this_Action.current;})|
this_AbstractTerminal=ruleAbstractTerminal{$current = $this_AbstractTerminal.current;})
(
	lv_cardinality=
(
(
'?'|
'*')|
'+') {if ($current==null) {$current = factory.create("AbstractElement");}factory.set($current, "cardinality",lv_cardinality);}
)?);

ruleAssignment returns [Object current=null] : {Object temp=null;}
	
(
(
(
	lv_feature=
RULE_ID {if ($current==null) {$current = factory.create("Assignment");}factory.set($current, "feature",lv_feature);}
)
(
	lv_operator=
(
(
'+='|
'=')|
'?=') {if ($current==null) {$current = factory.create("Assignment");}factory.set($current, "operator",lv_operator);}
))
(
	lv_terminal=
ruleAbstractTerminal {if ($current==null) {$current = factory.create("Assignment");}factory.set($current, "terminal",lv_terminal);}
));

ruleAction returns [Object current=null] : {Object temp=null;}
	
(
(
(
(
(
(
(
'{'
(
'current'
'=')?)
(
	lv_typeName=
ruleTypeRef {if ($current==null) {$current = factory.create("Action");}factory.set($current, "typeName",lv_typeName);}
))
'.')
(
	lv_feature=
RULE_ID {if ($current==null) {$current = factory.create("Action");}factory.set($current, "feature",lv_feature);}
))
(
	lv_operator=
(
'='|
'+=') {if ($current==null) {$current = factory.create("Action");}factory.set($current, "operator",lv_operator);}
))
'current')
'}');

ruleAbstractTerminal returns [Object current=null] : {Object temp=null;}
	
(
(
this_Keyword=ruleKeyword{$current = $this_Keyword.current;}|
this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;})|
this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;});

ruleParenthesizedElement returns [Object current=null] : {Object temp=null;}
	
(
(
'('
this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;})
')');

ruleKeyword returns [Object current=null] : {Object temp=null;}
	
(
	lv_value=
RULE_STRING {if ($current==null) {$current = factory.create("Keyword");}factory.set($current, "value",lv_value);}
);

ruleRuleCall returns [Object current=null] : {Object temp=null;}
	
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("RuleCall");}factory.set($current, "name",lv_name);}
);



RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_INT : ('0'..'9')+;

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


