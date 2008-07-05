
/*
Generated with Xtext
*/
grammar InternalTestLanguage;

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
 
    public InternalTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "EntryRule";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleEntryRule
entryRuleEntryRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEntryRule=ruleEntryRule 
	 { $current=$iv_ruleEntryRule.current; } 
	 EOF 
;

// Rule EntryRule
ruleEntryRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_multiFeature=ruleAbstractRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "multiFeature", lv_multiFeature,null);
        
         }
)*;
    


// Entry rule entryRuleAbstractRule
entryRuleAbstractRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ChoiceRule=ruleChoiceRule
    { 
        $current = $this_ChoiceRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ReducibleRule=ruleReducibleRule
    { 
        $current = $this_ReducibleRule.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleChoiceRule
entryRuleChoiceRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleChoiceRule=ruleChoiceRule 
	 { $current=$iv_ruleChoiceRule.current; } 
	 EOF 
;

// Rule ChoiceRule
ruleChoiceRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('choice' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_optionalKeyword='optional' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "optionalKeyword"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ChoiceElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "optionalKeyword", true,"optional");
        
         }
)?)(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ChoiceElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
));
    


// Entry rule entryRuleReducibleRule
entryRuleReducibleRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleReducibleRule=ruleReducibleRule 
	 { $current=$iv_ruleReducibleRule.current; } 
	 EOF 
;

// Rule ReducibleRule
ruleReducibleRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('reducible' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalRule=ruleTerminalRule
    { 
        $current = $this_TerminalRule.current; 
        currentNode = currentNode.getParent();
    }
)((
    { 
        temp=factory.create("ReducibleComposite");
        factory.add(temp, "actionFeature",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_actionFeature=ruleTerminalRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ReducibleElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "actionFeature", lv_actionFeature,null);
        
         }
))?);
    


// Entry rule entryRuleTerminalRule
entryRuleTerminalRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalRule=ruleTerminalRule 
	 { $current=$iv_ruleTerminalRule.current; } 
	 EOF 
;

// Rule TerminalRule
ruleTerminalRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_stringFeature=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi#//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, "stringFeature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TerminalElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "stringFeature", lv_stringFeature,"STRING");
        
         }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


