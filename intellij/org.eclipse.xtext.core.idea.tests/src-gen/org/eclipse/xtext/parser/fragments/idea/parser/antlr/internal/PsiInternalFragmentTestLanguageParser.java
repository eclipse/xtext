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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#8'", "'#9'", "'#10'", "'#11'", "':'", "'-'", "'<-'", "'.'", "'('", "')'"
    };
    public static final int RULE_ID=4;
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
    // PsiInternalFragmentTestLanguage.g:52:1: entryRuleParserRuleFragments returns [Boolean current=false] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final Boolean entryRuleParserRuleFragments() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRuleFragments = null;


        try {
            // PsiInternalFragmentTestLanguage.g:52:61: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // PsiInternalFragmentTestLanguage.g:53:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleFragmentsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleFragments=ruleParserRuleFragments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleFragments; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParserRuleFragments"


    // $ANTLR start "ruleParserRuleFragments"
    // PsiInternalFragmentTestLanguage.g:59:1: ruleParserRuleFragments returns [Boolean current=false] : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) ;
    public final Boolean ruleParserRuleFragments() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Boolean lv_element_2_0 = null;

        Boolean lv_element_4_0 = null;

        Boolean lv_element_8_0 = null;

        Boolean lv_element_10_0 = null;

        Boolean lv_element_12_0 = null;

        Boolean lv_element_14_0 = null;

        Boolean lv_element_16_0 = null;

        Boolean lv_element_18_0 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:60:1: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) )
            // PsiInternalFragmentTestLanguage.g:61:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:61:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            // PsiInternalFragmentTestLanguage.g:62:3: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:62:3: ()
            // PsiInternalFragmentTestLanguage.g:63:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleFragments_ParserRuleFragmentsAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguage.g:69:3: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            int alt1=8;
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
            case 18:
                {
                alt1=7;
                }
                break;
            case 19:
                {
                alt1=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:70:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:70:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    // PsiInternalFragmentTestLanguage.g:71:5: otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:78:5: ( (lv_element_2_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguage.g:79:6: (lv_element_2_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguage.g:79:6: (lv_element_2_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguage.g:80:7: lv_element_2_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_2_0=rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:95:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:95:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguage.g:96:5: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:103:5: ( (lv_element_4_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguage.g:104:6: (lv_element_4_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguage.g:104:6: (lv_element_4_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguage.g:105:7: lv_element_4_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_element_4_0=rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:125:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:126:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:126:6: (otherlv_6= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:127:7: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType());
                      						
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_6);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalFragmentTestLanguage.g:144:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:144:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // PsiInternalFragmentTestLanguage.g:145:5: otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:152:5: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // PsiInternalFragmentTestLanguage.g:153:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // PsiInternalFragmentTestLanguage.g:153:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    // PsiInternalFragmentTestLanguage.g:154:7: lv_element_8_0= rulePRFNamedRefFirst
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_8_0=rulePRFNamedRefFirst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 4 :
                    // PsiInternalFragmentTestLanguage.g:169:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:169:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // PsiInternalFragmentTestLanguage.g:170:5: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_9);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:177:5: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // PsiInternalFragmentTestLanguage.g:178:6: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // PsiInternalFragmentTestLanguage.g:178:6: (lv_element_10_0= rulePRFNamedWithAction )
                    // PsiInternalFragmentTestLanguage.g:179:7: lv_element_10_0= rulePRFNamedWithAction
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_10_0=rulePRFNamedWithAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 5 :
                    // PsiInternalFragmentTestLanguage.g:194:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:194:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // PsiInternalFragmentTestLanguage.g:195:5: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType());
                      				
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_11);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:202:5: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // PsiInternalFragmentTestLanguage.g:203:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // PsiInternalFragmentTestLanguage.g:203:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    // PsiInternalFragmentTestLanguage.g:204:7: lv_element_12_0= rulePRFNamedWithFQN
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_12_0=rulePRFNamedWithFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 6 :
                    // PsiInternalFragmentTestLanguage.g:219:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:219:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    // PsiInternalFragmentTestLanguage.g:220:5: otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:227:5: ( (lv_element_14_0= rulePRFWithPredicate ) )
                    // PsiInternalFragmentTestLanguage.g:228:6: (lv_element_14_0= rulePRFWithPredicate )
                    {
                    // PsiInternalFragmentTestLanguage.g:228:6: (lv_element_14_0= rulePRFWithPredicate )
                    // PsiInternalFragmentTestLanguage.g:229:7: lv_element_14_0= rulePRFWithPredicate
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_14_0=rulePRFWithPredicate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 7 :
                    // PsiInternalFragmentTestLanguage.g:244:4: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:244:4: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    // PsiInternalFragmentTestLanguage.g:245:5: otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:252:5: ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    // PsiInternalFragmentTestLanguage.g:253:6: (lv_element_16_0= rulePRFNamedRecursive )
                    {
                    // PsiInternalFragmentTestLanguage.g:253:6: (lv_element_16_0= rulePRFNamedRecursive )
                    // PsiInternalFragmentTestLanguage.g:254:7: lv_element_16_0= rulePRFNamedRecursive
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_16_0=rulePRFNamedRecursive();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 8 :
                    // PsiInternalFragmentTestLanguage.g:269:4: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:269:4: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    // PsiInternalFragmentTestLanguage.g:270:5: otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:277:5: ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    // PsiInternalFragmentTestLanguage.g:278:6: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    {
                    // PsiInternalFragmentTestLanguage.g:278:6: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    // PsiInternalFragmentTestLanguage.g:279:7: lv_element_18_0= rulePRFNamedRecursiveFragment
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_18_0=rulePRFNamedRecursiveFragment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleParserRuleFragments"


    // $ANTLR start "entryRulePRFNamed"
    // PsiInternalFragmentTestLanguage.g:298:1: entryRulePRFNamed returns [Boolean current=false] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final Boolean entryRulePRFNamed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamed = null;


        try {
            // PsiInternalFragmentTestLanguage.g:298:50: (iv_rulePRFNamed= rulePRFNamed EOF )
            // PsiInternalFragmentTestLanguage.g:299:2: iv_rulePRFNamed= rulePRFNamed EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamed=rulePRFNamed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamed"


    // $ANTLR start "rulePRFNamed"
    // PsiInternalFragmentTestLanguage.g:305:1: rulePRFNamed returns [Boolean current=false] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final Boolean rulePRFNamed() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean this_PRFNamedFragment_0 = null;

        Boolean this_PRFNamedRef_4 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:306:1: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // PsiInternalFragmentTestLanguage.g:307:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:307:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // PsiInternalFragmentTestLanguage.g:308:3: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            {
            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PRFNamedFragment_0;
              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:320:3: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:321:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:321:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguage.g:322:5: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFNamed_ColonKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguage.g:329:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:330:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:330:6: (otherlv_2= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:331:7: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType());
                      						
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_2);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:348:4: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // PsiInternalFragmentTestLanguage.g:348:4: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // PsiInternalFragmentTestLanguage.g:349:5: otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFNamed_HyphenMinusKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      					markComposite(elementTypeProvider.getPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PRFNamedRef_4=rulePRFNamedRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_PRFNamedRef_4;
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
        return current;
    }
    // $ANTLR end "rulePRFNamed"


    // $ANTLR start "entryRulePRFNamedRecursive"
    // PsiInternalFragmentTestLanguage.g:374:1: entryRulePRFNamedRecursive returns [Boolean current=false] : iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF ;
    public final Boolean entryRulePRFNamedRecursive() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRecursive = null;


        try {
            // PsiInternalFragmentTestLanguage.g:374:59: (iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF )
            // PsiInternalFragmentTestLanguage.g:375:2: iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedRecursiveElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedRecursive=rulePRFNamedRecursive();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamedRecursive; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamedRecursive"


    // $ANTLR start "rulePRFNamedRecursive"
    // PsiInternalFragmentTestLanguage.g:381:1: rulePRFNamedRecursive returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) ;
    public final Boolean rulePRFNamedRecursive() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean this_RecursiveFromFragment_1 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:382:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) )
            // PsiInternalFragmentTestLanguage.g:383:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            {
            // PsiInternalFragmentTestLanguage.g:383:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            // PsiInternalFragmentTestLanguage.g:384:3: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current]
            {
            // PsiInternalFragmentTestLanguage.g:384:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:385:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:385:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:386:5: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedRecursive_NameIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_0_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getPRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_RecursiveFromFragment_1=ruleRecursiveFromFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RecursiveFromFragment_1;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedRecursive"


    // $ANTLR start "entryRulePRFNamedRecursiveFragment"
    // PsiInternalFragmentTestLanguage.g:417:1: entryRulePRFNamedRecursiveFragment returns [Boolean current=false] : iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF ;
    public final Boolean entryRulePRFNamedRecursiveFragment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRecursiveFragment = null;


        try {
            // PsiInternalFragmentTestLanguage.g:417:67: (iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF )
            // PsiInternalFragmentTestLanguage.g:418:2: iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedRecursiveFragmentElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedRecursiveFragment=rulePRFNamedRecursiveFragment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamedRecursiveFragment; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamedRecursiveFragment"


    // $ANTLR start "rulePRFNamedRecursiveFragment"
    // PsiInternalFragmentTestLanguage.g:424:1: rulePRFNamedRecursiveFragment returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) ;
    public final Boolean rulePRFNamedRecursiveFragment() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean this_RecursiveFragment_1 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:425:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) )
            // PsiInternalFragmentTestLanguage.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            {
            // PsiInternalFragmentTestLanguage.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            // PsiInternalFragmentTestLanguage.g:427:3: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current]
            {
            // PsiInternalFragmentTestLanguage.g:427:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:428:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:428:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:429:5: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_0_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getPRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_RecursiveFragment_1=ruleRecursiveFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RecursiveFragment_1;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedRecursiveFragment"


    // $ANTLR start "entryRulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguage.g:460:1: entryRulePRFNamedRefFirst returns [Boolean current=false] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final Boolean entryRulePRFNamedRefFirst() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRefFirst = null;


        try {
            // PsiInternalFragmentTestLanguage.g:460:58: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // PsiInternalFragmentTestLanguage.g:461:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedRefFirstElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedRefFirst=rulePRFNamedRefFirst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamedRefFirst; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamedRefFirst"


    // $ANTLR start "rulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguage.g:467:1: rulePRFNamedRefFirst returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final Boolean rulePRFNamedRefFirst() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Boolean this_PRFNamedFragment_2 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:468:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // PsiInternalFragmentTestLanguage.g:469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // PsiInternalFragmentTestLanguage.g:469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // PsiInternalFragmentTestLanguage.g:470:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // PsiInternalFragmentTestLanguage.g:470:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:471:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:471:4: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:472:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType());
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_PRFNamedFragment_2=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PRFNamedFragment_2;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedRefFirst"


    // $ANTLR start "entryRulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguage.g:510:1: entryRulePRFNamedWithAction returns [Boolean current=false] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final Boolean entryRulePRFNamedWithAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedWithAction = null;


        try {
            // PsiInternalFragmentTestLanguage.g:510:60: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // PsiInternalFragmentTestLanguage.g:511:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedWithActionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithAction=rulePRFNamedWithAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamedWithAction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamedWithAction"


    // $ANTLR start "rulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguage.g:517:1: rulePRFNamedWithAction returns [Boolean current=false] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final Boolean rulePRFNamedWithAction() throws RecognitionException {
        Boolean current = false;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean this_PRFNamed_0 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:518:1: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // PsiInternalFragmentTestLanguage.g:519:2: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:519:2: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // PsiInternalFragmentTestLanguage.g:520:3: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_3);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PRFNamed_0;
              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:528:3: ()
            // PsiInternalFragmentTestLanguage.g:529:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguage.g:535:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:536:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:536:4: (lv_name_2_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:537:5: lv_name_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_2_0);
              				
            }

            }


            }

            // PsiInternalFragmentTestLanguage.g:552:3: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:553:4: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:553:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:554:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:554:5: (otherlv_3= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:555:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType());
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_3);
                      					
                    }

                    }


                    }

                    // PsiInternalFragmentTestLanguage.g:570:4: ( (otherlv_4= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:571:5: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:571:5: (otherlv_4= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:572:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType());
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedWithAction"


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguage.g:592:1: entryRulePRFNamedWithFQN returns [Boolean current=false] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final Boolean entryRulePRFNamedWithFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedWithFQN = null;


        try {
            // PsiInternalFragmentTestLanguage.g:592:57: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // PsiInternalFragmentTestLanguage.g:593:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFNamedWithFQNElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithFQN=rulePRFNamedWithFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFNamedWithFQN; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFNamedWithFQN"


    // $ANTLR start "rulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguage.g:599:1: rulePRFNamedWithFQN returns [Boolean current=false] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final Boolean rulePRFNamedWithFQN() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_name_0_0 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:600:1: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // PsiInternalFragmentTestLanguage.g:601:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:601:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // PsiInternalFragmentTestLanguage.g:602:3: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // PsiInternalFragmentTestLanguage.g:602:3: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalFragmentTestLanguage.g:603:4: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalFragmentTestLanguage.g:603:4: (lv_name_0_0= ruleFQN )
            // PsiInternalFragmentTestLanguage.g:604:5: lv_name_0_0= ruleFQN
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_9);
            lv_name_0_0=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalFragmentTestLanguage.g:617:3: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:618:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalFragmentTestLanguage.g:625:4: ( ( ruleFQN2 ) )
                    // PsiInternalFragmentTestLanguage.g:626:5: ( ruleFQN2 )
                    {
                    // PsiInternalFragmentTestLanguage.g:626:5: ( ruleFQN2 )
                    // PsiInternalFragmentTestLanguage.g:627:6: ruleFQN2
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFQN2();

                    state._fsp--;
                    if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedWithFQN"


    // $ANTLR start "entryRulePRFWithPredicate"
    // PsiInternalFragmentTestLanguage.g:647:1: entryRulePRFWithPredicate returns [Boolean current=false] : iv_rulePRFWithPredicate= rulePRFWithPredicate EOF ;
    public final Boolean entryRulePRFWithPredicate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFWithPredicate = null;


        try {
            // PsiInternalFragmentTestLanguage.g:647:58: (iv_rulePRFWithPredicate= rulePRFWithPredicate EOF )
            // PsiInternalFragmentTestLanguage.g:648:2: iv_rulePRFWithPredicate= rulePRFWithPredicate EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPRFWithPredicateElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFWithPredicate=rulePRFWithPredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRFWithPredicate; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePRFWithPredicate"


    // $ANTLR start "rulePRFWithPredicate"
    // PsiInternalFragmentTestLanguage.g:654:1: rulePRFWithPredicate returns [Boolean current=false] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) ;
    public final Boolean rulePRFWithPredicate() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean this_PRFNamedFragment_0 = null;

        Boolean this_PRFNamedRef_2 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:655:1: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) )
            // PsiInternalFragmentTestLanguage.g:656:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            {
            // PsiInternalFragmentTestLanguage.g:656:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            // PsiInternalFragmentTestLanguage.g:657:3: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            {
            if ( state.backtracking==0 ) {

              			if (!current) {
              				associateWithSemanticElement();
              				current = true;
              			}
              			markComposite(elementTypeProvider.getPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_9);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PRFNamedFragment_0;
              			doneComposite();
              		
            }
            // PsiInternalFragmentTestLanguage.g:669:3: ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) && (synpred1_PsiInternalFragmentTestLanguage())) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:670:4: ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    {
                    // PsiInternalFragmentTestLanguage.g:675:4: (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    // PsiInternalFragmentTestLanguage.g:676:5: otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current]
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFWithPredicate_HyphenMinusKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      					markComposite(elementTypeProvider.getPRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PRFNamedRef_2=rulePRFNamedRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_PRFNamedRef_2;
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
        return current;
    }
    // $ANTLR end "rulePRFWithPredicate"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalFragmentTestLanguage.g:701:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalFragmentTestLanguage.g:701:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalFragmentTestLanguage.g:702:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFQNElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalFragmentTestLanguage.g:708:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID ( ruleSuffix )? ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:709:1: ( (this_ID_0= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguage.g:710:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguage.g:710:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguage.g:711:3: this_ID_0= RULE_ID ( ruleSuffix )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguage.g:718:3: ( ruleSuffix )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:719:4: ruleSuffix
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getFQN_SuffixParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;
                    if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFQN2"
    // PsiInternalFragmentTestLanguage.g:731:1: entryRuleFQN2 returns [Boolean current=false] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final Boolean entryRuleFQN2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN2 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:731:46: (iv_ruleFQN2= ruleFQN2 EOF )
            // PsiInternalFragmentTestLanguage.g:732:2: iv_ruleFQN2= ruleFQN2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFQN2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN2=ruleFQN2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQN2"


    // $ANTLR start "ruleFQN2"
    // PsiInternalFragmentTestLanguage.g:738:1: ruleFQN2 returns [Boolean current=false] : (this_ID_0= RULE_ID ( ruleSuffix2 )* ) ;
    public final Boolean ruleFQN2() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:739:1: ( (this_ID_0= RULE_ID ( ruleSuffix2 )* ) )
            // PsiInternalFragmentTestLanguage.g:740:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            {
            // PsiInternalFragmentTestLanguage.g:740:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            // PsiInternalFragmentTestLanguage.g:741:3: this_ID_0= RULE_ID ( ruleSuffix2 )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN2_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguage.g:748:3: ( ruleSuffix2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalFragmentTestLanguage.g:749:4: ruleSuffix2
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getFQN2_Suffix2ParserRuleCall_1ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    ruleSuffix2();

            	    state._fsp--;
            	    if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleFQN2"


    // $ANTLR start "ruleSuffix"
    // PsiInternalFragmentTestLanguage.g:762:1: ruleSuffix returns [Boolean current=false] : (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) ;
    public final Boolean ruleSuffix() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:763:1: ( (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguage.g:764:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguage.g:764:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguage.g:765:3: kw= '.' this_ID_1= RULE_ID ( ruleSuffix )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix_FullStopKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix_IDTerminalRuleCall_1ElementType());
              		
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_1);
              		
            }
            // PsiInternalFragmentTestLanguage.g:779:3: ( ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:780:4: ruleSuffix
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getSuffix_SuffixParserRuleCall_2ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;
                    if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleSuffix"


    // $ANTLR start "ruleSuffix2"
    // PsiInternalFragmentTestLanguage.g:793:1: ruleSuffix2 returns [Boolean current=false] : (kw= '.' this_ID_1= RULE_ID ) ;
    public final Boolean ruleSuffix2() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguage.g:794:1: ( (kw= '.' this_ID_1= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:795:2: (kw= '.' this_ID_1= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:795:2: (kw= '.' this_ID_1= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:796:3: kw= '.' this_ID_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix2_FullStopKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getSuffix2_IDTerminalRuleCall_1ElementType());
              		
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleSuffix2"


    // $ANTLR start "rulePRFNamedFragment"
    // PsiInternalFragmentTestLanguage.g:815:1: rulePRFNamedFragment[Boolean in_current] returns [Boolean current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean rulePRFNamedFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_name_0_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:816:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguage.g:817:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguage.g:817:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:818:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:818:3: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:819:4: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType());
              			
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
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
        return current;
    }
    // $ANTLR end "rulePRFNamedFragment"


    // $ANTLR start "rulePRFNamedRef"
    // PsiInternalFragmentTestLanguage.g:838:1: rulePRFNamedRef[Boolean in_current] returns [Boolean current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean rulePRFNamedRef(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token otherlv_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:839:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguage.g:840:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguage.g:840:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:841:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:841:3: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:842:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				if (!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getPRFNamedRef_RefPRFNamedCrossReference_0ElementType());
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "rulePRFNamedRef"


    // $ANTLR start "ruleRecursiveFromFragment"
    // PsiInternalFragmentTestLanguage.g:861:1: ruleRecursiveFromFragment[Boolean in_current] returns [Boolean current=in_current] : ( (lv_prev_0_0= ruleNamedInParentheses ) ) ;
    public final Boolean ruleRecursiveFromFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Boolean lv_prev_0_0 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:862:1: ( ( (lv_prev_0_0= ruleNamedInParentheses ) ) )
            // PsiInternalFragmentTestLanguage.g:863:2: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            {
            // PsiInternalFragmentTestLanguage.g:863:2: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            // PsiInternalFragmentTestLanguage.g:864:3: (lv_prev_0_0= ruleNamedInParentheses )
            {
            // PsiInternalFragmentTestLanguage.g:864:3: (lv_prev_0_0= ruleNamedInParentheses )
            // PsiInternalFragmentTestLanguage.g:865:4: lv_prev_0_0= ruleNamedInParentheses
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getRecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_prev_0_0=ruleNamedInParentheses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleRecursiveFromFragment"


    // $ANTLR start "entryRuleNamedInParentheses"
    // PsiInternalFragmentTestLanguage.g:881:1: entryRuleNamedInParentheses returns [Boolean current=false] : iv_ruleNamedInParentheses= ruleNamedInParentheses EOF ;
    public final Boolean entryRuleNamedInParentheses() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedInParentheses = null;


        try {
            // PsiInternalFragmentTestLanguage.g:881:60: (iv_ruleNamedInParentheses= ruleNamedInParentheses EOF )
            // PsiInternalFragmentTestLanguage.g:882:2: iv_ruleNamedInParentheses= ruleNamedInParentheses EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getNamedInParenthesesElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedInParentheses=ruleNamedInParentheses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedInParentheses; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNamedInParentheses"


    // $ANTLR start "ruleNamedInParentheses"
    // PsiInternalFragmentTestLanguage.g:888:1: ruleNamedInParentheses returns [Boolean current=false] : ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) ;
    public final Boolean ruleNamedInParentheses() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Boolean this_NamedInParentheses_1 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:889:1: ( ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) )
            // PsiInternalFragmentTestLanguage.g:890:2: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:890:2: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:891:3: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    {
                    // PsiInternalFragmentTestLanguage.g:891:3: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    // PsiInternalFragmentTestLanguage.g:892:4: otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getNamedInParentheses_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getNamedInParentheses_NamedInParenthesesParserRuleCall_0_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    this_NamedInParentheses_1=ruleNamedInParentheses();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_NamedInParentheses_1;
                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getNamedInParentheses_RightParenthesisKeyword_0_2ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:916:3: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:916:3: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguage.g:917:4: () ( (lv_name_4_0= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:917:4: ()
                    // PsiInternalFragmentTestLanguage.g:918:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getNamedInParentheses_PRFNamedAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalFragmentTestLanguage.g:924:4: ( (lv_name_4_0= RULE_ID ) )
                    // PsiInternalFragmentTestLanguage.g:925:5: (lv_name_4_0= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguage.g:925:5: (lv_name_4_0= RULE_ID )
                    // PsiInternalFragmentTestLanguage.g:926:6: lv_name_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getNamedInParentheses_NameIDTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_4_0);
                      					
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
    // $ANTLR end "ruleNamedInParentheses"


    // $ANTLR start "ruleRecursiveFragment"
    // PsiInternalFragmentTestLanguage.g:947:1: ruleRecursiveFragment[Boolean in_current] returns [Boolean current=in_current] : ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) ;
    public final Boolean ruleRecursiveFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_RecursiveFragment_1 = null;

        Boolean lv_prev_3_0 = null;


        try {
            // PsiInternalFragmentTestLanguage.g:948:1: ( ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) )
            // PsiInternalFragmentTestLanguage.g:949:2: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:949:2: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalFragmentTestLanguage.g:950:3: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    {
                    // PsiInternalFragmentTestLanguage.g:950:3: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    // PsiInternalFragmentTestLanguage.g:951:4: otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getRecursiveFragment_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (!current) {
                      					associateWithSemanticElement();
                      					current = true;
                      				}
                      				markComposite(elementTypeProvider.getRecursiveFragment_RecursiveFragmentParserRuleCall_0_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    this_RecursiveFragment_1=ruleRecursiveFragment(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RecursiveFragment_1;
                      				doneComposite();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getRecursiveFragment_RightParenthesisKeyword_0_2ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguage.g:979:3: ( (lv_prev_3_0= ruleNamedByAction ) )
                    {
                    // PsiInternalFragmentTestLanguage.g:979:3: ( (lv_prev_3_0= ruleNamedByAction ) )
                    // PsiInternalFragmentTestLanguage.g:980:4: (lv_prev_3_0= ruleNamedByAction )
                    {
                    // PsiInternalFragmentTestLanguage.g:980:4: (lv_prev_3_0= ruleNamedByAction )
                    // PsiInternalFragmentTestLanguage.g:981:5: lv_prev_3_0= ruleNamedByAction
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getRecursiveFragment_PrevNamedByActionParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_prev_3_0=ruleNamedByAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleRecursiveFragment"


    // $ANTLR start "entryRuleNamedByAction"
    // PsiInternalFragmentTestLanguage.g:998:1: entryRuleNamedByAction returns [Boolean current=false] : iv_ruleNamedByAction= ruleNamedByAction EOF ;
    public final Boolean entryRuleNamedByAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedByAction = null;


        try {
            // PsiInternalFragmentTestLanguage.g:998:55: (iv_ruleNamedByAction= ruleNamedByAction EOF )
            // PsiInternalFragmentTestLanguage.g:999:2: iv_ruleNamedByAction= ruleNamedByAction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getNamedByActionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedByAction=ruleNamedByAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedByAction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNamedByAction"


    // $ANTLR start "ruleNamedByAction"
    // PsiInternalFragmentTestLanguage.g:1005:1: ruleNamedByAction returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleNamedByAction() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalFragmentTestLanguage.g:1006:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalFragmentTestLanguage.g:1007:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalFragmentTestLanguage.g:1007:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguage.g:1008:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguage.g:1008:3: ()
            // PsiInternalFragmentTestLanguage.g:1009:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getNamedByAction_PRFNamedAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguage.g:1015:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguage.g:1016:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguage.g:1016:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFragmentTestLanguage.g:1017:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getNamedByAction_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
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
    // $ANTLR end "ruleNamedByAction"

    // $ANTLR start synpred1_PsiInternalFragmentTestLanguage
    public final void synpred1_PsiInternalFragmentTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalFragmentTestLanguage.g:670:4: ( ( '-' rulePRFNamedRef[null] ) )
        // PsiInternalFragmentTestLanguage.g:670:5: ( '-' rulePRFNamedRef[null] )
        {
        // PsiInternalFragmentTestLanguage.g:670:5: ( '-' rulePRFNamedRef[null] )
        // PsiInternalFragmentTestLanguage.g:671:5: '-' rulePRFNamedRef[null]
        {
        match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return ;
        pushFollow(FollowSets000.FOLLOW_2);
        rulePRFNamedRef(null);

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
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000000L});
    }


}