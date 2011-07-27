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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#0'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'model'", "'kw1'", "'kw2'", "'.'", "'foo'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:28: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:81:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            case 15:
                {
                alt7=5;
                }
                break;
            case 16:
                {
                alt7=6;
                }
                break;
            case 17:
                {
                alt7=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
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
                            		"Model2");
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

                    if ( (LA1_0==19) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==20) ) {
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
                                    		"AttributeExclusionTest1");
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
                                    		"AttributeExclusionTest2");
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

                    if ( (LA2_0==19) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==20) ) {
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
                                    		"NestedTypeTest1");
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
                                    		"NestedTypeTest2");
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

                    if ( (LA3_0==19) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==20) ) {
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
                                    		"NestedTypeRecursiveTest1");
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
                                    		"NestedTypeRecursiveTest2");
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

                    if ( (LA4_0==19) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==20) ) {
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
                                    		"ParentRefTest1");
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
                                    		"ParentRefTest2");
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

                    if ( (LA5_0==19) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==20) ) {
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
                                    		"QuantityExclusionTest1");
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
                                    		"QuantityExclusionTest2");
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

                    if ( (LA6_0==23) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==24) ) {
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
                                    		"ValueExclusionTest1");
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
                                    		"ValueExclusionTest2");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:357:1: entryRuleModel2 returns [EObject current=null] : iv_ruleModel2= ruleModel2 EOF ;
    public final EObject entryRuleModel2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:358:2: (iv_ruleModel2= ruleModel2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:359:2: iv_ruleModel2= ruleModel2 EOF
            {
             newCompositeNode(grammarAccess.getModel2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel2_in_entryRuleModel2571);
            iv_ruleModel2=ruleModel2();

            state._fsp--;

             current =iv_ruleModel2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel2581); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:366:1: ruleModel2 returns [EObject current=null] : ( () otherlv_1= 'model' ) ;
    public final EObject ruleModel2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:369:28: ( ( () otherlv_1= 'model' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:370:1: ( () otherlv_1= 'model' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:370:1: ( () otherlv_1= 'model' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:370:2: () otherlv_1= 'model'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:370:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:371:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModel2Access().getModelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel2627); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:388:1: entryRuleAttributeExclusionTest1 returns [EObject current=null] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final EObject entryRuleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:389:2: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:390:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1663);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest1673); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:397:1: ruleAttributeExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:400:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:401:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:401:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:401:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAttributeExclusionTest1710); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:405:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:406:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:406:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:407:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1727); 

            			newLeafNode(lv_attr1_1_0, grammarAccess.getAttributeExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExclusionTest1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr1",
                    		lv_attr1_1_0, 
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
    // $ANTLR end "ruleAttributeExclusionTest1"


    // $ANTLR start "entryRuleAttributeExclusionTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:431:1: entryRuleAttributeExclusionTest2 returns [EObject current=null] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final EObject entryRuleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:2: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:433:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2768);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest2778); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:440:1: ruleAttributeExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:443:28: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:444:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:444:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:444:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAttributeExclusionTest2815); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:448:1: ( (lv_attr2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:449:1: (lv_attr2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:449:1: (lv_attr2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:450:3: lv_attr2_1_0= RULE_ID
            {
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2832); 

            			newLeafNode(lv_attr2_1_0, grammarAccess.getAttributeExclusionTest2Access().getAttr2IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExclusionTest2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr2",
                    		lv_attr2_1_0, 
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
    // $ANTLR end "ruleAttributeExclusionTest2"


    // $ANTLR start "entryRuleNestedTypeTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:474:1: entryRuleNestedTypeTest1 returns [EObject current=null] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final EObject entryRuleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:2: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:476:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1873);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest1883); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:483:1: ruleNestedTypeTest1 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final EObject ruleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:486:28: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:487:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:487:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:489:3: lv_nested_0_0= ruleNestedTypeChild1
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1928);
            lv_nested_0_0=ruleNestedTypeChild1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNestedTypeTest1Rule());
            	        }
                   		set(
                   			current, 
                   			"nested",
                    		lv_nested_0_0, 
                    		"NestedTypeChild1");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:513:1: entryRuleNestedTypeTest2 returns [EObject current=null] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final EObject entryRuleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:514:2: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:515:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2963);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest2973); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:522:1: ruleNestedTypeTest2 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final EObject ruleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:525:28: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:528:3: lv_nested_0_0= ruleNestedTypeChild2
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21018);
            lv_nested_0_0=ruleNestedTypeChild2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNestedTypeTest2Rule());
            	        }
                   		set(
                   			current, 
                   			"nested",
                    		lv_nested_0_0, 
                    		"NestedTypeChild2");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:554:1: entryRuleNestedTypeChild1 returns [EObject current=null] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final EObject entryRuleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:555:2: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:556:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11055);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild11065); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:563:1: ruleNestedTypeChild1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:566:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:567:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:567:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:567:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNestedTypeChild11102); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:571:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:572:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:572:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:573:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild11119); 

            			newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild1Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedTypeChild1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
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
    // $ANTLR end "ruleNestedTypeChild1"


    // $ANTLR start "entryRuleNestedTypeChild2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:597:1: entryRuleNestedTypeChild2 returns [EObject current=null] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final EObject entryRuleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:598:2: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:599:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21160);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild21170); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:606:1: ruleNestedTypeChild2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:609:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:610:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:610:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:610:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNestedTypeChild21207); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:614:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:615:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:615:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:616:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild21224); 

            			newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild2Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedTypeChild2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
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
    // $ANTLR end "ruleNestedTypeChild2"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:640:1: entryRuleNestedTypeRecursiveTest1 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:641:2: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:642:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11265);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11275); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:649:1: ruleNestedTypeRecursiveTest1 returns [EObject current=null] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:652:28: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:653:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:653:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:653:2: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:653:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:654:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNestedTypeRecursiveTest11321); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:663:1: ( () otherlv_3= '.' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:663:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:663:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:664:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeRecursiveTest11343); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest1Access().getFullStopKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:681:1: entryRuleNestedTypeRecursiveTest2 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:682:2: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:683:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21381);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21391); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:690:1: ruleNestedTypeRecursiveTest2 returns [EObject current=null] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:693:28: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:694:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:694:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:694:2: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:694:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:695:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNestedTypeRecursiveTest21437); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:704:1: ( () otherlv_3= '.' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:704:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:704:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:705:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeRecursiveTest21459); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest2Access().getFullStopKeyword_2_1());
            	        

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:722:1: entryRuleParentRefTest1 returns [EObject current=null] : iv_ruleParentRefTest1= ruleParentRefTest1 EOF ;
    public final EObject entryRuleParentRefTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:723:2: (iv_ruleParentRefTest1= ruleParentRefTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:724:2: iv_ruleParentRefTest1= ruleParentRefTest1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11497);
            iv_ruleParentRefTest1=ruleParentRefTest1();

            state._fsp--;

             current =iv_ruleParentRefTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest11507); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:731:1: ruleParentRefTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final EObject ruleParentRefTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child1_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:734:28: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:735:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:735:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:735:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParentRefTest11544); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:739:1: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:740:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:740:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:741:3: lv_child1_1_0= ruleParentRefTestChild1
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest1Access().getChild1ParentRefTestChild1ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11565);
            lv_child1_1_0=ruleParentRefTestChild1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParentRefTest1Rule());
            	        }
                   		set(
                   			current, 
                   			"child1",
                    		lv_child1_1_0, 
                    		"ParentRefTestChild1");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:765:1: entryRuleParentRefTest2 returns [EObject current=null] : iv_ruleParentRefTest2= ruleParentRefTest2 EOF ;
    public final EObject entryRuleParentRefTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:766:2: (iv_ruleParentRefTest2= ruleParentRefTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:767:2: iv_ruleParentRefTest2= ruleParentRefTest2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21601);
            iv_ruleParentRefTest2=ruleParentRefTest2();

            state._fsp--;

             current =iv_ruleParentRefTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest21611); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:774:1: ruleParentRefTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final EObject ruleParentRefTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child2_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:777:28: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:778:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:778:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:778:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParentRefTest21648); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:782:1: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:783:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:783:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:784:3: lv_child2_1_0= ruleParentRefTestChild2
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest2Access().getChild2ParentRefTestChild2ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21669);
            lv_child2_1_0=ruleParentRefTestChild2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParentRefTest2Rule());
            	        }
                   		set(
                   			current, 
                   			"child2",
                    		lv_child2_1_0, 
                    		"ParentRefTestChild2");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:808:1: entryRuleParentRefTestChild1 returns [EObject current=null] : iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF ;
    public final EObject entryRuleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:809:2: (iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:810:2: iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11705);
            iv_ruleParentRefTestChild1=ruleParentRefTestChild1();

            state._fsp--;

             current =iv_ruleParentRefTestChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild11715); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:817:1: ruleParentRefTestChild1 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final EObject ruleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:820:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:821:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:821:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:821:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:821:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:822:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild1Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParentRefTestChild11761); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild1Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:831:1: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:832:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:832:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:833:3: lv_child_2_0= ruleParentRefTestChild1
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild1Access().getChildParentRefTestChild1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11782);
                    lv_child_2_0=ruleParentRefTestChild1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParentRefTestChild1Rule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"ParentRefTestChild1");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:857:1: entryRuleParentRefTestChild2 returns [EObject current=null] : iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF ;
    public final EObject entryRuleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:858:2: (iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:859:2: iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21819);
            iv_ruleParentRefTestChild2=ruleParentRefTestChild2();

            state._fsp--;

             current =iv_ruleParentRefTestChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild21829); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:866:1: ruleParentRefTestChild2 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final EObject ruleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:869:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:870:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:870:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:870:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:870:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:871:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild2Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParentRefTestChild21875); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild2Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:880:1: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:881:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:881:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:882:3: lv_child_2_0= ruleParentRefTestChild2
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild2Access().getChildParentRefTestChild2ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild21896);
                    lv_child_2_0=ruleParentRefTestChild2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParentRefTestChild2Rule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"ParentRefTestChild2");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:906:1: entryRuleQuantityExclusionTest1 returns [EObject current=null] : iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF ;
    public final EObject entryRuleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:907:2: (iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:908:2: iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest11933);
            iv_ruleQuantityExclusionTest1=ruleQuantityExclusionTest1();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest11943); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:915:1: ruleQuantityExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) ;
    public final EObject ruleQuantityExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:918:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:919:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:919:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:919:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQuantityExclusionTest11980); 

                	newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:923:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:924:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:924:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:925:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest11997); 

            			newLeafNode(lv_attr1_1_0, grammarAccess.getQuantityExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQuantityExclusionTest1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr1",
                    		lv_attr1_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:941:2: ( (lv_attr2_2_0= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:942:1: (lv_attr2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:942:1: (lv_attr2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:943:3: lv_attr2_2_0= RULE_ID
                    {
                    lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12019); 

                    			newLeafNode(lv_attr2_2_0, grammarAccess.getQuantityExclusionTest1Access().getAttr2IDTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQuantityExclusionTest1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"attr2",
                            		lv_attr2_2_0, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:967:1: entryRuleQuantityExclusionTest2 returns [EObject current=null] : iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF ;
    public final EObject entryRuleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:968:2: (iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:969:2: iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getQuantityExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22061);
            iv_ruleQuantityExclusionTest2=ruleQuantityExclusionTest2();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest22071); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:976:1: ruleQuantityExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleQuantityExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:979:28: ( (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:980:1: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:980:1: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:980:3: otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQuantityExclusionTest22108); 

                	newLeafNode(otherlv_0, grammarAccess.getQuantityExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:984:1: ( (lv_attr1_1_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_ID) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:985:1: (lv_attr1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:985:1: (lv_attr1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:986:3: lv_attr1_1_0= RULE_ID
                    {
                    lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22125); 

                    			newLeafNode(lv_attr1_1_0, grammarAccess.getQuantityExclusionTest2Access().getAttr1IDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQuantityExclusionTest2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"attr1",
                            		lv_attr1_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1002:3: ( (lv_attr2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1003:1: (lv_attr2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1003:1: (lv_attr2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1004:3: lv_attr2_2_0= RULE_ID
            {
            lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22148); 

            			newLeafNode(lv_attr2_2_0, grammarAccess.getQuantityExclusionTest2Access().getAttr2IDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQuantityExclusionTest2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr2",
                    		lv_attr2_2_0, 
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
    // $ANTLR end "ruleQuantityExclusionTest2"


    // $ANTLR start "entryRuleValueExclusionTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1028:1: entryRuleValueExclusionTest1 returns [EObject current=null] : iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF ;
    public final EObject entryRuleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1029:2: (iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1030:2: iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12189);
            iv_ruleValueExclusionTest1=ruleValueExclusionTest1();

            state._fsp--;

             current =iv_ruleValueExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest12199); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1037:1: ruleValueExclusionTest1 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) ;
    public final EObject ruleValueExclusionTest1() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1040:28: ( ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1041:1: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1041:1: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1042:1: (lv_val_0_0= ruleValueExclusionTestEn1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1042:1: (lv_val_0_0= ruleValueExclusionTestEn1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1043:3: lv_val_0_0= ruleValueExclusionTestEn1
            {
             
            	        newCompositeNode(grammarAccess.getValueExclusionTest1Access().getValValueExclusionTestEn1EnumRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12244);
            lv_val_0_0=ruleValueExclusionTestEn1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueExclusionTest1Rule());
            	        }
                   		set(
                   			current, 
                   			"val",
                    		lv_val_0_0, 
                    		"ValueExclusionTestEn1");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1067:1: entryRuleValueExclusionTest2 returns [EObject current=null] : iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF ;
    public final EObject entryRuleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1068:2: (iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1069:2: iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getValueExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22279);
            iv_ruleValueExclusionTest2=ruleValueExclusionTest2();

            state._fsp--;

             current =iv_ruleValueExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest22289); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1076:1: ruleValueExclusionTest2 returns [EObject current=null] : ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) ;
    public final EObject ruleValueExclusionTest2() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1079:28: ( ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1080:1: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1080:1: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1081:1: (lv_val_0_0= ruleValueExclusionTestEn2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1081:1: (lv_val_0_0= ruleValueExclusionTestEn2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1082:3: lv_val_0_0= ruleValueExclusionTestEn2
            {
             
            	        newCompositeNode(grammarAccess.getValueExclusionTest2Access().getValValueExclusionTestEn2EnumRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22334);
            lv_val_0_0=ruleValueExclusionTestEn2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueExclusionTest2Rule());
            	        }
                   		set(
                   			current, 
                   			"val",
                    		lv_val_0_0, 
                    		"ValueExclusionTestEn2");
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


    // $ANTLR start "ruleValueExclusionTestEn1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1108:1: ruleValueExclusionTestEn1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleValueExclusionTestEn1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1110:28: ( (enumLiteral_0= 'lit1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1111:1: (enumLiteral_0= 'lit1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1111:1: (enumLiteral_0= 'lit1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1111:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleValueExclusionTestEn12384); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1121:1: ruleValueExclusionTestEn2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleValueExclusionTestEn2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1123:28: ( (enumLiteral_0= 'lit2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1124:1: (enumLiteral_0= 'lit2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1124:1: (enumLiteral_0= 'lit2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:1124:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleValueExclusionTestEn22427); 

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
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleModel2_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel164 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_ruleModel187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_ruleModel206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel229 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_ruleModel252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_ruleModel271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel294 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel359 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_ruleModel382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel424 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_ruleModel447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_ruleModel466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel489 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_ruleModel512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_ruleModel531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel2_in_entryRuleModel2571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel2581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel2627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAttributeExclusionTest1710 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest2778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleAttributeExclusionTest2815 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest1883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2963 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest2973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild11065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleNestedTypeChild11102 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild11119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild21170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleNestedTypeChild21207 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild21224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11265 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleNestedTypeRecursiveTest11321 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeRecursiveTest11343 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleNestedTypeRecursiveTest21437 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeRecursiveTest21459 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest11507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParentRefTest11544 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest21611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleParentRefTest21648 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild11715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParentRefTestChild11761 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21819 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild21829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParentRefTestChild21875 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild21896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest11933 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest11943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleQuantityExclusionTest11980 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest11997 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22061 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest22071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleQuantityExclusionTest22108 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22125 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest12199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22279 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest22289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleValueExclusionTestEn12384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleValueExclusionTestEn22427 = new BitSet(new long[]{0x0000000000000002L});
    }


}