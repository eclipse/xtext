// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g 2008-06-03 15:39:51

package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalActionTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalActionTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g"; }


     
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



    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:89:1: internalParse returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:89:46: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:90:3: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_internalParse76);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_internalParse86); 

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
    // $ANTLR end internalParse


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:98:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:99:33: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:100:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:100:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:102:5: lv_children= ruleElement
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel130);
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


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:117:1: ruleElement returns [EObject current=null] : (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Item = null;

        EObject lv_items = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:118:33: ( (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:119:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:119:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:119:2: this_Item= ruleItem ( () (lv_items= ruleItem ) )
            {
            pushFollow(FOLLOW_ruleItem_in_ruleElement166);
            this_Item=ruleItem();
            _fsp--;

             
                    current = this_Item; 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:123:1: ( () (lv_items= ruleItem ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:123:2: () (lv_items= ruleItem )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:123:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:124:5: 
            {
             
                    temp=factory.create("Item");
                    factory.add(temp, "items",current);
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                newNode.getChildren().add(currentNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:134:2: (lv_items= ruleItem )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:136:5: lv_items= ruleItem
            {
             
                    currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleItem_in_ruleElement203);
            lv_items=ruleItem();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Type");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.add(current, "items", lv_items);    

            }


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
    // $ANTLR end ruleElement


    // $ANTLR start ruleItem
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:151:1: ruleItem returns [EObject current=null] : ( () (lv_name= RULE_ID ) ) ;
    public final EObject ruleItem() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:152:33: ( ( () (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:153:1: ( () (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:153:1: ( () (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:153:2: () (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:153:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:154:5: 
            {
             
                    temp=factory.create("Thing");
                    factory.set(temp, "content",current);
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                newNode.getChildren().add(currentNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:164:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalActionTestLanguage.g:165:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleItem255); 
             
                createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("Type");
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
    // $ANTLR end ruleItem


 

    public static final BitSet FOLLOW_ruleModel_in_internalParse76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement166 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleItem255 = new BitSet(new long[]{0x0000000000000002L});

}