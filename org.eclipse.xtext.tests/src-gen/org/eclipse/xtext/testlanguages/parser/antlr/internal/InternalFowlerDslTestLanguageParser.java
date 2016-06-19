package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFowlerDslTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'commands'", "'resetting'", "'state'", "'actions'", "'{'", "'}'", "'=>'"
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
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalFowlerDslTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFowlerDslTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFowlerDslTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFowlerDslTestLanguage.g"; }



     	private FowlerDslTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFowlerDslTestLanguageParser(TokenStream input, FowlerDslTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";	
       	}
       	
       	@Override
       	protected FowlerDslTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStatemachine"
    // InternalFowlerDslTestLanguage.g:67:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // InternalFowlerDslTestLanguage.g:68:2: (iv_ruleStatemachine= ruleStatemachine EOF )
            // InternalFowlerDslTestLanguage.g:69:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // InternalFowlerDslTestLanguage.g:76:1: ruleStatemachine returns [EObject current=null] : (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_events_1_0 = null;

        EObject lv_commands_4_0 = null;

        EObject lv_states_6_0 = null;


         enterRule(); 
            
        try {
            // InternalFowlerDslTestLanguage.g:79:28: ( (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) )
            // InternalFowlerDslTestLanguage.g:80:1: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            {
            // InternalFowlerDslTestLanguage.g:80:1: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            // InternalFowlerDslTestLanguage.g:80:3: otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getStatemachineAccess().getEventsKeyword_0());
                
            // InternalFowlerDslTestLanguage.g:84:1: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFowlerDslTestLanguage.g:85:1: (lv_events_1_0= ruleEvent )
            	    {
            	    // InternalFowlerDslTestLanguage.g:85:1: (lv_events_1_0= ruleEvent )
            	    // InternalFowlerDslTestLanguage.g:86:3: lv_events_1_0= ruleEvent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_events_1_0=ruleEvent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"events",
            	            		lv_events_1_0, 
            	            		"org.eclipse.xtext.testlanguages.FowlerDslTestLanguage.Event");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getStatemachineAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_3, grammarAccess.getStatemachineAccess().getCommandsKeyword_3());
                
            // InternalFowlerDslTestLanguage.g:110:1: ( (lv_commands_4_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFowlerDslTestLanguage.g:111:1: (lv_commands_4_0= ruleCommand )
            	    {
            	    // InternalFowlerDslTestLanguage.g:111:1: (lv_commands_4_0= ruleCommand )
            	    // InternalFowlerDslTestLanguage.g:112:3: lv_commands_4_0= ruleCommand
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_commands_4_0=ruleCommand();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_4_0, 
            	            		"org.eclipse.xtext.testlanguages.FowlerDslTestLanguage.Command");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_5, grammarAccess.getStatemachineAccess().getEndKeyword_5());
                
            // InternalFowlerDslTestLanguage.g:132:1: ( (lv_states_6_0= ruleState ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFowlerDslTestLanguage.g:133:1: (lv_states_6_0= ruleState )
            	    {
            	    // InternalFowlerDslTestLanguage.g:133:1: (lv_states_6_0= ruleState )
            	    // InternalFowlerDslTestLanguage.g:134:3: lv_states_6_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_states_6_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_6_0, 
            	            		"org.eclipse.xtext.testlanguages.FowlerDslTestLanguage.State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // InternalFowlerDslTestLanguage.g:158:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalFowlerDslTestLanguage.g:159:2: (iv_ruleEvent= ruleEvent EOF )
            // InternalFowlerDslTestLanguage.g:160:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalFowlerDslTestLanguage.g:167:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting_0_0=null;
        Token lv_name_1_0=null;
        Token lv_code_2_0=null;

         enterRule(); 
            
        try {
            // InternalFowlerDslTestLanguage.g:170:28: ( ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) )
            // InternalFowlerDslTestLanguage.g:171:1: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            {
            // InternalFowlerDslTestLanguage.g:171:1: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            // InternalFowlerDslTestLanguage.g:171:2: ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) )
            {
            // InternalFowlerDslTestLanguage.g:171:2: ( (lv_resetting_0_0= 'resetting' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFowlerDslTestLanguage.g:172:1: (lv_resetting_0_0= 'resetting' )
                    {
                    // InternalFowlerDslTestLanguage.g:172:1: (lv_resetting_0_0= 'resetting' )
                    // InternalFowlerDslTestLanguage.g:173:3: lv_resetting_0_0= 'resetting'
                    {
                    lv_resetting_0_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

                            newLeafNode(lv_resetting_0_0, grammarAccess.getEventAccess().getResettingResettingKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEventRule());
                    	        }
                           		setWithLastConsumed(current, "resetting", true, "resetting");
                    	    

                    }


                    }
                    break;

            }

            // InternalFowlerDslTestLanguage.g:186:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:187:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:187:1: (lv_name_1_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:188:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalFowlerDslTestLanguage.g:204:2: ( (lv_code_2_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:205:1: (lv_code_2_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:205:1: (lv_code_2_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:206:3: lv_code_2_0= RULE_ID
            {
            lv_code_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_code_2_0, grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"code",
                    		lv_code_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // InternalFowlerDslTestLanguage.g:230:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalFowlerDslTestLanguage.g:231:2: (iv_ruleCommand= ruleCommand EOF )
            // InternalFowlerDslTestLanguage.g:232:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalFowlerDslTestLanguage.g:239:1: ruleCommand returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_code_1_0=null;

         enterRule(); 
            
        try {
            // InternalFowlerDslTestLanguage.g:242:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) )
            // InternalFowlerDslTestLanguage.g:243:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            {
            // InternalFowlerDslTestLanguage.g:243:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            // InternalFowlerDslTestLanguage.g:243:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) )
            {
            // InternalFowlerDslTestLanguage.g:243:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:244:1: (lv_name_0_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:244:1: (lv_name_0_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:245:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalFowlerDslTestLanguage.g:261:2: ( (lv_code_1_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:262:1: (lv_code_1_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:262:1: (lv_code_1_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:263:3: lv_code_1_0= RULE_ID
            {
            lv_code_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_code_1_0, grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"code",
                    		lv_code_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleState"
    // InternalFowlerDslTestLanguage.g:287:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalFowlerDslTestLanguage.g:288:2: (iv_ruleState= ruleState EOF )
            // InternalFowlerDslTestLanguage.g:289:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalFowlerDslTestLanguage.g:296:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_transitions_6_0 = null;


         enterRule(); 
            
        try {
            // InternalFowlerDslTestLanguage.g:299:28: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) )
            // InternalFowlerDslTestLanguage.g:300:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            {
            // InternalFowlerDslTestLanguage.g:300:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            // InternalFowlerDslTestLanguage.g:300:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
                
            // InternalFowlerDslTestLanguage.g:304:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:305:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:305:1: (lv_name_1_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:306:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalFowlerDslTestLanguage.g:322:2: (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFowlerDslTestLanguage.g:322:4: otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}'
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_2, grammarAccess.getStateAccess().getActionsKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1());
                        
                    // InternalFowlerDslTestLanguage.g:330:1: ( (otherlv_4= RULE_ID ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalFowlerDslTestLanguage.g:331:1: (otherlv_4= RULE_ID )
                    	    {
                    	    // InternalFowlerDslTestLanguage.g:331:1: (otherlv_4= RULE_ID )
                    	    // InternalFowlerDslTestLanguage.g:332:3: otherlv_4= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStateRule());
                    	    	        }
                    	            
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

                    	    		newLeafNode(otherlv_4, grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3());
                        

                    }
                    break;

            }

            // InternalFowlerDslTestLanguage.g:347:3: ( (lv_transitions_6_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFowlerDslTestLanguage.g:348:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalFowlerDslTestLanguage.g:348:1: (lv_transitions_6_0= ruleTransition )
            	    // InternalFowlerDslTestLanguage.g:349:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_transitions_6_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_6_0, 
            	            		"org.eclipse.xtext.testlanguages.FowlerDslTestLanguage.Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getStateAccess().getEndKeyword_4());
                

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // InternalFowlerDslTestLanguage.g:377:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalFowlerDslTestLanguage.g:378:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalFowlerDslTestLanguage.g:379:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalFowlerDslTestLanguage.g:386:1: ruleTransition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalFowlerDslTestLanguage.g:389:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalFowlerDslTestLanguage.g:390:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalFowlerDslTestLanguage.g:390:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // InternalFowlerDslTestLanguage.g:390:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // InternalFowlerDslTestLanguage.g:390:2: ( (otherlv_0= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:391:1: (otherlv_0= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:391:1: (otherlv_0= RULE_ID )
            // InternalFowlerDslTestLanguage.g:392:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            		newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalFowlerDslTestLanguage.g:407:1: ( (otherlv_2= RULE_ID ) )
            // InternalFowlerDslTestLanguage.g:408:1: (otherlv_2= RULE_ID )
            {
            // InternalFowlerDslTestLanguage.g:408:1: (otherlv_2= RULE_ID )
            // InternalFowlerDslTestLanguage.g:409:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleTransition"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000005010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000011010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    }


}