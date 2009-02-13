/*
Generated with Xtext
*/
grammar InternalFormatterTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

}

@parser::members {
 
 	private FormatterTestLanguageGrammarAccess grammarAccess;
 	
    public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, FormatterTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalFormatterTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.tokens");
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
(
    { 
        currentNode=createCompositeNode(grammarAccess.prRoot().ele10ParserRuleCallTestLinewrap(), currentNode); 
    }
    this_TestLinewrap_1=ruleTestLinewrap
    { 
        $current = $this_TestLinewrap_1.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode(grammarAccess.prRoot().ele11ParserRuleCallTestIndentation(), currentNode); 
    }
    this_TestIndentation_2=ruleTestIndentation
    { 
        $current = $this_TestIndentation_2.current; 
        currentNode = currentNode.getParent();
    }
));







// Entry rule entryRuleLine
entryRuleLine returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prLine().getRule(), currentNode); }
	 iv_ruleLine=ruleLine 
	 { $current=$iv_ruleLine.current; } 
	 EOF 
;

// Rule Line
ruleLine returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(((	
	
	    lv_type_0=	RULE_ID
	{
		createLeafNode(grammarAccess.prLine().ele000LexerRuleCallID(), "type"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("Line");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "type", lv_type_0, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_name_1=	RULE_ID
	{
		createLeafNode(grammarAccess.prLine().ele010LexerRuleCallID(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create("Line");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "name", lv_name_1, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))';' 
    {
        createLeafNode(grammarAccess.prLine().ele1KeywordSemicolon(), null); 
    }
);







// Entry rule entryRuleTestLinewrap
entryRuleTestLinewrap returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTestLinewrap().getRule(), currentNode); }
	 iv_ruleTestLinewrap=ruleTestLinewrap 
	 { $current=$iv_ruleTestLinewrap.current; } 
	 EOF 
;

// Rule TestLinewrap
ruleTestLinewrap returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('linewrap' 
    {
        createLeafNode(grammarAccess.prTestLinewrap().ele0KeywordLinewrap(), null); 
    }
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTestLinewrap().ele10ParserRuleCallLine(), currentNode); 
	    }
	    lv_items_1=ruleLine 
	    {
	        if ($current==null) {
	            $current = factory.create("TestLinewrap");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "items", lv_items_1, "Line", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*);







// Entry rule entryRuleTestIndentation
entryRuleTestIndentation returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prTestIndentation().getRule(), currentNode); }
	 iv_ruleTestIndentation=ruleTestIndentation 
	 { $current=$iv_ruleTestIndentation.current; } 
	 EOF 
;

// Rule TestIndentation
ruleTestIndentation returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
((('indentation' 
    {
        createLeafNode(grammarAccess.prTestIndentation().ele000KeywordIndentation(), null); 
    }
'{' 
    {
        createLeafNode(grammarAccess.prTestIndentation().ele001KeywordLeftCurlyBracket(), null); 
    }
)((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTestIndentation().ele0100ParserRuleCallTestIndentation(), currentNode); 
	    }
	    lv_sub_2=ruleTestIndentation 
	    {
	        if ($current==null) {
	            $current = factory.create("TestIndentation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "sub", lv_sub_2, "TestIndentation", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prTestIndentation().ele0110ParserRuleCallLine(), currentNode); 
	    }
	    lv_items_3=ruleLine 
	    {
	        if ($current==null) {
	            $current = factory.create("TestIndentation");
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "items", lv_items_3, "Line", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))*)'}' 
    {
        createLeafNode(grammarAccess.prTestIndentation().ele1KeywordRightCurlyBracket(), null); 
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


