
grammar InternalSimpleTest;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
}

@parser::members {
private IElementFactory factory;
public InternalSimpleTestParser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

}

parse returns [Object current] :
	ruleFoo {$current=$ruleFoo.current;} EOF;


ruleFoo returns [Object current=null] : {Object temp=null;}
	
(
	lv_name=
RULE_ID {if ($current==null) {$current = factory.create("Foo");}factory.set($current, "name",lv_name);}
);



RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_INT : ('0'..'9')+;

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ANY_OTHER : .;


