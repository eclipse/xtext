/*
Generated with Xtext
*/
grammar InternalFormatterTestLanguage;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.formatter.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.formatter.parser.internal; 

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
 
    public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalFormatterTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Root";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleRoot
entryRuleRoot returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRoot=ruleRoot 
	 { $current=$iv_ruleRoot.current; } 
	 EOF 
;

// Rule Root
ruleRoot returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('test' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TestLinewrap=ruleTestLinewrap
    { 
        $current = $this_TestLinewrap.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TestIndentation=ruleTestIndentation
    { 
        $current = $this_TestIndentation.current; 
        currentNode = currentNode.getParent();
    }
));
    


// Entry rule entryRuleLine
entryRuleLine returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLine=ruleLine 
	 { $current=$iv_ruleLine.current; } 
	 EOF 
;

// Rule Line
ruleLine returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    lv_type=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "type"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Line");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "type", lv_type,"ID");
	         }
	
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Line");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "name", lv_name,"ID");
	         }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleTestLinewrap
entryRuleTestLinewrap returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTestLinewrap=ruleTestLinewrap 
	 { $current=$iv_ruleTestLinewrap.current; } 
	 EOF 
;

// Rule TestLinewrap
ruleTestLinewrap returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('linewrap' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_items=ruleLine 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("TestLinewrap");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "items", lv_items,null);
	         }
	
)*);
    


// Entry rule entryRuleTestIndentation
entryRuleTestIndentation returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTestIndentation=ruleTestIndentation 
	 { $current=$iv_ruleTestIndentation.current; } 
	 EOF 
;

// Rule TestIndentation
ruleTestIndentation returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('indentation' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_sub=ruleTestIndentation 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("TestIndentation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "sub", lv_sub,null);
	         }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_items=ruleLine 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("TestIndentation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "items", lv_items,null);
	         }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


