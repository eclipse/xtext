lexer grammar InternalEcoreTerminalsTestLanguage;
@header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T8 : 'int' ;
T9 : 'double' ;
T10 : 'date' ;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g" 185
RULE_EDOUBLE : ('.' ('0'..'9')+|('0'..'9')+ '.' ('0'..'9')*) (('E'|'e') ('-'|'+'?) ('0'..'9')+)?;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g" 187
RULE_EDATE : '0'..'9' '0'..'9' '0'..'9' '0'..'9' '-' '0'..'9' '0'..'9' '-' '0'..'9' '0'..'9' 'T' '0'..'9' '0'..'9' ':' '0'..'9' '0'..'9' ':' '0'..'9' '0'..'9' '.' '0'..'9' '0'..'9' '0'..'9' ('+'|'-') '0'..'9' '0'..'9' '0'..'9' '0'..'9';

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g" 189
RULE_EINT : '-'? ('0'..'9')+;

// $ANTLR src "/Users/koehnlein/Documents/devel/xtext/workspace/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g" 191
RULE_WS : (' '|'\t'|'\r'|'\n')+;


