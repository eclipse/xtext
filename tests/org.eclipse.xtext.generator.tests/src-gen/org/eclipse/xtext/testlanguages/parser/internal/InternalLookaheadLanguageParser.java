// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g 2008-07-04 15:45:38

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLookaheadLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'bar'", "'a'", "'foo'", "'b'", "'d'", "'c'"
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


     
        public InternalLookaheadLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
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



    // $ANTLR start entryRuleEntry
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:63:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:63:47: (iv_ruleEntry= ruleEntry EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:64:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntry_in_entryRuleEntry71);
            iv_ruleEntry=ruleEntry();
            _fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntry81); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntry


    // $ANTLR start ruleEntry
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:71:1: ruleEntry returns [EObject current=null] : (lv_contents= ruleAlts )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:73:33: ( (lv_contents= ruleAlts )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:74:1: (lv_contents= ruleAlts )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:74:1: (lv_contents= ruleAlts )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:76:5: lv_contents= ruleAlts
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry133);
            	    lv_contents=ruleAlts();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Entry");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "contents", lv_contents,null);    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEntry


    // $ANTLR start entryRuleAlts
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:92:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:92:46: (iv_ruleAlts= ruleAlts EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:93:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlts_in_entryRuleAlts169);
            iv_ruleAlts=ruleAlts();
            _fsp--;

             current =iv_ruleAlts; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlts179); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAlts


    // $ANTLR start ruleAlts
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:100:1: ruleAlts returns [EObject current=null] : ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0 = null;

        EObject this_LookAhead1 = null;

        EObject this_LookAhead3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:102:33: ( ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:103:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:103:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==12) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==15) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==17) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("103:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==14) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("103:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("103:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:103:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:103:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==12) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==14) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("103:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:104:5: this_LookAhead0= ruleLookAhead0
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts227);
                            this_LookAhead0=ruleLookAhead0();
                            _fsp--;

                             
                                    current = this_LookAhead0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:114:5: this_LookAhead1= ruleLookAhead1
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts254);
                            this_LookAhead1=ruleLookAhead1();
                            _fsp--;

                             
                                    current = this_LookAhead1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:124:5: this_LookAhead3= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts282);
                    this_LookAhead3=ruleLookAhead3();
                    _fsp--;

                     
                            current = this_LookAhead3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAlts


    // $ANTLR start entryRuleLookAhead0
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:137:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:137:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:138:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0316);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead0326); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLookAhead0


    // $ANTLR start ruleLookAhead0
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:145:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:147:33: ( ( 'bar' (lv_x= 'a' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:148:1: ( 'bar' (lv_x= 'a' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:148:1: ( 'bar' (lv_x= 'a' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:148:2: 'bar' (lv_x= 'a' )
            {
            match(input,12,FOLLOW_12_in_ruleLookAhead0360); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:153:1: (lv_x= 'a' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:154:5: lv_x= 'a'
            {
            lv_x=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_ruleLookAhead0378); 

                    if (current==null) {
                        current = factory.create("LookAhead0");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"a");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x");    

            }


            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLookAhead0


    // $ANTLR start entryRuleLookAhead1
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:167:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:167:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:168:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1416);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1426); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLookAhead1


    // $ANTLR start ruleLookAhead1
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:175:1: ruleLookAhead1 returns [EObject current=null] : ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_y = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:177:33: ( ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:3: ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:3: ( 'foo' (lv_y= ruleLookAhead2 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:4: 'foo' (lv_y= ruleLookAhead2 )
            {
            match(input,14,FOLLOW_14_in_ruleLookAhead1462); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:183:1: (lv_y= ruleLookAhead2 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:185:5: lv_y= ruleLookAhead2
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1491);
            lv_y=ruleLookAhead2();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("LookAhead1");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "y", lv_y,null);    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:196:3: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:197:5: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1510); 

                    if (current==null) {
                        current = factory.create("LookAhead1");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"b");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x");    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:205:3: (lv_x= 'd' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:206:5: lv_x= 'd'
            {
            lv_x=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_ruleLookAhead1531); 

                    if (current==null) {
                        current = factory.create("LookAhead1");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"d");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x");    

            }


            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLookAhead1


    // $ANTLR start entryRuleLookAhead2
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:219:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:219:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:220:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2569);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2579); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLookAhead2


    // $ANTLR start ruleLookAhead2
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:227:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:229:33: ( ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("230:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:3: (lv_z= 'foo' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:230:3: (lv_z= 'foo' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:231:5: lv_z= 'foo'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleLookAhead2622); 

                            if (current==null) {
                                current = factory.create("LookAhead2");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "z", lv_z,"foo");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "z");    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:240:6: (lv_z= 'bar' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:240:6: (lv_z= 'bar' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:241:5: lv_z= 'bar'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleLookAhead2648); 

                            if (current==null) {
                                current = factory.create("LookAhead2");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "z", lv_z,"bar");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal" /* xtext::Keyword */, "z");    

                    }


                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_ruleLookAhead2661); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLookAhead2


    // $ANTLR start entryRuleLookAhead3
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:259:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:259:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:260:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3697);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3707); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLookAhead3


    // $ANTLR start ruleLookAhead3
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:267:1: ruleLookAhead3 returns [EObject current=null] : ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_z = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:269:33: ( ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:3: ( 'foo' 'bar' ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:3: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:270:4: 'foo' 'bar'
            {
            match(input,14,FOLLOW_14_in_ruleLookAhead3743); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleLookAhead3753); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:280:2: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:281:5: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead3772); 

                    if (current==null) {
                        current = factory.create("LookAhead3");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "x", lv_x,"b");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x");    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:289:3: (lv_z= ruleLookAhead4 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:291:5: lv_z= ruleLookAhead4
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleLookAhead4_in_ruleLookAhead3804);
            lv_z=ruleLookAhead4();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("LookAhead3");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "z", lv_z,null);    

            }


            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLookAhead3


    // $ANTLR start entryRuleLookAhead4
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:307:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:307:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:308:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4840);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4850); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLookAhead4


    // $ANTLR start ruleLookAhead4
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:315:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x= 'c' ) | (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:317:33: ( ( (lv_x= 'c' ) | (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:318:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:318:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("318:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:318:2: (lv_x= 'c' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:318:2: (lv_x= 'c' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:319:5: lv_x= 'c'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleLookAhead4892); 

                            if (current==null) {
                                current = factory.create("LookAhead4");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "x", lv_x,"c");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.0/@terminal" /* xtext::Keyword */, "x");    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:328:6: (lv_x= 'd' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:328:6: (lv_x= 'd' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:329:5: lv_x= 'd'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead4918); 

                            if (current==null) {
                                current = factory.create("LookAhead4");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "x", lv_x,"d");        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, "x");    

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLookAhead4


 

    public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntry81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlts_in_ruleEntry133 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlts179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead0360 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead0378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1462 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1491 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1510 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead2622 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead2648 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLookAhead2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3743 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead3753 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead3772 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleLookAhead4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead4918 = new BitSet(new long[]{0x0000000000000002L});

}