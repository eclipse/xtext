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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:215:1: rule__Statemachine__Group__0__Impl : ( () ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:219:1: ( ( () ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:220:1: ( () )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:220:1: ( () )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:221:1: ()
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:222:1: ()
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:224:1: 
            {
            }

             after(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 

            }


            }

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
            pushFollow(FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1429);
            rule__Statemachine__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1432);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:246:1: rule__Statemachine__Group__1__Impl : ( 'events' ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:250:1: ( ( 'events' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:251:1: ( 'events' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:251:1: ( 'events' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:252:1: 'events'
            {
             before(grammarAccess.getStatemachineAccess().getEventsKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__Statemachine__Group__1__Impl460); 
             after(grammarAccess.getStatemachineAccess().getEventsKeyword_1()); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:265:1: rule__Statemachine__Group__2 : rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:269:1: ( rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:270:2: rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:277:1: rule__Statemachine__Group__2__Impl : ( ( rule__Statemachine__EventsAssignment_2 )* ) ;
    public final void rule__Statemachine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:281:1: ( ( ( rule__Statemachine__EventsAssignment_2 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:282:1: ( ( rule__Statemachine__EventsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:282:1: ( ( rule__Statemachine__EventsAssignment_2 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:283:1: ( rule__Statemachine__EventsAssignment_2 )*
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:284:1: ( rule__Statemachine__EventsAssignment_2 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:284:2: rule__Statemachine__EventsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__EventsAssignment_2_in_rule__Statemachine__Group__2__Impl521);
            	    rule__Statemachine__EventsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getEventsAssignment_2()); 

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
            pushFollow(FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3552);
            rule__Statemachine__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3555);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:306:1: rule__Statemachine__Group__3__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:310:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:311:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:311:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:312:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group__3__Impl583); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_3()); 

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
            pushFollow(FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4614);
            rule__Statemachine__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4617);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:337:1: rule__Statemachine__Group__4__Impl : ( 'commands' ) ;
    public final void rule__Statemachine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:341:1: ( ( 'commands' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:342:1: ( 'commands' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:342:1: ( 'commands' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:343:1: 'commands'
            {
             before(grammarAccess.getStatemachineAccess().getCommandsKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__Statemachine__Group__4__Impl645); 
             after(grammarAccess.getStatemachineAccess().getCommandsKeyword_4()); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:356:1: rule__Statemachine__Group__5 : rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 ;
    public final void rule__Statemachine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:360:1: ( rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:361:2: rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:368:1: rule__Statemachine__Group__5__Impl : ( ( rule__Statemachine__CommandsAssignment_5 )* ) ;
    public final void rule__Statemachine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:372:1: ( ( ( rule__Statemachine__CommandsAssignment_5 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:373:1: ( ( rule__Statemachine__CommandsAssignment_5 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:373:1: ( ( rule__Statemachine__CommandsAssignment_5 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:374:1: ( rule__Statemachine__CommandsAssignment_5 )*
            {
             before(grammarAccess.getStatemachineAccess().getCommandsAssignment_5()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:375:1: ( rule__Statemachine__CommandsAssignment_5 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:375:2: rule__Statemachine__CommandsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__CommandsAssignment_5_in_rule__Statemachine__Group__5__Impl706);
            	    rule__Statemachine__CommandsAssignment_5();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getCommandsAssignment_5()); 

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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:385:1: rule__Statemachine__Group__6 : rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 ;
    public final void rule__Statemachine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:389:1: ( rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:390:2: rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__6737);
            rule__Statemachine__Group__6__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__7_in_rule__Statemachine__Group__6740);
            rule__Statemachine__Group__7();
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:397:1: rule__Statemachine__Group__6__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:401:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:402:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:402:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:403:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_6()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group__6__Impl768); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_6()); 

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


    // $ANTLR start rule__Statemachine__Group__7
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:416:1: rule__Statemachine__Group__7 : rule__Statemachine__Group__7__Impl ;
    public final void rule__Statemachine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:420:1: ( rule__Statemachine__Group__7__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:421:2: rule__Statemachine__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__7__Impl_in_rule__Statemachine__Group__7799);
            rule__Statemachine__Group__7__Impl();
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
    // $ANTLR end rule__Statemachine__Group__7


    // $ANTLR start rule__Statemachine__Group__7__Impl
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:427:1: rule__Statemachine__Group__7__Impl : ( ( rule__Statemachine__StatesAssignment_7 )* ) ;
    public final void rule__Statemachine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:431:1: ( ( ( rule__Statemachine__StatesAssignment_7 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:432:1: ( ( rule__Statemachine__StatesAssignment_7 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:432:1: ( ( rule__Statemachine__StatesAssignment_7 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:433:1: ( rule__Statemachine__StatesAssignment_7 )*
            {
             before(grammarAccess.getStatemachineAccess().getStatesAssignment_7()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:434:1: ( rule__Statemachine__StatesAssignment_7 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:434:2: rule__Statemachine__StatesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__StatesAssignment_7_in_rule__Statemachine__Group__7__Impl826);
            	    rule__Statemachine__StatesAssignment_7();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getStatesAssignment_7()); 

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
    // $ANTLR end rule__Statemachine__Group__7__Impl


    // $ANTLR start rule__Event__Group__0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:460:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:464:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:465:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__0873);
            rule__Event__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0876);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:472:1: rule__Event__Group__0__Impl : ( ( rule__Event__ResettingAssignment_0 )? ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:476:1: ( ( ( rule__Event__ResettingAssignment_0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:477:1: ( ( rule__Event__ResettingAssignment_0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:477:1: ( ( rule__Event__ResettingAssignment_0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:478:1: ( rule__Event__ResettingAssignment_0 )?
            {
             before(grammarAccess.getEventAccess().getResettingAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:479:1: ( rule__Event__ResettingAssignment_0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:479:2: rule__Event__ResettingAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0__Impl903);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:489:1: rule__Event__Group__1 : rule__Event__Group__1__Impl rule__Event__Group__2 ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:493:1: ( rule__Event__Group__1__Impl rule__Event__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:494:2: rule__Event__Group__1__Impl rule__Event__Group__2
            {
            pushFollow(FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__1934);
            rule__Event__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1937);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:501:1: rule__Event__Group__1__Impl : ( ( rule__Event__NameAssignment_1 ) ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:505:1: ( ( ( rule__Event__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:506:1: ( ( rule__Event__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:506:1: ( ( rule__Event__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:507:1: ( rule__Event__NameAssignment_1 )
            {
             before(grammarAccess.getEventAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:508:1: ( rule__Event__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:508:2: rule__Event__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1__Impl964);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:518:1: rule__Event__Group__2 : rule__Event__Group__2__Impl ;
    public final void rule__Event__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:522:1: ( rule__Event__Group__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:523:2: rule__Event__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group__2__Impl_in_rule__Event__Group__2994);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:529:1: rule__Event__Group__2__Impl : ( ( rule__Event__CodeAssignment_2 ) ) ;
    public final void rule__Event__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:533:1: ( ( ( rule__Event__CodeAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:534:1: ( ( rule__Event__CodeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:534:1: ( ( rule__Event__CodeAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:535:1: ( rule__Event__CodeAssignment_2 )
            {
             before(grammarAccess.getEventAccess().getCodeAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:536:1: ( rule__Event__CodeAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:536:2: rule__Event__CodeAssignment_2
            {
            pushFollow(FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2__Impl1021);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:552:1: rule__Command__Group__0 : rule__Command__Group__0__Impl rule__Command__Group__1 ;
    public final void rule__Command__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:556:1: ( rule__Command__Group__0__Impl rule__Command__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:557:2: rule__Command__Group__0__Impl rule__Command__Group__1
            {
            pushFollow(FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01057);
            rule__Command__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01060);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:564:1: rule__Command__Group__0__Impl : ( ( rule__Command__NameAssignment_0 ) ) ;
    public final void rule__Command__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:568:1: ( ( ( rule__Command__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:569:1: ( ( rule__Command__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:569:1: ( ( rule__Command__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:570:1: ( rule__Command__NameAssignment_0 )
            {
             before(grammarAccess.getCommandAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:571:1: ( rule__Command__NameAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:571:2: rule__Command__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1087);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:581:1: rule__Command__Group__1 : rule__Command__Group__1__Impl ;
    public final void rule__Command__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:585:1: ( rule__Command__Group__1__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:586:2: rule__Command__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11117);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:592:1: rule__Command__Group__1__Impl : ( ( rule__Command__CodeAssignment_1 ) ) ;
    public final void rule__Command__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:596:1: ( ( ( rule__Command__CodeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:597:1: ( ( rule__Command__CodeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:597:1: ( ( rule__Command__CodeAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:598:1: ( rule__Command__CodeAssignment_1 )
            {
             before(grammarAccess.getCommandAccess().getCodeAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:599:1: ( rule__Command__CodeAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:599:2: rule__Command__CodeAssignment_1
            {
            pushFollow(FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1144);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:613:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:617:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:618:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01178);
            rule__State__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__1_in_rule__State__Group__01181);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:625:1: rule__State__Group__0__Impl : ( 'state' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:629:1: ( ( 'state' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:630:1: ( 'state' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:630:1: ( 'state' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:631:1: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__State__Group__0__Impl1209); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:644:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:648:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:649:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11240);
            rule__State__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__2_in_rule__State__Group__11243);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:656:1: rule__State__Group__1__Impl : ( ( rule__State__NameAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:660:1: ( ( ( rule__State__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:661:1: ( ( rule__State__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:661:1: ( ( rule__State__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:662:1: ( rule__State__NameAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:663:1: ( rule__State__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:663:2: rule__State__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1270);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:673:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:677:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:678:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21300);
            rule__State__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__3_in_rule__State__Group__21303);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:685:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:689:1: ( ( ( rule__State__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:690:1: ( ( rule__State__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:690:1: ( ( rule__State__Group_2__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:691:1: ( rule__State__Group_2__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:692:1: ( rule__State__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:692:2: rule__State__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1330);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:702:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:706:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:707:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31361);
            rule__State__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group__4_in_rule__State__Group__31364);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:714:1: rule__State__Group__3__Impl : ( ( rule__State__TransitionsAssignment_3 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:718:1: ( ( ( rule__State__TransitionsAssignment_3 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:719:1: ( ( rule__State__TransitionsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:719:1: ( ( rule__State__TransitionsAssignment_3 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:720:1: ( rule__State__TransitionsAssignment_3 )*
            {
             before(grammarAccess.getStateAccess().getTransitionsAssignment_3()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:721:1: ( rule__State__TransitionsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:721:2: rule__State__TransitionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1391);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:731:1: rule__State__Group__4 : rule__State__Group__4__Impl ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:735:1: ( rule__State__Group__4__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:736:2: rule__State__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41422);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:742:1: rule__State__Group__4__Impl : ( 'end' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:746:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:747:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:747:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:748:1: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__State__Group__4__Impl1450); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:771:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:775:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:776:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
            {
            pushFollow(FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01491);
            rule__State__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01494);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:783:1: rule__State__Group_2__0__Impl : ( 'actions' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:787:1: ( ( 'actions' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:788:1: ( 'actions' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:788:1: ( 'actions' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:789:1: 'actions'
            {
             before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 
            match(input,15,FOLLOW_15_in_rule__State__Group_2__0__Impl1522); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:802:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl rule__State__Group_2__2 ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:806:1: ( rule__State__Group_2__1__Impl rule__State__Group_2__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:807:2: rule__State__Group_2__1__Impl rule__State__Group_2__2
            {
            pushFollow(FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11553);
            rule__State__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11556);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:814:1: rule__State__Group_2__1__Impl : ( '{' ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:818:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:819:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:819:1: ( '{' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:820:1: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,16,FOLLOW_16_in_rule__State__Group_2__1__Impl1584); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:833:1: rule__State__Group_2__2 : rule__State__Group_2__2__Impl rule__State__Group_2__3 ;
    public final void rule__State__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:837:1: ( rule__State__Group_2__2__Impl rule__State__Group_2__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:838:2: rule__State__Group_2__2__Impl rule__State__Group_2__3
            {
            pushFollow(FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21615);
            rule__State__Group_2__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21618);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:845:1: rule__State__Group_2__2__Impl : ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) ;
    public final void rule__State__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:849:1: ( ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:850:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:850:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:851:1: ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:851:1: ( ( rule__State__ActionsAssignment_2_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:852:1: ( rule__State__ActionsAssignment_2_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:853:1: ( rule__State__ActionsAssignment_2_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:853:2: rule__State__ActionsAssignment_2_2
            {
            pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1647);
            rule__State__ActionsAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:856:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:857:1: ( rule__State__ActionsAssignment_2_2 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:858:1: ( rule__State__ActionsAssignment_2_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:858:2: rule__State__ActionsAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1659);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:869:1: rule__State__Group_2__3 : rule__State__Group_2__3__Impl ;
    public final void rule__State__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:873:1: ( rule__State__Group_2__3__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:874:2: rule__State__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__31692);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:880:1: rule__State__Group_2__3__Impl : ( '}' ) ;
    public final void rule__State__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:884:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:885:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:885:1: ( '}' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:886:1: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,17,FOLLOW_17_in_rule__State__Group_2__3__Impl1720); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:907:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:911:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:912:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01759);
            rule__Transition__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01762);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:919:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__EventAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:923:1: ( ( ( rule__Transition__EventAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:924:1: ( ( rule__Transition__EventAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:924:1: ( ( rule__Transition__EventAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:925:1: ( rule__Transition__EventAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:926:1: ( rule__Transition__EventAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:926:2: rule__Transition__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl1789);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:936:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:940:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:941:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11819);
            rule__Transition__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11822);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:948:1: rule__Transition__Group__1__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:952:1: ( ( '=>' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:953:1: ( '=>' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:953:1: ( '=>' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:954:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,18,FOLLOW_18_in_rule__Transition__Group__1__Impl1850); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:967:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:971:1: ( rule__Transition__Group__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:972:2: rule__Transition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21881);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:978:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__StateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:982:1: ( ( ( rule__Transition__StateAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:983:1: ( ( rule__Transition__StateAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:983:1: ( ( rule__Transition__StateAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:984:1: ( rule__Transition__StateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getStateAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:985:1: ( rule__Transition__StateAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:985:2: rule__Transition__StateAssignment_2
            {
            pushFollow(FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl1908);
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


    // $ANTLR start rule__Statemachine__EventsAssignment_2
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1002:1: rule__Statemachine__EventsAssignment_2 : ( ruleEvent ) ;
    public final void rule__Statemachine__EventsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1006:1: ( ( ruleEvent ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1007:1: ( ruleEvent )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1007:1: ( ruleEvent )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1008:1: ruleEvent
            {
             before(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_21949);
            ruleEvent();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_2_0()); 

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
    // $ANTLR end rule__Statemachine__EventsAssignment_2


    // $ANTLR start rule__Statemachine__CommandsAssignment_5
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1017:1: rule__Statemachine__CommandsAssignment_5 : ( ruleCommand ) ;
    public final void rule__Statemachine__CommandsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1021:1: ( ( ruleCommand ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1022:1: ( ruleCommand )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1022:1: ( ruleCommand )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1023:1: ruleCommand
            {
             before(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_51980);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_5_0()); 

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
    // $ANTLR end rule__Statemachine__CommandsAssignment_5


    // $ANTLR start rule__Statemachine__StatesAssignment_7
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1032:1: rule__Statemachine__StatesAssignment_7 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1036:1: ( ( ruleState ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1037:1: ( ruleState )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1037:1: ( ruleState )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1038:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_72011);
            ruleState();
            _fsp--;

             after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_7_0()); 

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
    // $ANTLR end rule__Statemachine__StatesAssignment_7


    // $ANTLR start rule__Event__ResettingAssignment_0
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1047:1: rule__Event__ResettingAssignment_0 : ( ( 'resetting' ) ) ;
    public final void rule__Event__ResettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1051:1: ( ( ( 'resetting' ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1052:1: ( ( 'resetting' ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1052:1: ( ( 'resetting' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1053:1: ( 'resetting' )
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1054:1: ( 'resetting' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1055:1: 'resetting'
            {
             before(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0()); 
            match(input,19,FOLLOW_19_in_rule__Event__ResettingAssignment_02047); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1070:1: rule__Event__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1074:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1075:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1075:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1076:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__NameAssignment_12086); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1085:1: rule__Event__CodeAssignment_2 : ( RULE_ID ) ;
    public final void rule__Event__CodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1089:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1090:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1090:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1091:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_22117); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1100:1: rule__Command__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Command__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1104:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1105:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1105:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1106:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02148); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1115:1: rule__Command__CodeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Command__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1119:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1120:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1120:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1121:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12179); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1130:1: rule__State__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1134:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1135:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1135:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1136:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__NameAssignment_12210); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1145:1: rule__State__ActionsAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__State__ActionsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1149:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1150:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1150:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1151:1: ( RULE_ID )
            {
             before(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1152:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1153:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22245); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1164:1: rule__State__TransitionsAssignment_3 : ( ruleTransition ) ;
    public final void rule__State__TransitionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1168:1: ( ( ruleTransition ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1169:1: ( ruleTransition )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1169:1: ( ruleTransition )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1170:1: ruleTransition
            {
             before(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32280);
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1179:1: rule__Transition__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1183:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1184:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1184:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1185:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1186:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1187:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02315); 
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
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1198:1: rule__Transition__StateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__StateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1202:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1203:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1203:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1204:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1205:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalFowlerDsl.g:1206:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22354); 
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
    public static final BitSet FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0368 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1429 = new BitSet(new long[]{0x0000000000081010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Statemachine__Group__1__Impl460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2491 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_2_in_rule__Statemachine__Group__2__Impl521 = new BitSet(new long[]{0x0000000000080012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3552 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__3__Impl583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4614 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Statemachine__Group__4__Impl645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5__Impl_in_rule__Statemachine__Group__5676 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__CommandsAssignment_5_in_rule__Statemachine__Group__5__Impl706 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__6737 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__7_in_rule__Statemachine__Group__6740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__6__Impl768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__7__Impl_in_rule__Statemachine__Group__7799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_7_in_rule__Statemachine__Group__7__Impl826 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__0873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Event__Group__1_in_rule__Event__Group__0876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__ResettingAssignment_0_in_rule__Event__Group__0__Impl903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__1934 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Event__Group__2_in_rule__Event__Group__1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__NameAssignment_1_in_rule__Event__Group__1__Impl964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__2__Impl_in_rule__Event__Group__2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__CodeAssignment_2_in_rule__Event__Group__2__Impl1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__01181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__State__Group__0__Impl1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11240 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__11243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21300 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__21303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31361 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__State__Group__4_in_rule__State__Group__31364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1391 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__State__Group__4__Impl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01491 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__State__Group_2__0__Impl1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__State__Group_2__1__Impl1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21615 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1647 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl1659 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__31692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__State__Group_2__3__Impl1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01759 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transition__Group__1__Impl1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_21949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_51980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_72011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Event__ResettingAssignment_02047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__NameAssignment_12086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_22117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__NameAssignment_12210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22354 = new BitSet(new long[]{0x0000000000000002L});

}