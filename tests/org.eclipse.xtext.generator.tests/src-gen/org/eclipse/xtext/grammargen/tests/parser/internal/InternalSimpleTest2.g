
grammar InternalSimpleTest2;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
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
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.internal.SimpleTest2TokenTypeResolver;
}

@parser::members {

    private IElementFactory factory;
    public InternalSimpleTest2Parser(TokenStream input, IElementFactory factory) {
        this(input);
        this.factory = factory;
    }
    
    protected void reportError(RecognitionException re, LeafNode ln) {
            reportError(re);
        }
            
            private int lastConsumedIndex = -1;
        
             private void appendAllTokens() {
                for (int x = lastConsumedIndex+1; input.size()>x;input.consume(),x++) {
                    Token hidden = input.get(x);
                    LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                    leafNode.setText(hidden.getText());
                    leafNode.setHidden(true);
                    setLexerRule(leafNode, hidden);
                    currentNode.getChildren().add(leafNode);
                }
            }

             public List<LeafNode> appendSkippedTokens() {
               	List<LeafNode> skipped = new ArrayList<LeafNode>();
                Token currentToken = input.LT(-1);
                int currentTokenIndex = (currentToken == null) ? -1 : currentToken.getTokenIndex();
                Token tokenBefore = (lastConsumedIndex == -1) ? null :input.get(lastConsumedIndex);
                int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
                if (indexOfTokenBefore+1<currentTokenIndex) {
                    for (int x = indexOfTokenBefore+1; x<currentTokenIndex;x++) {
                        Token hidden = input.get(x);
                        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                        leafNode.setText(hidden.getText());
                        leafNode.setHidden(true);
                        setLexerRule(leafNode, hidden);
                        currentNode.getChildren().add(leafNode);
                        skipped.add(leafNode);
                    }
                }
                if(lastConsumedIndex < currentTokenIndex) {
                    LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                    leafNode.setText(currentToken.getText());
                    leafNode.setHidden(true);
                    setLexerRule(leafNode, currentToken);
                    currentNode.getChildren().add(leafNode);
                    skipped.add(leafNode);
                    lastConsumedIndex = currentToken.getTokenIndex();
                }
                return skipped;
            }
            
            public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
                CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
                if (parentNode!=null) parentNode.getChildren().add(compositeNode);
                compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
                return compositeNode;
            }
            

            public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
                Token token = input.LT(-1);
                int indexOfTokenBefore = lastConsumedIndex;
                if (indexOfTokenBefore+1<token.getTokenIndex()) {
                    for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
                        Token hidden = input.get(x);
                        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                        leafNode.setText(hidden.getText());
                        leafNode.setHidden(true);
                        setLexerRule(leafNode, hidden);
                        parentNode.getChildren().add(leafNode);
                    }
                }
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(token.getText());
                leafNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
                leafNode.setFeature(feature);
                parentNode.getChildren().add(leafNode);
                lastConsumedIndex = token.getTokenIndex();
                return leafNode;
            }

            private void appendTrailingHiddenTokens(CompositeNode parentNode) {
                Token tokenBefore = input.LT(-1);
                int size = input.size();
                if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
                    for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
                        Token hidden = input.get(x);
                        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                        leafNode.setText(hidden.getText());
                        leafNode.setHidden(true);
                        setLexerRule(leafNode, hidden);
                        parentNode.getChildren().add(leafNode);
                        lastConsumedIndex = hidden.getTokenIndex();
                    }
                }
            }
            
            public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
                if(node.getElement() != null && node.getElement() != astElement) {
                    throw new ParseException(node, "Reassignment of astElement in parse tree node");
                }
                node.setElement(astElement);
                if(astElement instanceof EObject) {
                    EObject eObject = (EObject) astElement;
                    NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
                    adapter.setParserNode(node); 
                }
            }
            
    protected void setLexerRule(LeafNode node, Token t) {
        LexerRule lexerRule = SimpleTest2TokenTypeResolver.getLexerRule(node, t.getType());
        if(lexerRule != null) {
            node.setGrammarElement(lexerRule);
        }
    }
    
    private CompositeNode currentNode;
    public CompositeNode getCurrentNode() {
        return currentNode;
    }
    
    private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/grammargen/tests/SimpleTest2").getGrammar();;

}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
        LeafNode ln = null;
        if (currentNode!=null) {
            CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
            List<LeafNode> list = root.getLeafNodes();
            if (list.size()>lastErrorIndex)
                ln = list.get(lastErrorIndex);
        }
        reportError(re, ln);
    } 
}

parse returns [IParseResult result] 
	@init { EObject current = null; } : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleModel 
    { current=$ruleModel.current; }
    EOF 
    { appendTrailingHiddenTokens(currentNode); };
    finally { appendAllTokens(); $result = new ParseResult(current, currentNode); }



// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_contents=ruleChild 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "contents", lv_contents);    }
)*;


// Rule Child
ruleChild returns [EObject current=null] 
    @init { EObject temp=null; }:
((((((
    lv_optional='optional' 
 
    {
        if ($current==null) {
            $current = factory.create("Child");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "optional", true);        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, currentNode,"optional");    }
)?'keyword' 

    {
        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Child");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
))(
    lv_number=RULE_INT
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"number"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Child");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "number", lv_number);    }
))'{' 

    {
        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)'}' 

    {
        createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ANY_OTHER : .;


