package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalAssignmentFinderTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TERMINAL1", "RULE_TERMINAL2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#00'", "'#01'", "'#02'", "'#03'", "'#04'", "'#05'", "'#06'", "'#07'", "'#08'", "'#09'", "'kw1'", "'kw2'", "'%foo'", "'true'", "'false'", "'lit3'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_TERMINAL1=4;
    public static final int RULE_TERMINAL2=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=7;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public PsiInternalAssignmentFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalAssignmentFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalAssignmentFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g"; }



    	protected AssignmentFinderTestLanguageGrammarAccess grammarAccess;

    	protected AssignmentFinderTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalAssignmentFinderTestLanguageParser(PsiBuilder builder, TokenStream input, AssignmentFinderTestLanguageElementTypeProvider elementTypeProvider, AssignmentFinderTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:59:1: ruleModel : ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:59:10: ( ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:60:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:60:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
            int alt1=10;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 18:
                {
                alt1=6;
                }
                break;
            case 19:
                {
                alt1=7;
                }
                break;
            case 20:
                {
                alt1=8;
                }
                break;
            case 21:
                {
                alt1=9;
                }
                break;
            case 22:
                {
                alt1=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:61:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:61:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:62:4: otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel85); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getModel_NumberSignDigitZeroDigitZeroKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:69:4: ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:70:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:70:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:71:6: lv_keywordVal_1_0= ruleKeywordVal
                    {

                    						markComposite(elementTypeProvider.getModel_KeywordValKeywordValParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeywordVal_in_ruleModel117);
                    ruleKeywordVal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:82:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:82:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:83:4: otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel163); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getModel_NumberSignDigitZeroDigitOneKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:90:4: ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:91:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:91:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:92:6: lv_terminalVal_3_0= ruleTerminalVal
                    {

                    						markComposite(elementTypeProvider.getModel_TerminalValTerminalValParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalVal_in_ruleModel195);
                    ruleTerminalVal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:103:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:103:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:104:4: otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel241); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_NumberSignDigitZeroDigitTwoKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:111:4: ( (lv_enumVal_5_0= ruleEnumVal ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:112:5: (lv_enumVal_5_0= ruleEnumVal )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:112:5: (lv_enumVal_5_0= ruleEnumVal )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:113:6: lv_enumVal_5_0= ruleEnumVal
                    {

                    						markComposite(elementTypeProvider.getModel_EnumValEnumValParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEnumVal_in_ruleModel273);
                    ruleEnumVal();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:124:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:124:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:125:4: otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel319); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getModel_NumberSignDigitZeroDigitThreeKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:132:4: ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:133:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:133:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:134:6: lv_keywordBool_7_0= ruleKeywordBool
                    {

                    						markComposite(elementTypeProvider.getModel_KeywordBoolKeywordBoolParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleKeywordBool_in_ruleModel351);
                    ruleKeywordBool();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:145:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:145:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:146:4: otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel397); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_NumberSignDigitZeroDigitFourKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:153:4: ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:154:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:154:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:155:6: lv_terminalBool_9_0= ruleTerminalBool
                    {

                    						markComposite(elementTypeProvider.getModel_TerminalBoolTerminalBoolParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalBool_in_ruleModel429);
                    ruleTerminalBool();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:166:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:166:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:167:4: otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel475); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getModel_NumberSignDigitZeroDigitFiveKeyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:174:4: ( (lv_enumBool_11_0= ruleEnumBool ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:175:5: (lv_enumBool_11_0= ruleEnumBool )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:175:5: (lv_enumBool_11_0= ruleEnumBool )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:176:6: lv_enumBool_11_0= ruleEnumBool
                    {

                    						markComposite(elementTypeProvider.getModel_EnumBoolEnumBoolParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleEnumBool_in_ruleModel507);
                    ruleEnumBool();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:187:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:187:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:188:4: otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    {

                    				markLeaf();
                    			
                    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel553); 

                    				doneLeaf(otherlv_12, elementTypeProvider.getModel_NumberSignDigitZeroDigitSixKeyword_6_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:195:4: ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:196:5: (lv_mixedBool_13_0= ruleMixedBool )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:196:5: (lv_mixedBool_13_0= ruleMixedBool )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:197:6: lv_mixedBool_13_0= ruleMixedBool
                    {

                    						markComposite(elementTypeProvider.getModel_MixedBoolMixedBoolParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMixedBool_in_ruleModel585);
                    ruleMixedBool();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:208:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:208:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:209:4: otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    {

                    				markLeaf();
                    			
                    otherlv_14=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel631); 

                    				doneLeaf(otherlv_14, elementTypeProvider.getModel_NumberSignDigitZeroDigitSevenKeyword_7_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:216:4: ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:217:5: (lv_mixedValue_15_0= ruleMixedValue )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:217:5: (lv_mixedValue_15_0= ruleMixedValue )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:218:6: lv_mixedValue_15_0= ruleMixedValue
                    {

                    						markComposite(elementTypeProvider.getModel_MixedValueMixedValueParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMixedValue_in_ruleModel663);
                    ruleMixedValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:229:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:229:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:230:4: otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    {

                    				markLeaf();
                    			
                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModel709); 

                    				doneLeaf(otherlv_16, elementTypeProvider.getModel_NumberSignDigitZeroDigitEightKeyword_8_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:237:4: ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:238:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:238:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:239:6: lv_containmentRef_17_0= ruleContainmentRef
                    {

                    						markComposite(elementTypeProvider.getModel_ContainmentRefContainmentRefParserRuleCall_8_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef_in_ruleModel741);
                    ruleContainmentRef();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:250:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:250:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:251:4: otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) )
                    {

                    				markLeaf();
                    			
                    otherlv_18=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModel787); 

                    				doneLeaf(otherlv_18, elementTypeProvider.getModel_NumberSignDigitZeroDigitNineKeyword_9_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:258:4: ( (lv_crossRef_19_0= ruleCrossRef ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:259:5: (lv_crossRef_19_0= ruleCrossRef )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:259:5: (lv_crossRef_19_0= ruleCrossRef )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:260:6: lv_crossRef_19_0= ruleCrossRef
                    {

                    						markComposite(elementTypeProvider.getModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCrossRef_in_ruleModel819);
                    ruleCrossRef();

                    state._fsp--;


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


    // $ANTLR start "entryRuleKeywordVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:274:1: entryRuleKeywordVal : ruleKeywordVal EOF ;
    public final void entryRuleKeywordVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:274:20: ( ruleKeywordVal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:275:2: ruleKeywordVal EOF
            {
             markComposite(elementTypeProvider.getKeywordValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeywordVal_in_entryRuleKeywordVal857);
            ruleKeywordVal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeywordVal863); 

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
    // $ANTLR end "entryRuleKeywordVal"


    // $ANTLR start "ruleKeywordVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:281:1: ruleKeywordVal : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final void ruleKeywordVal() throws RecognitionException {
        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:281:15: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:282:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:282:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==24) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:283:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:283:3: ( (lv_kw_0_0= 'kw1' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:284:4: (lv_kw_0_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:284:4: (lv_kw_0_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:285:5: lv_kw_0_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleKeywordVal895); 

                    					doneLeaf(lv_kw_0_0, elementTypeProvider.getKeywordVal_KwKw1Keyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:295:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:295:3: ( (lv_kw_1_0= 'kw2' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:296:4: (lv_kw_1_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:296:4: (lv_kw_1_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:297:5: lv_kw_1_0= 'kw2'
                    {

                    					markLeaf();
                    				
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleKeywordVal941); 

                    					doneLeaf(lv_kw_1_0, elementTypeProvider.getKeywordVal_KwKw2Keyword_1_0ElementType());
                    				

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
    // $ANTLR end "ruleKeywordVal"


    // $ANTLR start "entryRuleTerminalVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:310:1: entryRuleTerminalVal : ruleTerminalVal EOF ;
    public final void entryRuleTerminalVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:310:21: ( ruleTerminalVal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:311:2: ruleTerminalVal EOF
            {
             markComposite(elementTypeProvider.getTerminalValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalVal_in_entryRuleTerminalVal972);
            ruleTerminalVal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalVal978); 

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
    // $ANTLR end "entryRuleTerminalVal"


    // $ANTLR start "ruleTerminalVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:317:1: ruleTerminalVal : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final void ruleTerminalVal() throws RecognitionException {
        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:317:16: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:318:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:318:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_TERMINAL1:
                {
                alt3=1;
                }
                break;
            case RULE_TERMINAL2:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:319:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:319:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:320:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:320:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:321:5: lv_term_0_0= RULE_TERMINAL1
                    {

                    					markLeaf();
                    				
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleTerminalVal1010); 

                    					doneLeaf(lv_term_0_0, elementTypeProvider.getTerminalVal_TermTerminal1TerminalRuleCall_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:331:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:331:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:332:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:332:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:333:5: lv_term_1_0= RULE_TERMINAL2
                    {

                    					markLeaf();
                    				
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleTerminalVal1056); 

                    					doneLeaf(lv_term_1_0, elementTypeProvider.getTerminalVal_TermTerminal2TerminalRuleCall_1_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:343:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:343:3: ( (lv_term_2_0= '%foo' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:344:4: (lv_term_2_0= '%foo' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:344:4: (lv_term_2_0= '%foo' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:345:5: lv_term_2_0= '%foo'
                    {

                    					markLeaf();
                    				
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalVal1102); 

                    					doneLeaf(lv_term_2_0, elementTypeProvider.getTerminalVal_TermFooKeyword_2_0ElementType());
                    				

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
    // $ANTLR end "ruleTerminalVal"


    // $ANTLR start "entryRuleEnumVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:358:1: entryRuleEnumVal : ruleEnumVal EOF ;
    public final void entryRuleEnumVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:358:17: ( ruleEnumVal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:359:2: ruleEnumVal EOF
            {
             markComposite(elementTypeProvider.getEnumValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumVal_in_entryRuleEnumVal1133);
            ruleEnumVal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumVal1139); 

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
    // $ANTLR end "entryRuleEnumVal"


    // $ANTLR start "ruleEnumVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:365:1: ruleEnumVal : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final void ruleEnumVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:365:12: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:366:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:366:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:367:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:367:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:368:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:368:4: (lv_en_0_0= ruleEnum1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:369:5: lv_en_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getEnumVal_EnEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumVal1171);
                    ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:379:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:379:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:380:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:380:4: (lv_en_1_0= ruleEnum2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:381:5: lv_en_1_0= ruleEnum2
                    {

                    					markComposite(elementTypeProvider.getEnumVal_EnEnum2EnumRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleEnum2_in_ruleEnumVal1217);
                    ruleEnum2();

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
    // $ANTLR end "ruleEnumVal"


    // $ANTLR start "entryRuleKeywordBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:394:1: entryRuleKeywordBool : ruleKeywordBool EOF ;
    public final void entryRuleKeywordBool() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:394:21: ( ruleKeywordBool EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:395:2: ruleKeywordBool EOF
            {
             markComposite(elementTypeProvider.getKeywordBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeywordBool_in_entryRuleKeywordBool1248);
            ruleKeywordBool();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeywordBool1254); 

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
    // $ANTLR end "entryRuleKeywordBool"


    // $ANTLR start "ruleKeywordBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:401:1: ruleKeywordBool : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final void ruleKeywordBool() throws RecognitionException {
        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:401:16: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:402:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:402:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:403:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:403:3: ( (lv_kw_0_0= 'kw1' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:404:4: (lv_kw_0_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:404:4: (lv_kw_0_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:405:5: lv_kw_0_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleKeywordBool1286); 

                    					doneLeaf(lv_kw_0_0, elementTypeProvider.getKeywordBool_KwKw1Keyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:415:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:415:3: ( (lv_kw_1_0= 'kw2' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:416:4: (lv_kw_1_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:416:4: (lv_kw_1_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:417:5: lv_kw_1_0= 'kw2'
                    {

                    					markLeaf();
                    				
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleKeywordBool1332); 

                    					doneLeaf(lv_kw_1_0, elementTypeProvider.getKeywordBool_KwKw2Keyword_1_0ElementType());
                    				

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
    // $ANTLR end "ruleKeywordBool"


    // $ANTLR start "entryRuleTerminalBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:430:1: entryRuleTerminalBool : ruleTerminalBool EOF ;
    public final void entryRuleTerminalBool() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:430:22: ( ruleTerminalBool EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:431:2: ruleTerminalBool EOF
            {
             markComposite(elementTypeProvider.getTerminalBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalBool_in_entryRuleTerminalBool1363);
            ruleTerminalBool();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalBool1369); 

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
    // $ANTLR end "entryRuleTerminalBool"


    // $ANTLR start "ruleTerminalBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:437:1: ruleTerminalBool : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final void ruleTerminalBool() throws RecognitionException {
        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:437:17: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:438:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:438:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_TERMINAL1:
                {
                alt6=1;
                }
                break;
            case RULE_TERMINAL2:
                {
                alt6=2;
                }
                break;
            case 25:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:439:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:439:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:440:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:440:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:441:5: lv_term_0_0= RULE_TERMINAL1
                    {

                    					markLeaf();
                    				
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleTerminalBool1401); 

                    					doneLeaf(lv_term_0_0, elementTypeProvider.getTerminalBool_TermTerminal1TerminalRuleCall_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:451:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:451:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:452:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:452:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:453:5: lv_term_1_0= RULE_TERMINAL2
                    {

                    					markLeaf();
                    				
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleTerminalBool1447); 

                    					doneLeaf(lv_term_1_0, elementTypeProvider.getTerminalBool_TermTerminal2TerminalRuleCall_1_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:463:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:463:3: ( (lv_term_2_0= '%foo' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:464:4: (lv_term_2_0= '%foo' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:464:4: (lv_term_2_0= '%foo' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:465:5: lv_term_2_0= '%foo'
                    {

                    					markLeaf();
                    				
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalBool1493); 

                    					doneLeaf(lv_term_2_0, elementTypeProvider.getTerminalBool_TermFooKeyword_2_0ElementType());
                    				

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
    // $ANTLR end "ruleTerminalBool"


    // $ANTLR start "entryRuleEnumBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:478:1: entryRuleEnumBool : ruleEnumBool EOF ;
    public final void entryRuleEnumBool() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:478:18: ( ruleEnumBool EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:479:2: ruleEnumBool EOF
            {
             markComposite(elementTypeProvider.getEnumBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBool_in_entryRuleEnumBool1524);
            ruleEnumBool();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBool1530); 

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
    // $ANTLR end "entryRuleEnumBool"


    // $ANTLR start "ruleEnumBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:485:1: ruleEnumBool : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final void ruleEnumBool() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:485:13: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:486:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:486:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            else if ( (LA7_0==30) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:487:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:487:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:488:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:488:4: (lv_en_0_0= ruleEnum1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:489:5: lv_en_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getEnumBool_EnEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumBool1562);
                    ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:499:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:499:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:500:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:500:4: (lv_en_1_0= ruleEnum2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:501:5: lv_en_1_0= ruleEnum2
                    {

                    					markComposite(elementTypeProvider.getEnumBool_EnEnum2EnumRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleEnum2_in_ruleEnumBool1608);
                    ruleEnum2();

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
    // $ANTLR end "ruleEnumBool"


    // $ANTLR start "entryRuleMixedBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:514:1: entryRuleMixedBool : ruleMixedBool EOF ;
    public final void entryRuleMixedBool() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:514:19: ( ruleMixedBool EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:515:2: ruleMixedBool EOF
            {
             markComposite(elementTypeProvider.getMixedBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMixedBool_in_entryRuleMixedBool1639);
            ruleMixedBool();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMixedBool1645); 

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
    // $ANTLR end "entryRuleMixedBool"


    // $ANTLR start "ruleMixedBool"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:521:1: ruleMixedBool : ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) ;
    public final void ruleMixedBool() throws RecognitionException {
        Token lv_val_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:521:14: ( ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:522:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:522:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=26 && LA8_0<=27)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:523:3: ( (lv_val_0_0= 'kw1' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:523:3: ( (lv_val_0_0= 'kw1' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:524:4: (lv_val_0_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:524:4: (lv_val_0_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:525:5: lv_val_0_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_val_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMixedBool1677); 

                    					doneLeaf(lv_val_0_0, elementTypeProvider.getMixedBool_ValKw1Keyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:535:3: ( (lv_val_1_0= ruleBoolean ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:535:3: ( (lv_val_1_0= ruleBoolean ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:536:4: (lv_val_1_0= ruleBoolean )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:536:4: (lv_val_1_0= ruleBoolean )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:537:5: lv_val_1_0= ruleBoolean
                    {

                    					markComposite(elementTypeProvider.getMixedBool_ValBooleanParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleMixedBool1723);
                    ruleBoolean();

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
    // $ANTLR end "ruleMixedBool"


    // $ANTLR start "entryRuleBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:550:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:550:17: ( ruleBoolean EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:551:2: ruleBoolean EOF
            {
             markComposite(elementTypeProvider.getBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1754);
            ruleBoolean();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1760); 

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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:557:1: ruleBoolean : (kw= 'true' | kw= 'false' ) ;
    public final void ruleBoolean() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:557:12: ( (kw= 'true' | kw= 'false' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:558:2: (kw= 'true' | kw= 'false' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:558:2: (kw= 'true' | kw= 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:559:3: kw= 'true'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBoolean1779); 

                    			doneLeaf(kw, elementTypeProvider.getBoolean_TrueKeyword_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:567:3: kw= 'false'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBoolean1801); 

                    			doneLeaf(kw, elementTypeProvider.getBoolean_FalseKeyword_1ElementType());
                    		

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleMixedValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:578:1: entryRuleMixedValue : ruleMixedValue EOF ;
    public final void entryRuleMixedValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:578:20: ( ruleMixedValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:579:2: ruleMixedValue EOF
            {
             markComposite(elementTypeProvider.getMixedValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMixedValue_in_entryRuleMixedValue1821);
            ruleMixedValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMixedValue1827); 

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
    // $ANTLR end "entryRuleMixedValue"


    // $ANTLR start "ruleMixedValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:585:1: ruleMixedValue : ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) ;
    public final void ruleMixedValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:585:15: ( ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:586:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:586:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            else if ( (LA10_0==28) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:587:3: ( (lv_val_0_0= ruleEnum1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:587:3: ( (lv_val_0_0= ruleEnum1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:588:4: (lv_val_0_0= ruleEnum1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:588:4: (lv_val_0_0= ruleEnum1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:589:5: lv_val_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getMixedValue_ValEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleMixedValue1859);
                    ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:599:3: ( (lv_val_1_0= ruleDatEnum ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:599:3: ( (lv_val_1_0= ruleDatEnum ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:600:4: (lv_val_1_0= ruleDatEnum )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:600:4: (lv_val_1_0= ruleDatEnum )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:601:5: lv_val_1_0= ruleDatEnum
                    {

                    					markComposite(elementTypeProvider.getMixedValue_ValDatEnumParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleDatEnum_in_ruleMixedValue1905);
                    ruleDatEnum();

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
    // $ANTLR end "ruleMixedValue"


    // $ANTLR start "entryRuleDatEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:614:1: entryRuleDatEnum : ruleDatEnum EOF ;
    public final void entryRuleDatEnum() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:614:17: ( ruleDatEnum EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:615:2: ruleDatEnum EOF
            {
             markComposite(elementTypeProvider.getDatEnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatEnum_in_entryRuleDatEnum1936);
            ruleDatEnum();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatEnum1942); 

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
    // $ANTLR end "entryRuleDatEnum"


    // $ANTLR start "ruleDatEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:621:1: ruleDatEnum : kw= 'lit3' ;
    public final void ruleDatEnum() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:621:12: (kw= 'lit3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:622:2: kw= 'lit3'
            {

            		markLeaf();
            	
            kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDatEnum1956); 

            		doneLeaf(kw, elementTypeProvider.getDatEnum_Lit3KeywordElementType());
            	

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
    // $ANTLR end "ruleDatEnum"


    // $ANTLR start "entryRuleContainmentRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:632:1: entryRuleContainmentRef : ruleContainmentRef EOF ;
    public final void entryRuleContainmentRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:632:24: ( ruleContainmentRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:633:2: ruleContainmentRef EOF
            {
             markComposite(elementTypeProvider.getContainmentRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef_in_entryRuleContainmentRef1972);
            ruleContainmentRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef1978); 

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
    // $ANTLR end "entryRuleContainmentRef"


    // $ANTLR start "ruleContainmentRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:639:1: ruleContainmentRef : ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) ;
    public final void ruleContainmentRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:639:19: ( ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:640:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:640:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:641:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:641:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:642:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:642:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:643:5: lv_ctx_0_0= ruleContainmentRef1
                    {

                    					markComposite(elementTypeProvider.getContainmentRef_CtxContainmentRef1ParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef1_in_ruleContainmentRef2010);
                    ruleContainmentRef1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:653:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:653:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:654:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:654:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:655:5: lv_ctx_1_0= ruleContainmentRef2
                    {

                    					markComposite(elementTypeProvider.getContainmentRef_CtxContainmentRef2ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef2_in_ruleContainmentRef2056);
                    ruleContainmentRef2();

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
    // $ANTLR end "ruleContainmentRef"


    // $ANTLR start "entryRuleContainmentRef1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:668:1: entryRuleContainmentRef1 : ruleContainmentRef1 EOF ;
    public final void entryRuleContainmentRef1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:668:25: ( ruleContainmentRef1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:669:2: ruleContainmentRef1 EOF
            {
             markComposite(elementTypeProvider.getContainmentRef1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef1_in_entryRuleContainmentRef12087);
            ruleContainmentRef1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef12093); 

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
    // $ANTLR end "entryRuleContainmentRef1"


    // $ANTLR start "ruleContainmentRef1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:675:1: ruleContainmentRef1 : (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) ;
    public final void ruleContainmentRef1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:675:20: ( (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:676:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:676:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:677:3: otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleContainmentRef12112); 

            			doneLeaf(otherlv_0, elementTypeProvider.getContainmentRef1_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:684:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:685:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:685:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:686:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentRef12139); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getContainmentRef1_Val1IDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleContainmentRef1"


    // $ANTLR start "entryRuleContainmentRef2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:699:1: entryRuleContainmentRef2 : ruleContainmentRef2 EOF ;
    public final void entryRuleContainmentRef2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:699:25: ( ruleContainmentRef2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:700:2: ruleContainmentRef2 EOF
            {
             markComposite(elementTypeProvider.getContainmentRef2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef2_in_entryRuleContainmentRef22170);
            ruleContainmentRef2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef22176); 

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
    // $ANTLR end "entryRuleContainmentRef2"


    // $ANTLR start "ruleContainmentRef2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:706:1: ruleContainmentRef2 : (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) ;
    public final void ruleContainmentRef2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val2_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:706:20: ( (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:707:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:707:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:708:3: otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleContainmentRef22195); 

            			doneLeaf(otherlv_0, elementTypeProvider.getContainmentRef2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:715:3: ( (lv_val2_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:716:4: (lv_val2_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:716:4: (lv_val2_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:717:5: lv_val2_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentRef22222); 

            					doneLeaf(lv_val2_1_0, elementTypeProvider.getContainmentRef2_Val2IDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleContainmentRef2"


    // $ANTLR start "entryRuleCrossRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:730:1: entryRuleCrossRef : ruleCrossRef EOF ;
    public final void entryRuleCrossRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:730:18: ( ruleCrossRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:731:2: ruleCrossRef EOF
            {
             markComposite(elementTypeProvider.getCrossRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossRef_in_entryRuleCrossRef2253);
            ruleCrossRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossRef2259); 

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
    // $ANTLR end "entryRuleCrossRef"


    // $ANTLR start "ruleCrossRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:737:1: ruleCrossRef : ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) ;
    public final void ruleCrossRef() throws RecognitionException {
        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:737:13: ( ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:738:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:738:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:739:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:739:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:740:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:740:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:741:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:741:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_TERMINAL1) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_TERMINAL2) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:742:6: lv_name_0_1= RULE_TERMINAL1
                    {

                    						markLeaf();
                    					
                    lv_name_0_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2299); 

                    						doneLeaf(lv_name_0_1, elementTypeProvider.getCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:750:6: lv_name_0_2= RULE_TERMINAL2
                    {

                    						markLeaf();
                    					
                    lv_name_0_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2333); 

                    						doneLeaf(lv_name_0_2, elementTypeProvider.getCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:760:3: ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_TERMINAL1) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_TERMINAL2) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:761:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:761:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:762:5: (otherlv_1= RULE_TERMINAL1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:762:5: (otherlv_1= RULE_TERMINAL1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:763:6: otherlv_1= RULE_TERMINAL1
                    {

                    						markLeaf();
                    					
                    otherlv_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2386); 

                    						doneLeaf(otherlv_1, elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:773:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:773:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:774:5: (otherlv_2= RULE_TERMINAL2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:774:5: (otherlv_2= RULE_TERMINAL2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:775:6: otherlv_2= RULE_TERMINAL2
                    {

                    						markLeaf();
                    					
                    otherlv_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2440); 

                    						doneLeaf(otherlv_2, elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType());
                    					

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
    // $ANTLR end "ruleCrossRef"


    // $ANTLR start "ruleEnum1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:789:1: ruleEnum1 : (enumLiteral_0= 'lit1' ) ;
    public final void ruleEnum1() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:789:10: ( (enumLiteral_0= 'lit1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:790:2: (enumLiteral_0= 'lit1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:790:2: (enumLiteral_0= 'lit1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:791:3: enumLiteral_0= 'lit1'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnum12485); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getEnum1_Lit1EnumLiteralDeclarationElementType());
            		

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
    // $ANTLR end "ruleEnum1"


    // $ANTLR start "ruleEnum2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:802:1: ruleEnum2 : (enumLiteral_0= 'lit2' ) ;
    public final void ruleEnum2() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:802:10: ( (enumLiteral_0= 'lit2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:803:2: (enumLiteral_0= 'lit2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:803:2: (enumLiteral_0= 'lit2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalAssignmentFinderTestLanguage.g:804:3: enumLiteral_0= 'lit2'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEnum22512); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getEnum2_Lit2EnumLiteralDeclarationElementType());
            		

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
    // $ANTLR end "ruleEnum2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel85 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleKeywordVal_in_ruleModel117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel163 = new BitSet(new long[]{0x0000000002000030L});
        public static final BitSet FOLLOW_ruleTerminalVal_in_ruleModel195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel241 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleEnumVal_in_ruleModel273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel319 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleKeywordBool_in_ruleModel351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel397 = new BitSet(new long[]{0x0000000002000030L});
        public static final BitSet FOLLOW_ruleTerminalBool_in_ruleModel429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel475 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleEnumBool_in_ruleModel507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel553 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_ruleMixedBool_in_ruleModel585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel631 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_ruleMixedValue_in_ruleModel663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModel709 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleContainmentRef_in_ruleModel741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleModel787 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossRef_in_ruleModel819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeywordVal_in_entryRuleKeywordVal857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeywordVal863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleKeywordVal895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleKeywordVal941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalVal_in_entryRuleTerminalVal972 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalVal978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleTerminalVal1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleTerminalVal1056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalVal1102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumVal_in_entryRuleEnumVal1133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumVal1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumVal1171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum2_in_ruleEnumVal1217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeywordBool_in_entryRuleKeywordBool1248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeywordBool1254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleKeywordBool1286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleKeywordBool1332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalBool_in_entryRuleTerminalBool1363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalBool1369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleTerminalBool1401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleTerminalBool1447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalBool1493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumBool_in_entryRuleEnumBool1524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBool1530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumBool1562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum2_in_ruleEnumBool1608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMixedBool_in_entryRuleMixedBool1639 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMixedBool1645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMixedBool1677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleMixedBool1723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleBoolean1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleBoolean1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMixedValue_in_entryRuleMixedValue1821 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMixedValue1827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleMixedValue1859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatEnum_in_ruleMixedValue1905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatEnum_in_entryRuleDatEnum1936 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatEnum1942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleDatEnum1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef_in_entryRuleContainmentRef1972 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef1978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef1_in_ruleContainmentRef2010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef2_in_ruleContainmentRef2056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef1_in_entryRuleContainmentRef12087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef12093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleContainmentRef12112 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentRef12139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef2_in_entryRuleContainmentRef22170 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef22176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleContainmentRef22195 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentRef22222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossRef_in_entryRuleCrossRef2253 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossRef2259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2299 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2333 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEnum12485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleEnum22512 = new BitSet(new long[]{0x0000000000000002L});
    }


}