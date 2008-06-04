
grammar InternalActionTestLanguage;

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
 
    public InternalActionTestLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    protected void setLexerRule(LeafNode node, Token t) {
    /*    LexerRule lexerRule = ActionTestLanguageTokenTypeResolver.getLexerRule(node, t.getType());
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
        factory.add($current, "children", lv_children,null);    }
)*;



// Rule Element
ruleElement returns [EObject current=null] 
    @init { EObject temp=null; }:
(this_Item=ruleItem
    { 
        $current = $this_Item.current; 
    }
((
    { 
        temp=factory.create("Item");
        factory.add(temp, "items",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_items=ruleItem 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Type");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "items", lv_items,null);    }
)));



// Rule Item
ruleItem returns [EObject current=null] 
    @init { EObject temp=null; }:
((
    { 
        temp=factory.create("Thing");
        factory.set(temp, "content",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Type");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name,"ID");    }
));




RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


