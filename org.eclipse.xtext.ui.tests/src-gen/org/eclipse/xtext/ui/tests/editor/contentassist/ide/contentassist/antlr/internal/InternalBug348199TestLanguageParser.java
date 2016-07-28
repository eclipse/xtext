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
    // InternalBug348199TestLanguage.g:53:1: entryRuleTimeperiod : ruleTimeperiod EOF ;
    public final void entryRuleTimeperiod() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:54:1: ( ruleTimeperiod EOF )
            // InternalBug348199TestLanguage.g:55:1: ruleTimeperiod EOF
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
    // InternalBug348199TestLanguage.g:62:1: ruleTimeperiod : ( ( rule__Timeperiod__Group__0 ) ) ;
    public final void ruleTimeperiod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:66:2: ( ( ( rule__Timeperiod__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:67:2: ( ( rule__Timeperiod__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:67:2: ( ( rule__Timeperiod__Group__0 ) )
            // InternalBug348199TestLanguage.g:68:3: ( rule__Timeperiod__Group__0 )
            {
             before(grammarAccess.getTimeperiodAccess().getGroup()); 
            // InternalBug348199TestLanguage.g:69:3: ( rule__Timeperiod__Group__0 )
            // InternalBug348199TestLanguage.g:69:4: rule__Timeperiod__Group__0
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
    // InternalBug348199TestLanguage.g:78:1: entryRuleTimeDef1 : ruleTimeDef1 EOF ;
    public final void entryRuleTimeDef1() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:79:1: ( ruleTimeDef1 EOF )
            // InternalBug348199TestLanguage.g:80:1: ruleTimeDef1 EOF
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
    // InternalBug348199TestLanguage.g:87:1: ruleTimeDef1 : ( ( rule__TimeDef1__Group__0 ) ) ;
    public final void ruleTimeDef1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:91:2: ( ( ( rule__TimeDef1__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:92:2: ( ( rule__TimeDef1__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:92:2: ( ( rule__TimeDef1__Group__0 ) )
            // InternalBug348199TestLanguage.g:93:3: ( rule__TimeDef1__Group__0 )
            {
             before(grammarAccess.getTimeDef1Access().getGroup()); 
            // InternalBug348199TestLanguage.g:94:3: ( rule__TimeDef1__Group__0 )
            // InternalBug348199TestLanguage.g:94:4: rule__TimeDef1__Group__0
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
    // InternalBug348199TestLanguage.g:103:1: entryRuleTimeDef2 : ruleTimeDef2 EOF ;
    public final void entryRuleTimeDef2() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:104:1: ( ruleTimeDef2 EOF )
            // InternalBug348199TestLanguage.g:105:1: ruleTimeDef2 EOF
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
    // InternalBug348199TestLanguage.g:112:1: ruleTimeDef2 : ( ( rule__TimeDef2__Group__0 ) ) ;
    public final void ruleTimeDef2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:116:2: ( ( ( rule__TimeDef2__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:117:2: ( ( rule__TimeDef2__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:117:2: ( ( rule__TimeDef2__Group__0 ) )
            // InternalBug348199TestLanguage.g:118:3: ( rule__TimeDef2__Group__0 )
            {
             before(grammarAccess.getTimeDef2Access().getGroup()); 
            // InternalBug348199TestLanguage.g:119:3: ( rule__TimeDef2__Group__0 )
            // InternalBug348199TestLanguage.g:119:4: rule__TimeDef2__Group__0
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
    // InternalBug348199TestLanguage.g:128:1: entryRuleTimeDef3 : ruleTimeDef3 EOF ;
    public final void entryRuleTimeDef3() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:129:1: ( ruleTimeDef3 EOF )
            // InternalBug348199TestLanguage.g:130:1: ruleTimeDef3 EOF
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
    // InternalBug348199TestLanguage.g:137:1: ruleTimeDef3 : ( ( rule__TimeDef3__Group__0 ) ) ;
    public final void ruleTimeDef3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:141:2: ( ( ( rule__TimeDef3__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:142:2: ( ( rule__TimeDef3__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:142:2: ( ( rule__TimeDef3__Group__0 ) )
            // InternalBug348199TestLanguage.g:143:3: ( rule__TimeDef3__Group__0 )
            {
             before(grammarAccess.getTimeDef3Access().getGroup()); 
            // InternalBug348199TestLanguage.g:144:3: ( rule__TimeDef3__Group__0 )
            // InternalBug348199TestLanguage.g:144:4: rule__TimeDef3__Group__0
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
    // InternalBug348199TestLanguage.g:152:1: rule__Timeperiod__Alternatives_3 : ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:156:1: ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:157:2: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:157:2: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:158:3: ( rule__Timeperiod__Group_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0()); 
                    // InternalBug348199TestLanguage.g:159:3: ( rule__Timeperiod__Group_3_0__0 )
                    // InternalBug348199TestLanguage.g:159:4: rule__Timeperiod__Group_3_0__0
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
                    // InternalBug348199TestLanguage.g:163:2: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:163:2: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:164:3: ( rule__Timeperiod__Group_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1()); 
                    // InternalBug348199TestLanguage.g:165:3: ( rule__Timeperiod__Group_3_1__0 )
                    // InternalBug348199TestLanguage.g:165:4: rule__Timeperiod__Group_3_1__0
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
                    // InternalBug348199TestLanguage.g:169:2: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:169:2: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    // InternalBug348199TestLanguage.g:170:3: ( rule__Timeperiod__Group_3_2__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2()); 
                    // InternalBug348199TestLanguage.g:171:3: ( rule__Timeperiod__Group_3_2__0 )
                    // InternalBug348199TestLanguage.g:171:4: rule__Timeperiod__Group_3_2__0
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
                    // InternalBug348199TestLanguage.g:175:2: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:175:2: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    // InternalBug348199TestLanguage.g:176:3: ( rule__Timeperiod__Group_3_3__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3()); 
                    // InternalBug348199TestLanguage.g:177:3: ( rule__Timeperiod__Group_3_3__0 )
                    // InternalBug348199TestLanguage.g:177:4: rule__Timeperiod__Group_3_3__0
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
                    // InternalBug348199TestLanguage.g:181:2: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:181:2: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    // InternalBug348199TestLanguage.g:182:3: ( rule__Timeperiod__Group_3_4__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4()); 
                    // InternalBug348199TestLanguage.g:183:3: ( rule__Timeperiod__Group_3_4__0 )
                    // InternalBug348199TestLanguage.g:183:4: rule__Timeperiod__Group_3_4__0
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
                    // InternalBug348199TestLanguage.g:187:2: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:187:2: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    // InternalBug348199TestLanguage.g:188:3: ( rule__Timeperiod__Group_3_5__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5()); 
                    // InternalBug348199TestLanguage.g:189:3: ( rule__Timeperiod__Group_3_5__0 )
                    // InternalBug348199TestLanguage.g:189:4: rule__Timeperiod__Group_3_5__0
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
                    // InternalBug348199TestLanguage.g:193:2: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:193:2: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    // InternalBug348199TestLanguage.g:194:3: ( rule__Timeperiod__Group_3_6__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6()); 
                    // InternalBug348199TestLanguage.g:195:3: ( rule__Timeperiod__Group_3_6__0 )
                    // InternalBug348199TestLanguage.g:195:4: rule__Timeperiod__Group_3_6__0
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
                    // InternalBug348199TestLanguage.g:199:2: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:199:2: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    // InternalBug348199TestLanguage.g:200:3: ( rule__Timeperiod__Group_3_7__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7()); 
                    // InternalBug348199TestLanguage.g:201:3: ( rule__Timeperiod__Group_3_7__0 )
                    // InternalBug348199TestLanguage.g:201:4: rule__Timeperiod__Group_3_7__0
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
    // InternalBug348199TestLanguage.g:209:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:213:1: ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348199TestLanguage.g:214:2: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:214:2: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:215:3: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0()); 
                    // InternalBug348199TestLanguage.g:216:3: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    // InternalBug348199TestLanguage.g:216:4: rule__Timeperiod__Group_3_1_3_0__0
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
                    // InternalBug348199TestLanguage.g:220:2: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:220:2: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    // InternalBug348199TestLanguage.g:221:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1()); 
                    // InternalBug348199TestLanguage.g:222:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:222:4: rule__Timeperiod__Group_3_1_3_1__0
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
    // InternalBug348199TestLanguage.g:230:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:234:1: ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348199TestLanguage.g:235:2: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:235:2: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:236:3: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0()); 
                    // InternalBug348199TestLanguage.g:237:3: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    // InternalBug348199TestLanguage.g:237:4: rule__Timeperiod__Group_3_2_3_0__0
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
                    // InternalBug348199TestLanguage.g:241:2: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:241:2: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:242:3: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1()); 
                    // InternalBug348199TestLanguage.g:243:3: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    // InternalBug348199TestLanguage.g:243:4: rule__Timeperiod__Group_3_2_3_1__0
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
    // InternalBug348199TestLanguage.g:251:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:255:1: ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348199TestLanguage.g:256:2: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:256:2: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:257:3: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0()); 
                    // InternalBug348199TestLanguage.g:258:3: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    // InternalBug348199TestLanguage.g:258:4: rule__Timeperiod__Group_3_3_3_0__0
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
                    // InternalBug348199TestLanguage.g:262:2: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:262:2: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:263:3: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1()); 
                    // InternalBug348199TestLanguage.g:264:3: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    // InternalBug348199TestLanguage.g:264:4: rule__Timeperiod__Group_3_3_3_1__0
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
    // InternalBug348199TestLanguage.g:272:1: rule__Timeperiod__Alternatives_3_5_4 : ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:276:1: ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) )
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
                    // InternalBug348199TestLanguage.g:277:2: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:277:2: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:278:3: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0()); 
                    // InternalBug348199TestLanguage.g:279:3: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    // InternalBug348199TestLanguage.g:279:4: rule__Timeperiod__Group_3_5_4_0__0
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
                    // InternalBug348199TestLanguage.g:283:2: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:283:2: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    // InternalBug348199TestLanguage.g:284:3: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1()); 
                    // InternalBug348199TestLanguage.g:285:3: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==18) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:285:4: rule__Timeperiod__Group_3_5_4_1__0
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
    // InternalBug348199TestLanguage.g:293:1: rule__Timeperiod__Alternatives_3_6_4 : ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:297:1: ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:298:2: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:298:2: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:299:3: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0()); 
                    // InternalBug348199TestLanguage.g:300:3: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    // InternalBug348199TestLanguage.g:300:4: rule__Timeperiod__Group_3_6_4_0__0
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
                    // InternalBug348199TestLanguage.g:304:2: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:304:2: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:305:3: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1()); 
                    // InternalBug348199TestLanguage.g:306:3: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    // InternalBug348199TestLanguage.g:306:4: rule__Timeperiod__Group_3_6_4_1__0
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
    // InternalBug348199TestLanguage.g:314:1: rule__Timeperiod__Alternatives_3_7_4 : ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:318:1: ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:319:2: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:319:2: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:320:3: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0()); 
                    // InternalBug348199TestLanguage.g:321:3: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    // InternalBug348199TestLanguage.g:321:4: rule__Timeperiod__Group_3_7_4_0__0
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
                    // InternalBug348199TestLanguage.g:325:2: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:325:2: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:326:3: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1()); 
                    // InternalBug348199TestLanguage.g:327:3: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    // InternalBug348199TestLanguage.g:327:4: rule__Timeperiod__Group_3_7_4_1__0
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
    // InternalBug348199TestLanguage.g:335:1: rule__Timeperiod__Group__0 : rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 ;
    public final void rule__Timeperiod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:339:1: ( rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 )
            // InternalBug348199TestLanguage.g:340:2: rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1
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
    // InternalBug348199TestLanguage.g:347:1: rule__Timeperiod__Group__0__Impl : ( () ) ;
    public final void rule__Timeperiod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:351:1: ( ( () ) )
            // InternalBug348199TestLanguage.g:352:1: ( () )
            {
            // InternalBug348199TestLanguage.g:352:1: ( () )
            // InternalBug348199TestLanguage.g:353:2: ()
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiodAction_0()); 
            // InternalBug348199TestLanguage.g:354:2: ()
            // InternalBug348199TestLanguage.g:354:3: 
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
    // InternalBug348199TestLanguage.g:362:1: rule__Timeperiod__Group__1 : rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 ;
    public final void rule__Timeperiod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:366:1: ( rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 )
            // InternalBug348199TestLanguage.g:367:2: rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2
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
    // InternalBug348199TestLanguage.g:374:1: rule__Timeperiod__Group__1__Impl : ( 'define' ) ;
    public final void rule__Timeperiod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:378:1: ( ( 'define' ) )
            // InternalBug348199TestLanguage.g:379:1: ( 'define' )
            {
            // InternalBug348199TestLanguage.g:379:1: ( 'define' )
            // InternalBug348199TestLanguage.g:380:2: 'define'
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
    // InternalBug348199TestLanguage.g:389:1: rule__Timeperiod__Group__2 : rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 ;
    public final void rule__Timeperiod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:393:1: ( rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 )
            // InternalBug348199TestLanguage.g:394:2: rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3
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
    // InternalBug348199TestLanguage.g:401:1: rule__Timeperiod__Group__2__Impl : ( 'timeperiod' ) ;
    public final void rule__Timeperiod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:405:1: ( ( 'timeperiod' ) )
            // InternalBug348199TestLanguage.g:406:1: ( 'timeperiod' )
            {
            // InternalBug348199TestLanguage.g:406:1: ( 'timeperiod' )
            // InternalBug348199TestLanguage.g:407:2: 'timeperiod'
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
    // InternalBug348199TestLanguage.g:416:1: rule__Timeperiod__Group__3 : rule__Timeperiod__Group__3__Impl ;
    public final void rule__Timeperiod__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:420:1: ( rule__Timeperiod__Group__3__Impl )
            // InternalBug348199TestLanguage.g:421:2: rule__Timeperiod__Group__3__Impl
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
    // InternalBug348199TestLanguage.g:427:1: rule__Timeperiod__Group__3__Impl : ( ( rule__Timeperiod__Alternatives_3 ) ) ;
    public final void rule__Timeperiod__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:431:1: ( ( ( rule__Timeperiod__Alternatives_3 ) ) )
            // InternalBug348199TestLanguage.g:432:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            {
            // InternalBug348199TestLanguage.g:432:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            // InternalBug348199TestLanguage.g:433:2: ( rule__Timeperiod__Alternatives_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3()); 
            // InternalBug348199TestLanguage.g:434:2: ( rule__Timeperiod__Alternatives_3 )
            // InternalBug348199TestLanguage.g:434:3: rule__Timeperiod__Alternatives_3
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
    // InternalBug348199TestLanguage.g:443:1: rule__Timeperiod__Group_3_0__0 : rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:447:1: ( rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 )
            // InternalBug348199TestLanguage.g:448:2: rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1
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
    // InternalBug348199TestLanguage.g:455:1: rule__Timeperiod__Group_3_0__0__Impl : ( '1' ) ;
    public final void rule__Timeperiod__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:459:1: ( ( '1' ) )
            // InternalBug348199TestLanguage.g:460:1: ( '1' )
            {
            // InternalBug348199TestLanguage.g:460:1: ( '1' )
            // InternalBug348199TestLanguage.g:461:2: '1'
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
    // InternalBug348199TestLanguage.g:470:1: rule__Timeperiod__Group_3_0__1 : rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:474:1: ( rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 )
            // InternalBug348199TestLanguage.g:475:2: rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2
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
    // InternalBug348199TestLanguage.g:482:1: rule__Timeperiod__Group_3_0__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:486:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:487:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:487:1: ( '{' )
            // InternalBug348199TestLanguage.g:488:2: '{'
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
    // InternalBug348199TestLanguage.g:497:1: rule__Timeperiod__Group_3_0__2 : rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:501:1: ( rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 )
            // InternalBug348199TestLanguage.g:502:2: rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3
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
    // InternalBug348199TestLanguage.g:509:1: rule__Timeperiod__Group_3_0__2__Impl : ( ( rule__Timeperiod__Group_3_0_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:513:1: ( ( ( rule__Timeperiod__Group_3_0_2__0 )* ) )
            // InternalBug348199TestLanguage.g:514:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:514:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            // InternalBug348199TestLanguage.g:515:2: ( rule__Timeperiod__Group_3_0_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_2()); 
            // InternalBug348199TestLanguage.g:516:2: ( rule__Timeperiod__Group_3_0_2__0 )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:516:3: rule__Timeperiod__Group_3_0_2__0
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
    // InternalBug348199TestLanguage.g:524:1: rule__Timeperiod__Group_3_0__3 : rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 ;
    public final void rule__Timeperiod__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:528:1: ( rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 )
            // InternalBug348199TestLanguage.g:529:2: rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4
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
    // InternalBug348199TestLanguage.g:536:1: rule__Timeperiod__Group_3_0__3__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) ;
    public final void rule__Timeperiod__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:540:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) )
            // InternalBug348199TestLanguage.g:541:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            {
            // InternalBug348199TestLanguage.g:541:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            // InternalBug348199TestLanguage.g:542:2: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()); 
            // InternalBug348199TestLanguage.g:543:2: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            // InternalBug348199TestLanguage.g:543:3: rule__Timeperiod__UnorderedGroup_3_0_3
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
    // InternalBug348199TestLanguage.g:551:1: rule__Timeperiod__Group_3_0__4 : rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 ;
    public final void rule__Timeperiod__Group_3_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:555:1: ( rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 )
            // InternalBug348199TestLanguage.g:556:2: rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5
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
    // InternalBug348199TestLanguage.g:563:1: rule__Timeperiod__Group_3_0__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:567:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:568:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:568:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:569:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:569:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:570:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:571:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:571:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 

            }

            // InternalBug348199TestLanguage.g:574:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:575:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:576:3: ( RULE_NL )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_NL) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:576:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:585:1: rule__Timeperiod__Group_3_0__5 : rule__Timeperiod__Group_3_0__5__Impl ;
    public final void rule__Timeperiod__Group_3_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:589:1: ( rule__Timeperiod__Group_3_0__5__Impl )
            // InternalBug348199TestLanguage.g:590:2: rule__Timeperiod__Group_3_0__5__Impl
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
    // InternalBug348199TestLanguage.g:596:1: rule__Timeperiod__Group_3_0__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:600:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:601:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:601:1: ( '}' )
            // InternalBug348199TestLanguage.g:602:2: '}'
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
    // InternalBug348199TestLanguage.g:612:1: rule__Timeperiod__Group_3_0_2__0 : rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 ;
    public final void rule__Timeperiod__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:616:1: ( rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 )
            // InternalBug348199TestLanguage.g:617:2: rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1
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
    // InternalBug348199TestLanguage.g:624:1: rule__Timeperiod__Group_3_0_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:628:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:629:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:629:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:630:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:630:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:631:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:632:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:632:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 

            }

            // InternalBug348199TestLanguage.g:635:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:636:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:637:3: ( RULE_NL )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:637:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:646:1: rule__Timeperiod__Group_3_0_2__1 : rule__Timeperiod__Group_3_0_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:650:1: ( rule__Timeperiod__Group_3_0_2__1__Impl )
            // InternalBug348199TestLanguage.g:651:2: rule__Timeperiod__Group_3_0_2__1__Impl
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
    // InternalBug348199TestLanguage.g:657:1: rule__Timeperiod__Group_3_0_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:661:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) )
            // InternalBug348199TestLanguage.g:662:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:662:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            // InternalBug348199TestLanguage.g:663:2: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_2_1()); 
            // InternalBug348199TestLanguage.g:664:2: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            // InternalBug348199TestLanguage.g:664:3: rule__Timeperiod__TimeAssignment_3_0_2_1
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
    // InternalBug348199TestLanguage.g:673:1: rule__Timeperiod__Group_3_0_3_0__0 : rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:677:1: ( rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 )
            // InternalBug348199TestLanguage.g:678:2: rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1
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
    // InternalBug348199TestLanguage.g:685:1: rule__Timeperiod__Group_3_0_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:689:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:690:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:690:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:691:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:691:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:692:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:693:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:693:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:696:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:697:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:698:3: ( RULE_NL )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:698:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:707:1: rule__Timeperiod__Group_3_0_3_0__1 : rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:711:1: ( rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 )
            // InternalBug348199TestLanguage.g:712:2: rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2
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
    // InternalBug348199TestLanguage.g:719:1: rule__Timeperiod__Group_3_0_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:723:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:724:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:724:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:725:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:734:1: rule__Timeperiod__Group_3_0_3_0__2 : rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:738:1: ( rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 )
            // InternalBug348199TestLanguage.g:739:2: rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3
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
    // InternalBug348199TestLanguage.g:746:1: rule__Timeperiod__Group_3_0_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:750:1: ( ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:751:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:751:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            // InternalBug348199TestLanguage.g:752:2: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_0_3_0_2()); 
            // InternalBug348199TestLanguage.g:753:2: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            // InternalBug348199TestLanguage.g:753:3: rule__Timeperiod__NameAssignment_3_0_3_0_2
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
    // InternalBug348199TestLanguage.g:761:1: rule__Timeperiod__Group_3_0_3_0__3 : rule__Timeperiod__Group_3_0_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:765:1: ( rule__Timeperiod__Group_3_0_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:766:2: rule__Timeperiod__Group_3_0_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:772:1: rule__Timeperiod__Group_3_0_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:776:1: ( ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:777:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:777:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:778:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0_3()); 
            // InternalBug348199TestLanguage.g:779:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:779:3: rule__Timeperiod__Group_3_0_3_0_3__0
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
    // InternalBug348199TestLanguage.g:788:1: rule__Timeperiod__Group_3_0_3_0_3__0 : rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:792:1: ( rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 )
            // InternalBug348199TestLanguage.g:793:2: rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1
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
    // InternalBug348199TestLanguage.g:800:1: rule__Timeperiod__Group_3_0_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:804:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:805:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:805:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:806:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:806:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:807:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:808:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:808:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:811:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:812:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:813:3: ( RULE_NL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:813:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:822:1: rule__Timeperiod__Group_3_0_3_0_3__1 : rule__Timeperiod__Group_3_0_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:826:1: ( rule__Timeperiod__Group_3_0_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:827:2: rule__Timeperiod__Group_3_0_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:833:1: rule__Timeperiod__Group_3_0_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:837:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:838:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:838:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:839:2: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:840:2: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            // InternalBug348199TestLanguage.g:840:3: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1
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
    // InternalBug348199TestLanguage.g:849:1: rule__Timeperiod__Group_3_0_3_1__0 : rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:853:1: ( rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 )
            // InternalBug348199TestLanguage.g:854:2: rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1
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
    // InternalBug348199TestLanguage.g:861:1: rule__Timeperiod__Group_3_0_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:865:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:866:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:866:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:867:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:867:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:868:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:869:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:869:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:872:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:873:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:874:3: ( RULE_NL )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:874:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:883:1: rule__Timeperiod__Group_3_0_3_1__1 : rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 ;
    public final void rule__Timeperiod__Group_3_0_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:887:1: ( rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 )
            // InternalBug348199TestLanguage.g:888:2: rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2
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
    // InternalBug348199TestLanguage.g:895:1: rule__Timeperiod__Group_3_0_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:899:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:900:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:900:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:901:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:910:1: rule__Timeperiod__Group_3_0_3_1__2 : rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 ;
    public final void rule__Timeperiod__Group_3_0_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:914:1: ( rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 )
            // InternalBug348199TestLanguage.g:915:2: rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3
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
    // InternalBug348199TestLanguage.g:922:1: rule__Timeperiod__Group_3_0_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:926:1: ( ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:927:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:927:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            // InternalBug348199TestLanguage.g:928:2: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_0_3_1_2()); 
            // InternalBug348199TestLanguage.g:929:2: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            // InternalBug348199TestLanguage.g:929:3: rule__Timeperiod__AliasAssignment_3_0_3_1_2
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
    // InternalBug348199TestLanguage.g:937:1: rule__Timeperiod__Group_3_0_3_1__3 : rule__Timeperiod__Group_3_0_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:941:1: ( rule__Timeperiod__Group_3_0_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:942:2: rule__Timeperiod__Group_3_0_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:948:1: rule__Timeperiod__Group_3_0_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:952:1: ( ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:953:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:953:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:954:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1_3()); 
            // InternalBug348199TestLanguage.g:955:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:955:3: rule__Timeperiod__Group_3_0_3_1_3__0
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
    // InternalBug348199TestLanguage.g:964:1: rule__Timeperiod__Group_3_0_3_1_3__0 : rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:968:1: ( rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 )
            // InternalBug348199TestLanguage.g:969:2: rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1
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
    // InternalBug348199TestLanguage.g:976:1: rule__Timeperiod__Group_3_0_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:980:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:982:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:982:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:983:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:984:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:984:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:987:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:988:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:989:3: ( RULE_NL )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:989:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:998:1: rule__Timeperiod__Group_3_0_3_1_3__1 : rule__Timeperiod__Group_3_0_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1002:1: ( rule__Timeperiod__Group_3_0_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1003:2: rule__Timeperiod__Group_3_0_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1009:1: rule__Timeperiod__Group_3_0_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1013:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1014:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1014:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1015:2: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1016:2: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1016:3: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1
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
    // InternalBug348199TestLanguage.g:1025:1: rule__Timeperiod__Group_3_1__0 : rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1029:1: ( rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 )
            // InternalBug348199TestLanguage.g:1030:2: rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1
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
    // InternalBug348199TestLanguage.g:1037:1: rule__Timeperiod__Group_3_1__0__Impl : ( '2' ) ;
    public final void rule__Timeperiod__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1041:1: ( ( '2' ) )
            // InternalBug348199TestLanguage.g:1042:1: ( '2' )
            {
            // InternalBug348199TestLanguage.g:1042:1: ( '2' )
            // InternalBug348199TestLanguage.g:1043:2: '2'
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
    // InternalBug348199TestLanguage.g:1052:1: rule__Timeperiod__Group_3_1__1 : rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1056:1: ( rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 )
            // InternalBug348199TestLanguage.g:1057:2: rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2
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
    // InternalBug348199TestLanguage.g:1064:1: rule__Timeperiod__Group_3_1__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1068:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1069:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1069:1: ( '{' )
            // InternalBug348199TestLanguage.g:1070:2: '{'
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
    // InternalBug348199TestLanguage.g:1079:1: rule__Timeperiod__Group_3_1__2 : rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1083:1: ( rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 )
            // InternalBug348199TestLanguage.g:1084:2: rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3
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
    // InternalBug348199TestLanguage.g:1091:1: rule__Timeperiod__Group_3_1__2__Impl : ( ( rule__Timeperiod__Group_3_1_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1095:1: ( ( ( rule__Timeperiod__Group_3_1_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1096:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1096:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            // InternalBug348199TestLanguage.g:1097:2: ( rule__Timeperiod__Group_3_1_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_2()); 
            // InternalBug348199TestLanguage.g:1098:2: ( rule__Timeperiod__Group_3_1_2__0 )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1098:3: rule__Timeperiod__Group_3_1_2__0
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
    // InternalBug348199TestLanguage.g:1106:1: rule__Timeperiod__Group_3_1__3 : rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 ;
    public final void rule__Timeperiod__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1110:1: ( rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 )
            // InternalBug348199TestLanguage.g:1111:2: rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4
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
    // InternalBug348199TestLanguage.g:1118:1: rule__Timeperiod__Group_3_1__3__Impl : ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) ;
    public final void rule__Timeperiod__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1122:1: ( ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) )
            // InternalBug348199TestLanguage.g:1123:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            {
            // InternalBug348199TestLanguage.g:1123:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            // InternalBug348199TestLanguage.g:1124:2: ( rule__Timeperiod__Alternatives_3_1_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_1_3()); 
            // InternalBug348199TestLanguage.g:1125:2: ( rule__Timeperiod__Alternatives_3_1_3 )
            // InternalBug348199TestLanguage.g:1125:3: rule__Timeperiod__Alternatives_3_1_3
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
    // InternalBug348199TestLanguage.g:1133:1: rule__Timeperiod__Group_3_1__4 : rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 ;
    public final void rule__Timeperiod__Group_3_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1137:1: ( rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 )
            // InternalBug348199TestLanguage.g:1138:2: rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5
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
    // InternalBug348199TestLanguage.g:1145:1: rule__Timeperiod__Group_3_1__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1149:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1150:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1150:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1151:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1151:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1152:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1153:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1153:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 

            }

            // InternalBug348199TestLanguage.g:1156:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1157:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1158:3: ( RULE_NL )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NL) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1158:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1167:1: rule__Timeperiod__Group_3_1__5 : rule__Timeperiod__Group_3_1__5__Impl ;
    public final void rule__Timeperiod__Group_3_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1171:1: ( rule__Timeperiod__Group_3_1__5__Impl )
            // InternalBug348199TestLanguage.g:1172:2: rule__Timeperiod__Group_3_1__5__Impl
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
    // InternalBug348199TestLanguage.g:1178:1: rule__Timeperiod__Group_3_1__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1182:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:1183:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:1183:1: ( '}' )
            // InternalBug348199TestLanguage.g:1184:2: '}'
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
    // InternalBug348199TestLanguage.g:1194:1: rule__Timeperiod__Group_3_1_2__0 : rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 ;
    public final void rule__Timeperiod__Group_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1198:1: ( rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 )
            // InternalBug348199TestLanguage.g:1199:2: rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1
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
    // InternalBug348199TestLanguage.g:1206:1: rule__Timeperiod__Group_3_1_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1210:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1211:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1211:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1212:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1212:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1213:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1214:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1214:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 

            }

            // InternalBug348199TestLanguage.g:1217:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1218:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1219:3: ( RULE_NL )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NL) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1219:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1228:1: rule__Timeperiod__Group_3_1_2__1 : rule__Timeperiod__Group_3_1_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1232:1: ( rule__Timeperiod__Group_3_1_2__1__Impl )
            // InternalBug348199TestLanguage.g:1233:2: rule__Timeperiod__Group_3_1_2__1__Impl
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
    // InternalBug348199TestLanguage.g:1239:1: rule__Timeperiod__Group_3_1_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1243:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) )
            // InternalBug348199TestLanguage.g:1244:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:1244:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            // InternalBug348199TestLanguage.g:1245:2: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_2_1()); 
            // InternalBug348199TestLanguage.g:1246:2: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            // InternalBug348199TestLanguage.g:1246:3: rule__Timeperiod__TimeAssignment_3_1_2_1
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
    // InternalBug348199TestLanguage.g:1255:1: rule__Timeperiod__Group_3_1_3_0__0 : rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1259:1: ( rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 )
            // InternalBug348199TestLanguage.g:1260:2: rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1
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
    // InternalBug348199TestLanguage.g:1267:1: rule__Timeperiod__Group_3_1_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1271:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1272:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1272:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1273:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1273:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1274:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1275:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1275:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:1278:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1279:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1280:3: ( RULE_NL )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NL) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1280:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1289:1: rule__Timeperiod__Group_3_1_3_0__1 : rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 ;
    public final void rule__Timeperiod__Group_3_1_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1293:1: ( rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 )
            // InternalBug348199TestLanguage.g:1294:2: rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2
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
    // InternalBug348199TestLanguage.g:1301:1: rule__Timeperiod__Group_3_1_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1305:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:1306:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:1306:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:1307:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:1316:1: rule__Timeperiod__Group_3_1_3_0__2 : rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 ;
    public final void rule__Timeperiod__Group_3_1_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1320:1: ( rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 )
            // InternalBug348199TestLanguage.g:1321:2: rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3
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
    // InternalBug348199TestLanguage.g:1328:1: rule__Timeperiod__Group_3_1_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1332:1: ( ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:1333:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:1333:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            // InternalBug348199TestLanguage.g:1334:2: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_1_3_0_2()); 
            // InternalBug348199TestLanguage.g:1335:2: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            // InternalBug348199TestLanguage.g:1335:3: rule__Timeperiod__NameAssignment_3_1_3_0_2
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
    // InternalBug348199TestLanguage.g:1343:1: rule__Timeperiod__Group_3_1_3_0__3 : rule__Timeperiod__Group_3_1_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1347:1: ( rule__Timeperiod__Group_3_1_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:1348:2: rule__Timeperiod__Group_3_1_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:1354:1: rule__Timeperiod__Group_3_1_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1358:1: ( ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1359:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1359:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:1360:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0_3()); 
            // InternalBug348199TestLanguage.g:1361:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1361:3: rule__Timeperiod__Group_3_1_3_0_3__0
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
    // InternalBug348199TestLanguage.g:1370:1: rule__Timeperiod__Group_3_1_3_0_3__0 : rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1374:1: ( rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 )
            // InternalBug348199TestLanguage.g:1375:2: rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1
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
    // InternalBug348199TestLanguage.g:1382:1: rule__Timeperiod__Group_3_1_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1386:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1387:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1387:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1388:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1388:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1389:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1390:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1390:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1393:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1394:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1395:3: ( RULE_NL )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1395:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1404:1: rule__Timeperiod__Group_3_1_3_0_3__1 : rule__Timeperiod__Group_3_1_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1408:1: ( rule__Timeperiod__Group_3_1_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:1409:2: rule__Timeperiod__Group_3_1_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1415:1: rule__Timeperiod__Group_3_1_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1419:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1420:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1420:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:1421:2: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:1422:2: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            // InternalBug348199TestLanguage.g:1422:3: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1
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
    // InternalBug348199TestLanguage.g:1431:1: rule__Timeperiod__Group_3_1_3_1__0 : rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1435:1: ( rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 )
            // InternalBug348199TestLanguage.g:1436:2: rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1
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
    // InternalBug348199TestLanguage.g:1443:1: rule__Timeperiod__Group_3_1_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1447:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1448:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1448:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1449:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1449:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1450:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1451:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1451:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:1454:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1455:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1456:3: ( RULE_NL )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NL) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1456:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1465:1: rule__Timeperiod__Group_3_1_3_1__1 : rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1469:1: ( rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 )
            // InternalBug348199TestLanguage.g:1470:2: rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2
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
    // InternalBug348199TestLanguage.g:1477:1: rule__Timeperiod__Group_3_1_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1481:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:1482:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:1482:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:1483:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:1492:1: rule__Timeperiod__Group_3_1_3_1__2 : rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1496:1: ( rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 )
            // InternalBug348199TestLanguage.g:1497:2: rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3
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
    // InternalBug348199TestLanguage.g:1504:1: rule__Timeperiod__Group_3_1_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1508:1: ( ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:1509:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:1509:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            // InternalBug348199TestLanguage.g:1510:2: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_1_3_1_2()); 
            // InternalBug348199TestLanguage.g:1511:2: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            // InternalBug348199TestLanguage.g:1511:3: rule__Timeperiod__AliasAssignment_3_1_3_1_2
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
    // InternalBug348199TestLanguage.g:1519:1: rule__Timeperiod__Group_3_1_3_1__3 : rule__Timeperiod__Group_3_1_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1523:1: ( rule__Timeperiod__Group_3_1_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:1524:2: rule__Timeperiod__Group_3_1_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:1530:1: rule__Timeperiod__Group_3_1_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1534:1: ( ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1535:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1535:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:1536:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1_3()); 
            // InternalBug348199TestLanguage.g:1537:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1537:3: rule__Timeperiod__Group_3_1_3_1_3__0
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
    // InternalBug348199TestLanguage.g:1546:1: rule__Timeperiod__Group_3_1_3_1_3__0 : rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1550:1: ( rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 )
            // InternalBug348199TestLanguage.g:1551:2: rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1
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
    // InternalBug348199TestLanguage.g:1558:1: rule__Timeperiod__Group_3_1_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1562:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1563:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1563:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1564:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1564:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1565:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1566:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1566:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1569:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1570:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1571:3: ( RULE_NL )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_NL) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1571:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1580:1: rule__Timeperiod__Group_3_1_3_1_3__1 : rule__Timeperiod__Group_3_1_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1584:1: ( rule__Timeperiod__Group_3_1_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1585:2: rule__Timeperiod__Group_3_1_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1591:1: rule__Timeperiod__Group_3_1_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1595:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1596:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1596:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1597:2: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1598:2: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1598:3: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1
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
    // InternalBug348199TestLanguage.g:1607:1: rule__Timeperiod__Group_3_2__0 : rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 ;
    public final void rule__Timeperiod__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1611:1: ( rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 )
            // InternalBug348199TestLanguage.g:1612:2: rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1
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
    // InternalBug348199TestLanguage.g:1619:1: rule__Timeperiod__Group_3_2__0__Impl : ( '3' ) ;
    public final void rule__Timeperiod__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1623:1: ( ( '3' ) )
            // InternalBug348199TestLanguage.g:1624:1: ( '3' )
            {
            // InternalBug348199TestLanguage.g:1624:1: ( '3' )
            // InternalBug348199TestLanguage.g:1625:2: '3'
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
    // InternalBug348199TestLanguage.g:1634:1: rule__Timeperiod__Group_3_2__1 : rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 ;
    public final void rule__Timeperiod__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1638:1: ( rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 )
            // InternalBug348199TestLanguage.g:1639:2: rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2
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
    // InternalBug348199TestLanguage.g:1646:1: rule__Timeperiod__Group_3_2__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1650:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1651:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1651:1: ( '{' )
            // InternalBug348199TestLanguage.g:1652:2: '{'
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
    // InternalBug348199TestLanguage.g:1661:1: rule__Timeperiod__Group_3_2__2 : rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 ;
    public final void rule__Timeperiod__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1665:1: ( rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 )
            // InternalBug348199TestLanguage.g:1666:2: rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3
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
    // InternalBug348199TestLanguage.g:1673:1: rule__Timeperiod__Group_3_2__2__Impl : ( ( rule__Timeperiod__Group_3_2_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1677:1: ( ( ( rule__Timeperiod__Group_3_2_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1678:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1678:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            // InternalBug348199TestLanguage.g:1679:2: ( rule__Timeperiod__Group_3_2_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_2()); 
            // InternalBug348199TestLanguage.g:1680:2: ( rule__Timeperiod__Group_3_2_2__0 )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1680:3: rule__Timeperiod__Group_3_2_2__0
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
    // InternalBug348199TestLanguage.g:1688:1: rule__Timeperiod__Group_3_2__3 : rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 ;
    public final void rule__Timeperiod__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1692:1: ( rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 )
            // InternalBug348199TestLanguage.g:1693:2: rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4
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
    // InternalBug348199TestLanguage.g:1700:1: rule__Timeperiod__Group_3_2__3__Impl : ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1704:1: ( ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) )
            // InternalBug348199TestLanguage.g:1705:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            {
            // InternalBug348199TestLanguage.g:1705:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            // InternalBug348199TestLanguage.g:1706:2: ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            {
            // InternalBug348199TestLanguage.g:1706:2: ( ( rule__Timeperiod__Alternatives_3_2_3 ) )
            // InternalBug348199TestLanguage.g:1707:3: ( rule__Timeperiod__Alternatives_3_2_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1708:3: ( rule__Timeperiod__Alternatives_3_2_3 )
            // InternalBug348199TestLanguage.g:1708:4: rule__Timeperiod__Alternatives_3_2_3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__Alternatives_3_2_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 

            }

            // InternalBug348199TestLanguage.g:1711:2: ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            // InternalBug348199TestLanguage.g:1712:3: ( rule__Timeperiod__Alternatives_3_2_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1713:3: ( rule__Timeperiod__Alternatives_3_2_3 )*
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1713:4: rule__Timeperiod__Alternatives_3_2_3
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
    // InternalBug348199TestLanguage.g:1722:1: rule__Timeperiod__Group_3_2__4 : rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 ;
    public final void rule__Timeperiod__Group_3_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1726:1: ( rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 )
            // InternalBug348199TestLanguage.g:1727:2: rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5
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
    // InternalBug348199TestLanguage.g:1734:1: rule__Timeperiod__Group_3_2__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1738:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1739:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1739:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1740:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1740:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1741:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1742:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1742:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 

            }

            // InternalBug348199TestLanguage.g:1745:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1746:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1747:3: ( RULE_NL )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_NL) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1747:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1756:1: rule__Timeperiod__Group_3_2__5 : rule__Timeperiod__Group_3_2__5__Impl ;
    public final void rule__Timeperiod__Group_3_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1760:1: ( rule__Timeperiod__Group_3_2__5__Impl )
            // InternalBug348199TestLanguage.g:1761:2: rule__Timeperiod__Group_3_2__5__Impl
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
    // InternalBug348199TestLanguage.g:1767:1: rule__Timeperiod__Group_3_2__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1771:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:1772:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:1772:1: ( '}' )
            // InternalBug348199TestLanguage.g:1773:2: '}'
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
    // InternalBug348199TestLanguage.g:1783:1: rule__Timeperiod__Group_3_2_2__0 : rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 ;
    public final void rule__Timeperiod__Group_3_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1787:1: ( rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 )
            // InternalBug348199TestLanguage.g:1788:2: rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1
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
    // InternalBug348199TestLanguage.g:1795:1: rule__Timeperiod__Group_3_2_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1799:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1800:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1800:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1801:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1801:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1802:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:1803:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1803:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 

            }

            // InternalBug348199TestLanguage.g:1806:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1807:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:1808:3: ( RULE_NL )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_NL) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1808:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1817:1: rule__Timeperiod__Group_3_2_2__1 : rule__Timeperiod__Group_3_2_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1821:1: ( rule__Timeperiod__Group_3_2_2__1__Impl )
            // InternalBug348199TestLanguage.g:1822:2: rule__Timeperiod__Group_3_2_2__1__Impl
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
    // InternalBug348199TestLanguage.g:1828:1: rule__Timeperiod__Group_3_2_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1832:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) )
            // InternalBug348199TestLanguage.g:1833:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:1833:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            // InternalBug348199TestLanguage.g:1834:2: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_2_1()); 
            // InternalBug348199TestLanguage.g:1835:2: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            // InternalBug348199TestLanguage.g:1835:3: rule__Timeperiod__TimeAssignment_3_2_2_1
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
    // InternalBug348199TestLanguage.g:1844:1: rule__Timeperiod__Group_3_2_3_0__0 : rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1848:1: ( rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 )
            // InternalBug348199TestLanguage.g:1849:2: rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1
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
    // InternalBug348199TestLanguage.g:1856:1: rule__Timeperiod__Group_3_2_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1860:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1861:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1861:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1862:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1862:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1863:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:1864:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1864:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:1867:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1868:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:1869:3: ( RULE_NL )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_NL) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1869:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1878:1: rule__Timeperiod__Group_3_2_3_0__1 : rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 ;
    public final void rule__Timeperiod__Group_3_2_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1882:1: ( rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 )
            // InternalBug348199TestLanguage.g:1883:2: rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2
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
    // InternalBug348199TestLanguage.g:1890:1: rule__Timeperiod__Group_3_2_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1894:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:1895:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:1895:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:1896:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:1905:1: rule__Timeperiod__Group_3_2_3_0__2 : rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 ;
    public final void rule__Timeperiod__Group_3_2_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1909:1: ( rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 )
            // InternalBug348199TestLanguage.g:1910:2: rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3
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
    // InternalBug348199TestLanguage.g:1917:1: rule__Timeperiod__Group_3_2_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1921:1: ( ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:1922:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:1922:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            // InternalBug348199TestLanguage.g:1923:2: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_2_3_0_2()); 
            // InternalBug348199TestLanguage.g:1924:2: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            // InternalBug348199TestLanguage.g:1924:3: rule__Timeperiod__NameAssignment_3_2_3_0_2
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
    // InternalBug348199TestLanguage.g:1932:1: rule__Timeperiod__Group_3_2_3_0__3 : rule__Timeperiod__Group_3_2_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1936:1: ( rule__Timeperiod__Group_3_2_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:1937:2: rule__Timeperiod__Group_3_2_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:1943:1: rule__Timeperiod__Group_3_2_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1947:1: ( ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1948:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1948:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:1949:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0_3()); 
            // InternalBug348199TestLanguage.g:1950:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1950:3: rule__Timeperiod__Group_3_2_3_0_3__0
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
    // InternalBug348199TestLanguage.g:1959:1: rule__Timeperiod__Group_3_2_3_0_3__0 : rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1963:1: ( rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 )
            // InternalBug348199TestLanguage.g:1964:2: rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1
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
    // InternalBug348199TestLanguage.g:1971:1: rule__Timeperiod__Group_3_2_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1975:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1976:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1976:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1977:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1977:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1978:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1979:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1979:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1982:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1983:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1984:3: ( RULE_NL )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NL) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1984:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:1993:1: rule__Timeperiod__Group_3_2_3_0_3__1 : rule__Timeperiod__Group_3_2_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:1997:1: ( rule__Timeperiod__Group_3_2_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:1998:2: rule__Timeperiod__Group_3_2_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2004:1: rule__Timeperiod__Group_3_2_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2008:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2009:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2009:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2010:2: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2011:2: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2011:3: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1
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
    // InternalBug348199TestLanguage.g:2020:1: rule__Timeperiod__Group_3_2_3_1__0 : rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2024:1: ( rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 )
            // InternalBug348199TestLanguage.g:2025:2: rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1
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
    // InternalBug348199TestLanguage.g:2032:1: rule__Timeperiod__Group_3_2_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2036:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2037:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2037:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2038:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2038:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2039:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2040:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2040:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2043:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2044:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2045:3: ( RULE_NL )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_NL) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2045:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2054:1: rule__Timeperiod__Group_3_2_3_1__1 : rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 ;
    public final void rule__Timeperiod__Group_3_2_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2058:1: ( rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 )
            // InternalBug348199TestLanguage.g:2059:2: rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2
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
    // InternalBug348199TestLanguage.g:2066:1: rule__Timeperiod__Group_3_2_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2070:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:2071:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:2071:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:2072:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:2081:1: rule__Timeperiod__Group_3_2_3_1__2 : rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 ;
    public final void rule__Timeperiod__Group_3_2_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2085:1: ( rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 )
            // InternalBug348199TestLanguage.g:2086:2: rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3
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
    // InternalBug348199TestLanguage.g:2093:1: rule__Timeperiod__Group_3_2_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2097:1: ( ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:2098:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:2098:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            // InternalBug348199TestLanguage.g:2099:2: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_2_3_1_2()); 
            // InternalBug348199TestLanguage.g:2100:2: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            // InternalBug348199TestLanguage.g:2100:3: rule__Timeperiod__AliasAssignment_3_2_3_1_2
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
    // InternalBug348199TestLanguage.g:2108:1: rule__Timeperiod__Group_3_2_3_1__3 : rule__Timeperiod__Group_3_2_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2112:1: ( rule__Timeperiod__Group_3_2_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:2113:2: rule__Timeperiod__Group_3_2_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:2119:1: rule__Timeperiod__Group_3_2_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2123:1: ( ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2124:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2124:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:2125:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1_3()); 
            // InternalBug348199TestLanguage.g:2126:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2126:3: rule__Timeperiod__Group_3_2_3_1_3__0
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
    // InternalBug348199TestLanguage.g:2135:1: rule__Timeperiod__Group_3_2_3_1_3__0 : rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2139:1: ( rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 )
            // InternalBug348199TestLanguage.g:2140:2: rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1
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
    // InternalBug348199TestLanguage.g:2147:1: rule__Timeperiod__Group_3_2_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2151:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2152:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2152:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2153:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2153:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2154:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2155:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2155:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2158:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2159:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2160:3: ( RULE_NL )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2160:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2169:1: rule__Timeperiod__Group_3_2_3_1_3__1 : rule__Timeperiod__Group_3_2_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2173:1: ( rule__Timeperiod__Group_3_2_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:2174:2: rule__Timeperiod__Group_3_2_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2180:1: rule__Timeperiod__Group_3_2_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2184:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2185:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2185:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:2186:2: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:2187:2: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            // InternalBug348199TestLanguage.g:2187:3: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1
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
    // InternalBug348199TestLanguage.g:2196:1: rule__Timeperiod__Group_3_3__0 : rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 ;
    public final void rule__Timeperiod__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2200:1: ( rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 )
            // InternalBug348199TestLanguage.g:2201:2: rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1
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
    // InternalBug348199TestLanguage.g:2208:1: rule__Timeperiod__Group_3_3__0__Impl : ( '4' ) ;
    public final void rule__Timeperiod__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2212:1: ( ( '4' ) )
            // InternalBug348199TestLanguage.g:2213:1: ( '4' )
            {
            // InternalBug348199TestLanguage.g:2213:1: ( '4' )
            // InternalBug348199TestLanguage.g:2214:2: '4'
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
    // InternalBug348199TestLanguage.g:2223:1: rule__Timeperiod__Group_3_3__1 : rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 ;
    public final void rule__Timeperiod__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2227:1: ( rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 )
            // InternalBug348199TestLanguage.g:2228:2: rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2
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
    // InternalBug348199TestLanguage.g:2235:1: rule__Timeperiod__Group_3_3__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2239:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:2240:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:2240:1: ( '{' )
            // InternalBug348199TestLanguage.g:2241:2: '{'
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
    // InternalBug348199TestLanguage.g:2250:1: rule__Timeperiod__Group_3_3__2 : rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 ;
    public final void rule__Timeperiod__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2254:1: ( rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 )
            // InternalBug348199TestLanguage.g:2255:2: rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3
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
    // InternalBug348199TestLanguage.g:2262:1: rule__Timeperiod__Group_3_3__2__Impl : ( ( rule__Timeperiod__Group_3_3_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2266:1: ( ( ( rule__Timeperiod__Group_3_3_2__0 )* ) )
            // InternalBug348199TestLanguage.g:2267:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:2267:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            // InternalBug348199TestLanguage.g:2268:2: ( rule__Timeperiod__Group_3_3_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_2()); 
            // InternalBug348199TestLanguage.g:2269:2: ( rule__Timeperiod__Group_3_3_2__0 )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2269:3: rule__Timeperiod__Group_3_3_2__0
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
    // InternalBug348199TestLanguage.g:2277:1: rule__Timeperiod__Group_3_3__3 : rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 ;
    public final void rule__Timeperiod__Group_3_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2281:1: ( rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 )
            // InternalBug348199TestLanguage.g:2282:2: rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4
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
    // InternalBug348199TestLanguage.g:2289:1: rule__Timeperiod__Group_3_3__3__Impl : ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) ;
    public final void rule__Timeperiod__Group_3_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2293:1: ( ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) )
            // InternalBug348199TestLanguage.g:2294:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            {
            // InternalBug348199TestLanguage.g:2294:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            // InternalBug348199TestLanguage.g:2295:2: ( rule__Timeperiod__Alternatives_3_3_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_3_3()); 
            // InternalBug348199TestLanguage.g:2296:2: ( rule__Timeperiod__Alternatives_3_3_3 )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2296:3: rule__Timeperiod__Alternatives_3_3_3
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
    // InternalBug348199TestLanguage.g:2304:1: rule__Timeperiod__Group_3_3__4 : rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 ;
    public final void rule__Timeperiod__Group_3_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2308:1: ( rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 )
            // InternalBug348199TestLanguage.g:2309:2: rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5
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
    // InternalBug348199TestLanguage.g:2316:1: rule__Timeperiod__Group_3_3__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2320:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2321:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2321:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2322:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2322:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2323:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2324:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2324:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 

            }

            // InternalBug348199TestLanguage.g:2327:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2328:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2329:3: ( RULE_NL )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2329:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2338:1: rule__Timeperiod__Group_3_3__5 : rule__Timeperiod__Group_3_3__5__Impl ;
    public final void rule__Timeperiod__Group_3_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2342:1: ( rule__Timeperiod__Group_3_3__5__Impl )
            // InternalBug348199TestLanguage.g:2343:2: rule__Timeperiod__Group_3_3__5__Impl
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
    // InternalBug348199TestLanguage.g:2349:1: rule__Timeperiod__Group_3_3__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2353:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2354:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2354:1: ( '}' )
            // InternalBug348199TestLanguage.g:2355:2: '}'
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
    // InternalBug348199TestLanguage.g:2365:1: rule__Timeperiod__Group_3_3_2__0 : rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 ;
    public final void rule__Timeperiod__Group_3_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2369:1: ( rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 )
            // InternalBug348199TestLanguage.g:2370:2: rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1
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
    // InternalBug348199TestLanguage.g:2377:1: rule__Timeperiod__Group_3_3_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2381:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2382:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2382:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2383:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2383:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2384:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2385:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2385:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 

            }

            // InternalBug348199TestLanguage.g:2388:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2389:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2390:3: ( RULE_NL )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_NL) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2390:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2399:1: rule__Timeperiod__Group_3_3_2__1 : rule__Timeperiod__Group_3_3_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2403:1: ( rule__Timeperiod__Group_3_3_2__1__Impl )
            // InternalBug348199TestLanguage.g:2404:2: rule__Timeperiod__Group_3_3_2__1__Impl
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
    // InternalBug348199TestLanguage.g:2410:1: rule__Timeperiod__Group_3_3_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2414:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) )
            // InternalBug348199TestLanguage.g:2415:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:2415:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            // InternalBug348199TestLanguage.g:2416:2: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_2_1()); 
            // InternalBug348199TestLanguage.g:2417:2: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            // InternalBug348199TestLanguage.g:2417:3: rule__Timeperiod__TimeAssignment_3_3_2_1
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
    // InternalBug348199TestLanguage.g:2426:1: rule__Timeperiod__Group_3_3_3_0__0 : rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2430:1: ( rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 )
            // InternalBug348199TestLanguage.g:2431:2: rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1
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
    // InternalBug348199TestLanguage.g:2438:1: rule__Timeperiod__Group_3_3_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2442:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2443:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2443:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2444:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2444:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2445:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2446:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2446:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:2449:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2450:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2451:3: ( RULE_NL )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_NL) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2451:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2460:1: rule__Timeperiod__Group_3_3_3_0__1 : rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 ;
    public final void rule__Timeperiod__Group_3_3_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2464:1: ( rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 )
            // InternalBug348199TestLanguage.g:2465:2: rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2
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
    // InternalBug348199TestLanguage.g:2472:1: rule__Timeperiod__Group_3_3_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2476:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:2477:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:2477:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:2478:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:2487:1: rule__Timeperiod__Group_3_3_3_0__2 : rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 ;
    public final void rule__Timeperiod__Group_3_3_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2491:1: ( rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 )
            // InternalBug348199TestLanguage.g:2492:2: rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3
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
    // InternalBug348199TestLanguage.g:2499:1: rule__Timeperiod__Group_3_3_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2503:1: ( ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:2504:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:2504:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            // InternalBug348199TestLanguage.g:2505:2: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_3_3_0_2()); 
            // InternalBug348199TestLanguage.g:2506:2: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            // InternalBug348199TestLanguage.g:2506:3: rule__Timeperiod__NameAssignment_3_3_3_0_2
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
    // InternalBug348199TestLanguage.g:2514:1: rule__Timeperiod__Group_3_3_3_0__3 : rule__Timeperiod__Group_3_3_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2518:1: ( rule__Timeperiod__Group_3_3_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:2519:2: rule__Timeperiod__Group_3_3_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:2525:1: rule__Timeperiod__Group_3_3_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2529:1: ( ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2530:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2530:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:2531:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0_3()); 
            // InternalBug348199TestLanguage.g:2532:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2532:3: rule__Timeperiod__Group_3_3_3_0_3__0
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
    // InternalBug348199TestLanguage.g:2541:1: rule__Timeperiod__Group_3_3_3_0_3__0 : rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2545:1: ( rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 )
            // InternalBug348199TestLanguage.g:2546:2: rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1
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
    // InternalBug348199TestLanguage.g:2553:1: rule__Timeperiod__Group_3_3_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2557:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2558:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2558:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2559:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2559:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2560:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2561:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2561:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2564:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2565:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2566:3: ( RULE_NL )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_NL) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2566:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2575:1: rule__Timeperiod__Group_3_3_3_0_3__1 : rule__Timeperiod__Group_3_3_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2579:1: ( rule__Timeperiod__Group_3_3_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:2580:2: rule__Timeperiod__Group_3_3_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2586:1: rule__Timeperiod__Group_3_3_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2590:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2591:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2591:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2592:2: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2593:2: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2593:3: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1
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
    // InternalBug348199TestLanguage.g:2602:1: rule__Timeperiod__Group_3_3_3_1__0 : rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2606:1: ( rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 )
            // InternalBug348199TestLanguage.g:2607:2: rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1
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
    // InternalBug348199TestLanguage.g:2614:1: rule__Timeperiod__Group_3_3_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2618:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2619:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2619:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2620:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2620:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2621:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2622:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2622:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2625:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2626:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2627:3: ( RULE_NL )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NL) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2627:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2636:1: rule__Timeperiod__Group_3_3_3_1__1 : rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 ;
    public final void rule__Timeperiod__Group_3_3_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2640:1: ( rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 )
            // InternalBug348199TestLanguage.g:2641:2: rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2
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
    // InternalBug348199TestLanguage.g:2648:1: rule__Timeperiod__Group_3_3_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2652:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:2653:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:2653:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:2654:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:2663:1: rule__Timeperiod__Group_3_3_3_1__2 : rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 ;
    public final void rule__Timeperiod__Group_3_3_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2667:1: ( rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 )
            // InternalBug348199TestLanguage.g:2668:2: rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3
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
    // InternalBug348199TestLanguage.g:2675:1: rule__Timeperiod__Group_3_3_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2679:1: ( ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:2680:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:2680:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            // InternalBug348199TestLanguage.g:2681:2: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_3_3_1_2()); 
            // InternalBug348199TestLanguage.g:2682:2: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            // InternalBug348199TestLanguage.g:2682:3: rule__Timeperiod__AliasAssignment_3_3_3_1_2
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
    // InternalBug348199TestLanguage.g:2690:1: rule__Timeperiod__Group_3_3_3_1__3 : rule__Timeperiod__Group_3_3_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2694:1: ( rule__Timeperiod__Group_3_3_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:2695:2: rule__Timeperiod__Group_3_3_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:2701:1: rule__Timeperiod__Group_3_3_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2705:1: ( ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2706:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2706:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:2707:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1_3()); 
            // InternalBug348199TestLanguage.g:2708:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2708:3: rule__Timeperiod__Group_3_3_3_1_3__0
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
    // InternalBug348199TestLanguage.g:2717:1: rule__Timeperiod__Group_3_3_3_1_3__0 : rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2721:1: ( rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 )
            // InternalBug348199TestLanguage.g:2722:2: rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1
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
    // InternalBug348199TestLanguage.g:2729:1: rule__Timeperiod__Group_3_3_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2733:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2734:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2734:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2735:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2735:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2736:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2737:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2737:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2740:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2741:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2742:3: ( RULE_NL )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_NL) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2742:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2751:1: rule__Timeperiod__Group_3_3_3_1_3__1 : rule__Timeperiod__Group_3_3_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2755:1: ( rule__Timeperiod__Group_3_3_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:2756:2: rule__Timeperiod__Group_3_3_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2762:1: rule__Timeperiod__Group_3_3_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2766:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2767:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2767:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:2768:2: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:2769:2: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            // InternalBug348199TestLanguage.g:2769:3: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1
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
    // InternalBug348199TestLanguage.g:2778:1: rule__Timeperiod__Group_3_4__0 : rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 ;
    public final void rule__Timeperiod__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2782:1: ( rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 )
            // InternalBug348199TestLanguage.g:2783:2: rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1
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
    // InternalBug348199TestLanguage.g:2790:1: rule__Timeperiod__Group_3_4__0__Impl : ( '5' ) ;
    public final void rule__Timeperiod__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2794:1: ( ( '5' ) )
            // InternalBug348199TestLanguage.g:2795:1: ( '5' )
            {
            // InternalBug348199TestLanguage.g:2795:1: ( '5' )
            // InternalBug348199TestLanguage.g:2796:2: '5'
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
    // InternalBug348199TestLanguage.g:2805:1: rule__Timeperiod__Group_3_4__1 : rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 ;
    public final void rule__Timeperiod__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2809:1: ( rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 )
            // InternalBug348199TestLanguage.g:2810:2: rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2
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
    // InternalBug348199TestLanguage.g:2817:1: rule__Timeperiod__Group_3_4__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2821:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:2822:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:2822:1: ( '{' )
            // InternalBug348199TestLanguage.g:2823:2: '{'
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
    // InternalBug348199TestLanguage.g:2832:1: rule__Timeperiod__Group_3_4__2 : rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 ;
    public final void rule__Timeperiod__Group_3_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2836:1: ( rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 )
            // InternalBug348199TestLanguage.g:2837:2: rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3
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
    // InternalBug348199TestLanguage.g:2844:1: rule__Timeperiod__Group_3_4__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2848:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2849:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2849:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2850:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2850:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2851:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:2852:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2852:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 

            }

            // InternalBug348199TestLanguage.g:2855:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2856:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:2857:3: ( RULE_NL )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_NL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2857:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:2866:1: rule__Timeperiod__Group_3_4__3 : rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 ;
    public final void rule__Timeperiod__Group_3_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2870:1: ( rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 )
            // InternalBug348199TestLanguage.g:2871:2: rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4
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
    // InternalBug348199TestLanguage.g:2878:1: rule__Timeperiod__Group_3_4__3__Impl : ( ( rule__Timeperiod__Group_3_4_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2882:1: ( ( ( rule__Timeperiod__Group_3_4_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2883:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2883:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            // InternalBug348199TestLanguage.g:2884:2: ( rule__Timeperiod__Group_3_4_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_3()); 
            // InternalBug348199TestLanguage.g:2885:2: ( rule__Timeperiod__Group_3_4_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==26) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2885:3: rule__Timeperiod__Group_3_4_3__0
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
    // InternalBug348199TestLanguage.g:2893:1: rule__Timeperiod__Group_3_4__4 : rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 ;
    public final void rule__Timeperiod__Group_3_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2897:1: ( rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 )
            // InternalBug348199TestLanguage.g:2898:2: rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5
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
    // InternalBug348199TestLanguage.g:2905:1: rule__Timeperiod__Group_3_4__4__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) ;
    public final void rule__Timeperiod__Group_3_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2909:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) )
            // InternalBug348199TestLanguage.g:2910:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            {
            // InternalBug348199TestLanguage.g:2910:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            // InternalBug348199TestLanguage.g:2911:2: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()); 
            // InternalBug348199TestLanguage.g:2912:2: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            // InternalBug348199TestLanguage.g:2912:3: rule__Timeperiod__UnorderedGroup_3_4_4
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
    // InternalBug348199TestLanguage.g:2920:1: rule__Timeperiod__Group_3_4__5 : rule__Timeperiod__Group_3_4__5__Impl ;
    public final void rule__Timeperiod__Group_3_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2924:1: ( rule__Timeperiod__Group_3_4__5__Impl )
            // InternalBug348199TestLanguage.g:2925:2: rule__Timeperiod__Group_3_4__5__Impl
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
    // InternalBug348199TestLanguage.g:2931:1: rule__Timeperiod__Group_3_4__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2935:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2936:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2936:1: ( '}' )
            // InternalBug348199TestLanguage.g:2937:2: '}'
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
    // InternalBug348199TestLanguage.g:2947:1: rule__Timeperiod__Group_3_4_3__0 : rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 ;
    public final void rule__Timeperiod__Group_3_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2951:1: ( rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 )
            // InternalBug348199TestLanguage.g:2952:2: rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1
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
    // InternalBug348199TestLanguage.g:2959:1: rule__Timeperiod__Group_3_4_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2963:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) )
            // InternalBug348199TestLanguage.g:2964:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:2964:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            // InternalBug348199TestLanguage.g:2965:2: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_3_0()); 
            // InternalBug348199TestLanguage.g:2966:2: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            // InternalBug348199TestLanguage.g:2966:3: rule__Timeperiod__TimeAssignment_3_4_3_0
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
    // InternalBug348199TestLanguage.g:2974:1: rule__Timeperiod__Group_3_4_3__1 : rule__Timeperiod__Group_3_4_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2978:1: ( rule__Timeperiod__Group_3_4_3__1__Impl )
            // InternalBug348199TestLanguage.g:2979:2: rule__Timeperiod__Group_3_4_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2985:1: rule__Timeperiod__Group_3_4_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:2989:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2990:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2990:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2991:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2991:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2992:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:2993:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2993:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 

            }

            // InternalBug348199TestLanguage.g:2996:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2997:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:2998:3: ( RULE_NL )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_NL) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2998:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3008:1: rule__Timeperiod__Group_3_4_4_0__0 : rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3012:1: ( rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 )
            // InternalBug348199TestLanguage.g:3013:2: rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1
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
    // InternalBug348199TestLanguage.g:3020:1: rule__Timeperiod__Group_3_4_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3024:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:3025:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:3025:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:3026:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:3035:1: rule__Timeperiod__Group_3_4_4_0__1 : rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 ;
    public final void rule__Timeperiod__Group_3_4_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3039:1: ( rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 )
            // InternalBug348199TestLanguage.g:3040:2: rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2
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
    // InternalBug348199TestLanguage.g:3047:1: rule__Timeperiod__Group_3_4_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3051:1: ( ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:3052:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:3052:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            // InternalBug348199TestLanguage.g:3053:2: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_4_4_0_1()); 
            // InternalBug348199TestLanguage.g:3054:2: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            // InternalBug348199TestLanguage.g:3054:3: rule__Timeperiod__NameAssignment_3_4_4_0_1
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
    // InternalBug348199TestLanguage.g:3062:1: rule__Timeperiod__Group_3_4_4_0__2 : rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 ;
    public final void rule__Timeperiod__Group_3_4_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3066:1: ( rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 )
            // InternalBug348199TestLanguage.g:3067:2: rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3
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
    // InternalBug348199TestLanguage.g:3074:1: rule__Timeperiod__Group_3_4_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3078:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3079:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3079:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3080:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3080:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3081:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3082:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3082:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:3085:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3086:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3087:3: ( RULE_NL )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_NL) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3087:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3096:1: rule__Timeperiod__Group_3_4_4_0__3 : rule__Timeperiod__Group_3_4_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3100:1: ( rule__Timeperiod__Group_3_4_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:3101:2: rule__Timeperiod__Group_3_4_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:3107:1: rule__Timeperiod__Group_3_4_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3111:1: ( ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3112:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3112:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:3113:2: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0_3()); 
            // InternalBug348199TestLanguage.g:3114:2: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==27) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3114:3: rule__Timeperiod__Group_3_4_4_0_3__0
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
    // InternalBug348199TestLanguage.g:3123:1: rule__Timeperiod__Group_3_4_4_0_3__0 : rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3127:1: ( rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 )
            // InternalBug348199TestLanguage.g:3128:2: rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1
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
    // InternalBug348199TestLanguage.g:3135:1: rule__Timeperiod__Group_3_4_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3139:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3140:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3140:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:3141:2: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:3142:2: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            // InternalBug348199TestLanguage.g:3142:3: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0
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
    // InternalBug348199TestLanguage.g:3150:1: rule__Timeperiod__Group_3_4_4_0_3__1 : rule__Timeperiod__Group_3_4_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3154:1: ( rule__Timeperiod__Group_3_4_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:3155:2: rule__Timeperiod__Group_3_4_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3161:1: rule__Timeperiod__Group_3_4_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3165:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3166:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3166:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3167:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3167:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3168:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3169:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3169:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3172:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3173:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3174:3: ( RULE_NL )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_NL) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3174:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3184:1: rule__Timeperiod__Group_3_4_4_1__0 : rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3188:1: ( rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 )
            // InternalBug348199TestLanguage.g:3189:2: rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1
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
    // InternalBug348199TestLanguage.g:3196:1: rule__Timeperiod__Group_3_4_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3200:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3201:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3201:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3202:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:3211:1: rule__Timeperiod__Group_3_4_4_1__1 : rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 ;
    public final void rule__Timeperiod__Group_3_4_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3215:1: ( rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 )
            // InternalBug348199TestLanguage.g:3216:2: rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2
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
    // InternalBug348199TestLanguage.g:3223:1: rule__Timeperiod__Group_3_4_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3227:1: ( ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:3228:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:3228:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            // InternalBug348199TestLanguage.g:3229:2: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_4_4_1_1()); 
            // InternalBug348199TestLanguage.g:3230:2: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            // InternalBug348199TestLanguage.g:3230:3: rule__Timeperiod__AliasAssignment_3_4_4_1_1
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
    // InternalBug348199TestLanguage.g:3238:1: rule__Timeperiod__Group_3_4_4_1__2 : rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 ;
    public final void rule__Timeperiod__Group_3_4_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3242:1: ( rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 )
            // InternalBug348199TestLanguage.g:3243:2: rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3
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
    // InternalBug348199TestLanguage.g:3250:1: rule__Timeperiod__Group_3_4_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3254:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3255:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3255:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3256:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3256:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3257:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3258:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3258:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:3261:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3262:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3263:3: ( RULE_NL )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_NL) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3263:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3272:1: rule__Timeperiod__Group_3_4_4_1__3 : rule__Timeperiod__Group_3_4_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3276:1: ( rule__Timeperiod__Group_3_4_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:3277:2: rule__Timeperiod__Group_3_4_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:3283:1: rule__Timeperiod__Group_3_4_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3287:1: ( ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3288:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3288:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3289:2: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1_3()); 
            // InternalBug348199TestLanguage.g:3290:2: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==28) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3290:3: rule__Timeperiod__Group_3_4_4_1_3__0
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
    // InternalBug348199TestLanguage.g:3299:1: rule__Timeperiod__Group_3_4_4_1_3__0 : rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3303:1: ( rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 )
            // InternalBug348199TestLanguage.g:3304:2: rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1
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
    // InternalBug348199TestLanguage.g:3311:1: rule__Timeperiod__Group_3_4_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3315:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3316:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3316:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:3317:2: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:3318:2: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            // InternalBug348199TestLanguage.g:3318:3: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0
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
    // InternalBug348199TestLanguage.g:3326:1: rule__Timeperiod__Group_3_4_4_1_3__1 : rule__Timeperiod__Group_3_4_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3330:1: ( rule__Timeperiod__Group_3_4_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3331:2: rule__Timeperiod__Group_3_4_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3337:1: rule__Timeperiod__Group_3_4_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3341:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3342:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3342:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3343:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3343:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3344:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3345:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3345:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3348:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3349:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3350:3: ( RULE_NL )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_NL) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3350:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3360:1: rule__Timeperiod__Group_3_5__0 : rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 ;
    public final void rule__Timeperiod__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3364:1: ( rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 )
            // InternalBug348199TestLanguage.g:3365:2: rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1
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
    // InternalBug348199TestLanguage.g:3372:1: rule__Timeperiod__Group_3_5__0__Impl : ( '6' ) ;
    public final void rule__Timeperiod__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3376:1: ( ( '6' ) )
            // InternalBug348199TestLanguage.g:3377:1: ( '6' )
            {
            // InternalBug348199TestLanguage.g:3377:1: ( '6' )
            // InternalBug348199TestLanguage.g:3378:2: '6'
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
    // InternalBug348199TestLanguage.g:3387:1: rule__Timeperiod__Group_3_5__1 : rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 ;
    public final void rule__Timeperiod__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3391:1: ( rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 )
            // InternalBug348199TestLanguage.g:3392:2: rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2
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
    // InternalBug348199TestLanguage.g:3399:1: rule__Timeperiod__Group_3_5__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3403:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3404:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3404:1: ( '{' )
            // InternalBug348199TestLanguage.g:3405:2: '{'
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
    // InternalBug348199TestLanguage.g:3414:1: rule__Timeperiod__Group_3_5__2 : rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 ;
    public final void rule__Timeperiod__Group_3_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3418:1: ( rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 )
            // InternalBug348199TestLanguage.g:3419:2: rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3
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
    // InternalBug348199TestLanguage.g:3426:1: rule__Timeperiod__Group_3_5__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3430:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3431:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3431:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3432:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3432:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3433:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3434:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3434:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 

            }

            // InternalBug348199TestLanguage.g:3437:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3438:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3439:3: ( RULE_NL )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_NL) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3439:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3448:1: rule__Timeperiod__Group_3_5__3 : rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 ;
    public final void rule__Timeperiod__Group_3_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3452:1: ( rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 )
            // InternalBug348199TestLanguage.g:3453:2: rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4
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
    // InternalBug348199TestLanguage.g:3460:1: rule__Timeperiod__Group_3_5__3__Impl : ( ( rule__Timeperiod__Group_3_5_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3464:1: ( ( ( rule__Timeperiod__Group_3_5_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3465:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3465:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            // InternalBug348199TestLanguage.g:3466:2: ( rule__Timeperiod__Group_3_5_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_3()); 
            // InternalBug348199TestLanguage.g:3467:2: ( rule__Timeperiod__Group_3_5_3__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==26) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3467:3: rule__Timeperiod__Group_3_5_3__0
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
    // InternalBug348199TestLanguage.g:3475:1: rule__Timeperiod__Group_3_5__4 : rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 ;
    public final void rule__Timeperiod__Group_3_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3479:1: ( rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 )
            // InternalBug348199TestLanguage.g:3480:2: rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5
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
    // InternalBug348199TestLanguage.g:3487:1: rule__Timeperiod__Group_3_5__4__Impl : ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) ;
    public final void rule__Timeperiod__Group_3_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3491:1: ( ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) )
            // InternalBug348199TestLanguage.g:3492:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            {
            // InternalBug348199TestLanguage.g:3492:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            // InternalBug348199TestLanguage.g:3493:2: ( rule__Timeperiod__Alternatives_3_5_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_5_4()); 
            // InternalBug348199TestLanguage.g:3494:2: ( rule__Timeperiod__Alternatives_3_5_4 )
            // InternalBug348199TestLanguage.g:3494:3: rule__Timeperiod__Alternatives_3_5_4
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
    // InternalBug348199TestLanguage.g:3502:1: rule__Timeperiod__Group_3_5__5 : rule__Timeperiod__Group_3_5__5__Impl ;
    public final void rule__Timeperiod__Group_3_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3506:1: ( rule__Timeperiod__Group_3_5__5__Impl )
            // InternalBug348199TestLanguage.g:3507:2: rule__Timeperiod__Group_3_5__5__Impl
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
    // InternalBug348199TestLanguage.g:3513:1: rule__Timeperiod__Group_3_5__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3517:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:3518:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:3518:1: ( '}' )
            // InternalBug348199TestLanguage.g:3519:2: '}'
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
    // InternalBug348199TestLanguage.g:3529:1: rule__Timeperiod__Group_3_5_3__0 : rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 ;
    public final void rule__Timeperiod__Group_3_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3533:1: ( rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 )
            // InternalBug348199TestLanguage.g:3534:2: rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1
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
    // InternalBug348199TestLanguage.g:3541:1: rule__Timeperiod__Group_3_5_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3545:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3546:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3546:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            // InternalBug348199TestLanguage.g:3547:2: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_3_0()); 
            // InternalBug348199TestLanguage.g:3548:2: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            // InternalBug348199TestLanguage.g:3548:3: rule__Timeperiod__TimeAssignment_3_5_3_0
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
    // InternalBug348199TestLanguage.g:3556:1: rule__Timeperiod__Group_3_5_3__1 : rule__Timeperiod__Group_3_5_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3560:1: ( rule__Timeperiod__Group_3_5_3__1__Impl )
            // InternalBug348199TestLanguage.g:3561:2: rule__Timeperiod__Group_3_5_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3567:1: rule__Timeperiod__Group_3_5_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3571:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3572:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3572:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3573:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3573:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3574:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:3575:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3575:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3578:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3579:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:3580:3: ( RULE_NL )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_NL) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3580:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3590:1: rule__Timeperiod__Group_3_5_4_0__0 : rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3594:1: ( rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 )
            // InternalBug348199TestLanguage.g:3595:2: rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1
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
    // InternalBug348199TestLanguage.g:3602:1: rule__Timeperiod__Group_3_5_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3606:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:3607:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:3607:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:3608:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:3617:1: rule__Timeperiod__Group_3_5_4_0__1 : rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 ;
    public final void rule__Timeperiod__Group_3_5_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3621:1: ( rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 )
            // InternalBug348199TestLanguage.g:3622:2: rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2
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
    // InternalBug348199TestLanguage.g:3629:1: rule__Timeperiod__Group_3_5_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3633:1: ( ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:3634:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:3634:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            // InternalBug348199TestLanguage.g:3635:2: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_5_4_0_1()); 
            // InternalBug348199TestLanguage.g:3636:2: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            // InternalBug348199TestLanguage.g:3636:3: rule__Timeperiod__NameAssignment_3_5_4_0_1
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
    // InternalBug348199TestLanguage.g:3644:1: rule__Timeperiod__Group_3_5_4_0__2 : rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 ;
    public final void rule__Timeperiod__Group_3_5_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3648:1: ( rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 )
            // InternalBug348199TestLanguage.g:3649:2: rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3
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
    // InternalBug348199TestLanguage.g:3656:1: rule__Timeperiod__Group_3_5_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3660:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3661:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3661:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3662:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3662:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3663:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:3664:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3664:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:3667:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3668:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:3669:3: ( RULE_NL )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_NL) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3669:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3678:1: rule__Timeperiod__Group_3_5_4_0__3 : rule__Timeperiod__Group_3_5_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3682:1: ( rule__Timeperiod__Group_3_5_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:3683:2: rule__Timeperiod__Group_3_5_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:3689:1: rule__Timeperiod__Group_3_5_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3693:1: ( ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3694:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3694:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:3695:2: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0_3()); 
            // InternalBug348199TestLanguage.g:3696:2: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==27) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3696:3: rule__Timeperiod__Group_3_5_4_0_3__0
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
    // InternalBug348199TestLanguage.g:3705:1: rule__Timeperiod__Group_3_5_4_0_3__0 : rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3709:1: ( rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 )
            // InternalBug348199TestLanguage.g:3710:2: rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1
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
    // InternalBug348199TestLanguage.g:3717:1: rule__Timeperiod__Group_3_5_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3721:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3722:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3722:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:3723:2: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:3724:2: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            // InternalBug348199TestLanguage.g:3724:3: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0
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
    // InternalBug348199TestLanguage.g:3732:1: rule__Timeperiod__Group_3_5_4_0_3__1 : rule__Timeperiod__Group_3_5_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3736:1: ( rule__Timeperiod__Group_3_5_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:3737:2: rule__Timeperiod__Group_3_5_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3743:1: rule__Timeperiod__Group_3_5_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3747:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3748:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3748:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3749:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3749:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3750:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3751:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3751:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3754:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3755:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3756:3: ( RULE_NL )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_NL) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3756:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3766:1: rule__Timeperiod__Group_3_5_4_1__0 : rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3770:1: ( rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 )
            // InternalBug348199TestLanguage.g:3771:2: rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1
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
    // InternalBug348199TestLanguage.g:3778:1: rule__Timeperiod__Group_3_5_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3782:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3783:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3783:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3784:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:3793:1: rule__Timeperiod__Group_3_5_4_1__1 : rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 ;
    public final void rule__Timeperiod__Group_3_5_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3797:1: ( rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 )
            // InternalBug348199TestLanguage.g:3798:2: rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2
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
    // InternalBug348199TestLanguage.g:3805:1: rule__Timeperiod__Group_3_5_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3809:1: ( ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:3810:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:3810:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            // InternalBug348199TestLanguage.g:3811:2: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_5_4_1_1()); 
            // InternalBug348199TestLanguage.g:3812:2: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            // InternalBug348199TestLanguage.g:3812:3: rule__Timeperiod__AliasAssignment_3_5_4_1_1
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
    // InternalBug348199TestLanguage.g:3820:1: rule__Timeperiod__Group_3_5_4_1__2 : rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 ;
    public final void rule__Timeperiod__Group_3_5_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3824:1: ( rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 )
            // InternalBug348199TestLanguage.g:3825:2: rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3
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
    // InternalBug348199TestLanguage.g:3832:1: rule__Timeperiod__Group_3_5_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3836:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3837:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3837:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3838:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3838:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3839:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:3840:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3840:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:3843:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3844:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:3845:3: ( RULE_NL )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_NL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3845:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3854:1: rule__Timeperiod__Group_3_5_4_1__3 : rule__Timeperiod__Group_3_5_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3858:1: ( rule__Timeperiod__Group_3_5_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:3859:2: rule__Timeperiod__Group_3_5_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:3865:1: rule__Timeperiod__Group_3_5_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3869:1: ( ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3870:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3870:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3871:2: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1_3()); 
            // InternalBug348199TestLanguage.g:3872:2: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==28) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3872:3: rule__Timeperiod__Group_3_5_4_1_3__0
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
    // InternalBug348199TestLanguage.g:3881:1: rule__Timeperiod__Group_3_5_4_1_3__0 : rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3885:1: ( rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 )
            // InternalBug348199TestLanguage.g:3886:2: rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1
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
    // InternalBug348199TestLanguage.g:3893:1: rule__Timeperiod__Group_3_5_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3897:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3898:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3898:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:3899:2: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:3900:2: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            // InternalBug348199TestLanguage.g:3900:3: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0
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
    // InternalBug348199TestLanguage.g:3908:1: rule__Timeperiod__Group_3_5_4_1_3__1 : rule__Timeperiod__Group_3_5_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3912:1: ( rule__Timeperiod__Group_3_5_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3913:2: rule__Timeperiod__Group_3_5_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3919:1: rule__Timeperiod__Group_3_5_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3923:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3924:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3924:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3925:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3925:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3926:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3927:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3927:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3930:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3931:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3932:3: ( RULE_NL )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_NL) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3932:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:3942:1: rule__Timeperiod__Group_3_6__0 : rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 ;
    public final void rule__Timeperiod__Group_3_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3946:1: ( rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 )
            // InternalBug348199TestLanguage.g:3947:2: rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1
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
    // InternalBug348199TestLanguage.g:3954:1: rule__Timeperiod__Group_3_6__0__Impl : ( '7' ) ;
    public final void rule__Timeperiod__Group_3_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3958:1: ( ( '7' ) )
            // InternalBug348199TestLanguage.g:3959:1: ( '7' )
            {
            // InternalBug348199TestLanguage.g:3959:1: ( '7' )
            // InternalBug348199TestLanguage.g:3960:2: '7'
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
    // InternalBug348199TestLanguage.g:3969:1: rule__Timeperiod__Group_3_6__1 : rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 ;
    public final void rule__Timeperiod__Group_3_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3973:1: ( rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 )
            // InternalBug348199TestLanguage.g:3974:2: rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2
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
    // InternalBug348199TestLanguage.g:3981:1: rule__Timeperiod__Group_3_6__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:3985:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3986:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3986:1: ( '{' )
            // InternalBug348199TestLanguage.g:3987:2: '{'
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
    // InternalBug348199TestLanguage.g:3996:1: rule__Timeperiod__Group_3_6__2 : rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 ;
    public final void rule__Timeperiod__Group_3_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4000:1: ( rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 )
            // InternalBug348199TestLanguage.g:4001:2: rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3
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
    // InternalBug348199TestLanguage.g:4008:1: rule__Timeperiod__Group_3_6__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4012:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4013:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4013:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4014:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4014:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4015:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4016:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4016:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 

            }

            // InternalBug348199TestLanguage.g:4019:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4020:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4021:3: ( RULE_NL )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_NL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4021:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4030:1: rule__Timeperiod__Group_3_6__3 : rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 ;
    public final void rule__Timeperiod__Group_3_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4034:1: ( rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 )
            // InternalBug348199TestLanguage.g:4035:2: rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4
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
    // InternalBug348199TestLanguage.g:4042:1: rule__Timeperiod__Group_3_6__3__Impl : ( ( rule__Timeperiod__Group_3_6_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4046:1: ( ( ( rule__Timeperiod__Group_3_6_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4047:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4047:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            // InternalBug348199TestLanguage.g:4048:2: ( rule__Timeperiod__Group_3_6_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_3()); 
            // InternalBug348199TestLanguage.g:4049:2: ( rule__Timeperiod__Group_3_6_3__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==26) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4049:3: rule__Timeperiod__Group_3_6_3__0
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
    // InternalBug348199TestLanguage.g:4057:1: rule__Timeperiod__Group_3_6__4 : rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 ;
    public final void rule__Timeperiod__Group_3_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4061:1: ( rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 )
            // InternalBug348199TestLanguage.g:4062:2: rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5
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
    // InternalBug348199TestLanguage.g:4069:1: rule__Timeperiod__Group_3_6__4__Impl : ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4073:1: ( ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) )
            // InternalBug348199TestLanguage.g:4074:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            {
            // InternalBug348199TestLanguage.g:4074:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            // InternalBug348199TestLanguage.g:4075:2: ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            {
            // InternalBug348199TestLanguage.g:4075:2: ( ( rule__Timeperiod__Alternatives_3_6_4 ) )
            // InternalBug348199TestLanguage.g:4076:3: ( rule__Timeperiod__Alternatives_3_6_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4077:3: ( rule__Timeperiod__Alternatives_3_6_4 )
            // InternalBug348199TestLanguage.g:4077:4: rule__Timeperiod__Alternatives_3_6_4
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__Alternatives_3_6_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 

            }

            // InternalBug348199TestLanguage.g:4080:2: ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            // InternalBug348199TestLanguage.g:4081:3: ( rule__Timeperiod__Alternatives_3_6_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4082:3: ( rule__Timeperiod__Alternatives_3_6_4 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( ((LA68_0>=17 && LA68_0<=18)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4082:4: rule__Timeperiod__Alternatives_3_6_4
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
    // InternalBug348199TestLanguage.g:4091:1: rule__Timeperiod__Group_3_6__5 : rule__Timeperiod__Group_3_6__5__Impl ;
    public final void rule__Timeperiod__Group_3_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4095:1: ( rule__Timeperiod__Group_3_6__5__Impl )
            // InternalBug348199TestLanguage.g:4096:2: rule__Timeperiod__Group_3_6__5__Impl
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
    // InternalBug348199TestLanguage.g:4102:1: rule__Timeperiod__Group_3_6__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4106:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4107:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4107:1: ( '}' )
            // InternalBug348199TestLanguage.g:4108:2: '}'
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
    // InternalBug348199TestLanguage.g:4118:1: rule__Timeperiod__Group_3_6_3__0 : rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 ;
    public final void rule__Timeperiod__Group_3_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4122:1: ( rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 )
            // InternalBug348199TestLanguage.g:4123:2: rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1
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
    // InternalBug348199TestLanguage.g:4130:1: rule__Timeperiod__Group_3_6_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4134:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4135:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4135:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            // InternalBug348199TestLanguage.g:4136:2: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_3_0()); 
            // InternalBug348199TestLanguage.g:4137:2: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            // InternalBug348199TestLanguage.g:4137:3: rule__Timeperiod__TimeAssignment_3_6_3_0
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
    // InternalBug348199TestLanguage.g:4145:1: rule__Timeperiod__Group_3_6_3__1 : rule__Timeperiod__Group_3_6_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4149:1: ( rule__Timeperiod__Group_3_6_3__1__Impl )
            // InternalBug348199TestLanguage.g:4150:2: rule__Timeperiod__Group_3_6_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4156:1: rule__Timeperiod__Group_3_6_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4160:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4161:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4161:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4162:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4162:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4163:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4164:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4164:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4167:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4168:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4169:3: ( RULE_NL )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_NL) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4169:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4179:1: rule__Timeperiod__Group_3_6_4_0__0 : rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4183:1: ( rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 )
            // InternalBug348199TestLanguage.g:4184:2: rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1
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
    // InternalBug348199TestLanguage.g:4191:1: rule__Timeperiod__Group_3_6_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4195:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4196:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4196:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4197:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:4206:1: rule__Timeperiod__Group_3_6_4_0__1 : rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 ;
    public final void rule__Timeperiod__Group_3_6_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4210:1: ( rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 )
            // InternalBug348199TestLanguage.g:4211:2: rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2
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
    // InternalBug348199TestLanguage.g:4218:1: rule__Timeperiod__Group_3_6_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4222:1: ( ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4223:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4223:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4224:2: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_6_4_0_1()); 
            // InternalBug348199TestLanguage.g:4225:2: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            // InternalBug348199TestLanguage.g:4225:3: rule__Timeperiod__NameAssignment_3_6_4_0_1
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
    // InternalBug348199TestLanguage.g:4233:1: rule__Timeperiod__Group_3_6_4_0__2 : rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 ;
    public final void rule__Timeperiod__Group_3_6_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4237:1: ( rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 )
            // InternalBug348199TestLanguage.g:4238:2: rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3
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
    // InternalBug348199TestLanguage.g:4245:1: rule__Timeperiod__Group_3_6_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4249:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4250:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4250:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4251:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4251:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4252:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4253:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4253:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4256:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4257:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4258:3: ( RULE_NL )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_NL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4258:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4267:1: rule__Timeperiod__Group_3_6_4_0__3 : rule__Timeperiod__Group_3_6_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4271:1: ( rule__Timeperiod__Group_3_6_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4272:2: rule__Timeperiod__Group_3_6_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:4278:1: rule__Timeperiod__Group_3_6_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4282:1: ( ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4283:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4283:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4284:2: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0_3()); 
            // InternalBug348199TestLanguage.g:4285:2: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4285:3: rule__Timeperiod__Group_3_6_4_0_3__0
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
    // InternalBug348199TestLanguage.g:4294:1: rule__Timeperiod__Group_3_6_4_0_3__0 : rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4298:1: ( rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4299:2: rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1
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
    // InternalBug348199TestLanguage.g:4306:1: rule__Timeperiod__Group_3_6_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4310:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4311:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4311:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4312:2: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4313:2: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4313:3: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0
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
    // InternalBug348199TestLanguage.g:4321:1: rule__Timeperiod__Group_3_6_4_0_3__1 : rule__Timeperiod__Group_3_6_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4325:1: ( rule__Timeperiod__Group_3_6_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4326:2: rule__Timeperiod__Group_3_6_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4332:1: rule__Timeperiod__Group_3_6_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4336:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4337:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4337:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4338:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4338:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4339:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4340:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4340:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4343:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4344:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4345:3: ( RULE_NL )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_NL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4345:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4355:1: rule__Timeperiod__Group_3_6_4_1__0 : rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4359:1: ( rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 )
            // InternalBug348199TestLanguage.g:4360:2: rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1
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
    // InternalBug348199TestLanguage.g:4367:1: rule__Timeperiod__Group_3_6_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4371:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4372:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4372:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4373:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:4382:1: rule__Timeperiod__Group_3_6_4_1__1 : rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 ;
    public final void rule__Timeperiod__Group_3_6_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4386:1: ( rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 )
            // InternalBug348199TestLanguage.g:4387:2: rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2
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
    // InternalBug348199TestLanguage.g:4394:1: rule__Timeperiod__Group_3_6_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4398:1: ( ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:4399:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:4399:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            // InternalBug348199TestLanguage.g:4400:2: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_6_4_1_1()); 
            // InternalBug348199TestLanguage.g:4401:2: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            // InternalBug348199TestLanguage.g:4401:3: rule__Timeperiod__AliasAssignment_3_6_4_1_1
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
    // InternalBug348199TestLanguage.g:4409:1: rule__Timeperiod__Group_3_6_4_1__2 : rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 ;
    public final void rule__Timeperiod__Group_3_6_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4413:1: ( rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 )
            // InternalBug348199TestLanguage.g:4414:2: rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3
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
    // InternalBug348199TestLanguage.g:4421:1: rule__Timeperiod__Group_3_6_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4425:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4426:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4426:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4427:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4427:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4428:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:4429:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4429:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:4432:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4433:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:4434:3: ( RULE_NL )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_NL) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4434:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4443:1: rule__Timeperiod__Group_3_6_4_1__3 : rule__Timeperiod__Group_3_6_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4447:1: ( rule__Timeperiod__Group_3_6_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:4448:2: rule__Timeperiod__Group_3_6_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:4454:1: rule__Timeperiod__Group_3_6_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4458:1: ( ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4459:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4459:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:4460:2: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1_3()); 
            // InternalBug348199TestLanguage.g:4461:2: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==28) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4461:3: rule__Timeperiod__Group_3_6_4_1_3__0
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
    // InternalBug348199TestLanguage.g:4470:1: rule__Timeperiod__Group_3_6_4_1_3__0 : rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4474:1: ( rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 )
            // InternalBug348199TestLanguage.g:4475:2: rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1
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
    // InternalBug348199TestLanguage.g:4482:1: rule__Timeperiod__Group_3_6_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4486:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4487:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4487:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:4488:2: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:4489:2: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            // InternalBug348199TestLanguage.g:4489:3: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0
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
    // InternalBug348199TestLanguage.g:4497:1: rule__Timeperiod__Group_3_6_4_1_3__1 : rule__Timeperiod__Group_3_6_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4501:1: ( rule__Timeperiod__Group_3_6_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:4502:2: rule__Timeperiod__Group_3_6_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4508:1: rule__Timeperiod__Group_3_6_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4512:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4513:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4513:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4514:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4514:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4515:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4516:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4516:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4519:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4520:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4521:3: ( RULE_NL )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_NL) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4521:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4531:1: rule__Timeperiod__Group_3_7__0 : rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 ;
    public final void rule__Timeperiod__Group_3_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4535:1: ( rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 )
            // InternalBug348199TestLanguage.g:4536:2: rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1
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
    // InternalBug348199TestLanguage.g:4543:1: rule__Timeperiod__Group_3_7__0__Impl : ( '8' ) ;
    public final void rule__Timeperiod__Group_3_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4547:1: ( ( '8' ) )
            // InternalBug348199TestLanguage.g:4548:1: ( '8' )
            {
            // InternalBug348199TestLanguage.g:4548:1: ( '8' )
            // InternalBug348199TestLanguage.g:4549:2: '8'
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
    // InternalBug348199TestLanguage.g:4558:1: rule__Timeperiod__Group_3_7__1 : rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 ;
    public final void rule__Timeperiod__Group_3_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4562:1: ( rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 )
            // InternalBug348199TestLanguage.g:4563:2: rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2
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
    // InternalBug348199TestLanguage.g:4570:1: rule__Timeperiod__Group_3_7__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4574:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:4575:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:4575:1: ( '{' )
            // InternalBug348199TestLanguage.g:4576:2: '{'
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
    // InternalBug348199TestLanguage.g:4585:1: rule__Timeperiod__Group_3_7__2 : rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 ;
    public final void rule__Timeperiod__Group_3_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4589:1: ( rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 )
            // InternalBug348199TestLanguage.g:4590:2: rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3
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
    // InternalBug348199TestLanguage.g:4597:1: rule__Timeperiod__Group_3_7__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4601:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4602:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4602:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4603:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4603:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4604:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:4605:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4605:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 

            }

            // InternalBug348199TestLanguage.g:4608:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4609:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:4610:3: ( RULE_NL )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_NL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4610:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4619:1: rule__Timeperiod__Group_3_7__3 : rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 ;
    public final void rule__Timeperiod__Group_3_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4623:1: ( rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 )
            // InternalBug348199TestLanguage.g:4624:2: rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4
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
    // InternalBug348199TestLanguage.g:4631:1: rule__Timeperiod__Group_3_7__3__Impl : ( ( rule__Timeperiod__Group_3_7_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4635:1: ( ( ( rule__Timeperiod__Group_3_7_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4636:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4636:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            // InternalBug348199TestLanguage.g:4637:2: ( rule__Timeperiod__Group_3_7_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_3()); 
            // InternalBug348199TestLanguage.g:4638:2: ( rule__Timeperiod__Group_3_7_3__0 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==26) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4638:3: rule__Timeperiod__Group_3_7_3__0
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
    // InternalBug348199TestLanguage.g:4646:1: rule__Timeperiod__Group_3_7__4 : rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 ;
    public final void rule__Timeperiod__Group_3_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4650:1: ( rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 )
            // InternalBug348199TestLanguage.g:4651:2: rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5
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
    // InternalBug348199TestLanguage.g:4658:1: rule__Timeperiod__Group_3_7__4__Impl : ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) ;
    public final void rule__Timeperiod__Group_3_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4662:1: ( ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) )
            // InternalBug348199TestLanguage.g:4663:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            {
            // InternalBug348199TestLanguage.g:4663:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            // InternalBug348199TestLanguage.g:4664:2: ( rule__Timeperiod__Alternatives_3_7_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_7_4()); 
            // InternalBug348199TestLanguage.g:4665:2: ( rule__Timeperiod__Alternatives_3_7_4 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=17 && LA78_0<=18)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4665:3: rule__Timeperiod__Alternatives_3_7_4
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
    // InternalBug348199TestLanguage.g:4673:1: rule__Timeperiod__Group_3_7__5 : rule__Timeperiod__Group_3_7__5__Impl ;
    public final void rule__Timeperiod__Group_3_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4677:1: ( rule__Timeperiod__Group_3_7__5__Impl )
            // InternalBug348199TestLanguage.g:4678:2: rule__Timeperiod__Group_3_7__5__Impl
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
    // InternalBug348199TestLanguage.g:4684:1: rule__Timeperiod__Group_3_7__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4688:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4689:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4689:1: ( '}' )
            // InternalBug348199TestLanguage.g:4690:2: '}'
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
    // InternalBug348199TestLanguage.g:4700:1: rule__Timeperiod__Group_3_7_3__0 : rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 ;
    public final void rule__Timeperiod__Group_3_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4704:1: ( rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 )
            // InternalBug348199TestLanguage.g:4705:2: rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1
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
    // InternalBug348199TestLanguage.g:4712:1: rule__Timeperiod__Group_3_7_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4716:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4717:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4717:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            // InternalBug348199TestLanguage.g:4718:2: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_3_0()); 
            // InternalBug348199TestLanguage.g:4719:2: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            // InternalBug348199TestLanguage.g:4719:3: rule__Timeperiod__TimeAssignment_3_7_3_0
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
    // InternalBug348199TestLanguage.g:4727:1: rule__Timeperiod__Group_3_7_3__1 : rule__Timeperiod__Group_3_7_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4731:1: ( rule__Timeperiod__Group_3_7_3__1__Impl )
            // InternalBug348199TestLanguage.g:4732:2: rule__Timeperiod__Group_3_7_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4738:1: rule__Timeperiod__Group_3_7_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4742:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4743:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4743:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4744:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4744:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4745:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:4746:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4746:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4749:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4750:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:4751:3: ( RULE_NL )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_NL) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4751:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4761:1: rule__Timeperiod__Group_3_7_4_0__0 : rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4765:1: ( rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 )
            // InternalBug348199TestLanguage.g:4766:2: rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1
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
    // InternalBug348199TestLanguage.g:4773:1: rule__Timeperiod__Group_3_7_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4777:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4778:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4778:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4779:2: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:4788:1: rule__Timeperiod__Group_3_7_4_0__1 : rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 ;
    public final void rule__Timeperiod__Group_3_7_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4792:1: ( rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 )
            // InternalBug348199TestLanguage.g:4793:2: rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2
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
    // InternalBug348199TestLanguage.g:4800:1: rule__Timeperiod__Group_3_7_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4804:1: ( ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4805:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4805:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4806:2: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_7_4_0_1()); 
            // InternalBug348199TestLanguage.g:4807:2: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            // InternalBug348199TestLanguage.g:4807:3: rule__Timeperiod__NameAssignment_3_7_4_0_1
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
    // InternalBug348199TestLanguage.g:4815:1: rule__Timeperiod__Group_3_7_4_0__2 : rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 ;
    public final void rule__Timeperiod__Group_3_7_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4819:1: ( rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 )
            // InternalBug348199TestLanguage.g:4820:2: rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3
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
    // InternalBug348199TestLanguage.g:4827:1: rule__Timeperiod__Group_3_7_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4831:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4832:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4832:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4833:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4833:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4834:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:4835:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4835:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4838:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4839:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:4840:3: ( RULE_NL )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_NL) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4840:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4849:1: rule__Timeperiod__Group_3_7_4_0__3 : rule__Timeperiod__Group_3_7_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4853:1: ( rule__Timeperiod__Group_3_7_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4854:2: rule__Timeperiod__Group_3_7_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:4860:1: rule__Timeperiod__Group_3_7_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4864:1: ( ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4865:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4865:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4866:2: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0_3()); 
            // InternalBug348199TestLanguage.g:4867:2: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==27) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4867:3: rule__Timeperiod__Group_3_7_4_0_3__0
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
    // InternalBug348199TestLanguage.g:4876:1: rule__Timeperiod__Group_3_7_4_0_3__0 : rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4880:1: ( rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4881:2: rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1
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
    // InternalBug348199TestLanguage.g:4888:1: rule__Timeperiod__Group_3_7_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4892:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4893:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4893:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4894:2: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4895:2: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4895:3: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0
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
    // InternalBug348199TestLanguage.g:4903:1: rule__Timeperiod__Group_3_7_4_0_3__1 : rule__Timeperiod__Group_3_7_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4907:1: ( rule__Timeperiod__Group_3_7_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4908:2: rule__Timeperiod__Group_3_7_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4914:1: rule__Timeperiod__Group_3_7_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4918:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4919:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4919:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4920:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4920:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4921:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4922:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4922:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4925:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4926:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4927:3: ( RULE_NL )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_NL) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4927:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:4937:1: rule__Timeperiod__Group_3_7_4_1__0 : rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4941:1: ( rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 )
            // InternalBug348199TestLanguage.g:4942:2: rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1
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
    // InternalBug348199TestLanguage.g:4949:1: rule__Timeperiod__Group_3_7_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4953:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4954:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4954:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4955:2: 'otherelement'
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
    // InternalBug348199TestLanguage.g:4964:1: rule__Timeperiod__Group_3_7_4_1__1 : rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 ;
    public final void rule__Timeperiod__Group_3_7_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4968:1: ( rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 )
            // InternalBug348199TestLanguage.g:4969:2: rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2
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
    // InternalBug348199TestLanguage.g:4976:1: rule__Timeperiod__Group_3_7_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4980:1: ( ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:4981:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:4981:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            // InternalBug348199TestLanguage.g:4982:2: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_7_4_1_1()); 
            // InternalBug348199TestLanguage.g:4983:2: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            // InternalBug348199TestLanguage.g:4983:3: rule__Timeperiod__AliasAssignment_3_7_4_1_1
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
    // InternalBug348199TestLanguage.g:4991:1: rule__Timeperiod__Group_3_7_4_1__2 : rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 ;
    public final void rule__Timeperiod__Group_3_7_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:4995:1: ( rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 )
            // InternalBug348199TestLanguage.g:4996:2: rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3
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
    // InternalBug348199TestLanguage.g:5003:1: rule__Timeperiod__Group_3_7_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5007:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5008:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5008:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5009:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5009:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5010:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5011:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5011:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:5014:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5015:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5016:3: ( RULE_NL )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_NL) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5016:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:5025:1: rule__Timeperiod__Group_3_7_4_1__3 : rule__Timeperiod__Group_3_7_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5029:1: ( rule__Timeperiod__Group_3_7_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:5030:2: rule__Timeperiod__Group_3_7_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:5036:1: rule__Timeperiod__Group_3_7_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5040:1: ( ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5041:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5041:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:5042:2: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1_3()); 
            // InternalBug348199TestLanguage.g:5043:2: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==28) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5043:3: rule__Timeperiod__Group_3_7_4_1_3__0
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
    // InternalBug348199TestLanguage.g:5052:1: rule__Timeperiod__Group_3_7_4_1_3__0 : rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5056:1: ( rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 )
            // InternalBug348199TestLanguage.g:5057:2: rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1
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
    // InternalBug348199TestLanguage.g:5064:1: rule__Timeperiod__Group_3_7_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5068:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5069:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5069:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:5070:2: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:5071:2: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            // InternalBug348199TestLanguage.g:5071:3: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0
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
    // InternalBug348199TestLanguage.g:5079:1: rule__Timeperiod__Group_3_7_4_1_3__1 : rule__Timeperiod__Group_3_7_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5083:1: ( rule__Timeperiod__Group_3_7_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:5084:2: rule__Timeperiod__Group_3_7_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:5090:1: rule__Timeperiod__Group_3_7_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5094:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5095:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5095:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5096:2: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5096:2: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5097:3: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5098:3: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5098:4: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5101:2: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5102:3: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5103:3: ( RULE_NL )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_NL) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5103:4: RULE_NL
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
    // InternalBug348199TestLanguage.g:5113:1: rule__TimeDef1__Group__0 : rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 ;
    public final void rule__TimeDef1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5117:1: ( rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 )
            // InternalBug348199TestLanguage.g:5118:2: rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1
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
    // InternalBug348199TestLanguage.g:5125:1: rule__TimeDef1__Group__0__Impl : ( 'july' ) ;
    public final void rule__TimeDef1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5129:1: ( ( 'july' ) )
            // InternalBug348199TestLanguage.g:5130:1: ( 'july' )
            {
            // InternalBug348199TestLanguage.g:5130:1: ( 'july' )
            // InternalBug348199TestLanguage.g:5131:2: 'july'
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
    // InternalBug348199TestLanguage.g:5140:1: rule__TimeDef1__Group__1 : rule__TimeDef1__Group__1__Impl ;
    public final void rule__TimeDef1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5144:1: ( rule__TimeDef1__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5145:2: rule__TimeDef1__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:5151:1: rule__TimeDef1__Group__1__Impl : ( ( rule__TimeDef1__DayAssignment_1 ) ) ;
    public final void rule__TimeDef1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5155:1: ( ( ( rule__TimeDef1__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5156:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5156:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5157:2: ( rule__TimeDef1__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef1Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5158:2: ( rule__TimeDef1__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5158:3: rule__TimeDef1__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:5167:1: rule__TimeDef2__Group__0 : rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 ;
    public final void rule__TimeDef2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5171:1: ( rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 )
            // InternalBug348199TestLanguage.g:5172:2: rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1
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
    // InternalBug348199TestLanguage.g:5179:1: rule__TimeDef2__Group__0__Impl : ( 'august' ) ;
    public final void rule__TimeDef2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5183:1: ( ( 'august' ) )
            // InternalBug348199TestLanguage.g:5184:1: ( 'august' )
            {
            // InternalBug348199TestLanguage.g:5184:1: ( 'august' )
            // InternalBug348199TestLanguage.g:5185:2: 'august'
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
    // InternalBug348199TestLanguage.g:5194:1: rule__TimeDef2__Group__1 : rule__TimeDef2__Group__1__Impl ;
    public final void rule__TimeDef2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5198:1: ( rule__TimeDef2__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5199:2: rule__TimeDef2__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:5205:1: rule__TimeDef2__Group__1__Impl : ( ( rule__TimeDef2__DayAssignment_1 ) ) ;
    public final void rule__TimeDef2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5209:1: ( ( ( rule__TimeDef2__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5210:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5210:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5211:2: ( rule__TimeDef2__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef2Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5212:2: ( rule__TimeDef2__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5212:3: rule__TimeDef2__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:5221:1: rule__TimeDef3__Group__0 : rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 ;
    public final void rule__TimeDef3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5225:1: ( rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 )
            // InternalBug348199TestLanguage.g:5226:2: rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1
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
    // InternalBug348199TestLanguage.g:5233:1: rule__TimeDef3__Group__0__Impl : ( 'september' ) ;
    public final void rule__TimeDef3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5237:1: ( ( 'september' ) )
            // InternalBug348199TestLanguage.g:5238:1: ( 'september' )
            {
            // InternalBug348199TestLanguage.g:5238:1: ( 'september' )
            // InternalBug348199TestLanguage.g:5239:2: 'september'
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
    // InternalBug348199TestLanguage.g:5248:1: rule__TimeDef3__Group__1 : rule__TimeDef3__Group__1__Impl ;
    public final void rule__TimeDef3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5252:1: ( rule__TimeDef3__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5253:2: rule__TimeDef3__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:5259:1: rule__TimeDef3__Group__1__Impl : ( ( rule__TimeDef3__DayAssignment_1 ) ) ;
    public final void rule__TimeDef3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5263:1: ( ( ( rule__TimeDef3__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5264:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5264:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5265:2: ( rule__TimeDef3__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef3Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5266:2: ( rule__TimeDef3__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5266:3: rule__TimeDef3__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:5275:1: rule__Timeperiod__UnorderedGroup_3_0_3 : rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
        	
        try {
            // InternalBug348199TestLanguage.g:5280:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?)
            // InternalBug348199TestLanguage.g:5281:2: rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?
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
    // InternalBug348199TestLanguage.g:5289:1: rule__Timeperiod__UnorderedGroup_3_0_3__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug348199TestLanguage.g:5294:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:5295:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:5295:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5296:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5296:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5297:4: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:5297:110: ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:5298:5: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5304:5: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:5305:6: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0()); 
                    // InternalBug348199TestLanguage.g:5306:6: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    // InternalBug348199TestLanguage.g:5306:7: rule__Timeperiod__Group_3_0_3_0__0
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
                    // InternalBug348199TestLanguage.g:5311:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5311:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5312:4: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:5312:110: ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:5313:5: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5319:5: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:5320:6: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1()); 
                    // InternalBug348199TestLanguage.g:5321:6: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    // InternalBug348199TestLanguage.g:5321:7: rule__Timeperiod__Group_3_0_3_1__0
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
    // InternalBug348199TestLanguage.g:5334:1: rule__Timeperiod__UnorderedGroup_3_0_3__0 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5338:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? )
            // InternalBug348199TestLanguage.g:5339:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__UnorderedGroup_3_0_3__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:5340:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalBug348199TestLanguage.g:5340:2: rule__Timeperiod__UnorderedGroup_3_0_3__1
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
    // InternalBug348199TestLanguage.g:5346:1: rule__Timeperiod__UnorderedGroup_3_0_3__1 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5350:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl )
            // InternalBug348199TestLanguage.g:5351:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl
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
    // InternalBug348199TestLanguage.g:5358:1: rule__Timeperiod__UnorderedGroup_3_4_4 : rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
        	
        try {
            // InternalBug348199TestLanguage.g:5363:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?)
            // InternalBug348199TestLanguage.g:5364:2: rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?
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
    // InternalBug348199TestLanguage.g:5372:1: rule__Timeperiod__UnorderedGroup_3_4_4__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug348199TestLanguage.g:5377:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:5378:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:5378:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
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
                    // InternalBug348199TestLanguage.g:5379:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5379:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5380:4: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:5380:110: ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:5381:5: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5387:5: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:5388:6: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0()); 
                    // InternalBug348199TestLanguage.g:5389:6: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    // InternalBug348199TestLanguage.g:5389:7: rule__Timeperiod__Group_3_4_4_0__0
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
                    // InternalBug348199TestLanguage.g:5394:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:5394:3: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:5395:4: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:5395:110: ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:5396:5: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug348199TestLanguage.g:5402:5: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:5403:6: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1()); 
                    // InternalBug348199TestLanguage.g:5404:6: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    // InternalBug348199TestLanguage.g:5404:7: rule__Timeperiod__Group_3_4_4_1__0
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
    // InternalBug348199TestLanguage.g:5417:1: rule__Timeperiod__UnorderedGroup_3_4_4__0 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5421:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? )
            // InternalBug348199TestLanguage.g:5422:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__UnorderedGroup_3_4_4__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:5423:2: ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
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
                    // InternalBug348199TestLanguage.g:5423:2: rule__Timeperiod__UnorderedGroup_3_4_4__1
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
    // InternalBug348199TestLanguage.g:5429:1: rule__Timeperiod__UnorderedGroup_3_4_4__1 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5433:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl )
            // InternalBug348199TestLanguage.g:5434:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl
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
    // InternalBug348199TestLanguage.g:5441:1: rule__Timeperiod__TimeAssignment_3_0_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5445:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5446:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5446:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5447:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5456:1: rule__Timeperiod__NameAssignment_3_0_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_0_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5460:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5461:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5461:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5462:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5471:1: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5475:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5476:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5476:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5477:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5486:1: rule__Timeperiod__AliasAssignment_3_0_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_0_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5490:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5491:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5491:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5492:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5501:1: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5505:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5506:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5506:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5507:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5516:1: rule__Timeperiod__TimeAssignment_3_1_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5520:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5521:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5521:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5522:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5531:1: rule__Timeperiod__NameAssignment_3_1_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_1_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5535:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5536:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5536:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5537:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5546:1: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5550:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5551:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5551:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5552:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5561:1: rule__Timeperiod__AliasAssignment_3_1_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_1_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5565:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5566:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5566:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5567:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5576:1: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5580:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5581:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5581:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5582:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5591:1: rule__Timeperiod__TimeAssignment_3_2_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5595:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5596:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5596:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5597:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5606:1: rule__Timeperiod__NameAssignment_3_2_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_2_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5610:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5611:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5611:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5612:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5621:1: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5625:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5626:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5626:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5627:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5636:1: rule__Timeperiod__AliasAssignment_3_2_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_2_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5640:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5641:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5641:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5642:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5651:1: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5655:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5656:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5656:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5657:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5666:1: rule__Timeperiod__TimeAssignment_3_3_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5670:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5671:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5671:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5672:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5681:1: rule__Timeperiod__NameAssignment_3_3_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_3_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5685:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5686:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5686:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5687:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5696:1: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5700:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5701:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5701:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5702:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5711:1: rule__Timeperiod__AliasAssignment_3_3_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_3_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5715:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5716:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5716:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5717:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5726:1: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5730:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5731:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5731:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5732:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5741:1: rule__Timeperiod__TimeAssignment_3_4_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5745:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5746:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5746:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5747:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5756:1: rule__Timeperiod__NameAssignment_3_4_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_4_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5760:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5761:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5761:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5762:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5771:1: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5775:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5776:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5776:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5777:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5786:1: rule__Timeperiod__AliasAssignment_3_4_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_4_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5790:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5791:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5791:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5792:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5801:1: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5805:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5806:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5806:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5807:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5816:1: rule__Timeperiod__TimeAssignment_3_5_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5820:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5821:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5821:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5822:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5831:1: rule__Timeperiod__NameAssignment_3_5_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_5_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5835:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5836:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5836:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5837:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5846:1: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5850:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5851:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5851:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5852:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5861:1: rule__Timeperiod__AliasAssignment_3_5_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_5_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5865:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5866:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5866:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5867:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5876:1: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5880:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5881:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5881:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5882:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5891:1: rule__Timeperiod__TimeAssignment_3_6_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5895:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5896:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5896:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5897:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5906:1: rule__Timeperiod__NameAssignment_3_6_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_6_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5910:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5911:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5911:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5912:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5921:1: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5925:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:5926:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:5926:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:5927:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:5936:1: rule__Timeperiod__AliasAssignment_3_6_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_6_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5940:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5941:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5941:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5942:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5951:1: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5955:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:5956:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:5956:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:5957:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:5966:1: rule__Timeperiod__TimeAssignment_3_7_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5970:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:5971:2: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:5971:2: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:5972:3: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:5981:1: rule__Timeperiod__NameAssignment_3_7_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_7_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:5985:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:5986:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:5986:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:5987:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:5996:1: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6000:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6001:2: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6001:2: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6002:3: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6011:1: rule__Timeperiod__AliasAssignment_3_7_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_7_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6015:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6016:2: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6016:2: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6017:3: RULE_ID
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
    // InternalBug348199TestLanguage.g:6026:1: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6030:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6031:2: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6031:2: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6032:3: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6041:1: rule__TimeDef1__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef1__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6045:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6046:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6046:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6047:3: RULE_INT
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
    // InternalBug348199TestLanguage.g:6056:1: rule__TimeDef2__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef2__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6060:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6061:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6061:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6062:3: RULE_INT
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
    // InternalBug348199TestLanguage.g:6071:1: rule__TimeDef3__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef3__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug348199TestLanguage.g:6075:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6076:2: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6076:2: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6077:3: RULE_INT
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
            return "209:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );";
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
            return "222:3: ( rule__Timeperiod__Group_3_1_3_1__0 )?";
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
            return "230:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );";
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
            return "251:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );";
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
            return "()* loopback of 516:2: ( rule__Timeperiod__Group_3_0_2__0 )*";
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
            return "()* loopback of 779:2: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*";
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
            return "()* loopback of 955:2: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*";
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
            return "()* loopback of 1098:2: ( rule__Timeperiod__Group_3_1_2__0 )*";
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
            return "()* loopback of 1361:2: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*";
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
            return "()* loopback of 1537:2: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*";
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
            return "()* loopback of 1680:2: ( rule__Timeperiod__Group_3_2_2__0 )*";
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
            return "()* loopback of 1713:3: ( rule__Timeperiod__Alternatives_3_2_3 )*";
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
            return "()* loopback of 1950:2: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*";
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
            return "()* loopback of 2126:2: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*";
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
            return "()* loopback of 2269:2: ( rule__Timeperiod__Group_3_3_2__0 )*";
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
            return "()* loopback of 2296:2: ( rule__Timeperiod__Alternatives_3_3_3 )*";
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
            return "()* loopback of 2532:2: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*";
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
            return "()* loopback of 2708:2: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*";
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
            return "5295:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )";
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
            return "5340:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?";
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