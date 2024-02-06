package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



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
public class InternalContentAssistContextTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistContextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistContextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistContextTestLanguage.g"; }


    	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:58:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:59:1: ( ruleFirstLevel EOF )
            // InternalContentAssistContextTestLanguage.g:60:1: ruleFirstLevel EOF
            {
             before(grammarAccess.getFirstLevelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstLevel();

            state._fsp--;

             after(grammarAccess.getFirstLevelRule()); 
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
    // $ANTLR end "entryRuleFirstLevel"


    // $ANTLR start "ruleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:67:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:71:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:72:2: ( ( rule__FirstLevel__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:72:2: ( ( rule__FirstLevel__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:73:3: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:74:3: ( rule__FirstLevel__Group__0 )
            // InternalContentAssistContextTestLanguage.g:74:4: rule__FirstLevel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFirstLevelAccess().getGroup()); 

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
    // $ANTLR end "ruleFirstLevel"


    // $ANTLR start "entryRuleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:83:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:84:1: ( ruleSecondLevelA EOF )
            // InternalContentAssistContextTestLanguage.g:85:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondLevelA();

            state._fsp--;

             after(grammarAccess.getSecondLevelARule()); 
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
    // $ANTLR end "entryRuleSecondLevelA"


    // $ANTLR start "ruleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:92:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:96:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:97:2: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:97:2: ( ( rule__SecondLevelA__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:98:3: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:99:3: ( rule__SecondLevelA__Group__0 )
            // InternalContentAssistContextTestLanguage.g:99:4: rule__SecondLevelA__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getGroup()); 

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
    // $ANTLR end "ruleSecondLevelA"


    // $ANTLR start "entryRuleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:108:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:109:1: ( ruleSecondLevelB EOF )
            // InternalContentAssistContextTestLanguage.g:110:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondLevelB();

            state._fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
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
    // $ANTLR end "entryRuleSecondLevelB"


    // $ANTLR start "ruleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:117:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:121:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:122:2: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:122:2: ( ( rule__SecondLevelB__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:123:3: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:124:3: ( rule__SecondLevelB__Group__0 )
            // InternalContentAssistContextTestLanguage.g:124:4: rule__SecondLevelB__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getGroup()); 

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
    // $ANTLR end "ruleSecondLevelB"


    // $ANTLR start "entryRuleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:133:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:134:1: ( ruleThirdLevelA1 EOF )
            // InternalContentAssistContextTestLanguage.g:135:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelA1();

            state._fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelA1"


    // $ANTLR start "ruleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:142:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:146:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:147:2: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:147:2: ( ( rule__ThirdLevelA1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:148:3: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:149:3: ( rule__ThirdLevelA1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:149:4: rule__ThirdLevelA1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelA1Access().getGroup()); 

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
    // $ANTLR end "ruleThirdLevelA1"


    // $ANTLR start "entryRuleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:158:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:159:1: ( ruleThirdLevelA2 EOF )
            // InternalContentAssistContextTestLanguage.g:160:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelA2();

            state._fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelA2"


    // $ANTLR start "ruleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:167:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:171:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:172:2: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:172:2: ( ( rule__ThirdLevelA2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:173:3: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:174:3: ( rule__ThirdLevelA2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:174:4: rule__ThirdLevelA2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelA2Access().getGroup()); 

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
    // $ANTLR end "ruleThirdLevelA2"


    // $ANTLR start "entryRuleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:183:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:184:1: ( ruleThirdLevelB1 EOF )
            // InternalContentAssistContextTestLanguage.g:185:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelB1();

            state._fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelB1"


    // $ANTLR start "ruleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:192:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:196:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:197:2: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:197:2: ( ( rule__ThirdLevelB1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:198:3: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:199:3: ( rule__ThirdLevelB1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:199:4: rule__ThirdLevelB1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelB1Access().getGroup()); 

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
    // $ANTLR end "ruleThirdLevelB1"


    // $ANTLR start "entryRuleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:208:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:209:1: ( ruleThirdLevelB2 EOF )
            // InternalContentAssistContextTestLanguage.g:210:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelB2();

            state._fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelB2"


    // $ANTLR start "ruleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:217:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:221:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:222:2: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:222:2: ( ( rule__ThirdLevelB2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:223:3: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:224:3: ( rule__ThirdLevelB2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:224:4: rule__ThirdLevelB2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelB2Access().getGroup()); 

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
    // $ANTLR end "ruleThirdLevelB2"


    // $ANTLR start "rule__FirstLevel__Group__0"
    // InternalContentAssistContextTestLanguage.g:232:1: rule__FirstLevel__Group__0 : rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:236:1: ( rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 )
            // InternalContentAssistContextTestLanguage.g:237:2: rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__FirstLevel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__1();

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
    // $ANTLR end "rule__FirstLevel__Group__0"


    // $ANTLR start "rule__FirstLevel__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:244:1: rule__FirstLevel__Group__0__Impl : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) ;
    public final void rule__FirstLevel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:248:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:249:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:249:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:250:2: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // InternalContentAssistContextTestLanguage.g:251:2: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:251:3: rule__FirstLevel__SecondLevelAAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__FirstLevel__SecondLevelAAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 

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
    // $ANTLR end "rule__FirstLevel__Group__0__Impl"


    // $ANTLR start "rule__FirstLevel__Group__1"
    // InternalContentAssistContextTestLanguage.g:259:1: rule__FirstLevel__Group__1 : rule__FirstLevel__Group__1__Impl ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:263:1: ( rule__FirstLevel__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:264:2: rule__FirstLevel__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__1__Impl();

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
    // $ANTLR end "rule__FirstLevel__Group__1"


    // $ANTLR start "rule__FirstLevel__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:270:1: rule__FirstLevel__Group__1__Impl : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:274:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:275:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:275:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:276:2: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // InternalContentAssistContextTestLanguage.g:277:2: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:277:3: rule__FirstLevel__SecondLevelBAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__FirstLevel__SecondLevelBAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 

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
    // $ANTLR end "rule__FirstLevel__Group__1__Impl"


    // $ANTLR start "rule__SecondLevelA__Group__0"
    // InternalContentAssistContextTestLanguage.g:286:1: rule__SecondLevelA__Group__0 : rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:290:1: ( rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 )
            // InternalContentAssistContextTestLanguage.g:291:2: rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SecondLevelA__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__1();

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
    // $ANTLR end "rule__SecondLevelA__Group__0"


    // $ANTLR start "rule__SecondLevelA__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:298:1: rule__SecondLevelA__Group__0__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelA__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:302:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:303:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:303:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:304:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:304:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:305:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:306:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:306:4: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:309:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:310:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:311:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:311:4: rule__SecondLevelA__ThirdLevelA1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__SecondLevelA__ThirdLevelA1Assignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

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
    // $ANTLR end "rule__SecondLevelA__Group__0__Impl"


    // $ANTLR start "rule__SecondLevelA__Group__1"
    // InternalContentAssistContextTestLanguage.g:320:1: rule__SecondLevelA__Group__1 : rule__SecondLevelA__Group__1__Impl ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:324:1: ( rule__SecondLevelA__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:325:2: rule__SecondLevelA__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__1__Impl();

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
    // $ANTLR end "rule__SecondLevelA__Group__1"


    // $ANTLR start "rule__SecondLevelA__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:331:1: rule__SecondLevelA__Group__1__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:335:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:336:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:336:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:337:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:337:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:338:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:339:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:339:4: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:342:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:343:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:344:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:344:4: rule__SecondLevelA__ThirdLevelA2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__SecondLevelA__ThirdLevelA2Assignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

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
    // $ANTLR end "rule__SecondLevelA__Group__1__Impl"


    // $ANTLR start "rule__SecondLevelB__Group__0"
    // InternalContentAssistContextTestLanguage.g:354:1: rule__SecondLevelB__Group__0 : rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:358:1: ( rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 )
            // InternalContentAssistContextTestLanguage.g:359:2: rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SecondLevelB__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__1();

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
    // $ANTLR end "rule__SecondLevelB__Group__0"


    // $ANTLR start "rule__SecondLevelB__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:366:1: rule__SecondLevelB__Group__0__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelB__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:370:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:371:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:371:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:372:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:372:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:373:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:374:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:374:4: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:377:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:378:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:379:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:379:4: rule__SecondLevelB__ThirdLevelB1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__SecondLevelB__ThirdLevelB1Assignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

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
    // $ANTLR end "rule__SecondLevelB__Group__0__Impl"


    // $ANTLR start "rule__SecondLevelB__Group__1"
    // InternalContentAssistContextTestLanguage.g:388:1: rule__SecondLevelB__Group__1 : rule__SecondLevelB__Group__1__Impl ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:392:1: ( rule__SecondLevelB__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:393:2: rule__SecondLevelB__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__1__Impl();

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
    // $ANTLR end "rule__SecondLevelB__Group__1"


    // $ANTLR start "rule__SecondLevelB__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:399:1: rule__SecondLevelB__Group__1__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:403:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:404:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:404:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:405:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:405:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:406:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:407:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:407:4: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:410:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:411:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:412:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:412:4: rule__SecondLevelB__ThirdLevelB2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__SecondLevelB__ThirdLevelB2Assignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

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
    // $ANTLR end "rule__SecondLevelB__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__0"
    // InternalContentAssistContextTestLanguage.g:422:1: rule__ThirdLevelA1__Group__0 : rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:426:1: ( rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:427:2: rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__1();

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
    // $ANTLR end "rule__ThirdLevelA1__Group__0"


    // $ANTLR start "rule__ThirdLevelA1__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:434:1: rule__ThirdLevelA1__Group__0__Impl : ( 'A1' ) ;
    public final void rule__ThirdLevelA1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:438:1: ( ( 'A1' ) )
            // InternalContentAssistContextTestLanguage.g:439:1: ( 'A1' )
            {
            // InternalContentAssistContextTestLanguage.g:439:1: ( 'A1' )
            // InternalContentAssistContextTestLanguage.g:440:2: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

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
    // $ANTLR end "rule__ThirdLevelA1__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__1"
    // InternalContentAssistContextTestLanguage.g:449:1: rule__ThirdLevelA1__Group__1 : rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:453:1: ( rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:454:2: rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__2();

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
    // $ANTLR end "rule__ThirdLevelA1__Group__1"


    // $ANTLR start "rule__ThirdLevelA1__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:461:1: rule__ThirdLevelA1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:465:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:466:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:466:1: ( () )
            // InternalContentAssistContextTestLanguage.g:467:2: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:468:2: ()
            // InternalContentAssistContextTestLanguage.g:468:3: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__2"
    // InternalContentAssistContextTestLanguage.g:476:1: rule__ThirdLevelA1__Group__2 : rule__ThirdLevelA1__Group__2__Impl ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:480:1: ( rule__ThirdLevelA1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:481:2: rule__ThirdLevelA1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__2__Impl();

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
    // $ANTLR end "rule__ThirdLevelA1__Group__2"


    // $ANTLR start "rule__ThirdLevelA1__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:487:1: rule__ThirdLevelA1__Group__2__Impl : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:491:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:492:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:492:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:493:2: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:494:2: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:494:3: rule__ThirdLevelA1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelA1__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 

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
    // $ANTLR end "rule__ThirdLevelA1__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__0"
    // InternalContentAssistContextTestLanguage.g:503:1: rule__ThirdLevelA2__Group__0 : rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:507:1: ( rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:508:2: rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__1();

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
    // $ANTLR end "rule__ThirdLevelA2__Group__0"


    // $ANTLR start "rule__ThirdLevelA2__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:515:1: rule__ThirdLevelA2__Group__0__Impl : ( 'A2' ) ;
    public final void rule__ThirdLevelA2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:519:1: ( ( 'A2' ) )
            // InternalContentAssistContextTestLanguage.g:520:1: ( 'A2' )
            {
            // InternalContentAssistContextTestLanguage.g:520:1: ( 'A2' )
            // InternalContentAssistContextTestLanguage.g:521:2: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

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
    // $ANTLR end "rule__ThirdLevelA2__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__1"
    // InternalContentAssistContextTestLanguage.g:530:1: rule__ThirdLevelA2__Group__1 : rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:534:1: ( rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:535:2: rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__2();

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
    // $ANTLR end "rule__ThirdLevelA2__Group__1"


    // $ANTLR start "rule__ThirdLevelA2__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:542:1: rule__ThirdLevelA2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:546:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:547:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:547:1: ( () )
            // InternalContentAssistContextTestLanguage.g:548:2: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:549:2: ()
            // InternalContentAssistContextTestLanguage.g:549:3: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__2"
    // InternalContentAssistContextTestLanguage.g:557:1: rule__ThirdLevelA2__Group__2 : rule__ThirdLevelA2__Group__2__Impl ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:561:1: ( rule__ThirdLevelA2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:562:2: rule__ThirdLevelA2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__2__Impl();

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
    // $ANTLR end "rule__ThirdLevelA2__Group__2"


    // $ANTLR start "rule__ThirdLevelA2__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:568:1: rule__ThirdLevelA2__Group__2__Impl : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:572:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:573:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:573:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:574:2: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:575:2: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:575:3: rule__ThirdLevelA2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelA2__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 

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
    // $ANTLR end "rule__ThirdLevelA2__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__0"
    // InternalContentAssistContextTestLanguage.g:584:1: rule__ThirdLevelB1__Group__0 : rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:588:1: ( rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:589:2: rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__1();

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
    // $ANTLR end "rule__ThirdLevelB1__Group__0"


    // $ANTLR start "rule__ThirdLevelB1__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:596:1: rule__ThirdLevelB1__Group__0__Impl : ( 'B1' ) ;
    public final void rule__ThirdLevelB1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:600:1: ( ( 'B1' ) )
            // InternalContentAssistContextTestLanguage.g:601:1: ( 'B1' )
            {
            // InternalContentAssistContextTestLanguage.g:601:1: ( 'B1' )
            // InternalContentAssistContextTestLanguage.g:602:2: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

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
    // $ANTLR end "rule__ThirdLevelB1__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__1"
    // InternalContentAssistContextTestLanguage.g:611:1: rule__ThirdLevelB1__Group__1 : rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:615:1: ( rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:616:2: rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__2();

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
    // $ANTLR end "rule__ThirdLevelB1__Group__1"


    // $ANTLR start "rule__ThirdLevelB1__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:623:1: rule__ThirdLevelB1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:627:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:628:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:628:1: ( () )
            // InternalContentAssistContextTestLanguage.g:629:2: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:630:2: ()
            // InternalContentAssistContextTestLanguage.g:630:3: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__2"
    // InternalContentAssistContextTestLanguage.g:638:1: rule__ThirdLevelB1__Group__2 : rule__ThirdLevelB1__Group__2__Impl ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:642:1: ( rule__ThirdLevelB1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:643:2: rule__ThirdLevelB1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__2__Impl();

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
    // $ANTLR end "rule__ThirdLevelB1__Group__2"


    // $ANTLR start "rule__ThirdLevelB1__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:649:1: rule__ThirdLevelB1__Group__2__Impl : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:653:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:654:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:654:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:655:2: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:656:2: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:656:3: rule__ThirdLevelB1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelB1__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 

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
    // $ANTLR end "rule__ThirdLevelB1__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__0"
    // InternalContentAssistContextTestLanguage.g:665:1: rule__ThirdLevelB2__Group__0 : rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:669:1: ( rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:670:2: rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__1();

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
    // $ANTLR end "rule__ThirdLevelB2__Group__0"


    // $ANTLR start "rule__ThirdLevelB2__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:677:1: rule__ThirdLevelB2__Group__0__Impl : ( 'B2' ) ;
    public final void rule__ThirdLevelB2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:681:1: ( ( 'B2' ) )
            // InternalContentAssistContextTestLanguage.g:682:1: ( 'B2' )
            {
            // InternalContentAssistContextTestLanguage.g:682:1: ( 'B2' )
            // InternalContentAssistContextTestLanguage.g:683:2: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

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
    // $ANTLR end "rule__ThirdLevelB2__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__1"
    // InternalContentAssistContextTestLanguage.g:692:1: rule__ThirdLevelB2__Group__1 : rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:696:1: ( rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:697:2: rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__2();

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
    // $ANTLR end "rule__ThirdLevelB2__Group__1"


    // $ANTLR start "rule__ThirdLevelB2__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:704:1: rule__ThirdLevelB2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:708:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:709:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:709:1: ( () )
            // InternalContentAssistContextTestLanguage.g:710:2: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:711:2: ()
            // InternalContentAssistContextTestLanguage.g:711:3: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__2"
    // InternalContentAssistContextTestLanguage.g:719:1: rule__ThirdLevelB2__Group__2 : rule__ThirdLevelB2__Group__2__Impl ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:723:1: ( rule__ThirdLevelB2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:724:2: rule__ThirdLevelB2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__2__Impl();

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
    // $ANTLR end "rule__ThirdLevelB2__Group__2"


    // $ANTLR start "rule__ThirdLevelB2__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:730:1: rule__ThirdLevelB2__Group__2__Impl : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:734:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:735:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:735:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:736:2: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:737:2: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:737:3: rule__ThirdLevelB2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelB2__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 

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
    // $ANTLR end "rule__ThirdLevelB2__Group__2__Impl"


    // $ANTLR start "rule__FirstLevel__SecondLevelAAssignment_0"
    // InternalContentAssistContextTestLanguage.g:746:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:750:1: ( ( ruleSecondLevelA ) )
            // InternalContentAssistContextTestLanguage.g:751:2: ( ruleSecondLevelA )
            {
            // InternalContentAssistContextTestLanguage.g:751:2: ( ruleSecondLevelA )
            // InternalContentAssistContextTestLanguage.g:752:3: ruleSecondLevelA
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSecondLevelA();

            state._fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__FirstLevel__SecondLevelAAssignment_0"


    // $ANTLR start "rule__FirstLevel__SecondLevelBAssignment_1"
    // InternalContentAssistContextTestLanguage.g:761:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:765:1: ( ( ruleSecondLevelB ) )
            // InternalContentAssistContextTestLanguage.g:766:2: ( ruleSecondLevelB )
            {
            // InternalContentAssistContextTestLanguage.g:766:2: ( ruleSecondLevelB )
            // InternalContentAssistContextTestLanguage.g:767:3: ruleSecondLevelB
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSecondLevelB();

            state._fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__FirstLevel__SecondLevelBAssignment_1"


    // $ANTLR start "rule__SecondLevelA__ThirdLevelA1Assignment_0"
    // InternalContentAssistContextTestLanguage.g:776:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:780:1: ( ( ruleThirdLevelA1 ) )
            // InternalContentAssistContextTestLanguage.g:781:2: ( ruleThirdLevelA1 )
            {
            // InternalContentAssistContextTestLanguage.g:781:2: ( ruleThirdLevelA1 )
            // InternalContentAssistContextTestLanguage.g:782:3: ruleThirdLevelA1
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelA1();

            state._fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__SecondLevelA__ThirdLevelA1Assignment_0"


    // $ANTLR start "rule__SecondLevelA__ThirdLevelA2Assignment_1"
    // InternalContentAssistContextTestLanguage.g:791:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:795:1: ( ( ruleThirdLevelA2 ) )
            // InternalContentAssistContextTestLanguage.g:796:2: ( ruleThirdLevelA2 )
            {
            // InternalContentAssistContextTestLanguage.g:796:2: ( ruleThirdLevelA2 )
            // InternalContentAssistContextTestLanguage.g:797:3: ruleThirdLevelA2
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelA2();

            state._fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__SecondLevelA__ThirdLevelA2Assignment_1"


    // $ANTLR start "rule__SecondLevelB__ThirdLevelB1Assignment_0"
    // InternalContentAssistContextTestLanguage.g:806:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:810:1: ( ( ruleThirdLevelB1 ) )
            // InternalContentAssistContextTestLanguage.g:811:2: ( ruleThirdLevelB1 )
            {
            // InternalContentAssistContextTestLanguage.g:811:2: ( ruleThirdLevelB1 )
            // InternalContentAssistContextTestLanguage.g:812:3: ruleThirdLevelB1
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelB1();

            state._fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__SecondLevelB__ThirdLevelB1Assignment_0"


    // $ANTLR start "rule__SecondLevelB__ThirdLevelB2Assignment_1"
    // InternalContentAssistContextTestLanguage.g:821:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:825:1: ( ( ruleThirdLevelB2 ) )
            // InternalContentAssistContextTestLanguage.g:826:2: ( ruleThirdLevelB2 )
            {
            // InternalContentAssistContextTestLanguage.g:826:2: ( ruleThirdLevelB2 )
            // InternalContentAssistContextTestLanguage.g:827:3: ruleThirdLevelB2
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelB2();

            state._fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__SecondLevelB__ThirdLevelB2Assignment_1"


    // $ANTLR start "rule__ThirdLevelA1__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:836:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:840:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:841:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:841:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:842:3: RULE_ID
            {
             before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__ThirdLevelA1__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelA2__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:851:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:855:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:856:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:856:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:857:3: RULE_ID
            {
             before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__ThirdLevelA2__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelB1__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:866:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:870:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:871:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:871:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:872:3: RULE_ID
            {
             before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__ThirdLevelB1__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelB2__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:881:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:885:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:886:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:886:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:887:3: RULE_ID
            {
             before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__ThirdLevelB2__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    }


}