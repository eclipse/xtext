/*
Generated with Xtext
*/
grammar InternalComplexReconstrTestLanguage;

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
 
    public InternalComplexReconstrTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalComplexReconstrTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalComplexReconstrTestLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Root";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleRoot
entryRuleRoot returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRoot=ruleRoot 
	 { $current=$iv_ruleRoot.current; } 
	 EOF 
;

// Rule Root
ruleRoot returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Op=ruleOp
    { 
        $current = $this_Op.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TrickyG=ruleTrickyG
    { 
        $current = $this_TrickyG.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleOp
entryRuleOp returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Term=ruleTerm
    { 
        $current = $this_Term.current; 
        currentNode = currentNode.getParent();
    }
((((
    { 
        temp=factory.create("Add");
        try {
        	factory.add(temp, "addOperands", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_addOperands=ruleTerm 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "addOperands", lv_addOperands, "Term", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |(((
    { 
        temp=factory.create("Minus");
        try {
        	factory.add(temp, "minusOperands", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'-' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_minusOperands=ruleTerm 
	    {
	        if ($current==null) {
	            $current = factory.create("Expression");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "minusOperands", lv_minusOperands, "Term", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))*);





// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerm=ruleTerm 
	 { $current=$iv_ruleTerm.current; } 
	 EOF 
;

// Rule Term
ruleTerm returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Atom=ruleAtom
    { 
        $current = $this_Atom.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Parens=ruleParens
    { 
        $current = $this_Parens.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
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
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Op=ruleOp
    { 
        $current = $this_Op.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_em='!' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
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







// Entry rule entryRuleTrickyA1
entryRuleTrickyA1 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTrickyA1=ruleTrickyA1 
	 { $current=$iv_ruleTrickyA1.current; } 
	 EOF 
;

// Rule TrickyA1
ruleTrickyA1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.6/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TypeD");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.add($current, "name", lv_name, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);















// Entry rule entryRuleTrickyG
entryRuleTrickyG returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTrickyG=ruleTrickyG 
	 { $current=$iv_ruleTrickyG.current; } 
	 EOF 
;

// Rule TrickyG
ruleTrickyG returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('TG' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_tree=ruleTrickyG1 
	    {
	        if ($current==null) {
	            $current = factory.create("TrickyG");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.set($current, "tree", lv_tree, "TrickyG1", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
));





// Entry rule entryRuleTrickyG1
entryRuleTrickyG1 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTrickyG1=ruleTrickyG1 
	 { $current=$iv_ruleTrickyG1.current; } 
	 EOF 
;

// Rule TrickyG1
ruleTrickyG1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('[' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_vals=ruleTrickyG2 
	    {
	        if ($current==null) {
	            $current = factory.create("TrickyG1");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "vals", lv_vals, "TrickyG2", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(',' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
	    }
	    lv_vals=ruleTrickyG2 
	    {
	        if ($current==null) {
	            $current = factory.create("TrickyG1");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	        	factory.add($current, "vals", lv_vals, "TrickyG2", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)?)']' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
);





// Entry rule entryRuleTrickyG2
entryRuleTrickyG2 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTrickyG2=ruleTrickyG2 
	 { $current=$iv_ruleTrickyG2.current; } 
	 EOF 
;

// Rule TrickyG2
ruleTrickyG2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.14/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TrickyG1=ruleTrickyG1
    { 
        $current = $this_TrickyG1.current; 
        currentNode = currentNode.getParent();
    }

    |(	
	
	    lv_val=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.14/@alternatives/@groups.1/@terminal" /* xtext::RuleCall */, "val"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TrickyG2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "val", lv_val, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


