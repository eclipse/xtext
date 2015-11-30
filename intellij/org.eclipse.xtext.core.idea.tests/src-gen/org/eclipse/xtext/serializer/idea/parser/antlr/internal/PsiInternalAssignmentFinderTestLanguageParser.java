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
    public String getGrammarFileName() { return "PsiInternalAssignmentFinderTestLanguage.g"; }



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
    // PsiInternalAssignmentFinderTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentFinderTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_keywordVal_1_0 = null;

        Boolean lv_terminalVal_3_0 = null;

        Boolean lv_enumVal_5_0 = null;

        Boolean lv_keywordBool_7_0 = null;

        Boolean lv_terminalBool_9_0 = null;

        Boolean lv_enumBool_11_0 = null;

        Boolean lv_mixedBool_13_0 = null;

        Boolean lv_mixedValue_15_0 = null;

        Boolean lv_containmentRef_17_0 = null;

        Boolean lv_crossRef_19_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:60:1: ( ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:61:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:61:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:62:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:62:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:63:4: otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitZeroKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:70:4: ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:71:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:71:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    // PsiInternalAssignmentFinderTestLanguage.g:72:6: lv_keywordVal_1_0= ruleKeywordVal
                    {

                    						markComposite(elementTypeProvider.getModel_KeywordValKeywordValParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_keywordVal_1_0=ruleKeywordVal();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:87:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:87:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:88:4: otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitOneKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:95:4: ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:96:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:96:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    // PsiInternalAssignmentFinderTestLanguage.g:97:6: lv_terminalVal_3_0= ruleTerminalVal
                    {

                    						markComposite(elementTypeProvider.getModel_TerminalValTerminalValParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_terminalVal_3_0=ruleTerminalVal();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:112:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:112:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:113:4: otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitTwoKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:120:4: ( (lv_enumVal_5_0= ruleEnumVal ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:121:5: (lv_enumVal_5_0= ruleEnumVal )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:121:5: (lv_enumVal_5_0= ruleEnumVal )
                    // PsiInternalAssignmentFinderTestLanguage.g:122:6: lv_enumVal_5_0= ruleEnumVal
                    {

                    						markComposite(elementTypeProvider.getModel_EnumValEnumValParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_enumVal_5_0=ruleEnumVal();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:137:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:137:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:138:4: otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitThreeKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:145:4: ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:146:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:146:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    // PsiInternalAssignmentFinderTestLanguage.g:147:6: lv_keywordBool_7_0= ruleKeywordBool
                    {

                    						markComposite(elementTypeProvider.getModel_KeywordBoolKeywordBoolParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_keywordBool_7_0=ruleKeywordBool();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:162:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:162:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:163:4: otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitFourKeyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:170:4: ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:171:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:171:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    // PsiInternalAssignmentFinderTestLanguage.g:172:6: lv_terminalBool_9_0= ruleTerminalBool
                    {

                    						markComposite(elementTypeProvider.getModel_TerminalBoolTerminalBoolParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_terminalBool_9_0=ruleTerminalBool();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:187:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:187:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:188:4: otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitFiveKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:195:4: ( (lv_enumBool_11_0= ruleEnumBool ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:196:5: (lv_enumBool_11_0= ruleEnumBool )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:196:5: (lv_enumBool_11_0= ruleEnumBool )
                    // PsiInternalAssignmentFinderTestLanguage.g:197:6: lv_enumBool_11_0= ruleEnumBool
                    {

                    						markComposite(elementTypeProvider.getModel_EnumBoolEnumBoolParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_enumBool_11_0=ruleEnumBool();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:212:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:212:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:213:4: otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitSixKeyword_6_0ElementType());
                    			
                    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_12);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:220:4: ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:221:5: (lv_mixedBool_13_0= ruleMixedBool )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:221:5: (lv_mixedBool_13_0= ruleMixedBool )
                    // PsiInternalAssignmentFinderTestLanguage.g:222:6: lv_mixedBool_13_0= ruleMixedBool
                    {

                    						markComposite(elementTypeProvider.getModel_MixedBoolMixedBoolParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixedBool_13_0=ruleMixedBool();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:237:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:237:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:238:4: otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitSevenKeyword_7_0ElementType());
                    			
                    otherlv_14=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_14);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:245:4: ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:246:5: (lv_mixedValue_15_0= ruleMixedValue )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:246:5: (lv_mixedValue_15_0= ruleMixedValue )
                    // PsiInternalAssignmentFinderTestLanguage.g:247:6: lv_mixedValue_15_0= ruleMixedValue
                    {

                    						markComposite(elementTypeProvider.getModel_MixedValueMixedValueParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixedValue_15_0=ruleMixedValue();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:262:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:262:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:263:4: otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitEightKeyword_8_0ElementType());
                    			
                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_16);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:270:4: ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:271:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:271:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    // PsiInternalAssignmentFinderTestLanguage.g:272:6: lv_containmentRef_17_0= ruleContainmentRef
                    {

                    						markComposite(elementTypeProvider.getModel_ContainmentRefContainmentRefParserRuleCall_8_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_containmentRef_17_0=ruleContainmentRef();

                    state._fsp--;


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
                    // PsiInternalAssignmentFinderTestLanguage.g:287:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:287:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:288:4: otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroDigitNineKeyword_9_0ElementType());
                    			
                    otherlv_18=(Token)match(input,22,FollowSets000.FOLLOW_8); 

                    				doneLeaf(otherlv_18);
                    			
                    // PsiInternalAssignmentFinderTestLanguage.g:295:4: ( (lv_crossRef_19_0= ruleCrossRef ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:296:5: (lv_crossRef_19_0= ruleCrossRef )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:296:5: (lv_crossRef_19_0= ruleCrossRef )
                    // PsiInternalAssignmentFinderTestLanguage.g:297:6: lv_crossRef_19_0= ruleCrossRef
                    {

                    						markComposite(elementTypeProvider.getModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_crossRef_19_0=ruleCrossRef();

                    state._fsp--;


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


    // $ANTLR start "entryRuleKeywordVal"
    // PsiInternalAssignmentFinderTestLanguage.g:315:1: entryRuleKeywordVal returns [Boolean current=false] : iv_ruleKeywordVal= ruleKeywordVal EOF ;
    public final Boolean entryRuleKeywordVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKeywordVal = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:315:52: (iv_ruleKeywordVal= ruleKeywordVal EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:316:2: iv_ruleKeywordVal= ruleKeywordVal EOF
            {
             markComposite(elementTypeProvider.getKeywordValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeywordVal=ruleKeywordVal();

            state._fsp--;

             current =iv_ruleKeywordVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleKeywordVal"


    // $ANTLR start "ruleKeywordVal"
    // PsiInternalAssignmentFinderTestLanguage.g:322:1: ruleKeywordVal returns [Boolean current=false] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final Boolean ruleKeywordVal() throws RecognitionException {
        Boolean current = false;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:323:1: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:324:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:324:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:325:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:325:3: ( (lv_kw_0_0= 'kw1' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:326:4: (lv_kw_0_0= 'kw1' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:326:4: (lv_kw_0_0= 'kw1' )
                    // PsiInternalAssignmentFinderTestLanguage.g:327:5: lv_kw_0_0= 'kw1'
                    {

                    					markLeaf(elementTypeProvider.getKeywordVal_KwKw1Keyword_0_0ElementType());
                    				
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_kw_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:343:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:343:3: ( (lv_kw_1_0= 'kw2' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:344:4: (lv_kw_1_0= 'kw2' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:344:4: (lv_kw_1_0= 'kw2' )
                    // PsiInternalAssignmentFinderTestLanguage.g:345:5: lv_kw_1_0= 'kw2'
                    {

                    					markLeaf(elementTypeProvider.getKeywordVal_KwKw2Keyword_1_0ElementType());
                    				
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_kw_1_0);
                    				

                    					if (!current) {
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordVal"


    // $ANTLR start "entryRuleTerminalVal"
    // PsiInternalAssignmentFinderTestLanguage.g:364:1: entryRuleTerminalVal returns [Boolean current=false] : iv_ruleTerminalVal= ruleTerminalVal EOF ;
    public final Boolean entryRuleTerminalVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalVal = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:364:53: (iv_ruleTerminalVal= ruleTerminalVal EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:365:2: iv_ruleTerminalVal= ruleTerminalVal EOF
            {
             markComposite(elementTypeProvider.getTerminalValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalVal=ruleTerminalVal();

            state._fsp--;

             current =iv_ruleTerminalVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTerminalVal"


    // $ANTLR start "ruleTerminalVal"
    // PsiInternalAssignmentFinderTestLanguage.g:371:1: ruleTerminalVal returns [Boolean current=false] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final Boolean ruleTerminalVal() throws RecognitionException {
        Boolean current = false;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:372:1: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:373:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:373:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:374:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:374:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:375:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:375:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:376:5: lv_term_0_0= RULE_TERMINAL1
                    {

                    					markLeaf(elementTypeProvider.getTerminalVal_TermTerminal1TerminalRuleCall_0_0ElementType());
                    				
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_term_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:392:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:392:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:393:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:393:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:394:5: lv_term_1_0= RULE_TERMINAL2
                    {

                    					markLeaf(elementTypeProvider.getTerminalVal_TermTerminal2TerminalRuleCall_1_0ElementType());
                    				
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_term_1_0);
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalAssignmentFinderTestLanguage.g:410:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:410:3: ( (lv_term_2_0= '%foo' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:411:4: (lv_term_2_0= '%foo' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:411:4: (lv_term_2_0= '%foo' )
                    // PsiInternalAssignmentFinderTestLanguage.g:412:5: lv_term_2_0= '%foo'
                    {

                    					markLeaf(elementTypeProvider.getTerminalVal_TermFooKeyword_2_0ElementType());
                    				
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_term_2_0);
                    				

                    					if (!current) {
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalVal"


    // $ANTLR start "entryRuleEnumVal"
    // PsiInternalAssignmentFinderTestLanguage.g:431:1: entryRuleEnumVal returns [Boolean current=false] : iv_ruleEnumVal= ruleEnumVal EOF ;
    public final Boolean entryRuleEnumVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumVal = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:431:49: (iv_ruleEnumVal= ruleEnumVal EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:432:2: iv_ruleEnumVal= ruleEnumVal EOF
            {
             markComposite(elementTypeProvider.getEnumValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumVal=ruleEnumVal();

            state._fsp--;

             current =iv_ruleEnumVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnumVal"


    // $ANTLR start "ruleEnumVal"
    // PsiInternalAssignmentFinderTestLanguage.g:438:1: ruleEnumVal returns [Boolean current=false] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final Boolean ruleEnumVal() throws RecognitionException {
        Boolean current = false;

        Boolean lv_en_0_0 = null;

        Boolean lv_en_1_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:439:1: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:440:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:440:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:441:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:441:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:442:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:442:4: (lv_en_0_0= ruleEnum1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:443:5: lv_en_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getEnumVal_EnEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:457:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:457:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:458:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:458:4: (lv_en_1_0= ruleEnum2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:459:5: lv_en_1_0= ruleEnum2
                    {

                    					markComposite(elementTypeProvider.getEnumVal_EnEnum2EnumRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumVal"


    // $ANTLR start "entryRuleKeywordBool"
    // PsiInternalAssignmentFinderTestLanguage.g:476:1: entryRuleKeywordBool returns [Boolean current=false] : iv_ruleKeywordBool= ruleKeywordBool EOF ;
    public final Boolean entryRuleKeywordBool() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleKeywordBool = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:476:53: (iv_ruleKeywordBool= ruleKeywordBool EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:477:2: iv_ruleKeywordBool= ruleKeywordBool EOF
            {
             markComposite(elementTypeProvider.getKeywordBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeywordBool=ruleKeywordBool();

            state._fsp--;

             current =iv_ruleKeywordBool; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleKeywordBool"


    // $ANTLR start "ruleKeywordBool"
    // PsiInternalAssignmentFinderTestLanguage.g:483:1: ruleKeywordBool returns [Boolean current=false] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final Boolean ruleKeywordBool() throws RecognitionException {
        Boolean current = false;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:484:1: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:485:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:485:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:486:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:486:3: ( (lv_kw_0_0= 'kw1' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:487:4: (lv_kw_0_0= 'kw1' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:487:4: (lv_kw_0_0= 'kw1' )
                    // PsiInternalAssignmentFinderTestLanguage.g:488:5: lv_kw_0_0= 'kw1'
                    {

                    					markLeaf(elementTypeProvider.getKeywordBool_KwKw1Keyword_0_0ElementType());
                    				
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_kw_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:504:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:504:3: ( (lv_kw_1_0= 'kw2' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:505:4: (lv_kw_1_0= 'kw2' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:505:4: (lv_kw_1_0= 'kw2' )
                    // PsiInternalAssignmentFinderTestLanguage.g:506:5: lv_kw_1_0= 'kw2'
                    {

                    					markLeaf(elementTypeProvider.getKeywordBool_KwKw2Keyword_1_0ElementType());
                    				
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_kw_1_0);
                    				

                    					if (!current) {
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordBool"


    // $ANTLR start "entryRuleTerminalBool"
    // PsiInternalAssignmentFinderTestLanguage.g:525:1: entryRuleTerminalBool returns [Boolean current=false] : iv_ruleTerminalBool= ruleTerminalBool EOF ;
    public final Boolean entryRuleTerminalBool() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalBool = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:525:54: (iv_ruleTerminalBool= ruleTerminalBool EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:526:2: iv_ruleTerminalBool= ruleTerminalBool EOF
            {
             markComposite(elementTypeProvider.getTerminalBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalBool=ruleTerminalBool();

            state._fsp--;

             current =iv_ruleTerminalBool; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTerminalBool"


    // $ANTLR start "ruleTerminalBool"
    // PsiInternalAssignmentFinderTestLanguage.g:532:1: ruleTerminalBool returns [Boolean current=false] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final Boolean ruleTerminalBool() throws RecognitionException {
        Boolean current = false;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:533:1: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:534:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:534:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:535:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:535:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:536:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:536:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:537:5: lv_term_0_0= RULE_TERMINAL1
                    {

                    					markLeaf(elementTypeProvider.getTerminalBool_TermTerminal1TerminalRuleCall_0_0ElementType());
                    				
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_term_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:553:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:553:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:554:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:554:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:555:5: lv_term_1_0= RULE_TERMINAL2
                    {

                    					markLeaf(elementTypeProvider.getTerminalBool_TermTerminal2TerminalRuleCall_1_0ElementType());
                    				
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_term_1_0);
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalAssignmentFinderTestLanguage.g:571:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:571:3: ( (lv_term_2_0= '%foo' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:572:4: (lv_term_2_0= '%foo' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:572:4: (lv_term_2_0= '%foo' )
                    // PsiInternalAssignmentFinderTestLanguage.g:573:5: lv_term_2_0= '%foo'
                    {

                    					markLeaf(elementTypeProvider.getTerminalBool_TermFooKeyword_2_0ElementType());
                    				
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_term_2_0);
                    				

                    					if (!current) {
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalBool"


    // $ANTLR start "entryRuleEnumBool"
    // PsiInternalAssignmentFinderTestLanguage.g:592:1: entryRuleEnumBool returns [Boolean current=false] : iv_ruleEnumBool= ruleEnumBool EOF ;
    public final Boolean entryRuleEnumBool() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumBool = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:592:50: (iv_ruleEnumBool= ruleEnumBool EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:593:2: iv_ruleEnumBool= ruleEnumBool EOF
            {
             markComposite(elementTypeProvider.getEnumBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumBool=ruleEnumBool();

            state._fsp--;

             current =iv_ruleEnumBool; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnumBool"


    // $ANTLR start "ruleEnumBool"
    // PsiInternalAssignmentFinderTestLanguage.g:599:1: ruleEnumBool returns [Boolean current=false] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final Boolean ruleEnumBool() throws RecognitionException {
        Boolean current = false;

        Boolean lv_en_0_0 = null;

        Boolean lv_en_1_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:600:1: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:601:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:601:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:602:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:602:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:603:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:603:4: (lv_en_0_0= ruleEnum1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:604:5: lv_en_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getEnumBool_EnEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:618:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:618:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:619:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:619:4: (lv_en_1_0= ruleEnum2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:620:5: lv_en_1_0= ruleEnum2
                    {

                    					markComposite(elementTypeProvider.getEnumBool_EnEnum2EnumRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumBool"


    // $ANTLR start "entryRuleMixedBool"
    // PsiInternalAssignmentFinderTestLanguage.g:637:1: entryRuleMixedBool returns [Boolean current=false] : iv_ruleMixedBool= ruleMixedBool EOF ;
    public final Boolean entryRuleMixedBool() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMixedBool = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:637:51: (iv_ruleMixedBool= ruleMixedBool EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:638:2: iv_ruleMixedBool= ruleMixedBool EOF
            {
             markComposite(elementTypeProvider.getMixedBoolElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixedBool=ruleMixedBool();

            state._fsp--;

             current =iv_ruleMixedBool; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMixedBool"


    // $ANTLR start "ruleMixedBool"
    // PsiInternalAssignmentFinderTestLanguage.g:644:1: ruleMixedBool returns [Boolean current=false] : ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) ;
    public final Boolean ruleMixedBool() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;
        Boolean lv_val_1_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:645:1: ( ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:646:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:646:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:647:3: ( (lv_val_0_0= 'kw1' ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:647:3: ( (lv_val_0_0= 'kw1' ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:648:4: (lv_val_0_0= 'kw1' )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:648:4: (lv_val_0_0= 'kw1' )
                    // PsiInternalAssignmentFinderTestLanguage.g:649:5: lv_val_0_0= 'kw1'
                    {

                    					markLeaf(elementTypeProvider.getMixedBool_ValKw1Keyword_0_0ElementType());
                    				
                    lv_val_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_val_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:665:3: ( (lv_val_1_0= ruleBoolean ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:665:3: ( (lv_val_1_0= ruleBoolean ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:666:4: (lv_val_1_0= ruleBoolean )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:666:4: (lv_val_1_0= ruleBoolean )
                    // PsiInternalAssignmentFinderTestLanguage.g:667:5: lv_val_1_0= ruleBoolean
                    {

                    					markComposite(elementTypeProvider.getMixedBool_ValBooleanParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_0=ruleBoolean();

                    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMixedBool"


    // $ANTLR start "entryRuleBoolean"
    // PsiInternalAssignmentFinderTestLanguage.g:684:1: entryRuleBoolean returns [Boolean current=false] : iv_ruleBoolean= ruleBoolean EOF ;
    public final Boolean entryRuleBoolean() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBoolean = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:684:49: (iv_ruleBoolean= ruleBoolean EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:685:2: iv_ruleBoolean= ruleBoolean EOF
            {
             markComposite(elementTypeProvider.getBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // PsiInternalAssignmentFinderTestLanguage.g:691:1: ruleBoolean returns [Boolean current=false] : (kw= 'true' | kw= 'false' ) ;
    public final Boolean ruleBoolean() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:692:1: ( (kw= 'true' | kw= 'false' ) )
            // PsiInternalAssignmentFinderTestLanguage.g:693:2: (kw= 'true' | kw= 'false' )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:693:2: (kw= 'true' | kw= 'false' )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:694:3: kw= 'true'
                    {

                    			markLeaf(elementTypeProvider.getBoolean_TrueKeyword_0ElementType());
                    		
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:702:3: kw= 'false'
                    {

                    			markLeaf(elementTypeProvider.getBoolean_FalseKeyword_1ElementType());
                    		
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleMixedValue"
    // PsiInternalAssignmentFinderTestLanguage.g:713:1: entryRuleMixedValue returns [Boolean current=false] : iv_ruleMixedValue= ruleMixedValue EOF ;
    public final Boolean entryRuleMixedValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMixedValue = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:713:52: (iv_ruleMixedValue= ruleMixedValue EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:714:2: iv_ruleMixedValue= ruleMixedValue EOF
            {
             markComposite(elementTypeProvider.getMixedValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixedValue=ruleMixedValue();

            state._fsp--;

             current =iv_ruleMixedValue; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMixedValue"


    // $ANTLR start "ruleMixedValue"
    // PsiInternalAssignmentFinderTestLanguage.g:720:1: ruleMixedValue returns [Boolean current=false] : ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) ;
    public final Boolean ruleMixedValue() throws RecognitionException {
        Boolean current = false;

        Boolean lv_val_0_0 = null;

        Boolean lv_val_1_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:721:1: ( ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:722:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:722:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:723:3: ( (lv_val_0_0= ruleEnum1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:723:3: ( (lv_val_0_0= ruleEnum1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:724:4: (lv_val_0_0= ruleEnum1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:724:4: (lv_val_0_0= ruleEnum1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:725:5: lv_val_0_0= ruleEnum1
                    {

                    					markComposite(elementTypeProvider.getMixedValue_ValEnum1EnumRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_0_0=ruleEnum1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:739:3: ( (lv_val_1_0= ruleDatEnum ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:739:3: ( (lv_val_1_0= ruleDatEnum ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:740:4: (lv_val_1_0= ruleDatEnum )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:740:4: (lv_val_1_0= ruleDatEnum )
                    // PsiInternalAssignmentFinderTestLanguage.g:741:5: lv_val_1_0= ruleDatEnum
                    {

                    					markComposite(elementTypeProvider.getMixedValue_ValDatEnumParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_0=ruleDatEnum();

                    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMixedValue"


    // $ANTLR start "entryRuleDatEnum"
    // PsiInternalAssignmentFinderTestLanguage.g:758:1: entryRuleDatEnum returns [Boolean current=false] : iv_ruleDatEnum= ruleDatEnum EOF ;
    public final Boolean entryRuleDatEnum() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatEnum = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:758:49: (iv_ruleDatEnum= ruleDatEnum EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:759:2: iv_ruleDatEnum= ruleDatEnum EOF
            {
             markComposite(elementTypeProvider.getDatEnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatEnum=ruleDatEnum();

            state._fsp--;

             current =iv_ruleDatEnum; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDatEnum"


    // $ANTLR start "ruleDatEnum"
    // PsiInternalAssignmentFinderTestLanguage.g:765:1: ruleDatEnum returns [Boolean current=false] : kw= 'lit3' ;
    public final Boolean ruleDatEnum() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:766:1: (kw= 'lit3' )
            // PsiInternalAssignmentFinderTestLanguage.g:767:2: kw= 'lit3'
            {

            		markLeaf(elementTypeProvider.getDatEnum_Lit3KeywordElementType());
            	
            kw=(Token)match(input,28,FollowSets000.FOLLOW_2); 

            		doneLeaf(kw);
            	

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
    // $ANTLR end "ruleDatEnum"


    // $ANTLR start "entryRuleContainmentRef"
    // PsiInternalAssignmentFinderTestLanguage.g:777:1: entryRuleContainmentRef returns [Boolean current=false] : iv_ruleContainmentRef= ruleContainmentRef EOF ;
    public final Boolean entryRuleContainmentRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleContainmentRef = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:777:56: (iv_ruleContainmentRef= ruleContainmentRef EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:778:2: iv_ruleContainmentRef= ruleContainmentRef EOF
            {
             markComposite(elementTypeProvider.getContainmentRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef=ruleContainmentRef();

            state._fsp--;

             current =iv_ruleContainmentRef; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleContainmentRef"


    // $ANTLR start "ruleContainmentRef"
    // PsiInternalAssignmentFinderTestLanguage.g:784:1: ruleContainmentRef returns [Boolean current=false] : ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) ;
    public final Boolean ruleContainmentRef() throws RecognitionException {
        Boolean current = false;

        Boolean lv_ctx_0_0 = null;

        Boolean lv_ctx_1_0 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:785:1: ( ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:786:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:786:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:787:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:787:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:788:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:788:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:789:5: lv_ctx_0_0= ruleContainmentRef1
                    {

                    					markComposite(elementTypeProvider.getContainmentRef_CtxContainmentRef1ParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ctx_0_0=ruleContainmentRef1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:803:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:803:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:804:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:804:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:805:5: lv_ctx_1_0= ruleContainmentRef2
                    {

                    					markComposite(elementTypeProvider.getContainmentRef_CtxContainmentRef2ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ctx_1_0=ruleContainmentRef2();

                    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentRef"


    // $ANTLR start "entryRuleContainmentRef1"
    // PsiInternalAssignmentFinderTestLanguage.g:822:1: entryRuleContainmentRef1 returns [Boolean current=false] : iv_ruleContainmentRef1= ruleContainmentRef1 EOF ;
    public final Boolean entryRuleContainmentRef1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleContainmentRef1 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:822:57: (iv_ruleContainmentRef1= ruleContainmentRef1 EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:823:2: iv_ruleContainmentRef1= ruleContainmentRef1 EOF
            {
             markComposite(elementTypeProvider.getContainmentRef1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef1=ruleContainmentRef1();

            state._fsp--;

             current =iv_ruleContainmentRef1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleContainmentRef1"


    // $ANTLR start "ruleContainmentRef1"
    // PsiInternalAssignmentFinderTestLanguage.g:829:1: ruleContainmentRef1 returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleContainmentRef1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:830:1: ( (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:831:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:831:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:832:3: otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getContainmentRef1_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAssignmentFinderTestLanguage.g:839:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalAssignmentFinderTestLanguage.g:840:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:840:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalAssignmentFinderTestLanguage.g:841:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getContainmentRef1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

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
    // $ANTLR end "ruleContainmentRef1"


    // $ANTLR start "entryRuleContainmentRef2"
    // PsiInternalAssignmentFinderTestLanguage.g:860:1: entryRuleContainmentRef2 returns [Boolean current=false] : iv_ruleContainmentRef2= ruleContainmentRef2 EOF ;
    public final Boolean entryRuleContainmentRef2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleContainmentRef2 = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:860:57: (iv_ruleContainmentRef2= ruleContainmentRef2 EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:861:2: iv_ruleContainmentRef2= ruleContainmentRef2 EOF
            {
             markComposite(elementTypeProvider.getContainmentRef2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef2=ruleContainmentRef2();

            state._fsp--;

             current =iv_ruleContainmentRef2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleContainmentRef2"


    // $ANTLR start "ruleContainmentRef2"
    // PsiInternalAssignmentFinderTestLanguage.g:867:1: ruleContainmentRef2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleContainmentRef2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val2_1_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:868:1: ( (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:869:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:869:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:870:3: otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getContainmentRef2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAssignmentFinderTestLanguage.g:877:3: ( (lv_val2_1_0= RULE_ID ) )
            // PsiInternalAssignmentFinderTestLanguage.g:878:4: (lv_val2_1_0= RULE_ID )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:878:4: (lv_val2_1_0= RULE_ID )
            // PsiInternalAssignmentFinderTestLanguage.g:879:5: lv_val2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getContainmentRef2_Val2IDTerminalRuleCall_1_0ElementType());
            				
            lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val2_1_0);
            				

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
    // $ANTLR end "ruleContainmentRef2"


    // $ANTLR start "entryRuleCrossRef"
    // PsiInternalAssignmentFinderTestLanguage.g:898:1: entryRuleCrossRef returns [Boolean current=false] : iv_ruleCrossRef= ruleCrossRef EOF ;
    public final Boolean entryRuleCrossRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossRef = null;


        try {
            // PsiInternalAssignmentFinderTestLanguage.g:898:50: (iv_ruleCrossRef= ruleCrossRef EOF )
            // PsiInternalAssignmentFinderTestLanguage.g:899:2: iv_ruleCrossRef= ruleCrossRef EOF
            {
             markComposite(elementTypeProvider.getCrossRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRef=ruleCrossRef();

            state._fsp--;

             current =iv_ruleCrossRef; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleCrossRef"


    // $ANTLR start "ruleCrossRef"
    // PsiInternalAssignmentFinderTestLanguage.g:905:1: ruleCrossRef returns [Boolean current=false] : ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) ;
    public final Boolean ruleCrossRef() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:906:1: ( ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:907:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:907:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:908:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:908:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) )
            // PsiInternalAssignmentFinderTestLanguage.g:909:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:909:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            // PsiInternalAssignmentFinderTestLanguage.g:910:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:910:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:911:6: lv_name_0_1= RULE_TERMINAL1
                    {

                    						markLeaf(elementTypeProvider.getCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType());
                    					
                    lv_name_0_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_8); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:925:6: lv_name_0_2= RULE_TERMINAL2
                    {

                    						markLeaf(elementTypeProvider.getCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType());
                    					
                    lv_name_0_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_8); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_0_2);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalAssignmentFinderTestLanguage.g:941:3: ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
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
                    // PsiInternalAssignmentFinderTestLanguage.g:942:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:942:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:943:5: (otherlv_1= RULE_TERMINAL1 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:943:5: (otherlv_1= RULE_TERMINAL1 )
                    // PsiInternalAssignmentFinderTestLanguage.g:944:6: otherlv_1= RULE_TERMINAL1
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType());
                    					
                    otherlv_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_1);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentFinderTestLanguage.g:960:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:960:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    // PsiInternalAssignmentFinderTestLanguage.g:961:5: (otherlv_2= RULE_TERMINAL2 )
                    {
                    // PsiInternalAssignmentFinderTestLanguage.g:961:5: (otherlv_2= RULE_TERMINAL2 )
                    // PsiInternalAssignmentFinderTestLanguage.g:962:6: otherlv_2= RULE_TERMINAL2
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_2);
                    					

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
    // $ANTLR end "ruleCrossRef"


    // $ANTLR start "ruleEnum1"
    // PsiInternalAssignmentFinderTestLanguage.g:982:1: ruleEnum1 returns [Boolean current=false] : (enumLiteral_0= 'lit1' ) ;
    public final Boolean ruleEnum1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:983:1: ( (enumLiteral_0= 'lit1' ) )
            // PsiInternalAssignmentFinderTestLanguage.g:984:2: (enumLiteral_0= 'lit1' )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:984:2: (enumLiteral_0= 'lit1' )
            // PsiInternalAssignmentFinderTestLanguage.g:985:3: enumLiteral_0= 'lit1'
            {

            			markLeaf(elementTypeProvider.getEnum1_Lit1EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleEnum1"


    // $ANTLR start "ruleEnum2"
    // PsiInternalAssignmentFinderTestLanguage.g:996:1: ruleEnum2 returns [Boolean current=false] : (enumLiteral_0= 'lit2' ) ;
    public final Boolean ruleEnum2() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalAssignmentFinderTestLanguage.g:997:1: ( (enumLiteral_0= 'lit2' ) )
            // PsiInternalAssignmentFinderTestLanguage.g:998:2: (enumLiteral_0= 'lit2' )
            {
            // PsiInternalAssignmentFinderTestLanguage.g:998:2: (enumLiteral_0= 'lit2' )
            // PsiInternalAssignmentFinderTestLanguage.g:999:3: enumLiteral_0= 'lit2'
            {

            			markLeaf(elementTypeProvider.getEnum2_Lit2EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleEnum2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000002000030L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    }


}