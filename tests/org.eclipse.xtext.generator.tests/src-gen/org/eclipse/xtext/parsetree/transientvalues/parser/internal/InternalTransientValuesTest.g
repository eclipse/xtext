/*
Generated with Xtext
*/
grammar InternalTransientValuesTest;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parsetree.transientvalues.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parsetree.transientvalues.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
}

@parser::members {
 
    public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalTransientValuesTestParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.tokens");
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
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleRoot=ruleRoot 
	 { $current=$iv_ruleRoot.current; } 
	 EOF 
;

// Rule Root
ruleRoot returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('test' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
((
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_TestRequired=ruleTestRequired
    { 
        $current = $this_TestRequired.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TestOptional=ruleTestOptional
    { 
        $current = $this_TestOptional.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_TestList=ruleTestList
    { 
        $current = $this_TestList.current; 
        currentNode = currentNode.getParent();
    }
));
    


// Entry rule entryRuleTestRequired
entryRuleTestRequired returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTestRequired=ruleTestRequired 
	 { $current=$iv_ruleTestRequired.current; } 
	 EOF 
;

// Rule TestRequired
ruleTestRequired returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('required' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_required1=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestRequired");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "required1", lv_required1,"INT");
	         }
	
))(	
	
	    lv_required2=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required2"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestRequired");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "required2", lv_required2,"INT");
	         }
	
));
    


// Entry rule entryRuleTestOptional
entryRuleTestOptional returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTestOptional=ruleTestOptional 
	 { $current=$iv_ruleTestOptional.current; } 
	 EOF 
;

// Rule TestOptional
ruleTestOptional returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('optional' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_opt1=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt1"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestOptional");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "opt1", lv_opt1,"INT");
	         }
	
)?)(':' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_opt2=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt2"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestOptional");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.set($current, "opt2", lv_opt2,"INT");
	         }
	
))?);
    


// Entry rule entryRuleTestList
entryRuleTestList returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTestList=ruleTestList 
	 { $current=$iv_ruleTestList.current; } 
	 EOF 
;

// Rule TestList
ruleTestList returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('list' 
    {
        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
    }
(	
	
	    lv_item=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "item"); 
    }
 
	    {
	        if ($current==null) {
	            $current = factory.create("TestList");
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        factory.add($current, "item", lv_item,"INT");
	         }
	
)*);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |                '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* ('\r'? '\n')? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


