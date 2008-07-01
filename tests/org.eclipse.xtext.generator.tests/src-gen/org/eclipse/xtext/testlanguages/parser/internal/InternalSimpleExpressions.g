
/*
Generated with Xtext
*/
grammar InternalSimpleExpressions;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

@lexer::members {

  public Token nextToken() {
        while (true) {
            this.token = null;
            this.channel = Token.DEFAULT_CHANNEL;
            this.tokenStartCharIndex = input.index();
            this.tokenStartCharPositionInLine = input.getCharPositionInLine();
            this.tokenStartLine = input.getLine();
            this.text = null;
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            try {
                mTokens();
                if ( this.token==null ) {
                    emit();
                }
                else if ( this.token==Token.SKIP_TOKEN ) {
                    continue;
                }
                return this.token;
            }
            catch (RecognitionException re) {
                reportError(re);
                if ( re instanceof NoViableAltException ) { recover(re); }
                                // create token that holds mismatched char
                Token t = new CommonToken(input, Token.INVALID_TOKEN_TYPE,
                                          Token.HIDDEN_CHANNEL,
                                          this.tokenStartCharIndex,
                                          getCharIndex()-1);
                t.setLine(this.tokenStartLine);
                t.setCharPositionInLine(this.tokenStartCharPositionInLine);
                emit(t);
                return this.token;
            }
        }
    }
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.internal; 

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
 
    public InternalSimpleExpressionsParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalSimpleExpressionsParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Sequence";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleSequence
entryRuleSequence returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSequence=ruleSequence 
	 { $current=$iv_ruleSequence.current; } 
	 EOF 
;

// Rule Sequence
ruleSequence returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Addition=ruleAddition
    { 
        $current = $this_Addition.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Sequence");
        factory.add(temp, "expressions",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_expressions=ruleAddition 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Sequence");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "expressions", lv_expressions,null);    }
))*);
    


// Entry rule entryRuleAddition
entryRuleAddition returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAddition=ruleAddition 
	 { $current=$iv_ruleAddition.current; } 
	 EOF 
;

// Rule Addition
ruleAddition returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Multiplication=ruleMultiplication
    { 
        $current = $this_Multiplication.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Op");
        factory.add(temp, "values",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    lv_operator=('+' 

    |'-' 
) 
    {
        if ($current==null) {
            $current = factory.create("Expression");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "operator", lv_operator,null);        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
))(
    
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_values=ruleMultiplication 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Expression");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "values", lv_values,null);    }
))*);
    


// Entry rule entryRuleMultiplication
entryRuleMultiplication returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleMultiplication=ruleMultiplication 
	 { $current=$iv_ruleMultiplication.current; } 
	 EOF 
;

// Rule Multiplication
ruleMultiplication returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Term=ruleTerm
    { 
        $current = $this_Term.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Op");
        factory.add(temp, "values",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    moveLookaheadInfo(currentNode, newNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    lv_operator=('*' 

    |'/' 
) 
    {
        if ($current==null) {
            $current = factory.create("Expression");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "operator", lv_operator,null);        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
))(
    
    { 
        currentNode=createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_values=ruleTerm 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Expression");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "values", lv_values,null);    }
))*);
    


// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleTerm=ruleTerm 
	 { $current=$iv_ruleTerm.current; } 
	 EOF 
;

// Rule Term
ruleTerm returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.3/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Atom=ruleAtom
    { 
        $current = $this_Atom.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.3/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Parens=ruleParens
    { 
        $current = $this_Parens.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleAtom
entryRuleAtom returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAtom=ruleAtom 
	 { $current=$iv_ruleAtom.current; } 
	 EOF 
;

// Rule Atom
ruleAtom returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Atom");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
);
    


// Entry rule entryRuleParens
entryRuleParens returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleParens=ruleParens 
	 { $current=$iv_ruleParens.current; } 
	 EOF 
;

// Rule Parens
ruleParens returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(('(' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }

    { 
        currentNode=createCompositeNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Addition=ruleAddition
    { 
        $current = $this_Addition.current; 
        currentNode = currentNode.getParent();
    }
)')' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


