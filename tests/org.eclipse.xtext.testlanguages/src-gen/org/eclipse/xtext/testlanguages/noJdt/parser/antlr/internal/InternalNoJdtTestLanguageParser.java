package org.eclipse.xtext.testlanguages.noJdt.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.noJdt.services.NoJdtTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNoJdtTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'('", "'from'", "')'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalNoJdtTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNoJdtTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNoJdtTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalNoJdtTestLanguage.g"; }



     	private NoJdtTestLanguageGrammarAccess grammarAccess;
     	
        public InternalNoJdtTestLanguageParser(TokenStream input, NoJdtTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected NoJdtTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalNoJdtTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalNoJdtTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalNoJdtTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalNoJdtTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_greetings_0_0= ruleGreeting ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_greetings_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoJdtTestLanguage.g:79:28: ( ( (lv_greetings_0_0= ruleGreeting ) ) )
            // InternalNoJdtTestLanguage.g:80:1: ( (lv_greetings_0_0= ruleGreeting ) )
            {
            // InternalNoJdtTestLanguage.g:80:1: ( (lv_greetings_0_0= ruleGreeting ) )
            // InternalNoJdtTestLanguage.g:81:1: (lv_greetings_0_0= ruleGreeting )
            {
            // InternalNoJdtTestLanguage.g:81:1: (lv_greetings_0_0= ruleGreeting )
            // InternalNoJdtTestLanguage.g:82:3: lv_greetings_0_0= ruleGreeting
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_greetings_0_0=ruleGreeting();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"greetings",
                    		lv_greetings_0_0, 
                    		"org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguage.Greeting");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGreeting"
    // InternalNoJdtTestLanguage.g:106:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // InternalNoJdtTestLanguage.g:107:2: (iv_ruleGreeting= ruleGreeting EOF )
            // InternalNoJdtTestLanguage.g:108:2: iv_ruleGreeting= ruleGreeting EOF
            {
             newCompositeNode(grammarAccess.getGreetingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // InternalNoJdtTestLanguage.g:115:1: ruleGreeting returns [EObject current=null] : (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // InternalNoJdtTestLanguage.g:118:28: ( (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' ) )
            // InternalNoJdtTestLanguage.g:119:1: (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' )
            {
            // InternalNoJdtTestLanguage.g:119:1: (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' )
            // InternalNoJdtTestLanguage.g:119:3: otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getGreetingAccess().getHelloKeyword_0());
                
            // InternalNoJdtTestLanguage.g:123:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalNoJdtTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            {
            // InternalNoJdtTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            // InternalNoJdtTestLanguage.g:125:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGreetingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalNoJdtTestLanguage.g:141:2: (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNoJdtTestLanguage.g:141:4: otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getGreetingAccess().getLeftParenthesisKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,13,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getGreetingAccess().getFromKeyword_2_1());
                        
                    // InternalNoJdtTestLanguage.g:149:1: ( (otherlv_4= RULE_ID ) )
                    // InternalNoJdtTestLanguage.g:150:1: (otherlv_4= RULE_ID )
                    {
                    // InternalNoJdtTestLanguage.g:150:1: (otherlv_4= RULE_ID )
                    // InternalNoJdtTestLanguage.g:151:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGreetingRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_6); 

                    		newLeafNode(otherlv_4, grammarAccess.getGreetingAccess().getOtherGreetingCrossReference_2_2_0()); 
                    	

                    }


                    }

                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                        	newLeafNode(otherlv_5, grammarAccess.getGreetingAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3());
                

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
    // $ANTLR end "ruleGreeting"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});

}