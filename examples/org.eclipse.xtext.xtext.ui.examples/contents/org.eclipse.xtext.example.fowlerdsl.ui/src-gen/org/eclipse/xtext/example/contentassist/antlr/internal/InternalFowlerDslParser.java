package org.eclipse.xtext.example.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFowlerDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'commands'", "'state'", "'actions'", "'{'", "'}'", "'=>'", "'resetting'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFowlerDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g"; }


     
     	private FowlerDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(FowlerDslGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleStatemachine
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:60:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:61:1: ( ruleStatemachine EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:62:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatemachine_in_entryRuleStatemachine61);
            ruleStatemachine();
            _fsp--;

             after(grammarAccess.getStatemachineRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatemachine68); 

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
    // $ANTLR end entryRuleStatemachine


    // $ANTLR start ruleStatemachine
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:69:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:73:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:74:1: ( ( rule__Statemachine__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:74:1: ( ( rule__Statemachine__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:75:1: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:76:1: ( rule__Statemachine__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:76:2: rule__Statemachine__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine95);
            rule__Statemachine__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStatemachine


    // $ANTLR start entryRuleEvent
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:88:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:89:1: ( ruleEvent EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:90:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvent_in_entryRuleEvent122);
            ruleEvent();
            _fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvent129); 

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
    // $ANTLR end entryRuleEvent


    // $ANTLR start ruleEvent
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:97:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:101:2: ( ( ( rule__Event__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:102:1: ( ( rule__Event__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:102:1: ( ( rule__Event__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:103:1: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:104:1: ( rule__Event__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:104:2: rule__Event__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Event__Group__0_in_ruleEvent156);
            rule__Event__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEvent


    // $ANTLR start entryRuleCommand
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:116:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:117:1: ( ruleCommand EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:118:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommand_in_entryRuleCommand183);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getCommandRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommand190); 

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
    // $ANTLR end entryRuleCommand


    // $ANTLR start ruleCommand
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:125:1: ruleCommand : ( ( rule__Command__Group__0 ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:129:2: ( ( ( rule__Command__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:130:1: ( ( rule__Command__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:130:1: ( ( rule__Command__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:131:1: ( rule__Command__Group__0 )
            {
             before(grammarAccess.getCommandAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:132:1: ( rule__Command__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:132:2: rule__Command__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Command__Group__0_in_ruleCommand217);
            rule__Command__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleCommand


    // $ANTLR start entryRuleState
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:144:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:145:1: ( ruleState EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:146:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState244);
            ruleState();
            _fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState251); 

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:153:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:157:2: ( ( ( rule__State__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:158:1: ( ( rule__State__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:158:1: ( ( rule__State__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:159:1: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:160:1: ( rule__State__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:160:2: rule__State__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__0_in_ruleState278);
            rule__State__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleState


    // $ANTLR start entryRuleTransition
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:172:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:173:1: ( ruleTransition EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:174:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_entryRuleTransition305);
            ruleTransition();
            _fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransition312); 

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
    // $ANTLR end entryRuleTransition


    // $ANTLR start ruleTransition
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:181:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:185:2: ( ( ( rule__Transition__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:186:1: ( ( rule__Transition__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:186:1: ( ( rule__Transition__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:187:1: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:188:1: ( rule__Transition__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:188:2: rule__Transition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Transition__Group__0_in_ruleTransition339);
            rule__Transition__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTransition


    // $ANTLR start rule__Statemachine__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:202:1: rule__Statemachine__Group__0 : ( 'events' ) rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:206:1: ( ( 'events' ) rule__Statemachine__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:207:1: ( 'events' ) rule__Statemachine__Group__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:207:1: ( 'events' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:208:1: 'events'
            {
             before(grammarAccess.getStatemachineAccess().getEventsKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Statemachine__Group__0378); 
             after(grammarAccess.getStatemachineAccess().getEventsKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0388);
            rule__Statemachine__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__0


    // $ANTLR start rule__Statemachine__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:222:1: rule__Statemachine__Group__1 : ( ( rule__Statemachine__EventsAssignment_1 )* ) rule__Statemachine__Group__2 ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:226:1: ( ( ( rule__Statemachine__EventsAssignment_1 )* ) rule__Statemachine__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:227:1: ( ( rule__Statemachine__EventsAssignment_1 )* ) rule__Statemachine__Group__2
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:227:1: ( ( rule__Statemachine__EventsAssignment_1 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:228:1: ( rule__Statemachine__EventsAssignment_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:229:1: ( rule__Statemachine__EventsAssignment_1 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:229:2: rule__Statemachine__EventsAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Statemachine__EventsAssignment_1_in_rule__Statemachine__Group__1416);
            	    rule__Statemachine__EventsAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getEventsAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1426);
            rule__Statemachine__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__1


    // $ANTLR start rule__Statemachine__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:240:1: rule__Statemachine__Group__2 : ( 'end' ) rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:244:1: ( ( 'end' ) rule__Statemachine__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:245:1: ( 'end' ) rule__Statemachine__Group__3
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:245:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:246:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Statemachine__Group__2455); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2465);
            rule__Statemachine__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__2


    // $ANTLR start rule__Statemachine__Group__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:260:1: rule__Statemachine__Group__3 : ( 'commands' ) rule__Statemachine__Group__4 ;
    public final void rule__Statemachine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:264:1: ( ( 'commands' ) rule__Statemachine__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:265:1: ( 'commands' ) rule__Statemachine__Group__4
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:265:1: ( 'commands' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:266:1: 'commands'
            {
             before(grammarAccess.getStatemachineAccess().getCommandsKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Statemachine__Group__3494); 
             after(grammarAccess.getStatemachineAccess().getCommandsKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3504);
            rule__Statemachine__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__3


    // $ANTLR start rule__Statemachine__Group__4
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:280:1: rule__Statemachine__Group__4 : ( ( rule__Statemachine__CommandsAssignment_4 )* ) rule__Statemachine__Group__5 ;
    public final void rule__Statemachine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:284:1: ( ( ( rule__Statemachine__CommandsAssignment_4 )* ) rule__Statemachine__Group__5 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:285:1: ( ( rule__Statemachine__CommandsAssignment_4 )* ) rule__Statemachine__Group__5
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:285:1: ( ( rule__Statemachine__CommandsAssignment_4 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:286:1: ( rule__Statemachine__CommandsAssignment_4 )*
            {
             before(grammarAccess.getStatemachineAccess().getCommandsAssignment_4()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:287:1: ( rule__Statemachine__CommandsAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:287:2: rule__Statemachine__CommandsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Statemachine__CommandsAssignment_4_in_rule__Statemachine__Group__4532);
            	    rule__Statemachine__CommandsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getCommandsAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4542);
            rule__Statemachine__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__4


    // $ANTLR start rule__Statemachine__Group__5
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:298:1: rule__Statemachine__Group__5 : ( 'end' ) rule__Statemachine__Group__6 ;
    public final void rule__Statemachine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:302:1: ( ( 'end' ) rule__Statemachine__Group__6 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:303:1: ( 'end' ) rule__Statemachine__Group__6
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:303:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:304:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_5()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Statemachine__Group__5571); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__5581);
            rule__Statemachine__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__5


    // $ANTLR start rule__Statemachine__Group__6
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:318:1: rule__Statemachine__Group__6 : ( ( rule__Statemachine__StatesAssignment_6 )* ) ;
    public final void rule__Statemachine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:322:1: ( ( ( rule__Statemachine__StatesAssignment_6 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:323:1: ( ( rule__Statemachine__StatesAssignment_6 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:323:1: ( ( rule__Statemachine__StatesAssignment_6 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:324:1: ( rule__Statemachine__StatesAssignment_6 )*
            {
             before(grammarAccess.getStatemachineAccess().getStatesAssignment_6()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:325:1: ( rule__Statemachine__StatesAssignment_6 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:325:2: rule__Statemachine__StatesAssignment_6
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Statemachine__StatesAssignment_6_in_rule__Statemachine__Group__6609);
            	    rule__Statemachine__StatesAssignment_6();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getStatesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__Group__6


    // $ANTLR start rule__Event__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:349:1: rule__Event__Group__0 : ( ( rule__Event__ResettingAssignment_0 )? ) rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:353:1: ( ( ( rule__Event__ResettingAssignment_0 )? ) rule__Event__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:354:1: ( ( rule__Event__ResettingAssignment_0 )? ) rule__Event__Group__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:354:1: ( ( rule__Event__ResettingAssignment_0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:355:1: ( rule__Event__ResettingAssignment_0 )?
            {
             before(grammarAccess.getEventAccess().getResettingAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:356:1: ( rule__Event__ResettingAssignment_0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:356:2: rule__Event__ResettingAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0658);
                    rule__Event__ResettingAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventAccess().getResettingAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0668);
            rule__Event__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__Group__0


    // $ANTLR start rule__Event__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:367:1: rule__Event__Group__1 : ( ( rule__Event__NameAssignment_1 ) ) rule__Event__Group__2 ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:371:1: ( ( ( rule__Event__NameAssignment_1 ) ) rule__Event__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:372:1: ( ( rule__Event__NameAssignment_1 ) ) rule__Event__Group__2
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:372:1: ( ( rule__Event__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:373:1: ( rule__Event__NameAssignment_1 )
            {
             before(grammarAccess.getEventAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:374:1: ( rule__Event__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:374:2: rule__Event__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1696);
            rule__Event__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEventAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1705);
            rule__Event__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__Group__1


    // $ANTLR start rule__Event__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:385:1: rule__Event__Group__2 : ( ( rule__Event__CodeAssignment_2 ) ) ;
    public final void rule__Event__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:389:1: ( ( ( rule__Event__CodeAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:390:1: ( ( rule__Event__CodeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:390:1: ( ( rule__Event__CodeAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:391:1: ( rule__Event__CodeAssignment_2 )
            {
             before(grammarAccess.getEventAccess().getCodeAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:392:1: ( rule__Event__CodeAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:392:2: rule__Event__CodeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2733);
            rule__Event__CodeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEventAccess().getCodeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__Group__2


    // $ANTLR start rule__Command__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:408:1: rule__Command__Group__0 : ( ( rule__Command__NameAssignment_0 ) ) rule__Command__Group__1 ;
    public final void rule__Command__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:412:1: ( ( ( rule__Command__NameAssignment_0 ) ) rule__Command__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:413:1: ( ( rule__Command__NameAssignment_0 ) ) rule__Command__Group__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:413:1: ( ( rule__Command__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:414:1: ( rule__Command__NameAssignment_0 )
            {
             before(grammarAccess.getCommandAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:415:1: ( rule__Command__NameAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:415:2: rule__Command__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0773);
            rule__Command__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Command__Group__1_in_rule__Command__Group__0782);
            rule__Command__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__0


    // $ANTLR start rule__Command__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:426:1: rule__Command__Group__1 : ( ( rule__Command__CodeAssignment_1 ) ) ;
    public final void rule__Command__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:430:1: ( ( ( rule__Command__CodeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:431:1: ( ( rule__Command__CodeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:431:1: ( ( rule__Command__CodeAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:432:1: ( rule__Command__CodeAssignment_1 )
            {
             before(grammarAccess.getCommandAccess().getCodeAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:433:1: ( rule__Command__CodeAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:433:2: rule__Command__CodeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1810);
            rule__Command__CodeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getCodeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__1


    // $ANTLR start rule__State__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:447:1: rule__State__Group__0 : ( 'state' ) rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:451:1: ( ( 'state' ) rule__State__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:452:1: ( 'state' ) rule__State__Group__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:452:1: ( 'state' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:453:1: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__State__Group__0849); 
             after(grammarAccess.getStateAccess().getStateKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__1_in_rule__State__Group__0859);
            rule__State__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__0


    // $ANTLR start rule__State__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:467:1: rule__State__Group__1 : ( ( rule__State__NameAssignment_1 ) ) rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:471:1: ( ( ( rule__State__NameAssignment_1 ) ) rule__State__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:472:1: ( ( rule__State__NameAssignment_1 ) ) rule__State__Group__2
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:472:1: ( ( rule__State__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:473:1: ( rule__State__NameAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:474:1: ( rule__State__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:474:2: rule__State__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1887);
            rule__State__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__2_in_rule__State__Group__1896);
            rule__State__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__1


    // $ANTLR start rule__State__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:485:1: rule__State__Group__2 : ( ( rule__State__Group_2__0 )? ) rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:489:1: ( ( ( rule__State__Group_2__0 )? ) rule__State__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:490:1: ( ( rule__State__Group_2__0 )? ) rule__State__Group__3
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:490:1: ( ( rule__State__Group_2__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:491:1: ( rule__State__Group_2__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:492:1: ( rule__State__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:492:2: rule__State__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2924);
                    rule__State__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__3_in_rule__State__Group__2934);
            rule__State__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__2


    // $ANTLR start rule__State__Group__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:503:1: rule__State__Group__3 : ( ( rule__State__TransitionsAssignment_3 )* ) rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:507:1: ( ( ( rule__State__TransitionsAssignment_3 )* ) rule__State__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:508:1: ( ( rule__State__TransitionsAssignment_3 )* ) rule__State__Group__4
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:508:1: ( ( rule__State__TransitionsAssignment_3 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:509:1: ( rule__State__TransitionsAssignment_3 )*
            {
             before(grammarAccess.getStateAccess().getTransitionsAssignment_3()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:510:1: ( rule__State__TransitionsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:510:2: rule__State__TransitionsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3962);
            	    rule__State__TransitionsAssignment_3();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getTransitionsAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__4_in_rule__State__Group__3972);
            rule__State__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__3


    // $ANTLR start rule__State__Group__4
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:521:1: rule__State__Group__4 : ( 'end' ) ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:525:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:526:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:526:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:527:1: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_4()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__State__Group__41001); 
             after(grammarAccess.getStateAccess().getEndKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__4


    // $ANTLR start rule__State__Group_2__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:550:1: rule__State__Group_2__0 : ( 'actions' ) rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:554:1: ( ( 'actions' ) rule__State__Group_2__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:555:1: ( 'actions' ) rule__State__Group_2__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:555:1: ( 'actions' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:556:1: 'actions'
            {
             before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__State__Group_2__01047); 
             after(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01057);
            rule__State__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group_2__0


    // $ANTLR start rule__State__Group_2__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:570:1: rule__State__Group_2__1 : ( '{' ) rule__State__Group_2__2 ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:574:1: ( ( '{' ) rule__State__Group_2__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:575:1: ( '{' ) rule__State__Group_2__2
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:575:1: ( '{' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:576:1: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__State__Group_2__11086); 
             after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11096);
            rule__State__Group_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group_2__1


    // $ANTLR start rule__State__Group_2__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:590:1: rule__State__Group_2__2 : ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) rule__State__Group_2__3 ;
    public final void rule__State__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:594:1: ( ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) rule__State__Group_2__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:595:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) rule__State__Group_2__3
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:595:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:596:1: ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:596:1: ( ( rule__State__ActionsAssignment_2_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:597:1: ( rule__State__ActionsAssignment_2_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:598:1: ( rule__State__ActionsAssignment_2_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:598:2: rule__State__ActionsAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__21126);
            rule__State__ActionsAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:601:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:602:1: ( rule__State__ActionsAssignment_2_2 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:603:1: ( rule__State__ActionsAssignment_2_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:603:2: rule__State__ActionsAssignment_2_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__21138);
            	    rule__State__ActionsAssignment_2_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21150);
            rule__State__Group_2__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group_2__2


    // $ANTLR start rule__State__Group_2__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:615:1: rule__State__Group_2__3 : ( '}' ) ;
    public final void rule__State__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:619:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:620:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:620:1: ( '}' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:621:1: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__State__Group_2__31179); 
             after(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group_2__3


    // $ANTLR start rule__Transition__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:642:1: rule__Transition__Group__0 : ( ( rule__Transition__EventAssignment_0 ) ) rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:646:1: ( ( ( rule__Transition__EventAssignment_0 ) ) rule__Transition__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:647:1: ( ( rule__Transition__EventAssignment_0 ) ) rule__Transition__Group__1
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:647:1: ( ( rule__Transition__EventAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:648:1: ( rule__Transition__EventAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:649:1: ( rule__Transition__EventAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:649:2: rule__Transition__EventAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__01222);
            rule__Transition__EventAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getTransitionAccess().getEventAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01231);
            rule__Transition__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Transition__Group__0


    // $ANTLR start rule__Transition__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:660:1: rule__Transition__Group__1 : ( '=>' ) rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:664:1: ( ( '=>' ) rule__Transition__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:665:1: ( '=>' ) rule__Transition__Group__2
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:665:1: ( '=>' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:666:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Transition__Group__11260); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11270);
            rule__Transition__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Transition__Group__1


    // $ANTLR start rule__Transition__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:680:1: rule__Transition__Group__2 : ( ( rule__Transition__StateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:684:1: ( ( ( rule__Transition__StateAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:685:1: ( ( rule__Transition__StateAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:685:1: ( ( rule__Transition__StateAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:686:1: ( rule__Transition__StateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getStateAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:687:1: ( rule__Transition__StateAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:687:2: rule__Transition__StateAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__21298);
            rule__Transition__StateAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getTransitionAccess().getStateAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Transition__Group__2


    // $ANTLR start rule__Statemachine__EventsAssignment_1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:704:1: rule__Statemachine__EventsAssignment_1 : ( ruleEvent ) ;
    public final void rule__Statemachine__EventsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:708:1: ( ( ruleEvent ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:709:1: ( ruleEvent )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:709:1: ( ruleEvent )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:710:1: ruleEvent
            {
             before(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_11339);
            ruleEvent();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__EventsAssignment_1


    // $ANTLR start rule__Statemachine__CommandsAssignment_4
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:719:1: rule__Statemachine__CommandsAssignment_4 : ( ruleCommand ) ;
    public final void rule__Statemachine__CommandsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:723:1: ( ( ruleCommand ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:724:1: ( ruleCommand )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:724:1: ( ruleCommand )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:725:1: ruleCommand
            {
             before(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_41370);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__CommandsAssignment_4


    // $ANTLR start rule__Statemachine__StatesAssignment_6
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:734:1: rule__Statemachine__StatesAssignment_6 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:738:1: ( ( ruleState ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:739:1: ( ruleState )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:739:1: ( ruleState )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:740:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_61401);
            ruleState();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statemachine__StatesAssignment_6


    // $ANTLR start rule__Event__ResettingAssignment_0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:749:1: rule__Event__ResettingAssignment_0 : ( ( 'resetting' ) ) ;
    public final void rule__Event__ResettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:753:1: ( ( ( 'resetting' ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:754:1: ( ( 'resetting' ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:754:1: ( ( 'resetting' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:755:1: ( 'resetting' )
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:756:1: ( 'resetting' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:757:1: 'resetting'
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Event__ResettingAssignment_01437); 
             after(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 

            }

             after(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__ResettingAssignment_0


    // $ANTLR start rule__Event__NameAssignment_1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:772:1: rule__Event__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:776:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:777:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:777:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:778:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Event__NameAssignment_11476); 
             after(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__NameAssignment_1


    // $ANTLR start rule__Event__CodeAssignment_2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:787:1: rule__Event__CodeAssignment_2 : ( RULE_ID ) ;
    public final void rule__Event__CodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:791:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:792:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:792:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:793:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_21507); 
             after(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Event__CodeAssignment_2


    // $ANTLR start rule__Command__NameAssignment_0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:802:1: rule__Command__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Command__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:806:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:807:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:807:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:808:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Command__NameAssignment_01538); 
             after(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__NameAssignment_0


    // $ANTLR start rule__Command__CodeAssignment_1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:817:1: rule__Command__CodeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Command__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:821:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:822:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:822:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:823:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_11569); 
             after(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__CodeAssignment_1


    // $ANTLR start rule__State__NameAssignment_1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:832:1: rule__State__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:836:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:837:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:837:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:838:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__State__NameAssignment_11600); 
             after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__NameAssignment_1


    // $ANTLR start rule__State__ActionsAssignment_2_2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:847:1: rule__State__ActionsAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__State__ActionsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:851:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:852:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:852:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:853:1: ( RULE_ID )
            {
             before(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:854:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:855:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_21635); 
             after(grammarAccess.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__ActionsAssignment_2_2


    // $ANTLR start rule__State__TransitionsAssignment_3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:866:1: rule__State__TransitionsAssignment_3 : ( ruleTransition ) ;
    public final void rule__State__TransitionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:870:1: ( ( ruleTransition ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:871:1: ( ruleTransition )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:871:1: ( ruleTransition )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:872:1: ruleTransition
            {
             before(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_31670);
            ruleTransition();
            _fsp--;

             after(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__TransitionsAssignment_3


    // $ANTLR start rule__Transition__EventAssignment_0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:881:1: rule__Transition__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:885:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:886:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:886:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:887:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:888:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:889:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_01705); 
             after(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Transition__EventAssignment_0


    // $ANTLR start rule__Transition__StateAssignment_2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:900:1: rule__Transition__StateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__StateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:904:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:905:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:905:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:906:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:907:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalFowlerDsl.g:908:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_21744); 
             after(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Transition__StateAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvent129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Event__Group__0_in_ruleEvent156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommand190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Command__Group__0_in_ruleCommand217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleState_in_entryRuleState244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__0_in_ruleState278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransition312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Transition__Group__0_in_ruleTransition339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Statemachine__Group__0378 = new BitSet(new long[]{0x0000000000081010L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_1_in_rule__Statemachine__Group__1416 = new BitSet(new long[]{0x0000000000081010L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__2455 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Statemachine__Group__3494 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statemachine__CommandsAssignment_4_in_rule__Statemachine__Group__4532 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__5571 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__5581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_6_in_rule__Statemachine__Group__6609 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0658 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1696 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0773 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Command__Group__1_in_rule__Command__Group__0782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__State__Group__0849 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__0859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1887 = new BitSet(new long[]{0x0000000000009010L});
        public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__1896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2924 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__2934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3962 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__State__Group__4_in_rule__State__Group__3972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__State__Group__41001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__State__Group_2__01047 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__State__Group_2__11086 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__21126 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__21138 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__State__Group_2__31179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__01222 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Transition__Group__11260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__21298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_11339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_41370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_61401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Event__ResettingAssignment_01437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Event__NameAssignment_11476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_21507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Command__NameAssignment_01538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_11569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__State__NameAssignment_11600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_21635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_31670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_01705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_21744 = new BitSet(new long[]{0x0000000000000002L});
    }


}