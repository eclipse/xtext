// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g 2009-01-04 17:07:31

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
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLookaheadTestLanguageParser extends AbstractAntlrParser {
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

        public InternalLookaheadTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g"; }


     
        public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLookaheadTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Entry";	
       	} 



    // $ANTLR start entryRuleEntry
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:66:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:66:47: (iv_ruleEntry= ruleEntry EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:67:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:74:1: ruleEntry returns [EObject current=null] : (lv_contents= ruleAlts )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:76:33: ( (lv_contents= ruleAlts )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:77:1: (lv_contents= ruleAlts )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:77:1: (lv_contents= ruleAlts )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:80:6: lv_contents= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry139);
            	    lv_contents=ruleAlts();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Entry");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "contents", lv_contents, "Alts", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:105:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:105:46: (iv_ruleAlts= ruleAlts EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:106:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlts_in_entryRuleAlts176);
            iv_ruleAlts=ruleAlts();
            _fsp--;

             current =iv_ruleAlts; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlts186); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:113:1: ruleAlts returns [EObject current=null] : ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0 = null;

        EObject this_LookAhead1 = null;

        EObject this_LookAhead3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:115:33: ( ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:116:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:116:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
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
                            new NoViableAltException("116:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==13) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("116:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("116:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:116:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:116:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
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
                            new NoViableAltException("116:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:117:5: this_LookAhead0= ruleLookAhead0
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts234);
                            this_LookAhead0=ruleLookAhead0();
                            _fsp--;

                             
                                    current = this_LookAhead0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:127:5: this_LookAhead1= ruleLookAhead1
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts261);
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
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:137:5: this_LookAhead3= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts289);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:152:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:152:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:153:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0321);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead0331); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:160:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:162:33: ( ( 'bar' (lv_x= 'a' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:163:1: ( 'bar' (lv_x= 'a' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:163:1: ( 'bar' (lv_x= 'a' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:163:2: 'bar' (lv_x= 'a' )
            {
            match(input,11,FOLLOW_11_in_ruleLookAhead0365); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:167:1: (lv_x= 'a' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:169:6: lv_x= 'a'
            {
            lv_x=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleLookAhead0386); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead0");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "x", input.LT(-1), "a", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:194:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:194:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:195:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1431);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1441); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:202:1: ruleLookAhead1 returns [EObject current=null] : ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_y = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:204:33: ( ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:3: ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:3: ( 'foo' (lv_y= ruleLookAhead2 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:205:4: 'foo' (lv_y= ruleLookAhead2 )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead1477); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:209:1: (lv_y= ruleLookAhead2 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:212:6: lv_y= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1511);
            lv_y=ruleLookAhead2();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("LookAhead1");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "y", lv_y, "LookAhead2", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:230:3: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:232:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead1537); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "x", input.LT(-1), "b", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:250:3: (lv_x= 'd' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:252:6: lv_x= 'd'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1571); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "x", input.LT(-1), "d", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:277:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:277:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:278:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2616);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2626); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:285:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:287:33: ( ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )
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
                    new NoViableAltException("288:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:3: (lv_z= 'foo' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:288:3: (lv_z= 'foo' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:290:6: lv_z= 'foo'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleLookAhead2673); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead2");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "z", input.LT(-1), "foo", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:309:6: (lv_z= 'bar' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:309:6: (lv_z= 'bar' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:311:6: lv_z= 'bar'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleLookAhead2712); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@groups.1/@terminal" /* xtext::Keyword */, "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead2");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "z", input.LT(-1), "bar", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleLookAhead2734); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:340:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:340:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:341:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3767);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3777); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:348:1: ruleLookAhead3 returns [EObject current=null] : ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_z = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:350:33: ( ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:3: ( 'foo' 'bar' ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:3: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:351:4: 'foo' 'bar'
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead3813); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,11,FOLLOW_11_in_ruleLookAhead3822); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:359:2: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:361:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead3844); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "x"); 
                

            	        if (current==null) {
            	            current = factory.create("LookAhead3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "x", input.LT(-1), "b", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:379:3: (lv_z= ruleLookAhead4 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:382:6: lv_z= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead4_in_ruleLookAhead3891);
            lv_z=ruleLookAhead4();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("LookAhead3");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "z", lv_z, "LookAhead4", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:407:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:407:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:408:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4928);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4938); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:415:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x= 'c' ) | (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:417:33: ( ( (lv_x= 'c' ) | (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:418:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:418:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
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
                    new NoViableAltException("418:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:418:2: (lv_x= 'c' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:418:2: (lv_x= 'c' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:420:6: lv_x= 'c'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead4984); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.6/@alternatives/@groups.0/@terminal" /* xtext::Keyword */, "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead4");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "x", input.LT(-1), "c", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:439:6: (lv_x= 'd' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:439:6: (lv_x= 'd' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalLookaheadTestLanguage.g:441:6: lv_x= 'd'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleLookAhead41023); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.6/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("LookAhead4");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "x", input.LT(-1), "d", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlts186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead0365 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead0386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead1477 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1511 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1537 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead2673 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead2712 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead3813 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead3822 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3844 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead41023 = new BitSet(new long[]{0x0000000000000002L});

}