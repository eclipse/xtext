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
    	lastConsumedNode = currentNode;
    }:
((((
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele0000ParserRuleCallWithoutHiddens(), currentNode); 
    }
    this_WithoutHiddens_0=ruleWithoutHiddens
    { 
        $current = $this_WithoutHiddens_0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele0001ParserRuleCallWithHiddens(), currentNode); 
    }
    this_WithHiddens_1=ruleWithHiddens
    { 
        $current = $this_WithHiddens_1.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele001ParserRuleCallOverridingHiddens(), currentNode); 
    }
    this_OverridingHiddens_2=ruleOverridingHiddens
    { 
        $current = $this_OverridingHiddens_2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele01ParserRuleCallInheritingHiddens(), currentNode); 
    }
    this_InheritingHiddens_3=ruleInheritingHiddens
    { 
        $current = $this_InheritingHiddens_3.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prModel().ele1ParserRuleCallDatatypeHiddens(), currentNode); 
    }
    this_DatatypeHiddens_4=ruleDatatypeHiddens
    { 
        $current = $this_DatatypeHiddens_4.current; 
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
    	lastConsumedNode = currentNode;
    }:
(((('without' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele0000KeywordWithout(), null); 
    }
(	
	
	    lv_spaces_1=RULE_WS	{
		createLeafNode(grammarAccess.prWithoutHiddens().ele00010ParserRuleCallWS(), "spaces"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prWithoutHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "spaces", lv_spaces_1, "WS", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'hiddens' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele001KeywordHiddens(), null); 
    }
)(	
	
	    lv_spaces_3=RULE_WS	{
		createLeafNode(grammarAccess.prWithoutHiddens().ele010ParserRuleCallWS(), "spaces"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prWithoutHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "spaces", lv_spaces_3, "WS", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(	
	
	    lv_valid_4=';' 
    {
        createLeafNode(grammarAccess.prWithoutHiddens().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prWithoutHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
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
    	lastConsumedNode = currentNode;
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
	
	    lv_valid_2=';' 
    {
        createLeafNode(grammarAccess.prWithHiddens().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prWithHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
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
    	lastConsumedNode = currentNode;
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
	    lv_called_3=ruleOverridingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prOverridingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "called", lv_called_3, "OverridingHiddensCall", currentNode);
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
	
	    lv_valid_5=';' 
    {
        createLeafNode(grammarAccess.prOverridingHiddens().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prOverridingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
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
    	lastConsumedNode = currentNode;
		myHiddenTokenState.restore();
    }:
(('call' 
    {
        createLeafNode(grammarAccess.prOverridingHiddensCall().ele00KeywordCall(), null); 
    }
(	
	
	    lv_spaces_1=RULE_WS	{
		createLeafNode(grammarAccess.prOverridingHiddensCall().ele010ParserRuleCallWS(), "spaces"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prOverridingHiddensCall().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "spaces", lv_spaces_1, "WS", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(	
	
	    lv_valid_2=';' 
    {
        createLeafNode(grammarAccess.prOverridingHiddensCall().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prOverridingHiddensCall().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
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
    	lastConsumedNode = currentNode;
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
	    lv_called_3=ruleInheritingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prInheritingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "called", lv_called_3, "InheritingHiddensCall", currentNode);
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
	    lv_hidingCalled_4=ruleHidingHiddens 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prInheritingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "hidingCalled", lv_hidingCalled_4, "HidingHiddens", currentNode);
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
	
	    lv_valid_6=';' 
    {
        createLeafNode(grammarAccess.prInheritingHiddens().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prInheritingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
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
    	lastConsumedNode = currentNode;
    }:
('datatype' 
    {
        createLeafNode(grammarAccess.prDatatypeHiddens().ele0KeywordDatatype(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prDatatypeHiddens().ele10ParserRuleCallDatatypeRule(), currentNode); 
	    }
	    lv_valid_1=ruleDatatypeRule 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prDatatypeHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "valid", true, "DatatypeRule", currentNode);
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
	    lastConsumedNode = currentNode;
	    lastConsumedDatatypeToken = $current;
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
    	lastConsumedNode = currentNode;
		myHiddenTokenState.restore();
    }:
(('hiding' 
    {
        createLeafNode(grammarAccess.prHidingHiddens().ele00KeywordHiding(), null); 
    }
(	
	
	    lv_space_1=RULE_WS	{
		createLeafNode(grammarAccess.prHidingHiddens().ele010ParserRuleCallWS(), "space"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prHidingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "space", lv_space_1, "WS", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prHidingHiddens().ele10ParserRuleCallInheritingHiddensCall(), currentNode); 
	    }
	    lv_called_2=ruleInheritingHiddensCall 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prHidingHiddens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "called", lv_called_2, "InheritingHiddensCall", currentNode);
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
    	lastConsumedNode = currentNode;
    }:
('call' 
    {
        createLeafNode(grammarAccess.prInheritingHiddensCall().ele0KeywordCall(), null); 
    }
(	
	
	    lv_valid_1=';' 
    {
        createLeafNode(grammarAccess.prInheritingHiddensCall().ele10KeywordSemicolon(), "valid"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prInheritingHiddensCall().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "valid", true, ";", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





































RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



RULE_WS : (((' '|'\t')|'\r')|'\n')+;



RULE_ANY_OTHER : .;




