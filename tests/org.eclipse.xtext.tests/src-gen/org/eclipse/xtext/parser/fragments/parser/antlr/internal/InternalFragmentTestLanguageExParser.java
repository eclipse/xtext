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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NumberSignDigitOne", "NumberSignDigitTwo", "NumberSignDigitThree", "NumberSignDigitFour", "NumberSignDigitEight", "HyphenMinusGreaterThanSign", "LessThanSignHyphenMinus", "HyphenMinus", "FullStop", "Colon", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=14;
    public static final int HyphenMinus=11;
    public static final int LessThanSignHyphenMinus=10;
    public static final int NumberSignDigitEight=8;
    public static final int RULE_ANY_OTHER=20;
    public static final int Colon=13;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=18;
    public static final int NumberSignDigitThree=6;
    public static final int FullStop=12;
    public static final int RULE_ML_COMMENT=17;
    public static final int RULE_STRING=16;
    public static final int NumberSignDigitOne=4;
    public static final int NumberSignDigitTwo=5;
    public static final int RULE_INT=15;
    public static final int NumberSignDigitFour=7;
    public static final int RULE_WS=19;
    public static final int HyphenMinusGreaterThanSign=9;

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
             newCompositeNode(grammarAccess.getParserRuleFragmentsExRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleFragmentsEx=ruleParserRuleFragmentsEx();

            state._fsp--;

             current =iv_ruleParserRuleFragmentsEx; 
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
             
                    newCompositeNode(grammarAccess.getParserRuleFragmentsExAccess().getParserRuleFragmentsParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalFragmentTestLanguageExParser.g:91:1: entryRuleParserRuleFragments returns [EObject current=null] : iv_ruleParserRuleFragments= ruleParserRuleFragments EOF ;
    public final EObject entryRuleParserRuleFragments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragments = null;


        try {
            // InternalFragmentTestLanguageExParser.g:92:2: (iv_ruleParserRuleFragments= ruleParserRuleFragments EOF )
            // InternalFragmentTestLanguageExParser.g:93:2: iv_ruleParserRuleFragments= ruleParserRuleFragments EOF
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
    // InternalFragmentTestLanguageExParser.g:100:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) ;
    public final EObject ruleParserRuleFragments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_element_2_0 = null;

        EObject lv_element_4_0 = null;

        EObject lv_element_8_0 = null;

        EObject lv_element_10_0 = null;

        EObject lv_element_12_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:103:28: ( ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) )
            // InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            // InternalFragmentTestLanguageExParser.g:104:2: () ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            {
            // InternalFragmentTestLanguageExParser.g:104:2: ()
            // InternalFragmentTestLanguageExParser.g:105:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                        current);
                

            }

            // InternalFragmentTestLanguageExParser.g:110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            int alt1=5;
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
            default:
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
                    otherlv_1=(Token)match(input,NumberSignDigitOne,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
                        
                    // InternalFragmentTestLanguageExParser.g:115:1: ( (lv_element_2_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguageExParser.g:116:1: (lv_element_2_0= rulePRFNamed )
                    // InternalFragmentTestLanguageExParser.g:117:3: lv_element_2_0= rulePRFNamed
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
                    // InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) ) )
                    // InternalFragmentTestLanguageExParser.g:135:2: otherlv_3= NumberSignDigitTwo ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= HyphenMinusGreaterThanSign ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,NumberSignDigitTwo,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
                        
                    // InternalFragmentTestLanguageExParser.g:139:1: ( (lv_element_4_0= rulePRFNamed ) )
                    // InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    {
                    // InternalFragmentTestLanguageExParser.g:140:1: (lv_element_4_0= rulePRFNamed )
                    // InternalFragmentTestLanguageExParser.g:141:3: lv_element_4_0= rulePRFNamed
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

                    otherlv_5=(Token)match(input,HyphenMinusGreaterThanSign,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_5, grammarAccess.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                        
                    // InternalFragmentTestLanguageExParser.g:162:1: ( (otherlv_6= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:163:1: (otherlv_6= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:164:3: otherlv_6= RULE_ID
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
                    // InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:176:6: (otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // InternalFragmentTestLanguageExParser.g:177:2: otherlv_7= NumberSignDigitThree ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {
                    otherlv_7=(Token)match(input,NumberSignDigitThree,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_7, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
                        
                    // InternalFragmentTestLanguageExParser.g:181:1: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // InternalFragmentTestLanguageExParser.g:182:1: (lv_element_8_0= rulePRFNamedRefFirst )
                    // InternalFragmentTestLanguageExParser.g:183:3: lv_element_8_0= rulePRFNamedRefFirst
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
                    // InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:200:6: (otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // InternalFragmentTestLanguageExParser.g:201:2: otherlv_9= NumberSignDigitFour ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {
                    otherlv_9=(Token)match(input,NumberSignDigitFour,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_9, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
                        
                    // InternalFragmentTestLanguageExParser.g:205:1: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // InternalFragmentTestLanguageExParser.g:206:1: (lv_element_10_0= rulePRFNamedWithAction )
                    // InternalFragmentTestLanguageExParser.g:207:3: lv_element_10_0= rulePRFNamedWithAction
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
                    // InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:224:6: (otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // InternalFragmentTestLanguageExParser.g:225:2: otherlv_11= NumberSignDigitEight ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_11=(Token)match(input,NumberSignDigitEight,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_4_0());
                        
                    // InternalFragmentTestLanguageExParser.g:229:1: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // InternalFragmentTestLanguageExParser.g:230:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    // InternalFragmentTestLanguageExParser.g:231:3: lv_element_12_0= rulePRFNamedWithFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_12_0=rulePRFNamedWithFQN();

                    state._fsp--;


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
    // InternalFragmentTestLanguageExParser.g:255:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // InternalFragmentTestLanguageExParser.g:256:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // InternalFragmentTestLanguageExParser.g:257:2: iv_rulePRFNamed= rulePRFNamed EOF
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
    // InternalFragmentTestLanguageExParser.g:264:1: rulePRFNamed returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFNamed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_4 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:267:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguageExParser.g:268:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:268:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguageExParser.g:269:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                
            // InternalFragmentTestLanguageExParser.g:280:1: ( (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                    // InternalFragmentTestLanguageExParser.g:280:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:280:2: (otherlv_1= Colon ( (otherlv_2= RULE_ID ) ) )
                    // InternalFragmentTestLanguageExParser.g:281:2: otherlv_1= Colon ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                        
                    // InternalFragmentTestLanguageExParser.g:285:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:286:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:286:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:287:3: otherlv_2= RULE_ID
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
                    // InternalFragmentTestLanguageExParser.g:299:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguageExParser.g:299:6: (otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguageExParser.g:300:2: otherlv_3= HyphenMinus this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    otherlv_3=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_3); 

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
    // InternalFragmentTestLanguageExParser.g:324:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // InternalFragmentTestLanguageExParser.g:325:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // InternalFragmentTestLanguageExParser.g:326:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
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
    // InternalFragmentTestLanguageExParser.g:333:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:336:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // InternalFragmentTestLanguageExParser.g:337:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // InternalFragmentTestLanguageExParser.g:337:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // InternalFragmentTestLanguageExParser.g:337:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= LessThanSignHyphenMinus this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // InternalFragmentTestLanguageExParser.g:337:2: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:338:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:338:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:339:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,LessThanSignHyphenMinus,FollowSets000.FOLLOW_3); 

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
    // InternalFragmentTestLanguageExParser.g:375:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // InternalFragmentTestLanguageExParser.g:376:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // InternalFragmentTestLanguageExParser.g:377:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
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
    // InternalFragmentTestLanguageExParser.g:384:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:387:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguageExParser.g:388:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:388:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // InternalFragmentTestLanguageExParser.g:389:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;


                    current = this_PRFNamed_0;
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguageExParser.g:397:1: ()
            // InternalFragmentTestLanguageExParser.g:398:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // InternalFragmentTestLanguageExParser.g:403:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:404:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:404:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:405:3: lv_name_2_0= RULE_ID
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

            // InternalFragmentTestLanguageExParser.g:421:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:421:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguageExParser.g:421:3: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:422:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:422:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:423:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0()); 
                    	

                    }


                    }

                    // InternalFragmentTestLanguageExParser.g:434:2: ( (otherlv_4= RULE_ID ) )
                    // InternalFragmentTestLanguageExParser.g:435:1: (otherlv_4= RULE_ID )
                    {
                    // InternalFragmentTestLanguageExParser.g:435:1: (otherlv_4= RULE_ID )
                    // InternalFragmentTestLanguageExParser.g:436:3: otherlv_4= RULE_ID
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


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // InternalFragmentTestLanguageExParser.g:455:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // InternalFragmentTestLanguageExParser.g:456:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // InternalFragmentTestLanguageExParser.g:457:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
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
    // InternalFragmentTestLanguageExParser.g:464:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:467:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? ) )
            // InternalFragmentTestLanguageExParser.g:468:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            {
            // InternalFragmentTestLanguageExParser.g:468:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )? )
            // InternalFragmentTestLanguageExParser.g:468:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            {
            // InternalFragmentTestLanguageExParser.g:468:2: ( (lv_name_0_0= ruleFQN ) )
            // InternalFragmentTestLanguageExParser.g:469:1: (lv_name_0_0= ruleFQN )
            {
            // InternalFragmentTestLanguageExParser.g:469:1: (lv_name_0_0= ruleFQN )
            // InternalFragmentTestLanguageExParser.g:470:3: lv_name_0_0= ruleFQN
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

            // InternalFragmentTestLanguageExParser.g:486:2: (otherlv_1= HyphenMinus ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==HyphenMinus) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:487:2: otherlv_1= HyphenMinus ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFragmentTestLanguageExParser.g:491:1: ( ( ruleFQN2 ) )
                    // InternalFragmentTestLanguageExParser.g:492:1: ( ruleFQN2 )
                    {
                    // InternalFragmentTestLanguageExParser.g:492:1: ( ruleFQN2 )
                    // InternalFragmentTestLanguageExParser.g:493:3: ruleFQN2
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
    // InternalFragmentTestLanguageExParser.g:515:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFragmentTestLanguageExParser.g:516:1: (iv_ruleFQN= ruleFQN EOF )
            // InternalFragmentTestLanguageExParser.g:517:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalFragmentTestLanguageExParser.g:524:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:528:6: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // InternalFragmentTestLanguageExParser.g:529:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // InternalFragmentTestLanguageExParser.g:529:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // InternalFragmentTestLanguageExParser.g:529:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguageExParser.g:536:1: (this_Suffix_1= ruleSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FullStop) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:537:5: this_Suffix_1= ruleSuffix
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
    // InternalFragmentTestLanguageExParser.g:555:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // InternalFragmentTestLanguageExParser.g:556:1: (iv_ruleFQN2= ruleFQN2 EOF )
            // InternalFragmentTestLanguageExParser.g:557:2: iv_ruleFQN2= ruleFQN2 EOF
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
    // InternalFragmentTestLanguageExParser.g:564:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:568:6: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // InternalFragmentTestLanguageExParser.g:569:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // InternalFragmentTestLanguageExParser.g:569:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // InternalFragmentTestLanguageExParser.g:569:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguageExParser.g:576:1: (this_Suffix2_1= ruleSuffix2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==FullStop) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFragmentTestLanguageExParser.g:577:5: this_Suffix2_1= ruleSuffix2
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
            	    break loop6;
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
    // InternalFragmentTestLanguageExParser.g:596:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:600:6: ( (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // InternalFragmentTestLanguageExParser.g:601:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // InternalFragmentTestLanguageExParser.g:601:1: (kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // InternalFragmentTestLanguageExParser.g:602:2: kw= FullStop this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffixAccess().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getSuffixAccess().getIDTerminalRuleCall_1()); 
                
            // InternalFragmentTestLanguageExParser.g:614:1: (this_Suffix_2= ruleSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==FullStop) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFragmentTestLanguageExParser.g:615:5: this_Suffix_2= ruleSuffix
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
    // InternalFragmentTestLanguageExParser.g:634:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStop this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:638:6: ( (kw= FullStop this_ID_1= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:639:1: (kw= FullStop this_ID_1= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:639:1: (kw= FullStop this_ID_1= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:640:2: kw= FullStop this_ID_1= RULE_ID
            {
            kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); 

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


    // $ANTLR start "rulePRFNamedFragment"
    // InternalFragmentTestLanguageExParser.g:661:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:664:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFragmentTestLanguageExParser.g:665:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguageExParser.g:665:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:666:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:666:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:667:3: lv_name_0_0= RULE_ID
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
    // InternalFragmentTestLanguageExParser.g:692:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguageExParser.g:695:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFragmentTestLanguageExParser.g:696:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguageExParser.g:696:1: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguageExParser.g:697:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguageExParser.g:697:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguageExParser.g:698:3: otherlv_0= RULE_ID
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001002L});
    }


}