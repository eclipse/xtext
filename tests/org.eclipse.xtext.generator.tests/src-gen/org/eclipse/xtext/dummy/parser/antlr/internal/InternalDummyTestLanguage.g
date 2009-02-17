/*
Generated with Xtext
*/
grammar InternalDummyTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.dummy.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.dummy.parser.antlr.internal; 

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
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;

}

@parser::members {
 
 	private DummyTestLanguageGrammarAccess grammarAccess;
 	
    public InternalDummyTestLanguageParser(TokenStream input, IAstFactory factory, DummyTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalDummyTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.tokens");
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
(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.prModel().ele0ParserRuleCallElement(), currentNode); 
	    }
	    lv_elements_0=ruleElement 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prModel().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "elements", lv_elements_0, "Element", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)*;







// Entry rule entryRuleElement
entryRuleElement returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.prElement().getRule(), currentNode); }
	 iv_ruleElement=ruleElement 
	 { $current=$iv_ruleElement.current; } 
	 EOF 
;

// Rule Element
ruleElement returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(((((	
	
	    lv_optional_0='optional' 
    {
        createLeafNode(grammarAccess.prElement().ele00000KeywordOptional(), "optional"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prElement().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "optional", true, "optional", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?'element' 
    {
        createLeafNode(grammarAccess.prElement().ele0001KeywordElement(), null); 
    }
)(	
	
	    lv_name_2=	RULE_ID
	{
		createLeafNode(grammarAccess.prElement().ele0010LexerRuleCallID(), "name"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prElement().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "name", lv_name_2, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))(	
	
	    lv_descriptions_3=	RULE_STRING
	{
		createLeafNode(grammarAccess.prElement().ele010LexerRuleCallSTRING(), "descriptions"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.prElement().getRule().getType().getType());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		add($current, "descriptions", lv_descriptions_3, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)*)';' 
    {
        createLeafNode(grammarAccess.prElement().ele1KeywordSemicolon(), null); 
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


