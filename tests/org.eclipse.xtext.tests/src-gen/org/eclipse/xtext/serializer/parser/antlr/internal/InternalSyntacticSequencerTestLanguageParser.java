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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINALID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'", "'#7'", "'matched'", "'#8'", "'#9'", "'#10'", "'#11'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
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
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) ) ;
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

        EObject lv_x9_8_0 = null;

        EObject lv_x10_9_0 = null;

        EObject lv_x11_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:79:28: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) )
            int alt1=11;
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
            case 28:
                {
                alt1=8;
                }
                break;
            case 29:
                {
                alt1=9;
                }
                break;
            case 30:
                {
                alt1=10;
                }
                break;
            case 31:
                {
                alt1=11;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:215:3: lv_x8_7_0= ruleOptionalSingleTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX8OptionalSingleTransitionParserRuleCall_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_ruleModel320);
                    lv_x8_7_0=ruleOptionalSingleTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x8",
                            		lv_x8_7_0, 
                            		"OptionalSingleTransition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:232:6: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:232:6: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:233:1: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:233:1: (lv_x9_8_0= ruleOptionalManyTransition )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:234:3: lv_x9_8_0= ruleOptionalManyTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX9OptionalManyTransitionParserRuleCall_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_ruleModel347);
                    lv_x9_8_0=ruleOptionalManyTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x9",
                            		lv_x9_8_0, 
                            		"OptionalManyTransition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:251:6: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:251:6: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:252:1: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:252:1: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:253:3: lv_x10_9_0= ruleMandatoryManyTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX10MandatoryManyTransitionParserRuleCall_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_ruleModel374);
                    lv_x10_9_0=ruleMandatoryManyTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x10",
                            		lv_x10_9_0, 
                            		"MandatoryManyTransition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:270:6: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:270:6: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:271:1: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:271:1: (lv_x11_10_0= ruleAlternativeTransition )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:272:3: lv_x11_10_0= ruleAlternativeTransition
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX11AlternativeTransitionParserRuleCall_10_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_ruleModel401);
                    lv_x11_10_0=ruleAlternativeTransition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x11",
                            		lv_x11_10_0, 
                            		"AlternativeTransition");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:296:1: entryRuleMandatoryKeywords returns [EObject current=null] : iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF ;
    public final EObject entryRuleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryKeywords = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:297:2: (iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:298:2: iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF
            {
             newCompositeNode(grammarAccess.getMandatoryKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords437);
            iv_ruleMandatoryKeywords=ruleMandatoryKeywords();

            state._fsp--;

             current =iv_ruleMandatoryKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryKeywords447); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:305:1: ruleMandatoryKeywords returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:308:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:309:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMandatoryKeywords484); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryKeywordsAccess().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:313:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:314:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:314:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:315:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords501); 

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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMandatoryKeywords518); 

                	newLeafNode(otherlv_2, grammarAccess.getMandatoryKeywordsAccess().getKw1Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:335:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:336:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:336:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:337:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords535); 

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

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMandatoryKeywords552); 

                	newLeafNode(otherlv_4, grammarAccess.getMandatoryKeywordsAccess().getKw2Keyword_4());
                
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryKeywords564); 

                	newLeafNode(otherlv_5, grammarAccess.getMandatoryKeywordsAccess().getKw3Keyword_5());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:361:1: ( (lv_val3_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:362:1: (lv_val3_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:362:1: (lv_val3_6_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:363:3: lv_val3_6_0= RULE_ID
            {
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords581); 

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

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryKeywords598); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:391:1: entryRuleExp0 returns [EObject current=null] : iv_ruleExp0= ruleExp0 EOF ;
    public final EObject entryRuleExp0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:392:2: (iv_ruleExp0= ruleExp0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:393:2: iv_ruleExp0= ruleExp0 EOF
            {
             newCompositeNode(grammarAccess.getExp0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp0_in_entryRuleExp0634);
            iv_ruleExp0=ruleExp0();

            state._fsp--;

             current =iv_ruleExp0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp0644); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:400:1: ruleExp0 returns [EObject current=null] : (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) ;
    public final EObject ruleExp0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition0_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:403:28: ( (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:404:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:404:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:404:3: otherlv_0= '#2' this_Addition0_1= ruleAddition0
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleExp0681); 

                	newLeafNode(otherlv_0, grammarAccess.getExp0Access().getNumberSignDigitTwoKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp0Access().getAddition0ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_ruleExp0703);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:425:1: entryRuleAddition0 returns [EObject current=null] : iv_ruleAddition0= ruleAddition0 EOF ;
    public final EObject entryRuleAddition0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:426:2: (iv_ruleAddition0= ruleAddition0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:427:2: iv_ruleAddition0= ruleAddition0 EOF
            {
             newCompositeNode(grammarAccess.getAddition0Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_entryRuleAddition0738);
            iv_ruleAddition0=ruleAddition0();

            state._fsp--;

             current =iv_ruleAddition0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition0748); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:434:1: ruleAddition0 returns [EObject current=null] : (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final EObject ruleAddition0() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim0_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:437:28: ( (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:438:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:438:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:439:5: this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition0Access().getPrim0ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0795);
            this_Prim0_0=rulePrim0();

            state._fsp--;

             
                    current = this_Prim0_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:447:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:447:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:447:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:448:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition0816); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition0Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:457:1: ( (lv_right_3_0= rulePrim0 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:458:1: (lv_right_3_0= rulePrim0 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:458:1: (lv_right_3_0= rulePrim0 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:459:3: lv_right_3_0= rulePrim0
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0837);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:483:1: entryRulePrim0 returns [EObject current=null] : iv_rulePrim0= rulePrim0 EOF ;
    public final EObject entryRulePrim0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim0 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:484:2: (iv_rulePrim0= rulePrim0 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:485:2: iv_rulePrim0= rulePrim0 EOF
            {
             newCompositeNode(grammarAccess.getPrim0Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_entryRulePrim0875);
            iv_rulePrim0=rulePrim0();

            state._fsp--;

             current =iv_rulePrim0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim0885); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:492:1: rulePrim0 returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePrim0() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:495:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:496:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:496:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:496:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:496:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:497:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrim0Access().getVal0Action_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:502:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:503:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:503:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:504:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim0936); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:528:1: entryRuleExp1 returns [EObject current=null] : iv_ruleExp1= ruleExp1 EOF ;
    public final EObject entryRuleExp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:529:2: (iv_ruleExp1= ruleExp1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:530:2: iv_ruleExp1= ruleExp1 EOF
            {
             newCompositeNode(grammarAccess.getExp1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp1_in_entryRuleExp1977);
            iv_ruleExp1=ruleExp1();

            state._fsp--;

             current =iv_ruleExp1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp1987); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:537:1: ruleExp1 returns [EObject current=null] : (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) ;
    public final EObject ruleExp1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition1_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:540:28: ( (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:541:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:541:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:541:3: otherlv_0= '#3' this_Addition1_1= ruleAddition1
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleExp11024); 

                	newLeafNode(otherlv_0, grammarAccess.getExp1Access().getNumberSignDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp1Access().getAddition1ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_ruleExp11046);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:562:1: entryRuleAddition1 returns [EObject current=null] : iv_ruleAddition1= ruleAddition1 EOF ;
    public final EObject entryRuleAddition1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:563:2: (iv_ruleAddition1= ruleAddition1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:564:2: iv_ruleAddition1= ruleAddition1 EOF
            {
             newCompositeNode(grammarAccess.getAddition1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_entryRuleAddition11081);
            iv_ruleAddition1=ruleAddition1();

            state._fsp--;

             current =iv_ruleAddition1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition11091); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:571:1: ruleAddition1 returns [EObject current=null] : (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final EObject ruleAddition1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim1_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:574:28: ( (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:575:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:575:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:576:5: this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition1Access().getPrim1ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11138);
            this_Prim1_0=rulePrim1();

            state._fsp--;

             
                    current = this_Prim1_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:584:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:584:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:584:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:585:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition11159); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition1Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:594:1: ( (lv_right_3_0= rulePrim1 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:595:1: (lv_right_3_0= rulePrim1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:595:1: (lv_right_3_0= rulePrim1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:596:3: lv_right_3_0= rulePrim1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11180);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:620:1: entryRulePrim1 returns [EObject current=null] : iv_rulePrim1= rulePrim1 EOF ;
    public final EObject entryRulePrim1() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:621:2: (iv_rulePrim1= rulePrim1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:622:2: iv_rulePrim1= rulePrim1 EOF
            {
             newCompositeNode(grammarAccess.getPrim1Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_entryRulePrim11218);
            iv_rulePrim1=rulePrim1();

            state._fsp--;

             current =iv_rulePrim1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim11228); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:629:1: rulePrim1 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) ;
    public final EObject rulePrim1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition1_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:632:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:633:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:634:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim1Access().getVal1Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:639:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:640:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:640:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:641:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim11280); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:658:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:658:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:658:8: otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim11305); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim1Access().getAddition1ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_rulePrim11327);
                    this_Addition1_3=ruleAddition1();

                    state._fsp--;

                     
                            current = this_Addition1_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim11338); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:683:1: entryRuleExp2 returns [EObject current=null] : iv_ruleExp2= ruleExp2 EOF ;
    public final EObject entryRuleExp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:684:2: (iv_ruleExp2= ruleExp2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:685:2: iv_ruleExp2= ruleExp2 EOF
            {
             newCompositeNode(grammarAccess.getExp2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp2_in_entryRuleExp21375);
            iv_ruleExp2=ruleExp2();

            state._fsp--;

             current =iv_ruleExp2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp21385); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:692:1: ruleExp2 returns [EObject current=null] : (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) ;
    public final EObject ruleExp2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:695:28: ( (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:696:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:696:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:696:3: otherlv_0= '#4' this_Addition2_1= ruleAddition2
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleExp21422); 

                	newLeafNode(otherlv_0, grammarAccess.getExp2Access().getNumberSignDigitFourKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExp2Access().getAddition2ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_ruleExp21444);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:717:1: entryRuleAddition2 returns [EObject current=null] : iv_ruleAddition2= ruleAddition2 EOF ;
    public final EObject entryRuleAddition2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:718:2: (iv_ruleAddition2= ruleAddition2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:719:2: iv_ruleAddition2= ruleAddition2 EOF
            {
             newCompositeNode(grammarAccess.getAddition2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_entryRuleAddition21479);
            iv_ruleAddition2=ruleAddition2();

            state._fsp--;

             current =iv_ruleAddition2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition21489); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:726:1: ruleAddition2 returns [EObject current=null] : (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final EObject ruleAddition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Multiplication2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:729:28: ( (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:730:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:730:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:731:5: this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddition2Access().getMultiplication2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21536);
            this_Multiplication2_0=ruleMultiplication2();

            state._fsp--;

             
                    current = this_Multiplication2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:739:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:739:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:739:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:740:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAddition21557); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddition2Access().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:749:1: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:750:1: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:750:1: (lv_right_3_0= ruleMultiplication2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:751:3: lv_right_3_0= ruleMultiplication2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21578);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:775:1: entryRuleMultiplication2 returns [EObject current=null] : iv_ruleMultiplication2= ruleMultiplication2 EOF ;
    public final EObject entryRuleMultiplication2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:776:2: (iv_ruleMultiplication2= ruleMultiplication2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:777:2: iv_ruleMultiplication2= ruleMultiplication2 EOF
            {
             newCompositeNode(grammarAccess.getMultiplication2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21616);
            iv_ruleMultiplication2=ruleMultiplication2();

            state._fsp--;

             current =iv_ruleMultiplication2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication21626); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:784:1: ruleMultiplication2 returns [EObject current=null] : (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final EObject ruleMultiplication2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:787:28: ( (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:788:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:788:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:789:5: this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplication2Access().getPrim2ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21673);
            this_Prim2_0=rulePrim2();

            state._fsp--;

             
                    current = this_Prim2_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:797:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:797:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:797:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:798:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiplication21694); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultiplication2Access().getAsteriskKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:807:1: ( (lv_right_3_0= rulePrim2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:808:1: (lv_right_3_0= rulePrim2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:808:1: (lv_right_3_0= rulePrim2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:809:3: lv_right_3_0= rulePrim2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21715);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:833:1: entryRulePrim2 returns [EObject current=null] : iv_rulePrim2= rulePrim2 EOF ;
    public final EObject entryRulePrim2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:834:2: (iv_rulePrim2= rulePrim2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:835:2: iv_rulePrim2= rulePrim2 EOF
            {
             newCompositeNode(grammarAccess.getPrim2Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_entryRulePrim21753);
            iv_rulePrim2=rulePrim2();

            state._fsp--;

             current =iv_rulePrim2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim21763); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:842:1: rulePrim2 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) ;
    public final EObject rulePrim2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition2_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:845:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:846:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:847:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrim2Access().getVal2Action_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:852:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:853:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:853:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:854:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim21815); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:871:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:871:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:871:8: otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrim21840); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrim2Access().getAddition2ParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_rulePrim21862);
                    this_Addition2_3=ruleAddition2();

                    state._fsp--;

                     
                            current = this_Addition2_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim21873); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:896:1: entryRuleDatatypeID returns [String current=null] : iv_ruleDatatypeID= ruleDatatypeID EOF ;
    public final String entryRuleDatatypeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:897:2: (iv_ruleDatatypeID= ruleDatatypeID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:898:2: iv_ruleDatatypeID= ruleDatatypeID EOF
            {
             newCompositeNode(grammarAccess.getDatatypeIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1911);
            iv_ruleDatatypeID=ruleDatatypeID();

            state._fsp--;

             current =iv_ruleDatatypeID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeID1922); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:905:1: ruleDatatypeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDatatypeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:908:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:909:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatypeID1961); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:924:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:925:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:926:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2005);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference2015); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:933:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:936:28: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:937:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:937:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:937:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSingleCrossReference2052); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:941:1: ( ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:942:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:942:1: ( (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:943:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:943:1: (lv_name_1_1= RULE_TERMINALID | lv_name_1_2= RULE_ID )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:944:3: lv_name_1_1= RULE_TERMINALID
                    {
                    lv_name_1_1=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2071); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:959:8: lv_name_1_2= RULE_ID
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2091); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:977:2: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:977:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINALID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleCrossReference2112); 

                        	newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getKw1Keyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:981:1: ( (otherlv_3= RULE_TERMINALID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:982:1: (otherlv_3= RULE_TERMINALID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:982:1: (otherlv_3= RULE_TERMINALID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:983:3: otherlv_3= RULE_TERMINALID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_TERMINALID,FollowSets000.FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2132); 

                    		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:994:4: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:994:6: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleCrossReference2147); 

                        	newLeafNode(otherlv_4, grammarAccess.getSingleCrossReferenceAccess().getKw2Keyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:998:1: ( ( ruleDatatypeID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:999:1: ( ruleDatatypeID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:999:1: ( ruleDatatypeID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1000:3: ruleDatatypeID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2170);
                    ruleDatatypeID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1013:4: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1013:6: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleCrossReference2185); 

                        	newLeafNode(otherlv_6, grammarAccess.getSingleCrossReferenceAccess().getKw3Keyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1017:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1018:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1018:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1019:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2205); 

                    		newLeafNode(otherlv_7, grammarAccess.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1030:4: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1030:6: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleCrossReference2220); 

                        	newLeafNode(otherlv_8, grammarAccess.getSingleCrossReferenceAccess().getKw4Keyword_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1034:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1035:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1035:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1036:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2240); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1055:1: entryRuleBooleanAlternative returns [EObject current=null] : iv_ruleBooleanAlternative= ruleBooleanAlternative EOF ;
    public final EObject entryRuleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1056:2: (iv_ruleBooleanAlternative= ruleBooleanAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1057:2: iv_ruleBooleanAlternative= ruleBooleanAlternative EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2278);
            iv_ruleBooleanAlternative=ruleBooleanAlternative();

            state._fsp--;

             current =iv_ruleBooleanAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternative2288); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1064:1: ruleBooleanAlternative returns [EObject current=null] : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final EObject ruleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bool_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1067:28: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1068:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1068:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1068:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBooleanAlternative2325); 

                	newLeafNode(otherlv_0, grammarAccess.getBooleanAlternativeAccess().getNumberSignDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1072:1: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1073:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1073:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1074:3: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2346);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1098:1: entryRuleBooleanAlternativeLiteral returns [EObject current=null] : iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF ;
    public final EObject entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternativeLiteral = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1099:2: (iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1100:2: iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanAlternativeLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2382);
            iv_ruleBooleanAlternativeLiteral=ruleBooleanAlternativeLiteral();

            state._fsp--;

             current =iv_ruleBooleanAlternativeLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2392); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1107:1: ruleBooleanAlternativeLiteral returns [EObject current=null] : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final EObject ruleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1110:28: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1111:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1111:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1111:2: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1111:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1112:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanAlternativeLiteralAccess().getBooleanAlternativeLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1117:2: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1117:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBooleanAlternativeLiteral2439); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanAlternativeLiteralAccess().getKw1Keyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1122:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1122:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1123:1: (lv_isTrue_2_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1123:1: (lv_isTrue_2_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1124:3: lv_isTrue_2_0= 'kw2'
                    {
                    lv_isTrue_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanAlternativeLiteral2463); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1145:1: entryRuleUnassignedDatatype returns [EObject current=null] : iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF ;
    public final EObject entryRuleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1146:2: (iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1147:2: iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF
            {
             newCompositeNode(grammarAccess.getUnassignedDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2513);
            iv_ruleUnassignedDatatype=ruleUnassignedDatatype();

            state._fsp--;

             current =iv_ruleUnassignedDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedDatatype2523); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1154:1: ruleUnassignedDatatype returns [EObject current=null] : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final EObject ruleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1157:28: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1158:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1158:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1158:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedDatatype2560); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedDatatypeAccess().getNumberSignDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1162:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1163:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1163:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1164:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedDatatype2577); 

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

             
                    newCompositeNode(grammarAccess.getUnassignedDatatypeAccess().getKW1ParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleUnassignedDatatype2598);
            ruleKW1();

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


    // $ANTLR start "entryRuleKW1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1196:1: entryRuleKW1 returns [String current=null] : iv_ruleKW1= ruleKW1 EOF ;
    public final String entryRuleKW1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKW1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1197:2: (iv_ruleKW1= ruleKW1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1198:2: iv_ruleKW1= ruleKW1 EOF
            {
             newCompositeNode(grammarAccess.getKW1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_entryRuleKW12634);
            iv_ruleKW1=ruleKW1();

            state._fsp--;

             current =iv_ruleKW1.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKW12645); 

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
    // $ANTLR end "entryRuleKW1"


    // $ANTLR start "ruleKW1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1205:1: ruleKW1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleKW1() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1208:28: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1209:1: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1209:1: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            else if ( (LA15_0==27) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1210:2: kw= 'kw1'
                    {
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleKW12683); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getKW1Access().getKw1Keyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1216:6: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1216:6: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1217:2: kw= 'matched' (this_INT_2= RULE_INT )?
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleKW12703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getKW1Access().getMatchedKeyword_1_0()); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1222:1: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1222:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleKW12719); 

                            		current.merge(this_INT_2);
                                
                             
                                newLeafNode(this_INT_2, grammarAccess.getKW1Access().getINTTerminalRuleCall_1_1()); 
                                

                            }
                            break;

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
    // $ANTLR end "ruleKW1"


    // $ANTLR start "entryRuleOptionalSingleTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1237:1: entryRuleOptionalSingleTransition returns [EObject current=null] : iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF ;
    public final EObject entryRuleOptionalSingleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalSingleTransition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1238:2: (iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1239:2: iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF
            {
             newCompositeNode(grammarAccess.getOptionalSingleTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2767);
            iv_ruleOptionalSingleTransition=ruleOptionalSingleTransition();

            state._fsp--;

             current =iv_ruleOptionalSingleTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalSingleTransition2777); 

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
    // $ANTLR end "entryRuleOptionalSingleTransition"


    // $ANTLR start "ruleOptionalSingleTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1246:1: ruleOptionalSingleTransition returns [EObject current=null] : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalSingleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1249:28: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1250:1: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1250:1: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1250:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOptionalSingleTransition2814); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalSingleTransitionAccess().getNumberSignDigitEightKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1254:1: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13||LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1255:5: ruleKW1
                    {
                     
                            newCompositeNode(grammarAccess.getOptionalSingleTransitionAccess().getKW1ParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2831);
                    ruleKW1();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1262:3: ( (lv_val_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1263:1: (lv_val_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1263:1: (lv_val_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1264:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalSingleTransition2849); 

            			newLeafNode(lv_val_2_0, grammarAccess.getOptionalSingleTransitionAccess().getValIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalSingleTransitionRule());
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
    // $ANTLR end "ruleOptionalSingleTransition"


    // $ANTLR start "entryRuleOptionalManyTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1288:1: entryRuleOptionalManyTransition returns [EObject current=null] : iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF ;
    public final EObject entryRuleOptionalManyTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalManyTransition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1289:2: (iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1290:2: iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF
            {
             newCompositeNode(grammarAccess.getOptionalManyTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition2890);
            iv_ruleOptionalManyTransition=ruleOptionalManyTransition();

            state._fsp--;

             current =iv_ruleOptionalManyTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalManyTransition2900); 

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
    // $ANTLR end "entryRuleOptionalManyTransition"


    // $ANTLR start "ruleOptionalManyTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1297:1: ruleOptionalManyTransition returns [EObject current=null] : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalManyTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1300:28: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1301:1: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1301:1: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1301:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleOptionalManyTransition2937); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalManyTransitionAccess().getNumberSignDigitNineKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1305:1: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==13||LA17_0==27) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1306:5: ruleKW1
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionalManyTransitionAccess().getKW1ParserRuleCall_1()); 
            	        
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalManyTransition2954);
            	    ruleKW1();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1313:3: ( (lv_val_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1314:1: (lv_val_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1314:1: (lv_val_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1315:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalManyTransition2972); 

            			newLeafNode(lv_val_2_0, grammarAccess.getOptionalManyTransitionAccess().getValIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalManyTransitionRule());
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
    // $ANTLR end "ruleOptionalManyTransition"


    // $ANTLR start "entryRuleMandatoryManyTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1339:1: entryRuleMandatoryManyTransition returns [EObject current=null] : iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF ;
    public final EObject entryRuleMandatoryManyTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryManyTransition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1340:2: (iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1341:2: iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF
            {
             newCompositeNode(grammarAccess.getMandatoryManyTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3013);
            iv_ruleMandatoryManyTransition=ruleMandatoryManyTransition();

            state._fsp--;

             current =iv_ruleMandatoryManyTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryManyTransition3023); 

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
    // $ANTLR end "entryRuleMandatoryManyTransition"


    // $ANTLR start "ruleMandatoryManyTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1348:1: ruleMandatoryManyTransition returns [EObject current=null] : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleMandatoryManyTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1351:28: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1352:1: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1352:1: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1352:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleMandatoryManyTransition3060); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryManyTransitionAccess().getNumberSignDigitOneDigitZeroKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1356:1: ( ruleKW1 )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==13||LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1357:5: ruleKW1
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMandatoryManyTransitionAccess().getKW1ParserRuleCall_1()); 
            	        
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3077);
            	    ruleKW1();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1364:3: ( (lv_val_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1365:1: (lv_val_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1365:1: (lv_val_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1366:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3095); 

            			newLeafNode(lv_val_2_0, grammarAccess.getMandatoryManyTransitionAccess().getValIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMandatoryManyTransitionRule());
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
    // $ANTLR end "ruleMandatoryManyTransition"


    // $ANTLR start "entryRuleAlternativeTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1390:1: entryRuleAlternativeTransition returns [EObject current=null] : iv_ruleAlternativeTransition= ruleAlternativeTransition EOF ;
    public final EObject entryRuleAlternativeTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeTransition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1391:2: (iv_ruleAlternativeTransition= ruleAlternativeTransition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1392:2: iv_ruleAlternativeTransition= ruleAlternativeTransition EOF
            {
             newCompositeNode(grammarAccess.getAlternativeTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3136);
            iv_ruleAlternativeTransition=ruleAlternativeTransition();

            state._fsp--;

             current =iv_ruleAlternativeTransition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeTransition3146); 

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
    // $ANTLR end "entryRuleAlternativeTransition"


    // $ANTLR start "ruleAlternativeTransition"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1399:1: ruleAlternativeTransition returns [EObject current=null] : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAlternativeTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1402:28: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1403:1: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1403:1: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1403:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAlternativeTransition3183); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeTransitionAccess().getNumberSignDigitOneDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1407:1: ( ruleKW1 | otherlv_2= 'kw2' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==13||LA19_0==27) ) {
                alt19=1;
            }
            else if ( (LA19_0==14) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1408:5: ruleKW1
                    {
                     
                            newCompositeNode(grammarAccess.getAlternativeTransitionAccess().getKW1ParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleAlternativeTransition3200);
                    ruleKW1();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1416:7: otherlv_2= 'kw2'
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeTransition3217); 

                        	newLeafNode(otherlv_2, grammarAccess.getAlternativeTransitionAccess().getKw2Keyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1420:2: ( (lv_val_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1421:1: (lv_val_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1421:1: (lv_val_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSyntacticSequencerTestLanguage.g:1422:3: lv_val_3_0= RULE_ID
            {
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeTransition3235); 

            			newLeafNode(lv_val_3_0, grammarAccess.getAlternativeTransitionAccess().getValIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAlternativeTransitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_3_0, 
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
    // $ANTLR end "ruleAlternativeTransition"

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
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_ruleModel320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_ruleModel347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_ruleModel374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords437 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryKeywords447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleMandatoryKeywords484 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords501 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMandatoryKeywords518 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords535 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMandatoryKeywords552 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryKeywords564 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords581 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryKeywords598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_entryRuleExp0634 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp0644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleExp0681 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAddition0_in_ruleExp0703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition0_in_entryRuleAddition0738 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition0748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0795 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition0816 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0837 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim0_in_entryRulePrim0875 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim0885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim0936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_entryRuleExp1977 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp1987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleExp11024 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_ruleExp11046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition1_in_entryRuleAddition11081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition11091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11138 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition11159 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11180 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrim1_in_entryRulePrim11218 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim11228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim11280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim11305 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition1_in_rulePrim11327 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim11338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_entryRuleExp21375 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp21385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleExp21422 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_ruleExp21444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition2_in_entryRuleAddition21479 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition21489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21536 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleAddition21557 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21578 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21616 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication21626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21673 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleMultiplication21694 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21715 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rulePrim2_in_entryRulePrim21753 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim21763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim21815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrim21840 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleAddition2_in_rulePrim21862 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_rulePrim21873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeID1922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatypeID1961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2005 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference2015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleSingleCrossReference2052 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2071 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2091 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_13_in_ruleSingleCrossReference2112 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_TERMINALID_in_ruleSingleCrossReference2132 = new BitSet(new long[]{0x000000000001C002L});
        public static final BitSet FOLLOW_14_in_ruleSingleCrossReference2147 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2170 = new BitSet(new long[]{0x0000000000018002L});
        public static final BitSet FOLLOW_15_in_ruleSingleCrossReference2185 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2205 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSingleCrossReference2220 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternative2288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBooleanAlternative2325 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2382 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleBooleanAlternativeLiteral2439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleBooleanAlternativeLiteral2463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2513 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedDatatype2523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedDatatype2560 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedDatatype2577 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleUnassignedDatatype2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKW1_in_entryRuleKW12634 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKW12645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleKW12683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleKW12703 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleKW12719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalSingleTransition2777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleOptionalSingleTransition2814 = new BitSet(new long[]{0x0000000008002010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2831 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalSingleTransition2849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition2890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalManyTransition2900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleOptionalManyTransition2937 = new BitSet(new long[]{0x0000000008002010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalManyTransition2954 = new BitSet(new long[]{0x0000000008002010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalManyTransition2972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryManyTransition3023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleMandatoryManyTransition3060 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3077 = new BitSet(new long[]{0x0000000008002010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3136 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeTransition3146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleAlternativeTransition3183 = new BitSet(new long[]{0x0000000008006000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleAlternativeTransition3200 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeTransition3217 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeTransition3235 = new BitSet(new long[]{0x0000000000000002L});
    }


}