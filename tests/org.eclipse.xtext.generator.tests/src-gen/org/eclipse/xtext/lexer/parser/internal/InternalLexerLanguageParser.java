// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g 2008-05-20 13:54:32

package org.eclipse.xtext.lexer.parser.internal; 

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.lexer.parser.internal.LexerLanguageTokenTypeResolver;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLexerLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EXPLICITTOKENTYPE", "RULE_IMPLICITTOKENTYPE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_LEXER_BODY", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=11;
    public static final int EOF=-1;
    public static final int RULE_IMPLICITTOKENTYPE=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_EXPLICITTOKENTYPE=5;
    public static final int RULE_LEXER_BODY=12;

        public InternalLexerLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g"; }



    private IElementFactory factory;
    public InternalLexerLanguageParser(TokenStream input, IElementFactory factory) {
        this(input);
        this.factory = factory;
    }

    public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
        CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
        if (parentNode!=null) parentNode.getChildren().add(compositeNode);
        compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
        return compositeNode;
    }

    public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
        Token token = input.LT(-1);
        Token tokenBefore = input.LT(-2);
        int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
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
    	LexerRule lexerRule = LexerLanguageTokenTypeResolver.getLexerRule(node, t.getType());
    	if(lexerRule != null) {
    		node.setGrammarElement(lexerRule);
    	}
    }

    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.lexer.LexerLanguageConstants.getLexerLanguageGrammar();






    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:98:1: parse returns [EObject current] : ruleModel EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleModel1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:98:33: ( ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:99:5: ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_parse53);
            ruleModel1=ruleModel();
            _fsp--;

             current =ruleModel1; 
            match(input,EOF,FOLLOW_EOF_in_parse67); 
             appendTrailingHiddenTokens(currentNode); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:108:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:109:37: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:110:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:110:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:112:5: lv_children= ruleElement
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel121);
            	    lv_children=ruleElement();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Model");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "children", lv_children);    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:127:1: ruleElement returns [EObject current=null] : ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_f=null;
        Token lv_g=null;
        Token lv_h=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:128:37: ( ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:1: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:1: ( ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:2: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) ) (lv_h= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:2: ( ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:3: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) ) (lv_g= RULE_IMPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:3: ( (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE ) )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:4: (lv_name= RULE_ID ) (lv_f= RULE_EXPLICITTOKENTYPE )
            {
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:129:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:130:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement169); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:141:2: (lv_f= RULE_EXPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:142:5: lv_f= RULE_EXPLICITTOKENTYPE
            {
            lv_f=(Token)input.LT(1);
            match(input,RULE_EXPLICITTOKENTYPE,FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement194); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"f"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "f", lv_f);    

            }


            }

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:153:3: (lv_g= RULE_IMPLICITTOKENTYPE )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:154:5: lv_g= RULE_IMPLICITTOKENTYPE
            {
            lv_g=(Token)input.LT(1);
            match(input,RULE_IMPLICITTOKENTYPE,FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement220); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"g"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "g", lv_g);    

            }


            }

            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:165:3: (lv_h= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/lexer/parser/internal/InternalLexerLanguage.g:166:5: lv_h= RULE_STRING
            {
            lv_h=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement246); 
             
                createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"h"); 
                

                    if (current==null) {
                        current = factory.create("Element");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "h", lv_h);    

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_parse53 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel121 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_EXPLICITTOKENTYPE_in_ruleElement194 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_IMPLICITTOKENTYPE_in_ruleElement220 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement246 = new BitSet(new long[]{0x0000000000000002L});

}