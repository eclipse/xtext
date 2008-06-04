
grammar InternalReferenceGrammar;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.reference.parser.internal;
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
package org.eclipse.xtext.reference.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
}

@parser::members {
 
    public InternalReferenceGrammarParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    protected void setLexerRule(LeafNode node, Token t) {
    /*    LexerRule lexerRule = ReferenceGrammarTokenTypeResolver.getLexerRule(node, t.getType());
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
	 iv_ruleSpielplatz=ruleSpielplatz 
	 { $current=$iv_ruleSpielplatz.current; } 
	 EOF 
;


// Rule Spielplatz
ruleSpielplatz returns [EObject current=null] 
    @init { EObject temp=null; }:
(((('spielplatz' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_groesse=RULE_INT
    { 
    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"groesse"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "groesse", lv_groesse,"INT");    }
))'{' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(((
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_kinder=ruleKind 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "kinder", lv_kinder,null);    }
)
    |(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_erzieher=ruleErwachsener 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "erzieher", lv_erzieher,null);    }
))
    |(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_spielzeuge=ruleSpielzeug 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "spielzeuge", lv_spielzeuge,null);    }
))*)'}' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)?;





// Rule Kind
ruleKind returns [EObject current=null] 
    @init { EObject temp=null; }:
(((('kind' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Kind");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
))(
    lv_age=RULE_INT
    { 
    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Kind");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "age", lv_age,"INT");    }
))')' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



// Rule Erwachsener
ruleErwachsener returns [EObject current=null] 
    @init { EObject temp=null; }:
(((('erwachsener' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Erwachsener");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
))(
    lv_age=RULE_INT
    { 
    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Erwachsener");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "age", lv_age,"INT");    }
))')' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



// Rule Spielzeug
ruleSpielzeug returns [EObject current=null] 
    @init { EObject temp=null; }:
(((('spielzeug' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Spielzeug");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
))(
    
    { 
        currentNode=createCompositeNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_farbe=ruleFarbe 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Spielzeug");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "farbe", lv_farbe,null);    }
))')' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



// Rule Farbe
ruleFarbe returns [EObject current=null] 
    @init { EObject temp=null; }:
((('ROT' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, currentNode,null); 
    }

    |'BLAU' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
)
    |'GELB' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
)
    |'GRÜN' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
);




RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


