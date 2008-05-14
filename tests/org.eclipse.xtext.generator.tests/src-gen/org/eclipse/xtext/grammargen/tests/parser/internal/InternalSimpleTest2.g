
grammar InternalSimpleTest2;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
}

@parser::members {
private IElementFactory factory;
public InternalSimpleTest2Parser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

}

parse returns [Object current] :
	ruleModel {$current=$ruleModel.current;} EOF;


ruleModel returns [Object current=null] : {Object temp=null;}
	
(
	lv_contents=
ruleChild {if ($current==null) {$current = factory.create("Model");}factory.add($current, "contents",lv_contents);}
)*;

ruleChild returns [Object current=null] : {Object temp=null;}
	
(
(
(
(
(
(
	lv_optional=
'optional' {if ($current==null) {$current = factory.create("Child");}factory.set($current, "optional",lv_optional);}
)?
'keyword')
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("Child");}factory.set($current, "name",lv_name);}
))
(
	lv_number=
RULE_INT {if ($current==null) {$current = factory.create("Child");}factory.set($current, "number",lv_number);}
))
'{')
'}');



RULE_INT : ('0'..'9')+;

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ANY_OTHER : .;


