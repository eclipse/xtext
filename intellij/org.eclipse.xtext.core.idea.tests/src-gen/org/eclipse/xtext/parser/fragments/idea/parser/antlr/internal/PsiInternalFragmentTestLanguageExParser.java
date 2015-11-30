package org.eclipse.xtext.parser.fragments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalFragmentTestLanguageExParser extends AbstractPsiAntlrParser {
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


        public PsiInternalFragmentTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFragmentTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFragmentTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalFragmentTestLanguageEx.g"; }



    	protected FragmentTestLanguageExGrammarAccess grammarAccess;

    	protected FragmentTestLanguageExElementTypeProvider elementTypeProvider;

    	public PsiInternalFragmentTestLanguageExParser(PsiBuilder builder, TokenStream input, FragmentTestLanguageExElementTypeProvider elementTypeProvider, FragmentTestLanguageExGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragmentsEx";
    	}




    // $ANTLR start "entryRuleParserRuleFragmentsEx"
    // PsiInternalFragmentTestLanguageEx.g:52:1: entryRuleParserRuleFragmentsEx returns [Boolean current=false] : iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF ;
    public final Boolean entryRuleParserRuleFragmentsEx() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRuleFragmentsEx = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:52:63: (iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF )
            // PsiInternalFragmentTestLanguageEx.g:53:2: iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleFragmentsExElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleFragmentsEx=ruleParserRuleFragmentsEx();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleFragmentsEx; 
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
    // $ANTLR end "entryRuleParserRuleFragmentsEx"


    // $ANTLR start "ruleParserRuleFragmentsEx"
    // PsiInternalFragmentTestLanguageEx.g:59:1: ruleParserRuleFragmentsEx returns [Boolean current=false] : this_ParserRuleFragments_0= ruleParserRuleFragments ;
    public final Boolean ruleParserRuleFragmentsEx() throws RecognitionException {
        Boolean current = false;

        Boolean this_ParserRuleFragments_0 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:60:1: (this_ParserRuleFragments_0= ruleParserRuleFragments )
            // PsiInternalFragmentTestLanguageEx.g:61:2: this_ParserRuleFragments_0= ruleParserRuleFragments
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ParserRuleFragments_0=ruleParserRuleFragments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_ParserRuleFragments_0;
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
        return current;
    }
    // $ANTLR end "ruleParserRuleFragmentsEx"


    // $ANTLR start "entryRuleParserRuleFragments"
    // PsiInternalFragmentTestLanguageEx.g:72:1: entryRuleParserRuleFragments returns [Boolean current=false] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final Boolean entryRuleParserRuleFragments() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRuleFragments = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:72:61: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // PsiInternalFragmentTestLanguageEx.g:73:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
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
    // PsiInternalFragmentTestLanguageEx.g:79:1: ruleParserRuleFragments returns [Boolean current=false] : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) ;
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
            // PsiInternalFragmentTestLanguageEx.g:80:1: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:81:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:81:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:82:3: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:82:3: ()
            // PsiInternalFragmentTestLanguageEx.g:83:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleFragments_ParserRuleFragmentsAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguageEx.g:89:3: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
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
                    // PsiInternalFragmentTestLanguageEx.g:90:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:90:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:91:5: otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:98:5: ( (lv_element_2_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguageEx.g:99:6: (lv_element_2_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:99:6: (lv_element_2_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguageEx.g:100:7: lv_element_2_0= rulePRFNamed
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
                    // PsiInternalFragmentTestLanguageEx.g:115:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:115:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:116:5: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:123:5: ( (lv_element_4_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguageEx.g:124:6: (lv_element_4_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:124:6: (lv_element_4_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguageEx.g:125:7: lv_element_4_0= rulePRFNamed
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
                    // PsiInternalFragmentTestLanguageEx.g:145:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:146:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:146:6: (otherlv_6= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:147:7: otherlv_6= RULE_ID
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
                    // PsiInternalFragmentTestLanguageEx.g:164:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:164:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:165:5: otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:172:5: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // PsiInternalFragmentTestLanguageEx.g:173:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:173:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    // PsiInternalFragmentTestLanguageEx.g:174:7: lv_element_8_0= rulePRFNamedRefFirst
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
                    // PsiInternalFragmentTestLanguageEx.g:189:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:189:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:190:5: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_9);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:197:5: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // PsiInternalFragmentTestLanguageEx.g:198:6: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:198:6: (lv_element_10_0= rulePRFNamedWithAction )
                    // PsiInternalFragmentTestLanguageEx.g:199:7: lv_element_10_0= rulePRFNamedWithAction
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
                    // PsiInternalFragmentTestLanguageEx.g:214:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:214:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:215:5: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType());
                      				
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_11);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:222:5: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // PsiInternalFragmentTestLanguageEx.g:223:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:223:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    // PsiInternalFragmentTestLanguageEx.g:224:7: lv_element_12_0= rulePRFNamedWithFQN
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
                    // PsiInternalFragmentTestLanguageEx.g:239:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:239:4: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:240:5: otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:247:5: ( (lv_element_14_0= rulePRFWithPredicate ) )
                    // PsiInternalFragmentTestLanguageEx.g:248:6: (lv_element_14_0= rulePRFWithPredicate )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:248:6: (lv_element_14_0= rulePRFWithPredicate )
                    // PsiInternalFragmentTestLanguageEx.g:249:7: lv_element_14_0= rulePRFWithPredicate
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
                    // PsiInternalFragmentTestLanguageEx.g:264:4: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:264:4: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:265:5: otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:272:5: ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    // PsiInternalFragmentTestLanguageEx.g:273:6: (lv_element_16_0= rulePRFNamedRecursive )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:273:6: (lv_element_16_0= rulePRFNamedRecursive )
                    // PsiInternalFragmentTestLanguageEx.g:274:7: lv_element_16_0= rulePRFNamedRecursive
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
                    // PsiInternalFragmentTestLanguageEx.g:289:4: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:289:4: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:290:5: otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:297:5: ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    // PsiInternalFragmentTestLanguageEx.g:298:6: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:298:6: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    // PsiInternalFragmentTestLanguageEx.g:299:7: lv_element_18_0= rulePRFNamedRecursiveFragment
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
    // PsiInternalFragmentTestLanguageEx.g:318:1: entryRulePRFNamed returns [Boolean current=false] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final Boolean entryRulePRFNamed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamed = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:318:50: (iv_rulePRFNamed= rulePRFNamed EOF )
            // PsiInternalFragmentTestLanguageEx.g:319:2: iv_rulePRFNamed= rulePRFNamed EOF
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
    // PsiInternalFragmentTestLanguageEx.g:325:1: rulePRFNamed returns [Boolean current=false] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final Boolean rulePRFNamed() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean this_PRFNamedFragment_0 = null;

        Boolean this_PRFNamedRef_4 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:326:1: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:327:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:327:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // PsiInternalFragmentTestLanguageEx.g:328:3: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
            // PsiInternalFragmentTestLanguageEx.g:340:3: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                    // PsiInternalFragmentTestLanguageEx.g:341:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:341:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:342:5: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getPRFNamed_ColonKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalFragmentTestLanguageEx.g:349:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:350:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:350:6: (otherlv_2= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:351:7: otherlv_2= RULE_ID
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
                    // PsiInternalFragmentTestLanguageEx.g:368:4: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:368:4: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // PsiInternalFragmentTestLanguageEx.g:369:5: otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current]
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
    // PsiInternalFragmentTestLanguageEx.g:394:1: entryRulePRFNamedRecursive returns [Boolean current=false] : iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF ;
    public final Boolean entryRulePRFNamedRecursive() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRecursive = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:394:59: (iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF )
            // PsiInternalFragmentTestLanguageEx.g:395:2: iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF
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
    // PsiInternalFragmentTestLanguageEx.g:401:1: rulePRFNamedRecursive returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) ;
    public final Boolean rulePRFNamedRecursive() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean this_RecursiveFromFragment_1 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:402:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) )
            // PsiInternalFragmentTestLanguageEx.g:403:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            {
            // PsiInternalFragmentTestLanguageEx.g:403:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            // PsiInternalFragmentTestLanguageEx.g:404:3: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current]
            {
            // PsiInternalFragmentTestLanguageEx.g:404:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:405:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:405:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:406:5: lv_name_0_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:437:1: entryRulePRFNamedRecursiveFragment returns [Boolean current=false] : iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF ;
    public final Boolean entryRulePRFNamedRecursiveFragment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRecursiveFragment = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:437:67: (iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF )
            // PsiInternalFragmentTestLanguageEx.g:438:2: iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF
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
    // PsiInternalFragmentTestLanguageEx.g:444:1: rulePRFNamedRecursiveFragment returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) ;
    public final Boolean rulePRFNamedRecursiveFragment() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean this_RecursiveFragment_1 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:445:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) )
            // PsiInternalFragmentTestLanguageEx.g:446:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            {
            // PsiInternalFragmentTestLanguageEx.g:446:2: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            // PsiInternalFragmentTestLanguageEx.g:447:3: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current]
            {
            // PsiInternalFragmentTestLanguageEx.g:447:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:448:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:448:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:449:5: lv_name_0_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:480:1: entryRulePRFNamedRefFirst returns [Boolean current=false] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final Boolean entryRulePRFNamedRefFirst() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedRefFirst = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:480:58: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // PsiInternalFragmentTestLanguageEx.g:481:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
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
    // PsiInternalFragmentTestLanguageEx.g:487:1: rulePRFNamedRefFirst returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final Boolean rulePRFNamedRefFirst() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Boolean this_PRFNamedFragment_2 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:488:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // PsiInternalFragmentTestLanguageEx.g:489:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // PsiInternalFragmentTestLanguageEx.g:489:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // PsiInternalFragmentTestLanguageEx.g:490:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // PsiInternalFragmentTestLanguageEx.g:490:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:491:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:491:4: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:492:5: otherlv_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:530:1: entryRulePRFNamedWithAction returns [Boolean current=false] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final Boolean entryRulePRFNamedWithAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedWithAction = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:530:60: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // PsiInternalFragmentTestLanguageEx.g:531:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
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
    // PsiInternalFragmentTestLanguageEx.g:537:1: rulePRFNamedWithAction returns [Boolean current=false] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final Boolean rulePRFNamedWithAction() throws RecognitionException {
        Boolean current = false;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean this_PRFNamed_0 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:538:1: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:539:2: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:539:2: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // PsiInternalFragmentTestLanguageEx.g:540:3: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
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
            // PsiInternalFragmentTestLanguageEx.g:548:3: ()
            // PsiInternalFragmentTestLanguageEx.g:549:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguageEx.g:555:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:556:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:556:4: (lv_name_2_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:557:5: lv_name_2_0= RULE_ID
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

            // PsiInternalFragmentTestLanguageEx.g:572:3: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:573:4: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:573:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:574:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:574:5: (otherlv_3= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:575:6: otherlv_3= RULE_ID
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

                    // PsiInternalFragmentTestLanguageEx.g:590:4: ( (otherlv_4= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:591:5: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:591:5: (otherlv_4= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:592:6: otherlv_4= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:612:1: entryRulePRFNamedWithFQN returns [Boolean current=false] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final Boolean entryRulePRFNamedWithFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFNamedWithFQN = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:612:57: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // PsiInternalFragmentTestLanguageEx.g:613:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
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
    // PsiInternalFragmentTestLanguageEx.g:619:1: rulePRFNamedWithFQN returns [Boolean current=false] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final Boolean rulePRFNamedWithFQN() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_name_0_0 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:620:1: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:621:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:621:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // PsiInternalFragmentTestLanguageEx.g:622:3: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // PsiInternalFragmentTestLanguageEx.g:622:3: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalFragmentTestLanguageEx.g:623:4: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalFragmentTestLanguageEx.g:623:4: (lv_name_0_0= ruleFQN )
            // PsiInternalFragmentTestLanguageEx.g:624:5: lv_name_0_0= ruleFQN
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

            // PsiInternalFragmentTestLanguageEx.g:637:3: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:638:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalFragmentTestLanguageEx.g:645:4: ( ( ruleFQN2 ) )
                    // PsiInternalFragmentTestLanguageEx.g:646:5: ( ruleFQN2 )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:646:5: ( ruleFQN2 )
                    // PsiInternalFragmentTestLanguageEx.g:647:6: ruleFQN2
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
    // PsiInternalFragmentTestLanguageEx.g:667:1: entryRulePRFWithPredicate returns [Boolean current=false] : iv_rulePRFWithPredicate= rulePRFWithPredicate EOF ;
    public final Boolean entryRulePRFWithPredicate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePRFWithPredicate = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:667:58: (iv_rulePRFWithPredicate= rulePRFWithPredicate EOF )
            // PsiInternalFragmentTestLanguageEx.g:668:2: iv_rulePRFWithPredicate= rulePRFWithPredicate EOF
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
    // PsiInternalFragmentTestLanguageEx.g:674:1: rulePRFWithPredicate returns [Boolean current=false] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) ;
    public final Boolean rulePRFWithPredicate() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean this_PRFNamedFragment_0 = null;

        Boolean this_PRFNamedRef_2 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:675:1: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:676:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:676:2: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            // PsiInternalFragmentTestLanguageEx.g:677:3: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
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
            // PsiInternalFragmentTestLanguageEx.g:689:3: ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) && (synpred1_PsiInternalFragmentTestLanguageEx())) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:690:4: ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:695:4: (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    // PsiInternalFragmentTestLanguageEx.g:696:5: otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current]
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
    // PsiInternalFragmentTestLanguageEx.g:721:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:721:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalFragmentTestLanguageEx.g:722:2: iv_ruleFQN= ruleFQN EOF
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
    // PsiInternalFragmentTestLanguageEx.g:728:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID ( ruleSuffix )? ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:729:1: ( (this_ID_0= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguageEx.g:730:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:730:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguageEx.g:731:3: this_ID_0= RULE_ID ( ruleSuffix )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguageEx.g:738:3: ( ruleSuffix )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:739:4: ruleSuffix
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
    // PsiInternalFragmentTestLanguageEx.g:751:1: entryRuleFQN2 returns [Boolean current=false] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final Boolean entryRuleFQN2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN2 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:751:46: (iv_ruleFQN2= ruleFQN2 EOF )
            // PsiInternalFragmentTestLanguageEx.g:752:2: iv_ruleFQN2= ruleFQN2 EOF
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
    // PsiInternalFragmentTestLanguageEx.g:758:1: ruleFQN2 returns [Boolean current=false] : (this_ID_0= RULE_ID ( ruleSuffix2 )* ) ;
    public final Boolean ruleFQN2() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:759:1: ( (this_ID_0= RULE_ID ( ruleSuffix2 )* ) )
            // PsiInternalFragmentTestLanguageEx.g:760:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            {
            // PsiInternalFragmentTestLanguageEx.g:760:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            // PsiInternalFragmentTestLanguageEx.g:761:3: this_ID_0= RULE_ID ( ruleSuffix2 )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFQN2_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalFragmentTestLanguageEx.g:768:3: ( ruleSuffix2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalFragmentTestLanguageEx.g:769:4: ruleSuffix2
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
    // PsiInternalFragmentTestLanguageEx.g:782:1: ruleSuffix returns [Boolean current=false] : (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) ;
    public final Boolean ruleSuffix() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:783:1: ( (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguageEx.g:784:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:784:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguageEx.g:785:3: kw= '.' this_ID_1= RULE_ID ( ruleSuffix )?
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
            // PsiInternalFragmentTestLanguageEx.g:799:3: ( ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:800:4: ruleSuffix
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
    // PsiInternalFragmentTestLanguageEx.g:813:1: ruleSuffix2 returns [Boolean current=false] : (kw= '.' this_ID_1= RULE_ID ) ;
    public final Boolean ruleSuffix2() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:814:1: ( (kw= '.' this_ID_1= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:815:2: (kw= '.' this_ID_1= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:815:2: (kw= '.' this_ID_1= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:816:3: kw= '.' this_ID_1= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:835:1: rulePRFNamedFragment[Boolean in_current] returns [Boolean current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean rulePRFNamedFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_name_0_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:836:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguageEx.g:837:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:837:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:838:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:838:3: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:839:4: lv_name_0_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:858:1: rulePRFNamedRef[Boolean in_current] returns [Boolean current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean rulePRFNamedRef(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token otherlv_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:859:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguageEx.g:860:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:860:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:861:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:861:3: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:862:4: otherlv_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:881:1: ruleRecursiveFromFragment[Boolean in_current] returns [Boolean current=in_current] : ( (lv_prev_0_0= ruleNamedInParentheses ) ) ;
    public final Boolean ruleRecursiveFromFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Boolean lv_prev_0_0 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:882:1: ( ( (lv_prev_0_0= ruleNamedInParentheses ) ) )
            // PsiInternalFragmentTestLanguageEx.g:883:2: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:883:2: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            // PsiInternalFragmentTestLanguageEx.g:884:3: (lv_prev_0_0= ruleNamedInParentheses )
            {
            // PsiInternalFragmentTestLanguageEx.g:884:3: (lv_prev_0_0= ruleNamedInParentheses )
            // PsiInternalFragmentTestLanguageEx.g:885:4: lv_prev_0_0= ruleNamedInParentheses
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
    // PsiInternalFragmentTestLanguageEx.g:901:1: entryRuleNamedInParentheses returns [Boolean current=false] : iv_ruleNamedInParentheses= ruleNamedInParentheses EOF ;
    public final Boolean entryRuleNamedInParentheses() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedInParentheses = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:901:60: (iv_ruleNamedInParentheses= ruleNamedInParentheses EOF )
            // PsiInternalFragmentTestLanguageEx.g:902:2: iv_ruleNamedInParentheses= ruleNamedInParentheses EOF
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
    // PsiInternalFragmentTestLanguageEx.g:908:1: ruleNamedInParentheses returns [Boolean current=false] : ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) ;
    public final Boolean ruleNamedInParentheses() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Boolean this_NamedInParentheses_1 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:909:1: ( ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:910:2: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:910:2: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalFragmentTestLanguageEx.g:911:3: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:911:3: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    // PsiInternalFragmentTestLanguageEx.g:912:4: otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')'
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
                    // PsiInternalFragmentTestLanguageEx.g:936:3: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:936:3: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:937:4: () ( (lv_name_4_0= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:937:4: ()
                    // PsiInternalFragmentTestLanguageEx.g:938:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getNamedInParentheses_PRFNamedAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalFragmentTestLanguageEx.g:944:4: ( (lv_name_4_0= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:945:5: (lv_name_4_0= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:945:5: (lv_name_4_0= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:946:6: lv_name_4_0= RULE_ID
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
    // PsiInternalFragmentTestLanguageEx.g:967:1: ruleRecursiveFragment[Boolean in_current] returns [Boolean current=in_current] : ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) ;
    public final Boolean ruleRecursiveFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_RecursiveFragment_1 = null;

        Boolean lv_prev_3_0 = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:968:1: ( ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:969:2: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:969:2: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
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
                    // PsiInternalFragmentTestLanguageEx.g:970:3: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:970:3: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    // PsiInternalFragmentTestLanguageEx.g:971:4: otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')'
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
                    // PsiInternalFragmentTestLanguageEx.g:999:3: ( (lv_prev_3_0= ruleNamedByAction ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:999:3: ( (lv_prev_3_0= ruleNamedByAction ) )
                    // PsiInternalFragmentTestLanguageEx.g:1000:4: (lv_prev_3_0= ruleNamedByAction )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:1000:4: (lv_prev_3_0= ruleNamedByAction )
                    // PsiInternalFragmentTestLanguageEx.g:1001:5: lv_prev_3_0= ruleNamedByAction
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
    // PsiInternalFragmentTestLanguageEx.g:1018:1: entryRuleNamedByAction returns [Boolean current=false] : iv_ruleNamedByAction= ruleNamedByAction EOF ;
    public final Boolean entryRuleNamedByAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedByAction = null;


        try {
            // PsiInternalFragmentTestLanguageEx.g:1018:55: (iv_ruleNamedByAction= ruleNamedByAction EOF )
            // PsiInternalFragmentTestLanguageEx.g:1019:2: iv_ruleNamedByAction= ruleNamedByAction EOF
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
    // PsiInternalFragmentTestLanguageEx.g:1025:1: ruleNamedByAction returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleNamedByAction() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:1026:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:1027:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:1027:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguageEx.g:1028:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:1028:3: ()
            // PsiInternalFragmentTestLanguageEx.g:1029:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getNamedByAction_PRFNamedAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalFragmentTestLanguageEx.g:1035:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:1036:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:1036:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:1037:5: lv_name_1_0= RULE_ID
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

    // $ANTLR start synpred1_PsiInternalFragmentTestLanguageEx
    public final void synpred1_PsiInternalFragmentTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalFragmentTestLanguageEx.g:690:4: ( ( '-' rulePRFNamedRef[null] ) )
        // PsiInternalFragmentTestLanguageEx.g:690:5: ( '-' rulePRFNamedRef[null] )
        {
        // PsiInternalFragmentTestLanguageEx.g:690:5: ( '-' rulePRFNamedRef[null] )
        // PsiInternalFragmentTestLanguageEx.g:691:5: '-' rulePRFNamedRef[null]
        {
        match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return ;
        pushFollow(FollowSets000.FOLLOW_2);
        rulePRFNamedRef(null);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_PsiInternalFragmentTestLanguageEx

    // Delegated rules

    public final boolean synpred1_PsiInternalFragmentTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalFragmentTestLanguageEx_fragment(); // can never throw exception
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