/*
Generated with Xtext
*/
grammar InternalXtextTerminalsTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;

}

@parser::members {
 
    public InternalXtextTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalXtextTerminalsTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Grammar";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleGrammar
entryRuleGrammar returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGrammar=ruleGrammar 
	 { $current=$iv_ruleGrammar.current; } 
	 EOF 
;

// Rule Grammar
ruleGrammar returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((((	
	
	    lv_abstract='abstract language' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "abstract", true, "abstract language", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |'language' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_idElements=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "idElements", lv_idElements, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_idElements=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "idElements", lv_idElements, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)(('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_superGrammarIdElements=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_superGrammarIdElements=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations, "AbstractMetamodelDeclaration", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rules=ruleAbstractRule 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "rules", lv_rules, "AbstractRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)+);







// Entry rule entryRuleAbstractRule
entryRuleAbstractRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractRule=ruleAbstractRule 
	 { $current=$iv_ruleAbstractRule.current; } 
	 EOF 
;

// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_LexerRule=ruleLexerRule
    { 
        $current = $this_LexerRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ParserRule=ruleParserRule
    { 
        $current = $this_ParserRule.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalRule=ruleTerminalRule
    { 
        $current = $this_TerminalRule.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAbstractMetamodelDeclaration
entryRuleAbstractMetamodelDeclaration returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration 
	 { $current=$iv_ruleAbstractMetamodelDeclaration.current; } 
	 EOF 
;

// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_GeneratedMetamodel=ruleGeneratedMetamodel
    { 
        $current = $this_GeneratedMetamodel.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ReferencedMetamodel=ruleReferencedMetamodel
    { 
        $current = $this_ReferencedMetamodel.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleGeneratedMetamodel
entryRuleGeneratedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel 
	 { $current=$iv_ruleGeneratedMetamodel.current; } 
	 EOF 
;

// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('generate' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_name=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("GeneratedMetamodel");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("GeneratedMetamodel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_STRING    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
    }
) 
	
))('as' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_alias=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("GeneratedMetamodel");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "alias", lv_alias, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?);







// Entry rule entryRuleReferencedMetamodel
entryRuleReferencedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleReferencedMetamodel=ruleReferencedMetamodel 
	 { $current=$iv_ruleReferencedMetamodel.current; } 
	 EOF 
;

// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ReferencedMetamodel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_STRING    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
    }
) 
	
))('as' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_alias=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("ReferencedMetamodel");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "alias", lv_alias, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?);







// Entry rule entryRuleLexerRule
entryRuleLexerRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLexerRule=ruleLexerRule 
	 { $current=$iv_ruleLexerRule.current; } 
	 EOF 
;

// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((('native' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::Keyword */, null); 
    }

    |'lexer' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_name=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("LexerRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('returns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("LexerRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_body=RULE_STRING 
	    {
	        if ($current==null) {
	            $current = factory.create("LexerRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "body", lv_body, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleParserRule
entryRuleParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParserRule=ruleParserRule 
	 { $current=$iv_ruleParserRule.current; } 
	 EOF 
;

// Rule ParserRule
ruleParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_name=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)('returns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)(((((	
	
	    lv_definesHiddenTokens='hidden' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "definesHiddenTokens"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "definesHiddenTokens", true, "hidden", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
    }
) 
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
    }
) 
	
)))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_alternatives=ruleAlternatives 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "alternatives", lv_alternatives, "Alternatives", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleTerminalRule
entryRuleTerminalRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalRule=ruleTerminalRule 
	 { $current=$iv_ruleTerminalRule.current; } 
	 EOF 
;

// Rule TerminalRule
ruleTerminalRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((	
	
	    lv_terminal='terminal' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "terminal"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "terminal", true, "terminal", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_name=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('returns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_alternatives=ruleTerminalAlternatives 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "alternatives", lv_alternatives, "TerminalAlternatives", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleTypeRef
entryRuleTypeRef returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTypeRef=ruleTypeRef 
	 { $current=$iv_ruleTypeRef.current; } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("TypeRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "metamodel"); 
    }
) 
	
)'::' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("TypeRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "type"); 
    }
) 
	
));







// Entry rule entryRuleAlternatives
entryRuleAlternatives returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAlternatives=ruleAlternatives 
	 { $current=$iv_ruleAlternatives.current; } 
	 EOF 
;

// Rule Alternatives
ruleAlternatives returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Group=ruleGroup
    { 
        $current = $this_Group.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Alternatives");
        try {
        	factory.add(temp, "groups", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_groups=ruleGroup 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "groups", lv_groups, "Group", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleTerminalAlternatives
entryRuleTerminalAlternatives returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalAlternatives=ruleTerminalAlternatives 
	 { $current=$iv_ruleTerminalAlternatives.current; } 
	 EOF 
;

// Rule TerminalAlternatives
ruleTerminalAlternatives returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalGroup=ruleTerminalGroup
    { 
        $current = $this_TerminalGroup.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Alternatives");
        try {
        	factory.add(temp, "groups", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_groups=ruleTerminalGroup 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "groups", lv_groups, "TerminalGroup", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleGroup
entryRuleGroup returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGroup=ruleGroup 
	 { $current=$iv_ruleGroup.current; } 
	 EOF 
;

// Rule Group
ruleGroup returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractToken=ruleAbstractToken
    { 
        $current = $this_AbstractToken.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Group");
        try {
        	factory.add(temp, "abstractTokens", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_abstractTokens=ruleAbstractToken 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "abstractTokens", lv_abstractTokens, "AbstractToken", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleTerminalGroup
entryRuleTerminalGroup returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalGroup=ruleTerminalGroup 
	 { $current=$iv_ruleTerminalGroup.current; } 
	 EOF 
;

// Rule TerminalGroup
ruleTerminalGroup returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalToken=ruleTerminalToken
    { 
        $current = $this_TerminalToken.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Group");
        try {
        	factory.add(temp, "abstractTokens", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_abstractTokens=ruleTerminalToken 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "abstractTokens", lv_abstractTokens, "TerminalToken", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleAbstractToken
entryRuleAbstractToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractToken=ruleAbstractToken 
	 { $current=$iv_ruleAbstractToken.current; } 
	 EOF 
;

// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Assignment=ruleAssignment
    { 
        $current = $this_Assignment.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Action=ruleAction
    { 
        $current = $this_Action.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractTerminal=ruleAbstractTerminal
    { 
        $current = $this_AbstractTerminal.current; 
        currentNode = currentNode.getParent();
    }
)(	
	
	    lv_cardinality=(('?' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
    }

    |'*' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
)
    |'+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "cardinality", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?);







// Entry rule entryRuleTerminalToken
entryRuleTerminalToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalToken=ruleTerminalToken 
	 { $current=$iv_ruleTerminalToken.current; } 
	 EOF 
;

// Rule TerminalToken
ruleTerminalToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalTokenElement=ruleTerminalTokenElement
    { 
        $current = $this_TerminalTokenElement.current; 
        currentNode = currentNode.getParent();
    }
(	
	
	    lv_cardinality=(('?' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
    }

    |'*' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
)
    |'+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "cardinality", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?);







// Entry rule entryRuleAssignment
entryRuleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAssignment=ruleAssignment 
	 { $current=$iv_ruleAssignment.current; } 
	 EOF 
;

// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_feature=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Assignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_operator=(('+=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
    }
)
    |'?=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Assignment");
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
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_terminal=ruleAbstractTerminal 
	    {
	        if ($current==null) {
	            $current = factory.create("Assignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "terminal", lv_terminal, "AbstractTerminal", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAction=ruleAction 
	 { $current=$iv_ruleAction.current; } 
	 EOF 
;

// Rule Action
ruleAction returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((('{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
('current' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_typeName=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("Action");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "typeName", lv_typeName, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))'.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_feature=RULE_ID 
	    {
	        if ($current==null) {
	            $current = factory.create("Action");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
	    lv_operator=('=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'+=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Action");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "operator", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'current' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleAbstractTerminal
entryRuleAbstractTerminal returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractTerminal=ruleAbstractTerminal 
	 { $current=$iv_ruleAbstractTerminal.current; } 
	 EOF 
;

// Rule AbstractTerminal
ruleAbstractTerminal returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ParenthesizedElement=ruleParenthesizedElement
    { 
        $current = $this_ParenthesizedElement.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_CrossReference=ruleCrossReference
    { 
        $current = $this_CrossReference.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleTerminalTokenElement
entryRuleTerminalTokenElement returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerminalTokenElement=ruleTerminalTokenElement 
	 { $current=$iv_ruleTerminalTokenElement.current; } 
	 EOF 
;

// Rule TerminalTokenElement
ruleTerminalTokenElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_CharacterRange=ruleCharacterRange
    { 
        $current = $this_CharacterRange.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ParenthesizedTerminalElement=ruleParenthesizedTerminalElement
    { 
        $current = $this_ParenthesizedTerminalElement.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractNegatedToken=ruleAbstractNegatedToken
    { 
        $current = $this_AbstractNegatedToken.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Wildcard=ruleWildcard
    { 
        $current = $this_Wildcard.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAbstractNegatedToken
entryRuleAbstractNegatedToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken 
	 { $current=$iv_ruleAbstractNegatedToken.current; } 
	 EOF 
;

// Rule AbstractNegatedToken
ruleAbstractNegatedToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_NegatedToken=ruleNegatedToken
    { 
        $current = $this_NegatedToken.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_UpToToken=ruleUpToToken
    { 
        $current = $this_UpToToken.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleNegatedToken
entryRuleNegatedToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNegatedToken=ruleNegatedToken 
	 { $current=$iv_ruleNegatedToken.current; } 
	 EOF 
;

// Rule NegatedToken
ruleNegatedToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('!' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_terminal=ruleTerminalTokenElement 
	    {
	        if ($current==null) {
	            $current = factory.create("NegatedToken");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleUpToToken
entryRuleUpToToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21" /* xtext::ParserRule */, currentNode); }
	 iv_ruleUpToToken=ruleUpToToken 
	 { $current=$iv_ruleUpToToken.current; } 
	 EOF 
;

// Rule UpToToken
ruleUpToToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('->' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_terminal=ruleTerminalTokenElement 
	    {
	        if ($current==null) {
	            $current = factory.create("UpToToken");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleWildcard
entryRuleWildcard returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.22" /* xtext::ParserRule */, currentNode); }
	 iv_ruleWildcard=ruleWildcard 
	 { $current=$iv_ruleWildcard.current; } 
	 EOF 
;

// Rule Wildcard
ruleWildcard returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    lv_isWildcard='.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.22/@alternatives/@terminal" /* xtext::Keyword */, "isWildcard"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Wildcard");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "isWildcard", true, ".", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleCharacterRange
entryRuleCharacterRange returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCharacterRange=ruleCharacterRange 
	 { $current=$iv_ruleCharacterRange.current; } 
	 EOF 
;

// Rule CharacterRange
ruleCharacterRange returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("CharacterRange");
        try {
        	factory.set(temp, "left", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'..' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_right=ruleKeyword 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractElement");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "right", lv_right, "Keyword", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?);







// Entry rule entryRuleCrossReference
entryRuleCrossReference returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCrossReference=ruleCrossReference 
	 { $current=$iv_ruleCrossReference.current; } 
	 EOF 
;

// Rule CrossReference
ruleCrossReference returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("CrossReference");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("CrossReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rule"); 
    }
) 
	
))?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleParenthesizedElement
entryRuleParenthesizedElement returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParenthesizedElement=ruleParenthesizedElement 
	 { $current=$iv_ruleParenthesizedElement.current; } 
	 EOF 
;

// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Alternatives=ruleAlternatives
    { 
        $current = $this_Alternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleParenthesizedTerminalElement
entryRuleParenthesizedTerminalElement returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement 
	 { $current=$iv_ruleParenthesizedTerminalElement.current; } 
	 EOF 
;

// Rule ParenthesizedTerminalElement
ruleParenthesizedTerminalElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TerminalAlternatives=ruleTerminalAlternatives
    { 
        $current = $this_TerminalAlternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleKeyword
entryRuleKeyword returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.27" /* xtext::ParserRule */, currentNode); }
	 iv_ruleKeyword=ruleKeyword 
	 { $current=$iv_ruleKeyword.current; } 
	 EOF 
;

// Rule Keyword
ruleKeyword returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.27/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_value=RULE_STRING 
	    {
	        if ($current==null) {
	            $current = factory.create("Keyword");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
);







// Entry rule entryRuleRuleCall
entryRuleRuleCall returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.28" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRuleCall=ruleRuleCall 
	 { $current=$iv_ruleRuleCall.current; } 
	 EOF 
;

// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("RuleCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.28/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
    }
) 
	
);



















































































RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



RULE_INT : ('0'..'9')+;



RULE_STRING : ('"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'"')|'\'')|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



RULE_ML_COMMENT : '/*' ~('*/')*'*/';



RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



RULE_WS : (((' '|'\t')|'\r')|'\n')+;



RULE_ANY_OTHER : .;




