/*
Generated with Xtext
*/
grammar InternalHiddenTerminalsTestLanguage;

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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

}

@parser::members {
 
 	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;
 	
    public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalHiddenTerminalsTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Model";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}





// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
((((
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele0000ParserRuleCallWithoutHiddens(), currentNode); 
    }
    this_WithoutHiddens=ruleWithoutHiddens
    { 
        $current = $this_WithoutHiddens.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele0001ParserRuleCallWithHiddens(), currentNode); 
    }
    this_WithHiddens=ruleWithHiddens
    { 
        $current = $this_WithHiddens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele001ParserRuleCallOverridingHiddens(), currentNode); 
    }
    this_OverridingHiddens=ruleOverridingHiddens
    { 
        $current = $this_OverridingHiddens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele01ParserRuleCallInheritingHiddens(), currentNode); 
    }
    this_InheritingHiddens=ruleInheritingHiddens
    { 
        $current = $this_InheritingHiddens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele1ParserRuleCallDatatypeHiddens(), currentNode); 
    }
    this_DatatypeHiddens=ruleDatatypeHiddens
    { 
        $current = $this_DatatypeHiddens.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleWithoutHiddens
entryRuleWithoutHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prWithoutHiddens().getRule(), currentNode); }
	 iv_ruleWithoutHiddens=ruleWithoutHiddens 
	 { $current=$iv_ruleWithoutHiddens.current; } 
	 EOF 
;

// Rule WithoutHiddens
ruleWithoutHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
(((('without' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele0000KeywordWithout(), null); 
    }
(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode(grammarAccess.prWithoutHiddens().ele00010ParserRuleCallWS(), "spaces"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("WithoutHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "spaces", lv_spaces, "WS", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'hiddens' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele001KeywordHiddens(), null); 
    }
)(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode(grammarAccess.prWithoutHiddens().ele010ParserRuleCallWS(), "spaces"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("WithoutHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "spaces", lv_spaces, "WS", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("WithoutHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleWithHiddens
entryRuleWithHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prWithHiddens().getRule(), currentNode); }
	 iv_ruleWithHiddens=ruleWithHiddens 
	 { $current=$iv_ruleWithHiddens.current; } 
	 EOF 
;

// Rule WithHiddens
ruleWithHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
(('with' 
    {
        createLeafNode(grammarAccess.prWithHiddens().ele00KeywordWith(), null); 
    }
'hiddens' 
    {
        createLeafNode(grammarAccess.prWithHiddens().ele01KeywordHiddens(), null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prWithHiddens().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("WithHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleOverridingHiddens
entryRuleOverridingHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prOverridingHiddens().getRule(), currentNode); }
	 iv_ruleOverridingHiddens=ruleOverridingHiddens 
	 { $current=$iv_ruleOverridingHiddens.current; } 
	 EOF 
;

// Rule OverridingHiddens
ruleOverridingHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
((((('overriding' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele00000KeywordOverriding(), null); 
    }
'hiddens' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele00001KeywordHiddens(), null); 
    }
)'(' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele0001KeywordLeftParenthesis(), null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prOverridingHiddens().ele0010ParserRuleCallOverridingHiddensCall(), currentNode); 
	    }
	    lv_called=ruleOverridingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create("OverridingHiddens");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "called", lv_called, "OverridingHiddensCall", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))')' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele01KeywordRightParenthesis(), null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("OverridingHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleOverridingHiddensCall
entryRuleOverridingHiddensCall returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prOverridingHiddensCall().getRule(), currentNode); }
	 iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall 
	 { $current=$iv_ruleOverridingHiddensCall.current; } 
	 EOF 
;

// Rule OverridingHiddensCall
ruleOverridingHiddensCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
(('call' 
    {
        createLeafNode(grammarAccess.prOverridingHiddensCall().ele00KeywordCall(), null); 
    }
(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode(grammarAccess.prOverridingHiddensCall().ele010ParserRuleCallWS(), "spaces"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("OverridingHiddensCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "spaces", lv_spaces, "WS", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prOverridingHiddensCall().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("OverridingHiddensCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleInheritingHiddens
entryRuleInheritingHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prInheritingHiddens().getRule(), currentNode); }
	 iv_ruleInheritingHiddens=ruleInheritingHiddens 
	 { $current=$iv_ruleInheritingHiddens.current; } 
	 EOF 
;

// Rule InheritingHiddens
ruleInheritingHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
((((('inheriting' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele00000KeywordInheriting(), null); 
    }
'hiddens' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele00001KeywordHiddens(), null); 
    }
)'(' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele0001KeywordLeftParenthesis(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prInheritingHiddens().ele00100ParserRuleCallInheritingHiddensCall(), currentNode); 
	    }
	    lv_called=ruleInheritingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create("InheritingHiddens");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "called", lv_called, "InheritingHiddensCall", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prInheritingHiddens().ele00110ParserRuleCallHidingHiddens(), currentNode); 
	    }
	    lv_hidingCalled=ruleHidingHiddens 
	    {
	        if ($current==null) {
	            $current = factory.create("InheritingHiddens");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "hidingCalled", lv_hidingCalled, "HidingHiddens", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))')' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele01KeywordRightParenthesis(), null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("InheritingHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleDatatypeHiddens
entryRuleDatatypeHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prDatatypeHiddens().getRule(), currentNode); }
	 iv_ruleDatatypeHiddens=ruleDatatypeHiddens 
	 { $current=$iv_ruleDatatypeHiddens.current; } 
	 EOF 
;

// Rule DatatypeHiddens
ruleDatatypeHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('datatype' 
    {
        createLeafNode(grammarAccess.prDatatypeHiddens().ele0KeywordDatatype(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prDatatypeHiddens().ele10ParserRuleCallDatatypeRule(), currentNode); 
	    }
	    lv_valid=ruleDatatypeRule 
	    {
	        if ($current==null) {
	            $current = factory.create("DatatypeHiddens");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, "DatatypeRule", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleDatatypeRule
entryRuleDatatypeRule returns [String current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prDatatypeRule().getRule(), currentNode); } 
	 iv_ruleDatatypeRule=ruleDatatypeRule 
	 { $current=$iv_ruleDatatypeRule.current.getText(); }  
	 EOF 
;

// Rule DatatypeRule
ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
(
	kw='rule' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prDatatypeRule().ele0KeywordRule(), null); 
    }

	kw=';' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prDatatypeRule().ele1KeywordSemicolon(), null); 
    }
)
    ;







// Entry rule entryRuleHidingHiddens
entryRuleHidingHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prHidingHiddens().getRule(), currentNode); }
	 iv_ruleHidingHiddens=ruleHidingHiddens 
	 { $current=$iv_ruleHidingHiddens.current; } 
	 EOF 
;

// Rule HidingHiddens
ruleHidingHiddens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { resetLookahead(); 
		myHiddenTokenState.restore();
    }:
(('hiding' 
    {
        createLeafNode(grammarAccess.prHidingHiddens().ele00KeywordHiding(), null); 
    }
(	
	
	    lv_space=RULE_WS
    { 
    createLeafNode(grammarAccess.prHidingHiddens().ele010ParserRuleCallWS(), "space"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("HidingHiddens");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "space", lv_space, "WS", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prHidingHiddens().ele10ParserRuleCallInheritingHiddensCall(), currentNode); 
	    }
	    lv_called=ruleInheritingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create("HidingHiddens");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "called", lv_called, "InheritingHiddensCall", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));







// Entry rule entryRuleInheritingHiddensCall
entryRuleInheritingHiddensCall returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prInheritingHiddensCall().getRule(), currentNode); }
	 iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall 
	 { $current=$iv_ruleInheritingHiddensCall.current; } 
	 EOF 
;

// Rule InheritingHiddensCall
ruleInheritingHiddensCall returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    }:
('call' 
    {
        createLeafNode(grammarAccess.prInheritingHiddensCall().ele0KeywordCall(), null); 
    }
(	
	
	    lv_valid=';' 
    {
        createLeafNode(grammarAccess.prInheritingHiddensCall().ele10KeywordSemicolon(), "valid"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("InheritingHiddensCall");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "valid", true, ";", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





































RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



RULE_WS : (((' '|'\t')|'\r')|'\n')+;



RULE_ANY_OTHER : .;




