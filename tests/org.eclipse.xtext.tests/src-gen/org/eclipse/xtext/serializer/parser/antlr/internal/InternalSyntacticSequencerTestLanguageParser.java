package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSyntacticSequencerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINALID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_TERMINALID=5;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=7;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__22=22;
    public static final int RULE_WS=10;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalSyntacticSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSyntacticSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSyntacticSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g"; }



     	private SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSyntacticSequencerTestLanguageParser(TokenStream input, SyntacticSequencerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected SyntacticSequencerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_x1_0_0 = null;

        EObject lv_x2_1_0 = null;

        EObject lv_x3_2_0 = null;

        EObject lv_x4_3_0 = null;

        EObject lv_x5_4_0 = null;

        EObject lv_x6_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:79:28: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 19:
                {
                alt1=3;
                }
                break;
            case 22:
                {
                alt1=4;
                }
                break;
            case 24:
                {
                alt1=5;
                }
                break;
            case 25:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:2: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:2: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:81:1: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:81:1: (lv_x1_0_0= ruleMandatoryKeywords )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:82:3: lv_x1_0_0= ruleMandatoryKeywords
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX1MandatoryKeywordsParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_ruleModel131);
                    lv_x1_0_0=ruleMandatoryKeywords();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x1",
                            		lv_x1_0_0, 
                            		"MandatoryKeywords");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:99:6: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:99:6: ( (lv_x2_1_0= ruleExp0 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:100:1: (lv_x2_1_0= ruleExp0 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:100:1: (lv_x2_1_0= ruleExp0 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:101:3: lv_x2_1_0= ruleExp0
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX2Exp0ParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExp0_in_ruleModel158);
                    lv_x2_1_0=ruleExp0();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x2",
                            		lv_x2_1_0, 
                            		"Exp0");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:118:6: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:118:6: ( (lv_x3_2_0= ruleExp1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:119:1: (lv_x3_2_0= ruleExp1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:119:1: (lv_x3_2_0= ruleExp1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:120:3: lv_x3_2_0= ruleExp1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX3Exp1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExp1_in_ruleModel185);
                    lv_x3_2_0=ruleExp1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x3",
                            		lv_x3_2_0, 
                            		"Exp1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:137:6: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:137:6: ( (lv_x4_3_0= ruleExp2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:138:1: (lv_x4_3_0= ruleExp2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:138:1: (lv_x4_3_0= ruleExp2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:139:3: lv_x4_3_0= ruleExp2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX4Exp2ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExp2_in_ruleModel212);
                    lv_x4_3_0=ruleExp2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x4",
                            		lv_x4_3_0, 
                            		"Exp2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:156:6: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:156:6: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:157:1: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:157:1: (lv_x5_4_0= ruleSingleCrossReference )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:158:3: lv_x5_4_0= ruleSingleCrossReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX5SingleCrossReferenceParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_ruleModel239);
                    lv_x5_4_0=ruleSingleCrossReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x5",
                            		lv_x5_4_0, 
                            		"SingleCrossReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:175:6: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:175:6: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:176:1: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:176:1: (lv_x6_5_0= ruleBooleanAlternative )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:177:3: lv_x6_5_0= ruleBooleanAlternative
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX6BooleanAlternativeParserRuleCall_5_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_ruleModel266);
                    lv_x6_5_0=ruleBooleanAlternative();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x6",
                            		lv_x6_5_0, 
                            		"BooleanAlternative");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleMandatoryKeywords"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:201:1: entryRuleMandatoryKeywords returns [EObject current=null] : iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF ;
    public final EObject entryRuleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryKeywords = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:202:2: (iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:203:2: iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF
            {
             newCompositeNode(grammarAccess.getMandatoryKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords302);
            iv_ruleMandatoryKeywords=ruleMandatoryKeywords();

            state._fsp--;

             current =iv_ruleMandatoryKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryKeywords312); 

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
    // $ANTLR end "entryRuleMandatoryKeywords"


    // $ANTLR start "ruleMandatoryKeywords"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:210:1: ruleMandatoryKeywords returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
    public final EObject ruleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_val3_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:213:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMandatoryKeywords349); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryKeywordsAccess().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:218:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:219:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:219:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:220:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords366); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getMandatoryKeywordsAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMandatoryKeywords383); 

                	newLeafNode(otherlv_2, grammarAccess.getMandatoryKeywordsAccess().getKw1Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:240:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:241:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:241:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:242:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords400); 

            			newLeafNode(lv_val2_3_0, grammarAccess.getMandatoryKeywordsAccess().getVal2IDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val2",
                    		lv_val2_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMandatoryKeywords417); 

                	newLeafNode(otherlv_4, grammarAccess.getMandatoryKeywordsAccess().getKw2Keyword_4());
                
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryKeywords429); 

                	newLeafNode(otherlv_5, grammarAccess.getMandatoryKeywordsAccess().getKw3Keyword_5());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:266:1: ( (lv_val3_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:267:1: (lv_val3_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:267:1: (lv_val3_6_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:268:3: lv_val3_6_0= RULE_ID
            {
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords446); 

            			newLeafNode(lv_val3_6_0, grammarAccess.getMandatoryKeywordsAccess().getVal3IDTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val3",
                    		lv_val3_6_0, 
                    		"ID");
            	    

            }


            }

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryKeywords463); 

                	newLeafNode(otherlv_7, grammarAccess.getMandatoryKeywordsAccess().getKw4Keyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMandatoryKeywords"


    // $ANTLR start "entryRuleExp0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:296:1: entryRuleExp0 returns [EObject current=null] : iv_ruleExp0= ruleExp0 EOF ;
    public final EObject entryRuleExp0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:297:2: (iv_ruleExp0= ruleExp0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:298:2: iv_ruleExp0= ruleExp0 EOF
            {
             newCompositeNode(grammarAccess.getExp0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp0_in_entryRuleExp0499);
            iv_ruleExp0=ruleExp0();

            state._fsp--;

             current =iv_ruleExp0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp0509); 

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
    // $ANTLR end "entryRuleExp0"


    // $ANTLR start "ruleExp0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:305:1: ruleExp0 returns [EObject current=null] : (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) ;
    public final EObject ruleExp0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition0_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:308:28: ( (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:3: otherlv_0= '#2' this_Addition0_1= ruleAddition0
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleExp0546); 

                	newLeafNode(otherlv_0, grammarAccess.getExp0Access().getNumberSignDigitTwoKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp0Access().getAddition0ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_ruleExp0568);
            this_Addition0_1=ruleAddition0();

            state._fsp--;

             
                    current = this_Addition0_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp0"


    // $ANTLR start "entryRuleAddition0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:330:1: entryRuleAddition0 returns [EObject current=null] : iv_ruleAddition0= ruleAddition0 EOF ;
    public final EObject entryRuleAddition0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:331:2: (iv_ruleAddition0= ruleAddition0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:332:2: iv_ruleAddition0= ruleAddition0 EOF
            {
             newCompositeNode(grammarAccess.getAddition0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_entryRuleAddition0603);
            iv_ruleAddition0=ruleAddition0();

            state._fsp--;

             current =iv_ruleAddition0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition0613); 

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
    // $ANTLR end "entryRuleAddition0"


    // $ANTLR start "ruleAddition0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:339:1: ruleAddition0 returns [EObject current=null] : (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final EObject ruleAddition0() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim0_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:342:28: ( (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:343:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:343:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:344:5: this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition0Access().getPrim0ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0660);
            this_Prim0_0=rulePrim0();

            state._fsp--;

             
                    current = this_Prim0_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:352:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:352:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:352:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:353:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition0681); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition0Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:362:1: ( (lv_right_3_0= rulePrim0 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:363:1: (lv_right_3_0= rulePrim0 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:363:1: (lv_right_3_0= rulePrim0 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:364:3: lv_right_3_0= rulePrim0
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0702);
            	    lv_right_3_0=rulePrim0();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddition0Rule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Prim0");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition0"


    // $ANTLR start "entryRulePrim0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:388:1: entryRulePrim0 returns [EObject current=null] : iv_rulePrim0= rulePrim0 EOF ;
    public final EObject entryRulePrim0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:389:2: (iv_rulePrim0= rulePrim0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:390:2: iv_rulePrim0= rulePrim0 EOF
            {
             newCompositeNode(grammarAccess.getPrim0Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_entryRulePrim0740);
            iv_rulePrim0=rulePrim0();

            state._fsp--;

             current =iv_rulePrim0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim0750); 

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
    // $ANTLR end "entryRulePrim0"


    // $ANTLR start "rulePrim0"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:397:1: rulePrim0 returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePrim0() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:400:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:402:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrim0Access().getVal0Action_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:407:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:408:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:408:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:409:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim0801); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPrim0Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrim0Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim0"


    // $ANTLR start "entryRuleExp1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:433:1: entryRuleExp1 returns [EObject current=null] : iv_ruleExp1= ruleExp1 EOF ;
    public final EObject entryRuleExp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:434:2: (iv_ruleExp1= ruleExp1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:435:2: iv_ruleExp1= ruleExp1 EOF
            {
             newCompositeNode(grammarAccess.getExp1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp1_in_entryRuleExp1842);
            iv_ruleExp1=ruleExp1();

            state._fsp--;

             current =iv_ruleExp1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp1852); 

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
    // $ANTLR end "entryRuleExp1"


    // $ANTLR start "ruleExp1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:442:1: ruleExp1 returns [EObject current=null] : (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) ;
    public final EObject ruleExp1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition1_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:445:28: ( (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:446:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:446:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:446:3: otherlv_0= '#3' this_Addition1_1= ruleAddition1
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleExp1889); 

                	newLeafNode(otherlv_0, grammarAccess.getExp1Access().getNumberSignDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp1Access().getAddition1ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_ruleExp1911);
            this_Addition1_1=ruleAddition1();

            state._fsp--;

             
                    current = this_Addition1_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp1"


    // $ANTLR start "entryRuleAddition1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:467:1: entryRuleAddition1 returns [EObject current=null] : iv_ruleAddition1= ruleAddition1 EOF ;
    public final EObject entryRuleAddition1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:468:2: (iv_ruleAddition1= ruleAddition1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:469:2: iv_ruleAddition1= ruleAddition1 EOF
            {
             newCompositeNode(grammarAccess.getAddition1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_entryRuleAddition1946);
            iv_ruleAddition1=ruleAddition1();

            state._fsp--;

             current =iv_ruleAddition1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition1956); 

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
    // $ANTLR end "entryRuleAddition1"


    // $ANTLR start "ruleAddition1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:476:1: ruleAddition1 returns [EObject current=null] : (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final EObject ruleAddition1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim1_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:479:28: ( (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:480:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:480:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:481:5: this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition1Access().getPrim1ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11003);
            this_Prim1_0=rulePrim1();

            state._fsp--;

             
                    current = this_Prim1_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:489:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:489:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:489:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:490:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition11024); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition1Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:499:1: ( (lv_right_3_0= rulePrim1 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:500:1: (lv_right_3_0= rulePrim1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:500:1: (lv_right_3_0= rulePrim1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:501:3: lv_right_3_0= rulePrim1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11045);
            	    lv_right_3_0=rulePrim1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddition1Rule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Prim1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition1"


    // $ANTLR start "entryRulePrim1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:525:1: entryRulePrim1 returns [EObject current=null] : iv_rulePrim1= rulePrim1 EOF ;
    public final EObject entryRulePrim1() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:526:2: (iv_rulePrim1= rulePrim1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:527:2: iv_rulePrim1= rulePrim1 EOF
            {
             newCompositeNode(grammarAccess.getPrim1Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_entryRulePrim11083);
            iv_rulePrim1=rulePrim1();

            state._fsp--;

             current =iv_rulePrim1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim11093); 

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
    // $ANTLR end "entryRulePrim1"


    // $ANTLR start "rulePrim1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:534:1: rulePrim1 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) ;
    public final EObject rulePrim1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition1_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:537:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:539:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim1Access().getVal1Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:544:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:545:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:545:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:546:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim11145); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getPrim1Access().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrim1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:563:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:563:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:563:8: otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim11170); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim1Access().getAddition1ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_rulePrim11192);
                    this_Addition1_3=ruleAddition1();

                    state._fsp--;

                     
                            current = this_Addition1_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim11203); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrim1Access().getRightParenthesisKeyword_1_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim1"


    // $ANTLR start "entryRuleExp2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:588:1: entryRuleExp2 returns [EObject current=null] : iv_ruleExp2= ruleExp2 EOF ;
    public final EObject entryRuleExp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:589:2: (iv_ruleExp2= ruleExp2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:590:2: iv_ruleExp2= ruleExp2 EOF
            {
             newCompositeNode(grammarAccess.getExp2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp2_in_entryRuleExp21240);
            iv_ruleExp2=ruleExp2();

            state._fsp--;

             current =iv_ruleExp2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp21250); 

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
    // $ANTLR end "entryRuleExp2"


    // $ANTLR start "ruleExp2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:597:1: ruleExp2 returns [EObject current=null] : (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) ;
    public final EObject ruleExp2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:600:28: ( (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:3: otherlv_0= '#4' this_Addition2_1= ruleAddition2
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleExp21287); 

                	newLeafNode(otherlv_0, grammarAccess.getExp2Access().getNumberSignDigitFourKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp2Access().getAddition2ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_ruleExp21309);
            this_Addition2_1=ruleAddition2();

            state._fsp--;

             
                    current = this_Addition2_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp2"


    // $ANTLR start "entryRuleAddition2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:622:1: entryRuleAddition2 returns [EObject current=null] : iv_ruleAddition2= ruleAddition2 EOF ;
    public final EObject entryRuleAddition2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:623:2: (iv_ruleAddition2= ruleAddition2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:624:2: iv_ruleAddition2= ruleAddition2 EOF
            {
             newCompositeNode(grammarAccess.getAddition2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_entryRuleAddition21344);
            iv_ruleAddition2=ruleAddition2();

            state._fsp--;

             current =iv_ruleAddition2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition21354); 

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
    // $ANTLR end "entryRuleAddition2"


    // $ANTLR start "ruleAddition2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:631:1: ruleAddition2 returns [EObject current=null] : (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final EObject ruleAddition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Multiplication2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:634:28: ( (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:635:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:635:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:636:5: this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition2Access().getMultiplication2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21401);
            this_Multiplication2_0=ruleMultiplication2();

            state._fsp--;

             
                    current = this_Multiplication2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:644:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:644:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:644:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:645:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition21422); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition2Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:654:1: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:655:1: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:655:1: (lv_right_3_0= ruleMultiplication2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:656:3: lv_right_3_0= ruleMultiplication2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21443);
            	    lv_right_3_0=ruleMultiplication2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddition2Rule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Multiplication2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition2"


    // $ANTLR start "entryRuleMultiplication2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:680:1: entryRuleMultiplication2 returns [EObject current=null] : iv_ruleMultiplication2= ruleMultiplication2 EOF ;
    public final EObject entryRuleMultiplication2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:681:2: (iv_ruleMultiplication2= ruleMultiplication2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:682:2: iv_ruleMultiplication2= ruleMultiplication2 EOF
            {
             newCompositeNode(grammarAccess.getMultiplication2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21481);
            iv_ruleMultiplication2=ruleMultiplication2();

            state._fsp--;

             current =iv_ruleMultiplication2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication21491); 

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
    // $ANTLR end "entryRuleMultiplication2"


    // $ANTLR start "ruleMultiplication2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:689:1: ruleMultiplication2 returns [EObject current=null] : (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final EObject ruleMultiplication2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:692:28: ( (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:693:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:693:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:694:5: this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplication2Access().getPrim2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21538);
            this_Prim2_0=rulePrim2();

            state._fsp--;

             
                    current = this_Prim2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:702:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:702:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:702:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:703:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiplication21559); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultiplication2Access().getAsteriskKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:712:1: ( (lv_right_3_0= rulePrim2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:713:1: (lv_right_3_0= rulePrim2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:713:1: (lv_right_3_0= rulePrim2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:714:3: lv_right_3_0= rulePrim2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21580);
            	    lv_right_3_0=rulePrim2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplication2Rule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Prim2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication2"


    // $ANTLR start "entryRulePrim2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:738:1: entryRulePrim2 returns [EObject current=null] : iv_rulePrim2= rulePrim2 EOF ;
    public final EObject entryRulePrim2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:739:2: (iv_rulePrim2= rulePrim2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:740:2: iv_rulePrim2= rulePrim2 EOF
            {
             newCompositeNode(grammarAccess.getPrim2Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_entryRulePrim21618);
            iv_rulePrim2=rulePrim2();

            state._fsp--;

             current =iv_rulePrim2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim21628); 

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
    // $ANTLR end "entryRulePrim2"


    // $ANTLR start "rulePrim2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:747:1: rulePrim2 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) ;
    public final EObject rulePrim2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition2_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:750:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:752:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim2Access().getVal2Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:757:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:758:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:758:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:759:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim21680); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getPrim2Access().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrim2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:776:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:776:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:776:8: otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim21705); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim2Access().getAddition2ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_rulePrim21727);
                    this_Addition2_3=ruleAddition2();

                    state._fsp--;

                     
                            current = this_Addition2_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim21738); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrim2Access().getRightParenthesisKeyword_1_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim2"


    // $ANTLR start "entryRuleDatatypeID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:801:1: entryRuleDatatypeID returns [String current=null] : iv_ruleDatatypeID= ruleDatatypeID EOF ;
    public final String entryRuleDatatypeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:802:2: (iv_ruleDatatypeID= ruleDatatypeID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:803:2: iv_ruleDatatypeID= ruleDatatypeID EOF
            {
             newCompositeNode(grammarAccess.getDatatypeIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1776);
            iv_ruleDatatypeID=ruleDatatypeID();

            state._fsp--;

             current =iv_ruleDatatypeID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeID1787); 

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
    // $ANTLR end "entryRuleDatatypeID"


    // $ANTLR start "ruleDatatypeID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:810:1: ruleDatatypeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDatatypeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:813:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:814:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatypeID1826); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDatatypeIDAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeID"


    // $ANTLR start "entryRuleSingleCrossReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:829:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:830:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:831:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference1870);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference1880); 

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
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:838:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
    public final EObject ruleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:841:28: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:842:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:842:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:842:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSingleCrossReference1917); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:1: ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:847:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:847:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:848:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:848:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_TERMINALID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:849:3: lv_name_1_1= RULE_TERMINALID
                    {
                    lv_name_1_1=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1936); 

                    			newLeafNode(lv_name_1_1, grammarAccess.getSingleCrossReferenceAccess().getNameTerminalIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_1, 
                            		"TerminalID");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:864:8: lv_name_1_2= RULE_ID
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference1956); 

                    			newLeafNode(lv_name_1_2, grammarAccess.getSingleCrossReferenceAccess().getNameIDTerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_2, 
                            		"ID");
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:882:2: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:882:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleCrossReference1977); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getKw1Keyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:886:1: ( (otherlv_3= RULE_TERMINALID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:887:1: (otherlv_3= RULE_TERMINALID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:887:1: (otherlv_3= RULE_TERMINALID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:888:3: otherlv_3= RULE_TERMINALID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1997); 

                    		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:899:4: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:899:6: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleCrossReference2012); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleCrossReferenceAccess().getKw2Keyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:903:1: ( ( ruleDatatypeID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:904:1: ( ruleDatatypeID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:904:1: ( ruleDatatypeID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:905:3: ruleDatatypeID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2035);
                    ruleDatatypeID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:918:4: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:918:6: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleCrossReference2050); 

                        	newLeafNode(otherlv_6, grammarAccess.getSingleCrossReferenceAccess().getKw3Keyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:922:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:923:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:923:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:924:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2070); 

                    		newLeafNode(otherlv_7, grammarAccess.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:935:4: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:935:6: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleCrossReference2085); 

                        	newLeafNode(otherlv_8, grammarAccess.getSingleCrossReferenceAccess().getKw4Keyword_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:939:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:940:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:940:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:941:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2105); 

                    		newLeafNode(otherlv_9, grammarAccess.getSingleCrossReferenceAccess().getRef4SingleCrossReferenceCrossReference_5_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleBooleanAlternative"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:960:1: entryRuleBooleanAlternative returns [EObject current=null] : iv_ruleBooleanAlternative= ruleBooleanAlternative EOF ;
    public final EObject entryRuleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:961:2: (iv_ruleBooleanAlternative= ruleBooleanAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:962:2: iv_ruleBooleanAlternative= ruleBooleanAlternative EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2143);
            iv_ruleBooleanAlternative=ruleBooleanAlternative();

            state._fsp--;

             current =iv_ruleBooleanAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternative2153); 

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
    // $ANTLR end "entryRuleBooleanAlternative"


    // $ANTLR start "ruleBooleanAlternative"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:969:1: ruleBooleanAlternative returns [EObject current=null] : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final EObject ruleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bool_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:972:28: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:973:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:973:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:973:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBooleanAlternative2190); 

                	newLeafNode(otherlv_0, grammarAccess.getBooleanAlternativeAccess().getNumberSignDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:977:1: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:978:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:978:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:979:3: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2211);
            lv_bool_1_0=ruleBooleanAlternativeLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBooleanAlternativeRule());
            	        }
                   		set(
                   			current, 
                   			"bool",
                    		lv_bool_1_0, 
                    		"BooleanAlternativeLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAlternative"


    // $ANTLR start "entryRuleBooleanAlternativeLiteral"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1003:1: entryRuleBooleanAlternativeLiteral returns [EObject current=null] : iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF ;
    public final EObject entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternativeLiteral = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1004:2: (iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1005:2: iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2247);
            iv_ruleBooleanAlternativeLiteral=ruleBooleanAlternativeLiteral();

            state._fsp--;

             current =iv_ruleBooleanAlternativeLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2257); 

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
    // $ANTLR end "entryRuleBooleanAlternativeLiteral"


    // $ANTLR start "ruleBooleanAlternativeLiteral"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1012:1: ruleBooleanAlternativeLiteral returns [EObject current=null] : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final EObject ruleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1015:28: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:2: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1017:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanAlternativeLiteralAccess().getBooleanAlternativeLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1022:2: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1022:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBooleanAlternativeLiteral2304); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanAlternativeLiteralAccess().getKw1Keyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1027:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1027:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1028:1: (lv_isTrue_2_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1028:1: (lv_isTrue_2_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1029:3: lv_isTrue_2_0= 'kw2'
                    {
                    lv_isTrue_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanAlternativeLiteral2328); 

                            newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanAlternativeLiteralAccess().getIsTrueKw2Keyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanAlternativeLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "isTrue", true, "kw2");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAlternativeLiteral"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_ruleModel185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_ruleModel212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryKeywords312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleMandatoryKeywords349 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords366 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMandatoryKeywords383 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords400 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMandatoryKeywords417 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryKeywords429 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords446 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryKeywords463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_entryRuleExp0499 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp0509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleExp0546 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAddition0_in_ruleExp0568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition0_in_entryRuleAddition0603 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition0613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0660 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition0681 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0702 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim0_in_entryRulePrim0740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim0750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim0801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_entryRuleExp1842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp1852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleExp1889 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_ruleExp1911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition1_in_entryRuleAddition1946 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11003 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition11024 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11045 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim1_in_entryRulePrim11083 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim11093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim11145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim11170 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_rulePrim11192 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim11203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_entryRuleExp21240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp21250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleExp21287 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_ruleExp21309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition2_in_entryRuleAddition21344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition21354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21401 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition21422 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21443 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication21491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21538 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleMultiplication21559 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21580 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rulePrim2_in_entryRulePrim21618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim21628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim21680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim21705 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_rulePrim21727 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim21738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1776 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeID1787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatypeID1826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference1870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference1880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleSingleCrossReference1917 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1936 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference1956 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_13_in_ruleSingleCrossReference1977 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1997 = new BitSet(new long[]{0x000000000001C002L});
        public static final BitSet FOLLOW_14_in_ruleSingleCrossReference2012 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2035 = new BitSet(new long[]{0x0000000000018002L});
        public static final BitSet FOLLOW_15_in_ruleSingleCrossReference2050 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2070 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSingleCrossReference2085 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2143 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternative2153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBooleanAlternative2190 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleBooleanAlternativeLiteral2304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleBooleanAlternativeLiteral2328 = new BitSet(new long[]{0x0000000000000002L});
    }


}