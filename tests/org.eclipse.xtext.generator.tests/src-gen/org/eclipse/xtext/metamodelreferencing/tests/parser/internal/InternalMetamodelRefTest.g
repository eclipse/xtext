
/*
Generated with Xtext
*/
grammar InternalMetamodelRefTest;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
}

@parser::members {
 
    public InternalMetamodelRefTestParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalMetamodelRefTestParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMetamodelRefTest.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Foo";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleFoo
entryRuleFoo returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFoo=ruleFoo 
	 { $current=$iv_ruleFoo.current; } 
	 EOF 
;

// Rule Foo
ruleFoo returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Foo");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_nameRefs=ruleNameRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Foo");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "nameRefs", lv_nameRefs,null);    }
)*);
    


// Entry rule entryRuleNameRef
entryRuleNameRef returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNameRef=ruleNameRef 
	 { $current=$iv_ruleNameRef.current; } 
	 EOF 
;

// Rule NameRef
ruleNameRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_name=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi#//@parserRules.1/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("xtext::RuleCall");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"STRING");    }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


