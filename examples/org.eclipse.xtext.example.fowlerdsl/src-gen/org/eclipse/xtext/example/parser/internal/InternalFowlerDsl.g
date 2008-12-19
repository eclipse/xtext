/*
Generated with Xtext
*/
grammar InternalFowlerDsl;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.example.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.example.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;

}

@parser::members {
 
    public InternalFowlerDslParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalFowlerDslParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/internal/InternalFowlerDsl.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Statemachine";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleStatemachine
entryRuleStatemachine returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleStatemachine=ruleStatemachine 
	 { $current=$iv_ruleStatemachine.current; } 
	 EOF 
;

// Rule Statemachine
ruleStatemachine returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((('events' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_events=ruleEvent 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Statemachine");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "events", lv_events,"Event");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)'end' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'commands' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_commands=ruleCommand 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Statemachine");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "commands", lv_commands,"Command");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)'end' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_states=ruleState 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Statemachine");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "states", lv_states,"State");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*);





// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEvent=ruleEvent 
	 { $current=$iv_ruleEvent.current; } 
	 EOF 
;

// Rule Event
ruleEvent returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    lv_resetting='resetting' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "resetting"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Event");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "resetting", true,"resetting");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Event");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name,"ID");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_code=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Event");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "code", lv_code,"ID");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleCommand
entryRuleCommand returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCommand=ruleCommand 
	 { $current=$iv_ruleCommand.current; } 
	 EOF 
;

// Rule Command
ruleCommand returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Command");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name,"ID");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_code=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Command");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "code", lv_code,"ID");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleState
entryRuleState returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleState=ruleState 
	 { $current=$iv_ruleState.current; } 
	 EOF 
;

// Rule State
ruleState returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('state' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("State");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name,"ID");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))((('actions' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("State");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "actions"); 
    }
) 
	
)+)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_transitions=ruleTransition 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("State");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "transitions", lv_transitions,"Transition");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)'end' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);





// Entry rule entryRuleTransition
entryRuleTransition returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTransition=ruleTransition 
	 { $current=$iv_ruleTransition.current; } 
	 EOF 
;

// Rule Transition
ruleTransition returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Transition");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "event"); 
    }
) 
	
)'=>' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Transition");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "state"); 
    }
) 
	
));





RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


