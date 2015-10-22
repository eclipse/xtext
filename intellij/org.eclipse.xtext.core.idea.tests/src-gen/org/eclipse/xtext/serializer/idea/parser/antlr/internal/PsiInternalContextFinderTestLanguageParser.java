package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.serializer.services.ContextFinderTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalContextFinderTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalContextFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalContextFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalContextFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalContextFinderTestLanguage.g"; }



    	protected ContextFinderTestLanguageGrammarAccess grammarAccess;

    	protected ContextFinderTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalContextFinderTestLanguageParser(PsiBuilder builder, TokenStream input, ContextFinderTestLanguageElementTypeProvider elementTypeProvider, ContextFinderTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalContextFinderTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalContextFinderTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalContextFinderTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_model_1_0 = null;

        Boolean lv_attributeExclusion_3_1 = null;

        Boolean lv_attributeExclusion_3_2 = null;

        Boolean lv_nestedType_5_1 = null;

        Boolean lv_nestedType_5_2 = null;

        Boolean lv_nestedTypeRecursiveTest2_7_1 = null;

        Boolean lv_nestedTypeRecursiveTest2_7_2 = null;

        Boolean lv_parentRef_9_1 = null;

        Boolean lv_parentRef_9_2 = null;

        Boolean lv_quantityExclusion_11_1 = null;

        Boolean lv_quantityExclusion_11_2 = null;

        Boolean lv_valueExclusion_13_1 = null;

        Boolean lv_valueExclusion_13_2 = null;

        Boolean lv_nodeExclusion_16_1 = null;

        Boolean lv_nodeExclusion_16_2 = null;

        Boolean lv_nodeExclusionList_19_1 = null;

        Boolean lv_nodeExclusionList_19_2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:60:1: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:61:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:61:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
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
                    // PsiInternalContextFinderTestLanguage.g:62:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:62:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:63:4: otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitZeroKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalContextFinderTestLanguage.g:70:4: ( (lv_model_1_0= ruleModel2 ) )
                    // PsiInternalContextFinderTestLanguage.g:71:5: (lv_model_1_0= ruleModel2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:71:5: (lv_model_1_0= ruleModel2 )
                    // PsiInternalContextFinderTestLanguage.g:72:6: lv_model_1_0= ruleModel2
                    {

                    						markComposite(elementTypeProvider.getModel_ModelModel2ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_model_1_0=ruleModel2();

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
                    break;
                case 2 :
                    // PsiInternalContextFinderTestLanguage.g:87:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:87:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:88:4: otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitOneKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalContextFinderTestLanguage.g:95:4: ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:96:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:96:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:97:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:97:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:98:7: lv_attributeExclusion_3_1= ruleAttributeExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_attributeExclusion_3_1=ruleAttributeExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:110:7: lv_attributeExclusion_3_2= ruleAttributeExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_attributeExclusion_3_2=ruleAttributeExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalContextFinderTestLanguage.g:126:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:126:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:127:4: otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitTwoKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalContextFinderTestLanguage.g:134:4: ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:135:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:135:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:136:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:136:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:137:7: lv_nestedType_5_1= ruleNestedTypeTest1
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedType_5_1=ruleNestedTypeTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:149:7: lv_nestedType_5_2= ruleNestedTypeTest2
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedType_5_2=ruleNestedTypeTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalContextFinderTestLanguage.g:165:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:165:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:166:4: otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitThreeKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalContextFinderTestLanguage.g:173:4: ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:174:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:174:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:175:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:175:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:176:7: lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedTypeRecursiveTest2_7_1=ruleNestedTypeRecursiveTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:188:7: lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nestedTypeRecursiveTest2_7_2=ruleNestedTypeRecursiveTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalContextFinderTestLanguage.g:204:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:204:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:205:4: otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitFourKeyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalContextFinderTestLanguage.g:212:4: ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:213:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:213:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:214:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:214:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:215:7: lv_parentRef_9_1= ruleParentRefTest1
                            {

                            							markComposite(elementTypeProvider.getModel_ParentRefParentRefTest1ParserRuleCall_4_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_parentRef_9_1=ruleParentRefTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:227:7: lv_parentRef_9_2= ruleParentRefTest2
                            {

                            							markComposite(elementTypeProvider.getModel_ParentRefParentRefTest2ParserRuleCall_4_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_parentRef_9_2=ruleParentRefTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalContextFinderTestLanguage.g:243:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:243:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:244:4: otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitFiveKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalContextFinderTestLanguage.g:251:4: ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:252:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:252:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:253:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:253:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:254:7: lv_quantityExclusion_11_1= ruleQuantityExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_quantityExclusion_11_1=ruleQuantityExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:266:7: lv_quantityExclusion_11_2= ruleQuantityExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_quantityExclusion_11_2=ruleQuantityExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalContextFinderTestLanguage.g:282:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:282:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:283:4: otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitSixKeyword_6_0ElementType());
                    			
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_12);
                    			
                    // PsiInternalContextFinderTestLanguage.g:290:4: ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:291:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:291:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    // PsiInternalContextFinderTestLanguage.g:292:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:292:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
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
                            // PsiInternalContextFinderTestLanguage.g:293:7: lv_valueExclusion_13_1= ruleValueExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_valueExclusion_13_1=ruleValueExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:305:7: lv_valueExclusion_13_2= ruleValueExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_valueExclusion_13_2=ruleValueExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalContextFinderTestLanguage.g:321:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:321:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:322:4: otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitSevenKeyword_7_0ElementType());
                    			
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_14);
                    			
                    // PsiInternalContextFinderTestLanguage.g:329:4: ( (lv_name_15_0= RULE_STRING ) )
                    // PsiInternalContextFinderTestLanguage.g:330:5: (lv_name_15_0= RULE_STRING )
                    {
                    // PsiInternalContextFinderTestLanguage.g:330:5: (lv_name_15_0= RULE_STRING )
                    // PsiInternalContextFinderTestLanguage.g:331:6: lv_name_15_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_NameSTRINGTerminalRuleCall_7_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_name_15_0);
                    					

                    }


                    }

                    // PsiInternalContextFinderTestLanguage.g:346:4: ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    // PsiInternalContextFinderTestLanguage.g:347:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:347:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    // PsiInternalContextFinderTestLanguage.g:348:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:348:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
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
                            // PsiInternalContextFinderTestLanguage.g:349:7: lv_nodeExclusion_16_1= ruleNodeExclusion1
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusion_16_1=ruleNodeExclusion1();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:361:7: lv_nodeExclusion_16_2= ruleNodeExclusion2
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusion_16_2=ruleNodeExclusion2();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalContextFinderTestLanguage.g:377:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:377:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    // PsiInternalContextFinderTestLanguage.g:378:4: otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignDigitEightKeyword_8_0ElementType());
                    			
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_17);
                    			
                    // PsiInternalContextFinderTestLanguage.g:385:4: ( (lv_name_18_0= RULE_STRING ) )
                    // PsiInternalContextFinderTestLanguage.g:386:5: (lv_name_18_0= RULE_STRING )
                    {
                    // PsiInternalContextFinderTestLanguage.g:386:5: (lv_name_18_0= RULE_STRING )
                    // PsiInternalContextFinderTestLanguage.g:387:6: lv_name_18_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_NameSTRINGTerminalRuleCall_8_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_18_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_name_18_0);
                    					

                    }


                    }

                    // PsiInternalContextFinderTestLanguage.g:402:4: ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    // PsiInternalContextFinderTestLanguage.g:403:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    {
                    // PsiInternalContextFinderTestLanguage.g:403:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    // PsiInternalContextFinderTestLanguage.g:404:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
                    {
                    // PsiInternalContextFinderTestLanguage.g:404:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
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
                            // PsiInternalContextFinderTestLanguage.g:405:7: lv_nodeExclusionList_19_1= ruleNodeExclusion1List
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusionList_19_1=ruleNodeExclusion1List();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalContextFinderTestLanguage.g:417:7: lv_nodeExclusionList_19_2= ruleNodeExclusion2List
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_nodeExclusionList_19_2=ruleNodeExclusion2List();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

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


    // $ANTLR start "entryRuleModel2"
    // PsiInternalContextFinderTestLanguage.g:436:1: entryRuleModel2 returns [Boolean current=false] : iv_ruleModel2= ruleModel2 EOF ;
    public final Boolean entryRuleModel2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:436:48: (iv_ruleModel2= ruleModel2 EOF )
            // PsiInternalContextFinderTestLanguage.g:437:2: iv_ruleModel2= ruleModel2 EOF
            {
             markComposite(elementTypeProvider.getModel2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel2=ruleModel2();

            state._fsp--;

             current =iv_ruleModel2; 
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
    // $ANTLR end "entryRuleModel2"


    // $ANTLR start "ruleModel2"
    // PsiInternalContextFinderTestLanguage.g:443:1: ruleModel2 returns [Boolean current=false] : ( () otherlv_1= 'model' ) ;
    public final Boolean ruleModel2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:444:1: ( ( () otherlv_1= 'model' ) )
            // PsiInternalContextFinderTestLanguage.g:445:2: ( () otherlv_1= 'model' )
            {
            // PsiInternalContextFinderTestLanguage.g:445:2: ( () otherlv_1= 'model' )
            // PsiInternalContextFinderTestLanguage.g:446:3: () otherlv_1= 'model'
            {
            // PsiInternalContextFinderTestLanguage.g:446:3: ()
            // PsiInternalContextFinderTestLanguage.g:447:4: 
            {

            				precedeComposite(elementTypeProvider.getModel2_ModelAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getModel2_ModelKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleModel2"


    // $ANTLR start "entryRuleAttributeExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:464:1: entryRuleAttributeExclusionTest1 returns [Boolean current=false] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final Boolean entryRuleAttributeExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAttributeExclusionTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:464:65: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:465:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getAttributeExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
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
    // $ANTLR end "entryRuleAttributeExclusionTest1"


    // $ANTLR start "ruleAttributeExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:471:1: ruleAttributeExclusionTest1 returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleAttributeExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:472:1: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:473:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:473:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:474:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAttributeExclusionTest1_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:481:3: ( (lv_attr1_1_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:482:4: (lv_attr1_1_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:482:4: (lv_attr1_1_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:483:5: lv_attr1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_attr1_1_0);
            				

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
    // $ANTLR end "ruleAttributeExclusionTest1"


    // $ANTLR start "entryRuleAttributeExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:502:1: entryRuleAttributeExclusionTest2 returns [Boolean current=false] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final Boolean entryRuleAttributeExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAttributeExclusionTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:502:65: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:503:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getAttributeExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
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
    // $ANTLR end "entryRuleAttributeExclusionTest2"


    // $ANTLR start "ruleAttributeExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:509:1: ruleAttributeExclusionTest2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleAttributeExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:510:1: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:511:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:511:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:512:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAttributeExclusionTest2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:519:3: ( (lv_attr2_1_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:520:4: (lv_attr2_1_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:520:4: (lv_attr2_1_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:521:5: lv_attr2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_attr2_1_0);
            				

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
    // $ANTLR end "ruleAttributeExclusionTest2"


    // $ANTLR start "entryRuleNestedTypeTest1"
    // PsiInternalContextFinderTestLanguage.g:540:1: entryRuleNestedTypeTest1 returns [Boolean current=false] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final Boolean entryRuleNestedTypeTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:540:57: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:541:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
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
    // $ANTLR end "entryRuleNestedTypeTest1"


    // $ANTLR start "ruleNestedTypeTest1"
    // PsiInternalContextFinderTestLanguage.g:547:1: ruleNestedTypeTest1 returns [Boolean current=false] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final Boolean ruleNestedTypeTest1() throws RecognitionException {
        Boolean current = false;

        Boolean lv_nested_0_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:548:1: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // PsiInternalContextFinderTestLanguage.g:549:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // PsiInternalContextFinderTestLanguage.g:549:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // PsiInternalContextFinderTestLanguage.g:550:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // PsiInternalContextFinderTestLanguage.g:550:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            // PsiInternalContextFinderTestLanguage.g:551:4: lv_nested_0_0= ruleNestedTypeChild1
            {

            				markComposite(elementTypeProvider.getNestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_nested_0_0=ruleNestedTypeChild1();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedTypeTest1"


    // $ANTLR start "entryRuleNestedTypeTest2"
    // PsiInternalContextFinderTestLanguage.g:567:1: entryRuleNestedTypeTest2 returns [Boolean current=false] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final Boolean entryRuleNestedTypeTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:567:57: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:568:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
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
    // $ANTLR end "entryRuleNestedTypeTest2"


    // $ANTLR start "ruleNestedTypeTest2"
    // PsiInternalContextFinderTestLanguage.g:574:1: ruleNestedTypeTest2 returns [Boolean current=false] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final Boolean ruleNestedTypeTest2() throws RecognitionException {
        Boolean current = false;

        Boolean lv_nested_0_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:575:1: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // PsiInternalContextFinderTestLanguage.g:576:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // PsiInternalContextFinderTestLanguage.g:576:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // PsiInternalContextFinderTestLanguage.g:577:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // PsiInternalContextFinderTestLanguage.g:577:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            // PsiInternalContextFinderTestLanguage.g:578:4: lv_nested_0_0= ruleNestedTypeChild2
            {

            				markComposite(elementTypeProvider.getNestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_nested_0_0=ruleNestedTypeChild2();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedTypeTest2"


    // $ANTLR start "entryRuleNestedTypeChild1"
    // PsiInternalContextFinderTestLanguage.g:594:1: entryRuleNestedTypeChild1 returns [Boolean current=false] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final Boolean entryRuleNestedTypeChild1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeChild1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:594:58: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // PsiInternalContextFinderTestLanguage.g:595:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
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
    // $ANTLR end "entryRuleNestedTypeChild1"


    // $ANTLR start "ruleNestedTypeChild1"
    // PsiInternalContextFinderTestLanguage.g:601:1: ruleNestedTypeChild1 returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleNestedTypeChild1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:602:1: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:603:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:603:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:604:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getNestedTypeChild1_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:611:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:612:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:612:4: (lv_val_1_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:613:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNestedTypeChild1_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleNestedTypeChild1"


    // $ANTLR start "entryRuleNestedTypeChild2"
    // PsiInternalContextFinderTestLanguage.g:632:1: entryRuleNestedTypeChild2 returns [Boolean current=false] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final Boolean entryRuleNestedTypeChild2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeChild2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:632:58: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // PsiInternalContextFinderTestLanguage.g:633:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
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
    // $ANTLR end "entryRuleNestedTypeChild2"


    // $ANTLR start "ruleNestedTypeChild2"
    // PsiInternalContextFinderTestLanguage.g:639:1: ruleNestedTypeChild2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleNestedTypeChild2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:640:1: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:641:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:641:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:642:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getNestedTypeChild2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:649:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:650:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:650:4: (lv_val_1_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:651:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNestedTypeChild2_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleNestedTypeChild2"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest1"
    // PsiInternalContextFinderTestLanguage.g:670:1: entryRuleNestedTypeRecursiveTest1 returns [Boolean current=false] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final Boolean entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:670:66: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:671:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeRecursiveTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest1"


    // $ANTLR start "ruleNestedTypeRecursiveTest1"
    // PsiInternalContextFinderTestLanguage.g:677:1: ruleNestedTypeRecursiveTest1 returns [Boolean current=false] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final Boolean ruleNestedTypeRecursiveTest1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:678:1: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // PsiInternalContextFinderTestLanguage.g:679:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // PsiInternalContextFinderTestLanguage.g:679:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // PsiInternalContextFinderTestLanguage.g:680:3: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // PsiInternalContextFinderTestLanguage.g:680:3: ()
            // PsiInternalContextFinderTestLanguage.g:681:4: 
            {

            				precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getNestedTypeRecursiveTest1_Kw1Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalContextFinderTestLanguage.g:694:3: ( () otherlv_3= '.' )+
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
            	    // PsiInternalContextFinderTestLanguage.g:695:4: () otherlv_3= '.'
            	    {
            	    // PsiInternalContextFinderTestLanguage.g:695:4: ()
            	    // PsiInternalContextFinderTestLanguage.g:696:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getNestedTypeRecursiveTest1_FullStopKeyword_2_1ElementType());
            	    			
            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(otherlv_3);
            	    			

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedTypeRecursiveTest1"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest2"
    // PsiInternalContextFinderTestLanguage.g:714:1: entryRuleNestedTypeRecursiveTest2 returns [Boolean current=false] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final Boolean entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:714:66: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:715:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeRecursiveTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest2"


    // $ANTLR start "ruleNestedTypeRecursiveTest2"
    // PsiInternalContextFinderTestLanguage.g:721:1: ruleNestedTypeRecursiveTest2 returns [Boolean current=false] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final Boolean ruleNestedTypeRecursiveTest2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:722:1: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // PsiInternalContextFinderTestLanguage.g:723:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // PsiInternalContextFinderTestLanguage.g:723:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // PsiInternalContextFinderTestLanguage.g:724:3: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // PsiInternalContextFinderTestLanguage.g:724:3: ()
            // PsiInternalContextFinderTestLanguage.g:725:4: 
            {

            				precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getNestedTypeRecursiveTest2_Kw2Keyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalContextFinderTestLanguage.g:738:3: ( () otherlv_3= '.' )+
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
            	    // PsiInternalContextFinderTestLanguage.g:739:4: () otherlv_3= '.'
            	    {
            	    // PsiInternalContextFinderTestLanguage.g:739:4: ()
            	    // PsiInternalContextFinderTestLanguage.g:740:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getNestedTypeRecursiveTest2_FullStopKeyword_2_1ElementType());
            	    			
            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(otherlv_3);
            	    			

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedTypeRecursiveTest2"


    // $ANTLR start "entryRuleParentRefTest1"
    // PsiInternalContextFinderTestLanguage.g:758:1: entryRuleParentRefTest1 returns [Boolean current=false] : iv_ruleParentRefTest1= ruleParentRefTest1 EOF ;
    public final Boolean entryRuleParentRefTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParentRefTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:758:56: (iv_ruleParentRefTest1= ruleParentRefTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:759:2: iv_ruleParentRefTest1= ruleParentRefTest1 EOF
            {
             markComposite(elementTypeProvider.getParentRefTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTest1=ruleParentRefTest1();

            state._fsp--;

             current =iv_ruleParentRefTest1; 
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
    // $ANTLR end "entryRuleParentRefTest1"


    // $ANTLR start "ruleParentRefTest1"
    // PsiInternalContextFinderTestLanguage.g:765:1: ruleParentRefTest1 returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final Boolean ruleParentRefTest1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_child1_1_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:766:1: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:767:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:767:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // PsiInternalContextFinderTestLanguage.g:768:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {

            			markLeaf(elementTypeProvider.getParentRefTest1_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:775:3: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // PsiInternalContextFinderTestLanguage.g:776:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // PsiInternalContextFinderTestLanguage.g:776:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            // PsiInternalContextFinderTestLanguage.g:777:5: lv_child1_1_0= ruleParentRefTestChild1
            {

            					markComposite(elementTypeProvider.getParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child1_1_0=ruleParentRefTestChild1();

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
    // $ANTLR end "ruleParentRefTest1"


    // $ANTLR start "entryRuleParentRefTest2"
    // PsiInternalContextFinderTestLanguage.g:794:1: entryRuleParentRefTest2 returns [Boolean current=false] : iv_ruleParentRefTest2= ruleParentRefTest2 EOF ;
    public final Boolean entryRuleParentRefTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParentRefTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:794:56: (iv_ruleParentRefTest2= ruleParentRefTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:795:2: iv_ruleParentRefTest2= ruleParentRefTest2 EOF
            {
             markComposite(elementTypeProvider.getParentRefTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTest2=ruleParentRefTest2();

            state._fsp--;

             current =iv_ruleParentRefTest2; 
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
    // $ANTLR end "entryRuleParentRefTest2"


    // $ANTLR start "ruleParentRefTest2"
    // PsiInternalContextFinderTestLanguage.g:801:1: ruleParentRefTest2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final Boolean ruleParentRefTest2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_child2_1_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:802:1: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:803:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:803:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // PsiInternalContextFinderTestLanguage.g:804:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {

            			markLeaf(elementTypeProvider.getParentRefTest2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:811:3: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // PsiInternalContextFinderTestLanguage.g:812:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // PsiInternalContextFinderTestLanguage.g:812:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            // PsiInternalContextFinderTestLanguage.g:813:5: lv_child2_1_0= ruleParentRefTestChild2
            {

            					markComposite(elementTypeProvider.getParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child2_1_0=ruleParentRefTestChild2();

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
    // $ANTLR end "ruleParentRefTest2"


    // $ANTLR start "entryRuleParentRefTestChild1"
    // PsiInternalContextFinderTestLanguage.g:830:1: entryRuleParentRefTestChild1 returns [Boolean current=false] : iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF ;
    public final Boolean entryRuleParentRefTestChild1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParentRefTestChild1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:830:61: (iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF )
            // PsiInternalContextFinderTestLanguage.g:831:2: iv_ruleParentRefTestChild1= ruleParentRefTestChild1 EOF
            {
             markComposite(elementTypeProvider.getParentRefTestChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTestChild1=ruleParentRefTestChild1();

            state._fsp--;

             current =iv_ruleParentRefTestChild1; 
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
    // $ANTLR end "entryRuleParentRefTestChild1"


    // $ANTLR start "ruleParentRefTestChild1"
    // PsiInternalContextFinderTestLanguage.g:837:1: ruleParentRefTestChild1 returns [Boolean current=false] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final Boolean ruleParentRefTestChild1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_child_2_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:838:1: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // PsiInternalContextFinderTestLanguage.g:839:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // PsiInternalContextFinderTestLanguage.g:839:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // PsiInternalContextFinderTestLanguage.g:840:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // PsiInternalContextFinderTestLanguage.g:840:3: ()
            // PsiInternalContextFinderTestLanguage.g:841:4: 
            {

            				precedeComposite(elementTypeProvider.getParentRefTestChild1_ParentRefTestChildAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getParentRefTestChild1_FooKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalContextFinderTestLanguage.g:854:3: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalContextFinderTestLanguage.g:855:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:855:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    // PsiInternalContextFinderTestLanguage.g:856:5: lv_child_2_0= ruleParentRefTestChild1
                    {

                    					markComposite(elementTypeProvider.getParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_2_0=ruleParentRefTestChild1();

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
    // $ANTLR end "ruleParentRefTestChild1"


    // $ANTLR start "entryRuleParentRefTestChild2"
    // PsiInternalContextFinderTestLanguage.g:873:1: entryRuleParentRefTestChild2 returns [Boolean current=false] : iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF ;
    public final Boolean entryRuleParentRefTestChild2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParentRefTestChild2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:873:61: (iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF )
            // PsiInternalContextFinderTestLanguage.g:874:2: iv_ruleParentRefTestChild2= ruleParentRefTestChild2 EOF
            {
             markComposite(elementTypeProvider.getParentRefTestChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParentRefTestChild2=ruleParentRefTestChild2();

            state._fsp--;

             current =iv_ruleParentRefTestChild2; 
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
    // $ANTLR end "entryRuleParentRefTestChild2"


    // $ANTLR start "ruleParentRefTestChild2"
    // PsiInternalContextFinderTestLanguage.g:880:1: ruleParentRefTestChild2 returns [Boolean current=false] : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final Boolean ruleParentRefTestChild2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_child_2_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:881:1: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // PsiInternalContextFinderTestLanguage.g:882:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // PsiInternalContextFinderTestLanguage.g:882:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // PsiInternalContextFinderTestLanguage.g:883:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // PsiInternalContextFinderTestLanguage.g:883:3: ()
            // PsiInternalContextFinderTestLanguage.g:884:4: 
            {

            				precedeComposite(elementTypeProvider.getParentRefTestChild2_ParentRefTestChildAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getParentRefTestChild2_FooKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalContextFinderTestLanguage.g:897:3: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalContextFinderTestLanguage.g:898:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // PsiInternalContextFinderTestLanguage.g:898:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    // PsiInternalContextFinderTestLanguage.g:899:5: lv_child_2_0= ruleParentRefTestChild2
                    {

                    					markComposite(elementTypeProvider.getParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_2_0=ruleParentRefTestChild2();

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
    // $ANTLR end "ruleParentRefTestChild2"


    // $ANTLR start "entryRuleQuantityExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:916:1: entryRuleQuantityExclusionTest1 returns [Boolean current=false] : iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF ;
    public final Boolean entryRuleQuantityExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQuantityExclusionTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:916:64: (iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:917:2: iv_ruleQuantityExclusionTest1= ruleQuantityExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getQuantityExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuantityExclusionTest1=ruleQuantityExclusionTest1();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest1; 
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
    // $ANTLR end "entryRuleQuantityExclusionTest1"


    // $ANTLR start "ruleQuantityExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:923:1: ruleQuantityExclusionTest1 returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) ;
    public final Boolean ruleQuantityExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:924:1: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) )
            // PsiInternalContextFinderTestLanguage.g:925:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            {
            // PsiInternalContextFinderTestLanguage.g:925:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            // PsiInternalContextFinderTestLanguage.g:926:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getQuantityExclusionTest1_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:933:3: ( (lv_attr1_1_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:934:4: (lv_attr1_1_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:934:4: (lv_attr1_1_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:935:5: lv_attr1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getQuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_attr1_1_0);
            				

            }


            }

            // PsiInternalContextFinderTestLanguage.g:950:3: ( (lv_attr2_2_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalContextFinderTestLanguage.g:951:4: (lv_attr2_2_0= RULE_ID )
                    {
                    // PsiInternalContextFinderTestLanguage.g:951:4: (lv_attr2_2_0= RULE_ID )
                    // PsiInternalContextFinderTestLanguage.g:952:5: lv_attr2_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getQuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_attr2_2_0);
                    				

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
    // $ANTLR end "ruleQuantityExclusionTest1"


    // $ANTLR start "entryRuleQuantityExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:971:1: entryRuleQuantityExclusionTest2 returns [Boolean current=false] : iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF ;
    public final Boolean entryRuleQuantityExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQuantityExclusionTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:971:64: (iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:972:2: iv_ruleQuantityExclusionTest2= ruleQuantityExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getQuantityExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuantityExclusionTest2=ruleQuantityExclusionTest2();

            state._fsp--;

             current =iv_ruleQuantityExclusionTest2; 
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
    // $ANTLR end "entryRuleQuantityExclusionTest2"


    // $ANTLR start "ruleQuantityExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:978:1: ruleQuantityExclusionTest2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleQuantityExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:979:1: ( (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) )
            // PsiInternalContextFinderTestLanguage.g:980:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            {
            // PsiInternalContextFinderTestLanguage.g:980:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:981:3: otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getQuantityExclusionTest2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalContextFinderTestLanguage.g:988:3: ( (lv_attr1_1_0= RULE_ID ) )?
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
                    // PsiInternalContextFinderTestLanguage.g:989:4: (lv_attr1_1_0= RULE_ID )
                    {
                    // PsiInternalContextFinderTestLanguage.g:989:4: (lv_attr1_1_0= RULE_ID )
                    // PsiInternalContextFinderTestLanguage.g:990:5: lv_attr1_1_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getQuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    					doneLeaf(lv_attr1_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalContextFinderTestLanguage.g:1005:3: ( (lv_attr2_2_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:1006:4: (lv_attr2_2_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:1006:4: (lv_attr2_2_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:1007:5: lv_attr2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getQuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_attr2_2_0);
            				

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
    // $ANTLR end "ruleQuantityExclusionTest2"


    // $ANTLR start "entryRuleValueExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:1026:1: entryRuleValueExclusionTest1 returns [Boolean current=false] : iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF ;
    public final Boolean entryRuleValueExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValueExclusionTest1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1026:61: (iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF )
            // PsiInternalContextFinderTestLanguage.g:1027:2: iv_ruleValueExclusionTest1= ruleValueExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getValueExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueExclusionTest1=ruleValueExclusionTest1();

            state._fsp--;

             current =iv_ruleValueExclusionTest1; 
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
    // $ANTLR end "entryRuleValueExclusionTest1"


    // $ANTLR start "ruleValueExclusionTest1"
    // PsiInternalContextFinderTestLanguage.g:1033:1: ruleValueExclusionTest1 returns [Boolean current=false] : ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) ;
    public final Boolean ruleValueExclusionTest1() throws RecognitionException {
        Boolean current = false;

        Boolean lv_val_0_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1034:1: ( ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) )
            // PsiInternalContextFinderTestLanguage.g:1035:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            {
            // PsiInternalContextFinderTestLanguage.g:1035:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            // PsiInternalContextFinderTestLanguage.g:1036:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            {
            // PsiInternalContextFinderTestLanguage.g:1036:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            // PsiInternalContextFinderTestLanguage.g:1037:4: lv_val_0_0= ruleValueExclusionTestEn1
            {

            				markComposite(elementTypeProvider.getValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_0_0=ruleValueExclusionTestEn1();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueExclusionTest1"


    // $ANTLR start "entryRuleValueExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:1053:1: entryRuleValueExclusionTest2 returns [Boolean current=false] : iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF ;
    public final Boolean entryRuleValueExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValueExclusionTest2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1053:61: (iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF )
            // PsiInternalContextFinderTestLanguage.g:1054:2: iv_ruleValueExclusionTest2= ruleValueExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getValueExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueExclusionTest2=ruleValueExclusionTest2();

            state._fsp--;

             current =iv_ruleValueExclusionTest2; 
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
    // $ANTLR end "entryRuleValueExclusionTest2"


    // $ANTLR start "ruleValueExclusionTest2"
    // PsiInternalContextFinderTestLanguage.g:1060:1: ruleValueExclusionTest2 returns [Boolean current=false] : ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) ;
    public final Boolean ruleValueExclusionTest2() throws RecognitionException {
        Boolean current = false;

        Boolean lv_val_0_0 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1061:1: ( ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) )
            // PsiInternalContextFinderTestLanguage.g:1062:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            {
            // PsiInternalContextFinderTestLanguage.g:1062:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            // PsiInternalContextFinderTestLanguage.g:1063:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            {
            // PsiInternalContextFinderTestLanguage.g:1063:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            // PsiInternalContextFinderTestLanguage.g:1064:4: lv_val_0_0= ruleValueExclusionTestEn2
            {

            				markComposite(elementTypeProvider.getValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_0_0=ruleValueExclusionTestEn2();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueExclusionTest2"


    // $ANTLR start "entryRuleNodeExclusion1"
    // PsiInternalContextFinderTestLanguage.g:1080:1: entryRuleNodeExclusion1 returns [Boolean current=false] : iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF ;
    public final Boolean entryRuleNodeExclusion1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeExclusion1 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1080:56: (iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF )
            // PsiInternalContextFinderTestLanguage.g:1081:2: iv_ruleNodeExclusion1= ruleNodeExclusion1 EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion1=ruleNodeExclusion1();

            state._fsp--;

             current =iv_ruleNodeExclusion1; 
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
    // $ANTLR end "entryRuleNodeExclusion1"


    // $ANTLR start "ruleNodeExclusion1"
    // PsiInternalContextFinderTestLanguage.g:1087:1: ruleNodeExclusion1 returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleNodeExclusion1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1088:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalContextFinderTestLanguage.g:1089:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalContextFinderTestLanguage.g:1089:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalContextFinderTestLanguage.g:1090:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalContextFinderTestLanguage.g:1090:3: (otherlv_0= RULE_ID )
            // PsiInternalContextFinderTestLanguage.g:1091:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getNodeExclusion1_RefModelCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleNodeExclusion1"


    // $ANTLR start "entryRuleNodeExclusion2"
    // PsiInternalContextFinderTestLanguage.g:1109:1: entryRuleNodeExclusion2 returns [Boolean current=false] : iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF ;
    public final Boolean entryRuleNodeExclusion2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeExclusion2 = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1109:56: (iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF )
            // PsiInternalContextFinderTestLanguage.g:1110:2: iv_ruleNodeExclusion2= ruleNodeExclusion2 EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion2=ruleNodeExclusion2();

            state._fsp--;

             current =iv_ruleNodeExclusion2; 
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
    // $ANTLR end "entryRuleNodeExclusion2"


    // $ANTLR start "ruleNodeExclusion2"
    // PsiInternalContextFinderTestLanguage.g:1116:1: ruleNodeExclusion2 returns [Boolean current=false] : ( (otherlv_0= RULE_STRING ) ) ;
    public final Boolean ruleNodeExclusion2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1117:1: ( ( (otherlv_0= RULE_STRING ) ) )
            // PsiInternalContextFinderTestLanguage.g:1118:2: ( (otherlv_0= RULE_STRING ) )
            {
            // PsiInternalContextFinderTestLanguage.g:1118:2: ( (otherlv_0= RULE_STRING ) )
            // PsiInternalContextFinderTestLanguage.g:1119:3: (otherlv_0= RULE_STRING )
            {
            // PsiInternalContextFinderTestLanguage.g:1119:3: (otherlv_0= RULE_STRING )
            // PsiInternalContextFinderTestLanguage.g:1120:4: otherlv_0= RULE_STRING
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getNodeExclusion2_RefModelCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleNodeExclusion2"


    // $ANTLR start "entryRuleNodeExclusion1List"
    // PsiInternalContextFinderTestLanguage.g:1138:1: entryRuleNodeExclusion1List returns [Boolean current=false] : iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF ;
    public final Boolean entryRuleNodeExclusion1List() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeExclusion1List = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1138:60: (iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF )
            // PsiInternalContextFinderTestLanguage.g:1139:2: iv_ruleNodeExclusion1List= ruleNodeExclusion1List EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion1ListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion1List=ruleNodeExclusion1List();

            state._fsp--;

             current =iv_ruleNodeExclusion1List; 
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
    // $ANTLR end "entryRuleNodeExclusion1List"


    // $ANTLR start "ruleNodeExclusion1List"
    // PsiInternalContextFinderTestLanguage.g:1145:1: ruleNodeExclusion1List returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) )+ ;
    public final Boolean ruleNodeExclusion1List() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1146:1: ( ( (otherlv_0= RULE_ID ) )+ )
            // PsiInternalContextFinderTestLanguage.g:1147:2: ( (otherlv_0= RULE_ID ) )+
            {
            // PsiInternalContextFinderTestLanguage.g:1147:2: ( (otherlv_0= RULE_ID ) )+
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
            	    // PsiInternalContextFinderTestLanguage.g:1148:3: (otherlv_0= RULE_ID )
            	    {
            	    // PsiInternalContextFinderTestLanguage.g:1148:3: (otherlv_0= RULE_ID )
            	    // PsiInternalContextFinderTestLanguage.g:1149:4: otherlv_0= RULE_ID
            	    {

            	    				if (!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

            	    				markLeaf(elementTypeProvider.getNodeExclusion1List_RefModelCrossReference_0ElementType());
            	    			
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    				doneLeaf(otherlv_0);
            	    			

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeExclusion1List"


    // $ANTLR start "entryRuleNodeExclusion2List"
    // PsiInternalContextFinderTestLanguage.g:1167:1: entryRuleNodeExclusion2List returns [Boolean current=false] : iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF ;
    public final Boolean entryRuleNodeExclusion2List() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNodeExclusion2List = null;


        try {
            // PsiInternalContextFinderTestLanguage.g:1167:60: (iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF )
            // PsiInternalContextFinderTestLanguage.g:1168:2: iv_ruleNodeExclusion2List= ruleNodeExclusion2List EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion2ListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeExclusion2List=ruleNodeExclusion2List();

            state._fsp--;

             current =iv_ruleNodeExclusion2List; 
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
    // $ANTLR end "entryRuleNodeExclusion2List"


    // $ANTLR start "ruleNodeExclusion2List"
    // PsiInternalContextFinderTestLanguage.g:1174:1: ruleNodeExclusion2List returns [Boolean current=false] : ( (otherlv_0= RULE_STRING ) )+ ;
    public final Boolean ruleNodeExclusion2List() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1175:1: ( ( (otherlv_0= RULE_STRING ) )+ )
            // PsiInternalContextFinderTestLanguage.g:1176:2: ( (otherlv_0= RULE_STRING ) )+
            {
            // PsiInternalContextFinderTestLanguage.g:1176:2: ( (otherlv_0= RULE_STRING ) )+
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
            	    // PsiInternalContextFinderTestLanguage.g:1177:3: (otherlv_0= RULE_STRING )
            	    {
            	    // PsiInternalContextFinderTestLanguage.g:1177:3: (otherlv_0= RULE_STRING )
            	    // PsiInternalContextFinderTestLanguage.g:1178:4: otherlv_0= RULE_STRING
            	    {

            	    				if (!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

            	    				markLeaf(elementTypeProvider.getNodeExclusion2List_RefModelCrossReference_0ElementType());
            	    			
            	    otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_14); 

            	    				doneLeaf(otherlv_0);
            	    			

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeExclusion2List"


    // $ANTLR start "ruleValueExclusionTestEn1"
    // PsiInternalContextFinderTestLanguage.g:1196:1: ruleValueExclusionTestEn1 returns [Boolean current=false] : (enumLiteral_0= 'lit1' ) ;
    public final Boolean ruleValueExclusionTestEn1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1197:1: ( (enumLiteral_0= 'lit1' ) )
            // PsiInternalContextFinderTestLanguage.g:1198:2: (enumLiteral_0= 'lit1' )
            {
            // PsiInternalContextFinderTestLanguage.g:1198:2: (enumLiteral_0= 'lit1' )
            // PsiInternalContextFinderTestLanguage.g:1199:3: enumLiteral_0= 'lit1'
            {

            			markLeaf(elementTypeProvider.getValueExclusionTestEn1_Lit1EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleValueExclusionTestEn1"


    // $ANTLR start "ruleValueExclusionTestEn2"
    // PsiInternalContextFinderTestLanguage.g:1210:1: ruleValueExclusionTestEn2 returns [Boolean current=false] : (enumLiteral_0= 'lit2' ) ;
    public final Boolean ruleValueExclusionTestEn2() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalContextFinderTestLanguage.g:1211:1: ( (enumLiteral_0= 'lit2' ) )
            // PsiInternalContextFinderTestLanguage.g:1212:2: (enumLiteral_0= 'lit2' )
            {
            // PsiInternalContextFinderTestLanguage.g:1212:2: (enumLiteral_0= 'lit2' )
            // PsiInternalContextFinderTestLanguage.g:1213:3: enumLiteral_0= 'lit2'
            {

            			markLeaf(elementTypeProvider.getValueExclusionTestEn2_Lit2EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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