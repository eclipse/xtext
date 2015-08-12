package org.eclipse.xtext.linking.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.services.Bug362902GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug362902Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'favourite'", "'Hello'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug362902Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug362902Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug362902Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g"; }



     	private Bug362902GrammarAccess grammarAccess;
     	
        public InternalBug362902Parser(TokenStream input, Bug362902GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug362902GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_greetings_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:79:28: ( ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:80:1: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:80:1: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:80:2: ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:80:2: ( (lv_greetings_0_0= ruleGreeting ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:81:1: (lv_greetings_0_0= ruleGreeting )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:81:1: (lv_greetings_0_0= ruleGreeting )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:82:3: lv_greetings_0_0= ruleGreeting
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleGreeting_in_ruleModel131);
            	    lv_greetings_0_0=ruleGreeting();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"greetings",
            	            		lv_greetings_0_0, 
            	            		"org.eclipse.xtext.linking.Bug362902.Greeting");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel144); 

                	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getFavouriteKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:102:1: ( ( ruleMyId ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:103:1: ( ruleMyId )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:103:1: ( ruleMyId )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:104:3: ruleMyId
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModelRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModelAccess().getFavouriteGreetingCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_ruleModel167);
            ruleMyId();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:125:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:126:2: (iv_ruleGreeting= ruleGreeting EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:127:2: iv_ruleGreeting= ruleGreeting EOF
            {
             newCompositeNode(grammarAccess.getGreetingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGreeting_in_entryRuleGreeting203);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGreeting213); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:134:1: ruleGreeting returns [EObject current=null] : (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:137:28: ( (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:138:1: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:138:1: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:138:3: otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGreeting250); 

                	newLeafNode(otherlv_0, grammarAccess.getGreetingAccess().getHelloKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:142:1: ( (lv_name_1_0= ruleMyId ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:143:1: (lv_name_1_0= ruleMyId )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:143:1: (lv_name_1_0= ruleMyId )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:144:3: lv_name_1_0= ruleMyId
            {
             
            	        newCompositeNode(grammarAccess.getGreetingAccess().getNameMyIdParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_ruleGreeting271);
            lv_name_1_0=ruleMyId();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGreetingRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.linking.Bug362902.MyId");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGreeting283); 

                	newLeafNode(otherlv_2, grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2());
                

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


    // $ANTLR start "entryRuleMyId"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:172:1: entryRuleMyId returns [String current=null] : iv_ruleMyId= ruleMyId EOF ;
    public final String entryRuleMyId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyId = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:173:2: (iv_ruleMyId= ruleMyId EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:174:2: iv_ruleMyId= ruleMyId EOF
            {
             newCompositeNode(grammarAccess.getMyIdRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_entryRuleMyId320);
            iv_ruleMyId=ruleMyId();

            state._fsp--;

             current =iv_ruleMyId.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyId331); 

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
    // $ANTLR end "entryRuleMyId"


    // $ANTLR start "ruleMyId"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:181:1: ruleMyId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleMyId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:184:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug362902.g:185:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMyId370); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getMyIdAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleMyId"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGreeting_in_ruleModel131 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_11_in_ruleModel144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMyId_in_ruleModel167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting203 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGreeting213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleGreeting250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMyId_in_ruleGreeting271 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGreeting283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyId_in_entryRuleMyId320 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyId331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMyId370 = new BitSet(new long[]{0x0000000000000002L});
    }


}