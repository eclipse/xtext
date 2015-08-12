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

@SuppressWarnings("all")
public class InternalContextFinderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#0'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'model'", "'kw1'", "'kw2'", "'.'", "'foo'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalContextFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContextFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContextFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:28: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:2: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:2: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:4: otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitZeroKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:85:1: ( (lv_model_1_0= ruleModel2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:86:1: (lv_model_1_0= ruleModel2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:86:1: (lv_model_1_0= ruleModel2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:87:3: lv_model_1_0= ruleModel2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getModelModel2ParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleModel2_in_ruleModel144);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:104:6: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:104:6: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:104:8: otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel164); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:108:1: ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:109:1: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:109:1: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:110:1: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:110:1: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:111:3: lv_attributeExclusion_3_1= ruleAttributeExclusionTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_ruleModel187);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:126:8: lv_attributeExclusion_3_2= ruleAttributeExclusionTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_ruleModel206);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:145:6: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:145:6: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:145:8: otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel229); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:149:1: ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:150:1: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:150:1: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:151:1: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:151:1: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:152:3: lv_nestedType_5_1= ruleNestedTypeTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_ruleModel252);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:167:8: lv_nestedType_5_2= ruleNestedTypeTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_ruleModel271);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:186:6: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:186:6: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:186:8: otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel294); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:190:1: ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:191:1: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:191:1: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:192:1: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:192:1: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:193:3: lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel317);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:208:8: lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel336);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:227:6: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:227:6: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:227:8: otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel359); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:231:1: ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:232:1: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:232:1: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:233:1: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:233:1: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:234:3: lv_parentRef_9_1= ruleParentRefTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getParentRefParentRefTest1ParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_ruleModel382);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:249:8: lv_parentRef_9_2= ruleParentRefTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getParentRefParentRefTest2ParserRuleCall_4_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_ruleModel401);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:268:6: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:268:6: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:268:8: otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel424); 

                        	newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:272:1: ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:273:1: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:273:1: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:274:1: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:274:1: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:275:3: lv_quantityExclusion_11_1= ruleQuantityExclusionTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getQuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest1_in_ruleModel447);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:290:8: lv_quantityExclusion_11_2= ruleQuantityExclusionTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getQuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest2_in_ruleModel466);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:309:6: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:309:6: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:309:8: otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    {
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel489); 

                        	newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitSixKeyword_6_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:313:1: ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:314:1: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:314:1: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:315:1: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:315:1: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:316:3: lv_valueExclusion_13_1= ruleValueExclusionTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest1_in_ruleModel512);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:331:8: lv_valueExclusion_13_2= ruleValueExclusionTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest2_in_ruleModel531);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:350:6: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:350:6: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:350:8: otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    {
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel554); 

                        	newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitSevenKeyword_7_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:354:1: ( (lv_name_15_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:355:1: (lv_name_15_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:355:1: (lv_name_15_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:356:3: lv_name_15_0= RULE_STRING
                    {
                    lv_name_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel571); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:372:2: ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:373:1: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:373:1: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:374:1: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:374:1: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:375:3: lv_nodeExclusion_16_1= ruleNodeExclusion1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1_in_ruleModel599);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:390:8: lv_nodeExclusion_16_2= ruleNodeExclusion2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2_in_ruleModel618);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:409:6: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:409:6: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:409:8: otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel641); 

                        	newLeafNode(otherlv_17, grammarAccess.getModelAccess().getNumberSignDigitEightKeyword_8_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:413:1: ( (lv_name_18_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:414:1: (lv_name_18_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:414:1: (lv_name_18_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:415:3: lv_name_18_0= RULE_STRING
                    {
                    lv_name_18_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel658); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:431:2: ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:1: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:1: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:433:1: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:433:1: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:434:3: lv_nodeExclusionList_19_1= ruleNodeExclusion1List
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1List_in_ruleModel686);
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:449:8: lv_nodeExclusionList_19_2= ruleNodeExclusion2List
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2List_in_ruleModel705);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:1: entryRuleModel2 returns [EObject current=null] : iv_ruleModel2= ruleModel2 EOF ;
    public final EObject entryRuleModel2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:476:2: (iv_ruleModel2= ruleModel2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:477:2: iv_ruleModel2= ruleModel2 EOF
            {
             newCompositeNode(grammarAccess.getModel2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel2_in_entryRuleModel2745);
            iv_ruleModel2=ruleModel2();

            state._fsp--;

             current =iv_ruleModel2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel2755); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:484:1: ruleModel2 returns [EObject current=null] : ( () otherlv_1= 'model' ) ;
    public final EObject ruleModel2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:487:28: ( ( () otherlv_1= 'model' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:1: ( () otherlv_1= 'model' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:1: ( () otherlv_1= 'model' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:2: () otherlv_1= 'model'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:489:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModel2Access().getModelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel2801); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:506:1: entryRuleAttributeExclusionTest1 returns [EObject current=null] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final EObject entryRuleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:507:2: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:508:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1837);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest1847); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:515:1: ruleAttributeExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:518:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:519:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:519:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:519:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttributeExclusionTest1884); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:523:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:524:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:524:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:525:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1901); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:549:1: entryRuleAttributeExclusionTest2 returns [EObject current=null] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final EObject entryRuleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:550:2: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:551:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2942);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest2952); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:558:1: ruleAttributeExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:561:28: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:562:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:562:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:562:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAttributeExclusionTest2989); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:566:1: ( (lv_attr2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:567:1: (lv_attr2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:567:1: (lv_attr2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:568:3: lv_attr2_1_0= RULE_ID
            {
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest21006); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:592:1: entryRuleNestedTypeTest1 returns [EObject current=null] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final EObject entryRuleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:593:2: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:594:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest11047);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest11057); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:601:1: ruleNestedTypeTest1 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final EObject ruleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:604:28: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:605:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:605:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:606:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:606:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:607:3: lv_nested_0_0= ruleNestedTypeChild1
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest11102);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:631:1: entryRuleNestedTypeTest2 returns [EObject current=null] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final EObject entryRuleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:632:2: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:633:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest21137);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest21147); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:640:1: ruleNestedTypeTest2 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final EObject ruleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:643:28: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:644:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:644:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:645:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:645:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:646:3: lv_nested_0_0= ruleNestedTypeChild2
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21192);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:672:1: entryRuleNestedTypeChild1 returns [EObject current=null] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final EObject entryRuleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:673:2: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:674:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11229);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild11239); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:681:1: ruleNestedTypeChild1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:684:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:685:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:685:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:685:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeChild11276); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:689:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:690:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:690:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:691:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild11293); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:715:1: entryRuleNestedTypeChild2 returns [EObject current=null] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final EObject entryRuleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:716:2: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:717:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21334);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild21344); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:724:1: ruleNestedTypeChild2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:727:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:728:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:728:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:728:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNestedTypeChild21381); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:732:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:733:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:733:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:734:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild21398); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:758:1: entryRuleNestedTypeRecursiveTest1 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:759:2: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:760:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11439);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11449); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:767:1: ruleNestedTypeRecursiveTest1 returns [EObject current=null] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:770:28: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:771:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:771:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:771:2: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:771:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:772:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeRecursiveTest11495); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:781:1: ( () otherlv_3= '.' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:781:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:781:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:782:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedTypeRecursiveTest11517); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:799:1: entryRuleNestedTypeRecursiveTest2 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:800:2: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:801:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21555);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21565); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:808:1: ruleNestedTypeRecursiveTest2 returns [EObject current=null] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:811:28: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:812:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:812:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:812:2: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:812:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:813:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNestedTypeRecursiveTest21611); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:822:1: ( () otherlv_3= '.' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:822:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:822:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:823:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedTypeRecursiveTest21633); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:840:1: entryRuleParentRefTest1 returns [EObject current=null] : iv_ruleParentRefTest1= ruleParentRefTest1 EOF ;
    public final EObject entryRuleParentRefTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:841:2: (iv_ruleParentRefTest1= ruleParentRefTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:842:2: iv_ruleParentRefTest1= ruleParentRefTest1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11671);
            iv_ruleParentRefTest1=ruleParentRefTest1();

            state._fsp--;

             current =iv_ruleParentRefTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest11681); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:849:1: ruleParentRefTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final EObject ruleParentRefTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child1_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:852:28: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:853:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:853:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:853:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParentRefTest11718); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:857:1: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:858:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:858:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:859:3: lv_child1_1_0= ruleParentRefTestChild1
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest1Access().getChild1ParentRefTestChild1ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11739);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:883:1: entryRuleParentRefTest2 returns [EObject current=null] : iv_ruleParentRefTest2= ruleParentRefTest2 EOF ;
    public final EObject entryRuleParentRefTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:884:2: (iv_ruleParentRefTest2= ruleParentRefTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:885:2: iv_ruleParentRefTest2= ruleParentRefTest2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21775);
            iv_ruleParentRefTest2=ruleParentRefTest2();

            state._fsp--;

             current =iv_ruleParentRefTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest21785); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:892:1: ruleParentRefTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final EObject ruleParentRefTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child2_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:895:28: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:896:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:896:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:896:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParentRefTest21822); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:900:1: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:901:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:901:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:902:3: lv_child2_1_0= ruleParentRefTestChild2
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest2Access().getChild2ParentRefTestChild2ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21843);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:926:1: entryRuleParentRefTestChild1 returns [EObject current=null] : iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF ;
    public final EObject entryRuleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:927:2: (iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:928:2: iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11879);
            iv_ruleParentRefTestChild1=ruleParentRefTestChild1();

            state._fsp--;

             current =iv_ruleParentRefTestChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild11889); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:935:1: ruleParentRefTestChild1 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final EObject ruleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:938:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:939:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:939:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:939:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:939:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:940:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild1Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParentRefTestChild11935); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild1Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:949:1: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:950:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:950:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:951:3: lv_child_2_0= ruleParentRefTestChild1
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild1Access().getChildParentRefTestChild1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11956);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:975:1: entryRuleParentRefTestChild2 returns [EObject current=null] : iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF ;
    public final EObject entryRuleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:976:2: (iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:977:2: iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21993);
            iv_ruleParentRefTestChild2=ruleParentRefTestChild2();

            state._fsp--;

             current =iv_ruleParentRefTestChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild22003); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:984:1: ruleParentRefTestChild2 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final EObject ruleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:987:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:988:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:988:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:988:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:988:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:989:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild2Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParentRefTestChild22049); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild2Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:998:1: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:999:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:999:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1000:3: lv_child_2_0= ruleParentRefTestChild2
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild2Access().getChildParentRefTestChild2ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild22070);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1024:1: entryRuleQuantityExclusionTest1 returns [EObject current=null] : iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF ;
    public final EObject entryRuleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1025:2: (iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1026:2: iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest12107);
            iv_ruleQuantityExclusionTest1=ruleQuantityExclusionTest1();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest12117); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1033:1: ruleQuantityExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) ;
    public final EObject ruleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1036:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1037:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1037:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1037:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleQuantityExclusionTest12154); 

                	newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1041:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1042:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1042:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1043:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12171); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1059:2: ( (lv_attr2_2_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1060:1: (lv_attr2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1060:1: (lv_attr2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1061:3: lv_attr2_2_0= RULE_ID
                    {
                    lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12193); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1085:1: entryRuleQuantityExclusionTest2 returns [EObject current=null] : iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF ;
    public final EObject entryRuleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1086:2: (iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1087:2: iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22235);
            iv_ruleQuantityExclusionTest2=ruleQuantityExclusionTest2();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest22245); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1094:1: ruleQuantityExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1097:28: ( (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1098:1: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1098:1: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1098:3: otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQuantityExclusionTest22282); 

                	newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1102:1: ( (lv_attr1_1_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1103:1: (lv_attr1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1103:1: (lv_attr1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1104:3: lv_attr1_1_0= RULE_ID
                    {
                    lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22299); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1120:3: ( (lv_attr2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1121:1: (lv_attr2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1121:1: (lv_attr2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1122:3: lv_attr2_2_0= RULE_ID
            {
            lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22322); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1146:1: entryRuleValueExclusionTest1 returns [EObject current=null] : iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF ;
    public final EObject entryRuleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1147:2: (iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1148:2: iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12363);
            iv_ruleValueExclusionTest1=ruleValueExclusionTest1();

            state._fsp--;

             current =iv_ruleValueExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest12373); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1155:1: ruleValueExclusionTest1 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) ;
    public final EObject ruleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1158:28: ( ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1159:1: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1159:1: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1160:1: (lv_val_0_0= ruleValueExclusionTestEn1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1160:1: (lv_val_0_0= ruleValueExclusionTestEn1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1161:3: lv_val_0_0= ruleValueExclusionTestEn1
            {
             
            	        newCompositeNode(grammarAccess.getValueExclusionTest1Access().getValValueExclusionTestEn1EnumRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12418);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1185:1: entryRuleValueExclusionTest2 returns [EObject current=null] : iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF ;
    public final EObject entryRuleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1186:2: (iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1187:2: iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22453);
            iv_ruleValueExclusionTest2=ruleValueExclusionTest2();

            state._fsp--;

             current =iv_ruleValueExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest22463); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1194:1: ruleValueExclusionTest2 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) ;
    public final EObject ruleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1197:28: ( ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1198:1: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1198:1: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1199:1: (lv_val_0_0= ruleValueExclusionTestEn2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1199:1: (lv_val_0_0= ruleValueExclusionTestEn2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1200:3: lv_val_0_0= ruleValueExclusionTestEn2
            {
             
            	        newCompositeNode(grammarAccess.getValueExclusionTest2Access().getValValueExclusionTestEn2EnumRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22508);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1224:1: entryRuleNodeExclusion1 returns [EObject current=null] : iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF ;
    public final EObject entryRuleNodeExclusion1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1225:2: (iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1226:2: iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1_in_entryRuleNodeExclusion12543);
            iv_ruleNodeExclusion1=ruleNodeExclusion1();

            state._fsp--;

             current =iv_ruleNodeExclusion1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion12553); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1233:1: ruleNodeExclusion1 returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleNodeExclusion1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1236:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1237:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1237:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1238:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1238:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1239:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeExclusion1Rule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNodeExclusion12597); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1258:1: entryRuleNodeExclusion2 returns [EObject current=null] : iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF ;
    public final EObject entryRuleNodeExclusion2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1259:2: (iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1260:2: iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2_in_entryRuleNodeExclusion22632);
            iv_ruleNodeExclusion2=ruleNodeExclusion2();

            state._fsp--;

             current =iv_ruleNodeExclusion2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion22642); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1267:1: ruleNodeExclusion2 returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) ) ;
    public final EObject ruleNodeExclusion2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1270:28: ( ( (otherlv_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1271:1: ( (otherlv_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1271:1: ( (otherlv_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1272:1: (otherlv_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1272:1: (otherlv_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1273:3: otherlv_0= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeExclusion2Rule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNodeExclusion22686); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1292:1: entryRuleNodeExclusion1List returns [EObject current=null] : iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF ;
    public final EObject entryRuleNodeExclusion1List() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion1List = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1293:2: (iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1294:2: iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion1ListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1List_in_entryRuleNodeExclusion1List2721);
            iv_ruleNodeExclusion1List=ruleNodeExclusion1List();

            state._fsp--;

             current =iv_ruleNodeExclusion1List; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion1List2731); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1301:1: ruleNodeExclusion1List returns [EObject current=null] : ( (otherlv_0= RULE_ID ) )+ ;
    public final EObject ruleNodeExclusion1List() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1304:28: ( ( (otherlv_0= RULE_ID ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1305:1: ( (otherlv_0= RULE_ID ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1305:1: ( (otherlv_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1306:1: (otherlv_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1306:1: (otherlv_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1307:3: otherlv_0= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getNodeExclusion1ListRule());
            	    	        }
            	            
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNodeExclusion1List2775); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1326:1: entryRuleNodeExclusion2List returns [EObject current=null] : iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF ;
    public final EObject entryRuleNodeExclusion2List() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeExclusion2List = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1327:2: (iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1328:2: iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF
            {
             newCompositeNode(grammarAccess.getNodeExclusion2ListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2List_in_entryRuleNodeExclusion2List2811);
            iv_ruleNodeExclusion2List=ruleNodeExclusion2List();

            state._fsp--;

             current =iv_ruleNodeExclusion2List; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion2List2821); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1335:1: ruleNodeExclusion2List returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) )+ ;
    public final EObject ruleNodeExclusion2List() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1338:28: ( ( (otherlv_0= RULE_STRING ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1339:1: ( (otherlv_0= RULE_STRING ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1339:1: ( (otherlv_0= RULE_STRING ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1340:1: (otherlv_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1340:1: (otherlv_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1341:3: otherlv_0= RULE_STRING
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getNodeExclusion2ListRule());
            	    	        }
            	            
            	    otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNodeExclusion2List2865); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1362:1: ruleValueExclusionTestEn1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleValueExclusionTestEn1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1364:28: ( (enumLiteral_0= 'lit1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1365:1: (enumLiteral_0= 'lit1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1365:1: (enumLiteral_0= 'lit1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1365:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleValueExclusionTestEn12916); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1375:1: ruleValueExclusionTestEn2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleValueExclusionTestEn2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1377:28: ( (enumLiteral_0= 'lit2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1378:1: (enumLiteral_0= 'lit2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1378:1: (enumLiteral_0= 'lit2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1378:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleValueExclusionTestEn22959); 

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleModel2_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel164 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_ruleModel187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_ruleModel206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel229 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_ruleModel252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_ruleModel271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel294 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel359 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_ruleModel382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel424 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_ruleModel447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_ruleModel466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel489 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_ruleModel512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_ruleModel531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel554 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel571 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNodeExclusion1_in_ruleModel599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2_in_ruleModel618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel641 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel658 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNodeExclusion1List_in_ruleModel686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2List_in_ruleModel705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel2_in_entryRuleModel2745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel2755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel2801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAttributeExclusionTest1884 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAttributeExclusionTest2989 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest21006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest11047 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest11057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest11102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest21137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest21147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11229 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild11239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeChild11276 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild11293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild21344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNestedTypeChild21381 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild21398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11439 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeRecursiveTest11495 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedTypeRecursiveTest11517 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21555 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNestedTypeRecursiveTest21611 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedTypeRecursiveTest21633 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest11681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParentRefTest11718 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21775 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest21785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParentRefTest21822 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11879 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild11889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleParentRefTestChild11935 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild22003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleParentRefTestChild22049 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild22070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest12107 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest12117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleQuantityExclusionTest12154 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12171 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest22245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleQuantityExclusionTest22282 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22299 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest12373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22453 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest22463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion1_in_entryRuleNodeExclusion12543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion12553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNodeExclusion12597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2_in_entryRuleNodeExclusion22632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion22642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNodeExclusion22686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion1List_in_entryRuleNodeExclusion1List2721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion1List2731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNodeExclusion1List2775 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleNodeExclusion2List_in_entryRuleNodeExclusion2List2811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion2List2821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNodeExclusion2List2865 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_25_in_ruleValueExclusionTestEn12916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleValueExclusionTestEn22959 = new BitSet(new long[]{0x0000000000000002L});
    }


}