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
    public String getGrammarFileName() { return "PsiInternalRegionAccessTestLanguage.g"; }



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
    // PsiInternalRegionAccessTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:52:14: ( ruleRoot EOF )
            // PsiInternalRegionAccessTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRoot();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:58:1: ruleRoot : ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:58:9: ( ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:59:2: ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:59:2: ( ruleSimple | ruleDelegation | ruleUnassigned | rulePrefixedUnassigned | (otherlv_4= '5' ruleExpression ) | (otherlv_6= '6' ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:60:3: ruleSimple
                    {

                    			markComposite(elementTypeProvider.getRoot_SimpleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimple();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:68:3: ruleDelegation
                    {

                    			markComposite(elementTypeProvider.getRoot_DelegationParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDelegation();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:76:3: ruleUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_UnassignedParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassigned();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalRegionAccessTestLanguage.g:84:3: rulePrefixedUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_PrefixedUnassignedParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePrefixedUnassigned();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalRegionAccessTestLanguage.g:92:3: (otherlv_4= '5' ruleExpression )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:92:3: (otherlv_4= '5' ruleExpression )
                    // PsiInternalRegionAccessTestLanguage.g:93:4: otherlv_4= '5' ruleExpression
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitFiveKeyword_4_0ElementType());
                    			
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			

                    				markComposite(elementTypeProvider.getRoot_ExpressionParserRuleCall_4_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExpression();

                    state._fsp--;


                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 6 :
                    // PsiInternalRegionAccessTestLanguage.g:109:3: (otherlv_6= '6' ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:109:3: (otherlv_6= '6' ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:110:4: otherlv_6= '6' ruleMixed
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSixKeyword_5_0ElementType());
                    			
                    otherlv_6=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			

                    				markComposite(elementTypeProvider.getRoot_MixedParserRuleCall_5_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMixed();

                    state._fsp--;


                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 7 :
                    // PsiInternalRegionAccessTestLanguage.g:126:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:126:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:127:4: otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSevenKeyword_6_0ElementType());
                    			
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:134:4: ( (lv_mixed_9_0= ruleMixed ) )
                    // PsiInternalRegionAccessTestLanguage.g:135:5: (lv_mixed_9_0= ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:135:5: (lv_mixed_9_0= ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:136:6: lv_mixed_9_0= ruleMixed
                    {

                    						markComposite(elementTypeProvider.getRoot_MixedMixedParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:150:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:150:16: ( ruleSimple EOF )
            // PsiInternalRegionAccessTestLanguage.g:151:2: ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimple();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:156:1: ruleSimple : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleSimple() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:156:11: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:157:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:157:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:158:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimple_DigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:167:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:180:1: entryRuleDelegation : ruleDelegation EOF ;
    public final void entryRuleDelegation() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:180:20: ( ruleDelegation EOF )
            // PsiInternalRegionAccessTestLanguage.g:181:2: ruleDelegation EOF
            {
             markComposite(elementTypeProvider.getDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDelegation();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:186:1: ruleDelegation : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final void ruleDelegation() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:186:15: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:188:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {

            			markLeaf(elementTypeProvider.getDelegation_DigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:195:3: ( (lv_delegate_1_0= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:196:4: (lv_delegate_1_0= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:196:4: (lv_delegate_1_0= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:197:5: lv_delegate_1_0= ruleDelegate
            {

            					markComposite(elementTypeProvider.getDelegation_DelegateDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:210:1: entryRuleUnassigned : ruleUnassigned EOF ;
    public final void entryRuleUnassigned() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:210:20: ( ruleUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:211:2: ruleUnassigned EOF
            {
             markComposite(elementTypeProvider.getUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassigned();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:216:1: ruleUnassigned : (otherlv_0= '3' ruleDelegate ) ;
    public final void ruleUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:216:15: ( (otherlv_0= '3' ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:217:2: (otherlv_0= '3' ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:217:2: (otherlv_0= '3' ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:218:3: otherlv_0= '3' ruleDelegate
            {

            			markLeaf(elementTypeProvider.getUnassigned_DigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassigned_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:236:1: entryRulePrefixedUnassigned : rulePrefixedUnassigned EOF ;
    public final void entryRulePrefixedUnassigned() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:236:28: ( rulePrefixedUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:237:2: rulePrefixedUnassigned EOF
            {
             markComposite(elementTypeProvider.getPrefixedUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrefixedUnassigned();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:242:1: rulePrefixedUnassigned : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final void rulePrefixedUnassigned() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:242:23: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:243:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:243:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:244:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {

            			markLeaf(elementTypeProvider.getPrefixedUnassigned_DigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:251:3: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:252:4: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:252:4: (lv_delegate_1_0= rulePrefixedDelegate )
            // PsiInternalRegionAccessTestLanguage.g:253:5: lv_delegate_1_0= rulePrefixedDelegate
            {

            					markComposite(elementTypeProvider.getPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:266:1: entryRulePrefixedDelegate : rulePrefixedDelegate EOF ;
    public final void entryRulePrefixedDelegate() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:266:26: ( rulePrefixedDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:267:2: rulePrefixedDelegate EOF
            {
             markComposite(elementTypeProvider.getPrefixedDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrefixedDelegate();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:272:1: rulePrefixedDelegate : (otherlv_0= 'prefix' ruleDelegate ) ;
    public final void rulePrefixedDelegate() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:272:21: ( (otherlv_0= 'prefix' ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:273:2: (otherlv_0= 'prefix' ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:273:2: (otherlv_0= 'prefix' ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:274:3: otherlv_0= 'prefix' ruleDelegate
            {

            			markLeaf(elementTypeProvider.getPrefixedDelegate_PrefixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getPrefixedDelegate_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:292:1: entryRuleDelegate : ruleDelegate EOF ;
    public final void entryRuleDelegate() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:292:18: ( ruleDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:293:2: ruleDelegate EOF
            {
             markComposite(elementTypeProvider.getDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDelegate();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:298:1: ruleDelegate : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleDelegate() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:298:13: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:299:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:299:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:300:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:300:3: (lv_name_0_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:301:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:313:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:313:20: ( ruleExpression EOF )
            // PsiInternalRegionAccessTestLanguage.g:314:2: ruleExpression EOF
            {
             markComposite(elementTypeProvider.getExpressionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpression();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:319:1: ruleExpression : ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:319:15: ( ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // PsiInternalRegionAccessTestLanguage.g:320:2: ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:320:2: ( rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // PsiInternalRegionAccessTestLanguage.g:321:3: rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			markComposite(elementTypeProvider.getExpression_PrimaryParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            rulePrimary();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalRegionAccessTestLanguage.g:328:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:329:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:329:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:330:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getExpression_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:342:4: ( (lv_right_3_0= rulePrimary ) )
            	    // PsiInternalRegionAccessTestLanguage.g:343:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:343:5: (lv_right_3_0= rulePrimary )
            	    // PsiInternalRegionAccessTestLanguage.g:344:6: lv_right_3_0= rulePrimary
            	    {

            	    						markComposite(elementTypeProvider.getExpression_RightPrimaryParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
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
    // PsiInternalRegionAccessTestLanguage.g:358:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:358:17: ( rulePrimary EOF )
            // PsiInternalRegionAccessTestLanguage.g:359:2: rulePrimary EOF
            {
             markComposite(elementTypeProvider.getPrimaryElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrimary();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:364:1: rulePrimary : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized ) ;
    public final void rulePrimary() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:364:12: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized ) )
            // PsiInternalRegionAccessTestLanguage.g:365:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized )
            {
            // PsiInternalRegionAccessTestLanguage.g:365:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ruleParenthesized )
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
                    // PsiInternalRegionAccessTestLanguage.g:366:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:366:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:367:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:367:4: ()
                    // PsiInternalRegionAccessTestLanguage.g:368:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrimary_NamedAction_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalRegionAccessTestLanguage.g:373:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalRegionAccessTestLanguage.g:374:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:374:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalRegionAccessTestLanguage.g:375:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_name_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:386:3: ruleParenthesized
                    {

                    			markComposite(elementTypeProvider.getPrimary_ParenthesizedParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalRegionAccessTestLanguage.g:397:1: entryRuleParenthesized : ruleParenthesized EOF ;
    public final void entryRuleParenthesized() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:397:23: ( ruleParenthesized EOF )
            // PsiInternalRegionAccessTestLanguage.g:398:2: ruleParenthesized EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesized();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:403:1: ruleParenthesized : (otherlv_0= '(' ruleExpression otherlv_2= ')' ) ;
    public final void ruleParenthesized() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:403:18: ( (otherlv_0= '(' ruleExpression otherlv_2= ')' ) )
            // PsiInternalRegionAccessTestLanguage.g:404:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            {
            // PsiInternalRegionAccessTestLanguage.g:404:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            // PsiInternalRegionAccessTestLanguage.g:405:3: otherlv_0= '(' ruleExpression otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesized_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesized_ExpressionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_8);
            ruleExpression();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesized_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:430:1: entryRuleMixed : ruleMixed EOF ;
    public final void entryRuleMixed() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:430:15: ( ruleMixed EOF )
            // PsiInternalRegionAccessTestLanguage.g:431:2: ruleMixed EOF
            {
             markComposite(elementTypeProvider.getMixedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMixed();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:436:1: ruleMixed : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) ;
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
            // PsiInternalRegionAccessTestLanguage.g:436:10: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) )
            // PsiInternalRegionAccessTestLanguage.g:437:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:437:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            // PsiInternalRegionAccessTestLanguage.g:438:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            {

            			markLeaf(elementTypeProvider.getMixed_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:445:3: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalRegionAccessTestLanguage.g:446:4: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {

                    				markLeaf(elementTypeProvider.getMixed_UnassignedKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:453:4: (this_ID_2= RULE_ID | ruleDatatype )
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
                            // PsiInternalRegionAccessTestLanguage.g:454:5: this_ID_2= RULE_ID
                            {

                            					markLeaf(elementTypeProvider.getMixed_IDTerminalRuleCall_1_1_0ElementType());
                            				
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            					doneLeaf(this_ID_2);
                            				

                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:462:5: ruleDatatype
                            {

                            					markComposite(elementTypeProvider.getMixed_DatatypeParserRuleCall_1_1_1ElementType());
                            				
                            pushFollow(FollowSets000.FOLLOW_9);
                            ruleDatatype();

                            state._fsp--;


                            					doneComposite();
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // PsiInternalRegionAccessTestLanguage.g:471:3: ( () | ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:472:4: ()
                    {
                    // PsiInternalRegionAccessTestLanguage.g:472:4: ()
                    // PsiInternalRegionAccessTestLanguage.g:473:5: 
                    {

                    					precedeComposite(elementTypeProvider.getMixed_ActionAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:479:4: ruleMixed
                    {

                    				markComposite(elementTypeProvider.getMixed_MixedParserRuleCall_2_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleMixed();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:487:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:487:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
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
                            // PsiInternalRegionAccessTestLanguage.g:488:5: ( (lv_name_6_0= RULE_ID ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:488:5: ( (lv_name_6_0= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:489:6: (lv_name_6_0= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:489:6: (lv_name_6_0= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:490:7: lv_name_6_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType());
                            						
                            lv_name_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							doneLeaf(lv_name_6_0);
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:500:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:500:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:501:6: otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_ChildKeyword_2_2_1_0ElementType());
                            					
                            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_4); 

                            						doneLeaf(otherlv_7);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:508:6: ( (lv_eobj_8_0= ruleMixed ) )
                            // PsiInternalRegionAccessTestLanguage.g:509:7: (lv_eobj_8_0= ruleMixed )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:509:7: (lv_eobj_8_0= ruleMixed )
                            // PsiInternalRegionAccessTestLanguage.g:510:8: lv_eobj_8_0= ruleMixed
                            {

                            								markComposite(elementTypeProvider.getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_8);
                            ruleMixed();

                            state._fsp--;


                            								doneComposite();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // PsiInternalRegionAccessTestLanguage.g:521:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:521:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            // PsiInternalRegionAccessTestLanguage.g:522:6: (lv_datatype_9_0= ruleDatatype )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:522:6: (lv_datatype_9_0= ruleDatatype )
                            // PsiInternalRegionAccessTestLanguage.g:523:7: lv_datatype_9_0= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // PsiInternalRegionAccessTestLanguage.g:533:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:533:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:534:6: otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_RefKeyword_2_2_3_0ElementType());
                            					
                            otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                            						doneLeaf(otherlv_10);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:541:6: ( (otherlv_11= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:542:7: (otherlv_11= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:542:7: (otherlv_11= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:543:8: otherlv_11= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getMixed_RefMixedCrossReference_2_2_3_1_0ElementType());
                            							
                            otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            								doneLeaf(otherlv_11);
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // PsiInternalRegionAccessTestLanguage.g:554:5: ( (lv_lit_12_0= ruleEnum ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:554:5: ( (lv_lit_12_0= ruleEnum ) )
                            // PsiInternalRegionAccessTestLanguage.g:555:6: (lv_lit_12_0= ruleEnum )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:555:6: (lv_lit_12_0= ruleEnum )
                            // PsiInternalRegionAccessTestLanguage.g:556:7: lv_lit_12_0= ruleEnum
                            {

                            							markComposite(elementTypeProvider.getMixed_LitEnumEnumRuleCall_2_2_4_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
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
            		
            otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_13);
            		
            // PsiInternalRegionAccessTestLanguage.g:574:3: ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:575:4: () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:575:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:576:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMixed_AssignedActionChildAction_4_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getMixed_ActionKeyword_4_1ElementType());
            	    			
            	    otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_12); 

            	    				doneLeaf(otherlv_15);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:588:4: ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==20) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // PsiInternalRegionAccessTestLanguage.g:589:5: ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end'
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:589:5: ( (lv_body_16_0= ruleMixed ) )
            	            // PsiInternalRegionAccessTestLanguage.g:590:6: (lv_body_16_0= ruleMixed )
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:590:6: (lv_body_16_0= ruleMixed )
            	            // PsiInternalRegionAccessTestLanguage.g:591:7: lv_body_16_0= ruleMixed
            	            {

            	            							markComposite(elementTypeProvider.getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType());
            	            						
            	            pushFollow(FollowSets000.FOLLOW_13);
            	            ruleMixed();

            	            state._fsp--;


            	            							doneComposite();
            	            						

            	            }


            	            }


            	            					markLeaf(elementTypeProvider.getMixed_EndKeyword_4_2_1ElementType());
            	            				
            	            otherlv_17=(Token)match(input,26,FollowSets000.FOLLOW_11); 

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
    // PsiInternalRegionAccessTestLanguage.g:613:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // PsiInternalRegionAccessTestLanguage.g:613:18: ( ruleDatatype EOF )
            // PsiInternalRegionAccessTestLanguage.g:614:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:619:1: ruleDatatype : (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:619:13: ( (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:620:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:620:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:621:3: kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            kw=(Token)match(input,27,FollowSets000.FOLLOW_10); 

            			doneLeaf(kw);
            		
            // PsiInternalRegionAccessTestLanguage.g:628:3: ( ruleDatatype | this_ID_2= RULE_ID )
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
                    // PsiInternalRegionAccessTestLanguage.g:629:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getDatatype_DatatypeParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:637:4: this_ID_2= RULE_ID
                    {

                    				markLeaf(elementTypeProvider.getDatatype_IDTerminalRuleCall_1_1ElementType());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:649:1: ruleEnum : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final void ruleEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:649:9: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // PsiInternalRegionAccessTestLanguage.g:650:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:650:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:651:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:651:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalRegionAccessTestLanguage.g:652:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:661:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:661:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalRegionAccessTestLanguage.g:662:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,29,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002100002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    }


}