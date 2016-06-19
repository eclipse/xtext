package org.eclipse.xtext.parser.fragments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalFragmentTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#8'", "'#9'", "'#10'", "'#11'", "':'", "'-'", "'<-'", "'.'", "'('", "')'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalFragmentTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFragmentTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFragmentTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFragmentTestLanguage.g"; }



     	private FragmentTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFragmentTestLanguageParser(TokenStream input, FragmentTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ParserRuleFragments";	
       	}
       	
       	@Override
       	protected FragmentTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleParserRuleFragments"
    // InternalFragmentTestLanguage.g:67:1: entryRuleParserRuleFragments returns [EObject current=null] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final EObject entryRuleParserRuleFragments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragments = null;


        try {
            // InternalFragmentTestLanguage.g:68:2: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // InternalFragmentTestLanguage.g:69:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleFragmentsRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParserRuleFragments"


    // $ANTLR start "ruleParserRuleFragments"
    // InternalFragmentTestLanguage.g:76:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) ;
    public final EObject ruleParserRuleFragments() throws RecognitionException {
        EObject current = null;

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
        EObject lv_element_2_0 = null;

        EObject lv_element_4_0 = null;

        EObject lv_element_8_0 = null;

        EObject lv_element_10_0 = null;

        EObject lv_element_12_0 = null;

        EObject lv_element_14_0 = null;

        EObject lv_element_16_0 = null;

        EObject lv_element_18_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:2: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:2: ()
            // InternalFragmentTestLanguage.g:81:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguage.g:86:2: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
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
                    // InternalFragmentTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // InternalFragmentTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    // InternalFragmentTestLanguage.g:86:5: otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:90:1: ( (lv_element_2_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguage.g:91:1: (lv_element_2_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguage.g:91:1: (lv_element_2_0= rulePRFNamed )
                    // InternalFragmentTestLanguage.g:92:3: lv_element_2_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_2_0=rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_2_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamed");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // InternalFragmentTestLanguage.g:109:8: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:113:1: ( (lv_element_4_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguage.g:114:1: (lv_element_4_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguage.g:114:1: (lv_element_4_0= rulePRFNamed )
                    // InternalFragmentTestLanguage.g:115:3: lv_element_4_0= rulePRFNamed
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_element_4_0=rulePRFNamed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_4_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamed");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                          
                    }
                    // InternalFragmentTestLanguage.g:135:1: ( (otherlv_6= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:136:1: (otherlv_6= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:136:1: (otherlv_6= RULE_ID )
                    // InternalFragmentTestLanguage.g:137:3: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                              
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_6, grammarAccess.getParserRuleFragmentsAccess().getRefPRFNamedCrossReference_1_1_3_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFragmentTestLanguage.g:149:6: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // InternalFragmentTestLanguage.g:149:6: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // InternalFragmentTestLanguage.g:149:8: otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:153:1: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // InternalFragmentTestLanguage.g:154:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // InternalFragmentTestLanguage.g:154:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    // InternalFragmentTestLanguage.g:155:3: lv_element_8_0= rulePRFNamedRefFirst
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedRefFirstParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_8_0=rulePRFNamedRefFirst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_8_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedRefFirst");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFragmentTestLanguage.g:172:6: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // InternalFragmentTestLanguage.g:172:6: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // InternalFragmentTestLanguage.g:172:8: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:176:1: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // InternalFragmentTestLanguage.g:177:1: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // InternalFragmentTestLanguage.g:177:1: (lv_element_10_0= rulePRFNamedWithAction )
                    // InternalFragmentTestLanguage.g:178:3: lv_element_10_0= rulePRFNamedWithAction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_10_0=rulePRFNamedWithAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_10_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithAction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // InternalFragmentTestLanguage.g:195:8: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_4_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:199:1: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    // InternalFragmentTestLanguage.g:201:3: lv_element_12_0= rulePRFNamedWithFQN
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_12_0=rulePRFNamedWithFQN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_12_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithFQN");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalFragmentTestLanguage.g:218:6: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    {
                    // InternalFragmentTestLanguage.g:218:6: (otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    // InternalFragmentTestLanguage.g:218:8: otherlv_13= '#9' ( (lv_element_14_0= rulePRFWithPredicate ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitNineKeyword_1_5_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:222:1: ( (lv_element_14_0= rulePRFWithPredicate ) )
                    // InternalFragmentTestLanguage.g:223:1: (lv_element_14_0= rulePRFWithPredicate )
                    {
                    // InternalFragmentTestLanguage.g:223:1: (lv_element_14_0= rulePRFWithPredicate )
                    // InternalFragmentTestLanguage.g:224:3: lv_element_14_0= rulePRFWithPredicate
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFWithPredicateParserRuleCall_1_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_14_0=rulePRFWithPredicate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_14_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFWithPredicate");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalFragmentTestLanguage.g:241:6: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    {
                    // InternalFragmentTestLanguage.g:241:6: (otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    // InternalFragmentTestLanguage.g:241:8: otherlv_15= '#10' ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitZeroKeyword_1_6_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:245:1: ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    // InternalFragmentTestLanguage.g:246:1: (lv_element_16_0= rulePRFNamedRecursive )
                    {
                    // InternalFragmentTestLanguage.g:246:1: (lv_element_16_0= rulePRFNamedRecursive )
                    // InternalFragmentTestLanguage.g:247:3: lv_element_16_0= rulePRFNamedRecursive
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedRecursiveParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_16_0=rulePRFNamedRecursive();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_16_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedRecursive");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalFragmentTestLanguage.g:264:6: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    {
                    // InternalFragmentTestLanguage.g:264:6: (otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    // InternalFragmentTestLanguage.g:264:8: otherlv_17= '#11' ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitOneKeyword_1_7_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:268:1: ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    // InternalFragmentTestLanguage.g:269:1: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    {
                    // InternalFragmentTestLanguage.g:269:1: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    // InternalFragmentTestLanguage.g:270:3: lv_element_18_0= rulePRFNamedRecursiveFragment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_18_0=rulePRFNamedRecursiveFragment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_18_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedRecursiveFragment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParserRuleFragments"


    // $ANTLR start "entryRulePRFNamed"
    // InternalFragmentTestLanguage.g:294:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // InternalFragmentTestLanguage.g:295:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // InternalFragmentTestLanguage.g:296:2: iv_rulePRFNamed= rulePRFNamed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamed"


    // $ANTLR start "rulePRFNamed"
    // InternalFragmentTestLanguage.g:303:1: rulePRFNamed returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFNamed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_4 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:306:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguage.g:307:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguage.g:307:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguage.g:308:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            {
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getPRFNamedRule());
              		}
                      newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedFragmentParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PRFNamedFragment_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalFragmentTestLanguage.g:319:1: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                    // InternalFragmentTestLanguage.g:319:2: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguage.g:319:2: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // InternalFragmentTestLanguage.g:319:4: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:323:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:324:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:324:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:325:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPRFNamedRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getPRFNamedAccess().getRefPRFNamedCrossReference_1_0_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguage.g:337:6: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguage.g:337:6: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguage.g:337:8: otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPRFNamedAccess().getHyphenMinusKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getPRFNamedRule());
                      		}
                              newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedRefParserRuleCall_1_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PRFNamedRef_4=rulePRFNamedRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PRFNamedRef_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamed"


    // $ANTLR start "entryRulePRFNamedRecursive"
    // InternalFragmentTestLanguage.g:361:1: entryRulePRFNamedRecursive returns [EObject current=null] : iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF ;
    public final EObject entryRulePRFNamedRecursive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRecursive = null;


        try {
            // InternalFragmentTestLanguage.g:362:2: (iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF )
            // InternalFragmentTestLanguage.g:363:2: iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedRecursiveRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamedRecursive"


    // $ANTLR start "rulePRFNamedRecursive"
    // InternalFragmentTestLanguage.g:370:1: rulePRFNamedRecursive returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) ;
    public final EObject rulePRFNamedRecursive() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject this_RecursiveFromFragment_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:373:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) )
            // InternalFragmentTestLanguage.g:374:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            {
            // InternalFragmentTestLanguage.g:374:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            // InternalFragmentTestLanguage.g:374:2: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current]
            {
            // InternalFragmentTestLanguage.g:374:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:375:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:375:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:376:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPRFNamedRecursiveAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedRecursiveRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getPRFNamedRecursiveRule());
              		}
                      newCompositeNode(grammarAccess.getPRFNamedRecursiveAccess().getRecursiveFromFragmentParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_RecursiveFromFragment_1=ruleRecursiveFromFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RecursiveFromFragment_1; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedRecursive"


    // $ANTLR start "entryRulePRFNamedRecursiveFragment"
    // InternalFragmentTestLanguage.g:412:1: entryRulePRFNamedRecursiveFragment returns [EObject current=null] : iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF ;
    public final EObject entryRulePRFNamedRecursiveFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRecursiveFragment = null;


        try {
            // InternalFragmentTestLanguage.g:413:2: (iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF )
            // InternalFragmentTestLanguage.g:414:2: iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedRecursiveFragmentRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamedRecursiveFragment"


    // $ANTLR start "rulePRFNamedRecursiveFragment"
    // InternalFragmentTestLanguage.g:421:1: rulePRFNamedRecursiveFragment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) ;
    public final EObject rulePRFNamedRecursiveFragment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject this_RecursiveFragment_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:424:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) )
            // InternalFragmentTestLanguage.g:425:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            {
            // InternalFragmentTestLanguage.g:425:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            // InternalFragmentTestLanguage.g:425:2: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current]
            {
            // InternalFragmentTestLanguage.g:425:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:426:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:426:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:427:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPRFNamedRecursiveFragmentAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedRecursiveFragmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getPRFNamedRecursiveFragmentRule());
              		}
                      newCompositeNode(grammarAccess.getPRFNamedRecursiveFragmentAccess().getRecursiveFragmentParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_RecursiveFragment_1=ruleRecursiveFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RecursiveFragment_1; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedRecursiveFragment"


    // $ANTLR start "entryRulePRFNamedRefFirst"
    // InternalFragmentTestLanguage.g:463:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // InternalFragmentTestLanguage.g:464:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // InternalFragmentTestLanguage.g:465:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedRefFirstRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamedRefFirst"


    // $ANTLR start "rulePRFNamedRefFirst"
    // InternalFragmentTestLanguage.g:472:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:475:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // InternalFragmentTestLanguage.g:476:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // InternalFragmentTestLanguage.g:476:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // InternalFragmentTestLanguage.g:476:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // InternalFragmentTestLanguage.g:476:2: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:477:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:477:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:478:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPRFNamedRefFirstAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
              		}
                      newCompositeNode(grammarAccess.getPRFNamedRefFirstAccess().getPRFNamedFragmentParserRuleCall_2()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_PRFNamedFragment_2=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PRFNamedFragment_2; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedRefFirst"


    // $ANTLR start "entryRulePRFNamedWithAction"
    // InternalFragmentTestLanguage.g:513:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // InternalFragmentTestLanguage.g:514:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // InternalFragmentTestLanguage.g:515:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedWithActionRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamedWithAction"


    // $ANTLR start "rulePRFNamedWithAction"
    // InternalFragmentTestLanguage.g:522:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:525:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:526:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:526:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:527:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_3);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PRFNamed_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalFragmentTestLanguage.g:535:1: ()
            // InternalFragmentTestLanguage.g:536:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElementAndSet(
                          grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguage.g:541:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:542:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:542:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguage.g:543:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getPRFNamedWithActionAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalFragmentTestLanguage.g:559:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFragmentTestLanguage.g:559:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguage.g:559:3: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:560:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:560:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguage.g:561:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0()); 
                      	
                    }

                    }


                    }

                    // InternalFragmentTestLanguage.g:572:2: ( (otherlv_4= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:573:1: (otherlv_4= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:573:1: (otherlv_4= RULE_ID )
                    // InternalFragmentTestLanguage.g:574:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getPRFNamedWithActionAccess().getRef2PRFNamedCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedWithAction"


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // InternalFragmentTestLanguage.g:593:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // InternalFragmentTestLanguage.g:594:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // InternalFragmentTestLanguage.g:595:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFNamedWithFQNRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFNamedWithFQN"


    // $ANTLR start "rulePRFNamedWithFQN"
    // InternalFragmentTestLanguage.g:602:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:605:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // InternalFragmentTestLanguage.g:606:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // InternalFragmentTestLanguage.g:606:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // InternalFragmentTestLanguage.g:606:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // InternalFragmentTestLanguage.g:606:2: ( (lv_name_0_0= ruleFQN ) )
            // InternalFragmentTestLanguage.g:607:1: (lv_name_0_0= ruleFQN )
            {
            // InternalFragmentTestLanguage.g:607:1: (lv_name_0_0= ruleFQN )
            // InternalFragmentTestLanguage.g:608:3: lv_name_0_0= ruleFQN
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getNameFQNParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_9);
            lv_name_0_0=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPRFNamedWithFQNRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.FQN");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalFragmentTestLanguage.g:624:2: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFragmentTestLanguage.g:624:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                          
                    }
                    // InternalFragmentTestLanguage.g:628:1: ( ( ruleFQN2 ) )
                    // InternalFragmentTestLanguage.g:629:1: ( ruleFQN2 )
                    {
                    // InternalFragmentTestLanguage.g:629:1: ( ruleFQN2 )
                    // InternalFragmentTestLanguage.g:630:3: ruleFQN2
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPRFNamedWithFQNRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getRefPRFNamedCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFQN2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedWithFQN"


    // $ANTLR start "entryRulePRFWithPredicate"
    // InternalFragmentTestLanguage.g:651:1: entryRulePRFWithPredicate returns [EObject current=null] : iv_rulePRFWithPredicate= rulePRFWithPredicate EOF ;
    public final EObject entryRulePRFWithPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFWithPredicate = null;


        try {
            // InternalFragmentTestLanguage.g:652:2: (iv_rulePRFWithPredicate= rulePRFWithPredicate EOF )
            // InternalFragmentTestLanguage.g:653:2: iv_rulePRFWithPredicate= rulePRFWithPredicate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRFWithPredicateRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePRFWithPredicate"


    // $ANTLR start "rulePRFWithPredicate"
    // InternalFragmentTestLanguage.g:660:1: rulePRFWithPredicate returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFWithPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:663:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguage.g:664:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguage.g:664:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguage.g:665:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            {
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getPRFWithPredicateRule());
              		}
                      newCompositeNode(grammarAccess.getPRFWithPredicateAccess().getPRFNamedFragmentParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_9);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PRFNamedFragment_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalFragmentTestLanguage.g:676:1: ( ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) && (synpred1_InternalFragmentTestLanguage())) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFragmentTestLanguage.g:676:2: ( ( '-' rulePRFNamedRef[null] ) )=> (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguage.g:677:27: (otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguage.g:677:29: otherlv_1= '-' this_PRFNamedRef_2= rulePRFNamedRef[$current]
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPRFWithPredicateAccess().getHyphenMinusKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getPRFWithPredicateRule());
                      		}
                              newCompositeNode(grammarAccess.getPRFWithPredicateAccess().getPRFNamedRefParserRuleCall_1_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PRFNamedRef_2=rulePRFNamedRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PRFNamedRef_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFWithPredicate"


    // $ANTLR start "entryRuleFQN"
    // InternalFragmentTestLanguage.g:701:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFragmentTestLanguage.g:702:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalFragmentTestLanguage.g:703:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalFragmentTestLanguage.g:710:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:713:28: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:714:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:714:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:714:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalFragmentTestLanguage.g:721:1: (this_Suffix_1= ruleSuffix )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFragmentTestLanguage.g:722:5: this_Suffix_1= ruleSuffix
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFQNAccess().getSuffixParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Suffix_1=ruleSuffix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Suffix_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFQN2"
    // InternalFragmentTestLanguage.g:740:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // InternalFragmentTestLanguage.g:741:2: (iv_ruleFQN2= ruleFQN2 EOF )
            // InternalFragmentTestLanguage.g:742:2: iv_ruleFQN2= ruleFQN2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQN2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN2=ruleFQN2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN2.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFQN2"


    // $ANTLR start "ruleFQN2"
    // InternalFragmentTestLanguage.g:749:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:752:28: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // InternalFragmentTestLanguage.g:753:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // InternalFragmentTestLanguage.g:753:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // InternalFragmentTestLanguage.g:753:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalFragmentTestLanguage.g:760:1: (this_Suffix2_1= ruleSuffix2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFragmentTestLanguage.g:761:5: this_Suffix2_1= ruleSuffix2
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getFQN2Access().getSuffix2ParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    this_Suffix2_1=ruleSuffix2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_Suffix2_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFQN2"


    // $ANTLR start "ruleSuffix"
    // InternalFragmentTestLanguage.g:780:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:783:28: ( (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:784:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:784:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:785:2: kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSuffixAccess().getFullStopKeyword_0()); 
                  
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_1, grammarAccess.getSuffixAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalFragmentTestLanguage.g:797:1: (this_Suffix_2= ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFragmentTestLanguage.g:798:5: this_Suffix_2= ruleSuffix
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSuffixAccess().getSuffixParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Suffix_2=ruleSuffix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Suffix_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleSuffix"


    // $ANTLR start "ruleSuffix2"
    // InternalFragmentTestLanguage.g:817:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:820:28: ( (kw= '.' this_ID_1= RULE_ID ) )
            // InternalFragmentTestLanguage.g:821:1: (kw= '.' this_ID_1= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:821:1: (kw= '.' this_ID_1= RULE_ID )
            // InternalFragmentTestLanguage.g:822:2: kw= '.' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSuffix2Access().getFullStopKeyword_0()); 
                  
            }
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_1, grammarAccess.getSuffix2Access().getIDTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleSuffix2"


    // $ANTLR start "rulePRFNamedFragment"
    // InternalFragmentTestLanguage.g:843:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:846:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:847:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:847:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:848:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:848:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:849:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPRFNamedFragmentAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedFragmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedFragment"


    // $ANTLR start "rulePRFNamedRef"
    // InternalFragmentTestLanguage.g:874:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:877:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:878:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:878:1: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:879:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:879:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:880:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPRFNamedRefRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefAccess().getRefPRFNamedCrossReference_0()); 
              	
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePRFNamedRef"


    // $ANTLR start "ruleRecursiveFromFragment"
    // InternalFragmentTestLanguage.g:900:1: ruleRecursiveFromFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_prev_0_0= ruleNamedInParentheses ) ) ;
    public final EObject ruleRecursiveFromFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_prev_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:903:28: ( ( (lv_prev_0_0= ruleNamedInParentheses ) ) )
            // InternalFragmentTestLanguage.g:904:1: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            {
            // InternalFragmentTestLanguage.g:904:1: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            // InternalFragmentTestLanguage.g:905:1: (lv_prev_0_0= ruleNamedInParentheses )
            {
            // InternalFragmentTestLanguage.g:905:1: (lv_prev_0_0= ruleNamedInParentheses )
            // InternalFragmentTestLanguage.g:906:3: lv_prev_0_0= ruleNamedInParentheses
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRecursiveFromFragmentAccess().getPrevNamedInParenthesesParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_prev_0_0=ruleNamedInParentheses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRecursiveFromFragmentRule());
              	        }
                     		set(
                     			current, 
                     			"prev",
                      		lv_prev_0_0, 
                      		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.NamedInParentheses");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRecursiveFromFragment"


    // $ANTLR start "entryRuleNamedInParentheses"
    // InternalFragmentTestLanguage.g:930:1: entryRuleNamedInParentheses returns [EObject current=null] : iv_ruleNamedInParentheses= ruleNamedInParentheses EOF ;
    public final EObject entryRuleNamedInParentheses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedInParentheses = null;


        try {
            // InternalFragmentTestLanguage.g:931:2: (iv_ruleNamedInParentheses= ruleNamedInParentheses EOF )
            // InternalFragmentTestLanguage.g:932:2: iv_ruleNamedInParentheses= ruleNamedInParentheses EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedInParenthesesRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedInParentheses"


    // $ANTLR start "ruleNamedInParentheses"
    // InternalFragmentTestLanguage.g:939:1: ruleNamedInParentheses returns [EObject current=null] : ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleNamedInParentheses() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        EObject this_NamedInParentheses_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:942:28: ( ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) )
            // InternalFragmentTestLanguage.g:943:1: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            {
            // InternalFragmentTestLanguage.g:943:1: ( (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
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
                    // InternalFragmentTestLanguage.g:943:2: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    {
                    // InternalFragmentTestLanguage.g:943:2: (otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')' )
                    // InternalFragmentTestLanguage.g:943:4: otherlv_0= '(' this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getNamedInParenthesesAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNamedInParenthesesAccess().getNamedInParenthesesParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    this_NamedInParentheses_1=ruleNamedInParentheses();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NamedInParentheses_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNamedInParenthesesAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguage.g:961:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguage.g:961:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    // InternalFragmentTestLanguage.g:961:7: () ( (lv_name_4_0= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguage.g:961:7: ()
                    // InternalFragmentTestLanguage.g:962:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNamedInParenthesesAccess().getPRFNamedAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalFragmentTestLanguage.g:967:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:968:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:968:1: (lv_name_4_0= RULE_ID )
                    // InternalFragmentTestLanguage.g:969:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getNamedInParenthesesAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedInParenthesesRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNamedInParentheses"


    // $ANTLR start "ruleRecursiveFragment"
    // InternalFragmentTestLanguage.g:994:1: ruleRecursiveFragment[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) ;
    public final EObject ruleRecursiveFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_RecursiveFragment_1 = null;

        EObject lv_prev_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:997:28: ( ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) )
            // InternalFragmentTestLanguage.g:998:1: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            {
            // InternalFragmentTestLanguage.g:998:1: ( (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
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
                    // InternalFragmentTestLanguage.g:998:2: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    {
                    // InternalFragmentTestLanguage.g:998:2: (otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')' )
                    // InternalFragmentTestLanguage.g:998:4: otherlv_0= '(' this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getRecursiveFragmentAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getRecursiveFragmentRule());
                      		}
                              newCompositeNode(grammarAccess.getRecursiveFragmentAccess().getRecursiveFragmentParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    this_RecursiveFragment_1=ruleRecursiveFragment(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RecursiveFragment_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getRecursiveFragmentAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguage.g:1019:6: ( (lv_prev_3_0= ruleNamedByAction ) )
                    {
                    // InternalFragmentTestLanguage.g:1019:6: ( (lv_prev_3_0= ruleNamedByAction ) )
                    // InternalFragmentTestLanguage.g:1020:1: (lv_prev_3_0= ruleNamedByAction )
                    {
                    // InternalFragmentTestLanguage.g:1020:1: (lv_prev_3_0= ruleNamedByAction )
                    // InternalFragmentTestLanguage.g:1021:3: lv_prev_3_0= ruleNamedByAction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRecursiveFragmentAccess().getPrevNamedByActionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_prev_3_0=ruleNamedByAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRecursiveFragmentRule());
                      	        }
                             		set(
                             			current, 
                             			"prev",
                              		lv_prev_3_0, 
                              		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.NamedByAction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRecursiveFragment"


    // $ANTLR start "entryRuleNamedByAction"
    // InternalFragmentTestLanguage.g:1045:1: entryRuleNamedByAction returns [EObject current=null] : iv_ruleNamedByAction= ruleNamedByAction EOF ;
    public final EObject entryRuleNamedByAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedByAction = null;


        try {
            // InternalFragmentTestLanguage.g:1046:2: (iv_ruleNamedByAction= ruleNamedByAction EOF )
            // InternalFragmentTestLanguage.g:1047:2: iv_ruleNamedByAction= ruleNamedByAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedByActionRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedByAction"


    // $ANTLR start "ruleNamedByAction"
    // InternalFragmentTestLanguage.g:1054:1: ruleNamedByAction returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNamedByAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:1057:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFragmentTestLanguage.g:1058:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFragmentTestLanguage.g:1058:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:1058:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:1058:2: ()
            // InternalFragmentTestLanguage.g:1059:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNamedByActionAccess().getPRFNamedAction_0(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguage.g:1064:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:1065:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:1065:1: (lv_name_1_0= RULE_ID )
            // InternalFragmentTestLanguage.g:1066:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getNamedByActionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNamedByActionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNamedByAction"

    // $ANTLR start synpred1_InternalFragmentTestLanguage
    public final void synpred1_InternalFragmentTestLanguage_fragment() throws RecognitionException {   
        // InternalFragmentTestLanguage.g:676:2: ( ( '-' rulePRFNamedRef[null] ) )
        // InternalFragmentTestLanguage.g:676:3: ( '-' rulePRFNamedRef[null] )
        {
        // InternalFragmentTestLanguage.g:676:3: ( '-' rulePRFNamedRef[null] )
        // InternalFragmentTestLanguage.g:676:5: '-' rulePRFNamedRef[null]
        {
        match(input,21,FollowSets000.FOLLOW_3); if (state.failed) return ;
        pushFollow(FollowSets000.FOLLOW_2);
        rulePRFNamedRef(null);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalFragmentTestLanguage

    // Delegated rules

    public final boolean synpred1_InternalFragmentTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalFragmentTestLanguage_fragment(); // can never throw exception
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