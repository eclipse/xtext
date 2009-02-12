/*
Generated with Xtext
*/
grammar InternalTerminalRulesTestLanguage;

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
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;

}

@parser::members {
 
 	private TerminalRulesTestLanguageGrammarAccess grammarAccess;
 	
    public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
        super(input, factory, grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalTerminalRulesTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.tokens");
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
    }:
(((((((	
	
	    lv_idValue=RULE_ID
    { 
    createLeafNode(grammarAccess.prModel().ele0000000ParserRuleCallID(), "idValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "idValue", lv_idValue, "ID", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_intValue=RULE_INT
    { 
    createLeafNode(grammarAccess.prModel().ele0000010ParserRuleCallINT(), "intValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "intValue", lv_intValue, "INT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_stringValue=RULE_STRING
    { 
    createLeafNode(grammarAccess.prModel().ele000010ParserRuleCallSTRING(), "stringValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "stringValue", lv_stringValue, "STRING", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_mlCommentValue=RULE_ML_COMMENT
    { 
    createLeafNode(grammarAccess.prModel().ele00010ParserRuleCallML_COMMENT(), "mlCommentValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "mlCommentValue", lv_mlCommentValue, "ML_COMMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_slCommentValue=RULE_SL_COMMENT
    { 
    createLeafNode(grammarAccess.prModel().ele0010ParserRuleCallSL_COMMENT(), "slCommentValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "slCommentValue", lv_slCommentValue, "SL_COMMENT", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_wsValue=RULE_WS
    { 
    createLeafNode(grammarAccess.prModel().ele010ParserRuleCallWS(), "wsValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "wsValue", lv_wsValue, "WS", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |(	
	
	    lv_anyValue=RULE_ANY_OTHER
    { 
    createLeafNode(grammarAccess.prModel().ele10ParserRuleCallANY_OTHER(), "anyValue"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "anyValue", lv_anyValue, "ANY_OTHER", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





































RULE_ID : '^'? (('a'..'z'|'A'..'Z')|'_') ((('a'..'z'|'A'..'Z')|'_')|'0'..'9')*;



RULE_INT : ('0'..'9')+;



RULE_STRING : ('\"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\"')))* '\"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'\"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



RULE_WS : (((' '|'\t')|'\r')|'\n')+;



RULE_ANY_OTHER : .;




