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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:59:1: ruleModel : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:59:10: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:61:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:61:3: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:62:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:62:4: (lv_x1_0_0= ruleMandatoryKeywords )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:63:5: lv_x1_0_0= ruleMandatoryKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_ruleModel92);
                    ruleMandatoryKeywords();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:73:3: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:73:3: ( (lv_x2_1_0= ruleExp0 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:74:4: (lv_x2_1_0= ruleExp0 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:74:4: (lv_x2_1_0= ruleExp0 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:75:5: lv_x2_1_0= ruleExp0
                    {

                    					markComposite(elementTypeProvider.getModel_X2Exp0ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp0_in_ruleModel138);
                    ruleExp0();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:85:3: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:85:3: ( (lv_x3_2_0= ruleExp1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:86:4: (lv_x3_2_0= ruleExp1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:86:4: (lv_x3_2_0= ruleExp1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:87:5: lv_x3_2_0= ruleExp1
                    {

                    					markComposite(elementTypeProvider.getModel_X3Exp1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp1_in_ruleModel184);
                    ruleExp1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:97:3: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:97:3: ( (lv_x4_3_0= ruleExp2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:98:4: (lv_x4_3_0= ruleExp2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:98:4: (lv_x4_3_0= ruleExp2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:99:5: lv_x4_3_0= ruleExp2
                    {

                    					markComposite(elementTypeProvider.getModel_X4Exp2ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExp2_in_ruleModel230);
                    ruleExp2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:109:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:109:3: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:110:4: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:110:4: (lv_x5_4_0= ruleSingleCrossReference )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:111:5: lv_x5_4_0= ruleSingleCrossReference
                    {

                    					markComposite(elementTypeProvider.getModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_ruleModel276);
                    ruleSingleCrossReference();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:121:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:121:3: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:122:4: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:122:4: (lv_x6_5_0= ruleBooleanAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:123:5: lv_x6_5_0= ruleBooleanAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X6BooleanAlternativeParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_ruleModel322);
                    ruleBooleanAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:133:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:133:3: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:134:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:134:4: (lv_x7_6_0= ruleUnassignedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:135:5: lv_x7_6_0= ruleUnassignedDatatype
                    {

                    					markComposite(elementTypeProvider.getModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_ruleModel368);
                    ruleUnassignedDatatype();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:145:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:145:3: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:146:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:146:4: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:147:5: lv_x8_7_0= ruleOptionalSingleTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_ruleModel414);
                    ruleOptionalSingleTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:157:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:157:3: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:158:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:158:4: (lv_x9_8_0= ruleOptionalManyTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:159:5: lv_x9_8_0= ruleOptionalManyTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_ruleModel460);
                    ruleOptionalManyTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:169:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:169:3: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:170:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:170:4: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:171:5: lv_x10_9_0= ruleMandatoryManyTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_ruleModel506);
                    ruleMandatoryManyTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:181:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:181:3: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:182:4: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:182:4: (lv_x11_10_0= ruleAlternativeTransition )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:183:5: lv_x11_10_0= ruleAlternativeTransition
                    {

                    					markComposite(elementTypeProvider.getModel_X11AlternativeTransitionParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_ruleModel552);
                    ruleAlternativeTransition();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:193:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:193:3: ( (lv_x12_11_0= ruleBooleanValues ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:194:4: (lv_x12_11_0= ruleBooleanValues )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:194:4: (lv_x12_11_0= ruleBooleanValues )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:195:5: lv_x12_11_0= ruleBooleanValues
                    {

                    					markComposite(elementTypeProvider.getModel_X12BooleanValuesParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanValues_in_ruleModel598);
                    ruleBooleanValues();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:205:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:205:3: ( (lv_x13_12_0= ruleLongAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:206:4: (lv_x13_12_0= ruleLongAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:206:4: (lv_x13_12_0= ruleLongAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:207:5: lv_x13_12_0= ruleLongAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X13LongAlternativeParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleLongAlternative_in_ruleModel644);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:220:1: entryRuleMandatoryKeywords : ruleMandatoryKeywords EOF ;
    public final void entryRuleMandatoryKeywords() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:220:27: ( ruleMandatoryKeywords EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:221:2: ruleMandatoryKeywords EOF
            {
             markComposite(elementTypeProvider.getMandatoryKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords675);
            ruleMandatoryKeywords();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryKeywords681); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:227:1: ruleMandatoryKeywords : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:227:22: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:228:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:228:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:229:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMandatoryKeywords700); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:236:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:237:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:237:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:238:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords727); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMandatoryKeywords752); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMandatoryKeywords_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:254:3: ( (lv_val2_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:255:4: (lv_val2_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:255:4: (lv_val2_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:256:5: lv_val2_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords779); 

            					doneLeaf(lv_val2_3_0, elementTypeProvider.getMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryKeywords804); 

            			doneLeaf(otherlv_4, elementTypeProvider.getMandatoryKeywords_Kw2Keyword_4ElementType());
            		

            			markLeaf();
            		
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryKeywords818); 

            			doneLeaf(otherlv_5, elementTypeProvider.getMandatoryKeywords_Kw3Keyword_5ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:279:3: ( (lv_val3_6_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:280:4: (lv_val3_6_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:280:4: (lv_val3_6_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:281:5: lv_val3_6_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryKeywords845); 

            					doneLeaf(lv_val3_6_0, elementTypeProvider.getMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryKeywords870); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:301:1: entryRuleExp0 : ruleExp0 EOF ;
    public final void entryRuleExp0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:301:14: ( ruleExp0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:302:2: ruleExp0 EOF
            {
             markComposite(elementTypeProvider.getExp0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp0_in_entryRuleExp0890);
            ruleExp0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp0896); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:308:1: ruleExp0 : (otherlv_0= '#2' ruleAddition0 ) ;
    public final void ruleExp0() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:308:9: ( (otherlv_0= '#2' ruleAddition0 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:309:2: (otherlv_0= '#2' ruleAddition0 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:309:2: (otherlv_0= '#2' ruleAddition0 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:310:3: otherlv_0= '#2' ruleAddition0
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleExp0915); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp0_NumberSignDigitTwoKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp0_Addition0ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_ruleExp0927);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:328:1: entryRuleAddition0 : ruleAddition0 EOF ;
    public final void entryRuleAddition0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:328:19: ( ruleAddition0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:329:2: ruleAddition0 EOF
            {
             markComposite(elementTypeProvider.getAddition0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition0_in_entryRuleAddition0947);
            ruleAddition0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition0953); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:335:1: ruleAddition0 : ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final void ruleAddition0() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:335:14: ( ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:336:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:336:2: ( rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:337:3: rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition0_Prim0ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition0970);
            rulePrim0();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:344:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:345:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:345:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:346:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition0_Add0LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition01006); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition0_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:358:4: ( (lv_right_3_0= rulePrim0 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:359:5: (lv_right_3_0= rulePrim0 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:359:5: (lv_right_3_0= rulePrim0 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:360:6: lv_right_3_0= rulePrim0
            	    {

            	    						markComposite(elementTypeProvider.getAddition0_RightPrim0ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim0_in_ruleAddition01038);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:374:1: entryRulePrim0 : rulePrim0 EOF ;
    public final void entryRulePrim0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:374:15: ( rulePrim0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:375:2: rulePrim0 EOF
            {
             markComposite(elementTypeProvider.getPrim0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim0_in_entryRulePrim01077);
            rulePrim0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim01083); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:381:1: rulePrim0 : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void rulePrim0() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:381:10: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:382:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:382:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:383:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:383:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:384:4: 
            {

            				precedeComposite(elementTypeProvider.getPrim0_Val0Action_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:389:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:390:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:390:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:391:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim01128); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:404:1: entryRuleExp1 : ruleExp1 EOF ;
    public final void entryRuleExp1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:404:14: ( ruleExp1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:405:2: ruleExp1 EOF
            {
             markComposite(elementTypeProvider.getExp1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp1_in_entryRuleExp11159);
            ruleExp1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp11165); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:411:1: ruleExp1 : (otherlv_0= '#3' ruleAddition1 ) ;
    public final void ruleExp1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:411:9: ( (otherlv_0= '#3' ruleAddition1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:412:2: (otherlv_0= '#3' ruleAddition1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:412:2: (otherlv_0= '#3' ruleAddition1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:413:3: otherlv_0= '#3' ruleAddition1
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleExp11184); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp1_NumberSignDigitThreeKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp1_Addition1ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_ruleExp11196);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:431:1: entryRuleAddition1 : ruleAddition1 EOF ;
    public final void entryRuleAddition1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:431:19: ( ruleAddition1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:432:2: ruleAddition1 EOF
            {
             markComposite(elementTypeProvider.getAddition1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_entryRuleAddition11216);
            ruleAddition1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition11222); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:438:1: ruleAddition1 : ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final void ruleAddition1() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:438:14: ( ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:439:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:439:2: ( rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:440:3: rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition1_Prim1ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11239);
            rulePrim1();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:447:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:448:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:448:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:449:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition1_Add1LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition11275); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition1_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:461:4: ( (lv_right_3_0= rulePrim1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:462:5: (lv_right_3_0= rulePrim1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:462:5: (lv_right_3_0= rulePrim1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:463:6: lv_right_3_0= rulePrim1
            	    {

            	    						markComposite(elementTypeProvider.getAddition1_RightPrim1ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim1_in_ruleAddition11307);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:477:1: entryRulePrim1 : rulePrim1 EOF ;
    public final void entryRulePrim1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:477:15: ( rulePrim1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:478:2: rulePrim1 EOF
            {
             markComposite(elementTypeProvider.getPrim1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim1_in_entryRulePrim11346);
            rulePrim1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim11352); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:484:1: rulePrim1 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) ;
    public final void rulePrim1() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:484:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:485:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:485:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition1 otherlv_4= ')' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:486:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:486:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:487:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:487:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:488:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim1_Val1Action_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:493:4: ( (lv_name_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:494:5: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:494:5: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:495:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim11408); 

                    						doneLeaf(lv_name_1_0, elementTypeProvider.getPrim1_NameIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:506:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:506:3: (otherlv_2= '(' ruleAddition1 otherlv_4= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:507:4: otherlv_2= '(' ruleAddition1 otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim11454); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getPrim1_LeftParenthesisKeyword_1_0ElementType());
                    			

                    				markComposite(elementTypeProvider.getPrim1_Addition1ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAddition1_in_rulePrim11469);
                    ruleAddition1();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrim11486); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:533:1: entryRuleExp2 : ruleExp2 EOF ;
    public final void entryRuleExp2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:533:14: ( ruleExp2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:534:2: ruleExp2 EOF
            {
             markComposite(elementTypeProvider.getExp2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExp2_in_entryRuleExp21511);
            ruleExp2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExp21517); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:540:1: ruleExp2 : (otherlv_0= '#4' ruleAddition2 ) ;
    public final void ruleExp2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:540:9: ( (otherlv_0= '#4' ruleAddition2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:541:2: (otherlv_0= '#4' ruleAddition2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:541:2: (otherlv_0= '#4' ruleAddition2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:542:3: otherlv_0= '#4' ruleAddition2
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleExp21536); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExp2_NumberSignDigitFourKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExp2_Addition2ParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_ruleExp21548);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:560:1: entryRuleAddition2 : ruleAddition2 EOF ;
    public final void entryRuleAddition2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:560:19: ( ruleAddition2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:561:2: ruleAddition2 EOF
            {
             markComposite(elementTypeProvider.getAddition2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_entryRuleAddition21568);
            ruleAddition2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition21574); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:567:1: ruleAddition2 : ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final void ruleAddition2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:567:14: ( ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:568:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:568:2: ( ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:569:3: ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {

            			markComposite(elementTypeProvider.getAddition2_Multiplication2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21591);
            ruleMultiplication2();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:576:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:577:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:577:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:578:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAddition2_Add2LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAddition21627); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAddition2_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:590:4: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:591:5: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:591:5: (lv_right_3_0= ruleMultiplication2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:592:6: lv_right_3_0= ruleMultiplication2
            	    {

            	    						markComposite(elementTypeProvider.getAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_ruleAddition21659);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:606:1: entryRuleMultiplication2 : ruleMultiplication2 EOF ;
    public final void entryRuleMultiplication2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:606:25: ( ruleMultiplication2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:607:2: ruleMultiplication2 EOF
            {
             markComposite(elementTypeProvider.getMultiplication2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21698);
            ruleMultiplication2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication21704); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:613:1: ruleMultiplication2 : ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final void ruleMultiplication2() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:613:20: ( ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:614:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:614:2: ( rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:615:3: rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {

            			markComposite(elementTypeProvider.getMultiplication2_Prim2ParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21721);
            rulePrim2();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:622:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:623:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:623:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:624:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMultiplication2_Mult2LeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiplication21757); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getMultiplication2_AsteriskKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:636:4: ( (lv_right_3_0= rulePrim2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:637:5: (lv_right_3_0= rulePrim2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:637:5: (lv_right_3_0= rulePrim2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:638:6: lv_right_3_0= rulePrim2
            	    {

            	    						markComposite(elementTypeProvider.getMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim2_in_ruleMultiplication21789);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:652:1: entryRulePrim2 : rulePrim2 EOF ;
    public final void entryRulePrim2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:652:15: ( rulePrim2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:653:2: rulePrim2 EOF
            {
             markComposite(elementTypeProvider.getPrim2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim2_in_entryRulePrim21828);
            rulePrim2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim21834); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:659:1: rulePrim2 : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) ;
    public final void rulePrim2() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:659:10: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:660:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:660:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' ruleAddition2 otherlv_4= ')' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:661:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:661:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:662:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:662:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:663:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim2_Val2Action_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:668:4: ( (lv_name_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:669:5: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:669:5: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:670:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim21890); 

                    						doneLeaf(lv_name_1_0, elementTypeProvider.getPrim2_NameIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:681:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:681:3: (otherlv_2= '(' ruleAddition2 otherlv_4= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:682:4: otherlv_2= '(' ruleAddition2 otherlv_4= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePrim21936); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getPrim2_LeftParenthesisKeyword_1_0ElementType());
                    			

                    				markComposite(elementTypeProvider.getPrim2_Addition2ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAddition2_in_rulePrim21951);
                    ruleAddition2();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrim21968); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:708:1: entryRuleDatatypeID : ruleDatatypeID EOF ;
    public final void entryRuleDatatypeID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:708:20: ( ruleDatatypeID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:709:2: ruleDatatypeID EOF
            {
             markComposite(elementTypeProvider.getDatatypeIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1993);
            ruleDatatypeID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeID1999); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:715:1: ruleDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:715:15: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:716:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatypeID2013); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:726:1: entryRuleSingleCrossReference : ruleSingleCrossReference EOF ;
    public final void entryRuleSingleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:726:30: ( ruleSingleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:727:2: ruleSingleCrossReference EOF
            {
             markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2029);
            ruleSingleCrossReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference2035); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:733:1: ruleSingleCrossReference : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:733:25: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:734:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:734:2: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:735:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSingleCrossReference2054); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:742:3: ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:743:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:743:4: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:744:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:744:5: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:745:6: lv_name_1_1= RULE_TERMINAL_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_1=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2089); 

                    						doneLeaf(lv_name_1_1, elementTypeProvider.getSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:753:6: lv_name_1_2= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2123); 

                    						doneLeaf(lv_name_1_2, elementTypeProvider.getSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:763:3: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:764:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleCrossReference2161); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getSingleCrossReference_Kw1Keyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:771:4: ( (otherlv_3= RULE_TERMINAL_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:772:5: (otherlv_3= RULE_TERMINAL_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:772:5: (otherlv_3= RULE_TERMINAL_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:773:6: otherlv_3= RULE_TERMINAL_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2193); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:783:3: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:784:4: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleCrossReference2232); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getSingleCrossReference_Kw2Keyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:791:4: ( ( ruleDatatypeID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:792:5: ( ruleDatatypeID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:792:5: ( ruleDatatypeID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:793:6: ruleDatatypeID
                    {

                    						markComposite(elementTypeProvider.getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2262);
                    ruleDatatypeID();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:803:3: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:804:4: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleCrossReference2301); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getSingleCrossReference_Kw3Keyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:811:4: ( (otherlv_7= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:812:5: (otherlv_7= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:812:5: (otherlv_7= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:813:6: otherlv_7= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2333); 

                    						doneLeaf(otherlv_7, elementTypeProvider.getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:823:3: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:824:4: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleCrossReference2372); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getSingleCrossReference_Kw4Keyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:831:4: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:832:5: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:832:5: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:833:6: otherlv_9= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleCrossReference2404); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:847:1: entryRuleBooleanAlternative : ruleBooleanAlternative EOF ;
    public final void entryRuleBooleanAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:847:28: ( ruleBooleanAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:848:2: ruleBooleanAlternative EOF
            {
             markComposite(elementTypeProvider.getBooleanAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2443);
            ruleBooleanAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternative2449); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:854:1: ruleBooleanAlternative : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final void ruleBooleanAlternative() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:854:23: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:855:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:855:2: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:856:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBooleanAlternative2468); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBooleanAlternative_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:863:3: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:864:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:864:4: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:865:5: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {

            					markComposite(elementTypeProvider.getBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2495);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:878:1: entryRuleBooleanAlternativeLiteral : ruleBooleanAlternativeLiteral EOF ;
    public final void entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:878:35: ( ruleBooleanAlternativeLiteral EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:879:2: ruleBooleanAlternativeLiteral EOF
            {
             markComposite(elementTypeProvider.getBooleanAlternativeLiteralElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2526);
            ruleBooleanAlternativeLiteral();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2532); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:885:1: ruleBooleanAlternativeLiteral : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final void ruleBooleanAlternativeLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:885:30: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:886:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:886:2: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:887:3: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:887:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:888:4: 
            {

            				precedeComposite(elementTypeProvider.getBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:893:3: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:894:4: otherlv_1= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanAlternativeLiteral2570); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:902:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:902:4: ( (lv_isTrue_2_0= 'kw2' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:903:5: (lv_isTrue_2_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:903:5: (lv_isTrue_2_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:904:6: lv_isTrue_2_0= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_isTrue_2_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBooleanAlternativeLiteral2611); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:918:1: entryRuleUnassignedDatatype : ruleUnassignedDatatype EOF ;
    public final void entryRuleUnassignedDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:918:28: ( ruleUnassignedDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:919:2: ruleUnassignedDatatype EOF
            {
             markComposite(elementTypeProvider.getUnassignedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2649);
            ruleUnassignedDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedDatatype2655); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:925:1: ruleUnassignedDatatype : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final void ruleUnassignedDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:925:23: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:926:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:926:2: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:927:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedDatatype2674); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:934:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:935:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:935:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:936:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedDatatype2701); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getUnassignedDatatype_KW1ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleUnassignedDatatype2724);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:956:1: entryRuleKW1 : ruleKW1 EOF ;
    public final void entryRuleKW1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:956:13: ( ruleKW1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:957:2: ruleKW1 EOF
            {
             markComposite(elementTypeProvider.getKW1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKW1_in_entryRuleKW12744);
            ruleKW1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKW12750); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:963:1: ruleKW1 : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final void ruleKW1() throws RecognitionException {
        Token kw=null;
        Token this_INT_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:963:8: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:964:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:964:2: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:965:3: kw= 'kw1'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKW12769); 

                    			doneLeaf(kw, elementTypeProvider.getKW1_Kw1Keyword_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:973:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:973:3: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:974:4: kw= 'matched' (this_INT_2= RULE_INT )?
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleKW12797); 

                    				doneLeaf(kw, elementTypeProvider.getKW1_MatchedKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:981:4: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:982:5: this_INT_2= RULE_INT
                            {

                            					markLeaf();
                            				
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleKW12821); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:995:1: entryRuleOptionalSingleTransition : ruleOptionalSingleTransition EOF ;
    public final void entryRuleOptionalSingleTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:995:34: ( ruleOptionalSingleTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:996:2: ruleOptionalSingleTransition EOF
            {
             markComposite(elementTypeProvider.getOptionalSingleTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2853);
            ruleOptionalSingleTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalSingleTransition2859); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1002:1: ruleOptionalSingleTransition : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalSingleTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1002:29: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1003:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1003:2: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1004:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleOptionalSingleTransition2878); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1011:3: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1012:4: ruleKW1
                    {

                    				markComposite(elementTypeProvider.getOptionalSingleTransition_KW1ParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2896);
                    ruleKW1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1020:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1021:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1021:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1022:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalSingleTransition2929); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1035:1: entryRuleOptionalManyTransition : ruleOptionalManyTransition EOF ;
    public final void entryRuleOptionalManyTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1035:32: ( ruleOptionalManyTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1036:2: ruleOptionalManyTransition EOF
            {
             markComposite(elementTypeProvider.getOptionalManyTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition2960);
            ruleOptionalManyTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalManyTransition2966); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1042:1: ruleOptionalManyTransition : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleOptionalManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1042:27: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1043:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1043:2: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1044:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleOptionalManyTransition2985); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1051:3: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1052:4: ruleKW1
            	    {

            	    				markComposite(elementTypeProvider.getOptionalManyTransition_KW1ParserRuleCall_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleOptionalManyTransition3003);
            	    ruleKW1();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1060:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1061:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1061:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1062:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalManyTransition3036); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1075:1: entryRuleMandatoryManyTransition : ruleMandatoryManyTransition EOF ;
    public final void entryRuleMandatoryManyTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1075:33: ( ruleMandatoryManyTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1076:2: ruleMandatoryManyTransition EOF
            {
             markComposite(elementTypeProvider.getMandatoryManyTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3067);
            ruleMandatoryManyTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryManyTransition3073); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1082:1: ruleMandatoryManyTransition : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final void ruleMandatoryManyTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1082:28: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1083:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1083:2: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1084:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMandatoryManyTransition3092); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1091:3: ( ruleKW1 )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1092:4: ruleKW1
            	    {

            	    				markComposite(elementTypeProvider.getMandatoryManyTransition_KW1ParserRuleCall_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3110);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1100:3: ( (lv_val_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1101:4: (lv_val_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1101:4: (lv_val_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1102:5: lv_val_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3143); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1115:1: entryRuleAlternativeTransition : ruleAlternativeTransition EOF ;
    public final void entryRuleAlternativeTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1115:31: ( ruleAlternativeTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1116:2: ruleAlternativeTransition EOF
            {
             markComposite(elementTypeProvider.getAlternativeTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3174);
            ruleAlternativeTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeTransition3180); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1122:1: ruleAlternativeTransition : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final void ruleAlternativeTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1122:26: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1123:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1123:2: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1124:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAlternativeTransition3199); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1131:3: ( ruleKW1 | otherlv_2= 'kw2' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1132:4: ruleKW1
                    {

                    				markComposite(elementTypeProvider.getAlternativeTransition_KW1ParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleKW1_in_ruleAlternativeTransition3217);
                    ruleKW1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1140:4: otherlv_2= 'kw2'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAlternativeTransition3243); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getAlternativeTransition_Kw2Keyword_1_1ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1148:3: ( (lv_val_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1149:4: (lv_val_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1149:4: (lv_val_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1150:5: lv_val_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeTransition3275); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1163:1: entryRuleBooleanDatatypeID : ruleBooleanDatatypeID EOF ;
    public final void entryRuleBooleanDatatypeID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1163:27: ( ruleBooleanDatatypeID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1164:2: ruleBooleanDatatypeID EOF
            {
             markComposite(elementTypeProvider.getBooleanDatatypeIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanDatatypeID_in_entryRuleBooleanDatatypeID3306);
            ruleBooleanDatatypeID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanDatatypeID3312); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1170:1: ruleBooleanDatatypeID : this_ID_0= RULE_ID ;
    public final void ruleBooleanDatatypeID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1170:22: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1171:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanDatatypeID3326); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1181:1: entryRuleBooleanValues : ruleBooleanValues EOF ;
    public final void entryRuleBooleanValues() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1181:23: ( ruleBooleanValues EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1182:2: ruleBooleanValues EOF
            {
             markComposite(elementTypeProvider.getBooleanValuesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanValues_in_entryRuleBooleanValues3342);
            ruleBooleanValues();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanValues3348); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1188:1: ruleBooleanValues : ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) ;
    public final void ruleBooleanValues() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1188:18: ( ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1189:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1189:2: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1190:3: () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1190:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1191:4: 
            {

            				precedeComposite(elementTypeProvider.getBooleanValues_BooleanValuesAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleBooleanValues3380); 

            			doneLeaf(otherlv_1, elementTypeProvider.getBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1203:3: ( (lv_val1_2_0= 'kw1' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1204:4: (lv_val1_2_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1204:4: (lv_val1_2_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1205:5: lv_val1_2_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_val1_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBooleanValues3407); 

                    					doneLeaf(lv_val1_2_0, elementTypeProvider.getBooleanValues_Val1Kw1Keyword_2_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1214:3: ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BOOLEAN_TERMINAL_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1215:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1215:4: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1216:5: lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_BOOLEAN_TERMINAL_ID,FollowSets000.FOLLOW_RULE_BOOLEAN_TERMINAL_ID_in_ruleBooleanValues3446); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1225:3: ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1226:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1226:4: (lv_val3_4_0= ruleBooleanDatatypeID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1227:5: lv_val3_4_0= ruleBooleanDatatypeID
                    {

                    					markComposite(elementTypeProvider.getBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanDatatypeID_in_ruleBooleanValues3485);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1240:1: entryRuleLongAlternative : ruleLongAlternative EOF ;
    public final void entryRuleLongAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1240:25: ( ruleLongAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1241:2: ruleLongAlternative EOF
            {
             markComposite(elementTypeProvider.getLongAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLongAlternative_in_entryRuleLongAlternative3517);
            ruleLongAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLongAlternative3523); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1247:1: ruleLongAlternative : (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1247:20: ( (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1248:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1248:2: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1249:3: otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLongAlternative3542); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1256:3: ( (lv_foo_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1257:4: (lv_foo_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1257:4: (lv_foo_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1258:5: lv_foo_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3569); 

            					doneLeaf(lv_foo_1_0, elementTypeProvider.getLongAlternative_FooIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1267:3: ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1268:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1268:4: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1269:5: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLongAlternative3607); 

            	    					doneLeaf(otherlv_2, elementTypeProvider.getLongAlternative_Kw1Keyword_2_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1276:5: ( (lv_val1_3_0= RULE_ID ) )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_ID) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1277:6: (lv_val1_3_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1277:6: (lv_val1_3_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1278:7: lv_val1_3_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3644); 

            	            							doneLeaf(lv_val1_3_0, elementTypeProvider.getLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1289:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1289:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1290:5: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLongAlternative3699); 

            	    					doneLeaf(otherlv_4, elementTypeProvider.getLongAlternative_Kw2Keyword_2_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1297:5: ( (lv_val2_5_0= RULE_ID ) )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_ID) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1298:6: (lv_val2_5_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1298:6: (lv_val2_5_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1299:7: lv_val2_5_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3736); 

            	            							doneLeaf(lv_val2_5_0, elementTypeProvider.getLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1310:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1310:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1311:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLongAlternative3791); 

            	    					doneLeaf(otherlv_6, elementTypeProvider.getLongAlternative_Kw3Keyword_2_2_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1318:5: ( (lv_val3_7_0= RULE_ID ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==RULE_ID) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1319:6: (lv_val3_7_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1319:6: (lv_val3_7_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1320:7: lv_val3_7_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3828); 

            	            							doneLeaf(lv_val3_7_0, elementTypeProvider.getLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1331:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1331:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1332:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLongAlternative3883); 

            	    					doneLeaf(otherlv_8, elementTypeProvider.getLongAlternative_Kw4Keyword_2_3_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1339:5: ( (lv_val4_9_0= RULE_ID ) )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_ID) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1340:6: (lv_val4_9_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1340:6: (lv_val4_9_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1341:7: lv_val4_9_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative3920); 

            	            							doneLeaf(lv_val4_9_0, elementTypeProvider.getLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1352:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1352:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1353:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLongAlternative3975); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getLongAlternative_Kw5Keyword_2_4_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1360:5: ( (lv_val5_11_0= RULE_ID ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1361:6: (lv_val5_11_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1361:6: (lv_val5_11_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1362:7: lv_val5_11_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4012); 

            	            							doneLeaf(lv_val5_11_0, elementTypeProvider.getLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1373:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1373:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1374:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_12=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLongAlternative4067); 

            	    					doneLeaf(otherlv_12, elementTypeProvider.getLongAlternative_Kw6Keyword_2_5_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1381:5: ( (lv_val6_13_0= RULE_ID ) )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1382:6: (lv_val6_13_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1382:6: (lv_val6_13_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1383:7: lv_val6_13_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4104); 

            	            							doneLeaf(lv_val6_13_0, elementTypeProvider.getLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1394:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1394:4: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1395:5: otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_14=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLongAlternative4159); 

            	    					doneLeaf(otherlv_14, elementTypeProvider.getLongAlternative_Kw7Keyword_2_6_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1402:5: ( (lv_val7_15_0= RULE_ID ) )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==RULE_ID) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1403:6: (lv_val7_15_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1403:6: (lv_val7_15_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1404:7: lv_val7_15_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val7_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4196); 

            	            							doneLeaf(lv_val7_15_0, elementTypeProvider.getLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType());
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1415:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1415:4: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1416:5: otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )?
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_16=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLongAlternative4251); 

            	    					doneLeaf(otherlv_16, elementTypeProvider.getLongAlternative_Kw8Keyword_2_7_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1423:5: ( (lv_val8_17_0= RULE_ID ) )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_ID) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1424:6: (lv_val8_17_0= RULE_ID )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1424:6: (lv_val8_17_0= RULE_ID )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSyntacticSequencerTestLanguage.g:1425:7: lv_val8_17_0= RULE_ID
            	            {

            	            							markLeaf();
            	            						
            	            lv_val8_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongAlternative4288); 

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
            		
            otherlv_18=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLongAlternative4330); 

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
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_ruleModel92 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_ruleModel138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_ruleModel184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_ruleModel230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_ruleModel276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_ruleModel322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_ruleModel368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_ruleModel414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_ruleModel460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_ruleModel506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_ruleModel552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValues_in_ruleModel598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongAlternative_in_ruleModel644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryKeywords_in_entryRuleMandatoryKeywords675 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryKeywords681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleMandatoryKeywords700 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords727 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMandatoryKeywords752 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords779 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryKeywords804 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryKeywords818 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryKeywords845 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryKeywords870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp0_in_entryRuleExp0890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp0896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleExp0915 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAddition0_in_ruleExp0927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition0_in_entryRuleAddition0947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition0953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition0970 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition01006 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePrim0_in_ruleAddition01038 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrim0_in_entryRulePrim01077 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim01083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim01128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp1_in_entryRuleExp11159 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp11165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleExp11184 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition1_in_ruleExp11196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition1_in_entryRuleAddition11216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition11222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11239 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition11275 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rulePrim1_in_ruleAddition11307 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrim1_in_entryRulePrim11346 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim11352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim11408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rulePrim11454 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition1_in_rulePrim11469 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrim11486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExp2_in_entryRuleExp21511 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExp21517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleExp21536 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition2_in_ruleExp21548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition2_in_entryRuleAddition21568 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition21574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21591 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAddition21627 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_ruleAddition21659 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleMultiplication2_in_entryRuleMultiplication21698 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication21704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21721 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleMultiplication21757 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rulePrim2_in_ruleMultiplication21789 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rulePrim2_in_entryRulePrim21828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim21834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim21890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rulePrim21936 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleAddition2_in_rulePrim21951 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrim21968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_entryRuleDatatypeID1993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeID1999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatypeID2013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference2029 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference2035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleSingleCrossReference2054 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2089 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2123 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14_in_ruleSingleCrossReference2161 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_TERMINAL_ID_in_ruleSingleCrossReference2193 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_15_in_ruleSingleCrossReference2232 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatypeID_in_ruleSingleCrossReference2262 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleSingleCrossReference2301 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2333 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleSingleCrossReference2372 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleCrossReference2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternative_in_entryRuleBooleanAlternative2443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternative2449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleBooleanAlternative2468 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_ruleBooleanAlternative2495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAlternativeLiteral_in_entryRuleBooleanAlternativeLiteral2526 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAlternativeLiteral2532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleBooleanAlternativeLiteral2570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleBooleanAlternativeLiteral2611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedDatatype_in_entryRuleUnassignedDatatype2649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedDatatype2655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedDatatype2674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedDatatype2701 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleUnassignedDatatype2724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKW1_in_entryRuleKW12744 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKW12750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleKW12769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleKW12797 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleKW12821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalSingleTransition_in_entryRuleOptionalSingleTransition2853 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalSingleTransition2859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleOptionalSingleTransition2878 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalSingleTransition2896 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalSingleTransition2929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalManyTransition_in_entryRuleOptionalManyTransition2960 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalManyTransition2966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleOptionalManyTransition2985 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleOptionalManyTransition3003 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalManyTransition3036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryManyTransition_in_entryRuleMandatoryManyTransition3067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryManyTransition3073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleMandatoryManyTransition3092 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleMandatoryManyTransition3110 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryManyTransition3143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeTransition_in_entryRuleAlternativeTransition3174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeTransition3180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleAlternativeTransition3199 = new BitSet(new long[]{0x000000001000C000L});
        public static final BitSet FOLLOW_ruleKW1_in_ruleAlternativeTransition3217 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15_in_ruleAlternativeTransition3243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeTransition3275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanDatatypeID_in_entryRuleBooleanDatatypeID3306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanDatatypeID3312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanDatatypeID3326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValues_in_entryRuleBooleanValues3342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValues3348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleBooleanValues3380 = new BitSet(new long[]{0x0000000000004092L});
        public static final BitSet FOLLOW_14_in_ruleBooleanValues3407 = new BitSet(new long[]{0x0000000000000092L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_TERMINAL_ID_in_ruleBooleanValues3446 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleBooleanDatatypeID_in_ruleBooleanValues3485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongAlternative_in_entryRuleLongAlternative3517 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLongAlternative3523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleLongAlternative3542 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3569 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_14_in_ruleLongAlternative3607 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3644 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_15_in_ruleLongAlternative3699 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3736 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_16_in_ruleLongAlternative3791 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3828 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_17_in_ruleLongAlternative3883 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative3920 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_35_in_ruleLongAlternative3975 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4012 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_36_in_ruleLongAlternative4067 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4104 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_37_in_ruleLongAlternative4159 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4196 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_38_in_ruleLongAlternative4251 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongAlternative4288 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_39_in_ruleLongAlternative4330 = new BitSet(new long[]{0x0000000000000002L});
    }


}