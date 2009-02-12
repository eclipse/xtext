/*
Generated with Xtext
*/
grammar InternalDomainmodel;

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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;

}

@parser::members {
 
 	private DomainmodelGrammarAccess grammarAccess;
 	
    public InternalDomainmodelParser(TokenStream input, IAstFactory factory, DomainmodelGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalDomainmodelParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.tokens");
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
	{ currentNode = createCompositeNode(grammarAccess.prFile().getRule(), currentNode); }
	 iv_ruleFile=ruleFile 
	 { $current=$iv_ruleFile.current; } 
	 EOF 
;

// Rule File
ruleFile returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prFile().ele00ParserRuleCallImport(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prFile().ele10ParserRuleCallNamedElement(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); }
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
('import' 
    {
        createLeafNode(grammarAccess.prImport().ele0KeywordImport(), null); 
    }
(	
	
	    lv_importURI=RULE_STRING
    { 
    createLeafNode(grammarAccess.prImport().ele10LexerRuleCallSTRING(), "importURI"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prNamedElement().getRule(), currentNode); }
	 iv_ruleNamedElement=ruleNamedElement 
	 { $current=$iv_ruleNamedElement.current; } 
	 EOF 
;

// Rule NamedElement
ruleNamedElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prNamedElement().ele0ParserRuleCallPackage(), currentNode); 
    }
    this_Package=rulePackage
    { 
        $current = $this_Package.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prNamedElement().ele1ParserRuleCallType(), currentNode); 
    }
    this_Type=ruleType
    { 
        $current = $this_Type.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRulePackage
entryRulePackage returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prPackage().getRule(), currentNode); }
	 iv_rulePackage=rulePackage 
	 { $current=$iv_rulePackage.current; } 
	 EOF 
;

// Rule Package
rulePackage returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('package' 
    {
        createLeafNode(grammarAccess.prPackage().ele0000KeywordPackage(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prPackage().ele00010ParserRuleCallQualifiedName(), currentNode); 
	    }
	    lv_name=ruleQualifiedName 
	    {
	        if ($current==null) {
	            $current = factory.create("Package");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "QualifiedName", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))'{' 
    {
        createLeafNode(grammarAccess.prPackage().ele001KeywordLeftCurlyBracket(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prPackage().ele010ParserRuleCallNamedElement(), currentNode); 
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
        createLeafNode(grammarAccess.prPackage().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleType
entryRuleType returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); }
	 iv_ruleType=ruleType 
	 { $current=$iv_ruleType.current; } 
	 EOF 
;

// Rule Type
ruleType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prType().ele0ParserRuleCallEntity(), currentNode); 
    }
    this_Entity=ruleEntity
    { 
        $current = $this_Entity.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prType().ele1ParserRuleCallDataType(), currentNode); 
    }
    this_DataType=ruleDataType
    { 
        $current = $this_DataType.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleDataType
entryRuleDataType returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prDataType().getRule(), currentNode); }
	 iv_ruleDataType=ruleDataType 
	 { $current=$iv_ruleDataType.current; } 
	 EOF 
;

// Rule DataType
ruleDataType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('datatype' 
    {
        createLeafNode(grammarAccess.prDataType().ele0KeywordDatatype(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prDataType().ele10LexerRuleCallID(), "name"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prEntity().getRule(), currentNode); }
	 iv_ruleEntity=ruleEntity 
	 { $current=$iv_ruleEntity.current; } 
	 EOF 
;

// Rule Entity
ruleEntity returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((('entity' 
    {
        createLeafNode(grammarAccess.prEntity().ele00000KeywordEntity(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEntity().ele000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEntity().ele00010KeywordExtends(), null); 
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
    createLeafNode(grammarAccess.prEntity().ele000110CrossReferenceEStringEntity(), "superType"); 
    }
) 
	
))?)'{' 
    {
        createLeafNode(grammarAccess.prEntity().ele001KeywordLeftCurlyBracket(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEntity().ele010ParserRuleCallFeature(), currentNode); 
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
        createLeafNode(grammarAccess.prEntity().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleFeature
entryRuleFeature returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prFeature().getRule(), currentNode); }
	 iv_ruleFeature=ruleFeature 
	 { $current=$iv_ruleFeature.current; } 
	 EOF 
;

// Rule Feature
ruleFeature returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prFeature().ele0ParserRuleCallStructuralFeature(), currentNode); 
    }
    this_StructuralFeature=ruleStructuralFeature
    { 
        $current = $this_StructuralFeature.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prFeature().ele1ParserRuleCallOperation(), currentNode); 
    }
    this_Operation=ruleOperation
    { 
        $current = $this_Operation.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleStructuralFeature
entryRuleStructuralFeature returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prStructuralFeature().getRule(), currentNode); }
	 iv_ruleStructuralFeature=ruleStructuralFeature 
	 { $current=$iv_ruleStructuralFeature.current; } 
	 EOF 
;

// Rule StructuralFeature
ruleStructuralFeature returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prStructuralFeature().ele0ParserRuleCallAttribute(), currentNode); 
    }
    this_Attribute=ruleAttribute
    { 
        $current = $this_Attribute.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prStructuralFeature().ele1ParserRuleCallReference(), currentNode); 
    }
    this_Reference=ruleReference
    { 
        $current = $this_Reference.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAttribute().getRule(), currentNode); }
	 iv_ruleAttribute=ruleAttribute 
	 { $current=$iv_ruleAttribute.current; } 
	 EOF 
;

// Rule Attribute
ruleAttribute returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('attr' 
    {
        createLeafNode(grammarAccess.prAttribute().ele000KeywordAttr(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prAttribute().ele0010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prAttribute().ele01KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAttribute().ele10ParserRuleCallTypeRef(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prReference().getRule(), currentNode); }
	 iv_ruleReference=ruleReference 
	 { $current=$iv_ruleReference.current; } 
	 EOF 
;

// Rule Reference
ruleReference returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('ref' 
    {
        createLeafNode(grammarAccess.prReference().ele0000KeywordRef(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prReference().ele00010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prReference().ele001KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prReference().ele010ParserRuleCallTypeRef(), currentNode); 
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
        createLeafNode(grammarAccess.prReference().ele10KeywordOpposite(), null); 
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
    createLeafNode(grammarAccess.prReference().ele110CrossReferenceEStringReference(), "opposite"); 
    }
) 
	
))?);







// Entry rule entryRuleOperation
entryRuleOperation returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prOperation().getRule(), currentNode); }
	 iv_ruleOperation=ruleOperation 
	 { $current=$iv_ruleOperation.current; } 
	 EOF 
;

// Rule Operation
ruleOperation returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((('op' 
    {
        createLeafNode(grammarAccess.prOperation().ele000000KeywordOp(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prOperation().ele0000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prOperation().ele00001KeywordLeftParenthesis(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prOperation().ele000100ParserRuleCallParameter(), currentNode); 
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
        createLeafNode(grammarAccess.prOperation().ele000110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prOperation().ele0001110ParserRuleCallParameter(), currentNode); 
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
        createLeafNode(grammarAccess.prOperation().ele001KeywordRightParenthesis(), null); 
    }
)':' 
    {
        createLeafNode(grammarAccess.prOperation().ele01KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prOperation().ele10ParserRuleCallTypeRef(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prParameter().getRule(), currentNode); }
	 iv_ruleParameter=ruleParameter 
	 { $current=$iv_ruleParameter.current; } 
	 EOF 
;

// Rule Parameter
ruleParameter returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prParameter().ele00LexerRuleCallID(), "name"); 
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
	        currentNode=createCompositeNode(grammarAccess.prParameter().ele10ParserRuleCallTypeRef(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); }
	 iv_ruleTypeRef=ruleTypeRef 
	 { $current=$iv_ruleTypeRef.current; } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("TypeRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prTypeRef().ele0CrossReferenceEStringType(), "referenced"); 
    }
) 
	
);







// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prQualifiedName().getRule(), currentNode); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode(grammarAccess.prQualifiedName().ele0LexerRuleCallID(), null); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prQualifiedName().ele10KeywordFullStop(), null); 
    }
    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode(grammarAccess.prQualifiedName().ele11LexerRuleCallID(), null); 
    }
)*)
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


