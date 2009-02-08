/*
Generated with Xtext
*/
grammar InternalEcoreDsl;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.example.parser.antlr.internal; 

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
 
    public InternalEcoreDslParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalEcoreDslParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "EcoreDsl";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleEcoreDsl
entryRuleEcoreDsl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEcoreDsl=ruleEcoreDsl 
	 { $current=$iv_ruleEcoreDsl.current; } 
	 EOF 
;

// Rule EcoreDsl
ruleEcoreDsl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_imports=ruleImportStatementDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EcoreDsl");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "imports", lv_imports, "ImportStatementDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_package=ruleEPackageDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EcoreDsl");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "package", lv_package, "EPackageDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleImportStatementDecl
entryRuleImportStatementDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleImportStatementDecl=ruleImportStatementDecl 
	 { $current=$iv_ruleImportStatementDecl.current; } 
	 EOF 
;

// Rule ImportStatementDecl
ruleImportStatementDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
((	
	
	    lv_alias=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "alias"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ImportStatementDecl");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "alias", lv_alias, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(	
	
	    lv_importURI=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "importURI"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ImportStatementDecl");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "importURI", lv_importURI, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEPackageDecl
entryRuleEPackageDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEPackageDecl=ruleEPackageDecl 
	 { $current=$iv_ruleEPackageDecl.current; } 
	 EOF 
;

// Rule EPackageDecl
ruleEPackageDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*'package' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_name=ruleQID 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "QID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))'nsURI' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_nsURI=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "nsURI"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "nsURI", lv_nsURI, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'nsPrefix' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_nsPrefix=ruleQID 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "nsPrefix", lv_nsPrefix, "QID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eSubpackages=ruleSubEPackageDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eSubpackages", lv_eSubpackages, "SubEPackageDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eClassifiers=ruleEClassifierDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eClassifiers", lv_eClassifiers, "EClassifierDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleSubEPackageDecl
entryRuleSubEPackageDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSubEPackageDecl=ruleSubEPackageDecl 
	 { $current=$iv_ruleSubEPackageDecl.current; } 
	 EOF 
;

// Rule SubEPackageDecl
ruleSubEPackageDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*'package' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
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
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eSubpackages=ruleSubEPackageDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eSubpackages", lv_eSubpackages, "SubEPackageDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eClassifiers=ruleEClassifierDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EPackage");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eClassifiers", lv_eClassifiers, "EClassifierDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEClassifierDecl
entryRuleEClassifierDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEClassifierDecl=ruleEClassifierDecl 
	 { $current=$iv_ruleEClassifierDecl.current; } 
	 EOF 
;

// Rule EClassifierDecl
ruleEClassifierDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.4/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_EClassDecl=ruleEClassDecl
    { 
        $current = $this_EClassDecl.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.4/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_EDataTypeDecl=ruleEDataTypeDecl
    { 
        $current = $this_EDataTypeDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEDataTypeDecl
entryRuleEDataTypeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEDataTypeDecl=ruleEDataTypeDecl 
	 { $current=$iv_ruleEDataTypeDecl.current; } 
	 EOF 
;

// Rule EDataTypeDecl
ruleEDataTypeDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EDataType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    lv_serializable='!serializable' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "serializable"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EDataType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "serializable", true, "!serializable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(((('datatype' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EDataType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_instanceClassName=ruleSTRING_OR_QID 
	    {
	        if ($current==null) {
	            $current = factory.create("EDataType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "instanceClassName", lv_instanceClassName, "STRING_OR_QID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
))
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.5/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_EEnumDecl=ruleEEnumDecl
    { 
        $current = $this_EEnumDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEAnnotationDecl
entryRuleEAnnotationDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEAnnotationDecl=ruleEAnnotationDecl 
	 { $current=$iv_ruleEAnnotationDecl.current; } 
	 EOF 
;

// Rule EAnnotationDecl
ruleEAnnotationDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((('@' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_source=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "source"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAnnotation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "source", lv_source, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EAnnotation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "eModelElement"); 
    }
) 
	
)?)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_contents=ruleMapEntrySuper 
	    {
	        if ($current==null) {
	            $current = factory.create("EAnnotation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "contents", lv_contents, "MapEntrySuper", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_contents=ruleMapEntrySuper 
	    {
	        if ($current==null) {
	            $current = factory.create("EAnnotation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "contents", lv_contents, "MapEntrySuper", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEClassDecl
entryRuleEClassDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEClassDecl=ruleEClassDecl 
	 { $current=$iv_ruleEClassDecl.current; } 
	 EOF 
;

// Rule EClassDecl
ruleEClassDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    lv_abstract='abstract' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "abstract"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "abstract", true, "abstract", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)((	
	
	    lv_interface='interface' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::Keyword */, "interface"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "interface", true, "interface", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |'class' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1" /* xtext::Keyword */, null); 
    }
))(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))((('<' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeParameters=ruleETypeParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeParameters=ruleETypeParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'>' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericSuperTypes=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eGenericSuperTypes", lv_eGenericSuperTypes, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericSuperTypes=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eGenericSuperTypes", lv_eGenericSuperTypes, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)(':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_instanceClassName=ruleSTRING_OR_QID 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "instanceClassName", lv_instanceClassName, "STRING_OR_QID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eStructuralFeatures=ruleEStructuralFeatureDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eStructuralFeatures", lv_eStructuralFeatures, "EStructuralFeatureDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eOperations=ruleEOperationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EClass");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eOperations", lv_eOperations, "EOperationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEStructuralFeatureDecl
entryRuleEStructuralFeatureDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl 
	 { $current=$iv_ruleEStructuralFeatureDecl.current; } 
	 EOF 
;

// Rule EStructuralFeatureDecl
ruleEStructuralFeatureDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.8/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_EAttributeDecl=ruleEAttributeDecl
    { 
        $current = $this_EAttributeDecl.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.8/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_EReferenceDecl=ruleEReferenceDecl
    { 
        $current = $this_EReferenceDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEAttributeDecl
entryRuleEAttributeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEAttributeDecl=ruleEAttributeDecl 
	 { $current=$iv_ruleEAttributeDecl.current; } 
	 EOF 
;

// Rule EAttributeDecl
ruleEAttributeDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*((((((((	
	
	    lv_iD='ID' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::Keyword */, "iD"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "iD", true, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_unique='bag' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "unique"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "unique", true, "bag", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_ordered='random' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "ordered"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "ordered", true, "random", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_changeable='readonly' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "changeable"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "changeable", true, "readonly", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_volatile='volatile' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "volatile"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "volatile", true, "volatile", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_transient='transient' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "transient"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "transient", true, "transient", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_unsettable='unsettable' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "unsettable"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "unsettable", true, "unsettable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_derived='derived' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::Keyword */, "derived"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "derived", true, "derived", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*)'attr' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericType=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))((('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_lowerBound=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "lowerBound"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "lowerBound", lv_lowerBound, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('..' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_upperBound=ruleSINT 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "upperBound", lv_upperBound, "SINT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_defaultValueLiteral=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "defaultValueLiteral"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EAttribute");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "defaultValueLiteral", lv_defaultValueLiteral, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.9/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEReferenceDecl
entryRuleEReferenceDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEReferenceDecl=ruleEReferenceDecl 
	 { $current=$iv_ruleEReferenceDecl.current; } 
	 EOF 
;

// Rule EReferenceDecl
ruleEReferenceDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*((((((((	
	
	    lv_resolveProxies='local' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::Keyword */, "resolveProxies"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "resolveProxies", true, "local", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_unique='bag' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "unique"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "unique", true, "bag", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_ordered='random' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "ordered"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "ordered", true, "random", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_changeable='readonly' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "changeable"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "changeable", true, "readonly", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_volatile='volatile' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "volatile"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "volatile", true, "volatile", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_transient='transient' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "transient"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "transient", true, "transient", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_unsettable='unsettable' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "unsettable"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "unsettable", true, "unsettable", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_derived='derived' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::Keyword */, "derived"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "derived", true, "derived", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*)((	
	
	    lv_containment='val' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::Keyword */, "containment"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "containment", true, "val", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |'ref' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1" /* xtext::Keyword */, null); 
    }
))(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericType=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))((('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_lowerBound=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "lowerBound"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "lowerBound", lv_lowerBound, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('..' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_upperBound=ruleSINT 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "upperBound", lv_upperBound, "SINT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)('#' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "eOpposite"); 
    }
) 
	
))?)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EReference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.10/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEEnumDecl
entryRuleEEnumDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEEnumDecl=ruleEEnumDecl 
	 { $current=$iv_ruleEEnumDecl.current; } 
	 EOF 
;

// Rule EEnumDecl
ruleEEnumDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnum");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*'enum' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnum");
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
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eLiterals=ruleEEnumLiteralDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnum");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eLiterals", lv_eLiterals, "EEnumLiteralDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)+)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.11/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEEnumLiteralDecl
entryRuleEEnumLiteralDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl 
	 { $current=$iv_ruleEEnumLiteralDecl.current; } 
	 EOF 
;

// Rule EEnumLiteralDecl
ruleEEnumLiteralDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnumLiteral");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnumLiteral");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_value=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnumLiteral");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?)(	
	
	    lv_literal=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "literal"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EEnumLiteral");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "literal", lv_literal, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleETypeParameterDecl
entryRuleETypeParameterDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); }
	 iv_ruleETypeParameterDecl=ruleETypeParameterDecl 
	 { $current=$iv_ruleETypeParameterDecl.current; } 
	 EOF 
;

// Rule ETypeParameterDecl
ruleETypeParameterDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.13/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ETypeParameter");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.13/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.13/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eBounds=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("ETypeParameter");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eBounds", lv_eBounds, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))?);







// Entry rule entryRuleEGenericTypeReferenceDecl
entryRuleEGenericTypeReferenceDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl 
	 { $current=$iv_ruleEGenericTypeReferenceDecl.current; } 
	 EOF 
;

// Rule EGenericTypeReferenceDecl
ruleEGenericTypeReferenceDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "eClassifier"); 
    }
) 
	
)((('<' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeArguments=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeArguments=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'>' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)
    |('#' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.14/@alternatives/@groups.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "eTypeParameter"); 
    }
) 
	
)));







// Entry rule entryRuleEGenericTypeDecl
entryRuleEGenericTypeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl 
	 { $current=$iv_ruleEGenericTypeDecl.current; } 
	 EOF 
;

// Rule EGenericTypeDecl
ruleEGenericTypeDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "eClassifier"); 
    }
) 
	
)((('<' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeArguments=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeArguments=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeArguments", lv_eTypeArguments, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'>' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)
    |('#' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.0/@groups.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "eTypeParameter"); 
    }
) 
	
)))
    |('?' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.1/@groups.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eUpperBound=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eUpperBound", lv_eUpperBound, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |('super' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.1/@groups.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.15/@alternatives/@groups.1/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eLowerBound=ruleEGenericTypeDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EGenericType");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eLowerBound", lv_eLowerBound, "EGenericTypeDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))));







// Entry rule entryRuleEOperationDecl
entryRuleEOperationDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEOperationDecl=ruleEOperationDecl 
	 { $current=$iv_ruleEOperationDecl.current; } 
	 EOF 
;

// Rule EOperationDecl
ruleEOperationDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((((((((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*((	
	
	    lv_unique='bag' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::Keyword */, "unique"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "unique", true, "bag", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_ordered='random' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::Keyword */, "ordered"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "ordered", true, "random", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*)'op' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericType=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |'void' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1" /* xtext::Keyword */, null); 
    }
))(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))((('<' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeParameters=ruleETypeParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eTypeParameters=ruleETypeParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eTypeParameters", lv_eTypeParameters, "ETypeParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'>' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)?)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eParameters=ruleEParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eParameters", lv_eParameters, "EParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eParameters=ruleEParameterDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eParameters", lv_eParameters, "EParameterDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(('throws' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericExceptions=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eGenericExceptions", lv_eGenericExceptions, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericExceptions=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EOperation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eGenericExceptions", lv_eGenericExceptions, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.16/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);







// Entry rule entryRuleEParameterDecl
entryRuleEParameterDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.17" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEParameterDecl=ruleEParameterDecl 
	 { $current=$iv_ruleEParameterDecl.current; } 
	 EOF 
;

// Rule EParameterDecl
ruleEParameterDecl returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.17/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eAnnotations=ruleEAnnotationDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EParameter");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "eAnnotations", lv_eAnnotations, "EAnnotationDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.17/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_eGenericType=ruleEGenericTypeReferenceDecl 
	    {
	        if ($current==null) {
	            $current = factory.create("EParameter");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "eGenericType", lv_eGenericType, "EGenericTypeReferenceDecl", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.17/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("EParameter");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleMapEntrySuper
entryRuleMapEntrySuper returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.18" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMapEntrySuper=ruleMapEntrySuper 
	 { $current=$iv_ruleMapEntrySuper.current; } 
	 EOF 
;

// Rule MapEntrySuper
ruleMapEntrySuper returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.18/@alternatives" /* xtext::RuleCall */, currentNode); 
    }
    this_MapEntry=ruleMapEntry
    { 
        $current = $this_MapEntry.current; 
        currentNode = currentNode.getParent();
    }
;







// Entry rule entryRuleMapEntry
entryRuleMapEntry returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.19" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMapEntry=ruleMapEntry 
	 { $current=$iv_ruleMapEntry.current; } 
	 EOF 
;

// Rule MapEntry
ruleMapEntry returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
	    lv_detailKey=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "detailKey"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("MapEntry");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "detailKey", lv_detailKey, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)'=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.19/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_detailValue=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.19/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "detailValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("MapEntry");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "detailValue", lv_detailValue, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));









// Entry rule entryRuleQID
entryRuleQID returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.21" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleQID=ruleQID 
	 { $current=$iv_ruleQID.current.getText(); }  
	 EOF 
;

// Rule QID
ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.21/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, null); 
    }
((
	kw='.' 
    {
        $current.merge(kw);
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.21/@alternatives/@abstractTokens.1/@abstractTokens.0/@groups.0" /* xtext::Keyword */, null); 
    }

    |
	kw='$' 
    {
        $current.merge(kw);
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.21/@alternatives/@abstractTokens.1/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
    }
)    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.21/@alternatives/@abstractTokens.1/@abstractTokens.1" /* xtext::RuleCall */, null); 
    }
)*)
    ;







// Entry rule entryRuleSTRING_OR_QID
entryRuleSTRING_OR_QID returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.22" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID 
	 { $current=$iv_ruleSTRING_OR_QID.current.getText(); }  
	 EOF 
;

// Rule STRING_OR_QID
ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(    this_STRING=RULE_STRING    {
		$current.merge(this_STRING);
    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.22/@alternatives/@groups.0" /* xtext::RuleCall */, null); 
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.22/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_QID=ruleQID    {
		$current.merge(this_QID);
    }

    { 
        currentNode = currentNode.getParent();
    }
)
    ;







// Entry rule entryRuleSINT
entryRuleSINT returns [String current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.23" /* xtext::ParserRule */, currentNode); } 
	 iv_ruleSINT=ruleSINT 
	 { $current=$iv_ruleSINT.current.getText(); }  
	 EOF 
;

// Rule SINT
ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((
	kw='-' 
    {
        $current.merge(kw);
        createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.23/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
)?    this_INT=RULE_INT    {
		$current.merge(this_INT);
    }

    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/EcoreDsl.xmi#//@rules.23/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, null); 
    }
)
    ;























































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


