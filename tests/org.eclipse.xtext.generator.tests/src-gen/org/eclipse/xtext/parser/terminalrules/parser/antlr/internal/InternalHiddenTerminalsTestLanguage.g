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

}

@parser::members {
 
    public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
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
(((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_WithoutHiddens=ruleWithoutHiddens
    { 
        $current = $this_WithoutHiddens.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_WithHiddens=ruleWithHiddens
    { 
        $current = $this_WithHiddens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_OverridingHiddens=ruleOverridingHiddens
    { 
        $current = $this_OverridingHiddens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_InheritingHiddens=ruleInheritingHiddens
    { 
        $current = $this_InheritingHiddens.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleWithoutHiddens
entryRuleWithoutHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'hiddens' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'hiddens' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_spaces=RULE_WS
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
'hiddens' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)'(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
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
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_valid=';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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







// Entry rule entryRuleHidingHiddens
entryRuleHidingHiddens returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_space=RULE_WS
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "space"); 
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
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_valid=';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
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




