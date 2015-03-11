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
    public String getGrammarFileName() { return "../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g"; }



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
    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_greetings_0_0= ruleGreeting ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_greetings_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:79:28: ( ( (lv_greetings_0_0= ruleGreeting ) ) )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:80:1: ( (lv_greetings_0_0= ruleGreeting ) )
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:80:1: ( (lv_greetings_0_0= ruleGreeting ) )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:81:1: (lv_greetings_0_0= ruleGreeting )
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:81:1: (lv_greetings_0_0= ruleGreeting )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:82:3: lv_greetings_0_0= ruleGreeting
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleGreeting_in_ruleModel130);
            lv_greetings_0_0=ruleGreeting();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"greetings",
                    		lv_greetings_0_0, 
                    		"Greeting");
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
    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:106:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:107:2: (iv_ruleGreeting= ruleGreeting EOF )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:108:2: iv_ruleGreeting= ruleGreeting EOF
            {
             newCompositeNode(grammarAccess.getGreetingRule()); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting165);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting175); 

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
    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:115:1: ruleGreeting returns [EObject current=null] : (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' ) ;
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
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:118:28: ( (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' ) )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:119:1: (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' )
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:119:1: (otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!' )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:119:3: otherlv_0= 'Hello' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )? otherlv_6= '!'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGreeting212); 

                	newLeafNode(otherlv_0, grammarAccess.getGreetingAccess().getHelloKeyword_0());
                
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:123:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:125:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting229); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGreetingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:141:2: (otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:141:4: otherlv_2= '(' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleGreeting247); 

                        	newLeafNode(otherlv_2, grammarAccess.getGreetingAccess().getLeftParenthesisKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleGreeting259); 

                        	newLeafNode(otherlv_3, grammarAccess.getGreetingAccess().getFromKeyword_2_1());
                        
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:149:1: ( (otherlv_4= RULE_ID ) )
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:150:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:150:1: (otherlv_4= RULE_ID )
                    // ../org.eclipse.xtext.testlanguages/src-gen/org/eclipse/xtext/testlanguages/noJdt/parser/antlr/internal/InternalNoJdtTestLanguage.g:151:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGreetingRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting279); 

                    		newLeafNode(otherlv_4, grammarAccess.getGreetingAccess().getOtherGreetingCrossReference_2_2_0()); 
                    	

                    }


                    }

                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleGreeting291); 

                        	newLeafNode(otherlv_5, grammarAccess.getGreetingAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleGreeting305); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGreeting212 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting229 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleGreeting247 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGreeting259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting279 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGreeting291 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGreeting305 = new BitSet(new long[]{0x0000000000000002L});

}