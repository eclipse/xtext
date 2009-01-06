/*
Generated with Xtext
*/
grammar InternalDomainmodel;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.example.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.example.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;

}

@parser::members {
 
    public InternalDomainmodelParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalDomainmodelParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/internal/InternalDomainmodel.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "File";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleFile
entryRuleFile returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFile=ruleFile 
	 { $current=$iv_ruleFile.current; } 
	 EOF 
;

// Rule File
ruleFile returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_imports=ruleImport 
	    {
	        if ($current==null) {
	            $current = factory.create("File");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "imports", lv_imports, "Import", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_namedElements=ruleNamedElement 
	    {
	        if ($current==null) {
	            $current = factory.create("File");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "namedElements", lv_namedElements, "NamedElement", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*);





// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('import' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_importURI=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "importURI"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Import");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "importURI", lv_importURI, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleNamedElement
entryRuleNamedElement returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNamedElement=ruleNamedElement 
	 { $current=$iv_ruleNamedElement.current; } 
	 EOF 
;

// Rule NamedElement
ruleNamedElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Package=rulePackage
    { 
        $current = $this_Package.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Type=ruleType
    { 
        $current = $this_Type.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRulePackage
entryRulePackage returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_rulePackage=rulePackage 
	 { $current=$iv_rulePackage.current; } 
	 EOF 
;

// Rule Package
rulePackage returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('package' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Package");
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
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_namedElements=ruleNamedElement 
	    {
	        if ($current==null) {
	            $current = factory.create("Package");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "namedElements", lv_namedElements, "NamedElement", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);





// Entry rule entryRuleType
entryRuleType returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleType=ruleType 
	 { $current=$iv_ruleType.current; } 
	 EOF 
;

// Rule Type
ruleType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Entity=ruleEntity
    { 
        $current = $this_Entity.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.4/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_DataType=ruleDataType
    { 
        $current = $this_DataType.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleDataType
entryRuleDataType returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleDataType=ruleDataType 
	 { $current=$iv_ruleDataType.current; } 
	 EOF 
;

// Rule DataType
ruleDataType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('datatype' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("DataType");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleEntity
entryRuleEntity returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEntity=ruleEntity 
	 { $current=$iv_ruleEntity.current; } 
	 EOF 
;

// Rule Entity
ruleEntity returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((('entity' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Entity");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Entity");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "superType"); 
    }
) 
	
))?)'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_features=ruleFeature 
	    {
	        if ($current==null) {
	            $current = factory.create("Entity");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "features", lv_features, "Feature", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);





// Entry rule entryRuleFeature
entryRuleFeature returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFeature=ruleFeature 
	 { $current=$iv_ruleFeature.current; } 
	 EOF 
;

// Rule Feature
ruleFeature returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_StructuralFeature=ruleStructuralFeature
    { 
        $current = $this_StructuralFeature.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.7/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Operation=ruleOperation
    { 
        $current = $this_Operation.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleStructuralFeature
entryRuleStructuralFeature returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleStructuralFeature=ruleStructuralFeature 
	 { $current=$iv_ruleStructuralFeature.current; } 
	 EOF 
;

// Rule StructuralFeature
ruleStructuralFeature returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Attribute=ruleAttribute
    { 
        $current = $this_Attribute.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.8/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Reference=ruleReference
    { 
        $current = $this_Reference.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAttribute=ruleAttribute 
	 { $current=$iv_ruleAttribute.current; } 
	 EOF 
;

// Rule Attribute
ruleAttribute returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('attr' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Attribute");
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
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.9/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("Attribute");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));





// Entry rule entryRuleReference
entryRuleReference returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); }
	 iv_ruleReference=ruleReference 
	 { $current=$iv_ruleReference.current; } 
	 EOF 
;

// Rule Reference
ruleReference returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('ref' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Reference");
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
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("Reference");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('opposite' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Reference");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "opposite"); 
    }
) 
	
))?);





// Entry rule entryRuleOperation
entryRuleOperation returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleOperation=ruleOperation 
	 { $current=$iv_ruleOperation.current; } 
	 EOF 
;

// Rule Operation
ruleOperation returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((('op' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Operation");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_params=ruleParameter 
	    {
	        if ($current==null) {
	            $current = factory.create("Operation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "params", lv_params, "Parameter", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_params=ruleParameter 
	    {
	        if ($current==null) {
	            $current = factory.create("Operation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "params", lv_params, "Parameter", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("Operation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));





// Entry rule entryRuleParameter
entryRuleParameter returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParameter=ruleParameter 
	 { $current=$iv_ruleParameter.current; } 
	 EOF 
;

// Rule Parameter
ruleParameter returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Parameter");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.12/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_type=ruleTypeRef 
	    {
	        if ($current==null) {
	            $current = factory.create("Parameter");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "type", lv_type, "TypeRef", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleTypeRef
entryRuleTypeRef returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTypeRef=ruleTypeRef 
	 { $current=$iv_ruleTypeRef.current; } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("TypeRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/example/Domainmodel.xmi#//@rules.14/@alternatives/@terminal" /* xtext::CrossReference */, "referenced"); 
    }
) 
	
);





RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ('.' ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*)*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


