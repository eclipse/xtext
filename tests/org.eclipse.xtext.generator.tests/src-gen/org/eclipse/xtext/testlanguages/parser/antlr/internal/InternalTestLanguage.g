/*
Generated with Xtext
*/
grammar InternalTestLanguage;

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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;

}

@parser::members {
 
 	private TestLanguageGrammarAccess grammarAccess;
 	
    public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.tokens");
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
	{ currentNode = createCompositeNode(grammarAccess.prEntryRule().getRule(), currentNode); }
	 iv_ruleEntryRule=ruleEntryRule 
	 { $current=$iv_ruleEntryRule.current; } 
	 EOF 
;

// Rule EntryRule
ruleEntryRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEntryRule().ele0ParserRuleCallAbstractRule(), currentNode); 
	    }
	    lv_multiFeature=ruleAbstractRule 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "multiFeature", lv_multiFeature, "AbstractRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*;







// Entry rule entryRuleAbstractRule
entryRuleAbstractRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); }
	 iv_ruleAbstractRule=ruleAbstractRule 
	 { $current=$iv_ruleAbstractRule.current; } 
	 EOF 
;

// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele0ParserRuleCallChoiceRule(), currentNode); 
    }
    this_ChoiceRule=ruleChoiceRule
    { 
        $current = $this_ChoiceRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallReducibleRule(), currentNode); 
    }
    this_ReducibleRule=ruleReducibleRule
    { 
        $current = $this_ReducibleRule.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleChoiceRule
entryRuleChoiceRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prChoiceRule().getRule(), currentNode); }
	 iv_ruleChoiceRule=ruleChoiceRule 
	 { $current=$iv_ruleChoiceRule.current; } 
	 EOF 
;

// Rule ChoiceRule
ruleChoiceRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('choice' 
    {
        createLeafNode(grammarAccess.prChoiceRule().ele00KeywordChoice(), null); 
    }
(	
	
	    lv_optionalKeyword='optional' 
    {
        createLeafNode(grammarAccess.prChoiceRule().ele010KeywordOptional(), "optionalKeyword"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ChoiceElement");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "optionalKeyword", true, "optional", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prChoiceRule().ele10LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ChoiceElement");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleReducibleRule
entryRuleReducibleRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prReducibleRule().getRule(), currentNode); }
	 iv_ruleReducibleRule=ruleReducibleRule 
	 { $current=$iv_ruleReducibleRule.current; } 
	 EOF 
;

// Rule ReducibleRule
ruleReducibleRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('reducible' 
    {
        createLeafNode(grammarAccess.prReducibleRule().ele00KeywordReducible(), null); 
    }

    { 
        currentNode=createCompositeNode(grammarAccess.prReducibleRule().ele01ParserRuleCallTerminalRule(), currentNode); 
    }
    this_TerminalRule=ruleTerminalRule
    { 
        $current = $this_TerminalRule.current; 
        currentNode = currentNode.getParent();
    }
)((
    { 
        temp=factory.create("ReducibleComposite");
        try {
        	factory.add(temp, "actionFeature", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode(grammarAccess.prReducibleRule().ele10ActionReducibleCompositeactionFeature(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prReducibleRule().ele110ParserRuleCallTerminalRule(), currentNode); 
	    }
	    lv_actionFeature=ruleTerminalRule 
	    {
	        if ($current==null) {
	            $current = factory.create("ReducibleElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "actionFeature", lv_actionFeature, "TerminalRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?);







// Entry rule entryRuleTerminalRule
entryRuleTerminalRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); }
	 iv_ruleTerminalRule=ruleTerminalRule 
	 { $current=$iv_ruleTerminalRule.current; } 
	 EOF 
;

// Rule TerminalRule
ruleTerminalRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_stringFeature=RULE_STRING
    { 
    createLeafNode(grammarAccess.prTerminalRule().ele0LexerRuleCallSTRING(), "stringFeature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TerminalElement");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "stringFeature", lv_stringFeature, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
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


