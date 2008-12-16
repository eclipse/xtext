/*
Generated with Xtext
*/
grammar InternalDatatypeRulesTestLanguage;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.datatyperules.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.datatyperules.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.ValueConverterException;
}

@parser::members {
 
    public InternalDatatypeRulesTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalDatatypeRulesTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "CompositeModel";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleCompositeModel
entryRuleCompositeModel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCompositeModel=ruleCompositeModel 
	 { $current=$iv_ruleCompositeModel.current; } 
	 EOF 
;

// Rule CompositeModel
ruleCompositeModel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_model=ruleModel 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("CompositeModel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "model", lv_model,"Model");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)+;





// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_id=ruleNestedModelId 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "id", lv_id,"NestedModelId");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_value=ruleFraction 
	    {
	        currentNode = currentNode.getParent();
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value,"Fraction");
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);





// Entry rule entryRuleModelId
entryRuleModelId returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleModelId=ruleModelId 
	 { $current=$iv_ruleModelId.current; }  
	 EOF 
;

// Rule ModelId
ruleModelId returns [String current=null] 
    @init { StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; }:
((    this_ID=RULE_ID    {

		buffer.append($this_ID.text);

    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, null); 
    }
'.' 
    {
        buffer.append(".");
        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)    this_ID=RULE_ID    {

		buffer.append($this_ID.text);

    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, null); 
    }
)
    ;





// Entry rule entryRuleNestedModelId
entryRuleNestedModelId returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleNestedModelId=ruleNestedModelId 
	 { $current=$iv_ruleNestedModelId.current; }  
	 EOF 
;

// Rule NestedModelId
ruleNestedModelId returns [String current=null] 
    @init { StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; }:
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ModelId=ruleModelId    {

		if ($this_ModelId.current != null) buffer.append($this_ModelId.current);

    }

    { 
        currentNode = currentNode.getParent();
    }
'.' 
    {
        buffer.append(".");
        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ModelId=ruleModelId    {

		if ($this_ModelId.current != null) buffer.append($this_ModelId.current);

    }

    { 
        currentNode = currentNode.getParent();
    }
)
    ;





// Entry rule entryRuleFraction
entryRuleFraction returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleFraction=ruleFraction 
	 { $current=$iv_ruleFraction.current; }  
	 EOF 
;

// Rule Fraction
ruleFraction returns [String current=null] 
    @init { StringBuilder buffer=new StringBuilder(20); setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); current = buffer.length() > 0 ? buffer.toString() : null; }:
(    this_INT=RULE_INT    {

		buffer.append($this_INT.text);

    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, null); 
    }
('/' 
    {
        buffer.append("/");
        createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
    this_INT=RULE_INT    {

		buffer.append($this_INT.text);

    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::RuleCall */, null); 
    }
)?)
    ;





RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


