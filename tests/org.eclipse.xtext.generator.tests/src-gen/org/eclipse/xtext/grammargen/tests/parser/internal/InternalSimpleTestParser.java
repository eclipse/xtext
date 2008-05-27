// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g 2008-05-27 15:19:50

package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.internal.SimpleTestTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_STRING", "RULE_INT", "RULE_LEXER_BODY", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=5;
    public static final int RULE_ID=4;
    public static final int RULE_WS=6;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=8;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=7;
    public static final int RULE_LEXER_BODY=10;

        public InternalSimpleTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g"; }


        public TokenStream getInput() {
        	return input;
        }

        private IElementFactory factory;
        public InternalSimpleTestParser(TokenStream input, IElementFactory factory) {
            this(input);
            this.factory = factory;
        }
        
        private List<IParseError> parseErrors;
        private IParseError createParseError(RecognitionException re) {
    		LeafNode ln = null;
    		if (currentNode!=null) {
    		    CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
    		    List<LeafNode> list = root.getLeafNodes();
    		    if (list.size()>lastErrorIndex)
    		        ln = list.get(lastErrorIndex);
    		}
    		IParseError error = null;
    		if (ln == null) {
    			CommonToken lt = (CommonToken) input.LT(input.index());
    			error = new ParseError(lt.getLine(), lt.getStartIndex(), lt.getText() != null ? lt.getText()
    					.length() : 0, lt.getText(), getErrorMessage(re, getTokenNames()), re);
    		} else {
    			error = new ParseError(ln, getErrorMessage(re, getTokenNames()), re);
    		}
    		parseErrors.add(error);
    		return error;
    	}
        
        protected void reportError(IParseError error, RecognitionException re) {
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
                        throw new ParseException(new ParseError(node, "Reassignment of astElement in parse tree node", null));
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




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:221:1: parse returns [IParseResult result] : ruleFoo EOF ;
    public final IParseResult parse() throws RecognitionException {
        IParseResult result = null;

        EObject ruleFoo1 = null;


         EObject current = null; parseErrors = new ArrayList<IParseError>();
        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:222:79: ( ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:223:5: ruleFoo EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFoo_in_parse75);
            ruleFoo1=ruleFoo();
            _fsp--;

             current=ruleFoo1; 
            match(input,EOF,FOLLOW_EOF_in_parse88); 
             appendTrailingHiddenTokens(currentNode); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
             appendAllTokens(); result = new ParseResult(current, currentNode,parseErrors); 
        }
        return result;
    }
    // $ANTLR end parse


    // $ANTLR start ruleFoo
    // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:233:1: ruleFoo returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:234:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:235:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:235:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammargen/tests/parser/internal/InternalSimpleTest.g:236:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo135); 
             
                createLeafNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Foo");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFoo


 

    public static final BitSet FOLLOW_ruleFoo_in_parse75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo135 = new BitSet(new long[]{0x0000000000000002L});

}