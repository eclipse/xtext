// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g 2008-05-27 15:10:52

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.OptionalEmptyLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalOptionalEmptyLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_STRING", "RULE_INT", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'hallo'"
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

        public InternalOptionalEmptyLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g"; }


        public TokenStream getInput() {
        	return input;
        }

        private IElementFactory factory;
        public InternalOptionalEmptyLanguageParser(TokenStream input, IElementFactory factory) {
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
            LexerRule lexerRule = OptionalEmptyLanguageTokenTypeResolver.getLexerRule(node, t.getType());
            if(lexerRule != null) {
                node.setGrammarElement(lexerRule);
            }
        }
        
        private CompositeNode currentNode;
        public CompositeNode getCurrentNode() {
            return currentNode;
        }
        
        private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/OptionalEmptyLanguage").getGrammar();;




    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:221:1: parse returns [IParseResult result] : ruleModel EOF ;
    public final IParseResult parse() throws RecognitionException {
        IParseResult result = null;

        EObject ruleModel1 = null;


         EObject current = null; parseErrors = new ArrayList<IParseError>();
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:222:79: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:223:5: ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_parse75);
            ruleModel1=ruleModel();
            _fsp--;

             current=ruleModel1; 
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


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:233:1: ruleModel returns [EObject current=null] : (lv_child= ruleGreeting )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_child = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:234:33: ( (lv_child= ruleGreeting )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:235:1: (lv_child= ruleGreeting )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:235:1: (lv_child= ruleGreeting )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:237:5: lv_child= ruleGreeting
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGreeting_in_ruleModel146);
                    lv_child=ruleGreeting();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("Model");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "child", lv_child);    

                    }
                    break;

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
    // $ANTLR end ruleModel


    // $ANTLR start ruleGreeting
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:252:1: ruleGreeting returns [EObject current=null] : ( 'hallo' (lv_name= RULE_ID ) ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:253:33: ( ( 'hallo' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:254:1: ( 'hallo' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:254:1: ( 'hallo' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:254:2: 'hallo' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleGreeting180); 

                    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:259:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalOptionalEmptyLanguage.g:260:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting198); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Greeting");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


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
    // $ANTLR end ruleGreeting


 

    public static final BitSet FOLLOW_ruleModel_in_parse75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_ruleModel146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleGreeting180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting198 = new BitSet(new long[]{0x0000000000000002L});

}