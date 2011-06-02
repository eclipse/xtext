package org.eclipse.xtext.example.fowlerdsl.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStatemachineParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'resetEvents'", "'commands'", "'state'", "'actions'", "'{'", "'}'", "'=>'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalStatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g"; }


     
     	private StatemachineGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleStatemachine"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:61:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:62:1: ( ruleStatemachine EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:63:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine61);
            ruleStatemachine();

            state._fsp--;

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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:70:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:74:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:75:1: ( ( rule__Statemachine__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:75:1: ( ( rule__Statemachine__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:76:1: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:77:1: ( rule__Statemachine__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:77:2: rule__Statemachine__Group__0
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine94);
            rule__Statemachine__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:89:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:90:1: ( ruleEvent EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:91:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent121);
            ruleEvent();

            state._fsp--;

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:98:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:102:2: ( ( ( rule__Event__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:103:1: ( ( rule__Event__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:103:1: ( ( rule__Event__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:104:1: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:105:1: ( rule__Event__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:105:2: rule__Event__Group__0
            {
            pushFollow(FOLLOW_rule__Event__Group__0_in_ruleEvent154);
            rule__Event__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:117:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:118:1: ( ruleCommand EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:119:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand181);
            ruleCommand();

            state._fsp--;

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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:126:1: ruleCommand : ( ( rule__Command__Group__0 ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:130:2: ( ( ( rule__Command__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:131:1: ( ( rule__Command__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:131:1: ( ( rule__Command__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:132:1: ( rule__Command__Group__0 )
            {
             before(grammarAccess.getCommandAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:133:1: ( rule__Command__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:133:2: rule__Command__Group__0
            {
            pushFollow(FOLLOW_rule__Command__Group__0_in_ruleCommand214);
            rule__Command__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:145:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:146:1: ( ruleState EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:147:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState241);
            ruleState();

            state._fsp--;

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:154:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:158:2: ( ( ( rule__State__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:159:1: ( ( rule__State__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:159:1: ( ( rule__State__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:160:1: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:161:1: ( rule__State__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:161:2: rule__State__Group__0
            {
            pushFollow(FOLLOW_rule__State__Group__0_in_ruleState274);
            rule__State__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:173:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:174:1: ( ruleTransition EOF )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:175:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition301);
            ruleTransition();

            state._fsp--;

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:182:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:186:2: ( ( ( rule__Transition__Group__0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:187:1: ( ( rule__Transition__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:187:1: ( ( rule__Transition__Group__0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:188:1: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:189:1: ( rule__Transition__Group__0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:189:2: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_rule__Transition__Group__0_in_ruleTransition334);
            rule__Transition__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "rule__Statemachine__Group__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:203:1: rule__Statemachine__Group__0 : rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:207:1: ( rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:208:2: rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0368);
            rule__Statemachine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0371);
            rule__Statemachine__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group__0"


    // $ANTLR start "rule__Statemachine__Group__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:215:1: rule__Statemachine__Group__0__Impl : ( () ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:219:1: ( ( () ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:220:1: ( () )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:220:1: ( () )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:221:1: ()
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:222:1: ()
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:224:1: 
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
    // $ANTLR end "rule__Statemachine__Group__0__Impl"


    // $ANTLR start "rule__Statemachine__Group__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:234:1: rule__Statemachine__Group__1 : rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:238:1: ( rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:239:2: rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1429);
            rule__Statemachine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1432);
            rule__Statemachine__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group__1"


    // $ANTLR start "rule__Statemachine__Group__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:246:1: rule__Statemachine__Group__1__Impl : ( ( rule__Statemachine__Group_1__0 )? ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:250:1: ( ( ( rule__Statemachine__Group_1__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:251:1: ( ( rule__Statemachine__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:251:1: ( ( rule__Statemachine__Group_1__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:252:1: ( rule__Statemachine__Group_1__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:253:1: ( rule__Statemachine__Group_1__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:253:2: rule__Statemachine__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__Group_1__0_in_rule__Statemachine__Group__1__Impl459);
                    rule__Statemachine__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Statemachine__Group__1__Impl"


    // $ANTLR start "rule__Statemachine__Group__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:263:1: rule__Statemachine__Group__2 : rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:267:1: ( rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:268:2: rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2490);
            rule__Statemachine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2493);
            rule__Statemachine__Group__3();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group__2"


    // $ANTLR start "rule__Statemachine__Group__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:275:1: rule__Statemachine__Group__2__Impl : ( ( rule__Statemachine__Group_2__0 )? ) ;
    public final void rule__Statemachine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:279:1: ( ( ( rule__Statemachine__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:280:1: ( ( rule__Statemachine__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:280:1: ( ( rule__Statemachine__Group_2__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:281:1: ( rule__Statemachine__Group_2__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:282:1: ( rule__Statemachine__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:282:2: rule__Statemachine__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__Group_2__0_in_rule__Statemachine__Group__2__Impl520);
                    rule__Statemachine__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Statemachine__Group__2__Impl"


    // $ANTLR start "rule__Statemachine__Group__3"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:292:1: rule__Statemachine__Group__3 : rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 ;
    public final void rule__Statemachine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:296:1: ( rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:297:2: rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3551);
            rule__Statemachine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3554);
            rule__Statemachine__Group__4();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group__3"


    // $ANTLR start "rule__Statemachine__Group__3__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:304:1: rule__Statemachine__Group__3__Impl : ( ( rule__Statemachine__Group_3__0 )? ) ;
    public final void rule__Statemachine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:308:1: ( ( ( rule__Statemachine__Group_3__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:309:1: ( ( rule__Statemachine__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:309:1: ( ( rule__Statemachine__Group_3__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:310:1: ( rule__Statemachine__Group_3__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_3()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:311:1: ( rule__Statemachine__Group_3__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:311:2: rule__Statemachine__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__Group_3__0_in_rule__Statemachine__Group__3__Impl581);
                    rule__Statemachine__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Statemachine__Group__3__Impl"


    // $ANTLR start "rule__Statemachine__Group__4"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:321:1: rule__Statemachine__Group__4 : rule__Statemachine__Group__4__Impl ;
    public final void rule__Statemachine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:325:1: ( rule__Statemachine__Group__4__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:326:2: rule__Statemachine__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4612);
            rule__Statemachine__Group__4__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group__4"


    // $ANTLR start "rule__Statemachine__Group__4__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:332:1: rule__Statemachine__Group__4__Impl : ( ( rule__Statemachine__StatesAssignment_4 )* ) ;
    public final void rule__Statemachine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:336:1: ( ( ( rule__Statemachine__StatesAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:337:1: ( ( rule__Statemachine__StatesAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:337:1: ( ( rule__Statemachine__StatesAssignment_4 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:338:1: ( rule__Statemachine__StatesAssignment_4 )*
            {
             before(grammarAccess.getStatemachineAccess().getStatesAssignment_4()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:339:1: ( rule__Statemachine__StatesAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:339:2: rule__Statemachine__StatesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__StatesAssignment_4_in_rule__Statemachine__Group__4__Impl639);
            	    rule__Statemachine__StatesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getStatesAssignment_4()); 

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
    // $ANTLR end "rule__Statemachine__Group__4__Impl"


    // $ANTLR start "rule__Statemachine__Group_1__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:359:1: rule__Statemachine__Group_1__0 : rule__Statemachine__Group_1__0__Impl rule__Statemachine__Group_1__1 ;
    public final void rule__Statemachine__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:363:1: ( rule__Statemachine__Group_1__0__Impl rule__Statemachine__Group_1__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:364:2: rule__Statemachine__Group_1__0__Impl rule__Statemachine__Group_1__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_1__0__Impl_in_rule__Statemachine__Group_1__0680);
            rule__Statemachine__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_1__1_in_rule__Statemachine__Group_1__0683);
            rule__Statemachine__Group_1__1();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_1__0"


    // $ANTLR start "rule__Statemachine__Group_1__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:371:1: rule__Statemachine__Group_1__0__Impl : ( 'events' ) ;
    public final void rule__Statemachine__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:375:1: ( ( 'events' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:376:1: ( 'events' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:376:1: ( 'events' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:377:1: 'events'
            {
             before(grammarAccess.getStatemachineAccess().getEventsKeyword_1_0()); 
            match(input,11,FOLLOW_11_in_rule__Statemachine__Group_1__0__Impl711); 
             after(grammarAccess.getStatemachineAccess().getEventsKeyword_1_0()); 

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
    // $ANTLR end "rule__Statemachine__Group_1__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_1__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:390:1: rule__Statemachine__Group_1__1 : rule__Statemachine__Group_1__1__Impl rule__Statemachine__Group_1__2 ;
    public final void rule__Statemachine__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:394:1: ( rule__Statemachine__Group_1__1__Impl rule__Statemachine__Group_1__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:395:2: rule__Statemachine__Group_1__1__Impl rule__Statemachine__Group_1__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_1__1__Impl_in_rule__Statemachine__Group_1__1742);
            rule__Statemachine__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_1__2_in_rule__Statemachine__Group_1__1745);
            rule__Statemachine__Group_1__2();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_1__1"


    // $ANTLR start "rule__Statemachine__Group_1__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:402:1: rule__Statemachine__Group_1__1__Impl : ( ( ( rule__Statemachine__EventsAssignment_1_1 ) ) ( ( rule__Statemachine__EventsAssignment_1_1 )* ) ) ;
    public final void rule__Statemachine__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:406:1: ( ( ( ( rule__Statemachine__EventsAssignment_1_1 ) ) ( ( rule__Statemachine__EventsAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:407:1: ( ( ( rule__Statemachine__EventsAssignment_1_1 ) ) ( ( rule__Statemachine__EventsAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:407:1: ( ( ( rule__Statemachine__EventsAssignment_1_1 ) ) ( ( rule__Statemachine__EventsAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:408:1: ( ( rule__Statemachine__EventsAssignment_1_1 ) ) ( ( rule__Statemachine__EventsAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:408:1: ( ( rule__Statemachine__EventsAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:409:1: ( rule__Statemachine__EventsAssignment_1_1 )
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_1_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:410:1: ( rule__Statemachine__EventsAssignment_1_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:410:2: rule__Statemachine__EventsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Statemachine__EventsAssignment_1_1_in_rule__Statemachine__Group_1__1__Impl774);
            rule__Statemachine__EventsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getEventsAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:413:1: ( ( rule__Statemachine__EventsAssignment_1_1 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:414:1: ( rule__Statemachine__EventsAssignment_1_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_1_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:415:1: ( rule__Statemachine__EventsAssignment_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:415:2: rule__Statemachine__EventsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__EventsAssignment_1_1_in_rule__Statemachine__Group_1__1__Impl786);
            	    rule__Statemachine__EventsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getEventsAssignment_1_1()); 

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
    // $ANTLR end "rule__Statemachine__Group_1__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_1__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:426:1: rule__Statemachine__Group_1__2 : rule__Statemachine__Group_1__2__Impl ;
    public final void rule__Statemachine__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:430:1: ( rule__Statemachine__Group_1__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:431:2: rule__Statemachine__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_1__2__Impl_in_rule__Statemachine__Group_1__2819);
            rule__Statemachine__Group_1__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_1__2"


    // $ANTLR start "rule__Statemachine__Group_1__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:437:1: rule__Statemachine__Group_1__2__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:441:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:442:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:442:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:443:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_1_2()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group_1__2__Impl847); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_1_2()); 

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
    // $ANTLR end "rule__Statemachine__Group_1__2__Impl"


    // $ANTLR start "rule__Statemachine__Group_2__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:462:1: rule__Statemachine__Group_2__0 : rule__Statemachine__Group_2__0__Impl rule__Statemachine__Group_2__1 ;
    public final void rule__Statemachine__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:466:1: ( rule__Statemachine__Group_2__0__Impl rule__Statemachine__Group_2__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:467:2: rule__Statemachine__Group_2__0__Impl rule__Statemachine__Group_2__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_2__0__Impl_in_rule__Statemachine__Group_2__0884);
            rule__Statemachine__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_2__1_in_rule__Statemachine__Group_2__0887);
            rule__Statemachine__Group_2__1();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_2__0"


    // $ANTLR start "rule__Statemachine__Group_2__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:474:1: rule__Statemachine__Group_2__0__Impl : ( 'resetEvents' ) ;
    public final void rule__Statemachine__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:478:1: ( ( 'resetEvents' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:479:1: ( 'resetEvents' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:479:1: ( 'resetEvents' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:480:1: 'resetEvents'
            {
             before(grammarAccess.getStatemachineAccess().getResetEventsKeyword_2_0()); 
            match(input,13,FOLLOW_13_in_rule__Statemachine__Group_2__0__Impl915); 
             after(grammarAccess.getStatemachineAccess().getResetEventsKeyword_2_0()); 

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
    // $ANTLR end "rule__Statemachine__Group_2__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_2__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:493:1: rule__Statemachine__Group_2__1 : rule__Statemachine__Group_2__1__Impl rule__Statemachine__Group_2__2 ;
    public final void rule__Statemachine__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:497:1: ( rule__Statemachine__Group_2__1__Impl rule__Statemachine__Group_2__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:498:2: rule__Statemachine__Group_2__1__Impl rule__Statemachine__Group_2__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_2__1__Impl_in_rule__Statemachine__Group_2__1946);
            rule__Statemachine__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_2__2_in_rule__Statemachine__Group_2__1949);
            rule__Statemachine__Group_2__2();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_2__1"


    // $ANTLR start "rule__Statemachine__Group_2__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:505:1: rule__Statemachine__Group_2__1__Impl : ( ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) ) ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* ) ) ;
    public final void rule__Statemachine__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:509:1: ( ( ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) ) ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:510:1: ( ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) ) ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:510:1: ( ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) ) ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:511:1: ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) ) ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:511:1: ( ( rule__Statemachine__ResetEventsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:512:1: ( rule__Statemachine__ResetEventsAssignment_2_1 )
            {
             before(grammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:513:1: ( rule__Statemachine__ResetEventsAssignment_2_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:513:2: rule__Statemachine__ResetEventsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Statemachine__ResetEventsAssignment_2_1_in_rule__Statemachine__Group_2__1__Impl978);
            rule__Statemachine__ResetEventsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:516:1: ( ( rule__Statemachine__ResetEventsAssignment_2_1 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:517:1: ( rule__Statemachine__ResetEventsAssignment_2_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:518:1: ( rule__Statemachine__ResetEventsAssignment_2_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:518:2: rule__Statemachine__ResetEventsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__ResetEventsAssignment_2_1_in_rule__Statemachine__Group_2__1__Impl990);
            	    rule__Statemachine__ResetEventsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1()); 

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
    // $ANTLR end "rule__Statemachine__Group_2__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_2__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:529:1: rule__Statemachine__Group_2__2 : rule__Statemachine__Group_2__2__Impl ;
    public final void rule__Statemachine__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:533:1: ( rule__Statemachine__Group_2__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:534:2: rule__Statemachine__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_2__2__Impl_in_rule__Statemachine__Group_2__21023);
            rule__Statemachine__Group_2__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_2__2"


    // $ANTLR start "rule__Statemachine__Group_2__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:540:1: rule__Statemachine__Group_2__2__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:544:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:545:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:545:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:546:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_2_2()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group_2__2__Impl1051); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_2_2()); 

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
    // $ANTLR end "rule__Statemachine__Group_2__2__Impl"


    // $ANTLR start "rule__Statemachine__Group_3__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:565:1: rule__Statemachine__Group_3__0 : rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1 ;
    public final void rule__Statemachine__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:569:1: ( rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:570:2: rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_3__0__Impl_in_rule__Statemachine__Group_3__01088);
            rule__Statemachine__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_3__1_in_rule__Statemachine__Group_3__01091);
            rule__Statemachine__Group_3__1();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_3__0"


    // $ANTLR start "rule__Statemachine__Group_3__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:577:1: rule__Statemachine__Group_3__0__Impl : ( 'commands' ) ;
    public final void rule__Statemachine__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:581:1: ( ( 'commands' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:582:1: ( 'commands' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:582:1: ( 'commands' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:583:1: 'commands'
            {
             before(grammarAccess.getStatemachineAccess().getCommandsKeyword_3_0()); 
            match(input,14,FOLLOW_14_in_rule__Statemachine__Group_3__0__Impl1119); 
             after(grammarAccess.getStatemachineAccess().getCommandsKeyword_3_0()); 

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
    // $ANTLR end "rule__Statemachine__Group_3__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_3__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:596:1: rule__Statemachine__Group_3__1 : rule__Statemachine__Group_3__1__Impl rule__Statemachine__Group_3__2 ;
    public final void rule__Statemachine__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:600:1: ( rule__Statemachine__Group_3__1__Impl rule__Statemachine__Group_3__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:601:2: rule__Statemachine__Group_3__1__Impl rule__Statemachine__Group_3__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_3__1__Impl_in_rule__Statemachine__Group_3__11150);
            rule__Statemachine__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_3__2_in_rule__Statemachine__Group_3__11153);
            rule__Statemachine__Group_3__2();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_3__1"


    // $ANTLR start "rule__Statemachine__Group_3__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:608:1: rule__Statemachine__Group_3__1__Impl : ( ( ( rule__Statemachine__CommandsAssignment_3_1 ) ) ( ( rule__Statemachine__CommandsAssignment_3_1 )* ) ) ;
    public final void rule__Statemachine__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:612:1: ( ( ( ( rule__Statemachine__CommandsAssignment_3_1 ) ) ( ( rule__Statemachine__CommandsAssignment_3_1 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:613:1: ( ( ( rule__Statemachine__CommandsAssignment_3_1 ) ) ( ( rule__Statemachine__CommandsAssignment_3_1 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:613:1: ( ( ( rule__Statemachine__CommandsAssignment_3_1 ) ) ( ( rule__Statemachine__CommandsAssignment_3_1 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:614:1: ( ( rule__Statemachine__CommandsAssignment_3_1 ) ) ( ( rule__Statemachine__CommandsAssignment_3_1 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:614:1: ( ( rule__Statemachine__CommandsAssignment_3_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:615:1: ( rule__Statemachine__CommandsAssignment_3_1 )
            {
             before(grammarAccess.getStatemachineAccess().getCommandsAssignment_3_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:616:1: ( rule__Statemachine__CommandsAssignment_3_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:616:2: rule__Statemachine__CommandsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Statemachine__CommandsAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1182);
            rule__Statemachine__CommandsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getCommandsAssignment_3_1()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:619:1: ( ( rule__Statemachine__CommandsAssignment_3_1 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:620:1: ( rule__Statemachine__CommandsAssignment_3_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getCommandsAssignment_3_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:621:1: ( rule__Statemachine__CommandsAssignment_3_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:621:2: rule__Statemachine__CommandsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__CommandsAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1194);
            	    rule__Statemachine__CommandsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getCommandsAssignment_3_1()); 

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
    // $ANTLR end "rule__Statemachine__Group_3__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_3__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:632:1: rule__Statemachine__Group_3__2 : rule__Statemachine__Group_3__2__Impl ;
    public final void rule__Statemachine__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:636:1: ( rule__Statemachine__Group_3__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:637:2: rule__Statemachine__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_3__2__Impl_in_rule__Statemachine__Group_3__21227);
            rule__Statemachine__Group_3__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Statemachine__Group_3__2"


    // $ANTLR start "rule__Statemachine__Group_3__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:643:1: rule__Statemachine__Group_3__2__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:647:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:648:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:648:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:649:1: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_3_2()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group_3__2__Impl1255); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_3_2()); 

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
    // $ANTLR end "rule__Statemachine__Group_3__2__Impl"


    // $ANTLR start "rule__Event__Group__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:668:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:672:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:673:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__01292);
            rule__Event__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group__1_in_rule__Event__Group__01295);
            rule__Event__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__Event__Group__0"


    // $ANTLR start "rule__Event__Group__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:680:1: rule__Event__Group__0__Impl : ( ( rule__Event__NameAssignment_0 ) ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:684:1: ( ( ( rule__Event__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:685:1: ( ( rule__Event__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:685:1: ( ( rule__Event__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:686:1: ( rule__Event__NameAssignment_0 )
            {
             before(grammarAccess.getEventAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:687:1: ( rule__Event__NameAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:687:2: rule__Event__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Event__NameAssignment_0_in_rule__Event__Group__0__Impl1322);
            rule__Event__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Event__Group__0__Impl"


    // $ANTLR start "rule__Event__Group__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:697:1: rule__Event__Group__1 : rule__Event__Group__1__Impl ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:701:1: ( rule__Event__Group__1__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:702:2: rule__Event__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__11352);
            rule__Event__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Event__Group__1"


    // $ANTLR start "rule__Event__Group__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:708:1: rule__Event__Group__1__Impl : ( ( rule__Event__CodeAssignment_1 ) ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:712:1: ( ( ( rule__Event__CodeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:713:1: ( ( rule__Event__CodeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:713:1: ( ( rule__Event__CodeAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:714:1: ( rule__Event__CodeAssignment_1 )
            {
             before(grammarAccess.getEventAccess().getCodeAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:715:1: ( rule__Event__CodeAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:715:2: rule__Event__CodeAssignment_1
            {
            pushFollow(FOLLOW_rule__Event__CodeAssignment_1_in_rule__Event__Group__1__Impl1379);
            rule__Event__CodeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getCodeAssignment_1()); 

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
    // $ANTLR end "rule__Event__Group__1__Impl"


    // $ANTLR start "rule__Command__Group__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:729:1: rule__Command__Group__0 : rule__Command__Group__0__Impl rule__Command__Group__1 ;
    public final void rule__Command__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:733:1: ( rule__Command__Group__0__Impl rule__Command__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:734:2: rule__Command__Group__0__Impl rule__Command__Group__1
            {
            pushFollow(FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01413);
            rule__Command__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01416);
            rule__Command__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__Command__Group__0"


    // $ANTLR start "rule__Command__Group__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:741:1: rule__Command__Group__0__Impl : ( ( rule__Command__NameAssignment_0 ) ) ;
    public final void rule__Command__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:745:1: ( ( ( rule__Command__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:746:1: ( ( rule__Command__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:746:1: ( ( rule__Command__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:747:1: ( rule__Command__NameAssignment_0 )
            {
             before(grammarAccess.getCommandAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:748:1: ( rule__Command__NameAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:748:2: rule__Command__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1443);
            rule__Command__NameAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__Command__Group__0__Impl"


    // $ANTLR start "rule__Command__Group__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:758:1: rule__Command__Group__1 : rule__Command__Group__1__Impl ;
    public final void rule__Command__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:762:1: ( rule__Command__Group__1__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:763:2: rule__Command__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11473);
            rule__Command__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Command__Group__1"


    // $ANTLR start "rule__Command__Group__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:769:1: rule__Command__Group__1__Impl : ( ( rule__Command__CodeAssignment_1 ) ) ;
    public final void rule__Command__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:773:1: ( ( ( rule__Command__CodeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:774:1: ( ( rule__Command__CodeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:774:1: ( ( rule__Command__CodeAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:775:1: ( rule__Command__CodeAssignment_1 )
            {
             before(grammarAccess.getCommandAccess().getCodeAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:776:1: ( rule__Command__CodeAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:776:2: rule__Command__CodeAssignment_1
            {
            pushFollow(FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1500);
            rule__Command__CodeAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Command__Group__1__Impl"


    // $ANTLR start "rule__State__Group__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:790:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:794:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:795:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01534);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__1_in_rule__State__Group__01537);
            rule__State__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:802:1: rule__State__Group__0__Impl : ( 'state' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:806:1: ( ( 'state' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:807:1: ( 'state' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:807:1: ( 'state' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:808:1: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__State__Group__0__Impl1565); 
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
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:821:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:825:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:826:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11596);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__2_in_rule__State__Group__11599);
            rule__State__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:833:1: rule__State__Group__1__Impl : ( ( rule__State__NameAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:837:1: ( ( ( rule__State__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:838:1: ( ( rule__State__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:838:1: ( ( rule__State__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:839:1: ( rule__State__NameAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:840:1: ( rule__State__NameAssignment_1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:840:2: rule__State__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1626);
            rule__State__NameAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:850:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:854:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:855:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21656);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__3_in_rule__State__Group__21659);
            rule__State__Group__3();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:862:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:866:1: ( ( ( rule__State__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:867:1: ( ( rule__State__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:867:1: ( ( rule__State__Group_2__0 )? )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:868:1: ( rule__State__Group_2__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:869:1: ( rule__State__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:869:2: rule__State__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1686);
                    rule__State__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:879:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:883:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:884:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31717);
            rule__State__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__4_in_rule__State__Group__31720);
            rule__State__Group__4();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:891:1: rule__State__Group__3__Impl : ( ( rule__State__TransitionsAssignment_3 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:895:1: ( ( ( rule__State__TransitionsAssignment_3 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:896:1: ( ( rule__State__TransitionsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:896:1: ( ( rule__State__TransitionsAssignment_3 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:897:1: ( rule__State__TransitionsAssignment_3 )*
            {
             before(grammarAccess.getStateAccess().getTransitionsAssignment_3()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:898:1: ( rule__State__TransitionsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:898:2: rule__State__TransitionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1747);
            	    rule__State__TransitionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group__4"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:908:1: rule__State__Group__4 : rule__State__Group__4__Impl ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:912:1: ( rule__State__Group__4__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:913:2: rule__State__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41778);
            rule__State__Group__4__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group__4"


    // $ANTLR start "rule__State__Group__4__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:919:1: rule__State__Group__4__Impl : ( 'end' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:923:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:924:1: ( 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:924:1: ( 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:925:1: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__State__Group__4__Impl1806); 
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
    // $ANTLR end "rule__State__Group__4__Impl"


    // $ANTLR start "rule__State__Group_2__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:948:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:952:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:953:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
            {
            pushFollow(FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01847);
            rule__State__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01850);
            rule__State__Group_2__1();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group_2__0"


    // $ANTLR start "rule__State__Group_2__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:960:1: rule__State__Group_2__0__Impl : ( 'actions' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:964:1: ( ( 'actions' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:965:1: ( 'actions' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:965:1: ( 'actions' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:966:1: 'actions'
            {
             before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__State__Group_2__0__Impl1878); 
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
    // $ANTLR end "rule__State__Group_2__0__Impl"


    // $ANTLR start "rule__State__Group_2__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:979:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl rule__State__Group_2__2 ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:983:1: ( rule__State__Group_2__1__Impl rule__State__Group_2__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:984:2: rule__State__Group_2__1__Impl rule__State__Group_2__2
            {
            pushFollow(FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11909);
            rule__State__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11912);
            rule__State__Group_2__2();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group_2__1"


    // $ANTLR start "rule__State__Group_2__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:991:1: rule__State__Group_2__1__Impl : ( '{' ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:995:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:996:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:996:1: ( '{' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:997:1: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,17,FOLLOW_17_in_rule__State__Group_2__1__Impl1940); 
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
    // $ANTLR end "rule__State__Group_2__1__Impl"


    // $ANTLR start "rule__State__Group_2__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1010:1: rule__State__Group_2__2 : rule__State__Group_2__2__Impl rule__State__Group_2__3 ;
    public final void rule__State__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1014:1: ( rule__State__Group_2__2__Impl rule__State__Group_2__3 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1015:2: rule__State__Group_2__2__Impl rule__State__Group_2__3
            {
            pushFollow(FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21971);
            rule__State__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21974);
            rule__State__Group_2__3();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group_2__2"


    // $ANTLR start "rule__State__Group_2__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1022:1: rule__State__Group_2__2__Impl : ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) ;
    public final void rule__State__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1026:1: ( ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1027:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1027:1: ( ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1028:1: ( ( rule__State__ActionsAssignment_2_2 ) ) ( ( rule__State__ActionsAssignment_2_2 )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1028:1: ( ( rule__State__ActionsAssignment_2_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1029:1: ( rule__State__ActionsAssignment_2_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1030:1: ( rule__State__ActionsAssignment_2_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1030:2: rule__State__ActionsAssignment_2_2
            {
            pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl2003);
            rule__State__ActionsAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1033:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1034:1: ( rule__State__ActionsAssignment_2_2 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1035:1: ( rule__State__ActionsAssignment_2_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1035:2: rule__State__ActionsAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl2015);
            	    rule__State__ActionsAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end "rule__State__Group_2__2__Impl"


    // $ANTLR start "rule__State__Group_2__3"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1046:1: rule__State__Group_2__3 : rule__State__Group_2__3__Impl ;
    public final void rule__State__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1050:1: ( rule__State__Group_2__3__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1051:2: rule__State__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__32048);
            rule__State__Group_2__3__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__State__Group_2__3"


    // $ANTLR start "rule__State__Group_2__3__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1057:1: rule__State__Group_2__3__Impl : ( '}' ) ;
    public final void rule__State__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1061:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1062:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1062:1: ( '}' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1063:1: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,18,FOLLOW_18_in_rule__State__Group_2__3__Impl2076); 
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
    // $ANTLR end "rule__State__Group_2__3__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1084:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1088:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1089:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__02115);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__02118);
            rule__Transition__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1096:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__EventAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1100:1: ( ( ( rule__Transition__EventAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1101:1: ( ( rule__Transition__EventAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1101:1: ( ( rule__Transition__EventAssignment_0 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1102:1: ( rule__Transition__EventAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1103:1: ( rule__Transition__EventAssignment_0 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1103:2: rule__Transition__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl2145);
            rule__Transition__EventAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1113:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1117:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1118:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__12175);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__12178);
            rule__Transition__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1125:1: rule__Transition__Group__1__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1129:1: ( ( '=>' ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1130:1: ( '=>' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1130:1: ( '=>' )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1131:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,19,FOLLOW_19_in_rule__Transition__Group__1__Impl2206); 
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
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1144:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1148:1: ( rule__Transition__Group__2__Impl )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1149:2: rule__Transition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__22237);
            rule__Transition__Group__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1155:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__StateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1159:1: ( ( ( rule__Transition__StateAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1160:1: ( ( rule__Transition__StateAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1160:1: ( ( rule__Transition__StateAssignment_2 ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1161:1: ( rule__Transition__StateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getStateAssignment_2()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1162:1: ( rule__Transition__StateAssignment_2 )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1162:2: rule__Transition__StateAssignment_2
            {
            pushFollow(FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl2264);
            rule__Transition__StateAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Statemachine__EventsAssignment_1_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1179:1: rule__Statemachine__EventsAssignment_1_1 : ( ruleEvent ) ;
    public final void rule__Statemachine__EventsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1183:1: ( ( ruleEvent ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1184:1: ( ruleEvent )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1184:1: ( ruleEvent )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1185:1: ruleEvent
            {
             before(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_1_12305);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Statemachine__EventsAssignment_1_1"


    // $ANTLR start "rule__Statemachine__ResetEventsAssignment_2_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1194:1: rule__Statemachine__ResetEventsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Statemachine__ResetEventsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1198:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1199:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1199:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1200:1: ( RULE_ID )
            {
             before(grammarAccess.getStatemachineAccess().getResetEventsEventCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1201:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1202:1: RULE_ID
            {
             before(grammarAccess.getStatemachineAccess().getResetEventsEventIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Statemachine__ResetEventsAssignment_2_12340); 
             after(grammarAccess.getStatemachineAccess().getResetEventsEventIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getStatemachineAccess().getResetEventsEventCrossReference_2_1_0()); 

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
    // $ANTLR end "rule__Statemachine__ResetEventsAssignment_2_1"


    // $ANTLR start "rule__Statemachine__CommandsAssignment_3_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1213:1: rule__Statemachine__CommandsAssignment_3_1 : ( ruleCommand ) ;
    public final void rule__Statemachine__CommandsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1217:1: ( ( ruleCommand ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1218:1: ( ruleCommand )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1218:1: ( ruleCommand )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1219:1: ruleCommand
            {
             before(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_3_12375);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Statemachine__CommandsAssignment_3_1"


    // $ANTLR start "rule__Statemachine__StatesAssignment_4"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1228:1: rule__Statemachine__StatesAssignment_4 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1232:1: ( ( ruleState ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1233:1: ( ruleState )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1233:1: ( ruleState )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1234:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_42406);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Statemachine__StatesAssignment_4"


    // $ANTLR start "rule__Event__NameAssignment_0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1243:1: rule__Event__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1247:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1248:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1248:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1249:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__NameAssignment_02437); 
             after(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Event__NameAssignment_0"


    // $ANTLR start "rule__Event__CodeAssignment_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1258:1: rule__Event__CodeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Event__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1262:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1263:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1263:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1264:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_12468); 
             after(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Event__CodeAssignment_1"


    // $ANTLR start "rule__Command__NameAssignment_0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1273:1: rule__Command__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Command__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1277:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1278:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1278:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1279:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02499); 
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
    // $ANTLR end "rule__Command__NameAssignment_0"


    // $ANTLR start "rule__Command__CodeAssignment_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1288:1: rule__Command__CodeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Command__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1292:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1293:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1293:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1294:1: RULE_ID
            {
             before(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12530); 
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
    // $ANTLR end "rule__Command__CodeAssignment_1"


    // $ANTLR start "rule__State__NameAssignment_1"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1303:1: rule__State__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1307:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1308:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1308:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1309:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__NameAssignment_12561); 
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
    // $ANTLR end "rule__State__NameAssignment_1"


    // $ANTLR start "rule__State__ActionsAssignment_2_2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1318:1: rule__State__ActionsAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__State__ActionsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1322:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1323:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1323:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1324:1: ( RULE_ID )
            {
             before(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1325:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1326:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22596); 
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
    // $ANTLR end "rule__State__ActionsAssignment_2_2"


    // $ANTLR start "rule__State__TransitionsAssignment_3"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1337:1: rule__State__TransitionsAssignment_3 : ( ruleTransition ) ;
    public final void rule__State__TransitionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1341:1: ( ( ruleTransition ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1342:1: ( ruleTransition )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1342:1: ( ruleTransition )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1343:1: ruleTransition
            {
             before(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32631);
            ruleTransition();

            state._fsp--;

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
    // $ANTLR end "rule__State__TransitionsAssignment_3"


    // $ANTLR start "rule__Transition__EventAssignment_0"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1352:1: rule__Transition__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1356:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1357:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1357:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1358:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1359:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1360:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02666); 
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
    // $ANTLR end "rule__Transition__EventAssignment_0"


    // $ANTLR start "rule__Transition__StateAssignment_2"
    // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1371:1: rule__Transition__StateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__StateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1375:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1376:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1376:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1377:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1378:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl.ui/src-gen/org/eclipse/xtext/example/fowlerdsl/ui/contentassist/antlr/internal/InternalStatemachine.g:1379:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22705); 
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
    // $ANTLR end "rule__Transition__StateAssignment_2"

    // Delegated rules


 

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
    public static final BitSet FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0368 = new BitSet(new long[]{0x000000000000E800L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1429 = new BitSet(new long[]{0x000000000000E800L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__0_in_rule__Statemachine__Group__1__Impl459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2490 = new BitSet(new long[]{0x000000000000E800L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__0_in_rule__Statemachine__Group__2__Impl520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3551 = new BitSet(new long[]{0x000000000000E800L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__0_in_rule__Statemachine__Group__3__Impl581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_4_in_rule__Statemachine__Group__4__Impl639 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__0__Impl_in_rule__Statemachine__Group_1__0680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__1_in_rule__Statemachine__Group_1__0683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Statemachine__Group_1__0__Impl711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__1__Impl_in_rule__Statemachine__Group_1__1742 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__2_in_rule__Statemachine__Group_1__1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_1_1_in_rule__Statemachine__Group_1__1__Impl774 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_1_1_in_rule__Statemachine__Group_1__1__Impl786 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_1__2__Impl_in_rule__Statemachine__Group_1__2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group_1__2__Impl847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__0__Impl_in_rule__Statemachine__Group_2__0884 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__1_in_rule__Statemachine__Group_2__0887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Statemachine__Group_2__0__Impl915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__1__Impl_in_rule__Statemachine__Group_2__1946 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__2_in_rule__Statemachine__Group_2__1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__ResetEventsAssignment_2_1_in_rule__Statemachine__Group_2__1__Impl978 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__ResetEventsAssignment_2_1_in_rule__Statemachine__Group_2__1__Impl990 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_2__2__Impl_in_rule__Statemachine__Group_2__21023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group_2__2__Impl1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__0__Impl_in_rule__Statemachine__Group_3__01088 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__1_in_rule__Statemachine__Group_3__01091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Statemachine__Group_3__0__Impl1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__1__Impl_in_rule__Statemachine__Group_3__11150 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__2_in_rule__Statemachine__Group_3__11153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__CommandsAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1182 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__CommandsAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1194 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__2__Impl_in_rule__Statemachine__Group_3__21227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group_3__2__Impl1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__01292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Event__Group__1_in_rule__Event__Group__01295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__NameAssignment_0_in_rule__Event__Group__0__Impl1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__11352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__CodeAssignment_1_in_rule__Event__Group__1__Impl1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__NameAssignment_0_in_rule__Command__Group__0__Impl1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__CodeAssignment_1_in_rule__Command__Group__1__Impl1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__01534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__01537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__State__Group__0__Impl1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__11596 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__11599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__21656 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__21659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__31717 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_rule__State__Group__4_in_rule__State__Group__31720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__TransitionsAssignment_3_in_rule__State__Group__3__Impl1747 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group__4__Impl_in_rule__State__Group__41778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__State__Group__4__Impl1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__01847 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__01850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__State__Group_2__0__Impl1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__11909 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__11912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__State__Group_2__1__Impl1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__21971 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__21974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl2003 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl2015 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__32048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__State__Group_2__3__Impl2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__02115 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__02118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__12175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__12178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Transition__Group__1__Impl2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__22237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_1_12305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Statemachine__ResetEventsAssignment_2_12340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Statemachine__CommandsAssignment_3_12375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_42406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__NameAssignment_02437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__CodeAssignment_12468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__NameAssignment_02499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Command__CodeAssignment_12530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__NameAssignment_12561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__ActionsAssignment_2_22596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__State__TransitionsAssignment_32631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_02666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_22705 = new BitSet(new long[]{0x0000000000000002L});

}