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
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;

}

@parser::members {
 
 	private EpatchTestLanguageGrammarAccess grammarAccess;
 	
    public InternalEpatchTestLanguageParser(TokenStream input, IAstFactory factory, EpatchTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
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
	{ currentNode = createCompositeNode(grammarAccess.prEPatch().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prEPatch().ele000000KeywordEpatch(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEPatch().ele0000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEPatch().ele00001KeywordLeftCurlyBracket(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele00010ParserRuleCallImport(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele0010ParserRuleCallNamedResource(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prEPatch().ele010ParserRuleCallObjectRef(), currentNode); 
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
        createLeafNode(grammarAccess.prEPatch().ele1KeywordRightCurlyBracket(), null); 
    }
);







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
((
    { 
        currentNode=createCompositeNode(grammarAccess.prImport().ele00ParserRuleCallModelImport(), currentNode); 
    }
    this_ModelImport=ruleModelImport
    { 
        $current = $this_ModelImport.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prImport().ele01ParserRuleCallJavaImport(), currentNode); 
    }
    this_JavaImport=ruleJavaImport
    { 
        $current = $this_JavaImport.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prImport().ele1ParserRuleCallExtensionImport(), currentNode); 
    }
    this_ExtensionImport=ruleExtensionImport
    { 
        $current = $this_ExtensionImport.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleModelImport
entryRuleModelImport returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prModelImport().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prModelImport().ele0ParserRuleCallResourceImport(), currentNode); 
    }
    this_ResourceImport=ruleResourceImport
    { 
        $current = $this_ResourceImport.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModelImport().ele1ParserRuleCallEPackageImport(), currentNode); 
    }
    this_EPackageImport=ruleEPackageImport
    { 
        $current = $this_EPackageImport.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleResourceImport
entryRuleResourceImport returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prResourceImport().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prResourceImport().ele000KeywordImport(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prResourceImport().ele0010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prResourceImport().ele01KeywordUri(), null); 
    }
)(	
	
	    lv_uri=RULE_STRING
    { 
    createLeafNode(grammarAccess.prResourceImport().ele10LexerRuleCallSTRING(), "uri"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prEPackageImport().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prEPackageImport().ele000KeywordImport(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prEPackageImport().ele0010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prEPackageImport().ele01KeywordNs(), null); 
    }
)(	
	
	    lv_nsURI=RULE_STRING
    { 
    createLeafNode(grammarAccess.prEPackageImport().ele10LexerRuleCallSTRING(), "nsURI"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prJavaImport().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prJavaImport().ele000KeywordImport(), null); 
    }
'java' 
    {
        createLeafNode(grammarAccess.prJavaImport().ele001KeywordJava(), null); 
    }
)(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode(grammarAccess.prJavaImport().ele010LexerRuleCallID(), "path"); 
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
        createLeafNode(grammarAccess.prJavaImport().ele10KeywordFullStop(), null); 
    }
(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode(grammarAccess.prJavaImport().ele110LexerRuleCallID(), "path"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prExtensionImport().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prExtensionImport().ele000KeywordImport(), null); 
    }
'extension' 
    {
        createLeafNode(grammarAccess.prExtensionImport().ele001KeywordExtension(), null); 
    }
)(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode(grammarAccess.prExtensionImport().ele010LexerRuleCallID(), "path"); 
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
        createLeafNode(grammarAccess.prExtensionImport().ele10KeywordColonColon(), null); 
    }
(	
	
	    lv_path=RULE_ID
    { 
    createLeafNode(grammarAccess.prExtensionImport().ele110LexerRuleCallID(), "path"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prNamedResource().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prNamedResource().ele000000000KeywordResource(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prNamedResource().ele0000000010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prNamedResource().ele00000001KeywordLeftCurlyBracket(), null); 
    }
)'left' 
    {
        createLeafNode(grammarAccess.prNamedResource().ele0000001KeywordLeft(), null); 
    }
)(('uri' 
    {
        createLeafNode(grammarAccess.prNamedResource().ele00000100KeywordUri(), null); 
    }
(	
	
	    lv_leftUri=RULE_STRING
    { 
    createLeafNode(grammarAccess.prNamedResource().ele000001010LexerRuleCallSTRING(), "leftUri"); 
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
	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00000110ParserRuleCallCreatedObject(), currentNode); 
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
        createLeafNode(grammarAccess.prNamedResource().ele00001KeywordSemicolon(), null); 
    }
)'right' 
    {
        createLeafNode(grammarAccess.prNamedResource().ele0001KeywordRight(), null); 
    }
)(('uri' 
    {
        createLeafNode(grammarAccess.prNamedResource().ele00100KeywordUri(), null); 
    }
(	
	
	    lv_rightUri=RULE_STRING
    { 
    createLeafNode(grammarAccess.prNamedResource().ele001010LexerRuleCallSTRING(), "rightUri"); 
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
	        currentNode=createCompositeNode(grammarAccess.prNamedResource().ele00110ParserRuleCallCreatedObject(), currentNode); 
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
        createLeafNode(grammarAccess.prNamedResource().ele01KeywordSemicolon(), null); 
    }
)'}' 
    {
        createLeafNode(grammarAccess.prNamedResource().ele1KeywordRightCurlyBracket(), null); 
    }
);









// Entry rule entryRuleObjectRef
entryRuleObjectRef returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prObjectRef().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prObjectRef().ele000KeywordObject(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prObjectRef().ele0010LexerRuleCallID(), "name"); 
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
    createLeafNode(grammarAccess.prObjectRef().ele01000CrossReferenceEStringNamedResource(), "leftRes"); 
    }
) 
	
)(	
	
	    lv_leftFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prObjectRef().ele01010LexerRuleCallFRAGMENT(), "leftFrag"); 
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
        createLeafNode(grammarAccess.prObjectRef().ele01100000KeywordLeft(), null); 
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
    createLeafNode(grammarAccess.prObjectRef().ele011000010CrossReferenceEStringNamedResource(), "leftRes"); 
    }
) 
	
))(	
	
	    lv_leftFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prObjectRef().ele01100010LexerRuleCallFRAGMENT(), "leftFrag"); 
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
        createLeafNode(grammarAccess.prObjectRef().ele011001KeywordRight(), null); 
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
    createLeafNode(grammarAccess.prObjectRef().ele011010CrossReferenceEStringNamedResource(), "rightRes"); 
    }
) 
	
))(	
	
	    lv_rightFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prObjectRef().ele01110LexerRuleCallFRAGMENT(), "rightFrag"); 
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
        createLeafNode(grammarAccess.prObjectRef().ele10000KeywordLeftCurlyBracket(), null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000100ParserRuleCallBiSingleAssignment(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele1000110ParserRuleCallBiListAssignment(), currentNode); 
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
        createLeafNode(grammarAccess.prObjectRef().ele10010KeywordLeft(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele100110ParserRuleCallMigration(), currentNode); 
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
        createLeafNode(grammarAccess.prObjectRef().ele1010KeywordRight(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prObjectRef().ele10110ParserRuleCallMigration(), currentNode); 
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
        createLeafNode(grammarAccess.prObjectRef().ele11KeywordRightCurlyBracket(), null); 
    }
)?);









// Entry rule entryRuleBiSingleAssignment
entryRuleBiSingleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prBiSingleAssignment().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prBiSingleAssignment().ele000000LexerRuleCallID(), "feature"); 
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
        createLeafNode(grammarAccess.prBiSingleAssignment().ele00001KeywordEqualsSign(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele00010ParserRuleCallSingleAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiSingleAssignment().ele001KeywordVerticalLine(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiSingleAssignment().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleBiListAssignment
entryRuleBiListAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prBiListAssignment().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prBiListAssignment().ele00000000LexerRuleCallID(), "feature"); 
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
        createLeafNode(grammarAccess.prBiListAssignment().ele0000001KeywordEqualsSign(), null); 
    }
)'[' 
    {
        createLeafNode(grammarAccess.prBiListAssignment().ele000001KeywordLeftSquareBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele0000100ParserRuleCallListAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiListAssignment().ele0000110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00001110ParserRuleCallListAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiListAssignment().ele0001KeywordVerticalLine(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele00100ParserRuleCallListAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiListAssignment().ele00110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prBiListAssignment().ele001110ParserRuleCallListAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prBiListAssignment().ele01KeywordRightSquareBracket(), null); 
    }
)';' 
    {
        createLeafNode(grammarAccess.prBiListAssignment().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleMonoSingleAssignment
entryRuleMonoSingleAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prMonoSingleAssignment().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prMonoSingleAssignment().ele0000LexerRuleCallID(), "feature"); 
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
        createLeafNode(grammarAccess.prMonoSingleAssignment().ele001KeywordEqualsSign(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMonoSingleAssignment().ele010ParserRuleCallSingleAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prMonoSingleAssignment().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleMonoListAssignment
entryRuleMonoListAssignment returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prMonoListAssignment().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prMonoListAssignment().ele000000LexerRuleCallID(), "feature"); 
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
        createLeafNode(grammarAccess.prMonoListAssignment().ele00001KeywordEqualsSign(), null); 
    }
)'[' 
    {
        createLeafNode(grammarAccess.prMonoListAssignment().ele0001KeywordLeftSquareBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele00100ParserRuleCallAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prMonoListAssignment().ele00110KeywordComma(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMonoListAssignment().ele001110ParserRuleCallAssignmentValue(), currentNode); 
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
        createLeafNode(grammarAccess.prMonoListAssignment().ele01KeywordRightSquareBracket(), null); 
    }
)';' 
    {
        createLeafNode(grammarAccess.prMonoListAssignment().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleAssignmentValue
entryRuleAssignmentValue returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAssignmentValue().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prAssignmentValue().ele0000LexerRuleCallSTRING(), "value"); 
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
    createLeafNode(grammarAccess.prAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode(grammarAccess.prAssignmentValue().ele001100KeywordFullStop(), null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode(grammarAccess.prAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
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
        createLeafNode(grammarAccess.prAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode(grammarAccess.prAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
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
        createLeafNode(grammarAccess.prAssignmentValue().ele001111KeywordRightSquareBracket(), null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
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
    createLeafNode(grammarAccess.prAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prListAssignmentValue().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prListAssignmentValue().ele000LexerRuleCallINT(), "index"); 
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
        createLeafNode(grammarAccess.prListAssignmentValue().ele01KeywordColon(), null); 
    }
)(((((('[' 
    {
        createLeafNode(grammarAccess.prListAssignmentValue().ele1000000KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode(grammarAccess.prListAssignmentValue().ele10000010LexerRuleCallINT(), "refIndex"); 
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
        createLeafNode(grammarAccess.prListAssignmentValue().ele100001KeywordRightSquareBracket(), null); 
    }
)
    |(	
	
	    lv_value=RULE_STRING
    { 
    createLeafNode(grammarAccess.prListAssignmentValue().ele100010LexerRuleCallSTRING(), "value"); 
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
    createLeafNode(grammarAccess.prListAssignmentValue().ele100100CrossReferenceEStringNamedObject(), "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode(grammarAccess.prListAssignmentValue().ele1001100KeywordFullStop(), null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode(grammarAccess.prListAssignmentValue().ele10011010LexerRuleCallID(), "refFeature"); 
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
        createLeafNode(grammarAccess.prListAssignmentValue().ele10011100KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode(grammarAccess.prListAssignmentValue().ele100111010LexerRuleCallINT(), "refIndex"); 
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
        createLeafNode(grammarAccess.prListAssignmentValue().ele1001111KeywordRightSquareBracket(), null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prListAssignmentValue().ele1010ParserRuleCallCreatedObject(), currentNode); 
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
    createLeafNode(grammarAccess.prListAssignmentValue().ele1100CrossReferenceEStringImport(), "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prListAssignmentValue().ele1110LexerRuleCallFRAGMENT(), "impFrag"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prSingleAssignmentValue().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prSingleAssignmentValue().ele00000KeywordNull(), "keyword"); 
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
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele00010LexerRuleCallSTRING(), "value"); 
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
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele00100CrossReferenceEStringNamedObject(), "refObject"); 
    }
) 
	
)(('.' 
    {
        createLeafNode(grammarAccess.prSingleAssignmentValue().ele001100KeywordFullStop(), null); 
    }
(	
	
	    lv_refFeature=RULE_ID
    { 
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011010LexerRuleCallID(), "refFeature"); 
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
        createLeafNode(grammarAccess.prSingleAssignmentValue().ele0011100KeywordLeftSquareBracket(), null); 
    }
(	
	
	    lv_refIndex=RULE_INT
    { 
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele00111010LexerRuleCallINT(), "refIndex"); 
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
        createLeafNode(grammarAccess.prSingleAssignmentValue().ele001111KeywordRightSquareBracket(), null); 
    }
)?)?))
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prSingleAssignmentValue().ele010ParserRuleCallCreatedObject(), currentNode); 
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
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele100CrossReferenceEStringImport(), "import"); 
    }
) 
	
)(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prSingleAssignmentValue().ele110LexerRuleCallFRAGMENT(), "impFrag"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prCreatedObject().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele000ParserRuleCallObjectNew(), currentNode); 
    }
    this_ObjectNew=ruleObjectNew
    { 
        $current = $this_ObjectNew.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele001ParserRuleCallObjectCopy(), currentNode); 
    }
    this_ObjectCopy=ruleObjectCopy
    { 
        $current = $this_ObjectCopy.current; 
        currentNode = currentNode.getParent();
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prCreatedObject().ele010LexerRuleCallID(), "name"); 
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
        createLeafNode(grammarAccess.prCreatedObject().ele1000KeywordLeftCurlyBracket(), null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100100ParserRuleCallMonoSingleAssignment(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele100110ParserRuleCallMonoListAssignment(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prCreatedObject().ele1010ParserRuleCallMigration(), currentNode); 
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
        createLeafNode(grammarAccess.prCreatedObject().ele11KeywordRightCurlyBracket(), null); 
    }
)?);







// Entry rule entryRuleObjectNew
entryRuleObjectNew returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prObjectNew().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prObjectNew().ele00KeywordNew(), null); 
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
    createLeafNode(grammarAccess.prObjectNew().ele010CrossReferenceEStringImport(), "import"); 
    }
) 
	
))(	
	
	    lv_impFrag=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prObjectNew().ele10LexerRuleCallFRAGMENT(), "impFrag"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prObjectCopy().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prObjectCopy().ele00KeywordCopy(), null); 
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
    createLeafNode(grammarAccess.prObjectCopy().ele010CrossReferenceEStringNamedResource(), "resource"); 
    }
) 
	
))(	
	
	    lv_fragment=RULE_FRAGMENT
    { 
    createLeafNode(grammarAccess.prObjectCopy().ele10LexerRuleCallFRAGMENT(), "fragment"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prMigration().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prMigration().ele000KeywordMigrate(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMigration().ele0010ParserRuleCallExecutable(), currentNode); 
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
        createLeafNode(grammarAccess.prMigration().ele0100KeywordAs(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01010ParserRuleCallExecutable(), currentNode); 
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
        createLeafNode(grammarAccess.prMigration().ele0110KeywordEach(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prMigration().ele01110ParserRuleCallExecutable(), currentNode); 
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
        createLeafNode(grammarAccess.prMigration().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleExecutable
entryRuleExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prExecutable().getRule(), currentNode); }
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
        currentNode=createCompositeNode(grammarAccess.prExecutable().ele0ParserRuleCallJavaExecutable(), currentNode); 
    }
    this_JavaExecutable=ruleJavaExecutable
    { 
        $current = $this_JavaExecutable.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prExecutable().ele1ParserRuleCallExpressionExecutable(), currentNode); 
    }
    this_ExpressionExecutable=ruleExpressionExecutable
    { 
        $current = $this_ExpressionExecutable.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleJavaExecutable
entryRuleJavaExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prJavaExecutable().getRule(), currentNode); }
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
        createLeafNode(grammarAccess.prJavaExecutable().ele000KeywordJava(), null); 
    }
(	
	
	    lv_method=RULE_ID
    { 
    createLeafNode(grammarAccess.prJavaExecutable().ele0010LexerRuleCallID(), "method"); 
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
        createLeafNode(grammarAccess.prJavaExecutable().ele01KeywordLeftParenthesis(), null); 
    }
)')' 
    {
        createLeafNode(grammarAccess.prJavaExecutable().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleExpressionExecutable
entryRuleExpressionExecutable returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prExpressionExecutable().getRule(), currentNode); }
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
    createLeafNode(grammarAccess.prExpressionExecutable().ele0LexerRuleCallSTRING(), "exprstr"); 
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


