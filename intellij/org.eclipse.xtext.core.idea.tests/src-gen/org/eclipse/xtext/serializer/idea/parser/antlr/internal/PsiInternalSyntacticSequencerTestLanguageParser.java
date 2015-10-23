package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalSyntacticSequencerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINAL_ID", "RULE_INT", "RULE_BOOLEAN_TERMINAL_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'", "'#7'", "'matched'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'kw5'", "'kw6'", "'kw7'", "'kw8'", "'!'", "'#14'", "'#15'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOLEAN_TERMINAL_ID=7;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int RULE_TERMINAL_ID=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public PsiInternalSyntacticSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSyntacticSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSyntacticSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSyntacticSequencerTestLanguage.g"; }



    	protected SyntacticSequencerTestLanguageGrammarAccess grammarAccess;

    	protected SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSyntacticSequencerTestLanguageParser(PsiBuilder builder, TokenStream input, SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider, SyntacticSequencerTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalSyntacticSequencerTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSyntacticSequencerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_x1_0_0 = null;

        Boolean lv_x2_1_0 = null;

        Boolean lv_x3_2_0 = null;

        Boolean lv_x4_3_0 = null;

        Boolean lv_x5_4_0 = null;

        Boolean lv_x6_5_0 = null;

        Boolean lv_x7_6_0 = null;

        Boolean lv_x8_7_0 = null;

        Boolean lv_x9_8_0 = null;

        Boolean lv_x10_9_0 = null;

        Boolean lv_x11_10_0 = null;

        Boolean lv_x12_11_0 = null;

        Boolean lv_x13_12_0 = null;

        Boolean lv_x14_13_0 = null;

        Boolean lv_x15_14_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:60:1: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) )
            int alt1=15;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case 23:
                {
                alt1=4;
                }
                break;
            case 25:
                {
                alt1=5;
                }
                break;
            case 26:
                {
                alt1=6;
                }
                break;
            case 27:
                {
                alt1=7;
                }
                break;
            case 29:
                {
                alt1=8;
                }
                break;
            case 30:
                {
                alt1=9;
                }
                break;
            case 31:
                {
                alt1=10;
                }
                break;
            case 32:
                {
                alt1=11;
                }
                break;
            case 33:
                {
                alt1=12;
                }
                break;
            case 34:
                {
                alt1=13;
                }
                break;
            case 40:
                {
                alt1=14;
                }
                break;
            case 41:
                {
                alt1=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:62:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:62:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:63:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:63:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    // PsiInternalSyntacticSequencerTestLanguage.g:64:5: lv_x1_0_0= ruleMandatoryKeywords
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x1_0_0=ruleMandatoryKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:78:3: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:78:3: ( (lv_x2_1_0= ruleExp0 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:79:4: (lv_x2_1_0= ruleExp0 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:79:4: (lv_x2_1_0= ruleExp0 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:80:5: lv_x2_1_0= ruleExp0
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X2Exp0ParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x2_1_0=ruleExp0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:94:3: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:94:3: ( (lv_x3_2_0= ruleExp1 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:95:4: (lv_x3_2_0= ruleExp1 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:95:4: (lv_x3_2_0= ruleExp1 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:96:5: lv_x3_2_0= ruleExp1
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X3Exp1ParserRuleCall_2_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x3_2_0=ruleExp1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:110:3: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:110:3: ( (lv_x4_3_0= ruleExp2 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:111:4: (lv_x4_3_0= ruleExp2 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:111:4: (lv_x4_3_0= ruleExp2 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:112:5: lv_x4_3_0= ruleExp2
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X4Exp2ParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x4_3_0=ruleExp2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:126:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:126:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:127:4: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:127:4: (lv_x5_4_0= ruleSingleCrossReference )
                    // PsiInternalSyntacticSequencerTestLanguage.g:128:5: lv_x5_4_0= ruleSingleCrossReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x5_4_0=ruleSingleCrossReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:142:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:142:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:143:4: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:143:4: (lv_x6_5_0= ruleBooleanAlternative )
                    // PsiInternalSyntacticSequencerTestLanguage.g:144:5: lv_x6_5_0= ruleBooleanAlternative
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X6BooleanAlternativeParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleBooleanAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:158:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:158:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:159:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:159:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    // PsiInternalSyntacticSequencerTestLanguage.g:160:5: lv_x7_6_0= ruleUnassignedDatatype
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleUnassignedDatatype();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:174:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:174:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:175:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:175:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:176:5: lv_x8_7_0= ruleOptionalSingleTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleOptionalSingleTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:190:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:190:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:191:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:191:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:192:5: lv_x9_8_0= ruleOptionalManyTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleOptionalManyTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:206:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:206:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:207:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:207:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:208:5: lv_x10_9_0= ruleMandatoryManyTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleMandatoryManyTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:222:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:222:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:223:4: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:223:4: (lv_x11_10_0= ruleAlternativeTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:224:5: lv_x11_10_0= ruleAlternativeTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X11AlternativeTransitionParserRuleCall_10_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleAlternativeTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:238:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:238:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:239:4: (lv_x12_11_0= ruleBooleanValues )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:239:4: (lv_x12_11_0= ruleBooleanValues )
                    // PsiInternalSyntacticSequencerTestLanguage.g:240:5: lv_x12_11_0= ruleBooleanValues
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X12BooleanValuesParserRuleCall_11_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleBooleanValues();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:254:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:254:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:255:4: (lv_x13_12_0= ruleLongAlternative )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:255:4: (lv_x13_12_0= ruleLongAlternative )
                    // PsiInternalSyntacticSequencerTestLanguage.g:256:5: lv_x13_12_0= ruleLongAlternative
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X13LongAlternativeParserRuleCall_12_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_12_0=ruleLongAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:270:3: ( (lv_x14_13_0= ruleActionOnly ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:270:3: ( (lv_x14_13_0= ruleActionOnly ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:271:4: (lv_x14_13_0= ruleActionOnly )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:271:4: (lv_x14_13_0= ruleActionOnly )
                    // PsiInternalSyntacticSequencerTestLanguage.g:272:5: lv_x14_13_0= ruleActionOnly
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X14ActionOnlyParserRuleCall_13_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_13_0=ruleActionOnly();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;
                case 15 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:286:3: ( (lv_x15_14_0= ruleFragmentCaller ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:286:3: ( (lv_x15_14_0= ruleFragmentCaller ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:287:4: (lv_x15_14_0= ruleFragmentCaller )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:287:4: (lv_x15_14_0= ruleFragmentCaller )
                    // PsiInternalSyntacticSequencerTestLanguage.g:288:5: lv_x15_14_0= ruleFragmentCaller
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X15FragmentCallerParserRuleCall_14_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x15_14_0=ruleFragmentCaller();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleMandatoryKeywords"
    // PsiInternalSyntacticSequencerTestLanguage.g:305:1: entryRuleMandatoryKeywords returns [Boolean current=false] : iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF ;
    public final Boolean entryRuleMandatoryKeywords() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMandatoryKeywords = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:305:59: (iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:306:2: iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMandatoryKeywordsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMandatoryKeywords=ruleMandatoryKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatoryKeywords; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMandatoryKeywords"


    // $ANTLR start "ruleMandatoryKeywords"
    // PsiInternalSyntacticSequencerTestLanguage.g:312:1: ruleMandatoryKeywords returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
    public final Boolean ruleMandatoryKeywords() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_val3_6_0=null;
        Token otherlv_7=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:313:1: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:314:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:314:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // PsiInternalSyntacticSequencerTestLanguage.g:315:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:322:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:323:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:323:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:324:5: lv_val1_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val1_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw1Keyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:346:3: ( (lv_val2_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:347:4: (lv_val2_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:347:4: (lv_val2_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:348:5: lv_val2_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val2_3_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw2Keyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw3Keyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:377:3: ( (lv_val3_6_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:378:4: (lv_val3_6_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:378:4: (lv_val3_6_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:379:5: lv_val3_6_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val3_6_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw4Keyword_7ElementType());
              		
            }
            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_7);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMandatoryKeywords"


    // $ANTLR start "entryRuleExp0"
    // PsiInternalSyntacticSequencerTestLanguage.g:405:1: entryRuleExp0 returns [Boolean current=false] : iv_ruleExp0= ruleExp0 EOF ;
    public final Boolean entryRuleExp0() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExp0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:405:46: (iv_ruleExp0= ruleExp0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:406:2: iv_ruleExp0= ruleExp0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp0=ruleExp0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp0; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExp0"


    // $ANTLR start "ruleExp0"
    // PsiInternalSyntacticSequencerTestLanguage.g:412:1: ruleExp0 returns [Boolean current=false] : (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) ;
    public final Boolean ruleExp0() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Addition0_1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:413:1: ( (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:414:2: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:414:2: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            // PsiInternalSyntacticSequencerTestLanguage.g:415:3: otherlv_0= '#2' this_Addition0_1= ruleAddition0
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp0_NumberSignDigitTwoKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp0_Addition0ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition0_1=ruleAddition0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition0_1;
              			doneComposite();
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp0"


    // $ANTLR start "entryRuleAddition0"
    // PsiInternalSyntacticSequencerTestLanguage.g:434:1: entryRuleAddition0 returns [Boolean current=false] : iv_ruleAddition0= ruleAddition0 EOF ;
    public final Boolean entryRuleAddition0() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAddition0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:434:51: (iv_ruleAddition0= ruleAddition0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:435:2: iv_ruleAddition0= ruleAddition0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition0=ruleAddition0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition0; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition0"


    // $ANTLR start "ruleAddition0"
    // PsiInternalSyntacticSequencerTestLanguage.g:441:1: ruleAddition0 returns [Boolean current=false] : (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final Boolean ruleAddition0() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Prim0_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:442:1: ( (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:443:2: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:443:2: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:444:3: this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition0_Prim0ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Prim0_0=rulePrim0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prim0_0;
              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:452:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:453:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:453:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:454:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition0_Add0LeftAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition0_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:467:4: ( (lv_right_3_0= rulePrim0 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:468:5: (lv_right_3_0= rulePrim0 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:468:5: (lv_right_3_0= rulePrim0 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:469:6: lv_right_3_0= rulePrim0
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition0_RightPrim0ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=rulePrim0();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition0"


    // $ANTLR start "entryRulePrim0"
    // PsiInternalSyntacticSequencerTestLanguage.g:487:1: entryRulePrim0 returns [Boolean current=false] : iv_rulePrim0= rulePrim0 EOF ;
    public final Boolean entryRulePrim0() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrim0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:487:47: (iv_rulePrim0= rulePrim0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:488:2: iv_rulePrim0= rulePrim0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim0=rulePrim0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim0; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrim0"


    // $ANTLR start "rulePrim0"
    // PsiInternalSyntacticSequencerTestLanguage.g:494:1: rulePrim0 returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean rulePrim0() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:495:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:496:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:496:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:497:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:497:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:498:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPrim0_Val0Action_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:504:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:505:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:505:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:506:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPrim0_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim0"


    // $ANTLR start "entryRuleExp1"
    // PsiInternalSyntacticSequencerTestLanguage.g:525:1: entryRuleExp1 returns [Boolean current=false] : iv_ruleExp1= ruleExp1 EOF ;
    public final Boolean entryRuleExp1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExp1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:525:46: (iv_ruleExp1= ruleExp1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:526:2: iv_ruleExp1= ruleExp1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp1=ruleExp1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExp1"


    // $ANTLR start "ruleExp1"
    // PsiInternalSyntacticSequencerTestLanguage.g:532:1: ruleExp1 returns [Boolean current=false] : (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) ;
    public final Boolean ruleExp1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Addition1_1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:533:1: ( (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:534:2: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:534:2: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            // PsiInternalSyntacticSequencerTestLanguage.g:535:3: otherlv_0= '#3' this_Addition1_1= ruleAddition1
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp1_NumberSignDigitThreeKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp1_Addition1ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition1_1=ruleAddition1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition1_1;
              			doneComposite();
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp1"


    // $ANTLR start "entryRuleAddition1"
    // PsiInternalSyntacticSequencerTestLanguage.g:554:1: entryRuleAddition1 returns [Boolean current=false] : iv_ruleAddition1= ruleAddition1 EOF ;
    public final Boolean entryRuleAddition1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAddition1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:554:51: (iv_ruleAddition1= ruleAddition1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:555:2: iv_ruleAddition1= ruleAddition1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition1=ruleAddition1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition1"


    // $ANTLR start "ruleAddition1"
    // PsiInternalSyntacticSequencerTestLanguage.g:561:1: ruleAddition1 returns [Boolean current=false] : (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final Boolean ruleAddition1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Prim1_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:562:1: ( (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:563:2: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:563:2: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:564:3: this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition1_Prim1ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Prim1_0=rulePrim1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prim1_0;
              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:572:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:573:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:573:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:574:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition1_Add1LeftAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition1_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:587:4: ( (lv_right_3_0= rulePrim1 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:588:5: (lv_right_3_0= rulePrim1 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:588:5: (lv_right_3_0= rulePrim1 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:589:6: lv_right_3_0= rulePrim1
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition1_RightPrim1ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=rulePrim1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition1"


    // $ANTLR start "entryRulePrim1"
    // PsiInternalSyntacticSequencerTestLanguage.g:607:1: entryRulePrim1 returns [Boolean current=false] : iv_rulePrim1= rulePrim1 EOF ;
    public final Boolean entryRulePrim1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrim1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:607:47: (iv_rulePrim1= rulePrim1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:608:2: iv_rulePrim1= rulePrim1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim1=rulePrim1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrim1"


    // $ANTLR start "rulePrim1"
    // PsiInternalSyntacticSequencerTestLanguage.g:614:1: rulePrim1 returns [Boolean current=false] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) ;
    public final Boolean rulePrim1() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean this_Addition1_3 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:615:1: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:616:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:616:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:617:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:617:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:618:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:618:4: ()
                    // PsiInternalSyntacticSequencerTestLanguage.g:619:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPrim1_Val1Action_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalSyntacticSequencerTestLanguage.g:625:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:626:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:626:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:627:6: lv_name_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPrim1_NameIDTerminalRuleCall_0_1_0ElementType());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_0);
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:644:3: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:644:3: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:645:4: otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim1_LeftParenthesisKeyword_1_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPrim1_Addition1ParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    this_Addition1_3=ruleAddition1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Addition1_3;
                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim1_RightParenthesisKeyword_1_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim1"


    // $ANTLR start "entryRuleExp2"
    // PsiInternalSyntacticSequencerTestLanguage.g:672:1: entryRuleExp2 returns [Boolean current=false] : iv_ruleExp2= ruleExp2 EOF ;
    public final Boolean entryRuleExp2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExp2 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:672:46: (iv_ruleExp2= ruleExp2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:673:2: iv_ruleExp2= ruleExp2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp2=ruleExp2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExp2"


    // $ANTLR start "ruleExp2"
    // PsiInternalSyntacticSequencerTestLanguage.g:679:1: ruleExp2 returns [Boolean current=false] : (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) ;
    public final Boolean ruleExp2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Addition2_1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:680:1: ( (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:681:2: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:681:2: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            // PsiInternalSyntacticSequencerTestLanguage.g:682:3: otherlv_0= '#4' this_Addition2_1= ruleAddition2
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp2_NumberSignDigitFourKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp2_Addition2ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition2_1=ruleAddition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition2_1;
              			doneComposite();
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp2"


    // $ANTLR start "entryRuleAddition2"
    // PsiInternalSyntacticSequencerTestLanguage.g:701:1: entryRuleAddition2 returns [Boolean current=false] : iv_ruleAddition2= ruleAddition2 EOF ;
    public final Boolean entryRuleAddition2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAddition2 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:701:51: (iv_ruleAddition2= ruleAddition2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:702:2: iv_ruleAddition2= ruleAddition2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition2=ruleAddition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition2"


    // $ANTLR start "ruleAddition2"
    // PsiInternalSyntacticSequencerTestLanguage.g:708:1: ruleAddition2 returns [Boolean current=false] : (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final Boolean ruleAddition2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Multiplication2_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:709:1: ( (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:710:2: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:710:2: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:711:3: this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition2_Multiplication2ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Multiplication2_0=ruleMultiplication2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication2_0;
              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:719:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:720:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:720:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:721:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition2_Add2LeftAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition2_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:734:4: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:735:5: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:735:5: (lv_right_3_0= ruleMultiplication2 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:736:6: lv_right_3_0= ruleMultiplication2
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=ruleMultiplication2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition2"


    // $ANTLR start "entryRuleMultiplication2"
    // PsiInternalSyntacticSequencerTestLanguage.g:754:1: entryRuleMultiplication2 returns [Boolean current=false] : iv_ruleMultiplication2= ruleMultiplication2 EOF ;
    public final Boolean entryRuleMultiplication2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiplication2 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:754:57: (iv_ruleMultiplication2= ruleMultiplication2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:755:2: iv_ruleMultiplication2= ruleMultiplication2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMultiplication2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplication2=ruleMultiplication2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication2"


    // $ANTLR start "ruleMultiplication2"
    // PsiInternalSyntacticSequencerTestLanguage.g:761:1: ruleMultiplication2 returns [Boolean current=false] : (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final Boolean ruleMultiplication2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Prim2_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:762:1: ( (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:763:2: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:763:2: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:764:3: this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getMultiplication2_Prim2ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_11);
            this_Prim2_0=rulePrim2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prim2_0;
              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:772:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:773:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:773:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:774:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplication2_Mult2LeftAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getMultiplication2_AsteriskKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:787:4: ( (lv_right_3_0= rulePrim2 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:788:5: (lv_right_3_0= rulePrim2 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:788:5: (lv_right_3_0= rulePrim2 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:789:6: lv_right_3_0= rulePrim2
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_right_3_0=rulePrim2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication2"


    // $ANTLR start "entryRulePrim2"
    // PsiInternalSyntacticSequencerTestLanguage.g:807:1: entryRulePrim2 returns [Boolean current=false] : iv_rulePrim2= rulePrim2 EOF ;
    public final Boolean entryRulePrim2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrim2 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:807:47: (iv_rulePrim2= rulePrim2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:808:2: iv_rulePrim2= rulePrim2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim2=rulePrim2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrim2"


    // $ANTLR start "rulePrim2"
    // PsiInternalSyntacticSequencerTestLanguage.g:814:1: rulePrim2 returns [Boolean current=false] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) ;
    public final Boolean rulePrim2() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean this_Addition2_3 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:815:1: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:816:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:816:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:817:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:817:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:818:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:818:4: ()
                    // PsiInternalSyntacticSequencerTestLanguage.g:819:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPrim2_Val2Action_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalSyntacticSequencerTestLanguage.g:825:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:826:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:826:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:827:6: lv_name_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPrim2_NameIDTerminalRuleCall_0_1_0ElementType());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_0);
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:844:3: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:844:3: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:845:4: otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim2_LeftParenthesisKeyword_1_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPrim2_Addition2ParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    this_Addition2_3=ruleAddition2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Addition2_3;
                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim2_RightParenthesisKeyword_1_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrim2"


    // $ANTLR start "entryRuleDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:872:1: entryRuleDatatypeID returns [Boolean current=false] : iv_ruleDatatypeID= ruleDatatypeID EOF ;
    public final Boolean entryRuleDatatypeID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypeID = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:872:52: (iv_ruleDatatypeID= ruleDatatypeID EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:873:2: iv_ruleDatatypeID= ruleDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDatatypeIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeID=ruleDatatypeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDatatypeID; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeID"


    // $ANTLR start "ruleDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:879:1: ruleDatatypeID returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleDatatypeID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:880:1: (this_ID_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:881:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getDatatypeID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeID"


    // $ANTLR start "entryRuleSingleCrossReference"
    // PsiInternalSyntacticSequencerTestLanguage.g:891:1: entryRuleSingleCrossReference returns [Boolean current=false] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final Boolean entryRuleSingleCrossReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleCrossReference = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:891:62: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:892:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleCrossReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // PsiInternalSyntacticSequencerTestLanguage.g:898:1: ruleSingleCrossReference returns [Boolean current=false] : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
    public final Boolean ruleSingleCrossReference() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:899:1: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:900:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:900:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:901:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:908:3: ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:909:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:909:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:910:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:910:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_TERMINAL_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:911:6: lv_name_1_1= RULE_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    lv_name_1_1=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_1);
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:925:6: lv_name_1_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_2);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalSyntacticSequencerTestLanguage.g:941:3: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:942:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw1Keyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:949:4: ( (otherlv_3= RULE_TERMINAL_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:950:5: (otherlv_3= RULE_TERMINAL_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:950:5: (otherlv_3= RULE_TERMINAL_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:951:6: otherlv_3= RULE_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType());
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_3);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:967:3: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:968:4: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw2Keyword_3_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:975:4: ( ( ruleDatatypeID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:976:5: ( ruleDatatypeID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:976:5: ( ruleDatatypeID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:977:6: ruleDatatypeID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    ruleDatatypeID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:993:3: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:994:4: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw3Keyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:1001:4: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1002:5: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1002:5: (otherlv_7= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1003:6: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType());
                      					
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_7);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1019:3: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1020:4: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw4Keyword_5_0ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_8);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:1027:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1028:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1028:5: (otherlv_9= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1029:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleBooleanAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1049:1: entryRuleBooleanAlternative returns [Boolean current=false] : iv_ruleBooleanAlternative= ruleBooleanAlternative EOF ;
    public final Boolean entryRuleBooleanAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanAlternative = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1049:60: (iv_ruleBooleanAlternative= ruleBooleanAlternative EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1050:2: iv_ruleBooleanAlternative= ruleBooleanAlternative EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanAlternativeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanAlternative=ruleBooleanAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAlternative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAlternative"


    // $ANTLR start "ruleBooleanAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1056:1: ruleBooleanAlternative returns [Boolean current=false] : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final Boolean ruleBooleanAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_bool_1_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1057:1: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1058:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1058:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1059:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBooleanAlternative_NumberSignDigitSixKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1066:3: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1067:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1067:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // PsiInternalSyntacticSequencerTestLanguage.g:1068:5: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_bool_1_0=ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAlternative"


    // $ANTLR start "entryRuleBooleanAlternativeLiteral"
    // PsiInternalSyntacticSequencerTestLanguage.g:1085:1: entryRuleBooleanAlternativeLiteral returns [Boolean current=false] : iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF ;
    public final Boolean entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanAlternativeLiteral = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1085:67: (iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1086:2: iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanAlternativeLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanAlternativeLiteral=ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAlternativeLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAlternativeLiteral"


    // $ANTLR start "ruleBooleanAlternativeLiteral"
    // PsiInternalSyntacticSequencerTestLanguage.g:1092:1: ruleBooleanAlternativeLiteral returns [Boolean current=false] : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final Boolean ruleBooleanAlternativeLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1093:1: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1094:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1094:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1095:3: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1095:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:1096:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1102:3: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1103:4: otherlv_1= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1111:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1111:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1112:5: (lv_isTrue_2_0= 'kw2' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1112:5: (lv_isTrue_2_0= 'kw2' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1113:6: lv_isTrue_2_0= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType());
                      					
                    }
                    lv_isTrue_2_0=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_isTrue_2_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAlternativeLiteral"


    // $ANTLR start "entryRuleUnassignedDatatype"
    // PsiInternalSyntacticSequencerTestLanguage.g:1133:1: entryRuleUnassignedDatatype returns [Boolean current=false] : iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF ;
    public final Boolean entryRuleUnassignedDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedDatatype = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1133:60: (iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1134:2: iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnassignedDatatypeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedDatatype=ruleUnassignedDatatype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnassignedDatatype; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedDatatype"


    // $ANTLR start "ruleUnassignedDatatype"
    // PsiInternalSyntacticSequencerTestLanguage.g:1140:1: ruleUnassignedDatatype returns [Boolean current=false] : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final Boolean ruleUnassignedDatatype() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1141:1: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1142:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1142:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // PsiInternalSyntacticSequencerTestLanguage.g:1143:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1150:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1151:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1151:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1152:5: lv_val_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getUnassignedDatatype_KW1ParserRuleCall_2ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKW1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedDatatype"


    // $ANTLR start "entryRuleKW1"
    // PsiInternalSyntacticSequencerTestLanguage.g:1178:1: entryRuleKW1 returns [Boolean current=false] : iv_ruleKW1= ruleKW1 EOF ;
    public final Boolean entryRuleKW1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKW1 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1178:45: (iv_ruleKW1= ruleKW1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1179:2: iv_ruleKW1= ruleKW1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getKW1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKW1=ruleKW1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKW1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKW1"


    // $ANTLR start "ruleKW1"
    // PsiInternalSyntacticSequencerTestLanguage.g:1185:1: ruleKW1 returns [Boolean current=false] : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final Boolean ruleKW1() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1186:1: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1187:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1187:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1188:3: kw= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getKW1_Kw1Keyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1196:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1196:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1197:4: kw= 'matched' (this_INT_2= RULE_INT )?
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getKW1_MatchedKeyword_1_0ElementType());
                      			
                    }
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:1204:4: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // PsiInternalSyntacticSequencerTestLanguage.g:1205:5: this_INT_2= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getKW1_INTTerminalRuleCall_1_1ElementType());
                              				
                            }
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_INT_2);
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKW1"


    // $ANTLR start "entryRuleOptionalSingleTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1218:1: entryRuleOptionalSingleTransition returns [Boolean current=false] : iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF ;
    public final Boolean entryRuleOptionalSingleTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptionalSingleTransition = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1218:66: (iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1219:2: iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOptionalSingleTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalSingleTransition=ruleOptionalSingleTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalSingleTransition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalSingleTransition"


    // $ANTLR start "ruleOptionalSingleTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1225:1: ruleOptionalSingleTransition returns [Boolean current=false] : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleOptionalSingleTransition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1226:1: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1227:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1227:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1228:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1235:3: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1236:4: ruleKW1
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getOptionalSingleTransition_KW1ParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1244:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1245:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1245:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1246:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_2_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalSingleTransition"


    // $ANTLR start "entryRuleOptionalManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1265:1: entryRuleOptionalManyTransition returns [Boolean current=false] : iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF ;
    public final Boolean entryRuleOptionalManyTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptionalManyTransition = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1265:64: (iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1266:2: iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOptionalManyTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalManyTransition=ruleOptionalManyTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalManyTransition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalManyTransition"


    // $ANTLR start "ruleOptionalManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1272:1: ruleOptionalManyTransition returns [Boolean current=false] : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleOptionalManyTransition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1273:1: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1274:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1274:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1275:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1282:3: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1283:4: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getOptionalManyTransition_KW1ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // PsiInternalSyntacticSequencerTestLanguage.g:1291:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1292:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1292:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1293:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_2_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalManyTransition"


    // $ANTLR start "entryRuleMandatoryManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1312:1: entryRuleMandatoryManyTransition returns [Boolean current=false] : iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF ;
    public final Boolean entryRuleMandatoryManyTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMandatoryManyTransition = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1312:65: (iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1313:2: iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMandatoryManyTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMandatoryManyTransition=ruleMandatoryManyTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatoryManyTransition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMandatoryManyTransition"


    // $ANTLR start "ruleMandatoryManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1319:1: ruleMandatoryManyTransition returns [Boolean current=false] : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleMandatoryManyTransition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1320:1: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1321:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1321:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1322:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1329:3: ( ruleKW1 )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14||LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1330:4: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getMandatoryManyTransition_KW1ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // PsiInternalSyntacticSequencerTestLanguage.g:1338:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1339:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1339:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1340:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_2_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMandatoryManyTransition"


    // $ANTLR start "entryRuleAlternativeTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1359:1: entryRuleAlternativeTransition returns [Boolean current=false] : iv_ruleAlternativeTransition= ruleAlternativeTransition EOF ;
    public final Boolean entryRuleAlternativeTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternativeTransition = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1359:63: (iv_ruleAlternativeTransition= ruleAlternativeTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1360:2: iv_ruleAlternativeTransition= ruleAlternativeTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAlternativeTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternativeTransition=ruleAlternativeTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternativeTransition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternativeTransition"


    // $ANTLR start "ruleAlternativeTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1366:1: ruleAlternativeTransition returns [Boolean current=false] : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleAlternativeTransition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1367:1: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1368:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1368:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1369:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1376:3: ( ruleKW1 | otherlv_2= 'kw2' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14||LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==15) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1377:4: ruleKW1
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getAlternativeTransition_KW1ParserRuleCall_1_0ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1385:4: otherlv_2= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAlternativeTransition_Kw2Keyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1393:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1394:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1394:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1395:5: lv_val_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_3_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeTransition"


    // $ANTLR start "entryRuleBooleanDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:1414:1: entryRuleBooleanDatatypeID returns [Boolean current=false] : iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF ;
    public final Boolean entryRuleBooleanDatatypeID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanDatatypeID = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1414:59: (iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1415:2: iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanDatatypeIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanDatatypeID=ruleBooleanDatatypeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanDatatypeID; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanDatatypeID"


    // $ANTLR start "ruleBooleanDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:1421:1: ruleBooleanDatatypeID returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleBooleanDatatypeID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1422:1: (this_ID_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1423:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getBooleanDatatypeID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanDatatypeID"


    // $ANTLR start "entryRuleBooleanValues"
    // PsiInternalSyntacticSequencerTestLanguage.g:1433:1: entryRuleBooleanValues returns [Boolean current=false] : iv_ruleBooleanValues= ruleBooleanValues EOF ;
    public final Boolean entryRuleBooleanValues() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanValues = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1433:55: (iv_ruleBooleanValues= ruleBooleanValues EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1434:2: iv_ruleBooleanValues= ruleBooleanValues EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanValuesElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanValues=ruleBooleanValues();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanValues; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanValues"


    // $ANTLR start "ruleBooleanValues"
    // PsiInternalSyntacticSequencerTestLanguage.g:1440:1: ruleBooleanValues returns [Boolean current=false] : ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) ;
    public final Boolean ruleBooleanValues() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Boolean lv_val3_4_0 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1441:1: ( ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1442:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1442:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:1443:3: () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1443:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:1444:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBooleanValues_BooleanValuesAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1457:3: ( (lv_val1_2_0= 'kw1' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1458:4: (lv_val1_2_0= 'kw1' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1458:4: (lv_val1_2_0= 'kw1' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1459:5: lv_val1_2_0= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getBooleanValues_Val1Kw1Keyword_2_0ElementType());
                      				
                    }
                    lv_val1_2_0=(Token)match(input,14,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_val1_2_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1474:3: ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BOOLEAN_TERMINAL_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1475:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1475:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1476:5: lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    lv_val2_3_0=(Token)match(input,RULE_BOOLEAN_TERMINAL_ID,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_val2_3_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1491:3: ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1492:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1492:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1493:5: lv_val3_4_0= ruleBooleanDatatypeID
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val3_4_0=ruleBooleanDatatypeID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanValues"


    // $ANTLR start "entryRuleLongAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1510:1: entryRuleLongAlternative returns [Boolean current=false] : iv_ruleLongAlternative= ruleLongAlternative EOF ;
    public final Boolean entryRuleLongAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLongAlternative = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1510:57: (iv_ruleLongAlternative= ruleLongAlternative EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1511:2: iv_ruleLongAlternative= ruleLongAlternative EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLongAlternativeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLongAlternative=ruleLongAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLongAlternative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongAlternative"


    // $ANTLR start "ruleLongAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1517:1: ruleLongAlternative returns [Boolean current=false] : (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) ;
    public final Boolean ruleLongAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_foo_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token lv_val3_7_0=null;
        Token otherlv_8=null;
        Token lv_val4_9_0=null;
        Token otherlv_10=null;
        Token lv_val5_11_0=null;
        Token otherlv_12=null;
        Token lv_val6_13_0=null;
        Token otherlv_14=null;
        Token lv_val7_15_0=null;
        Token otherlv_16=null;
        Token lv_val8_17_0=null;
        Token otherlv_18=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1518:1: ( (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1519:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1519:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            // PsiInternalSyntacticSequencerTestLanguage.g:1520:3: otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1527:3: ( (lv_foo_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1528:4: (lv_foo_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1528:4: (lv_foo_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1529:5: lv_foo_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getLongAlternative_FooIDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_foo_1_0);
              				
            }

            }


            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1544:3: ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )*
            loop31:
            do {
                int alt31=9;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt31=1;
                    }
                    break;
                case 15:
                    {
                    alt31=2;
                    }
                    break;
                case 16:
                    {
                    alt31=3;
                    }
                    break;
                case 17:
                    {
                    alt31=4;
                    }
                    break;
                case 35:
                    {
                    alt31=5;
                    }
                    break;
                case 36:
                    {
                    alt31=6;
                    }
                    break;
                case 37:
                    {
                    alt31=7;
                    }
                    break;
                case 38:
                    {
                    alt31=8;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1545:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1545:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1546:5: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw1Keyword_2_0_0ElementType());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1553:5: ( (lv_val1_3_0= RULE_ID ) )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_ID) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1554:6: (lv_val1_3_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1554:6: (lv_val1_3_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1555:7: lv_val1_3_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val1_3_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1572:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1572:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1573:5: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw2Keyword_2_1_0ElementType());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_4);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1580:5: ( (lv_val2_5_0= RULE_ID ) )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_ID) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1581:6: (lv_val2_5_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1581:6: (lv_val2_5_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1582:7: lv_val2_5_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val2_5_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1599:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1599:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1600:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw3Keyword_2_2_0ElementType());
            	      				
            	    }
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_6);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1607:5: ( (lv_val3_7_0= RULE_ID ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==RULE_ID) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1608:6: (lv_val3_7_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1608:6: (lv_val3_7_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1609:7: lv_val3_7_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val3_7_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1626:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1626:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1627:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw4Keyword_2_3_0ElementType());
            	      				
            	    }
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_8);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1634:5: ( (lv_val4_9_0= RULE_ID ) )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_ID) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1635:6: (lv_val4_9_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1635:6: (lv_val4_9_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1636:7: lv_val4_9_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val4_9_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1653:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1653:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1654:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw5Keyword_2_4_0ElementType());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_10);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1661:5: ( (lv_val5_11_0= RULE_ID ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1662:6: (lv_val5_11_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1662:6: (lv_val5_11_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1663:7: lv_val5_11_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val5_11_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1680:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1680:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1681:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw6Keyword_2_5_0ElementType());
            	      				
            	    }
            	    otherlv_12=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_12);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1688:5: ( (lv_val6_13_0= RULE_ID ) )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1689:6: (lv_val6_13_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1689:6: (lv_val6_13_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1690:7: lv_val6_13_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val6_13_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1707:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1707:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1708:5: otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw7Keyword_2_6_0ElementType());
            	      				
            	    }
            	    otherlv_14=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_14);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1715:5: ( (lv_val7_15_0= RULE_ID ) )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==RULE_ID) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1716:6: (lv_val7_15_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1716:6: (lv_val7_15_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1717:7: lv_val7_15_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val7_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val7_15_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1734:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1734:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1735:5: otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw8Keyword_2_7_0ElementType());
            	      				
            	    }
            	    otherlv_16=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_16);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1742:5: ( (lv_val8_17_0= RULE_ID ) )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_ID) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1743:6: (lv_val8_17_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1743:6: (lv_val8_17_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1744:7: lv_val8_17_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }
            	            lv_val8_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_val8_17_0);
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLongAlternative_ExclamationMarkKeyword_3ElementType());
              		
            }
            otherlv_18=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_18);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongAlternative"


    // $ANTLR start "entryRuleActionOnly"
    // PsiInternalSyntacticSequencerTestLanguage.g:1772:1: entryRuleActionOnly returns [Boolean current=false] : iv_ruleActionOnly= ruleActionOnly EOF ;
    public final Boolean entryRuleActionOnly() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleActionOnly = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1772:52: (iv_ruleActionOnly= ruleActionOnly EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1773:2: iv_ruleActionOnly= ruleActionOnly EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getActionOnlyElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionOnly=ruleActionOnly();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionOnly; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionOnly"


    // $ANTLR start "ruleActionOnly"
    // PsiInternalSyntacticSequencerTestLanguage.g:1779:1: ruleActionOnly returns [Boolean current=false] : (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) ;
    public final Boolean ruleActionOnly() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_4=null;
        Token this_ID_5=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1780:1: ( (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1781:2: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1781:2: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:1782:3: otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getActionOnly_NumberSignDigitOneDigitFourKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1789:3: (otherlv_1= 'kw1' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1790:4: otherlv_1= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_Kw1Keyword_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1798:3: ( ( RULE_ID )=>this_ID_2= RULE_ID )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred1_PsiInternalSyntacticSequencerTestLanguage()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1799:4: ( RULE_ID )=>this_ID_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_IDTerminalRuleCall_2ElementType());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_ID_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1808:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:1809:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getActionOnly_ActionOnlyAction_3ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1815:3: (otherlv_4= 'kw2' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1816:4: otherlv_4= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_Kw2Keyword_4ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1824:3: (this_ID_5= RULE_ID )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1825:4: this_ID_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_IDTerminalRuleCall_5ElementType());
                      			
                    }
                    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_ID_5);
                      			
                    }

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionOnly"


    // $ANTLR start "entryRuleFragmentCaller"
    // PsiInternalSyntacticSequencerTestLanguage.g:1837:1: entryRuleFragmentCaller returns [Boolean current=false] : iv_ruleFragmentCaller= ruleFragmentCaller EOF ;
    public final Boolean entryRuleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFragmentCaller = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1837:56: (iv_ruleFragmentCaller= ruleFragmentCaller EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1838:2: iv_ruleFragmentCaller= ruleFragmentCaller EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFragmentCallerElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFragmentCaller=ruleFragmentCaller();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFragmentCaller; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFragmentCaller"


    // $ANTLR start "ruleFragmentCaller"
    // PsiInternalSyntacticSequencerTestLanguage.g:1844:1: ruleFragmentCaller returns [Boolean current=false] : (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val_3_0=null;
        Boolean this_Fragment1_2 = null;


        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1845:1: ( (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1846:2: (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1846:2: (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1847:3: otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFragmentCaller_NumberSignDigitOneDigitFiveKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1854:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1855:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1855:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1856:5: lv_val1_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFragmentCaller_Val1IDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val1_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getFragmentCaller_Fragment1ParserRuleCall_2ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_3);
            this_Fragment1_2=ruleFragment1(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Fragment1_2;
              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1883:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1884:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1884:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1885:5: lv_val_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFragmentCaller_ValIDTerminalRuleCall_3_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val_3_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentCaller"


    // $ANTLR start "ruleFragment1"
    // PsiInternalSyntacticSequencerTestLanguage.g:1905:1: ruleFragment1[Boolean in_current] returns [Boolean current=in_current] : ( (lv_fragVal_0_0= RULE_ID ) ) ;
    public final Boolean ruleFragment1(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_fragVal_0_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1906:1: ( ( (lv_fragVal_0_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1907:2: ( (lv_fragVal_0_0= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1907:2: ( (lv_fragVal_0_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1908:3: (lv_fragVal_0_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1908:3: (lv_fragVal_0_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1909:4: lv_fragVal_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getFragment1_FragValIDTerminalRuleCall_0ElementType());
              			
            }
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
            lv_fragVal_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_fragVal_0_0);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragment1"

    // $ANTLR start synpred1_PsiInternalSyntacticSequencerTestLanguage
    public final void synpred1_PsiInternalSyntacticSequencerTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSyntacticSequencerTestLanguage.g:1799:4: ( RULE_ID )
        // PsiInternalSyntacticSequencerTestLanguage.g:1799:5: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_PsiInternalSyntacticSequencerTestLanguage

    // Delegated rules

    public final boolean synpred1_PsiInternalSyntacticSequencerTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalSyntacticSequencerTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000001000C000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000004092L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000092L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000000000C012L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000008012L});
    }


}