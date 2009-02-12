/*
Generated with Xtext
*/
grammar InternalXtext;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.antlr.internal; 

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
import org.eclipse.xtext.services.XtextGrammarAccess;

}

@parser::members {
 
 	private XtextGrammarAccess grammarAccess;
 	
    public InternalXtextParser(TokenStream input, IAstFactory factory, XtextGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalXtextParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtext.tokens");
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
	{ currentNode = createCompositeNode(grammarAccess.prGrammar().getRule(), currentNode); }
	 iv_ruleGrammar=ruleGrammar 
	 { $current=$iv_ruleGrammar.current; } 
	 EOF 
;

// Rule Grammar
ruleGrammar returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((((	
	
	    lv_abstract='abstract language' 
    {
        createLeafNode(grammarAccess.prGrammar().ele0000000KeywordAbstractLanguage(), "abstract"); 
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
        createLeafNode(grammarAccess.prGrammar().ele000001KeywordLanguage(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000010ParserRuleCallGrammarID(), currentNode); 
	    }
	    lv_name=ruleGrammarID 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "GrammarID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('extends' 
    {
        createLeafNode(grammarAccess.prGrammar().ele00010KeywordExtends(), null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(

    { 
        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000110CrossReferenceEStringGrammar(), currentNode); 
    }
	ruleGrammarID
    { 
        currentNode = currentNode.getParent();
    }
) 
	
))?)((((	
	
	    lv_definesHiddenTokens='hidden' 
    {
        createLeafNode(grammarAccess.prGrammar().ele0010000KeywordHidden(), "definesHiddenTokens"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Grammar");
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
        createLeafNode(grammarAccess.prGrammar().ele001001KeywordLeftParenthesis(), null); 
    }
)((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prGrammar().ele0010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
    }
) 
	
)(',' 
    {
        createLeafNode(grammarAccess.prGrammar().ele0010110KeywordComma(), null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Grammar");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prGrammar().ele00101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
    }
) 
	
))*)?)')' 
    {
        createLeafNode(grammarAccess.prGrammar().ele0011KeywordRightParenthesis(), null); 
    }
)?)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele010ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
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
	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallAbstractRule(), currentNode); 
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







// Entry rule entryRuleGrammarID
entryRuleGrammarID returns [String current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); } 
	 iv_ruleGrammarID=ruleGrammarID 
	 { $current=$iv_ruleGrammarID.current.getText(); }  
	 EOF 
;

// Rule GrammarID
ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode(grammarAccess.prGrammarID().ele0LexerRuleCallID(), null); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
    }
    this_ID=RULE_ID    {
		$current.merge(this_ID);
    }

    { 
    createLeafNode(grammarAccess.prGrammarID().ele11LexerRuleCallID(), null); 
    }
)*)
    ;







// Entry rule entryRuleAbstractRule
entryRuleAbstractRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); }
	 iv_ruleAbstractRule=ruleAbstractRule 
	 { $current=$iv_ruleAbstractRule.current; } 
	 EOF 
;

// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele00ParserRuleCallLexerRule(), currentNode); 
    }
    this_LexerRule=ruleLexerRule
    { 
        $current = $this_LexerRule.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele01ParserRuleCallParserRule(), currentNode); 
    }
    this_ParserRule=ruleParserRule
    { 
        $current = $this_ParserRule.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
    }
    this_TerminalRule=ruleTerminalRule
    { 
        $current = $this_TerminalRule.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAbstractMetamodelDeclaration
entryRuleAbstractMetamodelDeclaration returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); }
	 iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration 
	 { $current=$iv_ruleAbstractMetamodelDeclaration.current; } 
	 EOF 
;

// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
    }
    this_GeneratedMetamodel=ruleGeneratedMetamodel
    { 
        $current = $this_GeneratedMetamodel.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
    }
    this_ReferencedMetamodel=ruleReferencedMetamodel
    { 
        $current = $this_ReferencedMetamodel.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleGeneratedMetamodel
entryRuleGeneratedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); }
	 iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel 
	 { $current=$iv_ruleGeneratedMetamodel.current; } 
	 EOF 
;

// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('generate' 
    {
        createLeafNode(grammarAccess.prGeneratedMetamodel().ele000KeywordGenerate(), null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prGeneratedMetamodel().ele0010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("GeneratedMetamodel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
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
    createLeafNode(grammarAccess.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
    }
) 
	
))('as' 
    {
        createLeafNode(grammarAccess.prGeneratedMetamodel().ele10KeywordAs(), null); 
    }
(	
	
	    lv_alias=RULE_ID
    { 
    createLeafNode(grammarAccess.prGeneratedMetamodel().ele110LexerRuleCallID(), "alias"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("GeneratedMetamodel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "alias", lv_alias, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?);







// Entry rule entryRuleReferencedMetamodel
entryRuleReferencedMetamodel returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); }
	 iv_ruleReferencedMetamodel=ruleReferencedMetamodel 
	 { $current=$iv_ruleReferencedMetamodel.current; } 
	 EOF 
;

// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('import' 
    {
        createLeafNode(grammarAccess.prReferencedMetamodel().ele00KeywordImport(), null); 
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
    createLeafNode(grammarAccess.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
    }
) 
	
))('as' 
    {
        createLeafNode(grammarAccess.prReferencedMetamodel().ele10KeywordAs(), null); 
    }
(	
	
	    lv_alias=RULE_ID
    { 
    createLeafNode(grammarAccess.prReferencedMetamodel().ele110LexerRuleCallID(), "alias"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ReferencedMetamodel");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "alias", lv_alias, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?);







// Entry rule entryRuleLexerRule
entryRuleLexerRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLexerRule().getRule(), currentNode); }
	 iv_ruleLexerRule=ruleLexerRule 
	 { $current=$iv_ruleLexerRule.current; } 
	 EOF 
;

// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((((('native' 
    {
        createLeafNode(grammarAccess.prLexerRule().ele000000KeywordNative(), null); 
    }

    |'lexer' 
    {
        createLeafNode(grammarAccess.prLexerRule().ele000001KeywordLexer(), null); 
    }
)(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prLexerRule().ele000010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LexerRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('returns' 
    {
        createLeafNode(grammarAccess.prLexerRule().ele00010KeywordReturns(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prLexerRule().ele000110ParserRuleCallTypeRef(), currentNode); 
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
        createLeafNode(grammarAccess.prLexerRule().ele001KeywordColon(), null); 
    }
)(	
	
	    lv_body=RULE_STRING
    { 
    createLeafNode(grammarAccess.prLexerRule().ele010LexerRuleCallSTRING(), "body"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("LexerRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "body", lv_body, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))';' 
    {
        createLeafNode(grammarAccess.prLexerRule().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleParserRule
entryRuleParserRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); }
	 iv_ruleParserRule=ruleParserRule 
	 { $current=$iv_ruleParserRule.current; } 
	 EOF 
;

// Rule ParserRule
ruleParserRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prParserRule().ele000000LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)('returns' 
    {
        createLeafNode(grammarAccess.prParserRule().ele000010KeywordReturns(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele0000110ParserRuleCallTypeRef(), currentNode); 
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
	
))?)((((	
	
	    lv_definesHiddenTokens='hidden' 
    {
        createLeafNode(grammarAccess.prParserRule().ele00010000KeywordHidden(), "definesHiddenTokens"); 
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
        createLeafNode(grammarAccess.prParserRule().ele0001001KeywordLeftParenthesis(), null); 
    }
)((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prParserRule().ele00010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
    }
) 
	
)(',' 
    {
        createLeafNode(grammarAccess.prParserRule().ele00010110KeywordComma(), null); 
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
    createLeafNode(grammarAccess.prParserRule().ele000101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
    }
) 
	
))*)?)')' 
    {
        createLeafNode(grammarAccess.prParserRule().ele00011KeywordRightParenthesis(), null); 
    }
)?)':' 
    {
        createLeafNode(grammarAccess.prParserRule().ele001KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele010ParserRuleCallAlternatives(), currentNode); 
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
        createLeafNode(grammarAccess.prParserRule().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleTerminalRule
entryRuleTerminalRule returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); }
	 iv_ruleTerminalRule=ruleTerminalRule 
	 { $current=$iv_ruleTerminalRule.current; } 
	 EOF 
;

// Rule TerminalRule
ruleTerminalRule returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((	
	
	    lv_terminal='terminal' 
    {
        createLeafNode(grammarAccess.prTerminalRule().ele000000KeywordTerminal(), "terminal"); 
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
	
	    lv_name=RULE_ID
    { 
    createLeafNode(grammarAccess.prTerminalRule().ele000010LexerRuleCallID(), "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ParserRule");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('returns' 
    {
        createLeafNode(grammarAccess.prTerminalRule().ele00010KeywordReturns(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele000110ParserRuleCallTypeRef(), currentNode); 
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
        createLeafNode(grammarAccess.prTerminalRule().ele001KeywordColon(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele010ParserRuleCallTerminalAlternatives(), currentNode); 
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
        createLeafNode(grammarAccess.prTerminalRule().ele1KeywordSemicolon(), null); 
    }
);







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
(((	
	
		
		{
			if ($current==null) {
	            $current = factory.create("TypeRef");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
    }
) 
	
)'::' 
    {
        createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
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
    createLeafNode(grammarAccess.prTypeRef().ele10CrossReferenceEStringEClassifier(), "type"); 
    }
) 
	
));







// Entry rule entryRuleAlternatives
entryRuleAlternatives returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); }
	 iv_ruleAlternatives=ruleAlternatives 
	 { $current=$iv_ruleAlternatives.current; } 
	 EOF 
;

// Rule Alternatives
ruleAlternatives returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
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
        CompositeNode newNode = createCompositeNode(grammarAccess.prAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 
    {
        createLeafNode(grammarAccess.prAlternatives().ele101KeywordVerticalLine(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele110ParserRuleCallGroup(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); }
	 iv_ruleTerminalAlternatives=ruleTerminalAlternatives 
	 { $current=$iv_ruleTerminalAlternatives.current; } 
	 EOF 
;

// Rule TerminalAlternatives
ruleTerminalAlternatives returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
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
        CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 
    {
        createLeafNode(grammarAccess.prTerminalAlternatives().ele101KeywordVerticalLine(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele110ParserRuleCallTerminalGroup(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); }
	 iv_ruleGroup=ruleGroup 
	 { $current=$iv_ruleGroup.current; } 
	 EOF 
;

// Rule Group
ruleGroup returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
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
        CompositeNode newNode = createCompositeNode(grammarAccess.prGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); }
	 iv_ruleTerminalGroup=ruleTerminalGroup 
	 { $current=$iv_ruleTerminalGroup.current; } 
	 EOF 
;

// Rule TerminalGroup
ruleTerminalGroup returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
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
        CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); }
	 iv_ruleAbstractToken=ruleAbstractToken 
	 { $current=$iv_ruleAbstractToken.current; } 
	 EOF 
;

// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele000ParserRuleCallAssignment(), currentNode); 
    }
    this_Assignment=ruleAssignment
    { 
        $current = $this_Assignment.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele001ParserRuleCallAction(), currentNode); 
    }
    this_Action=ruleAction
    { 
        $current = $this_Action.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAbstractTerminal(), currentNode); 
    }
    this_AbstractTerminal=ruleAbstractTerminal
    { 
        $current = $this_AbstractTerminal.current; 
        currentNode = currentNode.getParent();
    }
)(	
	
	    lv_cardinality=(('?' 
    {
        createLeafNode(grammarAccess.prAbstractToken().ele1000KeywordQuestionMark(), "cardinality"); 
    }

    |'*' 
    {
        createLeafNode(grammarAccess.prAbstractToken().ele1001KeywordAsterisk(), "cardinality"); 
    }
)
    |'+' 
    {
        createLeafNode(grammarAccess.prAbstractToken().ele101KeywordPlusSign(), "cardinality"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); }
	 iv_ruleTerminalToken=ruleTerminalToken 
	 { $current=$iv_ruleTerminalToken.current; } 
	 EOF 
;

// Rule TerminalToken
ruleTerminalToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
    }
    this_TerminalTokenElement=ruleTerminalTokenElement
    { 
        $current = $this_TerminalTokenElement.current; 
        currentNode = currentNode.getParent();
    }
(	
	
	    lv_cardinality=(('?' 
    {
        createLeafNode(grammarAccess.prTerminalToken().ele1000KeywordQuestionMark(), "cardinality"); 
    }

    |'*' 
    {
        createLeafNode(grammarAccess.prTerminalToken().ele1001KeywordAsterisk(), "cardinality"); 
    }
)
    |'+' 
    {
        createLeafNode(grammarAccess.prTerminalToken().ele101KeywordPlusSign(), "cardinality"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); }
	 iv_ruleAssignment=ruleAssignment 
	 { $current=$iv_ruleAssignment.current; } 
	 EOF 
;

// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode(grammarAccess.prAssignment().ele000LexerRuleCallID(), "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Assignment");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_operator=(('+=' 
    {
        createLeafNode(grammarAccess.prAssignment().ele01000KeywordPlusSignEqualsSign(), "operator"); 
    }

    |'=' 
    {
        createLeafNode(grammarAccess.prAssignment().ele01001KeywordEqualsSign(), "operator"); 
    }
)
    |'?=' 
    {
        createLeafNode(grammarAccess.prAssignment().ele0101KeywordQuestionMarkEqualsSign(), "operator"); 
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
	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele10ParserRuleCallAbstractTerminal(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); }
	 iv_ruleAction=ruleAction 
	 { $current=$iv_ruleAction.current; } 
	 EOF 
;

// Rule Action
ruleAction returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((((('{' 
    {
        createLeafNode(grammarAccess.prAction().ele0000000KeywordLeftCurlyBracket(), null); 
    }
('current' 
    {
        createLeafNode(grammarAccess.prAction().ele00000010KeywordCurrent(), null); 
    }
'=' 
    {
        createLeafNode(grammarAccess.prAction().ele00000011KeywordEqualsSign(), null); 
    }
)?)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prAction().ele0000010ParserRuleCallTypeRef(), currentNode); 
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
        createLeafNode(grammarAccess.prAction().ele00001KeywordFullStop(), null); 
    }
)(	
	
	    lv_feature=RULE_ID
    { 
    createLeafNode(grammarAccess.prAction().ele00010LexerRuleCallID(), "feature"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Action");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "feature", lv_feature, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_operator=('=' 
    {
        createLeafNode(grammarAccess.prAction().ele00100KeywordEqualsSign(), "operator"); 
    }

    |'+=' 
    {
        createLeafNode(grammarAccess.prAction().ele00101KeywordPlusSignEqualsSign(), "operator"); 
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
        createLeafNode(grammarAccess.prAction().ele01KeywordCurrent(), null); 
    }
)'}' 
    {
        createLeafNode(grammarAccess.prAction().ele1KeywordRightCurlyBracket(), null); 
    }
);







// Entry rule entryRuleAbstractTerminal
entryRuleAbstractTerminal returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); }
	 iv_ruleAbstractTerminal=ruleAbstractTerminal 
	 { $current=$iv_ruleAbstractTerminal.current; } 
	 EOF 
;

// Rule AbstractTerminal
ruleAbstractTerminal returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele000ParserRuleCallKeyword(), currentNode); 
    }
    this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele001ParserRuleCallRuleCall(), currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement(), currentNode); 
    }
    this_ParenthesizedElement=ruleParenthesizedElement
    { 
        $current = $this_ParenthesizedElement.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallCrossReference(), currentNode); 
    }
    this_CrossReference=ruleCrossReference
    { 
        $current = $this_CrossReference.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleTerminalTokenElement
entryRuleTerminalTokenElement returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); }
	 iv_ruleTerminalTokenElement=ruleTerminalTokenElement 
	 { $current=$iv_ruleTerminalTokenElement.current; } 
	 EOF 
;

// Rule TerminalTokenElement
ruleTerminalTokenElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange(), currentNode); 
    }
    this_CharacterRange=ruleCharacterRange
    { 
        $current = $this_CharacterRange.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0001ParserRuleCallRuleCall(), currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement(), currentNode); 
    }
    this_ParenthesizedTerminalElement=ruleParenthesizedTerminalElement
    { 
        $current = $this_ParenthesizedTerminalElement.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken(), currentNode); 
    }
    this_AbstractNegatedToken=ruleAbstractNegatedToken
    { 
        $current = $this_AbstractNegatedToken.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallWildcard(), currentNode); 
    }
    this_Wildcard=ruleWildcard
    { 
        $current = $this_Wildcard.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAbstractNegatedToken
entryRuleAbstractNegatedToken returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); }
	 iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken 
	 { $current=$iv_ruleAbstractNegatedToken.current; } 
	 EOF 
;

// Rule AbstractNegatedToken
ruleAbstractNegatedToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
    }
    this_NegatedToken=ruleNegatedToken
    { 
        $current = $this_NegatedToken.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUpToToken(), currentNode); 
    }
    this_UpToToken=ruleUpToToken
    { 
        $current = $this_UpToToken.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleNegatedToken
entryRuleNegatedToken returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); }
	 iv_ruleNegatedToken=ruleNegatedToken 
	 { $current=$iv_ruleNegatedToken.current; } 
	 EOF 
;

// Rule NegatedToken
ruleNegatedToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('!' 
    {
        createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prUpToToken().getRule(), currentNode); }
	 iv_ruleUpToToken=ruleUpToToken 
	 { $current=$iv_ruleUpToToken.current; } 
	 EOF 
;

// Rule UpToToken
ruleUpToToken returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('->' 
    {
        createLeafNode(grammarAccess.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prUpToToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); }
	 iv_ruleWildcard=ruleWildcard 
	 { $current=$iv_ruleWildcard.current; } 
	 EOF 
;

// Rule Wildcard
ruleWildcard returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_isWildcard='.' 
    {
        createLeafNode(grammarAccess.prWildcard().ele0KeywordFullStop(), "isWildcard"); 
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
	{ currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); }
	 iv_ruleCharacterRange=ruleCharacterRange 
	 { $current=$iv_ruleCharacterRange.current; } 
	 EOF 
;

// Rule CharacterRange
ruleCharacterRange returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
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
        CompositeNode newNode = createCompositeNode(grammarAccess.prCharacterRange().ele100ActionCharacterRangeleft(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'..' 
    {
        createLeafNode(grammarAccess.prCharacterRange().ele101KeywordFullStopFullStop(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele110ParserRuleCallKeyword(), currentNode); 
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
	{ currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); }
	 iv_ruleCrossReference=ruleCrossReference 
	 { $current=$iv_ruleCrossReference.current; } 
	 EOF 
;

// Rule CrossReference
ruleCrossReference returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((('[' 
    {
        createLeafNode(grammarAccess.prCrossReference().ele000KeywordLeftSquareBracket(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele0010ParserRuleCallTypeRef(), currentNode); 
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
        createLeafNode(grammarAccess.prCrossReference().ele010KeywordVerticalLine(), null); 
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
    createLeafNode(grammarAccess.prCrossReference().ele0110CrossReferenceEStringAbstractRule(), "rule"); 
    }
) 
	
))?)']' 
    {
        createLeafNode(grammarAccess.prCrossReference().ele1KeywordRightSquareBracket(), null); 
    }
);







// Entry rule entryRuleParenthesizedElement
entryRuleParenthesizedElement returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); }
	 iv_ruleParenthesizedElement=ruleParenthesizedElement 
	 { $current=$iv_ruleParenthesizedElement.current; } 
	 EOF 
;

// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('(' 
    {
        createLeafNode(grammarAccess.prParenthesizedElement().ele00KeywordLeftParenthesis(), null); 
    }

    { 
        currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele01ParserRuleCallAlternatives(), currentNode); 
    }
    this_Alternatives=ruleAlternatives
    { 
        $current = $this_Alternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode(grammarAccess.prParenthesizedElement().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleParenthesizedTerminalElement
entryRuleParenthesizedTerminalElement returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); }
	 iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement 
	 { $current=$iv_ruleParenthesizedTerminalElement.current; } 
	 EOF 
;

// Rule ParenthesizedTerminalElement
ruleParenthesizedTerminalElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(('(' 
    {
        createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis(), null); 
    }

    { 
        currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives(), currentNode); 
    }
    this_TerminalAlternatives=ruleTerminalAlternatives
    { 
        $current = $this_TerminalAlternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele1KeywordRightParenthesis(), null); 
    }
);







// Entry rule entryRuleKeyword
entryRuleKeyword returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); }
	 iv_ruleKeyword=ruleKeyword 
	 { $current=$iv_ruleKeyword.current; } 
	 EOF 
;

// Rule Keyword
ruleKeyword returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
	    lv_value=RULE_STRING
    { 
    createLeafNode(grammarAccess.prKeyword().ele0LexerRuleCallSTRING(), "value"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Keyword");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "value", lv_value, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleRuleCall
entryRuleRuleCall returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); }
	 iv_ruleRuleCall=ruleRuleCall 
	 { $current=$iv_ruleRuleCall.current; } 
	 EOF 
;

// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("RuleCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode(grammarAccess.prRuleCall().ele0CrossReferenceEStringAbstractRule(), "rule"); 
    }
) 
	
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


