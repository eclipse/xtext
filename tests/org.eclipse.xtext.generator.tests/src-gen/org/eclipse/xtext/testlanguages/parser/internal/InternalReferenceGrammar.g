
/*
Generated with Xtext
*/
grammar InternalReferenceGrammar;

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
 
    public InternalReferenceGrammarParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalReferenceGrammar.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Spielplatz";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}



// Entry rule entryRuleSpielplatz
entryRuleSpielplatz returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielplatz=ruleSpielplatz 
	 { $current=$iv_ruleSpielplatz.current; } 
	 EOF 
;

// Rule Spielplatz
ruleSpielplatz returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((((('spielplatz' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_groesse=RULE_INT
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"groesse"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "groesse", lv_groesse,"INT");    }
))(
    lv_beschreibung=RULE_STRING
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"beschreibung"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Spielplatz");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "beschreibung", lv_beschreibung,"STRING");    }
)?)'{' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(((
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)?;
    




// Entry rule entryRuleKind
entryRuleKind returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleKind=ruleKind 
	 { $current=$iv_ruleKind.current; } 
	 EOF 
;

// Rule Kind
ruleKind returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('kind' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Kind");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "age", lv_age,"INT");    }
))')' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);
    


// Entry rule entryRuleErwachsener
entryRuleErwachsener returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleErwachsener=ruleErwachsener 
	 { $current=$iv_ruleErwachsener.current; } 
	 EOF 
;

// Rule Erwachsener
ruleErwachsener returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('erwachsener' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
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
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"age"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Erwachsener");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "age", lv_age,"INT");    }
))')' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);
    


// Entry rule entryRuleSpielzeug
entryRuleSpielzeug returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleSpielzeug=ruleSpielzeug 
	 { $current=$iv_ruleSpielzeug.current; } 
	 EOF 
;

// Rule Spielzeug
ruleSpielzeug returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((('spielzeug' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'(' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Spielzeug");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
))(
    
    { 
        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
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
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);
    


// Entry rule entryRuleFarbe
entryRuleFarbe returns [EObject current=null] :
	{ currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleFarbe=ruleFarbe 
	 { $current=$iv_ruleFarbe.current; } 
	 EOF 
;

// Rule Farbe
ruleFarbe returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('ROT' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, currentNode,null); 
    }

    |'BLAU' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
)
    |'GELB' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
)
    |'GRÜN' 

    {
        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.1" /* xtext::Keyword */, currentNode,null); 
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


