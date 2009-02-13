/*
Generated with Xtext
*/
grammar InternalBug250313;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.valueconverter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

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
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

}

@parser::members {
 
 	private Bug250313GrammarAccess grammarAccess;
 	
    public InternalBug250313Parser(TokenStream input, IAstFactory factory, Bug250313GrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalBug250313Parser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.tokens");
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
((((('#' 
    {
        createLeafNode(grammarAccess.prModel().ele0000KeywordNumberSign(), null); 
    }
)?(	
	
	    lv_value_1=((('mykeyword1' 
    {
        createLeafNode(grammarAccess.prModel().ele00010000KeywordMykeyword1(), "value"); 
    }


    |	RULE_STRING
	{
		createLeafNode(grammarAccess.prModel().ele00010001LexerRuleCallSTRING(), "value"); 
	}
)

    |		{ 
	        currentNode=createCompositeNode(grammarAccess.prModel().ele0001001ParserRuleCallDatatype(), currentNode); 
	    }
		ruleDatatype		{ 
	        currentNode = currentNode.getParent();
	    }
)

    |	RULE_ID
	{
		createLeafNode(grammarAccess.prModel().ele000101LexerRuleCallID(), "value"); 
	}
)
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "value", /* lv_value_1 */ input.LT(-1), null, lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |('!' 
    {
        createLeafNode(grammarAccess.prModel().ele0010KeywordExclamationMark(), null); 
    }
(	
	
	    lv_value_3=	RULE_STRING
	{
		createLeafNode(grammarAccess.prModel().ele00110LexerRuleCallSTRING(), "value"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "value", lv_value_3, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)))
    |('$' 
    {
        createLeafNode(grammarAccess.prModel().ele010Keyword$(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prModel().ele0110ParserRuleCallDatatype(), currentNode); 
	    }
	    lv_value_5=ruleDatatype 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "value", lv_value_5, "Datatype", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)))
    |(('content' 
    {
        createLeafNode(grammarAccess.prModel().ele100KeywordContent(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prModel().ele1010ParserRuleCallChild(), currentNode); 
	    }
	    lv_children_7=ruleChild 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "children", lv_children_7, "Child", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))('ref' 
    {
        createLeafNode(grammarAccess.prModel().ele110KeywordRef(), null); 
    }
(	
	
		
		{
			if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
        }
(	RULE_STRING
	{
		createLeafNode(grammarAccess.prModel().ele11100CrossReferenceEStringChild1(), "ref"); 
	}

    |	RULE_ID
	{
		createLeafNode(grammarAccess.prModel().ele11101CrossReferenceEStringChild2(), "ref"); 
	}
)

		// TODO assign feature to currentNode
	
))?));







// Entry rule entryRuleDatatype
entryRuleDatatype returns [String current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prDatatype().getRule(), currentNode); } 
	 iv_ruleDatatype=ruleDatatype 
	 { $current=$iv_ruleDatatype.current.getText(); }  
	 EOF 
;

// Rule Datatype
ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
	    lastConsumedNode = currentNode;
	    lastConsumedDatatypeToken = $current;
    }:
(((
	kw='>>' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prDatatype().ele000KeywordGreaterThanSignGreaterThanSign(), null); 
    }
    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    createLeafNode(grammarAccess.prDatatype().ele001LexerRuleCallID(), null); 
    }
)
	kw='-' 
    {
        $current.merge(kw);
        createLeafNode(grammarAccess.prDatatype().ele01KeywordHyphenMinus(), null); 
    }
)    this_ID_3=RULE_ID    {
		$current.merge(this_ID_3);
    }

    { 
    createLeafNode(grammarAccess.prDatatype().ele1LexerRuleCallID(), null); 
    }
)
    ;







// Entry rule entryRuleChild
entryRuleChild returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prChild().getRule(), currentNode); }
	 iv_ruleChild=ruleChild 
	 { $current=$iv_ruleChild.current; } 
	 EOF 
;

// Rule Child
ruleChild returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(
    { 
        currentNode=createCompositeNode(grammarAccess.prChild().ele0ParserRuleCallChild1(), currentNode); 
    }
    this_Child1_0=ruleChild1
    { 
        $current = $this_Child1_0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prChild().ele1ParserRuleCallChild2(), currentNode); 
    }
    this_Child2_1=ruleChild2
    { 
        $current = $this_Child2_1.current; 
        currentNode = currentNode.getParent();
    }
);







// Entry rule entryRuleChild1
entryRuleChild1 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prChild1().getRule(), currentNode); }
	 iv_ruleChild1=ruleChild1 
	 { $current=$iv_ruleChild1.current; } 
	 EOF 
;

// Rule Child1
ruleChild1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(	
	
	    lv_name_0=	RULE_ID
	{
		createLeafNode(grammarAccess.prChild1().ele0LexerRuleCallID(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("Child1");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "name", lv_name_0, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
);







// Entry rule entryRuleChild2
entryRuleChild2 returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prChild2().getRule(), currentNode); }
	 iv_ruleChild2=ruleChild2 
	 { $current=$iv_ruleChild2.current; } 
	 EOF 
;

// Rule Child2
ruleChild2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(	
	
	    lv_name_0=	RULE_STRING
	{
		createLeafNode(grammarAccess.prChild2().ele0LexerRuleCallSTRING(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("Child2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "name", lv_name_0, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
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


