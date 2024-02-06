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

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
    // InternalUnorderedGroupsTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:82:2: ( ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) )
            // InternalUnorderedGroupsTestLanguage.g:83:2: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:83:2: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
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
                    // InternalUnorderedGroupsTestLanguage.g:84:3: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:84:3: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:85:4: otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:89:4: ( (lv_first_1_0= ruleSimpleModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:90:5: (lv_first_1_0= ruleSimpleModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:90:5: (lv_first_1_0= ruleSimpleModel )
                    // InternalUnorderedGroupsTestLanguage.g:91:6: lv_first_1_0= ruleSimpleModel
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
                    // InternalUnorderedGroupsTestLanguage.g:110:3: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:110:3: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:111:4: otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:115:4: ( (lv_second_3_0= ruleMandatoryModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:116:5: (lv_second_3_0= ruleMandatoryModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:116:5: (lv_second_3_0= ruleMandatoryModel )
                    // InternalUnorderedGroupsTestLanguage.g:117:6: lv_second_3_0= ruleMandatoryModel
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
                    // InternalUnorderedGroupsTestLanguage.g:136:3: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:136:3: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:137:4: otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getDigitThreeKeyword_2_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:141:4: ( (lv_thrird_5_0= ruleLoopedModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:142:5: (lv_thrird_5_0= ruleLoopedModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:142:5: (lv_thrird_5_0= ruleLoopedModel )
                    // InternalUnorderedGroupsTestLanguage.g:143:6: lv_thrird_5_0= ruleLoopedModel
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
                    // InternalUnorderedGroupsTestLanguage.g:162:3: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:162:3: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:163:4: otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getDigitFourKeyword_3_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:167:4: ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:168:5: (lv_forth_7_0= ruleGroupLoopedModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:168:5: (lv_forth_7_0= ruleGroupLoopedModel )
                    // InternalUnorderedGroupsTestLanguage.g:169:6: lv_forth_7_0= ruleGroupLoopedModel
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
                    // InternalUnorderedGroupsTestLanguage.g:188:3: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:188:3: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:189:4: otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getDigitFiveKeyword_4_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:193:4: ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    // InternalUnorderedGroupsTestLanguage.g:194:5: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:194:5: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    // InternalUnorderedGroupsTestLanguage.g:195:6: lv_fifth_9_0= ruleLoopedAlternativeModel
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
                    // InternalUnorderedGroupsTestLanguage.g:214:3: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:214:3: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    // InternalUnorderedGroupsTestLanguage.g:215:4: otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getBug304681Keyword_5_0());
                    			
                    // InternalUnorderedGroupsTestLanguage.g:219:4: ( (lv_model_11_0= ruleBug304681Model ) )
                    // InternalUnorderedGroupsTestLanguage.g:220:5: (lv_model_11_0= ruleBug304681Model )
                    {
                    // InternalUnorderedGroupsTestLanguage.g:220:5: (lv_model_11_0= ruleBug304681Model )
                    // InternalUnorderedGroupsTestLanguage.g:221:6: lv_model_11_0= ruleBug304681Model
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
    // InternalUnorderedGroupsTestLanguage.g:243:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:243:52: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:244:2: iv_ruleSimpleModel= ruleSimpleModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:250:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:256:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:257:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:257:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:258:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:258:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:259:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:259:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:260:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:263:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:264:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:264:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )*
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
            	    // InternalUnorderedGroupsTestLanguage.g:265:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:265:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:266:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:266:108: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:267:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:270:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:270:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:270:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:270:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:270:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:271:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:271:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
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
            	            // InternalUnorderedGroupsTestLanguage.g:272:11: lv_visibility_1_1= 'public'
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
            	            // InternalUnorderedGroupsTestLanguage.g:283:11: lv_visibility_1_2= 'private'
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
            	            // InternalUnorderedGroupsTestLanguage.g:294:11: lv_visibility_1_3= 'protected'
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
            	    // InternalUnorderedGroupsTestLanguage.g:312:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:312:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:313:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:313:108: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:314:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:317:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:317:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:317:19: ( (lv_static_2_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:317:20: (lv_static_2_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:317:20: (lv_static_2_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:318:10: lv_static_2_0= 'static'
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
            	    // InternalUnorderedGroupsTestLanguage.g:335:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:335:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:336:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:336:108: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:337:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:340:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:340:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:340:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:340:20: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:340:20: (lv_synchronized_3_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:341:10: lv_synchronized_3_0= 'synchronized'
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
            	    // InternalUnorderedGroupsTestLanguage.g:358:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:358:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:359:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:359:108: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:360:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:363:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:363:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:363:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
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
            	            // InternalUnorderedGroupsTestLanguage.g:363:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:363:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:364:10: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:364:10: (lv_abstract_4_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:365:11: lv_abstract_4_0= 'abstract'
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
            	            // InternalUnorderedGroupsTestLanguage.g:378:9: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:378:9: ( (lv_final_5_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:379:10: (lv_final_5_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:379:10: (lv_final_5_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:380:11: lv_final_5_0= 'final'
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
            		
            // InternalUnorderedGroupsTestLanguage.g:409:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:410:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:410:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:411:5: lv_name_7_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:439:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:439:55: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:440:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:446:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:452:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:453:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:453:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:454:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:454:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )
            // InternalUnorderedGroupsTestLanguage.g:455:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalUnorderedGroupsTestLanguage.g:455:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            // InternalUnorderedGroupsTestLanguage.g:456:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:459:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            // InternalUnorderedGroupsTestLanguage.g:460:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?
            {
            // InternalUnorderedGroupsTestLanguage.g:460:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+
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
            	    // InternalUnorderedGroupsTestLanguage.g:461:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:461:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:462:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:462:111: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:463:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:466:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:466:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:466:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:466:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:466:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:467:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:467:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
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
            	            // InternalUnorderedGroupsTestLanguage.g:468:11: lv_visibility_1_1= 'public'
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
            	            // InternalUnorderedGroupsTestLanguage.g:479:11: lv_visibility_1_2= 'private'
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
            	            // InternalUnorderedGroupsTestLanguage.g:490:11: lv_visibility_1_3= 'protected'
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
            	    // InternalUnorderedGroupsTestLanguage.g:508:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:508:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:509:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:509:111: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:510:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:513:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:513:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:513:19: ( (lv_static_2_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:513:20: (lv_static_2_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:513:20: (lv_static_2_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:514:10: lv_static_2_0= 'static'
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
            	    // InternalUnorderedGroupsTestLanguage.g:531:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:531:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:532:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:532:111: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:533:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:536:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:536:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:536:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:536:20: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:536:20: (lv_synchronized_3_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:537:10: lv_synchronized_3_0= 'synchronized'
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
            	    // InternalUnorderedGroupsTestLanguage.g:554:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:554:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:555:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:555:111: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:556:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:559:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:559:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:559:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
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
            	            // InternalUnorderedGroupsTestLanguage.g:559:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:559:20: ( (lv_abstract_4_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:560:10: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:560:10: (lv_abstract_4_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:561:11: lv_abstract_4_0= 'abstract'
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
            	            // InternalUnorderedGroupsTestLanguage.g:574:9: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:574:9: ( (lv_final_5_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:575:10: (lv_final_5_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:575:10: (lv_final_5_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:576:11: lv_final_5_0= 'final'
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
            		
            // InternalUnorderedGroupsTestLanguage.g:606:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:607:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:607:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:608:5: lv_name_7_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:636:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:636:52: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:637:2: iv_ruleLoopedModel= ruleLoopedModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:643:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:649:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:650:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:650:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:651:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:651:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:652:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:652:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:653:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            				
            // InternalUnorderedGroupsTestLanguage.g:656:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:657:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:657:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) ) )*
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
            	    // InternalUnorderedGroupsTestLanguage.g:658:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:658:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:659:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:659:108: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:660:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:663:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )+
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:663:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:663:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:663:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:663:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:664:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:664:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:665:11: lv_visibility_1_1= 'public'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:676:11: lv_visibility_1_2= 'private'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:687:11: lv_visibility_1_3= 'protected'
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
            	    // InternalUnorderedGroupsTestLanguage.g:705:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:705:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:706:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:706:108: ( ({...}? => ( (lv_static_2_0= 'static' ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:707:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:710:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )+
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:710:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:710:19: ( (lv_static_2_0= 'static' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:710:20: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:710:20: (lv_static_2_0= 'static' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:711:10: lv_static_2_0= 'static'
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
            	    // InternalUnorderedGroupsTestLanguage.g:728:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:728:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:729:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:729:108: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:730:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:733:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )+
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:733:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:733:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:733:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:733:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:734:10: lv_synchronized_3_0= 'synchronized'
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
            	    // InternalUnorderedGroupsTestLanguage.g:751:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:751:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:752:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:752:108: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:753:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:756:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )+
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:756:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:756:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:756:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:756:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:757:10: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:757:10: (lv_abstract_4_0= 'abstract' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:758:11: lv_abstract_4_0= 'abstract'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:771:9: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:771:9: ( (lv_final_5_0= 'final' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:772:10: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:772:10: (lv_final_5_0= 'final' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:773:11: lv_final_5_0= 'final'
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
            		
            // InternalUnorderedGroupsTestLanguage.g:802:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:803:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:803:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:804:5: lv_name_7_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:832:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:832:57: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:833:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:839:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:845:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:846:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:846:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // InternalUnorderedGroupsTestLanguage.g:847:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:847:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=17 && LA18_0<=23)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalUnorderedGroupsTestLanguage.g:848:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:848:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?) )
            	    // InternalUnorderedGroupsTestLanguage.g:849:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    				  getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    				
            	    // InternalUnorderedGroupsTestLanguage.g:852:5: ( ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?)
            	    // InternalUnorderedGroupsTestLanguage.g:853:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+ {...}?
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:853:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=5;
            	        alt17 = dfa17.predict(input);
            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:854:4: ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:855:5: {...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:855:113: ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:856:6: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:859:9: ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:859:10: {...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:859:19: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:859:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:859:20: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:860:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:860:10: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:861:11: lv_visibility_1_1= 'public'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:872:11: lv_visibility_1_2= 'private'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:883:11: lv_visibility_1_3= 'protected'
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:901:4: ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:902:5: {...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:902:113: ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:903:6: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:906:9: ({...}? => ( (lv_static_2_0= 'static' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:906:10: {...}? => ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:906:19: ( (lv_static_2_0= 'static' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:906:20: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:906:20: (lv_static_2_0= 'static' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:907:10: lv_static_2_0= 'static'
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:924:4: ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:925:5: {...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:925:113: ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:926:6: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:929:9: ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:929:10: {...}? => ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:929:19: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:929:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:929:20: (lv_synchronized_3_0= 'synchronized' )
            	    	    // InternalUnorderedGroupsTestLanguage.g:930:10: lv_synchronized_3_0= 'synchronized'
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:947:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:947:4: ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:948:5: {...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:948:113: ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:949:6: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {

            	    	    						getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	    					
            	    	    // InternalUnorderedGroupsTestLanguage.g:952:9: ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:952:10: {...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:952:19: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:952:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:952:20: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:953:10: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:953:10: (lv_abstract_4_0= 'abstract' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:954:11: lv_abstract_4_0= 'abstract'
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
            	    	            // InternalUnorderedGroupsTestLanguage.g:967:9: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:967:9: ( (lv_final_5_0= 'final' ) )
            	    	            // InternalUnorderedGroupsTestLanguage.g:968:10: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // InternalUnorderedGroupsTestLanguage.g:968:10: (lv_final_5_0= 'final' )
            	    	            // InternalUnorderedGroupsTestLanguage.g:969:11: lv_final_5_0= 'final'
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
            		
            // InternalUnorderedGroupsTestLanguage.g:999:3: ( (lv_name_7_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1000:4: (lv_name_7_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1000:4: (lv_name_7_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1001:5: lv_name_7_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:1029:1: entryRuleLoopedAlternativeModel returns [EObject current=null] : iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF ;
    public final EObject entryRuleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedAlternativeModel = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1029:63: (iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF )
            // InternalUnorderedGroupsTestLanguage.g:1030:2: iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF
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
    // InternalUnorderedGroupsTestLanguage.g:1036:1: ruleLoopedAlternativeModel returns [EObject current=null] : ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:1042:2: ( ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:1043:2: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1043:2: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            // InternalUnorderedGroupsTestLanguage.g:1044:3: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:1044:3: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )*
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
            	    // InternalUnorderedGroupsTestLanguage.g:1045:4: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1045:4: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1046:5: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1046:5: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1047:6: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1047:6: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
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
            	            // InternalUnorderedGroupsTestLanguage.g:1048:7: lv_visibility_0_1= 'public'
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
            	            // InternalUnorderedGroupsTestLanguage.g:1059:7: lv_visibility_0_2= 'private'
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
            	            // InternalUnorderedGroupsTestLanguage.g:1070:7: lv_visibility_0_3= 'protected'
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
            	    // InternalUnorderedGroupsTestLanguage.g:1084:4: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1084:4: ( (lv_static_1_0= 'static' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1085:5: (lv_static_1_0= 'static' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1085:5: (lv_static_1_0= 'static' )
            	    // InternalUnorderedGroupsTestLanguage.g:1086:6: lv_static_1_0= 'static'
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
            	    // InternalUnorderedGroupsTestLanguage.g:1099:4: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1099:4: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1100:5: (lv_synchronized_2_0= 'synchronized' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1100:5: (lv_synchronized_2_0= 'synchronized' )
            	    // InternalUnorderedGroupsTestLanguage.g:1101:6: lv_synchronized_2_0= 'synchronized'
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
            	    // InternalUnorderedGroupsTestLanguage.g:1114:4: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1114:4: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
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
            	            // InternalUnorderedGroupsTestLanguage.g:1115:5: ( (lv_abstract_3_0= 'abstract' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1115:5: ( (lv_abstract_3_0= 'abstract' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:1116:6: (lv_abstract_3_0= 'abstract' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1116:6: (lv_abstract_3_0= 'abstract' )
            	            // InternalUnorderedGroupsTestLanguage.g:1117:7: lv_abstract_3_0= 'abstract'
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
            	            // InternalUnorderedGroupsTestLanguage.g:1130:5: ( (lv_final_4_0= 'final' ) )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1130:5: ( (lv_final_4_0= 'final' ) )
            	            // InternalUnorderedGroupsTestLanguage.g:1131:6: (lv_final_4_0= 'final' )
            	            {
            	            // InternalUnorderedGroupsTestLanguage.g:1131:6: (lv_final_4_0= 'final' )
            	            // InternalUnorderedGroupsTestLanguage.g:1132:7: lv_final_4_0= 'final'
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
            	    // InternalUnorderedGroupsTestLanguage.g:1146:4: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1146:4: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    // InternalUnorderedGroupsTestLanguage.g:1147:5: otherlv_5= 'before' (otherlv_6= 'after' )*
            	    {
            	    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_9); 

            	    					newLeafNode(otherlv_5, grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0());
            	    				
            	    // InternalUnorderedGroupsTestLanguage.g:1151:5: (otherlv_6= 'after' )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==28) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // InternalUnorderedGroupsTestLanguage.g:1152:6: otherlv_6= 'after'
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
            		
            // InternalUnorderedGroupsTestLanguage.g:1163:3: ( (lv_name_8_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1164:4: (lv_name_8_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1164:4: (lv_name_8_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1165:5: lv_name_8_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:1193:1: entryRuleBug304681Model returns [EObject current=null] : iv_ruleBug304681Model= ruleBug304681Model EOF ;
    public final EObject entryRuleBug304681Model() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Model = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1193:55: (iv_ruleBug304681Model= ruleBug304681Model EOF )
            // InternalUnorderedGroupsTestLanguage.g:1194:2: iv_ruleBug304681Model= ruleBug304681Model EOF
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
    // InternalUnorderedGroupsTestLanguage.g:1200:1: ruleBug304681Model returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' ) ;
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
            // InternalUnorderedGroupsTestLanguage.g:1206:2: ( ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' ) )
            // InternalUnorderedGroupsTestLanguage.g:1207:2: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1207:2: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            // InternalUnorderedGroupsTestLanguage.g:1208:3: () otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) ) otherlv_15= '}'
            {
            // InternalUnorderedGroupsTestLanguage.g:1208:3: ()
            // InternalUnorderedGroupsTestLanguage.g:1209:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalUnorderedGroupsTestLanguage.g:1219:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) ) )
            // InternalUnorderedGroupsTestLanguage.g:1220:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) )
            {
            // InternalUnorderedGroupsTestLanguage.g:1220:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* ) )
            // InternalUnorderedGroupsTestLanguage.g:1221:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            				
            // InternalUnorderedGroupsTestLanguage.g:1224:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )* )
            // InternalUnorderedGroupsTestLanguage.g:1225:6: ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )*
            {
            // InternalUnorderedGroupsTestLanguage.g:1225:6: ( ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) ) )*
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
            	    // InternalUnorderedGroupsTestLanguage.g:1226:4: ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1226:4: ({...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1227:5: {...}? => ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1227:111: ( ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1228:6: ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1231:9: ({...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1231:10: {...}? => (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1231:19: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1231:20: otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';'
            	    {
            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_3, grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1235:9: ( (lv_shortDescription_4_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1236:10: (lv_shortDescription_4_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1236:10: (lv_shortDescription_4_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1237:11: lv_shortDescription_4_0= RULE_STRING
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
            	    // InternalUnorderedGroupsTestLanguage.g:1263:4: ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1263:4: ({...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1264:5: {...}? => ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1264:111: ( ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1265:6: ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1268:9: ({...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1268:10: {...}? => (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1268:19: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1268:20: otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
            	    {
            	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_6, grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1272:9: ( (lv_longDescription_7_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1273:10: (lv_longDescription_7_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1273:10: (lv_longDescription_7_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1274:11: lv_longDescription_7_0= RULE_STRING
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
            	    // InternalUnorderedGroupsTestLanguage.g:1300:4: ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1300:4: ({...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1301:5: {...}? => ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1301:111: ( ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1302:6: ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1305:9: ({...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1305:10: {...}? => (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1305:19: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1305:20: otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';'
            	    {
            	    otherlv_9=(Token)match(input,32,FollowSets000.FOLLOW_11); 

            	    									newLeafNode(otherlv_9, grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0());
            	    								
            	    // InternalUnorderedGroupsTestLanguage.g:1309:9: ( (lv_uid_10_0= RULE_STRING ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1310:10: (lv_uid_10_0= RULE_STRING )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1310:10: (lv_uid_10_0= RULE_STRING )
            	    // InternalUnorderedGroupsTestLanguage.g:1311:11: lv_uid_10_0= RULE_STRING
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
            	    // InternalUnorderedGroupsTestLanguage.g:1337:4: ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1337:4: ({...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1338:5: {...}? => ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1338:111: ( ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1339:6: ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1342:9: ({...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1342:10: {...}? => ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1342:19: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    // InternalUnorderedGroupsTestLanguage.g:1342:20: ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';'
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1342:20: ( (lv_flag_12_0= 'flag' ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1343:10: (lv_flag_12_0= 'flag' )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1343:10: (lv_flag_12_0= 'flag' )
            	    // InternalUnorderedGroupsTestLanguage.g:1344:11: lv_flag_12_0= 'flag'
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
            	    // InternalUnorderedGroupsTestLanguage.g:1366:4: ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) )
            	    {
            	    // InternalUnorderedGroupsTestLanguage.g:1366:4: ({...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ ) )
            	    // InternalUnorderedGroupsTestLanguage.g:1367:5: {...}? => ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // InternalUnorderedGroupsTestLanguage.g:1367:111: ( ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+ )
            	    // InternalUnorderedGroupsTestLanguage.g:1368:6: ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4);
            	    					
            	    // InternalUnorderedGroupsTestLanguage.g:1371:9: ({...}? => ( (lv_features_14_0= ruleBug304681Feature ) ) )+
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
            	    	    // InternalUnorderedGroupsTestLanguage.g:1371:10: {...}? => ( (lv_features_14_0= ruleBug304681Feature ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleBug304681Model", "true");
            	    	    }
            	    	    // InternalUnorderedGroupsTestLanguage.g:1371:19: ( (lv_features_14_0= ruleBug304681Feature ) )
            	    	    // InternalUnorderedGroupsTestLanguage.g:1371:20: (lv_features_14_0= ruleBug304681Feature )
            	    	    {
            	    	    // InternalUnorderedGroupsTestLanguage.g:1371:20: (lv_features_14_0= ruleBug304681Feature )
            	    	    // InternalUnorderedGroupsTestLanguage.g:1372:10: lv_features_14_0= ruleBug304681Feature
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
    // InternalUnorderedGroupsTestLanguage.g:1409:1: entryRuleBug304681Feature returns [EObject current=null] : iv_ruleBug304681Feature= ruleBug304681Feature EOF ;
    public final EObject entryRuleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Feature = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1409:57: (iv_ruleBug304681Feature= ruleBug304681Feature EOF )
            // InternalUnorderedGroupsTestLanguage.g:1410:2: iv_ruleBug304681Feature= ruleBug304681Feature EOF
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
    // InternalUnorderedGroupsTestLanguage.g:1416:1: ruleBug304681Feature returns [EObject current=null] : (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) ;
    public final EObject ruleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject this_Bug304681Attribute_0 = null;

        EObject this_Bug304681Reference_1 = null;



        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1422:2: ( (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) )
            // InternalUnorderedGroupsTestLanguage.g:1423:2: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            {
            // InternalUnorderedGroupsTestLanguage.g:1423:2: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
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
                    // InternalUnorderedGroupsTestLanguage.g:1424:3: this_Bug304681Attribute_0= ruleBug304681Attribute
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
                    // InternalUnorderedGroupsTestLanguage.g:1433:3: this_Bug304681Reference_1= ruleBug304681Reference
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
    // InternalUnorderedGroupsTestLanguage.g:1445:1: entryRuleBug304681Attribute returns [EObject current=null] : iv_ruleBug304681Attribute= ruleBug304681Attribute EOF ;
    public final EObject entryRuleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Attribute = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1445:59: (iv_ruleBug304681Attribute= ruleBug304681Attribute EOF )
            // InternalUnorderedGroupsTestLanguage.g:1446:2: iv_ruleBug304681Attribute= ruleBug304681Attribute EOF
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
    // InternalUnorderedGroupsTestLanguage.g:1452:1: ruleBug304681Attribute returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1458:2: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalUnorderedGroupsTestLanguage.g:1459:2: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1459:2: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalUnorderedGroupsTestLanguage.g:1460:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0());
            		
            // InternalUnorderedGroupsTestLanguage.g:1464:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1465:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1465:4: (lv_name_1_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1466:5: lv_name_1_0= RULE_ID
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
    // InternalUnorderedGroupsTestLanguage.g:1490:1: entryRuleBug304681Reference returns [EObject current=null] : iv_ruleBug304681Reference= ruleBug304681Reference EOF ;
    public final EObject entryRuleBug304681Reference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Reference = null;


        try {
            // InternalUnorderedGroupsTestLanguage.g:1490:59: (iv_ruleBug304681Reference= ruleBug304681Reference EOF )
            // InternalUnorderedGroupsTestLanguage.g:1491:2: iv_ruleBug304681Reference= ruleBug304681Reference EOF
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
    // InternalUnorderedGroupsTestLanguage.g:1497:1: ruleBug304681Reference returns [EObject current=null] : (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Reference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalUnorderedGroupsTestLanguage.g:1503:2: ( (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalUnorderedGroupsTestLanguage.g:1504:2: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalUnorderedGroupsTestLanguage.g:1504:2: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalUnorderedGroupsTestLanguage.g:1505:3: otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0());
            		
            // InternalUnorderedGroupsTestLanguage.g:1509:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUnorderedGroupsTestLanguage.g:1510:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUnorderedGroupsTestLanguage.g:1510:4: (lv_name_1_0= RULE_ID )
            // InternalUnorderedGroupsTestLanguage.g:1511:5: lv_name_1_0= RULE_ID
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
            return "()+ loopback of 853:6: ( ({...}? => ( ({...}? => ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_static_2_0= 'static' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) ) )+";
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