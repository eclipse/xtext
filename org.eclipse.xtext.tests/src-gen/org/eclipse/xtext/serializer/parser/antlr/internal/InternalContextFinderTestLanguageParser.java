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
import org.eclipse.xtext.serializer.services.ContextFinderTestLanguageGrammarAccess;



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
public class InternalContextFinderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#0'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'model'", "'kw1'", "'kw2'", "'.'", "'foo'", "'lit1'", "'lit2'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalContextFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContextFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContextFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContextFinderTestLanguage.g"; }



     	private ContextFinderTestLanguageGrammarAccess grammarAccess;

        public InternalContextFinderTestLanguageParser(TokenStream input, ContextFinderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ContextFinderTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalContextFinderTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalContextFinderTestLanguage.g:70:46: (iv_ruleModel= ruleModel EOF )
            // InternalContextFinderTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // InternalContextFinderTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) ;
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
        Token lv_name_15_0=null;
        Token otherlv_17=null;
        Token lv_name_18_0=null;
        EObject lv_model_1_0 = null;

        EObject lv_attributeExclusion_3_1 = null;

        EObject lv_attributeExclusion_3_2 = null;

        EObject lv_nestedType_5_1 = null;

        EObject lv_nestedType_5_2 = null;

        EObject lv_nestedTypeRecursiveTest2_7_1 = null;

        EObject lv_nestedTypeRecursiveTest2_7_2 = null;

        EObject lv_parentRef_9_1 = null;

        EObject lv_parentRef_9_2 = null;

        EObject lv_quantityExclusion_11_1 = null;

        EObject lv_quantityExclusion_11_2 = null;

        EObject lv_valueExclusion_13_1 = null;

        EObject lv_valueExclusion_13_2 = null;

        EObject lv_nodeExclusion_16_1 = null;

        EObject lv_nodeExclusion_16_2 = null;

        EObject lv_nodeExclusionList_19_1 = null;

        EObject lv_nodeExclusionList_19_2 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:83:2: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) )
            // InternalContextFinderTestLanguage.g:84:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
            {
            // InternalContextFinderTestLanguage.g:84:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
            int alt9=9;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt9=1;
                }
                break;
            case 12:
                {
                alt9=2;
                }
                break;
            case 13:
                {
                alt9=3;
                }
                break;
            case 14:
                {
                alt9=4;
                }
                break;
            case 15:
                {
                alt9=5;
                }
                break;
            case 16:
                {
                alt9=6;
                }
                break;
            case 17:
                {
                alt9=7;
                }
                break;
            case 18:
                {
                alt9=8;
                }
                break;
            case 19:
                {
                alt9=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalContextFinderTestLanguage.g:85:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:85:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    // InternalContextFinderTestLanguage.g:86:4: otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitZeroKeyword_0_0());
                    			
                    // InternalContextFinderTestLanguage.g:90:4: ( (lv_model_1_0= ruleModel2 ) )
                    // InternalContextFinderTestLanguage.g:91:5: (lv_model_1_0= ruleModel2 )
                    {
                    // InternalContextFinderTestLanguage.g:91:5: (lv_model_1_0= ruleModel2 )
                    // InternalContextFinderTestLanguage.g:92:6: lv_model_1_0= ruleModel2
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getModelModel2ParserRuleCall_0_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_model_1_0=ruleModel2();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"model",
                    							lv_model_1_0,
                    							"org.eclipse.xtext.serializer.ContextFinderTestLanguage.Model2");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContextFinderTestLanguage.g:111:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:111:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:112:4: otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_1_0());
                    			
                    // InternalContextFinderTestLanguage.g:116:4: ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:117:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:117:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    // InternalContextFinderTestLanguage.g:118:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:118:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==21) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==22) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:119:7: lv_attributeExclusion_3_1= ruleAttributeExclusionTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_attributeExclusion_3_1=ruleAttributeExclusionTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"attributeExclusion",
                            								lv_attributeExclusion_3_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.AttributeExclusionTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:135:7: lv_attributeExclusion_3_2= ruleAttributeExclusionTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_attributeExclusion_3_2=ruleAttributeExclusionTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"attributeExclusion",
                            								lv_attributeExclusion_3_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.AttributeExclusionTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalContextFinderTestLanguage.g:155:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:155:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:156:4: otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_2_0());
                    			
                    // InternalContextFinderTestLanguage.g:160:4: ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:161:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:161:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    // InternalContextFinderTestLanguage.g:162:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:162:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==21) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==22) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:163:7: lv_nestedType_5_1= ruleNestedTypeTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedType_5_1=ruleNestedTypeTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nestedType",
                            								lv_nestedType_5_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:179:7: lv_nestedType_5_2= ruleNestedTypeTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedType_5_2=ruleNestedTypeTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nestedType",
                            								lv_nestedType_5_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalContextFinderTestLanguage.g:199:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:199:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:200:4: otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_3_0());
                    			
                    // InternalContextFinderTestLanguage.g:204:4: ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:205:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:205:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    // InternalContextFinderTestLanguage.g:206:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:206:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==21) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==22) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:207:7: lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedTypeRecursiveTest2_7_1=ruleNestedTypeRecursiveTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nestedTypeRecursiveTest2",
                            								lv_nestedTypeRecursiveTest2_7_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeRecursiveTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:223:7: lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedTypeRecursiveTest2_7_2=ruleNestedTypeRecursiveTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nestedTypeRecursiveTest2",
                            								lv_nestedTypeRecursiveTest2_7_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeRecursiveTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalContextFinderTestLanguage.g:243:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:243:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:244:4: otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_4_0());
                    			
                    // InternalContextFinderTestLanguage.g:248:4: ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:249:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:249:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    // InternalContextFinderTestLanguage.g:250:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:250:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==21) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==22) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:251:7: lv_parentRef_9_1= ruleParentRefTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getParentRefParentRefTest1ParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_parentRef_9_1=ruleParentRefTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"parentRef",
                            								lv_parentRef_9_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:267:7: lv_parentRef_9_2= ruleParentRefTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getParentRefParentRefTest2ParserRuleCall_4_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_parentRef_9_2=ruleParentRefTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"parentRef",
                            								lv_parentRef_9_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalContextFinderTestLanguage.g:287:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:287:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:288:4: otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_5_0());
                    			
                    // InternalContextFinderTestLanguage.g:292:4: ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:293:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:293:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    // InternalContextFinderTestLanguage.g:294:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:294:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==22) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:295:7: lv_quantityExclusion_11_1= ruleQuantityExclusionTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getQuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_quantityExclusion_11_1=ruleQuantityExclusionTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"quantityExclusion",
                            								lv_quantityExclusion_11_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.QuantityExclusionTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:311:7: lv_quantityExclusion_11_2= ruleQuantityExclusionTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getQuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_quantityExclusion_11_2=ruleQuantityExclusionTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"quantityExclusion",
                            								lv_quantityExclusion_11_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.QuantityExclusionTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalContextFinderTestLanguage.g:331:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:331:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:332:4: otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    {
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitSixKeyword_6_0());
                    			
                    // InternalContextFinderTestLanguage.g:336:4: ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    // InternalContextFinderTestLanguage.g:337:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:337:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    // InternalContextFinderTestLanguage.g:338:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
                    {
                    // InternalContextFinderTestLanguage.g:338:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==25) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==26) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:339:7: lv_valueExclusion_13_1= ruleValueExclusionTest1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_valueExclusion_13_1=ruleValueExclusionTest1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"valueExclusion",
                            								lv_valueExclusion_13_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ValueExclusionTest1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:355:7: lv_valueExclusion_13_2= ruleValueExclusionTest2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_valueExclusion_13_2=ruleValueExclusionTest2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"valueExclusion",
                            								lv_valueExclusion_13_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ValueExclusionTest2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalContextFinderTestLanguage.g:375:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:375:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    // InternalContextFinderTestLanguage.g:376:4: otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    {
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitSevenKeyword_7_0());
                    			
                    // InternalContextFinderTestLanguage.g:380:4: ( (lv_name_15_0= RULE_STRING ) )
                    // InternalContextFinderTestLanguage.g:381:5: (lv_name_15_0= RULE_STRING )
                    {
                    // InternalContextFinderTestLanguage.g:381:5: (lv_name_15_0= RULE_STRING )
                    // InternalContextFinderTestLanguage.g:382:6: lv_name_15_0= RULE_STRING
                    {
                    lv_name_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

                    						newLeafNode(lv_name_15_0, grammarAccess.getModelAccess().getNameSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_15_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalContextFinderTestLanguage.g:398:4: ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    // InternalContextFinderTestLanguage.g:399:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    {
                    // InternalContextFinderTestLanguage.g:399:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    // InternalContextFinderTestLanguage.g:400:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
                    {
                    // InternalContextFinderTestLanguage.g:400:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==RULE_ID) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==RULE_STRING) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:401:7: lv_nodeExclusion_16_1= ruleNodeExclusion1
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusion_16_1=ruleNodeExclusion1();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nodeExclusion",
                            								lv_nodeExclusion_16_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NodeExclusion1");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:417:7: lv_nodeExclusion_16_2= ruleNodeExclusion2
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusion_16_2=ruleNodeExclusion2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nodeExclusion",
                            								lv_nodeExclusion_16_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NodeExclusion2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalContextFinderTestLanguage.g:437:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    {
                    // InternalContextFinderTestLanguage.g:437:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    // InternalContextFinderTestLanguage.g:438:4: otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_17, grammarAccess.getModelAccess().getNumberSignDigitEightKeyword_8_0());
                    			
                    // InternalContextFinderTestLanguage.g:442:4: ( (lv_name_18_0= RULE_STRING ) )
                    // InternalContextFinderTestLanguage.g:443:5: (lv_name_18_0= RULE_STRING )
                    {
                    // InternalContextFinderTestLanguage.g:443:5: (lv_name_18_0= RULE_STRING )
                    // InternalContextFinderTestLanguage.g:444:6: lv_name_18_0= RULE_STRING
                    {
                    lv_name_18_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

                    						newLeafNode(lv_name_18_0, grammarAccess.getModelAccess().getNameSTRINGTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_18_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalContextFinderTestLanguage.g:460:4: ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    // InternalContextFinderTestLanguage.g:461:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    {
                    // InternalContextFinderTestLanguage.g:461:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    // InternalContextFinderTestLanguage.g:462:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
                    {
                    // InternalContextFinderTestLanguage.g:462:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_STRING) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalContextFinderTestLanguage.g:463:7: lv_nodeExclusionList_19_1= ruleNodeExclusion1List
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusionList_19_1=ruleNodeExclusion1List();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nodeExclusionList",
                            								lv_nodeExclusionList_19_1,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NodeExclusion1List");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalContextFinderTestLanguage.g:479:7: lv_nodeExclusionList_19_2= ruleNodeExclusion2List
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusionList_19_2=ruleNodeExclusion2List();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"nodeExclusionList",
                            								lv_nodeExclusionList_19_2,
                            								"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NodeExclusion2List");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


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


    // $ANTLR start "entryRuleModel2"
    // InternalContextFinderTestLanguage.g:502:1: entryRuleModel2 returns [EObject current=null] : iv_ruleModel2= ruleModel2 EOF ;
    public final EObject entryRuleModel2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel2 = null;


        try {
            // InternalContextFinderTestLanguage.g:502:47: (iv_ruleModel2= ruleModel2 EOF )
            // InternalContextFinderTestLanguage.g:503:2: iv_ruleModel2= ruleModel2 EOF
            {
             newCompositeNode(grammarAccess.getModel2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel2=ruleModel2();

            state._fsp--;

             current =iv_ruleModel2; 
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
    // $ANTLR end "entryRuleModel2"


    // $ANTLR start "ruleModel2"
    // InternalContextFinderTestLanguage.g:509:1: ruleModel2 returns [EObject current=null] : ( () otherlv_1= 'model' ) ;
    public final EObject ruleModel2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:515:2: ( ( () otherlv_1= 'model' ) )
            // InternalContextFinderTestLanguage.g:516:2: ( () otherlv_1= 'model' )
            {
            // InternalContextFinderTestLanguage.g:516:2: ( () otherlv_1= 'model' )
            // InternalContextFinderTestLanguage.g:517:3: () otherlv_1= 'model'
            {
            // InternalContextFinderTestLanguage.g:517:3: ()
            // InternalContextFinderTestLanguage.g:518:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModel2Access().getModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getModel2Access().getModelKeyword_1());
            		

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
    // $ANTLR end "ruleModel2"


    // $ANTLR start "entryRuleAttributeExclusionTest1"
    // InternalContextFinderTestLanguage.g:532:1: entryRuleAttributeExclusionTest1 returns [EObject current=null] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final EObject entryRuleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:532:64: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // InternalContextFinderTestLanguage.g:533:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
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
    // $ANTLR end "entryRuleAttributeExclusionTest1"


    // $ANTLR start "ruleAttributeExclusionTest1"
    // InternalContextFinderTestLanguage.g:539:1: ruleAttributeExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:545:2: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // InternalContextFinderTestLanguage.g:546:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // InternalContextFinderTestLanguage.g:546:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:547:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest1Access().getKw1Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:551:3: ( (lv_attr1_1_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:552:4: (lv_attr1_1_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:552:4: (lv_attr1_1_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:553:5: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_attr1_1_0, grammarAccess.getAttributeExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeExclusionTest1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr1",
            						lv_attr1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleAttributeExclusionTest1"


    // $ANTLR start "entryRuleAttributeExclusionTest2"
    // InternalContextFinderTestLanguage.g:573:1: entryRuleAttributeExclusionTest2 returns [EObject current=null] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final EObject entryRuleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:573:64: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // InternalContextFinderTestLanguage.g:574:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
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
    // $ANTLR end "entryRuleAttributeExclusionTest2"


    // $ANTLR start "ruleAttributeExclusionTest2"
    // InternalContextFinderTestLanguage.g:580:1: ruleAttributeExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:586:2: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // InternalContextFinderTestLanguage.g:587:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // InternalContextFinderTestLanguage.g:587:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:588:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest2Access().getKw2Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:592:3: ( (lv_attr2_1_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:593:4: (lv_attr2_1_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:593:4: (lv_attr2_1_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:594:5: lv_attr2_1_0= RULE_ID
            {
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_attr2_1_0, grammarAccess.getAttributeExclusionTest2Access().getAttr2IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeExclusionTest2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr2",
            						lv_attr2_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleAttributeExclusionTest2"


    // $ANTLR start "entryRuleNestedTypeTest1"
    // InternalContextFinderTestLanguage.g:614:1: entryRuleNestedTypeTest1 returns [EObject current=null] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final EObject entryRuleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:614:56: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // InternalContextFinderTestLanguage.g:615:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
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
    // $ANTLR end "entryRuleNestedTypeTest1"


    // $ANTLR start "ruleNestedTypeTest1"
    // InternalContextFinderTestLanguage.g:621:1: ruleNestedTypeTest1 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final EObject ruleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:627:2: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // InternalContextFinderTestLanguage.g:628:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // InternalContextFinderTestLanguage.g:628:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // InternalContextFinderTestLanguage.g:629:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // InternalContextFinderTestLanguage.g:629:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            // InternalContextFinderTestLanguage.g:630:4: lv_nested_0_0= ruleNestedTypeChild1
            {

            				newCompositeNode(grammarAccess.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_nested_0_0=ruleNestedTypeChild1();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getNestedTypeTest1Rule());
            				}
            				set(
            					current,
            					"nested",
            					lv_nested_0_0,
            					"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeChild1");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleNestedTypeTest1"


    // $ANTLR start "entryRuleNestedTypeTest2"
    // InternalContextFinderTestLanguage.g:650:1: entryRuleNestedTypeTest2 returns [EObject current=null] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final EObject entryRuleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:650:56: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // InternalContextFinderTestLanguage.g:651:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
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
    // $ANTLR end "entryRuleNestedTypeTest2"


    // $ANTLR start "ruleNestedTypeTest2"
    // InternalContextFinderTestLanguage.g:657:1: ruleNestedTypeTest2 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final EObject ruleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:663:2: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // InternalContextFinderTestLanguage.g:664:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // InternalContextFinderTestLanguage.g:664:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // InternalContextFinderTestLanguage.g:665:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // InternalContextFinderTestLanguage.g:665:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            // InternalContextFinderTestLanguage.g:666:4: lv_nested_0_0= ruleNestedTypeChild2
            {

            				newCompositeNode(grammarAccess.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_nested_0_0=ruleNestedTypeChild2();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getNestedTypeTest2Rule());
            				}
            				set(
            					current,
            					"nested",
            					lv_nested_0_0,
            					"org.eclipse.xtext.serializer.ContextFinderTestLanguage.NestedTypeChild2");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleNestedTypeTest2"


    // $ANTLR start "entryRuleNestedTypeChild1"
    // InternalContextFinderTestLanguage.g:686:1: entryRuleNestedTypeChild1 returns [EObject current=null] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final EObject entryRuleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild1 = null;


        try {
            // InternalContextFinderTestLanguage.g:686:57: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // InternalContextFinderTestLanguage.g:687:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
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
    // $ANTLR end "entryRuleNestedTypeChild1"


    // $ANTLR start "ruleNestedTypeChild1"
    // InternalContextFinderTestLanguage.g:693:1: ruleNestedTypeChild1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:699:2: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalContextFinderTestLanguage.g:700:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalContextFinderTestLanguage.g:700:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:701:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild1Access().getKw1Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:705:3: ( (lv_val_1_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:706:4: (lv_val_1_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:706:4: (lv_val_1_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:707:5: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild1Access().getValIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNestedTypeChild1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleNestedTypeChild1"


    // $ANTLR start "entryRuleNestedTypeChild2"
    // InternalContextFinderTestLanguage.g:727:1: entryRuleNestedTypeChild2 returns [EObject current=null] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final EObject entryRuleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild2 = null;


        try {
            // InternalContextFinderTestLanguage.g:727:57: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // InternalContextFinderTestLanguage.g:728:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
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
    // $ANTLR end "entryRuleNestedTypeChild2"


    // $ANTLR start "ruleNestedTypeChild2"
    // InternalContextFinderTestLanguage.g:734:1: ruleNestedTypeChild2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:740:2: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalContextFinderTestLanguage.g:741:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalContextFinderTestLanguage.g:741:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:742:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild2Access().getKw2Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:746:3: ( (lv_val_1_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:747:4: (lv_val_1_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:747:4: (lv_val_1_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:748:5: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild2Access().getValIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNestedTypeChild2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleNestedTypeChild2"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest1"
    // InternalContextFinderTestLanguage.g:768:1: entryRuleNestedTypeRecursiveTest1 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:768:65: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // InternalContextFinderTestLanguage.g:769:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest1"


    // $ANTLR start "ruleNestedTypeRecursiveTest1"
    // InternalContextFinderTestLanguage.g:775:1: ruleNestedTypeRecursiveTest1 returns [EObject current=null] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:781:2: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // InternalContextFinderTestLanguage.g:782:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // InternalContextFinderTestLanguage.g:782:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // InternalContextFinderTestLanguage.g:783:3: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // InternalContextFinderTestLanguage.g:783:3: ()
            // InternalContextFinderTestLanguage.g:784:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
            		
            // InternalContextFinderTestLanguage.g:794:3: ( () otherlv_3= '.' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalContextFinderTestLanguage.g:795:4: () otherlv_3= '.'
            	    {
            	    // InternalContextFinderTestLanguage.g:795:4: ()
            	    // InternalContextFinderTestLanguage.g:796:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest1Access().getFullStopKeyword_2_1());
            	    			

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
    // $ANTLR end "ruleNestedTypeRecursiveTest1"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest2"
    // InternalContextFinderTestLanguage.g:811:1: entryRuleNestedTypeRecursiveTest2 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:811:65: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // InternalContextFinderTestLanguage.g:812:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest2"


    // $ANTLR start "ruleNestedTypeRecursiveTest2"
    // InternalContextFinderTestLanguage.g:818:1: ruleNestedTypeRecursiveTest2 returns [EObject current=null] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:824:2: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // InternalContextFinderTestLanguage.g:825:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // InternalContextFinderTestLanguage.g:825:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // InternalContextFinderTestLanguage.g:826:3: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // InternalContextFinderTestLanguage.g:826:3: ()
            // InternalContextFinderTestLanguage.g:827:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
            		
            // InternalContextFinderTestLanguage.g:837:3: ( () otherlv_3= '.' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalContextFinderTestLanguage.g:838:4: () otherlv_3= '.'
            	    {
            	    // InternalContextFinderTestLanguage.g:838:4: ()
            	    // InternalContextFinderTestLanguage.g:839:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest2Access().getFullStopKeyword_2_1());
            	    			

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
    // $ANTLR end "ruleNestedTypeRecursiveTest2"


    // $ANTLR start "entryRuleParentRefTest1"
    // InternalContextFinderTestLanguage.g:854:1: entryRuleParentRefTest1 returns [EObject current=null] : iv_ruleParentRefTest1= ruleParentRefTest1 EOF ;
    public final EObject entryRuleParentRefTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:854:55: (iv_ruleParentRefTest1= ruleParentRefTest1 EOF )
            // InternalContextFinderTestLanguage.g:855:2: iv_ruleParentRefTest1= ruleParentRefTest1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTest1=ruleParentRefTest1();

            state._fsp--;

             current =iv_ruleParentRefTest1; 
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
    // $ANTLR end "entryRuleParentRefTest1"


    // $ANTLR start "ruleParentRefTest1"
    // InternalContextFinderTestLanguage.g:861:1: ruleParentRefTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final EObject ruleParentRefTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child1_1_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:867:2: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // InternalContextFinderTestLanguage.g:868:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // InternalContextFinderTestLanguage.g:868:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // InternalContextFinderTestLanguage.g:869:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getParentRefTest1Access().getKw1Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:873:3: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // InternalContextFinderTestLanguage.g:874:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // InternalContextFinderTestLanguage.g:874:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            // InternalContextFinderTestLanguage.g:875:5: lv_child1_1_0= ruleParentRefTestChild1
            {

            					newCompositeNode(grammarAccess.getParentRefTest1Access().getChild1ParentRefTestChild1ParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child1_1_0=ruleParentRefTestChild1();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParentRefTest1Rule());
            					}
            					set(
            						current,
            						"child1",
            						lv_child1_1_0,
            						"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTestChild1");
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
    // $ANTLR end "ruleParentRefTest1"


    // $ANTLR start "entryRuleParentRefTest2"
    // InternalContextFinderTestLanguage.g:896:1: entryRuleParentRefTest2 returns [EObject current=null] : iv_ruleParentRefTest2= ruleParentRefTest2 EOF ;
    public final EObject entryRuleParentRefTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:896:55: (iv_ruleParentRefTest2= ruleParentRefTest2 EOF )
            // InternalContextFinderTestLanguage.g:897:2: iv_ruleParentRefTest2= ruleParentRefTest2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTest2=ruleParentRefTest2();

            state._fsp--;

             current =iv_ruleParentRefTest2; 
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
    // $ANTLR end "entryRuleParentRefTest2"


    // $ANTLR start "ruleParentRefTest2"
    // InternalContextFinderTestLanguage.g:903:1: ruleParentRefTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final EObject ruleParentRefTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child2_1_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:909:2: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // InternalContextFinderTestLanguage.g:910:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // InternalContextFinderTestLanguage.g:910:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // InternalContextFinderTestLanguage.g:911:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getParentRefTest2Access().getKw2Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:915:3: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // InternalContextFinderTestLanguage.g:916:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // InternalContextFinderTestLanguage.g:916:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            // InternalContextFinderTestLanguage.g:917:5: lv_child2_1_0= ruleParentRefTestChild2
            {

            					newCompositeNode(grammarAccess.getParentRefTest2Access().getChild2ParentRefTestChild2ParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child2_1_0=ruleParentRefTestChild2();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParentRefTest2Rule());
            					}
            					set(
            						current,
            						"child2",
            						lv_child2_1_0,
            						"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTestChild2");
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
    // $ANTLR end "ruleParentRefTest2"


    // $ANTLR start "entryRuleParentRefTestChild1"
    // InternalContextFinderTestLanguage.g:938:1: entryRuleParentRefTestChild1 returns [EObject current=null] : iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF ;
    public final EObject entryRuleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild1 = null;


        try {
            // InternalContextFinderTestLanguage.g:938:60: (iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF )
            // InternalContextFinderTestLanguage.g:939:2: iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTestChild1=ruleParentRefTestChild1();

            state._fsp--;

             current =iv_ruleParentRefTestChild1; 
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
    // $ANTLR end "entryRuleParentRefTestChild1"


    // $ANTLR start "ruleParentRefTestChild1"
    // InternalContextFinderTestLanguage.g:945:1: ruleParentRefTestChild1 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final EObject ruleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:951:2: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // InternalContextFinderTestLanguage.g:952:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // InternalContextFinderTestLanguage.g:952:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // InternalContextFinderTestLanguage.g:953:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // InternalContextFinderTestLanguage.g:953:3: ()
            // InternalContextFinderTestLanguage.g:954:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParentRefTestChild1Access().getParentRefTestChildAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild1Access().getFooKeyword_1());
            		
            // InternalContextFinderTestLanguage.g:964:3: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalContextFinderTestLanguage.g:965:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // InternalContextFinderTestLanguage.g:965:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    // InternalContextFinderTestLanguage.g:966:5: lv_child_2_0= ruleParentRefTestChild1
                    {

                    					newCompositeNode(grammarAccess.getParentRefTestChild1Access().getChildParentRefTestChild1ParserRuleCall_2_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_2_0=ruleParentRefTestChild1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParentRefTestChild1Rule());
                    					}
                    					set(
                    						current,
                    						"child",
                    						lv_child_2_0,
                    						"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTestChild1");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleParentRefTestChild1"


    // $ANTLR start "entryRuleParentRefTestChild2"
    // InternalContextFinderTestLanguage.g:987:1: entryRuleParentRefTestChild2 returns [EObject current=null] : iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF ;
    public final EObject entryRuleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild2 = null;


        try {
            // InternalContextFinderTestLanguage.g:987:60: (iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF )
            // InternalContextFinderTestLanguage.g:988:2: iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTestChild2=ruleParentRefTestChild2();

            state._fsp--;

             current =iv_ruleParentRefTestChild2; 
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
    // $ANTLR end "entryRuleParentRefTestChild2"


    // $ANTLR start "ruleParentRefTestChild2"
    // InternalContextFinderTestLanguage.g:994:1: ruleParentRefTestChild2 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final EObject ruleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1000:2: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // InternalContextFinderTestLanguage.g:1001:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // InternalContextFinderTestLanguage.g:1001:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // InternalContextFinderTestLanguage.g:1002:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // InternalContextFinderTestLanguage.g:1002:3: ()
            // InternalContextFinderTestLanguage.g:1003:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParentRefTestChild2Access().getParentRefTestChildAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild2Access().getFooKeyword_1());
            		
            // InternalContextFinderTestLanguage.g:1013:3: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalContextFinderTestLanguage.g:1014:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // InternalContextFinderTestLanguage.g:1014:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    // InternalContextFinderTestLanguage.g:1015:5: lv_child_2_0= ruleParentRefTestChild2
                    {

                    					newCompositeNode(grammarAccess.getParentRefTestChild2Access().getChildParentRefTestChild2ParserRuleCall_2_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_2_0=ruleParentRefTestChild2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParentRefTestChild2Rule());
                    					}
                    					set(
                    						current,
                    						"child",
                    						lv_child_2_0,
                    						"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ParentRefTestChild2");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleParentRefTestChild2"


    // $ANTLR start "entryRuleQuantityExclusionTest1"
    // InternalContextFinderTestLanguage.g:1036:1: entryRuleQuantityExclusionTest1 returns [EObject current=null] : iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF ;
    public final EObject entryRuleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:1036:63: (iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF )
            // InternalContextFinderTestLanguage.g:1037:2: iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuantityExclusionTest1=ruleQuantityExclusionTest1();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest1; 
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
    // $ANTLR end "entryRuleQuantityExclusionTest1"


    // $ANTLR start "ruleQuantityExclusionTest1"
    // InternalContextFinderTestLanguage.g:1043:1: ruleQuantityExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) ;
    public final EObject ruleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1049:2: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) )
            // InternalContextFinderTestLanguage.g:1050:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            {
            // InternalContextFinderTestLanguage.g:1050:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            // InternalContextFinderTestLanguage.g:1051:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest1Access().getKw1Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:1055:3: ( (lv_attr1_1_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:1056:4: (lv_attr1_1_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:1056:4: (lv_attr1_1_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:1057:5: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					newLeafNode(lv_attr1_1_0, grammarAccess.getQuantityExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuantityExclusionTest1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr1",
            						lv_attr1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalContextFinderTestLanguage.g:1073:3: ( (lv_attr2_2_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalContextFinderTestLanguage.g:1074:4: (lv_attr2_2_0= RULE_ID )
                    {
                    // InternalContextFinderTestLanguage.g:1074:4: (lv_attr2_2_0= RULE_ID )
                    // InternalContextFinderTestLanguage.g:1075:5: lv_attr2_2_0= RULE_ID
                    {
                    lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_attr2_2_0, grammarAccess.getQuantityExclusionTest1Access().getAttr2IDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQuantityExclusionTest1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"attr2",
                    						lv_attr2_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

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
    // $ANTLR end "ruleQuantityExclusionTest1"


    // $ANTLR start "entryRuleQuantityExclusionTest2"
    // InternalContextFinderTestLanguage.g:1095:1: entryRuleQuantityExclusionTest2 returns [EObject current=null] : iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF ;
    public final EObject entryRuleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:1095:63: (iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF )
            // InternalContextFinderTestLanguage.g:1096:2: iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuantityExclusionTest2=ruleQuantityExclusionTest2();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest2; 
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
    // $ANTLR end "entryRuleQuantityExclusionTest2"


    // $ANTLR start "ruleQuantityExclusionTest2"
    // InternalContextFinderTestLanguage.g:1102:1: ruleQuantityExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1108:2: ( (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) )
            // InternalContextFinderTestLanguage.g:1109:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            {
            // InternalContextFinderTestLanguage.g:1109:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:1110:3: otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest2Access().getKw2Keyword_0());
            		
            // InternalContextFinderTestLanguage.g:1114:3: ( (lv_attr1_1_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_ID) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalContextFinderTestLanguage.g:1115:4: (lv_attr1_1_0= RULE_ID )
                    {
                    // InternalContextFinderTestLanguage.g:1115:4: (lv_attr1_1_0= RULE_ID )
                    // InternalContextFinderTestLanguage.g:1116:5: lv_attr1_1_0= RULE_ID
                    {
                    lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    					newLeafNode(lv_attr1_1_0, grammarAccess.getQuantityExclusionTest2Access().getAttr1IDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQuantityExclusionTest2Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"attr1",
                    						lv_attr1_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalContextFinderTestLanguage.g:1132:3: ( (lv_attr2_2_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:1133:4: (lv_attr2_2_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:1133:4: (lv_attr2_2_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:1134:5: lv_attr2_2_0= RULE_ID
            {
            lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_attr2_2_0, grammarAccess.getQuantityExclusionTest2Access().getAttr2IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuantityExclusionTest2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr2",
            						lv_attr2_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleQuantityExclusionTest2"


    // $ANTLR start "entryRuleValueExclusionTest1"
    // InternalContextFinderTestLanguage.g:1154:1: entryRuleValueExclusionTest1 returns [EObject current=null] : iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF ;
    public final EObject entryRuleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest1 = null;


        try {
            // InternalContextFinderTestLanguage.g:1154:60: (iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF )
            // InternalContextFinderTestLanguage.g:1155:2: iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueExclusionTest1=ruleValueExclusionTest1();

            state._fsp--;

             current =iv_ruleValueExclusionTest1; 
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
    // $ANTLR end "entryRuleValueExclusionTest1"


    // $ANTLR start "ruleValueExclusionTest1"
    // InternalContextFinderTestLanguage.g:1161:1: ruleValueExclusionTest1 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) ;
    public final EObject ruleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1167:2: ( ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) )
            // InternalContextFinderTestLanguage.g:1168:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            {
            // InternalContextFinderTestLanguage.g:1168:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            // InternalContextFinderTestLanguage.g:1169:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            {
            // InternalContextFinderTestLanguage.g:1169:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            // InternalContextFinderTestLanguage.g:1170:4: lv_val_0_0= ruleValueExclusionTestEn1
            {

            				newCompositeNode(grammarAccess.getValueExclusionTest1Access().getValValueExclusionTestEn1EnumRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_0_0=ruleValueExclusionTestEn1();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getValueExclusionTest1Rule());
            				}
            				set(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ValueExclusionTestEn1");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleValueExclusionTest1"


    // $ANTLR start "entryRuleValueExclusionTest2"
    // InternalContextFinderTestLanguage.g:1190:1: entryRuleValueExclusionTest2 returns [EObject current=null] : iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF ;
    public final EObject entryRuleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest2 = null;


        try {
            // InternalContextFinderTestLanguage.g:1190:60: (iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF )
            // InternalContextFinderTestLanguage.g:1191:2: iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueExclusionTest2=ruleValueExclusionTest2();

            state._fsp--;

             current =iv_ruleValueExclusionTest2; 
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
    // $ANTLR end "entryRuleValueExclusionTest2"


    // $ANTLR start "ruleValueExclusionTest2"
    // InternalContextFinderTestLanguage.g:1197:1: ruleValueExclusionTest2 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) ;
    public final EObject ruleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1203:2: ( ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) )
            // InternalContextFinderTestLanguage.g:1204:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            {
            // InternalContextFinderTestLanguage.g:1204:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            // InternalContextFinderTestLanguage.g:1205:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            {
            // InternalContextFinderTestLanguage.g:1205:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            // InternalContextFinderTestLanguage.g:1206:4: lv_val_0_0= ruleValueExclusionTestEn2
            {

            				newCompositeNode(grammarAccess.getValueExclusionTest2Access().getValValueExclusionTestEn2EnumRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_0_0=ruleValueExclusionTestEn2();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getValueExclusionTest2Rule());
            				}
            				set(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.eclipse.xtext.serializer.ContextFinderTestLanguage.ValueExclusionTestEn2");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleValueExclusionTest2"


    // $ANTLR start "entryRuleNodeExclusion1"
    // InternalContextFinderTestLanguage.g:1226:1: entryRuleNodeExclusion1 returns [EObject current=null] : iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF ;
    public final EObject entryRuleNodeExclusion1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion1 = null;


        try {
            // InternalContextFinderTestLanguage.g:1226:55: (iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF )
            // InternalContextFinderTestLanguage.g:1227:2: iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion1=ruleNodeExclusion1();

            state._fsp--;

             current =iv_ruleNodeExclusion1; 
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
    // $ANTLR end "entryRuleNodeExclusion1"


    // $ANTLR start "ruleNodeExclusion1"
    // InternalContextFinderTestLanguage.g:1233:1: ruleNodeExclusion1 returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleNodeExclusion1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1239:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalContextFinderTestLanguage.g:1240:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalContextFinderTestLanguage.g:1240:2: ( (otherlv_0= RULE_ID ) )
            // InternalContextFinderTestLanguage.g:1241:3: (otherlv_0= RULE_ID )
            {
            // InternalContextFinderTestLanguage.g:1241:3: (otherlv_0= RULE_ID )
            // InternalContextFinderTestLanguage.g:1242:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNodeExclusion1Rule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getNodeExclusion1Access().getRefModelCrossReference_0());
            			

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
    // $ANTLR end "ruleNodeExclusion1"


    // $ANTLR start "entryRuleNodeExclusion2"
    // InternalContextFinderTestLanguage.g:1256:1: entryRuleNodeExclusion2 returns [EObject current=null] : iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF ;
    public final EObject entryRuleNodeExclusion2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion2 = null;


        try {
            // InternalContextFinderTestLanguage.g:1256:55: (iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF )
            // InternalContextFinderTestLanguage.g:1257:2: iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion2=ruleNodeExclusion2();

            state._fsp--;

             current =iv_ruleNodeExclusion2; 
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
    // $ANTLR end "entryRuleNodeExclusion2"


    // $ANTLR start "ruleNodeExclusion2"
    // InternalContextFinderTestLanguage.g:1263:1: ruleNodeExclusion2 returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) ) ;
    public final EObject ruleNodeExclusion2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1269:2: ( ( (otherlv_0= RULE_STRING ) ) )
            // InternalContextFinderTestLanguage.g:1270:2: ( (otherlv_0= RULE_STRING ) )
            {
            // InternalContextFinderTestLanguage.g:1270:2: ( (otherlv_0= RULE_STRING ) )
            // InternalContextFinderTestLanguage.g:1271:3: (otherlv_0= RULE_STRING )
            {
            // InternalContextFinderTestLanguage.g:1271:3: (otherlv_0= RULE_STRING )
            // InternalContextFinderTestLanguage.g:1272:4: otherlv_0= RULE_STRING
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNodeExclusion2Rule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getNodeExclusion2Access().getRefModelCrossReference_0());
            			

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
    // $ANTLR end "ruleNodeExclusion2"


    // $ANTLR start "entryRuleNodeExclusion1List"
    // InternalContextFinderTestLanguage.g:1286:1: entryRuleNodeExclusion1List returns [EObject current=null] : iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF ;
    public final EObject entryRuleNodeExclusion1List() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion1List = null;


        try {
            // InternalContextFinderTestLanguage.g:1286:59: (iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF )
            // InternalContextFinderTestLanguage.g:1287:2: iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion1ListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion1List=ruleNodeExclusion1List();

            state._fsp--;

             current =iv_ruleNodeExclusion1List; 
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
    // $ANTLR end "entryRuleNodeExclusion1List"


    // $ANTLR start "ruleNodeExclusion1List"
    // InternalContextFinderTestLanguage.g:1293:1: ruleNodeExclusion1List returns [EObject current=null] : ( (otherlv_0= RULE_ID ) )+ ;
    public final EObject ruleNodeExclusion1List() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1299:2: ( ( (otherlv_0= RULE_ID ) )+ )
            // InternalContextFinderTestLanguage.g:1300:2: ( (otherlv_0= RULE_ID ) )+
            {
            // InternalContextFinderTestLanguage.g:1300:2: ( (otherlv_0= RULE_ID ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalContextFinderTestLanguage.g:1301:3: (otherlv_0= RULE_ID )
            	    {
            	    // InternalContextFinderTestLanguage.g:1301:3: (otherlv_0= RULE_ID )
            	    // InternalContextFinderTestLanguage.g:1302:4: otherlv_0= RULE_ID
            	    {

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getNodeExclusion1ListRule());
            	    				}
            	    			
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    				newLeafNode(otherlv_0, grammarAccess.getNodeExclusion1ListAccess().getRefModelCrossReference_0());
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


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
    // $ANTLR end "ruleNodeExclusion1List"


    // $ANTLR start "entryRuleNodeExclusion2List"
    // InternalContextFinderTestLanguage.g:1316:1: entryRuleNodeExclusion2List returns [EObject current=null] : iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF ;
    public final EObject entryRuleNodeExclusion2List() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion2List = null;


        try {
            // InternalContextFinderTestLanguage.g:1316:59: (iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF )
            // InternalContextFinderTestLanguage.g:1317:2: iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion2ListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion2List=ruleNodeExclusion2List();

            state._fsp--;

             current =iv_ruleNodeExclusion2List; 
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
    // $ANTLR end "entryRuleNodeExclusion2List"


    // $ANTLR start "ruleNodeExclusion2List"
    // InternalContextFinderTestLanguage.g:1323:1: ruleNodeExclusion2List returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) )+ ;
    public final EObject ruleNodeExclusion2List() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1329:2: ( ( (otherlv_0= RULE_STRING ) )+ )
            // InternalContextFinderTestLanguage.g:1330:2: ( (otherlv_0= RULE_STRING ) )+
            {
            // InternalContextFinderTestLanguage.g:1330:2: ( (otherlv_0= RULE_STRING ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContextFinderTestLanguage.g:1331:3: (otherlv_0= RULE_STRING )
            	    {
            	    // InternalContextFinderTestLanguage.g:1331:3: (otherlv_0= RULE_STRING )
            	    // InternalContextFinderTestLanguage.g:1332:4: otherlv_0= RULE_STRING
            	    {

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getNodeExclusion2ListRule());
            	    				}
            	    			
            	    otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_14); 

            	    				newLeafNode(otherlv_0, grammarAccess.getNodeExclusion2ListAccess().getRefModelCrossReference_0());
            	    			

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
    // $ANTLR end "ruleNodeExclusion2List"


    // $ANTLR start "ruleValueExclusionTestEn1"
    // InternalContextFinderTestLanguage.g:1346:1: ruleValueExclusionTestEn1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleValueExclusionTestEn1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1352:2: ( (enumLiteral_0= 'lit1' ) )
            // InternalContextFinderTestLanguage.g:1353:2: (enumLiteral_0= 'lit1' )
            {
            // InternalContextFinderTestLanguage.g:1353:2: (enumLiteral_0= 'lit1' )
            // InternalContextFinderTestLanguage.g:1354:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

            			current = grammarAccess.getValueExclusionTestEn1Access().getLit1EnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getValueExclusionTestEn1Access().getLit1EnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleValueExclusionTestEn1"


    // $ANTLR start "ruleValueExclusionTestEn2"
    // InternalContextFinderTestLanguage.g:1363:1: ruleValueExclusionTestEn2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleValueExclusionTestEn2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalContextFinderTestLanguage.g:1369:2: ( (enumLiteral_0= 'lit2' ) )
            // InternalContextFinderTestLanguage.g:1370:2: (enumLiteral_0= 'lit2' )
            {
            // InternalContextFinderTestLanguage.g:1370:2: (enumLiteral_0= 'lit2' )
            // InternalContextFinderTestLanguage.g:1371:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			current = grammarAccess.getValueExclusionTestEn2Access().getLit2EnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getValueExclusionTestEn2Access().getLit2EnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleValueExclusionTestEn2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000012L});
    }


}