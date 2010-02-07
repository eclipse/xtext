lexer grammar InternalBuilderTestLanguage;
@header {
package org.eclipse.xtext.builder.tests.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'namespace' ;
T12 : '{' ;
T13 : '}' ;
T14 : 'import' ;
T15 : 'object' ;
T16 : 'references' ;
T17 : 'otherRefs' ;
T18 : ',' ;
T19 : '.' ;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 828
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 830
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 832
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 834
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 836
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 838
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 840
RULE_ANY_OTHER : .;


