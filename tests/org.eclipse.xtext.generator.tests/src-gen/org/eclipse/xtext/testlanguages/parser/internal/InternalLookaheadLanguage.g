
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
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
}

@parser::members {
 
    public InternalLookaheadLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalLookaheadLanguageParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Entry";	
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



// Entry rule entryRuleEntry
entryRuleEntry returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleEntry=ruleEntry 
	 { $current=$iv_ruleEntry.current; } 
	 EOF 
;

// Rule Entry
ruleEntry returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_contents=ruleAlts 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Entry");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "contents", lv_contents,null);    }
)*;
    


// Entry rule entryRuleAlts
entryRuleAlts returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.1" /* xtext::ParserRule */, currentNode); }
	 iv_ruleAlts=ruleAlts 
	 { $current=$iv_ruleAlts.current; } 
	 EOF 
;

// Rule Alts
ruleAlts returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead0=ruleLookAhead0
    { 
        $current = $this_LookAhead0.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead1=ruleLookAhead1
    { 
        $current = $this_LookAhead1.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead3=ruleLookAhead3
    { 
        $current = $this_LookAhead3.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleLookAhead0
entryRuleLookAhead0 returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.2" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead0=ruleLookAhead0 
	 { $current=$iv_ruleLookAhead0.current; } 
	 EOF 
;

// Rule LookAhead0
ruleLookAhead0 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
('bar' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_x='a' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead0");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"a");        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));
    


// Entry rule entryRuleLookAhead1
entryRuleLookAhead1 returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.3" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead1=ruleLookAhead1 
	 { $current=$iv_ruleLookAhead1.current; } 
	 EOF 
;

// Rule LookAhead1
ruleLookAhead1 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('foo' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_y=ruleLookAhead2 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("LookAhead1");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "y", lv_y,null);    }
))(
    lv_x='b' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead1");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"b");        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
))(
    lv_x='d' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead1");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"d");        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));
    


// Entry rule entryRuleLookAhead2
entryRuleLookAhead2 returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.4" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead2=ruleLookAhead2 
	 { $current=$iv_ruleLookAhead2.current; } 
	 EOF 
;

// Rule LookAhead2
ruleLookAhead2 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
(((
    lv_z='foo' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead2");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "z", lv_z,"foo");        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, currentNode,"z");    }
)
    |(
    lv_z='bar' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead2");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "z", lv_z,"bar");        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal" /* xtext::Keyword */, currentNode,"z");    }
))'c' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);
    


// Entry rule entryRuleLookAhead3
entryRuleLookAhead3 returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.5" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead3=ruleLookAhead3 
	 { $current=$iv_ruleLookAhead3.current; } 
	 EOF 
;

// Rule LookAhead3
ruleLookAhead3 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((('foo' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'bar' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_x='b' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead3");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"b");        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
))
    { 
        currentNode=createCompositeNode("//@parserRules.5/@alternatives/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_LookAhead4=ruleLookAhead4
    { 
        $current = $this_LookAhead4.current; 
        currentNode = currentNode.getParent();
    }
);
    


// Entry rule entryRuleLookAhead4
entryRuleLookAhead4 returns [EObject current=null] :
	{ currentNode = createCompositeNode("//@parserRules.6" /* xtext::ParserRule */, currentNode); }
	 iv_ruleLookAhead4=ruleLookAhead4 
	 { $current=$iv_ruleLookAhead4.current; } 
	 EOF 
;

// Rule LookAhead4
ruleLookAhead4 returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); }:
((
    lv_x='c' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead4");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"c");        createLeafNode("//@parserRules.6/@alternatives/@groups.0/@terminal" /* xtext::Keyword */, currentNode,"x");    }
)
    |(
    lv_x='d' 
 
    {
        if ($current==null) {
            $current = factory.create("LookAhead4");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "x", lv_x,"d");        createLeafNode("//@parserRules.6/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, currentNode,"x");    }
));
    



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


