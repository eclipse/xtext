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
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalLookaheadTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g"; }



     	private LookaheadTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, LookaheadTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
       	
       	@Override
       	protected LookaheadTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleEntry
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:77:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:78:2: (iv_ruleEntry= ruleEntry EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:79:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEntry_in_entryRuleEntry75);
            iv_ruleEntry=ruleEntry();
            _fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntry85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:86:1: ruleEntry returns [EObject current=null] : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:91:6: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:92:1: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:92:1: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:93:1: (lv_contents_0_0= ruleAlts )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:93:1: (lv_contents_0_0= ruleAlts )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:94:3: lv_contents_0_0= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntryAccess().getContentsAltsParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAlts_in_ruleEntry130);
            	    lv_contents_0_0=ruleAlts();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"contents",
            	    	        		lv_contents_0_0, 
            	    	        		"Alts", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:124:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:125:2: (iv_ruleAlts= ruleAlts EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:126:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlts_in_entryRuleAlts166);
            iv_ruleAlts=ruleAlts();
            _fsp--;

             current =iv_ruleAlts; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlts176); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:133:1: ruleAlts returns [EObject current=null] : (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0_0 = null;

        EObject this_LookAhead1_1 = null;

        EObject this_LookAhead3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:138:6: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:139:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:139:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
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
                            new NoViableAltException("139:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("139:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("139:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:140:5: this_LookAhead0_0= ruleLookAhead0
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead0ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_ruleAlts223);
                    this_LookAhead0_0=ruleLookAhead0();
                    _fsp--;

                     
                            current = this_LookAhead0_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:150:5: this_LookAhead1_1= ruleLookAhead1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead1ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_ruleAlts250);
                    this_LookAhead1_1=ruleLookAhead1();
                    _fsp--;

                     
                            current = this_LookAhead1_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:160:5: this_LookAhead3_2= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead3ParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_ruleAlts277);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:176:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:177:2: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:178:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0312);
            iv_ruleLookAhead0=ruleLookAhead0();
            _fsp--;

             current =iv_ruleLookAhead0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead0322); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:185:1: ruleLookAhead0 returns [EObject current=null] : ( 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token lv_x_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:190:6: ( ( 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:191:1: ( 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:191:1: ( 'bar' ( (lv_x_1_0= 'a' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:191:3: 'bar' ( (lv_x_1_0= 'a' ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead0357); 

                    createLeafNode(grammarAccess.getLookAhead0Access().getBarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:195:1: ( (lv_x_1_0= 'a' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:196:1: (lv_x_1_0= 'a' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:196:1: (lv_x_1_0= 'a' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:197:3: lv_x_1_0= 'a'
            {
            lv_x_1_0=(Token)input.LT(1);
            match(input,12,FollowSets000.FOLLOW_12_in_ruleLookAhead0375); 

                    createLeafNode(grammarAccess.getLookAhead0Access().getXAKeyword_1_0(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead0Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", lv_x_1_0, "a", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:224:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:225:2: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:226:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1424);
            iv_ruleLookAhead1=ruleLookAhead1();
            _fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead1434); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:1: ruleLookAhead1 returns [EObject current=null] : ( 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token lv_x_2_0=null;
        Token lv_x_3_0=null;
        EObject lv_y_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:238:6: ( ( 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:239:1: ( 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:239:1: ( 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:239:3: 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) )
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead1469); 

                    createLeafNode(grammarAccess.getLookAhead1Access().getFooKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:243:1: ( (lv_y_1_0= ruleLookAhead2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:244:1: (lv_y_1_0= ruleLookAhead2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:244:1: (lv_y_1_0= ruleLookAhead2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:245:3: lv_y_1_0= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLookAhead1Access().getYLookAhead2ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_ruleLookAhead1490);
            lv_y_1_0=ruleLookAhead2();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"y",
            	        		lv_y_1_0, 
            	        		"LookAhead2", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:267:2: ( (lv_x_2_0= 'b' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:268:1: (lv_x_2_0= 'b' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:268:1: (lv_x_2_0= 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:269:3: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)input.LT(1);
            match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead1508); 

                    createLeafNode(grammarAccess.getLookAhead1Access().getXBKeyword_2_0(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", lv_x_2_0, "b", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:288:2: ( (lv_x_3_0= 'd' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:289:1: (lv_x_3_0= 'd' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:289:1: (lv_x_3_0= 'd' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:290:3: lv_x_3_0= 'd'
            {
            lv_x_3_0=(Token)input.LT(1);
            match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead1539); 

                    createLeafNode(grammarAccess.getLookAhead1Access().getXDKeyword_3_0(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", lv_x_3_0, "d", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:317:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:318:2: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:319:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2588);
            iv_ruleLookAhead2=ruleLookAhead2();
            _fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead2598); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:1: ruleLookAhead2 returns [EObject current=null] : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z_0_0=null;
        Token lv_z_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:331:6: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) 'c' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:1: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) 'c' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:1: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) 'c' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:2: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) 'c'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:2: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
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
                    new NoViableAltException("332:2: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:3: ( (lv_z_0_0= 'foo' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:332:3: ( (lv_z_0_0= 'foo' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:333:1: (lv_z_0_0= 'foo' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:333:1: (lv_z_0_0= 'foo' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:334:3: lv_z_0_0= 'foo'
                    {
                    lv_z_0_0=(Token)input.LT(1);
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead2642); 

                            createLeafNode(grammarAccess.getLookAhead2Access().getZFooKeyword_0_0_0(), "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLookAhead2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "z", lv_z_0_0, "foo", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:354:6: ( (lv_z_1_0= 'bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:354:6: ( (lv_z_1_0= 'bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:355:1: (lv_z_1_0= 'bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:355:1: (lv_z_1_0= 'bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:356:3: lv_z_1_0= 'bar'
                    {
                    lv_z_1_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead2679); 

                            createLeafNode(grammarAccess.getLookAhead2Access().getZBarKeyword_0_1_0(), "z"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLookAhead2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "z", lv_z_1_0, "bar", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead2703); 

                    createLeafNode(grammarAccess.getLookAhead2Access().getCKeyword_1(), null); 
                

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:387:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:388:2: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:389:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3739);
            iv_ruleLookAhead3=ruleLookAhead3();
            _fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead3749); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:396:1: ruleLookAhead3 returns [EObject current=null] : ( 'foo' 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token lv_x_2_0=null;
        EObject lv_z_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:401:6: ( ( 'foo' 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:402:1: ( 'foo' 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:402:1: ( 'foo' 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:402:3: 'foo' 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead3784); 

                    createLeafNode(grammarAccess.getLookAhead3Access().getFooKeyword_0(), null); 
                
            match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead3794); 

                    createLeafNode(grammarAccess.getLookAhead3Access().getBarKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:410:1: ( (lv_x_2_0= 'b' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:411:1: (lv_x_2_0= 'b' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:411:1: (lv_x_2_0= 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:412:3: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)input.LT(1);
            match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead3812); 

                    createLeafNode(grammarAccess.getLookAhead3Access().getXBKeyword_2_0(), "x"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "x", lv_x_2_0, "b", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:431:2: ( (lv_z_3_0= ruleLookAhead4 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:432:1: (lv_z_3_0= ruleLookAhead4 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:432:1: (lv_z_3_0= ruleLookAhead4 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:433:3: lv_z_3_0= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLookAhead3Access().getZLookAhead4ParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_ruleLookAhead3846);
            lv_z_3_0=ruleLookAhead4();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLookAhead3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"z",
            	        		lv_z_3_0, 
            	        		"LookAhead4", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleLookAhead3


    // $ANTLR start entryRuleLookAhead4
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:463:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:464:2: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:465:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4882);
            iv_ruleLookAhead4=ruleLookAhead4();
            _fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead4892); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:472:1: ruleLookAhead4 returns [EObject current=null] : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token lv_x_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:477:6: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:478:1: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:478:1: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
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
                    new NoViableAltException("478:1: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:478:2: ( (lv_x_0_0= 'c' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:478:2: ( (lv_x_0_0= 'c' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:479:1: (lv_x_0_0= 'c' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:479:1: (lv_x_0_0= 'c' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:480:3: lv_x_0_0= 'c'
                    {
                    lv_x_0_0=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead4935); 

                            createLeafNode(grammarAccess.getLookAhead4Access().getXCKeyword_0_0(), "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLookAhead4Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "x", lv_x_0_0, "c", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:500:6: ( (lv_x_1_0= 'd' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:500:6: ( (lv_x_1_0= 'd' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:501:1: (lv_x_1_0= 'd' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:501:1: (lv_x_1_0= 'd' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:502:3: lv_x_1_0= 'd'
                    {
                    lv_x_1_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead4972); 

                            createLeafNode(grammarAccess.getLookAhead4Access().getXDKeyword_1_0(), "x"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLookAhead4Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "x", lv_x_1_0, "d", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntry85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlts_in_ruleEntry130 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlts176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead0357 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLookAhead0375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1424 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead1469 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1490 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead1508 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead1539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2588 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead2642 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead2679 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead2703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3739 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead3784 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead3794 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead3812 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4882 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead4935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead4972 = new BitSet(new long[]{0x0000000000000002L});
    }


}