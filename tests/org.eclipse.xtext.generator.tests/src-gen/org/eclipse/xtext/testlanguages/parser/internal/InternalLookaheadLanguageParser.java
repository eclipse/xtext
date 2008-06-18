// $ANTLR 3.0 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g 2008-06-18 12:01:26

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
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

public class InternalLookaheadLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'bar'", "'c'", "'foo'", "'d'", "'e'"
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

        public InternalLookaheadLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g"; }


     
        public InternalLookaheadLanguageParser(TokenStream input, IElementFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLookaheadLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.tokens");
        }



    // $ANTLR start internalParse
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:91:1: internalParse returns [EObject current=null] : iv_ruleA= ruleA EOF ;
    public EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleA = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:92:3: (iv_ruleA= ruleA EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:92:3: iv_ruleA= ruleA EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleA_in_internalParse78);
            iv_ruleA=ruleA();
            _fsp--;

             current =iv_ruleA; 
            match(input,EOF,FOLLOW_EOF_in_internalParse88); 

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


    // $ANTLR start ruleA
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:100:1: ruleA returns [EObject current=null] : (lv_x= ruleB ) ;
    public EObject ruleA() throws RecognitionException {
        EObject current = null;

        EObject lv_x = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:102:1: ( (lv_x= ruleB ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:102:1: (lv_x= ruleB )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:102:1: (lv_x= ruleB )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:104:5: lv_x= ruleB
            {
             
                    currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleB_in_ruleA132);
            lv_x=ruleB();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("A");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,null);    

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
    // $ANTLR end ruleA


    // $ANTLR start ruleB
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:120:1: ruleB returns [EObject current=null] : ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC ) ;
    public EObject ruleB() throws RecognitionException {
        EObject current = null;

        EObject this_D = null;

        EObject this_E = null;

        EObject this_C = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:122:1: ( ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==12) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==15) ) {
                        int LA2_3 = input.LA(4);

                        if ( (LA2_3==12) ) {
                            alt2=2;
                        }
                        else if ( (LA2_3==EOF) ) {
                            alt2=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )", 2, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA2_2==16) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )", 2, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("122:1: ( (this_D= ruleD | this_E= ruleE ) | this_C= ruleC )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:122:2: (this_D= ruleD | this_E= ruleE )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:122:2: (this_D= ruleD | this_E= ruleE )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==14) ) {
                        int LA1_1 = input.LA(2);

                        if ( (LA1_1==12) ) {
                            int LA1_2 = input.LA(3);

                            if ( (LA1_2==16) ) {
                                alt1=2;
                            }
                            else if ( (LA1_2==15) ) {
                                alt1=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("122:2: (this_D= ruleD | this_E= ruleE )", 1, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("122:2: (this_D= ruleD | this_E= ruleE )", 1, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("122:2: (this_D= ruleD | this_E= ruleE )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:123:5: this_D= ruleD
                            {
                             
                                    currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleD_in_ruleB180);
                            this_D=ruleD();
                            _fsp--;

                             
                                    current = this_D; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:133:5: this_E= ruleE
                            {
                             
                                    currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleE_in_ruleB207);
                            this_E=ruleE();
                            _fsp--;

                             
                                    current = this_E; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:143:5: this_C= ruleC
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleC_in_ruleB235);
                    this_C=ruleC();
                    _fsp--;

                     
                            current = this_C; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleB


    // $ANTLR start ruleC
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:156:1: ruleC returns [EObject current=null] : ( ( (lv_y= ruleD ) 'bar' ) (lv_x= 'c' ) ) ;
    public EObject ruleC() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_y = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:1: ( ( ( (lv_y= ruleD ) 'bar' ) (lv_x= 'c' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:1: ( ( (lv_y= ruleD ) 'bar' ) (lv_x= 'c' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:1: ( ( (lv_y= ruleD ) 'bar' ) (lv_x= 'c' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:2: ( (lv_y= ruleD ) 'bar' ) (lv_x= 'c' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:2: ( (lv_y= ruleD ) 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:3: (lv_y= ruleD ) 'bar'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:3: (lv_y= ruleD )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:160:5: lv_y= ruleD
            {
             
                    currentNode=createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleD_in_ruleC288);
            lv_y=ruleD();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("C");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "y", lv_y,null);    

            }

            match(input,12,FOLLOW_12_in_ruleC298); 

                    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:176:2: (lv_x= 'c' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:177:5: lv_x= 'c'
            {
            lv_x=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_ruleC317); 

                    if (current==null) {
                        current = factory.create("C");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"c");        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    

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
    // $ANTLR end ruleC


    // $ANTLR start ruleD
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:190:1: ruleD returns [EObject current=null] : ( ( 'foo' 'bar' ) (lv_x= 'd' ) ) ;
    public EObject ruleD() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:1: ( ( ( 'foo' 'bar' ) (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:1: ( ( 'foo' 'bar' ) (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:1: ( ( 'foo' 'bar' ) (lv_x= 'd' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:2: ( 'foo' 'bar' ) (lv_x= 'd' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:2: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:3: 'foo' 'bar'
            {
            match(input,14,FOLLOW_14_in_ruleD355); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,12,FOLLOW_12_in_ruleD365); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:202:2: (lv_x= 'd' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:203:5: lv_x= 'd'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleD384); 

                    if (current==null) {
                        current = factory.create("D");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"d");        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    

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
    // $ANTLR end ruleD


    // $ANTLR start ruleE
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:216:1: ruleE returns [EObject current=null] : ( ( 'foo' 'bar' ) (lv_x= 'e' ) ) ;
    public EObject ruleE() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:1: ( ( ( 'foo' 'bar' ) (lv_x= 'e' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:1: ( ( 'foo' 'bar' ) (lv_x= 'e' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:1: ( ( 'foo' 'bar' ) (lv_x= 'e' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:2: ( 'foo' 'bar' ) (lv_x= 'e' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:2: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:218:3: 'foo' 'bar'
            {
            match(input,14,FOLLOW_14_in_ruleE422); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            match(input,12,FOLLOW_12_in_ruleE432); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:228:2: (lv_x= 'e' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:229:5: lv_x= 'e'
            {
            lv_x=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_ruleE451); 

                    if (current==null) {
                        current = factory.create("E");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"e");        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"x");    

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
    // $ANTLR end ruleE


 

    public static final BitSet FOLLOW_ruleA_in_internalParse78 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleB_in_ruleA132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleD_in_ruleB180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE_in_ruleB207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleC_in_ruleB235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleD_in_ruleC288 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleC298 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleC317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleD355 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleD365 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleD384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleE422 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleE432 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleE451 = new BitSet(new long[]{0x0000000000000002L});

}