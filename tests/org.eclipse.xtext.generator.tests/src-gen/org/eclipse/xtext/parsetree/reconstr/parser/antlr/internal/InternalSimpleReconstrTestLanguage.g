/*
Generated with Xtext
*/
grammar InternalSimpleReconstrTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;

}

@parser::members {
 
    public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalSimpleReconstrTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Op";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleOp
entryRuleOp returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleOp=ruleOp 
	 { $current=$iv_ruleOp.current; } 
	 EOF 
;

// Rule Op
ruleOp returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Term=ruleTerm
    { 
        $current = $this_Term.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Op");
        try {
        	factory.add(temp, "values", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_values=ruleTerm 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "values", lv_values, "Term", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);





// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerm=ruleTerm 
	 { $current=$iv_ruleTerm.current; } 
	 EOF 
;

// Rule Term
ruleTerm returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Atom=ruleAtom
    { 
        $current = $this_Atom.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TwoNumbers=ruleTwoNumbers
    { 
        $current = $this_TwoNumbers.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ManyStrings=ruleManyStrings
    { 
        $current = $this_ManyStrings.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Parens=ruleParens
    { 
        $current = $this_Parens.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Type=ruleType
    { 
        $current = $this_Type.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Ref2=ruleRef2
    { 
        $current = $this_Ref2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Spare=ruleSpare
    { 
        $current = $this_Spare.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAtom=ruleAtom 
	 { $current=$iv_ruleAtom.current; } 
	 EOF 
;

// Rule Atom
ruleAtom returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.2/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Atom");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);





// Entry rule entryRuleParens
entryRuleParens returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParens=ruleParens 
	 { $current=$iv_ruleParens.current; } 
	 EOF 
;

// Rule Parens
ruleParens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('(' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Op=ruleOp
    { 
        $current = $this_Op.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_em='!' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "em", input.LT(-1), "!", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?);





// Entry rule entryRuleTwoNumbers
entryRuleTwoNumbers returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTwoNumbers=ruleTwoNumbers 
	 { $current=$iv_ruleTwoNumbers.current; } 
	 EOF 
;

// Rule TwoNumbers
ruleTwoNumbers returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((	
	
	    lv_num1=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "num1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TwoNumbers");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "num1", lv_num1, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_num2=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num2"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TwoNumbers");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "num2", lv_num2, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('#' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_num3=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num3"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TwoNumbers");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "num3", lv_num3, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);





// Entry rule entryRuleManyStrings
entryRuleManyStrings returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleManyStrings=ruleManyStrings 
	 { $current=$iv_ruleManyStrings.current; } 
	 EOF 
;

// Rule ManyStrings
ruleManyStrings returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('=' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_str1=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ManyStrings");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "str1", lv_str1, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)(	
	
	    lv_str2=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str2"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("ManyStrings");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "str2", lv_str2, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleType
entryRuleType returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleType=ruleType 
	 { $current=$iv_ruleType.current; } 
	 EOF 
;

// Rule Type
ruleType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('type' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Type");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'extends' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Type");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(
	RULE_ID    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
    }
) 
	
));





// Entry rule entryRuleRef2
entryRuleRef2 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRef2=ruleRef2 
	 { $current=$iv_ruleRef2.current; } 
	 EOF 
;

// Rule Ref2
ruleRef2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('#2' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_ref2=(('mykeyword1' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "ref2"); 
    }

    |RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "ref2"); 
    }
)
    |'mykeyword2' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "ref2"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Ref2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "ref2", input.LT(-1), null, currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleSpare
entryRuleSpare returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpare=ruleSpare 
	 { $current=$iv_ruleSpare.current; } 
	 EOF 
;

// Rule Spare
ruleSpare returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('#3' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_id=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "id"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spare");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "id", lv_id, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('.' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_id=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "id"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Spare");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "id", lv_id, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);





RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


