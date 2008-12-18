/*
Generated with Xtext
*/
grammar InternalBug250313;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.valueconverter.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.valueconverter.parser.internal; 

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
 
    public InternalBug250313Parser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalBug250313Parser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Ref2";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleRef2
entryRuleRef2 returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRef2=ruleRef2 
	 { $current=$iv_ruleRef2.current; } 
	 EOF 
;

// Rule Ref2
ruleRef2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('#2' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_ref2=(('mykeyword1' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "ref2"); 
    }

    |RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "ref2"); 
    }
)
    |RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "ref2"); 
    }
) 
	    {
	        if ($current==null) {
	            $current = factory.create("Ref2");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	        	factory.set($current, "ref2", input.LT(-1),null);
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


