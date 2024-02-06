package org.eclipse.xtext.testlanguages.noJdt.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.testlanguages.noJdt.services.NoJdtTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalNoJdtTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'!'", "'('", "'from'", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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
    // InternalNoJdtTestLanguage.g:59:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalNoJdtTestLanguage.g:60:1: ( ruleModel EOF )
            // InternalNoJdtTestLanguage.g:61:1: ruleModel EOF
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
    // InternalNoJdtTestLanguage.g:68:1: ruleModel : ( ( rule__Model__GreetingsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:72:2: ( ( ( rule__Model__GreetingsAssignment ) ) )
            // InternalNoJdtTestLanguage.g:73:2: ( ( rule__Model__GreetingsAssignment ) )
            {
            // InternalNoJdtTestLanguage.g:73:2: ( ( rule__Model__GreetingsAssignment ) )
            // InternalNoJdtTestLanguage.g:74:3: ( rule__Model__GreetingsAssignment )
            {
             before(grammarAccess.getModelAccess().getGreetingsAssignment()); 
            // InternalNoJdtTestLanguage.g:75:3: ( rule__Model__GreetingsAssignment )
            // InternalNoJdtTestLanguage.g:75:4: rule__Model__GreetingsAssignment
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
    // InternalNoJdtTestLanguage.g:84:1: entryRuleGreeting : ruleGreeting EOF ;
    public final void entryRuleGreeting() throws RecognitionException {
        try {
            // InternalNoJdtTestLanguage.g:85:1: ( ruleGreeting EOF )
            // InternalNoJdtTestLanguage.g:86:1: ruleGreeting EOF
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
    // InternalNoJdtTestLanguage.g:93:1: ruleGreeting : ( ( rule__Greeting__Group__0 ) ) ;
    public final void ruleGreeting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:97:2: ( ( ( rule__Greeting__Group__0 ) ) )
            // InternalNoJdtTestLanguage.g:98:2: ( ( rule__Greeting__Group__0 ) )
            {
            // InternalNoJdtTestLanguage.g:98:2: ( ( rule__Greeting__Group__0 ) )
            // InternalNoJdtTestLanguage.g:99:3: ( rule__Greeting__Group__0 )
            {
             before(grammarAccess.getGreetingAccess().getGroup()); 
            // InternalNoJdtTestLanguage.g:100:3: ( rule__Greeting__Group__0 )
            // InternalNoJdtTestLanguage.g:100:4: rule__Greeting__Group__0
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
    // InternalNoJdtTestLanguage.g:108:1: rule__Greeting__Group__0 : rule__Greeting__Group__0__Impl rule__Greeting__Group__1 ;
    public final void rule__Greeting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:112:1: ( rule__Greeting__Group__0__Impl rule__Greeting__Group__1 )
            // InternalNoJdtTestLanguage.g:113:2: rule__Greeting__Group__0__Impl rule__Greeting__Group__1
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
    // InternalNoJdtTestLanguage.g:120:1: rule__Greeting__Group__0__Impl : ( 'Hello' ) ;
    public final void rule__Greeting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:124:1: ( ( 'Hello' ) )
            // InternalNoJdtTestLanguage.g:125:1: ( 'Hello' )
            {
            // InternalNoJdtTestLanguage.g:125:1: ( 'Hello' )
            // InternalNoJdtTestLanguage.g:126:2: 'Hello'
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
    // InternalNoJdtTestLanguage.g:135:1: rule__Greeting__Group__1 : rule__Greeting__Group__1__Impl rule__Greeting__Group__2 ;
    public final void rule__Greeting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:139:1: ( rule__Greeting__Group__1__Impl rule__Greeting__Group__2 )
            // InternalNoJdtTestLanguage.g:140:2: rule__Greeting__Group__1__Impl rule__Greeting__Group__2
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
    // InternalNoJdtTestLanguage.g:147:1: rule__Greeting__Group__1__Impl : ( ( rule__Greeting__NameAssignment_1 ) ) ;
    public final void rule__Greeting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:151:1: ( ( ( rule__Greeting__NameAssignment_1 ) ) )
            // InternalNoJdtTestLanguage.g:152:1: ( ( rule__Greeting__NameAssignment_1 ) )
            {
            // InternalNoJdtTestLanguage.g:152:1: ( ( rule__Greeting__NameAssignment_1 ) )
            // InternalNoJdtTestLanguage.g:153:2: ( rule__Greeting__NameAssignment_1 )
            {
             before(grammarAccess.getGreetingAccess().getNameAssignment_1()); 
            // InternalNoJdtTestLanguage.g:154:2: ( rule__Greeting__NameAssignment_1 )
            // InternalNoJdtTestLanguage.g:154:3: rule__Greeting__NameAssignment_1
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
    // InternalNoJdtTestLanguage.g:162:1: rule__Greeting__Group__2 : rule__Greeting__Group__2__Impl rule__Greeting__Group__3 ;
    public final void rule__Greeting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:166:1: ( rule__Greeting__Group__2__Impl rule__Greeting__Group__3 )
            // InternalNoJdtTestLanguage.g:167:2: rule__Greeting__Group__2__Impl rule__Greeting__Group__3
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
    // InternalNoJdtTestLanguage.g:174:1: rule__Greeting__Group__2__Impl : ( ( rule__Greeting__Group_2__0 )? ) ;
    public final void rule__Greeting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:178:1: ( ( ( rule__Greeting__Group_2__0 )? ) )
            // InternalNoJdtTestLanguage.g:179:1: ( ( rule__Greeting__Group_2__0 )? )
            {
            // InternalNoJdtTestLanguage.g:179:1: ( ( rule__Greeting__Group_2__0 )? )
            // InternalNoJdtTestLanguage.g:180:2: ( rule__Greeting__Group_2__0 )?
            {
             before(grammarAccess.getGreetingAccess().getGroup_2()); 
            // InternalNoJdtTestLanguage.g:181:2: ( rule__Greeting__Group_2__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNoJdtTestLanguage.g:181:3: rule__Greeting__Group_2__0
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
    // InternalNoJdtTestLanguage.g:189:1: rule__Greeting__Group__3 : rule__Greeting__Group__3__Impl ;
    public final void rule__Greeting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:193:1: ( rule__Greeting__Group__3__Impl )
            // InternalNoJdtTestLanguage.g:194:2: rule__Greeting__Group__3__Impl
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
    // InternalNoJdtTestLanguage.g:200:1: rule__Greeting__Group__3__Impl : ( '!' ) ;
    public final void rule__Greeting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:204:1: ( ( '!' ) )
            // InternalNoJdtTestLanguage.g:205:1: ( '!' )
            {
            // InternalNoJdtTestLanguage.g:205:1: ( '!' )
            // InternalNoJdtTestLanguage.g:206:2: '!'
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
    // InternalNoJdtTestLanguage.g:216:1: rule__Greeting__Group_2__0 : rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1 ;
    public final void rule__Greeting__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:220:1: ( rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1 )
            // InternalNoJdtTestLanguage.g:221:2: rule__Greeting__Group_2__0__Impl rule__Greeting__Group_2__1
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
    // InternalNoJdtTestLanguage.g:228:1: rule__Greeting__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Greeting__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:232:1: ( ( '(' ) )
            // InternalNoJdtTestLanguage.g:233:1: ( '(' )
            {
            // InternalNoJdtTestLanguage.g:233:1: ( '(' )
            // InternalNoJdtTestLanguage.g:234:2: '('
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
    // InternalNoJdtTestLanguage.g:243:1: rule__Greeting__Group_2__1 : rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2 ;
    public final void rule__Greeting__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:247:1: ( rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2 )
            // InternalNoJdtTestLanguage.g:248:2: rule__Greeting__Group_2__1__Impl rule__Greeting__Group_2__2
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
    // InternalNoJdtTestLanguage.g:255:1: rule__Greeting__Group_2__1__Impl : ( 'from' ) ;
    public final void rule__Greeting__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:259:1: ( ( 'from' ) )
            // InternalNoJdtTestLanguage.g:260:1: ( 'from' )
            {
            // InternalNoJdtTestLanguage.g:260:1: ( 'from' )
            // InternalNoJdtTestLanguage.g:261:2: 'from'
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
    // InternalNoJdtTestLanguage.g:270:1: rule__Greeting__Group_2__2 : rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3 ;
    public final void rule__Greeting__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:274:1: ( rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3 )
            // InternalNoJdtTestLanguage.g:275:2: rule__Greeting__Group_2__2__Impl rule__Greeting__Group_2__3
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
    // InternalNoJdtTestLanguage.g:282:1: rule__Greeting__Group_2__2__Impl : ( ( rule__Greeting__OtherAssignment_2_2 ) ) ;
    public final void rule__Greeting__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:286:1: ( ( ( rule__Greeting__OtherAssignment_2_2 ) ) )
            // InternalNoJdtTestLanguage.g:287:1: ( ( rule__Greeting__OtherAssignment_2_2 ) )
            {
            // InternalNoJdtTestLanguage.g:287:1: ( ( rule__Greeting__OtherAssignment_2_2 ) )
            // InternalNoJdtTestLanguage.g:288:2: ( rule__Greeting__OtherAssignment_2_2 )
            {
             before(grammarAccess.getGreetingAccess().getOtherAssignment_2_2()); 
            // InternalNoJdtTestLanguage.g:289:2: ( rule__Greeting__OtherAssignment_2_2 )
            // InternalNoJdtTestLanguage.g:289:3: rule__Greeting__OtherAssignment_2_2
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
    // InternalNoJdtTestLanguage.g:297:1: rule__Greeting__Group_2__3 : rule__Greeting__Group_2__3__Impl ;
    public final void rule__Greeting__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:301:1: ( rule__Greeting__Group_2__3__Impl )
            // InternalNoJdtTestLanguage.g:302:2: rule__Greeting__Group_2__3__Impl
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
    // InternalNoJdtTestLanguage.g:308:1: rule__Greeting__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Greeting__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:312:1: ( ( ')' ) )
            // InternalNoJdtTestLanguage.g:313:1: ( ')' )
            {
            // InternalNoJdtTestLanguage.g:313:1: ( ')' )
            // InternalNoJdtTestLanguage.g:314:2: ')'
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
    // InternalNoJdtTestLanguage.g:324:1: rule__Model__GreetingsAssignment : ( ruleGreeting ) ;
    public final void rule__Model__GreetingsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:328:1: ( ( ruleGreeting ) )
            // InternalNoJdtTestLanguage.g:329:2: ( ruleGreeting )
            {
            // InternalNoJdtTestLanguage.g:329:2: ( ruleGreeting )
            // InternalNoJdtTestLanguage.g:330:3: ruleGreeting
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
    // InternalNoJdtTestLanguage.g:339:1: rule__Greeting__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Greeting__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:343:1: ( ( RULE_ID ) )
            // InternalNoJdtTestLanguage.g:344:2: ( RULE_ID )
            {
            // InternalNoJdtTestLanguage.g:344:2: ( RULE_ID )
            // InternalNoJdtTestLanguage.g:345:3: RULE_ID
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
    // InternalNoJdtTestLanguage.g:354:1: rule__Greeting__OtherAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__Greeting__OtherAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNoJdtTestLanguage.g:358:1: ( ( ( RULE_ID ) ) )
            // InternalNoJdtTestLanguage.g:359:2: ( ( RULE_ID ) )
            {
            // InternalNoJdtTestLanguage.g:359:2: ( ( RULE_ID ) )
            // InternalNoJdtTestLanguage.g:360:3: ( RULE_ID )
            {
             before(grammarAccess.getGreetingAccess().getOtherGreetingCrossReference_2_2_0()); 
            // InternalNoJdtTestLanguage.g:361:3: ( RULE_ID )
            // InternalNoJdtTestLanguage.g:362:4: RULE_ID
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