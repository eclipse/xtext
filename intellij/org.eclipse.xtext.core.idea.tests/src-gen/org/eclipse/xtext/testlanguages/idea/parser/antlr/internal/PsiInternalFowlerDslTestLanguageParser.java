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
    // PsiInternalFowlerDslTestLanguage.g:52:1: entryRuleStatemachine returns [Boolean current=false] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final Boolean entryRuleStatemachine() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStatemachine = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:52:54: (iv_ruleStatemachine= ruleStatemachine EOF )
            // PsiInternalFowlerDslTestLanguage.g:53:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             markComposite(elementTypeProvider.getStatemachineElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // PsiInternalFowlerDslTestLanguage.g:59:1: ruleStatemachine returns [Boolean current=false] : (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) ;
    public final Boolean ruleStatemachine() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_events_1_0 = null;

        Boolean lv_commands_4_0 = null;

        Boolean lv_states_6_0 = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:60:1: ( (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) )
            // PsiInternalFowlerDslTestLanguage.g:61:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            {
            // PsiInternalFowlerDslTestLanguage.g:61:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            // PsiInternalFowlerDslTestLanguage.g:62:3: otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )*
            {

            			markLeaf(elementTypeProvider.getStatemachine_EventsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFowlerDslTestLanguage.g:69:3: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:70:4: (lv_events_1_0= ruleEvent )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:70:4: (lv_events_1_0= ruleEvent )
            	    // PsiInternalFowlerDslTestLanguage.g:71:5: lv_events_1_0= ruleEvent
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_EventsEventParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_events_1_0=ruleEvent();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
            		
            // PsiInternalFowlerDslTestLanguage.g:98:3: ( (lv_commands_4_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:99:4: (lv_commands_4_0= ruleCommand )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:99:4: (lv_commands_4_0= ruleCommand )
            	    // PsiInternalFowlerDslTestLanguage.g:100:5: lv_commands_4_0= ruleCommand
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_CommandsCommandParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_commands_4_0=ruleCommand();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
            		
            // PsiInternalFowlerDslTestLanguage.g:120:3: ( (lv_states_6_0= ruleState ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:121:4: (lv_states_6_0= ruleState )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:121:4: (lv_states_6_0= ruleState )
            	    // PsiInternalFowlerDslTestLanguage.g:122:5: lv_states_6_0= ruleState
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_StatesStateParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_states_6_0=ruleState();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // PsiInternalFowlerDslTestLanguage.g:139:1: entryRuleEvent returns [Boolean current=false] : iv_ruleEvent= ruleEvent EOF ;
    public final Boolean entryRuleEvent() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEvent = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:139:47: (iv_ruleEvent= ruleEvent EOF )
            // PsiInternalFowlerDslTestLanguage.g:140:2: iv_ruleEvent= ruleEvent EOF
            {
             markComposite(elementTypeProvider.getEventElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // PsiInternalFowlerDslTestLanguage.g:146:1: ruleEvent returns [Boolean current=false] : ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleEvent() throws RecognitionException {
        Boolean current = false;

        Token lv_resetting_0_0=null;
        Token lv_name_1_0=null;
        Token lv_code_2_0=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:147:1: ( ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:148:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:148:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:149:3: ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:149:3: ( (lv_resetting_0_0= 'resetting' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFowlerDslTestLanguage.g:150:4: (lv_resetting_0_0= 'resetting' )
                    {
                    // PsiInternalFowlerDslTestLanguage.g:150:4: (lv_resetting_0_0= 'resetting' )
                    // PsiInternalFowlerDslTestLanguage.g:151:5: lv_resetting_0_0= 'resetting'
                    {

                    					markLeaf(elementTypeProvider.getEvent_ResettingResettingKeyword_0_0ElementType());
                    				
                    lv_resetting_0_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

                    					doneLeaf(lv_resetting_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalFowlerDslTestLanguage.g:166:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:167:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:167:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:168:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEvent_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:183:3: ( (lv_code_2_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:184:4: (lv_code_2_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:184:4: (lv_code_2_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:185:5: lv_code_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEvent_CodeIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // PsiInternalFowlerDslTestLanguage.g:204:1: entryRuleCommand returns [Boolean current=false] : iv_ruleCommand= ruleCommand EOF ;
    public final Boolean entryRuleCommand() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCommand = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:204:49: (iv_ruleCommand= ruleCommand EOF )
            // PsiInternalFowlerDslTestLanguage.g:205:2: iv_ruleCommand= ruleCommand EOF
            {
             markComposite(elementTypeProvider.getCommandElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // PsiInternalFowlerDslTestLanguage.g:211:1: ruleCommand returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleCommand() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token lv_code_1_0=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:212:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:213:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:213:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:214:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:214:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:215:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:215:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:216:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommand_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:231:3: ( (lv_code_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:232:4: (lv_code_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:232:4: (lv_code_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:233:5: lv_code_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommand_CodeIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleState"
    // PsiInternalFowlerDslTestLanguage.g:252:1: entryRuleState returns [Boolean current=false] : iv_ruleState= ruleState EOF ;
    public final Boolean entryRuleState() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleState = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:252:47: (iv_ruleState= ruleState EOF )
            // PsiInternalFowlerDslTestLanguage.g:253:2: iv_ruleState= ruleState EOF
            {
             markComposite(elementTypeProvider.getStateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // PsiInternalFowlerDslTestLanguage.g:259:1: ruleState returns [Boolean current=false] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) ;
    public final Boolean ruleState() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Boolean lv_transitions_6_0 = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:260:1: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) )
            // PsiInternalFowlerDslTestLanguage.g:261:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            {
            // PsiInternalFowlerDslTestLanguage.g:261:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            // PsiInternalFowlerDslTestLanguage.g:262:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end'
            {

            			markLeaf(elementTypeProvider.getState_StateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFowlerDslTestLanguage.g:269:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:270:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:270:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:271:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getState_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalFowlerDslTestLanguage.g:286:3: (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalFowlerDslTestLanguage.g:287:4: otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}'
                    {

                    				markLeaf(elementTypeProvider.getState_ActionsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    				doneLeaf(otherlv_2);
                    			

                    				markLeaf(elementTypeProvider.getState_LeftCurlyBracketKeyword_2_1ElementType());
                    			
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalFowlerDslTestLanguage.g:301:4: ( (otherlv_4= RULE_ID ) )+
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
                    	    // PsiInternalFowlerDslTestLanguage.g:302:5: (otherlv_4= RULE_ID )
                    	    {
                    	    // PsiInternalFowlerDslTestLanguage.g:302:5: (otherlv_4= RULE_ID )
                    	    // PsiInternalFowlerDslTestLanguage.g:303:6: otherlv_4= RULE_ID
                    	    {

                    	    						if (!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

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

            // PsiInternalFowlerDslTestLanguage.g:326:3: ( (lv_transitions_6_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalFowlerDslTestLanguage.g:327:4: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // PsiInternalFowlerDslTestLanguage.g:327:4: (lv_transitions_6_0= ruleTransition )
            	    // PsiInternalFowlerDslTestLanguage.g:328:5: lv_transitions_6_0= ruleTransition
            	    {

            	    					markComposite(elementTypeProvider.getState_TransitionsTransitionParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_transitions_6_0=ruleTransition();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // PsiInternalFowlerDslTestLanguage.g:352:1: entryRuleTransition returns [Boolean current=false] : iv_ruleTransition= ruleTransition EOF ;
    public final Boolean entryRuleTransition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransition = null;


        try {
            // PsiInternalFowlerDslTestLanguage.g:352:52: (iv_ruleTransition= ruleTransition EOF )
            // PsiInternalFowlerDslTestLanguage.g:353:2: iv_ruleTransition= ruleTransition EOF
            {
             markComposite(elementTypeProvider.getTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // PsiInternalFowlerDslTestLanguage.g:359:1: ruleTransition returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final Boolean ruleTransition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalFowlerDslTestLanguage.g:360:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalFowlerDslTestLanguage.g:361:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:361:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalFowlerDslTestLanguage.g:362:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalFowlerDslTestLanguage.g:362:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:363:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:363:4: (otherlv_0= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:364:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getTransition_EventEventCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(otherlv_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransition_EqualsSignGreaterThanSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFowlerDslTestLanguage.g:386:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalFowlerDslTestLanguage.g:387:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalFowlerDslTestLanguage.g:387:4: (otherlv_2= RULE_ID )
            // PsiInternalFowlerDslTestLanguage.g:388:5: otherlv_2= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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