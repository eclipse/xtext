/*
Generated with Xtext
*/
grammar InternalContentAssistTestLanguage;

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
 
    public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalContentAssistTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Start";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleStart
entryRuleStart returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleStart=ruleStart 
	 { $current=$iv_ruleStart.current; } 
	 EOF 
;

// Rule Start
ruleStart returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('abstract rules' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rules=ruleAbstractRule 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Start");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "rules", lv_rules,null);
	         }
	
)+)'end' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleAbstractRule
entryRuleAbstractRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractRule=ruleAbstractRule 
	 { $current=$iv_ruleAbstractRule.current; } 
	 EOF 
;

// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_FirstAbstractRuleChild=ruleFirstAbstractRuleChild
    { 
        $current = $this_FirstAbstractRuleChild.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_SecondAbstractRuleChild=ruleSecondAbstractRuleChild
    { 
        $current = $this_SecondAbstractRuleChild.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleFirstAbstractRuleChild
entryRuleFirstAbstractRuleChild returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild 
	 { $current=$iv_ruleFirstAbstractRuleChild.current; } 
	 EOF 
;

// Rule FirstAbstractRuleChild
ruleFirstAbstractRuleChild returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("FirstAbstractRuleChild");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "name", lv_name,"ID");
	         }
	
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_elements=ruleAbstractRule 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("FirstAbstractRuleChild");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "elements", lv_elements,null);
	         }
	
)+)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleSecondAbstractRuleChild
entryRuleSecondAbstractRuleChild returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild 
	 { $current=$iv_ruleSecondAbstractRuleChild.current; } 
	 EOF 
;

// Rule SecondAbstractRuleChild
ruleSecondAbstractRuleChild returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("SecondAbstractRuleChild");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "name", lv_name,"ID");
	         }
	
)'rule' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rule=ruleAbstractRuleCall 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("SecondAbstractRuleChild");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "rule", lv_rule,null);
	         }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleAbstractRuleCall
entryRuleAbstractRuleCall returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractRuleCall=ruleAbstractRuleCall 
	 { $current=$iv_ruleAbstractRuleCall.current; } 
	 EOF 
;

// Rule AbstractRuleCall
ruleAbstractRuleCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AbstractRuleCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
    }
) 
	
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


