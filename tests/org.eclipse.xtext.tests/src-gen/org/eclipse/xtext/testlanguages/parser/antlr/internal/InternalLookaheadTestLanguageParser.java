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

@SuppressWarnings("all")
public class InternalLookaheadTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bar'", "'a'", "'foo'", "'b'", "'d'", "'c'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalLookaheadTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLookaheadTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLookaheadTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g"; }



     	private LookaheadTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLookaheadTestLanguageParser(TokenStream input, IAstFactory factory, LookaheadTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Entry";	
       	}
       	
       	@Override
       	protected LookaheadTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEntry"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:71:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:72:2: (iv_ruleEntry= ruleEntry EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:73:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEntry_in_entryRuleEntry75);
            iv_ruleEntry=ruleEntry();

            state._fsp--;

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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:80:1: ruleEntry returns [EObject current=null] : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:85:6: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:86:1: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:86:1: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:87:1: (lv_contents_0_0= ruleAlts )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:87:1: (lv_contents_0_0= ruleAlts )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:88:3: lv_contents_0_0= ruleAlts
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntryAccess().getContentsAltsParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAlts_in_ruleEntry130);
            	    lv_contents_0_0=ruleAlts();

            	    state._fsp--;


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
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleAlts"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:118:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:119:2: (iv_ruleAlts= ruleAlts EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:120:2: iv_ruleAlts= ruleAlts EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlts_in_entryRuleAlts166);
            iv_ruleAlts=ruleAlts();

            state._fsp--;

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
    // $ANTLR end "entryRuleAlts"


    // $ANTLR start "ruleAlts"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:127:1: ruleAlts returns [EObject current=null] : (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0_0 = null;

        EObject this_LookAhead1_1 = null;

        EObject this_LookAhead3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:132:6: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:133:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:133:1: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==11) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==16) ) {
                        alt2=2;
                    }
                    else if ( (LA2_3==14) ) {
                        alt2=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:134:5: this_LookAhead0_0= ruleLookAhead0
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead0ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_ruleAlts223);
                    this_LookAhead0_0=ruleLookAhead0();

                    state._fsp--;

                     
                            current = this_LookAhead0_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:144:5: this_LookAhead1_1= ruleLookAhead1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead1ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_ruleAlts250);
                    this_LookAhead1_1=ruleLookAhead1();

                    state._fsp--;

                     
                            current = this_LookAhead1_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:154:5: this_LookAhead3_2= ruleLookAhead3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAltsAccess().getLookAhead3ParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_ruleAlts277);
                    this_LookAhead3_2=ruleLookAhead3();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleAlts"


    // $ANTLR start "entryRuleLookAhead0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:170:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:171:2: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:172:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0312);
            iv_ruleLookAhead0=ruleLookAhead0();

            state._fsp--;

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
    // $ANTLR end "entryRuleLookAhead0"


    // $ANTLR start "ruleLookAhead0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:179:1: ruleLookAhead0 returns [EObject current=null] : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:184:6: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:185:1: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:185:1: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:185:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead0359); 

                	createLeafNode(otherlv_0, grammarAccess.getLookAhead0Access().getBarKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:189:1: ( (lv_x_1_0= 'a' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:190:1: (lv_x_1_0= 'a' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:190:1: (lv_x_1_0= 'a' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:191:3: lv_x_1_0= 'a'
            {
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLookAhead0377); 

                    createLeafNode(lv_x_1_0, grammarAccess.getLookAhead0Access().getXAKeyword_1_0(), "x");
                

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
    // $ANTLR end "ruleLookAhead0"


    // $ANTLR start "entryRuleLookAhead1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:218:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:219:2: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:220:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1426);
            iv_ruleLookAhead1=ruleLookAhead1();

            state._fsp--;

             current =iv_ruleLookAhead1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead1436); 

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
    // $ANTLR end "entryRuleLookAhead1"


    // $ANTLR start "ruleLookAhead1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:227:1: ruleLookAhead1 returns [EObject current=null] : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_x_3_0=null;
        EObject lv_y_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:232:6: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:1: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:1: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:233:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_x_3_0= 'd' ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead1473); 

                	createLeafNode(otherlv_0, grammarAccess.getLookAhead1Access().getFooKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:237:1: ( (lv_y_1_0= ruleLookAhead2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:238:1: (lv_y_1_0= ruleLookAhead2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:238:1: (lv_y_1_0= ruleLookAhead2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:239:3: lv_y_1_0= ruleLookAhead2
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLookAhead1Access().getYLookAhead2ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_ruleLookAhead1494);
            lv_y_1_0=ruleLookAhead2();

            state._fsp--;


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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:261:2: ( (lv_x_2_0= 'b' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:262:1: (lv_x_2_0= 'b' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:262:1: (lv_x_2_0= 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:263:3: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead1512); 

                    createLeafNode(lv_x_2_0, grammarAccess.getLookAhead1Access().getXBKeyword_2_0(), "x");
                

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:282:2: ( (lv_x_3_0= 'd' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:283:1: (lv_x_3_0= 'd' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:283:1: (lv_x_3_0= 'd' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:284:3: lv_x_3_0= 'd'
            {
            lv_x_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead1543); 

                    createLeafNode(lv_x_3_0, grammarAccess.getLookAhead1Access().getXDKeyword_3_0(), "x");
                

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
    // $ANTLR end "ruleLookAhead1"


    // $ANTLR start "entryRuleLookAhead2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:311:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:312:2: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:313:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2592);
            iv_ruleLookAhead2=ruleLookAhead2();

            state._fsp--;

             current =iv_ruleLookAhead2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead2602); 

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
    // $ANTLR end "entryRuleLookAhead2"


    // $ANTLR start "ruleLookAhead2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:320:1: ruleLookAhead2 returns [EObject current=null] : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:325:6: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:1: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:1: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:2: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:2: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:3: ( (lv_z_0_0= 'foo' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:326:3: ( (lv_z_0_0= 'foo' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:327:1: (lv_z_0_0= 'foo' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:327:1: (lv_z_0_0= 'foo' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:328:3: lv_z_0_0= 'foo'
                    {
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead2646); 

                            createLeafNode(lv_z_0_0, grammarAccess.getLookAhead2Access().getZFooKeyword_0_0_0(), "z");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:348:6: ( (lv_z_1_0= 'bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:348:6: ( (lv_z_1_0= 'bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:349:1: (lv_z_1_0= 'bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:349:1: (lv_z_1_0= 'bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:350:3: lv_z_1_0= 'bar'
                    {
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead2683); 

                            createLeafNode(lv_z_1_0, grammarAccess.getLookAhead2Access().getZBarKeyword_0_1_0(), "z");
                        

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

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead2709); 

                	createLeafNode(otherlv_2, grammarAccess.getLookAhead2Access().getCKeyword_1(), null);
                

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
    // $ANTLR end "ruleLookAhead2"


    // $ANTLR start "entryRuleLookAhead3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:381:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:382:2: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:383:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3745);
            iv_ruleLookAhead3=ruleLookAhead3();

            state._fsp--;

             current =iv_ruleLookAhead3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead3755); 

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
    // $ANTLR end "entryRuleLookAhead3"


    // $ANTLR start "ruleLookAhead3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:390:1: ruleLookAhead3 returns [EObject current=null] : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;
        EObject lv_z_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:395:6: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:396:1: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:396:1: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:396:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead3792); 

                	createLeafNode(otherlv_0, grammarAccess.getLookAhead3Access().getFooKeyword_0(), null);
                
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead3804); 

                	createLeafNode(otherlv_1, grammarAccess.getLookAhead3Access().getBarKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:404:1: ( (lv_x_2_0= 'b' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:405:1: (lv_x_2_0= 'b' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:405:1: (lv_x_2_0= 'b' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:406:3: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead3822); 

                    createLeafNode(lv_x_2_0, grammarAccess.getLookAhead3Access().getXBKeyword_2_0(), "x");
                

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:425:2: ( (lv_z_3_0= ruleLookAhead4 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:426:1: (lv_z_3_0= ruleLookAhead4 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:426:1: (lv_z_3_0= ruleLookAhead4 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:427:3: lv_z_3_0= ruleLookAhead4
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLookAhead3Access().getZLookAhead4ParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_ruleLookAhead3856);
            lv_z_3_0=ruleLookAhead4();

            state._fsp--;


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
    // $ANTLR end "ruleLookAhead3"


    // $ANTLR start "entryRuleLookAhead4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:457:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:458:2: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:459:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLookAhead4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4892);
            iv_ruleLookAhead4=ruleLookAhead4();

            state._fsp--;

             current =iv_ruleLookAhead4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead4902); 

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
    // $ANTLR end "entryRuleLookAhead4"


    // $ANTLR start "ruleLookAhead4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:466:1: ruleLookAhead4 returns [EObject current=null] : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token lv_x_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:471:6: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:472:1: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:472:1: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:472:2: ( (lv_x_0_0= 'c' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:472:2: ( (lv_x_0_0= 'c' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:473:1: (lv_x_0_0= 'c' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:473:1: (lv_x_0_0= 'c' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:474:3: lv_x_0_0= 'c'
                    {
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead4945); 

                            createLeafNode(lv_x_0_0, grammarAccess.getLookAhead4Access().getXCKeyword_0_0(), "x");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:494:6: ( (lv_x_1_0= 'd' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:494:6: ( (lv_x_1_0= 'd' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:495:1: (lv_x_1_0= 'd' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:495:1: (lv_x_1_0= 'd' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLookaheadTestLanguage.g:496:3: lv_x_1_0= 'd'
                    {
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead4982); 

                            createLeafNode(lv_x_1_0, grammarAccess.getLookAhead4Access().getXDKeyword_1_0(), "x");
                        

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
    // $ANTLR end "ruleLookAhead4"

    // Delegated rules


 

    
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
        public static final BitSet FOLLOW_11_in_ruleLookAhead0359 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLookAhead0377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead1473 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1494 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead1512 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead1543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2592 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead2646 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead2683 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead2709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead3792 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead3804 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead3822 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4892 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead4945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead4982 = new BitSet(new long[]{0x0000000000000002L});
    }


}