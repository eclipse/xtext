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
    // InternalEcoreReferenceTestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalEcoreReferenceTestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalEcoreReferenceTestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_0_0 = null;

        EObject lv_extends_1_0 = null;

        EObject lv_extends_2_0 = null;



        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:77:2: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // InternalEcoreReferenceTestLanguage.g:78:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // InternalEcoreReferenceTestLanguage.g:78:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // InternalEcoreReferenceTestLanguage.g:79:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // InternalEcoreReferenceTestLanguage.g:79:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // InternalEcoreReferenceTestLanguage.g:80:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:80:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // InternalEcoreReferenceTestLanguage.g:81:5: lv_extends_0_0= ruleExtendsNsURIEObject
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

            // InternalEcoreReferenceTestLanguage.g:98:3: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // InternalEcoreReferenceTestLanguage.g:99:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:99:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            // InternalEcoreReferenceTestLanguage.g:100:5: lv_extends_1_0= ruleExtendsPluginEObject
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

            // InternalEcoreReferenceTestLanguage.g:117:3: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // InternalEcoreReferenceTestLanguage.g:118:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // InternalEcoreReferenceTestLanguage.g:118:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            // InternalEcoreReferenceTestLanguage.g:119:5: lv_extends_2_0= ruleExtendsResourceEObject
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
    // InternalEcoreReferenceTestLanguage.g:140:1: entryRuleExtendsNsURIEObject returns [EObject current=null] : iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF ;
    public final EObject entryRuleExtendsNsURIEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsNsURIEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:140:60: (iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:141:2: iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF
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
    // InternalEcoreReferenceTestLanguage.g:147:1: ruleExtendsNsURIEObject returns [EObject current=null] : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
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
            // InternalEcoreReferenceTestLanguage.g:153:2: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:154:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:154:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:155:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:159:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:160:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:160:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:161:5: lv_name_1_0= ruleValidID
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

            // InternalEcoreReferenceTestLanguage.g:178:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // InternalEcoreReferenceTestLanguage.g:179:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:179:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:180:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:184:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:185:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:185:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:186:7: otherlv_3= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:199:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:199:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:200:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:204:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:205:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:205:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:206:7: otherlv_5= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:219:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:219:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:220:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:224:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:225:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:225:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:226:7: otherlv_7= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:239:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:239:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:240:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:244:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:245:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:245:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:246:7: otherlv_9= RULE_ID
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

            // InternalEcoreReferenceTestLanguage.g:259:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
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
                    // InternalEcoreReferenceTestLanguage.g:260:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:264:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:265:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:265:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:266:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsNsURIEObjectAccess().getEAttributeReferenceMyEAttributeCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:277:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:278:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:278:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:279:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:290:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:291:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:291:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:292:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:303:4: ( (otherlv_14= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:304:5: (otherlv_14= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:304:5: (otherlv_14= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:305:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(otherlv_14, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_4_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:316:4: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:317:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:317:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // InternalEcoreReferenceTestLanguage.g:318:6: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
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

                    // InternalEcoreReferenceTestLanguage.g:335:4: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:336:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:336:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // InternalEcoreReferenceTestLanguage.g:337:6: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
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

                    // InternalEcoreReferenceTestLanguage.g:354:4: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:355:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:355:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // InternalEcoreReferenceTestLanguage.g:356:6: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
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

                    // InternalEcoreReferenceTestLanguage.g:373:4: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:374:5: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:374:5: (lv_eObjectContainment_18_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:375:6: lv_eObjectContainment_18_0= ruleEObject
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

                    // InternalEcoreReferenceTestLanguage.g:392:4: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:393:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:393:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:394:6: lv_eObjectContainment_19_0= ruleEAttribute
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

                    // InternalEcoreReferenceTestLanguage.g:411:4: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:412:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:412:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:413:6: lv_eObjectContainment_20_0= ruleMyEAttribute
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
    // InternalEcoreReferenceTestLanguage.g:435:1: entryRuleMyEAttribute returns [EObject current=null] : iv_ruleMyEAttribute= ruleMyEAttribute EOF ;
    public final EObject entryRuleMyEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyEAttribute = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:435:53: (iv_ruleMyEAttribute= ruleMyEAttribute EOF )
            // InternalEcoreReferenceTestLanguage.g:436:2: iv_ruleMyEAttribute= ruleMyEAttribute EOF
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
    // InternalEcoreReferenceTestLanguage.g:442:1: ruleMyEAttribute returns [EObject current=null] : ( () otherlv_1= 'MyEAttribute' ) ;
    public final EObject ruleMyEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:448:2: ( ( () otherlv_1= 'MyEAttribute' ) )
            // InternalEcoreReferenceTestLanguage.g:449:2: ( () otherlv_1= 'MyEAttribute' )
            {
            // InternalEcoreReferenceTestLanguage.g:449:2: ( () otherlv_1= 'MyEAttribute' )
            // InternalEcoreReferenceTestLanguage.g:450:3: () otherlv_1= 'MyEAttribute'
            {
            // InternalEcoreReferenceTestLanguage.g:450:3: ()
            // InternalEcoreReferenceTestLanguage.g:451:4: 
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
    // InternalEcoreReferenceTestLanguage.g:465:1: entryRuleEAttribute returns [EObject current=null] : iv_ruleEAttribute= ruleEAttribute EOF ;
    public final EObject entryRuleEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttribute = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:465:51: (iv_ruleEAttribute= ruleEAttribute EOF )
            // InternalEcoreReferenceTestLanguage.g:466:2: iv_ruleEAttribute= ruleEAttribute EOF
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
    // InternalEcoreReferenceTestLanguage.g:472:1: ruleEAttribute returns [EObject current=null] : ( () otherlv_1= 'EAttribute' ) ;
    public final EObject ruleEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:478:2: ( ( () otherlv_1= 'EAttribute' ) )
            // InternalEcoreReferenceTestLanguage.g:479:2: ( () otherlv_1= 'EAttribute' )
            {
            // InternalEcoreReferenceTestLanguage.g:479:2: ( () otherlv_1= 'EAttribute' )
            // InternalEcoreReferenceTestLanguage.g:480:3: () otherlv_1= 'EAttribute'
            {
            // InternalEcoreReferenceTestLanguage.g:480:3: ()
            // InternalEcoreReferenceTestLanguage.g:481:4: 
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
    // InternalEcoreReferenceTestLanguage.g:495:1: entryRuleExtendsPluginEObject returns [EObject current=null] : iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF ;
    public final EObject entryRuleExtendsPluginEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsPluginEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:495:61: (iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:496:2: iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF
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
    // InternalEcoreReferenceTestLanguage.g:502:1: ruleExtendsPluginEObject returns [EObject current=null] : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
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
            // InternalEcoreReferenceTestLanguage.g:508:2: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:509:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:509:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:510:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:514:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:515:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:515:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:516:5: lv_name_1_0= ruleValidID
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

            // InternalEcoreReferenceTestLanguage.g:533:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // InternalEcoreReferenceTestLanguage.g:534:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:534:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:535:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsPluginEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:539:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:540:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:540:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:541:7: otherlv_3= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:554:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:554:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:555:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsPluginEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:559:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:560:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:560:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:561:7: otherlv_5= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:574:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:574:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:575:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:579:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:580:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:580:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:581:7: otherlv_7= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:594:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:594:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:595:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsPluginEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:599:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:600:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:600:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:601:7: otherlv_9= RULE_ID
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

            // InternalEcoreReferenceTestLanguage.g:614:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:615:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:619:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:620:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:620:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:621:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:632:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:633:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:633:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:634:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:645:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:646:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:646:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:647:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:658:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:659:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:659:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // InternalEcoreReferenceTestLanguage.g:660:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
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

                    // InternalEcoreReferenceTestLanguage.g:677:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:678:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:678:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // InternalEcoreReferenceTestLanguage.g:679:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
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

                    // InternalEcoreReferenceTestLanguage.g:696:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalEcoreReferenceTestLanguage.g:697:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // InternalEcoreReferenceTestLanguage.g:697:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // InternalEcoreReferenceTestLanguage.g:698:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
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

                    // InternalEcoreReferenceTestLanguage.g:715:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:716:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:716:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:717:6: lv_eObjectContainment_17_0= ruleEObject
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

                    // InternalEcoreReferenceTestLanguage.g:734:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:735:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:735:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:736:6: lv_eObjectContainment_18_0= ruleEAttribute
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

                    // InternalEcoreReferenceTestLanguage.g:753:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:754:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:754:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:755:6: lv_eObjectContainment_19_0= ruleMyEAttribute
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
    // InternalEcoreReferenceTestLanguage.g:777:1: entryRuleExtendsResourceEObject returns [EObject current=null] : iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF ;
    public final EObject entryRuleExtendsResourceEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsResourceEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:777:63: (iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:778:2: iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF
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
    // InternalEcoreReferenceTestLanguage.g:784:1: ruleExtendsResourceEObject returns [EObject current=null] : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
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
            // InternalEcoreReferenceTestLanguage.g:790:2: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // InternalEcoreReferenceTestLanguage.g:791:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // InternalEcoreReferenceTestLanguage.g:791:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // InternalEcoreReferenceTestLanguage.g:792:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_0());
            		
            // InternalEcoreReferenceTestLanguage.g:796:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalEcoreReferenceTestLanguage.g:797:4: (lv_name_1_0= ruleValidID )
            {
            // InternalEcoreReferenceTestLanguage.g:797:4: (lv_name_1_0= ruleValidID )
            // InternalEcoreReferenceTestLanguage.g:798:5: lv_name_1_0= ruleValidID
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

            // InternalEcoreReferenceTestLanguage.g:815:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // InternalEcoreReferenceTestLanguage.g:816:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:816:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:817:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtendsResourceEObjectAccess().getEObjectKeyword_2_0_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:821:5: ( (otherlv_3= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:822:6: (otherlv_3= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:822:6: (otherlv_3= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:823:7: otherlv_3= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:836:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:836:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:837:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_4, grammarAccess.getExtendsResourceEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:841:5: ( (otherlv_5= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:842:6: (otherlv_5= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:842:6: (otherlv_5= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:843:7: otherlv_5= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:856:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:856:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:857:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtendsResourceEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:861:5: ( (otherlv_7= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:862:6: (otherlv_7= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:862:6: (otherlv_7= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:863:7: otherlv_7= RULE_ID
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
                    // InternalEcoreReferenceTestLanguage.g:876:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalEcoreReferenceTestLanguage.g:876:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // InternalEcoreReferenceTestLanguage.g:877:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_8, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                    				
                    // InternalEcoreReferenceTestLanguage.g:881:5: ( (otherlv_9= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:882:6: (otherlv_9= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:882:6: (otherlv_9= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:883:7: otherlv_9= RULE_ID
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

            // InternalEcoreReferenceTestLanguage.g:896:3: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalEcoreReferenceTestLanguage.g:897:4: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_3_0());
                    			
                    // InternalEcoreReferenceTestLanguage.g:901:4: ( (otherlv_11= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:902:5: (otherlv_11= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:902:5: (otherlv_11= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:903:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_11, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:914:4: ( (otherlv_12= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:915:5: (otherlv_12= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:915:5: (otherlv_12= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:916:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						newLeafNode(otherlv_12, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:927:4: ( (otherlv_13= RULE_ID ) )
                    // InternalEcoreReferenceTestLanguage.g:928:5: (otherlv_13= RULE_ID )
                    {
                    // InternalEcoreReferenceTestLanguage.g:928:5: (otherlv_13= RULE_ID )
                    // InternalEcoreReferenceTestLanguage.g:929:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						newLeafNode(otherlv_13, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0());
                    					

                    }


                    }

                    // InternalEcoreReferenceTestLanguage.g:940:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:941:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:941:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // InternalEcoreReferenceTestLanguage.g:942:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
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

                    // InternalEcoreReferenceTestLanguage.g:959:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:960:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:960:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // InternalEcoreReferenceTestLanguage.g:961:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
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

                    // InternalEcoreReferenceTestLanguage.g:978:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:979:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:979:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // InternalEcoreReferenceTestLanguage.g:980:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
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

                    // InternalEcoreReferenceTestLanguage.g:997:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // InternalEcoreReferenceTestLanguage.g:998:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // InternalEcoreReferenceTestLanguage.g:998:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // InternalEcoreReferenceTestLanguage.g:999:6: lv_eObjectContainment_17_0= ruleEObject
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

                    // InternalEcoreReferenceTestLanguage.g:1016:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:1017:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:1017:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:1018:6: lv_eObjectContainment_18_0= ruleEAttribute
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

                    // InternalEcoreReferenceTestLanguage.g:1035:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // InternalEcoreReferenceTestLanguage.g:1036:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // InternalEcoreReferenceTestLanguage.g:1036:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // InternalEcoreReferenceTestLanguage.g:1037:6: lv_eObjectContainment_19_0= ruleMyEAttribute
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
    // InternalEcoreReferenceTestLanguage.g:1059:1: entryRuleEObject returns [EObject current=null] : iv_ruleEObject= ruleEObject EOF ;
    public final EObject entryRuleEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObject = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:1059:48: (iv_ruleEObject= ruleEObject EOF )
            // InternalEcoreReferenceTestLanguage.g:1060:2: iv_ruleEObject= ruleEObject EOF
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
    // InternalEcoreReferenceTestLanguage.g:1066:1: ruleEObject returns [EObject current=null] : ( () otherlv_1= 'object' ) ;
    public final EObject ruleEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:1072:2: ( ( () otherlv_1= 'object' ) )
            // InternalEcoreReferenceTestLanguage.g:1073:2: ( () otherlv_1= 'object' )
            {
            // InternalEcoreReferenceTestLanguage.g:1073:2: ( () otherlv_1= 'object' )
            // InternalEcoreReferenceTestLanguage.g:1074:3: () otherlv_1= 'object'
            {
            // InternalEcoreReferenceTestLanguage.g:1074:3: ()
            // InternalEcoreReferenceTestLanguage.g:1075:4: 
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
    // InternalEcoreReferenceTestLanguage.g:1089:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalEcoreReferenceTestLanguage.g:1089:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalEcoreReferenceTestLanguage.g:1090:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalEcoreReferenceTestLanguage.g:1096:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalEcoreReferenceTestLanguage.g:1102:2: (this_ID_0= RULE_ID )
            // InternalEcoreReferenceTestLanguage.g:1103:2: this_ID_0= RULE_ID
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