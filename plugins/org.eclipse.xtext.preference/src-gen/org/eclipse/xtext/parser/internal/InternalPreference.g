
/*
Generated with Xtext
*/
grammar InternalPreference;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
}

@parser::members {
 
    public InternalPreferenceParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalPreferenceParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/internal/InternalPreference.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Description";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleDescription
entryRuleDescription returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleDescription=ruleDescription 
	 { $current=$iv_ruleDescription.current; } 
	 EOF 
;

// Rule Description
ruleDescription returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('commonprefix' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_idPrefix=ruleQName 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Description");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "idPrefix", lv_idPrefix,null);
        
         }
))(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_pages=rulePage 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Description");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "pages", lv_pages,null);
        
         }
));
    


// Entry rule entryRulePage
entryRulePage returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); }
	 iv_rulePage=rulePage 
	 { $current=$iv_rulePage.current; } 
	 EOF 
;

// Rule Page
rulePage returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('page' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_name=ruleQName 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Page");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,null);
        
         }
))(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_panel=rulePanel 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Page");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "panel", lv_panel,null);
        
         }
));
    


// Entry rule entryRulePanel
entryRulePanel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); }
	 iv_rulePanel=rulePanel 
	 { $current=$iv_rulePanel.current; } 
	 EOF 
;

// Rule Panel
rulePanel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_rows=ruleRow 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Panel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "rows", lv_rows,null);
        
         }
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleRow
entryRuleRow returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRow=ruleRow 
	 { $current=$iv_ruleRow.current; } 
	 EOF 
;

// Rule Row
ruleRow returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_entries=ruleEntry 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Row");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "entries", lv_entries,null);
        
         }
)*';' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleEntry
entryRuleEntry returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEntry=ruleEntry 
	 { $current=$iv_ruleEntry.current; } 
	 EOF 
;

// Rule Entry
ruleEntry returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    lv_colspan='#' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@terminal" /* xtext::Keyword */, "colspan"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Entry");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "colspan", input.LT(-1),"#");
        
         }
)+(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_widget=ruleWidget 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Entry");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "widget", lv_widget,null);
        
         }
));
    


// Entry rule entryRuleWidget
entryRuleWidget returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleWidget=ruleWidget 
	 { $current=$iv_ruleWidget.current; } 
	 EOF 
;

// Rule Widget
ruleWidget returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Label=ruleLabel
    { 
        $current = $this_Label.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Text=ruleText
    { 
        $current = $this_Text.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Check=ruleCheck
    { 
        $current = $this_Check.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Combo=ruleCombo
    { 
        $current = $this_Combo.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Panel=rulePanel
    { 
        $current = $this_Panel.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_NamedPanel=ruleNamedPanel
    { 
        $current = $this_NamedPanel.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.5/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_CheckedPanel=ruleCheckedPanel
    { 
        $current = $this_CheckedPanel.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleNamedPanel
entryRuleNamedPanel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleNamedPanel=ruleNamedPanel 
	 { $current=$iv_ruleNamedPanel.current; } 
	 EOF 
;

// Rule NamedPanel
ruleNamedPanel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((
    lv_name=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("NamedPanel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"STRING");
        
         }
)'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_rows=ruleRow 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("NamedPanel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "rows", lv_rows,null);
        
         }
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleCheckedPanel
entryRuleCheckedPanel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCheckedPanel=ruleCheckedPanel 
	 { $current=$iv_ruleCheckedPanel.current; } 
	 EOF 
;

// Rule CheckedPanel
ruleCheckedPanel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((((
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("CheckedPanel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
))'{' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_rows=ruleRow 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("CheckedPanel");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "rows", lv_rows,null);
        
         }
)*)'}' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);
    


// Entry rule entryRuleLabel
entryRuleLabel returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLabel=ruleLabel 
	 { $current=$iv_ruleLabel.current; } 
	 EOF 
;

// Rule Label
ruleLabel returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_value=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.8/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Label");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "value", lv_value,"STRING");
        
         }
);
    


// Entry rule entryRuleText
entryRuleText returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.9" /* xtext::ParserRule */, currentNode); }
	 iv_ruleText=ruleText 
	 { $current=$iv_ruleText.current; } 
	 EOF 
;

// Rule Text
ruleText returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.9/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Text");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
);
    


// Entry rule entryRuleCheck
entryRuleCheck returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.10" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCheck=ruleCheck 
	 { $current=$iv_ruleCheck.current; } 
	 EOF 
;

// Rule Check
ruleCheck returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('?' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.10/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Check");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
));
    


// Entry rule entryRuleCombo
entryRuleCombo returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11" /* xtext::ParserRule */, currentNode); }
	 iv_ruleCombo=ruleCombo 
	 { $current=$iv_ruleCombo.current; } 
	 EOF 
;

// Rule Combo
ruleCombo returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_alts=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alts"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Combo");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "alts", lv_alts,"STRING");
        
         }
))(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(
    lv_alts=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alts"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Combo");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "alts", lv_alts,"STRING");
        
         }
)))']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Combo");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.set($current, "name", lv_name,"ID");
        
         }
));
    


// Entry rule entryRuleQName
entryRuleQName returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleQName=ruleQName 
	 { $current=$iv_ruleQName.current; } 
	 EOF 
;

// Rule QName
ruleQName returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    lv_element=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "element"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("QName");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "element", lv_element,"ID");
        
         }
)((
    lv_element='.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::Keyword */, "element"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("QName");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "element", input.LT(-1),".");
        
         }
)(
    lv_element=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/Preference.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "element"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("QName");
            associateNodeWithAstElement(currentNode, $current);
        }
        
        factory.add($current, "element", lv_element,"ID");
        
         }
))*);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


