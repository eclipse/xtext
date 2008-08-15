
/*
Generated with Xtext
*/
grammar InternalLookaheadLanguage;

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
 
    public InternalLookaheadLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalLookaheadLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Entry";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleEntry
entryRuleEntry returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEntry=ruleEntry 
	 { $current=$iv_ruleEntry.current; } 
	 EOF 
;

// Rule Entry
ruleEntry returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_contents=ruleAlts 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Entry");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "contents", lv_contents,null);
	         }
	
)*;
    


// Entry rule entryRuleAlts
entryRuleAlts returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAlts=ruleAlts 
	 { $current=$iv_ruleAlts.current; } 
	 EOF 
;

// Rule Alts
ruleAlts returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead0=ruleLookAhead0
    { 
        $current = $this_LookAhead0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead1=ruleLookAhead1
    { 
        $current = $this_LookAhead1.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead3=ruleLookAhead3
    { 
        $current = $this_LookAhead3.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleLookAhead0
entryRuleLookAhead0 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead0=ruleLookAhead0 
	 { $current=$iv_ruleLookAhead0.current; } 
	 EOF 
;

// Rule LookAhead0
ruleLookAhead0 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('bar' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_x='a' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead0");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"a");
	         }
	
));
    


// Entry rule entryRuleLookAhead1
entryRuleLookAhead1 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead1=ruleLookAhead1 
	 { $current=$iv_ruleLookAhead1.current; } 
	 EOF 
;

// Rule LookAhead1
ruleLookAhead1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('foo' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_y=ruleLookAhead2 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "y", lv_y,null);
	         }
	
))(	
	
	    lv_x='b' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"b");
	         }
	
))(	
	
	    lv_x='d' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"d");
	         }
	
));
    


// Entry rule entryRuleLookAhead2
entryRuleLookAhead2 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead2=ruleLookAhead2 
	 { $current=$iv_ruleLookAhead2.current; } 
	 EOF 
;

// Rule LookAhead2
ruleLookAhead2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    lv_z='foo' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "z"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "z", input.LT(-1),"foo");
	         }
	
)
    |(	
	
	    lv_z='bar' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal" /* xtext::Keyword */, "z"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "z", input.LT(-1),"bar");
	         }
	
))'c' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleLookAhead3
entryRuleLookAhead3 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead3=ruleLookAhead3 
	 { $current=$iv_ruleLookAhead3.current; } 
	 EOF 
;

// Rule LookAhead3
ruleLookAhead3 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('foo' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'bar' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_x='b' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead3");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"b");
	         }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_z=ruleLookAhead4 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("LookAhead3");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "z", lv_z,null);
	         }
	
));
    


// Entry rule entryRuleLookAhead4
entryRuleLookAhead4 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead4=ruleLookAhead4 
	 { $current=$iv_ruleLookAhead4.current; } 
	 EOF 
;

// Rule LookAhead4
ruleLookAhead4 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((	
	
	    lv_x='c' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.6/@alternatives/@groups.0/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead4");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"c");
	         }
	
)
    |(	
	
	    lv_x='d' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@rules.6/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead4");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "x", input.LT(-1),"d");
	         }
	
));
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


