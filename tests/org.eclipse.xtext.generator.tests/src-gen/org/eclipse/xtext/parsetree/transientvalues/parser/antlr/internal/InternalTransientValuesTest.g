/*
Generated with Xtext
*/
grammar InternalTransientValuesTest;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;

}

@parser::members {
 
 	private TransientValuesTestGrammarAccess grammarAccess;
 	
    public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, TransientValuesTestGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalTransientValuesTestParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.tokens");
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
	{ currentNode = createCompositeNode(grammarAccess.prRoot().getRule(), currentNode); }
	 iv_ruleRoot=ruleRoot 
	 { $current=$iv_ruleRoot.current; } 
	 EOF 
;

// Rule Root
ruleRoot returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('test' 
    {
        createLeafNode(grammarAccess.prRoot().ele0KeywordTest(), null); 
    }
((
    { 
        currentNode=createCompositeNode(grammarAccess.prRoot().ele100ParserRuleCallTestRequired(), currentNode); 
    }
    this_TestRequired_1=ruleTestRequired
    { 
        $current = $this_TestRequired_1.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRoot().ele101ParserRuleCallTestOptional(), currentNode); 
    }
    this_TestOptional_2=ruleTestOptional
    { 
        $current = $this_TestOptional_2.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRoot().ele11ParserRuleCallTestList(), currentNode); 
    }
    this_TestList_3=ruleTestList
    { 
        $current = $this_TestList_3.current; 
        currentNode = currentNode.getParent();
    }
));







// Entry rule entryRuleTestRequired
entryRuleTestRequired returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTestRequired().getRule(), currentNode); }
	 iv_ruleTestRequired=ruleTestRequired 
	 { $current=$iv_ruleTestRequired.current; } 
	 EOF 
;

// Rule TestRequired
ruleTestRequired returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(('required' 
    {
        createLeafNode(grammarAccess.prTestRequired().ele00KeywordRequired(), null); 
    }
(	
	
	    lv_required1_1=	RULE_INT
	{
		createLeafNode(grammarAccess.prTestRequired().ele010LexerRuleCallINT(), "required1"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestRequired");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "required1", lv_required1_1, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_required2_2=	RULE_INT
	{
		createLeafNode(grammarAccess.prTestRequired().ele10LexerRuleCallINT(), "required2"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestRequired");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "required2", lv_required2_2, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));







// Entry rule entryRuleTestOptional
entryRuleTestOptional returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTestOptional().getRule(), currentNode); }
	 iv_ruleTestOptional=ruleTestOptional 
	 { $current=$iv_ruleTestOptional.current; } 
	 EOF 
;

// Rule TestOptional
ruleTestOptional returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(('optional' 
    {
        createLeafNode(grammarAccess.prTestOptional().ele00KeywordOptional(), null); 
    }
(	
	
	    lv_opt1_1=	RULE_INT
	{
		createLeafNode(grammarAccess.prTestOptional().ele010LexerRuleCallINT(), "opt1"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestOptional");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "opt1", lv_opt1_1, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?)(':' 
    {
        createLeafNode(grammarAccess.prTestOptional().ele10KeywordColon(), null); 
    }
(	
	
	    lv_opt2_3=	RULE_INT
	{
		createLeafNode(grammarAccess.prTestOptional().ele110LexerRuleCallINT(), "opt2"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestOptional");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "opt2", lv_opt2_3, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))?);







// Entry rule entryRuleTestList
entryRuleTestList returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTestList().getRule(), currentNode); }
	 iv_ruleTestList=ruleTestList 
	 { $current=$iv_ruleTestList.current; } 
	 EOF 
;

// Rule TestList
ruleTestList returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('list' 
    {
        createLeafNode(grammarAccess.prTestList().ele0KeywordList(), null); 
    }
(	
	
	    lv_item_1=	RULE_INT
	{
		createLeafNode(grammarAccess.prTestList().ele10LexerRuleCallINT(), "item"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestList");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "item", lv_item_1, "INT", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*);















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


