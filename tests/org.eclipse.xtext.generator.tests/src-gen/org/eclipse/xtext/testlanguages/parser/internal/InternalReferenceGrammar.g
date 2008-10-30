/*
Generated with Xtext
*/
grammar InternalReferenceGrammar;

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
 
    public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Spielplatz";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleSpielplatz
entryRuleSpielplatz returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielplatz=ruleSpielplatz 
	 { $current=$iv_ruleSpielplatz.current; } 
	 EOF 
;

// Rule Spielplatz
ruleSpielplatz returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((('spielplatz' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_groesse=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "groesse", lv_groesse,"INT");
	         }
	
))(	
	
	    lv_beschreibung=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "beschreibung", lv_beschreibung,"STRING");
	         }
	
)?)'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_kinder=ruleKind 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "kinder", lv_kinder,null);
	         }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_erzieher=ruleErwachsener 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "erzieher", lv_erzieher,null);
	         }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_spielzeuge=ruleSpielzeug 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Spielplatz");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "spielzeuge", lv_spielzeuge,null);
	         }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?;
    




// Entry rule entryRuleKind
entryRuleKind returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleKind=ruleKind 
	 { $current=$iv_ruleKind.current; } 
	 EOF 
;

// Rule Kind
ruleKind returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('kind' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Kind");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "name", lv_name,"ID");
	         }
	
))(	
	
	    lv_age=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Kind");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "age", lv_age,"INT");
	         }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleErwachsener
entryRuleErwachsener returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleErwachsener=ruleErwachsener 
	 { $current=$iv_ruleErwachsener.current; } 
	 EOF 
;

// Rule Erwachsener
ruleErwachsener returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('erwachsener' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Erwachsener");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "name", lv_name,"ID");
	         }
	
))(	
	
	    lv_age=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Erwachsener");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "age", lv_age,"INT");
	         }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleSpielzeug
entryRuleSpielzeug returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielzeug=ruleSpielzeug 
	 { $current=$iv_ruleSpielzeug.current; } 
	 EOF 
;

// Rule Spielzeug
ruleSpielzeug returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('spielzeug' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spielzeug");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "name", lv_name,"ID");
	         }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_farbe=ruleFarbe 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Spielzeug");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "farbe", lv_farbe,null);
	         }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleFarbe
entryRuleFarbe returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFarbe=ruleFarbe 
	 { $current=$iv_ruleFarbe.current; } 
	 EOF 
;

// Rule Farbe
ruleFarbe returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('ROT' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, null); 
    }

    |'BLAU' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, null); 
    }
)
    |'GELB' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, null); 
    }
)
    |'GRÜN' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5/@alternatives/@groups.1" /* xtext::Keyword */, null); 
    }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


