package org.eclipse.xtext.testlanguages.noJdt.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.testlanguages.noJdt.services.NoJdtTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNoJdtTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'!'", "'('", "'from'", "')'"
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
    public String getGrammarFileName() { return "InternalNoJdtTestLanguage.g"; }


     
     	private NoJdtTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(NoJdtTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // InternalNoJdtTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalNoJdtTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalNoJdtTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalNoJdtTestLanguage.g:69:1: ruleModel : ( ( rule__Model__GreetingsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:73:2: ( ( ( rule__Model__GreetingsAssignment ) ) )
            // InternalNoJdtTestLanguage.g:74:1: ( ( rule__Model__GreetingsAssignment ) )
            {
            // InternalNoJdtTestLanguage.g:74:1: ( ( rule__Model__GreetingsAssignment ) )
            // InternalNoJdtTestLanguage.g:75:1: ( rule__Model__GreetingsAssignment )
            {
             before(grammarAccess.getModelAccess().getGreetingsAssignment()); 
            // InternalNoJdtTestLanguage.g:76:1: ( rule__Model__GreetingsAssignment )
            // InternalNoJdtTestLanguage.g:76:2: rule__Model__GreetingsAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Model__GreetingsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGreetingsAssignment()); 

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGreeting"
    // InternalNoJdtTestLanguage.g:88:1: entryRuleGreeting : ruleGreeting EOF ;
    public final void entryRuleGreeting() throws RecognitionException {
        try {
            // InternalNoJdtTestLanguage.g:89:1: ( ruleGreeting EOF )
            // InternalNoJdtTestLanguage.g:90:1: ruleGreeting EOF
            {
             before(grammarAccess.getGreetingRule()); 
            pushFollow(FOLLOW_1);
            ruleGreeting();

            state._fsp--;

             after(grammarAccess.getGreetingRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // InternalNoJdtTestLanguage.g:97:1: ruleGreeting : ( ( rule__Greeting__Group__0 ) ) ;
    public final void ruleGreeting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:101:2: ( ( ( rule__Greeting__Group__0 ) ) )
            // InternalNoJdtTestLanguage.g:102:1: ( ( rule__Greeting__Group__0 ) )
            {
            // InternalNoJdtTestLanguage.g:102:1: ( ( rule__Greeting__Group__0 ) )
            // InternalNoJdtTestLanguage.g:103:1: ( rule__Greeting__Group__0 )
            {
             before(grammarAccess.getGreetingAccess().getGroup()); 
            // InternalNoJdtTestLanguage.g:104:1: ( rule__Greeting__Group__0 )
            // InternalNoJdtTestLanguage.g:104:2: rule__Greeting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Greeting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreetingAccess().getGroup()); 

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
    // $ANTLR end "ruleGreeting"


    // $ANTLR start "rule__Greeting__Group__0"
    // InternalNoJdtTestLanguage.g:118:1: rule__Greeting__Group__0 : rule__Greeting__Group__0__Impl rule__Greeting__Group__1 ;
    public final void rule__Greeting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:122:1: ( rule__Greeting__Group__0__Impl rule__Greeting__Group__1 )
            // InternalNoJdtTestLanguage.g:123:2: rule__Greeting__Group__0__Impl rule__Greeting__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Greeting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group__1();

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
    // $ANTLR end "rule__Greeting__Group__0"


    // $ANTLR start "rule__Greeting__Group__0__Impl"
    // InternalNoJdtTestLanguage.g:130:1: rule__Greeting__Group__0__Impl : ( 'Hello' ) ;
    public final void rule__Greeting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:134:1: ( ( 'Hello' ) )
            // InternalNoJdtTestLanguage.g:135:1: ( 'Hello' )
            {
            // InternalNoJdtTestLanguage.g:135:1: ( 'Hello' )
            // InternalNoJdtTestLanguage.g:136:1: 'Hello'
            {
             before(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 

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
    // $ANTLR end "rule__Greeting__Group__0__Impl"


    // $ANTLR start "rule__Greeting__Group__1"
    // InternalNoJdtTestLanguage.g:149:1: rule__Greeting__Group__1 : rule__Greeting__Group__1__Impl rule__Greeting__Group__2 ;
    public final void rule__Greeting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:153:1: ( rule__Greeting__Group__1__Impl rule__Greeting__Group__2 )
            // InternalNoJdtTestLanguage.g:154:2: rule__Greeting__Group__1__Impl rule__Greeting__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Greeting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group__2();

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
    // $ANTLR end "rule__Greeting__Group__1"


    // $ANTLR start "rule__Greeting__Group__1__Impl"
    // InternalNoJdtTestLanguage.g:161:1: rule__Greeting__Group__1__Impl : ( ( rule__Greeting__NameAssignment_1 ) ) ;
    public final void rule__Greeting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:165:1: ( ( ( rule__Greeting__NameAssignment_1 ) ) )
            // InternalNoJdtTestLanguage.g:166:1: ( ( rule__Greeting__NameAssignment_1 ) )
            {
            // InternalNoJdtTestLanguage.g:166:1: ( ( rule__Greeting__NameAssignment_1 ) )
            // InternalNoJdtTestLanguage.g:167:1: ( rule__Greeting__NameAssignment_1 )
            {
             before(grammarAccess.getGreetingAccess().getNameAssignment_1()); 
            // InternalNoJdtTestLanguage.g:168:1: ( rule__Greeting__NameAssignment_1 )
            // InternalNoJdtTestLanguage.g:168:2: rule__Greeting__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Greeting__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGreetingAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Greeting__Group__1__Impl"


    // $ANTLR start "rule__Greeting__Group__2"
    // InternalNoJdtTestLanguage.g:178:1: rule__Greeting__Group__2 : rule__Greeting__Group__2__Impl rule__Greeting__Group__3 ;
    public final void rule__Greeting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:182:1: ( rule__Greeting__Group__2__Impl rule__Greeting__Group__3 )
            // InternalNoJdtTestLanguage.g:183:2: rule__Greeting__Group__2__Impl rule__Greeting__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Greeting__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group__3();

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
    // $ANTLR end "rule__Greeting__Group__2"


    // $ANTLR start "rule__Greeting__Group__2__Impl"
    // InternalNoJdtTestLanguage.g:190:1: rule__Greeting__Group__2__Impl : ( ( rule__Greeting__Group_2__0 )? ) ;
    public final void rule__Greeting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:194:1: ( ( ( rule__Greeting__Group_2__0 )? ) )
            // InternalNoJdtTestLanguage.g:195:1: ( ( rule__Greeting__Group_2__0 )? )
            {
            // InternalNoJdtTestLanguage.g:195:1: ( ( rule__Greeting__Group_2__0 )? )
            // InternalNoJdtTestLanguage.g:196:1: ( rule__Greeting__Group_2__0 )?
            {
             before(grammarAccess.getGreetingAccess().getGroup_2()); 
            // InternalNoJdtTestLanguage.g:197:1: ( rule__Greeting__Group_2__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNoJdtTestLanguage.g:197:2: rule__Greeting__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Greeting__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGreetingAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Greeting__Group__2__Impl"


    // $ANTLR start "rule__Greeting__Group__3"
    // InternalNoJdtTestLanguage.g:207:1: rule__Greeting__Group__3 : rule__Greeting__Group__3__Impl ;
    public final void rule__Greeting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:211:1: ( rule__Greeting__Group__3__Impl )
            // InternalNoJdtTestLanguage.g:212:2: rule__Greeting__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greeting__Group__3__Impl();

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
    // $ANTLR end "rule__Greeting__Group__3"


    // $ANTLR start "rule__Greeting__Group__3__Impl"
    // InternalNoJdtTestLanguage.g:218:1: rule__Greeting__Group__3__Impl : ( '!' ) ;
    public final void rule__Greeting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:222:1: ( ( '!' ) )
            // InternalNoJdtTestLanguage.g:223:1: ( '!' )
            {
            // InternalNoJdtTestLanguage.g:223:1: ( '!' )
            // InternalNoJdtTestLanguage.g:224:1: '!'
            {
             before(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3()); 

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
    // $ANTLR end "rule__Greeting__Group__3__Impl"


    // $ANTLR start "rule__Greeting__Group_2__0"
    // InternalNoJdtTestLanguage.g:245:1: rule__Greeting__Group_2__0 : rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1 ;
    public final void rule__Greeting__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:249:1: ( rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1 )
            // InternalNoJdtTestLanguage.g:250:2: rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Greeting__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group_2__1();

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
    // $ANTLR end "rule__Greeting__Group_2__0"


    // $ANTLR start "rule__Greeting__Group_2__0__Impl"
    // InternalNoJdtTestLanguage.g:257:1: rule__Greeting__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Greeting__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:261:1: ( ( '(' ) )
            // InternalNoJdtTestLanguage.g:262:1: ( '(' )
            {
            // InternalNoJdtTestLanguage.g:262:1: ( '(' )
            // InternalNoJdtTestLanguage.g:263:1: '('
            {
             before(grammarAccess.getGreetingAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getLeftParenthesisKeyword_2_0()); 

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
    // $ANTLR end "rule__Greeting__Group_2__0__Impl"


    // $ANTLR start "rule__Greeting__Group_2__1"
    // InternalNoJdtTestLanguage.g:276:1: rule__Greeting__Group_2__1 : rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2 ;
    public final void rule__Greeting__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:280:1: ( rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2 )
            // InternalNoJdtTestLanguage.g:281:2: rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2
            {
            pushFollow(FOLLOW_3);
            rule__Greeting__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group_2__2();

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
    // $ANTLR end "rule__Greeting__Group_2__1"


    // $ANTLR start "rule__Greeting__Group_2__1__Impl"
    // InternalNoJdtTestLanguage.g:288:1: rule__Greeting__Group_2__1__Impl : ( 'from' ) ;
    public final void rule__Greeting__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:292:1: ( ( 'from' ) )
            // InternalNoJdtTestLanguage.g:293:1: ( 'from' )
            {
            // InternalNoJdtTestLanguage.g:293:1: ( 'from' )
            // InternalNoJdtTestLanguage.g:294:1: 'from'
            {
             before(grammarAccess.getGreetingAccess().getFromKeyword_2_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getFromKeyword_2_1()); 

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
    // $ANTLR end "rule__Greeting__Group_2__1__Impl"


    // $ANTLR start "rule__Greeting__Group_2__2"
    // InternalNoJdtTestLanguage.g:307:1: rule__Greeting__Group_2__2 : rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3 ;
    public final void rule__Greeting__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:311:1: ( rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3 )
            // InternalNoJdtTestLanguage.g:312:2: rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3
            {
            pushFollow(FOLLOW_6);
            rule__Greeting__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greeting__Group_2__3();

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
    // $ANTLR end "rule__Greeting__Group_2__2"


    // $ANTLR start "rule__Greeting__Group_2__2__Impl"
    // InternalNoJdtTestLanguage.g:319:1: rule__Greeting__Group_2__2__Impl : ( ( rule__Greeting__OtherAssignment_2_2 ) ) ;
    public final void rule__Greeting__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:323:1: ( ( ( rule__Greeting__OtherAssignment_2_2 ) ) )
            // InternalNoJdtTestLanguage.g:324:1: ( ( rule__Greeting__OtherAssignment_2_2 ) )
            {
            // InternalNoJdtTestLanguage.g:324:1: ( ( rule__Greeting__OtherAssignment_2_2 ) )
            // InternalNoJdtTestLanguage.g:325:1: ( rule__Greeting__OtherAssignment_2_2 )
            {
             before(grammarAccess.getGreetingAccess().getOtherAssignment_2_2()); 
            // InternalNoJdtTestLanguage.g:326:1: ( rule__Greeting__OtherAssignment_2_2 )
            // InternalNoJdtTestLanguage.g:326:2: rule__Greeting__OtherAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Greeting__OtherAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getGreetingAccess().getOtherAssignment_2_2()); 

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
    // $ANTLR end "rule__Greeting__Group_2__2__Impl"


    // $ANTLR start "rule__Greeting__Group_2__3"
    // InternalNoJdtTestLanguage.g:336:1: rule__Greeting__Group_2__3 : rule__Greeting__Group_2__3__Impl ;
    public final void rule__Greeting__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:340:1: ( rule__Greeting__Group_2__3__Impl )
            // InternalNoJdtTestLanguage.g:341:2: rule__Greeting__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greeting__Group_2__3__Impl();

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
    // $ANTLR end "rule__Greeting__Group_2__3"


    // $ANTLR start "rule__Greeting__Group_2__3__Impl"
    // InternalNoJdtTestLanguage.g:347:1: rule__Greeting__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Greeting__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:351:1: ( ( ')' ) )
            // InternalNoJdtTestLanguage.g:352:1: ( ')' )
            {
            // InternalNoJdtTestLanguage.g:352:1: ( ')' )
            // InternalNoJdtTestLanguage.g:353:1: ')'
            {
             before(grammarAccess.getGreetingAccess().getRightParenthesisKeyword_2_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getRightParenthesisKeyword_2_3()); 

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
    // $ANTLR end "rule__Greeting__Group_2__3__Impl"


    // $ANTLR start "rule__Model__GreetingsAssignment"
    // InternalNoJdtTestLanguage.g:375:1: rule__Model__GreetingsAssignment : ( ruleGreeting ) ;
    public final void rule__Model__GreetingsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:379:1: ( ( ruleGreeting ) )
            // InternalNoJdtTestLanguage.g:380:1: ( ruleGreeting )
            {
            // InternalNoJdtTestLanguage.g:380:1: ( ruleGreeting )
            // InternalNoJdtTestLanguage.g:381:1: ruleGreeting
            {
             before(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleGreeting();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__GreetingsAssignment"


    // $ANTLR start "rule__Greeting__NameAssignment_1"
    // InternalNoJdtTestLanguage.g:390:1: rule__Greeting__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Greeting__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:394:1: ( ( RULE_ID ) )
            // InternalNoJdtTestLanguage.g:395:1: ( RULE_ID )
            {
            // InternalNoJdtTestLanguage.g:395:1: ( RULE_ID )
            // InternalNoJdtTestLanguage.g:396:1: RULE_ID
            {
             before(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Greeting__NameAssignment_1"


    // $ANTLR start "rule__Greeting__OtherAssignment_2_2"
    // InternalNoJdtTestLanguage.g:405:1: rule__Greeting__OtherAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__Greeting__OtherAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalNoJdtTestLanguage.g:409:1: ( ( ( RULE_ID ) ) )
            // InternalNoJdtTestLanguage.g:410:1: ( ( RULE_ID ) )
            {
            // InternalNoJdtTestLanguage.g:410:1: ( ( RULE_ID ) )
            // InternalNoJdtTestLanguage.g:411:1: ( RULE_ID )
            {
             before(grammarAccess.getGreetingAccess().getOtherGreetingCrossReference_2_2_0()); 
            // InternalNoJdtTestLanguage.g:412:1: ( RULE_ID )
            // InternalNoJdtTestLanguage.g:413:1: RULE_ID
            {
             before(grammarAccess.getGreetingAccess().getOtherGreetingIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGreetingAccess().getOtherGreetingIDTerminalRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getGreetingAccess().getOtherGreetingCrossReference_2_2_0()); 

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
    // $ANTLR end "rule__Greeting__OtherAssignment_2_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});

}