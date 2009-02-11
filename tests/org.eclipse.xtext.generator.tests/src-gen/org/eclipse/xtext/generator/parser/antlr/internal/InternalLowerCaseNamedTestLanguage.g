/*
Generated with Xtext
*/
grammar InternalLowerCaseNamedTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.generator.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.generator.parser.antlr.internal; 

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
 
    public InternalLowerCaseNamedTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalLowerCaseNamedTestLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/parser/antlr/internal/InternalLowerCaseNamedTestLanguage.tokens");
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); }
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
(	
	
	    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.xmi#/0/@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("Model");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "name", lv_name, "ID", currentNode);
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


