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

}

@parser::members {
 
    public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, "idValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "intValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "stringValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "mlCommentValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "slCommentValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "wsValue"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.1/@terminal" /* xtext::RuleCall */, "anyValue"); 
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



RULE_STRING : ('"' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'"')|'\'')|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ((((((('b'|'t')|'n')|'f')|'r')|'"')|'\'')|'\\')|~(('\\'|'\'')))* '\'');



RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';



RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;



RULE_WS : (((' '|'\t')|'\r')|'\n')+;



RULE_ANY_OTHER : .;




