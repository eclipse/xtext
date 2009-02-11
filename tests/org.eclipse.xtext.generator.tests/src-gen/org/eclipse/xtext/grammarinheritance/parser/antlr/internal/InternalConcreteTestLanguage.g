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

}

@parser::members {
 
    public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); }
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
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ConcreteParserRule=ruleConcreteParserRule
    { 
        $current = $this_ConcreteParserRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_CallOverridenParserRule=ruleCallOverridenParserRule
    { 
        $current = $this_CallOverridenParserRule.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_CallExtendedParserRule=ruleCallExtendedParserRule
    { 
        $current = $this_CallExtendedParserRule.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleConcreteParserRule
entryRuleConcreteParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_magicNumber=RULE_REAL
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "magicNumber"); 
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); }
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
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.3/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
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







// Entry rule entryRuleExtendableParserRule
entryRuleExtendableParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Subrule1=ruleSubrule1
    { 
        $current = $this_Subrule1.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Subrule2=ruleSubrule2
    { 
        $current = $this_Subrule2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Subrule3=ruleSubrule3
    { 
        $current = $this_Subrule3.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleSubrule1
entryRuleSubrule1 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub1"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub2"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub1"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.8" /* xtext::ParserRule */, currentNode); }
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
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.8/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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


