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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;

}

@parser::members {
 
 	private EcoreDslGrammarAccess grammarAccess;
 	
    public InternalEcoreDslParser(TokenStream input, IAstFactory factory, EcoreDslGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
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
	{ currentNode = createCompositeNode(grammarAccess.prEcoreDsl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele00ParserRuleCallImportStatementDecl(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEcoreDsl().ele10ParserRuleCallEPackageDecl(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prImportStatementDecl().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prImportStatementDecl().ele000KeywordImport(), null); 
    }
((	
	
	    lv_alias=RULE_ID
    { 
    createLeafNode(grammarAccess.prImportStatementDecl().ele00100LexerRuleCallID(), "alias"); 
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
        createLeafNode(grammarAccess.prImportStatementDecl().ele0011KeywordEqualsSign(), null); 
    }
)?)(	
	
	    lv_importURI=RULE_STRING
    { 
    createLeafNode(grammarAccess.prImportStatementDecl().ele010LexerRuleCallSTRING(), "importURI"); 
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
        createLeafNode(grammarAccess.prImportStatementDecl().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleEPackageDecl
entryRuleEPackageDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEPackageDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele000000000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEPackageDecl().ele00000000001KeywordPackage(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00000000010ParserRuleCallQID(), currentNode); 
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
        createLeafNode(grammarAccess.prEPackageDecl().ele000000001KeywordNsURI(), null); 
    }
)'=' 
    {
        createLeafNode(grammarAccess.prEPackageDecl().ele00000001KeywordEqualsSign(), null); 
    }
)(	
	
	    lv_nsURI=RULE_STRING
    { 
    createLeafNode(grammarAccess.prEPackageDecl().ele00000010LexerRuleCallSTRING(), "nsURI"); 
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
        createLeafNode(grammarAccess.prEPackageDecl().ele000001KeywordNsPrefix(), null); 
    }
)'=' 
    {
        createLeafNode(grammarAccess.prEPackageDecl().ele00001KeywordEqualsSign(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele00010ParserRuleCallQID(), currentNode); 
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
        createLeafNode(grammarAccess.prEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleSubEPackageDecl
entryRuleSubEPackageDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSubEPackageDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prSubEPackageDecl().ele00001KeywordPackage(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prSubEPackageDecl().ele00010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prSubEPackageDecl().ele001KeywordLeftCurlyBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0100ParserRuleCallSubEPackageDecl(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prSubEPackageDecl().ele0110ParserRuleCallEClassifierDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prSubEPackageDecl().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleEClassifierDecl
entryRuleEClassifierDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEClassifierDecl().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele0ParserRuleCallEClassDecl(), currentNode); 
    }
    this_EClassDecl=ruleEClassDecl
    { 
        $current = $this_EClassDecl.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl(), currentNode); 
    }
    this_EDataTypeDecl=ruleEDataTypeDecl
    { 
        $current = $this_EDataTypeDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEDataTypeDecl
entryRuleEDataTypeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEDataTypeDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele0000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEDataTypeDecl().ele0010KeywordSerializable(), "serializable"); 
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
        createLeafNode(grammarAccess.prEDataTypeDecl().ele010000KeywordDatatype(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEDataTypeDecl().ele0100010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEDataTypeDecl().ele01001KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele01010ParserRuleCallSTRING_OR_QID(), currentNode); 
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
        createLeafNode(grammarAccess.prEDataTypeDecl().ele011KeywordSemicolon(), null); 
    }
))
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl(), currentNode); 
    }
    this_EEnumDecl=ruleEEnumDecl
    { 
        $current = $this_EEnumDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEAnnotationDecl
entryRuleEAnnotationDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEAnnotationDecl().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prEAnnotationDecl().ele000000KeywordCommercialAt(), null); 
    }
(	
	
	    lv_source=RULE_STRING
    { 
    createLeafNode(grammarAccess.prEAnnotationDecl().ele0000010LexerRuleCallSTRING(), "source"); 
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
    createLeafNode(grammarAccess.prEAnnotationDecl().ele000010CrossReferenceEStringEModelElement(), "eModelElement"); 
    }
) 
	
)?)'(' 
    {
        createLeafNode(grammarAccess.prEAnnotationDecl().ele0001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0010ParserRuleCallMapEntrySuper(), currentNode); 
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
        createLeafNode(grammarAccess.prEAnnotationDecl().ele010KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEAnnotationDecl().ele0110ParserRuleCallMapEntrySuper(), currentNode); 
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
        createLeafNode(grammarAccess.prEAnnotationDecl().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleEClassDecl
entryRuleEClassDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEClassDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele0000000010KeywordAbstract(), "abstract"); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele0000000100KeywordInterface(), "interface"); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele000000011KeywordClass(), null); 
    }
))(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEClassDecl().ele00000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele000001000KeywordLessThanSign(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele000001010KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele0000011KeywordGreaterThanSign(), null); 
    }
)?)(('extends' 
    {
        createLeafNode(grammarAccess.prEClassDecl().ele0000100KeywordExtends(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele0000110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele00001110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele00010KeywordColon(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele000110ParserRuleCallSTRING_OR_QID(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele001KeywordLeftCurlyBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0100ParserRuleCallEStructuralFeatureDecl(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEClassDecl().ele0110ParserRuleCallEOperationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEClassDecl().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleEStructuralFeatureDecl
entryRuleEStructuralFeatureDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEStructuralFeatureDecl().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl(), currentNode); 
    }
    this_EAttributeDecl=ruleEAttributeDecl
    { 
        $current = $this_EAttributeDecl.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl(), currentNode); 
    }
    this_EReferenceDecl=ruleEReferenceDecl
    { 
        $current = $this_EReferenceDecl.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleEAttributeDecl
entryRuleEAttributeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEAttributeDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000000KeywordID(), "iD"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele000000100000010KeywordBag(), "unique"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele00000010000010KeywordRandom(), "ordered"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele0000001000010KeywordReadonly(), "changeable"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele000000100010KeywordVolatile(), "volatile"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele00000010010KeywordTransient(), "transient"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele000000110KeywordDerived(), "derived"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele000001KeywordAttr(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele0001000KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_lowerBound=RULE_INT
    { 
    createLeafNode(grammarAccess.prEAttributeDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele0001010KeywordFullStopFullStop(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEAttributeDecl().ele00010110ParserRuleCallSINT(), currentNode); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele00011KeywordRightSquareBracket(), null); 
    }
)?)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEAttributeDecl().ele0010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele010KeywordEqualsSign(), null); 
    }
(	
	
	    lv_defaultValueLiteral=RULE_STRING
    { 
    createLeafNode(grammarAccess.prEAttributeDecl().ele0110LexerRuleCallSTRING(), "defaultValueLiteral"); 
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
        createLeafNode(grammarAccess.prEAttributeDecl().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleEReferenceDecl
entryRuleEReferenceDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEReferenceDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000000KeywordLocal(), "resolveProxies"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele000000100000010KeywordBag(), "unique"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele00000010000010KeywordRandom(), "ordered"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele0000001000010KeywordReadonly(), "changeable"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele000000100010KeywordVolatile(), "volatile"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele00000010010KeywordTransient(), "transient"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele0000001010KeywordUnsettable(), "unsettable"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele000000110KeywordDerived(), "derived"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele00000100KeywordVal(), "containment"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele0000011KeywordRef(), null); 
    }
))(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele000010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele0001000KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_lowerBound=RULE_INT
    { 
    createLeafNode(grammarAccess.prEReferenceDecl().ele00010010LexerRuleCallINT(), "lowerBound"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele0001010KeywordFullStopFullStop(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEReferenceDecl().ele00010110ParserRuleCallSINT(), currentNode); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele00011KeywordRightSquareBracket(), null); 
    }
)?)('#' 
    {
        createLeafNode(grammarAccess.prEReferenceDecl().ele0010KeywordNumberSign(), null); 
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
    createLeafNode(grammarAccess.prEReferenceDecl().ele00110CrossReferenceEStringEReference(), "eOpposite"); 
    }
) 
	
))?)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEReferenceDecl().ele010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEReferenceDecl().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleEEnumDecl
entryRuleEEnumDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEEnumDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEEnumDecl().ele00001KeywordEnum(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEEnumDecl().ele00010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEEnumDecl().ele001KeywordLeftCurlyBracket(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEEnumDecl().ele010ParserRuleCallEEnumLiteralDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEEnumDecl().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleEEnumLiteralDecl
entryRuleEEnumLiteralDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEEnumLiteralDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEEnumLiteralDecl().ele00000ParserRuleCallEAnnotationDecl(), currentNode); 
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
    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEEnumLiteralDecl().ele0010KeywordEqualsSign(), null); 
    }
(	
	
	    lv_value=RULE_INT
    { 
    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele00110LexerRuleCallINT(), "value"); 
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
    createLeafNode(grammarAccess.prEEnumLiteralDecl().ele010LexerRuleCallSTRING(), "literal"); 
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
        createLeafNode(grammarAccess.prEEnumLiteralDecl().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleETypeParameterDecl
entryRuleETypeParameterDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prETypeParameterDecl().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prETypeParameterDecl().ele00LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prETypeParameterDecl().ele10KeywordExtends(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prETypeParameterDecl().ele110ParserRuleCallEGenericTypeDecl(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele000CrossReferenceEStringEClassifier(), "eClassifier"); 
    }
) 
	
)((('<' 
    {
        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01000KeywordLessThanSign(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010010ParserRuleCallEGenericTypeDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele01010KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeReferenceDecl().ele010110ParserRuleCallEGenericTypeDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele011KeywordGreaterThanSign(), null); 
    }
)?)
    |('#' 
    {
        createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele10KeywordNumberSign(), null); 
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
    createLeafNode(grammarAccess.prEGenericTypeReferenceDecl().ele110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
    }
) 
	
)));







// Entry rule entryRuleEGenericTypeDecl
entryRuleEGenericTypeDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEGenericTypeDecl().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prEGenericTypeDecl().ele0000CrossReferenceEStringEClassifier(), "eClassifier"); 
    }
) 
	
)((('<' 
    {
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele001000KeywordLessThanSign(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010010ParserRuleCallEGenericTypeDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele001010KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele0010110ParserRuleCallEGenericTypeDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele0011KeywordGreaterThanSign(), null); 
    }
)?)
    |('#' 
    {
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele010KeywordNumberSign(), null); 
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
    createLeafNode(grammarAccess.prEGenericTypeDecl().ele0110CrossReferenceEStringETypeParameter(), "eTypeParameter"); 
    }
) 
	
)))
    |('?' 
    {
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele10KeywordQuestionMark(), null); 
    }
(('extends' 
    {
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele1100KeywordExtends(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11010ParserRuleCallEGenericTypeDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEGenericTypeDecl().ele1110KeywordSuper(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEGenericTypeDecl().ele11110ParserRuleCallEGenericTypeDecl(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prEOperationDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele00000000000ParserRuleCallEAnnotationDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000000000100KeywordBag(), "unique"); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000000000110KeywordRandom(), "ordered"); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000000001KeywordOp(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000000100ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000000011KeywordVoid(), null); 
    }
))(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEOperationDecl().ele00000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000001000KeywordLessThanSign(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010010ParserRuleCallETypeParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000001010KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0000010110ParserRuleCallETypeParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele0000011KeywordGreaterThanSign(), null); 
    }
)?)'(' 
    {
        createLeafNode(grammarAccess.prEOperationDecl().ele00001KeywordLeftParenthesis(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele000100ParserRuleCallEParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele000110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele0001110ParserRuleCallEParameterDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele001KeywordRightParenthesis(), null); 
    }
)(('throws' 
    {
        createLeafNode(grammarAccess.prEOperationDecl().ele0100KeywordThrows(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele0110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEOperationDecl().ele01110ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
        createLeafNode(grammarAccess.prEOperationDecl().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleEParameterDecl
entryRuleEParameterDecl returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prEParameterDecl().getRule(), currentNode); }
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
	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele000ParserRuleCallEAnnotationDecl(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEParameterDecl().ele010ParserRuleCallEGenericTypeReferenceDecl(), currentNode); 
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
    createLeafNode(grammarAccess.prEParameterDecl().ele10LexerRuleCallID(), "name"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prMapEntrySuper().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prMapEntrySuper().eleParserRuleCallMapEntry(), currentNode); 
    }
    this_MapEntry=ruleMapEntry
    { 
        $current = $this_MapEntry.current; 
        currentNode = currentNode.getParent();
    }
;







// Entry rule entryRuleMapEntry
entryRuleMapEntry returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prMapEntry().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prMapEntry().ele000LexerRuleCallID(), "detailKey"); 
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
        createLeafNode(grammarAccess.prMapEntry().ele01KeywordEqualsSign(), null); 
    }
)(	
	
	    lv_detailValue=RULE_STRING
    { 
    createLeafNode(grammarAccess.prMapEntry().ele10LexerRuleCallSTRING(), "detailValue"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prQID().getRule(), currentNode); } 
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
    createLeafNode(grammarAccess.prQID().ele0LexerRuleCallID(), null); 
    }
((
	kw='.' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prQID().ele100KeywordFullStop(), null); 
    }

    |
	kw='$' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prQID().ele101Keyword$(), null); 
    }
)    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode(grammarAccess.prQID().ele11LexerRuleCallID(), null); 
    }
)*)
    ;







// Entry rule entryRuleSTRING_OR_QID
entryRuleSTRING_OR_QID returns [String current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSTRING_OR_QID().getRule(), currentNode); } 
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
    createLeafNode(grammarAccess.prSTRING_OR_QID().ele0LexerRuleCallSTRING(), null); 
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prSTRING_OR_QID().ele1ParserRuleCallQID(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prSINT().getRule(), currentNode); } 
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
        createLeafNode(grammarAccess.prSINT().ele0KeywordHyphenMinus(), null); 
    }
)?    this_INT=RULE_INT    {
		$current.merge(this_INT);
    }

    { 
    createLeafNode(grammarAccess.prSINT().ele1LexerRuleCallINT(), null); 
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


