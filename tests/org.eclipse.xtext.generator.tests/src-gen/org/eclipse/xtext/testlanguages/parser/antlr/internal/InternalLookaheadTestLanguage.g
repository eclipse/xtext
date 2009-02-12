/*
Generated with Xtext
*/
grammar InternalLookaheadTestLanguage;

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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

}

@parser::members {
 
 	private LookaheadTestLanguageGrammarAccess grammarAccess;
 	
    public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, LookaheadTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalLookaheadTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.tokens");
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
	{ currentNode = createCompositeNode(grammarAccess.prEntry().getRule(), currentNode); }
	 iv_ruleEntry=ruleEntry 
	 { $current=$iv_ruleEntry.current; } 
	 EOF 
;

// Rule Entry
ruleEntry returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEntry().ele0ParserRuleCallAlts(), currentNode); 
	    }
	    lv_contents=ruleAlts 
	    {
	        if ($current==null) {
	            $current = factory.create("Entry");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "contents", lv_contents, "Alts", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*;







// Entry rule entryRuleAlts
entryRuleAlts returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAlts().getRule(), currentNode); }
	 iv_ruleAlts=ruleAlts 
	 { $current=$iv_ruleAlts.current; } 
	 EOF 
;

// Rule Alts
ruleAlts returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((
    { 
        currentNode=createCompositeNode(grammarAccess.prAlts().ele00ParserRuleCallLookAhead0(), currentNode); 
    }
    this_LookAhead0=ruleLookAhead0
    { 
        $current = $this_LookAhead0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAlts().ele01ParserRuleCallLookAhead1(), currentNode); 
    }
    this_LookAhead1=ruleLookAhead1
    { 
        $current = $this_LookAhead1.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAlts().ele1ParserRuleCallLookAhead3(), currentNode); 
    }
    this_LookAhead3=ruleLookAhead3
    { 
        $current = $this_LookAhead3.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleLookAhead0
entryRuleLookAhead0 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLookAhead0().getRule(), currentNode); }
	 iv_ruleLookAhead0=ruleLookAhead0 
	 { $current=$iv_ruleLookAhead0.current; } 
	 EOF 
;

// Rule LookAhead0
ruleLookAhead0 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('bar' 
    {
        createLeafNode(grammarAccess.prLookAhead0().ele0KeywordBar(), null); 
    }
(	
	
	    lv_x='a' 
    {
        createLeafNode(grammarAccess.prLookAhead0().ele10KeywordA(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead0");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "a", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleLookAhead1
entryRuleLookAhead1 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLookAhead1().getRule(), currentNode); }
	 iv_ruleLookAhead1=ruleLookAhead1 
	 { $current=$iv_ruleLookAhead1.current; } 
	 EOF 
;

// Rule LookAhead1
ruleLookAhead1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('foo' 
    {
        createLeafNode(grammarAccess.prLookAhead1().ele000KeywordFoo(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prLookAhead1().ele0010ParserRuleCallLookAhead2(), currentNode); 
	    }
	    lv_y=ruleLookAhead2 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "y", lv_y, "LookAhead2", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
	    lv_x='b' 
    {
        createLeafNode(grammarAccess.prLookAhead1().ele010KeywordB(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "b", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_x='d' 
    {
        createLeafNode(grammarAccess.prLookAhead1().ele10KeywordD(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "d", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleLookAhead2
entryRuleLookAhead2 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLookAhead2().getRule(), currentNode); }
	 iv_ruleLookAhead2=ruleLookAhead2 
	 { $current=$iv_ruleLookAhead2.current; } 
	 EOF 
;

// Rule LookAhead2
ruleLookAhead2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
	    lv_z='foo' 
    {
        createLeafNode(grammarAccess.prLookAhead2().ele000KeywordFoo(), "z"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "z", input.LT(-1), "foo", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_z='bar' 
    {
        createLeafNode(grammarAccess.prLookAhead2().ele010KeywordBar(), "z"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "z", input.LT(-1), "bar", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'c' 
    {
        createLeafNode(grammarAccess.prLookAhead2().ele1KeywordC(), null); 
    }
);







// Entry rule entryRuleLookAhead3
entryRuleLookAhead3 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLookAhead3().getRule(), currentNode); }
	 iv_ruleLookAhead3=ruleLookAhead3 
	 { $current=$iv_ruleLookAhead3.current; } 
	 EOF 
;

// Rule LookAhead3
ruleLookAhead3 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('foo' 
    {
        createLeafNode(grammarAccess.prLookAhead3().ele000KeywordFoo(), null); 
    }
'bar' 
    {
        createLeafNode(grammarAccess.prLookAhead3().ele001KeywordBar(), null); 
    }
)(	
	
	    lv_x='b' 
    {
        createLeafNode(grammarAccess.prLookAhead3().ele010KeywordB(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead3");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "b", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prLookAhead3().ele10ParserRuleCallLookAhead4(), currentNode); 
	    }
	    lv_z=ruleLookAhead4 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead3");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "z", lv_z, "LookAhead4", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleLookAhead4
entryRuleLookAhead4 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLookAhead4().getRule(), currentNode); }
	 iv_ruleLookAhead4=ruleLookAhead4 
	 { $current=$iv_ruleLookAhead4.current; } 
	 EOF 
;

// Rule LookAhead4
ruleLookAhead4 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((	
	
	    lv_x='c' 
    {
        createLeafNode(grammarAccess.prLookAhead4().ele00KeywordC(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead4");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "c", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_x='d' 
    {
        createLeafNode(grammarAccess.prLookAhead4().ele10KeywordD(), "x"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LookAhead4");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "x", input.LT(-1), "d", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





















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


