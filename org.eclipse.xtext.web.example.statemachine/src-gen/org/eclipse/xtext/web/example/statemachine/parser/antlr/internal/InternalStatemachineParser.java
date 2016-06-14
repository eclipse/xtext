package org.eclipse.xtext.web.example.statemachine.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalStatemachineParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOLEAN", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'signal'", "'input'", "'output'", "'state'", "'end'", "'if'", "'goto'", "'and'", "'=='", "'set'", "'='", "'.'"
    };
    public static final int RULE_BOOLEAN=5;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalStatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "InternalStatemachine.g"; }



     	private StatemachineGrammarAccess grammarAccess;

        public InternalStatemachineParser(TokenStream input, StatemachineGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";
       	}

       	@Override
       	protected StatemachineGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStatemachine"
    // InternalStatemachine.g:68:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // InternalStatemachine.g:68:53: (iv_ruleStatemachine= ruleStatemachine EOF )
            // InternalStatemachine.g:69:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // InternalStatemachine.g:75:1: ruleStatemachine returns [EObject current=null] : ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_signals_1_0 = null;

        EObject lv_states_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:81:2: ( ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* ) )
            // InternalStatemachine.g:82:2: ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* )
            {
            // InternalStatemachine.g:82:2: ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* )
            // InternalStatemachine.g:83:3: () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )*
            {
            // InternalStatemachine.g:83:3: ()
            // InternalStatemachine.g:84:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
            					current);
            			

            }

            // InternalStatemachine.g:90:3: ( (lv_signals_1_0= ruleSignal ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=14)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalStatemachine.g:91:4: (lv_signals_1_0= ruleSignal )
            	    {
            	    // InternalStatemachine.g:91:4: (lv_signals_1_0= ruleSignal )
            	    // InternalStatemachine.g:92:5: lv_signals_1_0= ruleSignal
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getSignalsSignalParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_signals_1_0=ruleSignal();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"signals",
            	    						lv_signals_1_0,
            	    						"org.eclipse.xtext.web.example.statemachine.Statemachine.Signal");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalStatemachine.g:109:3: ( (lv_states_2_0= ruleState ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalStatemachine.g:110:4: (lv_states_2_0= ruleState )
            	    {
            	    // InternalStatemachine.g:110:4: (lv_states_2_0= ruleState )
            	    // InternalStatemachine.g:111:5: lv_states_2_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_2_0,
            	    						"org.eclipse.xtext.web.example.statemachine.Statemachine.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "entryRuleSignal"
    // InternalStatemachine.g:132:1: entryRuleSignal returns [EObject current=null] : iv_ruleSignal= ruleSignal EOF ;
    public final EObject entryRuleSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignal = null;


        try {
            // InternalStatemachine.g:132:47: (iv_ruleSignal= ruleSignal EOF )
            // InternalStatemachine.g:133:2: iv_ruleSignal= ruleSignal EOF
            {
             newCompositeNode(grammarAccess.getSignalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignal=ruleSignal();

            state._fsp--;

             current =iv_ruleSignal; 
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
    // $ANTLR end "entryRuleSignal"


    // $ANTLR start "ruleSignal"
    // InternalStatemachine.g:139:1: ruleSignal returns [EObject current=null] : ( (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject this_InputSignal_0 = null;

        EObject this_OutputSignal_1 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:145:2: ( ( (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalStatemachine.g:146:2: ( (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalStatemachine.g:146:2: ( (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalStatemachine.g:147:3: (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalStatemachine.g:147:3: (this_InputSignal_0= ruleInputSignal | this_OutputSignal_1= ruleOutputSignal )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalStatemachine.g:148:4: this_InputSignal_0= ruleInputSignal
                    {

                    				newCompositeNode(grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_5);
                    this_InputSignal_0=ruleInputSignal();

                    state._fsp--;


                    				current = this_InputSignal_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:157:4: this_OutputSignal_1= ruleOutputSignal
                    {

                    				newCompositeNode(grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_5);
                    this_OutputSignal_1=ruleOutputSignal();

                    state._fsp--;


                    				current = this_OutputSignal_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSignalAccess().getSignalKeyword_1());
            		
            // InternalStatemachine.g:170:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalStatemachine.g:171:4: (lv_name_3_0= RULE_ID )
            {
            // InternalStatemachine.g:171:4: (lv_name_3_0= RULE_ID )
            // InternalStatemachine.g:172:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSignalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
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
    // $ANTLR end "ruleSignal"


    // $ANTLR start "entryRuleInputSignal"
    // InternalStatemachine.g:192:1: entryRuleInputSignal returns [EObject current=null] : iv_ruleInputSignal= ruleInputSignal EOF ;
    public final EObject entryRuleInputSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputSignal = null;


        try {
            // InternalStatemachine.g:192:52: (iv_ruleInputSignal= ruleInputSignal EOF )
            // InternalStatemachine.g:193:2: iv_ruleInputSignal= ruleInputSignal EOF
            {
             newCompositeNode(grammarAccess.getInputSignalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputSignal=ruleInputSignal();

            state._fsp--;

             current =iv_ruleInputSignal; 
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
    // $ANTLR end "entryRuleInputSignal"


    // $ANTLR start "ruleInputSignal"
    // InternalStatemachine.g:199:1: ruleInputSignal returns [EObject current=null] : ( () otherlv_1= 'input' ) ;
    public final EObject ruleInputSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalStatemachine.g:205:2: ( ( () otherlv_1= 'input' ) )
            // InternalStatemachine.g:206:2: ( () otherlv_1= 'input' )
            {
            // InternalStatemachine.g:206:2: ( () otherlv_1= 'input' )
            // InternalStatemachine.g:207:3: () otherlv_1= 'input'
            {
            // InternalStatemachine.g:207:3: ()
            // InternalStatemachine.g:208:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputSignalAccess().getInputSignalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInputSignalAccess().getInputKeyword_1());
            		

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
    // $ANTLR end "ruleInputSignal"


    // $ANTLR start "entryRuleOutputSignal"
    // InternalStatemachine.g:222:1: entryRuleOutputSignal returns [EObject current=null] : iv_ruleOutputSignal= ruleOutputSignal EOF ;
    public final EObject entryRuleOutputSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputSignal = null;


        try {
            // InternalStatemachine.g:222:53: (iv_ruleOutputSignal= ruleOutputSignal EOF )
            // InternalStatemachine.g:223:2: iv_ruleOutputSignal= ruleOutputSignal EOF
            {
             newCompositeNode(grammarAccess.getOutputSignalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputSignal=ruleOutputSignal();

            state._fsp--;

             current =iv_ruleOutputSignal; 
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
    // $ANTLR end "entryRuleOutputSignal"


    // $ANTLR start "ruleOutputSignal"
    // InternalStatemachine.g:229:1: ruleOutputSignal returns [EObject current=null] : ( () otherlv_1= 'output' ) ;
    public final EObject ruleOutputSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalStatemachine.g:235:2: ( ( () otherlv_1= 'output' ) )
            // InternalStatemachine.g:236:2: ( () otherlv_1= 'output' )
            {
            // InternalStatemachine.g:236:2: ( () otherlv_1= 'output' )
            // InternalStatemachine.g:237:3: () otherlv_1= 'output'
            {
            // InternalStatemachine.g:237:3: ()
            // InternalStatemachine.g:238:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOutputSignalAccess().getOutputSignalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getOutputSignalAccess().getOutputKeyword_1());
            		

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
    // $ANTLR end "ruleOutputSignal"


    // $ANTLR start "entryRuleState"
    // InternalStatemachine.g:252:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalStatemachine.g:252:46: (iv_ruleState= ruleState EOF )
            // InternalStatemachine.g:253:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalStatemachine.g:259:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* ( (lv_nestedStates_4_0= ruleState ) )* otherlv_5= 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_5=null;
        EObject lv_commands_2_0 = null;

        EObject lv_transitions_3_0 = null;

        EObject lv_nestedStates_4_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:265:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* ( (lv_nestedStates_4_0= ruleState ) )* otherlv_5= 'end' ) )
            // InternalStatemachine.g:266:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* ( (lv_nestedStates_4_0= ruleState ) )* otherlv_5= 'end' )
            {
            // InternalStatemachine.g:266:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* ( (lv_nestedStates_4_0= ruleState ) )* otherlv_5= 'end' )
            // InternalStatemachine.g:267:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* ( (lv_nestedStates_4_0= ruleState ) )* otherlv_5= 'end'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalStatemachine.g:271:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStatemachine.g:272:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStatemachine.g:272:4: (lv_name_1_0= RULE_ID )
            // InternalStatemachine.g:273:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

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

            // InternalStatemachine.g:289:3: ( (lv_commands_2_0= ruleCommand ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalStatemachine.g:290:4: (lv_commands_2_0= ruleCommand )
            	    {
            	    // InternalStatemachine.g:290:4: (lv_commands_2_0= ruleCommand )
            	    // InternalStatemachine.g:291:5: lv_commands_2_0= ruleCommand
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getCommandsCommandParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_commands_2_0=ruleCommand();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_2_0,
            	    						"org.eclipse.xtext.web.example.statemachine.Statemachine.Command");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalStatemachine.g:308:3: ( (lv_transitions_3_0= ruleTransition ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalStatemachine.g:309:4: (lv_transitions_3_0= ruleTransition )
            	    {
            	    // InternalStatemachine.g:309:4: (lv_transitions_3_0= ruleTransition )
            	    // InternalStatemachine.g:310:5: lv_transitions_3_0= ruleTransition
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_transitions_3_0=ruleTransition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transitions",
            	    						lv_transitions_3_0,
            	    						"org.eclipse.xtext.web.example.statemachine.Statemachine.Transition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalStatemachine.g:327:3: ( (lv_nestedStates_4_0= ruleState ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalStatemachine.g:328:4: (lv_nestedStates_4_0= ruleState )
            	    {
            	    // InternalStatemachine.g:328:4: (lv_nestedStates_4_0= ruleState )
            	    // InternalStatemachine.g:329:5: lv_nestedStates_4_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getNestedStatesStateParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_nestedStates_4_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nestedStates",
            	    						lv_nestedStates_4_0,
            	    						"org.eclipse.xtext.web.example.statemachine.Statemachine.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getEndKeyword_5());
            		

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
    // InternalStatemachine.g:354:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalStatemachine.g:354:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalStatemachine.g:355:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalStatemachine.g:361:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:367:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( ( ruleQualifiedName ) ) ) )
            // InternalStatemachine.g:368:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( ( ruleQualifiedName ) ) )
            {
            // InternalStatemachine.g:368:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( ( ruleQualifiedName ) ) )
            // InternalStatemachine.g:369:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getIfKeyword_0());
            		
            // InternalStatemachine.g:373:3: ( (lv_condition_1_0= ruleCondition ) )
            // InternalStatemachine.g:374:4: (lv_condition_1_0= ruleCondition )
            {
            // InternalStatemachine.g:374:4: (lv_condition_1_0= ruleCondition )
            // InternalStatemachine.g:375:5: lv_condition_1_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_condition_1_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransitionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.eclipse.xtext.web.example.statemachine.Statemachine.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getGotoKeyword_2());
            		
            // InternalStatemachine.g:396:3: ( ( ruleQualifiedName ) )
            // InternalStatemachine.g:397:4: ( ruleQualifiedName )
            {
            // InternalStatemachine.g:397:4: ( ruleQualifiedName )
            // InternalStatemachine.g:398:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getStateStateCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleCondition"
    // InternalStatemachine.g:416:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalStatemachine.g:416:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalStatemachine.g:417:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalStatemachine.g:423:1: ruleCondition returns [EObject current=null] : ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_events_0_0 = null;

        EObject lv_events_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:429:2: ( ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* ) )
            // InternalStatemachine.g:430:2: ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* )
            {
            // InternalStatemachine.g:430:2: ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* )
            // InternalStatemachine.g:431:3: ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )*
            {
            // InternalStatemachine.g:431:3: ( (lv_events_0_0= ruleEvent ) )
            // InternalStatemachine.g:432:4: (lv_events_0_0= ruleEvent )
            {
            // InternalStatemachine.g:432:4: (lv_events_0_0= ruleEvent )
            // InternalStatemachine.g:433:5: lv_events_0_0= ruleEvent
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_events_0_0=ruleEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					add(
            						current,
            						"events",
            						lv_events_0_0,
            						"org.eclipse.xtext.web.example.statemachine.Statemachine.Event");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStatemachine.g:450:3: (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalStatemachine.g:451:4: otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getAndKeyword_1_0());
            	    			
            	    // InternalStatemachine.g:455:4: ( (lv_events_2_0= ruleEvent ) )
            	    // InternalStatemachine.g:456:5: (lv_events_2_0= ruleEvent )
            	    {
            	    // InternalStatemachine.g:456:5: (lv_events_2_0= ruleEvent )
            	    // InternalStatemachine.g:457:6: lv_events_2_0= ruleEvent
            	    {

            	    						newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_events_2_0=ruleEvent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"events",
            	    							lv_events_2_0,
            	    							"org.eclipse.xtext.web.example.statemachine.Statemachine.Event");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleEvent"
    // InternalStatemachine.g:479:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalStatemachine.g:479:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalStatemachine.g:480:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalStatemachine.g:486:1: ruleEvent returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_value_2_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalStatemachine.g:492:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_value_2_0= RULE_BOOLEAN ) ) ) )
            // InternalStatemachine.g:493:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_value_2_0= RULE_BOOLEAN ) ) )
            {
            // InternalStatemachine.g:493:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_value_2_0= RULE_BOOLEAN ) ) )
            // InternalStatemachine.g:494:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_value_2_0= RULE_BOOLEAN ) )
            {
            // InternalStatemachine.g:494:3: ( (otherlv_0= RULE_ID ) )
            // InternalStatemachine.g:495:4: (otherlv_0= RULE_ID )
            {
            // InternalStatemachine.g:495:4: (otherlv_0= RULE_ID )
            // InternalStatemachine.g:496:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getEventAccess().getSignalSignalCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1());
            		
            // InternalStatemachine.g:511:3: ( (lv_value_2_0= RULE_BOOLEAN ) )
            // InternalStatemachine.g:512:4: (lv_value_2_0= RULE_BOOLEAN )
            {
            // InternalStatemachine.g:512:4: (lv_value_2_0= RULE_BOOLEAN )
            // InternalStatemachine.g:513:5: lv_value_2_0= RULE_BOOLEAN
            {
            lv_value_2_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getEventAccess().getValueBOOLEANTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.web.example.statemachine.Statemachine.BOOLEAN");
            				

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
    // InternalStatemachine.g:533:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalStatemachine.g:533:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalStatemachine.g:534:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalStatemachine.g:540:1: ruleCommand returns [EObject current=null] : (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newValue_3_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_newValue_3_0=null;


        	enterRule();

        try {
            // InternalStatemachine.g:546:2: ( (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newValue_3_0= RULE_BOOLEAN ) ) ) )
            // InternalStatemachine.g:547:2: (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newValue_3_0= RULE_BOOLEAN ) ) )
            {
            // InternalStatemachine.g:547:2: (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newValue_3_0= RULE_BOOLEAN ) ) )
            // InternalStatemachine.g:548:3: otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newValue_3_0= RULE_BOOLEAN ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getCommandAccess().getSetKeyword_0());
            		
            // InternalStatemachine.g:552:3: ( (otherlv_1= RULE_ID ) )
            // InternalStatemachine.g:553:4: (otherlv_1= RULE_ID )
            {
            // InternalStatemachine.g:553:4: (otherlv_1= RULE_ID )
            // InternalStatemachine.g:554:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommandRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getSignalSignalCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getCommandAccess().getEqualsSignKeyword_2());
            		
            // InternalStatemachine.g:569:3: ( (lv_newValue_3_0= RULE_BOOLEAN ) )
            // InternalStatemachine.g:570:4: (lv_newValue_3_0= RULE_BOOLEAN )
            {
            // InternalStatemachine.g:570:4: (lv_newValue_3_0= RULE_BOOLEAN )
            // InternalStatemachine.g:571:5: lv_newValue_3_0= RULE_BOOLEAN
            {
            lv_newValue_3_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            					newLeafNode(lv_newValue_3_0, grammarAccess.getCommandAccess().getNewValueBOOLEANTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommandRule());
            					}
            					setWithLastConsumed(
            						current,
            						"newValue",
            						lv_newValue_3_0,
            						"org.eclipse.xtext.web.example.statemachine.Statemachine.BOOLEAN");
            				

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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalStatemachine.g:591:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalStatemachine.g:591:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalStatemachine.g:592:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalStatemachine.g:598:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalStatemachine.g:604:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalStatemachine.g:605:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalStatemachine.g:605:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalStatemachine.g:606:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalStatemachine.g:613:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalStatemachine.g:614:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,23,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000238000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800002L});

}