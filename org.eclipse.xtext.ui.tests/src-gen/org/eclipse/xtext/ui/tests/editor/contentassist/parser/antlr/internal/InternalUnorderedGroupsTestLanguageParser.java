package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'5'", "'bug304681'", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'", "'before'", "'after'", "'short'", "';'", "'long'", "'uid'", "'flag'", "'attr'", "'ref'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnorderedGroupsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUnorderedGroupsTestLanguage.g"; }



     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected UnorderedGroupsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalUnorderedGroupsTestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalUnorderedGroupsTestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;

        EObject lv_thrird_5_0 = null;

        EObject lv_forth_7_0 = null;

        EObject lv_fifth_9_0 = null;

        EObject lv_model_11_0 = null;



        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:77:2: ( ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) )
            // InternalUnorderedGroupsTestLanguage.g:78:2: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:78:2: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
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
                    // InternalUnorderedGroupsTestLanguage.g:79:3: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:79:3: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:80:4: otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:84:4: ( (lv_first_1_0= ruleSimpleModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:85:5: (lv_first_1_0= ruleSimpleModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:85:5: (lv_first_1_0= ruleSimpleModel )
                    // InternalUnorderedGroupsTestLanguage.g:86:6: lv_first_1_0= ruleSimpleModel
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_1_0=ruleSimpleModel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"first",
                    							lv_first_1_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.SimpleModel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUnorderedGroupsTestLanguage.g:105:3: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:105:3: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:106:4: otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:110:4: ( (lv_second_3_0= ruleMandatoryModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:111:5: (lv_second_3_0= ruleMandatoryModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:111:5: (lv_second_3_0= ruleMandatoryModel )
                    // InternalUnorderedGroupsTestLanguage.g:112:6: lv_second_3_0= ruleMandatoryModel
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_second_3_0=ruleMandatoryModel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"second",
                    							lv_second_3_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.MandatoryModel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalUnorderedGroupsTestLanguage.g:131:3: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:131:3: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:132:4: otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getDigitThreeKeyword_2_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:136:4: ( (lv_thrird_5_0= ruleLoopedModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:137:5: (lv_thrird_5_0= ruleLoopedModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:137:5: (lv_thrird_5_0= ruleLoopedModel )
                    // InternalUnorderedGroupsTestLanguage.g:138:6: lv_thrird_5_0= ruleLoopedModel
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_thrird_5_0=ruleLoopedModel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"thrird",
                    							lv_thrird_5_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.LoopedModel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalUnorderedGroupsTestLanguage.g:157:3: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:157:3: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:158:4: otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getDigitFourKeyword_3_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:162:4: ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:163:5: (lv_forth_7_0= ruleGroupLoopedModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:163:5: (lv_forth_7_0= ruleGroupLoopedModel )
                    // InternalUnorderedGroupsTestLanguage.g:164:6: lv_forth_7_0= ruleGroupLoopedModel
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_forth_7_0=ruleGroupLoopedModel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"forth",
                    							lv_forth_7_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.GroupLoopedModel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalUnorderedGroupsTestLanguage.g:183:3: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:183:3: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:184:4: otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getDigitFiveKeyword_4_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:188:4: ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:189:5: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:189:5: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    // InternalUnorderedGroupsTestLanguage.g:190:6: lv_fifth_9_0= ruleLoopedAlternativeModel
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_fifth_9_0=ruleLoopedAlternativeModel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"fifth",
                    							lv_fifth_9_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.LoopedAlternativeModel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalUnorderedGroupsTestLanguage.g:209:3: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:209:3: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:210:4: otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getBug304681Keyword_5_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:214:4: ( (lv_model_11_0= ruleBug304681Model ) )
                    // InternalUnorderedGroupsTestLanguage.g:215:5: (lv_model_11_0= ruleBug304681Model )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:215:5: (lv_model_11_0= ruleBug304681Model )
                    // InternalUnorderedGroupsTestLanguage.g:216:6: lv_model_11_0= ruleBug304681Model
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_model_11_0=ruleBug304681Model();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"model",
                    							lv_model_11_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.Bug304681Model");
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


    // $ANTLR start "entryRuleSimpleModel"
    // InternalUnorderedGroupsTestLanguage.g:238:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:238:52: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:239:2: iv_ruleSimpleModel= ruleSimpleModel EOF
            {
             newCompositeNode(grammarAccess.getSimpleModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleModel=ruleSimpleModel();

            state._fsp--;

             current =iv_ruleSimpleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleModel"


    // $ANTLR start "ruleSimpleModel"
    // InternalUnorderedGroupsTestLanguage.g:245:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleSimpleModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:251:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:252:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:252:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:253:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:253:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:254:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:254:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:255:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:258:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:259:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:259:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( LA4_0 >= 17 && LA4_0 <= 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt4=2;
                }
                else if ( LA4_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt4=3;
                }
                else if ( LA4_0 >= 22 && LA4_0 <= 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:260:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:260:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:261:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:261:108: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:262:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:265:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:265:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:265:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:265:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:265:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:266:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:266:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:267:11: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_1, grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSimpleModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_1, null);
            	            										

            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:278:11: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_2, grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSimpleModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_2, null);
            	            										

            	            }
            	            break;
            	        case 3 :
            	            // InternalUnorderedGroupsTestLanguage.g:289:11: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_3, grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSimpleModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_3, null);
            	            										

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUnorderedGroupsTestLanguage.g:307:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:307:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:308:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:308:108: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:309:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:312:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:312:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:312:19: ( (lv_static_2_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:312:20: (lv_static_2_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:312:20: (lv_static_2_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:313:10: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    										newLeafNode(lv_static_2_0, grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getSimpleModelRule());
            	    										}
            	    										setWithLastConsumed(current, "static", lv_static_2_0 != null, "static");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUnorderedGroupsTestLanguage.g:330:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:330:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:331:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:331:108: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:332:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:335:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:335:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:335:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:335:20: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:335:20: (lv_synchronized_3_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:336:10: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    										newLeafNode(lv_synchronized_3_0, grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getSimpleModelRule());
            	    										}
            	    										setWithLastConsumed(current, "synchronized", lv_synchronized_3_0 != null, "synchronized");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUnorderedGroupsTestLanguage.g:353:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:353:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:354:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:354:108: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:355:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:358:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:358:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:358:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==22) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==23) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:358:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:358:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:359:10: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:359:10: (lv_abstract_4_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:360:11: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_abstract_4_0, grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSimpleModelRule());
            	            											}
            	            											setWithLastConsumed(current, "abstract", lv_abstract_4_0 != null, "abstract");
            	            										

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:373:9: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:373:9: ( (lv_final_5_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:374:10: (lv_final_5_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:374:10: (lv_final_5_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:375:11: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_final_5_0, grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSimpleModelRule());
            	            											}
            	            											setWithLastConsumed(current, "final", lv_final_5_0 != null, "final");
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            				

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getSimpleModelAccess().getClassKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:404:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:405:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:405:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:406:5: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_7_0, grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_7_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleSimpleModel"


    // $ANTLR start "entryRuleMandatoryModel"
    // InternalUnorderedGroupsTestLanguage.g:434:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:434:55: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:435:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
            {
             newCompositeNode(grammarAccess.getMandatoryModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMandatoryModel=ruleMandatoryModel();

            state._fsp--;

             current =iv_ruleMandatoryModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMandatoryModel"


    // $ANTLR start "ruleMandatoryModel"
    // InternalUnorderedGroupsTestLanguage.g:441:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleMandatoryModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:447:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:448:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:448:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:449:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:449:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )
            // InternalUnorderedGroupsTestLanguage.g:450:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalUnorderedGroupsTestLanguage.g:450:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            // InternalUnorderedGroupsTestLanguage.g:451:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:454:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            // InternalUnorderedGroupsTestLanguage.g:455:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?
            {
            // InternalUnorderedGroupsTestLanguage.g:455:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( LA7_0 >= 17 && LA7_0 <= 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 >= 22 && LA7_0 <= 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:456:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:456:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:457:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:457:111: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:458:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:461:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:461:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:461:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:461:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:461:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:462:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:462:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:463:11: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_1, grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getMandatoryModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_1, null);
            	            										

            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:474:11: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_2, grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getMandatoryModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_2, null);
            	            										

            	            }
            	            break;
            	        case 3 :
            	            // InternalUnorderedGroupsTestLanguage.g:485:11: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_visibility_1_3, grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getMandatoryModelRule());
            	            											}
            	            											setWithLastConsumed(current, "visibility", lv_visibility_1_3, null);
            	            										

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUnorderedGroupsTestLanguage.g:503:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:503:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:504:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:504:111: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:505:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:508:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:508:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:508:19: ( (lv_static_2_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:508:20: (lv_static_2_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:508:20: (lv_static_2_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:509:10: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    										newLeafNode(lv_static_2_0, grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getMandatoryModelRule());
            	    										}
            	    										setWithLastConsumed(current, "static", lv_static_2_0 != null, "static");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUnorderedGroupsTestLanguage.g:526:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:526:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:527:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:527:111: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:528:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:531:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:531:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:531:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:531:20: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:531:20: (lv_synchronized_3_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:532:10: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    										newLeafNode(lv_synchronized_3_0, grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getMandatoryModelRule());
            	    										}
            	    										setWithLastConsumed(current, "synchronized", lv_synchronized_3_0 != null, "synchronized");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUnorderedGroupsTestLanguage.g:549:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:549:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:550:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:550:111: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:551:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:554:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:554:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:554:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==22) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==23) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:554:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:554:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:555:10: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:555:10: (lv_abstract_4_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:556:11: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_abstract_4_0, grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getMandatoryModelRule());
            	            											}
            	            											setWithLastConsumed(current, "abstract", lv_abstract_4_0 != null, "abstract");
            	            										

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:569:9: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:569:9: ( (lv_final_5_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:570:10: (lv_final_5_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:570:10: (lv_final_5_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:571:11: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	            											newLeafNode(lv_final_5_0, grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getMandatoryModelRule());
            	            											}
            	            											setWithLastConsumed(current, "final", lv_final_5_0 != null, "final");
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()) ) {
                throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            				

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getMandatoryModelAccess().getClassKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:601:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:602:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:602:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:603:5: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_7_0, grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMandatoryModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_7_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleMandatoryModel"


    // $ANTLR start "entryRuleLoopedModel"
    // InternalUnorderedGroupsTestLanguage.g:631:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:631:52: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:632:2: iv_ruleLoopedModel= ruleLoopedModel EOF
            {
             newCompositeNode(grammarAccess.getLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoopedModel=ruleLoopedModel();

            state._fsp--;

             current =iv_ruleLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleLoopedModel"


    // $ANTLR start "ruleLoopedModel"
    // InternalUnorderedGroupsTestLanguage.g:638:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:644:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:645:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:645:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:646:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:646:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:647:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:647:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:648:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:651:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:652:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:652:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )*
            loop14:
            do {
                int alt14=5;
                int LA14_0 = input.LA(1);

                if ( LA14_0 >= 17 && LA14_0 <= 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt14=2;
                }
                else if ( LA14_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt14=3;
                }
                else if ( LA14_0 >= 22 && LA14_0 <= 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt14=4;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:653:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:653:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:654:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:654:108: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:655:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:658:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        switch ( input.LA(1) ) {
            	        case 17:
            	            {
            	            int LA9_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 18:
            	            {
            	            int LA9_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 19:
            	            {
            	            int LA9_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:658:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:658:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:658:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:658:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:659:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:659:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt8=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt8=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt8=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt8=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 8, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt8) {
            	    	        case 1 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:660:11: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_1, grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_1, null);
            	    	            										

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:671:11: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_2, grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_2, null);
            	    	            										

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:682:11: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_3, grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_3, null);
            	    	            										

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUnorderedGroupsTestLanguage.g:700:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:700:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:701:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:701:108: ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:702:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:705:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==20) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:705:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:705:19: ( (lv_static_2_0= 'static' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:705:20: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:705:20: (lv_static_2_0= 'static' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:706:10: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    	    										newLeafNode(lv_static_2_0, grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0());
            	    	    									

            	    	    										if (current==null) {
            	    	    											current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	    										}
            	    	    										addWithLastConsumed(current, "static", lv_static_2_0, "static");
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUnorderedGroupsTestLanguage.g:723:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:723:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:724:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:724:108: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:725:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:728:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==21) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:728:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:728:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:728:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:728:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:729:10: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    	    										newLeafNode(lv_synchronized_3_0, grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0());
            	    	    									

            	    	    										if (current==null) {
            	    	    											current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	    										}
            	    	    										addWithLastConsumed(current, "synchronized", lv_synchronized_3_0, "synchronized");
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUnorderedGroupsTestLanguage.g:746:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:746:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:747:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:747:108: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:748:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:751:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==22) ) {
            	            int LA13_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt13=1;
            	            }


            	        }
            	        else if ( (LA13_0==23) ) {
            	            int LA13_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt13=1;
            	            }


            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:751:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:751:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt12=2;
            	    	    int LA12_0 = input.LA(1);

            	    	    if ( (LA12_0==22) ) {
            	    	        alt12=1;
            	    	    }
            	    	    else if ( (LA12_0==23) ) {
            	    	        alt12=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 12, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt12) {
            	    	        case 1 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:751:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:751:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:752:10: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:752:10: (lv_abstract_4_0= 'abstract' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:753:11: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_abstract_4_0, grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "abstract", lv_abstract_4_0, "abstract");
            	    	            										

            	    	            }


            	    	            }


            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:766:9: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:766:9: ( (lv_final_5_0= 'final' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:767:10: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:767:10: (lv_final_5_0= 'final' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:768:11: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_final_5_0, grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "final", lv_final_5_0, "final");
            	    	            										

            	    	            }


            	    	            }


            	    	            }
            	    	            break;

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            				

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getLoopedModelAccess().getClassKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:797:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:798:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:798:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:799:5: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_7_0, grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopedModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_7_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleLoopedModel"


    // $ANTLR start "entryRuleGroupLoopedModel"
    // InternalUnorderedGroupsTestLanguage.g:827:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:827:57: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:828:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
            {
             newCompositeNode(grammarAccess.getGroupLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroupLoopedModel=ruleGroupLoopedModel();

            state._fsp--;

             current =iv_ruleGroupLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleGroupLoopedModel"


    // $ANTLR start "ruleGroupLoopedModel"
    // InternalUnorderedGroupsTestLanguage.g:834:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:840:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:841:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:841:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:842:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:842:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=17 && LA18_0<=23)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:843:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:843:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            	    // InternalUnorderedGroupsTestLanguage.g:844:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    				  getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    				
            	    // InternalUnorderedGroupsTestLanguage.g:847:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            	    // InternalUnorderedGroupsTestLanguage.g:848:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:848:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=5;
            	        alt17 = dfa17.predict(input);
            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:849:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:849:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:850:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:850:113: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:851:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:855:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:855:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt15=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt15=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt15=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt15=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 15, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt15) {
            	    	        case 1 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:856:11: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_1, grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_1, null);
            	    	            										

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:867:11: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_2, grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_2, null);
            	    	            										

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:878:11: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_visibility_1_3, grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "visibility", lv_visibility_1_3, null);
            	    	            										

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    					

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:896:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:896:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:897:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:897:113: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:898:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:19: ( (lv_static_2_0= 'static' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:20: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:20: (lv_static_2_0= 'static' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:902:10: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    	    										newLeafNode(lv_static_2_0, grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0());
            	    	    									

            	    	    										if (current==null) {
            	    	    											current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	    										}
            	    	    										addWithLastConsumed(current, "static", lv_static_2_0, "static");
            	    	    									

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    					

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:919:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:919:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:920:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:920:113: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:921:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:925:10: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    	    										newLeafNode(lv_synchronized_3_0, grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0());
            	    	    									

            	    	    										if (current==null) {
            	    	    											current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	    										}
            	    	    										addWithLastConsumed(current, "synchronized", lv_synchronized_3_0, "synchronized");
            	    	    									

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    					

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:942:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:942:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:943:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:943:113: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:944:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:947:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:947:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:947:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt16=2;
            	    	    int LA16_0 = input.LA(1);

            	    	    if ( (LA16_0==22) ) {
            	    	        alt16=1;
            	    	    }
            	    	    else if ( (LA16_0==23) ) {
            	    	        alt16=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 16, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt16) {
            	    	        case 1 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:947:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:947:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:948:10: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:948:10: (lv_abstract_4_0= 'abstract' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:949:11: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_abstract_4_0, grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "abstract", lv_abstract_4_0, "abstract");
            	    	            										

            	    	            }


            	    	            }


            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalUnorderedGroupsTestLanguage.g:962:9: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:962:9: ( (lv_final_5_0= 'final' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:963:10: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:963:10: (lv_final_5_0= 'final' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:964:11: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    	            											newLeafNode(lv_final_5_0, grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0());
            	    	            										

            	    	            											if (current==null) {
            	    	            												current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            	    	            											}
            	    	            											addWithLastConsumed(current, "final", lv_final_5_0, "final");
            	    	            										

            	    	            }


            	    	            }


            	    	            }
            	    	            break;

            	    	    }


            	    	    }

            	    	     
            	    	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    					

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {
            	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            	    }

            	    }


            	    }

            	     
            	    				  getUnorderedGroupHelper().leave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    				

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:994:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:995:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:995:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:996:5: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_7_0, grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupLoopedModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_7_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleGroupLoopedModel"


    // $ANTLR start "entryRuleLoopedAlternativeModel"
    // InternalUnorderedGroupsTestLanguage.g:1024:1: entryRuleLoopedAlternativeModel returns [EObject current=null] : iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF ;
    public final EObject entryRuleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedAlternativeModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1024:63: (iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:1025:2: iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF
            {
             newCompositeNode(grammarAccess.getLoopedAlternativeModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoopedAlternativeModel=ruleLoopedAlternativeModel();

            state._fsp--;

             current =iv_ruleLoopedAlternativeModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleLoopedAlternativeModel"


    // $ANTLR start "ruleLoopedAlternativeModel"
    // InternalUnorderedGroupsTestLanguage.g:1031:1: ruleLoopedAlternativeModel returns [EObject current=null] : ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) ;
    public final EObject ruleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_0_1=null;
        Token lv_visibility_0_2=null;
        Token lv_visibility_0_3=null;
        Token lv_static_1_0=null;
        Token lv_synchronized_2_0=null;
        Token lv_abstract_3_0=null;
        Token lv_final_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1037:2: ( ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:1038:2: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1038:2: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            // InternalUnorderedGroupsTestLanguage.g:1039:3: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:1039:3: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )*
            loop22:
            do {
                int alt22=6;
                switch ( input.LA(1) ) {
                case 17:
                case 18:
                case 19:
                    {
                    alt22=1;
                    }
                    break;
                case 20:
                    {
                    alt22=2;
                    }
                    break;
                case 21:
                    {
                    alt22=3;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt22=4;
                    }
                    break;
                case 27:
                    {
                    alt22=5;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:1040:4: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1040:4: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1041:5: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1041:5: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1042:6: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1042:6: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    int alt19=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt19=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt19=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt19=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt19) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:1043:7: lv_visibility_0_1= 'public'
            	            {
            	            lv_visibility_0_1=(Token)match(input,17,FollowSets000.FOLLOW_5); 

            	            							newLeafNode(lv_visibility_0_1, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	            							}
            	            							addWithLastConsumed(current, "visibility", lv_visibility_0_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:1054:7: lv_visibility_0_2= 'private'
            	            {
            	            lv_visibility_0_2=(Token)match(input,18,FollowSets000.FOLLOW_5); 

            	            							newLeafNode(lv_visibility_0_2, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	            							}
            	            							addWithLastConsumed(current, "visibility", lv_visibility_0_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalUnorderedGroupsTestLanguage.g:1065:7: lv_visibility_0_3= 'protected'
            	            {
            	            lv_visibility_0_3=(Token)match(input,19,FollowSets000.FOLLOW_5); 

            	            							newLeafNode(lv_visibility_0_3, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	            							}
            	            							addWithLastConsumed(current, "visibility", lv_visibility_0_3, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUnorderedGroupsTestLanguage.g:1079:4: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1079:4: ( (lv_static_1_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1080:5: (lv_static_1_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1080:5: (lv_static_1_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:1081:6: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)match(input,20,FollowSets000.FOLLOW_5); 

            	    						newLeafNode(lv_static_1_0, grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	    						}
            	    						addWithLastConsumed(current, "static", lv_static_1_0, "static");
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUnorderedGroupsTestLanguage.g:1094:4: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1094:4: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1095:5: (lv_synchronized_2_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1095:5: (lv_synchronized_2_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:1096:6: lv_synchronized_2_0= 'synchronized'
            	    {
            	    lv_synchronized_2_0=(Token)match(input,21,FollowSets000.FOLLOW_5); 

            	    						newLeafNode(lv_synchronized_2_0, grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	    						}
            	    						addWithLastConsumed(current, "synchronized", lv_synchronized_2_0, "synchronized");
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUnorderedGroupsTestLanguage.g:1109:4: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1109:4: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==22) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==23) ) {
            	        alt20=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalUnorderedGroupsTestLanguage.g:1110:5: ( (lv_abstract_3_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1110:5: ( (lv_abstract_3_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:1111:6: (lv_abstract_3_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1111:6: (lv_abstract_3_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:1112:7: lv_abstract_3_0= 'abstract'
            	            {
            	            lv_abstract_3_0=(Token)match(input,22,FollowSets000.FOLLOW_5); 

            	            							newLeafNode(lv_abstract_3_0, grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	            							}
            	            							addWithLastConsumed(current, "abstract", lv_abstract_3_0, "abstract");
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUnorderedGroupsTestLanguage.g:1125:5: ( (lv_final_4_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1125:5: ( (lv_final_4_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:1126:6: (lv_final_4_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1126:6: (lv_final_4_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:1127:7: lv_final_4_0= 'final'
            	            {
            	            lv_final_4_0=(Token)match(input,23,FollowSets000.FOLLOW_5); 

            	            							newLeafNode(lv_final_4_0, grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            	            							}
            	            							addWithLastConsumed(current, "final", lv_final_4_0, "final");
            	            						

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalUnorderedGroupsTestLanguage.g:1141:4: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1141:4: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    // InternalUnorderedGroupsTestLanguage.g:1142:5: otherlv_5= 'before' (otherlv_6= 'after' )*
            	    {
            	    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_9); 

            	    					newLeafNode(otherlv_5, grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0());
            	    				
            	    // InternalUnorderedGroupsTestLanguage.g:1146:5: (otherlv_6= 'after' )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==28) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:1147:6: otherlv_6= 'after'
            	    	    {
            	    	    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_9); 

            	    	    						newLeafNode(otherlv_6, grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1());
            	    	    					

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:1158:3: ( (lv_name_8_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1159:4: (lv_name_8_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1159:4: (lv_name_8_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1160:5: lv_name_8_0= RULE_ID
            {
            lv_name_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_8_0, grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopedAlternativeModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_9, grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleLoopedAlternativeModel"


    // $ANTLR start "entryRuleBug304681Model"
    // InternalUnorderedGroupsTestLanguage.g:1188:1: entryRuleBug304681Model returns [EObject current=null] : iv_ruleBug304681Model= ruleBug304681Model EOF ;
    public final EObject entryRuleBug304681Model() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Model = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1188:55: (iv_ruleBug304681Model= ruleBug304681Model EOF )
            // InternalUnorderedGroupsTestLanguage.g:1189:2: iv_ruleBug304681Model= ruleBug304681Model EOF
            {
             newCompositeNode(grammarAccess.getBug304681ModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug304681Model=ruleBug304681Model();

            state._fsp--;

             current =iv_ruleBug304681Model; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBug304681Model"


    // $ANTLR start "ruleBug304681Model"
    // InternalUnorderedGroupsTestLanguage.g:1195:1: ruleBug304681Model returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' ) ;
    public final EObject ruleBug304681Model() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_shortDescription_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_longDescription_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_uid_10_0=null;
        Token otherlv_11=null;
        Token lv_flag_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_features_14_0 = null;



        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1201:2: ( ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:1202:2: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1202:2: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            // InternalUnorderedGroupsTestLanguage.g:1203:3: () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:1203:3: ()
            // InternalUnorderedGroupsTestLanguage.g:1204:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:1214:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:1215:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:1215:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:1216:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            				
            // InternalUnorderedGroupsTestLanguage.g:1219:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:1220:6: ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:1220:6: ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )*
            loop24:
            do {
                int alt24=6;
                int LA24_0 = input.LA(1);

                if ( LA24_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                    alt24=1;
                }
                else if ( LA24_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                    alt24=2;
                }
                else if ( LA24_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                    alt24=3;
                }
                else if ( LA24_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                    alt24=4;
                }
                else if ( LA24_0 >= 34 && LA24_0 <= 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                    alt24=5;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:1221:4: ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1221:4: ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1222:5: {...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1222:111: ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1223:6: ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1226:9: ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1226:10: {...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1226:19: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1226:20: otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';'
            	    {
            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_3, grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1230:9: ( (lv_shortDescription_4_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1231:10: (lv_shortDescription_4_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1231:10: (lv_shortDescription_4_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1232:11: lv_shortDescription_4_0= RULE_STRING
            	    {
            	    lv_shortDescription_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            	    											newLeafNode(lv_shortDescription_4_0, grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBug304681ModelRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"shortDescription",
            	    												lv_shortDescription_4_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_10); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUnorderedGroupsTestLanguage.g:1258:4: ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1258:4: ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1259:5: {...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1259:111: ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1260:6: ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1263:9: ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1263:10: {...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1263:19: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1263:20: otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
            	    {
            	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_6, grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1267:9: ( (lv_longDescription_7_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1268:10: (lv_longDescription_7_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1268:10: (lv_longDescription_7_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1269:11: lv_longDescription_7_0= RULE_STRING
            	    {
            	    lv_longDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            	    											newLeafNode(lv_longDescription_7_0, grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBug304681ModelRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"longDescription",
            	    												lv_longDescription_7_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_10); 

            	    									newLeafNode(otherlv_8, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUnorderedGroupsTestLanguage.g:1295:4: ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1295:4: ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1296:5: {...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1296:111: ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1297:6: ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1300:9: ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1300:10: {...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1300:19: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1300:20: otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';'
            	    {
            	    otherlv_9=(Token)match(input,32,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_9, grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1304:9: ( (lv_uid_10_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1305:10: (lv_uid_10_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1305:10: (lv_uid_10_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1306:11: lv_uid_10_0= RULE_STRING
            	    {
            	    lv_uid_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            	    											newLeafNode(lv_uid_10_0, grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBug304681ModelRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"uid",
            	    												lv_uid_10_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_10); 

            	    									newLeafNode(otherlv_11, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUnorderedGroupsTestLanguage.g:1332:4: ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1332:4: ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1333:5: {...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1333:111: ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1334:6: ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1337:9: ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1337:10: {...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1337:19: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1337:20: ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';'
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1337:20: ( (lv_flag_12_0= 'flag' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1338:10: (lv_flag_12_0= 'flag' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1338:10: (lv_flag_12_0= 'flag' )
            	    // InternalUnorderedGroupsTestLanguage.g:1339:11: lv_flag_12_0= 'flag'
            	    {
            	    lv_flag_12_0=(Token)match(input,33,FollowSets000.FOLLOW_12); 

            	    											newLeafNode(lv_flag_12_0, grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBug304681ModelRule());
            	    											}
            	    											setWithLastConsumed(current, "flag", lv_flag_12_0 != null, "flag");
            	    										

            	    }


            	    }

            	    otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_10); 

            	    									newLeafNode(otherlv_13, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalUnorderedGroupsTestLanguage.g:1361:4: ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1361:4: ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1362:5: {...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1362:111: ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:1363:6: ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1366:9: ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+
            	    int cnt23=0;
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==34) ) {
            	            int LA23_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt23=1;
            	            }


            	        }
            	        else if ( (LA23_0==35) ) {
            	            int LA23_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt23=1;
            	            }


            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:1366:10: {...}? => ( (lv_features_14_0= ruleBug304681Feature ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:1366:19: ( (lv_features_14_0= ruleBug304681Feature ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:1366:20: (lv_features_14_0= ruleBug304681Feature )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:1366:20: (lv_features_14_0= ruleBug304681Feature )
            	    	    // InternalUnorderedGroupsTestLanguage.g:1367:10: lv_features_14_0= ruleBug304681Feature
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0());
            	    	    									
            	    	    pushFollow(FollowSets000.FOLLOW_10);
            	    	    lv_features_14_0=ruleBug304681Feature();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getBug304681ModelRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"features",
            	    	    											lv_features_14_0,
            	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.UnorderedGroupsTestLanguage.Bug304681Feature");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt23 >= 1 ) break loop23;
            	                EarlyExitException eee =
            	                    new EarlyExitException(23, input);
            	                throw eee;
            	        }
            	        cnt23++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            				

            }

            otherlv_15=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleBug304681Model"


    // $ANTLR start "entryRuleBug304681Feature"
    // InternalUnorderedGroupsTestLanguage.g:1404:1: entryRuleBug304681Feature returns [EObject current=null] : iv_ruleBug304681Feature= ruleBug304681Feature EOF ;
    public final EObject entryRuleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Feature = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1404:57: (iv_ruleBug304681Feature= ruleBug304681Feature EOF )
            // InternalUnorderedGroupsTestLanguage.g:1405:2: iv_ruleBug304681Feature= ruleBug304681Feature EOF
            {
             newCompositeNode(grammarAccess.getBug304681FeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug304681Feature=ruleBug304681Feature();

            state._fsp--;

             current =iv_ruleBug304681Feature; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBug304681Feature"


    // $ANTLR start "ruleBug304681Feature"
    // InternalUnorderedGroupsTestLanguage.g:1411:1: ruleBug304681Feature returns [EObject current=null] : (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) ;
    public final EObject ruleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject this_Bug304681Attribute_0 = null;

        EObject this_Bug304681Reference_1 = null;



        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1417:2: ( (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) )
            // InternalUnorderedGroupsTestLanguage.g:1418:2: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            {
            // InternalUnorderedGroupsTestLanguage.g:1418:2: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            else if ( (LA25_0==35) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalUnorderedGroupsTestLanguage.g:1419:3: this_Bug304681Attribute_0= ruleBug304681Attribute
                    {

                    			newCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug304681Attribute_0=ruleBug304681Attribute();

                    state._fsp--;


                    			current = this_Bug304681Attribute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUnorderedGroupsTestLanguage.g:1428:3: this_Bug304681Reference_1= ruleBug304681Reference
                    {

                    			newCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug304681Reference_1=ruleBug304681Reference();

                    state._fsp--;


                    			current = this_Bug304681Reference_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleBug304681Feature"


    // $ANTLR start "entryRuleBug304681Attribute"
    // InternalUnorderedGroupsTestLanguage.g:1440:1: entryRuleBug304681Attribute returns [EObject current=null] : iv_ruleBug304681Attribute= ruleBug304681Attribute EOF ;
    public final EObject entryRuleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Attribute = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1440:59: (iv_ruleBug304681Attribute= ruleBug304681Attribute EOF )
            // InternalUnorderedGroupsTestLanguage.g:1441:2: iv_ruleBug304681Attribute= ruleBug304681Attribute EOF
            {
             newCompositeNode(grammarAccess.getBug304681AttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug304681Attribute=ruleBug304681Attribute();

            state._fsp--;

             current =iv_ruleBug304681Attribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBug304681Attribute"


    // $ANTLR start "ruleBug304681Attribute"
    // InternalUnorderedGroupsTestLanguage.g:1447:1: ruleBug304681Attribute returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1453:2: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalUnorderedGroupsTestLanguage.g:1454:2: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1454:2: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalUnorderedGroupsTestLanguage.g:1455:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0());
            		
            // InternalUnorderedGroupsTestLanguage.g:1459:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1460:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1460:4: (lv_name_1_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1461:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBug304681AttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2());
            		

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
    // $ANTLR end "ruleBug304681Attribute"


    // $ANTLR start "entryRuleBug304681Reference"
    // InternalUnorderedGroupsTestLanguage.g:1485:1: entryRuleBug304681Reference returns [EObject current=null] : iv_ruleBug304681Reference= ruleBug304681Reference EOF ;
    public final EObject entryRuleBug304681Reference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Reference = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1485:59: (iv_ruleBug304681Reference= ruleBug304681Reference EOF )
            // InternalUnorderedGroupsTestLanguage.g:1486:2: iv_ruleBug304681Reference= ruleBug304681Reference EOF
            {
             newCompositeNode(grammarAccess.getBug304681ReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug304681Reference=ruleBug304681Reference();

            state._fsp--;

             current =iv_ruleBug304681Reference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBug304681Reference"


    // $ANTLR start "ruleBug304681Reference"
    // InternalUnorderedGroupsTestLanguage.g:1492:1: ruleBug304681Reference returns [EObject current=null] : (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Reference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1498:2: ( (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalUnorderedGroupsTestLanguage.g:1499:2: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1499:2: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalUnorderedGroupsTestLanguage.g:1500:3: otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0());
            		
            // InternalUnorderedGroupsTestLanguage.g:1504:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1505:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1505:4: (lv_name_1_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1506:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBug304681ReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2());
            		

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
    // $ANTLR end "ruleBug304681Reference"

    // Delegated rules


    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\21\1\uffff\7\0\4\uffff";
    static final String dfa_3s = "\1\30\1\uffff\7\0\4\uffff";
    static final String dfa_4s = "\1\uffff\1\5\7\uffff\1\1\1\2\1\3\1\4";
    static final String dfa_5s = "\2\uffff\1\4\1\5\1\6\1\1\1\2\1\0\1\3\4\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 848:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_7 = input.LA(1);

                         
                        int index17_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 12;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 10;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_6 = input.LA(1);

                         
                        int index17_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 11;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_8 = input.LA(1);

                         
                        int index17_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 12;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000FE0000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000019FE0000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040000000L});
    }


}