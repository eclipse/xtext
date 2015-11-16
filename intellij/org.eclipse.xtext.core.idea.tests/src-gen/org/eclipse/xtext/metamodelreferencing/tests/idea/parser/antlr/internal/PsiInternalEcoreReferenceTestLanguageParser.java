package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEcoreReferenceTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ExtendsNsURIEObject'", "'EObject'", "'ExtendsPluginEObject'", "'ExtendsResourceEObject'", "'MyEAttribute'", "'EAttribute'", "'object'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalEcoreReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEcoreReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEcoreReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEcoreReferenceTestLanguage.g"; }



    	protected EcoreReferenceTestLanguageGrammarAccess grammarAccess;

    	protected EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEcoreReferenceTestLanguageParser(PsiBuilder builder, TokenStream input, EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider, EcoreReferenceTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalEcoreReferenceTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalEcoreReferenceTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_extends_0_0 = null;

        Boolean lv_extends_1_0 = null;

        Boolean lv_extends_2_0 = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:60:1: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // PsiInternalEcoreReferenceTestLanguage.g:61:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:61:2: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // PsiInternalEcoreReferenceTestLanguage.g:62:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:62:3: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // PsiInternalEcoreReferenceTestLanguage.g:63:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:63:4: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // PsiInternalEcoreReferenceTestLanguage.g:64:5: lv_extends_0_0= ruleExtendsNsURIEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsNsURIEObjectParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_extends_0_0=ruleExtendsNsURIEObject();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEcoreReferenceTestLanguage.g:77:3: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // PsiInternalEcoreReferenceTestLanguage.g:78:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:78:4: (lv_extends_1_0= ruleExtendsPluginEObject )
            // PsiInternalEcoreReferenceTestLanguage.g:79:5: lv_extends_1_0= ruleExtendsPluginEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsPluginEObjectParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_extends_1_0=ruleExtendsPluginEObject();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEcoreReferenceTestLanguage.g:92:3: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // PsiInternalEcoreReferenceTestLanguage.g:93:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:93:4: (lv_extends_2_0= ruleExtendsResourceEObject )
            // PsiInternalEcoreReferenceTestLanguage.g:94:5: lv_extends_2_0= ruleExtendsResourceEObject
            {

            					markComposite(elementTypeProvider.getModel_ExtendsExtendsResourceEObjectParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_extends_2_0=ruleExtendsResourceEObject();

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


    // $ANTLR start "entryRuleExtendsNsURIEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:111:1: entryRuleExtendsNsURIEObject returns [Boolean current=false] : iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF ;
    public final Boolean entryRuleExtendsNsURIEObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtendsNsURIEObject = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:111:61: (iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:112:2: iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsNsURIEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsNsURIEObject=ruleExtendsNsURIEObject();

            state._fsp--;

             current =iv_ruleExtendsNsURIEObject; 
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
    // $ANTLR end "entryRuleExtendsNsURIEObject"


    // $ANTLR start "ruleExtendsNsURIEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:118:1: ruleExtendsNsURIEObject returns [Boolean current=false] : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
    public final Boolean ruleExtendsNsURIEObject() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_name_1_0 = null;

        Boolean lv_eObjectContainment_15_0 = null;

        Boolean lv_eObjectContainment_16_0 = null;

        Boolean lv_eObjectContainment_17_0 = null;

        Boolean lv_eObjectContainment_18_0 = null;

        Boolean lv_eObjectContainment_19_0 = null;

        Boolean lv_eObjectContainment_20_0 = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:119:1: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // PsiInternalEcoreReferenceTestLanguage.g:120:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:120:2: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // PsiInternalEcoreReferenceTestLanguage.g:121:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEcoreReferenceTestLanguage.g:128:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEcoreReferenceTestLanguage.g:129:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:129:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEcoreReferenceTestLanguage.g:130:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEcoreReferenceTestLanguage.g:143:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // PsiInternalEcoreReferenceTestLanguage.g:144:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:144:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:145:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:152:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:153:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:153:6: (otherlv_3= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:154:7: otherlv_3= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEcoreReferenceTestLanguage.g:171:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:171:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:172:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:179:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:180:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:180:6: (otherlv_5= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:181:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEcoreReferenceTestLanguage.g:198:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:198:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:199:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:206:5: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:207:6: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:207:6: (otherlv_7= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:208:7: otherlv_7= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEcoreReferenceTestLanguage.g:225:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:225:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:226:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_8);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:233:5: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:234:6: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:234:6: (otherlv_9= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:235:7: otherlv_9= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEcoreReferenceTestLanguage.g:252:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
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
                    // PsiInternalEcoreReferenceTestLanguage.g:253:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalEcoreReferenceTestLanguage.g:260:4: ( (otherlv_11= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:261:5: (otherlv_11= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:261:5: (otherlv_11= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:262:6: otherlv_11= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceMyEAttributeCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:277:4: ( (otherlv_12= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:278:5: (otherlv_12= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:278:5: (otherlv_12= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:279:6: otherlv_12= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:294:4: ( (otherlv_13= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:295:5: (otherlv_13= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:295:5: (otherlv_13= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:296:6: otherlv_13= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:311:4: ( (otherlv_14= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:312:5: (otherlv_14= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:312:5: (otherlv_14= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:313:6: otherlv_14= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsNsURIEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_4_0ElementType());
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(otherlv_14);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:328:4: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:329:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:329:5: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:330:6: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_15_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:343:4: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:344:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:344:5: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:345:6: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_16_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:358:4: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:359:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:359:5: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:360:6: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_17_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:373:4: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:374:5: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:374:5: (lv_eObjectContainment_18_0= ruleEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:375:6: lv_eObjectContainment_18_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEObjectParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_18_0=ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:388:4: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:389:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:389:5: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:390:6: lv_eObjectContainment_19_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_19_0=ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:403:4: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:404:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:404:5: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:405:6: lv_eObjectContainment_20_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentMyEAttributeParserRuleCall_3_10_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_20_0=ruleMyEAttribute();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendsNsURIEObject"


    // $ANTLR start "entryRuleMyEAttribute"
    // PsiInternalEcoreReferenceTestLanguage.g:423:1: entryRuleMyEAttribute returns [Boolean current=false] : iv_ruleMyEAttribute= ruleMyEAttribute EOF ;
    public final Boolean entryRuleMyEAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMyEAttribute = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:423:54: (iv_ruleMyEAttribute= ruleMyEAttribute EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:424:2: iv_ruleMyEAttribute= ruleMyEAttribute EOF
            {
             markComposite(elementTypeProvider.getMyEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMyEAttribute=ruleMyEAttribute();

            state._fsp--;

             current =iv_ruleMyEAttribute; 
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
    // $ANTLR end "entryRuleMyEAttribute"


    // $ANTLR start "ruleMyEAttribute"
    // PsiInternalEcoreReferenceTestLanguage.g:430:1: ruleMyEAttribute returns [Boolean current=false] : ( () otherlv_1= 'MyEAttribute' ) ;
    public final Boolean ruleMyEAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalEcoreReferenceTestLanguage.g:431:1: ( ( () otherlv_1= 'MyEAttribute' ) )
            // PsiInternalEcoreReferenceTestLanguage.g:432:2: ( () otherlv_1= 'MyEAttribute' )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:432:2: ( () otherlv_1= 'MyEAttribute' )
            // PsiInternalEcoreReferenceTestLanguage.g:433:3: () otherlv_1= 'MyEAttribute'
            {
            // PsiInternalEcoreReferenceTestLanguage.g:433:3: ()
            // PsiInternalEcoreReferenceTestLanguage.g:434:4: 
            {

            				precedeComposite(elementTypeProvider.getMyEAttribute_MyEAttributeAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getMyEAttribute_MyEAttributeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // $ANTLR end "ruleMyEAttribute"


    // $ANTLR start "entryRuleEAttribute"
    // PsiInternalEcoreReferenceTestLanguage.g:451:1: entryRuleEAttribute returns [Boolean current=false] : iv_ruleEAttribute= ruleEAttribute EOF ;
    public final Boolean entryRuleEAttribute() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEAttribute = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:451:52: (iv_ruleEAttribute= ruleEAttribute EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:452:2: iv_ruleEAttribute= ruleEAttribute EOF
            {
             markComposite(elementTypeProvider.getEAttributeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEAttribute=ruleEAttribute();

            state._fsp--;

             current =iv_ruleEAttribute; 
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
    // $ANTLR end "entryRuleEAttribute"


    // $ANTLR start "ruleEAttribute"
    // PsiInternalEcoreReferenceTestLanguage.g:458:1: ruleEAttribute returns [Boolean current=false] : ( () otherlv_1= 'EAttribute' ) ;
    public final Boolean ruleEAttribute() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalEcoreReferenceTestLanguage.g:459:1: ( ( () otherlv_1= 'EAttribute' ) )
            // PsiInternalEcoreReferenceTestLanguage.g:460:2: ( () otherlv_1= 'EAttribute' )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:460:2: ( () otherlv_1= 'EAttribute' )
            // PsiInternalEcoreReferenceTestLanguage.g:461:3: () otherlv_1= 'EAttribute'
            {
            // PsiInternalEcoreReferenceTestLanguage.g:461:3: ()
            // PsiInternalEcoreReferenceTestLanguage.g:462:4: 
            {

            				precedeComposite(elementTypeProvider.getEAttribute_EAttributeAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getEAttribute_EAttributeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleExtendsPluginEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:479:1: entryRuleExtendsPluginEObject returns [Boolean current=false] : iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF ;
    public final Boolean entryRuleExtendsPluginEObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtendsPluginEObject = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:479:62: (iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:480:2: iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsPluginEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsPluginEObject=ruleExtendsPluginEObject();

            state._fsp--;

             current =iv_ruleExtendsPluginEObject; 
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
    // $ANTLR end "entryRuleExtendsPluginEObject"


    // $ANTLR start "ruleExtendsPluginEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:486:1: ruleExtendsPluginEObject returns [Boolean current=false] : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final Boolean ruleExtendsPluginEObject() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_name_1_0 = null;

        Boolean lv_eObjectContainment_14_0 = null;

        Boolean lv_eObjectContainment_15_0 = null;

        Boolean lv_eObjectContainment_16_0 = null;

        Boolean lv_eObjectContainment_17_0 = null;

        Boolean lv_eObjectContainment_18_0 = null;

        Boolean lv_eObjectContainment_19_0 = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:487:1: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // PsiInternalEcoreReferenceTestLanguage.g:488:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:488:2: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // PsiInternalEcoreReferenceTestLanguage.g:489:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEcoreReferenceTestLanguage.g:496:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEcoreReferenceTestLanguage.g:497:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:497:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEcoreReferenceTestLanguage.g:498:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEcoreReferenceTestLanguage.g:511:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // PsiInternalEcoreReferenceTestLanguage.g:512:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:512:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:513:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:520:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:521:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:521:6: (otherlv_3= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:522:7: otherlv_3= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEcoreReferenceTestLanguage.g:539:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:539:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:540:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:547:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:548:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:548:6: (otherlv_5= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:549:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEcoreReferenceTestLanguage.g:566:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:566:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:567:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:574:5: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:575:6: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:575:6: (otherlv_7= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:576:7: otherlv_7= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEcoreReferenceTestLanguage.g:593:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:593:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:594:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_8);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:601:5: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:602:6: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:602:6: (otherlv_9= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:603:7: otherlv_9= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEcoreReferenceTestLanguage.g:620:3: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalEcoreReferenceTestLanguage.g:621:4: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalEcoreReferenceTestLanguage.g:628:4: ( (otherlv_11= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:629:5: (otherlv_11= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:629:5: (otherlv_11= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:630:6: otherlv_11= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:645:4: ( (otherlv_12= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:646:5: (otherlv_12= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:646:5: (otherlv_12= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:647:6: otherlv_12= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:662:4: ( (otherlv_13= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:663:5: (otherlv_13= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:663:5: (otherlv_13= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:664:6: otherlv_13= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsPluginEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:679:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:680:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:680:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:681:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:694:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:695:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:695:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:696:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:709:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // PsiInternalEcoreReferenceTestLanguage.g:710:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // PsiInternalEcoreReferenceTestLanguage.g:710:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // PsiInternalEcoreReferenceTestLanguage.g:711:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                            {

                            						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }


                            }
                            break;

                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:724:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:725:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:725:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:726:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:739:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:740:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:740:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:741:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:754:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:755:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:755:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:756:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsPluginEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendsPluginEObject"


    // $ANTLR start "entryRuleExtendsResourceEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:774:1: entryRuleExtendsResourceEObject returns [Boolean current=false] : iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF ;
    public final Boolean entryRuleExtendsResourceEObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtendsResourceEObject = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:774:64: (iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:775:2: iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF
            {
             markComposite(elementTypeProvider.getExtendsResourceEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendsResourceEObject=ruleExtendsResourceEObject();

            state._fsp--;

             current =iv_ruleExtendsResourceEObject; 
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
    // $ANTLR end "entryRuleExtendsResourceEObject"


    // $ANTLR start "ruleExtendsResourceEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:781:1: ruleExtendsResourceEObject returns [Boolean current=false] : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final Boolean ruleExtendsResourceEObject() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_name_1_0 = null;

        Boolean lv_eObjectContainment_14_0 = null;

        Boolean lv_eObjectContainment_15_0 = null;

        Boolean lv_eObjectContainment_16_0 = null;

        Boolean lv_eObjectContainment_17_0 = null;

        Boolean lv_eObjectContainment_18_0 = null;

        Boolean lv_eObjectContainment_19_0 = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:782:1: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // PsiInternalEcoreReferenceTestLanguage.g:783:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:783:2: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // PsiInternalEcoreReferenceTestLanguage.g:784:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {

            			markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEcoreReferenceTestLanguage.g:791:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEcoreReferenceTestLanguage.g:792:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:792:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEcoreReferenceTestLanguage.g:793:5: lv_name_1_0= ruleValidID
            {

            					markComposite(elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEcoreReferenceTestLanguage.g:806:3: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
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
                    // PsiInternalEcoreReferenceTestLanguage.g:807:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:807:4: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:808:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:815:5: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:816:6: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:816:6: (otherlv_3= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:817:7: otherlv_3= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType());
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							doneLeaf(otherlv_3);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEcoreReferenceTestLanguage.g:834:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:834:4: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:835:5: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:842:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:843:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:843:6: (otherlv_5= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:844:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEcoreReferenceTestLanguage.g:861:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:861:4: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:862:5: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:869:5: ( (otherlv_7= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:870:6: (otherlv_7= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:870:6: (otherlv_7= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:871:7: otherlv_7= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType());
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							doneLeaf(otherlv_7);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEcoreReferenceTestLanguage.g:888:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:888:4: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:889:5: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType());
                    				
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_8);
                    				
                    // PsiInternalEcoreReferenceTestLanguage.g:896:5: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:897:6: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:897:6: (otherlv_9= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:898:7: otherlv_9= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType());
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    							doneLeaf(otherlv_9);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEcoreReferenceTestLanguage.g:915:3: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalEcoreReferenceTestLanguage.g:916:4: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {

                    				markLeaf(elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalEcoreReferenceTestLanguage.g:923:4: ( (otherlv_11= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:924:5: (otherlv_11= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:924:5: (otherlv_11= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:925:6: otherlv_11= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType());
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_11);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:940:4: ( (otherlv_12= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:941:5: (otherlv_12= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:941:5: (otherlv_12= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:942:6: otherlv_12= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType());
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    						doneLeaf(otherlv_12);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:957:4: ( (otherlv_13= RULE_ID ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:958:5: (otherlv_13= RULE_ID )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:958:5: (otherlv_13= RULE_ID )
                    // PsiInternalEcoreReferenceTestLanguage.g:959:6: otherlv_13= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getExtendsResourceEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType());
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						doneLeaf(otherlv_13);
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:974:4: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:975:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:975:5: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:976:6: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:989:4: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:990:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:990:5: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:991:6: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:1004:4: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:1005:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:1005:5: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:1006:6: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:1019:4: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:1020:5: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:1020:5: (lv_eObjectContainment_17_0= ruleEObject )
                    // PsiInternalEcoreReferenceTestLanguage.g:1021:6: lv_eObjectContainment_17_0= ruleEObject
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:1034:4: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:1035:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:1035:5: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:1036:6: lv_eObjectContainment_18_0= ruleEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEcoreReferenceTestLanguage.g:1049:4: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // PsiInternalEcoreReferenceTestLanguage.g:1050:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // PsiInternalEcoreReferenceTestLanguage.g:1050:5: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // PsiInternalEcoreReferenceTestLanguage.g:1051:6: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {

                    						markComposite(elementTypeProvider.getExtendsResourceEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendsResourceEObject"


    // $ANTLR start "entryRuleEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:1069:1: entryRuleEObject returns [Boolean current=false] : iv_ruleEObject= ruleEObject EOF ;
    public final Boolean entryRuleEObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEObject = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:1069:49: (iv_ruleEObject= ruleEObject EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:1070:2: iv_ruleEObject= ruleEObject EOF
            {
             markComposite(elementTypeProvider.getEObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObject=ruleEObject();

            state._fsp--;

             current =iv_ruleEObject; 
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
    // $ANTLR end "entryRuleEObject"


    // $ANTLR start "ruleEObject"
    // PsiInternalEcoreReferenceTestLanguage.g:1076:1: ruleEObject returns [Boolean current=false] : ( () otherlv_1= 'object' ) ;
    public final Boolean ruleEObject() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalEcoreReferenceTestLanguage.g:1077:1: ( ( () otherlv_1= 'object' ) )
            // PsiInternalEcoreReferenceTestLanguage.g:1078:2: ( () otherlv_1= 'object' )
            {
            // PsiInternalEcoreReferenceTestLanguage.g:1078:2: ( () otherlv_1= 'object' )
            // PsiInternalEcoreReferenceTestLanguage.g:1079:3: () otherlv_1= 'object'
            {
            // PsiInternalEcoreReferenceTestLanguage.g:1079:3: ()
            // PsiInternalEcoreReferenceTestLanguage.g:1080:4: 
            {

            				precedeComposite(elementTypeProvider.getEObject_EObjectAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getEObject_ObjectKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleValidID"
    // PsiInternalEcoreReferenceTestLanguage.g:1097:1: entryRuleValidID returns [Boolean current=false] : iv_ruleValidID= ruleValidID EOF ;
    public final Boolean entryRuleValidID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValidID = null;


        try {
            // PsiInternalEcoreReferenceTestLanguage.g:1097:49: (iv_ruleValidID= ruleValidID EOF )
            // PsiInternalEcoreReferenceTestLanguage.g:1098:2: iv_ruleValidID= ruleValidID EOF
            {
             markComposite(elementTypeProvider.getValidIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID; 
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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // PsiInternalEcoreReferenceTestLanguage.g:1104:1: ruleValidID returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleValidID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalEcoreReferenceTestLanguage.g:1105:1: (this_ID_0= RULE_ID )
            // PsiInternalEcoreReferenceTestLanguage.g:1106:2: this_ID_0= RULE_ID
            {

            		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_ID_0);
            	

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