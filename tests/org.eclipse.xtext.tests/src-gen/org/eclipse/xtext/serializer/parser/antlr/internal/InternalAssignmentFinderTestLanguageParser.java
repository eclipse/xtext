package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssignmentFinderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TERMINAL1", "RULE_TERMINAL2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#0'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'kw1'", "'kw2'", "'%foo'", "'true'", "'false'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=6;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int RULE_TERMINAL1=4;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=8;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__22=22;
    public static final int RULE_TERMINAL2=5;
    public static final int RULE_WS=11;
    public static final int T__17=17;
    public static final int RULE_INT=7;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalAssignmentFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssignmentFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssignmentFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g"; }



     	private AssignmentFinderTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAssignmentFinderTestLanguageParser(TokenStream input, AssignmentFinderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected AssignmentFinderTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) ) | (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_keywordVal_1_0 = null;

        EObject lv_terminalVal_3_0 = null;

        EObject lv_enumVal_5_0 = null;

        EObject lv_keywordBool_7_0 = null;

        EObject lv_terminalBool_9_0 = null;

        EObject lv_enumBool_11_0 = null;

        EObject lv_mixedBool_13_0 = null;

        EObject lv_containmentRef_15_0 = null;

        EObject lv_crossRef_17_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:80:28: ( ( (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) ) | (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) ) | (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) ) | (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) ) )
            int alt1=9;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:81:2: (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:81:2: (otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:81:4: otherlv_0= '#0' ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitZeroKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:85:1: ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:86:1: (lv_keywordVal_1_0= ruleKeywordVal )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:86:1: (lv_keywordVal_1_0= ruleKeywordVal )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:87:3: lv_keywordVal_1_0= ruleKeywordVal
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getKeywordValKeywordValParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeywordVal_in_ruleModel144);
                    lv_keywordVal_1_0=ruleKeywordVal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"keywordVal",
                            		lv_keywordVal_1_0, 
                            		"KeywordVal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:104:6: (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:104:6: (otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:104:8: otherlv_2= '#1' ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel164); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:108:1: ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:109:1: (lv_terminalVal_3_0= ruleTerminalVal )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:109:1: (lv_terminalVal_3_0= ruleTerminalVal )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:110:3: lv_terminalVal_3_0= ruleTerminalVal
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getTerminalValTerminalValParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalVal_in_ruleModel185);
                    lv_terminalVal_3_0=ruleTerminalVal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"terminalVal",
                            		lv_terminalVal_3_0, 
                            		"TerminalVal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:127:6: (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:127:6: (otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:127:8: otherlv_4= '#2' ( (lv_enumVal_5_0= ruleEnumVal ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel205); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:131:1: ( (lv_enumVal_5_0= ruleEnumVal ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:132:1: (lv_enumVal_5_0= ruleEnumVal )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:132:1: (lv_enumVal_5_0= ruleEnumVal )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:133:3: lv_enumVal_5_0= ruleEnumVal
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getEnumValEnumValParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnumVal_in_ruleModel226);
                    lv_enumVal_5_0=ruleEnumVal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"enumVal",
                            		lv_enumVal_5_0, 
                            		"EnumVal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:150:6: (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:150:6: (otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:150:8: otherlv_6= '#3' ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    {
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel246); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:154:1: ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:155:1: (lv_keywordBool_7_0= ruleKeywordBool )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:155:1: (lv_keywordBool_7_0= ruleKeywordBool )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:156:3: lv_keywordBool_7_0= ruleKeywordBool
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getKeywordBoolKeywordBoolParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeywordBool_in_ruleModel267);
                    lv_keywordBool_7_0=ruleKeywordBool();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"keywordBool",
                            		lv_keywordBool_7_0, 
                            		"KeywordBool");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:173:6: (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:173:6: (otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:173:8: otherlv_8= '#4' ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel287); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:177:1: ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:178:1: (lv_terminalBool_9_0= ruleTerminalBool )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:178:1: (lv_terminalBool_9_0= ruleTerminalBool )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:179:3: lv_terminalBool_9_0= ruleTerminalBool
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getTerminalBoolTerminalBoolParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalBool_in_ruleModel308);
                    lv_terminalBool_9_0=ruleTerminalBool();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"terminalBool",
                            		lv_terminalBool_9_0, 
                            		"TerminalBool");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:196:6: (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:196:6: (otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:196:8: otherlv_10= '#5' ( (lv_enumBool_11_0= ruleEnumBool ) )
                    {
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel328); 

                        	newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:200:1: ( (lv_enumBool_11_0= ruleEnumBool ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:201:1: (lv_enumBool_11_0= ruleEnumBool )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:201:1: (lv_enumBool_11_0= ruleEnumBool )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:202:3: lv_enumBool_11_0= ruleEnumBool
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getEnumBoolEnumBoolParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnumBool_in_ruleModel349);
                    lv_enumBool_11_0=ruleEnumBool();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"enumBool",
                            		lv_enumBool_11_0, 
                            		"EnumBool");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:219:6: (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:219:6: (otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:219:8: otherlv_12= '#6' ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    {
                    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel369); 

                        	newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitSixKeyword_6_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:223:1: ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:224:1: (lv_mixedBool_13_0= ruleMixedBool )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:224:1: (lv_mixedBool_13_0= ruleMixedBool )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:225:3: lv_mixedBool_13_0= ruleMixedBool
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getMixedBoolMixedBoolParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMixedBool_in_ruleModel390);
                    lv_mixedBool_13_0=ruleMixedBool();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"mixedBool",
                            		lv_mixedBool_13_0, 
                            		"MixedBool");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:242:6: (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:242:6: (otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:242:8: otherlv_14= '#7' ( (lv_containmentRef_15_0= ruleContainmentRef ) )
                    {
                    otherlv_14=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel410); 

                        	newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitSevenKeyword_7_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:246:1: ( (lv_containmentRef_15_0= ruleContainmentRef ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:247:1: (lv_containmentRef_15_0= ruleContainmentRef )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:247:1: (lv_containmentRef_15_0= ruleContainmentRef )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:248:3: lv_containmentRef_15_0= ruleContainmentRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getContainmentRefContainmentRefParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef_in_ruleModel431);
                    lv_containmentRef_15_0=ruleContainmentRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"containmentRef",
                            		lv_containmentRef_15_0, 
                            		"ContainmentRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:265:6: (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:265:6: (otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:265:8: otherlv_16= '#8' ( (lv_crossRef_17_0= ruleCrossRef ) )
                    {
                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModel451); 

                        	newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitEightKeyword_8_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:269:1: ( (lv_crossRef_17_0= ruleCrossRef ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:270:1: (lv_crossRef_17_0= ruleCrossRef )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:270:1: (lv_crossRef_17_0= ruleCrossRef )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:271:3: lv_crossRef_17_0= ruleCrossRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getCrossRefCrossRefParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCrossRef_in_ruleModel472);
                    lv_crossRef_17_0=ruleCrossRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"crossRef",
                            		lv_crossRef_17_0, 
                            		"CrossRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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


    // $ANTLR start "entryRuleKeywordVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:295:1: entryRuleKeywordVal returns [EObject current=null] : iv_ruleKeywordVal= ruleKeywordVal EOF ;
    public final EObject entryRuleKeywordVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordVal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:296:2: (iv_ruleKeywordVal= ruleKeywordVal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:297:2: iv_ruleKeywordVal= ruleKeywordVal EOF
            {
             newCompositeNode(grammarAccess.getKeywordValRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeywordVal_in_entryRuleKeywordVal509);
            iv_ruleKeywordVal=ruleKeywordVal();

            state._fsp--;

             current =iv_ruleKeywordVal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeywordVal519); 

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
    // $ANTLR end "entryRuleKeywordVal"


    // $ANTLR start "ruleKeywordVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:304:1: ruleKeywordVal returns [EObject current=null] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final EObject ruleKeywordVal() throws RecognitionException {
        EObject current = null;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:307:28: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:308:1: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:308:1: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==22) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:308:2: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:308:2: ( (lv_kw_0_0= 'kw1' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:309:1: (lv_kw_0_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:309:1: (lv_kw_0_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:310:3: lv_kw_0_0= 'kw1'
                    {
                    lv_kw_0_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleKeywordVal562); 

                            newLeafNode(lv_kw_0_0, grammarAccess.getKeywordValAccess().getKwKw1Keyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordValRule());
                    	        }
                           		setWithLastConsumed(current, "kw", lv_kw_0_0, "kw1");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:324:6: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:324:6: ( (lv_kw_1_0= 'kw2' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:325:1: (lv_kw_1_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:325:1: (lv_kw_1_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:326:3: lv_kw_1_0= 'kw2'
                    {
                    lv_kw_1_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleKeywordVal599); 

                            newLeafNode(lv_kw_1_0, grammarAccess.getKeywordValAccess().getKwKw2Keyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordValRule());
                    	        }
                           		setWithLastConsumed(current, "kw", lv_kw_1_0, "kw2");
                    	    

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
    // $ANTLR end "ruleKeywordVal"


    // $ANTLR start "entryRuleTerminalVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:347:1: entryRuleTerminalVal returns [EObject current=null] : iv_ruleTerminalVal= ruleTerminalVal EOF ;
    public final EObject entryRuleTerminalVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalVal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:348:2: (iv_ruleTerminalVal= ruleTerminalVal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:349:2: iv_ruleTerminalVal= ruleTerminalVal EOF
            {
             newCompositeNode(grammarAccess.getTerminalValRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalVal_in_entryRuleTerminalVal648);
            iv_ruleTerminalVal=ruleTerminalVal();

            state._fsp--;

             current =iv_ruleTerminalVal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalVal658); 

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
    // $ANTLR end "entryRuleTerminalVal"


    // $ANTLR start "ruleTerminalVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:356:1: ruleTerminalVal returns [EObject current=null] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final EObject ruleTerminalVal() throws RecognitionException {
        EObject current = null;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:359:28: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:360:1: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:360:1: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
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
            case 24:
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:360:2: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:360:2: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:361:1: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:361:1: (lv_term_0_0= RULE_TERMINAL1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:362:3: lv_term_0_0= RULE_TERMINAL1
                    {
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleTerminalVal700); 

                    			newLeafNode(lv_term_0_0, grammarAccess.getTerminalValAccess().getTermTerminal1TerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalValRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"term",
                            		lv_term_0_0, 
                            		"Terminal1");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:379:6: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:379:6: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:380:1: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:380:1: (lv_term_1_0= RULE_TERMINAL2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:381:3: lv_term_1_0= RULE_TERMINAL2
                    {
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleTerminalVal728); 

                    			newLeafNode(lv_term_1_0, grammarAccess.getTerminalValAccess().getTermTerminal2TerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalValRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"term",
                            		lv_term_1_0, 
                            		"Terminal2");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:398:6: ( (lv_term_2_0= '%foo' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:398:6: ( (lv_term_2_0= '%foo' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:399:1: (lv_term_2_0= '%foo' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:399:1: (lv_term_2_0= '%foo' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:400:3: lv_term_2_0= '%foo'
                    {
                    lv_term_2_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTerminalVal757); 

                            newLeafNode(lv_term_2_0, grammarAccess.getTerminalValAccess().getTermFooKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalValRule());
                    	        }
                           		setWithLastConsumed(current, "term", lv_term_2_0, "%foo");
                    	    

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
    // $ANTLR end "ruleTerminalVal"


    // $ANTLR start "entryRuleEnumVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:421:1: entryRuleEnumVal returns [EObject current=null] : iv_ruleEnumVal= ruleEnumVal EOF ;
    public final EObject entryRuleEnumVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumVal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:422:2: (iv_ruleEnumVal= ruleEnumVal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:423:2: iv_ruleEnumVal= ruleEnumVal EOF
            {
             newCompositeNode(grammarAccess.getEnumValRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumVal_in_entryRuleEnumVal806);
            iv_ruleEnumVal=ruleEnumVal();

            state._fsp--;

             current =iv_ruleEnumVal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumVal816); 

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
    // $ANTLR end "entryRuleEnumVal"


    // $ANTLR start "ruleEnumVal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:430:1: ruleEnumVal returns [EObject current=null] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final EObject ruleEnumVal() throws RecognitionException {
        EObject current = null;

        Enumerator lv_en_0_0 = null;

        Enumerator lv_en_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:433:28: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:434:1: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:434:1: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            else if ( (LA4_0==28) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:434:2: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:434:2: ( (lv_en_0_0= ruleEnum1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:435:1: (lv_en_0_0= ruleEnum1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:435:1: (lv_en_0_0= ruleEnum1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:436:3: lv_en_0_0= ruleEnum1
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumValAccess().getEnEnum1EnumRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumVal862);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumValRule());
                    	        }
                           		set(
                           			current, 
                           			"en",
                            		lv_en_0_0, 
                            		"Enum1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:453:6: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:453:6: ( (lv_en_1_0= ruleEnum2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:454:1: (lv_en_1_0= ruleEnum2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:454:1: (lv_en_1_0= ruleEnum2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:455:3: lv_en_1_0= ruleEnum2
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumValAccess().getEnEnum2EnumRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnum2_in_ruleEnumVal889);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumValRule());
                    	        }
                           		set(
                           			current, 
                           			"en",
                            		lv_en_1_0, 
                            		"Enum2");
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
    // $ANTLR end "ruleEnumVal"


    // $ANTLR start "entryRuleKeywordBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:479:1: entryRuleKeywordBool returns [EObject current=null] : iv_ruleKeywordBool= ruleKeywordBool EOF ;
    public final EObject entryRuleKeywordBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordBool = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:480:2: (iv_ruleKeywordBool= ruleKeywordBool EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:481:2: iv_ruleKeywordBool= ruleKeywordBool EOF
            {
             newCompositeNode(grammarAccess.getKeywordBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeywordBool_in_entryRuleKeywordBool925);
            iv_ruleKeywordBool=ruleKeywordBool();

            state._fsp--;

             current =iv_ruleKeywordBool; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeywordBool935); 

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
    // $ANTLR end "entryRuleKeywordBool"


    // $ANTLR start "ruleKeywordBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:488:1: ruleKeywordBool returns [EObject current=null] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final EObject ruleKeywordBool() throws RecognitionException {
        EObject current = null;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:491:28: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:492:1: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:492:1: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            else if ( (LA5_0==23) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:492:2: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:492:2: ( (lv_kw_0_0= 'kw1' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:493:1: (lv_kw_0_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:493:1: (lv_kw_0_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:494:3: lv_kw_0_0= 'kw1'
                    {
                    lv_kw_0_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleKeywordBool978); 

                            newLeafNode(lv_kw_0_0, grammarAccess.getKeywordBoolAccess().getKwKw1Keyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordBoolRule());
                    	        }
                           		setWithLastConsumed(current, "kw", true, "kw1");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:508:6: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:508:6: ( (lv_kw_1_0= 'kw2' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:509:1: (lv_kw_1_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:509:1: (lv_kw_1_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:510:3: lv_kw_1_0= 'kw2'
                    {
                    lv_kw_1_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleKeywordBool1015); 

                            newLeafNode(lv_kw_1_0, grammarAccess.getKeywordBoolAccess().getKwKw2Keyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordBoolRule());
                    	        }
                           		setWithLastConsumed(current, "kw", true, "kw2");
                    	    

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
    // $ANTLR end "ruleKeywordBool"


    // $ANTLR start "entryRuleTerminalBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:531:1: entryRuleTerminalBool returns [EObject current=null] : iv_ruleTerminalBool= ruleTerminalBool EOF ;
    public final EObject entryRuleTerminalBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalBool = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:532:2: (iv_ruleTerminalBool= ruleTerminalBool EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:533:2: iv_ruleTerminalBool= ruleTerminalBool EOF
            {
             newCompositeNode(grammarAccess.getTerminalBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalBool_in_entryRuleTerminalBool1064);
            iv_ruleTerminalBool=ruleTerminalBool();

            state._fsp--;

             current =iv_ruleTerminalBool; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalBool1074); 

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
    // $ANTLR end "entryRuleTerminalBool"


    // $ANTLR start "ruleTerminalBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:540:1: ruleTerminalBool returns [EObject current=null] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final EObject ruleTerminalBool() throws RecognitionException {
        EObject current = null;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:543:28: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:544:1: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:544:1: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
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
            case 24:
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:544:2: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:544:2: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:545:1: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:545:1: (lv_term_0_0= RULE_TERMINAL1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:546:3: lv_term_0_0= RULE_TERMINAL1
                    {
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleTerminalBool1116); 

                    			newLeafNode(lv_term_0_0, grammarAccess.getTerminalBoolAccess().getTermTerminal1TerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalBoolRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"term",
                            		true, 
                            		"Terminal1");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:563:6: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:563:6: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:564:1: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:564:1: (lv_term_1_0= RULE_TERMINAL2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:565:3: lv_term_1_0= RULE_TERMINAL2
                    {
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleTerminalBool1144); 

                    			newLeafNode(lv_term_1_0, grammarAccess.getTerminalBoolAccess().getTermTerminal2TerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalBoolRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"term",
                            		true, 
                            		"Terminal2");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:582:6: ( (lv_term_2_0= '%foo' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:582:6: ( (lv_term_2_0= '%foo' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:583:1: (lv_term_2_0= '%foo' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:583:1: (lv_term_2_0= '%foo' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:584:3: lv_term_2_0= '%foo'
                    {
                    lv_term_2_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTerminalBool1173); 

                            newLeafNode(lv_term_2_0, grammarAccess.getTerminalBoolAccess().getTermFooKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTerminalBoolRule());
                    	        }
                           		setWithLastConsumed(current, "term", true, "%foo");
                    	    

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
    // $ANTLR end "ruleTerminalBool"


    // $ANTLR start "entryRuleEnumBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:605:1: entryRuleEnumBool returns [EObject current=null] : iv_ruleEnumBool= ruleEnumBool EOF ;
    public final EObject entryRuleEnumBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBool = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:606:2: (iv_ruleEnumBool= ruleEnumBool EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:607:2: iv_ruleEnumBool= ruleEnumBool EOF
            {
             newCompositeNode(grammarAccess.getEnumBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBool_in_entryRuleEnumBool1222);
            iv_ruleEnumBool=ruleEnumBool();

            state._fsp--;

             current =iv_ruleEnumBool; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBool1232); 

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
    // $ANTLR end "entryRuleEnumBool"


    // $ANTLR start "ruleEnumBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:614:1: ruleEnumBool returns [EObject current=null] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final EObject ruleEnumBool() throws RecognitionException {
        EObject current = null;

        Enumerator lv_en_0_0 = null;

        Enumerator lv_en_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:617:28: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:618:1: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:618:1: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            else if ( (LA7_0==28) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:618:2: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:618:2: ( (lv_en_0_0= ruleEnum1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:619:1: (lv_en_0_0= ruleEnum1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:619:1: (lv_en_0_0= ruleEnum1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:620:3: lv_en_0_0= ruleEnum1
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumBoolAccess().getEnEnum1EnumRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumBool1278);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumBoolRule());
                    	        }
                           		set(
                           			current, 
                           			"en",
                            		true, 
                            		"Enum1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:637:6: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:637:6: ( (lv_en_1_0= ruleEnum2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:638:1: (lv_en_1_0= ruleEnum2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:638:1: (lv_en_1_0= ruleEnum2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:639:3: lv_en_1_0= ruleEnum2
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumBoolAccess().getEnEnum2EnumRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEnum2_in_ruleEnumBool1305);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumBoolRule());
                    	        }
                           		set(
                           			current, 
                           			"en",
                            		true, 
                            		"Enum2");
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
    // $ANTLR end "ruleEnumBool"


    // $ANTLR start "entryRuleMixedBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:663:1: entryRuleMixedBool returns [EObject current=null] : iv_ruleMixedBool= ruleMixedBool EOF ;
    public final EObject entryRuleMixedBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixedBool = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:664:2: (iv_ruleMixedBool= ruleMixedBool EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:665:2: iv_ruleMixedBool= ruleMixedBool EOF
            {
             newCompositeNode(grammarAccess.getMixedBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMixedBool_in_entryRuleMixedBool1341);
            iv_ruleMixedBool=ruleMixedBool();

            state._fsp--;

             current =iv_ruleMixedBool; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMixedBool1351); 

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
    // $ANTLR end "entryRuleMixedBool"


    // $ANTLR start "ruleMixedBool"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:672:1: ruleMixedBool returns [EObject current=null] : ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) ;
    public final EObject ruleMixedBool() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        AntlrDatatypeRuleToken lv_val_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:675:28: ( ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:676:1: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:676:1: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=25 && LA8_0<=26)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:676:2: ( (lv_val_0_0= 'kw1' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:676:2: ( (lv_val_0_0= 'kw1' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:677:1: (lv_val_0_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:677:1: (lv_val_0_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:678:3: lv_val_0_0= 'kw1'
                    {
                    lv_val_0_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMixedBool1394); 

                            newLeafNode(lv_val_0_0, grammarAccess.getMixedBoolAccess().getValKw1Keyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMixedBoolRule());
                    	        }
                           		setWithLastConsumed(current, "val", true, "kw1");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:692:6: ( (lv_val_1_0= ruleBoolean ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:692:6: ( (lv_val_1_0= ruleBoolean ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:693:1: (lv_val_1_0= ruleBoolean )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:693:1: (lv_val_1_0= ruleBoolean )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:694:3: lv_val_1_0= ruleBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getMixedBoolAccess().getValBooleanParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleMixedBool1434);
                    lv_val_1_0=ruleBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMixedBoolRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"Boolean");
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
    // $ANTLR end "ruleMixedBool"


    // $ANTLR start "entryRuleBoolean"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:718:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:719:2: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:720:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1471);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1482); 

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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:727:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:730:28: ( (kw= 'true' | kw= 'false' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:731:1: (kw= 'true' | kw= 'false' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:731:1: (kw= 'true' | kw= 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            else if ( (LA9_0==26) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:732:2: kw= 'true'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBoolean1520); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:739:2: kw= 'false'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBoolean1539); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                        

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleContainmentRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:752:1: entryRuleContainmentRef returns [EObject current=null] : iv_ruleContainmentRef= ruleContainmentRef EOF ;
    public final EObject entryRuleContainmentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:753:2: (iv_ruleContainmentRef= ruleContainmentRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:754:2: iv_ruleContainmentRef= ruleContainmentRef EOF
            {
             newCompositeNode(grammarAccess.getContainmentRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef_in_entryRuleContainmentRef1579);
            iv_ruleContainmentRef=ruleContainmentRef();

            state._fsp--;

             current =iv_ruleContainmentRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef1589); 

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
    // $ANTLR end "entryRuleContainmentRef"


    // $ANTLR start "ruleContainmentRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:761:1: ruleContainmentRef returns [EObject current=null] : ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) ;
    public final EObject ruleContainmentRef() throws RecognitionException {
        EObject current = null;

        EObject lv_ctx_0_0 = null;

        EObject lv_ctx_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:764:28: ( ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:765:1: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:765:1: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            else if ( (LA10_0==23) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:765:2: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:765:2: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:766:1: (lv_ctx_0_0= ruleContainmentRef1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:766:1: (lv_ctx_0_0= ruleContainmentRef1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:767:3: lv_ctx_0_0= ruleContainmentRef1
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentRefAccess().getCtxContainmentRef1ParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef1_in_ruleContainmentRef1635);
                    lv_ctx_0_0=ruleContainmentRef1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentRefRule());
                    	        }
                           		set(
                           			current, 
                           			"ctx",
                            		lv_ctx_0_0, 
                            		"ContainmentRef1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:784:6: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:784:6: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:785:1: (lv_ctx_1_0= ruleContainmentRef2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:785:1: (lv_ctx_1_0= ruleContainmentRef2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:786:3: lv_ctx_1_0= ruleContainmentRef2
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentRefAccess().getCtxContainmentRef2ParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentRef2_in_ruleContainmentRef1662);
                    lv_ctx_1_0=ruleContainmentRef2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentRefRule());
                    	        }
                           		set(
                           			current, 
                           			"ctx",
                            		lv_ctx_1_0, 
                            		"ContainmentRef2");
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
    // $ANTLR end "ruleContainmentRef"


    // $ANTLR start "entryRuleContainmentRef1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:810:1: entryRuleContainmentRef1 returns [EObject current=null] : iv_ruleContainmentRef1= ruleContainmentRef1 EOF ;
    public final EObject entryRuleContainmentRef1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:811:2: (iv_ruleContainmentRef1= ruleContainmentRef1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:812:2: iv_ruleContainmentRef1= ruleContainmentRef1 EOF
            {
             newCompositeNode(grammarAccess.getContainmentRef1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef1_in_entryRuleContainmentRef11698);
            iv_ruleContainmentRef1=ruleContainmentRef1();

            state._fsp--;

             current =iv_ruleContainmentRef1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef11708); 

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
    // $ANTLR end "entryRuleContainmentRef1"


    // $ANTLR start "ruleContainmentRef1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:819:1: ruleContainmentRef1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContainmentRef1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:822:28: ( (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:823:1: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:823:1: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:823:3: otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleContainmentRef11745); 

                	newLeafNode(otherlv_0, grammarAccess.getContainmentRef1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:827:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:828:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:828:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:829:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentRef11762); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getContainmentRef1Access().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentRef1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
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
    // $ANTLR end "ruleContainmentRef1"


    // $ANTLR start "entryRuleContainmentRef2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:853:1: entryRuleContainmentRef2 returns [EObject current=null] : iv_ruleContainmentRef2= ruleContainmentRef2 EOF ;
    public final EObject entryRuleContainmentRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:854:2: (iv_ruleContainmentRef2= ruleContainmentRef2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:855:2: iv_ruleContainmentRef2= ruleContainmentRef2 EOF
            {
             newCompositeNode(grammarAccess.getContainmentRef2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentRef2_in_entryRuleContainmentRef21803);
            iv_ruleContainmentRef2=ruleContainmentRef2();

            state._fsp--;

             current =iv_ruleContainmentRef2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentRef21813); 

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
    // $ANTLR end "entryRuleContainmentRef2"


    // $ANTLR start "ruleContainmentRef2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:862:1: ruleContainmentRef2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContainmentRef2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:865:28: ( (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:866:1: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:866:1: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:866:3: otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleContainmentRef21850); 

                	newLeafNode(otherlv_0, grammarAccess.getContainmentRef2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:870:1: ( (lv_val2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:871:1: (lv_val2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:871:1: (lv_val2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:872:3: lv_val2_1_0= RULE_ID
            {
            lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentRef21867); 

            			newLeafNode(lv_val2_1_0, grammarAccess.getContainmentRef2Access().getVal2IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentRef2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val2",
                    		lv_val2_1_0, 
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
    // $ANTLR end "ruleContainmentRef2"


    // $ANTLR start "entryRuleCrossRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:896:1: entryRuleCrossRef returns [EObject current=null] : iv_ruleCrossRef= ruleCrossRef EOF ;
    public final EObject entryRuleCrossRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:897:2: (iv_ruleCrossRef= ruleCrossRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:898:2: iv_ruleCrossRef= ruleCrossRef EOF
            {
             newCompositeNode(grammarAccess.getCrossRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossRef_in_entryRuleCrossRef1908);
            iv_ruleCrossRef=ruleCrossRef();

            state._fsp--;

             current =iv_ruleCrossRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossRef1918); 

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
    // $ANTLR end "entryRuleCrossRef"


    // $ANTLR start "ruleCrossRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:905:1: ruleCrossRef returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) ;
    public final EObject ruleCrossRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:908:28: ( ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:909:1: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:909:1: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:909:2: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:909:2: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:910:1: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:910:1: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:911:1: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:911:1: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_TERMINAL1) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_TERMINAL2) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:912:3: lv_name_0_1= RULE_TERMINAL1
                    {
                    lv_name_0_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleCrossRef1962); 

                    			newLeafNode(lv_name_0_1, grammarAccess.getCrossRefAccess().getNameTerminal1TerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_1, 
                            		"Terminal1");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:927:8: lv_name_0_2= RULE_TERMINAL2
                    {
                    lv_name_0_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleCrossRef1982); 

                    			newLeafNode(lv_name_0_2, grammarAccess.getCrossRefAccess().getNameTerminal2TerminalRuleCall_0_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_2, 
                            		"Terminal2");
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:945:2: ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:945:3: ( (otherlv_1= RULE_TERMINAL1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:945:3: ( (otherlv_1= RULE_TERMINAL1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:946:1: (otherlv_1= RULE_TERMINAL1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:946:1: (otherlv_1= RULE_TERMINAL1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:947:3: otherlv_1= RULE_TERMINAL1
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2011); 

                    		newLeafNode(otherlv_1, grammarAccess.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:959:6: ( (otherlv_2= RULE_TERMINAL2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:959:6: ( (otherlv_2= RULE_TERMINAL2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:960:1: (otherlv_2= RULE_TERMINAL2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:960:1: (otherlv_2= RULE_TERMINAL2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:961:3: otherlv_2= RULE_TERMINAL2
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2037); 

                    		newLeafNode(otherlv_2, grammarAccess.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_1_0()); 
                    	

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
    // $ANTLR end "ruleCrossRef"


    // $ANTLR start "ruleEnum1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:980:1: ruleEnum1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleEnum1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:982:28: ( (enumLiteral_0= 'lit1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:983:1: (enumLiteral_0= 'lit1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:983:1: (enumLiteral_0= 'lit1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:983:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnum12087); 

                    current = grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration()); 
                

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
    // $ANTLR end "ruleEnum1"


    // $ANTLR start "ruleEnum2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:993:1: ruleEnum2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleEnum2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:995:28: ( (enumLiteral_0= 'lit2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:996:1: (enumLiteral_0= 'lit2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:996:1: (enumLiteral_0= 'lit2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalAssignmentFinderTestLanguage.g:996:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnum22130); 

                    current = grammarAccess.getEnum2Access().getLit2EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getEnum2Access().getLit2EnumLiteralDeclaration()); 
                

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
    // $ANTLR end "ruleEnum2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel123 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_ruleKeywordVal_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel164 = new BitSet(new long[]{0x0000000001000030L});
        public static final BitSet FOLLOW_ruleTerminalVal_in_ruleModel185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel205 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_ruleEnumVal_in_ruleModel226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel246 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_ruleKeywordBool_in_ruleModel267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel287 = new BitSet(new long[]{0x0000000001000030L});
        public static final BitSet FOLLOW_ruleTerminalBool_in_ruleModel308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel328 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_ruleEnumBool_in_ruleModel349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel369 = new BitSet(new long[]{0x0000000006400000L});
        public static final BitSet FOLLOW_ruleMixedBool_in_ruleModel390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel410 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_ruleContainmentRef_in_ruleModel431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModel451 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossRef_in_ruleModel472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeywordVal_in_entryRuleKeywordVal509 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeywordVal519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleKeywordVal562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleKeywordVal599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalVal_in_entryRuleTerminalVal648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalVal658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleTerminalVal700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleTerminalVal728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleTerminalVal757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumVal_in_entryRuleEnumVal806 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumVal816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumVal862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum2_in_ruleEnumVal889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeywordBool_in_entryRuleKeywordBool925 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeywordBool935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleKeywordBool978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleKeywordBool1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalBool_in_entryRuleTerminalBool1064 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalBool1074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleTerminalBool1116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleTerminalBool1144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleTerminalBool1173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumBool_in_entryRuleEnumBool1222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBool1232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumBool1278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnum2_in_ruleEnumBool1305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMixedBool_in_entryRuleMixedBool1341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMixedBool1351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMixedBool1394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleMixedBool1434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBoolean1520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleBoolean1539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef_in_entryRuleContainmentRef1579 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef1589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef1_in_ruleContainmentRef1635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef2_in_ruleContainmentRef1662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef1_in_entryRuleContainmentRef11698 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef11708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleContainmentRef11745 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentRef11762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentRef2_in_entryRuleContainmentRef21803 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentRef21813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleContainmentRef21850 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentRef21867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossRef_in_entryRuleCrossRef1908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossRef1918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleCrossRef1962 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleCrossRef1982 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_TERMINAL1_in_ruleCrossRef2011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_TERMINAL2_in_ruleCrossRef2037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleEnum12087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEnum22130 = new BitSet(new long[]{0x0000000000000002L});
    }


}