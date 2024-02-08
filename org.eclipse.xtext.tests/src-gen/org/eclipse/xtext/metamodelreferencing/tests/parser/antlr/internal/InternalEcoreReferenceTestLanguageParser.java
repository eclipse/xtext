package org.eclipse.xtext.metamodelreferencing.tests.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;



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
public class InternalEcoreReferenceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ExtendsNsURIEObject'", "'EObject'", "'ExtendsPluginEObject'", "'ExtendsResourceEObject'", "'MyEAttribute'", "'EAttribute'", "'object'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEcoreReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcoreReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcoreReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEcoreReferenceTestLanguage.g"; }



     	private EcoreReferenceTestLanguageGrammarAccess grammarAccess;

        public InternalEcoreReferenceTestLanguageParser(TokenStream input, EcoreReferenceTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected EcoreReferenceTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalEcoreReferenceTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalEcoreReferenceTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalEcoreReferenceTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_0_0 = null;

        EObject lv_extends_1_0 = null;

        EObject lv_extends_2_0 = null;



        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:82:2: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // InternalEcoreReferenceTestLanguage.g:83:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // InternalEcoreReferenceTestLanguage.g:83:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // InternalEcoreReferenceTestLanguage.g:84:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // InternalEcoreReferenceTestLanguage.g:84:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // InternalEcoreReferenceTestLanguage.g:85:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:85:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // InternalEcoreReferenceTestLanguage.g:86:5: lv_extends_0_0= ruleExtendsNsURIEObject
            {

            					newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsNsURIEObjectParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_extends_0_0=ruleExtendsNsURIEObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"extends",
            						lv_extends_0_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsNsURIEObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEcoreReferenceTestLanguage.g:103:3: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // InternalEcoreReferenceTestLanguage.g:104:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:104:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            // InternalEcoreReferenceTestLanguage.g:105:5: lv_extends_1_0= ruleExtendsPluginEObject
            {

            					newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsPluginEObjectParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_extends_1_0=ruleExtendsPluginEObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"extends",
            						lv_extends_1_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsPluginEObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEcoreReferenceTestLanguage.g:122:3: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // InternalEcoreReferenceTestLanguage.g:123:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:123:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            // InternalEcoreReferenceTestLanguage.g:124:5: lv_extends_2_0= ruleExtendsResourceEObject
            {

            					newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsResourceEObjectParserRuleCall_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_extends_2_0=ruleExtendsResourceEObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"extends",
            						lv_extends_2_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsResourceEObject");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExtendsNsURIEObject"
    // InternalEcoreReferenceTestLanguage.g:145:1: entryRuleExtendsNsURIEObject returns [EObject current=null] : iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF ;
    public final EObject entryRuleExtendsNsURIEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsNsURIEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:145:60: (iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:146:2: iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsNsURIEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsNsURIEObject=ruleExtendsNsURIEObject();

            state._fsp--;

             current =iv_ruleExtendsNsURIEObject; 
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
    // $ANTLR end "entryRuleExtendsNsURIEObject"


    // $ANTLR start "ruleExtendsNsURIEObject"
    // InternalEcoreReferenceTestLanguage.g:152:1: ruleExtendsNsURIEObject returns [EObject current=null] : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsNsURIEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;

        EObject lv_eObjectContainment_20_0 = null;



        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:158:2: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:159:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:159:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:160:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:164:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:165:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:165:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:166:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEcoreReferenceTestLanguage.g:183:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 11:
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:184:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:184:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:185:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:189:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:190:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:190:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:191:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_3, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEcoreReferenceTestLanguage.g:204:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:204:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:205:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:209:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:210:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:210:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:211:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_5, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalEcoreReferenceTestLanguage.g:224:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:224:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:225:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:229:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:230:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:230:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:231:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_7, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalEcoreReferenceTestLanguage.g:244:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:244:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:245:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:249:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:250:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:250:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:251:7: otherlv_9= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    							}
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_9, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalEcoreReferenceTestLanguage.g:264:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_ID) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:265:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:269:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:270:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:270:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:271:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsNsURIEObjectAccess().getEAttributeReferenceMyEAttributeCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:282:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:283:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:283:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:284:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:295:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:296:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:296:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:297:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:308:4: ( (otherlv_14= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:309:5: (otherlv_14= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:309:5: (otherlv_14= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:310:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(otherlv_14, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_4_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:321:4: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:322:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:322:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // InternalEcoreReferenceTestLanguage.g:323:6: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_15_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_15_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsNsURIEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:340:4: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:341:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:341:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // InternalEcoreReferenceTestLanguage.g:342:6: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_16_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_16_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsPluginEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:359:4: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:360:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:360:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // InternalEcoreReferenceTestLanguage.g:361:6: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_17_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_17_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsResourceEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:378:4: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:379:5: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:379:5: (lv_eObjectContainment_18_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:380:6: lv_eObjectContainment_18_0= ruleEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_8_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_18_0=ruleEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_18_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:397:4: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:398:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:398:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:399:6: lv_eObjectContainment_19_0= ruleEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_9_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_19_0=ruleEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_19_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:416:4: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:417:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:417:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:418:6: lv_eObjectContainment_20_0= ruleMyEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_10_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_20_0=ruleMyEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_20_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.MyEAttribute");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleExtendsNsURIEObject"


    // $ANTLR start "entryRuleMyEAttribute"
    // InternalEcoreReferenceTestLanguage.g:440:1: entryRuleMyEAttribute returns [EObject current=null] : iv_ruleMyEAttribute= ruleMyEAttribute EOF ;
    public final EObject entryRuleMyEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyEAttribute = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:440:53: (iv_ruleMyEAttribute= ruleMyEAttribute EOF )
            // InternalEcoreReferenceTestLanguage.g:441:2: iv_ruleMyEAttribute= ruleMyEAttribute EOF
            {
             newCompositeNode(grammarAccess.getMyEAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMyEAttribute=ruleMyEAttribute();

            state._fsp--;

             current =iv_ruleMyEAttribute; 
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
    // $ANTLR end "entryRuleMyEAttribute"


    // $ANTLR start "ruleMyEAttribute"
    // InternalEcoreReferenceTestLanguage.g:447:1: ruleMyEAttribute returns [EObject current=null] : ( () otherlv_1= 'MyEAttribute' ) ;
    public final EObject ruleMyEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:453:2: ( ( () otherlv_1= 'MyEAttribute' ) )
            // InternalEcoreReferenceTestLanguage.g:454:2: ( () otherlv_1= 'MyEAttribute' )
            {
            // InternalEcoreReferenceTestLanguage.g:454:2: ( () otherlv_1= 'MyEAttribute' )
            // InternalEcoreReferenceTestLanguage.g:455:3: () otherlv_1= 'MyEAttribute'
            {
            // InternalEcoreReferenceTestLanguage.g:455:3: ()
            // InternalEcoreReferenceTestLanguage.g:456:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMyEAttributeAccess().getMyEAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getMyEAttributeAccess().getMyEAttributeKeyword_1());
            		

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
    // $ANTLR end "ruleMyEAttribute"


    // $ANTLR start "entryRuleEAttribute"
    // InternalEcoreReferenceTestLanguage.g:470:1: entryRuleEAttribute returns [EObject current=null] : iv_ruleEAttribute= ruleEAttribute EOF ;
    public final EObject entryRuleEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttribute = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:470:51: (iv_ruleEAttribute= ruleEAttribute EOF )
            // InternalEcoreReferenceTestLanguage.g:471:2: iv_ruleEAttribute= ruleEAttribute EOF
            {
             newCompositeNode(grammarAccess.getEAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEAttribute=ruleEAttribute();

            state._fsp--;

             current =iv_ruleEAttribute; 
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
    // $ANTLR end "entryRuleEAttribute"


    // $ANTLR start "ruleEAttribute"
    // InternalEcoreReferenceTestLanguage.g:477:1: ruleEAttribute returns [EObject current=null] : ( () otherlv_1= 'EAttribute' ) ;
    public final EObject ruleEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:483:2: ( ( () otherlv_1= 'EAttribute' ) )
            // InternalEcoreReferenceTestLanguage.g:484:2: ( () otherlv_1= 'EAttribute' )
            {
            // InternalEcoreReferenceTestLanguage.g:484:2: ( () otherlv_1= 'EAttribute' )
            // InternalEcoreReferenceTestLanguage.g:485:3: () otherlv_1= 'EAttribute'
            {
            // InternalEcoreReferenceTestLanguage.g:485:3: ()
            // InternalEcoreReferenceTestLanguage.g:486:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEAttributeAccess().getEAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEAttributeAccess().getEAttributeKeyword_1());
            		

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
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleExtendsPluginEObject"
    // InternalEcoreReferenceTestLanguage.g:500:1: entryRuleExtendsPluginEObject returns [EObject current=null] : iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF ;
    public final EObject entryRuleExtendsPluginEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsPluginEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:500:61: (iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:501:2: iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsPluginEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsPluginEObject=ruleExtendsPluginEObject();

            state._fsp--;

             current =iv_ruleExtendsPluginEObject; 
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
    // $ANTLR end "entryRuleExtendsPluginEObject"


    // $ANTLR start "ruleExtendsPluginEObject"
    // InternalEcoreReferenceTestLanguage.g:507:1: ruleExtendsPluginEObject returns [EObject current=null] : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsPluginEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_14_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;



        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:513:2: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:514:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:514:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:515:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:519:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:520:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:520:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:521:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEcoreReferenceTestLanguage.g:538:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 11:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:539:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:539:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:540:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsPluginEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:544:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:545:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:545:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:546:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_3, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEcoreReferenceTestLanguage.g:559:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:559:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:560:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsPluginEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:564:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:565:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:565:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:566:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_5, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalEcoreReferenceTestLanguage.g:579:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:579:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:580:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:584:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:585:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:585:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:586:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_7, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalEcoreReferenceTestLanguage.g:599:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:599:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:600:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsPluginEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:604:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:605:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:605:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:606:7: otherlv_9= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    							}
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							newLeafNode(otherlv_9, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalEcoreReferenceTestLanguage.g:619:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:620:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:624:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:625:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:625:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:626:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:637:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:638:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:638:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:639:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:650:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:651:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:651:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:652:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:663:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:664:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:664:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // InternalEcoreReferenceTestLanguage.g:665:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_14_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsNsURIEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:682:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:683:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:683:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // InternalEcoreReferenceTestLanguage.g:684:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_15_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsPluginEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:701:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:702:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:702:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // InternalEcoreReferenceTestLanguage.g:703:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                            {

                            						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            						}
                            						add(
                            							current,
                            							"eObjectContainment",
                            							lv_eObjectContainment_16_0,
                            							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsResourceEObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalEcoreReferenceTestLanguage.g:720:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:721:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:721:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:722:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_7_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_17_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:739:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:740:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:740:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:741:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_8_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_18_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:758:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:759:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:759:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:760:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_9_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_19_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.MyEAttribute");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleExtendsPluginEObject"


    // $ANTLR start "entryRuleExtendsResourceEObject"
    // InternalEcoreReferenceTestLanguage.g:782:1: entryRuleExtendsResourceEObject returns [EObject current=null] : iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF ;
    public final EObject entryRuleExtendsResourceEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsResourceEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:782:63: (iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:783:2: iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsResourceEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsResourceEObject=ruleExtendsResourceEObject();

            state._fsp--;

             current =iv_ruleExtendsResourceEObject; 
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
    // $ANTLR end "entryRuleExtendsResourceEObject"


    // $ANTLR start "ruleExtendsResourceEObject"
    // InternalEcoreReferenceTestLanguage.g:789:1: ruleExtendsResourceEObject returns [EObject current=null] : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsResourceEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_14_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;



        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:795:2: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:796:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:796:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:797:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:801:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:802:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:802:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:803:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEcoreReferenceTestLanguage.g:820:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt11=1;
                }
                break;
            case 11:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            case 14:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:821:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:821:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:822:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsResourceEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:826:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:827:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:827:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:828:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							newLeafNode(otherlv_3, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEcoreReferenceTestLanguage.g:841:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:841:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:842:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsResourceEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:846:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:847:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:847:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:848:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							newLeafNode(otherlv_5, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalEcoreReferenceTestLanguage.g:861:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:861:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:862:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsResourceEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:866:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:867:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:867:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:868:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							newLeafNode(otherlv_7, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalEcoreReferenceTestLanguage.g:881:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:881:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:882:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:886:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:887:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:887:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:888:7: otherlv_9= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    							}
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							newLeafNode(otherlv_9, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalEcoreReferenceTestLanguage.g:901:3: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:902:4: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:906:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:907:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:907:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:908:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:919:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:920:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:920:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:921:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:932:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:933:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:933:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:934:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:945:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:946:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:946:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // InternalEcoreReferenceTestLanguage.g:947:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_14_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsNsURIEObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:964:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:965:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:965:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // InternalEcoreReferenceTestLanguage.g:966:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_15_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsPluginEObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:983:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:984:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:984:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // InternalEcoreReferenceTestLanguage.g:985:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_16_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.ExtendsResourceEObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:1002:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:1003:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:1003:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:1004:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_7_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_17_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:1021:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:1022:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:1022:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:1023:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_8_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_18_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.EAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:1040:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:1041:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:1041:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:1042:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_9_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    						add(
                    							current,
                    							"eObjectContainment",
                    							lv_eObjectContainment_19_0,
                    							"org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage.MyEAttribute");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleExtendsResourceEObject"


    // $ANTLR start "entryRuleEObject"
    // InternalEcoreReferenceTestLanguage.g:1064:1: entryRuleEObject returns [EObject current=null] : iv_ruleEObject= ruleEObject EOF ;
    public final EObject entryRuleEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:1064:48: (iv_ruleEObject= ruleEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:1065:2: iv_ruleEObject= ruleEObject EOF
            {
             newCompositeNode(grammarAccess.getEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObject=ruleEObject();

            state._fsp--;

             current =iv_ruleEObject; 
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
    // $ANTLR end "entryRuleEObject"


    // $ANTLR start "ruleEObject"
    // InternalEcoreReferenceTestLanguage.g:1071:1: ruleEObject returns [EObject current=null] : ( () otherlv_1= 'object' ) ;
    public final EObject ruleEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:1077:2: ( ( () otherlv_1= 'object' ) )
            // InternalEcoreReferenceTestLanguage.g:1078:2: ( () otherlv_1= 'object' )
            {
            // InternalEcoreReferenceTestLanguage.g:1078:2: ( () otherlv_1= 'object' )
            // InternalEcoreReferenceTestLanguage.g:1079:3: () otherlv_1= 'object'
            {
            // InternalEcoreReferenceTestLanguage.g:1079:3: ()
            // InternalEcoreReferenceTestLanguage.g:1080:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEObjectAccess().getEObjectAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEObjectAccess().getObjectKeyword_1());
            		

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
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleValidID"
    // InternalEcoreReferenceTestLanguage.g:1094:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:1094:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalEcoreReferenceTestLanguage.g:1095:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalEcoreReferenceTestLanguage.g:1101:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:1107:2: (this_ID_0= RULE_ID )
            // InternalEcoreReferenceTestLanguage.g:1108:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
            	

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
    // $ANTLR end "ruleValidID"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000800L});
    }


}