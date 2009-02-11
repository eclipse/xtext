/*
Generated with Xtext
*/
grammar InternalEpatchTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.epatch.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.epatch.parser.antlr.internal; 

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
 
    public InternalEpatchTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalEpatchTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "EPatch";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleEPatch
entryRuleEPatch returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEPatch=ruleEPatch 
	 { $current=$iv_ruleEPatch.current; } 
	 EOF 
;

// Rule EPatch
ruleEPatch returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((('epatch' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EPatch");
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_imports=ruleImport 
	    {
	        if ($current==null) {
	            $current = factory.create("EPatch");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "imports", lv_imports, "Import", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_resources=ruleNamedResource 
	    {
	        if ($current==null) {
	            $current = factory.create("EPatch");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "resources", lv_resources, "NamedResource", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_objects=ruleObjectRef 
	    {
	        if ($current==null) {
	            $current = factory.create("EPatch");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "objects", lv_objects, "ObjectRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ModelImport=ruleModelImport
    { 
        $current = $this_ModelImport.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_JavaImport=ruleJavaImport
    { 
        $current = $this_JavaImport.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ExtensionImport=ruleExtensionImport
    { 
        $current = $this_ExtensionImport.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleModelImport
entryRuleModelImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleModelImport=ruleModelImport 
	 { $current=$iv_ruleModelImport.current; } 
	 EOF 
;

// Rule ModelImport
ruleModelImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ResourceImport=ruleResourceImport
    { 
        $current = $this_ResourceImport.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_EPackageImport=ruleEPackageImport
    { 
        $current = $this_EPackageImport.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleResourceImport
entryRuleResourceImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleResourceImport=ruleResourceImport 
	 { $current=$iv_ruleResourceImport.current; } 
	 EOF 
;

// Rule ResourceImport
ruleResourceImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ResourceImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'uri' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_uri=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ResourceImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "uri", lv_uri, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleEPackageImport
entryRuleEPackageImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEPackageImport=ruleEPackageImport 
	 { $current=$iv_ruleEPackageImport.current; } 
	 EOF 
;

// Rule EPackageImport
ruleEPackageImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackageImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'ns' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_nsURI=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "nsURI"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackageImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "nsURI", lv_nsURI, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleJavaImport
entryRuleJavaImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleJavaImport=ruleJavaImport 
	 { $current=$iv_ruleJavaImport.current; } 
	 EOF 
;

// Rule JavaImport
ruleJavaImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'java' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("JavaImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "path", lv_path, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("JavaImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "path", lv_path, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);







// Entry rule entryRuleExtensionImport
entryRuleExtensionImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleExtensionImport=ruleExtensionImport 
	 { $current=$iv_ruleExtensionImport.current; } 
	 EOF 
;

// Rule ExtensionImport
ruleExtensionImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'extension' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ExtensionImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "path", lv_path, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('::' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "path"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ExtensionImport");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "path", lv_path, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);







// Entry rule entryRuleNamedResource
entryRuleNamedResource returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNamedResource=ruleNamedResource 
	 { $current=$iv_ruleNamedResource.current; } 
	 EOF 
;

// Rule NamedResource
ruleNamedResource returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((('resource' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("NamedResource");
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'left' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(('uri' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_leftUri=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftUri"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("NamedResource");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "leftUri", lv_leftUri, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftRoot=ruleCreatedObject 
	    {
	        if ($current==null) {
	            $current = factory.create("NamedResource");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "leftRoot", lv_leftRoot, "CreatedObject", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'right' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(('uri' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_rightUri=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "rightUri"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("NamedResource");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "rightUri", lv_rightUri, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rightRoot=ruleCreatedObject 
	    {
	        if ($current==null) {
	            $current = factory.create("NamedResource");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "rightRoot", lv_rightRoot, "CreatedObject", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);









// Entry rule entryRuleObjectRef
entryRuleObjectRef returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleObjectRef=ruleObjectRef 
	 { $current=$iv_ruleObjectRef.current; } 
	 EOF 
;

// Rule ObjectRef
ruleObjectRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('object' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "leftRes"); 
    }
) 
	
)(	
	
	    lv_leftFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "leftFrag", lv_leftFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((((('left' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "leftRes"); 
    }
) 
	
))(	
	
	    lv_leftFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "leftFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "leftFrag", lv_leftFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'right' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rightRes"); 
    }
) 
	
))(	
	
	    lv_rightFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "rightFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "rightFrag", lv_rightFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))))(((('{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_assignments=ruleBiSingleAssignment 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "assignments", lv_assignments, "BiSingleAssignment", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_assignments=ruleBiListAssignment 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "assignments", lv_assignments, "BiListAssignment", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))+)('left' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftMig=ruleMigration 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "leftMig", lv_leftMig, "Migration", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)('right' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rightMig=ruleMigration 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectRef");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "rightMig", lv_rightMig, "Migration", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?);









// Entry rule entryRuleBiSingleAssignment
entryRuleBiSingleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleBiSingleAssignment=ruleBiSingleAssignment 
	 { $current=$iv_ruleBiSingleAssignment.current; } 
	 EOF 
;

// Rule BiSingleAssignment
ruleBiSingleAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("SingleAssignment");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValue=ruleSingleAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("SingleAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "leftValue", lv_leftValue, "SingleAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))'|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rightValue=ruleSingleAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("SingleAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "rightValue", lv_rightValue, "SingleAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleBiListAssignment
entryRuleBiListAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleBiListAssignment=ruleBiListAssignment 
	 { $current=$iv_ruleBiListAssignment.current; } 
	 EOF 
;

// Rule BiListAssignment
ruleBiListAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValues=ruleListAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "leftValues", lv_leftValues, "ListAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValues=ruleListAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "leftValues", lv_leftValues, "ListAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)'|' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rightValues=ruleListAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "rightValues", lv_rightValues, "ListAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_rightValues=ruleListAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "rightValues", lv_rightValues, "ListAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleMonoSingleAssignment
entryRuleMonoSingleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.13" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment 
	 { $current=$iv_ruleMonoSingleAssignment.current; } 
	 EOF 
;

// Rule MonoSingleAssignment
ruleMonoSingleAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("SingleAssignment");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValue=ruleSingleAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("SingleAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "leftValue", lv_leftValue, "SingleAssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleMonoListAssignment
entryRuleMonoListAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMonoListAssignment=ruleMonoListAssignment 
	 { $current=$iv_ruleMonoListAssignment.current; } 
	 EOF 
;

// Rule MonoListAssignment
ruleMonoListAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValues=ruleAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "leftValues", lv_leftValues, "AssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftValues=ruleAssignmentValue 
	    {
	        if ($current==null) {
	            $current = factory.create("ListAssignment");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "leftValues", lv_leftValues, "AssignmentValue", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleAssignmentValue
entryRuleAssignmentValue returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAssignmentValue=ruleAssignmentValue 
	 { $current=$iv_ruleAssignmentValue.current; } 
	 EOF 
;

// Rule AssignmentValue
ruleAssignmentValue returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((	
	
	    lv_value=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refFeature", lv_refFeature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refIndex", lv_refIndex, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_newObject=ruleCreatedObject 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "newObject", lv_newObject, "CreatedObject", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.15/@alternatives/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)));







// Entry rule entryRuleListAssignmentValue
entryRuleListAssignmentValue returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16" /* xtext::ParserRule */, currentNode); }
	 iv_ruleListAssignmentValue=ruleListAssignmentValue 
	 { $current=$iv_ruleListAssignmentValue.current; } 
	 EOF 
;

// Rule ListAssignmentValue
ruleListAssignmentValue returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
	    lv_index=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "index"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "index", lv_index, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(((((('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refIndex", lv_refIndex, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)
    |(	
	
	    lv_value=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refFeature", lv_refFeature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refIndex", lv_refIndex, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_newObject=ruleCreatedObject 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "newObject", lv_newObject, "CreatedObject", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))));







// Entry rule entryRuleSingleAssignmentValue
entryRuleSingleAssignmentValue returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue 
	 { $current=$iv_ruleSingleAssignmentValue.current; } 
	 EOF 
;

// Rule SingleAssignmentValue
ruleSingleAssignmentValue returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((	
	
	    lv_keyword='null' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::Keyword */, "keyword"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "keyword", input.LT(-1), "null", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_value=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refFeature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refFeature", lv_refFeature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "refIndex"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "refIndex", lv_refIndex, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_newObject=ruleCreatedObject 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "newObject", lv_newObject, "CreatedObject", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("AssignmentValue");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)));







// Entry rule entryRuleCreatedObject
entryRuleCreatedObject returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCreatedObject=ruleCreatedObject 
	 { $current=$iv_ruleCreatedObject.current; } 
	 EOF 
;

// Rule CreatedObject
ruleCreatedObject returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_ObjectNew=ruleObjectNew
    { 
        $current = $this_ObjectNew.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ObjectCopy=ruleObjectCopy
    { 
        $current = $this_ObjectCopy.current; 
        currentNode = currentNode.getParent();
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("CreatedObject");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)((('{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_assignments=ruleMonoSingleAssignment 
	    {
	        if ($current==null) {
	            $current = factory.create("CreatedObject");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "assignments", lv_assignments, "MonoSingleAssignment", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_assignments=ruleMonoListAssignment 
	    {
	        if ($current==null) {
	            $current = factory.create("CreatedObject");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "assignments", lv_assignments, "MonoListAssignment", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))+)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_leftMig=ruleMigration 
	    {
	        if ($current==null) {
	            $current = factory.create("CreatedObject");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "leftMig", lv_leftMig, "Migration", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)?)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.18/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?);







// Entry rule entryRuleObjectNew
entryRuleObjectNew returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.19" /* xtext::ParserRule */, currentNode); }
	 iv_ruleObjectNew=ruleObjectNew 
	 { $current=$iv_ruleObjectNew.current; } 
	 EOF 
;

// Rule ObjectNew
ruleObjectNew returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('new' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ObjectNew");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "import"); 
    }
) 
	
))(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.19/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "impFrag"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectNew");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "impFrag", lv_impFrag, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleObjectCopy
entryRuleObjectCopy returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.20" /* xtext::ParserRule */, currentNode); }
	 iv_ruleObjectCopy=ruleObjectCopy 
	 { $current=$iv_ruleObjectCopy.current; } 
	 EOF 
;

// Rule ObjectCopy
ruleObjectCopy returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('copy' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.20/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ObjectCopy");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.20/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "resource"); 
    }
) 
	
))(	
	
	    lv_fragment=RULE_FRAGMENT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "fragment"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ObjectCopy");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "fragment", lv_fragment, "FRAGMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleMigration
entryRuleMigration returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMigration=ruleMigration 
	 { $current=$iv_ruleMigration.current; } 
	 EOF 
;

// Rule Migration
ruleMigration returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('migrate' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_first=ruleExecutable 
	    {
	        if ($current==null) {
	            $current = factory.create("Migration");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "first", lv_first, "Executable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)?)(('as' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_asOp=ruleExecutable 
	    {
	        if ($current==null) {
	            $current = factory.create("Migration");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "asOp", lv_asOp, "Executable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |('each' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eachOp=ruleExecutable 
	    {
	        if ($current==null) {
	            $current = factory.create("Migration");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eachOp", lv_eachOp, "Executable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))?)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.22/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleExecutable
entryRuleExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.23" /* xtext::ParserRule */, currentNode); }
	 iv_ruleExecutable=ruleExecutable 
	 { $current=$iv_ruleExecutable.current; } 
	 EOF 
;

// Rule Executable
ruleExecutable returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.23/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_JavaExecutable=ruleJavaExecutable
    { 
        $current = $this_JavaExecutable.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.23/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ExpressionExecutable=ruleExpressionExecutable
    { 
        $current = $this_ExpressionExecutable.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleJavaExecutable
entryRuleJavaExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.24" /* xtext::ParserRule */, currentNode); }
	 iv_ruleJavaExecutable=ruleJavaExecutable 
	 { $current=$iv_ruleJavaExecutable.current; } 
	 EOF 
;

// Rule JavaExecutable
ruleJavaExecutable returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('java' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_method=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "method"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("JavaExecutable");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "method", lv_method, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleExpressionExecutable
entryRuleExpressionExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.25" /* xtext::ParserRule */, currentNode); }
	 iv_ruleExpressionExecutable=ruleExpressionExecutable 
	 { $current=$iv_ruleExpressionExecutable.current; } 
	 EOF 
;

// Rule ExpressionExecutable
ruleExpressionExecutable returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_exprstr=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi#/0/@rules.25/@alternatives/@terminal" /* xtext::RuleCall */, "exprstr"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ExpressionExecutable");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "exprstr", lv_exprstr, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);

























































RULE_FRAGMENT : '#' ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'['|']'|'{'|'}'|'.'|'@')+;

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


