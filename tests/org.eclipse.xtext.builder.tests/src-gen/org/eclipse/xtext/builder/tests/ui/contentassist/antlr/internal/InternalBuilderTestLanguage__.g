lexer grammar InternalBuilderTestLanguage;
@header {
package org.eclipse.xtext.builder.tests.ui.contentassist.antlr.internal;

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

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 829
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 831
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 833
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 835
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 837
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 839
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g" 841
RULE_ANY_OTHER : .;


