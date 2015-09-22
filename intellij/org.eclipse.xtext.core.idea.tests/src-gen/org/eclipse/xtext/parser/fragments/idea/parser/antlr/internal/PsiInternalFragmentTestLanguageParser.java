package org.eclipse.xtext.parser.fragments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalFragmentTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#8'", "'#9'", "':'", "'-'", "'<-'", "'.'"
    };
    public static final int RULE_ID=4;
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


        public PsiInternalFragmentTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFragmentTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFragmentTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalFragmentTestLanguage.g"; }



    	protected FragmentTestLanguageGrammarAccess grammarAccess;

    	protected FragmentTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalFragmentTestLanguageParser(PsiBuilder builder, TokenStream input, FragmentTestLanguageElementTypeProvider elementTypeProvider, FragmentTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragments";
    	}




    // $ANTLR start "entryRuleParserRuleFragments"
    // PsiInternalFragmentTestLanguage.g:52:1: entryRuleParserRuleFragments : ruleParserRuleFragments EOF ;
    public final void entryRuleParserRuleFragments() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:52:29: ( ruleParserRuleFragments EOF )
            // PsiInternalFragmentTestLanguage.g:53:2: ruleParserRuleFragments EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleFragmentsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRuleFragments();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParserRuleFragments"


    // $ANTLR start "ruleParserRuleFragments"
    // PsiInternalFragmentTestLanguage.g:58:1: ruleParserRuleFragments : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) ) ) ;
    public final void ruleParserRuleFragments() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // PsiInternalFragmentTestLanguage.g:58:24: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) ) ) )
            // PsiInternalFragmentTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:59:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) ) )
            // PsiInternalFragmentTestLanguage.g:60:3: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:60:3: ()
            // PsiInternalFragmentTestLanguage.g:61:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleFragments_ParserRuleFragmentsAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalFragmentTestLanguage.g:66:3: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
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
            case 16:
                {
                alt1=5;
                }
                break;
            case 17:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:67:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    // PsiInternalFragmentTestLanguage.g:68:5: otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:75:5: ( (lv_element_2_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguage.g:76:6: (lv_element_2_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguage.g:76:6: (lv_element_2_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguage.g:77:7: lv_element_2_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:88:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguage.g:89:5: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:96:5: ( (lv_element_4_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguage.g:97:6: (lv_element_4_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguage.g:97:6: (lv_element_4_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguage.g:98:7: lv_element_4_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:114:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:115:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:115:6: (otherlv_6= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:116:7: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType());
                      						
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_6);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalFragmentTestLanguage.g:127:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:127:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // PsiInternalFragmentTestLanguage.g:128:5: otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:135:5: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // PsiInternalFragmentTestLanguage.g:136:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // PsiInternalFragmentTestLanguage.g:136:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    // PsiInternalFragmentTestLanguage.g:137:7: lv_element_8_0= rulePRFNamedRefFirst
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedRefFirst();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalFragmentTestLanguage.g:148:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:148:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // PsiInternalFragmentTestLanguage.g:149:5: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_9);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:156:5: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // PsiInternalFragmentTestLanguage.g:157:6: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // PsiInternalFragmentTestLanguage.g:157:6: (lv_element_10_0= rulePRFNamedWithAction )
                    // PsiInternalFragmentTestLanguage.g:158:7: lv_element_10_0= rulePRFNamedWithAction
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedWithAction();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalFragmentTestLanguage.g:169:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:169:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // PsiInternalFragmentTestLanguage.g:170:5: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType());
                      				
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_11);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:177:5: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // PsiInternalFragmentTestLanguage.g:178:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // PsiInternalFragmentTestLanguage.g:178:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    // PsiInternalFragmentTestLanguage.g:179:7: lv_element_12_0= rulePRFNamedWithFQN
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedWithFQN();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalFragmentTestLanguage.g:190:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:190:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    // PsiInternalFragmentTestLanguage.g:191:5: otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:198:5: ( (lv_element_14_0= rulePRFWithPredicate ) )
                    // PsiInternalFragmentTestLanguage.g:199:6: (lv_element_14_0= rulePRFWithPredicate )
                    {
                    // PsiInternalFragmentTestLanguage.g:199:6: (lv_element_14_0= rulePRFWithPredicate )
                    // PsiInternalFragmentTestLanguage.g:200:7: lv_element_14_0= rulePRFWithPredicate
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFWithPredicate();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

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
        return ;
    }
    // $ANTLR end "ruleParserRuleFragments"


    // $ANTLR start "entryRulePRFNamed"
    // PsiInternalFragmentTestLanguage.g:215:1: entryRulePRFNamed : rulePRFNamed EOF ;
    public final void entryRulePRFNamed() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:215:18: ( rulePRFNamed EOF )
            // PsiInternalFragmentTestLanguage.g:216:2: rulePRFNamed EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamed();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRFNamed"


    // $ANTLR start "rulePRFNamed"
    // PsiInternalFragmentTestLanguage.g:221:1: rulePRFNamed : ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? ) ;
    public final void rulePRFNamed() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalFragmentTestLanguage.g:221:13: ( ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? ) )
            // PsiInternalFragmentTestLanguage.g:222:2: ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:222:2: ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? )
            // PsiInternalFragmentTestLanguage.g:223:3: rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            rulePRFNamedFragment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:230:3: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:231:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:231:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguage.g:232:5: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFNamed_ColonKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:239:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:240:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:240:6: (otherlv_2= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:241:7: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType());
                      						
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_2);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:252:4: (otherlv_3= '-' rulePRFNamedRef )
                    {
                    // PsiInternalFragmentTestLanguage.g:252:4: (otherlv_3= '-' rulePRFNamedRef )
                    // PsiInternalFragmentTestLanguage.g:253:5: otherlv_3= '-' rulePRFNamedRef
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFNamed_HyphenMinusKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "rulePRFNamed"


    // $ANTLR start "entryRulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguage.g:273:1: entryRulePRFNamedRefFirst : rulePRFNamedRefFirst EOF ;
    public final void entryRulePRFNamedRefFirst() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:273:26: ( rulePRFNamedRefFirst EOF )
            // PsiInternalFragmentTestLanguage.g:274:2: rulePRFNamedRefFirst EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedRefFirstElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedRefFirst();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRFNamedRefFirst"


    // $ANTLR start "rulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguage.g:279:1: rulePRFNamedRefFirst : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment ) ;
    public final void rulePRFNamedRefFirst() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:279:21: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment ) )
            // PsiInternalFragmentTestLanguage.g:280:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment )
            {
            // PsiInternalFragmentTestLanguage.g:280:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment )
            // PsiInternalFragmentTestLanguage.g:281:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment
            {
            // PsiInternalFragmentTestLanguage.g:281:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:282:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:282:4: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:283:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType());
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePRFNamedFragment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "rulePRFNamedRefFirst"


    // $ANTLR start "entryRulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguage.g:310:1: entryRulePRFNamedWithAction : rulePRFNamedWithAction EOF ;
    public final void entryRulePRFNamedWithAction() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:310:28: ( rulePRFNamedWithAction EOF )
            // PsiInternalFragmentTestLanguage.g:311:2: rulePRFNamedWithAction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedWithActionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedWithAction();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRFNamedWithAction"


    // $ANTLR start "rulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguage.g:316:1: rulePRFNamedWithAction : ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final void rulePRFNamedWithAction() throws RecognitionException {
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            // PsiInternalFragmentTestLanguage.g:316:23: ( ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // PsiInternalFragmentTestLanguage.g:317:2: ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:317:2: ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // PsiInternalFragmentTestLanguage.g:318:3: rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_3);
            rulePRFNamed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:325:3: ()
            // PsiInternalFragmentTestLanguage.g:326:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalFragmentTestLanguage.g:331:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:332:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:332:4: (lv_name_2_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:333:5: lv_name_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_2_0);
              				
            }

            }


            }

            // PsiInternalFragmentTestLanguage.g:342:3: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:343:4: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:343:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:344:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:344:5: (otherlv_3= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:345:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType());
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_3);
                      					
                    }

                    }


                    }

                    // PsiInternalFragmentTestLanguage.g:354:4: ( (otherlv_4= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:355:5: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:355:5: (otherlv_4= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:356:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType());
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_4);
                      					
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
        return ;
    }
    // $ANTLR end "rulePRFNamedWithAction"


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguage.g:370:1: entryRulePRFNamedWithFQN : rulePRFNamedWithFQN EOF ;
    public final void entryRulePRFNamedWithFQN() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:370:25: ( rulePRFNamedWithFQN EOF )
            // PsiInternalFragmentTestLanguage.g:371:2: rulePRFNamedWithFQN EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedWithFQNElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedWithFQN();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRFNamedWithFQN"


    // $ANTLR start "rulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguage.g:376:1: rulePRFNamedWithFQN : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final void rulePRFNamedWithFQN() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:376:20: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // PsiInternalFragmentTestLanguage.g:377:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:377:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // PsiInternalFragmentTestLanguage.g:378:3: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // PsiInternalFragmentTestLanguage.g:378:3: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalFragmentTestLanguage.g:379:4: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalFragmentTestLanguage.g:379:4: (lv_name_0_0= ruleFQN )
            // PsiInternalFragmentTestLanguage.g:380:5: lv_name_0_0= ruleFQN
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_8);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalFragmentTestLanguage.g:389:3: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:390:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalFragmentTestLanguage.g:397:4: ( ( ruleFQN2 ) )
                    // PsiInternalFragmentTestLanguage.g:398:5: ( ruleFQN2 )
                    {
                    // PsiInternalFragmentTestLanguage.g:398:5: ( ruleFQN2 )
                    // PsiInternalFragmentTestLanguage.g:399:6: ruleFQN2
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFQN2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
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
        return ;
    }
    // $ANTLR end "rulePRFNamedWithFQN"


    // $ANTLR start "entryRulePRFWithPredicate"
    // PsiInternalFragmentTestLanguage.g:413:1: entryRulePRFWithPredicate : rulePRFWithPredicate EOF ;
    public final void entryRulePRFWithPredicate() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:413:26: ( rulePRFWithPredicate EOF )
            // PsiInternalFragmentTestLanguage.g:414:2: rulePRFWithPredicate EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFWithPredicateElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFWithPredicate();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRFWithPredicate"


    // $ANTLR start "rulePRFWithPredicate"
    // PsiInternalFragmentTestLanguage.g:419:1: rulePRFWithPredicate : ( rulePRFNamedFragment ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )? ) ;
    public final void rulePRFWithPredicate() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:419:21: ( ( rulePRFNamedFragment ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )? ) )
            // PsiInternalFragmentTestLanguage.g:420:2: ( rulePRFNamedFragment ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:420:2: ( rulePRFNamedFragment ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )? )
            // PsiInternalFragmentTestLanguage.g:421:3: rulePRFNamedFragment ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_8);
            rulePRFNamedFragment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:428:3: ( ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) && (synpred1_PsiInternalFragmentTestLanguage())) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:429:4: ( ( '-' rulePRFNamedRef ) )=> (otherlv_1= '-' rulePRFNamedRef )
                    {
                    // PsiInternalFragmentTestLanguage.g:434:4: (otherlv_1= '-' rulePRFNamedRef )
                    // PsiInternalFragmentTestLanguage.g:435:5: otherlv_1= '-' rulePRFNamedRef
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFWithPredicate_HyphenMinusKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getPRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "rulePRFWithPredicate"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalFragmentTestLanguage.g:455:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:455:13: ( ruleFQN EOF )
            // PsiInternalFragmentTestLanguage.g:456:2: ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFQNElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalFragmentTestLanguage.g:461:1: ruleFQN : (this_ID_0= RULE_ID ( ruleSuffix )? ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:461:8: ( (this_ID_0= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguage.g:462:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguage.g:462:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguage.g:463:3: this_ID_0= RULE_ID ( ruleSuffix )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguage.g:470:3: ( ruleSuffix )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:471:4: ruleSuffix
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getFQN_SuffixParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFQN2"
    // PsiInternalFragmentTestLanguage.g:483:1: entryRuleFQN2 : ruleFQN2 EOF ;
    public final void entryRuleFQN2() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguage.g:483:14: ( ruleFQN2 EOF )
            // PsiInternalFragmentTestLanguage.g:484:2: ruleFQN2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFQN2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN2();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFQN2"


    // $ANTLR start "ruleFQN2"
    // PsiInternalFragmentTestLanguage.g:489:1: ruleFQN2 : (this_ID_0= RULE_ID ( ruleSuffix2 )* ) ;
    public final void ruleFQN2() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:489:9: ( (this_ID_0= RULE_ID ( ruleSuffix2 )* ) )
            // PsiInternalFragmentTestLanguage.g:490:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            {
            // PsiInternalFragmentTestLanguage.g:490:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            // PsiInternalFragmentTestLanguage.g:491:3: this_ID_0= RULE_ID ( ruleSuffix2 )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN2_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguage.g:498:3: ( ruleSuffix2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalFragmentTestLanguage.g:499:4: ruleSuffix2
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getFQN2_Suffix2ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    ruleSuffix2();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleFQN2"


    // $ANTLR start "ruleSuffix"
    // PsiInternalFragmentTestLanguage.g:512:1: ruleSuffix : (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) ;
    public final void ruleSuffix() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:512:11: ( (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguage.g:513:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguage.g:513:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguage.g:514:3: kw= '.' this_ID_1= RULE_ID ( ruleSuffix )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix_FullStopKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix_IDTerminalRuleCall_1ElementType());
              		
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_1);
              		
            }
            // PsiInternalFragmentTestLanguage.g:528:3: ( ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:529:4: ruleSuffix
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getSuffix_SuffixParserRuleCall_2ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleSuffix"


    // $ANTLR start "ruleSuffix2"
    // PsiInternalFragmentTestLanguage.g:542:1: ruleSuffix2 : (kw= '.' this_ID_1= RULE_ID ) ;
    public final void ruleSuffix2() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:542:12: ( (kw= '.' this_ID_1= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:543:2: (kw= '.' this_ID_1= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:543:2: (kw= '.' this_ID_1= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:544:3: kw= '.' this_ID_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix2_FullStopKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix2_IDTerminalRuleCall_1ElementType());
              		
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_1);
              		
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
    // $ANTLR end "ruleSuffix2"


    // $ANTLR start "rulePRFNamedFragment"
    // PsiInternalFragmentTestLanguage.g:563:1: rulePRFNamedFragment : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void rulePRFNamedFragment() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:563:21: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguage.g:564:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguage.g:564:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:565:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:565:3: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:566:4: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType());
              			
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_name_0_0);
              			
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
    // $ANTLR end "rulePRFNamedFragment"


    // $ANTLR start "rulePRFNamedRef"
    // PsiInternalFragmentTestLanguage.g:579:1: rulePRFNamedRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void rulePRFNamedRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:579:16: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguage.g:580:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguage.g:580:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:581:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:581:3: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:582:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getPRFNamedRef_RefPRFNamedCrossReference_0ElementType());
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_0);
              			
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
    // $ANTLR end "rulePRFNamedRef"

    // $ANTLR start synpred1_PsiInternalFragmentTestLanguage
    public final void synpred1_PsiInternalFragmentTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalFragmentTestLanguage.g:429:4: ( ( '-' rulePRFNamedRef ) )
        // PsiInternalFragmentTestLanguage.g:429:5: ( '-' rulePRFNamedRef )
        {
        // PsiInternalFragmentTestLanguage.g:429:5: ( '-' rulePRFNamedRef )
        // PsiInternalFragmentTestLanguage.g:430:5: '-' rulePRFNamedRef
        {
        match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return ;
        pushFollow(FollowSets000.FOLLOW_2);
        rulePRFNamedRef();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_PsiInternalFragmentTestLanguage

    // Delegated rules

    public final boolean synpred1_PsiInternalFragmentTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalFragmentTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000C0002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200002L});
    }


}