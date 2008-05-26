
grammar InternalSimpleTest;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.internal.SimpleTestTokenTypeResolver;
}

@parser::members {

    private IElementFactory factory;
    public InternalSimpleTestParser(TokenStream input, IElementFactory factory) {
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
                Token token = input.LT(-1);
                Token tokenBefore = input.get(lastConsumedIndex);
                int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
                if (indexOfTokenBefore+1<token.getTokenIndex()) {
                    for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
                        Token hidden = input.get(x);
                        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                        leafNode.setText(hidden.getText());
                        leafNode.setHidden(true);
                        setLexerRule(leafNode, hidden);
                        currentNode.getChildren().add(leafNode);
                        skipped.add(leafNode);
                    }
                }
                if(lastConsumedIndex < token.getTokenIndex()) {
                    LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                    leafNode.setText(token.getText());
                    leafNode.setHidden(true);
                    setLexerRule(leafNode, token);
                    currentNode.getChildren().add(leafNode);
                    skipped.add(leafNode);
                    lastConsumedIndex = token.getTokenIndex();
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
        LexerRule lexerRule = SimpleTestTokenTypeResolver.getLexerRule(node, t.getType());
        if(lexerRule != null) {
            node.setGrammarElement(lexerRule);
        }
    }
    
    private CompositeNode currentNode;
    public CompositeNode getCurrentNode() {
        return currentNode;
    }
    
    private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/grammargen/tests/SimpleTest").getGrammar();;

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

parse returns [EObject current] : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleFoo 
    { $current=$ruleFoo.current; } 
    EOF 
    { appendTrailingHiddenTokens(currentNode); };
    finally { appendAllTokens(); } 



// Rule Foo
ruleFoo returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Foo");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
);



RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


