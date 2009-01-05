/*
Generated with Xtext
*/
grammar InternalComplexReconstrTestLanguage;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;

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
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTestLanguage.tokens");
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Term=ruleTerm
    { 
        $current = $this_Term.current; 
        currentNode = currentNode.getParent();
    }
((((
    { 
        temp=factory.create("Add");
        factory.add(temp, "addOperands", $current, null /*ParserRule*/, currentNode);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'+' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        factory.add(temp, "minusOperands", $current, null /*ParserRule*/, currentNode);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'-' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Atom=ruleAtom
    { 
        $current = $this_Atom.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Parens=ruleParens
    { 
        $current = $this_Parens.current; 
        currentNode = currentNode.getParent();
    }
);





// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
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
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.2/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
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
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }

    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Op=ruleOp
    { 
        $current = $this_Op.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
    }
)(	
	
	    lv_em='!' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); }
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
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi#//@rules.5/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
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















RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


