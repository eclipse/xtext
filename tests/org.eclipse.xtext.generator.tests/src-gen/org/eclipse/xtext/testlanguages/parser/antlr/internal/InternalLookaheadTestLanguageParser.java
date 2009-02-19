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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:70:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:70:47: (iv_ruleEntry= ruleEntry EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:71:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEntry().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:78:1: ruleEntry returns [EObject current=null] : (lv_contents_0= ruleAlts )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:83:6: ( (lv_contents_0= ruleAlts )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:84:1: (lv_contents_0= ruleAlts )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:84:1: (lv_contents_0= ruleAlts )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:87:6: lv_contents_0= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEntry().ele0ParserRuleCallAlts(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAlts_in_ruleEntry140);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:114:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:114:46: (iv_ruleAlts= ruleAlts EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:115:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlts().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:122:1: ruleAlts returns [EObject current=null] : ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0_0 = null;

        EObject this_LookAhead1_1 = null;

        EObject this_LookAhead3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:127:6: ( ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:128:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:128:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 )
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
                            new NoViableAltException("128:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 )", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==13) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("128:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 )", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("128:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 ) | this_LookAhead3_2= ruleLookAhead3 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:128:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:128:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 )
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
                            new NoViableAltException("128:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:129:5: this_LookAhead0_0= ruleLookAhead0
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAlts().ele00ParserRuleCallLookAhead0(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead0_in_ruleAlts237);
                            this_LookAhead0_0=ruleLookAhead0();
                            _fsp--;

                             
                                    current = this_LookAhead0_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:139:5: this_LookAhead1_1= ruleLookAhead1
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAlts().ele01ParserRuleCallLookAhead1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLookAhead1_in_ruleAlts264);
                            this_LookAhead1_1=ruleLookAhead1();
                            _fsp--;

                             
                                    current = this_LookAhead1_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:149:5: this_LookAhead3_2= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAlts().ele1ParserRuleCallLookAhead3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLookAhead3_in_ruleAlts292);
                    this_LookAhead3_2=ruleLookAhead3();
                    _fsp--;

                     
                            current = this_LookAhead3_2; 
                            currentNode = currentNode.getParent();
                        

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:166:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:166:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:167:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead0().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:174:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' (lv_x_1= 'a' ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:179:6: ( ( 'bar' (lv_x_1= 'a' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:180:1: ( 'bar' (lv_x_1= 'a' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:180:1: ( 'bar' (lv_x_1= 'a' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:180:2: 'bar' (lv_x_1= 'a' )
            {
            match(input,11,FOLLOW_11_in_ruleLookAhead0370); 

                    createLeafNode(grammarAccess.prLookAhead0().ele0KeywordBar(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:184:1: (lv_x_1= 'a' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:186:6: lv_x_1= 'a'
            {
            lv_x_1=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleLookAhead0391); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:214:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:214:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:215:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1439);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead1449); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:222:1: ruleLookAhead1 returns [EObject current=null] : ( ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) ) (lv_x_3= 'd' ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x_2=null;
        Token lv_x_3=null;
        EObject lv_y_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:227:6: ( ( ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) ) (lv_x_3= 'd' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:1: ( ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) ) (lv_x_3= 'd' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:1: ( ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) ) (lv_x_3= 'd' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:2: ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) ) (lv_x_3= 'd' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:2: ( ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:3: ( 'foo' (lv_y_1= ruleLookAhead2 ) ) (lv_x_2= 'b' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:3: ( 'foo' (lv_y_1= ruleLookAhead2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:228:4: 'foo' (lv_y_1= ruleLookAhead2 )
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead1485); 

                    createLeafNode(grammarAccess.prLookAhead1().ele000KeywordFoo(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:232:1: (lv_y_1= ruleLookAhead2 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:235:6: lv_y_1= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prLookAhead1().ele0010ParserRuleCallLookAhead2(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLookAhead2_in_ruleLookAhead1519);
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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:253:3: (lv_x_2= 'b' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:255:6: lv_x_2= 'b'
            {
            lv_x_2=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead1545); 

                    createLeafNode(grammarAccess.prLookAhead1().ele010KeywordB(), "x"); 
                

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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:274:3: (lv_x_3= 'd' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:276:6: lv_x_3= 'd'
            {
            lv_x_3=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleLookAhead1580); 

                    createLeafNode(grammarAccess.prLookAhead1().ele10KeywordD(), "x"); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:304:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:304:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:305:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2628);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead2638); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:312:1: ruleLookAhead2 returns [EObject current=null] : ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z_0=null;
        Token lv_z_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:317:6: ( ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:1: ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:1: ( ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) ) 'c'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) )
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
                    new NoViableAltException("318:2: ( (lv_z_0= 'foo' ) | (lv_z_1= 'bar' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:3: (lv_z_0= 'foo' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:3: (lv_z_0= 'foo' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:320:6: lv_z_0= 'foo'
                    {
                    lv_z_0=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleLookAhead2685); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:340:6: (lv_z_1= 'bar' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:340:6: (lv_z_1= 'bar' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:342:6: lv_z_1= 'bar'
                    {
                    lv_z_1=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleLookAhead2725); 

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

            match(input,16,FOLLOW_16_in_ruleLookAhead2748); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:374:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:374:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:375:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead3().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3783);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead3793); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:382:1: ruleLookAhead3 returns [EObject current=null] : ( ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) ) (lv_z_3= ruleLookAhead4 ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x_2=null;
        EObject lv_z_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:387:6: ( ( ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) ) (lv_z_3= ruleLookAhead4 ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:1: ( ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) ) (lv_z_3= ruleLookAhead4 ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:1: ( ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) ) (lv_z_3= ruleLookAhead4 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:2: ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) ) (lv_z_3= ruleLookAhead4 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:2: ( ( 'foo' 'bar' ) (lv_x_2= 'b' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:3: ( 'foo' 'bar' ) (lv_x_2= 'b' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:3: ( 'foo' 'bar' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:4: 'foo' 'bar'
            {
            match(input,13,FOLLOW_13_in_ruleLookAhead3829); 

                    createLeafNode(grammarAccess.prLookAhead3().ele000KeywordFoo(), null); 
                
            match(input,11,FOLLOW_11_in_ruleLookAhead3838); 

                    createLeafNode(grammarAccess.prLookAhead3().ele001KeywordBar(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:396:2: (lv_x_2= 'b' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:398:6: lv_x_2= 'b'
            {
            lv_x_2=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleLookAhead3860); 

                    createLeafNode(grammarAccess.prLookAhead3().ele010KeywordB(), "x"); 
                

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


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:417:3: (lv_z_3= ruleLookAhead4 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:420:6: lv_z_3= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prLookAhead3().ele10ParserRuleCallLookAhead4(), currentNode); 
            	    
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:447:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:447:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:448:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLookAhead4().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4947);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLookAhead4957); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:455:1: ruleLookAhead4 returns [EObject current=null] : ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x_0=null;
        Token lv_x_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:460:6: ( ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:461:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:461:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )
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
                    new NoViableAltException("461:1: ( (lv_x_0= 'c' ) | (lv_x_1= 'd' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:461:2: (lv_x_0= 'c' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:461:2: (lv_x_0= 'c' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:463:6: lv_x_0= 'c'
                    {
                    lv_x_0=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleLookAhead41003); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:483:6: (lv_x_1= 'd' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:483:6: (lv_x_1= 'd' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:485:6: lv_x_1= 'd'
                    {
                    lv_x_1=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleLookAhead41043); 

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
    public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead1485 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1519 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead1545 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead2685 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead2725 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleLookAhead3829 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleLookAhead3838 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLookAhead3860 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLookAhead41003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLookAhead41043 = new BitSet(new long[]{0x0000000000000002L});

}