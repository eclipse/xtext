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
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalFragmentTestLanguageExParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NumberSignDigitOneDigitZero", "NumberSignDigitOneDigitOne", "NumberSignDigitOne", "NumberSignDigitTwo", "NumberSignDigitThree", "NumberSignDigitFour", "NumberSignDigitEight", "NumberSignDigitNine", "HyphenMinusGreaterThanSign", "LessThanSignHyphenMinus", "LeftParenthesis", "RightParenthesis", "HyphenMinus", "FullStop", "Colon", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int NumberSignDigitThree=8;
    public static final int NumberSignDigitNine=11;
    public static final int NumberSignDigitOneDigitOne=5;
    public static final int RULE_STRING=21;
    public static final int NumberSignDigitEight=10;
    public static final int RULE_SL_COMMENT=23;
    public static final int HyphenMinus=16;
    public static final int LeftParenthesis=14;
    public static final int NumberSignDigitFour=9;
    public static final int Colon=18;
    public static final int EOF=-1;
    public static final int NumberSignDigitOneDigitZero=4;
    public static final int FullStop=17;
    public static final int RULE_ID=19;
    public static final int RULE_WS=24;
    public static final int NumberSignDigitTwo=7;
    public static final int RightParenthesis=15;
    public static final int RULE_ANY_OTHER=25;
    public static final int RULE_INT=20;
    public static final int LessThanSignHyphenMinus=13;
    public static final int RULE_ML_COMMENT=22;
    public static final int HyphenMinusGreaterThanSign=12;
    public static final int NumberSignDigitOne=6;

    // delegates
    // delegators


        public InternalFragmentTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFragmentTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFragmentTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFragmentTestLanguageExParser.g"; }




    	private FragmentTestLanguageExGrammarAccess grammarAccess;
    	 	
    	public InternalFragmentTestLanguageExParser(TokenStream input, FragmentTestLanguageExGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragmentsEx";	
    	} 
    	   	   	
    	@Override
    	protected FragmentTestLanguageExGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleParserRuleFragmentsEx"
    // InternalFragmentTestLanguageExParser.g:61:1: entryRuleParserRuleFragmentsEx returns [EObject current=null] : iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF ;
    public final EObject entryRuleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragmentsEx = null;


        try {
            // InternalFragmentTestLanguageExParser.g:62:2: (iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF )
            // InternalFragmentTestLanguageExParser.g:63:2: iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleFragmentsExRule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParserRuleFragmentsEx"


    // $ANTLR start "ruleParserRuleFragmentsEx"
    // InternalFragmentTestLanguageExParser.g:70:1: ruleParserRuleFragmentsEx returns [EObject current=null] : this_ParserRuleFragments_0= ruleParserRuleFragments ;
    public final EObject ruleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRuleFragments_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:73:28: (this_ParserRuleFragments_0= ruleParserRuleFragments )
            // InternalFragmentTestLanguageExParser.g:75:5: this_ParserRuleFragments_0= ruleParserRuleFragments
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParserRuleFragmentsExAccess().getParserRuleFragmentsParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ParserRuleFragments_0=ruleParserRuleFragments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ParserRuleFragments_0;
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleParserRuleFragmentsEx"


    // $ANTLR start "entryRuleParserRuleFragments"
    // InternalFragmentTestLanguageExParser.g:91:1: entryRuleParserRuleFragments returns [EObject current=null] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final EObject entryRuleParserRuleFragments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragments = null;


        try {
            // InternalFragmentTestLanguageExParser.g:92:2: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // InternalFragmentTestLanguageExParser.g:93:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
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
    // InternalFragmentTestLanguageExParser.g:100:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) ;
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
            // InternalFragmentTestLanguageExParser.g:103:28: ( ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) ) )
            // InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) ) )
            // InternalFragmentTestLanguageExParser.g:104:2: () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:104:2: ()
            // InternalFragmentTestLanguageExParser.g:105:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguageExParser.g:110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) | (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) ) | (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) ) | (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case NumberSignDigitOne:
                {
                alt1=1;
                }
                break;
            case NumberSignDigitTwo:
                {
                alt1=2;
                }
                break;
            case NumberSignDigitThree:
                {
                alt1=3;
                }
                break;
            case NumberSignDigitFour:
                {
                alt1=4;
                }
                break;
            case NumberSignDigitEight:
                {
                alt1=5;
                }
                break;
            case NumberSignDigitNine:
                {
                alt1=6;
                }
                break;
            case NumberSignDigitOneDigitZero:
                {
                alt1=7;
                }
                break;
            case NumberSignDigitOneDigitOne:
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
                    // InternalFragmentTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) )
                    // InternalFragmentTestLanguageExParser.g:111:2: otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    otherlv_1=(Token)match(input,NumberSignDigitOne,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:115:1: ( (lv_element_2_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    // InternalFragmentTestLanguageExParser.g:117:3: lv_element_2_0= rulePRFNamed
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
                    // InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    // InternalFragmentTestLanguageExParser.g:135:2: otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,NumberSignDigitTwo,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:139:1: ( (lv_element_4_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    // InternalFragmentTestLanguageExParser.g:141:3: lv_element_4_0= rulePRFNamed
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

                    otherlv_5=(Token)match(input,HyphenMinusGreaterThanSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:162:1: ( (otherlv_6= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:164:3: otherlv_6= RULE_ID
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
                    // InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // InternalFragmentTestLanguageExParser.g:177:2: otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    otherlv_7=(Token)match(input,NumberSignDigitThree,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:181:1: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    // InternalFragmentTestLanguageExParser.g:183:3: lv_element_8_0= rulePRFNamedRefFirst
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
                    // InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // InternalFragmentTestLanguageExParser.g:201:2: otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    otherlv_9=(Token)match(input,NumberSignDigitFour,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:205:1: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    // InternalFragmentTestLanguageExParser.g:207:3: lv_element_10_0= rulePRFNamedWithAction
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
                    // InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // InternalFragmentTestLanguageExParser.g:225:2: otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_11=(Token)match(input,NumberSignDigitEight,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_4_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:229:1: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    // InternalFragmentTestLanguageExParser.g:231:3: lv_element_12_0= rulePRFNamedWithFQN
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
                    // InternalFragmentTestLanguageExParser.g:248:6: (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:248:6: (otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) ) )
                    // InternalFragmentTestLanguageExParser.g:249:2: otherlv_13= NumberSignDigitNine ( (lv_element_14_0= rulePRFWithPredicate ) )
                    {
                    otherlv_13=(Token)match(input,NumberSignDigitNine,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitNineKeyword_1_5_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:253:1: ( (lv_element_14_0= rulePRFWithPredicate ) )
                    // InternalFragmentTestLanguageExParser.g:254:1: (lv_element_14_0= rulePRFWithPredicate )
                    {
                    // InternalFragmentTestLanguageExParser.g:254:1: (lv_element_14_0= rulePRFWithPredicate )
                    // InternalFragmentTestLanguageExParser.g:255:3: lv_element_14_0= rulePRFWithPredicate
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
                    // InternalFragmentTestLanguageExParser.g:272:6: (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:272:6: (otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) ) )
                    // InternalFragmentTestLanguageExParser.g:273:2: otherlv_15= NumberSignDigitOneDigitZero ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    {
                    otherlv_15=(Token)match(input,NumberSignDigitOneDigitZero,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitZeroKeyword_1_6_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:277:1: ( (lv_element_16_0= rulePRFNamedRecursive ) )
                    // InternalFragmentTestLanguageExParser.g:278:1: (lv_element_16_0= rulePRFNamedRecursive )
                    {
                    // InternalFragmentTestLanguageExParser.g:278:1: (lv_element_16_0= rulePRFNamedRecursive )
                    // InternalFragmentTestLanguageExParser.g:279:3: lv_element_16_0= rulePRFNamedRecursive
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
                    // InternalFragmentTestLanguageExParser.g:296:6: (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:296:6: (otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) ) )
                    // InternalFragmentTestLanguageExParser.g:297:2: otherlv_17= NumberSignDigitOneDigitOne ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    {
                    otherlv_17=(Token)match(input,NumberSignDigitOneDigitOne,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitOneKeyword_1_7_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:301:1: ( (lv_element_18_0= rulePRFNamedRecursiveFragment ) )
                    // InternalFragmentTestLanguageExParser.g:302:1: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    {
                    // InternalFragmentTestLanguageExParser.g:302:1: (lv_element_18_0= rulePRFNamedRecursiveFragment )
                    // InternalFragmentTestLanguageExParser.g:303:3: lv_element_18_0= rulePRFNamedRecursiveFragment
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
    // InternalFragmentTestLanguageExParser.g:327:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // InternalFragmentTestLanguageExParser.g:328:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // InternalFragmentTestLanguageExParser.g:329:2: iv_rulePRFNamed= rulePRFNamed EOF
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
    // InternalFragmentTestLanguageExParser.g:336:1: rulePRFNamed returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFNamed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_4 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:339:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguageExParser.g:340:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:340:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguageExParser.g:341:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
            // InternalFragmentTestLanguageExParser.g:352:1: ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Colon) ) {
                alt2=1;
            }
            else if ( (LA2_0==HyphenMinus) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:352:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:352:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    // InternalFragmentTestLanguageExParser.g:353:2: otherlv_1= Colon ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:357:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:358:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:358:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:359:3: otherlv_2= RULE_ID
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
                    // InternalFragmentTestLanguageExParser.g:371:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguageExParser.g:371:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguageExParser.g:372:2: otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    otherlv_3=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_3); if (state.failed) return current;
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
    // InternalFragmentTestLanguageExParser.g:396:1: entryRulePRFNamedRecursive returns [EObject current=null] : iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF ;
    public final EObject entryRulePRFNamedRecursive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRecursive = null;


        try {
            // InternalFragmentTestLanguageExParser.g:397:2: (iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF )
            // InternalFragmentTestLanguageExParser.g:398:2: iv_rulePRFNamedRecursive= rulePRFNamedRecursive EOF
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
    // InternalFragmentTestLanguageExParser.g:405:1: rulePRFNamedRecursive returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) ;
    public final EObject rulePRFNamedRecursive() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject this_RecursiveFromFragment_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:408:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] ) )
            // InternalFragmentTestLanguageExParser.g:409:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            {
            // InternalFragmentTestLanguageExParser.g:409:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current] )
            // InternalFragmentTestLanguageExParser.g:409:2: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFromFragment_1= ruleRecursiveFromFragment[$current]
            {
            // InternalFragmentTestLanguageExParser.g:409:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:410:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:410:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:411:3: lv_name_0_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:447:1: entryRulePRFNamedRecursiveFragment returns [EObject current=null] : iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF ;
    public final EObject entryRulePRFNamedRecursiveFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRecursiveFragment = null;


        try {
            // InternalFragmentTestLanguageExParser.g:448:2: (iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF )
            // InternalFragmentTestLanguageExParser.g:449:2: iv_rulePRFNamedRecursiveFragment= rulePRFNamedRecursiveFragment EOF
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
    // InternalFragmentTestLanguageExParser.g:456:1: rulePRFNamedRecursiveFragment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) ;
    public final EObject rulePRFNamedRecursiveFragment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject this_RecursiveFragment_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:459:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] ) )
            // InternalFragmentTestLanguageExParser.g:460:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            {
            // InternalFragmentTestLanguageExParser.g:460:1: ( ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current] )
            // InternalFragmentTestLanguageExParser.g:460:2: ( (lv_name_0_0= RULE_ID ) ) this_RecursiveFragment_1= ruleRecursiveFragment[$current]
            {
            // InternalFragmentTestLanguageExParser.g:460:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:461:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:461:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:462:3: lv_name_0_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:498:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // InternalFragmentTestLanguageExParser.g:499:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // InternalFragmentTestLanguageExParser.g:500:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
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
    // InternalFragmentTestLanguageExParser.g:507:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:510:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // InternalFragmentTestLanguageExParser.g:511:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // InternalFragmentTestLanguageExParser.g:511:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // InternalFragmentTestLanguageExParser.g:511:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // InternalFragmentTestLanguageExParser.g:511:2: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:512:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:512:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:513:3: otherlv_0= RULE_ID
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

            otherlv_1=(Token)match(input,LessThanSignHyphenMinus,FollowSets000.FOLLOW_3); if (state.failed) return current;
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
    // InternalFragmentTestLanguageExParser.g:549:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // InternalFragmentTestLanguageExParser.g:550:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // InternalFragmentTestLanguageExParser.g:551:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
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
    // InternalFragmentTestLanguageExParser.g:558:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:561:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguageExParser.g:562:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:562:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // InternalFragmentTestLanguageExParser.g:563:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
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
            // InternalFragmentTestLanguageExParser.g:571:1: ()
            // InternalFragmentTestLanguageExParser.g:572:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElementAndSet(
                          grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguageExParser.g:577:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:578:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:578:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:579:3: lv_name_2_0= RULE_ID
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

            // InternalFragmentTestLanguageExParser.g:595:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:595:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:595:3: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:596:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:596:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:597:3: otherlv_3= RULE_ID
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

                    // InternalFragmentTestLanguageExParser.g:608:2: ( (otherlv_4= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:609:1: (otherlv_4= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:609:1: (otherlv_4= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:610:3: otherlv_4= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:629:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // InternalFragmentTestLanguageExParser.g:630:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // InternalFragmentTestLanguageExParser.g:631:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
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
    // InternalFragmentTestLanguageExParser.g:638:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:641:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) )
            // InternalFragmentTestLanguageExParser.g:642:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:642:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            // InternalFragmentTestLanguageExParser.g:642:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            {
            // InternalFragmentTestLanguageExParser.g:642:2: ( (lv_name_0_0= ruleFQN ) )
            // InternalFragmentTestLanguageExParser.g:643:1: (lv_name_0_0= ruleFQN )
            {
            // InternalFragmentTestLanguageExParser.g:643:1: (lv_name_0_0= ruleFQN )
            // InternalFragmentTestLanguageExParser.g:644:3: lv_name_0_0= ruleFQN
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

            // InternalFragmentTestLanguageExParser.g:660:2: (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==HyphenMinus) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:661:2: otherlv_1= HyphenMinus ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                          
                    }
                    // InternalFragmentTestLanguageExParser.g:665:1: ( ( ruleFQN2 ) )
                    // InternalFragmentTestLanguageExParser.g:666:1: ( ruleFQN2 )
                    {
                    // InternalFragmentTestLanguageExParser.g:666:1: ( ruleFQN2 )
                    // InternalFragmentTestLanguageExParser.g:667:3: ruleFQN2
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
    // InternalFragmentTestLanguageExParser.g:689:1: entryRulePRFWithPredicate returns [EObject current=null] : iv_rulePRFWithPredicate= rulePRFWithPredicate EOF ;
    public final EObject entryRulePRFWithPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFWithPredicate = null;


        try {
            // InternalFragmentTestLanguageExParser.g:690:2: (iv_rulePRFWithPredicate= rulePRFWithPredicate EOF )
            // InternalFragmentTestLanguageExParser.g:691:2: iv_rulePRFWithPredicate= rulePRFWithPredicate EOF
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
    // InternalFragmentTestLanguageExParser.g:698:1: rulePRFWithPredicate returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFWithPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:701:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguageExParser.g:702:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:702:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguageExParser.g:703:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
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
            // InternalFragmentTestLanguageExParser.g:714:1: ( ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==HyphenMinus) && (synpred1_InternalFragmentTestLanguageExParser())) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:714:2: ( ( HyphenMinus rulePRFNamedRef[null] ) )=> (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguageExParser.g:716:26: (otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguageExParser.g:717:2: otherlv_1= HyphenMinus this_PRFNamedRef_2= rulePRFNamedRef[$current]
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_3); if (state.failed) return current;
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
    // InternalFragmentTestLanguageExParser.g:741:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFragmentTestLanguageExParser.g:742:1: (iv_ruleFQN= ruleFQN EOF )
            // InternalFragmentTestLanguageExParser.g:743:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalFragmentTestLanguageExParser.g:750:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:754:6: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // InternalFragmentTestLanguageExParser.g:755:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // InternalFragmentTestLanguageExParser.g:755:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // InternalFragmentTestLanguageExParser.g:755:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalFragmentTestLanguageExParser.g:762:1: (this_Suffix_1= ruleSuffix )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==FullStop) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:763:5: this_Suffix_1= ruleSuffix
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
    // InternalFragmentTestLanguageExParser.g:781:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // InternalFragmentTestLanguageExParser.g:782:1: (iv_ruleFQN2= ruleFQN2 EOF )
            // InternalFragmentTestLanguageExParser.g:783:2: iv_ruleFQN2= ruleFQN2 EOF
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
    // InternalFragmentTestLanguageExParser.g:790:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:794:6: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // InternalFragmentTestLanguageExParser.g:795:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // InternalFragmentTestLanguageExParser.g:795:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // InternalFragmentTestLanguageExParser.g:795:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalFragmentTestLanguageExParser.g:802:1: (this_Suffix2_1= ruleSuffix2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==FullStop) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFragmentTestLanguageExParser.g:803:5: this_Suffix2_1= ruleSuffix2
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
    // InternalFragmentTestLanguageExParser.g:822:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:826:6: ( (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // InternalFragmentTestLanguageExParser.g:827:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // InternalFragmentTestLanguageExParser.g:827:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // InternalFragmentTestLanguageExParser.g:828:2: kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
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
            // InternalFragmentTestLanguageExParser.g:840:1: (this_Suffix_2= ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FullStop) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:841:5: this_Suffix_2= ruleSuffix
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
    // InternalFragmentTestLanguageExParser.g:860:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:864:6: ( (kw= FullStop this_ID_1= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:865:1: (kw= FullStop this_ID_1= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:865:1: (kw= FullStop this_ID_1= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:866:2: kw= FullStop this_ID_1= RULE_ID
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
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
    // InternalFragmentTestLanguageExParser.g:887:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:890:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFragmentTestLanguageExParser.g:891:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguageExParser.g:891:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:892:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:892:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:893:3: lv_name_0_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:918:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:921:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFragmentTestLanguageExParser.g:922:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguageExParser.g:922:1: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:923:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:923:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:924:3: otherlv_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:944:1: ruleRecursiveFromFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_prev_0_0= ruleNamedInParentheses ) ) ;
    public final EObject ruleRecursiveFromFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_prev_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:947:28: ( ( (lv_prev_0_0= ruleNamedInParentheses ) ) )
            // InternalFragmentTestLanguageExParser.g:948:1: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            {
            // InternalFragmentTestLanguageExParser.g:948:1: ( (lv_prev_0_0= ruleNamedInParentheses ) )
            // InternalFragmentTestLanguageExParser.g:949:1: (lv_prev_0_0= ruleNamedInParentheses )
            {
            // InternalFragmentTestLanguageExParser.g:949:1: (lv_prev_0_0= ruleNamedInParentheses )
            // InternalFragmentTestLanguageExParser.g:950:3: lv_prev_0_0= ruleNamedInParentheses
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
    // InternalFragmentTestLanguageExParser.g:974:1: entryRuleNamedInParentheses returns [EObject current=null] : iv_ruleNamedInParentheses= ruleNamedInParentheses EOF ;
    public final EObject entryRuleNamedInParentheses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedInParentheses = null;


        try {
            // InternalFragmentTestLanguageExParser.g:975:2: (iv_ruleNamedInParentheses= ruleNamedInParentheses EOF )
            // InternalFragmentTestLanguageExParser.g:976:2: iv_ruleNamedInParentheses= ruleNamedInParentheses EOF
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
    // InternalFragmentTestLanguageExParser.g:983:1: ruleNamedInParentheses returns [EObject current=null] : ( (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleNamedInParentheses() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        EObject this_NamedInParentheses_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:986:28: ( ( (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) ) )
            // InternalFragmentTestLanguageExParser.g:987:1: ( (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:987:1: ( (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LeftParenthesis) ) {
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
                    // InternalFragmentTestLanguageExParser.g:987:2: (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis )
                    {
                    // InternalFragmentTestLanguageExParser.g:987:2: (otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis )
                    // InternalFragmentTestLanguageExParser.g:988:2: otherlv_0= LeftParenthesis this_NamedInParentheses_1= ruleNamedInParentheses otherlv_2= RightParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_6); if (state.failed) return current;
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
                    otherlv_2=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNamedInParenthesesAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguageExParser.g:1007:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:1007:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    // InternalFragmentTestLanguageExParser.g:1007:7: () ( (lv_name_4_0= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:1007:7: ()
                    // InternalFragmentTestLanguageExParser.g:1008:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNamedInParenthesesAccess().getPRFNamedAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalFragmentTestLanguageExParser.g:1013:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:1014:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:1014:1: (lv_name_4_0= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:1015:3: lv_name_4_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:1040:1: ruleRecursiveFragment[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) ;
    public final EObject ruleRecursiveFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_RecursiveFragment_1 = null;

        EObject lv_prev_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:1043:28: ( ( (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis ) | ( (lv_prev_3_0= ruleNamedByAction ) ) ) )
            // InternalFragmentTestLanguageExParser.g:1044:1: ( (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:1044:1: ( (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis ) | ( (lv_prev_3_0= ruleNamedByAction ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LeftParenthesis) ) {
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
                    // InternalFragmentTestLanguageExParser.g:1044:2: (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis )
                    {
                    // InternalFragmentTestLanguageExParser.g:1044:2: (otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis )
                    // InternalFragmentTestLanguageExParser.g:1045:2: otherlv_0= LeftParenthesis this_RecursiveFragment_1= ruleRecursiveFragment[$current] otherlv_2= RightParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_6); if (state.failed) return current;
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
                    otherlv_2=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getRecursiveFragmentAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFragmentTestLanguageExParser.g:1067:6: ( (lv_prev_3_0= ruleNamedByAction ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:1067:6: ( (lv_prev_3_0= ruleNamedByAction ) )
                    // InternalFragmentTestLanguageExParser.g:1068:1: (lv_prev_3_0= ruleNamedByAction )
                    {
                    // InternalFragmentTestLanguageExParser.g:1068:1: (lv_prev_3_0= ruleNamedByAction )
                    // InternalFragmentTestLanguageExParser.g:1069:3: lv_prev_3_0= ruleNamedByAction
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
    // InternalFragmentTestLanguageExParser.g:1093:1: entryRuleNamedByAction returns [EObject current=null] : iv_ruleNamedByAction= ruleNamedByAction EOF ;
    public final EObject entryRuleNamedByAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedByAction = null;


        try {
            // InternalFragmentTestLanguageExParser.g:1094:2: (iv_ruleNamedByAction= ruleNamedByAction EOF )
            // InternalFragmentTestLanguageExParser.g:1095:2: iv_ruleNamedByAction= ruleNamedByAction EOF
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
    // InternalFragmentTestLanguageExParser.g:1102:1: ruleNamedByAction returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNamedByAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:1105:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFragmentTestLanguageExParser.g:1106:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:1106:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFragmentTestLanguageExParser.g:1106:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguageExParser.g:1106:2: ()
            // InternalFragmentTestLanguageExParser.g:1107:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNamedByActionAccess().getPRFNamedAction_0(),
                          current);
                  
            }

            }

            // InternalFragmentTestLanguageExParser.g:1112:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:1113:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:1113:1: (lv_name_1_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:1114:3: lv_name_1_0= RULE_ID
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

    // $ANTLR start synpred1_InternalFragmentTestLanguageExParser
    public final void synpred1_InternalFragmentTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalFragmentTestLanguageExParser.g:714:2: ( ( HyphenMinus rulePRFNamedRef[null] ) )
        // InternalFragmentTestLanguageExParser.g:714:3: ( HyphenMinus rulePRFNamedRef[null] )
        {
        // InternalFragmentTestLanguageExParser.g:714:3: ( HyphenMinus rulePRFNamedRef[null] )
        // InternalFragmentTestLanguageExParser.g:715:1: HyphenMinus rulePRFNamedRef[null]
        {
        match(input,HyphenMinus,FollowSets000.FOLLOW_3); if (state.failed) return ;
        pushFollow(FollowSets000.FOLLOW_2);
        rulePRFNamedRef(null);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalFragmentTestLanguageExParser

    // Delegated rules

    public final boolean synpred1_InternalFragmentTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalFragmentTestLanguageExParser_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000050002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    }


}