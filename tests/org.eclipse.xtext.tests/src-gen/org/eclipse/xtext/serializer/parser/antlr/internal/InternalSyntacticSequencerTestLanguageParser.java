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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINALID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'", "'#7'", "'#8'"
    };
    public static final int RULE_ID=4;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_TERMINALID=5;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleAmbiguousTransition ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_x1_0_0 = null;

        EObject lv_x2_1_0 = null;

        EObject lv_x3_2_0 = null;

        EObject lv_x4_3_0 = null;

        EObject lv_x5_4_0 = null;

        EObject lv_x6_5_0 = null;

        EObject lv_x7_6_0 = null;

        EObject lv_x8_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:79:28: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleAmbiguousTransition ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleAmbiguousTransition ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleAmbiguousTransition ) ) )
            int alt1=8;
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
            case 26:
                {
                alt1=7;
                }
                break;
            case 27:
                {
                alt1=8;
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
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:194:6: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:194:6: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:195:1: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:195:1: (lv_x7_6_0= ruleUnassignedDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:196:3: lv_x7_6_0= ruleUnassignedDatatype
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX7UnassignedDatatypeParserRuleCall_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_ruleModel293);
                    lv_x7_6_0=ruleUnassignedDatatype();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x7",
                            		lv_x7_6_0, 
                            		"UnassignedDatatype");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleAmbiguousTransition ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleAmbiguousTransition ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleAmbiguousTransition )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleAmbiguousTransition )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:215:3: lv_x8_7_0= ruleAmbiguousTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX8AmbiguousTransitionParserRuleCall_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAmbiguousTransition_in_ruleModel320);
                    lv_x8_7_0=ruleAmbiguousTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x8",
                            		lv_x8_7_0, 
                            		"AmbiguousTransition");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:239:1: entryRuleMandatoryKeywords returns [EObject current=null] : iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF ;
    public final EObject entryRuleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryKeywords = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:240:2: (iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:241:2: iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF
            {
             newCompositeNode(grammarAccess.getMandatoryKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords356);
            iv_ruleMandatoryKeywords=ruleMandatoryKeywords();

            state._fsp--;

             current =iv_ruleMandatoryKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryKeywords366); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:248:1: ruleMandatoryKeywords returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:251:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:252:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:252:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:252:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMandatoryKeywords403); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryKeywordsAccess().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:256:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:257:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:257:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:258:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords420); 

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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMandatoryKeywords437); 

                	newLeafNode(otherlv_2, grammarAccess.getMandatoryKeywordsAccess().getKw1Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:278:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:279:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:279:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:280:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords454); 

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

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMandatoryKeywords471); 

                	newLeafNode(otherlv_4, grammarAccess.getMandatoryKeywordsAccess().getKw2Keyword_4());
                
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryKeywords483); 

                	newLeafNode(otherlv_5, grammarAccess.getMandatoryKeywordsAccess().getKw3Keyword_5());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:304:1: ( (lv_val3_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:305:1: (lv_val3_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:305:1: (lv_val3_6_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:306:3: lv_val3_6_0= RULE_ID
            {
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords500); 

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

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryKeywords517); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:334:1: entryRuleExp0 returns [EObject current=null] : iv_ruleExp0= ruleExp0 EOF ;
    public final EObject entryRuleExp0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:335:2: (iv_ruleExp0= ruleExp0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:336:2: iv_ruleExp0= ruleExp0 EOF
            {
             newCompositeNode(grammarAccess.getExp0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp0_in_entryRuleExp0553);
            iv_ruleExp0=ruleExp0();

            state._fsp--;

             current =iv_ruleExp0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp0563); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:343:1: ruleExp0 returns [EObject current=null] : (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) ;
    public final EObject ruleExp0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition0_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:346:28: ( (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:347:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:347:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:347:3: otherlv_0= '#2' this_Addition0_1= ruleAddition0
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleExp0600); 

                	newLeafNode(otherlv_0, grammarAccess.getExp0Access().getNumberSignDigitTwoKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp0Access().getAddition0ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_ruleExp0622);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:368:1: entryRuleAddition0 returns [EObject current=null] : iv_ruleAddition0= ruleAddition0 EOF ;
    public final EObject entryRuleAddition0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:369:2: (iv_ruleAddition0= ruleAddition0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:370:2: iv_ruleAddition0= ruleAddition0 EOF
            {
             newCompositeNode(grammarAccess.getAddition0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_entryRuleAddition0657);
            iv_ruleAddition0=ruleAddition0();

            state._fsp--;

             current =iv_ruleAddition0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition0667); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:377:1: ruleAddition0 returns [EObject current=null] : (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final EObject ruleAddition0() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim0_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:380:28: ( (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:381:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:381:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:382:5: this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition0Access().getPrim0ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0714);
            this_Prim0_0=rulePrim0();

            state._fsp--;

             
                    current = this_Prim0_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:390:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:390:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:390:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:391:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition0735); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition0Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:400:1: ( (lv_right_3_0= rulePrim0 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:1: (lv_right_3_0= rulePrim0 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:401:1: (lv_right_3_0= rulePrim0 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:402:3: lv_right_3_0= rulePrim0
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0756);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:426:1: entryRulePrim0 returns [EObject current=null] : iv_rulePrim0= rulePrim0 EOF ;
    public final EObject entryRulePrim0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:427:2: (iv_rulePrim0= rulePrim0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:428:2: iv_rulePrim0= rulePrim0 EOF
            {
             newCompositeNode(grammarAccess.getPrim0Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_entryRulePrim0794);
            iv_rulePrim0=rulePrim0();

            state._fsp--;

             current =iv_rulePrim0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim0804); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:435:1: rulePrim0 returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePrim0() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:438:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:439:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:439:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:439:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:439:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:440:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrim0Access().getVal0Action_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:445:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:446:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:446:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:447:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim0855); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:471:1: entryRuleExp1 returns [EObject current=null] : iv_ruleExp1= ruleExp1 EOF ;
    public final EObject entryRuleExp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:472:2: (iv_ruleExp1= ruleExp1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:473:2: iv_ruleExp1= ruleExp1 EOF
            {
             newCompositeNode(grammarAccess.getExp1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp1_in_entryRuleExp1896);
            iv_ruleExp1=ruleExp1();

            state._fsp--;

             current =iv_ruleExp1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp1906); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:480:1: ruleExp1 returns [EObject current=null] : (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) ;
    public final EObject ruleExp1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition1_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:483:28: ( (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:484:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:484:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:484:3: otherlv_0= '#3' this_Addition1_1= ruleAddition1
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleExp1943); 

                	newLeafNode(otherlv_0, grammarAccess.getExp1Access().getNumberSignDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp1Access().getAddition1ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_ruleExp1965);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:505:1: entryRuleAddition1 returns [EObject current=null] : iv_ruleAddition1= ruleAddition1 EOF ;
    public final EObject entryRuleAddition1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:506:2: (iv_ruleAddition1= ruleAddition1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:507:2: iv_ruleAddition1= ruleAddition1 EOF
            {
             newCompositeNode(grammarAccess.getAddition1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_entryRuleAddition11000);
            iv_ruleAddition1=ruleAddition1();

            state._fsp--;

             current =iv_ruleAddition1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition11010); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:514:1: ruleAddition1 returns [EObject current=null] : (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final EObject ruleAddition1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim1_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:517:28: ( (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:518:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:518:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:519:5: this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition1Access().getPrim1ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11057);
            this_Prim1_0=rulePrim1();

            state._fsp--;

             
                    current = this_Prim1_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:527:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:527:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:527:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:528:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition11078); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition1Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:537:1: ( (lv_right_3_0= rulePrim1 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:1: (lv_right_3_0= rulePrim1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:538:1: (lv_right_3_0= rulePrim1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:539:3: lv_right_3_0= rulePrim1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11099);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:563:1: entryRulePrim1 returns [EObject current=null] : iv_rulePrim1= rulePrim1 EOF ;
    public final EObject entryRulePrim1() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:564:2: (iv_rulePrim1= rulePrim1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:565:2: iv_rulePrim1= rulePrim1 EOF
            {
             newCompositeNode(grammarAccess.getPrim1Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_entryRulePrim11137);
            iv_rulePrim1=rulePrim1();

            state._fsp--;

             current =iv_rulePrim1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim11147); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:572:1: rulePrim1 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) ;
    public final EObject rulePrim1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition1_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:575:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:577:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim1Access().getVal1Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:582:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:583:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:583:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:584:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim11199); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:601:8: otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim11224); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim1Access().getAddition1ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_rulePrim11246);
                    this_Addition1_3=ruleAddition1();

                    state._fsp--;

                     
                            current = this_Addition1_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim11257); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:626:1: entryRuleExp2 returns [EObject current=null] : iv_ruleExp2= ruleExp2 EOF ;
    public final EObject entryRuleExp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:627:2: (iv_ruleExp2= ruleExp2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:628:2: iv_ruleExp2= ruleExp2 EOF
            {
             newCompositeNode(grammarAccess.getExp2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp2_in_entryRuleExp21294);
            iv_ruleExp2=ruleExp2();

            state._fsp--;

             current =iv_ruleExp2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp21304); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:635:1: ruleExp2 returns [EObject current=null] : (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) ;
    public final EObject ruleExp2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:638:28: ( (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:639:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:639:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:639:3: otherlv_0= '#4' this_Addition2_1= ruleAddition2
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleExp21341); 

                	newLeafNode(otherlv_0, grammarAccess.getExp2Access().getNumberSignDigitFourKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp2Access().getAddition2ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_ruleExp21363);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:660:1: entryRuleAddition2 returns [EObject current=null] : iv_ruleAddition2= ruleAddition2 EOF ;
    public final EObject entryRuleAddition2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:661:2: (iv_ruleAddition2= ruleAddition2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:662:2: iv_ruleAddition2= ruleAddition2 EOF
            {
             newCompositeNode(grammarAccess.getAddition2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_entryRuleAddition21398);
            iv_ruleAddition2=ruleAddition2();

            state._fsp--;

             current =iv_ruleAddition2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition21408); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:669:1: ruleAddition2 returns [EObject current=null] : (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final EObject ruleAddition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Multiplication2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:672:28: ( (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:673:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:673:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:674:5: this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition2Access().getMultiplication2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21455);
            this_Multiplication2_0=ruleMultiplication2();

            state._fsp--;

             
                    current = this_Multiplication2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:682:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:682:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:682:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:683:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition21476); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition2Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:692:1: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:693:1: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:693:1: (lv_right_3_0= ruleMultiplication2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:694:3: lv_right_3_0= ruleMultiplication2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21497);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:718:1: entryRuleMultiplication2 returns [EObject current=null] : iv_ruleMultiplication2= ruleMultiplication2 EOF ;
    public final EObject entryRuleMultiplication2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:719:2: (iv_ruleMultiplication2= ruleMultiplication2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:720:2: iv_ruleMultiplication2= ruleMultiplication2 EOF
            {
             newCompositeNode(grammarAccess.getMultiplication2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21535);
            iv_ruleMultiplication2=ruleMultiplication2();

            state._fsp--;

             current =iv_ruleMultiplication2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication21545); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:727:1: ruleMultiplication2 returns [EObject current=null] : (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final EObject ruleMultiplication2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:730:28: ( (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:731:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:731:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:732:5: this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplication2Access().getPrim2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21592);
            this_Prim2_0=rulePrim2();

            state._fsp--;

             
                    current = this_Prim2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:740:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:740:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:740:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:741:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiplication21613); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultiplication2Access().getAsteriskKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:750:1: ( (lv_right_3_0= rulePrim2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:1: (lv_right_3_0= rulePrim2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:1: (lv_right_3_0= rulePrim2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:752:3: lv_right_3_0= rulePrim2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21634);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:776:1: entryRulePrim2 returns [EObject current=null] : iv_rulePrim2= rulePrim2 EOF ;
    public final EObject entryRulePrim2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:777:2: (iv_rulePrim2= rulePrim2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:778:2: iv_rulePrim2= rulePrim2 EOF
            {
             newCompositeNode(grammarAccess.getPrim2Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_entryRulePrim21672);
            iv_rulePrim2=rulePrim2();

            state._fsp--;

             current =iv_rulePrim2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim21682); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:785:1: rulePrim2 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) ;
    public final EObject rulePrim2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition2_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:788:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:790:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim2Access().getVal2Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:795:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:796:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:796:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:797:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim21734); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:814:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:814:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:814:8: otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim21759); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim2Access().getAddition2ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_rulePrim21781);
                    this_Addition2_3=ruleAddition2();

                    state._fsp--;

                     
                            current = this_Addition2_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim21792); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:839:1: entryRuleDatatypeID returns [String current=null] : iv_ruleDatatypeID= ruleDatatypeID EOF ;
    public final String entryRuleDatatypeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:840:2: (iv_ruleDatatypeID= ruleDatatypeID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:841:2: iv_ruleDatatypeID= ruleDatatypeID EOF
            {
             newCompositeNode(grammarAccess.getDatatypeIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1830);
            iv_ruleDatatypeID=ruleDatatypeID();

            state._fsp--;

             current =iv_ruleDatatypeID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeID1841); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:848:1: ruleDatatypeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDatatypeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:851:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:852:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatypeID1880); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:867:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:868:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:869:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference1924);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference1934); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:876:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:879:28: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:880:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:880:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:880:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSingleCrossReference1971); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:884:1: ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:885:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:885:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:886:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:886:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:887:3: lv_name_1_1= RULE_TERMINALID
                    {
                    lv_name_1_1=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1990); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:902:8: lv_name_1_2= RULE_ID
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2010); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:920:2: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:920:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleCrossReference2031); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getKw1Keyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:924:1: ( (otherlv_3= RULE_TERMINALID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:925:1: (otherlv_3= RULE_TERMINALID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:925:1: (otherlv_3= RULE_TERMINALID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:926:3: otherlv_3= RULE_TERMINALID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2051); 

                    		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:937:4: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:937:6: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleCrossReference2066); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleCrossReferenceAccess().getKw2Keyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:941:1: ( ( ruleDatatypeID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:942:1: ( ruleDatatypeID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:942:1: ( ruleDatatypeID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:943:3: ruleDatatypeID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2089);
                    ruleDatatypeID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:956:4: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:956:6: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleCrossReference2104); 

                        	newLeafNode(otherlv_6, grammarAccess.getSingleCrossReferenceAccess().getKw3Keyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:960:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:961:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:961:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:962:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2124); 

                    		newLeafNode(otherlv_7, grammarAccess.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:973:4: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:973:6: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleCrossReference2139); 

                        	newLeafNode(otherlv_8, grammarAccess.getSingleCrossReferenceAccess().getKw4Keyword_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:977:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:978:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:978:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:979:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2159); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:998:1: entryRuleBooleanAlternative returns [EObject current=null] : iv_ruleBooleanAlternative= ruleBooleanAlternative EOF ;
    public final EObject entryRuleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:999:2: (iv_ruleBooleanAlternative= ruleBooleanAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1000:2: iv_ruleBooleanAlternative= ruleBooleanAlternative EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2197);
            iv_ruleBooleanAlternative=ruleBooleanAlternative();

            state._fsp--;

             current =iv_ruleBooleanAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternative2207); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1007:1: ruleBooleanAlternative returns [EObject current=null] : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final EObject ruleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bool_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1010:28: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1011:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1011:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1011:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBooleanAlternative2244); 

                	newLeafNode(otherlv_0, grammarAccess.getBooleanAlternativeAccess().getNumberSignDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1015:1: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1016:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1017:3: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2265);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1041:1: entryRuleBooleanAlternativeLiteral returns [EObject current=null] : iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF ;
    public final EObject entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternativeLiteral = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1042:2: (iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1043:2: iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2301);
            iv_ruleBooleanAlternativeLiteral=ruleBooleanAlternativeLiteral();

            state._fsp--;

             current =iv_ruleBooleanAlternativeLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2311); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1050:1: ruleBooleanAlternativeLiteral returns [EObject current=null] : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final EObject ruleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1053:28: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1054:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1054:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1054:2: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1054:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1055:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanAlternativeLiteralAccess().getBooleanAlternativeLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1060:2: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1060:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBooleanAlternativeLiteral2358); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanAlternativeLiteralAccess().getKw1Keyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1065:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1065:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1066:1: (lv_isTrue_2_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1066:1: (lv_isTrue_2_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1067:3: lv_isTrue_2_0= 'kw2'
                    {
                    lv_isTrue_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanAlternativeLiteral2382); 

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


    // $ANTLR start "entryRuleUnassignedDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1088:1: entryRuleUnassignedDatatype returns [EObject current=null] : iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF ;
    public final EObject entryRuleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1089:2: (iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1090:2: iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF
            {
             newCompositeNode(grammarAccess.getUnassignedDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2432);
            iv_ruleUnassignedDatatype=ruleUnassignedDatatype();

            state._fsp--;

             current =iv_ruleUnassignedDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedDatatype2442); 

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
    // $ANTLR end "entryRuleUnassignedDatatype"


    // $ANTLR start "ruleUnassignedDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1097:1: ruleUnassignedDatatype returns [EObject current=null] : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleUnassignedDatatypeRule ) ;
    public final EObject ruleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1100:28: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleUnassignedDatatypeRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1101:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleUnassignedDatatypeRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1101:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleUnassignedDatatypeRule )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1101:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleUnassignedDatatypeRule
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedDatatype2479); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedDatatypeAccess().getNumberSignDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1105:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1106:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1106:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1107:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedDatatype2496); 

            			newLeafNode(lv_val_1_0, grammarAccess.getUnassignedDatatypeAccess().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnassignedDatatypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"ID");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getUnassignedDatatypeAccess().getUnassignedDatatypeRuleParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatypeRule_in_ruleUnassignedDatatype2517);
            ruleUnassignedDatatypeRule();

            state._fsp--;

             
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
    // $ANTLR end "ruleUnassignedDatatype"


    // $ANTLR start "entryRuleUnassignedDatatypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1139:1: entryRuleUnassignedDatatypeRule returns [String current=null] : iv_ruleUnassignedDatatypeRule= ruleUnassignedDatatypeRule EOF ;
    public final String entryRuleUnassignedDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnassignedDatatypeRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1140:2: (iv_ruleUnassignedDatatypeRule= ruleUnassignedDatatypeRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1141:2: iv_ruleUnassignedDatatypeRule= ruleUnassignedDatatypeRule EOF
            {
             newCompositeNode(grammarAccess.getUnassignedDatatypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatypeRule_in_entryRuleUnassignedDatatypeRule2553);
            iv_ruleUnassignedDatatypeRule=ruleUnassignedDatatypeRule();

            state._fsp--;

             current =iv_ruleUnassignedDatatypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedDatatypeRule2564); 

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
    // $ANTLR end "entryRuleUnassignedDatatypeRule"


    // $ANTLR start "ruleUnassignedDatatypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1148:1: ruleUnassignedDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'kw1' ;
    public final AntlrDatatypeRuleToken ruleUnassignedDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1151:28: (kw= 'kw1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1153:2: kw= 'kw1'
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedDatatypeRule2601); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getUnassignedDatatypeRuleAccess().getKw1Keyword()); 
                

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
    // $ANTLR end "ruleUnassignedDatatypeRule"


    // $ANTLR start "entryRuleAmbiguousTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1166:1: entryRuleAmbiguousTransition returns [EObject current=null] : iv_ruleAmbiguousTransition= ruleAmbiguousTransition EOF ;
    public final EObject entryRuleAmbiguousTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAmbiguousTransition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1167:2: (iv_ruleAmbiguousTransition= ruleAmbiguousTransition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1168:2: iv_ruleAmbiguousTransition= ruleAmbiguousTransition EOF
            {
             newCompositeNode(grammarAccess.getAmbiguousTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAmbiguousTransition_in_entryRuleAmbiguousTransition2640);
            iv_ruleAmbiguousTransition=ruleAmbiguousTransition();

            state._fsp--;

             current =iv_ruleAmbiguousTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAmbiguousTransition2650); 

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
    // $ANTLR end "entryRuleAmbiguousTransition"


    // $ANTLR start "ruleAmbiguousTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1175:1: ruleAmbiguousTransition returns [EObject current=null] : (otherlv_0= '#8' (otherlv_1= 'kw1' )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAmbiguousTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1178:28: ( (otherlv_0= '#8' (otherlv_1= 'kw1' )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1179:1: (otherlv_0= '#8' (otherlv_1= 'kw1' )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1179:1: (otherlv_0= '#8' (otherlv_1= 'kw1' )? ( (lv_val_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1179:3: otherlv_0= '#8' (otherlv_1= 'kw1' )? ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAmbiguousTransition2687); 

                	newLeafNode(otherlv_0, grammarAccess.getAmbiguousTransitionAccess().getNumberSignDigitEightKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1183:1: (otherlv_1= 'kw1' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==13) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1183:3: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAmbiguousTransition2700); 

                        	newLeafNode(otherlv_1, grammarAccess.getAmbiguousTransitionAccess().getKw1Keyword_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1187:3: ( (lv_val_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1188:1: (lv_val_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1188:1: (lv_val_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1189:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAmbiguousTransition2719); 

            			newLeafNode(lv_val_2_0, grammarAccess.getAmbiguousTransitionAccess().getValIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAmbiguousTransitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_2_0, 
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
    // $ANTLR end "ruleAmbiguousTransition"

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
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAmbiguousTransition_in_ruleModel320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords356 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryKeywords366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleMandatoryKeywords403 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords420 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMandatoryKeywords437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords454 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMandatoryKeywords471 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryKeywords483 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords500 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryKeywords517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_entryRuleExp0553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp0563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleExp0600 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAddition0_in_ruleExp0622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition0_in_entryRuleAddition0657 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition0667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0714 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition0735 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0756 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim0_in_entryRulePrim0794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim0804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim0855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_entryRuleExp1896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp1906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleExp1943 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_ruleExp1965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition1_in_entryRuleAddition11000 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition11010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11057 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition11078 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11099 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim1_in_entryRulePrim11137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim11147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim11199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim11224 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_rulePrim11246 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim11257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_entryRuleExp21294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp21304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleExp21341 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_ruleExp21363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition2_in_entryRuleAddition21398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition21408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21455 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition21476 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21497 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication21545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21592 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleMultiplication21613 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21634 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rulePrim2_in_entryRulePrim21672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim21682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim21734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim21759 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_rulePrim21781 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim21792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1830 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeID1841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatypeID1880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference1924 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference1934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleSingleCrossReference1971 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference1990 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2010 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_13_in_ruleSingleCrossReference2031 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2051 = new BitSet(new long[]{0x000000000001C002L});
        public static final BitSet FOLLOW_14_in_ruleSingleCrossReference2066 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2089 = new BitSet(new long[]{0x0000000000018002L});
        public static final BitSet FOLLOW_15_in_ruleSingleCrossReference2104 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2124 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSingleCrossReference2139 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2197 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternative2207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBooleanAlternative2244 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleBooleanAlternativeLiteral2358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleBooleanAlternativeLiteral2382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedDatatype2442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedDatatype2479 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedDatatype2496 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleUnassignedDatatypeRule_in_ruleUnassignedDatatype2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatypeRule_in_entryRuleUnassignedDatatypeRule2553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedDatatypeRule2564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedDatatypeRule2601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAmbiguousTransition_in_entryRuleAmbiguousTransition2640 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAmbiguousTransition2650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAmbiguousTransition2687 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_13_in_ruleAmbiguousTransition2700 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAmbiguousTransition2719 = new BitSet(new long[]{0x0000000000000002L});
    }


}