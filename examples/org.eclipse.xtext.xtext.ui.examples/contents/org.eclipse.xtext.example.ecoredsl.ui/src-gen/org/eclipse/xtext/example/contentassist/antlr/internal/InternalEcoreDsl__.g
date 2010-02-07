lexer grammar InternalEcoreDsl;
@header {
package org.eclipse.xtext.example.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T16 : 'class' ;
T17 : 'ref' ;
T18 : 'void' ;
T19 : '.' ;
T20 : '$' ;
T21 : 'import' ;
T22 : ';' ;
T23 : '=' ;
T24 : 'package' ;
T25 : 'nsURI' ;
T26 : 'nsPrefix' ;
T27 : '{' ;
T28 : '}' ;
T29 : 'datatype' ;
T30 : ':' ;
T31 : '@' ;
T32 : '(' ;
T33 : ')' ;
T34 : ',' ;
T35 : '<' ;
T36 : '>' ;
T37 : 'extends' ;
T38 : 'attr' ;
T39 : '[' ;
T40 : ']' ;
T41 : '..' ;
T42 : '#' ;
T43 : 'enum' ;
T44 : '?' ;
T45 : 'super' ;
T46 : 'op' ;
T47 : 'throws' ;
T48 : '-' ;
T49 : 'abstract' ;
T50 : 'interface' ;
T51 : 'ID' ;
T52 : 'volatile' ;
T53 : 'transient' ;
T54 : 'unsettable' ;
T55 : 'derived' ;
T56 : 'val' ;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6373
RULE_BAG : 'bag';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6375
RULE_RANDOM : 'random';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6377
RULE_READONLY : 'readonly';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6379
RULE_LOCAL : 'local';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6381
RULE_SERIALIZABLE : '!serializable';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6383
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6385
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6387
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6389
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6391
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6393
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.xtext.example.ecoredsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalEcoreDsl.g" 6395
RULE_ANY_OTHER : .;


