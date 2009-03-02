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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g"; }


     
     	private LookaheadTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, LookaheadTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Entry";	
       	} 



    // $ANTLR start entryRuleEntry
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:69:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:69:47: (iv_ruleEntry= ruleEntry EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:70:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEntry().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:77:1: ruleEntry returns [EObject current=null] : (lv_contents_0= ruleAlts )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:82:6: ( (lv_contents_0= ruleAlts )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:83:1: (lv_contents_0= ruleAlts )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:83:1: (lv_contents_0= ruleAlts )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:86:6: lv_contents_0= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEntry().ele0ParserRuleCallAlts(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry139);
            	    lv_contents_0=ruleAlts();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEntry().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "contents", lv_contents_0, "Alts", currentNode);
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
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:111:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:111:46: (iv_ruleAlts= ruleAlts EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:112:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlts().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:119:1: ruleAlts returns [EObject current=null] : (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0_0 = null;

        EObject this_LookAhead1_1 = null;

        EObject this_LookAhead3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:6: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:125:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:125:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==11) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==14) ) {
                        alt2=3;
                    }
                    else if ( (LA2_3==16) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("125:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("125:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("125:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:126:5: this_LookAhead0_0= ruleLookAhead0
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAlts().ele0ParserRuleCallLookAhead0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts233);
                    this_LookAhead0_0=ruleLookAhead0();
                    _fsp--;

                     
                            current = this_LookAhead0_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAlts().ele0ParserRuleCallLookAhead0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:140:5: this_LookAhead1_1= ruleLookAhead1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAlts().ele1ParserRuleCallLookAhead1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts267);
                    this_LookAhead1_1=ruleLookAhead1();
                    _fsp--;

                     
                            current = this_LookAhead1_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAlts().ele1ParserRuleCallLookAhead1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:154:5: this_LookAhead3_2= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAlts().ele2ParserRuleCallLookAhead3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts301);
                    this_LookAhead3_2=ruleLookAhead3();
                    _fsp--;

                     
                            current = this_LookAhead3_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAlts().ele2ParserRuleCallLookAhead3(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:173:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:173:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:174:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead0().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0340);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead0350); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:181:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x_1= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:186:6: ( ( 'bar' (lv_x_1= 'a' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:187:1: ( 'bar' (lv_x_1= 'a' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:187:1: ( 'bar' (lv_x_1= 'a' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:187:2: 'bar' (lv_x_1= 'a' )
            {
            match(input,11,FOLLOW_11_in_ruleLookAhead0384); 

                    createLeafNode(grammarAccess.prLookAhead0().ele0KeywordBar(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:191:1: (lv_x_1= 'a' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:193:6: lv_x_1= 'a'
            {
            lv_x_1=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleLookAhead0405); 

                    createLeafNode(grammarAccess.prLookAhead0().ele10KeywordA(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead0().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", /* lv_x_1 */ input.LT(-1), "a", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:219:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:219:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:220:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1451);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1461); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:227:1: ruleLookAhead1 returns [EObject current=null] : ( 'foo' (lv_y_1= ruleLookAhead2 ) (lv_x_2= 'b' ) (lv_x_3= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x_2=null;
        Token lv_x_3=null;
        EObject lv_y_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:232:6: ( ( 'foo' (lv_y_1= ruleLookAhead2 ) (lv_x_2= 'b' ) (lv_x_3= 'd' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:1: ( 'foo' (lv_y_1= ruleLookAhead2 ) (lv_x_2= 'b' ) (lv_x_3= 'd' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:1: ( 'foo' (lv_y_1= ruleLookAhead2 ) (lv_x_2= 'b' ) (lv_x_3= 'd' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:2: 'foo' (lv_y_1= ruleLookAhead2 ) (lv_x_2= 'b' ) (lv_x_3= 'd' )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead1495); 

                    createLeafNode(grammarAccess.prLookAhead1().ele0KeywordFoo(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:237:1: (lv_y_1= ruleLookAhead2 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:240:6: lv_y_1= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prLookAhead1().ele10ParserRuleCallLookAhead2(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1529);
            lv_y_1=ruleLookAhead2();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead1().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "y", lv_y_1, "LookAhead2", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:258:2: (lv_x_2= 'b' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:260:6: lv_x_2= 'b'
            {
            lv_x_2=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead1554); 

                    createLeafNode(grammarAccess.prLookAhead1().ele20KeywordB(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead1().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", /* lv_x_2 */ input.LT(-1), "b", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:279:2: (lv_x_3= 'd' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:281:6: lv_x_3= 'd'
            {
            lv_x_3=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1588); 

                    createLeafNode(grammarAccess.prLookAhead1().ele30KeywordD(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead1().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", /* lv_x_3 */ input.LT(-1), "d", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:307:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:307:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:308:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2634);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2644); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:315:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z_0=null;
        Token lv_z_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:320:6: ( ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:1: ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:1: ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("321:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:3: (lv_z_0= 'foo' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:321:3: (lv_z_0= 'foo' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:323:6: lv_z_0= 'foo'
                    {
                    lv_z_0=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleLookAhead2691); 

                            createLeafNode(grammarAccess.prLookAhead2().ele000KeywordFoo(), "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLookAhead2().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "z", /* lv_z_0 */ input.LT(-1), "foo", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:343:6: (lv_z_1= 'bar' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:343:6: (lv_z_1= 'bar' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:345:6: lv_z_1= 'bar'
                    {
                    lv_z_1=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleLookAhead2731); 

                            createLeafNode(grammarAccess.prLookAhead2().ele010KeywordBar(), "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLookAhead2().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "z", /* lv_z_1 */ input.LT(-1), "bar", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleLookAhead2754); 

                    createLeafNode(grammarAccess.prLookAhead2().ele1KeywordC(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:376:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead3().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3787);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3797); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:383:1: ruleLookAhead3 returns [EObject current=null] : ( 'foo' 'bar' (lv_x_2= 'b' ) (lv_z_3= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x_2=null;
        EObject lv_z_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:6: ( ( 'foo' 'bar' (lv_x_2= 'b' ) (lv_z_3= ruleLookAhead4 ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:389:1: ( 'foo' 'bar' (lv_x_2= 'b' ) (lv_z_3= ruleLookAhead4 ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:389:1: ( 'foo' 'bar' (lv_x_2= 'b' ) (lv_z_3= ruleLookAhead4 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:389:2: 'foo' 'bar' (lv_x_2= 'b' ) (lv_z_3= ruleLookAhead4 )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead3831); 

                    createLeafNode(grammarAccess.prLookAhead3().ele0KeywordFoo(), null); 
                
            match(input,11,FOLLOW_11_in_ruleLookAhead3840); 

                    createLeafNode(grammarAccess.prLookAhead3().ele1KeywordBar(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:397:1: (lv_x_2= 'b' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:399:6: lv_x_2= 'b'
            {
            lv_x_2=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead3861); 

                    createLeafNode(grammarAccess.prLookAhead3().ele20KeywordB(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead3().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", /* lv_x_2 */ input.LT(-1), "b", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:418:2: (lv_z_3= ruleLookAhead4 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:421:6: lv_z_3= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prLookAhead3().ele30ParserRuleCallLookAhead4(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead4_in_ruleLookAhead3908);
            lv_z_3=ruleLookAhead4();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLookAhead3().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "z", lv_z_3, "LookAhead4", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:446:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:447:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead4().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4945);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4955); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:454:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x_0=null;
        Token lv_x_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:459:6: ( ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:460:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:460:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("460:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:460:2: (lv_x_0= 'c' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:460:2: (lv_x_0= 'c' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:462:6: lv_x_0= 'c'
                    {
                    lv_x_0=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead41001); 

                            createLeafNode(grammarAccess.prLookAhead4().ele00KeywordC(), "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLookAhead4().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "x", /* lv_x_0 */ input.LT(-1), "c", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:482:6: (lv_x_1= 'd' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:482:6: (lv_x_1= 'd' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:484:6: lv_x_1= 'd'
                    {
                    lv_x_1=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleLookAhead41041); 

                            createLeafNode(grammarAccess.prLookAhead4().ele10KeywordD(), "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLookAhead4().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "x", /* lv_x_1 */ input.LT(-1), "d", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead0384 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLookAhead0405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead1495 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1529 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1554 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead2691 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead2731 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead3831 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead3840 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3861 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead41001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead41041 = new BitSet(new long[]{0x0000000000000002L});

}