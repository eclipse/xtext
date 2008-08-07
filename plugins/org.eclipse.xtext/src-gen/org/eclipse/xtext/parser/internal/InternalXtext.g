
/*
Generated with Xtext
*/
grammar InternalXtext;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

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
 
    public InternalXtextParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalXtextParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/internal/InternalXtext.tokens");
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGrammar=ruleGrammar 
	 { $current=$iv_ruleGrammar.current; } 
	 EOF 
;

// Rule Grammar
ruleGrammar returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((((
    lv_abstract='abstract language' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "abstract", true,"abstract language");
        
         }
)
    |'language' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
    }
)(
    lv_idElements=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "idElements", lv_idElements,"ID");
        
         }
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_idElements=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "idElements", lv_idElements,"ID");
        
         }
))*)(('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_superGrammarIdElements=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");
        
         }
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_superGrammarIdElements=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");
        
         }
))*)?)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations,null);
        
         }
)*)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_parserRules=ruleParserRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "parserRules", lv_parserRules,null);
        
         }
)*)(('lexing' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_lexerRules=ruleLexerRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "lexerRules", lv_lexerRules,null);
        
         }
)+)?);
    




// Entry rule entryRuleAbstractMetamodelDeclaration
entryRuleAbstractMetamodelDeclaration returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_GeneratedMetamodel=ruleGeneratedMetamodel
    { 
        $current = $this_GeneratedMetamodel.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ReferencedMetamodel=ruleReferencedMetamodel
    { 
        $current = $this_ReferencedMetamodel.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleGeneratedMetamodel
entryRuleGeneratedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
))(
    lv_nsURI=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "nsURI"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "nsURI", lv_nsURI,"STRING");
        
         }
))('as' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_alias=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "alias", lv_alias,"ID");
        
         }
))?);
    


// Entry rule entryRuleReferencedMetamodel
entryRuleReferencedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_uri=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ReferencedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "uri", lv_uri,"STRING");
        
         }
))('as' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_alias=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ReferencedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "alias", lv_alias,"ID");
        
         }
))?);
    


// Entry rule entryRuleLexerRule
entryRuleLexerRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLexerRule=ruleLexerRule 
	 { $current=$iv_ruleLexerRule.current; } 
	 EOF 
;

// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
)('returns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_type=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "type", lv_type,null);
        
         }
))?)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    lv_body=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "body"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "body", lv_body,"STRING");
        
         }
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleParserRule
entryRuleParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParserRule=ruleParserRule 
	 { $current=$iv_ruleParserRule.current; } 
	 EOF 
;

// Rule ParserRule
ruleParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
)('returns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_type=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "type", lv_type,null);
        
         }
))?)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_alternatives=ruleAlternatives 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "alternatives", lv_alternatives,null);
        
         }
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleTypeRef
entryRuleTypeRef returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTypeRef=ruleTypeRef 
	 { $current=$iv_ruleTypeRef.current; } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((
    lv_alias=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TypeRef");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "alias", lv_alias,"ID");
        
         }
)'::' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TypeRef");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
));
    


// Entry rule entryRuleAlternatives
entryRuleAlternatives returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Group=ruleGroup
    { 
        $current = $this_Group.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Alternatives");
        factory.add(temp, "groups",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_groups=ruleGroup 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "groups", lv_groups,null);
        
         }
))*);
    


// Entry rule entryRuleGroup
entryRuleGroup returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractToken=ruleAbstractToken
    { 
        $current = $this_AbstractToken.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Group");
        factory.add(temp, "abstractTokens",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_abstractTokens=ruleAbstractToken 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "abstractTokens", lv_abstractTokens,null);
        
         }
))*);
    


// Entry rule entryRuleAbstractToken
entryRuleAbstractToken returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Assignment=ruleAssignment
    { 
        $current = $this_Assignment.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Action=ruleAction
    { 
        $current = $this_Action.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractTerminal=ruleAbstractTerminal
    { 
        $current = $this_AbstractTerminal.current; 
        currentNode = currentNode.getParent();
    }
)(
    lv_cardinality=(('?' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
    }

    |'*' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
)
    |'+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
    }
) 
    {
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "cardinality", input.LT(-1),null);
        
         }
)?);
    


// Entry rule entryRuleAssignment
entryRuleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAssignment=ruleAssignment 
	 { $current=$iv_ruleAssignment.current; } 
	 EOF 
;

// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((
    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "feature", lv_feature,"ID");
        
         }
)(
    lv_operator=(('+=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
    }
)
    |'?=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
    {
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "operator", input.LT(-1),null);
        
         }
))(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_terminal=ruleAbstractTerminal 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "terminal", lv_terminal,null);
        
         }
));
    


// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
('current' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_typeName=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "typeName", lv_typeName,null);
        
         }
))'.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "feature", lv_feature,"ID");
        
         }
))(
    lv_operator=('=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
    }

    |'+=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
    }
) 
    {
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "operator", input.LT(-1),null);
        
         }
))'current' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleAbstractTerminal
entryRuleAbstractTerminal returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ParenthesizedElement=ruleParenthesizedElement
    { 
        $current = $this_ParenthesizedElement.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.13/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_CrossReference=ruleCrossReference
    { 
        $current = $this_CrossReference.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleCrossReference
entryRuleCrossReference returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_type=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("CrossReference");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "type", lv_type,null);
        
         }
))('|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_rule=ruleRuleCall 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("CrossReference");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "rule", lv_rule,null);
        
         }
))?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleParenthesizedElement
entryRuleParenthesizedElement returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.15" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.15/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.15/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Alternatives=ruleAlternatives
    { 
        $current = $this_Alternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.15/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleKeyword
entryRuleKeyword returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.16" /* xtext::ParserRule */, currentNode); }
	 iv_ruleKeyword=ruleKeyword 
	 { $current=$iv_ruleKeyword.current; } 
	 EOF 
;

// Rule Keyword
ruleKeyword returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_value=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.16/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Keyword");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "value", lv_value,"STRING");
        
         }
);
    


// Entry rule entryRuleRuleCall
entryRuleRuleCall returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.17" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRuleCall=ruleRuleCall 
	 { $current=$iv_ruleRuleCall.current; } 
	 EOF 
;

// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@parserRules.17/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("RuleCall");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


