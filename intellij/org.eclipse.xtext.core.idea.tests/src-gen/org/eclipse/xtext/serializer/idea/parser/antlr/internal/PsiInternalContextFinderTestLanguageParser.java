package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:59:1: ruleModel : ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
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

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:59:10: ( ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:60:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:60:2: ( (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) ) | (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) ) | (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) ) | (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) ) | (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) ) | (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) ) | (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:61:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:61:3: (otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:62:4: otherlv_0= '#0' ( (lv_model_1_0= ruleModel2 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel89); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getModel_NumberSignDigitZeroKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:69:4: ( (lv_model_1_0= ruleModel2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:70:5: (lv_model_1_0= ruleModel2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:70:5: (lv_model_1_0= ruleModel2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:71:6: lv_model_1_0= ruleModel2
                    {

                    						markComposite(elementTypeProvider.getModel_ModelModel2ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleModel2_in_ruleModel121);
                    ruleModel2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:82:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:82:3: (otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:83:4: otherlv_2= '#1' ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel167); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getModel_NumberSignDigitOneKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:90:4: ( ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:91:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:91:5: ( (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:92:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:92:6: (lv_attributeExclusion_3_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_3_2= ruleAttributeExclusionTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:93:7: lv_attributeExclusion_3_1= ruleAttributeExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_ruleModel208);
                            ruleAttributeExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:101:7: lv_attributeExclusion_3_2= ruleAttributeExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_ruleModel246);
                            ruleAttributeExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:113:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:113:3: (otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:114:4: otherlv_4= '#2' ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel300); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_NumberSignDigitTwoKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:121:4: ( ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:122:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:122:5: ( (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:123:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:123:6: (lv_nestedType_5_1= ruleNestedTypeTest1 | lv_nestedType_5_2= ruleNestedTypeTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:124:7: lv_nestedType_5_1= ruleNestedTypeTest1
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_ruleModel341);
                            ruleNestedTypeTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:132:7: lv_nestedType_5_2= ruleNestedTypeTest2
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_ruleModel379);
                            ruleNestedTypeTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:144:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:144:3: (otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:145:4: otherlv_6= '#3' ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel433); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getModel_NumberSignDigitThreeKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:152:4: ( ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:153:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:153:5: ( (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:154:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:154:6: (lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:155:7: lv_nestedTypeRecursiveTest2_7_1= ruleNestedTypeRecursiveTest1
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel474);
                            ruleNestedTypeRecursiveTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:163:7: lv_nestedTypeRecursiveTest2_7_2= ruleNestedTypeRecursiveTest2
                            {

                            							markComposite(elementTypeProvider.getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel512);
                            ruleNestedTypeRecursiveTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:175:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:175:3: (otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:176:4: otherlv_8= '#4' ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel566); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_NumberSignDigitFourKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:183:4: ( ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:184:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:184:5: ( (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:185:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:185:6: (lv_parentRef_9_1= ruleParentRefTest1 | lv_parentRef_9_2= ruleParentRefTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:186:7: lv_parentRef_9_1= ruleParentRefTest1
                            {

                            							markComposite(elementTypeProvider.getModel_ParentRefParentRefTest1ParserRuleCall_4_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_ruleModel607);
                            ruleParentRefTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:194:7: lv_parentRef_9_2= ruleParentRefTest2
                            {

                            							markComposite(elementTypeProvider.getModel_ParentRefParentRefTest2ParserRuleCall_4_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_ruleModel645);
                            ruleParentRefTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:206:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:206:3: (otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:207:4: otherlv_10= '#5' ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel699); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getModel_NumberSignDigitFiveKeyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:214:4: ( ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:215:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:215:5: ( (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:216:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:216:6: (lv_quantityExclusion_11_1= ruleQuantityExclusionTest1 | lv_quantityExclusion_11_2= ruleQuantityExclusionTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:217:7: lv_quantityExclusion_11_1= ruleQuantityExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest1_in_ruleModel740);
                            ruleQuantityExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:225:7: lv_quantityExclusion_11_2= ruleQuantityExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest2_in_ruleModel778);
                            ruleQuantityExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:237:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:237:3: (otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:238:4: otherlv_12= '#6' ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel832); 

                    				doneLeaf(otherlv_12, elementTypeProvider.getModel_NumberSignDigitSixKeyword_6_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:245:4: ( ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:246:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:246:5: ( (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:247:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:247:6: (lv_valueExclusion_13_1= ruleValueExclusionTest1 | lv_valueExclusion_13_2= ruleValueExclusionTest2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:248:7: lv_valueExclusion_13_1= ruleValueExclusionTest1
                            {

                            							markComposite(elementTypeProvider.getModel_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest1_in_ruleModel873);
                            ruleValueExclusionTest1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:256:7: lv_valueExclusion_13_2= ruleValueExclusionTest2
                            {

                            							markComposite(elementTypeProvider.getModel_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest2_in_ruleModel911);
                            ruleValueExclusionTest2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:268:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:268:3: (otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:269:4: otherlv_14= '#7' ( (lv_name_15_0= RULE_STRING ) ) ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel965); 

                    				doneLeaf(otherlv_14, elementTypeProvider.getModel_NumberSignDigitSevenKeyword_7_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:276:4: ( (lv_name_15_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:277:5: (lv_name_15_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:277:5: (lv_name_15_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:278:6: lv_name_15_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_name_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel997); 

                    						doneLeaf(lv_name_15_0, elementTypeProvider.getModel_NameSTRINGTerminalRuleCall_7_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:287:4: ( ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:288:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:288:5: ( (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:289:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:289:6: (lv_nodeExclusion_16_1= ruleNodeExclusion1 | lv_nodeExclusion_16_2= ruleNodeExclusion2 )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:290:7: lv_nodeExclusion_16_1= ruleNodeExclusion1
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1_in_ruleModel1051);
                            ruleNodeExclusion1();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:298:7: lv_nodeExclusion_16_2= ruleNodeExclusion2
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2_in_ruleModel1089);
                            ruleNodeExclusion2();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:310:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:310:3: (otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:311:4: otherlv_17= '#8' ( (lv_name_18_0= RULE_STRING ) ) ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel1143); 

                    				doneLeaf(otherlv_17, elementTypeProvider.getModel_NumberSignDigitEightKeyword_8_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:318:4: ( (lv_name_18_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:319:5: (lv_name_18_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:319:5: (lv_name_18_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:320:6: lv_name_18_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_name_18_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel1175); 

                    						doneLeaf(lv_name_18_0, elementTypeProvider.getModel_NameSTRINGTerminalRuleCall_8_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:329:4: ( ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:330:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:330:5: ( (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:331:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:331:6: (lv_nodeExclusionList_19_1= ruleNodeExclusion1List | lv_nodeExclusionList_19_2= ruleNodeExclusion2List )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:332:7: lv_nodeExclusionList_19_1= ruleNodeExclusion1List
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1List_in_ruleModel1229);
                            ruleNodeExclusion1List();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:340:7: lv_nodeExclusionList_19_2= ruleNodeExclusion2List
                            {

                            							markComposite(elementTypeProvider.getModel_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2List_in_ruleModel1267);
                            ruleNodeExclusion2List();

                            state._fsp--;


                            							doneComposite();
                            						

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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModel2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:355:1: entryRuleModel2 : ruleModel2 EOF ;
    public final void entryRuleModel2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:355:16: ( ruleModel2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:356:2: ruleModel2 EOF
            {
             markComposite(elementTypeProvider.getModel2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel2_in_entryRuleModel21313);
            ruleModel2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel21319); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleModel2"


    // $ANTLR start "ruleModel2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:364:1: ruleModel2 : ( () otherlv_1= 'model' ) ;
    public final void ruleModel2() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:364:11: ( ( () otherlv_1= 'model' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:365:2: ( () otherlv_1= 'model' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:365:2: ( () otherlv_1= 'model' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:366:3: () otherlv_1= 'model'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:366:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:367:4: 
            {

            				precedeComposite(elementTypeProvider.getModel2_ModelAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel21355); 

            			doneLeaf(otherlv_1, elementTypeProvider.getModel2_ModelKeyword_1ElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel2"


    // $ANTLR start "entryRuleAttributeExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:383:1: entryRuleAttributeExclusionTest1 : ruleAttributeExclusionTest1 EOF ;
    public final void entryRuleAttributeExclusionTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:383:33: ( ruleAttributeExclusionTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:384:2: ruleAttributeExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getAttributeExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest11375);
            ruleAttributeExclusionTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest11381); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeExclusionTest1"


    // $ANTLR start "ruleAttributeExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:392:1: ruleAttributeExclusionTest1 : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final void ruleAttributeExclusionTest1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:392:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:393:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:393:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:394:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttributeExclusionTest11404); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAttributeExclusionTest1_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:401:3: ( (lv_attr1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:402:4: (lv_attr1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:402:4: (lv_attr1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:403:5: lv_attr1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest11431); 

            					doneLeaf(lv_attr1_1_0, elementTypeProvider.getAttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleAttributeExclusionTest1"


    // $ANTLR start "entryRuleAttributeExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:416:1: entryRuleAttributeExclusionTest2 : ruleAttributeExclusionTest2 EOF ;
    public final void entryRuleAttributeExclusionTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:416:33: ( ruleAttributeExclusionTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:417:2: ruleAttributeExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getAttributeExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest21462);
            ruleAttributeExclusionTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest21468); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeExclusionTest2"


    // $ANTLR start "ruleAttributeExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:425:1: ruleAttributeExclusionTest2 : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final void ruleAttributeExclusionTest2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:425:28: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:426:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:426:2: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:427:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAttributeExclusionTest21491); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAttributeExclusionTest2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:434:3: ( (lv_attr2_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:435:4: (lv_attr2_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:435:4: (lv_attr2_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:436:5: lv_attr2_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest21518); 

            					doneLeaf(lv_attr2_1_0, elementTypeProvider.getAttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleAttributeExclusionTest2"


    // $ANTLR start "entryRuleNestedTypeTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:449:1: entryRuleNestedTypeTest1 : ruleNestedTypeTest1 EOF ;
    public final void entryRuleNestedTypeTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:449:25: ( ruleNestedTypeTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:450:2: ruleNestedTypeTest1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest11549);
            ruleNestedTypeTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest11555); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeTest1"


    // $ANTLR start "ruleNestedTypeTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:458:1: ruleNestedTypeTest1 : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final void ruleNestedTypeTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:458:20: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:459:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:459:2: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:460:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:460:3: (lv_nested_0_0= ruleNestedTypeChild1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:461:4: lv_nested_0_0= ruleNestedTypeChild1
            {

            				markComposite(elementTypeProvider.getNestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest11584);
            ruleNestedTypeChild1();

            state._fsp--;


            				doneComposite();
            			

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeTest1"


    // $ANTLR start "entryRuleNestedTypeTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:473:1: entryRuleNestedTypeTest2 : ruleNestedTypeTest2 EOF ;
    public final void entryRuleNestedTypeTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:473:25: ( ruleNestedTypeTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:474:2: ruleNestedTypeTest2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest21609);
            ruleNestedTypeTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest21615); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeTest2"


    // $ANTLR start "ruleNestedTypeTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:482:1: ruleNestedTypeTest2 : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final void ruleNestedTypeTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:482:20: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:483:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:483:2: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:484:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:484:3: (lv_nested_0_0= ruleNestedTypeChild2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:485:4: lv_nested_0_0= ruleNestedTypeChild2
            {

            				markComposite(elementTypeProvider.getNestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21644);
            ruleNestedTypeChild2();

            state._fsp--;


            				doneComposite();
            			

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeTest2"


    // $ANTLR start "entryRuleNestedTypeChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:497:1: entryRuleNestedTypeChild1 : ruleNestedTypeChild1 EOF ;
    public final void entryRuleNestedTypeChild1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:497:26: ( ruleNestedTypeChild1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:498:2: ruleNestedTypeChild1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11669);
            ruleNestedTypeChild1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild11675); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeChild1"


    // $ANTLR start "ruleNestedTypeChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:506:1: ruleNestedTypeChild1 : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleNestedTypeChild1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:506:21: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:507:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:507:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:508:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeChild11698); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNestedTypeChild1_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:515:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:516:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:516:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:517:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild11725); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getNestedTypeChild1_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeChild1"


    // $ANTLR start "entryRuleNestedTypeChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:530:1: entryRuleNestedTypeChild2 : ruleNestedTypeChild2 EOF ;
    public final void entryRuleNestedTypeChild2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:530:26: ( ruleNestedTypeChild2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:531:2: ruleNestedTypeChild2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21756);
            ruleNestedTypeChild2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild21762); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeChild2"


    // $ANTLR start "ruleNestedTypeChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:539:1: ruleNestedTypeChild2 : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleNestedTypeChild2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:539:21: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:540:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:540:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:541:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNestedTypeChild21785); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNestedTypeChild2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:548:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:549:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:549:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:550:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild21812); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getNestedTypeChild2_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeChild2"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:563:1: entryRuleNestedTypeRecursiveTest1 : ruleNestedTypeRecursiveTest1 EOF ;
    public final void entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:563:34: ( ruleNestedTypeRecursiveTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:564:2: ruleNestedTypeRecursiveTest1 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeRecursiveTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11843);
            ruleNestedTypeRecursiveTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11849); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeRecursiveTest1"


    // $ANTLR start "ruleNestedTypeRecursiveTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:572:1: ruleNestedTypeRecursiveTest1 : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final void ruleNestedTypeRecursiveTest1() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:572:29: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:573:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:573:2: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:574:3: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:574:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:575:4: 
            {

            				precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNestedTypeRecursiveTest11885); 

            			doneLeaf(otherlv_1, elementTypeProvider.getNestedTypeRecursiveTest1_Kw1Keyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:587:3: ( () otherlv_3= '.' )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:588:4: () otherlv_3= '.'
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:588:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:589:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedTypeRecursiveTest11921); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getNestedTypeRecursiveTest1_FullStopKeyword_2_1ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeRecursiveTest1"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:606:1: entryRuleNestedTypeRecursiveTest2 : ruleNestedTypeRecursiveTest2 EOF ;
    public final void entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:606:34: ( ruleNestedTypeRecursiveTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:607:2: ruleNestedTypeRecursiveTest2 EOF
            {
             markComposite(elementTypeProvider.getNestedTypeRecursiveTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21947);
            ruleNestedTypeRecursiveTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21953); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNestedTypeRecursiveTest2"


    // $ANTLR start "ruleNestedTypeRecursiveTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:615:1: ruleNestedTypeRecursiveTest2 : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final void ruleNestedTypeRecursiveTest2() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:615:29: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:616:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:616:2: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:617:3: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:617:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:618:4: 
            {

            				precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNestedTypeRecursiveTest21989); 

            			doneLeaf(otherlv_1, elementTypeProvider.getNestedTypeRecursiveTest2_Kw2Keyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:630:3: ( () otherlv_3= '.' )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:631:4: () otherlv_3= '.'
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:631:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:632:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getNestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedTypeRecursiveTest22025); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getNestedTypeRecursiveTest2_FullStopKeyword_2_1ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleNestedTypeRecursiveTest2"


    // $ANTLR start "entryRuleParentRefTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:649:1: entryRuleParentRefTest1 : ruleParentRefTest1 EOF ;
    public final void entryRuleParentRefTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:649:24: ( ruleParentRefTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:650:2: ruleParentRefTest1 EOF
            {
             markComposite(elementTypeProvider.getParentRefTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest12051);
            ruleParentRefTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest12057); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleParentRefTest1"


    // $ANTLR start "ruleParentRefTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:658:1: ruleParentRefTest1 : (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) ;
    public final void ruleParentRefTest1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:658:19: ( (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:659:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:659:2: (otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:660:3: otherlv_0= 'kw1' ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParentRefTest12080); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParentRefTest1_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:667:3: ( (lv_child1_1_0= ruleParentRefTestChild1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:668:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:668:4: (lv_child1_1_0= ruleParentRefTestChild1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:669:5: lv_child1_1_0= ruleParentRefTestChild1
            {

            					markComposite(elementTypeProvider.getParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest12107);
            ruleParentRefTestChild1();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleParentRefTest1"


    // $ANTLR start "entryRuleParentRefTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:682:1: entryRuleParentRefTest2 : ruleParentRefTest2 EOF ;
    public final void entryRuleParentRefTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:682:24: ( ruleParentRefTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:683:2: ruleParentRefTest2 EOF
            {
             markComposite(elementTypeProvider.getParentRefTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest22138);
            ruleParentRefTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTest22144); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleParentRefTest2"


    // $ANTLR start "ruleParentRefTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:691:1: ruleParentRefTest2 : (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) ;
    public final void ruleParentRefTest2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:691:19: ( (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:692:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:692:2: (otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:693:3: otherlv_0= 'kw2' ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParentRefTest22167); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParentRefTest2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:700:3: ( (lv_child2_1_0= ruleParentRefTestChild2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:701:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:701:4: (lv_child2_1_0= ruleParentRefTestChild2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:702:5: lv_child2_1_0= ruleParentRefTestChild2
            {

            					markComposite(elementTypeProvider.getParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest22194);
            ruleParentRefTestChild2();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleParentRefTest2"


    // $ANTLR start "entryRuleParentRefTestChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:715:1: entryRuleParentRefTestChild1 : ruleParentRefTestChild1 EOF ;
    public final void entryRuleParentRefTestChild1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:715:29: ( ruleParentRefTestChild1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:716:2: ruleParentRefTestChild1 EOF
            {
             markComposite(elementTypeProvider.getParentRefTestChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild12225);
            ruleParentRefTestChild1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild12231); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleParentRefTestChild1"


    // $ANTLR start "ruleParentRefTestChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:724:1: ruleParentRefTestChild1 : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) ;
    public final void ruleParentRefTestChild1() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:724:24: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:725:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:725:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:726:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:726:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:727:4: 
            {

            				precedeComposite(elementTypeProvider.getParentRefTestChild1_ParentRefTestChildAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParentRefTestChild12267); 

            			doneLeaf(otherlv_1, elementTypeProvider.getParentRefTestChild1_FooKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:739:3: ( (lv_child_2_0= ruleParentRefTestChild1 ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:740:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:740:4: (lv_child_2_0= ruleParentRefTestChild1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:741:5: lv_child_2_0= ruleParentRefTestChild1
                    {

                    					markComposite(elementTypeProvider.getParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild12294);
                    ruleParentRefTestChild1();

                    state._fsp--;


                    					doneComposite();
                    				

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
        return ;
    }
    // $ANTLR end "ruleParentRefTestChild1"


    // $ANTLR start "entryRuleParentRefTestChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:754:1: entryRuleParentRefTestChild2 : ruleParentRefTestChild2 EOF ;
    public final void entryRuleParentRefTestChild2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:754:29: ( ruleParentRefTestChild2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:755:2: ruleParentRefTestChild2 EOF
            {
             markComposite(elementTypeProvider.getParentRefTestChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild22326);
            ruleParentRefTestChild2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParentRefTestChild22332); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleParentRefTestChild2"


    // $ANTLR start "ruleParentRefTestChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:763:1: ruleParentRefTestChild2 : ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) ;
    public final void ruleParentRefTestChild2() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:763:24: ( ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:764:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:764:2: ( () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:765:3: () otherlv_1= 'foo' ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:765:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:766:4: 
            {

            				precedeComposite(elementTypeProvider.getParentRefTestChild2_ParentRefTestChildAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleParentRefTestChild22368); 

            			doneLeaf(otherlv_1, elementTypeProvider.getParentRefTestChild2_FooKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:778:3: ( (lv_child_2_0= ruleParentRefTestChild2 ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:779:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:779:4: (lv_child_2_0= ruleParentRefTestChild2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:780:5: lv_child_2_0= ruleParentRefTestChild2
                    {

                    					markComposite(elementTypeProvider.getParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild22395);
                    ruleParentRefTestChild2();

                    state._fsp--;


                    					doneComposite();
                    				

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
        return ;
    }
    // $ANTLR end "ruleParentRefTestChild2"


    // $ANTLR start "entryRuleQuantityExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:793:1: entryRuleQuantityExclusionTest1 : ruleQuantityExclusionTest1 EOF ;
    public final void entryRuleQuantityExclusionTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:793:32: ( ruleQuantityExclusionTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:794:2: ruleQuantityExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getQuantityExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest12427);
            ruleQuantityExclusionTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest12433); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleQuantityExclusionTest1"


    // $ANTLR start "ruleQuantityExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:802:1: ruleQuantityExclusionTest1 : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) ;
    public final void ruleQuantityExclusionTest1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:802:27: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:803:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:803:2: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:804:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ( (lv_attr2_2_0= RULE_ID ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleQuantityExclusionTest12456); 

            			doneLeaf(otherlv_0, elementTypeProvider.getQuantityExclusionTest1_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:811:3: ( (lv_attr1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:812:4: (lv_attr1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:812:4: (lv_attr1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:813:5: lv_attr1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12483); 

            					doneLeaf(lv_attr1_1_0, elementTypeProvider.getQuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:822:3: ( (lv_attr2_2_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:823:4: (lv_attr2_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:823:4: (lv_attr2_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:824:5: lv_attr2_2_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12521); 

                    					doneLeaf(lv_attr2_2_0, elementTypeProvider.getQuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0ElementType());
                    				

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
        return ;
    }
    // $ANTLR end "ruleQuantityExclusionTest1"


    // $ANTLR start "entryRuleQuantityExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:837:1: entryRuleQuantityExclusionTest2 : ruleQuantityExclusionTest2 EOF ;
    public final void entryRuleQuantityExclusionTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:837:32: ( ruleQuantityExclusionTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:838:2: ruleQuantityExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getQuantityExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22553);
            ruleQuantityExclusionTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantityExclusionTest22559); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleQuantityExclusionTest2"


    // $ANTLR start "ruleQuantityExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:846:1: ruleQuantityExclusionTest2 : (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) ;
    public final void ruleQuantityExclusionTest2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_attr1_1_0=null;
        Token lv_attr2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:846:27: ( (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:847:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:847:2: (otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:848:3: otherlv_0= 'kw2' ( (lv_attr1_1_0= RULE_ID ) )? ( (lv_attr2_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQuantityExclusionTest22582); 

            			doneLeaf(otherlv_0, elementTypeProvider.getQuantityExclusionTest2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:855:3: ( (lv_attr1_1_0= RULE_ID ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:856:4: (lv_attr1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:856:4: (lv_attr1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:857:5: lv_attr1_1_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22609); 

                    					doneLeaf(lv_attr1_1_0, elementTypeProvider.getQuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:866:3: ( (lv_attr2_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:867:4: (lv_attr2_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:867:4: (lv_attr2_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:868:5: lv_attr2_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_attr2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22648); 

            					doneLeaf(lv_attr2_2_0, elementTypeProvider.getQuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleQuantityExclusionTest2"


    // $ANTLR start "entryRuleValueExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:881:1: entryRuleValueExclusionTest1 : ruleValueExclusionTest1 EOF ;
    public final void entryRuleValueExclusionTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:881:29: ( ruleValueExclusionTest1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:882:2: ruleValueExclusionTest1 EOF
            {
             markComposite(elementTypeProvider.getValueExclusionTest1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12679);
            ruleValueExclusionTest1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest12685); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleValueExclusionTest1"


    // $ANTLR start "ruleValueExclusionTest1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:890:1: ruleValueExclusionTest1 : ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) ;
    public final void ruleValueExclusionTest1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:890:24: ( ( (lv_val_0_0= ruleValueExclusionTestEn1 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:891:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:891:2: ( (lv_val_0_0= ruleValueExclusionTestEn1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:892:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:892:3: (lv_val_0_0= ruleValueExclusionTestEn1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:893:4: lv_val_0_0= ruleValueExclusionTestEn1
            {

            				markComposite(elementTypeProvider.getValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12714);
            ruleValueExclusionTestEn1();

            state._fsp--;


            				doneComposite();
            			

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
        return ;
    }
    // $ANTLR end "ruleValueExclusionTest1"


    // $ANTLR start "entryRuleValueExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:905:1: entryRuleValueExclusionTest2 : ruleValueExclusionTest2 EOF ;
    public final void entryRuleValueExclusionTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:905:29: ( ruleValueExclusionTest2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:906:2: ruleValueExclusionTest2 EOF
            {
             markComposite(elementTypeProvider.getValueExclusionTest2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22739);
            ruleValueExclusionTest2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueExclusionTest22745); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleValueExclusionTest2"


    // $ANTLR start "ruleValueExclusionTest2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:914:1: ruleValueExclusionTest2 : ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) ;
    public final void ruleValueExclusionTest2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:914:24: ( ( (lv_val_0_0= ruleValueExclusionTestEn2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:915:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:915:2: ( (lv_val_0_0= ruleValueExclusionTestEn2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:916:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:916:3: (lv_val_0_0= ruleValueExclusionTestEn2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:917:4: lv_val_0_0= ruleValueExclusionTestEn2
            {

            				markComposite(elementTypeProvider.getValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22774);
            ruleValueExclusionTestEn2();

            state._fsp--;


            				doneComposite();
            			

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
        return ;
    }
    // $ANTLR end "ruleValueExclusionTest2"


    // $ANTLR start "entryRuleNodeExclusion1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:929:1: entryRuleNodeExclusion1 : ruleNodeExclusion1 EOF ;
    public final void entryRuleNodeExclusion1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:929:24: ( ruleNodeExclusion1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:930:2: ruleNodeExclusion1 EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1_in_entryRuleNodeExclusion12799);
            ruleNodeExclusion1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion12805); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNodeExclusion1"


    // $ANTLR start "ruleNodeExclusion1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:938:1: ruleNodeExclusion1 : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleNodeExclusion1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:938:19: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:939:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:939:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:940:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:940:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:941:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNodeExclusion12834); 

            				doneLeaf(otherlv_0, elementTypeProvider.getNodeExclusion1_RefModelCrossReference_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleNodeExclusion1"


    // $ANTLR start "entryRuleNodeExclusion2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:953:1: entryRuleNodeExclusion2 : ruleNodeExclusion2 EOF ;
    public final void entryRuleNodeExclusion2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:953:24: ( ruleNodeExclusion2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:954:2: ruleNodeExclusion2 EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2_in_entryRuleNodeExclusion22859);
            ruleNodeExclusion2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion22865); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNodeExclusion2"


    // $ANTLR start "ruleNodeExclusion2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:962:1: ruleNodeExclusion2 : ( (otherlv_0= RULE_STRING ) ) ;
    public final void ruleNodeExclusion2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:962:19: ( ( (otherlv_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:963:2: ( (otherlv_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:963:2: ( (otherlv_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:964:3: (otherlv_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:964:3: (otherlv_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:965:4: otherlv_0= RULE_STRING
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNodeExclusion22894); 

            				doneLeaf(otherlv_0, elementTypeProvider.getNodeExclusion2_RefModelCrossReference_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleNodeExclusion2"


    // $ANTLR start "entryRuleNodeExclusion1List"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:977:1: entryRuleNodeExclusion1List : ruleNodeExclusion1List EOF ;
    public final void entryRuleNodeExclusion1List() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:977:28: ( ruleNodeExclusion1List EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:978:2: ruleNodeExclusion1List EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion1ListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion1List_in_entryRuleNodeExclusion1List2919);
            ruleNodeExclusion1List();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion1List2925); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNodeExclusion1List"


    // $ANTLR start "ruleNodeExclusion1List"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:986:1: ruleNodeExclusion1List : ( (otherlv_0= RULE_ID ) )+ ;
    public final void ruleNodeExclusion1List() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:986:23: ( ( (otherlv_0= RULE_ID ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:987:2: ( (otherlv_0= RULE_ID ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:987:2: ( (otherlv_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:988:3: (otherlv_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:988:3: (otherlv_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:989:4: otherlv_0= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNodeExclusion1List2954); 

            	    				doneLeaf(otherlv_0, elementTypeProvider.getNodeExclusion1List_RefModelCrossReference_0ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleNodeExclusion1List"


    // $ANTLR start "entryRuleNodeExclusion2List"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1001:1: entryRuleNodeExclusion2List : ruleNodeExclusion2List EOF ;
    public final void entryRuleNodeExclusion2List() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1001:28: ( ruleNodeExclusion2List EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1002:2: ruleNodeExclusion2List EOF
            {
             markComposite(elementTypeProvider.getNodeExclusion2ListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeExclusion2List_in_entryRuleNodeExclusion2List2980);
            ruleNodeExclusion2List();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeExclusion2List2986); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNodeExclusion2List"


    // $ANTLR start "ruleNodeExclusion2List"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1010:1: ruleNodeExclusion2List : ( (otherlv_0= RULE_STRING ) )+ ;
    public final void ruleNodeExclusion2List() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1010:23: ( ( (otherlv_0= RULE_STRING ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1011:2: ( (otherlv_0= RULE_STRING ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1011:2: ( (otherlv_0= RULE_STRING ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1012:3: (otherlv_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1012:3: (otherlv_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1013:4: otherlv_0= RULE_STRING
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNodeExclusion2List3015); 

            	    				doneLeaf(otherlv_0, elementTypeProvider.getNodeExclusion2List_RefModelCrossReference_0ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleNodeExclusion2List"


    // $ANTLR start "ruleValueExclusionTestEn1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1025:1: ruleValueExclusionTestEn1 : (enumLiteral_0= 'lit1' ) ;
    public final void ruleValueExclusionTestEn1() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1025:26: ( (enumLiteral_0= 'lit1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1026:2: (enumLiteral_0= 'lit1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1026:2: (enumLiteral_0= 'lit1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1027:3: enumLiteral_0= 'lit1'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleValueExclusionTestEn13048); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getValueExclusionTestEn1_Lit1EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleValueExclusionTestEn1"


    // $ANTLR start "ruleValueExclusionTestEn2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1038:1: ruleValueExclusionTestEn2 : (enumLiteral_0= 'lit2' ) ;
    public final void ruleValueExclusionTestEn2() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1038:26: ( (enumLiteral_0= 'lit2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1039:2: (enumLiteral_0= 'lit2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1039:2: (enumLiteral_0= 'lit2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalContextFinderTestLanguage.g:1040:3: enumLiteral_0= 'lit2'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleValueExclusionTestEn23075); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getValueExclusionTestEn2_Lit2EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleValueExclusionTestEn2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel89 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleModel2_in_ruleModel121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel167 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_ruleModel208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_ruleModel246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel300 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_ruleModel341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_ruleModel379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel433 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel566 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_ruleModel607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_ruleModel645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel699 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_ruleModel740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_ruleModel778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel832 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_ruleModel873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_ruleModel911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel965 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel997 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNodeExclusion1_in_ruleModel1051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2_in_ruleModel1089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel1143 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel1175 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNodeExclusion1List_in_ruleModel1229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2List_in_ruleModel1267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel2_in_entryRuleModel21313 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel21319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel21355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest11375 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest11381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAttributeExclusionTest11404 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest11431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest21462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest21468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAttributeExclusionTest21491 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest21518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest11549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest11555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest11584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest21609 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest21615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest21644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild11669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild11675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeChild11698 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild11725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild21756 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild21762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNestedTypeChild21785 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild21812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest11843 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest11849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleNestedTypeRecursiveTest11885 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedTypeRecursiveTest11921 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNestedTypeRecursiveTest21989 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedTypeRecursiveTest22025 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleParentRefTest1_in_entryRuleParentRefTest12051 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest12057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParentRefTest12080 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTest12107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTest2_in_entryRuleParentRefTest22138 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTest22144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParentRefTest22167 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTest22194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_entryRuleParentRefTestChild12225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild12231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleParentRefTestChild12267 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild1_in_ruleParentRefTestChild12294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_entryRuleParentRefTestChild22326 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParentRefTestChild22332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleParentRefTestChild22368 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleParentRefTestChild2_in_ruleParentRefTestChild22395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest1_in_entryRuleQuantityExclusionTest12427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest12433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleQuantityExclusionTest12456 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12483 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest12521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantityExclusionTest2_in_entryRuleQuantityExclusionTest22553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantityExclusionTest22559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleQuantityExclusionTest22582 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22609 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuantityExclusionTest22648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest1_in_entryRuleValueExclusionTest12679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest12685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn1_in_ruleValueExclusionTest12714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTest2_in_entryRuleValueExclusionTest22739 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueExclusionTest22745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueExclusionTestEn2_in_ruleValueExclusionTest22774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion1_in_entryRuleNodeExclusion12799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion12805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNodeExclusion12834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion2_in_entryRuleNodeExclusion22859 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion22865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNodeExclusion22894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeExclusion1List_in_entryRuleNodeExclusion1List2919 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion1List2925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNodeExclusion1List2954 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleNodeExclusion2List_in_entryRuleNodeExclusion2List2980 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeExclusion2List2986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNodeExclusion2List3015 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_25_in_ruleValueExclusionTestEn13048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleValueExclusionTestEn23075 = new BitSet(new long[]{0x0000000000000002L});
    }


}