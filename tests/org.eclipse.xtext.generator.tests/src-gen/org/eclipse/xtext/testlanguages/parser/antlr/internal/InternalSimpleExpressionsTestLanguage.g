/*
Generated with Xtext
*/
grammar InternalSimpleExpressionsTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;

}

@parser::members {
 
    public InternalSimpleExpressionsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalSimpleExpressionsTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Sequence";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleSequence
entryRuleSequence returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSequence=ruleSequence 
	 { $current=$iv_ruleSequence.current; } 
	 EOF 
;

// Rule Sequence
ruleSequence returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Addition=ruleAddition
    { 
        $current = $this_Addition.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Sequence");
        try {
        	factory.add(temp, "expressions", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_expressions=ruleAddition 
	    {
	        if ($current==null) {
	            $current = factory.create("Sequence");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "expressions", lv_expressions, "Addition", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleAddition
entryRuleAddition returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAddition=ruleAddition 
	 { $current=$iv_ruleAddition.current; } 
	 EOF 
;

// Rule Addition
ruleAddition returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Multiplication=ruleMultiplication
    { 
        $current = $this_Multiplication.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Op");
        try {
        	factory.add(temp, "values", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    lv_operator=('+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'-' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "operator", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_values=ruleMultiplication 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "values", lv_values, "Multiplication", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleMultiplication
entryRuleMultiplication returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMultiplication=ruleMultiplication 
	 { $current=$iv_ruleMultiplication.current; } 
	 EOF 
;

// Rule Multiplication
ruleMultiplication returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Term=ruleTerm
    { 
        $current = $this_Term.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Op");
        try {
        	factory.add(temp, "values", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    lv_operator=('*' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'/' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "operator", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_values=ruleTerm 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "values", lv_values, "Term", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerm=ruleTerm 
	 { $current=$iv_ruleTerm.current; } 
	 EOF 
;

// Rule Term
ruleTerm returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.3/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Atom=ruleAtom
    { 
        $current = $this_Atom.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.3/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Parens=ruleParens
    { 
        $current = $this_Parens.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAtom=ruleAtom 
	 { $current=$iv_ruleAtom.current; } 
	 EOF 
;

// Rule Atom
ruleAtom returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.4/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Atom");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleParens
entryRuleParens returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParens=ruleParens 
	 { $current=$iv_ruleParens.current; } 
	 EOF 
;

// Rule Parens
ruleParens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Addition=ruleAddition
    { 
        $current = $this_Addition.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);



















RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


