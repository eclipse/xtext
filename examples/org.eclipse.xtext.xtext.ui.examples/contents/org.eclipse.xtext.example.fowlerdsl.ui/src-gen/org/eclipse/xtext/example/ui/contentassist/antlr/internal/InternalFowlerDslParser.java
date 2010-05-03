package org.eclipse.xtext.example.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g"; }


     
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:61:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:62:1: ( ruleStatemachine EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:63:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine61);
            ruleStatemachine();
            _fsp--;

             after(grammarAccess.getStatemachineRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine68); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:70:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:74:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:75:1: ( ( rule__Statemachine__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:75:1: ( ( rule__Statemachine__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:76:1: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:77:1: ( rule__Statemachine__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:77:2: rule__Statemachine__Group__0
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine94);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:89:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:90:1: ( ruleEvent EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:91:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent121);
            ruleEvent();
            _fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent128); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:98:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:102:2: ( ( ( rule__Event__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:103:1: ( ( rule__Event__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:103:1: ( ( rule__Event__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:104:1: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:105:1: ( rule__Event__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:105:2: rule__Event__Group__0
            {
            pushFollow(FOLLOW_rule__Event__Group__0_in_ruleEvent154);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:117:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:118:1: ( ruleCommand EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:119:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand181);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getCommandRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand188); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:126:1: ruleCommand : ( ( rule__Command__Group__0 ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:130:2: ( ( ( rule__Command__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:131:1: ( ( rule__Command__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:131:1: ( ( rule__Command__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:132:1: ( rule__Command__Group__0 )
            {
             before(grammarAccess.getCommandAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:133:1: ( rule__Command__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:133:2: rule__Command__Group__0
            {
            pushFollow(FOLLOW_rule__Command__Group__0_in_ruleCommand214);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:145:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:146:1: ( ruleState EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:147:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState241);
            ruleState();
            _fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState248); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:154:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:158:2: ( ( ( rule__State__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:159:1: ( ( rule__State__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:159:1: ( ( rule__State__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:160:1: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:161:1: ( rule__State__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:161:2: rule__State__Group__0
            {
            pushFollow(FOLLOW_rule__State__Group__0_in_ruleState274);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:173:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:174:1: ( ruleTransition EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:175:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition301);
            ruleTransition();
            _fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition308); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:182:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:186:2: ( ( ( rule__Transition__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:187:1: ( ( rule__Transition__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:187:1: ( ( rule__Transition__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:188:1: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:189:1: ( rule__Transition__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:189:2: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_rule__Transition__Group__0_in_ruleTransition334);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:203:1: rule__Statemachine__Group__0 : rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:207:1: ( rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:208:2: rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0368);
            rule__Statemachine__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0371);
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


    // $ANTLR start rule__Statemachine__Group__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:215:1: rule__Statemachine__Group__0__Impl : ( 'events' ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:219:1: ( ( 'events' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:220:1: ( 'events' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:220:1: ( 'events' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:221:1: 'events'
            {
             before(grammarAccess.getStatemachineAccess().getEventsKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Statemachine__Group__0__Impl399); 
             after(grammarAccess.getStatemachineAccess().getEventsKeyword_0()); 

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
    // $ANTLR end rule__Statemachine__Group__0__Impl


    // $ANTLR start rule__Statemachine__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:234:1: rule__Statemachine__Group__1 : rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:238:1: ( rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:239:2: rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1430);
            rule__Statemachine__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1433);
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


    // $ANTLR start rule__Statemachine__Group__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:246:1: rule__Statemachine__Group__1__Impl : ( ( rule__Statemachine__EventsAssignment_1 )* ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:250:1: ( ( ( rule__Statemachine__EventsAssignment_1 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:251:1: ( ( rule__Statemachine__EventsAssignment_1 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:251:1: ( ( rule__Statemachine__EventsAssignment_1 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:252:1: ( rule__Statemachine__EventsAssignment_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:253:1: ( rule__Statemachine__EventsAssignment_1 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:253:2: rule__Statemachine__EventsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__EventsAssignment_1_in_rule__Statemachine__Group__1__Impl460);
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
    // $ANTLR end rule__Statemachine__Group__1__Impl


    // $ANTLR start rule__Statemachine__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:263:1: rule__Statemachine__Group__2 : rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:267:1: ( rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:268:2: rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2491);
            rule__Statemachine__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2494);
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


    // $ANTLR start rule__Statemachine__Group__2__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:275:1: rule__Statemachine__Group__2__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:279:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:280:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:280:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:281:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group__2__Impl522); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_2()); 

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
    // $ANTLR end rule__Statemachine__Group__2__Impl


    // $ANTLR start rule__Statemachine__Group__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:294:1: rule__Statemachine__Group__3 : rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 ;
    public final void rule__Statemachine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:298:1: ( rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:299:2: rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3553);
            rule__Statemachine__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3556);
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


    // $ANTLR start rule__Statemachine__Group__3__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:306:1: rule__Statemachine__Group__3__Impl : ( 'commands' ) ;
    public final void rule__Statemachine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:310:1: ( ( 'commands' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:311:1: ( 'commands' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:311:1: ( 'commands' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:312:1: 'commands'
            {
             before(grammarAccess.getStatemachineAccess().getCommandsKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__Statemachine__Group__3__Impl584); 
             after(grammarAccess.getStatemachineAccess().getCommandsKeyword_3()); 

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
    // $ANTLR end rule__Statemachine__Group__3__Impl


    // $ANTLR start rule__Statemachine__Group__4
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:325:1: rule__Statemachine__Group__4 : rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 ;
    public final void rule__Statemachine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:329:1: ( rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:330:2: rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4615);
            rule__Statemachine__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4618);
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


    // $ANTLR start rule__Statemachine__Group__4__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:337:1: rule__Statemachine__Group__4__Impl : ( ( rule__Statemachine__CommandsAssignment_4 )* ) ;
    public final void rule__Statemachine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:341:1: ( ( ( rule__Statemachine__CommandsAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:342:1: ( ( rule__Statemachine__CommandsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:342:1: ( ( rule__Statemachine__CommandsAssignment_4 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:343:1: ( rule__Statemachine__CommandsAssignment_4 )*
            {
             before(grammarAccess.getStatemachineAccess().getCommandsAssignment_4()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:344:1: ( rule__Statemachine__CommandsAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:344:2: rule__Statemachine__CommandsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__CommandsAssignment_4_in_rule__Statemachine__Group__4__Impl645);
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
    // $ANTLR end rule__Statemachine__Group__4__Impl


    // $ANTLR start rule__Statemachine__Group__5
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:354:1: rule__Statemachine__Group__5 : rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 ;
    public final void rule__Statemachine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:358:1: ( rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:359:2: rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__5__Impl_in_rule__Statemachine__Group__5676);
            rule__Statemachine__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__5679);
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


    // $ANTLR start rule__Statemachine__Group__5__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:366:1: rule__Statemachine__Group__5__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:370:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:371:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:371:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:372:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_5()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group__5__Impl707); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_5()); 

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
    // $ANTLR end rule__Statemachine__Group__5__Impl


    // $ANTLR start rule__Statemachine__Group__6
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:385:1: rule__Statemachine__Group__6 : rule__Statemachine__Group__6__Impl ;
    public final void rule__Statemachine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:389:1: ( rule__Statemachine__Group__6__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:390:2: rule__Statemachine__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__6738);
            rule__Statemachine__Group__6__Impl();
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
    // $ANTLR end rule__Statemachine__Group__6


    // $ANTLR start rule__Statemachine__Group__6__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:396:1: rule__Statemachine__Group__6__Impl : ( ( rule__Statemachine__StatesAssignment_6 )* ) ;
    public final void rule__Statemachine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:400:1: ( ( ( rule__Statemachine__StatesAssignment_6 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:401:1: ( ( rule__Statemachine__StatesAssignment_6 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:401:1: ( ( rule__Statemachine__StatesAssignment_6 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:402:1: ( rule__Statemachine__StatesAssignment_6 )*
            {
             before(grammarAccess.getStatemachineAccess().getStatesAssignment_6()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:403:1: ( rule__Statemachine__StatesAssignment_6 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:403:2: rule__Statemachine__StatesAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__StatesAssignment_6_in_rule__Statemachine__Group__6__Impl765);
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
    // $ANTLR end rule__Statemachine__Group__6__Impl


    // $ANTLR start rule__Event__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:427:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:431:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:432:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__0810);
            rule__Event__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0813);
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


    // $ANTLR start rule__Event__Group__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:439:1: rule__Event__Group__0__Impl : ( ( rule__Event__ResettingAssignment_0 )? ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:443:1: ( ( ( rule__Event__ResettingAssignment_0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:444:1: ( ( rule__Event__ResettingAssignment_0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:444:1: ( ( rule__Event__ResettingAssignment_0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:445:1: ( rule__Event__ResettingAssignment_0 )?
            {
             before(grammarAccess.getEventAccess().getResettingAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:446:1: ( rule__Event__ResettingAssignment_0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:446:2: rule__Event__ResettingAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0__Impl840);
                    rule__Event__ResettingAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventAccess().getResettingAssignment_0()); 

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
    // $ANTLR end rule__Event__Group__0__Impl


    // $ANTLR start rule__Event__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:456:1: rule__Event__Group__1 : rule__Event__Group__1__Impl rule__Event__Group__2 ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:460:1: ( rule__Event__Group__1__Impl rule__Event__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:461:2: rule__Event__Group__1__Impl rule__Event__Group__2
            {
            pushFollow(FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__1871);
            rule__Event__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1874);
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


    // $ANTLR start rule__Event__Group__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:468:1: rule__Event__Group__1__Impl : ( ( rule__Event__NameAssignment_1 ) ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:472:1: ( ( ( rule__Event__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:473:1: ( ( rule__Event__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:473:1: ( ( rule__Event__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:474:1: ( rule__Event__NameAssignment_1 )
            {
             before(grammarAccess.getEventAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:475:1: ( rule__Event__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:475:2: rule__Event__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1__Impl901);
            rule__Event__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEventAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__Event__Group__1__Impl


    // $ANTLR start rule__Event__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:485:1: rule__Event__Group__2 : rule__Event__Group__2__Impl ;
    public final void rule__Event__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:489:1: ( rule__Event__Group__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:490:2: rule__Event__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group__2__Impl_in_rule__Event__Group__2931);
            rule__Event__Group__2__Impl();
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
    // $ANTLR end rule__Event__Group__2


    // $ANTLR start rule__Event__Group__2__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:496:1: rule__Event__Group__2__Impl : ( ( rule__Event__CodeAssignment_2 ) ) ;
    public final void rule__Event__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:500:1: ( ( ( rule__Event__CodeAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:501:1: ( ( rule__Event__CodeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:501:1: ( ( rule__Event__CodeAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:502:1: ( rule__Event__CodeAssignment_2 )
            {
             before(grammarAccess.getEventAccess().getCodeAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:503:1: ( rule__Event__CodeAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:503:2: rule__Event__CodeAssignment_2
            {
            pushFollow(FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2__Impl958);
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
    // $ANTLR end rule__Event__Group__2__Impl


    // $ANTLR start rule__Command__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:519:1: rule__Command__Group__0 : rule__Command__Group__0__Impl rule__Command__Group__1 ;
    public final void rule__Command__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:523:1: ( rule__Command__Group__0__Impl rule__Command__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:524:2: rule__Command__Group__0__Impl rule__Command__Group__1
            {
            pushFollow(FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__0994);
            rule__Command__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Command__Group__1_in_rule__Command__Group__0997);
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


    // $ANTLR start rule__Command__Group__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:531:1: rule__Command__Group__0__Impl : ( ( rule__Command__NameAssignment_0 ) ) ;
    public final void rule__Command__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:535:1: ( ( ( rule__Command__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:536:1: ( ( rule__Command__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:536:1: ( ( rule__Command__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:537:1: ( rule__Command__NameAssignment_0 )
            {
             before(grammarAccess.getCommandAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:538:1: ( rule__Command__NameAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:538:2: rule__Command__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1024);
            rule__Command__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getNameAssignment_0()); 

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
    // $ANTLR end rule__Command__Group__0__Impl


    // $ANTLR start rule__Command__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:548:1: rule__Command__Group__1 : rule__Command__Group__1__Impl ;
    public final void rule__Command__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:552:1: ( rule__Command__Group__1__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:553:2: rule__Command__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11054);
            rule__Command__Group__1__Impl();
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
    // $ANTLR end rule__Command__Group__1


    // $ANTLR start rule__Command__Group__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:559:1: rule__Command__Group__1__Impl : ( ( rule__Command__CodeAssignment_1 ) ) ;
    public final void rule__Command__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:563:1: ( ( ( rule__Command__CodeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:564:1: ( ( rule__Command__CodeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:564:1: ( ( rule__Command__CodeAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:565:1: ( rule__Command__CodeAssignment_1 )
            {
             before(grammarAccess.getCommandAccess().getCodeAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:566:1: ( rule__Command__CodeAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:566:2: rule__Command__CodeAssignment_1
            {
            pushFollow(FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1081);
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
    // $ANTLR end rule__Command__Group__1__Impl


    // $ANTLR start rule__State__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:580:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:584:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:585:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01115);
            rule__State__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__1_in_rule__State__Group__01118);
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


    // $ANTLR start rule__State__Group__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:592:1: rule__State__Group__0__Impl : ( 'state' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:596:1: ( ( 'state' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:597:1: ( 'state' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:597:1: ( 'state' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:598:1: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__State__Group__0__Impl1146); 
             after(grammarAccess.getStateAccess().getStateKeyword_0()); 

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
    // $ANTLR end rule__State__Group__0__Impl


    // $ANTLR start rule__State__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:611:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:615:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:616:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11177);
            rule__State__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__2_in_rule__State__Group__11180);
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


    // $ANTLR start rule__State__Group__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:623:1: rule__State__Group__1__Impl : ( ( rule__State__NameAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:627:1: ( ( ( rule__State__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:628:1: ( ( rule__State__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:628:1: ( ( rule__State__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:629:1: ( rule__State__NameAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:630:1: ( rule__State__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:630:2: rule__State__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1207);
            rule__State__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__State__Group__1__Impl


    // $ANTLR start rule__State__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:640:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:644:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:645:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21237);
            rule__State__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__3_in_rule__State__Group__21240);
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


    // $ANTLR start rule__State__Group__2__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:652:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:656:1: ( ( ( rule__State__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:657:1: ( ( rule__State__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:657:1: ( ( rule__State__Group_2__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:658:1: ( rule__State__Group_2__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:659:1: ( rule__State__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:659:2: rule__State__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1267);
                    rule__State__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_2()); 

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
    // $ANTLR end rule__State__Group__2__Impl


    // $ANTLR start rule__State__Group__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:669:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:673:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:674:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31298);
            rule__State__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__4_in_rule__State__Group__31301);
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


    // $ANTLR start rule__State__Group__3__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:681:1: rule__State__Group__3__Impl : ( ( rule__State__TransitionsAssignment_3 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:685:1: ( ( ( rule__State__TransitionsAssignment_3 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:686:1: ( ( rule__State__TransitionsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:686:1: ( ( rule__State__TransitionsAssignment_3 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:687:1: ( rule__State__TransitionsAssignment_3 )*
            {
             before(grammarAccess.getStateAccess().getTransitionsAssignment_3()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:688:1: ( rule__State__TransitionsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:688:2: rule__State__TransitionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1328);
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
    // $ANTLR end rule__State__Group__3__Impl


    // $ANTLR start rule__State__Group__4
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:698:1: rule__State__Group__4 : rule__State__Group__4__Impl ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:702:1: ( rule__State__Group__4__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:703:2: rule__State__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41359);
            rule__State__Group__4__Impl();
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
    // $ANTLR end rule__State__Group__4


    // $ANTLR start rule__State__Group__4__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:709:1: rule__State__Group__4__Impl : ( 'end' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:713:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:714:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:714:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:715:1: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__State__Group__4__Impl1387); 
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
    // $ANTLR end rule__State__Group__4__Impl


    // $ANTLR start rule__State__Group_2__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:738:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:742:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:743:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
            {
            pushFollow(FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01428);
            rule__State__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01431);
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


    // $ANTLR start rule__State__Group_2__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:750:1: rule__State__Group_2__0__Impl : ( 'actions' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:754:1: ( ( 'actions' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:755:1: ( 'actions' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:755:1: ( 'actions' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:756:1: 'actions'
            {
             before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 
            match(input,15,FOLLOW_15_in_rule__State__Group_2__0__Impl1459); 
             after(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 

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
    // $ANTLR end rule__State__Group_2__0__Impl


    // $ANTLR start rule__State__Group_2__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:769:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl rule__State__Group_2__2 ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:773:1: ( rule__State__Group_2__1__Impl rule__State__Group_2__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:774:2: rule__State__Group_2__1__Impl rule__State__Group_2__2
            {
            pushFollow(FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11490);
            rule__State__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11493);
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


    // $ANTLR start rule__State__Group_2__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:781:1: rule__State__Group_2__1__Impl : ( '{' ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:785:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:786:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:786:1: ( '{' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:787:1: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,16,FOLLOW_16_in_rule__State__Group_2__1__Impl1521); 
             after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 

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
    // $ANTLR end rule__State__Group_2__1__Impl


    // $ANTLR start rule__State__Group_2__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:800:1: rule__State__Group_2__2 : rule__State__Group_2__2__Impl rule__State__Group_2__3 ;
    public final void rule__State__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:804:1: ( rule__State__Group_2__2__Impl rule__State__Group_2__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:805:2: rule__State__Group_2__2__Impl rule__State__Group_2__3
            {
            pushFollow(FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21552);
            rule__State__Group_2__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21555);
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


    // $ANTLR start rule__State__Group_2__2__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:812:1: rule__State__Group_2__2__Impl : ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) ;
    public final void rule__State__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:816:1: ( ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:817:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:817:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:818:1: ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:818:1: ( ( rule__State__ActionsAssignment_2_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:819:1: ( rule__State__ActionsAssignment_2_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:820:1: ( rule__State__ActionsAssignment_2_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:820:2: rule__State__ActionsAssignment_2_2
            {
            pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1584);
            rule__State__ActionsAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:823:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:824:1: ( rule__State__ActionsAssignment_2_2 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:825:1: ( rule__State__ActionsAssignment_2_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:825:2: rule__State__ActionsAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1596);
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
    // $ANTLR end rule__State__Group_2__2__Impl


    // $ANTLR start rule__State__Group_2__3
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:836:1: rule__State__Group_2__3 : rule__State__Group_2__3__Impl ;
    public final void rule__State__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:840:1: ( rule__State__Group_2__3__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:841:2: rule__State__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__31629);
            rule__State__Group_2__3__Impl();
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
    // $ANTLR end rule__State__Group_2__3


    // $ANTLR start rule__State__Group_2__3__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:847:1: rule__State__Group_2__3__Impl : ( '}' ) ;
    public final void rule__State__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:851:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:852:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:852:1: ( '}' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:853:1: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,17,FOLLOW_17_in_rule__State__Group_2__3__Impl1657); 
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
    // $ANTLR end rule__State__Group_2__3__Impl


    // $ANTLR start rule__Transition__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:874:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:878:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:879:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01696);
            rule__Transition__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01699);
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


    // $ANTLR start rule__Transition__Group__0__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:886:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__EventAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:890:1: ( ( ( rule__Transition__EventAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:891:1: ( ( rule__Transition__EventAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:891:1: ( ( rule__Transition__EventAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:892:1: ( rule__Transition__EventAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:893:1: ( rule__Transition__EventAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:893:2: rule__Transition__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl1726);
            rule__Transition__EventAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getTransitionAccess().getEventAssignment_0()); 

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
    // $ANTLR end rule__Transition__Group__0__Impl


    // $ANTLR start rule__Transition__Group__1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:903:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:907:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:908:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11756);
            rule__Transition__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11759);
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


    // $ANTLR start rule__Transition__Group__1__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:915:1: rule__Transition__Group__1__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:919:1: ( ( '=>' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:920:1: ( '=>' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:920:1: ( '=>' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:921:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,18,FOLLOW_18_in_rule__Transition__Group__1__Impl1787); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 

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
    // $ANTLR end rule__Transition__Group__1__Impl


    // $ANTLR start rule__Transition__Group__2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:934:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:938:1: ( rule__Transition__Group__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:939:2: rule__Transition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21818);
            rule__Transition__Group__2__Impl();
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
    // $ANTLR end rule__Transition__Group__2


    // $ANTLR start rule__Transition__Group__2__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:945:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__StateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:949:1: ( ( ( rule__Transition__StateAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:950:1: ( ( rule__Transition__StateAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:950:1: ( ( rule__Transition__StateAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:951:1: ( rule__Transition__StateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getStateAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:952:1: ( rule__Transition__StateAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:952:2: rule__Transition__StateAssignment_2
            {
            pushFollow(FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl1845);
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
    // $ANTLR end rule__Transition__Group__2__Impl


    // $ANTLR start rule__Statemachine__EventsAssignment_1
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:969:1: rule__Statemachine__EventsAssignment_1 : ( ruleEvent ) ;
    public final void rule__Statemachine__EventsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:973:1: ( ( ruleEvent ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:974:1: ( ruleEvent )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:974:1: ( ruleEvent )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:975:1: ruleEvent
            {
             before(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_11886);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:984:1: rule__Statemachine__CommandsAssignment_4 : ( ruleCommand ) ;
    public final void rule__Statemachine__CommandsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:988:1: ( ( ruleCommand ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:989:1: ( ruleCommand )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:989:1: ( ruleCommand )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:990:1: ruleCommand
            {
             before(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_41917);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:999:1: rule__Statemachine__StatesAssignment_6 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1003:1: ( ( ruleState ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1004:1: ( ruleState )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1004:1: ( ruleState )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1005:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_61948);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1014:1: rule__Event__ResettingAssignment_0 : ( ( 'resetting' ) ) ;
    public final void rule__Event__ResettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1018:1: ( ( ( 'resetting' ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1019:1: ( ( 'resetting' ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1019:1: ( ( 'resetting' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1020:1: ( 'resetting' )
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1021:1: ( 'resetting' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1022:1: 'resetting'
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            match(input,19,FOLLOW_19_in_rule__Event__ResettingAssignment_01984); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1037:1: rule__Event__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1041:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1042:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1042:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1043:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__NameAssignment_12023); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1052:1: rule__Event__CodeAssignment_2 : ( RULE_ID ) ;
    public final void rule__Event__CodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1056:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1057:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1057:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1058:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_22054); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1067:1: rule__Command__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Command__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1071:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1072:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1072:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1073:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02085); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1082:1: rule__Command__CodeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Command__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1086:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1087:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1087:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1088:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12116); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1097:1: rule__State__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1101:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1102:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1102:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1103:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__NameAssignment_12147); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1112:1: rule__State__ActionsAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__State__ActionsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1116:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1117:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1117:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1118:1: ( RULE_ID )
            {
             before(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1119:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1120:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22182); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1131:1: rule__State__TransitionsAssignment_3 : ( ruleTransition ) ;
    public final void rule__State__TransitionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1135:1: ( ( ruleTransition ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1136:1: ( ruleTransition )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1136:1: ( ruleTransition )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1137:1: ruleTransition
            {
             before(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32217);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1146:1: rule__Transition__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1150:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1151:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1151:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1152:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1153:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1154:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02252); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1165:1: rule__Transition__StateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__StateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1169:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1170:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1170:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1171:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1172:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1173:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22291); 
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


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__0_in_ruleEvent154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0_in_ruleCommand214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0_in_ruleState274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0_in_ruleTransition334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0368 = new BitSet(new long[]{0x0000000000081010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Statemachine__Group__0__Impl399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1430 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_1_in_rule__Statemachine__Group__1__Impl460 = new BitSet(new long[]{0x0000000000080012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2491 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__2__Impl522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3553 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Statemachine__Group__3__Impl584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4615 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__CommandsAssignment_4_in_rule__Statemachine__Group__4__Impl645 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5__Impl_in_rule__Statemachine__Group__5676 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__5__Impl707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__6738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_6_in_rule__Statemachine__Group__6__Impl765 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__0810 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0__Impl840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__1871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1__Impl901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__2__Impl_in_rule__Event__Group__2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2__Impl958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__0994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Command__Group__1_in_rule__Command__Group__0997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__01118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__State__Group__0__Impl1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11177 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__11180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21237 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__21240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31298 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__State__Group__4_in_rule__State__Group__31301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1328 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__State__Group__4__Impl1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01428 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__State__Group_2__0__Impl1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__State__Group_2__1__Impl1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1584 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1596 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__31629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__State__Group_2__3__Impl1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01696 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transition__Group__1__Impl1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_11886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_41917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_61948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Event__ResettingAssignment_01984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__NameAssignment_12023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_22054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__NameAssignment_12147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22291 = new BitSet(new long[]{0x0000000000000002L});

}