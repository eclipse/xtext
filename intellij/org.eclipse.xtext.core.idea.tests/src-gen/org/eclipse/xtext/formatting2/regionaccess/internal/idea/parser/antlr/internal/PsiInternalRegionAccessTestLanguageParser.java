package org.eclipse.xtext.formatting2.regionaccess.internal.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalRegionAccessTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'5'", "'6'", "'7'", "'1'", "'2'", "'3'", "'4'", "'prefix'", "'+'", "'('", "')'", "'unassigned'", "'child'", "'ref'", "'action'", "'end'", "'datatype'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
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
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalRegionAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalRegionAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalRegionAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g"; }



    	protected RegionAccessTestLanguageGrammarAccess grammarAccess;

    	protected RegionAccessTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalRegionAccessTestLanguageParser(PsiBuilder builder, TokenStream input, RegionAccessTestLanguageElementTypeProvider elementTypeProvider, RegionAccessTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot57); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:58:1: ruleRoot : ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:58:9: ( ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:59:2: ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:59:2: ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            int alt1=7;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 11:
                {
                alt1=5;
                }
                break;
            case 12:
                {
                alt1=6;
                }
                break;
            case 13:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:60:3: ruleSimple
                    {

                    			markComposite(elementTypeProvider.getRoot_SimpleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleRoot74);
                    ruleSimple();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:68:3: ruleDelegation
                    {

                    			markComposite(elementTypeProvider.getRoot_DelegationParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_ruleRoot94);
                    ruleDelegation();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:76:3: ruleUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_UnassignedParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_ruleRoot114);
                    ruleUnassigned();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:84:3: rulePrefixedUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_PrefixedUnassignedParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_ruleRoot134);
                    rulePrefixedUnassigned();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:92:3: (otherlv_4= '5' ruleExpression )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:92:3: (otherlv_4= '5' ruleExpression )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:93:4: otherlv_4= '5' ruleExpression
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitFiveKeyword_4_0ElementType());
                    			
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot162); 

                    				doneLeaf(otherlv_4);
                    			

                    				markComposite(elementTypeProvider.getRoot_ExpressionParserRuleCall_4_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRoot177);
                    ruleExpression();

                    state._fsp--;


                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:109:3: (otherlv_6= '6' ruleMixed )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:109:3: (otherlv_6= '6' ruleMixed )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:110:4: otherlv_6= '6' ruleMixed
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSixKeyword_5_0ElementType());
                    			
                    otherlv_6=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot210); 

                    				doneLeaf(otherlv_6);
                    			

                    				markComposite(elementTypeProvider.getRoot_MixedParserRuleCall_5_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleRoot225);
                    ruleMixed();

                    state._fsp--;


                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:126:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:126:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:127:4: otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSevenKeyword_6_0ElementType());
                    			
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot258); 

                    				doneLeaf(otherlv_8);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:134:4: ( (lv_mixed_9_0= ruleMixed ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:135:5: (lv_mixed_9_0= ruleMixed )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:135:5: (lv_mixed_9_0= ruleMixed )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:136:6: lv_mixed_9_0= ruleMixed
                    {

                    						markComposite(elementTypeProvider.getRoot_MixedMixedParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleRoot290);
                    ruleMixed();

                    state._fsp--;


                    						doneComposite();
                    					

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleSimple"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:150:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:150:16: ( ruleSimple EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:151:2: ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple328);
            ruleSimple();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple331); 

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
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:156:1: ruleSimple : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleSimple() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:156:11: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:157:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:157:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:158:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimple_DigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimple350); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:167:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple377); 

            					doneLeaf(lv_name_1_0);
            				

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
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleDelegation"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:180:1: entryRuleDelegation : ruleDelegation EOF ;
    public final void entryRuleDelegation() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:180:20: ( ruleDelegation EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:181:2: ruleDelegation EOF
            {
             markComposite(elementTypeProvider.getDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_entryRuleDelegation408);
            ruleDelegation();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegation411); 

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
    // $ANTLR end "entryRuleDelegation"


    // $ANTLR start "ruleDelegation"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:186:1: ruleDelegation : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final void ruleDelegation() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:186:15: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:188:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {

            			markLeaf(elementTypeProvider.getDelegation_DigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDelegation430); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:195:3: ( (lv_delegate_1_0= ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:196:4: (lv_delegate_1_0= ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:196:4: (lv_delegate_1_0= ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:197:5: lv_delegate_1_0= ruleDelegate
            {

            					markComposite(elementTypeProvider.getDelegation_DelegateDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleDelegation457);
            ruleDelegate();

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
    // $ANTLR end "ruleDelegation"


    // $ANTLR start "entryRuleUnassigned"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:210:1: entryRuleUnassigned : ruleUnassigned EOF ;
    public final void entryRuleUnassigned() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:210:20: ( ruleUnassigned EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:211:2: ruleUnassigned EOF
            {
             markComposite(elementTypeProvider.getUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_entryRuleUnassigned488);
            ruleUnassigned();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassigned491); 

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
    // $ANTLR end "entryRuleUnassigned"


    // $ANTLR start "ruleUnassigned"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:216:1: ruleUnassigned : (otherlv_0= '3' ruleDelegate ) ;
    public final void ruleUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:216:15: ( (otherlv_0= '3' ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:217:2: (otherlv_0= '3' ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:217:2: (otherlv_0= '3' ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:218:3: otherlv_0= '3' ruleDelegate
            {

            			markLeaf(elementTypeProvider.getUnassigned_DigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnassigned510); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassigned_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleUnassigned522);
            ruleDelegate();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "ruleUnassigned"


    // $ANTLR start "entryRulePrefixedUnassigned"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:236:1: entryRulePrefixedUnassigned : rulePrefixedUnassigned EOF ;
    public final void entryRulePrefixedUnassigned() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:236:28: ( rulePrefixedUnassigned EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:237:2: rulePrefixedUnassigned EOF
            {
             markComposite(elementTypeProvider.getPrefixedUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned542);
            rulePrefixedUnassigned();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedUnassigned545); 

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
    // $ANTLR end "entryRulePrefixedUnassigned"


    // $ANTLR start "rulePrefixedUnassigned"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:242:1: rulePrefixedUnassigned : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final void rulePrefixedUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:242:23: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:243:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:243:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:244:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {

            			markLeaf(elementTypeProvider.getPrefixedUnassigned_DigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrefixedUnassigned564); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:251:3: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:252:4: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:252:4: (lv_delegate_1_0= rulePrefixedDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:253:5: lv_delegate_1_0= rulePrefixedDelegate
            {

            					markComposite(elementTypeProvider.getPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned591);
            rulePrefixedDelegate();

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
    // $ANTLR end "rulePrefixedUnassigned"


    // $ANTLR start "entryRulePrefixedDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:266:1: entryRulePrefixedDelegate : rulePrefixedDelegate EOF ;
    public final void entryRulePrefixedDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:266:26: ( rulePrefixedDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:267:2: rulePrefixedDelegate EOF
            {
             markComposite(elementTypeProvider.getPrefixedDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate622);
            rulePrefixedDelegate();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedDelegate625); 

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
    // $ANTLR end "entryRulePrefixedDelegate"


    // $ANTLR start "rulePrefixedDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:272:1: rulePrefixedDelegate : (otherlv_0= 'prefix' ruleDelegate ) ;
    public final void rulePrefixedDelegate() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:272:21: ( (otherlv_0= 'prefix' ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:273:2: (otherlv_0= 'prefix' ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:273:2: (otherlv_0= 'prefix' ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:274:3: otherlv_0= 'prefix' ruleDelegate
            {

            			markLeaf(elementTypeProvider.getPrefixedDelegate_PrefixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_rulePrefixedDelegate644); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getPrefixedDelegate_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_rulePrefixedDelegate656);
            ruleDelegate();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "rulePrefixedDelegate"


    // $ANTLR start "entryRuleDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:292:1: entryRuleDelegate : ruleDelegate EOF ;
    public final void entryRuleDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:292:18: ( ruleDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:293:2: ruleDelegate EOF
            {
             markComposite(elementTypeProvider.getDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_entryRuleDelegate676);
            ruleDelegate();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegate679); 

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
    // $ANTLR end "entryRuleDelegate"


    // $ANTLR start "ruleDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:298:1: ruleDelegate : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleDelegate() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:298:13: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:299:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:299:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:300:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:300:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:301:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDelegate704); 

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleDelegate"


    // $ANTLR start "entryRuleExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:313:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:313:20: ( ruleExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:314:2: ruleExpression EOF
            {
             markComposite(elementTypeProvider.getExpressionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression729);
            ruleExpression();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression732); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:319:1: ruleExpression : ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:319:15: ( ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:320:2: ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:320:2: ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:321:3: rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			markComposite(elementTypeProvider.getExpression_PrimaryParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression749);
            rulePrimary();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:328:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:329:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:329:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:330:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getExpression_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleExpression785); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:342:4: ( (lv_right_3_0= rulePrimary ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:343:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:343:5: (lv_right_3_0= rulePrimary )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:344:6: lv_right_3_0= rulePrimary
            	    {

            	    						markComposite(elementTypeProvider.getExpression_RightPrimaryParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression817);
            	    rulePrimary();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimary"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:358:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:358:17: ( rulePrimary EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:359:2: rulePrimary EOF
            {
             markComposite(elementTypeProvider.getPrimaryElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_entryRulePrimary856);
            rulePrimary();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimary859); 

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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:364:1: rulePrimary : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized ) ;
    public final void rulePrimary() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:364:12: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:365:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:365:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:366:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:366:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:367:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:367:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:368:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrimary_NamedAction_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:373:4: ( (lv_name_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:374:5: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:374:5: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:375:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrimary915); 

                    						doneLeaf(lv_name_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:386:3: ruleParenthesized
                    {

                    			markComposite(elementTypeProvider.getPrimary_ParenthesizedParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_rulePrimary953);
                    ruleParenthesized();

                    state._fsp--;


                    			doneComposite();
                    		

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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleParenthesized"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:397:1: entryRuleParenthesized : ruleParenthesized EOF ;
    public final void entryRuleParenthesized() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:397:23: ( ruleParenthesized EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:398:2: ruleParenthesized EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_entryRuleParenthesized973);
            ruleParenthesized();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesized976); 

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
    // $ANTLR end "entryRuleParenthesized"


    // $ANTLR start "ruleParenthesized"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:403:1: ruleParenthesized : (otherlv_0= '(' ruleExpression otherlv_2= ')' ) ;
    public final void ruleParenthesized() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:403:18: ( (otherlv_0= '(' ruleExpression otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:404:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:404:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:405:3: otherlv_0= '(' ruleExpression otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesized_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParenthesized995); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesized_ExpressionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleParenthesized1007);
            ruleExpression();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesized_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParenthesized1021); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleParenthesized"


    // $ANTLR start "entryRuleMixed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:430:1: entryRuleMixed : ruleMixed EOF ;
    public final void entryRuleMixed() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:430:15: ( ruleMixed EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:431:2: ruleMixed EOF
            {
             markComposite(elementTypeProvider.getMixedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_entryRuleMixed1041);
            ruleMixed();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMixed1044); 

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
    // $ANTLR end "entryRuleMixed"


    // $ANTLR start "ruleMixed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:436:1: ruleMixed : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) ;
    public final void ruleMixed() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:436:10: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:437:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:437:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:438:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            {

            			markLeaf(elementTypeProvider.getMixed_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMixed1063); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:445:3: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:446:4: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {

                    				markLeaf(elementTypeProvider.getMixed_UnassignedKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMixed1083); 

                    				doneLeaf(otherlv_1);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:453:4: (this_ID_2= RULE_ID | ruleDatatype )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==27) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:454:5: this_ID_2= RULE_ID
                            {

                            					markLeaf(elementTypeProvider.getMixed_IDTerminalRuleCall_1_1_0ElementType());
                            				
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1107); 

                            					doneLeaf(this_ID_2);
                            				

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:462:5: ruleDatatype
                            {

                            					markComposite(elementTypeProvider.getMixed_DatatypeParserRuleCall_1_1_1ElementType());
                            				
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleMixed1135);
                            ruleDatatype();

                            state._fsp--;


                            					doneComposite();
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:471:3: ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
            case 23:
            case 24:
            case 27:
            case 28:
            case 29:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:472:4: ()
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:472:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:473:5: 
                    {

                    					precedeComposite(elementTypeProvider.getMixed_ActionAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:479:4: ruleMixed
                    {

                    				markComposite(elementTypeProvider.getMixed_MixedParserRuleCall_2_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1190);
                    ruleMixed();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:487:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:487:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    int alt6=5;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        alt6=1;
                        }
                        break;
                    case 23:
                        {
                        alt6=2;
                        }
                        break;
                    case 27:
                        {
                        alt6=3;
                        }
                        break;
                    case 24:
                        {
                        alt6=4;
                        }
                        break;
                    case 28:
                    case 29:
                        {
                        alt6=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:488:5: ( (lv_name_6_0= RULE_ID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:488:5: ( (lv_name_6_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:489:6: (lv_name_6_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:489:6: (lv_name_6_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:490:7: lv_name_6_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType());
                            						
                            lv_name_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1240); 

                            							doneLeaf(lv_name_6_0);
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:500:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:500:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:501:6: otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_ChildKeyword_2_2_1_0ElementType());
                            					
                            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMixed1293); 

                            						doneLeaf(otherlv_7);
                            					
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:508:6: ( (lv_eobj_8_0= ruleMixed ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:509:7: (lv_eobj_8_0= ruleMixed )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:509:7: (lv_eobj_8_0= ruleMixed )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:510:8: lv_eobj_8_0= ruleMixed
                            {

                            								markComposite(elementTypeProvider.getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1335);
                            ruleMixed();

                            state._fsp--;


                            								doneComposite();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:521:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:521:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:522:6: (lv_datatype_9_0= ruleDatatype )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:522:6: (lv_datatype_9_0= ruleDatatype )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:523:7: lv_datatype_9_0= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleMixed1406);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:533:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:533:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:534:6: otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_RefKeyword_2_2_3_0ElementType());
                            					
                            otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMixed1459); 

                            						doneLeaf(otherlv_10);
                            					
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:541:6: ( (otherlv_11= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:542:7: (otherlv_11= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:542:7: (otherlv_11= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:543:8: otherlv_11= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getMixed_RefMixedCrossReference_2_2_3_1_0ElementType());
                            							
                            otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1501); 

                            								doneLeaf(otherlv_11);
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:554:5: ( (lv_lit_12_0= ruleEnum ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:554:5: ( (lv_lit_12_0= ruleEnum ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:555:6: (lv_lit_12_0= ruleEnum )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:555:6: (lv_lit_12_0= ruleEnum )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:556:7: lv_lit_12_0= ruleEnum
                            {

                            							markComposite(elementTypeProvider.getMixed_LitEnumEnumRuleCall_2_2_4_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleEnum_in_ruleMixed1572);
                            ruleEnum();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getMixed_RightParenthesisKeyword_3ElementType());
            		
            otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMixed1612); 

            			doneLeaf(otherlv_13);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:574:3: ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:575:4: () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:575:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:576:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMixed_AssignedActionChildAction_4_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getMixed_ActionKeyword_4_1ElementType());
            	    			
            	    otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMixed1648); 

            	    				doneLeaf(otherlv_15);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:588:4: ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==20) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:589:5: ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end'
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:589:5: ( (lv_body_16_0= ruleMixed ) )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:590:6: (lv_body_16_0= ruleMixed )
            	            {
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:590:6: (lv_body_16_0= ruleMixed )
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:591:7: lv_body_16_0= ruleMixed
            	            {

            	            							markComposite(elementTypeProvider.getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType());
            	            						
            	            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1689);
            	            ruleMixed();

            	            state._fsp--;


            	            							doneComposite();
            	            						

            	            }


            	            }


            	            					markLeaf(elementTypeProvider.getMixed_EndKeyword_4_2_1ElementType());
            	            				
            	            otherlv_17=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMixed1724); 

            	            					doneLeaf(otherlv_17);
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
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
    // $ANTLR end "ruleMixed"


    // $ANTLR start "entryRuleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:613:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:613:18: ( ruleDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:614:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype1757);
            ruleDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype1760); 

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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:619:1: ruleDatatype : (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:619:13: ( (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:620:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:620:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:621:3: kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDatatype1779); 

            			doneLeaf(kw);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:628:3: ( ruleDatatype | this_ID_2= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:629:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getDatatype_DatatypeParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleDatatype1797);
                    ruleDatatype();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:637:4: this_ID_2= RULE_ID
                    {

                    				markLeaf(elementTypeProvider.getDatatype_IDTerminalRuleCall_1_1ElementType());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1823); 

                    				doneLeaf(this_ID_2);
                    			

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
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "ruleEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:649:1: ruleEnum : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final void ruleEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:649:9: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:650:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:650:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:651:3: (enumLiteral_0= 'lit1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:651:3: (enumLiteral_0= 'lit1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:652:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnum1861); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:661:3: (enumLiteral_1= 'lit2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:661:3: (enumLiteral_1= 'lit2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:662:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnum1894); 

                    				doneLeaf(enumLiteral_1);
                    			

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
    // $ANTLR end "ruleEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleRoot74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_ruleRoot94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_ruleRoot114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_ruleRoot134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot162 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRoot177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRoot210 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleRoot225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleRoot258 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleRoot290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimple350 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_entryRuleDelegation408 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegation411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleDelegation430 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleDelegation457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_entryRuleUnassigned488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassigned491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnassigned510 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleUnassigned522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned542 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedUnassigned545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rulePrefixedUnassigned564 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedDelegate625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rulePrefixedDelegate644 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_rulePrefixedDelegate656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegate_in_entryRuleDelegate676 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegate679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDelegate704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression729 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression749 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleExpression785 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression817 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary856 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimary859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrimary915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_rulePrimary953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized973 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleParenthesized995 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesized1007 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleParenthesized1021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMixed_in_entryRuleMixed1041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMixed1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMixed1063 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_22_in_ruleMixed1083 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1107 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleMixed1135 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1190 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1240 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_23_in_ruleMixed1293 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1335 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleMixed1406 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_24_in_ruleMixed1459 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1501 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_ruleEnum_in_ruleMixed1572 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMixed1612 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleMixed1648 = new BitSet(new long[]{0x0000000002100002L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1689 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleMixed1724 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1757 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleDatatype1779 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatype1797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEnum1861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEnum1894 = new BitSet(new long[]{0x0000000000000002L});
    }


}