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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'1'", "'2'", "'3'", "'4'", "'prefix'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:59:1: ruleRoot : (otherlv_0= 'test' ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:59:9: ( (otherlv_0= 'test' ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:60:2: (otherlv_0= 'test' ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:60:2: (otherlv_0= 'test' ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:61:3: otherlv_0= 'test' ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot79); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:68:3: ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 15:
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:69:4: ruleSimple
                    {

                    				markComposite(elementTypeProvider.getRoot_SimpleParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleRoot97);
                    ruleSimple();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:77:4: ruleDelegation
                    {

                    				markComposite(elementTypeProvider.getRoot_DelegationParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_ruleRoot121);
                    ruleDelegation();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:85:4: ruleUnassigned
                    {

                    				markComposite(elementTypeProvider.getRoot_UnassignedParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_ruleRoot145);
                    ruleUnassigned();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:93:4: rulePrefixedUnassigned
                    {

                    				markComposite(elementTypeProvider.getRoot_PrefixedUnassignedParserRuleCall_1_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_ruleRoot169);
                    rulePrefixedUnassigned();

                    state._fsp--;


                    				doneComposite();
                    			

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleSimple"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:105:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:105:16: ( ruleSimple EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:106:2: ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple194);
            ruleSimple();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple200); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:112:1: ruleSimple : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleSimple() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:112:11: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:113:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:113:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:114:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple219); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimple_DigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:121:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:122:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:122:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:123:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple246); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:136:1: entryRuleDelegation : ruleDelegation EOF ;
    public final void entryRuleDelegation() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:136:20: ( ruleDelegation EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:137:2: ruleDelegation EOF
            {
             markComposite(elementTypeProvider.getDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_entryRuleDelegation277);
            ruleDelegation();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegation283); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:143:1: ruleDelegation : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final void ruleDelegation() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:143:15: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:144:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:144:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:145:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDelegation302); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDelegation_DigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:152:3: ( (lv_delegate_1_0= ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:153:4: (lv_delegate_1_0= ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:153:4: (lv_delegate_1_0= ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:154:5: lv_delegate_1_0= ruleDelegate
            {

            					markComposite(elementTypeProvider.getDelegation_DelegateDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleDelegation329);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:167:1: entryRuleUnassigned : ruleUnassigned EOF ;
    public final void entryRuleUnassigned() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:167:20: ( ruleUnassigned EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:168:2: ruleUnassigned EOF
            {
             markComposite(elementTypeProvider.getUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_entryRuleUnassigned360);
            ruleUnassigned();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassigned366); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:174:1: ruleUnassigned : (otherlv_0= '3' ruleDelegate ) ;
    public final void ruleUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:174:15: ( (otherlv_0= '3' ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:175:2: (otherlv_0= '3' ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:175:2: (otherlv_0= '3' ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:176:3: otherlv_0= '3' ruleDelegate
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassigned385); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassigned_DigitThreeKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getUnassigned_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleUnassigned397);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:194:1: entryRulePrefixedUnassigned : rulePrefixedUnassigned EOF ;
    public final void entryRulePrefixedUnassigned() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:194:28: ( rulePrefixedUnassigned EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:195:2: rulePrefixedUnassigned EOF
            {
             markComposite(elementTypeProvider.getPrefixedUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned417);
            rulePrefixedUnassigned();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedUnassigned423); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:201:1: rulePrefixedUnassigned : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final void rulePrefixedUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:201:23: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:202:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:202:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:203:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePrefixedUnassigned442); 

            			doneLeaf(otherlv_0, elementTypeProvider.getPrefixedUnassigned_DigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:210:3: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:211:4: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:211:4: (lv_delegate_1_0= rulePrefixedDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:212:5: lv_delegate_1_0= rulePrefixedDelegate
            {

            					markComposite(elementTypeProvider.getPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned469);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:225:1: entryRulePrefixedDelegate : rulePrefixedDelegate EOF ;
    public final void entryRulePrefixedDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:225:26: ( rulePrefixedDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:226:2: rulePrefixedDelegate EOF
            {
             markComposite(elementTypeProvider.getPrefixedDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate500);
            rulePrefixedDelegate();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedDelegate506); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:232:1: rulePrefixedDelegate : (otherlv_0= 'prefix' ruleDelegate ) ;
    public final void rulePrefixedDelegate() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:232:21: ( (otherlv_0= 'prefix' ruleDelegate ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:233:2: (otherlv_0= 'prefix' ruleDelegate )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:233:2: (otherlv_0= 'prefix' ruleDelegate )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:234:3: otherlv_0= 'prefix' ruleDelegate
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrefixedDelegate525); 

            			doneLeaf(otherlv_0, elementTypeProvider.getPrefixedDelegate_PrefixKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getPrefixedDelegate_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_rulePrefixedDelegate537);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:252:1: entryRuleDelegate : ruleDelegate EOF ;
    public final void entryRuleDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:252:18: ( ruleDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:253:2: ruleDelegate EOF
            {
             markComposite(elementTypeProvider.getDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_entryRuleDelegate557);
            ruleDelegate();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegate563); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:259:1: ruleDelegate : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleDelegate() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:259:13: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:260:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:260:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:261:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:261:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/idea/parser/antlr/internal/PsiInternalRegionAccessTestLanguage.g:262:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDelegate588); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType());
            			

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot79 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleRoot97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_ruleRoot121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_ruleRoot145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_ruleRoot169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimple219 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_entryRuleDelegation277 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegation283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleDelegation302 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleDelegation329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_entryRuleUnassigned360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassigned366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleUnassigned385 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleUnassigned397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned417 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedUnassigned423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rulePrefixedUnassigned442 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate500 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedDelegate506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rulePrefixedDelegate525 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_rulePrefixedDelegate537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegate_in_entryRuleDelegate557 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegate563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDelegate588 = new BitSet(new long[]{0x0000000000000002L});
    }


}