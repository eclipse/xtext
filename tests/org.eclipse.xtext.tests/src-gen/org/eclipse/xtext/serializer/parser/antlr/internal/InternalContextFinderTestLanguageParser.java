package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#0'", "'#1'", "'#2'", "'#3'", "'#4'", "'model'", "'kw1'", "'kw2'", "'.'", "'foo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_model_1_0 = null;

        EObject lv_attributeExclusion_3_1 = null;

        EObject lv_attributeExclusion_3_2 = null;

        EObject lv_nestedType_5_1 = null;

        EObject lv_nestedType_5_2 = null;

        EObject lv_nestedTypeRecursiveTest2_7_1 = null;

        EObject lv_nestedTypeRecursiveTest2_7_2 = null;

        EObject lv_parentRef_9_1 = null;

        EObject lv_parentRef_9_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:79:28: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:1: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            case 15:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:2: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:2: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:4: otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitZeroKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:84:1: ( (lv_model_1_0= ruleModel2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:85:1: (lv_model_1_0= ruleModel2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:85:1: (lv_model_1_0= ruleModel2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:86:3: lv_model_1_0= ruleModel2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:103:6: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:103:6: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:103:8: otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel164); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:107:1: ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:108:1: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:108:1: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:109:1: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:109:1: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==17) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==18) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:110:3: lv_attributeExclusion_3_1= ruleAttributeExclusionTest1
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:125:8: lv_attributeExclusion_3_2= ruleAttributeExclusionTest2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:144:6: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:144:6: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:144:8: otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel229); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:148:1: ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:149:1: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:149:1: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:150:1: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:150:1: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==17) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==18) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:151:3: lv_nestedType_5_1= ruleNestedTypeTest1
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:166:8: lv_nestedType_5_2= ruleNestedTypeTest2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:185:6: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:185:6: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:185:8: otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel294); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:189:1: ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:190:1: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:190:1: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:191:1: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:191:1: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==17) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==18) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:192:3: lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:207:8: lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:226:6: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:226:6: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:226:8: otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel359); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:230:1: ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:231:1: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:231:1: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:232:1: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:232:1: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==17) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==18) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:233:3: lv_parentRef_9_1= ruleParentRefTest1
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:248:8: lv_parentRef_9_2= ruleParentRefTest2
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:274:1: entryRuleModel2 returns [EObject current=null] : iv_ruleModel2= ruleModel2 EOF ;
    public final EObject entryRuleModel2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:275:2: (iv_ruleModel2= ruleModel2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:276:2: iv_ruleModel2= ruleModel2 EOF
            {
             newCompositeNode(grammarAccess.getModel2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel2_in_entryRuleModel2441);
            iv_ruleModel2=ruleModel2();

            state._fsp--;

             current =iv_ruleModel2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel2451); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:283:1: ruleModel2 returns [EObject current=null] : ( () otherlv_1= 'model' ) ;
    public final EObject ruleModel2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:286:28: ( ( () otherlv_1= 'model' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:287:1: ( () otherlv_1= 'model' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:287:1: ( () otherlv_1= 'model' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:287:2: () otherlv_1= 'model'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:287:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:288:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModel2Access().getModelAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel2497); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:305:1: entryRuleAttributeExclusionTest1 returns [EObject current=null] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final EObject entryRuleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:306:2: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:307:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1533);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest1543); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:314:1: ruleAttributeExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:317:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:318:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:318:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:318:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAttributeExclusionTest1580); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:322:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:323:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:323:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:324:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1597); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:348:1: entryRuleAttributeExclusionTest2 returns [EObject current=null] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final EObject entryRuleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:349:2: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:350:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2638);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest2648); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:357:1: ruleAttributeExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:360:28: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:361:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:361:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:361:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAttributeExclusionTest2685); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:365:1: ( (lv_attr2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:366:1: (lv_attr2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:366:1: (lv_attr2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:367:3: lv_attr2_1_0= RULE_ID
            {
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2702); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:391:1: entryRuleNestedTypeTest1 returns [EObject current=null] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final EObject entryRuleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:392:2: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:393:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1743);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest1753); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:400:1: ruleNestedTypeTest1 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final EObject ruleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:403:28: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:404:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:404:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:405:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:405:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:406:3: lv_nested_0_0= ruleNestedTypeChild1
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1798);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:430:1: entryRuleNestedTypeTest2 returns [EObject current=null] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final EObject entryRuleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:431:2: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2833);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest2843); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:439:1: ruleNestedTypeTest2 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final EObject ruleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:442:28: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:443:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:443:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:444:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:444:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:445:3: lv_nested_0_0= ruleNestedTypeChild2
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest2888);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:471:1: entryRuleNestedTypeChild1 returns [EObject current=null] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final EObject entryRuleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:472:2: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:473:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild1925);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild1935); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:480:1: ruleNestedTypeChild1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:483:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:484:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:484:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:484:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNestedTypeChild1972); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:488:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:489:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:489:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:490:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild1989); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:514:1: entryRuleNestedTypeChild2 returns [EObject current=null] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final EObject entryRuleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:515:2: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:516:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21030);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild21040); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:523:1: ruleNestedTypeChild2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNestedTypeChild21077); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:531:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:532:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:532:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:533:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild21094); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:557:1: entryRuleNestedTypeRecursiveTest1 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:558:2: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:559:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11135);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11145); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:566:1: ruleNestedTypeRecursiveTest1 returns [EObject current=null] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:569:28: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:570:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:570:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:570:2: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:570:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:571:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNestedTypeRecursiveTest11191); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:580:1: ( () otherlv_3= '.' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:580:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:580:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:581:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNestedTypeRecursiveTest11213); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest1Access().getFullStopKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:598:1: entryRuleNestedTypeRecursiveTest2 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:599:2: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:600:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21251);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21261); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:607:1: ruleNestedTypeRecursiveTest2 returns [EObject current=null] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:610:28: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:611:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:611:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:611:2: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:611:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:612:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNestedTypeRecursiveTest21307); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:621:1: ( () otherlv_3= '.' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:621:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:621:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:622:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNestedTypeRecursiveTest21329); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest2Access().getFullStopKeyword_2_1());
            	        

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:639:1: entryRuleParentRefTest1 returns [EObject current=null] : iv_ruleParentRefTest1= ruleParentRefTest1 EOF ;
    public final EObject entryRuleParentRefTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:640:2: (iv_ruleParentRefTest1= ruleParentRefTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:641:2: iv_ruleParentRefTest1= ruleParentRefTest1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11367);
            iv_ruleParentRefTest1=ruleParentRefTest1();

            state._fsp--;

             current =iv_ruleParentRefTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest11377); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:648:1: ruleParentRefTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final EObject ruleParentRefTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child1_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:651:28: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:652:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:652:1: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:652:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParentRefTest11414); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:656:1: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:657:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:657:1: (lv_child1_1_0= ruleParentRefTestChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:658:3: lv_child1_1_0= ruleParentRefTestChild1
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest1Access().getChild1ParentRefTestChild1ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11435);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:682:1: entryRuleParentRefTest2 returns [EObject current=null] : iv_ruleParentRefTest2= ruleParentRefTest2 EOF ;
    public final EObject entryRuleParentRefTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:683:2: (iv_ruleParentRefTest2= ruleParentRefTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:684:2: iv_ruleParentRefTest2= ruleParentRefTest2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21471);
            iv_ruleParentRefTest2=ruleParentRefTest2();

            state._fsp--;

             current =iv_ruleParentRefTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest21481); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:691:1: ruleParentRefTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final EObject ruleParentRefTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child2_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:694:28: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:695:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:695:1: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:695:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParentRefTest21518); 

                	newLeafNode(otherlv_0, grammarAccess.getParentRefTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:699:1: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:700:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:700:1: (lv_child2_1_0= ruleParentRefTestChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:701:3: lv_child2_1_0= ruleParentRefTestChild2
            {
             
            	        newCompositeNode(grammarAccess.getParentRefTest2Access().getChild2ParentRefTestChild2ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21539);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:725:1: entryRuleParentRefTestChild1 returns [EObject current=null] : iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF ;
    public final EObject entryRuleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:726:2: (iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:727:2: iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11575);
            iv_ruleParentRefTestChild1=ruleParentRefTestChild1();

            state._fsp--;

             current =iv_ruleParentRefTestChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild11585); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:734:1: ruleParentRefTestChild1 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final EObject ruleParentRefTestChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:737:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:738:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:738:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:738:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:738:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:739:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild1Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParentRefTestChild11631); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild1Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:748:1: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:749:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:749:1: (lv_child_2_0= ruleParentRefTestChild1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:750:3: lv_child_2_0= ruleParentRefTestChild1
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild1Access().getChildParentRefTestChild1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11652);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:774:1: entryRuleParentRefTestChild2 returns [EObject current=null] : iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF ;
    public final EObject entryRuleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentRefTestChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:775:2: (iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:776:2: iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF
            {
             newCompositeNode(grammarAccess.getParentRefTestChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21689);
            iv_ruleParentRefTestChild2=ruleParentRefTestChild2();

            state._fsp--;

             current =iv_ruleParentRefTestChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild21699); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:783:1: ruleParentRefTestChild2 returns [EObject current=null] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final EObject ruleParentRefTestChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_child_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:786:28: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:787:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:787:1: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:787:2: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:787:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:788:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParentRefTestChild2Access().getParentRefTestChildAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParentRefTestChild21745); 

                	newLeafNode(otherlv_1, grammarAccess.getParentRefTestChild2Access().getFooKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:797:1: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:798:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:798:1: (lv_child_2_0= ruleParentRefTestChild2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:799:3: lv_child_2_0= ruleParentRefTestChild2
                    {
                     
                    	        newCompositeNode(grammarAccess.getParentRefTestChild2Access().getChildParentRefTestChild2ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild21766);
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleModel2_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel164 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_ruleModel187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_ruleModel206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel229 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_ruleModel252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_ruleModel271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel294 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel359 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_ruleModel382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel2_in_entryRuleModel2441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel2497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1533 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest1543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleAttributeExclusionTest1580 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAttributeExclusionTest2685 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1743 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest1753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest2843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest2888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild1925 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild1935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNestedTypeChild1972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild1989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21030 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild21040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleNestedTypeChild21077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild21094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNestedTypeRecursiveTest11191 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleNestedTypeRecursiveTest11213 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleNestedTypeRecursiveTest21307 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleNestedTypeRecursiveTest21329 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest11367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest11377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParentRefTest11414 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest11435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest21471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest21481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParentRefTest21518 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest21539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild11575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild11585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleParentRefTestChild11631 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild11652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild21689 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild21699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleParentRefTestChild21745 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild21766 = new BitSet(new long[]{0x0000000000000002L});
    }


}