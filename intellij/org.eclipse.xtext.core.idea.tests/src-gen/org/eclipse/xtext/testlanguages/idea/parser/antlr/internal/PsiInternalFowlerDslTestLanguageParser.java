package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalFowlerDslTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'commands'", "'resetting'", "'state'", "'actions'", "'{'", "'}'", "'=>'"
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
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalFowlerDslTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFowlerDslTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFowlerDslTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalFowlerDslTestLanguage.g"; }



    	protected FowlerDslTestLanguageGrammarAccess grammarAccess;

    	protected FowlerDslTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalFowlerDslTestLanguageParser(PsiBuilder builder, TokenStream input, FowlerDslTestLanguageElementTypeProvider elementTypeProvider, FowlerDslTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Statemachine";
    	}




    // $ANTLR start "entryRuleStatemachine"
    // PsiInternalFowlerDslTestLanguage.g:52:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // PsiInternalFowlerDslTestLanguage.g:52:22: ( ruleStatemachine EOF )
            // PsiInternalFowlerDslTestLanguage.g:53:2: ruleStatemachine EOF
            {
             markComposite(elementTypeProvider.getStatemachineElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStatemachine();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // PsiInternalFowlerDslTestLanguage.g:58:1: ruleStatemachine : (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) ;
    public final void ruleStatemachine() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:58:17: ( (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) )
            // PsiInternalFowlerDslTestLanguage.g:59:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            {
            // PsiInternalFowlerDslTestLanguage.g:59:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            // PsiInternalFowlerDslTestLanguage.g:60:3: otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )*
            {

            			markLeaf(elementTypeProvider.getStatemachine_EventsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFowlerDslTestLanguage.g:67:3: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:68:4: (lv_events_1_0= ruleEvent )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:68:4: (lv_events_1_0= ruleEvent )
            	    // PsiInternalFowlerDslTestLanguage.g:69:5: lv_events_1_0= ruleEvent
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_EventsEventParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleEvent();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getStatemachine_EndKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		

            			markLeaf(elementTypeProvider.getStatemachine_CommandsKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalFowlerDslTestLanguage.g:92:3: ( (lv_commands_4_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:93:4: (lv_commands_4_0= ruleCommand )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:93:4: (lv_commands_4_0= ruleCommand )
            	    // PsiInternalFowlerDslTestLanguage.g:94:5: lv_commands_4_0= ruleCommand
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_CommandsCommandParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    ruleCommand();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getStatemachine_EndKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalFowlerDslTestLanguage.g:110:3: ( (lv_states_6_0= ruleState ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:111:4: (lv_states_6_0= ruleState )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:111:4: (lv_states_6_0= ruleState )
            	    // PsiInternalFowlerDslTestLanguage.g:112:5: lv_states_6_0= ruleState
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_StatesStateParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    ruleState();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // PsiInternalFowlerDslTestLanguage.g:125:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // PsiInternalFowlerDslTestLanguage.g:125:15: ( ruleEvent EOF )
            // PsiInternalFowlerDslTestLanguage.g:126:2: ruleEvent EOF
            {
             markComposite(elementTypeProvider.getEventElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEvent();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // PsiInternalFowlerDslTestLanguage.g:131:1: ruleEvent : ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) ;
    public final void ruleEvent() throws RecognitionException {
        Token lv_resetting_0_0=null;
        Token lv_name_1_0=null;
        Token lv_code_2_0=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:131:10: ( ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:132:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:132:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:133:3: ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:133:3: ( (lv_resetting_0_0= 'resetting' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFowlerDslTestLanguage.g:134:4: (lv_resetting_0_0= 'resetting' )
                    {
                    // PsiInternalFowlerDslTestLanguage.g:134:4: (lv_resetting_0_0= 'resetting' )
                    // PsiInternalFowlerDslTestLanguage.g:135:5: lv_resetting_0_0= 'resetting'
                    {

                    					markLeaf(elementTypeProvider.getEvent_ResettingResettingKeyword_0_0ElementType());
                    				
                    lv_resetting_0_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

                    					doneLeaf(lv_resetting_0_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFowlerDslTestLanguage.g:144:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:145:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:145:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:146:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEvent_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:155:3: ( (lv_code_2_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:156:4: (lv_code_2_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:156:4: (lv_code_2_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:157:5: lv_code_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEvent_CodeIDTerminalRuleCall_2_0ElementType());
            				
            lv_code_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_code_2_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // PsiInternalFowlerDslTestLanguage.g:170:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // PsiInternalFowlerDslTestLanguage.g:170:17: ( ruleCommand EOF )
            // PsiInternalFowlerDslTestLanguage.g:171:2: ruleCommand EOF
            {
             markComposite(elementTypeProvider.getCommandElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCommand();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // PsiInternalFowlerDslTestLanguage.g:176:1: ruleCommand : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) ;
    public final void ruleCommand() throws RecognitionException {
        Token lv_name_0_0=null;
        Token lv_code_1_0=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:176:12: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:177:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:177:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:178:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:178:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:179:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:179:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:180:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommand_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:189:3: ( (lv_code_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:190:4: (lv_code_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:190:4: (lv_code_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:191:5: lv_code_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommand_CodeIDTerminalRuleCall_1_0ElementType());
            				
            lv_code_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_code_1_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleState"
    // PsiInternalFowlerDslTestLanguage.g:204:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // PsiInternalFowlerDslTestLanguage.g:204:15: ( ruleState EOF )
            // PsiInternalFowlerDslTestLanguage.g:205:2: ruleState EOF
            {
             markComposite(elementTypeProvider.getStateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleState();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // PsiInternalFowlerDslTestLanguage.g:210:1: ruleState : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) ;
    public final void ruleState() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:210:10: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) )
            // PsiInternalFowlerDslTestLanguage.g:211:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            {
            // PsiInternalFowlerDslTestLanguage.g:211:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            // PsiInternalFowlerDslTestLanguage.g:212:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end'
            {

            			markLeaf(elementTypeProvider.getState_StateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFowlerDslTestLanguage.g:219:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:220:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:220:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:221:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getState_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:230:3: (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFowlerDslTestLanguage.g:231:4: otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}'
                    {

                    				markLeaf(elementTypeProvider.getState_ActionsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    				doneLeaf(otherlv_2);
                    			

                    				markLeaf(elementTypeProvider.getState_LeftCurlyBracketKeyword_2_1ElementType());
                    			
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalFowlerDslTestLanguage.g:245:4: ( (otherlv_4= RULE_ID ) )+
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
                    	    // PsiInternalFowlerDslTestLanguage.g:246:5: (otherlv_4= RULE_ID )
                    	    {
                    	    // PsiInternalFowlerDslTestLanguage.g:246:5: (otherlv_4= RULE_ID )
                    	    // PsiInternalFowlerDslTestLanguage.g:247:6: otherlv_4= RULE_ID
                    	    {

                    	    						markLeaf(elementTypeProvider.getState_ActionsCommandCrossReference_2_2_0ElementType());
                    	    					
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

                    	    						doneLeaf(otherlv_4);
                    	    					

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


                    				markLeaf(elementTypeProvider.getState_RightCurlyBracketKeyword_2_3ElementType());
                    			
                    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;

            }

            // PsiInternalFowlerDslTestLanguage.g:264:3: ( (lv_transitions_6_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:265:4: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:265:4: (lv_transitions_6_0= ruleTransition )
            	    // PsiInternalFowlerDslTestLanguage.g:266:5: lv_transitions_6_0= ruleTransition
            	    {

            	    					markComposite(elementTypeProvider.getState_TransitionsTransitionParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    ruleTransition();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getState_EndKeyword_4ElementType());
            		
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_7);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // PsiInternalFowlerDslTestLanguage.g:286:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // PsiInternalFowlerDslTestLanguage.g:286:20: ( ruleTransition EOF )
            // PsiInternalFowlerDslTestLanguage.g:287:2: ruleTransition EOF
            {
             markComposite(elementTypeProvider.getTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTransition();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // PsiInternalFowlerDslTestLanguage.g:292:1: ruleTransition : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:292:15: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:293:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:293:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:294:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:294:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:295:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:295:4: (otherlv_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:296:5: otherlv_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransition_EventEventCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(otherlv_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransition_EqualsSignGreaterThanSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFowlerDslTestLanguage.g:312:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:313:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:313:4: (otherlv_2= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:314:5: otherlv_2= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransition_StateStateCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_2);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
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