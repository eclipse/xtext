
grammar InternalLexerLanguage;

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

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
}

@parser::members {
 
    public InternalLexerLanguageParser(TokenStream input, IElementFactory factory) {
        this(input);
        this.factory = factory;
		grammar = LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.LexerLanguage").getGrammar();
    }
    
    protected void setLexerRule(LeafNode node, Token t) {
    /*    LexerRule lexerRule = LexerLanguageTokenTypeResolver.getLexerRule(node, t.getType());
        if(lexerRule != null) {
            node.setGrammarElement(lexerRule);
        }*/
    }
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
        IParseError error = createParseError(re);
        reportError(error, re);
    } 
}

internalParse returns [EObject current=null] :
	 { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;


// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_children=ruleElement 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "children", lv_children);    }
)*;


// Rule Element
ruleElement returns [EObject current=null] 
    @init { EObject temp=null; }:
((
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
)(
    lv_h=RULE_STRING
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"h"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "h", lv_h);    }
));



RULE_STRING : " '#' ('B')+ ";

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


