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
    // PsiInternalSyntacticSequencerTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:53:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSyntacticSequencerTestLanguage.g:58:1: ruleModel : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:58:10: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) | ( (lv_x15_14_0= ruleFragmentCaller ) ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:60:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:60:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:61:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:61:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    // PsiInternalSyntacticSequencerTestLanguage.g:62:5: lv_x1_0_0= ruleMandatoryKeywords
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMandatoryKeywords();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:72:3: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:72:3: ( (lv_x2_1_0= ruleExp0 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:73:4: (lv_x2_1_0= ruleExp0 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:73:4: (lv_x2_1_0= ruleExp0 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:74:5: lv_x2_1_0= ruleExp0
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X2Exp0ParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExp0();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:84:3: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:84:3: ( (lv_x3_2_0= ruleExp1 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:85:4: (lv_x3_2_0= ruleExp1 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:85:4: (lv_x3_2_0= ruleExp1 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:86:5: lv_x3_2_0= ruleExp1
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X3Exp1ParserRuleCall_2_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExp1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:96:3: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:96:3: ( (lv_x4_3_0= ruleExp2 ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:97:4: (lv_x4_3_0= ruleExp2 )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:97:4: (lv_x4_3_0= ruleExp2 )
                    // PsiInternalSyntacticSequencerTestLanguage.g:98:5: lv_x4_3_0= ruleExp2
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X4Exp2ParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExp2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:108:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:108:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:109:4: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:109:4: (lv_x5_4_0= ruleSingleCrossReference )
                    // PsiInternalSyntacticSequencerTestLanguage.g:110:5: lv_x5_4_0= ruleSingleCrossReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSingleCrossReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:120:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:120:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:121:4: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:121:4: (lv_x6_5_0= ruleBooleanAlternative )
                    // PsiInternalSyntacticSequencerTestLanguage.g:122:5: lv_x6_5_0= ruleBooleanAlternative
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X6BooleanAlternativeParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBooleanAlternative();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:132:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:132:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:133:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:133:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    // PsiInternalSyntacticSequencerTestLanguage.g:134:5: lv_x7_6_0= ruleUnassignedDatatype
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedDatatype();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:144:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:144:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:145:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:145:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:146:5: lv_x8_7_0= ruleOptionalSingleTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOptionalSingleTransition();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:156:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:156:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:157:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:157:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:158:5: lv_x9_8_0= ruleOptionalManyTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOptionalManyTransition();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:168:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:168:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:169:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:169:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:170:5: lv_x10_9_0= ruleMandatoryManyTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMandatoryManyTransition();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:180:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:180:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:181:4: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:181:4: (lv_x11_10_0= ruleAlternativeTransition )
                    // PsiInternalSyntacticSequencerTestLanguage.g:182:5: lv_x11_10_0= ruleAlternativeTransition
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X11AlternativeTransitionParserRuleCall_10_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAlternativeTransition();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:192:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:192:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:193:4: (lv_x12_11_0= ruleBooleanValues )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:193:4: (lv_x12_11_0= ruleBooleanValues )
                    // PsiInternalSyntacticSequencerTestLanguage.g:194:5: lv_x12_11_0= ruleBooleanValues
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X12BooleanValuesParserRuleCall_11_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBooleanValues();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:204:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:204:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:205:4: (lv_x13_12_0= ruleLongAlternative )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:205:4: (lv_x13_12_0= ruleLongAlternative )
                    // PsiInternalSyntacticSequencerTestLanguage.g:206:5: lv_x13_12_0= ruleLongAlternative
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X13LongAlternativeParserRuleCall_12_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLongAlternative();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:216:3: ( (lv_x14_13_0= ruleActionOnly ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:216:3: ( (lv_x14_13_0= ruleActionOnly ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:217:4: (lv_x14_13_0= ruleActionOnly )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:217:4: (lv_x14_13_0= ruleActionOnly )
                    // PsiInternalSyntacticSequencerTestLanguage.g:218:5: lv_x14_13_0= ruleActionOnly
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X14ActionOnlyParserRuleCall_13_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleActionOnly();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 15 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:228:3: ( (lv_x15_14_0= ruleFragmentCaller ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:228:3: ( (lv_x15_14_0= ruleFragmentCaller ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:229:4: (lv_x15_14_0= ruleFragmentCaller )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:229:4: (lv_x15_14_0= ruleFragmentCaller )
                    // PsiInternalSyntacticSequencerTestLanguage.g:230:5: lv_x15_14_0= ruleFragmentCaller
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_X15FragmentCallerParserRuleCall_14_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFragmentCaller();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleMandatoryKeywords"
    // PsiInternalSyntacticSequencerTestLanguage.g:243:1: entryRuleMandatoryKeywords : ruleMandatoryKeywords EOF ;
    public final void entryRuleMandatoryKeywords() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:243:27: ( ruleMandatoryKeywords EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:244:2: ruleMandatoryKeywords EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMandatoryKeywordsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMandatoryKeywords();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMandatoryKeywords"


    // $ANTLR start "ruleMandatoryKeywords"
    // PsiInternalSyntacticSequencerTestLanguage.g:249:1: ruleMandatoryKeywords : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
    public final void ruleMandatoryKeywords() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_val3_6_0=null;
        Token otherlv_7=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:249:22: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:250:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:250:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // PsiInternalSyntacticSequencerTestLanguage.g:251:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:258:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:259:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:259:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:260:5: lv_val1_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val1_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw1Keyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:276:3: ( (lv_val2_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:277:4: (lv_val2_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:277:4: (lv_val2_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:278:5: lv_val2_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType());
              				
            }
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val2_3_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw2Keyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw3Keyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:301:3: ( (lv_val3_6_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:302:4: (lv_val3_6_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:302:4: (lv_val3_6_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:303:5: lv_val3_6_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType());
              				
            }
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val3_6_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryKeywords_Kw4Keyword_7ElementType());
              		
            }
            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleMandatoryKeywords"


    // $ANTLR start "entryRuleExp0"
    // PsiInternalSyntacticSequencerTestLanguage.g:323:1: entryRuleExp0 : ruleExp0 EOF ;
    public final void entryRuleExp0() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:323:14: ( ruleExp0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:324:2: ruleExp0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExp0();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExp0"


    // $ANTLR start "ruleExp0"
    // PsiInternalSyntacticSequencerTestLanguage.g:329:1: ruleExp0 : (otherlv_0= '#2' ruleAddition0 ) ;
    public final void ruleExp0() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:329:9: ( (otherlv_0= '#2' ruleAddition0 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:330:2: (otherlv_0= '#2' ruleAddition0 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:330:2: (otherlv_0= '#2' ruleAddition0 )
            // PsiInternalSyntacticSequencerTestLanguage.g:331:3: otherlv_0= '#2' ruleAddition0
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp0_NumberSignDigitTwoKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp0_Addition0ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAddition0();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleExp0"


    // $ANTLR start "entryRuleAddition0"
    // PsiInternalSyntacticSequencerTestLanguage.g:349:1: entryRuleAddition0 : ruleAddition0 EOF ;
    public final void entryRuleAddition0() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:349:19: ( ruleAddition0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:350:2: ruleAddition0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAddition0();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddition0"


    // $ANTLR start "ruleAddition0"
    // PsiInternalSyntacticSequencerTestLanguage.g:355:1: ruleAddition0 : ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final void ruleAddition0() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:355:14: ( ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:356:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:356:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:357:3: rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition0_Prim0ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            rulePrim0();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:364:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:365:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:365:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:366:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition0_Add0LeftAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition0_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:378:4: ( (lv_right_3_0= rulePrim0 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:379:5: (lv_right_3_0= rulePrim0 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:379:5: (lv_right_3_0= rulePrim0 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:380:6: lv_right_3_0= rulePrim0
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition0_RightPrim0ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rulePrim0();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleAddition0"


    // $ANTLR start "entryRulePrim0"
    // PsiInternalSyntacticSequencerTestLanguage.g:394:1: entryRulePrim0 : rulePrim0 EOF ;
    public final void entryRulePrim0() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:394:15: ( rulePrim0 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:395:2: rulePrim0 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim0ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrim0();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrim0"


    // $ANTLR start "rulePrim0"
    // PsiInternalSyntacticSequencerTestLanguage.g:400:1: rulePrim0 : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void rulePrim0() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:400:10: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:401:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:401:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:402:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:402:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:403:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPrim0_Val0Action_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:408:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:409:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:409:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:410:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPrim0_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "rulePrim0"


    // $ANTLR start "entryRuleExp1"
    // PsiInternalSyntacticSequencerTestLanguage.g:423:1: entryRuleExp1 : ruleExp1 EOF ;
    public final void entryRuleExp1() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:423:14: ( ruleExp1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:424:2: ruleExp1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExp1();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExp1"


    // $ANTLR start "ruleExp1"
    // PsiInternalSyntacticSequencerTestLanguage.g:429:1: ruleExp1 : (otherlv_0= '#3' ruleAddition1 ) ;
    public final void ruleExp1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:429:9: ( (otherlv_0= '#3' ruleAddition1 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:430:2: (otherlv_0= '#3' ruleAddition1 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:430:2: (otherlv_0= '#3' ruleAddition1 )
            // PsiInternalSyntacticSequencerTestLanguage.g:431:3: otherlv_0= '#3' ruleAddition1
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp1_NumberSignDigitThreeKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp1_Addition1ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAddition1();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleExp1"


    // $ANTLR start "entryRuleAddition1"
    // PsiInternalSyntacticSequencerTestLanguage.g:449:1: entryRuleAddition1 : ruleAddition1 EOF ;
    public final void entryRuleAddition1() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:449:19: ( ruleAddition1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:450:2: ruleAddition1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAddition1();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddition1"


    // $ANTLR start "ruleAddition1"
    // PsiInternalSyntacticSequencerTestLanguage.g:455:1: ruleAddition1 : ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final void ruleAddition1() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:455:14: ( ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:456:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:456:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:457:3: rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition1_Prim1ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            rulePrim1();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:464:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:465:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:465:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:466:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition1_Add1LeftAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition1_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:478:4: ( (lv_right_3_0= rulePrim1 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:479:5: (lv_right_3_0= rulePrim1 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:479:5: (lv_right_3_0= rulePrim1 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:480:6: lv_right_3_0= rulePrim1
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition1_RightPrim1ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rulePrim1();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleAddition1"


    // $ANTLR start "entryRulePrim1"
    // PsiInternalSyntacticSequencerTestLanguage.g:494:1: entryRulePrim1 : rulePrim1 EOF ;
    public final void entryRulePrim1() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:494:15: ( rulePrim1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:495:2: rulePrim1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrim1();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrim1"


    // $ANTLR start "rulePrim1"
    // PsiInternalSyntacticSequencerTestLanguage.g:500:1: rulePrim1 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) ;
    public final void rulePrim1() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:500:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:501:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:501:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:502:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:502:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:503:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:503:4: ()
                    // PsiInternalSyntacticSequencerTestLanguage.g:504:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPrim1_Val1Action_0_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalSyntacticSequencerTestLanguage.g:509:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:510:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:510:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:511:6: lv_name_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPrim1_NameIDTerminalRuleCall_0_1_0ElementType());
                      					
                    }
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_0);
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:522:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:522:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:523:4: otherlv_2= '(' ruleAddition1 otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim1_LeftParenthesisKeyword_1_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPrim1_Addition1ParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleAddition1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim1_RightParenthesisKeyword_1_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "rulePrim1"


    // $ANTLR start "entryRuleExp2"
    // PsiInternalSyntacticSequencerTestLanguage.g:549:1: entryRuleExp2 : ruleExp2 EOF ;
    public final void entryRuleExp2() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:549:14: ( ruleExp2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:550:2: ruleExp2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExp2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExp2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExp2"


    // $ANTLR start "ruleExp2"
    // PsiInternalSyntacticSequencerTestLanguage.g:555:1: ruleExp2 : (otherlv_0= '#4' ruleAddition2 ) ;
    public final void ruleExp2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:555:9: ( (otherlv_0= '#4' ruleAddition2 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:556:2: (otherlv_0= '#4' ruleAddition2 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:556:2: (otherlv_0= '#4' ruleAddition2 )
            // PsiInternalSyntacticSequencerTestLanguage.g:557:3: otherlv_0= '#4' ruleAddition2
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExp2_NumberSignDigitFourKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getExp2_Addition2ParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAddition2();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleExp2"


    // $ANTLR start "entryRuleAddition2"
    // PsiInternalSyntacticSequencerTestLanguage.g:575:1: entryRuleAddition2 : ruleAddition2 EOF ;
    public final void entryRuleAddition2() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:575:19: ( ruleAddition2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:576:2: ruleAddition2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAddition2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAddition2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddition2"


    // $ANTLR start "ruleAddition2"
    // PsiInternalSyntacticSequencerTestLanguage.g:581:1: ruleAddition2 : ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final void ruleAddition2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:581:14: ( ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:582:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:582:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:583:3: ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAddition2_Multiplication2ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            ruleMultiplication2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:590:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:591:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:591:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:592:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAddition2_Add2LeftAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAddition2_PlusSignKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:604:4: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:605:5: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:605:5: (lv_right_3_0= ruleMultiplication2 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:606:6: lv_right_3_0= ruleMultiplication2
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    ruleMultiplication2();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleAddition2"


    // $ANTLR start "entryRuleMultiplication2"
    // PsiInternalSyntacticSequencerTestLanguage.g:620:1: entryRuleMultiplication2 : ruleMultiplication2 EOF ;
    public final void entryRuleMultiplication2() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:620:25: ( ruleMultiplication2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:621:2: ruleMultiplication2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMultiplication2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplication2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplication2"


    // $ANTLR start "ruleMultiplication2"
    // PsiInternalSyntacticSequencerTestLanguage.g:626:1: ruleMultiplication2 : ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final void ruleMultiplication2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:626:20: ( ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:627:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:627:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // PsiInternalSyntacticSequencerTestLanguage.g:628:3: rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getMultiplication2_Prim2ParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_11);
            rulePrim2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:635:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:636:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:636:4: ()
            	    // PsiInternalSyntacticSequencerTestLanguage.g:637:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplication2_Mult2LeftAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getMultiplication2_AsteriskKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_9); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:649:4: ( (lv_right_3_0= rulePrim2 ) )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:650:5: (lv_right_3_0= rulePrim2 )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:650:5: (lv_right_3_0= rulePrim2 )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:651:6: lv_right_3_0= rulePrim2
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rulePrim2();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleMultiplication2"


    // $ANTLR start "entryRulePrim2"
    // PsiInternalSyntacticSequencerTestLanguage.g:665:1: entryRulePrim2 : rulePrim2 EOF ;
    public final void entryRulePrim2() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:665:15: ( rulePrim2 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:666:2: rulePrim2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrim2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrim2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrim2"


    // $ANTLR start "rulePrim2"
    // PsiInternalSyntacticSequencerTestLanguage.g:671:1: rulePrim2 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) ;
    public final void rulePrim2() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:671:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:672:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:672:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:673:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:673:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:674:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:674:4: ()
                    // PsiInternalSyntacticSequencerTestLanguage.g:675:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPrim2_Val2Action_0_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalSyntacticSequencerTestLanguage.g:680:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:681:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:681:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:682:6: lv_name_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPrim2_NameIDTerminalRuleCall_0_1_0ElementType());
                      					
                    }
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_0);
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:693:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:693:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:694:4: otherlv_2= '(' ruleAddition2 otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim2_LeftParenthesisKeyword_1_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPrim2_Addition2ParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleAddition2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPrim2_RightParenthesisKeyword_1_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "rulePrim2"


    // $ANTLR start "entryRuleDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:720:1: entryRuleDatatypeID : ruleDatatypeID EOF ;
    public final void entryRuleDatatypeID() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:720:20: ( ruleDatatypeID EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:721:2: ruleDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDatatypeIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatypeID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDatatypeID"


    // $ANTLR start "ruleDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:726:1: ruleDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:726:15: (this_ID_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:727:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getDatatypeID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleDatatypeID"


    // $ANTLR start "entryRuleSingleCrossReference"
    // PsiInternalSyntacticSequencerTestLanguage.g:737:1: entryRuleSingleCrossReference : ruleSingleCrossReference EOF ;
    public final void entryRuleSingleCrossReference() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:737:30: ( ruleSingleCrossReference EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:738:2: ruleSingleCrossReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSingleCrossReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // PsiInternalSyntacticSequencerTestLanguage.g:743:1: ruleSingleCrossReference : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
    public final void ruleSingleCrossReference() throws RecognitionException {
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
            // PsiInternalSyntacticSequencerTestLanguage.g:743:25: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:744:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:744:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:745:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_12); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:752:3: ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:753:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:753:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:754:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:754:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_TERMINAL_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:755:6: lv_name_1_1= RULE_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_name_1_1=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_13); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_1);
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:763:6: lv_name_1_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType());
                      					
                    }
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_2);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalSyntacticSequencerTestLanguage.g:773:3: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:774:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw1Keyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:781:4: ( (otherlv_3= RULE_TERMINAL_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:782:5: (otherlv_3= RULE_TERMINAL_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:782:5: (otherlv_3= RULE_TERMINAL_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:783:6: otherlv_3= RULE_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType());
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_15); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_3);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:793:3: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:794:4: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw2Keyword_3_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:801:4: ( ( ruleDatatypeID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:802:5: ( ruleDatatypeID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:802:5: ( ruleDatatypeID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:803:6: ruleDatatypeID
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    ruleDatatypeID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:813:3: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:814:4: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw3Keyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:821:4: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:822:5: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:822:5: (otherlv_7= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:823:6: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType());
                      					
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_7);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:833:3: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:834:4: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSingleCrossReference_Kw4Keyword_5_0ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_8);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:841:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:842:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:842:5: (otherlv_9= RULE_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:843:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleBooleanAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:857:1: entryRuleBooleanAlternative : ruleBooleanAlternative EOF ;
    public final void entryRuleBooleanAlternative() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:857:28: ( ruleBooleanAlternative EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:858:2: ruleBooleanAlternative EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanAlternativeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBooleanAlternative();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanAlternative"


    // $ANTLR start "ruleBooleanAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:863:1: ruleBooleanAlternative : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final void ruleBooleanAlternative() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:863:23: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:864:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:864:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:865:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBooleanAlternative_NumberSignDigitSixKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_18); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:872:3: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:873:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:873:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // PsiInternalSyntacticSequencerTestLanguage.g:874:5: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleBooleanAlternative"


    // $ANTLR start "entryRuleBooleanAlternativeLiteral"
    // PsiInternalSyntacticSequencerTestLanguage.g:887:1: entryRuleBooleanAlternativeLiteral : ruleBooleanAlternativeLiteral EOF ;
    public final void entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:887:35: ( ruleBooleanAlternativeLiteral EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:888:2: ruleBooleanAlternativeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanAlternativeLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanAlternativeLiteral"


    // $ANTLR start "ruleBooleanAlternativeLiteral"
    // PsiInternalSyntacticSequencerTestLanguage.g:893:1: ruleBooleanAlternativeLiteral : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final void ruleBooleanAlternativeLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:893:30: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:894:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:894:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:895:3: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:895:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:896:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:901:3: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:902:4: otherlv_1= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:910:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:910:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    // PsiInternalSyntacticSequencerTestLanguage.g:911:5: (lv_isTrue_2_0= 'kw2' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:911:5: (lv_isTrue_2_0= 'kw2' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:912:6: lv_isTrue_2_0= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType());
                      					
                    }
                    lv_isTrue_2_0=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_isTrue_2_0);
                      					
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
        return ;
    }
    // $ANTLR end "ruleBooleanAlternativeLiteral"


    // $ANTLR start "entryRuleUnassignedDatatype"
    // PsiInternalSyntacticSequencerTestLanguage.g:926:1: entryRuleUnassignedDatatype : ruleUnassignedDatatype EOF ;
    public final void entryRuleUnassignedDatatype() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:926:28: ( ruleUnassignedDatatype EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:927:2: ruleUnassignedDatatype EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnassignedDatatypeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedDatatype();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnassignedDatatype"


    // $ANTLR start "ruleUnassignedDatatype"
    // PsiInternalSyntacticSequencerTestLanguage.g:932:1: ruleUnassignedDatatype : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final void ruleUnassignedDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:932:23: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:933:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:933:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // PsiInternalSyntacticSequencerTestLanguage.g:934:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:941:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:942:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:942:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:943:5: lv_val_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); if (state.failed) return ;
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
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleUnassignedDatatype"


    // $ANTLR start "entryRuleKW1"
    // PsiInternalSyntacticSequencerTestLanguage.g:963:1: entryRuleKW1 : ruleKW1 EOF ;
    public final void entryRuleKW1() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:963:13: ( ruleKW1 EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:964:2: ruleKW1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getKW1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKW1();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKW1"


    // $ANTLR start "ruleKW1"
    // PsiInternalSyntacticSequencerTestLanguage.g:969:1: ruleKW1 : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final void ruleKW1() throws RecognitionException {
        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:969:8: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:970:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:970:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:971:3: kw= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getKW1_Kw1Keyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:979:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:979:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // PsiInternalSyntacticSequencerTestLanguage.g:980:4: kw= 'matched' (this_INT_2= RULE_INT )?
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getKW1_MatchedKeyword_1_0ElementType());
                      			
                    }
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_20); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalSyntacticSequencerTestLanguage.g:987:4: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // PsiInternalSyntacticSequencerTestLanguage.g:988:5: this_INT_2= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getKW1_INTTerminalRuleCall_1_1ElementType());
                              				
                            }
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleKW1"


    // $ANTLR start "entryRuleOptionalSingleTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1001:1: entryRuleOptionalSingleTransition : ruleOptionalSingleTransition EOF ;
    public final void entryRuleOptionalSingleTransition() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1001:34: ( ruleOptionalSingleTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1002:2: ruleOptionalSingleTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOptionalSingleTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOptionalSingleTransition();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptionalSingleTransition"


    // $ANTLR start "ruleOptionalSingleTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1007:1: ruleOptionalSingleTransition : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalSingleTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1007:29: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1008:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1008:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1009:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_21); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1016:3: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1017:4: ruleKW1
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getOptionalSingleTransition_KW1ParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1025:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1026:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1026:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1027:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOptionalSingleTransition"


    // $ANTLR start "entryRuleOptionalManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1040:1: entryRuleOptionalManyTransition : ruleOptionalManyTransition EOF ;
    public final void entryRuleOptionalManyTransition() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1040:32: ( ruleOptionalManyTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1041:2: ruleOptionalManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOptionalManyTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOptionalManyTransition();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptionalManyTransition"


    // $ANTLR start "ruleOptionalManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1046:1: ruleOptionalManyTransition : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1046:27: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1047:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1047:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1048:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_21); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1055:3: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1056:4: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getOptionalManyTransition_KW1ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // PsiInternalSyntacticSequencerTestLanguage.g:1064:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1065:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1065:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1066:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOptionalManyTransition"


    // $ANTLR start "entryRuleMandatoryManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1079:1: entryRuleMandatoryManyTransition : ruleMandatoryManyTransition EOF ;
    public final void entryRuleMandatoryManyTransition() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1079:33: ( ruleMandatoryManyTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1080:2: ruleMandatoryManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMandatoryManyTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMandatoryManyTransition();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMandatoryManyTransition"


    // $ANTLR start "ruleMandatoryManyTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1085:1: ruleMandatoryManyTransition : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleMandatoryManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1085:28: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1086:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1086:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1087:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_19); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1094:3: ( ruleKW1 )+
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1095:4: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getMandatoryManyTransition_KW1ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // PsiInternalSyntacticSequencerTestLanguage.g:1103:3: ( (lv_val_2_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1104:4: (lv_val_2_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1104:4: (lv_val_2_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1105:5: lv_val_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleMandatoryManyTransition"


    // $ANTLR start "entryRuleAlternativeTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1118:1: entryRuleAlternativeTransition : ruleAlternativeTransition EOF ;
    public final void entryRuleAlternativeTransition() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1118:31: ( ruleAlternativeTransition EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1119:2: ruleAlternativeTransition EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAlternativeTransitionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternativeTransition();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlternativeTransition"


    // $ANTLR start "ruleAlternativeTransition"
    // PsiInternalSyntacticSequencerTestLanguage.g:1124:1: ruleAlternativeTransition : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final void ruleAlternativeTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1124:26: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1125:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1125:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1126:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_22); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1133:3: ( ruleKW1 | otherlv_2= 'kw2' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14||LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==15) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1134:4: ruleKW1
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getAlternativeTransition_KW1ParserRuleCall_1_0ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1142:4: otherlv_2= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAlternativeTransition_Kw2Keyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1150:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1151:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1151:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1152:5: lv_val_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleAlternativeTransition"


    // $ANTLR start "entryRuleBooleanDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:1165:1: entryRuleBooleanDatatypeID : ruleBooleanDatatypeID EOF ;
    public final void entryRuleBooleanDatatypeID() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1165:27: ( ruleBooleanDatatypeID EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1166:2: ruleBooleanDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanDatatypeIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBooleanDatatypeID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanDatatypeID"


    // $ANTLR start "ruleBooleanDatatypeID"
    // PsiInternalSyntacticSequencerTestLanguage.g:1171:1: ruleBooleanDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleBooleanDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1171:22: (this_ID_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1172:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getBooleanDatatypeID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleBooleanDatatypeID"


    // $ANTLR start "entryRuleBooleanValues"
    // PsiInternalSyntacticSequencerTestLanguage.g:1182:1: entryRuleBooleanValues : ruleBooleanValues EOF ;
    public final void entryRuleBooleanValues() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1182:23: ( ruleBooleanValues EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1183:2: ruleBooleanValues EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBooleanValuesElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBooleanValues();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanValues"


    // $ANTLR start "ruleBooleanValues"
    // PsiInternalSyntacticSequencerTestLanguage.g:1188:1: ruleBooleanValues : ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) ;
    public final void ruleBooleanValues() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1188:18: ( ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1189:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1189:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:1190:3: () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1190:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:1191:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBooleanValues_BooleanValuesAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_23); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1203:3: ( (lv_val1_2_0= 'kw1' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1204:4: (lv_val1_2_0= 'kw1' )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1204:4: (lv_val1_2_0= 'kw1' )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1205:5: lv_val1_2_0= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getBooleanValues_Val1Kw1Keyword_2_0ElementType());
                      				
                    }
                    lv_val1_2_0=(Token)match(input,14,FollowSets000.FOLLOW_24); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_val1_2_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1214:3: ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BOOLEAN_TERMINAL_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1215:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1215:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1216:5: lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType());
                      				
                    }
                    lv_val2_3_0=(Token)match(input,RULE_BOOLEAN_TERMINAL_ID,FollowSets000.FOLLOW_25); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_val2_3_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1225:3: ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1226:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    {
                    // PsiInternalSyntacticSequencerTestLanguage.g:1226:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    // PsiInternalSyntacticSequencerTestLanguage.g:1227:5: lv_val3_4_0= ruleBooleanDatatypeID
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBooleanDatatypeID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "ruleBooleanValues"


    // $ANTLR start "entryRuleLongAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1240:1: entryRuleLongAlternative : ruleLongAlternative EOF ;
    public final void entryRuleLongAlternative() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1240:25: ( ruleLongAlternative EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1241:2: ruleLongAlternative EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLongAlternativeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLongAlternative();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLongAlternative"


    // $ANTLR start "ruleLongAlternative"
    // PsiInternalSyntacticSequencerTestLanguage.g:1246:1: ruleLongAlternative : (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) ;
    public final void ruleLongAlternative() throws RecognitionException {
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
            // PsiInternalSyntacticSequencerTestLanguage.g:1246:20: ( (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1247:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1247:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            // PsiInternalSyntacticSequencerTestLanguage.g:1248:3: otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1255:3: ( (lv_foo_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1256:4: (lv_foo_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1256:4: (lv_foo_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1257:5: lv_foo_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getLongAlternative_FooIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_foo_1_0);
              				
            }

            }


            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1266:3: ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )*
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1267:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1267:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1268:5: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw1Keyword_2_0_0ElementType());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1275:5: ( (lv_val1_3_0= RULE_ID ) )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_ID) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1276:6: (lv_val1_3_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1276:6: (lv_val1_3_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1277:7: lv_val1_3_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	              						
            	            }
            	            lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1288:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1288:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1289:5: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw2Keyword_2_1_0ElementType());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_4);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1296:5: ( (lv_val2_5_0= RULE_ID ) )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_ID) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1297:6: (lv_val2_5_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1297:6: (lv_val2_5_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1298:7: lv_val2_5_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType());
            	              						
            	            }
            	            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1309:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1309:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1310:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw3Keyword_2_2_0ElementType());
            	      				
            	    }
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_6);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1317:5: ( (lv_val3_7_0= RULE_ID ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==RULE_ID) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1318:6: (lv_val3_7_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1318:6: (lv_val3_7_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1319:7: lv_val3_7_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	              						
            	            }
            	            lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1330:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1330:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1331:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw4Keyword_2_3_0ElementType());
            	      				
            	    }
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_8);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1338:5: ( (lv_val4_9_0= RULE_ID ) )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_ID) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1339:6: (lv_val4_9_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1339:6: (lv_val4_9_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1340:7: lv_val4_9_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType());
            	              						
            	            }
            	            lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1351:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1351:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1352:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw5Keyword_2_4_0ElementType());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_10);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1359:5: ( (lv_val5_11_0= RULE_ID ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1360:6: (lv_val5_11_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1360:6: (lv_val5_11_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1361:7: lv_val5_11_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType());
            	              						
            	            }
            	            lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1372:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1372:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1373:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw6Keyword_2_5_0ElementType());
            	      				
            	    }
            	    otherlv_12=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_12);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1380:5: ( (lv_val6_13_0= RULE_ID ) )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1381:6: (lv_val6_13_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1381:6: (lv_val6_13_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1382:7: lv_val6_13_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType());
            	              						
            	            }
            	            lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1393:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1393:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1394:5: otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw7Keyword_2_6_0ElementType());
            	      				
            	    }
            	    otherlv_14=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_14);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1401:5: ( (lv_val7_15_0= RULE_ID ) )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==RULE_ID) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1402:6: (lv_val7_15_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1402:6: (lv_val7_15_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1403:7: lv_val7_15_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType());
            	              						
            	            }
            	            lv_val7_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1414:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    {
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1414:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1415:5: otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )?
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getLongAlternative_Kw8Keyword_2_7_0ElementType());
            	      				
            	    }
            	    otherlv_16=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_16);
            	      				
            	    }
            	    // PsiInternalSyntacticSequencerTestLanguage.g:1422:5: ( (lv_val8_17_0= RULE_ID ) )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_ID) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1423:6: (lv_val8_17_0= RULE_ID )
            	            {
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1423:6: (lv_val8_17_0= RULE_ID )
            	            // PsiInternalSyntacticSequencerTestLanguage.g:1424:7: lv_val8_17_0= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType());
            	              						
            	            }
            	            lv_val8_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return ;
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
            otherlv_18=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleLongAlternative"


    // $ANTLR start "entryRuleActionOnly"
    // PsiInternalSyntacticSequencerTestLanguage.g:1446:1: entryRuleActionOnly : ruleActionOnly EOF ;
    public final void entryRuleActionOnly() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1446:20: ( ruleActionOnly EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1447:2: ruleActionOnly EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getActionOnlyElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleActionOnly();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActionOnly"


    // $ANTLR start "ruleActionOnly"
    // PsiInternalSyntacticSequencerTestLanguage.g:1452:1: ruleActionOnly : (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) ;
    public final void ruleActionOnly() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_4=null;
        Token this_ID_5=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1452:15: ( (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1453:2: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1453:2: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            // PsiInternalSyntacticSequencerTestLanguage.g:1454:3: otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getActionOnly_NumberSignDigitOneDigitFourKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_28); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1461:3: (otherlv_1= 'kw1' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1462:4: otherlv_1= 'kw1'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_Kw1Keyword_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_29); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1470:3: ( ( RULE_ID )=>this_ID_2= RULE_ID )?
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
                    // PsiInternalSyntacticSequencerTestLanguage.g:1471:4: ( RULE_ID )=>this_ID_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_IDTerminalRuleCall_2ElementType());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_ID_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1480:3: ()
            // PsiInternalSyntacticSequencerTestLanguage.g:1481:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getActionOnly_ActionOnlyAction_3ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1486:3: (otherlv_4= 'kw2' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1487:4: otherlv_4= 'kw2'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_Kw2Keyword_4ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_25); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalSyntacticSequencerTestLanguage.g:1495:3: (this_ID_5= RULE_ID )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalSyntacticSequencerTestLanguage.g:1496:4: this_ID_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getActionOnly_IDTerminalRuleCall_5ElementType());
                      			
                    }
                    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleActionOnly"


    // $ANTLR start "entryRuleFragmentCaller"
    // PsiInternalSyntacticSequencerTestLanguage.g:1508:1: entryRuleFragmentCaller : ruleFragmentCaller EOF ;
    public final void entryRuleFragmentCaller() throws RecognitionException {
        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1508:24: ( ruleFragmentCaller EOF )
            // PsiInternalSyntacticSequencerTestLanguage.g:1509:2: ruleFragmentCaller EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFragmentCallerElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFragmentCaller();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFragmentCaller"


    // $ANTLR start "ruleFragmentCaller"
    // PsiInternalSyntacticSequencerTestLanguage.g:1514:1: ruleFragmentCaller : (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) ruleFragment1 ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final void ruleFragmentCaller() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val_3_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1514:19: ( (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) ruleFragment1 ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1515:2: (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) ruleFragment1 ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1515:2: (otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) ruleFragment1 ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1516:3: otherlv_0= '#15' ( (lv_val1_1_0= RULE_ID ) ) ruleFragment1 ( (lv_val_3_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFragmentCaller_NumberSignDigitOneDigitFiveKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1523:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1524:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1524:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1525:5: lv_val1_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFragmentCaller_Val1IDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_val1_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getFragmentCaller_Fragment1ParserRuleCall_2ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_3);
            ruleFragment1();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalSyntacticSequencerTestLanguage.g:1541:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1542:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1542:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1543:5: lv_val_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFragmentCaller_ValIDTerminalRuleCall_3_0ElementType());
              				
            }
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleFragmentCaller"


    // $ANTLR start "ruleFragment1"
    // PsiInternalSyntacticSequencerTestLanguage.g:1557:1: ruleFragment1 : ( (lv_fragVal_0_0= RULE_ID ) ) ;
    public final void ruleFragment1() throws RecognitionException {
        Token lv_fragVal_0_0=null;

        try {
            // PsiInternalSyntacticSequencerTestLanguage.g:1557:14: ( ( (lv_fragVal_0_0= RULE_ID ) ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1558:2: ( (lv_fragVal_0_0= RULE_ID ) )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1558:2: ( (lv_fragVal_0_0= RULE_ID ) )
            // PsiInternalSyntacticSequencerTestLanguage.g:1559:3: (lv_fragVal_0_0= RULE_ID )
            {
            // PsiInternalSyntacticSequencerTestLanguage.g:1559:3: (lv_fragVal_0_0= RULE_ID )
            // PsiInternalSyntacticSequencerTestLanguage.g:1560:4: lv_fragVal_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getFragment1_FragValIDTerminalRuleCall_0ElementType());
              			
            }
            lv_fragVal_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleFragment1"

    // $ANTLR start synpred1_PsiInternalSyntacticSequencerTestLanguage
    public final void synpred1_PsiInternalSyntacticSequencerTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSyntacticSequencerTestLanguage.g:1471:4: ( RULE_ID )
        // PsiInternalSyntacticSequencerTestLanguage.g:1471:5: RULE_ID
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