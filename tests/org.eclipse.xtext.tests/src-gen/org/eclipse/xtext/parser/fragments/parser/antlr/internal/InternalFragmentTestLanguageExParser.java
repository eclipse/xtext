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

@SuppressWarnings("all")
public class InternalFragmentTestLanguageExParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NumberSignDigitOne", "NumberSignDigitTwo", "NumberSignDigitThree", "NumberSignDigitFour", "NumberSignDigitFive", "NumberSignDigitSix", "NumberSignDigitSeven", "NumberSignDigitEight", "HyphenMinusGreaterThanSign", "LessThanSignHyphenMinus", "HyphenMinus", "FullStop", "Colon", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=17;
    public static final int HyphenMinus=14;
    public static final int LessThanSignHyphenMinus=13;
    public static final int NumberSignDigitEight=11;
    public static final int RULE_ANY_OTHER=23;
    public static final int NumberSignDigitSeven=10;
    public static final int Colon=16;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=21;
    public static final int NumberSignDigitThree=6;
    public static final int FullStop=15;
    public static final int RULE_ML_COMMENT=20;
    public static final int RULE_STRING=19;
    public static final int NumberSignDigitOne=4;
    public static final int NumberSignDigitTwo=5;
    public static final int RULE_INT=18;
    public static final int NumberSignDigitFour=7;
    public static final int NumberSignDigitSix=9;
    public static final int RULE_WS=22;
    public static final int NumberSignDigitFive=8;
    public static final int HyphenMinusGreaterThanSign=12;

    // delegates
    // delegators


        public InternalFragmentTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFragmentTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFragmentTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g"; }




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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:61:1: entryRuleParserRuleFragmentsEx returns [EObject current=null] : iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF ;
    public final EObject entryRuleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragmentsEx = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:62:2: (iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:63:2: iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF
            {
             newCompositeNode(grammarAccess.getParserRuleFragmentsExRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx67);
            iv_ruleParserRuleFragmentsEx=ruleParserRuleFragmentsEx();

            state._fsp--;

             current =iv_ruleParserRuleFragmentsEx; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx77); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:70:1: ruleParserRuleFragmentsEx returns [EObject current=null] : this_ParserRuleFragments_0= ruleParserRuleFragments ;
    public final EObject ruleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRuleFragments_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:73:28: (this_ParserRuleFragments_0= ruleParserRuleFragments )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:75:5: this_ParserRuleFragments_0= ruleParserRuleFragments
            {
             
                    newCompositeNode(grammarAccess.getParserRuleFragmentsExAccess().getParserRuleFragmentsParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleFragments_in_ruleParserRuleFragmentsEx123);
            this_ParserRuleFragments_0=ruleParserRuleFragments();

            state._fsp--;


                    current = this_ParserRuleFragments_0;
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:91:1: entryRuleParserRuleFragments returns [EObject current=null] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final EObject entryRuleParserRuleFragments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragments = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:92:2: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:93:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
            {
             newCompositeNode(grammarAccess.getParserRuleFragmentsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleFragments_in_entryRuleParserRuleFragments156);
            iv_ruleParserRuleFragments=ruleParserRuleFragments();

            state._fsp--;

             current =iv_ruleParserRuleFragments; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleFragments166); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:100:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:103:28: ( ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:104:2: () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:104:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:105:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) )
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
            case NumberSignDigitFive:
                {
                alt1=5;
                }
                break;
            case NumberSignDigitSix:
                {
                alt1=6;
                }
                break;
            case NumberSignDigitSeven:
                {
                alt1=7;
                }
                break;
            case NumberSignDigitEight:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:111:2: otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) )
                    {
                    otherlv_1=(Token)match(input,NumberSignDigitOne,FollowSets000.FOLLOW_NumberSignDigitOne_in_ruleParserRuleFragments215); 

                        	newLeafNode(otherlv_1, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:115:1: ( (lv_element_2_0= rulePRFNamed ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:117:3: lv_element_2_0= rulePRFNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamed_in_ruleParserRuleFragments235);
                    lv_element_2_0=rulePRFNamed();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:135:2: otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,NumberSignDigitTwo,FollowSets000.FOLLOW_NumberSignDigitTwo_in_ruleParserRuleFragments256); 

                        	newLeafNode(otherlv_3, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:139:1: ( (lv_element_4_0= rulePRFNamed ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:141:3: lv_element_4_0= rulePRFNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamed_in_ruleParserRuleFragments276);
                    lv_element_4_0=rulePRFNamed();

                    state._fsp--;


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

                    otherlv_5=(Token)match(input,HyphenMinusGreaterThanSign,FollowSets000.FOLLOW_HyphenMinusGreaterThanSign_in_ruleParserRuleFragments289); 

                        	newLeafNode(otherlv_5, grammarAccess.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:162:1: ( (otherlv_6= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:164:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRuleFragments308); 

                    		newLeafNode(otherlv_6, grammarAccess.getParserRuleFragmentsAccess().getRefPRFNamedCrossReference_1_1_3_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:177:2: otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    otherlv_7=(Token)match(input,NumberSignDigitThree,FollowSets000.FOLLOW_NumberSignDigitThree_in_ruleParserRuleFragments329); 

                        	newLeafNode(otherlv_7, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:181:1: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:183:3: lv_element_8_0= rulePRFNamedRefFirst
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedRefFirstParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedRefFirst_in_ruleParserRuleFragments349);
                    lv_element_8_0=rulePRFNamedRefFirst();

                    state._fsp--;


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
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:201:2: otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    otherlv_9=(Token)match(input,NumberSignDigitFour,FollowSets000.FOLLOW_NumberSignDigitFour_in_ruleParserRuleFragments370); 

                        	newLeafNode(otherlv_9, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:205:1: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:207:3: lv_element_10_0= rulePRFNamedWithAction
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionParserRuleCall_1_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithAction_in_ruleParserRuleFragments390);
                    lv_element_10_0=rulePRFNamedWithAction();

                    state._fsp--;


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
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:225:2: otherlv_11= NumberSignDigitFive ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) )
                    {
                    otherlv_11=(Token)match(input,NumberSignDigitFive,FollowSets000.FOLLOW_NumberSignDigitFive_in_ruleParserRuleFragments411); 

                        	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFiveKeyword_1_4_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:229:1: ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithActionInFragment )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithActionInFragment )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:231:3: lv_element_12_0= rulePRFNamedWithActionInFragment
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment_in_ruleParserRuleFragments431);
                    lv_element_12_0=rulePRFNamedWithActionInFragment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                           		set(
                           			current, 
                           			"element",
                            		lv_element_12_0, 
                            		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithActionInFragment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:248:6: (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:248:6: (otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:249:2: otherlv_13= NumberSignDigitSix ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) )
                    {
                    otherlv_13=(Token)match(input,NumberSignDigitSix,FollowSets000.FOLLOW_NumberSignDigitSix_in_ruleParserRuleFragments452); 

                        	newLeafNode(otherlv_13, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitSixKeyword_1_5_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:253:1: ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:254:1: (lv_element_14_0= rulePRFNamedWithActionInFragment2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:254:1: (lv_element_14_0= rulePRFNamedWithActionInFragment2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:255:3: lv_element_14_0= rulePRFNamedWithActionInFragment2
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment2_in_ruleParserRuleFragments472);
                    lv_element_14_0=rulePRFNamedWithActionInFragment2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                           		set(
                           			current, 
                           			"element",
                            		lv_element_14_0, 
                            		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithActionInFragment2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:272:6: (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:272:6: (otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:273:2: otherlv_15= NumberSignDigitSeven ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) )
                    {
                    otherlv_15=(Token)match(input,NumberSignDigitSeven,FollowSets000.FOLLOW_NumberSignDigitSeven_in_ruleParserRuleFragments493); 

                        	newLeafNode(otherlv_15, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitSevenKeyword_1_6_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:277:1: ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:278:1: (lv_element_16_0= rulePRFNamedWithActionInFragment3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:278:1: (lv_element_16_0= rulePRFNamedWithActionInFragment3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:279:3: lv_element_16_0= rulePRFNamedWithActionInFragment3
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment3_in_ruleParserRuleFragments513);
                    lv_element_16_0=rulePRFNamedWithActionInFragment3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                           		set(
                           			current, 
                           			"element",
                            		lv_element_16_0, 
                            		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithActionInFragment3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:296:6: (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:296:6: (otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:297:2: otherlv_17= NumberSignDigitEight ( (lv_element_18_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_17=(Token)match(input,NumberSignDigitEight,FollowSets000.FOLLOW_NumberSignDigitEight_in_ruleParserRuleFragments534); 

                        	newLeafNode(otherlv_17, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_7_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:301:1: ( (lv_element_18_0= rulePRFNamedWithFQN ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:302:1: (lv_element_18_0= rulePRFNamedWithFQN )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:302:1: (lv_element_18_0= rulePRFNamedWithFQN )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:303:3: lv_element_18_0= rulePRFNamedWithFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithFQN_in_ruleParserRuleFragments554);
                    lv_element_18_0=rulePRFNamedWithFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                           		set(
                           			current, 
                           			"element",
                            		lv_element_18_0, 
                            		"org.eclipse.xtext.parser.fragments.FragmentTestLanguage.PRFNamedWithFQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:327:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:328:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:329:2: iv_rulePRFNamed= rulePRFNamed EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamed_in_entryRulePRFNamed591);
            iv_rulePRFNamed=rulePRFNamed();

            state._fsp--;

             current =iv_rulePRFNamed; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamed601); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:336:1: rulePRFNamed returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFNamed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:339:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:340:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:340:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:341:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            {
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedFragmentParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedFragment_in_rulePRFNamed648);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;


                    current = this_PRFNamedFragment_0;
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:352:1: ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:352:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:352:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:353:2: otherlv_1= Colon ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_Colon_in_rulePRFNamed663); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:357:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:358:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:358:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:359:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamed682); 

                    		newLeafNode(otherlv_2, grammarAccess.getPRFNamedAccess().getRefPRFNamedCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:371:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:371:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:372:2: otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    otherlv_3=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_HyphenMinus_in_rulePRFNamed703); 

                        	newLeafNode(otherlv_3, grammarAccess.getPRFNamedAccess().getHyphenMinusKeyword_1_1_0());
                        
                     
                    		if (current==null) {
                    			current = createModelElement(grammarAccess.getPRFNamedRule());
                    		}
                            newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedRefParserRuleCall_1_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePRFNamedRef_in_rulePRFNamed724);
                    this_PRFNamedRef_4=rulePRFNamedRef(current);

                    state._fsp--;


                            current = this_PRFNamedRef_4;
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRulePRFNamedRefFirst"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:396:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:397:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:398:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedRefFirstRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedRefFirst_in_entryRulePRFNamedRefFirst762);
            iv_rulePRFNamedRefFirst=rulePRFNamedRefFirst();

            state._fsp--;

             current =iv_rulePRFNamedRefFirst; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedRefFirst772); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:405:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:408:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:409:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:409:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:409:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:409:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:410:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:410:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:411:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedRefFirst817); 

            		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,LessThanSignHyphenMinus,FollowSets000.FOLLOW_LessThanSignHyphenMinus_in_rulePRFNamedRefFirst830); 

                	newLeafNode(otherlv_1, grammarAccess.getPRFNamedRefFirstAccess().getLessThanSignHyphenMinusKeyword_1());
                
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedRefFirstAccess().getPRFNamedFragmentParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedFragment_in_rulePRFNamedRefFirst851);
            this_PRFNamedFragment_2=rulePRFNamedFragment(current);

            state._fsp--;


                    current = this_PRFNamedFragment_2;
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:447:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:448:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:449:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithAction_in_entryRulePRFNamedWithAction886);
            iv_rulePRFNamedWithAction=rulePRFNamedWithAction();

            state._fsp--;

             current =iv_rulePRFNamedWithAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedWithAction896); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:456:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:459:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:460:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:460:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:461:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePRFNamed_in_rulePRFNamedWithAction943);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;


                    current = this_PRFNamed_0;
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:469:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:470:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:475:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:476:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:476:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:477:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithAction968); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPRFNamedWithActionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:493:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:493:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:493:3: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:494:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:494:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:495:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithAction994); 

                    		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:506:2: ( (otherlv_4= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:507:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:507:1: (otherlv_4= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:508:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithAction1014); 

                    		newLeafNode(otherlv_4, grammarAccess.getPRFNamedWithActionAccess().getRef2PRFNamedCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRulePRFNamedWithActionInFragment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:527:1: entryRulePRFNamedWithActionInFragment returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:528:2: (iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:529:2: iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragmentRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment_in_entryRulePRFNamedWithActionInFragment1051);
            iv_rulePRFNamedWithActionInFragment=rulePRFNamedWithActionInFragment();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment1061); 

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
    // $ANTLR end "entryRulePRFNamedWithActionInFragment"


    // $ANTLR start "rulePRFNamedWithActionInFragment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:536:1: rulePRFNamedWithActionInFragment returns [EObject current=null] : (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_FragmentWithAction_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:539:28: ( (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:540:1: (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:540:1: (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:541:5: this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )?
            {
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedWithActionInFragmentRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedWithActionInFragmentAccess().getFragmentWithActionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFragmentWithAction_in_rulePRFNamedWithActionInFragment1108);
            this_FragmentWithAction_0=ruleFragmentWithAction(current);

            state._fsp--;


                    current = this_FragmentWithAction_0;
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:552:1: (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==HyphenMinus) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:553:2: otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment1122); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithActionInFragmentAccess().getHyphenMinusKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:557:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:558:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:558:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:559:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragmentRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment1141); 

                    		newLeafNode(otherlv_2, grammarAccess.getPRFNamedWithActionInFragmentAccess().getRefPRFNamedCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRFNamedWithActionInFragment"


    // $ANTLR start "entryRulePRFNamedWithActionInFragment2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:578:1: entryRulePRFNamedWithActionInFragment2 returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:579:2: (iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:580:2: iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment2Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment2_in_entryRulePRFNamedWithActionInFragment21178);
            iv_rulePRFNamedWithActionInFragment2=rulePRFNamedWithActionInFragment2();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment21188); 

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
    // $ANTLR end "entryRulePRFNamedWithActionInFragment2"


    // $ANTLR start "rulePRFNamedWithActionInFragment2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:587:1: rulePRFNamedWithActionInFragment2 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_FragmentWithAction2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:590:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:591:1: ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:591:1: ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:591:2: ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:591:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:592:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:592:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:593:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment21230); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPRFNamedWithActionInFragment2Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment2Rule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment2Access().getFragmentWithAction2ParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFragmentWithAction2_in_rulePRFNamedWithActionInFragment21257);
            this_FragmentWithAction2_1=ruleFragmentWithAction2(current);

            state._fsp--;


                    current = this_FragmentWithAction2_1;
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:621:1: (otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==HyphenMinus) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:622:2: otherlv_2= HyphenMinus ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment21271); 

                        	newLeafNode(otherlv_2, grammarAccess.getPRFNamedWithActionInFragment2Access().getHyphenMinusKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:626:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:627:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:627:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:628:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment2Rule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment21290); 

                    		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionInFragment2Access().getRefPRFNamedCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRFNamedWithActionInFragment2"


    // $ANTLR start "entryRulePRFNamedWithActionInFragment3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:647:1: entryRulePRFNamedWithActionInFragment3 returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment3() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:648:2: (iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:649:2: iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment3Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithActionInFragment3_in_entryRulePRFNamedWithActionInFragment31327);
            iv_rulePRFNamedWithActionInFragment3=rulePRFNamedWithActionInFragment3();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment31337); 

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
    // $ANTLR end "entryRulePRFNamedWithActionInFragment3"


    // $ANTLR start "rulePRFNamedWithActionInFragment3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:656:1: rulePRFNamedWithActionInFragment3 returns [EObject current=null] : (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_FragmentWithAction3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:659:28: ( (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:660:1: (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:660:1: (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:661:5: this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )?
            {
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment3Rule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment3Access().getFragmentWithAction3ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFragmentWithAction3_in_rulePRFNamedWithActionInFragment31384);
            this_FragmentWithAction3_0=ruleFragmentWithAction3(current);

            state._fsp--;


                    current = this_FragmentWithAction3_0;
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:672:1: (otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==HyphenMinus) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:673:2: otherlv_1= HyphenMinus ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment31398); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithActionInFragment3Access().getHyphenMinusKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:677:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:678:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:678:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:679:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment3Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment31417); 

                    		newLeafNode(otherlv_2, grammarAccess.getPRFNamedWithActionInFragment3Access().getRefPRFNamedCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePRFNamedWithActionInFragment3"


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:698:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:699:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:700:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePRFNamedWithFQN_in_entryRulePRFNamedWithFQN1454);
            iv_rulePRFNamedWithFQN=rulePRFNamedWithFQN();

            state._fsp--;

             current =iv_rulePRFNamedWithFQN; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePRFNamedWithFQN1464); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:707:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:710:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:711:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:711:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:711:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:711:2: ( (lv_name_0_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:712:1: (lv_name_0_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:712:1: (lv_name_0_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:713:3: lv_name_0_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getNameFQNParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rulePRFNamedWithFQN1510);
            lv_name_0_0=ruleFQN();

            state._fsp--;


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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:729:2: (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==HyphenMinus) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:730:2: otherlv_1= HyphenMinus ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_HyphenMinus_in_rulePRFNamedWithFQN1524); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:734:1: ( ( ruleFQN2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:735:1: ( ruleFQN2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:735:1: ( ruleFQN2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:736:3: ruleFQN2
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithFQNRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getRefPRFNamedCrossReference_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN2_in_rulePRFNamedWithFQN1546);
                    ruleFQN2();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:758:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:759:1: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:760:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN1585);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN1596); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:767:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:771:6: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:772:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:772:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:772:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1636); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:779:1: (this_Suffix_1= ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FullStop) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:780:5: this_Suffix_1= ruleSuffix
                    {
                     
                            newCompositeNode(grammarAccess.getFQNAccess().getSuffixParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSuffix_in_ruleFQN1664);
                    this_Suffix_1=ruleSuffix();

                    state._fsp--;


                    		current.merge(this_Suffix_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule();
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:798:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:799:1: (iv_ruleFQN2= ruleFQN2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:800:2: iv_ruleFQN2= ruleFQN2 EOF
            {
             newCompositeNode(grammarAccess.getFQN2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN2_in_entryRuleFQN21711);
            iv_ruleFQN2=ruleFQN2();

            state._fsp--;

             current =iv_ruleFQN2.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN21722); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:807:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:811:6: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:812:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:812:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:812:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN21762); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:819:1: (this_Suffix2_1= ruleSuffix2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==FullStop) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:820:5: this_Suffix2_1= ruleSuffix2
            	    {
            	     
            	            newCompositeNode(grammarAccess.getFQN2Access().getSuffix2ParserRuleCall_1()); 
            	        
            	    pushFollow(FollowSets000.FOLLOW_ruleSuffix2_in_ruleFQN21790);
            	    this_Suffix2_1=ruleSuffix2();

            	    state._fsp--;


            	    		current.merge(this_Suffix2_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             leaveRule();
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:839:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:843:6: ( (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:844:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:844:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:845:2: kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_FullStop_in_ruleSuffix1852); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffixAccess().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuffix1867); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getSuffixAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:857:1: (this_Suffix_2= ruleSuffix )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==FullStop) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:858:5: this_Suffix_2= ruleSuffix
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixAccess().getSuffixParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSuffix_in_ruleSuffix1895);
                    this_Suffix_2=ruleSuffix();

                    state._fsp--;


                    		current.merge(this_Suffix_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule();
                
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:877:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:881:6: ( (kw= FullStop this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:882:1: (kw= FullStop this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:882:1: (kw= FullStop this_ID_1= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:883:2: kw= FullStop this_ID_1= RULE_ID
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_FullStop_in_ruleSuffix21957); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffix2Access().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuffix21972); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getSuffix2Access().getIDTerminalRuleCall_1()); 
                

            }


            }

             leaveRule();
                
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


    // $ANTLR start "ruleFragmentWithAction"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:904:1: ruleFragmentWithAction[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? ) ;
    public final EObject ruleFragmentWithAction(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:907:28: ( ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:908:1: ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:908:1: ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:908:2: ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:908:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:909:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:909:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:910:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction2038); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFragmentWithActionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentWithActionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:926:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:927:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getFragmentWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:932:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:933:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:933:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:934:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction2069); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFragmentWithActionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentWithActionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:950:2: ( (otherlv_3= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:951:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:951:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:952:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFragmentWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction2094); 

                    		newLeafNode(otherlv_3, grammarAccess.getFragmentWithActionAccess().getRef2PRFNamedCrossReference_3_0()); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentWithAction"


    // $ANTLR start "ruleFragmentWithAction2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:972:1: ruleFragmentWithAction2[EObject in_current] returns [EObject current=in_current] : ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? ) ;
    public final EObject ruleFragmentWithAction2(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:975:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:976:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:976:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:976:2: () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:976:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:977:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getFragmentWithAction2Access().getPRFNamedWithActionPrevAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:982:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:983:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:983:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:984:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction22161); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFragmentWithAction2Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentWithAction2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1000:2: ( (otherlv_2= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1001:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1001:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1002:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFragmentWithAction2Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction22186); 

                    		newLeafNode(otherlv_2, grammarAccess.getFragmentWithAction2Access().getRef2PRFNamedCrossReference_2_0()); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentWithAction2"


    // $ANTLR start "ruleFragmentWithAction3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1022:1: ruleFragmentWithAction3[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* ) ;
    public final EObject ruleFragmentWithAction3(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1025:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1026:1: ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1026:1: ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1026:2: ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1026:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1027:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1027:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1028:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction32244); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFragmentWithAction3Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentWithAction3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1044:2: ( () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==HyphenMinusGreaterThanSign) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1044:3: () otherlv_2= HyphenMinusGreaterThanSign ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )?
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1044:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1045:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getFragmentWithAction3Access().getPRFNamedWithActionPrevAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,HyphenMinusGreaterThanSign,FollowSets000.FOLLOW_HyphenMinusGreaterThanSign_in_ruleFragmentWithAction32272); 

            	        	newLeafNode(otherlv_2, grammarAccess.getFragmentWithAction3Access().getHyphenMinusGreaterThanSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1055:1: ( (lv_name_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1056:1: (lv_name_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1056:1: (lv_name_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1057:3: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction32288); 

            	    			newLeafNode(lv_name_3_0, grammarAccess.getFragmentWithAction3Access().getNameIDTerminalRuleCall_1_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getFragmentWithAction3Rule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"name",
            	            		lv_name_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1073:2: ( (otherlv_4= RULE_ID ) )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==RULE_ID) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1074:1: (otherlv_4= RULE_ID )
            	            {
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1074:1: (otherlv_4= RULE_ID )
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1075:3: otherlv_4= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getFragmentWithAction3Rule());
            	            	        }
            	                    
            	            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFragmentWithAction32313); 

            	            		newLeafNode(otherlv_4, grammarAccess.getFragmentWithAction3Access().getRef2PRFNamedCrossReference_1_3_0()); 
            	            	

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentWithAction3"


    // $ANTLR start "rulePRFNamedFragment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1095:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1098:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1099:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1099:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1100:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1100:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1101:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedFragment2372); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPRFNamedFragmentAccess().getNameIDTerminalRuleCall_0()); 
            		

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1126:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1129:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1130:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1130:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1131:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1131:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/fragments/parser/antlr/internal/InternalFragmentTestLanguageExParser.g:1132:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePRFNamedRef2435); 

            		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefAccess().getRefPRFNamedCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleFragments_in_ruleParserRuleFragmentsEx123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleFragments_in_entryRuleParserRuleFragments156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleFragments166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitOne_in_ruleParserRuleFragments215 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamed_in_ruleParserRuleFragments235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitTwo_in_ruleParserRuleFragments256 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamed_in_ruleParserRuleFragments276 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_HyphenMinusGreaterThanSign_in_ruleParserRuleFragments289 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRuleFragments308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitThree_in_ruleParserRuleFragments329 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedRefFirst_in_ruleParserRuleFragments349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitFour_in_ruleParserRuleFragments370 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedWithAction_in_ruleParserRuleFragments390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitFive_in_ruleParserRuleFragments411 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment_in_ruleParserRuleFragments431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitSix_in_ruleParserRuleFragments452 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment2_in_ruleParserRuleFragments472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitSeven_in_ruleParserRuleFragments493 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment3_in_ruleParserRuleFragments513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitEight_in_ruleParserRuleFragments534 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedWithFQN_in_ruleParserRuleFragments554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamed_in_entryRulePRFNamed591 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamed601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedFragment_in_rulePRFNamed648 = new BitSet(new long[]{0x0000000000014002L});
        public static final BitSet FOLLOW_Colon_in_rulePRFNamed663 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamed682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_HyphenMinus_in_rulePRFNamed703 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedRef_in_rulePRFNamed724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedRefFirst_in_entryRulePRFNamedRefFirst762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedRefFirst772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedRefFirst817 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_LessThanSignHyphenMinus_in_rulePRFNamedRefFirst830 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePRFNamedFragment_in_rulePRFNamedRefFirst851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedWithAction_in_entryRulePRFNamedWithAction886 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedWithAction896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamed_in_rulePRFNamedWithAction943 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithAction968 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithAction994 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithAction1014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment_in_entryRulePRFNamedWithActionInFragment1051 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment1061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFragmentWithAction_in_rulePRFNamedWithActionInFragment1108 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment1122 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment1141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment2_in_entryRulePRFNamedWithActionInFragment21178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment21188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment21230 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleFragmentWithAction2_in_rulePRFNamedWithActionInFragment21257 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment21271 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment21290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedWithActionInFragment3_in_entryRulePRFNamedWithActionInFragment31327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedWithActionInFragment31337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFragmentWithAction3_in_rulePRFNamedWithActionInFragment31384 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_HyphenMinus_in_rulePRFNamedWithActionInFragment31398 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedWithActionInFragment31417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePRFNamedWithFQN_in_entryRulePRFNamedWithFQN1454 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePRFNamedWithFQN1464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rulePRFNamedWithFQN1510 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_HyphenMinus_in_rulePRFNamedWithFQN1524 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleFQN2_in_rulePRFNamedWithFQN1546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1585 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN1596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1636 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleSuffix_in_ruleFQN1664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN2_in_entryRuleFQN21711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN21722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN21762 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleSuffix2_in_ruleFQN21790 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_FullStop_in_ruleSuffix1852 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuffix1867 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleSuffix_in_ruleSuffix1895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_FullStop_in_ruleSuffix21957 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuffix21972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction2038 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction2069 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction2094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction22161 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction22186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction32244 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_HyphenMinusGreaterThanSign_in_ruleFragmentWithAction32272 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction32288 = new BitSet(new long[]{0x0000000000021002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFragmentWithAction32313 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedFragment2372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePRFNamedRef2435 = new BitSet(new long[]{0x0000000000000002L});
    }


}