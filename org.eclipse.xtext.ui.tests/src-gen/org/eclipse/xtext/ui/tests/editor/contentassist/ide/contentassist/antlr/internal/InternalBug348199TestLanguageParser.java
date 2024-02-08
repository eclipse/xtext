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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348199TestLanguageGrammarAccess;



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
public class InternalBug348199TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'define'", "'timeperiod'", "'1'", "'{'", "'}'", "'timeperiod_name'", "'otherelement'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'july'", "'august'", "'september'"
    };
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=4;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug348199TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug348199TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug348199TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug348199TestLanguage.g"; }


    	private Bug348199TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug348199TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleTimeperiod"
    // InternalBug348199TestLanguage.g:58:1: entryRuleTimeperiod : ruleTimeperiod EOF ;
    public final void entryRuleTimeperiod() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:59:1: ( ruleTimeperiod EOF )
            // InternalBug348199TestLanguage.g:60:1: ruleTimeperiod EOF
            {
             before(grammarAccess.getTimeperiodRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTimeperiod();

            state._fsp--;

             after(grammarAccess.getTimeperiodRule()); 
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
    // $ANTLR end "entryRuleTimeperiod"


    // $ANTLR start "ruleTimeperiod"
    // InternalBug348199TestLanguage.g:67:1: ruleTimeperiod : ( ( rule__Timeperiod__Group__0 ) ) ;
    public final void ruleTimeperiod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:71:2: ( ( ( rule__Timeperiod__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:72:2: ( ( rule__Timeperiod__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:72:2: ( ( rule__Timeperiod__Group__0 ) )
            // InternalBug348199TestLanguage.g:73:3: ( rule__Timeperiod__Group__0 )
            {
             before(grammarAccess.getTimeperiodAccess().getGroup()); 
            // InternalBug348199TestLanguage.g:74:3: ( rule__Timeperiod__Group__0 )
            // InternalBug348199TestLanguage.g:74:4: rule__Timeperiod__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getGroup()); 

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
    // $ANTLR end "ruleTimeperiod"


    // $ANTLR start "entryRuleTimeDef1"
    // InternalBug348199TestLanguage.g:83:1: entryRuleTimeDef1 : ruleTimeDef1 EOF ;
    public final void entryRuleTimeDef1() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:84:1: ( ruleTimeDef1 EOF )
            // InternalBug348199TestLanguage.g:85:1: ruleTimeDef1 EOF
            {
             before(grammarAccess.getTimeDef1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeDef1Rule()); 
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
    // $ANTLR end "entryRuleTimeDef1"


    // $ANTLR start "ruleTimeDef1"
    // InternalBug348199TestLanguage.g:92:1: ruleTimeDef1 : ( ( rule__TimeDef1__Group__0 ) ) ;
    public final void ruleTimeDef1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:96:2: ( ( ( rule__TimeDef1__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:97:2: ( ( rule__TimeDef1__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:97:2: ( ( rule__TimeDef1__Group__0 ) )
            // InternalBug348199TestLanguage.g:98:3: ( rule__TimeDef1__Group__0 )
            {
             before(grammarAccess.getTimeDef1Access().getGroup()); 
            // InternalBug348199TestLanguage.g:99:3: ( rule__TimeDef1__Group__0 )
            // InternalBug348199TestLanguage.g:99:4: rule__TimeDef1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef1Access().getGroup()); 

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
    // $ANTLR end "ruleTimeDef1"


    // $ANTLR start "entryRuleTimeDef2"
    // InternalBug348199TestLanguage.g:108:1: entryRuleTimeDef2 : ruleTimeDef2 EOF ;
    public final void entryRuleTimeDef2() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:109:1: ( ruleTimeDef2 EOF )
            // InternalBug348199TestLanguage.g:110:1: ruleTimeDef2 EOF
            {
             before(grammarAccess.getTimeDef2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeDef2Rule()); 
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
    // $ANTLR end "entryRuleTimeDef2"


    // $ANTLR start "ruleTimeDef2"
    // InternalBug348199TestLanguage.g:117:1: ruleTimeDef2 : ( ( rule__TimeDef2__Group__0 ) ) ;
    public final void ruleTimeDef2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:121:2: ( ( ( rule__TimeDef2__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:122:2: ( ( rule__TimeDef2__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:122:2: ( ( rule__TimeDef2__Group__0 ) )
            // InternalBug348199TestLanguage.g:123:3: ( rule__TimeDef2__Group__0 )
            {
             before(grammarAccess.getTimeDef2Access().getGroup()); 
            // InternalBug348199TestLanguage.g:124:3: ( rule__TimeDef2__Group__0 )
            // InternalBug348199TestLanguage.g:124:4: rule__TimeDef2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef2Access().getGroup()); 

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
    // $ANTLR end "ruleTimeDef2"


    // $ANTLR start "entryRuleTimeDef3"
    // InternalBug348199TestLanguage.g:133:1: entryRuleTimeDef3 : ruleTimeDef3 EOF ;
    public final void entryRuleTimeDef3() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:134:1: ( ruleTimeDef3 EOF )
            // InternalBug348199TestLanguage.g:135:1: ruleTimeDef3 EOF
            {
             before(grammarAccess.getTimeDef3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeDef3Rule()); 
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
    // $ANTLR end "entryRuleTimeDef3"


    // $ANTLR start "ruleTimeDef3"
    // InternalBug348199TestLanguage.g:142:1: ruleTimeDef3 : ( ( rule__TimeDef3__Group__0 ) ) ;
    public final void ruleTimeDef3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:146:2: ( ( ( rule__TimeDef3__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:147:2: ( ( rule__TimeDef3__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:147:2: ( ( rule__TimeDef3__Group__0 ) )
            // InternalBug348199TestLanguage.g:148:3: ( rule__TimeDef3__Group__0 )
            {
             before(grammarAccess.getTimeDef3Access().getGroup()); 
            // InternalBug348199TestLanguage.g:149:3: ( rule__TimeDef3__Group__0 )
            // InternalBug348199TestLanguage.g:149:4: rule__TimeDef3__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef3__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef3Access().getGroup()); 

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
    // $ANTLR end "ruleTimeDef3"


    // $ANTLR start "rule__Timeperiod__Alternatives_3"
    // InternalBug348199TestLanguage.g:157:1: rule__Timeperiod__Alternatives_3 : ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:161:1: ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case 21:
                {
                alt1=4;
                }
                break;
            case 22:
                {
                alt1=5;
                }
                break;
            case 23:
                {
                alt1=6;
                }
                break;
            case 24:
                {
                alt1=7;
                }
                break;
            case 25:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBug348199TestLanguage.g:162:2: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:162:2: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:163:3: ( rule__Timeperiod__Group_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0()); 
                    // InternalBug348199TestLanguage.g:164:3: ( rule__Timeperiod__Group_3_0__0 )
                    // InternalBug348199TestLanguage.g:164:4: rule__Timeperiod__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:168:2: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:168:2: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:169:3: ( rule__Timeperiod__Group_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1()); 
                    // InternalBug348199TestLanguage.g:170:3: ( rule__Timeperiod__Group_3_1__0 )
                    // InternalBug348199TestLanguage.g:170:4: rule__Timeperiod__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348199TestLanguage.g:174:2: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:174:2: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    // InternalBug348199TestLanguage.g:175:3: ( rule__Timeperiod__Group_3_2__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2()); 
                    // InternalBug348199TestLanguage.g:176:3: ( rule__Timeperiod__Group_3_2__0 )
                    // InternalBug348199TestLanguage.g:176:4: rule__Timeperiod__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug348199TestLanguage.g:180:2: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:180:2: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    // InternalBug348199TestLanguage.g:181:3: ( rule__Timeperiod__Group_3_3__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3()); 
                    // InternalBug348199TestLanguage.g:182:3: ( rule__Timeperiod__Group_3_3__0 )
                    // InternalBug348199TestLanguage.g:182:4: rule__Timeperiod__Group_3_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBug348199TestLanguage.g:186:2: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:186:2: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    // InternalBug348199TestLanguage.g:187:3: ( rule__Timeperiod__Group_3_4__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4()); 
                    // InternalBug348199TestLanguage.g:188:3: ( rule__Timeperiod__Group_3_4__0 )
                    // InternalBug348199TestLanguage.g:188:4: rule__Timeperiod__Group_3_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBug348199TestLanguage.g:192:2: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:192:2: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    // InternalBug348199TestLanguage.g:193:3: ( rule__Timeperiod__Group_3_5__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5()); 
                    // InternalBug348199TestLanguage.g:194:3: ( rule__Timeperiod__Group_3_5__0 )
                    // InternalBug348199TestLanguage.g:194:4: rule__Timeperiod__Group_3_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBug348199TestLanguage.g:198:2: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:198:2: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    // InternalBug348199TestLanguage.g:199:3: ( rule__Timeperiod__Group_3_6__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6()); 
                    // InternalBug348199TestLanguage.g:200:3: ( rule__Timeperiod__Group_3_6__0 )
                    // InternalBug348199TestLanguage.g:200:4: rule__Timeperiod__Group_3_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBug348199TestLanguage.g:204:2: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:204:2: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    // InternalBug348199TestLanguage.g:205:3: ( rule__Timeperiod__Group_3_7__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7()); 
                    // InternalBug348199TestLanguage.g:206:3: ( rule__Timeperiod__Group_3_7__0 )
                    // InternalBug348199TestLanguage.g:206:4: rule__Timeperiod__Group_3_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_1_3"
    // InternalBug348199TestLanguage.g:214:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:218:1: ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348199TestLanguage.g:219:2: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:219:2: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:220:3: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0()); 
                    // InternalBug348199TestLanguage.g:221:3: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    // InternalBug348199TestLanguage.g:221:4: rule__Timeperiod__Group_3_1_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_1_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:225:2: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:225:2: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    // InternalBug348199TestLanguage.g:226:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1()); 
                    // InternalBug348199TestLanguage.g:227:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:227:4: rule__Timeperiod__Group_3_1_3_1__0
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__Timeperiod__Group_3_1_3_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_1_3"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_2_3"
    // InternalBug348199TestLanguage.g:235:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:239:1: ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348199TestLanguage.g:240:2: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:240:2: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:241:3: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0()); 
                    // InternalBug348199TestLanguage.g:242:3: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    // InternalBug348199TestLanguage.g:242:4: rule__Timeperiod__Group_3_2_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_2_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:246:2: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:246:2: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:247:3: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1()); 
                    // InternalBug348199TestLanguage.g:248:3: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    // InternalBug348199TestLanguage.g:248:4: rule__Timeperiod__Group_3_2_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_2_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_2_3"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_3_3"
    // InternalBug348199TestLanguage.g:256:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:260:1: ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348199TestLanguage.g:261:2: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:261:2: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:262:3: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0()); 
                    // InternalBug348199TestLanguage.g:263:3: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    // InternalBug348199TestLanguage.g:263:4: rule__Timeperiod__Group_3_3_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_3_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:267:2: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:267:2: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:268:3: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1()); 
                    // InternalBug348199TestLanguage.g:269:3: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    // InternalBug348199TestLanguage.g:269:4: rule__Timeperiod__Group_3_3_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_3_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_3_3"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_5_4"
    // InternalBug348199TestLanguage.g:277:1: rule__Timeperiod__Alternatives_3_5_4 : ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:281:1: ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==16||LA7_0==18) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug348199TestLanguage.g:282:2: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:282:2: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:283:3: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0()); 
                    // InternalBug348199TestLanguage.g:284:3: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    // InternalBug348199TestLanguage.g:284:4: rule__Timeperiod__Group_3_5_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_5_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:288:2: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:288:2: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    // InternalBug348199TestLanguage.g:289:3: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1()); 
                    // InternalBug348199TestLanguage.g:290:3: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==18) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:290:4: rule__Timeperiod__Group_3_5_4_1__0
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__Timeperiod__Group_3_5_4_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_5_4"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_6_4"
    // InternalBug348199TestLanguage.g:298:1: rule__Timeperiod__Alternatives_3_6_4 : ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:302:1: ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug348199TestLanguage.g:303:2: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:303:2: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:304:3: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0()); 
                    // InternalBug348199TestLanguage.g:305:3: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    // InternalBug348199TestLanguage.g:305:4: rule__Timeperiod__Group_3_6_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_6_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:309:2: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:309:2: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:310:3: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1()); 
                    // InternalBug348199TestLanguage.g:311:3: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    // InternalBug348199TestLanguage.g:311:4: rule__Timeperiod__Group_3_6_4_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_6_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_6_4"


    // $ANTLR start "rule__Timeperiod__Alternatives_3_7_4"
    // InternalBug348199TestLanguage.g:319:1: rule__Timeperiod__Alternatives_3_7_4 : ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:323:1: ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug348199TestLanguage.g:324:2: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:324:2: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:325:3: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0()); 
                    // InternalBug348199TestLanguage.g:326:3: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    // InternalBug348199TestLanguage.g:326:4: rule__Timeperiod__Group_3_7_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_7_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:330:2: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:330:2: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:331:3: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1()); 
                    // InternalBug348199TestLanguage.g:332:3: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    // InternalBug348199TestLanguage.g:332:4: rule__Timeperiod__Group_3_7_4_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_7_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Alternatives_3_7_4"


    // $ANTLR start "rule__Timeperiod__Group__0"
    // InternalBug348199TestLanguage.g:340:1: rule__Timeperiod__Group__0 : rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 ;
    public final void rule__Timeperiod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:344:1: ( rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 )
            // InternalBug348199TestLanguage.g:345:2: rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Timeperiod__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group__1();

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
    // $ANTLR end "rule__Timeperiod__Group__0"


    // $ANTLR start "rule__Timeperiod__Group__0__Impl"
    // InternalBug348199TestLanguage.g:352:1: rule__Timeperiod__Group__0__Impl : ( () ) ;
    public final void rule__Timeperiod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:356:1: ( ( () ) )
            // InternalBug348199TestLanguage.g:357:1: ( () )
            {
            // InternalBug348199TestLanguage.g:357:1: ( () )
            // InternalBug348199TestLanguage.g:358:2: ()
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiodAction_0()); 
            // InternalBug348199TestLanguage.g:359:2: ()
            // InternalBug348199TestLanguage.g:359:3: 
            {
            }

             after(grammarAccess.getTimeperiodAccess().getTimeperiodAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__Group__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group__1"
    // InternalBug348199TestLanguage.g:367:1: rule__Timeperiod__Group__1 : rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 ;
    public final void rule__Timeperiod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:371:1: ( rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 )
            // InternalBug348199TestLanguage.g:372:2: rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Timeperiod__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group__2();

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
    // $ANTLR end "rule__Timeperiod__Group__1"


    // $ANTLR start "rule__Timeperiod__Group__1__Impl"
    // InternalBug348199TestLanguage.g:379:1: rule__Timeperiod__Group__1__Impl : ( 'define' ) ;
    public final void rule__Timeperiod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:383:1: ( ( 'define' ) )
            // InternalBug348199TestLanguage.g:384:1: ( 'define' )
            {
            // InternalBug348199TestLanguage.g:384:1: ( 'define' )
            // InternalBug348199TestLanguage.g:385:2: 'define'
            {
             before(grammarAccess.getTimeperiodAccess().getDefineKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDefineKeyword_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group__2"
    // InternalBug348199TestLanguage.g:394:1: rule__Timeperiod__Group__2 : rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 ;
    public final void rule__Timeperiod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:398:1: ( rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 )
            // InternalBug348199TestLanguage.g:399:2: rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Timeperiod__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group__3();

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
    // $ANTLR end "rule__Timeperiod__Group__2"


    // $ANTLR start "rule__Timeperiod__Group__2__Impl"
    // InternalBug348199TestLanguage.g:406:1: rule__Timeperiod__Group__2__Impl : ( 'timeperiod' ) ;
    public final void rule__Timeperiod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:410:1: ( ( 'timeperiod' ) )
            // InternalBug348199TestLanguage.g:411:1: ( 'timeperiod' )
            {
            // InternalBug348199TestLanguage.g:411:1: ( 'timeperiod' )
            // InternalBug348199TestLanguage.g:412:2: 'timeperiod'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiodKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiodKeyword_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group__3"
    // InternalBug348199TestLanguage.g:421:1: rule__Timeperiod__Group__3 : rule__Timeperiod__Group__3__Impl ;
    public final void rule__Timeperiod__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:425:1: ( rule__Timeperiod__Group__3__Impl )
            // InternalBug348199TestLanguage.g:426:2: rule__Timeperiod__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group__3"


    // $ANTLR start "rule__Timeperiod__Group__3__Impl"
    // InternalBug348199TestLanguage.g:432:1: rule__Timeperiod__Group__3__Impl : ( ( rule__Timeperiod__Alternatives_3 ) ) ;
    public final void rule__Timeperiod__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:436:1: ( ( ( rule__Timeperiod__Alternatives_3 ) ) )
            // InternalBug348199TestLanguage.g:437:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            {
            // InternalBug348199TestLanguage.g:437:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            // InternalBug348199TestLanguage.g:438:2: ( rule__Timeperiod__Alternatives_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3()); 
            // InternalBug348199TestLanguage.g:439:2: ( rule__Timeperiod__Alternatives_3 )
            // InternalBug348199TestLanguage.g:439:3: rule__Timeperiod__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__0"
    // InternalBug348199TestLanguage.g:448:1: rule__Timeperiod__Group_3_0__0 : rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:452:1: ( rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 )
            // InternalBug348199TestLanguage.g:453:2: rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0__0__Impl"
    // InternalBug348199TestLanguage.g:460:1: rule__Timeperiod__Group_3_0__0__Impl : ( '1' ) ;
    public final void rule__Timeperiod__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:464:1: ( ( '1' ) )
            // InternalBug348199TestLanguage.g:465:1: ( '1' )
            {
            // InternalBug348199TestLanguage.g:465:1: ( '1' )
            // InternalBug348199TestLanguage.g:466:2: '1'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitOneKeyword_3_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitOneKeyword_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__1"
    // InternalBug348199TestLanguage.g:475:1: rule__Timeperiod__Group_3_0__1 : rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:479:1: ( rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 )
            // InternalBug348199TestLanguage.g:480:2: rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0__1__Impl"
    // InternalBug348199TestLanguage.g:487:1: rule__Timeperiod__Group_3_0__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:491:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:492:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:492:1: ( '{' )
            // InternalBug348199TestLanguage.g:493:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_0_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__2"
    // InternalBug348199TestLanguage.g:502:1: rule__Timeperiod__Group_3_0__2 : rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:506:1: ( rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 )
            // InternalBug348199TestLanguage.g:507:2: rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_0__2__Impl"
    // InternalBug348199TestLanguage.g:514:1: rule__Timeperiod__Group_3_0__2__Impl : ( ( rule__Timeperiod__Group_3_0_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:518:1: ( ( ( rule__Timeperiod__Group_3_0_2__0 )* ) )
            // InternalBug348199TestLanguage.g:519:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:519:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            // InternalBug348199TestLanguage.g:520:2: ( rule__Timeperiod__Group_3_0_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_2()); 
            // InternalBug348199TestLanguage.g:521:2: ( rule__Timeperiod__Group_3_0_2__0 )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:521:3: rule__Timeperiod__Group_3_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__3"
    // InternalBug348199TestLanguage.g:529:1: rule__Timeperiod__Group_3_0__3 : rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 ;
    public final void rule__Timeperiod__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:533:1: ( rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 )
            // InternalBug348199TestLanguage.g:534:2: rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_0__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_0__3__Impl"
    // InternalBug348199TestLanguage.g:541:1: rule__Timeperiod__Group_3_0__3__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) ;
    public final void rule__Timeperiod__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:545:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) )
            // InternalBug348199TestLanguage.g:546:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            {
            // InternalBug348199TestLanguage.g:546:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            // InternalBug348199TestLanguage.g:547:2: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()); 
            // InternalBug348199TestLanguage.g:548:2: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            // InternalBug348199TestLanguage.g:548:3: rule__Timeperiod__UnorderedGroup_3_0_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_0_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__4"
    // InternalBug348199TestLanguage.g:556:1: rule__Timeperiod__Group_3_0__4 : rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 ;
    public final void rule__Timeperiod__Group_3_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:560:1: ( rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 )
            // InternalBug348199TestLanguage.g:561:2: rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_0__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__4"


    // $ANTLR start "rule__Timeperiod__Group_3_0__4__Impl"
    // InternalBug348199TestLanguage.g:568:1: rule__Timeperiod__Group_3_0__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:572:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:573:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:573:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:574:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:574:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:575:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:576:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:576:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 

            }

            // InternalBug348199TestLanguage.g:579:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:580:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:581:3: ( RULE_NL )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_NL) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:581:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0__5"
    // InternalBug348199TestLanguage.g:590:1: rule__Timeperiod__Group_3_0__5 : rule__Timeperiod__Group_3_0__5__Impl ;
    public final void rule__Timeperiod__Group_3_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:594:1: ( rule__Timeperiod__Group_3_0__5__Impl )
            // InternalBug348199TestLanguage.g:595:2: rule__Timeperiod__Group_3_0__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__5"


    // $ANTLR start "rule__Timeperiod__Group_3_0__5__Impl"
    // InternalBug348199TestLanguage.g:601:1: rule__Timeperiod__Group_3_0__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:605:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:606:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:606:1: ( '}' )
            // InternalBug348199TestLanguage.g:607:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_0_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_0_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_2__0"
    // InternalBug348199TestLanguage.g:617:1: rule__Timeperiod__Group_3_0_2__0 : rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 ;
    public final void rule__Timeperiod__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:621:1: ( rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 )
            // InternalBug348199TestLanguage.g:622:2: rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Timeperiod__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_2__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_2__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0_2__0__Impl"
    // InternalBug348199TestLanguage.g:629:1: rule__Timeperiod__Group_3_0_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:633:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:634:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:634:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:635:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:635:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:636:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:637:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:637:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 

            }

            // InternalBug348199TestLanguage.g:640:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:641:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:642:3: ( RULE_NL )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:642:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_2__1"
    // InternalBug348199TestLanguage.g:651:1: rule__Timeperiod__Group_3_0_2__1 : rule__Timeperiod__Group_3_0_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:655:1: ( rule__Timeperiod__Group_3_0_2__1__Impl )
            // InternalBug348199TestLanguage.g:656:2: rule__Timeperiod__Group_3_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_2__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_2__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0_2__1__Impl"
    // InternalBug348199TestLanguage.g:662:1: rule__Timeperiod__Group_3_0_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:666:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) )
            // InternalBug348199TestLanguage.g:667:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:667:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            // InternalBug348199TestLanguage.g:668:2: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_2_1()); 
            // InternalBug348199TestLanguage.g:669:2: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            // InternalBug348199TestLanguage.g:669:3: rule__Timeperiod__TimeAssignment_3_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_2_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__0"
    // InternalBug348199TestLanguage.g:678:1: rule__Timeperiod__Group_3_0_3_0__0 : rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:682:1: ( rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 )
            // InternalBug348199TestLanguage.g:683:2: rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Timeperiod__Group_3_0_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__0__Impl"
    // InternalBug348199TestLanguage.g:690:1: rule__Timeperiod__Group_3_0_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:694:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:695:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:695:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:696:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:696:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:697:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:698:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:698:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:701:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:702:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:703:3: ( RULE_NL )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:703:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__1"
    // InternalBug348199TestLanguage.g:712:1: rule__Timeperiod__Group_3_0_3_0__1 : rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:716:1: ( rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 )
            // InternalBug348199TestLanguage.g:717:2: rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_0_3_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__1__Impl"
    // InternalBug348199TestLanguage.g:724:1: rule__Timeperiod__Group_3_0_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:728:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:729:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:729:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:730:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_0_3_0_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_0_3_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__2"
    // InternalBug348199TestLanguage.g:739:1: rule__Timeperiod__Group_3_0_3_0__2 : rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:743:1: ( rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 )
            // InternalBug348199TestLanguage.g:744:2: rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_0_3_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__2__Impl"
    // InternalBug348199TestLanguage.g:751:1: rule__Timeperiod__Group_3_0_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:755:1: ( ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:756:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:756:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            // InternalBug348199TestLanguage.g:757:2: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_0_3_0_2()); 
            // InternalBug348199TestLanguage.g:758:2: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            // InternalBug348199TestLanguage.g:758:3: rule__Timeperiod__NameAssignment_3_0_3_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_0_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_0_3_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__3"
    // InternalBug348199TestLanguage.g:766:1: rule__Timeperiod__Group_3_0_3_0__3 : rule__Timeperiod__Group_3_0_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:770:1: ( rule__Timeperiod__Group_3_0_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:771:2: rule__Timeperiod__Group_3_0_3_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0__3__Impl"
    // InternalBug348199TestLanguage.g:777:1: rule__Timeperiod__Group_3_0_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:781:1: ( ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:782:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:782:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:783:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0_3()); 
            // InternalBug348199TestLanguage.g:784:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:784:3: rule__Timeperiod__Group_3_0_3_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_0_3_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0_3__0"
    // InternalBug348199TestLanguage.g:793:1: rule__Timeperiod__Group_3_0_3_0_3__0 : rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:797:1: ( rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 )
            // InternalBug348199TestLanguage.g:798:2: rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_0_3_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:805:1: rule__Timeperiod__Group_3_0_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:809:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:810:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:810:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:811:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:811:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:812:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:813:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:813:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:816:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:817:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:818:3: ( RULE_NL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:818:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0_3__1"
    // InternalBug348199TestLanguage.g:827:1: rule__Timeperiod__Group_3_0_3_0_3__1 : rule__Timeperiod__Group_3_0_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:831:1: ( rule__Timeperiod__Group_3_0_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:832:2: rule__Timeperiod__Group_3_0_3_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:838:1: rule__Timeperiod__Group_3_0_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:842:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:843:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:843:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:844:2: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:845:2: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            // InternalBug348199TestLanguage.g:845:3: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_0_3_0_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__0"
    // InternalBug348199TestLanguage.g:854:1: rule__Timeperiod__Group_3_0_3_1__0 : rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:858:1: ( rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 )
            // InternalBug348199TestLanguage.g:859:2: rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Timeperiod__Group_3_0_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__0__Impl"
    // InternalBug348199TestLanguage.g:866:1: rule__Timeperiod__Group_3_0_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:870:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:871:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:871:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:872:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:872:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:873:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:874:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:874:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:877:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:878:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:879:3: ( RULE_NL )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:879:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__1"
    // InternalBug348199TestLanguage.g:888:1: rule__Timeperiod__Group_3_0_3_1__1 : rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 ;
    public final void rule__Timeperiod__Group_3_0_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:892:1: ( rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 )
            // InternalBug348199TestLanguage.g:893:2: rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_0_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__1__Impl"
    // InternalBug348199TestLanguage.g:900:1: rule__Timeperiod__Group_3_0_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:904:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:905:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:905:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:906:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_0_3_1_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_0_3_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__2"
    // InternalBug348199TestLanguage.g:915:1: rule__Timeperiod__Group_3_0_3_1__2 : rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 ;
    public final void rule__Timeperiod__Group_3_0_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:919:1: ( rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 )
            // InternalBug348199TestLanguage.g:920:2: rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_0_3_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__2__Impl"
    // InternalBug348199TestLanguage.g:927:1: rule__Timeperiod__Group_3_0_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:931:1: ( ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:932:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:932:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            // InternalBug348199TestLanguage.g:933:2: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_0_3_1_2()); 
            // InternalBug348199TestLanguage.g:934:2: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            // InternalBug348199TestLanguage.g:934:3: rule__Timeperiod__AliasAssignment_3_0_3_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_0_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_0_3_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__3"
    // InternalBug348199TestLanguage.g:942:1: rule__Timeperiod__Group_3_0_3_1__3 : rule__Timeperiod__Group_3_0_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:946:1: ( rule__Timeperiod__Group_3_0_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:947:2: rule__Timeperiod__Group_3_0_3_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1__3__Impl"
    // InternalBug348199TestLanguage.g:953:1: rule__Timeperiod__Group_3_0_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:957:1: ( ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:958:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:958:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:959:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1_3()); 
            // InternalBug348199TestLanguage.g:960:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:960:3: rule__Timeperiod__Group_3_0_3_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_0_3_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1_3__0"
    // InternalBug348199TestLanguage.g:969:1: rule__Timeperiod__Group_3_0_3_1_3__0 : rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:973:1: ( rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 )
            // InternalBug348199TestLanguage.g:974:2: rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_0_3_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:981:1: rule__Timeperiod__Group_3_0_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:985:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:986:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:986:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:987:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:987:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:988:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:989:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:989:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:992:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:993:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:994:3: ( RULE_NL )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:994:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1_3__1"
    // InternalBug348199TestLanguage.g:1003:1: rule__Timeperiod__Group_3_0_3_1_3__1 : rule__Timeperiod__Group_3_0_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1007:1: ( rule__Timeperiod__Group_3_0_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1008:2: rule__Timeperiod__Group_3_0_3_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_0_3_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_0_3_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:1014:1: rule__Timeperiod__Group_3_0_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1018:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1019:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1019:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1020:2: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1021:2: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1021:3: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_0_3_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_0_3_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__0"
    // InternalBug348199TestLanguage.g:1030:1: rule__Timeperiod__Group_3_1__0 : rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1034:1: ( rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 )
            // InternalBug348199TestLanguage.g:1035:2: rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1__0__Impl"
    // InternalBug348199TestLanguage.g:1042:1: rule__Timeperiod__Group_3_1__0__Impl : ( '2' ) ;
    public final void rule__Timeperiod__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1046:1: ( ( '2' ) )
            // InternalBug348199TestLanguage.g:1047:1: ( '2' )
            {
            // InternalBug348199TestLanguage.g:1047:1: ( '2' )
            // InternalBug348199TestLanguage.g:1048:2: '2'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitTwoKeyword_3_1_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitTwoKeyword_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__1"
    // InternalBug348199TestLanguage.g:1057:1: rule__Timeperiod__Group_3_1__1 : rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1061:1: ( rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 )
            // InternalBug348199TestLanguage.g:1062:2: rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1__1__Impl"
    // InternalBug348199TestLanguage.g:1069:1: rule__Timeperiod__Group_3_1__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1073:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1074:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1074:1: ( '{' )
            // InternalBug348199TestLanguage.g:1075:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_1_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__2"
    // InternalBug348199TestLanguage.g:1084:1: rule__Timeperiod__Group_3_1__2 : rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1088:1: ( rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 )
            // InternalBug348199TestLanguage.g:1089:2: rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_1__2__Impl"
    // InternalBug348199TestLanguage.g:1096:1: rule__Timeperiod__Group_3_1__2__Impl : ( ( rule__Timeperiod__Group_3_1_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1100:1: ( ( ( rule__Timeperiod__Group_3_1_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1101:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1101:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            // InternalBug348199TestLanguage.g:1102:2: ( rule__Timeperiod__Group_3_1_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_2()); 
            // InternalBug348199TestLanguage.g:1103:2: ( rule__Timeperiod__Group_3_1_2__0 )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1103:3: rule__Timeperiod__Group_3_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__3"
    // InternalBug348199TestLanguage.g:1111:1: rule__Timeperiod__Group_3_1__3 : rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 ;
    public final void rule__Timeperiod__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1115:1: ( rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 )
            // InternalBug348199TestLanguage.g:1116:2: rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_1__3__Impl"
    // InternalBug348199TestLanguage.g:1123:1: rule__Timeperiod__Group_3_1__3__Impl : ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) ;
    public final void rule__Timeperiod__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1127:1: ( ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) )
            // InternalBug348199TestLanguage.g:1128:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            {
            // InternalBug348199TestLanguage.g:1128:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            // InternalBug348199TestLanguage.g:1129:2: ( rule__Timeperiod__Alternatives_3_1_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_1_3()); 
            // InternalBug348199TestLanguage.g:1130:2: ( rule__Timeperiod__Alternatives_3_1_3 )
            // InternalBug348199TestLanguage.g:1130:3: rule__Timeperiod__Alternatives_3_1_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Alternatives_3_1_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__4"
    // InternalBug348199TestLanguage.g:1138:1: rule__Timeperiod__Group_3_1__4 : rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 ;
    public final void rule__Timeperiod__Group_3_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1142:1: ( rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 )
            // InternalBug348199TestLanguage.g:1143:2: rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_1__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__4"


    // $ANTLR start "rule__Timeperiod__Group_3_1__4__Impl"
    // InternalBug348199TestLanguage.g:1150:1: rule__Timeperiod__Group_3_1__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1154:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1155:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1155:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1156:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1156:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1157:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1158:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1158:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 

            }

            // InternalBug348199TestLanguage.g:1161:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1162:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1163:3: ( RULE_NL )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NL) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1163:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1__5"
    // InternalBug348199TestLanguage.g:1172:1: rule__Timeperiod__Group_3_1__5 : rule__Timeperiod__Group_3_1__5__Impl ;
    public final void rule__Timeperiod__Group_3_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1176:1: ( rule__Timeperiod__Group_3_1__5__Impl )
            // InternalBug348199TestLanguage.g:1177:2: rule__Timeperiod__Group_3_1__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__5"


    // $ANTLR start "rule__Timeperiod__Group_3_1__5__Impl"
    // InternalBug348199TestLanguage.g:1183:1: rule__Timeperiod__Group_3_1__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1187:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:1188:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:1188:1: ( '}' )
            // InternalBug348199TestLanguage.g:1189:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_1_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_1_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_2__0"
    // InternalBug348199TestLanguage.g:1199:1: rule__Timeperiod__Group_3_1_2__0 : rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 ;
    public final void rule__Timeperiod__Group_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1203:1: ( rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 )
            // InternalBug348199TestLanguage.g:1204:2: rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Timeperiod__Group_3_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_2__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_2__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1_2__0__Impl"
    // InternalBug348199TestLanguage.g:1211:1: rule__Timeperiod__Group_3_1_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1215:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1216:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1216:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1217:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1217:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1218:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1219:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1219:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 

            }

            // InternalBug348199TestLanguage.g:1222:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1223:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1224:3: ( RULE_NL )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NL) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1224:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_2__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_2__1"
    // InternalBug348199TestLanguage.g:1233:1: rule__Timeperiod__Group_3_1_2__1 : rule__Timeperiod__Group_3_1_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1237:1: ( rule__Timeperiod__Group_3_1_2__1__Impl )
            // InternalBug348199TestLanguage.g:1238:2: rule__Timeperiod__Group_3_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_2__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_2__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1_2__1__Impl"
    // InternalBug348199TestLanguage.g:1244:1: rule__Timeperiod__Group_3_1_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1248:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) )
            // InternalBug348199TestLanguage.g:1249:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:1249:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            // InternalBug348199TestLanguage.g:1250:2: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_2_1()); 
            // InternalBug348199TestLanguage.g:1251:2: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            // InternalBug348199TestLanguage.g:1251:3: rule__Timeperiod__TimeAssignment_3_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_2_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_2__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__0"
    // InternalBug348199TestLanguage.g:1260:1: rule__Timeperiod__Group_3_1_3_0__0 : rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1264:1: ( rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 )
            // InternalBug348199TestLanguage.g:1265:2: rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Timeperiod__Group_3_1_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__0__Impl"
    // InternalBug348199TestLanguage.g:1272:1: rule__Timeperiod__Group_3_1_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1276:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1277:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1277:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1278:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1278:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1279:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1280:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1280:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:1283:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1284:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1285:3: ( RULE_NL )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NL) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1285:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__1"
    // InternalBug348199TestLanguage.g:1294:1: rule__Timeperiod__Group_3_1_3_0__1 : rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 ;
    public final void rule__Timeperiod__Group_3_1_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1298:1: ( rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 )
            // InternalBug348199TestLanguage.g:1299:2: rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_1_3_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__1__Impl"
    // InternalBug348199TestLanguage.g:1306:1: rule__Timeperiod__Group_3_1_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1310:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:1311:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:1311:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:1312:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_1_3_0_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_1_3_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__2"
    // InternalBug348199TestLanguage.g:1321:1: rule__Timeperiod__Group_3_1_3_0__2 : rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 ;
    public final void rule__Timeperiod__Group_3_1_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1325:1: ( rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 )
            // InternalBug348199TestLanguage.g:1326:2: rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_1_3_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__2__Impl"
    // InternalBug348199TestLanguage.g:1333:1: rule__Timeperiod__Group_3_1_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1337:1: ( ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:1338:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:1338:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            // InternalBug348199TestLanguage.g:1339:2: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_1_3_0_2()); 
            // InternalBug348199TestLanguage.g:1340:2: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            // InternalBug348199TestLanguage.g:1340:3: rule__Timeperiod__NameAssignment_3_1_3_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_1_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_1_3_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__3"
    // InternalBug348199TestLanguage.g:1348:1: rule__Timeperiod__Group_3_1_3_0__3 : rule__Timeperiod__Group_3_1_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1352:1: ( rule__Timeperiod__Group_3_1_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:1353:2: rule__Timeperiod__Group_3_1_3_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0__3__Impl"
    // InternalBug348199TestLanguage.g:1359:1: rule__Timeperiod__Group_3_1_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1363:1: ( ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1364:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1364:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:1365:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0_3()); 
            // InternalBug348199TestLanguage.g:1366:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1366:3: rule__Timeperiod__Group_3_1_3_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_1_3_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0_3__0"
    // InternalBug348199TestLanguage.g:1375:1: rule__Timeperiod__Group_3_1_3_0_3__0 : rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1379:1: ( rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 )
            // InternalBug348199TestLanguage.g:1380:2: rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_1_3_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:1387:1: rule__Timeperiod__Group_3_1_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1391:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1392:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1392:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1393:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1393:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1394:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1395:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1395:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1398:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1399:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1400:3: ( RULE_NL )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1400:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0_3__1"
    // InternalBug348199TestLanguage.g:1409:1: rule__Timeperiod__Group_3_1_3_0_3__1 : rule__Timeperiod__Group_3_1_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1413:1: ( rule__Timeperiod__Group_3_1_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:1414:2: rule__Timeperiod__Group_3_1_3_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:1420:1: rule__Timeperiod__Group_3_1_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1424:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1425:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1425:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:1426:2: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:1427:2: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            // InternalBug348199TestLanguage.g:1427:3: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_1_3_0_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__0"
    // InternalBug348199TestLanguage.g:1436:1: rule__Timeperiod__Group_3_1_3_1__0 : rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1440:1: ( rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 )
            // InternalBug348199TestLanguage.g:1441:2: rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Timeperiod__Group_3_1_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__0__Impl"
    // InternalBug348199TestLanguage.g:1448:1: rule__Timeperiod__Group_3_1_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1452:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1453:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1453:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1454:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1454:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1455:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1456:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1456:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:1459:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1460:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1461:3: ( RULE_NL )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NL) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1461:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__1"
    // InternalBug348199TestLanguage.g:1470:1: rule__Timeperiod__Group_3_1_3_1__1 : rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1474:1: ( rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 )
            // InternalBug348199TestLanguage.g:1475:2: rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_1_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__1__Impl"
    // InternalBug348199TestLanguage.g:1482:1: rule__Timeperiod__Group_3_1_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1486:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:1487:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:1487:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:1488:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_1_3_1_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_1_3_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__2"
    // InternalBug348199TestLanguage.g:1497:1: rule__Timeperiod__Group_3_1_3_1__2 : rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1501:1: ( rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 )
            // InternalBug348199TestLanguage.g:1502:2: rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_1_3_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__2__Impl"
    // InternalBug348199TestLanguage.g:1509:1: rule__Timeperiod__Group_3_1_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1513:1: ( ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:1514:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:1514:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            // InternalBug348199TestLanguage.g:1515:2: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_1_3_1_2()); 
            // InternalBug348199TestLanguage.g:1516:2: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            // InternalBug348199TestLanguage.g:1516:3: rule__Timeperiod__AliasAssignment_3_1_3_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_1_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_1_3_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__3"
    // InternalBug348199TestLanguage.g:1524:1: rule__Timeperiod__Group_3_1_3_1__3 : rule__Timeperiod__Group_3_1_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1528:1: ( rule__Timeperiod__Group_3_1_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:1529:2: rule__Timeperiod__Group_3_1_3_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1__3__Impl"
    // InternalBug348199TestLanguage.g:1535:1: rule__Timeperiod__Group_3_1_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1539:1: ( ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1540:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1540:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:1541:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1_3()); 
            // InternalBug348199TestLanguage.g:1542:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1542:3: rule__Timeperiod__Group_3_1_3_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_1_3_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1_3__0"
    // InternalBug348199TestLanguage.g:1551:1: rule__Timeperiod__Group_3_1_3_1_3__0 : rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1555:1: ( rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 )
            // InternalBug348199TestLanguage.g:1556:2: rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_1_3_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:1563:1: rule__Timeperiod__Group_3_1_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1567:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1568:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1568:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1569:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1569:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1570:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1571:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1571:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1574:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1575:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1576:3: ( RULE_NL )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_NL) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1576:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1_3__1"
    // InternalBug348199TestLanguage.g:1585:1: rule__Timeperiod__Group_3_1_3_1_3__1 : rule__Timeperiod__Group_3_1_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1589:1: ( rule__Timeperiod__Group_3_1_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1590:2: rule__Timeperiod__Group_3_1_3_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_1_3_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_1_3_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:1596:1: rule__Timeperiod__Group_3_1_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1600:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1601:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1601:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1602:2: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1603:2: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1603:3: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_1_3_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_1_3_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__0"
    // InternalBug348199TestLanguage.g:1612:1: rule__Timeperiod__Group_3_2__0 : rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 ;
    public final void rule__Timeperiod__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1616:1: ( rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 )
            // InternalBug348199TestLanguage.g:1617:2: rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2__0__Impl"
    // InternalBug348199TestLanguage.g:1624:1: rule__Timeperiod__Group_3_2__0__Impl : ( '3' ) ;
    public final void rule__Timeperiod__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1628:1: ( ( '3' ) )
            // InternalBug348199TestLanguage.g:1629:1: ( '3' )
            {
            // InternalBug348199TestLanguage.g:1629:1: ( '3' )
            // InternalBug348199TestLanguage.g:1630:2: '3'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitThreeKeyword_3_2_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitThreeKeyword_3_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__1"
    // InternalBug348199TestLanguage.g:1639:1: rule__Timeperiod__Group_3_2__1 : rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 ;
    public final void rule__Timeperiod__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1643:1: ( rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 )
            // InternalBug348199TestLanguage.g:1644:2: rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2__1__Impl"
    // InternalBug348199TestLanguage.g:1651:1: rule__Timeperiod__Group_3_2__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1655:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1656:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1656:1: ( '{' )
            // InternalBug348199TestLanguage.g:1657:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_2_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_2_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__2"
    // InternalBug348199TestLanguage.g:1666:1: rule__Timeperiod__Group_3_2__2 : rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 ;
    public final void rule__Timeperiod__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1670:1: ( rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 )
            // InternalBug348199TestLanguage.g:1671:2: rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__2"


    // $ANTLR start "rule__Timeperiod__Group_3_2__2__Impl"
    // InternalBug348199TestLanguage.g:1678:1: rule__Timeperiod__Group_3_2__2__Impl : ( ( rule__Timeperiod__Group_3_2_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1682:1: ( ( ( rule__Timeperiod__Group_3_2_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1683:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1683:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            // InternalBug348199TestLanguage.g:1684:2: ( rule__Timeperiod__Group_3_2_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_2()); 
            // InternalBug348199TestLanguage.g:1685:2: ( rule__Timeperiod__Group_3_2_2__0 )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1685:3: rule__Timeperiod__Group_3_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_2_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__3"
    // InternalBug348199TestLanguage.g:1693:1: rule__Timeperiod__Group_3_2__3 : rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 ;
    public final void rule__Timeperiod__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1697:1: ( rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 )
            // InternalBug348199TestLanguage.g:1698:2: rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__3"


    // $ANTLR start "rule__Timeperiod__Group_3_2__3__Impl"
    // InternalBug348199TestLanguage.g:1705:1: rule__Timeperiod__Group_3_2__3__Impl : ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1709:1: ( ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) )
            // InternalBug348199TestLanguage.g:1710:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            {
            // InternalBug348199TestLanguage.g:1710:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            // InternalBug348199TestLanguage.g:1711:2: ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            {
            // InternalBug348199TestLanguage.g:1711:2: ( ( rule__Timeperiod__Alternatives_3_2_3 ) )
            // InternalBug348199TestLanguage.g:1712:3: ( rule__Timeperiod__Alternatives_3_2_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1713:3: ( rule__Timeperiod__Alternatives_3_2_3 )
            // InternalBug348199TestLanguage.g:1713:4: rule__Timeperiod__Alternatives_3_2_3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__Alternatives_3_2_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 

            }

            // InternalBug348199TestLanguage.g:1716:2: ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            // InternalBug348199TestLanguage.g:1717:3: ( rule__Timeperiod__Alternatives_3_2_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1718:3: ( rule__Timeperiod__Alternatives_3_2_3 )*
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1718:4: rule__Timeperiod__Alternatives_3_2_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Alternatives_3_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__4"
    // InternalBug348199TestLanguage.g:1727:1: rule__Timeperiod__Group_3_2__4 : rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 ;
    public final void rule__Timeperiod__Group_3_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1731:1: ( rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 )
            // InternalBug348199TestLanguage.g:1732:2: rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_2__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__4"


    // $ANTLR start "rule__Timeperiod__Group_3_2__4__Impl"
    // InternalBug348199TestLanguage.g:1739:1: rule__Timeperiod__Group_3_2__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1743:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1744:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1744:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1745:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1745:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1746:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1747:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1747:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 

            }

            // InternalBug348199TestLanguage.g:1750:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1751:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1752:3: ( RULE_NL )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_NL) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1752:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2__5"
    // InternalBug348199TestLanguage.g:1761:1: rule__Timeperiod__Group_3_2__5 : rule__Timeperiod__Group_3_2__5__Impl ;
    public final void rule__Timeperiod__Group_3_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1765:1: ( rule__Timeperiod__Group_3_2__5__Impl )
            // InternalBug348199TestLanguage.g:1766:2: rule__Timeperiod__Group_3_2__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__5"


    // $ANTLR start "rule__Timeperiod__Group_3_2__5__Impl"
    // InternalBug348199TestLanguage.g:1772:1: rule__Timeperiod__Group_3_2__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1776:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:1777:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:1777:1: ( '}' )
            // InternalBug348199TestLanguage.g:1778:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_2_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_2_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_2__0"
    // InternalBug348199TestLanguage.g:1788:1: rule__Timeperiod__Group_3_2_2__0 : rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 ;
    public final void rule__Timeperiod__Group_3_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1792:1: ( rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 )
            // InternalBug348199TestLanguage.g:1793:2: rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Timeperiod__Group_3_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_2__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_2__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2_2__0__Impl"
    // InternalBug348199TestLanguage.g:1800:1: rule__Timeperiod__Group_3_2_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1804:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1805:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1805:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1806:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1806:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1807:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:1808:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1808:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 

            }

            // InternalBug348199TestLanguage.g:1811:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1812:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:1813:3: ( RULE_NL )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_NL) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1813:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_2__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_2__1"
    // InternalBug348199TestLanguage.g:1822:1: rule__Timeperiod__Group_3_2_2__1 : rule__Timeperiod__Group_3_2_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1826:1: ( rule__Timeperiod__Group_3_2_2__1__Impl )
            // InternalBug348199TestLanguage.g:1827:2: rule__Timeperiod__Group_3_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_2__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_2__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2_2__1__Impl"
    // InternalBug348199TestLanguage.g:1833:1: rule__Timeperiod__Group_3_2_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1837:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) )
            // InternalBug348199TestLanguage.g:1838:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:1838:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            // InternalBug348199TestLanguage.g:1839:2: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_2_1()); 
            // InternalBug348199TestLanguage.g:1840:2: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            // InternalBug348199TestLanguage.g:1840:3: rule__Timeperiod__TimeAssignment_3_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_2_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_2__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__0"
    // InternalBug348199TestLanguage.g:1849:1: rule__Timeperiod__Group_3_2_3_0__0 : rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1853:1: ( rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 )
            // InternalBug348199TestLanguage.g:1854:2: rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Timeperiod__Group_3_2_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__0__Impl"
    // InternalBug348199TestLanguage.g:1861:1: rule__Timeperiod__Group_3_2_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1865:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1866:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1866:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1867:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1867:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1868:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:1869:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1869:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:1872:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1873:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:1874:3: ( RULE_NL )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_NL) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1874:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__1"
    // InternalBug348199TestLanguage.g:1883:1: rule__Timeperiod__Group_3_2_3_0__1 : rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 ;
    public final void rule__Timeperiod__Group_3_2_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1887:1: ( rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 )
            // InternalBug348199TestLanguage.g:1888:2: rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_2_3_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__1__Impl"
    // InternalBug348199TestLanguage.g:1895:1: rule__Timeperiod__Group_3_2_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1899:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:1900:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:1900:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:1901:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_2_3_0_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_2_3_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__2"
    // InternalBug348199TestLanguage.g:1910:1: rule__Timeperiod__Group_3_2_3_0__2 : rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 ;
    public final void rule__Timeperiod__Group_3_2_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1914:1: ( rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 )
            // InternalBug348199TestLanguage.g:1915:2: rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_2_3_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__2__Impl"
    // InternalBug348199TestLanguage.g:1922:1: rule__Timeperiod__Group_3_2_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1926:1: ( ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:1927:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:1927:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            // InternalBug348199TestLanguage.g:1928:2: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_2_3_0_2()); 
            // InternalBug348199TestLanguage.g:1929:2: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            // InternalBug348199TestLanguage.g:1929:3: rule__Timeperiod__NameAssignment_3_2_3_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_2_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_2_3_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__3"
    // InternalBug348199TestLanguage.g:1937:1: rule__Timeperiod__Group_3_2_3_0__3 : rule__Timeperiod__Group_3_2_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1941:1: ( rule__Timeperiod__Group_3_2_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:1942:2: rule__Timeperiod__Group_3_2_3_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0__3__Impl"
    // InternalBug348199TestLanguage.g:1948:1: rule__Timeperiod__Group_3_2_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1952:1: ( ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1953:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1953:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:1954:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0_3()); 
            // InternalBug348199TestLanguage.g:1955:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1955:3: rule__Timeperiod__Group_3_2_3_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_2_3_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0_3__0"
    // InternalBug348199TestLanguage.g:1964:1: rule__Timeperiod__Group_3_2_3_0_3__0 : rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1968:1: ( rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 )
            // InternalBug348199TestLanguage.g:1969:2: rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_2_3_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:1976:1: rule__Timeperiod__Group_3_2_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1980:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1982:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1982:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1983:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1984:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1984:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1987:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1988:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1989:3: ( RULE_NL )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NL) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1989:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0_3__1"
    // InternalBug348199TestLanguage.g:1998:1: rule__Timeperiod__Group_3_2_3_0_3__1 : rule__Timeperiod__Group_3_2_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2002:1: ( rule__Timeperiod__Group_3_2_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:2003:2: rule__Timeperiod__Group_3_2_3_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:2009:1: rule__Timeperiod__Group_3_2_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2013:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2014:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2014:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2015:2: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2016:2: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2016:3: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_2_3_0_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__0"
    // InternalBug348199TestLanguage.g:2025:1: rule__Timeperiod__Group_3_2_3_1__0 : rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2029:1: ( rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 )
            // InternalBug348199TestLanguage.g:2030:2: rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Timeperiod__Group_3_2_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__0__Impl"
    // InternalBug348199TestLanguage.g:2037:1: rule__Timeperiod__Group_3_2_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2041:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2042:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2042:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2043:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2043:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2044:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2045:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2045:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2048:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2049:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2050:3: ( RULE_NL )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_NL) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2050:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__1"
    // InternalBug348199TestLanguage.g:2059:1: rule__Timeperiod__Group_3_2_3_1__1 : rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 ;
    public final void rule__Timeperiod__Group_3_2_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2063:1: ( rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 )
            // InternalBug348199TestLanguage.g:2064:2: rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_2_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__1__Impl"
    // InternalBug348199TestLanguage.g:2071:1: rule__Timeperiod__Group_3_2_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2075:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:2076:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:2076:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:2077:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_2_3_1_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_2_3_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__2"
    // InternalBug348199TestLanguage.g:2086:1: rule__Timeperiod__Group_3_2_3_1__2 : rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 ;
    public final void rule__Timeperiod__Group_3_2_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2090:1: ( rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 )
            // InternalBug348199TestLanguage.g:2091:2: rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_2_3_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__2__Impl"
    // InternalBug348199TestLanguage.g:2098:1: rule__Timeperiod__Group_3_2_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2102:1: ( ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:2103:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:2103:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            // InternalBug348199TestLanguage.g:2104:2: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_2_3_1_2()); 
            // InternalBug348199TestLanguage.g:2105:2: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            // InternalBug348199TestLanguage.g:2105:3: rule__Timeperiod__AliasAssignment_3_2_3_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_2_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_2_3_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__3"
    // InternalBug348199TestLanguage.g:2113:1: rule__Timeperiod__Group_3_2_3_1__3 : rule__Timeperiod__Group_3_2_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2117:1: ( rule__Timeperiod__Group_3_2_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:2118:2: rule__Timeperiod__Group_3_2_3_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1__3__Impl"
    // InternalBug348199TestLanguage.g:2124:1: rule__Timeperiod__Group_3_2_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2128:1: ( ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2129:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2129:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:2130:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1_3()); 
            // InternalBug348199TestLanguage.g:2131:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2131:3: rule__Timeperiod__Group_3_2_3_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_2_3_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1_3__0"
    // InternalBug348199TestLanguage.g:2140:1: rule__Timeperiod__Group_3_2_3_1_3__0 : rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2144:1: ( rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 )
            // InternalBug348199TestLanguage.g:2145:2: rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_2_3_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:2152:1: rule__Timeperiod__Group_3_2_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2156:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2157:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2157:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2158:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2158:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2159:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2160:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2160:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2163:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2164:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2165:3: ( RULE_NL )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2165:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1_3__1"
    // InternalBug348199TestLanguage.g:2174:1: rule__Timeperiod__Group_3_2_3_1_3__1 : rule__Timeperiod__Group_3_2_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2178:1: ( rule__Timeperiod__Group_3_2_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:2179:2: rule__Timeperiod__Group_3_2_3_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_2_3_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_2_3_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:2185:1: rule__Timeperiod__Group_3_2_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2189:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2190:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2190:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:2191:2: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:2192:2: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            // InternalBug348199TestLanguage.g:2192:3: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_2_3_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_2_3_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__0"
    // InternalBug348199TestLanguage.g:2201:1: rule__Timeperiod__Group_3_3__0 : rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 ;
    public final void rule__Timeperiod__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2205:1: ( rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 )
            // InternalBug348199TestLanguage.g:2206:2: rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3__0__Impl"
    // InternalBug348199TestLanguage.g:2213:1: rule__Timeperiod__Group_3_3__0__Impl : ( '4' ) ;
    public final void rule__Timeperiod__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2217:1: ( ( '4' ) )
            // InternalBug348199TestLanguage.g:2218:1: ( '4' )
            {
            // InternalBug348199TestLanguage.g:2218:1: ( '4' )
            // InternalBug348199TestLanguage.g:2219:2: '4'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitFourKeyword_3_3_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitFourKeyword_3_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__1"
    // InternalBug348199TestLanguage.g:2228:1: rule__Timeperiod__Group_3_3__1 : rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 ;
    public final void rule__Timeperiod__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2232:1: ( rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 )
            // InternalBug348199TestLanguage.g:2233:2: rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3__1__Impl"
    // InternalBug348199TestLanguage.g:2240:1: rule__Timeperiod__Group_3_3__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2244:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:2245:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:2245:1: ( '{' )
            // InternalBug348199TestLanguage.g:2246:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_3_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__2"
    // InternalBug348199TestLanguage.g:2255:1: rule__Timeperiod__Group_3_3__2 : rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 ;
    public final void rule__Timeperiod__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2259:1: ( rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 )
            // InternalBug348199TestLanguage.g:2260:2: rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__2"


    // $ANTLR start "rule__Timeperiod__Group_3_3__2__Impl"
    // InternalBug348199TestLanguage.g:2267:1: rule__Timeperiod__Group_3_3__2__Impl : ( ( rule__Timeperiod__Group_3_3_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2271:1: ( ( ( rule__Timeperiod__Group_3_3_2__0 )* ) )
            // InternalBug348199TestLanguage.g:2272:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:2272:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            // InternalBug348199TestLanguage.g:2273:2: ( rule__Timeperiod__Group_3_3_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_2()); 
            // InternalBug348199TestLanguage.g:2274:2: ( rule__Timeperiod__Group_3_3_2__0 )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2274:3: rule__Timeperiod__Group_3_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_3_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__3"
    // InternalBug348199TestLanguage.g:2282:1: rule__Timeperiod__Group_3_3__3 : rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 ;
    public final void rule__Timeperiod__Group_3_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2286:1: ( rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 )
            // InternalBug348199TestLanguage.g:2287:2: rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_3__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__3"


    // $ANTLR start "rule__Timeperiod__Group_3_3__3__Impl"
    // InternalBug348199TestLanguage.g:2294:1: rule__Timeperiod__Group_3_3__3__Impl : ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) ;
    public final void rule__Timeperiod__Group_3_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2298:1: ( ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) )
            // InternalBug348199TestLanguage.g:2299:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            {
            // InternalBug348199TestLanguage.g:2299:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            // InternalBug348199TestLanguage.g:2300:2: ( rule__Timeperiod__Alternatives_3_3_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_3_3()); 
            // InternalBug348199TestLanguage.g:2301:2: ( rule__Timeperiod__Alternatives_3_3_3 )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2301:3: rule__Timeperiod__Alternatives_3_3_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Alternatives_3_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_3_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__4"
    // InternalBug348199TestLanguage.g:2309:1: rule__Timeperiod__Group_3_3__4 : rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 ;
    public final void rule__Timeperiod__Group_3_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2313:1: ( rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 )
            // InternalBug348199TestLanguage.g:2314:2: rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_3__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__4"


    // $ANTLR start "rule__Timeperiod__Group_3_3__4__Impl"
    // InternalBug348199TestLanguage.g:2321:1: rule__Timeperiod__Group_3_3__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2325:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2326:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2326:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2327:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2327:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2328:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2329:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2329:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 

            }

            // InternalBug348199TestLanguage.g:2332:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2333:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2334:3: ( RULE_NL )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2334:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3__5"
    // InternalBug348199TestLanguage.g:2343:1: rule__Timeperiod__Group_3_3__5 : rule__Timeperiod__Group_3_3__5__Impl ;
    public final void rule__Timeperiod__Group_3_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2347:1: ( rule__Timeperiod__Group_3_3__5__Impl )
            // InternalBug348199TestLanguage.g:2348:2: rule__Timeperiod__Group_3_3__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__5"


    // $ANTLR start "rule__Timeperiod__Group_3_3__5__Impl"
    // InternalBug348199TestLanguage.g:2354:1: rule__Timeperiod__Group_3_3__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2358:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2359:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2359:1: ( '}' )
            // InternalBug348199TestLanguage.g:2360:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_3_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_3_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_2__0"
    // InternalBug348199TestLanguage.g:2370:1: rule__Timeperiod__Group_3_3_2__0 : rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 ;
    public final void rule__Timeperiod__Group_3_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2374:1: ( rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 )
            // InternalBug348199TestLanguage.g:2375:2: rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Timeperiod__Group_3_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_2__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_2__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3_2__0__Impl"
    // InternalBug348199TestLanguage.g:2382:1: rule__Timeperiod__Group_3_3_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2386:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2387:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2387:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2388:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2388:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2389:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2390:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2390:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 

            }

            // InternalBug348199TestLanguage.g:2393:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2394:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2395:3: ( RULE_NL )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_NL) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2395:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_2__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_2__1"
    // InternalBug348199TestLanguage.g:2404:1: rule__Timeperiod__Group_3_3_2__1 : rule__Timeperiod__Group_3_3_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2408:1: ( rule__Timeperiod__Group_3_3_2__1__Impl )
            // InternalBug348199TestLanguage.g:2409:2: rule__Timeperiod__Group_3_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_2__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_2__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3_2__1__Impl"
    // InternalBug348199TestLanguage.g:2415:1: rule__Timeperiod__Group_3_3_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2419:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) )
            // InternalBug348199TestLanguage.g:2420:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:2420:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            // InternalBug348199TestLanguage.g:2421:2: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_2_1()); 
            // InternalBug348199TestLanguage.g:2422:2: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            // InternalBug348199TestLanguage.g:2422:3: rule__Timeperiod__TimeAssignment_3_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_2_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_2__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__0"
    // InternalBug348199TestLanguage.g:2431:1: rule__Timeperiod__Group_3_3_3_0__0 : rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2435:1: ( rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 )
            // InternalBug348199TestLanguage.g:2436:2: rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Timeperiod__Group_3_3_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__0__Impl"
    // InternalBug348199TestLanguage.g:2443:1: rule__Timeperiod__Group_3_3_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2447:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2448:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2448:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2449:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2449:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2450:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2451:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2451:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:2454:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2455:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2456:3: ( RULE_NL )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_NL) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2456:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__1"
    // InternalBug348199TestLanguage.g:2465:1: rule__Timeperiod__Group_3_3_3_0__1 : rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 ;
    public final void rule__Timeperiod__Group_3_3_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2469:1: ( rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 )
            // InternalBug348199TestLanguage.g:2470:2: rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_3_3_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__1__Impl"
    // InternalBug348199TestLanguage.g:2477:1: rule__Timeperiod__Group_3_3_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2481:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:2482:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:2482:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:2483:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_3_3_0_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_3_3_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__2"
    // InternalBug348199TestLanguage.g:2492:1: rule__Timeperiod__Group_3_3_3_0__2 : rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 ;
    public final void rule__Timeperiod__Group_3_3_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2496:1: ( rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 )
            // InternalBug348199TestLanguage.g:2497:2: rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_3_3_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__2__Impl"
    // InternalBug348199TestLanguage.g:2504:1: rule__Timeperiod__Group_3_3_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2508:1: ( ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:2509:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:2509:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            // InternalBug348199TestLanguage.g:2510:2: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_3_3_0_2()); 
            // InternalBug348199TestLanguage.g:2511:2: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            // InternalBug348199TestLanguage.g:2511:3: rule__Timeperiod__NameAssignment_3_3_3_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_3_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_3_3_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__3"
    // InternalBug348199TestLanguage.g:2519:1: rule__Timeperiod__Group_3_3_3_0__3 : rule__Timeperiod__Group_3_3_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2523:1: ( rule__Timeperiod__Group_3_3_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:2524:2: rule__Timeperiod__Group_3_3_3_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0__3__Impl"
    // InternalBug348199TestLanguage.g:2530:1: rule__Timeperiod__Group_3_3_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2534:1: ( ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2535:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2535:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:2536:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0_3()); 
            // InternalBug348199TestLanguage.g:2537:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2537:3: rule__Timeperiod__Group_3_3_3_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_3_3_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0_3__0"
    // InternalBug348199TestLanguage.g:2546:1: rule__Timeperiod__Group_3_3_3_0_3__0 : rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2550:1: ( rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 )
            // InternalBug348199TestLanguage.g:2551:2: rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_3_3_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:2558:1: rule__Timeperiod__Group_3_3_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2562:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2563:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2563:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2564:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2564:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2565:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2566:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2566:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2569:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2570:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2571:3: ( RULE_NL )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_NL) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2571:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0_3__1"
    // InternalBug348199TestLanguage.g:2580:1: rule__Timeperiod__Group_3_3_3_0_3__1 : rule__Timeperiod__Group_3_3_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2584:1: ( rule__Timeperiod__Group_3_3_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:2585:2: rule__Timeperiod__Group_3_3_3_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:2591:1: rule__Timeperiod__Group_3_3_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2595:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2596:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2596:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2597:2: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2598:2: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2598:3: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_3_3_0_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__0"
    // InternalBug348199TestLanguage.g:2607:1: rule__Timeperiod__Group_3_3_3_1__0 : rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2611:1: ( rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 )
            // InternalBug348199TestLanguage.g:2612:2: rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Timeperiod__Group_3_3_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__0__Impl"
    // InternalBug348199TestLanguage.g:2619:1: rule__Timeperiod__Group_3_3_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2623:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2624:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2624:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2625:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2625:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2626:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2627:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2627:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2630:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2631:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2632:3: ( RULE_NL )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NL) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2632:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__1"
    // InternalBug348199TestLanguage.g:2641:1: rule__Timeperiod__Group_3_3_3_1__1 : rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 ;
    public final void rule__Timeperiod__Group_3_3_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2645:1: ( rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 )
            // InternalBug348199TestLanguage.g:2646:2: rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_3_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__1__Impl"
    // InternalBug348199TestLanguage.g:2653:1: rule__Timeperiod__Group_3_3_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2657:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:2658:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:2658:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:2659:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_3_3_1_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_3_3_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__2"
    // InternalBug348199TestLanguage.g:2668:1: rule__Timeperiod__Group_3_3_3_1__2 : rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 ;
    public final void rule__Timeperiod__Group_3_3_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2672:1: ( rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 )
            // InternalBug348199TestLanguage.g:2673:2: rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_3_3_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__2__Impl"
    // InternalBug348199TestLanguage.g:2680:1: rule__Timeperiod__Group_3_3_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2684:1: ( ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:2685:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:2685:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            // InternalBug348199TestLanguage.g:2686:2: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_3_3_1_2()); 
            // InternalBug348199TestLanguage.g:2687:2: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            // InternalBug348199TestLanguage.g:2687:3: rule__Timeperiod__AliasAssignment_3_3_3_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_3_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_3_3_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__3"
    // InternalBug348199TestLanguage.g:2695:1: rule__Timeperiod__Group_3_3_3_1__3 : rule__Timeperiod__Group_3_3_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2699:1: ( rule__Timeperiod__Group_3_3_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:2700:2: rule__Timeperiod__Group_3_3_3_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1__3__Impl"
    // InternalBug348199TestLanguage.g:2706:1: rule__Timeperiod__Group_3_3_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2710:1: ( ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2711:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2711:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:2712:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1_3()); 
            // InternalBug348199TestLanguage.g:2713:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2713:3: rule__Timeperiod__Group_3_3_3_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Timeperiod__Group_3_3_3_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1_3__0"
    // InternalBug348199TestLanguage.g:2722:1: rule__Timeperiod__Group_3_3_3_1_3__0 : rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2726:1: ( rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 )
            // InternalBug348199TestLanguage.g:2727:2: rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_3_3_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:2734:1: rule__Timeperiod__Group_3_3_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2738:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2739:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2739:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2740:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2740:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2741:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2742:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2742:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2745:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2746:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2747:3: ( RULE_NL )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_NL) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2747:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1_3__1"
    // InternalBug348199TestLanguage.g:2756:1: rule__Timeperiod__Group_3_3_3_1_3__1 : rule__Timeperiod__Group_3_3_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2760:1: ( rule__Timeperiod__Group_3_3_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:2761:2: rule__Timeperiod__Group_3_3_3_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_3_3_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_3_3_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:2767:1: rule__Timeperiod__Group_3_3_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2771:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2772:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2772:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:2773:2: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:2774:2: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            // InternalBug348199TestLanguage.g:2774:3: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_3_3_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_3_3_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__0"
    // InternalBug348199TestLanguage.g:2783:1: rule__Timeperiod__Group_3_4__0 : rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 ;
    public final void rule__Timeperiod__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2787:1: ( rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 )
            // InternalBug348199TestLanguage.g:2788:2: rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4__0__Impl"
    // InternalBug348199TestLanguage.g:2795:1: rule__Timeperiod__Group_3_4__0__Impl : ( '5' ) ;
    public final void rule__Timeperiod__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2799:1: ( ( '5' ) )
            // InternalBug348199TestLanguage.g:2800:1: ( '5' )
            {
            // InternalBug348199TestLanguage.g:2800:1: ( '5' )
            // InternalBug348199TestLanguage.g:2801:2: '5'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitFiveKeyword_3_4_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitFiveKeyword_3_4_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__1"
    // InternalBug348199TestLanguage.g:2810:1: rule__Timeperiod__Group_3_4__1 : rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 ;
    public final void rule__Timeperiod__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2814:1: ( rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 )
            // InternalBug348199TestLanguage.g:2815:2: rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4__1__Impl"
    // InternalBug348199TestLanguage.g:2822:1: rule__Timeperiod__Group_3_4__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2826:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:2827:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:2827:1: ( '{' )
            // InternalBug348199TestLanguage.g:2828:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_4_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_4_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__2"
    // InternalBug348199TestLanguage.g:2837:1: rule__Timeperiod__Group_3_4__2 : rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 ;
    public final void rule__Timeperiod__Group_3_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2841:1: ( rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 )
            // InternalBug348199TestLanguage.g:2842:2: rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__2"


    // $ANTLR start "rule__Timeperiod__Group_3_4__2__Impl"
    // InternalBug348199TestLanguage.g:2849:1: rule__Timeperiod__Group_3_4__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2853:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2854:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2854:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2855:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2855:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2856:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:2857:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2857:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 

            }

            // InternalBug348199TestLanguage.g:2860:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2861:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:2862:3: ( RULE_NL )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_NL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2862:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__3"
    // InternalBug348199TestLanguage.g:2871:1: rule__Timeperiod__Group_3_4__3 : rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 ;
    public final void rule__Timeperiod__Group_3_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2875:1: ( rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 )
            // InternalBug348199TestLanguage.g:2876:2: rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__3"


    // $ANTLR start "rule__Timeperiod__Group_3_4__3__Impl"
    // InternalBug348199TestLanguage.g:2883:1: rule__Timeperiod__Group_3_4__3__Impl : ( ( rule__Timeperiod__Group_3_4_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2887:1: ( ( ( rule__Timeperiod__Group_3_4_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2888:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2888:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            // InternalBug348199TestLanguage.g:2889:2: ( rule__Timeperiod__Group_3_4_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_3()); 
            // InternalBug348199TestLanguage.g:2890:2: ( rule__Timeperiod__Group_3_4_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==26) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2890:3: rule__Timeperiod__Group_3_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__Timeperiod__Group_3_4_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_4_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__4"
    // InternalBug348199TestLanguage.g:2898:1: rule__Timeperiod__Group_3_4__4 : rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 ;
    public final void rule__Timeperiod__Group_3_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2902:1: ( rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 )
            // InternalBug348199TestLanguage.g:2903:2: rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_4__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__4"


    // $ANTLR start "rule__Timeperiod__Group_3_4__4__Impl"
    // InternalBug348199TestLanguage.g:2910:1: rule__Timeperiod__Group_3_4__4__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) ;
    public final void rule__Timeperiod__Group_3_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2914:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) )
            // InternalBug348199TestLanguage.g:2915:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            {
            // InternalBug348199TestLanguage.g:2915:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            // InternalBug348199TestLanguage.g:2916:2: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()); 
            // InternalBug348199TestLanguage.g:2917:2: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            // InternalBug348199TestLanguage.g:2917:3: rule__Timeperiod__UnorderedGroup_3_4_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_4_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4__5"
    // InternalBug348199TestLanguage.g:2925:1: rule__Timeperiod__Group_3_4__5 : rule__Timeperiod__Group_3_4__5__Impl ;
    public final void rule__Timeperiod__Group_3_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2929:1: ( rule__Timeperiod__Group_3_4__5__Impl )
            // InternalBug348199TestLanguage.g:2930:2: rule__Timeperiod__Group_3_4__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__5"


    // $ANTLR start "rule__Timeperiod__Group_3_4__5__Impl"
    // InternalBug348199TestLanguage.g:2936:1: rule__Timeperiod__Group_3_4__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2940:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2941:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2941:1: ( '}' )
            // InternalBug348199TestLanguage.g:2942:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_4_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_4_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_3__0"
    // InternalBug348199TestLanguage.g:2952:1: rule__Timeperiod__Group_3_4_3__0 : rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 ;
    public final void rule__Timeperiod__Group_3_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2956:1: ( rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 )
            // InternalBug348199TestLanguage.g:2957:2: rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4_3__0__Impl"
    // InternalBug348199TestLanguage.g:2964:1: rule__Timeperiod__Group_3_4_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2968:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) )
            // InternalBug348199TestLanguage.g:2969:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:2969:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            // InternalBug348199TestLanguage.g:2970:2: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_3_0()); 
            // InternalBug348199TestLanguage.g:2971:2: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            // InternalBug348199TestLanguage.g:2971:3: rule__Timeperiod__TimeAssignment_3_4_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_4_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_3__1"
    // InternalBug348199TestLanguage.g:2979:1: rule__Timeperiod__Group_3_4_3__1 : rule__Timeperiod__Group_3_4_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2983:1: ( rule__Timeperiod__Group_3_4_3__1__Impl )
            // InternalBug348199TestLanguage.g:2984:2: rule__Timeperiod__Group_3_4_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4_3__1__Impl"
    // InternalBug348199TestLanguage.g:2990:1: rule__Timeperiod__Group_3_4_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2994:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2995:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2995:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2996:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2996:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2997:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:2998:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2998:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3001:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3002:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:3003:3: ( RULE_NL )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_NL) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3003:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__0"
    // InternalBug348199TestLanguage.g:3013:1: rule__Timeperiod__Group_3_4_4_0__0 : rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3017:1: ( rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 )
            // InternalBug348199TestLanguage.g:3018:2: rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_4_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__0__Impl"
    // InternalBug348199TestLanguage.g:3025:1: rule__Timeperiod__Group_3_4_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3029:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:3030:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:3030:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:3031:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_4_4_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_4_4_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__1"
    // InternalBug348199TestLanguage.g:3040:1: rule__Timeperiod__Group_3_4_4_0__1 : rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 ;
    public final void rule__Timeperiod__Group_3_4_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3044:1: ( rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 )
            // InternalBug348199TestLanguage.g:3045:2: rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4_4_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__1__Impl"
    // InternalBug348199TestLanguage.g:3052:1: rule__Timeperiod__Group_3_4_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3056:1: ( ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:3057:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:3057:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            // InternalBug348199TestLanguage.g:3058:2: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_4_4_0_1()); 
            // InternalBug348199TestLanguage.g:3059:2: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            // InternalBug348199TestLanguage.g:3059:3: rule__Timeperiod__NameAssignment_3_4_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_4_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_4_4_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__2"
    // InternalBug348199TestLanguage.g:3067:1: rule__Timeperiod__Group_3_4_4_0__2 : rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 ;
    public final void rule__Timeperiod__Group_3_4_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3071:1: ( rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 )
            // InternalBug348199TestLanguage.g:3072:2: rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_4_4_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__2__Impl"
    // InternalBug348199TestLanguage.g:3079:1: rule__Timeperiod__Group_3_4_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3083:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3084:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3084:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3085:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3085:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3086:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3087:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3087:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:3090:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3091:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3092:3: ( RULE_NL )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_NL) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3092:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__3"
    // InternalBug348199TestLanguage.g:3101:1: rule__Timeperiod__Group_3_4_4_0__3 : rule__Timeperiod__Group_3_4_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3105:1: ( rule__Timeperiod__Group_3_4_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:3106:2: rule__Timeperiod__Group_3_4_4_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0__3__Impl"
    // InternalBug348199TestLanguage.g:3112:1: rule__Timeperiod__Group_3_4_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3116:1: ( ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3117:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3117:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:3118:2: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0_3()); 
            // InternalBug348199TestLanguage.g:3119:2: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==27) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3119:3: rule__Timeperiod__Group_3_4_4_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__Timeperiod__Group_3_4_4_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0_3__0"
    // InternalBug348199TestLanguage.g:3128:1: rule__Timeperiod__Group_3_4_4_0_3__0 : rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3132:1: ( rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 )
            // InternalBug348199TestLanguage.g:3133:2: rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4_4_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:3140:1: rule__Timeperiod__Group_3_4_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3144:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3145:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3145:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:3146:2: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:3147:2: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            // InternalBug348199TestLanguage.g:3147:3: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_4_4_0_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0_3__1"
    // InternalBug348199TestLanguage.g:3155:1: rule__Timeperiod__Group_3_4_4_0_3__1 : rule__Timeperiod__Group_3_4_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3159:1: ( rule__Timeperiod__Group_3_4_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:3160:2: rule__Timeperiod__Group_3_4_4_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:3166:1: rule__Timeperiod__Group_3_4_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3170:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3171:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3171:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3172:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3172:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3173:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3174:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3174:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3177:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3178:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3179:3: ( RULE_NL )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_NL) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3179:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__0"
    // InternalBug348199TestLanguage.g:3189:1: rule__Timeperiod__Group_3_4_4_1__0 : rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3193:1: ( rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 )
            // InternalBug348199TestLanguage.g:3194:2: rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_4_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__0__Impl"
    // InternalBug348199TestLanguage.g:3201:1: rule__Timeperiod__Group_3_4_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3205:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3206:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3206:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3207:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_4_4_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_4_4_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__1"
    // InternalBug348199TestLanguage.g:3216:1: rule__Timeperiod__Group_3_4_4_1__1 : rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 ;
    public final void rule__Timeperiod__Group_3_4_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3220:1: ( rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 )
            // InternalBug348199TestLanguage.g:3221:2: rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4_4_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__1__Impl"
    // InternalBug348199TestLanguage.g:3228:1: rule__Timeperiod__Group_3_4_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3232:1: ( ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:3233:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:3233:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            // InternalBug348199TestLanguage.g:3234:2: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_4_4_1_1()); 
            // InternalBug348199TestLanguage.g:3235:2: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            // InternalBug348199TestLanguage.g:3235:3: rule__Timeperiod__AliasAssignment_3_4_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_4_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_4_4_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__2"
    // InternalBug348199TestLanguage.g:3243:1: rule__Timeperiod__Group_3_4_4_1__2 : rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 ;
    public final void rule__Timeperiod__Group_3_4_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3247:1: ( rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 )
            // InternalBug348199TestLanguage.g:3248:2: rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_4_4_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__2__Impl"
    // InternalBug348199TestLanguage.g:3255:1: rule__Timeperiod__Group_3_4_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3259:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3260:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3260:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3261:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3261:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3262:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3263:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3263:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:3266:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3267:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3268:3: ( RULE_NL )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_NL) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3268:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__3"
    // InternalBug348199TestLanguage.g:3277:1: rule__Timeperiod__Group_3_4_4_1__3 : rule__Timeperiod__Group_3_4_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3281:1: ( rule__Timeperiod__Group_3_4_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:3282:2: rule__Timeperiod__Group_3_4_4_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1__3__Impl"
    // InternalBug348199TestLanguage.g:3288:1: rule__Timeperiod__Group_3_4_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3292:1: ( ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3293:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3293:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3294:2: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1_3()); 
            // InternalBug348199TestLanguage.g:3295:2: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==28) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3295:3: rule__Timeperiod__Group_3_4_4_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    rule__Timeperiod__Group_3_4_4_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1_3__0"
    // InternalBug348199TestLanguage.g:3304:1: rule__Timeperiod__Group_3_4_4_1_3__0 : rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3308:1: ( rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 )
            // InternalBug348199TestLanguage.g:3309:2: rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_4_4_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:3316:1: rule__Timeperiod__Group_3_4_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3320:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3321:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3321:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:3322:2: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:3323:2: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            // InternalBug348199TestLanguage.g:3323:3: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_4_4_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1_3__1"
    // InternalBug348199TestLanguage.g:3331:1: rule__Timeperiod__Group_3_4_4_1_3__1 : rule__Timeperiod__Group_3_4_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3335:1: ( rule__Timeperiod__Group_3_4_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3336:2: rule__Timeperiod__Group_3_4_4_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_4_4_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_4_4_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:3342:1: rule__Timeperiod__Group_3_4_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3346:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3347:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3347:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3348:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3348:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3349:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3350:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3350:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3353:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3354:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3355:3: ( RULE_NL )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_NL) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3355:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_4_4_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__0"
    // InternalBug348199TestLanguage.g:3365:1: rule__Timeperiod__Group_3_5__0 : rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 ;
    public final void rule__Timeperiod__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3369:1: ( rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 )
            // InternalBug348199TestLanguage.g:3370:2: rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5__0__Impl"
    // InternalBug348199TestLanguage.g:3377:1: rule__Timeperiod__Group_3_5__0__Impl : ( '6' ) ;
    public final void rule__Timeperiod__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3381:1: ( ( '6' ) )
            // InternalBug348199TestLanguage.g:3382:1: ( '6' )
            {
            // InternalBug348199TestLanguage.g:3382:1: ( '6' )
            // InternalBug348199TestLanguage.g:3383:2: '6'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitSixKeyword_3_5_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitSixKeyword_3_5_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__1"
    // InternalBug348199TestLanguage.g:3392:1: rule__Timeperiod__Group_3_5__1 : rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 ;
    public final void rule__Timeperiod__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3396:1: ( rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 )
            // InternalBug348199TestLanguage.g:3397:2: rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5__1__Impl"
    // InternalBug348199TestLanguage.g:3404:1: rule__Timeperiod__Group_3_5__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3408:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3409:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3409:1: ( '{' )
            // InternalBug348199TestLanguage.g:3410:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_5_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_5_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__2"
    // InternalBug348199TestLanguage.g:3419:1: rule__Timeperiod__Group_3_5__2 : rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 ;
    public final void rule__Timeperiod__Group_3_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3423:1: ( rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 )
            // InternalBug348199TestLanguage.g:3424:2: rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_5__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__2"


    // $ANTLR start "rule__Timeperiod__Group_3_5__2__Impl"
    // InternalBug348199TestLanguage.g:3431:1: rule__Timeperiod__Group_3_5__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3435:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3436:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3436:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3437:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3437:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3438:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3439:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3439:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 

            }

            // InternalBug348199TestLanguage.g:3442:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3443:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3444:3: ( RULE_NL )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_NL) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3444:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__3"
    // InternalBug348199TestLanguage.g:3453:1: rule__Timeperiod__Group_3_5__3 : rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 ;
    public final void rule__Timeperiod__Group_3_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3457:1: ( rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 )
            // InternalBug348199TestLanguage.g:3458:2: rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_5__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__3"


    // $ANTLR start "rule__Timeperiod__Group_3_5__3__Impl"
    // InternalBug348199TestLanguage.g:3465:1: rule__Timeperiod__Group_3_5__3__Impl : ( ( rule__Timeperiod__Group_3_5_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3469:1: ( ( ( rule__Timeperiod__Group_3_5_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3470:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3470:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            // InternalBug348199TestLanguage.g:3471:2: ( rule__Timeperiod__Group_3_5_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_3()); 
            // InternalBug348199TestLanguage.g:3472:2: ( rule__Timeperiod__Group_3_5_3__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==26) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3472:3: rule__Timeperiod__Group_3_5_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__Timeperiod__Group_3_5_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_5_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__4"
    // InternalBug348199TestLanguage.g:3480:1: rule__Timeperiod__Group_3_5__4 : rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 ;
    public final void rule__Timeperiod__Group_3_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3484:1: ( rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 )
            // InternalBug348199TestLanguage.g:3485:2: rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_5__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__4"


    // $ANTLR start "rule__Timeperiod__Group_3_5__4__Impl"
    // InternalBug348199TestLanguage.g:3492:1: rule__Timeperiod__Group_3_5__4__Impl : ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) ;
    public final void rule__Timeperiod__Group_3_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3496:1: ( ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) )
            // InternalBug348199TestLanguage.g:3497:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            {
            // InternalBug348199TestLanguage.g:3497:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            // InternalBug348199TestLanguage.g:3498:2: ( rule__Timeperiod__Alternatives_3_5_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_5_4()); 
            // InternalBug348199TestLanguage.g:3499:2: ( rule__Timeperiod__Alternatives_3_5_4 )
            // InternalBug348199TestLanguage.g:3499:3: rule__Timeperiod__Alternatives_3_5_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Alternatives_3_5_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_5_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5__5"
    // InternalBug348199TestLanguage.g:3507:1: rule__Timeperiod__Group_3_5__5 : rule__Timeperiod__Group_3_5__5__Impl ;
    public final void rule__Timeperiod__Group_3_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3511:1: ( rule__Timeperiod__Group_3_5__5__Impl )
            // InternalBug348199TestLanguage.g:3512:2: rule__Timeperiod__Group_3_5__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__5"


    // $ANTLR start "rule__Timeperiod__Group_3_5__5__Impl"
    // InternalBug348199TestLanguage.g:3518:1: rule__Timeperiod__Group_3_5__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3522:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:3523:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:3523:1: ( '}' )
            // InternalBug348199TestLanguage.g:3524:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_5_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_5_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_3__0"
    // InternalBug348199TestLanguage.g:3534:1: rule__Timeperiod__Group_3_5_3__0 : rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 ;
    public final void rule__Timeperiod__Group_3_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3538:1: ( rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 )
            // InternalBug348199TestLanguage.g:3539:2: rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5_3__0__Impl"
    // InternalBug348199TestLanguage.g:3546:1: rule__Timeperiod__Group_3_5_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3550:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3551:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3551:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            // InternalBug348199TestLanguage.g:3552:2: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_3_0()); 
            // InternalBug348199TestLanguage.g:3553:2: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            // InternalBug348199TestLanguage.g:3553:3: rule__Timeperiod__TimeAssignment_3_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_5_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_3__1"
    // InternalBug348199TestLanguage.g:3561:1: rule__Timeperiod__Group_3_5_3__1 : rule__Timeperiod__Group_3_5_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3565:1: ( rule__Timeperiod__Group_3_5_3__1__Impl )
            // InternalBug348199TestLanguage.g:3566:2: rule__Timeperiod__Group_3_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5_3__1__Impl"
    // InternalBug348199TestLanguage.g:3572:1: rule__Timeperiod__Group_3_5_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3576:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3577:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3577:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3578:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3578:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3579:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:3580:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3580:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3583:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3584:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:3585:3: ( RULE_NL )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_NL) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3585:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__0"
    // InternalBug348199TestLanguage.g:3595:1: rule__Timeperiod__Group_3_5_4_0__0 : rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3599:1: ( rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 )
            // InternalBug348199TestLanguage.g:3600:2: rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_5_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__0__Impl"
    // InternalBug348199TestLanguage.g:3607:1: rule__Timeperiod__Group_3_5_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3611:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:3612:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:3612:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:3613:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_5_4_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_5_4_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__1"
    // InternalBug348199TestLanguage.g:3622:1: rule__Timeperiod__Group_3_5_4_0__1 : rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 ;
    public final void rule__Timeperiod__Group_3_5_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3626:1: ( rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 )
            // InternalBug348199TestLanguage.g:3627:2: rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5_4_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__1__Impl"
    // InternalBug348199TestLanguage.g:3634:1: rule__Timeperiod__Group_3_5_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3638:1: ( ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:3639:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:3639:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            // InternalBug348199TestLanguage.g:3640:2: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_5_4_0_1()); 
            // InternalBug348199TestLanguage.g:3641:2: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            // InternalBug348199TestLanguage.g:3641:3: rule__Timeperiod__NameAssignment_3_5_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_5_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_5_4_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__2"
    // InternalBug348199TestLanguage.g:3649:1: rule__Timeperiod__Group_3_5_4_0__2 : rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 ;
    public final void rule__Timeperiod__Group_3_5_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3653:1: ( rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 )
            // InternalBug348199TestLanguage.g:3654:2: rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_5_4_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__2__Impl"
    // InternalBug348199TestLanguage.g:3661:1: rule__Timeperiod__Group_3_5_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3665:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3666:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3666:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3667:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3667:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3668:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:3669:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3669:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:3672:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3673:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:3674:3: ( RULE_NL )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_NL) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3674:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__3"
    // InternalBug348199TestLanguage.g:3683:1: rule__Timeperiod__Group_3_5_4_0__3 : rule__Timeperiod__Group_3_5_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3687:1: ( rule__Timeperiod__Group_3_5_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:3688:2: rule__Timeperiod__Group_3_5_4_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0__3__Impl"
    // InternalBug348199TestLanguage.g:3694:1: rule__Timeperiod__Group_3_5_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3698:1: ( ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3699:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3699:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:3700:2: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0_3()); 
            // InternalBug348199TestLanguage.g:3701:2: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==27) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3701:3: rule__Timeperiod__Group_3_5_4_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__Timeperiod__Group_3_5_4_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0_3__0"
    // InternalBug348199TestLanguage.g:3710:1: rule__Timeperiod__Group_3_5_4_0_3__0 : rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3714:1: ( rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 )
            // InternalBug348199TestLanguage.g:3715:2: rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5_4_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:3722:1: rule__Timeperiod__Group_3_5_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3726:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3727:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3727:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:3728:2: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:3729:2: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            // InternalBug348199TestLanguage.g:3729:3: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_5_4_0_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0_3__1"
    // InternalBug348199TestLanguage.g:3737:1: rule__Timeperiod__Group_3_5_4_0_3__1 : rule__Timeperiod__Group_3_5_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3741:1: ( rule__Timeperiod__Group_3_5_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:3742:2: rule__Timeperiod__Group_3_5_4_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:3748:1: rule__Timeperiod__Group_3_5_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3752:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3753:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3753:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3754:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3754:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3755:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3756:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3756:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3759:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3760:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3761:3: ( RULE_NL )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_NL) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3761:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__0"
    // InternalBug348199TestLanguage.g:3771:1: rule__Timeperiod__Group_3_5_4_1__0 : rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3775:1: ( rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 )
            // InternalBug348199TestLanguage.g:3776:2: rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_5_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__0__Impl"
    // InternalBug348199TestLanguage.g:3783:1: rule__Timeperiod__Group_3_5_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3787:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3788:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3788:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3789:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_5_4_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_5_4_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__1"
    // InternalBug348199TestLanguage.g:3798:1: rule__Timeperiod__Group_3_5_4_1__1 : rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 ;
    public final void rule__Timeperiod__Group_3_5_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3802:1: ( rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 )
            // InternalBug348199TestLanguage.g:3803:2: rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5_4_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__1__Impl"
    // InternalBug348199TestLanguage.g:3810:1: rule__Timeperiod__Group_3_5_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3814:1: ( ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:3815:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:3815:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            // InternalBug348199TestLanguage.g:3816:2: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_5_4_1_1()); 
            // InternalBug348199TestLanguage.g:3817:2: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            // InternalBug348199TestLanguage.g:3817:3: rule__Timeperiod__AliasAssignment_3_5_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_5_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_5_4_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__2"
    // InternalBug348199TestLanguage.g:3825:1: rule__Timeperiod__Group_3_5_4_1__2 : rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 ;
    public final void rule__Timeperiod__Group_3_5_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3829:1: ( rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 )
            // InternalBug348199TestLanguage.g:3830:2: rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_5_4_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__2__Impl"
    // InternalBug348199TestLanguage.g:3837:1: rule__Timeperiod__Group_3_5_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3841:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3842:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3842:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3843:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3843:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3844:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:3845:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3845:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:3848:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3849:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:3850:3: ( RULE_NL )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_NL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3850:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__3"
    // InternalBug348199TestLanguage.g:3859:1: rule__Timeperiod__Group_3_5_4_1__3 : rule__Timeperiod__Group_3_5_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3863:1: ( rule__Timeperiod__Group_3_5_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:3864:2: rule__Timeperiod__Group_3_5_4_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1__3__Impl"
    // InternalBug348199TestLanguage.g:3870:1: rule__Timeperiod__Group_3_5_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3874:1: ( ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3875:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3875:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3876:2: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1_3()); 
            // InternalBug348199TestLanguage.g:3877:2: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==28) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3877:3: rule__Timeperiod__Group_3_5_4_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    rule__Timeperiod__Group_3_5_4_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1_3__0"
    // InternalBug348199TestLanguage.g:3886:1: rule__Timeperiod__Group_3_5_4_1_3__0 : rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3890:1: ( rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 )
            // InternalBug348199TestLanguage.g:3891:2: rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_5_4_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:3898:1: rule__Timeperiod__Group_3_5_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3902:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3903:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3903:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:3904:2: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:3905:2: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            // InternalBug348199TestLanguage.g:3905:3: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_5_4_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1_3__1"
    // InternalBug348199TestLanguage.g:3913:1: rule__Timeperiod__Group_3_5_4_1_3__1 : rule__Timeperiod__Group_3_5_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3917:1: ( rule__Timeperiod__Group_3_5_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3918:2: rule__Timeperiod__Group_3_5_4_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_5_4_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_5_4_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:3924:1: rule__Timeperiod__Group_3_5_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3928:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3929:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3929:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3930:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3930:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3931:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3932:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3932:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3935:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3936:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3937:3: ( RULE_NL )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_NL) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3937:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_5_4_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__0"
    // InternalBug348199TestLanguage.g:3947:1: rule__Timeperiod__Group_3_6__0 : rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 ;
    public final void rule__Timeperiod__Group_3_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3951:1: ( rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 )
            // InternalBug348199TestLanguage.g:3952:2: rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6__0__Impl"
    // InternalBug348199TestLanguage.g:3959:1: rule__Timeperiod__Group_3_6__0__Impl : ( '7' ) ;
    public final void rule__Timeperiod__Group_3_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3963:1: ( ( '7' ) )
            // InternalBug348199TestLanguage.g:3964:1: ( '7' )
            {
            // InternalBug348199TestLanguage.g:3964:1: ( '7' )
            // InternalBug348199TestLanguage.g:3965:2: '7'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitSevenKeyword_3_6_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitSevenKeyword_3_6_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__1"
    // InternalBug348199TestLanguage.g:3974:1: rule__Timeperiod__Group_3_6__1 : rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 ;
    public final void rule__Timeperiod__Group_3_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3978:1: ( rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 )
            // InternalBug348199TestLanguage.g:3979:2: rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6__1__Impl"
    // InternalBug348199TestLanguage.g:3986:1: rule__Timeperiod__Group_3_6__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3990:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3991:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3991:1: ( '{' )
            // InternalBug348199TestLanguage.g:3992:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_6_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_6_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__2"
    // InternalBug348199TestLanguage.g:4001:1: rule__Timeperiod__Group_3_6__2 : rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 ;
    public final void rule__Timeperiod__Group_3_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4005:1: ( rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 )
            // InternalBug348199TestLanguage.g:4006:2: rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_6__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__2"


    // $ANTLR start "rule__Timeperiod__Group_3_6__2__Impl"
    // InternalBug348199TestLanguage.g:4013:1: rule__Timeperiod__Group_3_6__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4017:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4018:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4018:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4019:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4019:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4020:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4021:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4021:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 

            }

            // InternalBug348199TestLanguage.g:4024:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4025:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4026:3: ( RULE_NL )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_NL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4026:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__3"
    // InternalBug348199TestLanguage.g:4035:1: rule__Timeperiod__Group_3_6__3 : rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 ;
    public final void rule__Timeperiod__Group_3_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4039:1: ( rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 )
            // InternalBug348199TestLanguage.g:4040:2: rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Timeperiod__Group_3_6__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__3"


    // $ANTLR start "rule__Timeperiod__Group_3_6__3__Impl"
    // InternalBug348199TestLanguage.g:4047:1: rule__Timeperiod__Group_3_6__3__Impl : ( ( rule__Timeperiod__Group_3_6_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4051:1: ( ( ( rule__Timeperiod__Group_3_6_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4052:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4052:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            // InternalBug348199TestLanguage.g:4053:2: ( rule__Timeperiod__Group_3_6_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_3()); 
            // InternalBug348199TestLanguage.g:4054:2: ( rule__Timeperiod__Group_3_6_3__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==26) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4054:3: rule__Timeperiod__Group_3_6_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__Timeperiod__Group_3_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_6_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__4"
    // InternalBug348199TestLanguage.g:4062:1: rule__Timeperiod__Group_3_6__4 : rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 ;
    public final void rule__Timeperiod__Group_3_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4066:1: ( rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 )
            // InternalBug348199TestLanguage.g:4067:2: rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Timeperiod__Group_3_6__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__4"


    // $ANTLR start "rule__Timeperiod__Group_3_6__4__Impl"
    // InternalBug348199TestLanguage.g:4074:1: rule__Timeperiod__Group_3_6__4__Impl : ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4078:1: ( ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) )
            // InternalBug348199TestLanguage.g:4079:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            {
            // InternalBug348199TestLanguage.g:4079:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            // InternalBug348199TestLanguage.g:4080:2: ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            {
            // InternalBug348199TestLanguage.g:4080:2: ( ( rule__Timeperiod__Alternatives_3_6_4 ) )
            // InternalBug348199TestLanguage.g:4081:3: ( rule__Timeperiod__Alternatives_3_6_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4082:3: ( rule__Timeperiod__Alternatives_3_6_4 )
            // InternalBug348199TestLanguage.g:4082:4: rule__Timeperiod__Alternatives_3_6_4
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__Alternatives_3_6_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 

            }

            // InternalBug348199TestLanguage.g:4085:2: ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            // InternalBug348199TestLanguage.g:4086:3: ( rule__Timeperiod__Alternatives_3_6_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4087:3: ( rule__Timeperiod__Alternatives_3_6_4 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( ((LA68_0>=17 && LA68_0<=18)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4087:4: rule__Timeperiod__Alternatives_3_6_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__Timeperiod__Alternatives_3_6_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6__5"
    // InternalBug348199TestLanguage.g:4096:1: rule__Timeperiod__Group_3_6__5 : rule__Timeperiod__Group_3_6__5__Impl ;
    public final void rule__Timeperiod__Group_3_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4100:1: ( rule__Timeperiod__Group_3_6__5__Impl )
            // InternalBug348199TestLanguage.g:4101:2: rule__Timeperiod__Group_3_6__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__5"


    // $ANTLR start "rule__Timeperiod__Group_3_6__5__Impl"
    // InternalBug348199TestLanguage.g:4107:1: rule__Timeperiod__Group_3_6__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4111:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4112:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4112:1: ( '}' )
            // InternalBug348199TestLanguage.g:4113:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_6_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_6_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_3__0"
    // InternalBug348199TestLanguage.g:4123:1: rule__Timeperiod__Group_3_6_3__0 : rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 ;
    public final void rule__Timeperiod__Group_3_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4127:1: ( rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 )
            // InternalBug348199TestLanguage.g:4128:2: rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6_3__0__Impl"
    // InternalBug348199TestLanguage.g:4135:1: rule__Timeperiod__Group_3_6_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4139:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4140:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4140:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            // InternalBug348199TestLanguage.g:4141:2: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_3_0()); 
            // InternalBug348199TestLanguage.g:4142:2: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            // InternalBug348199TestLanguage.g:4142:3: rule__Timeperiod__TimeAssignment_3_6_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_6_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_3__1"
    // InternalBug348199TestLanguage.g:4150:1: rule__Timeperiod__Group_3_6_3__1 : rule__Timeperiod__Group_3_6_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4154:1: ( rule__Timeperiod__Group_3_6_3__1__Impl )
            // InternalBug348199TestLanguage.g:4155:2: rule__Timeperiod__Group_3_6_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6_3__1__Impl"
    // InternalBug348199TestLanguage.g:4161:1: rule__Timeperiod__Group_3_6_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4165:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4166:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4166:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4167:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4167:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4168:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4169:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4169:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4172:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4173:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4174:3: ( RULE_NL )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_NL) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4174:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__0"
    // InternalBug348199TestLanguage.g:4184:1: rule__Timeperiod__Group_3_6_4_0__0 : rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4188:1: ( rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 )
            // InternalBug348199TestLanguage.g:4189:2: rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_6_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__0__Impl"
    // InternalBug348199TestLanguage.g:4196:1: rule__Timeperiod__Group_3_6_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4200:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4201:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4201:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4202:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_6_4_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_6_4_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__1"
    // InternalBug348199TestLanguage.g:4211:1: rule__Timeperiod__Group_3_6_4_0__1 : rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 ;
    public final void rule__Timeperiod__Group_3_6_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4215:1: ( rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 )
            // InternalBug348199TestLanguage.g:4216:2: rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6_4_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__1__Impl"
    // InternalBug348199TestLanguage.g:4223:1: rule__Timeperiod__Group_3_6_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4227:1: ( ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4228:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4228:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4229:2: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_6_4_0_1()); 
            // InternalBug348199TestLanguage.g:4230:2: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            // InternalBug348199TestLanguage.g:4230:3: rule__Timeperiod__NameAssignment_3_6_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_6_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_6_4_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__2"
    // InternalBug348199TestLanguage.g:4238:1: rule__Timeperiod__Group_3_6_4_0__2 : rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 ;
    public final void rule__Timeperiod__Group_3_6_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4242:1: ( rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 )
            // InternalBug348199TestLanguage.g:4243:2: rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_6_4_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__2__Impl"
    // InternalBug348199TestLanguage.g:4250:1: rule__Timeperiod__Group_3_6_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4254:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4255:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4255:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4256:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4256:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4257:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4258:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4258:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4261:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4262:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4263:3: ( RULE_NL )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_NL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4263:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__3"
    // InternalBug348199TestLanguage.g:4272:1: rule__Timeperiod__Group_3_6_4_0__3 : rule__Timeperiod__Group_3_6_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4276:1: ( rule__Timeperiod__Group_3_6_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4277:2: rule__Timeperiod__Group_3_6_4_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0__3__Impl"
    // InternalBug348199TestLanguage.g:4283:1: rule__Timeperiod__Group_3_6_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4287:1: ( ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4288:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4288:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4289:2: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0_3()); 
            // InternalBug348199TestLanguage.g:4290:2: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4290:3: rule__Timeperiod__Group_3_6_4_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__Timeperiod__Group_3_6_4_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0_3__0"
    // InternalBug348199TestLanguage.g:4299:1: rule__Timeperiod__Group_3_6_4_0_3__0 : rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4303:1: ( rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4304:2: rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6_4_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:4311:1: rule__Timeperiod__Group_3_6_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4315:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4316:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4316:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4317:2: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4318:2: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4318:3: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_6_4_0_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0_3__1"
    // InternalBug348199TestLanguage.g:4326:1: rule__Timeperiod__Group_3_6_4_0_3__1 : rule__Timeperiod__Group_3_6_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4330:1: ( rule__Timeperiod__Group_3_6_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4331:2: rule__Timeperiod__Group_3_6_4_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:4337:1: rule__Timeperiod__Group_3_6_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4341:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4342:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4342:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4343:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4343:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4344:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4345:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4345:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4348:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4349:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4350:3: ( RULE_NL )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_NL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4350:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__0"
    // InternalBug348199TestLanguage.g:4360:1: rule__Timeperiod__Group_3_6_4_1__0 : rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4364:1: ( rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 )
            // InternalBug348199TestLanguage.g:4365:2: rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_6_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__0__Impl"
    // InternalBug348199TestLanguage.g:4372:1: rule__Timeperiod__Group_3_6_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4376:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4377:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4377:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4378:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_6_4_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_6_4_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__1"
    // InternalBug348199TestLanguage.g:4387:1: rule__Timeperiod__Group_3_6_4_1__1 : rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 ;
    public final void rule__Timeperiod__Group_3_6_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4391:1: ( rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 )
            // InternalBug348199TestLanguage.g:4392:2: rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6_4_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__1__Impl"
    // InternalBug348199TestLanguage.g:4399:1: rule__Timeperiod__Group_3_6_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4403:1: ( ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:4404:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:4404:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            // InternalBug348199TestLanguage.g:4405:2: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_6_4_1_1()); 
            // InternalBug348199TestLanguage.g:4406:2: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            // InternalBug348199TestLanguage.g:4406:3: rule__Timeperiod__AliasAssignment_3_6_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_6_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_6_4_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__2"
    // InternalBug348199TestLanguage.g:4414:1: rule__Timeperiod__Group_3_6_4_1__2 : rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 ;
    public final void rule__Timeperiod__Group_3_6_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4418:1: ( rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 )
            // InternalBug348199TestLanguage.g:4419:2: rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_6_4_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__2__Impl"
    // InternalBug348199TestLanguage.g:4426:1: rule__Timeperiod__Group_3_6_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4430:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4431:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4431:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4432:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4432:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4433:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:4434:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4434:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:4437:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4438:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:4439:3: ( RULE_NL )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_NL) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4439:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__3"
    // InternalBug348199TestLanguage.g:4448:1: rule__Timeperiod__Group_3_6_4_1__3 : rule__Timeperiod__Group_3_6_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4452:1: ( rule__Timeperiod__Group_3_6_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:4453:2: rule__Timeperiod__Group_3_6_4_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1__3__Impl"
    // InternalBug348199TestLanguage.g:4459:1: rule__Timeperiod__Group_3_6_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4463:1: ( ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4464:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4464:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:4465:2: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1_3()); 
            // InternalBug348199TestLanguage.g:4466:2: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==28) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4466:3: rule__Timeperiod__Group_3_6_4_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    rule__Timeperiod__Group_3_6_4_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1_3__0"
    // InternalBug348199TestLanguage.g:4475:1: rule__Timeperiod__Group_3_6_4_1_3__0 : rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4479:1: ( rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 )
            // InternalBug348199TestLanguage.g:4480:2: rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_6_4_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:4487:1: rule__Timeperiod__Group_3_6_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4491:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4492:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4492:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:4493:2: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:4494:2: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            // InternalBug348199TestLanguage.g:4494:3: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_6_4_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1_3__1"
    // InternalBug348199TestLanguage.g:4502:1: rule__Timeperiod__Group_3_6_4_1_3__1 : rule__Timeperiod__Group_3_6_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4506:1: ( rule__Timeperiod__Group_3_6_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:4507:2: rule__Timeperiod__Group_3_6_4_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_6_4_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_6_4_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:4513:1: rule__Timeperiod__Group_3_6_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4517:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4518:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4518:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4519:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4519:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4520:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4521:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4521:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4524:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4525:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4526:3: ( RULE_NL )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_NL) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4526:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_6_4_1_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__0"
    // InternalBug348199TestLanguage.g:4536:1: rule__Timeperiod__Group_3_7__0 : rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 ;
    public final void rule__Timeperiod__Group_3_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4540:1: ( rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 )
            // InternalBug348199TestLanguage.g:4541:2: rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Timeperiod__Group_3_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7__0__Impl"
    // InternalBug348199TestLanguage.g:4548:1: rule__Timeperiod__Group_3_7__0__Impl : ( '8' ) ;
    public final void rule__Timeperiod__Group_3_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4552:1: ( ( '8' ) )
            // InternalBug348199TestLanguage.g:4553:1: ( '8' )
            {
            // InternalBug348199TestLanguage.g:4553:1: ( '8' )
            // InternalBug348199TestLanguage.g:4554:2: '8'
            {
             before(grammarAccess.getTimeperiodAccess().getDigitEightKeyword_3_7_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getDigitEightKeyword_3_7_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__1"
    // InternalBug348199TestLanguage.g:4563:1: rule__Timeperiod__Group_3_7__1 : rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 ;
    public final void rule__Timeperiod__Group_3_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4567:1: ( rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 )
            // InternalBug348199TestLanguage.g:4568:2: rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7__1__Impl"
    // InternalBug348199TestLanguage.g:4575:1: rule__Timeperiod__Group_3_7__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4579:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:4580:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:4580:1: ( '{' )
            // InternalBug348199TestLanguage.g:4581:2: '{'
            {
             before(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_7_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_7_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__2"
    // InternalBug348199TestLanguage.g:4590:1: rule__Timeperiod__Group_3_7__2 : rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 ;
    public final void rule__Timeperiod__Group_3_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4594:1: ( rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 )
            // InternalBug348199TestLanguage.g:4595:2: rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__Timeperiod__Group_3_7__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__2"


    // $ANTLR start "rule__Timeperiod__Group_3_7__2__Impl"
    // InternalBug348199TestLanguage.g:4602:1: rule__Timeperiod__Group_3_7__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4606:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4607:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4607:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4608:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4608:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4609:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:4610:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4610:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 

            }

            // InternalBug348199TestLanguage.g:4613:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4614:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:4615:3: ( RULE_NL )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_NL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4615:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__3"
    // InternalBug348199TestLanguage.g:4624:1: rule__Timeperiod__Group_3_7__3 : rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 ;
    public final void rule__Timeperiod__Group_3_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4628:1: ( rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 )
            // InternalBug348199TestLanguage.g:4629:2: rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__Timeperiod__Group_3_7__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__4();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__3"


    // $ANTLR start "rule__Timeperiod__Group_3_7__3__Impl"
    // InternalBug348199TestLanguage.g:4636:1: rule__Timeperiod__Group_3_7__3__Impl : ( ( rule__Timeperiod__Group_3_7_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4640:1: ( ( ( rule__Timeperiod__Group_3_7_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4641:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4641:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            // InternalBug348199TestLanguage.g:4642:2: ( rule__Timeperiod__Group_3_7_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_3()); 
            // InternalBug348199TestLanguage.g:4643:2: ( rule__Timeperiod__Group_3_7_3__0 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==26) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4643:3: rule__Timeperiod__Group_3_7_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__Timeperiod__Group_3_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_7_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__4"
    // InternalBug348199TestLanguage.g:4651:1: rule__Timeperiod__Group_3_7__4 : rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 ;
    public final void rule__Timeperiod__Group_3_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4655:1: ( rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 )
            // InternalBug348199TestLanguage.g:4656:2: rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__Timeperiod__Group_3_7__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__5();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__4"


    // $ANTLR start "rule__Timeperiod__Group_3_7__4__Impl"
    // InternalBug348199TestLanguage.g:4663:1: rule__Timeperiod__Group_3_7__4__Impl : ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) ;
    public final void rule__Timeperiod__Group_3_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4667:1: ( ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) )
            // InternalBug348199TestLanguage.g:4668:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            {
            // InternalBug348199TestLanguage.g:4668:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            // InternalBug348199TestLanguage.g:4669:2: ( rule__Timeperiod__Alternatives_3_7_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_7_4()); 
            // InternalBug348199TestLanguage.g:4670:2: ( rule__Timeperiod__Alternatives_3_7_4 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=17 && LA78_0<=18)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4670:3: rule__Timeperiod__Alternatives_3_7_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_22);
            	    rule__Timeperiod__Alternatives_3_7_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_7_4()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__4__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7__5"
    // InternalBug348199TestLanguage.g:4678:1: rule__Timeperiod__Group_3_7__5 : rule__Timeperiod__Group_3_7__5__Impl ;
    public final void rule__Timeperiod__Group_3_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4682:1: ( rule__Timeperiod__Group_3_7__5__Impl )
            // InternalBug348199TestLanguage.g:4683:2: rule__Timeperiod__Group_3_7__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7__5__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__5"


    // $ANTLR start "rule__Timeperiod__Group_3_7__5__Impl"
    // InternalBug348199TestLanguage.g:4689:1: rule__Timeperiod__Group_3_7__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4693:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4694:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4694:1: ( '}' )
            // InternalBug348199TestLanguage.g:4695:2: '}'
            {
             before(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_7_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_7_5()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7__5__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_3__0"
    // InternalBug348199TestLanguage.g:4705:1: rule__Timeperiod__Group_3_7_3__0 : rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 ;
    public final void rule__Timeperiod__Group_3_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4709:1: ( rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 )
            // InternalBug348199TestLanguage.g:4710:2: rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7_3__0__Impl"
    // InternalBug348199TestLanguage.g:4717:1: rule__Timeperiod__Group_3_7_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4721:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4722:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4722:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            // InternalBug348199TestLanguage.g:4723:2: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_3_0()); 
            // InternalBug348199TestLanguage.g:4724:2: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            // InternalBug348199TestLanguage.g:4724:3: rule__Timeperiod__TimeAssignment_3_7_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_7_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_3__1"
    // InternalBug348199TestLanguage.g:4732:1: rule__Timeperiod__Group_3_7_3__1 : rule__Timeperiod__Group_3_7_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4736:1: ( rule__Timeperiod__Group_3_7_3__1__Impl )
            // InternalBug348199TestLanguage.g:4737:2: rule__Timeperiod__Group_3_7_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7_3__1__Impl"
    // InternalBug348199TestLanguage.g:4743:1: rule__Timeperiod__Group_3_7_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4747:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4748:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4748:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4749:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4749:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4750:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:4751:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4751:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4754:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4755:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:4756:3: ( RULE_NL )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_NL) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4756:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__0"
    // InternalBug348199TestLanguage.g:4766:1: rule__Timeperiod__Group_3_7_4_0__0 : rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4770:1: ( rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 )
            // InternalBug348199TestLanguage.g:4771:2: rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_7_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__0__Impl"
    // InternalBug348199TestLanguage.g:4778:1: rule__Timeperiod__Group_3_7_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4782:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4783:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4783:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4784:2: 'timeperiod_name'
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_7_4_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_7_4_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__1"
    // InternalBug348199TestLanguage.g:4793:1: rule__Timeperiod__Group_3_7_4_0__1 : rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 ;
    public final void rule__Timeperiod__Group_3_7_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4797:1: ( rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 )
            // InternalBug348199TestLanguage.g:4798:2: rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7_4_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__1__Impl"
    // InternalBug348199TestLanguage.g:4805:1: rule__Timeperiod__Group_3_7_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4809:1: ( ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4810:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4810:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4811:2: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_7_4_0_1()); 
            // InternalBug348199TestLanguage.g:4812:2: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            // InternalBug348199TestLanguage.g:4812:3: rule__Timeperiod__NameAssignment_3_7_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__NameAssignment_3_7_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getNameAssignment_3_7_4_0_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__2"
    // InternalBug348199TestLanguage.g:4820:1: rule__Timeperiod__Group_3_7_4_0__2 : rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 ;
    public final void rule__Timeperiod__Group_3_7_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4824:1: ( rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 )
            // InternalBug348199TestLanguage.g:4825:2: rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Timeperiod__Group_3_7_4_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__2"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__2__Impl"
    // InternalBug348199TestLanguage.g:4832:1: rule__Timeperiod__Group_3_7_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4836:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4837:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4837:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4838:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4838:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4839:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:4840:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4840:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4843:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4844:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:4845:3: ( RULE_NL )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_NL) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4845:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__3"
    // InternalBug348199TestLanguage.g:4854:1: rule__Timeperiod__Group_3_7_4_0__3 : rule__Timeperiod__Group_3_7_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4858:1: ( rule__Timeperiod__Group_3_7_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4859:2: rule__Timeperiod__Group_3_7_4_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__3"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0__3__Impl"
    // InternalBug348199TestLanguage.g:4865:1: rule__Timeperiod__Group_3_7_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4869:1: ( ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4870:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4870:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4871:2: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0_3()); 
            // InternalBug348199TestLanguage.g:4872:2: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==27) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4872:3: rule__Timeperiod__Group_3_7_4_0_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__Timeperiod__Group_3_7_4_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0_3__0"
    // InternalBug348199TestLanguage.g:4881:1: rule__Timeperiod__Group_3_7_4_0_3__0 : rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4885:1: ( rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4886:2: rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7_4_0_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0_3__0__Impl"
    // InternalBug348199TestLanguage.g:4893:1: rule__Timeperiod__Group_3_7_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4897:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4898:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4898:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4899:2: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4900:2: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4900:3: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_7_4_0_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_0_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0_3__1"
    // InternalBug348199TestLanguage.g:4908:1: rule__Timeperiod__Group_3_7_4_0_3__1 : rule__Timeperiod__Group_3_7_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4912:1: ( rule__Timeperiod__Group_3_7_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4913:2: rule__Timeperiod__Group_3_7_4_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_0_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_0_3__1__Impl"
    // InternalBug348199TestLanguage.g:4919:1: rule__Timeperiod__Group_3_7_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4923:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4924:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4924:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4925:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4925:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4926:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4927:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4927:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4930:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4931:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4932:3: ( RULE_NL )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_NL) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4932:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_0_3__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__0"
    // InternalBug348199TestLanguage.g:4942:1: rule__Timeperiod__Group_3_7_4_1__0 : rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4946:1: ( rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 )
            // InternalBug348199TestLanguage.g:4947:2: rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Timeperiod__Group_3_7_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__0__Impl"
    // InternalBug348199TestLanguage.g:4954:1: rule__Timeperiod__Group_3_7_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4958:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4959:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4959:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4960:2: 'otherelement'
            {
             before(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_7_4_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_7_4_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__1"
    // InternalBug348199TestLanguage.g:4969:1: rule__Timeperiod__Group_3_7_4_1__1 : rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 ;
    public final void rule__Timeperiod__Group_3_7_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4973:1: ( rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 )
            // InternalBug348199TestLanguage.g:4974:2: rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7_4_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1__2();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__1__Impl"
    // InternalBug348199TestLanguage.g:4981:1: rule__Timeperiod__Group_3_7_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4985:1: ( ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:4986:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:4986:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            // InternalBug348199TestLanguage.g:4987:2: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_7_4_1_1()); 
            // InternalBug348199TestLanguage.g:4988:2: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            // InternalBug348199TestLanguage.g:4988:3: rule__Timeperiod__AliasAssignment_3_7_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__AliasAssignment_3_7_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_7_4_1_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__1__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__2"
    // InternalBug348199TestLanguage.g:4996:1: rule__Timeperiod__Group_3_7_4_1__2 : rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 ;
    public final void rule__Timeperiod__Group_3_7_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5000:1: ( rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 )
            // InternalBug348199TestLanguage.g:5001:2: rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Timeperiod__Group_3_7_4_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1__3();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__2"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__2__Impl"
    // InternalBug348199TestLanguage.g:5008:1: rule__Timeperiod__Group_3_7_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5012:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5013:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5013:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5014:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5014:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5015:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5016:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5016:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:5019:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5020:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5021:3: ( RULE_NL )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_NL) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5021:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__2__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__3"
    // InternalBug348199TestLanguage.g:5030:1: rule__Timeperiod__Group_3_7_4_1__3 : rule__Timeperiod__Group_3_7_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5034:1: ( rule__Timeperiod__Group_3_7_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:5035:2: rule__Timeperiod__Group_3_7_4_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1__3__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__3"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1__3__Impl"
    // InternalBug348199TestLanguage.g:5041:1: rule__Timeperiod__Group_3_7_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5045:1: ( ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5046:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5046:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:5047:2: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1_3()); 
            // InternalBug348199TestLanguage.g:5048:2: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==28) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5048:3: rule__Timeperiod__Group_3_7_4_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    rule__Timeperiod__Group_3_7_4_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1_3()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1__3__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1_3__0"
    // InternalBug348199TestLanguage.g:5057:1: rule__Timeperiod__Group_3_7_4_1_3__0 : rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5061:1: ( rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 )
            // InternalBug348199TestLanguage.g:5062:2: rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Timeperiod__Group_3_7_4_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1_3__1();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1_3__0"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1_3__0__Impl"
    // InternalBug348199TestLanguage.g:5069:1: rule__Timeperiod__Group_3_7_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5073:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5074:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5074:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:5075:2: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:5076:2: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            // InternalBug348199TestLanguage.g:5076:3: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__TimeAssignment_3_7_4_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_1_3_0()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1_3__0__Impl"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1_3__1"
    // InternalBug348199TestLanguage.g:5084:1: rule__Timeperiod__Group_3_7_4_1_3__1 : rule__Timeperiod__Group_3_7_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5088:1: ( rule__Timeperiod__Group_3_7_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:5089:2: rule__Timeperiod__Group_3_7_4_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__Group_3_7_4_1_3__1__Impl();

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1_3__1"


    // $ANTLR start "rule__Timeperiod__Group_3_7_4_1_3__1__Impl"
    // InternalBug348199TestLanguage.g:5095:1: rule__Timeperiod__Group_3_7_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5099:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5100:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5100:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5101:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5101:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5102:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5103:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5103:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5106:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5107:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5108:3: ( RULE_NL )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_NL) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5108:4: RULE_NL
            	    {
            	    match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 

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
    // $ANTLR end "rule__Timeperiod__Group_3_7_4_1_3__1__Impl"


    // $ANTLR start "rule__TimeDef1__Group__0"
    // InternalBug348199TestLanguage.g:5118:1: rule__TimeDef1__Group__0 : rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 ;
    public final void rule__TimeDef1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5122:1: ( rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 )
            // InternalBug348199TestLanguage.g:5123:2: rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__TimeDef1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef1__Group__1();

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
    // $ANTLR end "rule__TimeDef1__Group__0"


    // $ANTLR start "rule__TimeDef1__Group__0__Impl"
    // InternalBug348199TestLanguage.g:5130:1: rule__TimeDef1__Group__0__Impl : ( 'july' ) ;
    public final void rule__TimeDef1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5134:1: ( ( 'july' ) )
            // InternalBug348199TestLanguage.g:5135:1: ( 'july' )
            {
            // InternalBug348199TestLanguage.g:5135:1: ( 'july' )
            // InternalBug348199TestLanguage.g:5136:2: 'july'
            {
             before(grammarAccess.getTimeDef1Access().getJulyKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef1Access().getJulyKeyword_0()); 

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
    // $ANTLR end "rule__TimeDef1__Group__0__Impl"


    // $ANTLR start "rule__TimeDef1__Group__1"
    // InternalBug348199TestLanguage.g:5145:1: rule__TimeDef1__Group__1 : rule__TimeDef1__Group__1__Impl ;
    public final void rule__TimeDef1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5149:1: ( rule__TimeDef1__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5150:2: rule__TimeDef1__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef1__Group__1__Impl();

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
    // $ANTLR end "rule__TimeDef1__Group__1"


    // $ANTLR start "rule__TimeDef1__Group__1__Impl"
    // InternalBug348199TestLanguage.g:5156:1: rule__TimeDef1__Group__1__Impl : ( ( rule__TimeDef1__DayAssignment_1 ) ) ;
    public final void rule__TimeDef1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5160:1: ( ( ( rule__TimeDef1__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5161:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5161:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5162:2: ( rule__TimeDef1__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef1Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5163:2: ( rule__TimeDef1__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5163:3: rule__TimeDef1__DayAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef1__DayAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef1Access().getDayAssignment_1()); 

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
    // $ANTLR end "rule__TimeDef1__Group__1__Impl"


    // $ANTLR start "rule__TimeDef2__Group__0"
    // InternalBug348199TestLanguage.g:5172:1: rule__TimeDef2__Group__0 : rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 ;
    public final void rule__TimeDef2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5176:1: ( rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 )
            // InternalBug348199TestLanguage.g:5177:2: rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__TimeDef2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef2__Group__1();

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
    // $ANTLR end "rule__TimeDef2__Group__0"


    // $ANTLR start "rule__TimeDef2__Group__0__Impl"
    // InternalBug348199TestLanguage.g:5184:1: rule__TimeDef2__Group__0__Impl : ( 'august' ) ;
    public final void rule__TimeDef2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5188:1: ( ( 'august' ) )
            // InternalBug348199TestLanguage.g:5189:1: ( 'august' )
            {
            // InternalBug348199TestLanguage.g:5189:1: ( 'august' )
            // InternalBug348199TestLanguage.g:5190:2: 'august'
            {
             before(grammarAccess.getTimeDef2Access().getAugustKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef2Access().getAugustKeyword_0()); 

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
    // $ANTLR end "rule__TimeDef2__Group__0__Impl"


    // $ANTLR start "rule__TimeDef2__Group__1"
    // InternalBug348199TestLanguage.g:5199:1: rule__TimeDef2__Group__1 : rule__TimeDef2__Group__1__Impl ;
    public final void rule__TimeDef2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5203:1: ( rule__TimeDef2__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5204:2: rule__TimeDef2__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef2__Group__1__Impl();

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
    // $ANTLR end "rule__TimeDef2__Group__1"


    // $ANTLR start "rule__TimeDef2__Group__1__Impl"
    // InternalBug348199TestLanguage.g:5210:1: rule__TimeDef2__Group__1__Impl : ( ( rule__TimeDef2__DayAssignment_1 ) ) ;
    public final void rule__TimeDef2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5214:1: ( ( ( rule__TimeDef2__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5215:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5215:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5216:2: ( rule__TimeDef2__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef2Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5217:2: ( rule__TimeDef2__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5217:3: rule__TimeDef2__DayAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef2__DayAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef2Access().getDayAssignment_1()); 

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
    // $ANTLR end "rule__TimeDef2__Group__1__Impl"


    // $ANTLR start "rule__TimeDef3__Group__0"
    // InternalBug348199TestLanguage.g:5226:1: rule__TimeDef3__Group__0 : rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 ;
    public final void rule__TimeDef3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5230:1: ( rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 )
            // InternalBug348199TestLanguage.g:5231:2: rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__TimeDef3__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef3__Group__1();

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
    // $ANTLR end "rule__TimeDef3__Group__0"


    // $ANTLR start "rule__TimeDef3__Group__0__Impl"
    // InternalBug348199TestLanguage.g:5238:1: rule__TimeDef3__Group__0__Impl : ( 'september' ) ;
    public final void rule__TimeDef3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5242:1: ( ( 'september' ) )
            // InternalBug348199TestLanguage.g:5243:1: ( 'september' )
            {
            // InternalBug348199TestLanguage.g:5243:1: ( 'september' )
            // InternalBug348199TestLanguage.g:5244:2: 'september'
            {
             before(grammarAccess.getTimeDef3Access().getSeptemberKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef3Access().getSeptemberKeyword_0()); 

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
    // $ANTLR end "rule__TimeDef3__Group__0__Impl"


    // $ANTLR start "rule__TimeDef3__Group__1"
    // InternalBug348199TestLanguage.g:5253:1: rule__TimeDef3__Group__1 : rule__TimeDef3__Group__1__Impl ;
    public final void rule__TimeDef3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5257:1: ( rule__TimeDef3__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5258:2: rule__TimeDef3__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef3__Group__1__Impl();

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
    // $ANTLR end "rule__TimeDef3__Group__1"


    // $ANTLR start "rule__TimeDef3__Group__1__Impl"
    // InternalBug348199TestLanguage.g:5264:1: rule__TimeDef3__Group__1__Impl : ( ( rule__TimeDef3__DayAssignment_1 ) ) ;
    public final void rule__TimeDef3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5268:1: ( ( ( rule__TimeDef3__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5269:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5269:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5270:2: ( rule__TimeDef3__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef3Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5271:2: ( rule__TimeDef3__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5271:3: rule__TimeDef3__DayAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TimeDef3__DayAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeDef3Access().getDayAssignment_1()); 

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
    // $ANTLR end "rule__TimeDef3__Group__1__Impl"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_0_3"
    // InternalBug348199TestLanguage.g:5280:1: rule__Timeperiod__UnorderedGroup_3_0_3 : rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
        	
        try {
            // InternalBug348199TestLanguage.g:5285:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?)
            // InternalBug348199TestLanguage.g:5286:2: rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_0_3__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()) ) {
                throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_0_3"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_0_3__Impl"
    // InternalBug348199TestLanguage.g:5294:1: rule__Timeperiod__UnorderedGroup_3_0_3__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug348199TestLanguage.g:5299:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:5300:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:5300:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5301:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5301:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5302:4: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:5302:110: ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:5303:5: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5309:5: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:5310:6: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0()); 
                    // InternalBug348199TestLanguage.g:5311:6: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    // InternalBug348199TestLanguage.g:5311:7: rule__Timeperiod__Group_3_0_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_0_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:5316:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5316:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5317:4: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:5317:110: ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:5318:5: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5324:5: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:5325:6: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1()); 
                    // InternalBug348199TestLanguage.g:5326:6: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    // InternalBug348199TestLanguage.g:5326:7: rule__Timeperiod__Group_3_0_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_0_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_0_3__Impl"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_0_3__0"
    // InternalBug348199TestLanguage.g:5339:1: rule__Timeperiod__UnorderedGroup_3_0_3__0 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5343:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? )
            // InternalBug348199TestLanguage.g:5344:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__UnorderedGroup_3_0_3__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:5345:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5345:2: rule__Timeperiod__UnorderedGroup_3_0_3__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__UnorderedGroup_3_0_3__1();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_0_3__0"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_0_3__1"
    // InternalBug348199TestLanguage.g:5351:1: rule__Timeperiod__UnorderedGroup_3_0_3__1 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5355:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl )
            // InternalBug348199TestLanguage.g:5356:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_0_3__Impl();

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
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_0_3__1"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_4_4"
    // InternalBug348199TestLanguage.g:5363:1: rule__Timeperiod__UnorderedGroup_3_4_4 : rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
        	
        try {
            // InternalBug348199TestLanguage.g:5368:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?)
            // InternalBug348199TestLanguage.g:5369:2: rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_4_4__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()) ) {
                throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_4_4"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_4_4__Impl"
    // InternalBug348199TestLanguage.g:5377:1: rule__Timeperiod__UnorderedGroup_3_4_4__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug348199TestLanguage.g:5382:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:5383:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:5383:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( LA88_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                alt88=1;
            }
            else if ( LA88_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5384:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5384:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5385:4: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:5385:110: ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:5386:5: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5392:5: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:5393:6: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0()); 
                    // InternalBug348199TestLanguage.g:5394:6: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    // InternalBug348199TestLanguage.g:5394:7: rule__Timeperiod__Group_3_4_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_4_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:5399:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5399:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5400:4: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:5400:110: ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:5401:5: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5407:5: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:5408:6: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1()); 
                    // InternalBug348199TestLanguage.g:5409:6: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    // InternalBug348199TestLanguage.g:5409:7: rule__Timeperiod__Group_3_4_4_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__Group_3_4_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_4_4__Impl"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_4_4__0"
    // InternalBug348199TestLanguage.g:5422:1: rule__Timeperiod__UnorderedGroup_3_4_4__0 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5426:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? )
            // InternalBug348199TestLanguage.g:5427:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__UnorderedGroup_3_4_4__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:5428:2: ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( LA89_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                alt89=1;
            }
            else if ( LA89_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5428:2: rule__Timeperiod__UnorderedGroup_3_4_4__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Timeperiod__UnorderedGroup_3_4_4__1();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_4_4__0"


    // $ANTLR start "rule__Timeperiod__UnorderedGroup_3_4_4__1"
    // InternalBug348199TestLanguage.g:5434:1: rule__Timeperiod__UnorderedGroup_3_4_4__1 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5438:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl )
            // InternalBug348199TestLanguage.g:5439:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Timeperiod__UnorderedGroup_3_4_4__Impl();

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
    // $ANTLR end "rule__Timeperiod__UnorderedGroup_3_4_4__1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_0_2_1"
    // InternalBug348199TestLanguage.g:5446:1: rule__Timeperiod__TimeAssignment_3_0_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5450:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5451:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5451:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5452:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_0_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_0_2_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_0_2_1"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_0_3_0_2"
    // InternalBug348199TestLanguage.g:5461:1: rule__Timeperiod__NameAssignment_3_0_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_0_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5465:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5466:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5466:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5467:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_0_3_0_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_0_3_0_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_0_3_0_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_0_3_0_3_1"
    // InternalBug348199TestLanguage.g:5476:1: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5480:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5481:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5481:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5482:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_0_3_0_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_0_3_0_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_0_3_0_3_1"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_0_3_1_2"
    // InternalBug348199TestLanguage.g:5491:1: rule__Timeperiod__AliasAssignment_3_0_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_0_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5495:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5496:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5496:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5497:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_0_3_1_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_0_3_1_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_0_3_1_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_0_3_1_3_1"
    // InternalBug348199TestLanguage.g:5506:1: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5510:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5511:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5511:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5512:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_0_3_1_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_0_3_1_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_0_3_1_3_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_1_2_1"
    // InternalBug348199TestLanguage.g:5521:1: rule__Timeperiod__TimeAssignment_3_1_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5525:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5526:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5526:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5527:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_1_2_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_1_2_1"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_1_3_0_2"
    // InternalBug348199TestLanguage.g:5536:1: rule__Timeperiod__NameAssignment_3_1_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_1_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5540:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5541:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5541:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5542:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_1_3_0_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_1_3_0_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_1_3_0_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_1_3_0_3_1"
    // InternalBug348199TestLanguage.g:5551:1: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5555:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5556:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5556:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5557:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_1_3_0_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_1_3_0_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_1_3_0_3_1"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_1_3_1_2"
    // InternalBug348199TestLanguage.g:5566:1: rule__Timeperiod__AliasAssignment_3_1_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_1_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5570:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5571:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5571:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5572:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_1_3_1_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_1_3_1_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_1_3_1_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_1_3_1_3_1"
    // InternalBug348199TestLanguage.g:5581:1: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5585:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5586:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5586:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5587:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_1_3_1_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_1_3_1_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_1_3_1_3_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_2_2_1"
    // InternalBug348199TestLanguage.g:5596:1: rule__Timeperiod__TimeAssignment_3_2_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5600:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5601:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5601:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5602:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_2_2_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_2_2_1"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_2_3_0_2"
    // InternalBug348199TestLanguage.g:5611:1: rule__Timeperiod__NameAssignment_3_2_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_2_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5615:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5616:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5616:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5617:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_2_3_0_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_2_3_0_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_2_3_0_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_2_3_0_3_1"
    // InternalBug348199TestLanguage.g:5626:1: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5630:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5631:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5631:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5632:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_2_3_0_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_2_3_0_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_2_3_0_3_1"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_2_3_1_2"
    // InternalBug348199TestLanguage.g:5641:1: rule__Timeperiod__AliasAssignment_3_2_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_2_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5645:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5646:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5646:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5647:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_2_3_1_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_2_3_1_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_2_3_1_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_2_3_1_3_1"
    // InternalBug348199TestLanguage.g:5656:1: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5660:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5661:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5661:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5662:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_2_3_1_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_2_3_1_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_2_3_1_3_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_3_2_1"
    // InternalBug348199TestLanguage.g:5671:1: rule__Timeperiod__TimeAssignment_3_3_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5675:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5676:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5676:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5677:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_3_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_3_2_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_3_2_1"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_3_3_0_2"
    // InternalBug348199TestLanguage.g:5686:1: rule__Timeperiod__NameAssignment_3_3_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_3_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5690:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5691:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5691:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5692:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_3_3_0_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_3_3_0_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_3_3_0_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_3_3_0_3_1"
    // InternalBug348199TestLanguage.g:5701:1: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5705:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5706:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5706:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5707:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_3_3_0_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_3_3_0_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_3_3_0_3_1"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_3_3_1_2"
    // InternalBug348199TestLanguage.g:5716:1: rule__Timeperiod__AliasAssignment_3_3_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_3_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5720:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5721:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5721:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5722:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_3_3_1_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_3_3_1_2_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_3_3_1_2"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_3_3_1_3_1"
    // InternalBug348199TestLanguage.g:5731:1: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5735:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5736:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5736:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5737:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_3_3_1_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_3_3_1_3_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_3_3_1_3_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_4_3_0"
    // InternalBug348199TestLanguage.g:5746:1: rule__Timeperiod__TimeAssignment_3_4_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5750:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5751:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5751:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5752:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_4_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_4_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_4_3_0"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_4_4_0_1"
    // InternalBug348199TestLanguage.g:5761:1: rule__Timeperiod__NameAssignment_3_4_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_4_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5765:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5766:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5766:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5767:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_4_4_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_4_4_0_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_4_4_0_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_4_4_0_3_0"
    // InternalBug348199TestLanguage.g:5776:1: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5780:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5781:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5781:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5782:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_4_4_0_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_4_4_0_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_4_4_0_3_0"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_4_4_1_1"
    // InternalBug348199TestLanguage.g:5791:1: rule__Timeperiod__AliasAssignment_3_4_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_4_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5795:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5796:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5796:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5797:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_4_4_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_4_4_1_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_4_4_1_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_4_4_1_3_0"
    // InternalBug348199TestLanguage.g:5806:1: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5810:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5811:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5811:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5812:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_4_4_1_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_4_4_1_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_4_4_1_3_0"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_5_3_0"
    // InternalBug348199TestLanguage.g:5821:1: rule__Timeperiod__TimeAssignment_3_5_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5825:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5826:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5826:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5827:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_5_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_5_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_5_3_0"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_5_4_0_1"
    // InternalBug348199TestLanguage.g:5836:1: rule__Timeperiod__NameAssignment_3_5_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_5_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5840:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5841:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5841:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5842:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_5_4_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_5_4_0_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_5_4_0_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_5_4_0_3_0"
    // InternalBug348199TestLanguage.g:5851:1: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5855:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5856:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5856:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5857:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_5_4_0_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_5_4_0_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_5_4_0_3_0"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_5_4_1_1"
    // InternalBug348199TestLanguage.g:5866:1: rule__Timeperiod__AliasAssignment_3_5_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_5_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5870:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5871:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5871:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5872:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_5_4_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_5_4_1_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_5_4_1_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_5_4_1_3_0"
    // InternalBug348199TestLanguage.g:5881:1: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5885:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5886:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5886:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5887:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_5_4_1_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_5_4_1_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_5_4_1_3_0"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_6_3_0"
    // InternalBug348199TestLanguage.g:5896:1: rule__Timeperiod__TimeAssignment_3_6_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5900:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5901:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5901:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5902:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_6_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_6_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_6_3_0"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_6_4_0_1"
    // InternalBug348199TestLanguage.g:5911:1: rule__Timeperiod__NameAssignment_3_6_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_6_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5915:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5916:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5916:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5917:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_6_4_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_6_4_0_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_6_4_0_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_6_4_0_3_0"
    // InternalBug348199TestLanguage.g:5926:1: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5930:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5931:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5931:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5932:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_6_4_0_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_6_4_0_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_6_4_0_3_0"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_6_4_1_1"
    // InternalBug348199TestLanguage.g:5941:1: rule__Timeperiod__AliasAssignment_3_6_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_6_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5945:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5946:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5946:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5947:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_6_4_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_6_4_1_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_6_4_1_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_6_4_1_3_0"
    // InternalBug348199TestLanguage.g:5956:1: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5960:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5961:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5961:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5962:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_6_4_1_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_6_4_1_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_6_4_1_3_0"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_7_3_0"
    // InternalBug348199TestLanguage.g:5971:1: rule__Timeperiod__TimeAssignment_3_7_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5975:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5976:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5976:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5977:3: ruleTimeDef1
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_7_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef1();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_7_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_7_3_0"


    // $ANTLR start "rule__Timeperiod__NameAssignment_3_7_4_0_1"
    // InternalBug348199TestLanguage.g:5986:1: rule__Timeperiod__NameAssignment_3_7_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_7_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5990:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5991:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5991:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5992:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_7_4_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_7_4_0_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__NameAssignment_3_7_4_0_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_7_4_0_3_0"
    // InternalBug348199TestLanguage.g:6001:1: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6005:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6006:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6006:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6007:3: ruleTimeDef2
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_7_4_0_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef2();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_7_4_0_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_7_4_0_3_0"


    // $ANTLR start "rule__Timeperiod__AliasAssignment_3_7_4_1_1"
    // InternalBug348199TestLanguage.g:6016:1: rule__Timeperiod__AliasAssignment_3_7_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_7_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6020:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6021:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6021:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6022:3: RULE_ID
            {
             before(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_7_4_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_7_4_1_1_0()); 

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
    // $ANTLR end "rule__Timeperiod__AliasAssignment_3_7_4_1_1"


    // $ANTLR start "rule__Timeperiod__TimeAssignment_3_7_4_1_3_0"
    // InternalBug348199TestLanguage.g:6031:1: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6035:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6036:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6036:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6037:3: ruleTimeDef3
            {
             before(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_7_4_1_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTimeDef3();

            state._fsp--;

             after(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_7_4_1_3_0_0()); 

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
    // $ANTLR end "rule__Timeperiod__TimeAssignment_3_7_4_1_3_0"


    // $ANTLR start "rule__TimeDef1__DayAssignment_1"
    // InternalBug348199TestLanguage.g:6046:1: rule__TimeDef1__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef1__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6050:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6051:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6051:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6052:3: RULE_INT
            {
             before(grammarAccess.getTimeDef1Access().getDayINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef1Access().getDayINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TimeDef1__DayAssignment_1"


    // $ANTLR start "rule__TimeDef2__DayAssignment_1"
    // InternalBug348199TestLanguage.g:6061:1: rule__TimeDef2__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef2__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6065:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6066:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6066:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6067:3: RULE_INT
            {
             before(grammarAccess.getTimeDef2Access().getDayINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef2Access().getDayINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TimeDef2__DayAssignment_1"


    // $ANTLR start "rule__TimeDef3__DayAssignment_1"
    // InternalBug348199TestLanguage.g:6076:1: rule__TimeDef3__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef3__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6080:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6081:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6081:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6082:3: RULE_INT
            {
             before(grammarAccess.getTimeDef3Access().getDayINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTimeDef3Access().getDayINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TimeDef3__DayAssignment_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA87 dfa87 = new DFA87(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\3\4\2\uffff";
    static final String dfa_3s = "\1\4\2\22\2\uffff";
    static final String dfa_4s = "\3\uffff\1\2\1\1";
    static final String dfa_5s = "\5\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2\13\uffff\1\3\1\4\1\3",
            "\1\2\13\uffff\1\3\1\4\1\3",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "214:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );";
        }
    }
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\13\uffff\1\3\1\uffff\1\4",
            "\1\2\13\uffff\1\3\1\uffff\1\4",
            "",
            ""
    };
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "227:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?";
        }
    }
    static final String[] dfa_8s = {
            "\1\1",
            "\1\2\14\uffff\1\4\1\3",
            "\1\2\14\uffff\1\4\1\3",
            "",
            ""
    };
    static final short[][] dfa_8 = unpackEncodedStringArray(dfa_8s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "235:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );";
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "256:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );";
        }
    }
    static final String dfa_9s = "\1\4\2\32\2\uffff";
    static final String[] dfa_10s = {
            "\1\1",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "",
            ""
    };
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_9;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "()* loopback of 521:2: ( rule__Timeperiod__Group_3_0_2__0 )*";
        }
    }
    static final String dfa_11s = "\1\4\2\33\2\uffff";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "",
            ""
    };
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_11;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 784:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*";
        }
    }
    static final String dfa_13s = "\1\4\2\34\2\uffff";
    static final String[] dfa_14s = {
            "\1\1",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 960:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*";
        }
    }
    static final String[] dfa_15s = {
            "\1\1",
            "\1\2\13\uffff\3\3\7\uffff\1\4",
            "\1\2\13\uffff\3\3\7\uffff\1\4",
            "",
            ""
    };
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_9;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "()* loopback of 1103:2: ( rule__Timeperiod__Group_3_1_2__0 )*";
        }
    }
    static final String dfa_16s = "\3\uffff\1\1\1\2";
    static final String[] dfa_17s = {
            "\1\1",
            "\1\2\13\uffff\1\4\12\uffff\1\3",
            "\1\2\13\uffff\1\4\12\uffff\1\3",
            "",
            ""
    };
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_11;
            this.accept = dfa_16;
            this.special = dfa_5;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "()* loopback of 1366:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*";
        }
    }
    static final String[] dfa_18s = {
            "\1\1",
            "\1\2\13\uffff\1\4\13\uffff\1\3",
            "\1\2\13\uffff\1\4\13\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_16;
            this.special = dfa_5;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 1542:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*";
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_9;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "()* loopback of 1685:2: ( rule__Timeperiod__Group_3_2_2__0 )*";
        }
    }
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2\13\uffff\1\3\2\4",
            "\1\2\13\uffff\1\3\2\4",
            "",
            ""
    };
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 1718:3: ( rule__Timeperiod__Alternatives_3_2_3 )*";
        }
    }
    static final String[] dfa_20s = {
            "\1\1",
            "\1\2\13\uffff\3\4\10\uffff\1\3",
            "\1\2\13\uffff\3\4\10\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_11;
            this.accept = dfa_16;
            this.special = dfa_5;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "()* loopback of 1955:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*";
        }
    }
    static final String[] dfa_21s = {
            "\1\1",
            "\1\2\13\uffff\3\4\11\uffff\1\3",
            "\1\2\13\uffff\3\4\11\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_16;
            this.special = dfa_5;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "()* loopback of 2131:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*";
        }
    }
    static final String[] dfa_22s = {
            "\1\1",
            "\1\2\13\uffff\3\4\7\uffff\1\3",
            "\1\2\13\uffff\3\4\7\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_9;
            this.accept = dfa_16;
            this.special = dfa_5;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "()* loopback of 2274:2: ( rule__Timeperiod__Group_3_3_2__0 )*";
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 2301:2: ( rule__Timeperiod__Alternatives_3_3_3 )*";
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_11;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 2537:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*";
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 2713:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*";
        }
    }
    static final String dfa_23s = "\1\1\1\0\1\2\2\uffff}>";
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_23;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "5300:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_1 = input.LA(1);

                         
                        int index86_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_1 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) ) {s = 2;}

                        else if ( LA86_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                        else if ( LA86_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                         
                        input.seek(index86_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA86_0 = input.LA(1);

                         
                        int index86_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_0 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) ) {s = 1;}

                         
                        input.seek(index86_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA86_2 = input.LA(1);

                         
                        int index86_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_2 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                        else if ( LA86_2 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) ) {s = 2;}

                        else if ( LA86_2 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                         
                        input.seek(index86_2);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 86, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_24s = "\6\uffff";
    static final String dfa_25s = "\3\4\3\uffff";
    static final String dfa_26s = "\1\4\2\22\3\uffff";
    static final String dfa_27s = "\3\uffff\2\1\1\2";
    static final String dfa_28s = "\1\uffff\1\1\1\0\3\uffff}>";
    static final String[] dfa_29s = {
            "\1\1",
            "\1\2\13\uffff\1\5\1\4\1\3",
            "\1\2\13\uffff\1\5\1\4\1\3",
            "",
            "",
            ""
    };

    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_24;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_28;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "5345:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_2 = input.LA(1);

                         
                        int index87_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA87_2 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                        else if ( (LA87_2==RULE_NL) ) {s = 2;}

                        else if ( (LA87_2==16) ) {s = 5;}

                        else if ( LA87_2 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                         
                        input.seek(index87_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA87_1==RULE_NL) ) {s = 2;}

                        else if ( LA87_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                        else if ( LA87_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                        else if ( (LA87_1==16) ) {s = 5;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003F84000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004060000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004060002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004070000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    }


}