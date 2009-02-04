package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLookaheadTestLanguageParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g"; }


     
        public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLookaheadTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Entry";	
       	} 



    // $ANTLR start entryRuleEntry
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:68:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:68:47: (iv_ruleEntry= ruleEntry EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:69:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntry_in_entryRuleEntry72);
            iv_ruleEntry=ruleEntry();
            _fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntry82); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:76:1: ruleEntry returns [EObject current=null] : (lv_contents= ruleAlts )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:80:6: ( (lv_contents= ruleAlts )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:81:1: (lv_contents= ruleAlts )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:81:1: (lv_contents= ruleAlts )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:84:6: lv_contents= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry140);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:111:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:111:46: (iv_ruleAlts= ruleAlts EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:112:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlts_in_entryRuleAlts179);
            iv_ruleAlts=ruleAlts();
            _fsp--;

             current =iv_ruleAlts; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlts189); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:119:1: ruleAlts returns [EObject current=null] : ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0 = null;

        EObject this_LookAhead1 = null;

        EObject this_LookAhead3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:123:6: ( ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )
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
                            new NoViableAltException("124:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==13) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("124:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("124:1: ( (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 ) | this_LookAhead3= ruleLookAhead3 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )
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
                            new NoViableAltException("124:2: (this_LookAhead0= ruleLookAhead0 | this_LookAhead1= ruleLookAhead1 )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:125:5: this_LookAhead0= ruleLookAhead0
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts237);
                            this_LookAhead0=ruleLookAhead0();
                            _fsp--;

                             
                                    current = this_LookAhead0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:135:5: this_LookAhead1= ruleLookAhead1
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts264);
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
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:145:5: this_LookAhead3= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts292);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:162:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:162:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:163:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0326);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead0336); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:170:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:174:6: ( ( 'bar' (lv_x= 'a' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:175:1: ( 'bar' (lv_x= 'a' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:175:1: ( 'bar' (lv_x= 'a' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:175:2: 'bar' (lv_x= 'a' )
            {
            match(input,11,FOLLOW_11_in_ruleLookAhead0370); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:179:1: (lv_x= 'a' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:181:6: lv_x= 'a'
            {
            lv_x=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleLookAhead0391); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:208:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:208:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:209:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1438);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1448); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:216:1: ruleLookAhead1 returns [EObject current=null] : ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_y = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:220:6: ( ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:1: ( ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) ) (lv_x= 'd' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:2: ( ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:3: ( 'foo' (lv_y= ruleLookAhead2 ) ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:3: ( 'foo' (lv_y= ruleLookAhead2 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:221:4: 'foo' (lv_y= ruleLookAhead2 )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead1484); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:225:1: (lv_y= ruleLookAhead2 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:6: lv_y= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1518);
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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:246:3: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:248:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead1544); 

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:266:3: (lv_x= 'd' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:268:6: lv_x= 'd'
            {
            lv_x=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1578); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:295:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:295:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:296:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2625);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2635); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:303:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:307:6: ( ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:1: ( ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) ) 'c'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )
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
                    new NoViableAltException("308:2: ( (lv_z= 'foo' ) | (lv_z= 'bar' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:3: (lv_z= 'foo' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:3: (lv_z= 'foo' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:310:6: lv_z= 'foo'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleLookAhead2682); 

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
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:329:6: (lv_z= 'bar' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:329:6: (lv_z= 'bar' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:331:6: lv_z= 'bar'
                    {
                    lv_z=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleLookAhead2721); 

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

            match(input,16,FOLLOW_16_in_ruleLookAhead2743); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:362:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:362:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:363:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3778);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3788); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:370:1: ruleLookAhead3 returns [EObject current=null] : ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;
        EObject lv_z = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:374:6: ( ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:1: ( ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) ) (lv_z= ruleLookAhead4 )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:2: ( ( 'foo' 'bar' ) (lv_x= 'b' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:3: ( 'foo' 'bar' ) (lv_x= 'b' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:3: ( 'foo' 'bar' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:4: 'foo' 'bar'
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead3824); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,11,FOLLOW_11_in_ruleLookAhead3833); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:383:2: (lv_x= 'b' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:385:6: lv_x= 'b'
            {
            lv_x=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead3855); 

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:403:3: (lv_z= ruleLookAhead4 )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:406:6: lv_z= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead4_in_ruleLookAhead3902);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:433:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:433:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:434:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4941);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4951); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:441:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x= 'c' ) | (lv_x= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:445:6: ( ( (lv_x= 'c' ) | (lv_x= 'd' ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )
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
                    new NoViableAltException("446:1: ( (lv_x= 'c' ) | (lv_x= 'd' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:2: (lv_x= 'c' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:2: (lv_x= 'c' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:448:6: lv_x= 'c'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead4997); 

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
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:467:6: (lv_x= 'd' )
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:467:6: (lv_x= 'd' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:469:6: lv_x= 'd'
                    {
                    lv_x=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleLookAhead41036); 

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


 

    public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntry82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlts_in_ruleEntry140 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlts189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead0370 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead0391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead1484 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1518 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1544 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead2682 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead2721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead3824 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead3833 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3855 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead41036 = new BitSet(new long[]{0x0000000000000002L});

}