package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSyntacticSequencerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINAL_ID", "RULE_INT", "RULE_BOOLEAN_TERMINAL_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'", "'#7'", "'matched'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'kw5'", "'kw6'", "'kw7'", "'kw8'", "'!'"
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g"; }



    private SyntacticSequencerTestLanguageGrammarAccess grammarAccess;

    private SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalSyntacticSequencerTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider, SyntacticSequencerTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:50:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:58:1: ruleModel : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:58:10: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) )
            int alt1=13;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:60:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:60:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:61:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:61:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:62:5: lv_x1_0_0= ruleMandatoryKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_ruleModel96);
                    ruleMandatoryKeywords();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:72:3: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:72:3: ( (lv_x2_1_0= ruleExp0 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:73:4: (lv_x2_1_0= ruleExp0 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:73:4: (lv_x2_1_0= ruleExp0 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:74:5: lv_x2_1_0= ruleExp0
                    {

                    					markComposite(elementTypeProvider.getModel_X2Exp0ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp0_in_ruleModel142);
                    ruleExp0();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:84:3: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:84:3: ( (lv_x3_2_0= ruleExp1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:85:4: (lv_x3_2_0= ruleExp1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:85:4: (lv_x3_2_0= ruleExp1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:86:5: lv_x3_2_0= ruleExp1
                    {

                    					markComposite(elementTypeProvider.getModel_X3Exp1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp1_in_ruleModel188);
                    ruleExp1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:96:3: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:96:3: ( (lv_x4_3_0= ruleExp2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:97:4: (lv_x4_3_0= ruleExp2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:97:4: (lv_x4_3_0= ruleExp2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:98:5: lv_x4_3_0= ruleExp2
                    {

                    					markComposite(elementTypeProvider.getModel_X4Exp2ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp2_in_ruleModel234);
                    ruleExp2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:108:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:108:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:109:4: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:109:4: (lv_x5_4_0= ruleSingleCrossReference )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:110:5: lv_x5_4_0= ruleSingleCrossReference
                    {

                    					markComposite(elementTypeProvider.getModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_ruleModel280);
                    ruleSingleCrossReference();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:120:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:120:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:121:4: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:121:4: (lv_x6_5_0= ruleBooleanAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:122:5: lv_x6_5_0= ruleBooleanAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X6BooleanAlternativeParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_ruleModel326);
                    ruleBooleanAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:132:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:132:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:133:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:133:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:134:5: lv_x7_6_0= ruleUnassignedDatatype
                    {

                    					markComposite(elementTypeProvider.getModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_ruleModel372);
                    ruleUnassignedDatatype();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:144:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:144:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:145:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:145:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:146:5: lv_x8_7_0= ruleOptionalSingleTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_ruleModel418);
                    ruleOptionalSingleTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:156:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:156:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:157:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:157:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:158:5: lv_x9_8_0= ruleOptionalManyTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_ruleModel464);
                    ruleOptionalManyTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:168:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:168:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:169:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:169:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:170:5: lv_x10_9_0= ruleMandatoryManyTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_ruleModel510);
                    ruleMandatoryManyTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:180:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:180:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:181:4: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:181:4: (lv_x11_10_0= ruleAlternativeTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:182:5: lv_x11_10_0= ruleAlternativeTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X11AlternativeTransitionParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_ruleModel556);
                    ruleAlternativeTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:192:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:192:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:193:4: (lv_x12_11_0= ruleBooleanValues )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:193:4: (lv_x12_11_0= ruleBooleanValues )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:194:5: lv_x12_11_0= ruleBooleanValues
                    {

                    					markComposite(elementTypeProvider.getModel_X12BooleanValuesParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanValues_in_ruleModel602);
                    ruleBooleanValues();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:204:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:204:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:205:4: (lv_x13_12_0= ruleLongAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:205:4: (lv_x13_12_0= ruleLongAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:206:5: lv_x13_12_0= ruleLongAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X13LongAlternativeParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleLongAlternative_in_ruleModel648);
                    ruleLongAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:219:1: entryRuleMandatoryKeywords : ruleMandatoryKeywords EOF ;
    public final void entryRuleMandatoryKeywords() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:219:27: ( ruleMandatoryKeywords EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:220:2: ruleMandatoryKeywords EOF
            {
             markComposite(elementTypeProvider.getMandatoryKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords679);
            ruleMandatoryKeywords();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryKeywords685); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:228:1: ruleMandatoryKeywords : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:228:22: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:229:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:229:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:230:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMandatoryKeywords708); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:237:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:238:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:238:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:239:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords735); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMandatoryKeywords760); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMandatoryKeywords_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:255:3: ( (lv_val2_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:256:4: (lv_val2_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:256:4: (lv_val2_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:257:5: lv_val2_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords787); 

            					doneLeaf(lv_val2_3_0, elementTypeProvider.getMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryKeywords812); 

            			doneLeaf(otherlv_4, elementTypeProvider.getMandatoryKeywords_Kw2Keyword_4ElementType());
            		

            			markLeaf();
            		
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryKeywords826); 

            			doneLeaf(otherlv_5, elementTypeProvider.getMandatoryKeywords_Kw3Keyword_5ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:280:3: ( (lv_val3_6_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:281:4: (lv_val3_6_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:281:4: (lv_val3_6_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:282:5: lv_val3_6_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords853); 

            					doneLeaf(lv_val3_6_0, elementTypeProvider.getMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryKeywords878); 

            			doneLeaf(otherlv_7, elementTypeProvider.getMandatoryKeywords_Kw4Keyword_7ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:302:1: entryRuleExp0 : ruleExp0 EOF ;
    public final void entryRuleExp0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:302:14: ( ruleExp0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:303:2: ruleExp0 EOF
            {
             markComposite(elementTypeProvider.getExp0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp0_in_entryRuleExp0898);
            ruleExp0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp0904); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:311:1: ruleExp0 : (otherlv_0= '#2' ruleAddition0 ) ;
    public final void ruleExp0() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:311:9: ( (otherlv_0= '#2' ruleAddition0 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:312:2: (otherlv_0= '#2' ruleAddition0 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:312:2: (otherlv_0= '#2' ruleAddition0 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:313:3: otherlv_0= '#2' ruleAddition0
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleExp0927); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp0_NumberSignDigitTwoKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp0_Addition0ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_ruleExp0939);
            ruleAddition0();

            state._fsp--;


            			doneComposite();
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:331:1: entryRuleAddition0 : ruleAddition0 EOF ;
    public final void entryRuleAddition0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:331:19: ( ruleAddition0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:332:2: ruleAddition0 EOF
            {
             markComposite(elementTypeProvider.getAddition0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_entryRuleAddition0959);
            ruleAddition0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition0965); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:340:1: ruleAddition0 : ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final void ruleAddition0() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:340:14: ( ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:341:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:341:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:342:3: rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition0_Prim0ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0986);
            rulePrim0();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:349:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:350:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:350:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:351:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition0_Add0LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition01022); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition0_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:363:4: ( (lv_right_3_0= rulePrim0 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:364:5: (lv_right_3_0= rulePrim0 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:364:5: (lv_right_3_0= rulePrim0 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:365:6: lv_right_3_0= rulePrim0
            	    {

            	    						markComposite(elementTypeProvider.getAddition0_RightPrim0ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition01054);
            	    rulePrim0();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:379:1: entryRulePrim0 : rulePrim0 EOF ;
    public final void entryRulePrim0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:379:15: ( rulePrim0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:380:2: rulePrim0 EOF
            {
             markComposite(elementTypeProvider.getPrim0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_entryRulePrim01093);
            rulePrim0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim01099); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:388:1: rulePrim0 : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void rulePrim0() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:388:10: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:389:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:389:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:390:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:390:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:391:4: 
            {

            				precedeComposite(elementTypeProvider.getPrim0_Val0Action_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:396:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:397:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:397:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:398:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim01148); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getPrim0_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:411:1: entryRuleExp1 : ruleExp1 EOF ;
    public final void entryRuleExp1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:411:14: ( ruleExp1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:412:2: ruleExp1 EOF
            {
             markComposite(elementTypeProvider.getExp1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp1_in_entryRuleExp11179);
            ruleExp1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp11185); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:420:1: ruleExp1 : (otherlv_0= '#3' ruleAddition1 ) ;
    public final void ruleExp1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:420:9: ( (otherlv_0= '#3' ruleAddition1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:421:2: (otherlv_0= '#3' ruleAddition1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:421:2: (otherlv_0= '#3' ruleAddition1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:422:3: otherlv_0= '#3' ruleAddition1
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleExp11208); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp1_NumberSignDigitThreeKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp1_Addition1ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_ruleExp11220);
            ruleAddition1();

            state._fsp--;


            			doneComposite();
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:440:1: entryRuleAddition1 : ruleAddition1 EOF ;
    public final void entryRuleAddition1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:440:19: ( ruleAddition1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:441:2: ruleAddition1 EOF
            {
             markComposite(elementTypeProvider.getAddition1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_entryRuleAddition11240);
            ruleAddition1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition11246); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:449:1: ruleAddition1 : ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final void ruleAddition1() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:449:14: ( ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:450:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:450:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:451:3: rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition1_Prim1ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11267);
            rulePrim1();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:458:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:459:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:459:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:460:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition1_Add1LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition11303); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition1_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:472:4: ( (lv_right_3_0= rulePrim1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:473:5: (lv_right_3_0= rulePrim1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:473:5: (lv_right_3_0= rulePrim1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:474:6: lv_right_3_0= rulePrim1
            	    {

            	    						markComposite(elementTypeProvider.getAddition1_RightPrim1ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11335);
            	    rulePrim1();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:488:1: entryRulePrim1 : rulePrim1 EOF ;
    public final void entryRulePrim1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:488:15: ( rulePrim1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:489:2: rulePrim1 EOF
            {
             markComposite(elementTypeProvider.getPrim1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_entryRulePrim11374);
            rulePrim1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim11380); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:497:1: rulePrim1 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) ;
    public final void rulePrim1() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:497:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:498:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:498:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:499:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:499:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:500:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:500:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:501:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim1_Val1Action_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:506:4: ( (lv_name_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:507:5: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:507:5: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:508:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim11440); 

                    						doneLeaf(lv_name_1_0, elementTypeProvider.getPrim1_NameIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:519:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:519:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:520:4: otherlv_2= '(' ruleAddition1 otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim11486); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getPrim1_LeftParenthesisKeyword_1_0ElementType());
                    			

                    				markComposite(elementTypeProvider.getPrim1_Addition1ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_rulePrim11501);
                    ruleAddition1();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrim11518); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getPrim1_RightParenthesisKeyword_1_2ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:546:1: entryRuleExp2 : ruleExp2 EOF ;
    public final void entryRuleExp2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:546:14: ( ruleExp2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:547:2: ruleExp2 EOF
            {
             markComposite(elementTypeProvider.getExp2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp2_in_entryRuleExp21543);
            ruleExp2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp21549); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:555:1: ruleExp2 : (otherlv_0= '#4' ruleAddition2 ) ;
    public final void ruleExp2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:555:9: ( (otherlv_0= '#4' ruleAddition2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:556:2: (otherlv_0= '#4' ruleAddition2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:556:2: (otherlv_0= '#4' ruleAddition2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:557:3: otherlv_0= '#4' ruleAddition2
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleExp21572); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp2_NumberSignDigitFourKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp2_Addition2ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_ruleExp21584);
            ruleAddition2();

            state._fsp--;


            			doneComposite();
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:575:1: entryRuleAddition2 : ruleAddition2 EOF ;
    public final void entryRuleAddition2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:575:19: ( ruleAddition2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:576:2: ruleAddition2 EOF
            {
             markComposite(elementTypeProvider.getAddition2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_entryRuleAddition21604);
            ruleAddition2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition21610); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:584:1: ruleAddition2 : ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final void ruleAddition2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:584:14: ( ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:585:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:585:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:586:3: ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition2_Multiplication2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21631);
            ruleMultiplication2();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:593:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:594:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:594:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:595:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition2_Add2LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition21667); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition2_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:607:4: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:608:5: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:608:5: (lv_right_3_0= ruleMultiplication2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:609:6: lv_right_3_0= ruleMultiplication2
            	    {

            	    						markComposite(elementTypeProvider.getAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21699);
            	    ruleMultiplication2();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:623:1: entryRuleMultiplication2 : ruleMultiplication2 EOF ;
    public final void entryRuleMultiplication2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:623:25: ( ruleMultiplication2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:624:2: ruleMultiplication2 EOF
            {
             markComposite(elementTypeProvider.getMultiplication2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21738);
            ruleMultiplication2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication21744); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:632:1: ruleMultiplication2 : ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final void ruleMultiplication2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:632:20: ( ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:633:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:633:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:634:3: rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {

            			markComposite(elementTypeProvider.getMultiplication2_Prim2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21765);
            rulePrim2();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:641:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:642:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:642:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:643:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMultiplication2_Mult2LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiplication21801); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getMultiplication2_AsteriskKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:655:4: ( (lv_right_3_0= rulePrim2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:656:5: (lv_right_3_0= rulePrim2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:656:5: (lv_right_3_0= rulePrim2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:657:6: lv_right_3_0= rulePrim2
            	    {

            	    						markComposite(elementTypeProvider.getMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21833);
            	    rulePrim2();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:671:1: entryRulePrim2 : rulePrim2 EOF ;
    public final void entryRulePrim2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:671:15: ( rulePrim2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:672:2: rulePrim2 EOF
            {
             markComposite(elementTypeProvider.getPrim2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_entryRulePrim21872);
            rulePrim2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim21878); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:680:1: rulePrim2 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) ;
    public final void rulePrim2() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:680:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:681:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:681:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:682:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:682:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:683:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:683:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:684:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim2_Val2Action_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:689:4: ( (lv_name_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:690:5: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:690:5: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:691:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim21938); 

                    						doneLeaf(lv_name_1_0, elementTypeProvider.getPrim2_NameIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:702:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:702:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:703:4: otherlv_2= '(' ruleAddition2 otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim21984); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getPrim2_LeftParenthesisKeyword_1_0ElementType());
                    			

                    				markComposite(elementTypeProvider.getPrim2_Addition2ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_rulePrim21999);
                    ruleAddition2();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrim22016); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getPrim2_RightParenthesisKeyword_1_2ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:729:1: entryRuleDatatypeID : ruleDatatypeID EOF ;
    public final void entryRuleDatatypeID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:729:20: ( ruleDatatypeID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:730:2: ruleDatatypeID EOF
            {
             markComposite(elementTypeProvider.getDatatypeIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID2041);
            ruleDatatypeID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeID2047); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:738:1: ruleDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:738:15: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:739:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatypeID2065); 

            		doneLeaf(this_ID_0, elementTypeProvider.getDatatypeID_IDTerminalRuleCallElementType());
            	

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:749:1: entryRuleSingleCrossReference : ruleSingleCrossReference EOF ;
    public final void entryRuleSingleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:749:30: ( ruleSingleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:750:2: ruleSingleCrossReference EOF
            {
             markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2081);
            ruleSingleCrossReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference2087); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:758:1: ruleSingleCrossReference : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:758:25: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:759:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:759:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:760:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSingleCrossReference2110); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:767:3: ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:768:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:768:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:769:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:769:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_TERMINAL_ID) ) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:770:6: lv_name_1_1= RULE_TERMINAL_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_1=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2145); 

                    						doneLeaf(lv_name_1_1, elementTypeProvider.getSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:778:6: lv_name_1_2= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2179); 

                    						doneLeaf(lv_name_1_2, elementTypeProvider.getSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:788:3: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:789:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleCrossReference2217); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getSingleCrossReference_Kw1Keyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:796:4: ( (otherlv_3= RULE_TERMINAL_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:797:5: (otherlv_3= RULE_TERMINAL_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:797:5: (otherlv_3= RULE_TERMINAL_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:798:6: otherlv_3= RULE_TERMINAL_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2249); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:808:3: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:809:4: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleCrossReference2288); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getSingleCrossReference_Kw2Keyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:816:4: ( ( ruleDatatypeID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:817:5: ( ruleDatatypeID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:817:5: ( ruleDatatypeID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:818:6: ruleDatatypeID
                    {

                    						markComposite(elementTypeProvider.getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2318);
                    ruleDatatypeID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:828:3: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:829:4: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleCrossReference2357); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getSingleCrossReference_Kw3Keyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:836:4: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:837:5: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:837:5: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:838:6: otherlv_7= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2389); 

                    						doneLeaf(otherlv_7, elementTypeProvider.getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:848:3: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:849:4: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleCrossReference2428); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getSingleCrossReference_Kw4Keyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:856:4: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:857:5: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:857:5: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:858:6: otherlv_9= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2460); 

                    						doneLeaf(otherlv_9, elementTypeProvider.getSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:872:1: entryRuleBooleanAlternative : ruleBooleanAlternative EOF ;
    public final void entryRuleBooleanAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:872:28: ( ruleBooleanAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:873:2: ruleBooleanAlternative EOF
            {
             markComposite(elementTypeProvider.getBooleanAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2499);
            ruleBooleanAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternative2505); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:881:1: ruleBooleanAlternative : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final void ruleBooleanAlternative() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:881:23: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:882:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:882:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:883:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBooleanAlternative2528); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBooleanAlternative_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:890:3: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:891:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:891:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:892:5: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {

            					markComposite(elementTypeProvider.getBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2555);
            ruleBooleanAlternativeLiteral();

            state._fsp--;


            					doneComposite();
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:905:1: entryRuleBooleanAlternativeLiteral : ruleBooleanAlternativeLiteral EOF ;
    public final void entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:905:35: ( ruleBooleanAlternativeLiteral EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:906:2: ruleBooleanAlternativeLiteral EOF
            {
             markComposite(elementTypeProvider.getBooleanAlternativeLiteralElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2586);
            ruleBooleanAlternativeLiteral();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2592); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:914:1: ruleBooleanAlternativeLiteral : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final void ruleBooleanAlternativeLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:914:30: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:915:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:915:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:916:3: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:916:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:917:4: 
            {

            				precedeComposite(elementTypeProvider.getBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:922:3: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:923:4: otherlv_1= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanAlternativeLiteral2634); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:931:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:931:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:932:5: (lv_isTrue_2_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:932:5: (lv_isTrue_2_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:933:6: lv_isTrue_2_0= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_isTrue_2_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBooleanAlternativeLiteral2675); 

                    						doneLeaf(lv_isTrue_2_0, elementTypeProvider.getBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:947:1: entryRuleUnassignedDatatype : ruleUnassignedDatatype EOF ;
    public final void entryRuleUnassignedDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:947:28: ( ruleUnassignedDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:948:2: ruleUnassignedDatatype EOF
            {
             markComposite(elementTypeProvider.getUnassignedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2713);
            ruleUnassignedDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedDatatype2719); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:956:1: ruleUnassignedDatatype : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final void ruleUnassignedDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:956:23: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:957:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:957:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:958:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedDatatype2742); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:965:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:966:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:966:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:967:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedDatatype2769); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getUnassignedDatatype_KW1ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleUnassignedDatatype2792);
            ruleKW1();

            state._fsp--;


            			doneComposite();
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:987:1: entryRuleKW1 : ruleKW1 EOF ;
    public final void entryRuleKW1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:987:13: ( ruleKW1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:988:2: ruleKW1 EOF
            {
             markComposite(elementTypeProvider.getKW1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_entryRuleKW12812);
            ruleKW1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKW12818); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:996:1: ruleKW1 : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final void ruleKW1() throws RecognitionException {
        Token kw=null;
        Token this_INT_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:996:8: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:997:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:997:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:998:3: kw= 'kw1'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKW12841); 

                    			doneLeaf(kw, elementTypeProvider.getKW1_Kw1Keyword_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1006:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1006:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1007:4: kw= 'matched' (this_INT_2= RULE_INT )?
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleKW12869); 

                    				doneLeaf(kw, elementTypeProvider.getKW1_MatchedKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1014:4: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1015:5: this_INT_2= RULE_INT
                            {

                            					markLeaf();
                            				
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleKW12893); 

                            					doneLeaf(this_INT_2, elementTypeProvider.getKW1_INTTerminalRuleCall_1_1ElementType());
                            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1028:1: entryRuleOptionalSingleTransition : ruleOptionalSingleTransition EOF ;
    public final void entryRuleOptionalSingleTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1028:34: ( ruleOptionalSingleTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1029:2: ruleOptionalSingleTransition EOF
            {
             markComposite(elementTypeProvider.getOptionalSingleTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2925);
            ruleOptionalSingleTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalSingleTransition2931); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1037:1: ruleOptionalSingleTransition : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalSingleTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1037:29: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1038:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1038:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1039:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleOptionalSingleTransition2954); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1046:3: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1047:4: ruleKW1
                    {

                    				markComposite(elementTypeProvider.getOptionalSingleTransition_KW1ParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2972);
                    ruleKW1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1055:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1056:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1056:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1057:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalSingleTransition3005); 

            					doneLeaf(lv_val_2_0, elementTypeProvider.getOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1070:1: entryRuleOptionalManyTransition : ruleOptionalManyTransition EOF ;
    public final void entryRuleOptionalManyTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1070:32: ( ruleOptionalManyTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1071:2: ruleOptionalManyTransition EOF
            {
             markComposite(elementTypeProvider.getOptionalManyTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition3036);
            ruleOptionalManyTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalManyTransition3042); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1079:1: ruleOptionalManyTransition : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1079:27: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1080:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1080:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1081:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleOptionalManyTransition3065); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1088:3: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1089:4: ruleKW1
            	    {

            	    				markComposite(elementTypeProvider.getOptionalManyTransition_KW1ParserRuleCall_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalManyTransition3083);
            	    ruleKW1();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1097:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1098:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1098:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1099:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalManyTransition3116); 

            					doneLeaf(lv_val_2_0, elementTypeProvider.getOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1112:1: entryRuleMandatoryManyTransition : ruleMandatoryManyTransition EOF ;
    public final void entryRuleMandatoryManyTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1112:33: ( ruleMandatoryManyTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1113:2: ruleMandatoryManyTransition EOF
            {
             markComposite(elementTypeProvider.getMandatoryManyTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3147);
            ruleMandatoryManyTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryManyTransition3153); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1121:1: ruleMandatoryManyTransition : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleMandatoryManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1121:28: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1122:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1122:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1123:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMandatoryManyTransition3176); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1130:3: ( ruleKW1 )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1131:4: ruleKW1
            	    {

            	    				markComposite(elementTypeProvider.getMandatoryManyTransition_KW1ParserRuleCall_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3194);
            	    ruleKW1();

            	    state._fsp--;


            	    				doneComposite();
            	    			

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1139:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1140:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1140:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1141:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3227); 

            					doneLeaf(lv_val_2_0, elementTypeProvider.getMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1154:1: entryRuleAlternativeTransition : ruleAlternativeTransition EOF ;
    public final void entryRuleAlternativeTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1154:31: ( ruleAlternativeTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1155:2: ruleAlternativeTransition EOF
            {
             markComposite(elementTypeProvider.getAlternativeTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3258);
            ruleAlternativeTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeTransition3264); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1163:1: ruleAlternativeTransition : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final void ruleAlternativeTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1163:26: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1164:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1164:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1165:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAlternativeTransition3287); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1172:3: ( ruleKW1 | otherlv_2= 'kw2' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14||LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==15) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1173:4: ruleKW1
                    {

                    				markComposite(elementTypeProvider.getAlternativeTransition_KW1ParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleAlternativeTransition3305);
                    ruleKW1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1181:4: otherlv_2= 'kw2'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAlternativeTransition3331); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getAlternativeTransition_Kw2Keyword_1_1ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1189:3: ( (lv_val_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1190:4: (lv_val_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1190:4: (lv_val_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1191:5: lv_val_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeTransition3363); 

            					doneLeaf(lv_val_3_0, elementTypeProvider.getAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1204:1: entryRuleBooleanDatatypeID : ruleBooleanDatatypeID EOF ;
    public final void entryRuleBooleanDatatypeID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1204:27: ( ruleBooleanDatatypeID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1205:2: ruleBooleanDatatypeID EOF
            {
             markComposite(elementTypeProvider.getBooleanDatatypeIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanDatatypeID_in_entryRuleBooleanDatatypeID3394);
            ruleBooleanDatatypeID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanDatatypeID3400); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1213:1: ruleBooleanDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleBooleanDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1213:22: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1214:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanDatatypeID3418); 

            		doneLeaf(this_ID_0, elementTypeProvider.getBooleanDatatypeID_IDTerminalRuleCallElementType());
            	

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1224:1: entryRuleBooleanValues : ruleBooleanValues EOF ;
    public final void entryRuleBooleanValues() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1224:23: ( ruleBooleanValues EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1225:2: ruleBooleanValues EOF
            {
             markComposite(elementTypeProvider.getBooleanValuesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanValues_in_entryRuleBooleanValues3434);
            ruleBooleanValues();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanValues3440); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1233:1: ruleBooleanValues : ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) ;
    public final void ruleBooleanValues() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1233:18: ( ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1234:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1234:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1235:3: () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1235:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1236:4: 
            {

            				precedeComposite(elementTypeProvider.getBooleanValues_BooleanValuesAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleBooleanValues3476); 

            			doneLeaf(otherlv_1, elementTypeProvider.getBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1248:3: ( (lv_val1_2_0= 'kw1' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1249:4: (lv_val1_2_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1249:4: (lv_val1_2_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1250:5: lv_val1_2_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_val1_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanValues3503); 

                    					doneLeaf(lv_val1_2_0, elementTypeProvider.getBooleanValues_Val1Kw1Keyword_2_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1259:3: ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BOOLEAN_TERMINAL_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1260:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1260:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1261:5: lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_BOOLEAN_TERMINAL_ID,FollowSets000.FOLLOW_RULE_BOOLEAN_TERMINAL_ID_in_ruleBooleanValues3542); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1270:3: ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1271:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1271:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1272:5: lv_val3_4_0= ruleBooleanDatatypeID
                    {

                    					markComposite(elementTypeProvider.getBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanDatatypeID_in_ruleBooleanValues3581);
                    ruleBooleanDatatypeID();

                    state._fsp--;


                    					doneComposite();
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1285:1: entryRuleLongAlternative : ruleLongAlternative EOF ;
    public final void entryRuleLongAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1285:25: ( ruleLongAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1286:2: ruleLongAlternative EOF
            {
             markComposite(elementTypeProvider.getLongAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLongAlternative_in_entryRuleLongAlternative3613);
            ruleLongAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLongAlternative3619); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1294:1: ruleLongAlternative : (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1294:20: ( (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1295:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1295:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1296:3: otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLongAlternative3642); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1303:3: ( (lv_foo_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1304:4: (lv_foo_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1304:4: (lv_foo_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1305:5: lv_foo_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3669); 

            					doneLeaf(lv_foo_1_0, elementTypeProvider.getLongAlternative_FooIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1314:3: ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1315:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1315:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1316:5: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLongAlternative3707); 

            	    					doneLeaf(otherlv_2, elementTypeProvider.getLongAlternative_Kw1Keyword_2_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1323:5: ( (lv_val1_3_0= RULE_ID ) )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_ID) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1324:6: (lv_val1_3_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1324:6: (lv_val1_3_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1325:7: lv_val1_3_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3744); 

            	            							doneLeaf(lv_val1_3_0, elementTypeProvider.getLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1336:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1336:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1337:5: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLongAlternative3799); 

            	    					doneLeaf(otherlv_4, elementTypeProvider.getLongAlternative_Kw2Keyword_2_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1344:5: ( (lv_val2_5_0= RULE_ID ) )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_ID) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1345:6: (lv_val2_5_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1345:6: (lv_val2_5_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1346:7: lv_val2_5_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3836); 

            	            							doneLeaf(lv_val2_5_0, elementTypeProvider.getLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1357:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1357:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1358:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLongAlternative3891); 

            	    					doneLeaf(otherlv_6, elementTypeProvider.getLongAlternative_Kw3Keyword_2_2_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1365:5: ( (lv_val3_7_0= RULE_ID ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==RULE_ID) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1366:6: (lv_val3_7_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1366:6: (lv_val3_7_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1367:7: lv_val3_7_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3928); 

            	            							doneLeaf(lv_val3_7_0, elementTypeProvider.getLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1378:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1378:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1379:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLongAlternative3983); 

            	    					doneLeaf(otherlv_8, elementTypeProvider.getLongAlternative_Kw4Keyword_2_3_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1386:5: ( (lv_val4_9_0= RULE_ID ) )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_ID) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1387:6: (lv_val4_9_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1387:6: (lv_val4_9_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1388:7: lv_val4_9_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4020); 

            	            							doneLeaf(lv_val4_9_0, elementTypeProvider.getLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1399:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1399:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1400:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLongAlternative4075); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getLongAlternative_Kw5Keyword_2_4_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1407:5: ( (lv_val5_11_0= RULE_ID ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1408:6: (lv_val5_11_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1408:6: (lv_val5_11_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1409:7: lv_val5_11_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4112); 

            	            							doneLeaf(lv_val5_11_0, elementTypeProvider.getLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1420:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1420:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1421:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_12=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLongAlternative4167); 

            	    					doneLeaf(otherlv_12, elementTypeProvider.getLongAlternative_Kw6Keyword_2_5_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1428:5: ( (lv_val6_13_0= RULE_ID ) )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1429:6: (lv_val6_13_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1429:6: (lv_val6_13_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1430:7: lv_val6_13_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4204); 

            	            							doneLeaf(lv_val6_13_0, elementTypeProvider.getLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1441:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1441:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1442:5: otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_14=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLongAlternative4259); 

            	    					doneLeaf(otherlv_14, elementTypeProvider.getLongAlternative_Kw7Keyword_2_6_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1449:5: ( (lv_val7_15_0= RULE_ID ) )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==RULE_ID) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1450:6: (lv_val7_15_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1450:6: (lv_val7_15_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1451:7: lv_val7_15_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val7_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4296); 

            	            							doneLeaf(lv_val7_15_0, elementTypeProvider.getLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1462:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1462:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1463:5: otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_16=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLongAlternative4351); 

            	    					doneLeaf(otherlv_16, elementTypeProvider.getLongAlternative_Kw8Keyword_2_7_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1470:5: ( (lv_val8_17_0= RULE_ID ) )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_ID) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1471:6: (lv_val8_17_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1471:6: (lv_val8_17_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1472:7: lv_val8_17_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val8_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4388); 

            	            							doneLeaf(lv_val8_17_0, elementTypeProvider.getLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType());
            	            						

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


            			markLeaf();
            		
            otherlv_18=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLongAlternative4430); 

            			doneLeaf(otherlv_18, elementTypeProvider.getLongAlternative_ExclamationMarkKeyword_3ElementType());
            		

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_ruleModel96 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_ruleModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_ruleModel234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_ruleModel280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_ruleModel326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_ruleModel372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_ruleModel418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_ruleModel464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_ruleModel510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_ruleModel556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValues_in_ruleModel602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongAlternative_in_ruleModel648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryKeywords685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleMandatoryKeywords708 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords735 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMandatoryKeywords760 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords787 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryKeywords812 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryKeywords826 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords853 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryKeywords878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_entryRuleExp0898 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp0904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleExp0927 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAddition0_in_ruleExp0939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition0_in_entryRuleAddition0959 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition0965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0986 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition01022 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition01054 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrim0_in_entryRulePrim01093 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim01099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim01148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_entryRuleExp11179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp11185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleExp11208 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition1_in_ruleExp11220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition1_in_entryRuleAddition11240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition11246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11267 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition11303 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11335 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrim1_in_entryRulePrim11374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim11380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim11440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rulePrim11486 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition1_in_rulePrim11501 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrim11518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_entryRuleExp21543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp21549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleExp21572 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition2_in_ruleExp21584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition2_in_entryRuleAddition21604 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition21610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21631 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition21667 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21699 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21738 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication21744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21765 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleMultiplication21801 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21833 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rulePrim2_in_entryRulePrim21872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim21878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim21938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rulePrim21984 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition2_in_rulePrim21999 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrim22016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID2041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeID2047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatypeID2065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference2087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleSingleCrossReference2110 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2145 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2179 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14_in_ruleSingleCrossReference2217 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2249 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_15_in_ruleSingleCrossReference2288 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2318 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleSingleCrossReference2357 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2389 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleSingleCrossReference2428 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2499 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternative2505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleBooleanAlternative2528 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2586 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleBooleanAlternativeLiteral2634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleBooleanAlternativeLiteral2675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedDatatype2719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedDatatype2742 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedDatatype2769 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleUnassignedDatatype2792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKW1_in_entryRuleKW12812 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKW12818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleKW12841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleKW12869 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleKW12893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2925 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalSingleTransition2931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleOptionalSingleTransition2954 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalSingleTransition3005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition3036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalManyTransition3042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleOptionalManyTransition3065 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalManyTransition3083 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalManyTransition3116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryManyTransition3153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleMandatoryManyTransition3176 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3194 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeTransition3264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleAlternativeTransition3287 = new BitSet(new long[]{0x000000001000C000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleAlternativeTransition3305 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15_in_ruleAlternativeTransition3331 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeTransition3363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanDatatypeID_in_entryRuleBooleanDatatypeID3394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanDatatypeID3400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanDatatypeID3418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValues_in_entryRuleBooleanValues3434 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValues3440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleBooleanValues3476 = new BitSet(new long[]{0x0000000000004092L});
        public static final BitSet FOLLOW_14_in_ruleBooleanValues3503 = new BitSet(new long[]{0x0000000000000092L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_TERMINAL_ID_in_ruleBooleanValues3542 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleBooleanDatatypeID_in_ruleBooleanValues3581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongAlternative_in_entryRuleLongAlternative3613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLongAlternative3619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleLongAlternative3642 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3669 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_14_in_ruleLongAlternative3707 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3744 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_15_in_ruleLongAlternative3799 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3836 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_16_in_ruleLongAlternative3891 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3928 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_17_in_ruleLongAlternative3983 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4020 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_35_in_ruleLongAlternative4075 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4112 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_36_in_ruleLongAlternative4167 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4204 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_37_in_ruleLongAlternative4259 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4296 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_38_in_ruleLongAlternative4351 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4388 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_39_in_ruleLongAlternative4430 = new BitSet(new long[]{0x0000000000000002L});
    }


}