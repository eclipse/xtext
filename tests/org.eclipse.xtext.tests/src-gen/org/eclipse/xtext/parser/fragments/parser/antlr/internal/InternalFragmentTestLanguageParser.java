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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#8'", "':'", "'-'", "'<-'", "'.'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
    // InternalFragmentTestLanguage.g:76:1: ruleParserRuleFragments returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) ;
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
            // InternalFragmentTestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            // InternalFragmentTestLanguage.g:80:2: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            {
            // InternalFragmentTestLanguage.g:80:2: ()
            // InternalFragmentTestLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:86:2: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            int alt1=5;
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
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // InternalFragmentTestLanguage.g:195:6: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // InternalFragmentTestLanguage.g:195:8: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_11, grammarAccess.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_4_0());
                        
                    // InternalFragmentTestLanguage.g:199:1: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // InternalFragmentTestLanguage.g:200:1: (lv_element_12_0= rulePRFNamedWithFQN )
                    // InternalFragmentTestLanguage.g:201:3: lv_element_12_0= rulePRFNamedWithFQN
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
    // InternalFragmentTestLanguage.g:225:1: entryRulePRFNamed returns [EObject current=null] : iv_rulePRFNamed= rulePRFNamed EOF ;
    public final EObject entryRulePRFNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamed = null;


        try {
            // InternalFragmentTestLanguage.g:226:2: (iv_rulePRFNamed= rulePRFNamed EOF )
            // InternalFragmentTestLanguage.g:227:2: iv_rulePRFNamed= rulePRFNamed EOF
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
    // InternalFragmentTestLanguage.g:234:1: rulePRFNamed returns [EObject current=null] : (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) ;
    public final EObject rulePRFNamed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_PRFNamedFragment_0 = null;

        EObject this_PRFNamedRef_4 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:237:28: ( (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? ) )
            // InternalFragmentTestLanguage.g:238:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            {
            // InternalFragmentTestLanguage.g:238:1: (this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )? )
            // InternalFragmentTestLanguage.g:239:5: this_PRFNamedFragment_0= rulePRFNamedFragment[$current] ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
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
                
            // InternalFragmentTestLanguage.g:250:1: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // InternalFragmentTestLanguage.g:250:2: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFragmentTestLanguage.g:250:2: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // InternalFragmentTestLanguage.g:250:4: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedAccess().getColonKeyword_1_0_0());
                        
                    // InternalFragmentTestLanguage.g:254:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:255:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:255:1: (otherlv_2= RULE_ID )
                    // InternalFragmentTestLanguage.g:256:3: otherlv_2= RULE_ID
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
                    // InternalFragmentTestLanguage.g:268:6: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    {
                    // InternalFragmentTestLanguage.g:268:6: (otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current] )
                    // InternalFragmentTestLanguage.g:268:8: otherlv_3= '-' this_PRFNamedRef_4= rulePRFNamedRef[$current]
                    {
                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_3); 

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
    // InternalFragmentTestLanguage.g:292:1: entryRulePRFNamedRefFirst returns [EObject current=null] : iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF ;
    public final EObject entryRulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedRefFirst = null;


        try {
            // InternalFragmentTestLanguage.g:293:2: (iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF )
            // InternalFragmentTestLanguage.g:294:2: iv_rulePRFNamedRefFirst= rulePRFNamedRefFirst EOF
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
    // InternalFragmentTestLanguage.g:301:1: rulePRFNamedRefFirst returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) ;
    public final EObject rulePRFNamedRefFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PRFNamedFragment_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:304:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] ) )
            // InternalFragmentTestLanguage.g:305:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            {
            // InternalFragmentTestLanguage.g:305:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current] )
            // InternalFragmentTestLanguage.g:305:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' this_PRFNamedFragment_2= rulePRFNamedFragment[$current]
            {
            // InternalFragmentTestLanguage.g:305:2: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:306:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:306:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:307:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPRFNamedRefFirstRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		newLeafNode(otherlv_0, grammarAccess.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_3); 

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
    // InternalFragmentTestLanguage.g:342:1: entryRulePRFNamedWithAction returns [EObject current=null] : iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF ;
    public final EObject entryRulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithAction = null;


        try {
            // InternalFragmentTestLanguage.g:343:2: (iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF )
            // InternalFragmentTestLanguage.g:344:2: iv_rulePRFNamedWithAction= rulePRFNamedWithAction EOF
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
    // InternalFragmentTestLanguage.g:351:1: rulePRFNamedWithAction returns [EObject current=null] : (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePRFNamedWithAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_PRFNamed_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:354:28: ( (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalFragmentTestLanguage.g:355:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalFragmentTestLanguage.g:355:1: (this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // InternalFragmentTestLanguage.g:356:5: this_PRFNamed_0= rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_PRFNamed_0=rulePRFNamed();

            state._fsp--;

             
                    current = this_PRFNamed_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFragmentTestLanguage.g:364:1: ()
            // InternalFragmentTestLanguage.g:365:5: 
            {

                    current = forceCreateModelElementAndSet(
                        grammarAccess.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1(),
                        current);
                

            }

            // InternalFragmentTestLanguage.g:370:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:371:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:371:1: (lv_name_2_0= RULE_ID )
            // InternalFragmentTestLanguage.g:372:3: lv_name_2_0= RULE_ID
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

            // InternalFragmentTestLanguage.g:388:2: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFragmentTestLanguage.g:388:3: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalFragmentTestLanguage.g:388:3: ( (otherlv_3= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:389:1: (otherlv_3= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:389:1: (otherlv_3= RULE_ID )
                    // InternalFragmentTestLanguage.g:390:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPRFNamedWithActionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    		newLeafNode(otherlv_3, grammarAccess.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0()); 
                    	

                    }


                    }

                    // InternalFragmentTestLanguage.g:401:2: ( (otherlv_4= RULE_ID ) )
                    // InternalFragmentTestLanguage.g:402:1: (otherlv_4= RULE_ID )
                    {
                    // InternalFragmentTestLanguage.g:402:1: (otherlv_4= RULE_ID )
                    // InternalFragmentTestLanguage.g:403:3: otherlv_4= RULE_ID
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
    // InternalFragmentTestLanguage.g:422:1: entryRulePRFNamedWithFQN returns [EObject current=null] : iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF ;
    public final EObject entryRulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRFNamedWithFQN = null;


        try {
            // InternalFragmentTestLanguage.g:423:2: (iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF )
            // InternalFragmentTestLanguage.g:424:2: iv_rulePRFNamedWithFQN= rulePRFNamedWithFQN EOF
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
    // InternalFragmentTestLanguage.g:431:1: rulePRFNamedWithFQN returns [EObject current=null] : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final EObject rulePRFNamedWithFQN() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:434:28: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // InternalFragmentTestLanguage.g:435:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // InternalFragmentTestLanguage.g:435:1: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // InternalFragmentTestLanguage.g:435:2: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // InternalFragmentTestLanguage.g:435:2: ( (lv_name_0_0= ruleFQN ) )
            // InternalFragmentTestLanguage.g:436:1: (lv_name_0_0= ruleFQN )
            {
            // InternalFragmentTestLanguage.g:436:1: (lv_name_0_0= ruleFQN )
            // InternalFragmentTestLanguage.g:437:3: lv_name_0_0= ruleFQN
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

            // InternalFragmentTestLanguage.g:453:2: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFragmentTestLanguage.g:453:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {
                    otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFragmentTestLanguage.g:457:1: ( ( ruleFQN2 ) )
                    // InternalFragmentTestLanguage.g:458:1: ( ruleFQN2 )
                    {
                    // InternalFragmentTestLanguage.g:458:1: ( ruleFQN2 )
                    // InternalFragmentTestLanguage.g:459:3: ruleFQN2
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
    // InternalFragmentTestLanguage.g:480:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFragmentTestLanguage.g:481:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalFragmentTestLanguage.g:482:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalFragmentTestLanguage.g:489:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:492:28: ( (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:493:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:493:1: (this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:493:6: this_ID_0= RULE_ID (this_Suffix_1= ruleSuffix )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguage.g:500:1: (this_Suffix_1= ruleSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFragmentTestLanguage.g:501:5: this_Suffix_1= ruleSuffix
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
    // InternalFragmentTestLanguage.g:519:1: entryRuleFQN2 returns [String current=null] : iv_ruleFQN2= ruleFQN2 EOF ;
    public final String entryRuleFQN2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN2 = null;


        try {
            // InternalFragmentTestLanguage.g:520:2: (iv_ruleFQN2= ruleFQN2 EOF )
            // InternalFragmentTestLanguage.g:521:2: iv_ruleFQN2= ruleFQN2 EOF
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
    // InternalFragmentTestLanguage.g:528:1: ruleFQN2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Suffix2_1 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:531:28: ( (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* ) )
            // InternalFragmentTestLanguage.g:532:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            {
            // InternalFragmentTestLanguage.g:532:1: (this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )* )
            // InternalFragmentTestLanguage.g:532:6: this_ID_0= RULE_ID (this_Suffix2_1= ruleSuffix2 )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQN2Access().getIDTerminalRuleCall_0()); 
                
            // InternalFragmentTestLanguage.g:539:1: (this_Suffix2_1= ruleSuffix2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFragmentTestLanguage.g:540:5: this_Suffix2_1= ruleSuffix2
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
    // InternalFragmentTestLanguage.g:559:1: ruleSuffix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) ;
    public final AntlrDatatypeRuleToken ruleSuffix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        AntlrDatatypeRuleToken this_Suffix_2 = null;


         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:562:28: ( (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? ) )
            // InternalFragmentTestLanguage.g:563:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            {
            // InternalFragmentTestLanguage.g:563:1: (kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )? )
            // InternalFragmentTestLanguage.g:564:2: kw= '.' this_ID_1= RULE_ID (this_Suffix_2= ruleSuffix )?
            {
            kw=(Token)match(input,20,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSuffixAccess().getFullStopKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getSuffixAccess().getIDTerminalRuleCall_1()); 
                
            // InternalFragmentTestLanguage.g:576:1: (this_Suffix_2= ruleSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFragmentTestLanguage.g:577:5: this_Suffix_2= ruleSuffix
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
    // InternalFragmentTestLanguage.g:596:1: ruleSuffix2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSuffix2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:599:28: ( (kw= '.' this_ID_1= RULE_ID ) )
            // InternalFragmentTestLanguage.g:600:1: (kw= '.' this_ID_1= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:600:1: (kw= '.' this_ID_1= RULE_ID )
            // InternalFragmentTestLanguage.g:601:2: kw= '.' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,20,FollowSets000.FOLLOW_3); 

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
    // InternalFragmentTestLanguage.g:622:1: rulePRFNamedFragment[EObject in_current] returns [EObject current=in_current] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:625:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:626:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:626:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:627:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:627:1: (lv_name_0_0= RULE_ID )
            // InternalFragmentTestLanguage.g:628:3: lv_name_0_0= RULE_ID
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
    // InternalFragmentTestLanguage.g:653:1: rulePRFNamedRef[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePRFNamedRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalFragmentTestLanguage.g:656:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFragmentTestLanguage.g:657:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFragmentTestLanguage.g:657:1: ( (otherlv_0= RULE_ID ) )
            // InternalFragmentTestLanguage.g:658:1: (otherlv_0= RULE_ID )
            {
            // InternalFragmentTestLanguage.g:658:1: (otherlv_0= RULE_ID )
            // InternalFragmentTestLanguage.g:659:3: otherlv_0= RULE_ID
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
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100002L});
    }


}