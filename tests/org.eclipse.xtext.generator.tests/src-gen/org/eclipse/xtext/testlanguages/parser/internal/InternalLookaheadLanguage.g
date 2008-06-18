
/*
Generated with Xtext
*/
grammar InternalLookaheadLanguage;

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
}

@parser::members {
 
    public InternalLookaheadLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalLookaheadLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.tokens");
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
	 iv_ruleA=ruleA 
	 { $current=$iv_ruleA.current; } 
	 EOF 
;


// Rule A
ruleA returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_x=ruleB 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("A");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,null);    }
);



// Rule B
ruleB returns [EObject current=null] 
    @init { EObject temp=null; }:
((
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_D=ruleD
    { 
        $current = $this_D.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_E=ruleE
    { 
        $current = $this_E.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_C=ruleC
    { 
        $current = $this_C.current; 
        currentNode = currentNode.getParent();
    }
);



// Rule C
ruleC returns [EObject current=null] 
    @init { EObject temp=null; }:
(((
    
    { 
        currentNode=createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_y=ruleD 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("C");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "y", lv_y,null);    }
)'bar' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_x='c' 
 
    {
        if ($current==null) {
            $current = factory.create("C");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"c");        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));



// Rule D
ruleD returns [EObject current=null] 
    @init { EObject temp=null; }:
(('foo' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'bar' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_x='d' 
 
    {
        if ($current==null) {
            $current = factory.create("D");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"d");        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));



// Rule E
ruleE returns [EObject current=null] 
    @init { EObject temp=null; }:
(('foo' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'bar' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_x='e' 
 
    {
        if ($current==null) {
            $current = factory.create("E");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"e");        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));




RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


