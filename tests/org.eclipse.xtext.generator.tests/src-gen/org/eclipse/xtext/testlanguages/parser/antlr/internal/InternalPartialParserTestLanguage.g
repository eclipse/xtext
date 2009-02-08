/*
Generated with Xtext
*/
grammar InternalPartialParserTestLanguage;

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
 
    public InternalPartialParserTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalPartialParserTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Container";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleContainer
entryRuleContainer returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleContainer=ruleContainer 
	 { $current=$iv_ruleContainer.current; } 
	 EOF 
;

// Rule Container
ruleContainer returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('container' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Container");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_nested=ruleNested 
	    {
	        if ($current==null) {
	            $current = factory.create("Container");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "nested", lv_nested, "Nested", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_content=ruleContent 
	    {
	        if ($current==null) {
	            $current = factory.create("Container");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "content", lv_content, "Content", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleNested
entryRuleNested returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNested=ruleNested 
	 { $current=$iv_ruleNested.current; } 
	 EOF 
;

// Rule Nested
ruleNested returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('nested' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_nested=ruleContainer 
	    {
	        if ($current==null) {
	            $current = factory.create("Nested");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "nested", lv_nested, "Container", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)+)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleContent
entryRuleContent returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleContent=ruleContent 
	 { $current=$iv_ruleContent.current; } 
	 EOF 
;

// Rule Content
ruleContent returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Children=ruleChildren
    { 
        $current = $this_Children.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractChildren=ruleAbstractChildren
    { 
        $current = $this_AbstractChildren.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleChildren
entryRuleChildren returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleChildren=ruleChildren 
	 { $current=$iv_ruleChildren.current; } 
	 EOF 
;

// Rule Children
ruleChildren returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('children' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_children=ruleChild 
	    {
	        if ($current==null) {
	            $current = factory.create("Children");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "children", lv_children, "Child", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_children=ruleChild 
	    {
	        if ($current==null) {
	            $current = factory.create("Children");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "children", lv_children, "Child", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleChild
entryRuleChild returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleChild=ruleChild 
	 { $current=$iv_ruleChild.current; } 
	 EOF 
;

// Rule Child
ruleChild returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('->' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'C' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_value=ruleNamed 
	    {
	        if ($current==null) {
	            $current = factory.create("Child");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "Named", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleAbstractChildren
entryRuleAbstractChildren returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractChildren=ruleAbstractChildren 
	 { $current=$iv_ruleAbstractChildren.current; } 
	 EOF 
;

// Rule AbstractChildren
ruleAbstractChildren returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('abstract children' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_abstractChildren=ruleAbstractChild 
	    {
	        if ($current==null) {
	            $current = factory.create("AbstractChildren");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "abstractChildren", lv_abstractChildren, "AbstractChild", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)+)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleAbstractChild
entryRuleAbstractChild returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAbstractChild=ruleAbstractChild 
	 { $current=$iv_ruleAbstractChild.current; } 
	 EOF 
;

// Rule AbstractChild
ruleAbstractChild returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_FirstConcrete=ruleFirstConcrete
    { 
        $current = $this_FirstConcrete.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_SecondConcrete=ruleSecondConcrete
    { 
        $current = $this_SecondConcrete.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleFirstConcrete
entryRuleFirstConcrete returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFirstConcrete=ruleFirstConcrete 
	 { $current=$iv_ruleFirstConcrete.current; } 
	 EOF 
;

// Rule FirstConcrete
ruleFirstConcrete returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((('->' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'F' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_value=ruleNamed 
	    {
	        if ($current==null) {
	            $current = factory.create("FirstConcrete");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "Named", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("FirstConcrete");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedContainer"); 
    }
) 
	
)?)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleSecondConcrete
entryRuleSecondConcrete returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSecondConcrete=ruleSecondConcrete 
	 { $current=$iv_ruleSecondConcrete.current; } 
	 EOF 
;

// Rule SecondConcrete
ruleSecondConcrete returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((('->' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'F' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'S' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_value=ruleNamed 
	    {
	        if ($current==null) {
	            $current = factory.create("SecondConcrete");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "Named", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("SecondConcrete");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedChildren"); 
    }
) 
	
)?)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleNamed
entryRuleNamed returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNamed=ruleNamed 
	 { $current=$iv_ruleNamed.current; } 
	 EOF 
;

// Rule Named
ruleNamed returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Named");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
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


