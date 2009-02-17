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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;

}

@parser::members {
 
 	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
 	
    public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
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
	{ currentNode = createCompositeNode(grammarAccess.prOp().getRule(), currentNode); }
	 iv_ruleOp=ruleOp 
	 { $current=$iv_ruleOp.current; } 
	 EOF 
;

// Rule Op
ruleOp returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prOp().ele0ParserRuleCallTerm(), currentNode); 
    }
    this_Term_0=ruleTerm
    { 
        $current = $this_Term_0.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create(grammarAccess.prOp().ele10ActionOpvalues().getTypeName().getType());
        try {
        	factory.add(temp, "values", $current, null /*ParserRule*/, currentNode);
        } catch(ValueConverterException vce) {
        	handleValueConverterException(vce);
        }
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode(grammarAccess.prOp().ele10ActionOpvalues(), currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prOp().ele110ParserRuleCallTerm(), currentNode); 
	    }
	    lv_values_2=ruleTerm 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prOp().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "values", lv_values_2, "Term", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*);







// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTerm().getRule(), currentNode); }
	 iv_ruleTerm=ruleTerm 
	 { $current=$iv_ruleTerm.current; } 
	 EOF 
;

// Rule Term
ruleTerm returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(((((((
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele0000000ParserRuleCallAtom(), currentNode); 
    }
    this_Atom_0=ruleAtom
    { 
        $current = $this_Atom_0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele0000001ParserRuleCallTwoNumbers(), currentNode); 
    }
    this_TwoNumbers_1=ruleTwoNumbers
    { 
        $current = $this_TwoNumbers_1.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele000001ParserRuleCallManyStrings(), currentNode); 
    }
    this_ManyStrings_2=ruleManyStrings
    { 
        $current = $this_ManyStrings_2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele00001ParserRuleCallParens(), currentNode); 
    }
    this_Parens_3=ruleParens
    { 
        $current = $this_Parens_3.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele0001ParserRuleCallType(), currentNode); 
    }
    this_Type_4=ruleType
    { 
        $current = $this_Type_4.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele001ParserRuleCallRef2(), currentNode); 
    }
    this_Ref2_5=ruleRef2
    { 
        $current = $this_Ref2_5.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele01ParserRuleCallSpare(), currentNode); 
    }
    this_Spare_6=ruleSpare
    { 
        $current = $this_Spare_6.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prTerm().ele1ParserRuleCallBoolean(), currentNode); 
    }
    this_Boolean_7=ruleBoolean
    { 
        $current = $this_Boolean_7.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prAtom().getRule(), currentNode); }
	 iv_ruleAtom=ruleAtom 
	 { $current=$iv_ruleAtom.current; } 
	 EOF 
;

// Rule Atom
ruleAtom returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(	
	
	    lv_name_0=	RULE_ID
	{
		createLeafNode(grammarAccess.prAtom().ele0LexerRuleCallID(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prAtom().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "name", lv_name_0, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleParens
entryRuleParens returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prParens().getRule(), currentNode); }
	 iv_ruleParens=ruleParens 
	 { $current=$iv_ruleParens.current; } 
	 EOF 
;

// Rule Parens
ruleParens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
((('(' 
    {
        createLeafNode(grammarAccess.prParens().ele000KeywordLeftParenthesis(), null); 
    }

    { 
        currentNode=createCompositeNode(grammarAccess.prParens().ele001ParserRuleCallOp(), currentNode); 
    }
    this_Op_1=ruleOp
    { 
        $current = $this_Op_1.current; 
        currentNode = currentNode.getParent();
    }
)')' 
    {
        createLeafNode(grammarAccess.prParens().ele01KeywordRightParenthesis(), null); 
    }
)(	
	
	    lv_em_3='!' 
    {
        createLeafNode(grammarAccess.prParens().ele10KeywordExclamationMark(), "em"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prParens().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "em", /* lv_em_3 */ input.LT(-1), "!", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?);







// Entry rule entryRuleTwoNumbers
entryRuleTwoNumbers returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTwoNumbers().getRule(), currentNode); }
	 iv_ruleTwoNumbers=ruleTwoNumbers 
	 { $current=$iv_ruleTwoNumbers.current; } 
	 EOF 
;

// Rule TwoNumbers
ruleTwoNumbers returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(((	
	
	    lv_num1_0=	RULE_INT
	{
		createLeafNode(grammarAccess.prTwoNumbers().ele000LexerRuleCallINT(), "num1"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "num1", lv_num1_0, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_num2_1=	RULE_INT
	{
		createLeafNode(grammarAccess.prTwoNumbers().ele010LexerRuleCallINT(), "num2"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "num2", lv_num2_1, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('#' 
    {
        createLeafNode(grammarAccess.prTwoNumbers().ele10KeywordNumberSign(), null); 
    }
(	
	
	    lv_num3_3=	RULE_INT
	{
		createLeafNode(grammarAccess.prTwoNumbers().ele110LexerRuleCallINT(), "num3"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prTwoNumbers().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "num3", lv_num3_3, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);







// Entry rule entryRuleManyStrings
entryRuleManyStrings returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prManyStrings().getRule(), currentNode); }
	 iv_ruleManyStrings=ruleManyStrings 
	 { $current=$iv_ruleManyStrings.current; } 
	 EOF 
;

// Rule ManyStrings
ruleManyStrings returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(('=' 
    {
        createLeafNode(grammarAccess.prManyStrings().ele00KeywordEqualsSign(), null); 
    }
(	
	
	    lv_str1_1=	RULE_STRING
	{
		createLeafNode(grammarAccess.prManyStrings().ele010LexerRuleCallSTRING(), "str1"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prManyStrings().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "str1", lv_str1_1, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)(	
	
	    lv_str2_2=	RULE_STRING
	{
		createLeafNode(grammarAccess.prManyStrings().ele10LexerRuleCallSTRING(), "str2"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prManyStrings().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "str2", lv_str2_2, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleType
entryRuleType returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); }
	 iv_ruleType=ruleType 
	 { $current=$iv_ruleType.current; } 
	 EOF 
;

// Rule Type
ruleType returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
((('type' 
    {
        createLeafNode(grammarAccess.prType().ele000KeywordType(), null); 
    }
(	
	
	    lv_name_1=	RULE_ID
	{
		createLeafNode(grammarAccess.prType().ele0010LexerRuleCallID(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prType().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "name", lv_name_1, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))'extends' 
    {
        createLeafNode(grammarAccess.prType().ele01KeywordExtends(), null); 
    }
)(	
	
		
		{
			if ($current==null) {
	            $current = factory.create(grammarAccess.prType().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
	RULE_ID
	{
		createLeafNode(grammarAccess.prType().ele10CrossReferenceEStringType(), "extends"); 
	}

		// TODO assign feature to currentNode
	
));







// Entry rule entryRuleRef2
entryRuleRef2 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prRef2().getRule(), currentNode); }
	 iv_ruleRef2=ruleRef2 
	 { $current=$iv_ruleRef2.current; } 
	 EOF 
;

// Rule Ref2
ruleRef2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('#2' 
    {
        createLeafNode(grammarAccess.prRef2().ele0KeywordNumberSignDigitTwo(), null); 
    }
(	
	
	    lv_ref2_1=(('mykeyword1' 
    {
        createLeafNode(grammarAccess.prRef2().ele1000KeywordMykeyword1(), "ref2"); 
    }


    |	RULE_STRING
	{
		createLeafNode(grammarAccess.prRef2().ele1001LexerRuleCallSTRING(), "ref2"); 
	}
)

    |'mykeyword2' 
    {
        createLeafNode(grammarAccess.prRef2().ele101KeywordMykeyword2(), "ref2"); 
    }

)
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prRef2().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "ref2", /* lv_ref2_1 */ input.LT(-1), null, lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleSpare
entryRuleSpare returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prSpare().getRule(), currentNode); }
	 iv_ruleSpare=ruleSpare 
	 { $current=$iv_ruleSpare.current; } 
	 EOF 
;

// Rule Spare
ruleSpare returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(('#3' 
    {
        createLeafNode(grammarAccess.prSpare().ele00KeywordNumberSignDigitThree(), null); 
    }
(	
	
	    lv_id_1=	RULE_ID
	{
		createLeafNode(grammarAccess.prSpare().ele010LexerRuleCallID(), "id"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prSpare().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "id", lv_id_1, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))('.' 
    {
        createLeafNode(grammarAccess.prSpare().ele10KeywordFullStop(), null); 
    }
(	
	
	    lv_id_3=	RULE_ID
	{
		createLeafNode(grammarAccess.prSpare().ele110LexerRuleCallID(), "id"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prSpare().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "id", lv_id_3, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))*);







// Entry rule entryRuleBoolean
entryRuleBoolean returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prBoolean().getRule(), currentNode); }
	 iv_ruleBoolean=ruleBoolean 
	 { $current=$iv_ruleBoolean.current; } 
	 EOF 
;

// Rule Boolean
ruleBoolean returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
((('#4' 
    {
        createLeafNode(grammarAccess.prBoolean().ele000KeywordNumberSignDigitFour(), null); 
    }
(	
	
	    lv_bool_1='myoption' 
    {
        createLeafNode(grammarAccess.prBoolean().ele0010KeywordMyoption(), "bool"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prBoolean().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "bool", true, "myoption", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)'kw' 
    {
        createLeafNode(grammarAccess.prBoolean().ele01KeywordKw(), null); 
    }
)(	
	
	    lv_value_3=	RULE_ID
	{
		createLeafNode(grammarAccess.prBoolean().ele10LexerRuleCallID(), "value"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prBoolean().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "value", lv_value_3, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));



























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


