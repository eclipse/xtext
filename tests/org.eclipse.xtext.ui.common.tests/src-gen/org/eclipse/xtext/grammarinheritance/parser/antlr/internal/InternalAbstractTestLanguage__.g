lexer grammar InternalAbstractTestLanguage;
@header {
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'element' ;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 242
RULE_INT : ('0'..'9')+;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 246
RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 250
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 254
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 258
RULE_WS : (((' '|'\t')|'\r')|'\n')+;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 262
RULE_ANY_OTHER : .;



// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 266
RULE_REAL : RULE_INT '.' RULE_INT;

// $ANTLR src "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g" 268
RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;


