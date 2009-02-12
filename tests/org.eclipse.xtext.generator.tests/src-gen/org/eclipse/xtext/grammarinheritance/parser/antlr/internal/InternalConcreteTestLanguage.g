/*
Generated with Xtext
*/
grammar InternalConcreteTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

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
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;

}

@parser::members {
 
 	private ConcreteTestLanguageGrammarAccess grammarAccess;
 	
    public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalConcreteTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "RootRule";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleRootRule
entryRuleRootRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prRootRule().getRule(), currentNode); }
	 iv_ruleRootRule=ruleRootRule 
	 { $current=$iv_ruleRootRule.current; } 
	 EOF 
;

// Rule RootRule
ruleRootRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((
    { 
        currentNode=createCompositeNode(grammarAccess.prRootRule().ele000ParserRuleCallConcreteParserRule(), currentNode); 
    }
    this_ConcreteParserRule=ruleConcreteParserRule
    { 
        $current = $this_ConcreteParserRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRootRule().ele001ParserRuleCallCallOverridenParserRule(), currentNode); 
    }
    this_CallOverridenParserRule=ruleCallOverridenParserRule
    { 
        $current = $this_CallOverridenParserRule.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRootRule().ele01ParserRuleCallCallExtendedParserRule(), currentNode); 
    }
    this_CallExtendedParserRule=ruleCallExtendedParserRule
    { 
        $current = $this_CallExtendedParserRule.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRootRule().ele1ParserRuleCallOverridableParserRule2(), currentNode); 
    }
    this_OverridableParserRule2=ruleOverridableParserRule2
    { 
        $current = $this_OverridableParserRule2.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleConcreteParserRule
entryRuleConcreteParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prConcreteParserRule().getRule(), currentNode); }
	 iv_ruleConcreteParserRule=ruleConcreteParserRule 
	 { $current=$iv_ruleConcreteParserRule.current; } 
	 EOF 
;

// Rule ConcreteParserRule
ruleConcreteParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('model' 
    {
        createLeafNode(grammarAccess.prConcreteParserRule().ele000KeywordModel(), null); 
    }
(	
	
	    lv_magicNumber=RULE_REAL
    { 
    createLeafNode(grammarAccess.prConcreteParserRule().ele0010LexerRuleCallREAL(), "magicNumber"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ConcreteParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "magicNumber", lv_magicNumber, "REAL", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))':' 
    {
        createLeafNode(grammarAccess.prConcreteParserRule().ele01KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prConcreteParserRule().ele10ParserRuleCallInheritedParserRule(), currentNode); 
	    }
	    lv_elements=ruleInheritedParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("ConcreteParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "elements", lv_elements, "InheritedParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*);







// Entry rule entryRuleOverridableParserRule
entryRuleOverridableParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prOverridableParserRule().getRule(), currentNode); }
	 iv_ruleOverridableParserRule=ruleOverridableParserRule 
	 { $current=$iv_ruleOverridableParserRule.current; } 
	 EOF 
;

// Rule OverridableParserRule
ruleOverridableParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('overriddenelement' 
    {
        createLeafNode(grammarAccess.prOverridableParserRule().ele0KeywordOverriddenelement(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prOverridableParserRule().ele10LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleCallOverridenParserRule
entryRuleCallOverridenParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prCallOverridenParserRule().getRule(), currentNode); }
	 iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule 
	 { $current=$iv_ruleCallOverridenParserRule.current; } 
	 EOF 
;

// Rule CallOverridenParserRule
ruleCallOverridenParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prCallOverridenParserRule().ele0ParserRuleCallAbstractCallOverridenParserRule(), currentNode); 
	    }
	    lv_call=ruleAbstractCallOverridenParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("CallOverridenParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "call", lv_call, "AbstractCallOverridenParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
);







// Entry rule entryRuleOverridableParserRule2
entryRuleOverridableParserRule2 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prOverridableParserRule2().getRule(), currentNode); }
	 iv_ruleOverridableParserRule2=ruleOverridableParserRule2 
	 { $current=$iv_ruleOverridableParserRule2.current; } 
	 EOF 
;

// Rule OverridableParserRule2
ruleOverridableParserRule2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('overridden other element' 
    {
        createLeafNode(grammarAccess.prOverridableParserRule2().ele000KeywordOverriddenOtherElement(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prOverridableParserRule2().ele0010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AType2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'-' 
    {
        createLeafNode(grammarAccess.prOverridableParserRule2().ele01KeywordHyphenMinus(), null); 
    }
)(	
	
	    lv_age=RULE_INT
    { 
    createLeafNode(grammarAccess.prOverridableParserRule2().ele10LexerRuleCallINT(), "age"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AType2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "age", lv_age, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleExtendableParserRule
entryRuleExtendableParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prExtendableParserRule().getRule(), currentNode); }
	 iv_ruleExtendableParserRule=ruleExtendableParserRule 
	 { $current=$iv_ruleExtendableParserRule.current; } 
	 EOF 
;

// Rule ExtendableParserRule
ruleExtendableParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((
    { 
        currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele00ParserRuleCallSubrule1(), currentNode); 
    }
    this_Subrule1=ruleSubrule1
    { 
        $current = $this_Subrule1.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele01ParserRuleCallSubrule2(), currentNode); 
    }
    this_Subrule2=ruleSubrule2
    { 
        $current = $this_Subrule2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele1ParserRuleCallSubrule3(), currentNode); 
    }
    this_Subrule3=ruleSubrule3
    { 
        $current = $this_Subrule3.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleSubrule1
entryRuleSubrule1 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSubrule1().getRule(), currentNode); }
	 iv_ruleSubrule1=ruleSubrule1 
	 { $current=$iv_ruleSubrule1.current; } 
	 EOF 
;

// Rule Subrule1
ruleSubrule1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('subrule1' 
    {
        createLeafNode(grammarAccess.prSubrule1().ele00KeywordSubrule1(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prSubrule1().ele010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_sub1=RULE_ID
    { 
    createLeafNode(grammarAccess.prSubrule1().ele10LexerRuleCallID(), "sub1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "sub1", lv_sub1, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleSubrule2
entryRuleSubrule2 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSubrule2().getRule(), currentNode); }
	 iv_ruleSubrule2=ruleSubrule2 
	 { $current=$iv_ruleSubrule2.current; } 
	 EOF 
;

// Rule Subrule2
ruleSubrule2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('subrule3' 
    {
        createLeafNode(grammarAccess.prSubrule2().ele00KeywordSubrule3(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prSubrule2().ele010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_sub2=RULE_STRING
    { 
    createLeafNode(grammarAccess.prSubrule2().ele10LexerRuleCallSTRING(), "sub2"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "sub2", lv_sub2, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleSubrule3
entryRuleSubrule3 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSubrule3().getRule(), currentNode); }
	 iv_ruleSubrule3=ruleSubrule3 
	 { $current=$iv_ruleSubrule3.current; } 
	 EOF 
;

// Rule Subrule3
ruleSubrule3 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('subrule3' 
    {
        createLeafNode(grammarAccess.prSubrule3().ele00KeywordSubrule3(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prSubrule3().ele010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule3");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_sub1=RULE_INT
    { 
    createLeafNode(grammarAccess.prSubrule3().ele10LexerRuleCallINT(), "sub1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Subrule3");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "sub1", lv_sub1, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleCallExtendedParserRule
entryRuleCallExtendedParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prCallExtendedParserRule().getRule(), currentNode); }
	 iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule 
	 { $current=$iv_ruleCallExtendedParserRule.current; } 
	 EOF 
;

// Rule CallExtendedParserRule
ruleCallExtendedParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prCallExtendedParserRule().ele0ParserRuleCallAbstractCallExtendedParserRule(), currentNode); 
	    }
	    lv_call=ruleAbstractCallExtendedParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("CallExtendedParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "call", lv_call, "AbstractCallExtendedParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
);







// Entry rule entryRuleInheritedParserRule
entryRuleInheritedParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prInheritedParserRule().getRule(), currentNode); }
	 iv_ruleInheritedParserRule=ruleInheritedParserRule 
	 { $current=$iv_ruleInheritedParserRule.current; } 
	 EOF 
;

// Rule InheritedParserRule
ruleInheritedParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('element' 
    {
        createLeafNode(grammarAccess.prInheritedParserRule().ele0KeywordElement(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prInheritedParserRule().ele10LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleAbstractCallOverridenParserRule
entryRuleAbstractCallOverridenParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().getRule(), currentNode); }
	 iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule 
	 { $current=$iv_ruleAbstractCallOverridenParserRule.current; } 
	 EOF 
;

// Rule AbstractCallOverridenParserRule
ruleAbstractCallOverridenParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('overridemodel' 
    {
        createLeafNode(grammarAccess.prAbstractCallOverridenParserRule().ele0KeywordOverridemodel(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().ele10ParserRuleCallOverridableParserRule(), currentNode); 
	    }
	    lv_elements=ruleOverridableParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("AModel");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "elements", lv_elements, "OverridableParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*);







// Entry rule entryRuleAbstractCallExtendedParserRule
entryRuleAbstractCallExtendedParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().getRule(), currentNode); }
	 iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule 
	 { $current=$iv_ruleAbstractCallExtendedParserRule.current; } 
	 EOF 
;

// Rule AbstractCallExtendedParserRule
ruleAbstractCallExtendedParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('extendedmodel' 
    {
        createLeafNode(grammarAccess.prAbstractCallExtendedParserRule().ele0KeywordExtendedmodel(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().ele10ParserRuleCallExtendableParserRule(), currentNode); 
	    }
	    lv_elements=ruleExtendableParserRule 
	    {
	        if ($current==null) {
	            $current = factory.create("AModel");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "elements", lv_elements, "ExtendableParserRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*);

































RULE_REAL : RULE_INT '.' RULE_INT;

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : 
			  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | 
              '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
              ;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


