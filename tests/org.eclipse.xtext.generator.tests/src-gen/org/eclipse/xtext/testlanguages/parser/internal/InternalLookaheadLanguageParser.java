// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g 2008-08-07 16:59:11

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bar'", "'a'", "'foo'", "'b'", "'d'", "'c'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

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

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:77:6: lv_contents= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry139);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:96:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:96:46: (iv_ruleAlts= ruleAlts EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:97:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlts_in_entryRuleAlts178);
            iv_ruleAlts=ruleAlts();
            _fsp--;

             current =iv_ruleAlts; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlts188); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:104:1: ruleAlts returns [EObject current=null] : ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0 = null;

        EObject this_LookAhead1 = null;

        EObject this_LookAhead3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:106:33: ( ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:107:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:107:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==11) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==14) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==16) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("107:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==13) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("107:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("107:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:107:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:107:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==13) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("107:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:108:5: this_LookAhead0= ruleLookAhead0
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts236);
                            this_LookAhead0=ruleLookAhead0();
                            _fsp--;

                             
                                    current = this_LookAhead0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:118:5: this_LookAhead1= ruleLookAhead1
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts263);
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
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:128:5: this_LookAhead3= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts291);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:141:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:141:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:142:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0325);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead0335); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:149:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:151:33: ( ( 'bar' (lv_x= 'a' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:152:1: ( 'bar' (lv_x= 'a' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:152:1: ( 'bar' (lv_x= 'a' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:152:2: 'bar' (lv_x= 'a' )
            {
            match(input,11,FOLLOW_11_in_ruleLookAhead0369); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:156:1: (lv_x= 'a' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:158:6: lv_x= 'a'
            {
            lv_x=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleLookAhead0390); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead0");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "x", input.LT(-1),"a");
            	         

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:177:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:177:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:178:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1437);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1447); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:185:1: ruleLookAhead1 returns [EObject current=null] : ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_y = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:187:33: ( ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:3: ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:3: ( 'foo' (lv_y= ruleLookAhead2 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:188:4: 'foo' (lv_y= ruleLookAhead2 )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead1483); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:192:1: (lv_y= ruleLookAhead2 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:195:6: lv_y= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1517);
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:209:3: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:211:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead1543); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "x", input.LT(-1),"b");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:225:3: (lv_x= 'd' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:227:6: lv_x= 'd'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1577); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "x", input.LT(-1),"d");
            	         

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:246:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:246:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:247:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2624);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2634); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:254:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:256:33: ( ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:3: (lv_z= 'foo' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:257:3: (lv_z= 'foo' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:259:6: lv_z= 'foo'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleLookAhead2681); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead2");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "z", input.LT(-1),"foo");
                    	         

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:274:6: (lv_z= 'bar' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:274:6: (lv_z= 'bar' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:276:6: lv_z= 'bar'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleLookAhead2720); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal" /* xtext::Keyword */, "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead2");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "z", input.LT(-1),"bar");
                    	         

                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleLookAhead2742); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:299:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:299:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:300:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3777);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3787); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:307:1: ruleLookAhead3 returns [EObject current=null] : ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_z = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:309:33: ( ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:3: ( 'foo' 'bar' ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:3: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:310:4: 'foo' 'bar'
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead3823); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,11,FOLLOW_11_in_ruleLookAhead3832); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:318:2: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:320:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead3854); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "x", input.LT(-1),"b");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:334:3: (lv_z= ruleLookAhead4 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:337:6: lv_z= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead4_in_ruleLookAhead3901);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:356:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:356:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:357:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4940);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4950); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:364:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x= 'c' ) | (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:366:33: ( ( (lv_x= 'c' ) | (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:367:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:367:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("367:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:367:2: (lv_x= 'c' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:367:2: (lv_x= 'c' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:369:6: lv_x= 'c'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead4996); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.0/@terminal" /* xtext::Keyword */, "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead4");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "x", input.LT(-1),"c");
                    	         

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:384:6: (lv_x= 'd' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:384:6: (lv_x= 'd' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadLanguage.g:386:6: lv_x= 'd'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleLookAhead41035); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi#//@parserRules.6/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead4");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "x", input.LT(-1),"d");
                    	         

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
    public static final BitSet FOLLOW_ruleAlts_in_ruleEntry139 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlts188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead0369 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead0390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead1483 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1517 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1543 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead2681 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead2720 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead3823 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead3832 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3854 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead41035 = new BitSet(new long[]{0x0000000000000002L});

}