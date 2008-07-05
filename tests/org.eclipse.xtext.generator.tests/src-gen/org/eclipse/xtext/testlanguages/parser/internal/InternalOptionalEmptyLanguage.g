
/*
Generated with Xtext
*/
grammar InternalOptionalEmptyLanguage;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.internal; 

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
 
    public InternalOptionalEmptyLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalOptionalEmptyLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Model";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_child=ruleGreeting 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "child", lv_child,null);
        
         }
)?;
    


// Entry rule entryRuleGreeting
entryRuleGreeting returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGreeting=ruleGreeting 
	 { $current=$iv_ruleGreeting.current; } 
	 EOF 
;

// Rule Greeting
ruleGreeting returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('hallo' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@parserRules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Greeting");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
));
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


