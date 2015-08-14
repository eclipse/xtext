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

@SuppressWarnings("all")
public class InternalFragmentTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "':'", "'-'", "'<-'", "'.'"
    };
    public static final int RULE_ID=4;
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
             newCompositeNode(grammarAccess.getParserRuleFragmentsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleFragments=ruleParserRuleFragments();

            state._fsp--;

             current =iv_ruleParserRuleFragments; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:76:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) ) ;
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
            // InternalFragmentTestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:2: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:2: ()
            // InternalFragmentTestLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:86:2: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) ) | (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) ) | (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) ) | (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) ) )
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
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
                        
                    // InternalFragmentTestLanguage.g:90:1: ( (lv_element_2_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguage.g:91:1: (lv_element_2_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguage.g:91:1: (lv_element_2_0= rulePRFNamed )
                    // InternalFragmentTestLanguage.g:92:3: lv_element_2_0= rulePRFNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // InternalFragmentTestLanguage.g:109:8: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
                        
                    // InternalFragmentTestLanguage.g:113:1: ( (lv_element_4_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguage.g:114:1: (lv_element_4_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguage.g:114:1: (lv_element_4_0= rulePRFNamed )
                    // InternalFragmentTestLanguage.g:115:3: lv_element_4_0= rulePRFNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_4);
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

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_5, grammarAccess.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                        
                    // InternalFragmentTestLanguage.g:135:1: ( (otherlv_6= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:136:1: (otherlv_6= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:136:1: (otherlv_6= RULE_ID )
                    // InternalFragmentTestLanguage.g:137:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getParserRuleFragmentsRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_6, grammarAccess.getParserRuleFragmentsAccess().getRefPRFNamedCrossReference_1_1_3_0()); 
                    	

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
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_7, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
                        
                    // InternalFragmentTestLanguage.g:153:1: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // InternalFragmentTestLanguage.g:154:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // InternalFragmentTestLanguage.g:154:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    // InternalFragmentTestLanguage.g:155:3: lv_element_8_0= rulePRFNamedRefFirst
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedRefFirstParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:172:6: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // InternalFragmentTestLanguage.g:172:6: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // InternalFragmentTestLanguage.g:172:8: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_9, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
                        
                    // InternalFragmentTestLanguage.g:176:1: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // InternalFragmentTestLanguage.g:177:1: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // InternalFragmentTestLanguage.g:177:1: (lv_element_10_0= rulePRFNamedWithAction )
                    // InternalFragmentTestLanguage.g:178:3: lv_element_10_0= rulePRFNamedWithAction
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionParserRuleCall_1_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) )
                    {
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) ) )
                    // InternalFragmentTestLanguage.g:195:8: otherlv_11= '#5' ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFiveKeyword_1_4_0());
                        
                    // InternalFragmentTestLanguage.g:199:1: ( (lv_element_12_0= rulePRFNamedWithActionInFragment ) )
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithActionInFragment )
                    {
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithActionInFragment )
                    // InternalFragmentTestLanguage.g:201:3: lv_element_12_0= rulePRFNamedWithActionInFragment
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:218:6: (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) )
                    {
                    // InternalFragmentTestLanguage.g:218:6: (otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) ) )
                    // InternalFragmentTestLanguage.g:218:8: otherlv_13= '#6' ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_13, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitSixKeyword_1_5_0());
                        
                    // InternalFragmentTestLanguage.g:222:1: ( (lv_element_14_0= rulePRFNamedWithActionInFragment2 ) )
                    // InternalFragmentTestLanguage.g:223:1: (lv_element_14_0= rulePRFNamedWithActionInFragment2 )
                    {
                    // InternalFragmentTestLanguage.g:223:1: (lv_element_14_0= rulePRFNamedWithActionInFragment2 )
                    // InternalFragmentTestLanguage.g:224:3: lv_element_14_0= rulePRFNamedWithActionInFragment2
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:241:6: (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) )
                    {
                    // InternalFragmentTestLanguage.g:241:6: (otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) ) )
                    // InternalFragmentTestLanguage.g:241:8: otherlv_15= '#7' ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_15, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitSevenKeyword_1_6_0());
                        
                    // InternalFragmentTestLanguage.g:245:1: ( (lv_element_16_0= rulePRFNamedWithActionInFragment3 ) )
                    // InternalFragmentTestLanguage.g:246:1: (lv_element_16_0= rulePRFNamedWithActionInFragment3 )
                    {
                    // InternalFragmentTestLanguage.g:246:1: (lv_element_16_0= rulePRFNamedWithActionInFragment3 )
                    // InternalFragmentTestLanguage.g:247:3: lv_element_16_0= rulePRFNamedWithActionInFragment3
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalFragmentTestLanguage.g:264:6: (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) )
                    {
                    // InternalFragmentTestLanguage.g:264:6: (otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) ) )
                    // InternalFragmentTestLanguage.g:264:8: otherlv_17= '#8' ( (lv_element_18_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_17, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_7_0());
                        
                    // InternalFragmentTestLanguage.g:268:1: ( (lv_element_18_0= rulePRFNamedWithFQN ) )
                    // InternalFragmentTestLanguage.g:269:1: (lv_element_18_0= rulePRFNamedWithFQN )
                    {
                    // InternalFragmentTestLanguage.g:269:1: (lv_element_18_0= rulePRFNamedWithFQN )
                    // InternalFragmentTestLanguage.g:270:3: lv_element_18_0= rulePRFNamedWithFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:294:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // InternalFragmentTestLanguage.g:295:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // InternalFragmentTestLanguage.g:296:2: iv_rulePRFNamed= rulePRFNamed EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamed=rulePRFNamed();

            state._fsp--;

             current =iv_rulePRFNamed; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedFragmentParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_5);
            this_PRFNamedFragment_0=rulePRFNamedFragment(current);

            state._fsp--;

             
                    current = this_PRFNamedFragment_0; 
                    afterParserOrEnumRuleCall();
                
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
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                        
                    // InternalFragmentTestLanguage.g:323:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:324:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:324:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:325:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getPRFNamedAccess().getRefPRFNamedCrossReference_1_0_1_0()); 
                    	

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
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getPRFNamedAccess().getHyphenMinusKeyword_1_1_0());
                        
                     
                    		if (current==null) {
                    			current = createModelElement(grammarAccess.getPRFNamedRule());
                    		}
                            newCompositeNode(grammarAccess.getPRFNamedAccess().getPRFNamedRefParserRuleCall_1_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:361:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // InternalFragmentTestLanguage.g:362:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // InternalFragmentTestLanguage.g:363:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedRefFirstRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedRefFirst=rulePRFNamedRefFirst();

            state._fsp--;

             current =iv_rulePRFNamedRefFirst; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:370:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:373:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // InternalFragmentTestLanguage.g:374:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // InternalFragmentTestLanguage.g:374:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // InternalFragmentTestLanguage.g:374:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // InternalFragmentTestLanguage.g:374:2: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:375:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:375:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:376:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getPRFNamedRefFirstAccess().getLessThanSignHyphenMinusKeyword_1());
                
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedRefFirstAccess().getPRFNamedFragmentParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:411:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // InternalFragmentTestLanguage.g:412:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // InternalFragmentTestLanguage.g:413:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithAction=rulePRFNamedWithAction();

            state._fsp--;

             current =iv_rulePRFNamedWithAction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:420:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:423:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:424:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:424:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:425:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;

             
                    current = this_PRFNamed_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguage.g:433:1: ()
            // InternalFragmentTestLanguage.g:434:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:439:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:440:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:440:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguage.g:441:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

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

            // InternalFragmentTestLanguage.g:457:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFragmentTestLanguage.g:457:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguage.g:457:3: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:458:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:458:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguage.g:459:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0()); 
                    	

                    }


                    }

                    // InternalFragmentTestLanguage.g:470:2: ( (otherlv_4= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:471:1: (otherlv_4= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:471:1: (otherlv_4= RULE_ID )
                    // InternalFragmentTestLanguage.g:472:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:491:1: entryRulePRFNamedWithActionInFragment returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment = null;


        try {
            // InternalFragmentTestLanguage.g:492:2: (iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF )
            // InternalFragmentTestLanguage.g:493:2: iv_rulePRFNamedWithActionInFragment= rulePRFNamedWithActionInFragment EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithActionInFragment=rulePRFNamedWithActionInFragment();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:500:1: rulePRFNamedWithActionInFragment returns [EObject current=null] : (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_FragmentWithAction_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:503:28: ( (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:504:1: (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:504:1: (this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:505:5: this_FragmentWithAction_0= ruleFragmentWithAction[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )?
            {
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedWithActionInFragmentRule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedWithActionInFragmentAccess().getFragmentWithActionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_8);
            this_FragmentWithAction_0=ruleFragmentWithAction(current);

            state._fsp--;

             
                    current = this_FragmentWithAction_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguage.g:516:1: (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFragmentTestLanguage.g:516:3: otherlv_1= '-' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithActionInFragmentAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFragmentTestLanguage.g:520:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:521:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:521:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:522:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragmentRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:541:1: entryRulePRFNamedWithActionInFragment2 returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment2 = null;


        try {
            // InternalFragmentTestLanguage.g:542:2: (iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF )
            // InternalFragmentTestLanguage.g:543:2: iv_rulePRFNamedWithActionInFragment2= rulePRFNamedWithActionInFragment2 EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithActionInFragment2=rulePRFNamedWithActionInFragment2();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:550:1: rulePRFNamedWithActionInFragment2 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_FragmentWithAction2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:553:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:554:1: ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:554:1: ( ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:554:2: ( (lv_name_0_0= RULE_ID ) ) this_FragmentWithAction2_1= ruleFragmentWithAction2[$current] (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalFragmentTestLanguage.g:554:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:555:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:555:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:556:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

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
                
            pushFollow(FollowSets000.FOLLOW_8);
            this_FragmentWithAction2_1=ruleFragmentWithAction2(current);

            state._fsp--;

             
                    current = this_FragmentWithAction2_1; 
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguage.g:584:1: (otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFragmentTestLanguage.g:584:3: otherlv_2= '-' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getPRFNamedWithActionInFragment2Access().getHyphenMinusKeyword_2_0());
                        
                    // InternalFragmentTestLanguage.g:588:1: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:589:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:589:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguage.g:590:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment2Rule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:609:1: entryRulePRFNamedWithActionInFragment3 returns [EObject current=null] : iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF ;
    public final EObject entryRulePRFNamedWithActionInFragment3() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithActionInFragment3 = null;


        try {
            // InternalFragmentTestLanguage.g:610:2: (iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF )
            // InternalFragmentTestLanguage.g:611:2: iv_rulePRFNamedWithActionInFragment3= rulePRFNamedWithActionInFragment3 EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithActionInFragment3=rulePRFNamedWithActionInFragment3();

            state._fsp--;

             current =iv_rulePRFNamedWithActionInFragment3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:618:1: rulePRFNamedWithActionInFragment3 returns [EObject current=null] : (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithActionInFragment3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_FragmentWithAction3_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:621:28: ( (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:622:1: (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:622:1: (this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:623:5: this_FragmentWithAction3_0= ruleFragmentWithAction3[$current] (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )?
            {
             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment3Rule());
            		}
                    newCompositeNode(grammarAccess.getPRFNamedWithActionInFragment3Access().getFragmentWithAction3ParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_8);
            this_FragmentWithAction3_0=ruleFragmentWithAction3(current);

            state._fsp--;

             
                    current = this_FragmentWithAction3_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguage.g:634:1: (otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFragmentTestLanguage.g:634:3: otherlv_1= '-' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithActionInFragment3Access().getHyphenMinusKeyword_1_0());
                        
                    // InternalFragmentTestLanguage.g:638:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:639:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:639:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:640:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionInFragment3Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:659:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // InternalFragmentTestLanguage.g:660:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // InternalFragmentTestLanguage.g:661:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
            {
             newCompositeNode(grammarAccess.getPRFNamedWithFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePRFNamedWithFQN=rulePRFNamedWithFQN();

            state._fsp--;

             current =iv_rulePRFNamedWithFQN; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:668:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:671:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // InternalFragmentTestLanguage.g:672:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // InternalFragmentTestLanguage.g:672:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // InternalFragmentTestLanguage.g:672:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // InternalFragmentTestLanguage.g:672:2: ( (lv_name_0_0= ruleFQN ) )
            // InternalFragmentTestLanguage.g:673:1: (lv_name_0_0= ruleFQN )
            {
            // InternalFragmentTestLanguage.g:673:1: (lv_name_0_0= ruleFQN )
            // InternalFragmentTestLanguage.g:674:3: lv_name_0_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getNameFQNParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_8);
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

            // InternalFragmentTestLanguage.g:690:2: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFragmentTestLanguage.g:690:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFragmentTestLanguage.g:694:1: ( ( ruleFQN2 ) )
                    // InternalFragmentTestLanguage.g:695:1: ( ruleFQN2 )
                    {
                    // InternalFragmentTestLanguage.g:695:1: ( ruleFQN2 )
                    // InternalFragmentTestLanguage.g:696:3: ruleFQN2
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithFQNRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPRFNamedWithFQNAccess().getRefPRFNamedCrossReference_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:717:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFragmentTestLanguage.g:718:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalFragmentTestLanguage.g:719:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:726:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:729:28: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:730:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:730:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:730:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguage.g:737:1: (this_Suffix_1= ruleSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFragmentTestLanguage.g:738:5: this_Suffix_1= ruleSuffix
                    {
                     
                            newCompositeNode(grammarAccess.getFQNAccess().getSuffixParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:756:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // InternalFragmentTestLanguage.g:757:2: (iv_ruleFQN2= ruleFQN2 EOF )
            // InternalFragmentTestLanguage.g:758:2: iv_ruleFQN2= ruleFQN2 EOF
            {
             newCompositeNode(grammarAccess.getFQN2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN2=ruleFQN2();

            state._fsp--;

             current =iv_ruleFQN2.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:765:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:768:28: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // InternalFragmentTestLanguage.g:769:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // InternalFragmentTestLanguage.g:769:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // InternalFragmentTestLanguage.g:769:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguage.g:776:1: (this_Suffix2_1= ruleSuffix2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFragmentTestLanguage.g:777:5: this_Suffix2_1= ruleSuffix2
            	    {
            	     
            	            newCompositeNode(grammarAccess.getFQN2Access().getSuffix2ParserRuleCall_1()); 
            	        
            	    pushFollow(FollowSets000.FOLLOW_9);
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
    // InternalFragmentTestLanguage.g:796:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:799:28: ( (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:800:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:800:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:801:2: kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffixAccess().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getSuffixAccess().getIDTerminalRuleCall_1()); 
                
            // InternalFragmentTestLanguage.g:813:1: (this_Suffix_2= ruleSuffix )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFragmentTestLanguage.g:814:5: this_Suffix_2= ruleSuffix
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixAccess().getSuffixParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguage.g:833:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:836:28: ( (kw= '.' this_ID_1= RULE_ID ) )
            // InternalFragmentTestLanguage.g:837:1: (kw= '.' this_ID_1= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:837:1: (kw= '.' this_ID_1= RULE_ID )
            // InternalFragmentTestLanguage.g:838:2: kw= '.' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffix2Access().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:859:1: ruleFragmentWithAction[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? ) ;
    public final EObject ruleFragmentWithAction(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:862:28: ( ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? ) )
            // InternalFragmentTestLanguage.g:863:1: ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? )
            {
            // InternalFragmentTestLanguage.g:863:1: ( ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )? )
            // InternalFragmentTestLanguage.g:863:2: ( (lv_name_0_0= RULE_ID ) ) () ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )?
            {
            // InternalFragmentTestLanguage.g:863:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:864:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:864:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:865:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

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

            // InternalFragmentTestLanguage.g:881:2: ()
            // InternalFragmentTestLanguage.g:882:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getFragmentWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:887:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:888:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:888:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguage.g:889:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

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

            // InternalFragmentTestLanguage.g:905:2: ( (otherlv_3= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalFragmentTestLanguage.g:906:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:906:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguage.g:907:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFragmentWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:927:1: ruleFragmentWithAction2[EObject in_current] returns [EObject current=in_current] : ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? ) ;
    public final EObject ruleFragmentWithAction2(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:930:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? ) )
            // InternalFragmentTestLanguage.g:931:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? )
            {
            // InternalFragmentTestLanguage.g:931:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? )
            // InternalFragmentTestLanguage.g:931:2: () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )?
            {
            // InternalFragmentTestLanguage.g:931:2: ()
            // InternalFragmentTestLanguage.g:932:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getFragmentWithAction2Access().getPRFNamedWithActionPrevAction_0(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:937:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:938:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:938:1: (lv_name_1_0= RULE_ID )
            // InternalFragmentTestLanguage.g:939:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

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

            // InternalFragmentTestLanguage.g:955:2: ( (otherlv_2= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalFragmentTestLanguage.g:956:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:956:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:957:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFragmentWithAction2Rule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:977:1: ruleFragmentWithAction3[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* ) ;
    public final EObject ruleFragmentWithAction3(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:980:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* ) )
            // InternalFragmentTestLanguage.g:981:1: ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* )
            {
            // InternalFragmentTestLanguage.g:981:1: ( ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )* )
            // InternalFragmentTestLanguage.g:981:2: ( (lv_name_0_0= RULE_ID ) ) ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )*
            {
            // InternalFragmentTestLanguage.g:981:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:982:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:982:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:983:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

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

            // InternalFragmentTestLanguage.g:999:2: ( () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )? )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==13) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFragmentTestLanguage.g:999:3: () otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )?
            	    {
            	    // InternalFragmentTestLanguage.g:999:3: ()
            	    // InternalFragmentTestLanguage.g:1000:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getFragmentWithAction3Access().getPRFNamedWithActionPrevAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getFragmentWithAction3Access().getHyphenMinusGreaterThanSignKeyword_1_1());
            	        
            	    // InternalFragmentTestLanguage.g:1009:1: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalFragmentTestLanguage.g:1010:1: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalFragmentTestLanguage.g:1010:1: (lv_name_3_0= RULE_ID )
            	    // InternalFragmentTestLanguage.g:1011:3: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

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

            	    // InternalFragmentTestLanguage.g:1027:2: ( (otherlv_4= RULE_ID ) )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==RULE_ID) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalFragmentTestLanguage.g:1028:1: (otherlv_4= RULE_ID )
            	            {
            	            // InternalFragmentTestLanguage.g:1028:1: (otherlv_4= RULE_ID )
            	            // InternalFragmentTestLanguage.g:1029:3: otherlv_4= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getFragmentWithAction3Rule());
            	            	        }
            	                    
            	            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

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
    // InternalFragmentTestLanguage.g:1049:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:1052:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:1053:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:1053:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:1054:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:1054:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:1055:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalFragmentTestLanguage.g:1080:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:1083:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:1084:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:1084:1: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:1085:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:1085:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:1086:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002012L});
    }


}