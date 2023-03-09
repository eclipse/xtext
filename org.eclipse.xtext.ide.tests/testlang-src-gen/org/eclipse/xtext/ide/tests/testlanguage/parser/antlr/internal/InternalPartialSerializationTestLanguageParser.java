package org.eclipse.xtext.ide.tests.testlanguage.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialSerializationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#10'", "'#11'", "'#12'", "'#13'", "'#20'", "'#21'", "'#22'", "'#23'", "'#24'", "'#30'", "'kw1'", "'kw2'", "'{'", "'children1'", "'}'", "'direct'", "':'", "'child'", "'subs'", "'import'", "'refs'", "'ref'", "';'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
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
    public static final int RULE_INT=5;
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


        public InternalPartialSerializationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialSerializationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialSerializationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPartialSerializationTestLanguage.g"; }



     	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

        public InternalPartialSerializationTestLanguageParser(TokenStream input, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected PartialSerializationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalPartialSerializationTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPartialSerializationTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalPartialSerializationTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPartialSerializationTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#1' this_Node_1= ruleNode ) | (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue ) | (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue ) | (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild ) | (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild ) | (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues ) | (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues ) | (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList ) | (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList ) | (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ ) | (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef ) | (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists ) | (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds ) | (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds ) | (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer ) ) ;
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
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        EObject this_Node_1 = null;

        EObject this_MandatoryValue_3 = null;

        EObject this_OptionalValue_5 = null;

        EObject this_MandatoryChild_7 = null;

        EObject this_OptionalChild_9 = null;

        EObject this_ManyOptionalValues_11 = null;

        EObject this_ManyMandatoryValues_13 = null;

        EObject this_MandatoryChildList_15 = null;

        EObject this_OptionalChildList_17 = null;

        EObject lv_clazz_19_0 = null;

        EObject this_EClassRef_21 = null;

        EObject this_TwoChildLists_23 = null;

        EObject this_ChildWithSubChilds_25 = null;

        EObject this_TwoChilds_27 = null;

        EObject this_WithTransientContainer_29 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:82:2: ( ( (otherlv_0= '#1' this_Node_1= ruleNode ) | (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue ) | (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue ) | (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild ) | (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild ) | (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues ) | (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues ) | (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList ) | (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList ) | (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ ) | (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef ) | (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists ) | (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds ) | (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds ) | (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer ) ) )
            // InternalPartialSerializationTestLanguage.g:83:2: ( (otherlv_0= '#1' this_Node_1= ruleNode ) | (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue ) | (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue ) | (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild ) | (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild ) | (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues ) | (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues ) | (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList ) | (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList ) | (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ ) | (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef ) | (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists ) | (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds ) | (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds ) | (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer ) )
            {
            // InternalPartialSerializationTestLanguage.g:83:2: ( (otherlv_0= '#1' this_Node_1= ruleNode ) | (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue ) | (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue ) | (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild ) | (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild ) | (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues ) | (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues ) | (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList ) | (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList ) | (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ ) | (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef ) | (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists ) | (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds ) | (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds ) | (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer ) )
            int alt2=15;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 17:
                {
                alt2=7;
                }
                break;
            case 18:
                {
                alt2=8;
                }
                break;
            case 19:
                {
                alt2=9;
                }
                break;
            case 20:
                {
                alt2=10;
                }
                break;
            case 21:
                {
                alt2=11;
                }
                break;
            case 22:
                {
                alt2=12;
                }
                break;
            case 23:
                {
                alt2=13;
                }
                break;
            case 24:
                {
                alt2=14;
                }
                break;
            case 25:
                {
                alt2=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:84:3: (otherlv_0= '#1' this_Node_1= ruleNode )
                    {
                    // InternalPartialSerializationTestLanguage.g:84:3: (otherlv_0= '#1' this_Node_1= ruleNode )
                    // InternalPartialSerializationTestLanguage.g:85:4: otherlv_0= '#1' this_Node_1= ruleNode
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getNodeParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_Node_1=ruleNode();

                    state._fsp--;


                    				current = this_Node_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPartialSerializationTestLanguage.g:99:3: (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue )
                    {
                    // InternalPartialSerializationTestLanguage.g:99:3: (otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue )
                    // InternalPartialSerializationTestLanguage.g:100:4: otherlv_2= '#2' this_MandatoryValue_3= ruleMandatoryValue
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getMandatoryValueParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_MandatoryValue_3=ruleMandatoryValue();

                    state._fsp--;


                    				current = this_MandatoryValue_3;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPartialSerializationTestLanguage.g:114:3: (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue )
                    {
                    // InternalPartialSerializationTestLanguage.g:114:3: (otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue )
                    // InternalPartialSerializationTestLanguage.g:115:4: otherlv_4= '#3' this_OptionalValue_5= ruleOptionalValue
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_2_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getOptionalValueParserRuleCall_2_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_OptionalValue_5=ruleOptionalValue();

                    state._fsp--;


                    				current = this_OptionalValue_5;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPartialSerializationTestLanguage.g:129:3: (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild )
                    {
                    // InternalPartialSerializationTestLanguage.g:129:3: (otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild )
                    // InternalPartialSerializationTestLanguage.g:130:4: otherlv_6= '#4' this_MandatoryChild_7= ruleMandatoryChild
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_3_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getMandatoryChildParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_MandatoryChild_7=ruleMandatoryChild();

                    state._fsp--;


                    				current = this_MandatoryChild_7;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalPartialSerializationTestLanguage.g:144:3: (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild )
                    {
                    // InternalPartialSerializationTestLanguage.g:144:3: (otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild )
                    // InternalPartialSerializationTestLanguage.g:145:4: otherlv_8= '#5' this_OptionalChild_9= ruleOptionalChild
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_4_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getOptionalChildParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_OptionalChild_9=ruleOptionalChild();

                    state._fsp--;


                    				current = this_OptionalChild_9;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalPartialSerializationTestLanguage.g:159:3: (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues )
                    {
                    // InternalPartialSerializationTestLanguage.g:159:3: (otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues )
                    // InternalPartialSerializationTestLanguage.g:160:4: otherlv_10= '#10' this_ManyOptionalValues_11= ruleManyOptionalValues
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitOneDigitZeroKeyword_5_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getManyOptionalValuesParserRuleCall_5_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_ManyOptionalValues_11=ruleManyOptionalValues();

                    state._fsp--;


                    				current = this_ManyOptionalValues_11;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalPartialSerializationTestLanguage.g:174:3: (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues )
                    {
                    // InternalPartialSerializationTestLanguage.g:174:3: (otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues )
                    // InternalPartialSerializationTestLanguage.g:175:4: otherlv_12= '#11' this_ManyMandatoryValues_13= ruleManyMandatoryValues
                    {
                    otherlv_12=(Token)match(input,17,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitOneDigitOneKeyword_6_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getManyMandatoryValuesParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_ManyMandatoryValues_13=ruleManyMandatoryValues();

                    state._fsp--;


                    				current = this_ManyMandatoryValues_13;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalPartialSerializationTestLanguage.g:189:3: (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList )
                    {
                    // InternalPartialSerializationTestLanguage.g:189:3: (otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList )
                    // InternalPartialSerializationTestLanguage.g:190:4: otherlv_14= '#12' this_MandatoryChildList_15= ruleMandatoryChildList
                    {
                    otherlv_14=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitOneDigitTwoKeyword_7_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getMandatoryChildListParserRuleCall_7_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_MandatoryChildList_15=ruleMandatoryChildList();

                    state._fsp--;


                    				current = this_MandatoryChildList_15;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalPartialSerializationTestLanguage.g:204:3: (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList )
                    {
                    // InternalPartialSerializationTestLanguage.g:204:3: (otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList )
                    // InternalPartialSerializationTestLanguage.g:205:4: otherlv_16= '#13' this_OptionalChildList_17= ruleOptionalChildList
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitOneDigitThreeKeyword_8_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getOptionalChildListParserRuleCall_8_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_OptionalChildList_17=ruleOptionalChildList();

                    state._fsp--;


                    				current = this_OptionalChildList_17;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalPartialSerializationTestLanguage.g:219:3: (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ )
                    {
                    // InternalPartialSerializationTestLanguage.g:219:3: (otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+ )
                    // InternalPartialSerializationTestLanguage.g:220:4: otherlv_18= '#20' ( (lv_clazz_19_0= ruleEClassDecl ) )+
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitZeroKeyword_9_0());
                    			
                    // InternalPartialSerializationTestLanguage.g:224:4: ( (lv_clazz_19_0= ruleEClassDecl ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalPartialSerializationTestLanguage.g:225:5: (lv_clazz_19_0= ruleEClassDecl )
                    	    {
                    	    // InternalPartialSerializationTestLanguage.g:225:5: (lv_clazz_19_0= ruleEClassDecl )
                    	    // InternalPartialSerializationTestLanguage.g:226:6: lv_clazz_19_0= ruleEClassDecl
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getClazzEClassDeclParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_clazz_19_0=ruleEClassDecl();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModelRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"clazz",
                    	    							lv_clazz_19_0,
                    	    							"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.EClassDecl");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }


                    }
                    break;
                case 11 :
                    // InternalPartialSerializationTestLanguage.g:245:3: (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef )
                    {
                    // InternalPartialSerializationTestLanguage.g:245:3: (otherlv_20= '#21' this_EClassRef_21= ruleEClassRef )
                    // InternalPartialSerializationTestLanguage.g:246:4: otherlv_20= '#21' this_EClassRef_21= ruleEClassRef
                    {
                    otherlv_20=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_20, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitOneKeyword_10_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getEClassRefParserRuleCall_10_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_EClassRef_21=ruleEClassRef();

                    state._fsp--;


                    				current = this_EClassRef_21;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalPartialSerializationTestLanguage.g:260:3: (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists )
                    {
                    // InternalPartialSerializationTestLanguage.g:260:3: (otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists )
                    // InternalPartialSerializationTestLanguage.g:261:4: otherlv_22= '#22' this_TwoChildLists_23= ruleTwoChildLists
                    {
                    otherlv_22=(Token)match(input,22,FOLLOW_7); 

                    				newLeafNode(otherlv_22, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitTwoKeyword_11_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getTwoChildListsParserRuleCall_11_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_TwoChildLists_23=ruleTwoChildLists();

                    state._fsp--;


                    				current = this_TwoChildLists_23;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalPartialSerializationTestLanguage.g:275:3: (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds )
                    {
                    // InternalPartialSerializationTestLanguage.g:275:3: (otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds )
                    // InternalPartialSerializationTestLanguage.g:276:4: otherlv_24= '#23' this_ChildWithSubChilds_25= ruleChildWithSubChilds
                    {
                    otherlv_24=(Token)match(input,23,FOLLOW_8); 

                    				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitThreeKeyword_12_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getChildWithSubChildsParserRuleCall_12_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_ChildWithSubChilds_25=ruleChildWithSubChilds();

                    state._fsp--;


                    				current = this_ChildWithSubChilds_25;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalPartialSerializationTestLanguage.g:290:3: (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds )
                    {
                    // InternalPartialSerializationTestLanguage.g:290:3: (otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds )
                    // InternalPartialSerializationTestLanguage.g:291:4: otherlv_26= '#24' this_TwoChilds_27= ruleTwoChilds
                    {
                    otherlv_26=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_26, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitFourKeyword_13_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getTwoChildsParserRuleCall_13_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_TwoChilds_27=ruleTwoChilds();

                    state._fsp--;


                    				current = this_TwoChilds_27;
                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalPartialSerializationTestLanguage.g:305:3: (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer )
                    {
                    // InternalPartialSerializationTestLanguage.g:305:3: (otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer )
                    // InternalPartialSerializationTestLanguage.g:306:4: otherlv_28= '#30' this_WithTransientContainer_29= ruleWithTransientContainer
                    {
                    otherlv_28=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_28, grammarAccess.getModelAccess().getNumberSignDigitThreeDigitZeroKeyword_14_0());
                    			

                    				newCompositeNode(grammarAccess.getModelAccess().getWithTransientContainerParserRuleCall_14_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_WithTransientContainer_29=ruleWithTransientContainer();

                    state._fsp--;


                    				current = this_WithTransientContainer_29;
                    				afterParserOrEnumRuleCall();
                    			

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


    // $ANTLR start "entryRuleMandatoryValue"
    // InternalPartialSerializationTestLanguage.g:323:1: entryRuleMandatoryValue returns [EObject current=null] : iv_ruleMandatoryValue= ruleMandatoryValue EOF ;
    public final EObject entryRuleMandatoryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryValue = null;


        try {
            // InternalPartialSerializationTestLanguage.g:323:55: (iv_ruleMandatoryValue= ruleMandatoryValue EOF )
            // InternalPartialSerializationTestLanguage.g:324:2: iv_ruleMandatoryValue= ruleMandatoryValue EOF
            {
             newCompositeNode(grammarAccess.getMandatoryValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMandatoryValue=ruleMandatoryValue();

            state._fsp--;

             current =iv_ruleMandatoryValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMandatoryValue"


    // $ANTLR start "ruleMandatoryValue"
    // InternalPartialSerializationTestLanguage.g:330:1: ruleMandatoryValue returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleMandatoryValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:336:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPartialSerializationTestLanguage.g:337:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPartialSerializationTestLanguage.g:337:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:338:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:338:3: (lv_name_0_0= RULE_ID )
            // InternalPartialSerializationTestLanguage.g:339:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getMandatoryValueAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getMandatoryValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleMandatoryValue"


    // $ANTLR start "entryRuleOptionalValue"
    // InternalPartialSerializationTestLanguage.g:358:1: entryRuleOptionalValue returns [EObject current=null] : iv_ruleOptionalValue= ruleOptionalValue EOF ;
    public final EObject entryRuleOptionalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalValue = null;


        try {
            // InternalPartialSerializationTestLanguage.g:358:54: (iv_ruleOptionalValue= ruleOptionalValue EOF )
            // InternalPartialSerializationTestLanguage.g:359:2: iv_ruleOptionalValue= ruleOptionalValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalValue=ruleOptionalValue();

            state._fsp--;

             current =iv_ruleOptionalValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptionalValue"


    // $ANTLR start "ruleOptionalValue"
    // InternalPartialSerializationTestLanguage.g:365:1: ruleOptionalValue returns [EObject current=null] : ( () (otherlv_1= 'kw1' )? ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'kw2' )? ) ;
    public final EObject ruleOptionalValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:371:2: ( ( () (otherlv_1= 'kw1' )? ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'kw2' )? ) )
            // InternalPartialSerializationTestLanguage.g:372:2: ( () (otherlv_1= 'kw1' )? ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'kw2' )? )
            {
            // InternalPartialSerializationTestLanguage.g:372:2: ( () (otherlv_1= 'kw1' )? ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'kw2' )? )
            // InternalPartialSerializationTestLanguage.g:373:3: () (otherlv_1= 'kw1' )? ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'kw2' )?
            {
            // InternalPartialSerializationTestLanguage.g:373:3: ()
            // InternalPartialSerializationTestLanguage.g:374:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOptionalValueAccess().getOptionalValueAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:380:3: (otherlv_1= 'kw1' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:381:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_10); 

                    				newLeafNode(otherlv_1, grammarAccess.getOptionalValueAccess().getKw1Keyword_1());
                    			

                    }
                    break;

            }

            // InternalPartialSerializationTestLanguage.g:386:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:387:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalPartialSerializationTestLanguage.g:387:4: (lv_name_2_0= RULE_ID )
                    // InternalPartialSerializationTestLanguage.g:388:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_11); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getOptionalValueAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOptionalValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalPartialSerializationTestLanguage.g:404:3: (otherlv_3= 'kw2' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:405:4: otherlv_3= 'kw2'
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getOptionalValueAccess().getKw2Keyword_3());
                    			

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
    // $ANTLR end "ruleOptionalValue"


    // $ANTLR start "entryRuleManyOptionalValues"
    // InternalPartialSerializationTestLanguage.g:414:1: entryRuleManyOptionalValues returns [EObject current=null] : iv_ruleManyOptionalValues= ruleManyOptionalValues EOF ;
    public final EObject entryRuleManyOptionalValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyOptionalValues = null;


        try {
            // InternalPartialSerializationTestLanguage.g:414:59: (iv_ruleManyOptionalValues= ruleManyOptionalValues EOF )
            // InternalPartialSerializationTestLanguage.g:415:2: iv_ruleManyOptionalValues= ruleManyOptionalValues EOF
            {
             newCompositeNode(grammarAccess.getManyOptionalValuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleManyOptionalValues=ruleManyOptionalValues();

            state._fsp--;

             current =iv_ruleManyOptionalValues; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleManyOptionalValues"


    // $ANTLR start "ruleManyOptionalValues"
    // InternalPartialSerializationTestLanguage.g:421:1: ruleManyOptionalValues returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) )* ) ;
    public final EObject ruleManyOptionalValues() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:427:2: ( ( () ( (lv_name_1_0= RULE_ID ) )* ) )
            // InternalPartialSerializationTestLanguage.g:428:2: ( () ( (lv_name_1_0= RULE_ID ) )* )
            {
            // InternalPartialSerializationTestLanguage.g:428:2: ( () ( (lv_name_1_0= RULE_ID ) )* )
            // InternalPartialSerializationTestLanguage.g:429:3: () ( (lv_name_1_0= RULE_ID ) )*
            {
            // InternalPartialSerializationTestLanguage.g:429:3: ()
            // InternalPartialSerializationTestLanguage.g:430:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:436:3: ( (lv_name_1_0= RULE_ID ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:437:4: (lv_name_1_0= RULE_ID )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:437:4: (lv_name_1_0= RULE_ID )
            	    // InternalPartialSerializationTestLanguage.g:438:5: lv_name_1_0= RULE_ID
            	    {
            	    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    					newLeafNode(lv_name_1_0, grammarAccess.getManyOptionalValuesAccess().getNameIDTerminalRuleCall_1_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getManyOptionalValuesRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"name",
            	    						lv_name_1_0,
            	    						"org.eclipse.xtext.common.Terminals.ID");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
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
    // $ANTLR end "ruleManyOptionalValues"


    // $ANTLR start "entryRuleManyMandatoryValues"
    // InternalPartialSerializationTestLanguage.g:458:1: entryRuleManyMandatoryValues returns [EObject current=null] : iv_ruleManyMandatoryValues= ruleManyMandatoryValues EOF ;
    public final EObject entryRuleManyMandatoryValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyMandatoryValues = null;


        try {
            // InternalPartialSerializationTestLanguage.g:458:60: (iv_ruleManyMandatoryValues= ruleManyMandatoryValues EOF )
            // InternalPartialSerializationTestLanguage.g:459:2: iv_ruleManyMandatoryValues= ruleManyMandatoryValues EOF
            {
             newCompositeNode(grammarAccess.getManyMandatoryValuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleManyMandatoryValues=ruleManyMandatoryValues();

            state._fsp--;

             current =iv_ruleManyMandatoryValues; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleManyMandatoryValues"


    // $ANTLR start "ruleManyMandatoryValues"
    // InternalPartialSerializationTestLanguage.g:465:1: ruleManyMandatoryValues returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) )+ ;
    public final EObject ruleManyMandatoryValues() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:471:2: ( ( (lv_name_0_0= RULE_ID ) )+ )
            // InternalPartialSerializationTestLanguage.g:472:2: ( (lv_name_0_0= RULE_ID ) )+
            {
            // InternalPartialSerializationTestLanguage.g:472:2: ( (lv_name_0_0= RULE_ID ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:473:3: (lv_name_0_0= RULE_ID )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:473:3: (lv_name_0_0= RULE_ID )
            	    // InternalPartialSerializationTestLanguage.g:474:4: lv_name_0_0= RULE_ID
            	    {
            	    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				newLeafNode(lv_name_0_0, grammarAccess.getManyMandatoryValuesAccess().getNameIDTerminalRuleCall_0());
            	    			

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getManyMandatoryValuesRule());
            	    				}
            	    				addWithLastConsumed(
            	    					current,
            	    					"name",
            	    					lv_name_0_0,
            	    					"org.eclipse.xtext.common.Terminals.ID");
            	    			

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
    // $ANTLR end "ruleManyMandatoryValues"


    // $ANTLR start "entryRuleMandatoryChild"
    // InternalPartialSerializationTestLanguage.g:493:1: entryRuleMandatoryChild returns [EObject current=null] : iv_ruleMandatoryChild= ruleMandatoryChild EOF ;
    public final EObject entryRuleMandatoryChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryChild = null;


        try {
            // InternalPartialSerializationTestLanguage.g:493:55: (iv_ruleMandatoryChild= ruleMandatoryChild EOF )
            // InternalPartialSerializationTestLanguage.g:494:2: iv_ruleMandatoryChild= ruleMandatoryChild EOF
            {
             newCompositeNode(grammarAccess.getMandatoryChildRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMandatoryChild=ruleMandatoryChild();

            state._fsp--;

             current =iv_ruleMandatoryChild; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMandatoryChild"


    // $ANTLR start "ruleMandatoryChild"
    // InternalPartialSerializationTestLanguage.g:500:1: ruleMandatoryChild returns [EObject current=null] : ( (lv_child_0_0= ruleMandatoryValue ) ) ;
    public final EObject ruleMandatoryChild() throws RecognitionException {
        EObject current = null;

        EObject lv_child_0_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:506:2: ( ( (lv_child_0_0= ruleMandatoryValue ) ) )
            // InternalPartialSerializationTestLanguage.g:507:2: ( (lv_child_0_0= ruleMandatoryValue ) )
            {
            // InternalPartialSerializationTestLanguage.g:507:2: ( (lv_child_0_0= ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:508:3: (lv_child_0_0= ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:508:3: (lv_child_0_0= ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:509:4: lv_child_0_0= ruleMandatoryValue
            {

            				newCompositeNode(grammarAccess.getMandatoryChildAccess().getChildMandatoryValueParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_child_0_0=ruleMandatoryValue();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getMandatoryChildRule());
            				}
            				set(
            					current,
            					"child",
            					lv_child_0_0,
            					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
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
    // $ANTLR end "ruleMandatoryChild"


    // $ANTLR start "entryRuleOptionalChild"
    // InternalPartialSerializationTestLanguage.g:529:1: entryRuleOptionalChild returns [EObject current=null] : iv_ruleOptionalChild= ruleOptionalChild EOF ;
    public final EObject entryRuleOptionalChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalChild = null;


        try {
            // InternalPartialSerializationTestLanguage.g:529:54: (iv_ruleOptionalChild= ruleOptionalChild EOF )
            // InternalPartialSerializationTestLanguage.g:530:2: iv_ruleOptionalChild= ruleOptionalChild EOF
            {
             newCompositeNode(grammarAccess.getOptionalChildRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalChild=ruleOptionalChild();

            state._fsp--;

             current =iv_ruleOptionalChild; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptionalChild"


    // $ANTLR start "ruleOptionalChild"
    // InternalPartialSerializationTestLanguage.g:536:1: ruleOptionalChild returns [EObject current=null] : ( () ( (lv_child_1_0= ruleMandatoryValue ) )? ) ;
    public final EObject ruleOptionalChild() throws RecognitionException {
        EObject current = null;

        EObject lv_child_1_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:542:2: ( ( () ( (lv_child_1_0= ruleMandatoryValue ) )? ) )
            // InternalPartialSerializationTestLanguage.g:543:2: ( () ( (lv_child_1_0= ruleMandatoryValue ) )? )
            {
            // InternalPartialSerializationTestLanguage.g:543:2: ( () ( (lv_child_1_0= ruleMandatoryValue ) )? )
            // InternalPartialSerializationTestLanguage.g:544:3: () ( (lv_child_1_0= ruleMandatoryValue ) )?
            {
            // InternalPartialSerializationTestLanguage.g:544:3: ()
            // InternalPartialSerializationTestLanguage.g:545:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOptionalChildAccess().getOptionalChildAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:551:3: ( (lv_child_1_0= ruleMandatoryValue ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:552:4: (lv_child_1_0= ruleMandatoryValue )
                    {
                    // InternalPartialSerializationTestLanguage.g:552:4: (lv_child_1_0= ruleMandatoryValue )
                    // InternalPartialSerializationTestLanguage.g:553:5: lv_child_1_0= ruleMandatoryValue
                    {

                    					newCompositeNode(grammarAccess.getOptionalChildAccess().getChildMandatoryValueParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_child_1_0=ruleMandatoryValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOptionalChildRule());
                    					}
                    					set(
                    						current,
                    						"child",
                    						lv_child_1_0,
                    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
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
    // $ANTLR end "ruleOptionalChild"


    // $ANTLR start "entryRuleTwoChildLists"
    // InternalPartialSerializationTestLanguage.g:574:1: entryRuleTwoChildLists returns [EObject current=null] : iv_ruleTwoChildLists= ruleTwoChildLists EOF ;
    public final EObject entryRuleTwoChildLists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoChildLists = null;


        try {
            // InternalPartialSerializationTestLanguage.g:574:54: (iv_ruleTwoChildLists= ruleTwoChildLists EOF )
            // InternalPartialSerializationTestLanguage.g:575:2: iv_ruleTwoChildLists= ruleTwoChildLists EOF
            {
             newCompositeNode(grammarAccess.getTwoChildListsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTwoChildLists=ruleTwoChildLists();

            state._fsp--;

             current =iv_ruleTwoChildLists; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoChildLists"


    // $ANTLR start "ruleTwoChildLists"
    // InternalPartialSerializationTestLanguage.g:581:1: ruleTwoChildLists returns [EObject current=null] : (otherlv_0= '{' ( (lv_directChildren_1_0= ruleMandatoryValue ) )+ otherlv_2= 'children1' otherlv_3= '{' ( (lv_childsList_4_0= ruleMandatoryChildList ) ) otherlv_5= '}' otherlv_6= '}' ) ;
    public final EObject ruleTwoChildLists() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_directChildren_1_0 = null;

        EObject lv_childsList_4_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:587:2: ( (otherlv_0= '{' ( (lv_directChildren_1_0= ruleMandatoryValue ) )+ otherlv_2= 'children1' otherlv_3= '{' ( (lv_childsList_4_0= ruleMandatoryChildList ) ) otherlv_5= '}' otherlv_6= '}' ) )
            // InternalPartialSerializationTestLanguage.g:588:2: (otherlv_0= '{' ( (lv_directChildren_1_0= ruleMandatoryValue ) )+ otherlv_2= 'children1' otherlv_3= '{' ( (lv_childsList_4_0= ruleMandatoryChildList ) ) otherlv_5= '}' otherlv_6= '}' )
            {
            // InternalPartialSerializationTestLanguage.g:588:2: (otherlv_0= '{' ( (lv_directChildren_1_0= ruleMandatoryValue ) )+ otherlv_2= 'children1' otherlv_3= '{' ( (lv_childsList_4_0= ruleMandatoryChildList ) ) otherlv_5= '}' otherlv_6= '}' )
            // InternalPartialSerializationTestLanguage.g:589:3: otherlv_0= '{' ( (lv_directChildren_1_0= ruleMandatoryValue ) )+ otherlv_2= 'children1' otherlv_3= '{' ( (lv_childsList_4_0= ruleMandatoryChildList ) ) otherlv_5= '}' otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalPartialSerializationTestLanguage.g:593:3: ( (lv_directChildren_1_0= ruleMandatoryValue ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:594:4: (lv_directChildren_1_0= ruleMandatoryValue )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:594:4: (lv_directChildren_1_0= ruleMandatoryValue )
            	    // InternalPartialSerializationTestLanguage.g:595:5: lv_directChildren_1_0= ruleMandatoryValue
            	    {

            	    					newCompositeNode(grammarAccess.getTwoChildListsAccess().getDirectChildrenMandatoryValueParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_directChildren_1_0=ruleMandatoryValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTwoChildListsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"directChildren",
            	    						lv_directChildren_1_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
            	    					afterParserOrEnumRuleCall();
            	    				

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

            otherlv_2=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTwoChildListsAccess().getChildren1Keyword_2());
            		
            otherlv_3=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalPartialSerializationTestLanguage.g:620:3: ( (lv_childsList_4_0= ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:621:4: (lv_childsList_4_0= ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:621:4: (lv_childsList_4_0= ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:622:5: lv_childsList_4_0= ruleMandatoryChildList
            {

            					newCompositeNode(grammarAccess.getTwoChildListsAccess().getChildsListMandatoryChildListParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_13);
            lv_childsList_4_0=ruleMandatoryChildList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTwoChildListsRule());
            					}
            					set(
            						current,
            						"childsList",
            						lv_childsList_4_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryChildList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleTwoChildLists"


    // $ANTLR start "entryRuleTwoChilds"
    // InternalPartialSerializationTestLanguage.g:651:1: entryRuleTwoChilds returns [EObject current=null] : iv_ruleTwoChilds= ruleTwoChilds EOF ;
    public final EObject entryRuleTwoChilds() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoChilds = null;


        try {
            // InternalPartialSerializationTestLanguage.g:651:50: (iv_ruleTwoChilds= ruleTwoChilds EOF )
            // InternalPartialSerializationTestLanguage.g:652:2: iv_ruleTwoChilds= ruleTwoChilds EOF
            {
             newCompositeNode(grammarAccess.getTwoChildsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTwoChilds=ruleTwoChilds();

            state._fsp--;

             current =iv_ruleTwoChilds; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoChilds"


    // $ANTLR start "ruleTwoChilds"
    // InternalPartialSerializationTestLanguage.g:658:1: ruleTwoChilds returns [EObject current=null] : ( () otherlv_1= 'direct' otherlv_2= ':' ( (lv_directChild_3_0= ruleMandatoryValue ) )? otherlv_4= 'child' otherlv_5= ':' ( (lv_optChild_6_0= ruleOptionalChild ) ) ) ;
    public final EObject ruleTwoChilds() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_directChild_3_0 = null;

        EObject lv_optChild_6_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:664:2: ( ( () otherlv_1= 'direct' otherlv_2= ':' ( (lv_directChild_3_0= ruleMandatoryValue ) )? otherlv_4= 'child' otherlv_5= ':' ( (lv_optChild_6_0= ruleOptionalChild ) ) ) )
            // InternalPartialSerializationTestLanguage.g:665:2: ( () otherlv_1= 'direct' otherlv_2= ':' ( (lv_directChild_3_0= ruleMandatoryValue ) )? otherlv_4= 'child' otherlv_5= ':' ( (lv_optChild_6_0= ruleOptionalChild ) ) )
            {
            // InternalPartialSerializationTestLanguage.g:665:2: ( () otherlv_1= 'direct' otherlv_2= ':' ( (lv_directChild_3_0= ruleMandatoryValue ) )? otherlv_4= 'child' otherlv_5= ':' ( (lv_optChild_6_0= ruleOptionalChild ) ) )
            // InternalPartialSerializationTestLanguage.g:666:3: () otherlv_1= 'direct' otherlv_2= ':' ( (lv_directChild_3_0= ruleMandatoryValue ) )? otherlv_4= 'child' otherlv_5= ':' ( (lv_optChild_6_0= ruleOptionalChild ) )
            {
            // InternalPartialSerializationTestLanguage.g:666:3: ()
            // InternalPartialSerializationTestLanguage.g:667:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTwoChildsAccess().getTwoChildsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,31,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getTwoChildsAccess().getDirectKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getTwoChildsAccess().getColonKeyword_2());
            		
            // InternalPartialSerializationTestLanguage.g:681:3: ( (lv_directChild_3_0= ruleMandatoryValue ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:682:4: (lv_directChild_3_0= ruleMandatoryValue )
                    {
                    // InternalPartialSerializationTestLanguage.g:682:4: (lv_directChild_3_0= ruleMandatoryValue )
                    // InternalPartialSerializationTestLanguage.g:683:5: lv_directChild_3_0= ruleMandatoryValue
                    {

                    					newCompositeNode(grammarAccess.getTwoChildsAccess().getDirectChildMandatoryValueParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_directChild_3_0=ruleMandatoryValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTwoChildsRule());
                    					}
                    					set(
                    						current,
                    						"directChild",
                    						lv_directChild_3_0,
                    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,33,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getTwoChildsAccess().getChildKeyword_4());
            		
            otherlv_5=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoChildsAccess().getColonKeyword_5());
            		
            // InternalPartialSerializationTestLanguage.g:708:3: ( (lv_optChild_6_0= ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:709:4: (lv_optChild_6_0= ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:709:4: (lv_optChild_6_0= ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:710:5: lv_optChild_6_0= ruleOptionalChild
            {

            					newCompositeNode(grammarAccess.getTwoChildsAccess().getOptChildOptionalChildParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_optChild_6_0=ruleOptionalChild();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTwoChildsRule());
            					}
            					set(
            						current,
            						"optChild",
            						lv_optChild_6_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.OptionalChild");
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
    // $ANTLR end "ruleTwoChilds"


    // $ANTLR start "entryRuleChildWithSubChilds"
    // InternalPartialSerializationTestLanguage.g:731:1: entryRuleChildWithSubChilds returns [EObject current=null] : iv_ruleChildWithSubChilds= ruleChildWithSubChilds EOF ;
    public final EObject entryRuleChildWithSubChilds() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildWithSubChilds = null;


        try {
            // InternalPartialSerializationTestLanguage.g:731:59: (iv_ruleChildWithSubChilds= ruleChildWithSubChilds EOF )
            // InternalPartialSerializationTestLanguage.g:732:2: iv_ruleChildWithSubChilds= ruleChildWithSubChilds EOF
            {
             newCompositeNode(grammarAccess.getChildWithSubChildsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChildWithSubChilds=ruleChildWithSubChilds();

            state._fsp--;

             current =iv_ruleChildWithSubChilds; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleChildWithSubChilds"


    // $ANTLR start "ruleChildWithSubChilds"
    // InternalPartialSerializationTestLanguage.g:738:1: ruleChildWithSubChilds returns [EObject current=null] : ( () ( (lv_children_1_0= ruleChildWithSubChild ) )* ) ;
    public final EObject ruleChildWithSubChilds() throws RecognitionException {
        EObject current = null;

        EObject lv_children_1_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:744:2: ( ( () ( (lv_children_1_0= ruleChildWithSubChild ) )* ) )
            // InternalPartialSerializationTestLanguage.g:745:2: ( () ( (lv_children_1_0= ruleChildWithSubChild ) )* )
            {
            // InternalPartialSerializationTestLanguage.g:745:2: ( () ( (lv_children_1_0= ruleChildWithSubChild ) )* )
            // InternalPartialSerializationTestLanguage.g:746:3: () ( (lv_children_1_0= ruleChildWithSubChild ) )*
            {
            // InternalPartialSerializationTestLanguage.g:746:3: ()
            // InternalPartialSerializationTestLanguage.g:747:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getChildWithSubChildsAccess().getChildWithSubChildsAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:753:3: ( (lv_children_1_0= ruleChildWithSubChild ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==34) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:754:4: (lv_children_1_0= ruleChildWithSubChild )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:754:4: (lv_children_1_0= ruleChildWithSubChild )
            	    // InternalPartialSerializationTestLanguage.g:755:5: lv_children_1_0= ruleChildWithSubChild
            	    {

            	    					newCompositeNode(grammarAccess.getChildWithSubChildsAccess().getChildrenChildWithSubChildParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_children_1_0=ruleChildWithSubChild();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getChildWithSubChildsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"children",
            	    						lv_children_1_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.ChildWithSubChild");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
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
    // $ANTLR end "ruleChildWithSubChilds"


    // $ANTLR start "entryRuleChildWithSubChild"
    // InternalPartialSerializationTestLanguage.g:776:1: entryRuleChildWithSubChild returns [EObject current=null] : iv_ruleChildWithSubChild= ruleChildWithSubChild EOF ;
    public final EObject entryRuleChildWithSubChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildWithSubChild = null;


        try {
            // InternalPartialSerializationTestLanguage.g:776:58: (iv_ruleChildWithSubChild= ruleChildWithSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:777:2: iv_ruleChildWithSubChild= ruleChildWithSubChild EOF
            {
             newCompositeNode(grammarAccess.getChildWithSubChildRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChildWithSubChild=ruleChildWithSubChild();

            state._fsp--;

             current =iv_ruleChildWithSubChild; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleChildWithSubChild"


    // $ANTLR start "ruleChildWithSubChild"
    // InternalPartialSerializationTestLanguage.g:783:1: ruleChildWithSubChild returns [EObject current=null] : ( () otherlv_1= 'subs' ( (lv_subChilds_2_0= ruleSubChild ) )* ) ;
    public final EObject ruleChildWithSubChild() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subChilds_2_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:789:2: ( ( () otherlv_1= 'subs' ( (lv_subChilds_2_0= ruleSubChild ) )* ) )
            // InternalPartialSerializationTestLanguage.g:790:2: ( () otherlv_1= 'subs' ( (lv_subChilds_2_0= ruleSubChild ) )* )
            {
            // InternalPartialSerializationTestLanguage.g:790:2: ( () otherlv_1= 'subs' ( (lv_subChilds_2_0= ruleSubChild ) )* )
            // InternalPartialSerializationTestLanguage.g:791:3: () otherlv_1= 'subs' ( (lv_subChilds_2_0= ruleSubChild ) )*
            {
            // InternalPartialSerializationTestLanguage.g:791:3: ()
            // InternalPartialSerializationTestLanguage.g:792:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getChildWithSubChildAccess().getChildWithSubChildAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getChildWithSubChildAccess().getSubsKeyword_1());
            		
            // InternalPartialSerializationTestLanguage.g:802:3: ( (lv_subChilds_2_0= ruleSubChild ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:803:4: (lv_subChilds_2_0= ruleSubChild )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:803:4: (lv_subChilds_2_0= ruleSubChild )
            	    // InternalPartialSerializationTestLanguage.g:804:5: lv_subChilds_2_0= ruleSubChild
            	    {

            	    					newCompositeNode(grammarAccess.getChildWithSubChildAccess().getSubChildsSubChildParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_subChilds_2_0=ruleSubChild();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getChildWithSubChildRule());
            	    					}
            	    					add(
            	    						current,
            	    						"subChilds",
            	    						lv_subChilds_2_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.SubChild");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
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
    // $ANTLR end "ruleChildWithSubChild"


    // $ANTLR start "entryRuleSubChild"
    // InternalPartialSerializationTestLanguage.g:825:1: entryRuleSubChild returns [EObject current=null] : iv_ruleSubChild= ruleSubChild EOF ;
    public final EObject entryRuleSubChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubChild = null;


        try {
            // InternalPartialSerializationTestLanguage.g:825:49: (iv_ruleSubChild= ruleSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:826:2: iv_ruleSubChild= ruleSubChild EOF
            {
             newCompositeNode(grammarAccess.getSubChildRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubChild=ruleSubChild();

            state._fsp--;

             current =iv_ruleSubChild; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSubChild"


    // $ANTLR start "ruleSubChild"
    // InternalPartialSerializationTestLanguage.g:832:1: ruleSubChild returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSubChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:838:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPartialSerializationTestLanguage.g:839:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPartialSerializationTestLanguage.g:839:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:840:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:840:3: (lv_name_0_0= RULE_ID )
            // InternalPartialSerializationTestLanguage.g:841:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getSubChildAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSubChildRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleSubChild"


    // $ANTLR start "entryRuleMandatoryChildList"
    // InternalPartialSerializationTestLanguage.g:860:1: entryRuleMandatoryChildList returns [EObject current=null] : iv_ruleMandatoryChildList= ruleMandatoryChildList EOF ;
    public final EObject entryRuleMandatoryChildList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryChildList = null;


        try {
            // InternalPartialSerializationTestLanguage.g:860:59: (iv_ruleMandatoryChildList= ruleMandatoryChildList EOF )
            // InternalPartialSerializationTestLanguage.g:861:2: iv_ruleMandatoryChildList= ruleMandatoryChildList EOF
            {
             newCompositeNode(grammarAccess.getMandatoryChildListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMandatoryChildList=ruleMandatoryChildList();

            state._fsp--;

             current =iv_ruleMandatoryChildList; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMandatoryChildList"


    // $ANTLR start "ruleMandatoryChildList"
    // InternalPartialSerializationTestLanguage.g:867:1: ruleMandatoryChildList returns [EObject current=null] : ( (lv_children_0_0= ruleMandatoryValue ) )+ ;
    public final EObject ruleMandatoryChildList() throws RecognitionException {
        EObject current = null;

        EObject lv_children_0_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:873:2: ( ( (lv_children_0_0= ruleMandatoryValue ) )+ )
            // InternalPartialSerializationTestLanguage.g:874:2: ( (lv_children_0_0= ruleMandatoryValue ) )+
            {
            // InternalPartialSerializationTestLanguage.g:874:2: ( (lv_children_0_0= ruleMandatoryValue ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:875:3: (lv_children_0_0= ruleMandatoryValue )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:875:3: (lv_children_0_0= ruleMandatoryValue )
            	    // InternalPartialSerializationTestLanguage.g:876:4: lv_children_0_0= ruleMandatoryValue
            	    {

            	    				newCompositeNode(grammarAccess.getMandatoryChildListAccess().getChildrenMandatoryValueParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_6);
            	    lv_children_0_0=ruleMandatoryValue();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getMandatoryChildListRule());
            	    				}
            	    				add(
            	    					current,
            	    					"children",
            	    					lv_children_0_0,
            	    					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
            	    				afterParserOrEnumRuleCall();
            	    			

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
    // $ANTLR end "ruleMandatoryChildList"


    // $ANTLR start "entryRuleOptionalChildList"
    // InternalPartialSerializationTestLanguage.g:896:1: entryRuleOptionalChildList returns [EObject current=null] : iv_ruleOptionalChildList= ruleOptionalChildList EOF ;
    public final EObject entryRuleOptionalChildList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalChildList = null;


        try {
            // InternalPartialSerializationTestLanguage.g:896:58: (iv_ruleOptionalChildList= ruleOptionalChildList EOF )
            // InternalPartialSerializationTestLanguage.g:897:2: iv_ruleOptionalChildList= ruleOptionalChildList EOF
            {
             newCompositeNode(grammarAccess.getOptionalChildListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalChildList=ruleOptionalChildList();

            state._fsp--;

             current =iv_ruleOptionalChildList; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptionalChildList"


    // $ANTLR start "ruleOptionalChildList"
    // InternalPartialSerializationTestLanguage.g:903:1: ruleOptionalChildList returns [EObject current=null] : ( () ( (lv_children_1_0= ruleMandatoryValue ) )* ) ;
    public final EObject ruleOptionalChildList() throws RecognitionException {
        EObject current = null;

        EObject lv_children_1_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:909:2: ( ( () ( (lv_children_1_0= ruleMandatoryValue ) )* ) )
            // InternalPartialSerializationTestLanguage.g:910:2: ( () ( (lv_children_1_0= ruleMandatoryValue ) )* )
            {
            // InternalPartialSerializationTestLanguage.g:910:2: ( () ( (lv_children_1_0= ruleMandatoryValue ) )* )
            // InternalPartialSerializationTestLanguage.g:911:3: () ( (lv_children_1_0= ruleMandatoryValue ) )*
            {
            // InternalPartialSerializationTestLanguage.g:911:3: ()
            // InternalPartialSerializationTestLanguage.g:912:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:918:3: ( (lv_children_1_0= ruleMandatoryValue ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:919:4: (lv_children_1_0= ruleMandatoryValue )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:919:4: (lv_children_1_0= ruleMandatoryValue )
            	    // InternalPartialSerializationTestLanguage.g:920:5: lv_children_1_0= ruleMandatoryValue
            	    {

            	    					newCompositeNode(grammarAccess.getOptionalChildListAccess().getChildrenMandatoryValueParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_children_1_0=ruleMandatoryValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOptionalChildListRule());
            	    					}
            	    					add(
            	    						current,
            	    						"children",
            	    						lv_children_1_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
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
    // $ANTLR end "ruleOptionalChildList"


    // $ANTLR start "entryRuleImport"
    // InternalPartialSerializationTestLanguage.g:941:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalPartialSerializationTestLanguage.g:941:47: (iv_ruleImport= ruleImport EOF )
            // InternalPartialSerializationTestLanguage.g:942:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalPartialSerializationTestLanguage.g:948:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:954:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) )
            // InternalPartialSerializationTestLanguage.g:955:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            {
            // InternalPartialSerializationTestLanguage.g:955:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:956:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalPartialSerializationTestLanguage.g:960:3: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:961:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // InternalPartialSerializationTestLanguage.g:961:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:962:5: lv_importedNamespace_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importedNamespace",
            						lv_importedNamespace_1_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.QualifiedName");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleNode"
    // InternalPartialSerializationTestLanguage.g:983:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalPartialSerializationTestLanguage.g:983:45: (iv_ruleNode= ruleNode EOF )
            // InternalPartialSerializationTestLanguage.g:984:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalPartialSerializationTestLanguage.g:990:1: ruleNode returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )? ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_imports_1_0 = null;

        EObject lv_children_6_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:996:2: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )? ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalPartialSerializationTestLanguage.g:997:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )? ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalPartialSerializationTestLanguage.g:997:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )? ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalPartialSerializationTestLanguage.g:998:3: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )? ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' )
            {
            // InternalPartialSerializationTestLanguage.g:998:3: ()
            // InternalPartialSerializationTestLanguage.g:999:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeAccess().getNodeAction_0(),
            					current);
            			

            }

            // InternalPartialSerializationTestLanguage.g:1005:3: ( (lv_imports_1_0= ruleImport ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==35) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1006:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalPartialSerializationTestLanguage.g:1006:4: (lv_imports_1_0= ruleImport )
            	    // InternalPartialSerializationTestLanguage.g:1007:5: lv_imports_1_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getNodeAccess().getImportsImportParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNodeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_1_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalPartialSerializationTestLanguage.g:1024:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1025:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalPartialSerializationTestLanguage.g:1025:4: (lv_name_2_0= RULE_ID )
                    // InternalPartialSerializationTestLanguage.g:1026:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNodeRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalPartialSerializationTestLanguage.g:1042:3: (otherlv_3= 'refs' ( ( ruleQualifiedName ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1043:4: otherlv_3= 'refs' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_19); 

                    				newLeafNode(otherlv_3, grammarAccess.getNodeAccess().getRefsKeyword_3_0());
                    			
                    // InternalPartialSerializationTestLanguage.g:1047:4: ( ( ruleQualifiedName ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalPartialSerializationTestLanguage.g:1048:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalPartialSerializationTestLanguage.g:1048:5: ( ruleQualifiedName )
                    	    // InternalPartialSerializationTestLanguage.g:1049:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalPartialSerializationTestLanguage.g:1064:3: ( (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) | otherlv_10= ';' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            else if ( (LA21_0==38) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1065:4: (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
                    {
                    // InternalPartialSerializationTestLanguage.g:1065:4: (otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
                    // InternalPartialSerializationTestLanguage.g:1066:5: otherlv_5= '{' ( (lv_children_6_0= ruleNode ) )* (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )? otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_20); 

                    					newLeafNode(otherlv_5, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0());
                    				
                    // InternalPartialSerializationTestLanguage.g:1070:5: ( (lv_children_6_0= ruleNode ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID||LA19_0==28||(LA19_0>=35 && LA19_0<=36)||LA19_0==38) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalPartialSerializationTestLanguage.g:1071:6: (lv_children_6_0= ruleNode )
                    	    {
                    	    // InternalPartialSerializationTestLanguage.g:1071:6: (lv_children_6_0= ruleNode )
                    	    // InternalPartialSerializationTestLanguage.g:1072:7: lv_children_6_0= ruleNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_children_6_0=ruleNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"children",
                    	    								lv_children_6_0,
                    	    								"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.Node");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // InternalPartialSerializationTestLanguage.g:1089:5: (otherlv_7= 'ref' ( ( ruleQualifiedName ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==37) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalPartialSerializationTestLanguage.g:1090:6: otherlv_7= 'ref' ( ( ruleQualifiedName ) )
                            {
                            otherlv_7=(Token)match(input,37,FOLLOW_4); 

                            						newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0());
                            					
                            // InternalPartialSerializationTestLanguage.g:1094:6: ( ( ruleQualifiedName ) )
                            // InternalPartialSerializationTestLanguage.g:1095:7: ( ruleQualifiedName )
                            {
                            // InternalPartialSerializationTestLanguage.g:1095:7: ( ruleQualifiedName )
                            // InternalPartialSerializationTestLanguage.g:1096:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getNodeRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0());
                            							
                            pushFollow(FOLLOW_13);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalPartialSerializationTestLanguage.g:1117:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getSemicolonKeyword_4_1());
                    			

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
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalPartialSerializationTestLanguage.g:1126:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalPartialSerializationTestLanguage.g:1126:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalPartialSerializationTestLanguage.g:1127:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalPartialSerializationTestLanguage.g:1133:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:1139:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalPartialSerializationTestLanguage.g:1140:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalPartialSerializationTestLanguage.g:1140:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalPartialSerializationTestLanguage.g:1141:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalPartialSerializationTestLanguage.g:1148:3: (kw= '.' this_ID_2= RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==39) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1149:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,39,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop22;
                }
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleEClassDecl"
    // InternalPartialSerializationTestLanguage.g:1166:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // InternalPartialSerializationTestLanguage.g:1166:51: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // InternalPartialSerializationTestLanguage.g:1167:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             newCompositeNode(grammarAccess.getEClassDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEClassDecl=ruleEClassDecl();

            state._fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEClassDecl"


    // $ANTLR start "ruleEClassDecl"
    // InternalPartialSerializationTestLanguage.g:1173:1: ruleEClassDecl returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEClassDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:1179:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPartialSerializationTestLanguage.g:1180:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPartialSerializationTestLanguage.g:1180:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1181:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1181:3: (lv_name_0_0= RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1182:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEClassDeclRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleEClassDecl"


    // $ANTLR start "entryRuleEClassRef"
    // InternalPartialSerializationTestLanguage.g:1201:1: entryRuleEClassRef returns [EObject current=null] : iv_ruleEClassRef= ruleEClassRef EOF ;
    public final EObject entryRuleEClassRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassRef = null;


        try {
            // InternalPartialSerializationTestLanguage.g:1201:50: (iv_ruleEClassRef= ruleEClassRef EOF )
            // InternalPartialSerializationTestLanguage.g:1202:2: iv_ruleEClassRef= ruleEClassRef EOF
            {
             newCompositeNode(grammarAccess.getEClassRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEClassRef=ruleEClassRef();

            state._fsp--;

             current =iv_ruleEClassRef; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEClassRef"


    // $ANTLR start "ruleEClassRef"
    // InternalPartialSerializationTestLanguage.g:1208:1: ruleEClassRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleEClassRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:1214:2: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:1215:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:1215:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:1216:3: ( ruleQualifiedName )
            {
            // InternalPartialSerializationTestLanguage.g:1216:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:1217:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEClassRefRule());
            				}
            			

            				newCompositeNode(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleEClassRef"


    // $ANTLR start "entryRuleWithTransientContainer"
    // InternalPartialSerializationTestLanguage.g:1234:1: entryRuleWithTransientContainer returns [EObject current=null] : iv_ruleWithTransientContainer= ruleWithTransientContainer EOF ;
    public final EObject entryRuleWithTransientContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithTransientContainer = null;


        try {
            // InternalPartialSerializationTestLanguage.g:1234:63: (iv_ruleWithTransientContainer= ruleWithTransientContainer EOF )
            // InternalPartialSerializationTestLanguage.g:1235:2: iv_ruleWithTransientContainer= ruleWithTransientContainer EOF
            {
             newCompositeNode(grammarAccess.getWithTransientContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWithTransientContainer=ruleWithTransientContainer();

            state._fsp--;

             current =iv_ruleWithTransientContainer; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWithTransientContainer"


    // $ANTLR start "ruleWithTransientContainer"
    // InternalPartialSerializationTestLanguage.g:1241:1: ruleWithTransientContainer returns [EObject current=null] : ( (lv_child_0_0= ruleWithTransient ) ) ;
    public final EObject ruleWithTransientContainer() throws RecognitionException {
        EObject current = null;

        EObject lv_child_0_0 = null;



        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:1247:2: ( ( (lv_child_0_0= ruleWithTransient ) ) )
            // InternalPartialSerializationTestLanguage.g:1248:2: ( (lv_child_0_0= ruleWithTransient ) )
            {
            // InternalPartialSerializationTestLanguage.g:1248:2: ( (lv_child_0_0= ruleWithTransient ) )
            // InternalPartialSerializationTestLanguage.g:1249:3: (lv_child_0_0= ruleWithTransient )
            {
            // InternalPartialSerializationTestLanguage.g:1249:3: (lv_child_0_0= ruleWithTransient )
            // InternalPartialSerializationTestLanguage.g:1250:4: lv_child_0_0= ruleWithTransient
            {

            				newCompositeNode(grammarAccess.getWithTransientContainerAccess().getChildWithTransientParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_child_0_0=ruleWithTransient();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getWithTransientContainerRule());
            				}
            				set(
            					current,
            					"child",
            					lv_child_0_0,
            					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.WithTransient");
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
    // $ANTLR end "ruleWithTransientContainer"


    // $ANTLR start "entryRuleWithTransient"
    // InternalPartialSerializationTestLanguage.g:1270:1: entryRuleWithTransient returns [EObject current=null] : iv_ruleWithTransient= ruleWithTransient EOF ;
    public final EObject entryRuleWithTransient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithTransient = null;


        try {
            // InternalPartialSerializationTestLanguage.g:1270:54: (iv_ruleWithTransient= ruleWithTransient EOF )
            // InternalPartialSerializationTestLanguage.g:1271:2: iv_ruleWithTransient= ruleWithTransient EOF
            {
             newCompositeNode(grammarAccess.getWithTransientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWithTransient=ruleWithTransient();

            state._fsp--;

             current =iv_ruleWithTransient; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWithTransient"


    // $ANTLR start "ruleWithTransient"
    // InternalPartialSerializationTestLanguage.g:1277:1: ruleWithTransient returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleWithTransient() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPartialSerializationTestLanguage.g:1283:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPartialSerializationTestLanguage.g:1284:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPartialSerializationTestLanguage.g:1284:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1285:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1285:3: (lv_name_0_0= RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1286:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getWithTransientAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getWithTransientRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleWithTransient"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000005810000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000C000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000012L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000005010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000004010000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000007850000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000002L});

}