package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
    public static final int RULE_ID=5;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_NL=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=7;

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
    // InternalBug348199TestLanguage.g:60:1: entryRuleTimeperiod : ruleTimeperiod EOF ;
    public final void entryRuleTimeperiod() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:61:1: ( ruleTimeperiod EOF )
            // InternalBug348199TestLanguage.g:62:1: ruleTimeperiod EOF
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
    // InternalBug348199TestLanguage.g:69:1: ruleTimeperiod : ( ( rule__Timeperiod__Group__0 ) ) ;
    public final void ruleTimeperiod() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:73:2: ( ( ( rule__Timeperiod__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:74:1: ( ( rule__Timeperiod__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:74:1: ( ( rule__Timeperiod__Group__0 ) )
            // InternalBug348199TestLanguage.g:75:1: ( rule__Timeperiod__Group__0 )
            {
             before(grammarAccess.getTimeperiodAccess().getGroup()); 
            // InternalBug348199TestLanguage.g:76:1: ( rule__Timeperiod__Group__0 )
            // InternalBug348199TestLanguage.g:76:2: rule__Timeperiod__Group__0
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
    // InternalBug348199TestLanguage.g:88:1: entryRuleTimeDef1 : ruleTimeDef1 EOF ;
    public final void entryRuleTimeDef1() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:89:1: ( ruleTimeDef1 EOF )
            // InternalBug348199TestLanguage.g:90:1: ruleTimeDef1 EOF
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
    // InternalBug348199TestLanguage.g:97:1: ruleTimeDef1 : ( ( rule__TimeDef1__Group__0 ) ) ;
    public final void ruleTimeDef1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:101:2: ( ( ( rule__TimeDef1__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:102:1: ( ( rule__TimeDef1__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:102:1: ( ( rule__TimeDef1__Group__0 ) )
            // InternalBug348199TestLanguage.g:103:1: ( rule__TimeDef1__Group__0 )
            {
             before(grammarAccess.getTimeDef1Access().getGroup()); 
            // InternalBug348199TestLanguage.g:104:1: ( rule__TimeDef1__Group__0 )
            // InternalBug348199TestLanguage.g:104:2: rule__TimeDef1__Group__0
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
    // InternalBug348199TestLanguage.g:116:1: entryRuleTimeDef2 : ruleTimeDef2 EOF ;
    public final void entryRuleTimeDef2() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:117:1: ( ruleTimeDef2 EOF )
            // InternalBug348199TestLanguage.g:118:1: ruleTimeDef2 EOF
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
    // InternalBug348199TestLanguage.g:125:1: ruleTimeDef2 : ( ( rule__TimeDef2__Group__0 ) ) ;
    public final void ruleTimeDef2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:129:2: ( ( ( rule__TimeDef2__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:130:1: ( ( rule__TimeDef2__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:130:1: ( ( rule__TimeDef2__Group__0 ) )
            // InternalBug348199TestLanguage.g:131:1: ( rule__TimeDef2__Group__0 )
            {
             before(grammarAccess.getTimeDef2Access().getGroup()); 
            // InternalBug348199TestLanguage.g:132:1: ( rule__TimeDef2__Group__0 )
            // InternalBug348199TestLanguage.g:132:2: rule__TimeDef2__Group__0
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
    // InternalBug348199TestLanguage.g:144:1: entryRuleTimeDef3 : ruleTimeDef3 EOF ;
    public final void entryRuleTimeDef3() throws RecognitionException {
        try {
            // InternalBug348199TestLanguage.g:145:1: ( ruleTimeDef3 EOF )
            // InternalBug348199TestLanguage.g:146:1: ruleTimeDef3 EOF
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
    // InternalBug348199TestLanguage.g:153:1: ruleTimeDef3 : ( ( rule__TimeDef3__Group__0 ) ) ;
    public final void ruleTimeDef3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:157:2: ( ( ( rule__TimeDef3__Group__0 ) ) )
            // InternalBug348199TestLanguage.g:158:1: ( ( rule__TimeDef3__Group__0 ) )
            {
            // InternalBug348199TestLanguage.g:158:1: ( ( rule__TimeDef3__Group__0 ) )
            // InternalBug348199TestLanguage.g:159:1: ( rule__TimeDef3__Group__0 )
            {
             before(grammarAccess.getTimeDef3Access().getGroup()); 
            // InternalBug348199TestLanguage.g:160:1: ( rule__TimeDef3__Group__0 )
            // InternalBug348199TestLanguage.g:160:2: rule__TimeDef3__Group__0
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
    // InternalBug348199TestLanguage.g:172:1: rule__Timeperiod__Alternatives_3 : ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:176:1: ( ( ( rule__Timeperiod__Group_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1__0 ) ) | ( ( rule__Timeperiod__Group_3_2__0 ) ) | ( ( rule__Timeperiod__Group_3_3__0 ) ) | ( ( rule__Timeperiod__Group_3_4__0 ) ) | ( ( rule__Timeperiod__Group_3_5__0 ) ) | ( ( rule__Timeperiod__Group_3_6__0 ) ) | ( ( rule__Timeperiod__Group_3_7__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:177:1: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:177:1: ( ( rule__Timeperiod__Group_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:178:1: ( rule__Timeperiod__Group_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0()); 
                    // InternalBug348199TestLanguage.g:179:1: ( rule__Timeperiod__Group_3_0__0 )
                    // InternalBug348199TestLanguage.g:179:2: rule__Timeperiod__Group_3_0__0
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
                    // InternalBug348199TestLanguage.g:183:6: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:183:6: ( ( rule__Timeperiod__Group_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:184:1: ( rule__Timeperiod__Group_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1()); 
                    // InternalBug348199TestLanguage.g:185:1: ( rule__Timeperiod__Group_3_1__0 )
                    // InternalBug348199TestLanguage.g:185:2: rule__Timeperiod__Group_3_1__0
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
                    // InternalBug348199TestLanguage.g:189:6: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:189:6: ( ( rule__Timeperiod__Group_3_2__0 ) )
                    // InternalBug348199TestLanguage.g:190:1: ( rule__Timeperiod__Group_3_2__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2()); 
                    // InternalBug348199TestLanguage.g:191:1: ( rule__Timeperiod__Group_3_2__0 )
                    // InternalBug348199TestLanguage.g:191:2: rule__Timeperiod__Group_3_2__0
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
                    // InternalBug348199TestLanguage.g:195:6: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:195:6: ( ( rule__Timeperiod__Group_3_3__0 ) )
                    // InternalBug348199TestLanguage.g:196:1: ( rule__Timeperiod__Group_3_3__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3()); 
                    // InternalBug348199TestLanguage.g:197:1: ( rule__Timeperiod__Group_3_3__0 )
                    // InternalBug348199TestLanguage.g:197:2: rule__Timeperiod__Group_3_3__0
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
                    // InternalBug348199TestLanguage.g:201:6: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:201:6: ( ( rule__Timeperiod__Group_3_4__0 ) )
                    // InternalBug348199TestLanguage.g:202:1: ( rule__Timeperiod__Group_3_4__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4()); 
                    // InternalBug348199TestLanguage.g:203:1: ( rule__Timeperiod__Group_3_4__0 )
                    // InternalBug348199TestLanguage.g:203:2: rule__Timeperiod__Group_3_4__0
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
                    // InternalBug348199TestLanguage.g:207:6: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:207:6: ( ( rule__Timeperiod__Group_3_5__0 ) )
                    // InternalBug348199TestLanguage.g:208:1: ( rule__Timeperiod__Group_3_5__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5()); 
                    // InternalBug348199TestLanguage.g:209:1: ( rule__Timeperiod__Group_3_5__0 )
                    // InternalBug348199TestLanguage.g:209:2: rule__Timeperiod__Group_3_5__0
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
                    // InternalBug348199TestLanguage.g:213:6: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:213:6: ( ( rule__Timeperiod__Group_3_6__0 ) )
                    // InternalBug348199TestLanguage.g:214:1: ( rule__Timeperiod__Group_3_6__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6()); 
                    // InternalBug348199TestLanguage.g:215:1: ( rule__Timeperiod__Group_3_6__0 )
                    // InternalBug348199TestLanguage.g:215:2: rule__Timeperiod__Group_3_6__0
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
                    // InternalBug348199TestLanguage.g:219:6: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:219:6: ( ( rule__Timeperiod__Group_3_7__0 ) )
                    // InternalBug348199TestLanguage.g:220:1: ( rule__Timeperiod__Group_3_7__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7()); 
                    // InternalBug348199TestLanguage.g:221:1: ( rule__Timeperiod__Group_3_7__0 )
                    // InternalBug348199TestLanguage.g:221:2: rule__Timeperiod__Group_3_7__0
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
    // InternalBug348199TestLanguage.g:230:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:234:1: ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBug348199TestLanguage.g:235:1: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:235:1: ( ( rule__Timeperiod__Group_3_1_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:236:1: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0()); 
                    // InternalBug348199TestLanguage.g:237:1: ( rule__Timeperiod__Group_3_1_3_0__0 )
                    // InternalBug348199TestLanguage.g:237:2: rule__Timeperiod__Group_3_1_3_0__0
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
                    // InternalBug348199TestLanguage.g:241:6: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:241:6: ( ( rule__Timeperiod__Group_3_1_3_1__0 )? )
                    // InternalBug348199TestLanguage.g:242:1: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1()); 
                    // InternalBug348199TestLanguage.g:243:1: ( rule__Timeperiod__Group_3_1_3_1__0 )?
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:243:2: rule__Timeperiod__Group_3_1_3_1__0
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
    // InternalBug348199TestLanguage.g:252:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:256:1: ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug348199TestLanguage.g:257:1: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:257:1: ( ( rule__Timeperiod__Group_3_2_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:258:1: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0()); 
                    // InternalBug348199TestLanguage.g:259:1: ( rule__Timeperiod__Group_3_2_3_0__0 )
                    // InternalBug348199TestLanguage.g:259:2: rule__Timeperiod__Group_3_2_3_0__0
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
                    // InternalBug348199TestLanguage.g:263:6: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:263:6: ( ( rule__Timeperiod__Group_3_2_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:264:1: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1()); 
                    // InternalBug348199TestLanguage.g:265:1: ( rule__Timeperiod__Group_3_2_3_1__0 )
                    // InternalBug348199TestLanguage.g:265:2: rule__Timeperiod__Group_3_2_3_1__0
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
    // InternalBug348199TestLanguage.g:274:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:278:1: ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBug348199TestLanguage.g:279:1: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:279:1: ( ( rule__Timeperiod__Group_3_3_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:280:1: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0()); 
                    // InternalBug348199TestLanguage.g:281:1: ( rule__Timeperiod__Group_3_3_3_0__0 )
                    // InternalBug348199TestLanguage.g:281:2: rule__Timeperiod__Group_3_3_3_0__0
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
                    // InternalBug348199TestLanguage.g:285:6: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:285:6: ( ( rule__Timeperiod__Group_3_3_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:286:1: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1()); 
                    // InternalBug348199TestLanguage.g:287:1: ( rule__Timeperiod__Group_3_3_3_1__0 )
                    // InternalBug348199TestLanguage.g:287:2: rule__Timeperiod__Group_3_3_3_1__0
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
    // InternalBug348199TestLanguage.g:296:1: rule__Timeperiod__Alternatives_3_5_4 : ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) );
    public final void rule__Timeperiod__Alternatives_3_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:300:1: ( ( ( rule__Timeperiod__Group_3_5_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_5_4_1__0 )? ) )
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
                    // InternalBug348199TestLanguage.g:301:1: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:301:1: ( ( rule__Timeperiod__Group_3_5_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:302:1: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0()); 
                    // InternalBug348199TestLanguage.g:303:1: ( rule__Timeperiod__Group_3_5_4_0__0 )
                    // InternalBug348199TestLanguage.g:303:2: rule__Timeperiod__Group_3_5_4_0__0
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
                    // InternalBug348199TestLanguage.g:307:6: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    {
                    // InternalBug348199TestLanguage.g:307:6: ( ( rule__Timeperiod__Group_3_5_4_1__0 )? )
                    // InternalBug348199TestLanguage.g:308:1: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1()); 
                    // InternalBug348199TestLanguage.g:309:1: ( rule__Timeperiod__Group_3_5_4_1__0 )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==18) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:309:2: rule__Timeperiod__Group_3_5_4_1__0
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
    // InternalBug348199TestLanguage.g:318:1: rule__Timeperiod__Alternatives_3_6_4 : ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:322:1: ( ( ( rule__Timeperiod__Group_3_6_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_6_4_1__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:323:1: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:323:1: ( ( rule__Timeperiod__Group_3_6_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:324:1: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0()); 
                    // InternalBug348199TestLanguage.g:325:1: ( rule__Timeperiod__Group_3_6_4_0__0 )
                    // InternalBug348199TestLanguage.g:325:2: rule__Timeperiod__Group_3_6_4_0__0
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
                    // InternalBug348199TestLanguage.g:329:6: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:329:6: ( ( rule__Timeperiod__Group_3_6_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:330:1: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1()); 
                    // InternalBug348199TestLanguage.g:331:1: ( rule__Timeperiod__Group_3_6_4_1__0 )
                    // InternalBug348199TestLanguage.g:331:2: rule__Timeperiod__Group_3_6_4_1__0
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
    // InternalBug348199TestLanguage.g:340:1: rule__Timeperiod__Alternatives_3_7_4 : ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) );
    public final void rule__Timeperiod__Alternatives_3_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:344:1: ( ( ( rule__Timeperiod__Group_3_7_4_0__0 ) ) | ( ( rule__Timeperiod__Group_3_7_4_1__0 ) ) )
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
                    // InternalBug348199TestLanguage.g:345:1: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:345:1: ( ( rule__Timeperiod__Group_3_7_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:346:1: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0()); 
                    // InternalBug348199TestLanguage.g:347:1: ( rule__Timeperiod__Group_3_7_4_0__0 )
                    // InternalBug348199TestLanguage.g:347:2: rule__Timeperiod__Group_3_7_4_0__0
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
                    // InternalBug348199TestLanguage.g:351:6: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    {
                    // InternalBug348199TestLanguage.g:351:6: ( ( rule__Timeperiod__Group_3_7_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:352:1: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1()); 
                    // InternalBug348199TestLanguage.g:353:1: ( rule__Timeperiod__Group_3_7_4_1__0 )
                    // InternalBug348199TestLanguage.g:353:2: rule__Timeperiod__Group_3_7_4_1__0
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
    // InternalBug348199TestLanguage.g:364:1: rule__Timeperiod__Group__0 : rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 ;
    public final void rule__Timeperiod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:368:1: ( rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1 )
            // InternalBug348199TestLanguage.g:369:2: rule__Timeperiod__Group__0__Impl rule__Timeperiod__Group__1
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
    // InternalBug348199TestLanguage.g:376:1: rule__Timeperiod__Group__0__Impl : ( () ) ;
    public final void rule__Timeperiod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:380:1: ( ( () ) )
            // InternalBug348199TestLanguage.g:381:1: ( () )
            {
            // InternalBug348199TestLanguage.g:381:1: ( () )
            // InternalBug348199TestLanguage.g:382:1: ()
            {
             before(grammarAccess.getTimeperiodAccess().getTimeperiodAction_0()); 
            // InternalBug348199TestLanguage.g:383:1: ()
            // InternalBug348199TestLanguage.g:385:1: 
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
    // InternalBug348199TestLanguage.g:395:1: rule__Timeperiod__Group__1 : rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 ;
    public final void rule__Timeperiod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:399:1: ( rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2 )
            // InternalBug348199TestLanguage.g:400:2: rule__Timeperiod__Group__1__Impl rule__Timeperiod__Group__2
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
    // InternalBug348199TestLanguage.g:407:1: rule__Timeperiod__Group__1__Impl : ( 'define' ) ;
    public final void rule__Timeperiod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:411:1: ( ( 'define' ) )
            // InternalBug348199TestLanguage.g:412:1: ( 'define' )
            {
            // InternalBug348199TestLanguage.g:412:1: ( 'define' )
            // InternalBug348199TestLanguage.g:413:1: 'define'
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
    // InternalBug348199TestLanguage.g:426:1: rule__Timeperiod__Group__2 : rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 ;
    public final void rule__Timeperiod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:430:1: ( rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3 )
            // InternalBug348199TestLanguage.g:431:2: rule__Timeperiod__Group__2__Impl rule__Timeperiod__Group__3
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
    // InternalBug348199TestLanguage.g:438:1: rule__Timeperiod__Group__2__Impl : ( 'timeperiod' ) ;
    public final void rule__Timeperiod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:442:1: ( ( 'timeperiod' ) )
            // InternalBug348199TestLanguage.g:443:1: ( 'timeperiod' )
            {
            // InternalBug348199TestLanguage.g:443:1: ( 'timeperiod' )
            // InternalBug348199TestLanguage.g:444:1: 'timeperiod'
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
    // InternalBug348199TestLanguage.g:457:1: rule__Timeperiod__Group__3 : rule__Timeperiod__Group__3__Impl ;
    public final void rule__Timeperiod__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:461:1: ( rule__Timeperiod__Group__3__Impl )
            // InternalBug348199TestLanguage.g:462:2: rule__Timeperiod__Group__3__Impl
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
    // InternalBug348199TestLanguage.g:468:1: rule__Timeperiod__Group__3__Impl : ( ( rule__Timeperiod__Alternatives_3 ) ) ;
    public final void rule__Timeperiod__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:472:1: ( ( ( rule__Timeperiod__Alternatives_3 ) ) )
            // InternalBug348199TestLanguage.g:473:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            {
            // InternalBug348199TestLanguage.g:473:1: ( ( rule__Timeperiod__Alternatives_3 ) )
            // InternalBug348199TestLanguage.g:474:1: ( rule__Timeperiod__Alternatives_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3()); 
            // InternalBug348199TestLanguage.g:475:1: ( rule__Timeperiod__Alternatives_3 )
            // InternalBug348199TestLanguage.g:475:2: rule__Timeperiod__Alternatives_3
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
    // InternalBug348199TestLanguage.g:493:1: rule__Timeperiod__Group_3_0__0 : rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:497:1: ( rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1 )
            // InternalBug348199TestLanguage.g:498:2: rule__Timeperiod__Group_3_0__0__Impl rule__Timeperiod__Group_3_0__1
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
    // InternalBug348199TestLanguage.g:505:1: rule__Timeperiod__Group_3_0__0__Impl : ( '1' ) ;
    public final void rule__Timeperiod__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:509:1: ( ( '1' ) )
            // InternalBug348199TestLanguage.g:510:1: ( '1' )
            {
            // InternalBug348199TestLanguage.g:510:1: ( '1' )
            // InternalBug348199TestLanguage.g:511:1: '1'
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
    // InternalBug348199TestLanguage.g:524:1: rule__Timeperiod__Group_3_0__1 : rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:528:1: ( rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2 )
            // InternalBug348199TestLanguage.g:529:2: rule__Timeperiod__Group_3_0__1__Impl rule__Timeperiod__Group_3_0__2
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
    // InternalBug348199TestLanguage.g:536:1: rule__Timeperiod__Group_3_0__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:540:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:541:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:541:1: ( '{' )
            // InternalBug348199TestLanguage.g:542:1: '{'
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
    // InternalBug348199TestLanguage.g:555:1: rule__Timeperiod__Group_3_0__2 : rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:559:1: ( rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3 )
            // InternalBug348199TestLanguage.g:560:2: rule__Timeperiod__Group_3_0__2__Impl rule__Timeperiod__Group_3_0__3
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
    // InternalBug348199TestLanguage.g:567:1: rule__Timeperiod__Group_3_0__2__Impl : ( ( rule__Timeperiod__Group_3_0_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:571:1: ( ( ( rule__Timeperiod__Group_3_0_2__0 )* ) )
            // InternalBug348199TestLanguage.g:572:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:572:1: ( ( rule__Timeperiod__Group_3_0_2__0 )* )
            // InternalBug348199TestLanguage.g:573:1: ( rule__Timeperiod__Group_3_0_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_2()); 
            // InternalBug348199TestLanguage.g:574:1: ( rule__Timeperiod__Group_3_0_2__0 )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:574:2: rule__Timeperiod__Group_3_0_2__0
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
    // InternalBug348199TestLanguage.g:584:1: rule__Timeperiod__Group_3_0__3 : rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 ;
    public final void rule__Timeperiod__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:588:1: ( rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4 )
            // InternalBug348199TestLanguage.g:589:2: rule__Timeperiod__Group_3_0__3__Impl rule__Timeperiod__Group_3_0__4
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
    // InternalBug348199TestLanguage.g:596:1: rule__Timeperiod__Group_3_0__3__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) ;
    public final void rule__Timeperiod__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:600:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) ) )
            // InternalBug348199TestLanguage.g:601:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            {
            // InternalBug348199TestLanguage.g:601:1: ( ( rule__Timeperiod__UnorderedGroup_3_0_3 ) )
            // InternalBug348199TestLanguage.g:602:1: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()); 
            // InternalBug348199TestLanguage.g:603:1: ( rule__Timeperiod__UnorderedGroup_3_0_3 )
            // InternalBug348199TestLanguage.g:603:2: rule__Timeperiod__UnorderedGroup_3_0_3
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
    // InternalBug348199TestLanguage.g:613:1: rule__Timeperiod__Group_3_0__4 : rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 ;
    public final void rule__Timeperiod__Group_3_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:617:1: ( rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5 )
            // InternalBug348199TestLanguage.g:618:2: rule__Timeperiod__Group_3_0__4__Impl rule__Timeperiod__Group_3_0__5
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
    // InternalBug348199TestLanguage.g:625:1: rule__Timeperiod__Group_3_0__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:629:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:630:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:630:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:631:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:631:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:632:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:633:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:633:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 

            }

            // InternalBug348199TestLanguage.g:636:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:637:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4()); 
            // InternalBug348199TestLanguage.g:638:1: ( RULE_NL )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_NL) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:638:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:649:1: rule__Timeperiod__Group_3_0__5 : rule__Timeperiod__Group_3_0__5__Impl ;
    public final void rule__Timeperiod__Group_3_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:653:1: ( rule__Timeperiod__Group_3_0__5__Impl )
            // InternalBug348199TestLanguage.g:654:2: rule__Timeperiod__Group_3_0__5__Impl
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
    // InternalBug348199TestLanguage.g:660:1: rule__Timeperiod__Group_3_0__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:664:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:665:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:665:1: ( '}' )
            // InternalBug348199TestLanguage.g:666:1: '}'
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
    // InternalBug348199TestLanguage.g:691:1: rule__Timeperiod__Group_3_0_2__0 : rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 ;
    public final void rule__Timeperiod__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:695:1: ( rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1 )
            // InternalBug348199TestLanguage.g:696:2: rule__Timeperiod__Group_3_0_2__0__Impl rule__Timeperiod__Group_3_0_2__1
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
    // InternalBug348199TestLanguage.g:703:1: rule__Timeperiod__Group_3_0_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:707:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:708:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:708:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:709:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:709:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:710:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:711:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:711:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 

            }

            // InternalBug348199TestLanguage.g:714:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:715:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0()); 
            // InternalBug348199TestLanguage.g:716:1: ( RULE_NL )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:716:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:727:1: rule__Timeperiod__Group_3_0_2__1 : rule__Timeperiod__Group_3_0_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:731:1: ( rule__Timeperiod__Group_3_0_2__1__Impl )
            // InternalBug348199TestLanguage.g:732:2: rule__Timeperiod__Group_3_0_2__1__Impl
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
    // InternalBug348199TestLanguage.g:738:1: rule__Timeperiod__Group_3_0_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:742:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) ) )
            // InternalBug348199TestLanguage.g:743:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:743:1: ( ( rule__Timeperiod__TimeAssignment_3_0_2_1 ) )
            // InternalBug348199TestLanguage.g:744:1: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_2_1()); 
            // InternalBug348199TestLanguage.g:745:1: ( rule__Timeperiod__TimeAssignment_3_0_2_1 )
            // InternalBug348199TestLanguage.g:745:2: rule__Timeperiod__TimeAssignment_3_0_2_1
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
    // InternalBug348199TestLanguage.g:759:1: rule__Timeperiod__Group_3_0_3_0__0 : rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:763:1: ( rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1 )
            // InternalBug348199TestLanguage.g:764:2: rule__Timeperiod__Group_3_0_3_0__0__Impl rule__Timeperiod__Group_3_0_3_0__1
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
    // InternalBug348199TestLanguage.g:771:1: rule__Timeperiod__Group_3_0_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:775:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:776:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:776:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:777:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:777:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:778:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:779:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:779:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:782:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:783:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0()); 
            // InternalBug348199TestLanguage.g:784:1: ( RULE_NL )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:784:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:795:1: rule__Timeperiod__Group_3_0_3_0__1 : rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 ;
    public final void rule__Timeperiod__Group_3_0_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:799:1: ( rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2 )
            // InternalBug348199TestLanguage.g:800:2: rule__Timeperiod__Group_3_0_3_0__1__Impl rule__Timeperiod__Group_3_0_3_0__2
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
    // InternalBug348199TestLanguage.g:807:1: rule__Timeperiod__Group_3_0_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:811:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:812:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:812:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:813:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:826:1: rule__Timeperiod__Group_3_0_3_0__2 : rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 ;
    public final void rule__Timeperiod__Group_3_0_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:830:1: ( rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3 )
            // InternalBug348199TestLanguage.g:831:2: rule__Timeperiod__Group_3_0_3_0__2__Impl rule__Timeperiod__Group_3_0_3_0__3
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
    // InternalBug348199TestLanguage.g:838:1: rule__Timeperiod__Group_3_0_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:842:1: ( ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:843:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:843:1: ( ( rule__Timeperiod__NameAssignment_3_0_3_0_2 ) )
            // InternalBug348199TestLanguage.g:844:1: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_0_3_0_2()); 
            // InternalBug348199TestLanguage.g:845:1: ( rule__Timeperiod__NameAssignment_3_0_3_0_2 )
            // InternalBug348199TestLanguage.g:845:2: rule__Timeperiod__NameAssignment_3_0_3_0_2
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
    // InternalBug348199TestLanguage.g:855:1: rule__Timeperiod__Group_3_0_3_0__3 : rule__Timeperiod__Group_3_0_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:859:1: ( rule__Timeperiod__Group_3_0_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:860:2: rule__Timeperiod__Group_3_0_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:866:1: rule__Timeperiod__Group_3_0_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:870:1: ( ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:871:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:871:1: ( ( rule__Timeperiod__Group_3_0_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:872:1: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0_3()); 
            // InternalBug348199TestLanguage.g:873:1: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:873:2: rule__Timeperiod__Group_3_0_3_0_3__0
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
    // InternalBug348199TestLanguage.g:891:1: rule__Timeperiod__Group_3_0_3_0_3__0 : rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:895:1: ( rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1 )
            // InternalBug348199TestLanguage.g:896:2: rule__Timeperiod__Group_3_0_3_0_3__0__Impl rule__Timeperiod__Group_3_0_3_0_3__1
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
    // InternalBug348199TestLanguage.g:903:1: rule__Timeperiod__Group_3_0_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:907:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:908:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:908:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:909:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:909:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:910:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:911:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:911:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:914:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:915:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:916:1: ( RULE_NL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:916:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:927:1: rule__Timeperiod__Group_3_0_3_0_3__1 : rule__Timeperiod__Group_3_0_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:931:1: ( rule__Timeperiod__Group_3_0_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:932:2: rule__Timeperiod__Group_3_0_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:938:1: rule__Timeperiod__Group_3_0_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:942:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:943:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:943:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:944:1: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:945:1: ( rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 )
            // InternalBug348199TestLanguage.g:945:2: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1
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
    // InternalBug348199TestLanguage.g:959:1: rule__Timeperiod__Group_3_0_3_1__0 : rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:963:1: ( rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1 )
            // InternalBug348199TestLanguage.g:964:2: rule__Timeperiod__Group_3_0_3_1__0__Impl rule__Timeperiod__Group_3_0_3_1__1
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
    // InternalBug348199TestLanguage.g:971:1: rule__Timeperiod__Group_3_0_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:975:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:976:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:976:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:977:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:977:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:978:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:979:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:979:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:982:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:983:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0()); 
            // InternalBug348199TestLanguage.g:984:1: ( RULE_NL )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:984:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:995:1: rule__Timeperiod__Group_3_0_3_1__1 : rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 ;
    public final void rule__Timeperiod__Group_3_0_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:999:1: ( rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2 )
            // InternalBug348199TestLanguage.g:1000:2: rule__Timeperiod__Group_3_0_3_1__1__Impl rule__Timeperiod__Group_3_0_3_1__2
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
    // InternalBug348199TestLanguage.g:1007:1: rule__Timeperiod__Group_3_0_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1011:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:1012:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:1012:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:1013:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:1026:1: rule__Timeperiod__Group_3_0_3_1__2 : rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 ;
    public final void rule__Timeperiod__Group_3_0_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1030:1: ( rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3 )
            // InternalBug348199TestLanguage.g:1031:2: rule__Timeperiod__Group_3_0_3_1__2__Impl rule__Timeperiod__Group_3_0_3_1__3
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
    // InternalBug348199TestLanguage.g:1038:1: rule__Timeperiod__Group_3_0_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1042:1: ( ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:1043:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:1043:1: ( ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 ) )
            // InternalBug348199TestLanguage.g:1044:1: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_0_3_1_2()); 
            // InternalBug348199TestLanguage.g:1045:1: ( rule__Timeperiod__AliasAssignment_3_0_3_1_2 )
            // InternalBug348199TestLanguage.g:1045:2: rule__Timeperiod__AliasAssignment_3_0_3_1_2
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
    // InternalBug348199TestLanguage.g:1055:1: rule__Timeperiod__Group_3_0_3_1__3 : rule__Timeperiod__Group_3_0_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1059:1: ( rule__Timeperiod__Group_3_0_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:1060:2: rule__Timeperiod__Group_3_0_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:1066:1: rule__Timeperiod__Group_3_0_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_0_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1070:1: ( ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1071:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1071:1: ( ( rule__Timeperiod__Group_3_0_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:1072:1: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1_3()); 
            // InternalBug348199TestLanguage.g:1073:1: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1073:2: rule__Timeperiod__Group_3_0_3_1_3__0
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
    // InternalBug348199TestLanguage.g:1091:1: rule__Timeperiod__Group_3_0_3_1_3__0 : rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1095:1: ( rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1 )
            // InternalBug348199TestLanguage.g:1096:2: rule__Timeperiod__Group_3_0_3_1_3__0__Impl rule__Timeperiod__Group_3_0_3_1_3__1
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
    // InternalBug348199TestLanguage.g:1103:1: rule__Timeperiod__Group_3_0_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1107:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1108:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1108:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1109:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1109:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1110:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1111:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1111:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1114:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1115:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1116:1: ( RULE_NL )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1116:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1127:1: rule__Timeperiod__Group_3_0_3_1_3__1 : rule__Timeperiod__Group_3_0_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1131:1: ( rule__Timeperiod__Group_3_0_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1132:2: rule__Timeperiod__Group_3_0_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1138:1: rule__Timeperiod__Group_3_0_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_0_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1142:1: ( ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1143:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1143:1: ( ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1144:1: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1145:1: ( rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1145:2: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1
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
    // InternalBug348199TestLanguage.g:1159:1: rule__Timeperiod__Group_3_1__0 : rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1163:1: ( rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1 )
            // InternalBug348199TestLanguage.g:1164:2: rule__Timeperiod__Group_3_1__0__Impl rule__Timeperiod__Group_3_1__1
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
    // InternalBug348199TestLanguage.g:1171:1: rule__Timeperiod__Group_3_1__0__Impl : ( '2' ) ;
    public final void rule__Timeperiod__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1175:1: ( ( '2' ) )
            // InternalBug348199TestLanguage.g:1176:1: ( '2' )
            {
            // InternalBug348199TestLanguage.g:1176:1: ( '2' )
            // InternalBug348199TestLanguage.g:1177:1: '2'
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
    // InternalBug348199TestLanguage.g:1190:1: rule__Timeperiod__Group_3_1__1 : rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1194:1: ( rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2 )
            // InternalBug348199TestLanguage.g:1195:2: rule__Timeperiod__Group_3_1__1__Impl rule__Timeperiod__Group_3_1__2
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
    // InternalBug348199TestLanguage.g:1202:1: rule__Timeperiod__Group_3_1__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1206:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1207:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1207:1: ( '{' )
            // InternalBug348199TestLanguage.g:1208:1: '{'
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
    // InternalBug348199TestLanguage.g:1221:1: rule__Timeperiod__Group_3_1__2 : rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1225:1: ( rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3 )
            // InternalBug348199TestLanguage.g:1226:2: rule__Timeperiod__Group_3_1__2__Impl rule__Timeperiod__Group_3_1__3
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
    // InternalBug348199TestLanguage.g:1233:1: rule__Timeperiod__Group_3_1__2__Impl : ( ( rule__Timeperiod__Group_3_1_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1237:1: ( ( ( rule__Timeperiod__Group_3_1_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1238:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1238:1: ( ( rule__Timeperiod__Group_3_1_2__0 )* )
            // InternalBug348199TestLanguage.g:1239:1: ( rule__Timeperiod__Group_3_1_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_2()); 
            // InternalBug348199TestLanguage.g:1240:1: ( rule__Timeperiod__Group_3_1_2__0 )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1240:2: rule__Timeperiod__Group_3_1_2__0
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
    // InternalBug348199TestLanguage.g:1250:1: rule__Timeperiod__Group_3_1__3 : rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 ;
    public final void rule__Timeperiod__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1254:1: ( rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4 )
            // InternalBug348199TestLanguage.g:1255:2: rule__Timeperiod__Group_3_1__3__Impl rule__Timeperiod__Group_3_1__4
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
    // InternalBug348199TestLanguage.g:1262:1: rule__Timeperiod__Group_3_1__3__Impl : ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) ;
    public final void rule__Timeperiod__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1266:1: ( ( ( rule__Timeperiod__Alternatives_3_1_3 ) ) )
            // InternalBug348199TestLanguage.g:1267:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            {
            // InternalBug348199TestLanguage.g:1267:1: ( ( rule__Timeperiod__Alternatives_3_1_3 ) )
            // InternalBug348199TestLanguage.g:1268:1: ( rule__Timeperiod__Alternatives_3_1_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_1_3()); 
            // InternalBug348199TestLanguage.g:1269:1: ( rule__Timeperiod__Alternatives_3_1_3 )
            // InternalBug348199TestLanguage.g:1269:2: rule__Timeperiod__Alternatives_3_1_3
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
    // InternalBug348199TestLanguage.g:1279:1: rule__Timeperiod__Group_3_1__4 : rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 ;
    public final void rule__Timeperiod__Group_3_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1283:1: ( rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5 )
            // InternalBug348199TestLanguage.g:1284:2: rule__Timeperiod__Group_3_1__4__Impl rule__Timeperiod__Group_3_1__5
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
    // InternalBug348199TestLanguage.g:1291:1: rule__Timeperiod__Group_3_1__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1295:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1296:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1296:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1297:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1297:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1298:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1299:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1299:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 

            }

            // InternalBug348199TestLanguage.g:1302:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1303:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4()); 
            // InternalBug348199TestLanguage.g:1304:1: ( RULE_NL )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NL) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1304:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1315:1: rule__Timeperiod__Group_3_1__5 : rule__Timeperiod__Group_3_1__5__Impl ;
    public final void rule__Timeperiod__Group_3_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1319:1: ( rule__Timeperiod__Group_3_1__5__Impl )
            // InternalBug348199TestLanguage.g:1320:2: rule__Timeperiod__Group_3_1__5__Impl
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
    // InternalBug348199TestLanguage.g:1326:1: rule__Timeperiod__Group_3_1__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1330:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:1331:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:1331:1: ( '}' )
            // InternalBug348199TestLanguage.g:1332:1: '}'
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
    // InternalBug348199TestLanguage.g:1357:1: rule__Timeperiod__Group_3_1_2__0 : rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 ;
    public final void rule__Timeperiod__Group_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1361:1: ( rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1 )
            // InternalBug348199TestLanguage.g:1362:2: rule__Timeperiod__Group_3_1_2__0__Impl rule__Timeperiod__Group_3_1_2__1
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
    // InternalBug348199TestLanguage.g:1369:1: rule__Timeperiod__Group_3_1_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1373:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1374:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1374:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1375:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1375:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1376:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1377:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1377:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 

            }

            // InternalBug348199TestLanguage.g:1380:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1381:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0()); 
            // InternalBug348199TestLanguage.g:1382:1: ( RULE_NL )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NL) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1382:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1393:1: rule__Timeperiod__Group_3_1_2__1 : rule__Timeperiod__Group_3_1_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1397:1: ( rule__Timeperiod__Group_3_1_2__1__Impl )
            // InternalBug348199TestLanguage.g:1398:2: rule__Timeperiod__Group_3_1_2__1__Impl
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
    // InternalBug348199TestLanguage.g:1404:1: rule__Timeperiod__Group_3_1_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1408:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) ) )
            // InternalBug348199TestLanguage.g:1409:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:1409:1: ( ( rule__Timeperiod__TimeAssignment_3_1_2_1 ) )
            // InternalBug348199TestLanguage.g:1410:1: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_2_1()); 
            // InternalBug348199TestLanguage.g:1411:1: ( rule__Timeperiod__TimeAssignment_3_1_2_1 )
            // InternalBug348199TestLanguage.g:1411:2: rule__Timeperiod__TimeAssignment_3_1_2_1
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
    // InternalBug348199TestLanguage.g:1425:1: rule__Timeperiod__Group_3_1_3_0__0 : rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1429:1: ( rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1 )
            // InternalBug348199TestLanguage.g:1430:2: rule__Timeperiod__Group_3_1_3_0__0__Impl rule__Timeperiod__Group_3_1_3_0__1
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
    // InternalBug348199TestLanguage.g:1437:1: rule__Timeperiod__Group_3_1_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1441:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1442:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1442:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1443:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1443:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1444:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1445:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1445:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:1448:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1449:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0()); 
            // InternalBug348199TestLanguage.g:1450:1: ( RULE_NL )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NL) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1450:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1461:1: rule__Timeperiod__Group_3_1_3_0__1 : rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 ;
    public final void rule__Timeperiod__Group_3_1_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1465:1: ( rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2 )
            // InternalBug348199TestLanguage.g:1466:2: rule__Timeperiod__Group_3_1_3_0__1__Impl rule__Timeperiod__Group_3_1_3_0__2
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
    // InternalBug348199TestLanguage.g:1473:1: rule__Timeperiod__Group_3_1_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1477:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:1478:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:1478:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:1479:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:1492:1: rule__Timeperiod__Group_3_1_3_0__2 : rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 ;
    public final void rule__Timeperiod__Group_3_1_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1496:1: ( rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3 )
            // InternalBug348199TestLanguage.g:1497:2: rule__Timeperiod__Group_3_1_3_0__2__Impl rule__Timeperiod__Group_3_1_3_0__3
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
    // InternalBug348199TestLanguage.g:1504:1: rule__Timeperiod__Group_3_1_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1508:1: ( ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:1509:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:1509:1: ( ( rule__Timeperiod__NameAssignment_3_1_3_0_2 ) )
            // InternalBug348199TestLanguage.g:1510:1: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_1_3_0_2()); 
            // InternalBug348199TestLanguage.g:1511:1: ( rule__Timeperiod__NameAssignment_3_1_3_0_2 )
            // InternalBug348199TestLanguage.g:1511:2: rule__Timeperiod__NameAssignment_3_1_3_0_2
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
    // InternalBug348199TestLanguage.g:1521:1: rule__Timeperiod__Group_3_1_3_0__3 : rule__Timeperiod__Group_3_1_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1525:1: ( rule__Timeperiod__Group_3_1_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:1526:2: rule__Timeperiod__Group_3_1_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:1532:1: rule__Timeperiod__Group_3_1_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1536:1: ( ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1537:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1537:1: ( ( rule__Timeperiod__Group_3_1_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:1538:1: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0_3()); 
            // InternalBug348199TestLanguage.g:1539:1: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1539:2: rule__Timeperiod__Group_3_1_3_0_3__0
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
    // InternalBug348199TestLanguage.g:1557:1: rule__Timeperiod__Group_3_1_3_0_3__0 : rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1561:1: ( rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1 )
            // InternalBug348199TestLanguage.g:1562:2: rule__Timeperiod__Group_3_1_3_0_3__0__Impl rule__Timeperiod__Group_3_1_3_0_3__1
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
    // InternalBug348199TestLanguage.g:1569:1: rule__Timeperiod__Group_3_1_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1573:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1574:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1574:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1575:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1575:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1576:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1577:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1577:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1580:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1581:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:1582:1: ( RULE_NL )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1582:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1593:1: rule__Timeperiod__Group_3_1_3_0_3__1 : rule__Timeperiod__Group_3_1_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1597:1: ( rule__Timeperiod__Group_3_1_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:1598:2: rule__Timeperiod__Group_3_1_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1604:1: rule__Timeperiod__Group_3_1_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1608:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1609:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1609:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:1610:1: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:1611:1: ( rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 )
            // InternalBug348199TestLanguage.g:1611:2: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1
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
    // InternalBug348199TestLanguage.g:1625:1: rule__Timeperiod__Group_3_1_3_1__0 : rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1629:1: ( rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1 )
            // InternalBug348199TestLanguage.g:1630:2: rule__Timeperiod__Group_3_1_3_1__0__Impl rule__Timeperiod__Group_3_1_3_1__1
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
    // InternalBug348199TestLanguage.g:1637:1: rule__Timeperiod__Group_3_1_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1641:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1642:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1642:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1643:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1643:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1644:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1645:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1645:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:1648:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1649:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0()); 
            // InternalBug348199TestLanguage.g:1650:1: ( RULE_NL )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NL) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1650:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1661:1: rule__Timeperiod__Group_3_1_3_1__1 : rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 ;
    public final void rule__Timeperiod__Group_3_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1665:1: ( rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2 )
            // InternalBug348199TestLanguage.g:1666:2: rule__Timeperiod__Group_3_1_3_1__1__Impl rule__Timeperiod__Group_3_1_3_1__2
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
    // InternalBug348199TestLanguage.g:1673:1: rule__Timeperiod__Group_3_1_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1677:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:1678:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:1678:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:1679:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:1692:1: rule__Timeperiod__Group_3_1_3_1__2 : rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 ;
    public final void rule__Timeperiod__Group_3_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1696:1: ( rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3 )
            // InternalBug348199TestLanguage.g:1697:2: rule__Timeperiod__Group_3_1_3_1__2__Impl rule__Timeperiod__Group_3_1_3_1__3
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
    // InternalBug348199TestLanguage.g:1704:1: rule__Timeperiod__Group_3_1_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1708:1: ( ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:1709:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:1709:1: ( ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 ) )
            // InternalBug348199TestLanguage.g:1710:1: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_1_3_1_2()); 
            // InternalBug348199TestLanguage.g:1711:1: ( rule__Timeperiod__AliasAssignment_3_1_3_1_2 )
            // InternalBug348199TestLanguage.g:1711:2: rule__Timeperiod__AliasAssignment_3_1_3_1_2
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
    // InternalBug348199TestLanguage.g:1721:1: rule__Timeperiod__Group_3_1_3_1__3 : rule__Timeperiod__Group_3_1_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1725:1: ( rule__Timeperiod__Group_3_1_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:1726:2: rule__Timeperiod__Group_3_1_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:1732:1: rule__Timeperiod__Group_3_1_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_1_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1736:1: ( ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:1737:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:1737:1: ( ( rule__Timeperiod__Group_3_1_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:1738:1: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1_3()); 
            // InternalBug348199TestLanguage.g:1739:1: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1739:2: rule__Timeperiod__Group_3_1_3_1_3__0
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
    // InternalBug348199TestLanguage.g:1757:1: rule__Timeperiod__Group_3_1_3_1_3__0 : rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1761:1: ( rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1 )
            // InternalBug348199TestLanguage.g:1762:2: rule__Timeperiod__Group_3_1_3_1_3__0__Impl rule__Timeperiod__Group_3_1_3_1_3__1
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
    // InternalBug348199TestLanguage.g:1769:1: rule__Timeperiod__Group_3_1_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1773:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1774:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1774:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1775:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1775:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1776:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1777:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1777:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:1780:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1781:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:1782:1: ( RULE_NL )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_NL) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1782:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1793:1: rule__Timeperiod__Group_3_1_3_1_3__1 : rule__Timeperiod__Group_3_1_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1797:1: ( rule__Timeperiod__Group_3_1_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:1798:2: rule__Timeperiod__Group_3_1_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:1804:1: rule__Timeperiod__Group_3_1_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_1_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1808:1: ( ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:1809:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:1809:1: ( ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:1810:1: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:1811:1: ( rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 )
            // InternalBug348199TestLanguage.g:1811:2: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1
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
    // InternalBug348199TestLanguage.g:1825:1: rule__Timeperiod__Group_3_2__0 : rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 ;
    public final void rule__Timeperiod__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1829:1: ( rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1 )
            // InternalBug348199TestLanguage.g:1830:2: rule__Timeperiod__Group_3_2__0__Impl rule__Timeperiod__Group_3_2__1
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
    // InternalBug348199TestLanguage.g:1837:1: rule__Timeperiod__Group_3_2__0__Impl : ( '3' ) ;
    public final void rule__Timeperiod__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1841:1: ( ( '3' ) )
            // InternalBug348199TestLanguage.g:1842:1: ( '3' )
            {
            // InternalBug348199TestLanguage.g:1842:1: ( '3' )
            // InternalBug348199TestLanguage.g:1843:1: '3'
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
    // InternalBug348199TestLanguage.g:1856:1: rule__Timeperiod__Group_3_2__1 : rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 ;
    public final void rule__Timeperiod__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1860:1: ( rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2 )
            // InternalBug348199TestLanguage.g:1861:2: rule__Timeperiod__Group_3_2__1__Impl rule__Timeperiod__Group_3_2__2
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
    // InternalBug348199TestLanguage.g:1868:1: rule__Timeperiod__Group_3_2__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1872:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:1873:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:1873:1: ( '{' )
            // InternalBug348199TestLanguage.g:1874:1: '{'
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
    // InternalBug348199TestLanguage.g:1887:1: rule__Timeperiod__Group_3_2__2 : rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 ;
    public final void rule__Timeperiod__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1891:1: ( rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3 )
            // InternalBug348199TestLanguage.g:1892:2: rule__Timeperiod__Group_3_2__2__Impl rule__Timeperiod__Group_3_2__3
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
    // InternalBug348199TestLanguage.g:1899:1: rule__Timeperiod__Group_3_2__2__Impl : ( ( rule__Timeperiod__Group_3_2_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1903:1: ( ( ( rule__Timeperiod__Group_3_2_2__0 )* ) )
            // InternalBug348199TestLanguage.g:1904:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:1904:1: ( ( rule__Timeperiod__Group_3_2_2__0 )* )
            // InternalBug348199TestLanguage.g:1905:1: ( rule__Timeperiod__Group_3_2_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_2()); 
            // InternalBug348199TestLanguage.g:1906:1: ( rule__Timeperiod__Group_3_2_2__0 )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1906:2: rule__Timeperiod__Group_3_2_2__0
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
    // InternalBug348199TestLanguage.g:1916:1: rule__Timeperiod__Group_3_2__3 : rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 ;
    public final void rule__Timeperiod__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1920:1: ( rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4 )
            // InternalBug348199TestLanguage.g:1921:2: rule__Timeperiod__Group_3_2__3__Impl rule__Timeperiod__Group_3_2__4
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
    // InternalBug348199TestLanguage.g:1928:1: rule__Timeperiod__Group_3_2__3__Impl : ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1932:1: ( ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) ) )
            // InternalBug348199TestLanguage.g:1933:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            {
            // InternalBug348199TestLanguage.g:1933:1: ( ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* ) )
            // InternalBug348199TestLanguage.g:1934:1: ( ( rule__Timeperiod__Alternatives_3_2_3 ) ) ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            {
            // InternalBug348199TestLanguage.g:1934:1: ( ( rule__Timeperiod__Alternatives_3_2_3 ) )
            // InternalBug348199TestLanguage.g:1935:1: ( rule__Timeperiod__Alternatives_3_2_3 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1936:1: ( rule__Timeperiod__Alternatives_3_2_3 )
            // InternalBug348199TestLanguage.g:1936:2: rule__Timeperiod__Alternatives_3_2_3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__Alternatives_3_2_3();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 

            }

            // InternalBug348199TestLanguage.g:1939:1: ( ( rule__Timeperiod__Alternatives_3_2_3 )* )
            // InternalBug348199TestLanguage.g:1940:1: ( rule__Timeperiod__Alternatives_3_2_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3()); 
            // InternalBug348199TestLanguage.g:1941:1: ( rule__Timeperiod__Alternatives_3_2_3 )*
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1941:2: rule__Timeperiod__Alternatives_3_2_3
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
    // InternalBug348199TestLanguage.g:1952:1: rule__Timeperiod__Group_3_2__4 : rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 ;
    public final void rule__Timeperiod__Group_3_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1956:1: ( rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5 )
            // InternalBug348199TestLanguage.g:1957:2: rule__Timeperiod__Group_3_2__4__Impl rule__Timeperiod__Group_3_2__5
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
    // InternalBug348199TestLanguage.g:1964:1: rule__Timeperiod__Group_3_2__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1968:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:1969:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:1969:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:1970:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:1970:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:1971:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1972:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:1972:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 

            }

            // InternalBug348199TestLanguage.g:1975:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:1976:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4()); 
            // InternalBug348199TestLanguage.g:1977:1: ( RULE_NL )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_NL) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:1977:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:1988:1: rule__Timeperiod__Group_3_2__5 : rule__Timeperiod__Group_3_2__5__Impl ;
    public final void rule__Timeperiod__Group_3_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:1992:1: ( rule__Timeperiod__Group_3_2__5__Impl )
            // InternalBug348199TestLanguage.g:1993:2: rule__Timeperiod__Group_3_2__5__Impl
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
    // InternalBug348199TestLanguage.g:1999:1: rule__Timeperiod__Group_3_2__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2003:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2004:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2004:1: ( '}' )
            // InternalBug348199TestLanguage.g:2005:1: '}'
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
    // InternalBug348199TestLanguage.g:2030:1: rule__Timeperiod__Group_3_2_2__0 : rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 ;
    public final void rule__Timeperiod__Group_3_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2034:1: ( rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1 )
            // InternalBug348199TestLanguage.g:2035:2: rule__Timeperiod__Group_3_2_2__0__Impl rule__Timeperiod__Group_3_2_2__1
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
    // InternalBug348199TestLanguage.g:2042:1: rule__Timeperiod__Group_3_2_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2046:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2047:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2047:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2048:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2048:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2049:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:2050:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2050:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 

            }

            // InternalBug348199TestLanguage.g:2053:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2054:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0()); 
            // InternalBug348199TestLanguage.g:2055:1: ( RULE_NL )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_NL) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2055:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2066:1: rule__Timeperiod__Group_3_2_2__1 : rule__Timeperiod__Group_3_2_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2070:1: ( rule__Timeperiod__Group_3_2_2__1__Impl )
            // InternalBug348199TestLanguage.g:2071:2: rule__Timeperiod__Group_3_2_2__1__Impl
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
    // InternalBug348199TestLanguage.g:2077:1: rule__Timeperiod__Group_3_2_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2081:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) ) )
            // InternalBug348199TestLanguage.g:2082:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:2082:1: ( ( rule__Timeperiod__TimeAssignment_3_2_2_1 ) )
            // InternalBug348199TestLanguage.g:2083:1: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_2_1()); 
            // InternalBug348199TestLanguage.g:2084:1: ( rule__Timeperiod__TimeAssignment_3_2_2_1 )
            // InternalBug348199TestLanguage.g:2084:2: rule__Timeperiod__TimeAssignment_3_2_2_1
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
    // InternalBug348199TestLanguage.g:2098:1: rule__Timeperiod__Group_3_2_3_0__0 : rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2102:1: ( rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1 )
            // InternalBug348199TestLanguage.g:2103:2: rule__Timeperiod__Group_3_2_3_0__0__Impl rule__Timeperiod__Group_3_2_3_0__1
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
    // InternalBug348199TestLanguage.g:2110:1: rule__Timeperiod__Group_3_2_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2114:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2115:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2115:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2116:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2116:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2117:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:2118:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2118:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:2121:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2122:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0()); 
            // InternalBug348199TestLanguage.g:2123:1: ( RULE_NL )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_NL) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2123:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2134:1: rule__Timeperiod__Group_3_2_3_0__1 : rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 ;
    public final void rule__Timeperiod__Group_3_2_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2138:1: ( rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2 )
            // InternalBug348199TestLanguage.g:2139:2: rule__Timeperiod__Group_3_2_3_0__1__Impl rule__Timeperiod__Group_3_2_3_0__2
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
    // InternalBug348199TestLanguage.g:2146:1: rule__Timeperiod__Group_3_2_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2150:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:2151:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:2151:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:2152:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:2165:1: rule__Timeperiod__Group_3_2_3_0__2 : rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 ;
    public final void rule__Timeperiod__Group_3_2_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2169:1: ( rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3 )
            // InternalBug348199TestLanguage.g:2170:2: rule__Timeperiod__Group_3_2_3_0__2__Impl rule__Timeperiod__Group_3_2_3_0__3
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
    // InternalBug348199TestLanguage.g:2177:1: rule__Timeperiod__Group_3_2_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2181:1: ( ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:2182:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:2182:1: ( ( rule__Timeperiod__NameAssignment_3_2_3_0_2 ) )
            // InternalBug348199TestLanguage.g:2183:1: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_2_3_0_2()); 
            // InternalBug348199TestLanguage.g:2184:1: ( rule__Timeperiod__NameAssignment_3_2_3_0_2 )
            // InternalBug348199TestLanguage.g:2184:2: rule__Timeperiod__NameAssignment_3_2_3_0_2
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
    // InternalBug348199TestLanguage.g:2194:1: rule__Timeperiod__Group_3_2_3_0__3 : rule__Timeperiod__Group_3_2_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2198:1: ( rule__Timeperiod__Group_3_2_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:2199:2: rule__Timeperiod__Group_3_2_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:2205:1: rule__Timeperiod__Group_3_2_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2209:1: ( ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2210:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2210:1: ( ( rule__Timeperiod__Group_3_2_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:2211:1: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0_3()); 
            // InternalBug348199TestLanguage.g:2212:1: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2212:2: rule__Timeperiod__Group_3_2_3_0_3__0
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
    // InternalBug348199TestLanguage.g:2230:1: rule__Timeperiod__Group_3_2_3_0_3__0 : rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2234:1: ( rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1 )
            // InternalBug348199TestLanguage.g:2235:2: rule__Timeperiod__Group_3_2_3_0_3__0__Impl rule__Timeperiod__Group_3_2_3_0_3__1
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
    // InternalBug348199TestLanguage.g:2242:1: rule__Timeperiod__Group_3_2_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2246:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2247:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2247:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2248:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2248:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2249:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2250:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2250:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2253:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2254:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2255:1: ( RULE_NL )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NL) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2255:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2266:1: rule__Timeperiod__Group_3_2_3_0_3__1 : rule__Timeperiod__Group_3_2_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2270:1: ( rule__Timeperiod__Group_3_2_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:2271:2: rule__Timeperiod__Group_3_2_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2277:1: rule__Timeperiod__Group_3_2_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2281:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2282:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2282:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2283:1: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2284:1: ( rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2284:2: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1
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
    // InternalBug348199TestLanguage.g:2298:1: rule__Timeperiod__Group_3_2_3_1__0 : rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2302:1: ( rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1 )
            // InternalBug348199TestLanguage.g:2303:2: rule__Timeperiod__Group_3_2_3_1__0__Impl rule__Timeperiod__Group_3_2_3_1__1
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
    // InternalBug348199TestLanguage.g:2310:1: rule__Timeperiod__Group_3_2_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2314:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2315:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2315:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2316:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2316:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2317:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2318:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2318:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2321:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2322:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0()); 
            // InternalBug348199TestLanguage.g:2323:1: ( RULE_NL )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_NL) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2323:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2334:1: rule__Timeperiod__Group_3_2_3_1__1 : rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 ;
    public final void rule__Timeperiod__Group_3_2_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2338:1: ( rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2 )
            // InternalBug348199TestLanguage.g:2339:2: rule__Timeperiod__Group_3_2_3_1__1__Impl rule__Timeperiod__Group_3_2_3_1__2
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
    // InternalBug348199TestLanguage.g:2346:1: rule__Timeperiod__Group_3_2_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2350:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:2351:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:2351:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:2352:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:2365:1: rule__Timeperiod__Group_3_2_3_1__2 : rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 ;
    public final void rule__Timeperiod__Group_3_2_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2369:1: ( rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3 )
            // InternalBug348199TestLanguage.g:2370:2: rule__Timeperiod__Group_3_2_3_1__2__Impl rule__Timeperiod__Group_3_2_3_1__3
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
    // InternalBug348199TestLanguage.g:2377:1: rule__Timeperiod__Group_3_2_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2381:1: ( ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:2382:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:2382:1: ( ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 ) )
            // InternalBug348199TestLanguage.g:2383:1: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_2_3_1_2()); 
            // InternalBug348199TestLanguage.g:2384:1: ( rule__Timeperiod__AliasAssignment_3_2_3_1_2 )
            // InternalBug348199TestLanguage.g:2384:2: rule__Timeperiod__AliasAssignment_3_2_3_1_2
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
    // InternalBug348199TestLanguage.g:2394:1: rule__Timeperiod__Group_3_2_3_1__3 : rule__Timeperiod__Group_3_2_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2398:1: ( rule__Timeperiod__Group_3_2_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:2399:2: rule__Timeperiod__Group_3_2_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:2405:1: rule__Timeperiod__Group_3_2_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_2_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2409:1: ( ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2410:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2410:1: ( ( rule__Timeperiod__Group_3_2_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:2411:1: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1_3()); 
            // InternalBug348199TestLanguage.g:2412:1: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2412:2: rule__Timeperiod__Group_3_2_3_1_3__0
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
    // InternalBug348199TestLanguage.g:2430:1: rule__Timeperiod__Group_3_2_3_1_3__0 : rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2434:1: ( rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1 )
            // InternalBug348199TestLanguage.g:2435:2: rule__Timeperiod__Group_3_2_3_1_3__0__Impl rule__Timeperiod__Group_3_2_3_1_3__1
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
    // InternalBug348199TestLanguage.g:2442:1: rule__Timeperiod__Group_3_2_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2446:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2447:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2447:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2448:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2448:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2449:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2450:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2450:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2453:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2454:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:2455:1: ( RULE_NL )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2455:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2466:1: rule__Timeperiod__Group_3_2_3_1_3__1 : rule__Timeperiod__Group_3_2_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2470:1: ( rule__Timeperiod__Group_3_2_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:2471:2: rule__Timeperiod__Group_3_2_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2477:1: rule__Timeperiod__Group_3_2_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_2_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2481:1: ( ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2482:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2482:1: ( ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:2483:1: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:2484:1: ( rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 )
            // InternalBug348199TestLanguage.g:2484:2: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1
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
    // InternalBug348199TestLanguage.g:2498:1: rule__Timeperiod__Group_3_3__0 : rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 ;
    public final void rule__Timeperiod__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2502:1: ( rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1 )
            // InternalBug348199TestLanguage.g:2503:2: rule__Timeperiod__Group_3_3__0__Impl rule__Timeperiod__Group_3_3__1
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
    // InternalBug348199TestLanguage.g:2510:1: rule__Timeperiod__Group_3_3__0__Impl : ( '4' ) ;
    public final void rule__Timeperiod__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2514:1: ( ( '4' ) )
            // InternalBug348199TestLanguage.g:2515:1: ( '4' )
            {
            // InternalBug348199TestLanguage.g:2515:1: ( '4' )
            // InternalBug348199TestLanguage.g:2516:1: '4'
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
    // InternalBug348199TestLanguage.g:2529:1: rule__Timeperiod__Group_3_3__1 : rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 ;
    public final void rule__Timeperiod__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2533:1: ( rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2 )
            // InternalBug348199TestLanguage.g:2534:2: rule__Timeperiod__Group_3_3__1__Impl rule__Timeperiod__Group_3_3__2
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
    // InternalBug348199TestLanguage.g:2541:1: rule__Timeperiod__Group_3_3__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2545:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:2546:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:2546:1: ( '{' )
            // InternalBug348199TestLanguage.g:2547:1: '{'
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
    // InternalBug348199TestLanguage.g:2560:1: rule__Timeperiod__Group_3_3__2 : rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 ;
    public final void rule__Timeperiod__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2564:1: ( rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3 )
            // InternalBug348199TestLanguage.g:2565:2: rule__Timeperiod__Group_3_3__2__Impl rule__Timeperiod__Group_3_3__3
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
    // InternalBug348199TestLanguage.g:2572:1: rule__Timeperiod__Group_3_3__2__Impl : ( ( rule__Timeperiod__Group_3_3_2__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2576:1: ( ( ( rule__Timeperiod__Group_3_3_2__0 )* ) )
            // InternalBug348199TestLanguage.g:2577:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            {
            // InternalBug348199TestLanguage.g:2577:1: ( ( rule__Timeperiod__Group_3_3_2__0 )* )
            // InternalBug348199TestLanguage.g:2578:1: ( rule__Timeperiod__Group_3_3_2__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_2()); 
            // InternalBug348199TestLanguage.g:2579:1: ( rule__Timeperiod__Group_3_3_2__0 )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2579:2: rule__Timeperiod__Group_3_3_2__0
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
    // InternalBug348199TestLanguage.g:2589:1: rule__Timeperiod__Group_3_3__3 : rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 ;
    public final void rule__Timeperiod__Group_3_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2593:1: ( rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4 )
            // InternalBug348199TestLanguage.g:2594:2: rule__Timeperiod__Group_3_3__3__Impl rule__Timeperiod__Group_3_3__4
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
    // InternalBug348199TestLanguage.g:2601:1: rule__Timeperiod__Group_3_3__3__Impl : ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) ;
    public final void rule__Timeperiod__Group_3_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2605:1: ( ( ( rule__Timeperiod__Alternatives_3_3_3 )* ) )
            // InternalBug348199TestLanguage.g:2606:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            {
            // InternalBug348199TestLanguage.g:2606:1: ( ( rule__Timeperiod__Alternatives_3_3_3 )* )
            // InternalBug348199TestLanguage.g:2607:1: ( rule__Timeperiod__Alternatives_3_3_3 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_3_3()); 
            // InternalBug348199TestLanguage.g:2608:1: ( rule__Timeperiod__Alternatives_3_3_3 )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2608:2: rule__Timeperiod__Alternatives_3_3_3
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
    // InternalBug348199TestLanguage.g:2618:1: rule__Timeperiod__Group_3_3__4 : rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 ;
    public final void rule__Timeperiod__Group_3_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2622:1: ( rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5 )
            // InternalBug348199TestLanguage.g:2623:2: rule__Timeperiod__Group_3_3__4__Impl rule__Timeperiod__Group_3_3__5
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
    // InternalBug348199TestLanguage.g:2630:1: rule__Timeperiod__Group_3_3__4__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2634:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2635:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2635:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2636:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2636:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2637:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2638:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2638:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 

            }

            // InternalBug348199TestLanguage.g:2641:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2642:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4()); 
            // InternalBug348199TestLanguage.g:2643:1: ( RULE_NL )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2643:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2654:1: rule__Timeperiod__Group_3_3__5 : rule__Timeperiod__Group_3_3__5__Impl ;
    public final void rule__Timeperiod__Group_3_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2658:1: ( rule__Timeperiod__Group_3_3__5__Impl )
            // InternalBug348199TestLanguage.g:2659:2: rule__Timeperiod__Group_3_3__5__Impl
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
    // InternalBug348199TestLanguage.g:2665:1: rule__Timeperiod__Group_3_3__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2669:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:2670:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:2670:1: ( '}' )
            // InternalBug348199TestLanguage.g:2671:1: '}'
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
    // InternalBug348199TestLanguage.g:2696:1: rule__Timeperiod__Group_3_3_2__0 : rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 ;
    public final void rule__Timeperiod__Group_3_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2700:1: ( rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1 )
            // InternalBug348199TestLanguage.g:2701:2: rule__Timeperiod__Group_3_3_2__0__Impl rule__Timeperiod__Group_3_3_2__1
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
    // InternalBug348199TestLanguage.g:2708:1: rule__Timeperiod__Group_3_3_2__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2712:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2713:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2713:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2714:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2714:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2715:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2716:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2716:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 

            }

            // InternalBug348199TestLanguage.g:2719:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2720:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0()); 
            // InternalBug348199TestLanguage.g:2721:1: ( RULE_NL )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_NL) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2721:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2732:1: rule__Timeperiod__Group_3_3_2__1 : rule__Timeperiod__Group_3_3_2__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2736:1: ( rule__Timeperiod__Group_3_3_2__1__Impl )
            // InternalBug348199TestLanguage.g:2737:2: rule__Timeperiod__Group_3_3_2__1__Impl
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
    // InternalBug348199TestLanguage.g:2743:1: rule__Timeperiod__Group_3_3_2__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2747:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) ) )
            // InternalBug348199TestLanguage.g:2748:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            {
            // InternalBug348199TestLanguage.g:2748:1: ( ( rule__Timeperiod__TimeAssignment_3_3_2_1 ) )
            // InternalBug348199TestLanguage.g:2749:1: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_2_1()); 
            // InternalBug348199TestLanguage.g:2750:1: ( rule__Timeperiod__TimeAssignment_3_3_2_1 )
            // InternalBug348199TestLanguage.g:2750:2: rule__Timeperiod__TimeAssignment_3_3_2_1
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
    // InternalBug348199TestLanguage.g:2764:1: rule__Timeperiod__Group_3_3_3_0__0 : rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2768:1: ( rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1 )
            // InternalBug348199TestLanguage.g:2769:2: rule__Timeperiod__Group_3_3_3_0__0__Impl rule__Timeperiod__Group_3_3_3_0__1
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
    // InternalBug348199TestLanguage.g:2776:1: rule__Timeperiod__Group_3_3_3_0__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2780:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2781:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2781:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2782:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2782:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2783:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2784:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2784:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 

            }

            // InternalBug348199TestLanguage.g:2787:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2788:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0()); 
            // InternalBug348199TestLanguage.g:2789:1: ( RULE_NL )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_NL) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2789:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2800:1: rule__Timeperiod__Group_3_3_3_0__1 : rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 ;
    public final void rule__Timeperiod__Group_3_3_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2804:1: ( rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2 )
            // InternalBug348199TestLanguage.g:2805:2: rule__Timeperiod__Group_3_3_3_0__1__Impl rule__Timeperiod__Group_3_3_3_0__2
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
    // InternalBug348199TestLanguage.g:2812:1: rule__Timeperiod__Group_3_3_3_0__1__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2816:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:2817:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:2817:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:2818:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:2831:1: rule__Timeperiod__Group_3_3_3_0__2 : rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 ;
    public final void rule__Timeperiod__Group_3_3_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2835:1: ( rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3 )
            // InternalBug348199TestLanguage.g:2836:2: rule__Timeperiod__Group_3_3_3_0__2__Impl rule__Timeperiod__Group_3_3_3_0__3
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
    // InternalBug348199TestLanguage.g:2843:1: rule__Timeperiod__Group_3_3_3_0__2__Impl : ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2847:1: ( ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) ) )
            // InternalBug348199TestLanguage.g:2848:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            {
            // InternalBug348199TestLanguage.g:2848:1: ( ( rule__Timeperiod__NameAssignment_3_3_3_0_2 ) )
            // InternalBug348199TestLanguage.g:2849:1: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_3_3_0_2()); 
            // InternalBug348199TestLanguage.g:2850:1: ( rule__Timeperiod__NameAssignment_3_3_3_0_2 )
            // InternalBug348199TestLanguage.g:2850:2: rule__Timeperiod__NameAssignment_3_3_3_0_2
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
    // InternalBug348199TestLanguage.g:2860:1: rule__Timeperiod__Group_3_3_3_0__3 : rule__Timeperiod__Group_3_3_3_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2864:1: ( rule__Timeperiod__Group_3_3_3_0__3__Impl )
            // InternalBug348199TestLanguage.g:2865:2: rule__Timeperiod__Group_3_3_3_0__3__Impl
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
    // InternalBug348199TestLanguage.g:2871:1: rule__Timeperiod__Group_3_3_3_0__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2875:1: ( ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:2876:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:2876:1: ( ( rule__Timeperiod__Group_3_3_3_0_3__0 )* )
            // InternalBug348199TestLanguage.g:2877:1: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0_3()); 
            // InternalBug348199TestLanguage.g:2878:1: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2878:2: rule__Timeperiod__Group_3_3_3_0_3__0
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
    // InternalBug348199TestLanguage.g:2896:1: rule__Timeperiod__Group_3_3_3_0_3__0 : rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2900:1: ( rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1 )
            // InternalBug348199TestLanguage.g:2901:2: rule__Timeperiod__Group_3_3_3_0_3__0__Impl rule__Timeperiod__Group_3_3_3_0_3__1
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
    // InternalBug348199TestLanguage.g:2908:1: rule__Timeperiod__Group_3_3_3_0_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2912:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2913:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2913:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2914:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2914:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2915:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2916:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2916:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 

            }

            // InternalBug348199TestLanguage.g:2919:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2920:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0()); 
            // InternalBug348199TestLanguage.g:2921:1: ( RULE_NL )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_NL) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2921:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:2932:1: rule__Timeperiod__Group_3_3_3_0_3__1 : rule__Timeperiod__Group_3_3_3_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2936:1: ( rule__Timeperiod__Group_3_3_3_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:2937:2: rule__Timeperiod__Group_3_3_3_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:2943:1: rule__Timeperiod__Group_3_3_3_0_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2947:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) ) )
            // InternalBug348199TestLanguage.g:2948:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:2948:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 ) )
            // InternalBug348199TestLanguage.g:2949:1: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_0_3_1()); 
            // InternalBug348199TestLanguage.g:2950:1: ( rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 )
            // InternalBug348199TestLanguage.g:2950:2: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1
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
    // InternalBug348199TestLanguage.g:2964:1: rule__Timeperiod__Group_3_3_3_1__0 : rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2968:1: ( rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1 )
            // InternalBug348199TestLanguage.g:2969:2: rule__Timeperiod__Group_3_3_3_1__0__Impl rule__Timeperiod__Group_3_3_3_1__1
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
    // InternalBug348199TestLanguage.g:2976:1: rule__Timeperiod__Group_3_3_3_1__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:2980:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:2981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:2981:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:2982:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:2982:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:2983:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2984:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:2984:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 

            }

            // InternalBug348199TestLanguage.g:2987:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:2988:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0()); 
            // InternalBug348199TestLanguage.g:2989:1: ( RULE_NL )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NL) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:2989:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3000:1: rule__Timeperiod__Group_3_3_3_1__1 : rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 ;
    public final void rule__Timeperiod__Group_3_3_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3004:1: ( rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2 )
            // InternalBug348199TestLanguage.g:3005:2: rule__Timeperiod__Group_3_3_3_1__1__Impl rule__Timeperiod__Group_3_3_3_1__2
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
    // InternalBug348199TestLanguage.g:3012:1: rule__Timeperiod__Group_3_3_3_1__1__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3016:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3017:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3017:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3018:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:3031:1: rule__Timeperiod__Group_3_3_3_1__2 : rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 ;
    public final void rule__Timeperiod__Group_3_3_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3035:1: ( rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3 )
            // InternalBug348199TestLanguage.g:3036:2: rule__Timeperiod__Group_3_3_3_1__2__Impl rule__Timeperiod__Group_3_3_3_1__3
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
    // InternalBug348199TestLanguage.g:3043:1: rule__Timeperiod__Group_3_3_3_1__2__Impl : ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3047:1: ( ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) ) )
            // InternalBug348199TestLanguage.g:3048:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            {
            // InternalBug348199TestLanguage.g:3048:1: ( ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 ) )
            // InternalBug348199TestLanguage.g:3049:1: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_3_3_1_2()); 
            // InternalBug348199TestLanguage.g:3050:1: ( rule__Timeperiod__AliasAssignment_3_3_3_1_2 )
            // InternalBug348199TestLanguage.g:3050:2: rule__Timeperiod__AliasAssignment_3_3_3_1_2
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
    // InternalBug348199TestLanguage.g:3060:1: rule__Timeperiod__Group_3_3_3_1__3 : rule__Timeperiod__Group_3_3_3_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3064:1: ( rule__Timeperiod__Group_3_3_3_1__3__Impl )
            // InternalBug348199TestLanguage.g:3065:2: rule__Timeperiod__Group_3_3_3_1__3__Impl
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
    // InternalBug348199TestLanguage.g:3071:1: rule__Timeperiod__Group_3_3_3_1__3__Impl : ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_3_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3075:1: ( ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3076:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3076:1: ( ( rule__Timeperiod__Group_3_3_3_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3077:1: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1_3()); 
            // InternalBug348199TestLanguage.g:3078:1: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3078:2: rule__Timeperiod__Group_3_3_3_1_3__0
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
    // InternalBug348199TestLanguage.g:3096:1: rule__Timeperiod__Group_3_3_3_1_3__0 : rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3100:1: ( rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1 )
            // InternalBug348199TestLanguage.g:3101:2: rule__Timeperiod__Group_3_3_3_1_3__0__Impl rule__Timeperiod__Group_3_3_3_1_3__1
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
    // InternalBug348199TestLanguage.g:3108:1: rule__Timeperiod__Group_3_3_3_1_3__0__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3112:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3113:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3113:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3114:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3114:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3115:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:3116:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3116:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 

            }

            // InternalBug348199TestLanguage.g:3119:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3120:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0()); 
            // InternalBug348199TestLanguage.g:3121:1: ( RULE_NL )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_NL) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3121:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3132:1: rule__Timeperiod__Group_3_3_3_1_3__1 : rule__Timeperiod__Group_3_3_3_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3136:1: ( rule__Timeperiod__Group_3_3_3_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3137:2: rule__Timeperiod__Group_3_3_3_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3143:1: rule__Timeperiod__Group_3_3_3_1_3__1__Impl : ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) ;
    public final void rule__Timeperiod__Group_3_3_3_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3147:1: ( ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) ) )
            // InternalBug348199TestLanguage.g:3148:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            {
            // InternalBug348199TestLanguage.g:3148:1: ( ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 ) )
            // InternalBug348199TestLanguage.g:3149:1: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_1_3_1()); 
            // InternalBug348199TestLanguage.g:3150:1: ( rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 )
            // InternalBug348199TestLanguage.g:3150:2: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1
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
    // InternalBug348199TestLanguage.g:3164:1: rule__Timeperiod__Group_3_4__0 : rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 ;
    public final void rule__Timeperiod__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3168:1: ( rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1 )
            // InternalBug348199TestLanguage.g:3169:2: rule__Timeperiod__Group_3_4__0__Impl rule__Timeperiod__Group_3_4__1
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
    // InternalBug348199TestLanguage.g:3176:1: rule__Timeperiod__Group_3_4__0__Impl : ( '5' ) ;
    public final void rule__Timeperiod__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3180:1: ( ( '5' ) )
            // InternalBug348199TestLanguage.g:3181:1: ( '5' )
            {
            // InternalBug348199TestLanguage.g:3181:1: ( '5' )
            // InternalBug348199TestLanguage.g:3182:1: '5'
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
    // InternalBug348199TestLanguage.g:3195:1: rule__Timeperiod__Group_3_4__1 : rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 ;
    public final void rule__Timeperiod__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3199:1: ( rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2 )
            // InternalBug348199TestLanguage.g:3200:2: rule__Timeperiod__Group_3_4__1__Impl rule__Timeperiod__Group_3_4__2
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
    // InternalBug348199TestLanguage.g:3207:1: rule__Timeperiod__Group_3_4__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3211:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3212:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3212:1: ( '{' )
            // InternalBug348199TestLanguage.g:3213:1: '{'
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
    // InternalBug348199TestLanguage.g:3226:1: rule__Timeperiod__Group_3_4__2 : rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 ;
    public final void rule__Timeperiod__Group_3_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3230:1: ( rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3 )
            // InternalBug348199TestLanguage.g:3231:2: rule__Timeperiod__Group_3_4__2__Impl rule__Timeperiod__Group_3_4__3
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
    // InternalBug348199TestLanguage.g:3238:1: rule__Timeperiod__Group_3_4__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3242:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3243:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3243:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3244:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3244:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3245:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:3246:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3246:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 

            }

            // InternalBug348199TestLanguage.g:3249:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3250:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2()); 
            // InternalBug348199TestLanguage.g:3251:1: ( RULE_NL )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_NL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3251:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3262:1: rule__Timeperiod__Group_3_4__3 : rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 ;
    public final void rule__Timeperiod__Group_3_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3266:1: ( rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4 )
            // InternalBug348199TestLanguage.g:3267:2: rule__Timeperiod__Group_3_4__3__Impl rule__Timeperiod__Group_3_4__4
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
    // InternalBug348199TestLanguage.g:3274:1: rule__Timeperiod__Group_3_4__3__Impl : ( ( rule__Timeperiod__Group_3_4_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3278:1: ( ( ( rule__Timeperiod__Group_3_4_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3279:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3279:1: ( ( rule__Timeperiod__Group_3_4_3__0 )* )
            // InternalBug348199TestLanguage.g:3280:1: ( rule__Timeperiod__Group_3_4_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_3()); 
            // InternalBug348199TestLanguage.g:3281:1: ( rule__Timeperiod__Group_3_4_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==26) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3281:2: rule__Timeperiod__Group_3_4_3__0
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
    // InternalBug348199TestLanguage.g:3291:1: rule__Timeperiod__Group_3_4__4 : rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 ;
    public final void rule__Timeperiod__Group_3_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3295:1: ( rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5 )
            // InternalBug348199TestLanguage.g:3296:2: rule__Timeperiod__Group_3_4__4__Impl rule__Timeperiod__Group_3_4__5
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
    // InternalBug348199TestLanguage.g:3303:1: rule__Timeperiod__Group_3_4__4__Impl : ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) ;
    public final void rule__Timeperiod__Group_3_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3307:1: ( ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) ) )
            // InternalBug348199TestLanguage.g:3308:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            {
            // InternalBug348199TestLanguage.g:3308:1: ( ( rule__Timeperiod__UnorderedGroup_3_4_4 ) )
            // InternalBug348199TestLanguage.g:3309:1: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()); 
            // InternalBug348199TestLanguage.g:3310:1: ( rule__Timeperiod__UnorderedGroup_3_4_4 )
            // InternalBug348199TestLanguage.g:3310:2: rule__Timeperiod__UnorderedGroup_3_4_4
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
    // InternalBug348199TestLanguage.g:3320:1: rule__Timeperiod__Group_3_4__5 : rule__Timeperiod__Group_3_4__5__Impl ;
    public final void rule__Timeperiod__Group_3_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3324:1: ( rule__Timeperiod__Group_3_4__5__Impl )
            // InternalBug348199TestLanguage.g:3325:2: rule__Timeperiod__Group_3_4__5__Impl
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
    // InternalBug348199TestLanguage.g:3331:1: rule__Timeperiod__Group_3_4__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3335:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:3336:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:3336:1: ( '}' )
            // InternalBug348199TestLanguage.g:3337:1: '}'
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
    // InternalBug348199TestLanguage.g:3362:1: rule__Timeperiod__Group_3_4_3__0 : rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 ;
    public final void rule__Timeperiod__Group_3_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3366:1: ( rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1 )
            // InternalBug348199TestLanguage.g:3367:2: rule__Timeperiod__Group_3_4_3__0__Impl rule__Timeperiod__Group_3_4_3__1
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
    // InternalBug348199TestLanguage.g:3374:1: rule__Timeperiod__Group_3_4_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3378:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3379:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3379:1: ( ( rule__Timeperiod__TimeAssignment_3_4_3_0 ) )
            // InternalBug348199TestLanguage.g:3380:1: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_3_0()); 
            // InternalBug348199TestLanguage.g:3381:1: ( rule__Timeperiod__TimeAssignment_3_4_3_0 )
            // InternalBug348199TestLanguage.g:3381:2: rule__Timeperiod__TimeAssignment_3_4_3_0
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
    // InternalBug348199TestLanguage.g:3391:1: rule__Timeperiod__Group_3_4_3__1 : rule__Timeperiod__Group_3_4_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3395:1: ( rule__Timeperiod__Group_3_4_3__1__Impl )
            // InternalBug348199TestLanguage.g:3396:2: rule__Timeperiod__Group_3_4_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3402:1: rule__Timeperiod__Group_3_4_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3406:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3407:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3407:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3408:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3408:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3409:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:3410:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3410:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3413:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3414:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1()); 
            // InternalBug348199TestLanguage.g:3415:1: ( RULE_NL )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_NL) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3415:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3430:1: rule__Timeperiod__Group_3_4_4_0__0 : rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3434:1: ( rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1 )
            // InternalBug348199TestLanguage.g:3435:2: rule__Timeperiod__Group_3_4_4_0__0__Impl rule__Timeperiod__Group_3_4_4_0__1
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
    // InternalBug348199TestLanguage.g:3442:1: rule__Timeperiod__Group_3_4_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3446:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:3447:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:3447:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:3448:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:3461:1: rule__Timeperiod__Group_3_4_4_0__1 : rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 ;
    public final void rule__Timeperiod__Group_3_4_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3465:1: ( rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2 )
            // InternalBug348199TestLanguage.g:3466:2: rule__Timeperiod__Group_3_4_4_0__1__Impl rule__Timeperiod__Group_3_4_4_0__2
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
    // InternalBug348199TestLanguage.g:3473:1: rule__Timeperiod__Group_3_4_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3477:1: ( ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:3478:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:3478:1: ( ( rule__Timeperiod__NameAssignment_3_4_4_0_1 ) )
            // InternalBug348199TestLanguage.g:3479:1: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_4_4_0_1()); 
            // InternalBug348199TestLanguage.g:3480:1: ( rule__Timeperiod__NameAssignment_3_4_4_0_1 )
            // InternalBug348199TestLanguage.g:3480:2: rule__Timeperiod__NameAssignment_3_4_4_0_1
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
    // InternalBug348199TestLanguage.g:3490:1: rule__Timeperiod__Group_3_4_4_0__2 : rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 ;
    public final void rule__Timeperiod__Group_3_4_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3494:1: ( rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3 )
            // InternalBug348199TestLanguage.g:3495:2: rule__Timeperiod__Group_3_4_4_0__2__Impl rule__Timeperiod__Group_3_4_4_0__3
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
    // InternalBug348199TestLanguage.g:3502:1: rule__Timeperiod__Group_3_4_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3506:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3507:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3507:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3508:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3508:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3509:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3510:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3510:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:3513:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3514:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2()); 
            // InternalBug348199TestLanguage.g:3515:1: ( RULE_NL )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_NL) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3515:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3526:1: rule__Timeperiod__Group_3_4_4_0__3 : rule__Timeperiod__Group_3_4_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3530:1: ( rule__Timeperiod__Group_3_4_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:3531:2: rule__Timeperiod__Group_3_4_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:3537:1: rule__Timeperiod__Group_3_4_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3541:1: ( ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3542:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3542:1: ( ( rule__Timeperiod__Group_3_4_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:3543:1: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0_3()); 
            // InternalBug348199TestLanguage.g:3544:1: ( rule__Timeperiod__Group_3_4_4_0_3__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==27) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3544:2: rule__Timeperiod__Group_3_4_4_0_3__0
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
    // InternalBug348199TestLanguage.g:3562:1: rule__Timeperiod__Group_3_4_4_0_3__0 : rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3566:1: ( rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1 )
            // InternalBug348199TestLanguage.g:3567:2: rule__Timeperiod__Group_3_4_4_0_3__0__Impl rule__Timeperiod__Group_3_4_4_0_3__1
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
    // InternalBug348199TestLanguage.g:3574:1: rule__Timeperiod__Group_3_4_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3578:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3579:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3579:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:3580:1: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:3581:1: ( rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 )
            // InternalBug348199TestLanguage.g:3581:2: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0
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
    // InternalBug348199TestLanguage.g:3591:1: rule__Timeperiod__Group_3_4_4_0_3__1 : rule__Timeperiod__Group_3_4_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3595:1: ( rule__Timeperiod__Group_3_4_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:3596:2: rule__Timeperiod__Group_3_4_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3602:1: rule__Timeperiod__Group_3_4_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3606:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3607:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3607:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3608:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3608:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3609:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3610:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3610:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3613:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3614:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:3615:1: ( RULE_NL )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_NL) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3615:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3630:1: rule__Timeperiod__Group_3_4_4_1__0 : rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3634:1: ( rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1 )
            // InternalBug348199TestLanguage.g:3635:2: rule__Timeperiod__Group_3_4_4_1__0__Impl rule__Timeperiod__Group_3_4_4_1__1
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
    // InternalBug348199TestLanguage.g:3642:1: rule__Timeperiod__Group_3_4_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3646:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:3647:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:3647:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:3648:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:3661:1: rule__Timeperiod__Group_3_4_4_1__1 : rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 ;
    public final void rule__Timeperiod__Group_3_4_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3665:1: ( rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2 )
            // InternalBug348199TestLanguage.g:3666:2: rule__Timeperiod__Group_3_4_4_1__1__Impl rule__Timeperiod__Group_3_4_4_1__2
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
    // InternalBug348199TestLanguage.g:3673:1: rule__Timeperiod__Group_3_4_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3677:1: ( ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:3678:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:3678:1: ( ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 ) )
            // InternalBug348199TestLanguage.g:3679:1: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_4_4_1_1()); 
            // InternalBug348199TestLanguage.g:3680:1: ( rule__Timeperiod__AliasAssignment_3_4_4_1_1 )
            // InternalBug348199TestLanguage.g:3680:2: rule__Timeperiod__AliasAssignment_3_4_4_1_1
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
    // InternalBug348199TestLanguage.g:3690:1: rule__Timeperiod__Group_3_4_4_1__2 : rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 ;
    public final void rule__Timeperiod__Group_3_4_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3694:1: ( rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3 )
            // InternalBug348199TestLanguage.g:3695:2: rule__Timeperiod__Group_3_4_4_1__2__Impl rule__Timeperiod__Group_3_4_4_1__3
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
    // InternalBug348199TestLanguage.g:3702:1: rule__Timeperiod__Group_3_4_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3706:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3707:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3707:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3708:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3708:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3709:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3710:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3710:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:3713:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3714:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2()); 
            // InternalBug348199TestLanguage.g:3715:1: ( RULE_NL )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_NL) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3715:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3726:1: rule__Timeperiod__Group_3_4_4_1__3 : rule__Timeperiod__Group_3_4_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3730:1: ( rule__Timeperiod__Group_3_4_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:3731:2: rule__Timeperiod__Group_3_4_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:3737:1: rule__Timeperiod__Group_3_4_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_4_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3741:1: ( ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3742:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3742:1: ( ( rule__Timeperiod__Group_3_4_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:3743:1: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1_3()); 
            // InternalBug348199TestLanguage.g:3744:1: ( rule__Timeperiod__Group_3_4_4_1_3__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==28) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3744:2: rule__Timeperiod__Group_3_4_4_1_3__0
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
    // InternalBug348199TestLanguage.g:3762:1: rule__Timeperiod__Group_3_4_4_1_3__0 : rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3766:1: ( rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1 )
            // InternalBug348199TestLanguage.g:3767:2: rule__Timeperiod__Group_3_4_4_1_3__0__Impl rule__Timeperiod__Group_3_4_4_1_3__1
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
    // InternalBug348199TestLanguage.g:3774:1: rule__Timeperiod__Group_3_4_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3778:1: ( ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:3779:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:3779:1: ( ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:3780:1: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:3781:1: ( rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 )
            // InternalBug348199TestLanguage.g:3781:2: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0
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
    // InternalBug348199TestLanguage.g:3791:1: rule__Timeperiod__Group_3_4_4_1_3__1 : rule__Timeperiod__Group_3_4_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3795:1: ( rule__Timeperiod__Group_3_4_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:3796:2: rule__Timeperiod__Group_3_4_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:3802:1: rule__Timeperiod__Group_3_4_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_4_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3806:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3807:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3807:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3808:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3808:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3809:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3810:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3810:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:3813:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3814:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:3815:1: ( RULE_NL )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_NL) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3815:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3830:1: rule__Timeperiod__Group_3_5__0 : rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 ;
    public final void rule__Timeperiod__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3834:1: ( rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1 )
            // InternalBug348199TestLanguage.g:3835:2: rule__Timeperiod__Group_3_5__0__Impl rule__Timeperiod__Group_3_5__1
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
    // InternalBug348199TestLanguage.g:3842:1: rule__Timeperiod__Group_3_5__0__Impl : ( '6' ) ;
    public final void rule__Timeperiod__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3846:1: ( ( '6' ) )
            // InternalBug348199TestLanguage.g:3847:1: ( '6' )
            {
            // InternalBug348199TestLanguage.g:3847:1: ( '6' )
            // InternalBug348199TestLanguage.g:3848:1: '6'
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
    // InternalBug348199TestLanguage.g:3861:1: rule__Timeperiod__Group_3_5__1 : rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 ;
    public final void rule__Timeperiod__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3865:1: ( rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2 )
            // InternalBug348199TestLanguage.g:3866:2: rule__Timeperiod__Group_3_5__1__Impl rule__Timeperiod__Group_3_5__2
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
    // InternalBug348199TestLanguage.g:3873:1: rule__Timeperiod__Group_3_5__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3877:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:3878:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:3878:1: ( '{' )
            // InternalBug348199TestLanguage.g:3879:1: '{'
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
    // InternalBug348199TestLanguage.g:3892:1: rule__Timeperiod__Group_3_5__2 : rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 ;
    public final void rule__Timeperiod__Group_3_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3896:1: ( rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3 )
            // InternalBug348199TestLanguage.g:3897:2: rule__Timeperiod__Group_3_5__2__Impl rule__Timeperiod__Group_3_5__3
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
    // InternalBug348199TestLanguage.g:3904:1: rule__Timeperiod__Group_3_5__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3908:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:3909:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:3909:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:3910:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:3910:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:3911:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3912:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:3912:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 

            }

            // InternalBug348199TestLanguage.g:3915:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:3916:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2()); 
            // InternalBug348199TestLanguage.g:3917:1: ( RULE_NL )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_NL) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3917:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:3928:1: rule__Timeperiod__Group_3_5__3 : rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 ;
    public final void rule__Timeperiod__Group_3_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3932:1: ( rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4 )
            // InternalBug348199TestLanguage.g:3933:2: rule__Timeperiod__Group_3_5__3__Impl rule__Timeperiod__Group_3_5__4
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
    // InternalBug348199TestLanguage.g:3940:1: rule__Timeperiod__Group_3_5__3__Impl : ( ( rule__Timeperiod__Group_3_5_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3944:1: ( ( ( rule__Timeperiod__Group_3_5_3__0 )* ) )
            // InternalBug348199TestLanguage.g:3945:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:3945:1: ( ( rule__Timeperiod__Group_3_5_3__0 )* )
            // InternalBug348199TestLanguage.g:3946:1: ( rule__Timeperiod__Group_3_5_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_3()); 
            // InternalBug348199TestLanguage.g:3947:1: ( rule__Timeperiod__Group_3_5_3__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==26) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:3947:2: rule__Timeperiod__Group_3_5_3__0
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
    // InternalBug348199TestLanguage.g:3957:1: rule__Timeperiod__Group_3_5__4 : rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 ;
    public final void rule__Timeperiod__Group_3_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3961:1: ( rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5 )
            // InternalBug348199TestLanguage.g:3962:2: rule__Timeperiod__Group_3_5__4__Impl rule__Timeperiod__Group_3_5__5
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
    // InternalBug348199TestLanguage.g:3969:1: rule__Timeperiod__Group_3_5__4__Impl : ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) ;
    public final void rule__Timeperiod__Group_3_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3973:1: ( ( ( rule__Timeperiod__Alternatives_3_5_4 ) ) )
            // InternalBug348199TestLanguage.g:3974:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            {
            // InternalBug348199TestLanguage.g:3974:1: ( ( rule__Timeperiod__Alternatives_3_5_4 ) )
            // InternalBug348199TestLanguage.g:3975:1: ( rule__Timeperiod__Alternatives_3_5_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_5_4()); 
            // InternalBug348199TestLanguage.g:3976:1: ( rule__Timeperiod__Alternatives_3_5_4 )
            // InternalBug348199TestLanguage.g:3976:2: rule__Timeperiod__Alternatives_3_5_4
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
    // InternalBug348199TestLanguage.g:3986:1: rule__Timeperiod__Group_3_5__5 : rule__Timeperiod__Group_3_5__5__Impl ;
    public final void rule__Timeperiod__Group_3_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:3990:1: ( rule__Timeperiod__Group_3_5__5__Impl )
            // InternalBug348199TestLanguage.g:3991:2: rule__Timeperiod__Group_3_5__5__Impl
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
    // InternalBug348199TestLanguage.g:3997:1: rule__Timeperiod__Group_3_5__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4001:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4002:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4002:1: ( '}' )
            // InternalBug348199TestLanguage.g:4003:1: '}'
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
    // InternalBug348199TestLanguage.g:4028:1: rule__Timeperiod__Group_3_5_3__0 : rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 ;
    public final void rule__Timeperiod__Group_3_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4032:1: ( rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1 )
            // InternalBug348199TestLanguage.g:4033:2: rule__Timeperiod__Group_3_5_3__0__Impl rule__Timeperiod__Group_3_5_3__1
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
    // InternalBug348199TestLanguage.g:4040:1: rule__Timeperiod__Group_3_5_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4044:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4045:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4045:1: ( ( rule__Timeperiod__TimeAssignment_3_5_3_0 ) )
            // InternalBug348199TestLanguage.g:4046:1: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_3_0()); 
            // InternalBug348199TestLanguage.g:4047:1: ( rule__Timeperiod__TimeAssignment_3_5_3_0 )
            // InternalBug348199TestLanguage.g:4047:2: rule__Timeperiod__TimeAssignment_3_5_3_0
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
    // InternalBug348199TestLanguage.g:4057:1: rule__Timeperiod__Group_3_5_3__1 : rule__Timeperiod__Group_3_5_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4061:1: ( rule__Timeperiod__Group_3_5_3__1__Impl )
            // InternalBug348199TestLanguage.g:4062:2: rule__Timeperiod__Group_3_5_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4068:1: rule__Timeperiod__Group_3_5_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4072:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4073:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4073:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4074:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4074:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4075:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:4076:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4076:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4079:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4080:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1()); 
            // InternalBug348199TestLanguage.g:4081:1: ( RULE_NL )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_NL) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4081:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4096:1: rule__Timeperiod__Group_3_5_4_0__0 : rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4100:1: ( rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1 )
            // InternalBug348199TestLanguage.g:4101:2: rule__Timeperiod__Group_3_5_4_0__0__Impl rule__Timeperiod__Group_3_5_4_0__1
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
    // InternalBug348199TestLanguage.g:4108:1: rule__Timeperiod__Group_3_5_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4112:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4113:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4113:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4114:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:4127:1: rule__Timeperiod__Group_3_5_4_0__1 : rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 ;
    public final void rule__Timeperiod__Group_3_5_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4131:1: ( rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2 )
            // InternalBug348199TestLanguage.g:4132:2: rule__Timeperiod__Group_3_5_4_0__1__Impl rule__Timeperiod__Group_3_5_4_0__2
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
    // InternalBug348199TestLanguage.g:4139:1: rule__Timeperiod__Group_3_5_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4143:1: ( ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4144:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4144:1: ( ( rule__Timeperiod__NameAssignment_3_5_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4145:1: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_5_4_0_1()); 
            // InternalBug348199TestLanguage.g:4146:1: ( rule__Timeperiod__NameAssignment_3_5_4_0_1 )
            // InternalBug348199TestLanguage.g:4146:2: rule__Timeperiod__NameAssignment_3_5_4_0_1
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
    // InternalBug348199TestLanguage.g:4156:1: rule__Timeperiod__Group_3_5_4_0__2 : rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 ;
    public final void rule__Timeperiod__Group_3_5_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4160:1: ( rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3 )
            // InternalBug348199TestLanguage.g:4161:2: rule__Timeperiod__Group_3_5_4_0__2__Impl rule__Timeperiod__Group_3_5_4_0__3
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
    // InternalBug348199TestLanguage.g:4168:1: rule__Timeperiod__Group_3_5_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4172:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4173:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4173:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4174:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4174:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4175:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:4176:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4176:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4179:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4180:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2()); 
            // InternalBug348199TestLanguage.g:4181:1: ( RULE_NL )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_NL) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4181:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4192:1: rule__Timeperiod__Group_3_5_4_0__3 : rule__Timeperiod__Group_3_5_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4196:1: ( rule__Timeperiod__Group_3_5_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4197:2: rule__Timeperiod__Group_3_5_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:4203:1: rule__Timeperiod__Group_3_5_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4207:1: ( ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4208:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4208:1: ( ( rule__Timeperiod__Group_3_5_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4209:1: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0_3()); 
            // InternalBug348199TestLanguage.g:4210:1: ( rule__Timeperiod__Group_3_5_4_0_3__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==27) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4210:2: rule__Timeperiod__Group_3_5_4_0_3__0
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
    // InternalBug348199TestLanguage.g:4228:1: rule__Timeperiod__Group_3_5_4_0_3__0 : rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4232:1: ( rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4233:2: rule__Timeperiod__Group_3_5_4_0_3__0__Impl rule__Timeperiod__Group_3_5_4_0_3__1
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
    // InternalBug348199TestLanguage.g:4240:1: rule__Timeperiod__Group_3_5_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4244:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4245:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4245:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4246:1: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4247:1: ( rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4247:2: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0
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
    // InternalBug348199TestLanguage.g:4257:1: rule__Timeperiod__Group_3_5_4_0_3__1 : rule__Timeperiod__Group_3_5_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4261:1: ( rule__Timeperiod__Group_3_5_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4262:2: rule__Timeperiod__Group_3_5_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4268:1: rule__Timeperiod__Group_3_5_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4272:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4273:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4273:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4274:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4274:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4275:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4276:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4276:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4279:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4280:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4281:1: ( RULE_NL )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_NL) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4281:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4296:1: rule__Timeperiod__Group_3_5_4_1__0 : rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4300:1: ( rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1 )
            // InternalBug348199TestLanguage.g:4301:2: rule__Timeperiod__Group_3_5_4_1__0__Impl rule__Timeperiod__Group_3_5_4_1__1
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
    // InternalBug348199TestLanguage.g:4308:1: rule__Timeperiod__Group_3_5_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4312:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4313:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4313:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4314:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:4327:1: rule__Timeperiod__Group_3_5_4_1__1 : rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 ;
    public final void rule__Timeperiod__Group_3_5_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4331:1: ( rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2 )
            // InternalBug348199TestLanguage.g:4332:2: rule__Timeperiod__Group_3_5_4_1__1__Impl rule__Timeperiod__Group_3_5_4_1__2
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
    // InternalBug348199TestLanguage.g:4339:1: rule__Timeperiod__Group_3_5_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4343:1: ( ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:4344:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:4344:1: ( ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 ) )
            // InternalBug348199TestLanguage.g:4345:1: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_5_4_1_1()); 
            // InternalBug348199TestLanguage.g:4346:1: ( rule__Timeperiod__AliasAssignment_3_5_4_1_1 )
            // InternalBug348199TestLanguage.g:4346:2: rule__Timeperiod__AliasAssignment_3_5_4_1_1
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
    // InternalBug348199TestLanguage.g:4356:1: rule__Timeperiod__Group_3_5_4_1__2 : rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 ;
    public final void rule__Timeperiod__Group_3_5_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4360:1: ( rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3 )
            // InternalBug348199TestLanguage.g:4361:2: rule__Timeperiod__Group_3_5_4_1__2__Impl rule__Timeperiod__Group_3_5_4_1__3
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
    // InternalBug348199TestLanguage.g:4368:1: rule__Timeperiod__Group_3_5_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4372:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4373:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4373:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4374:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4374:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4375:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:4376:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4376:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:4379:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4380:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2()); 
            // InternalBug348199TestLanguage.g:4381:1: ( RULE_NL )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_NL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4381:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4392:1: rule__Timeperiod__Group_3_5_4_1__3 : rule__Timeperiod__Group_3_5_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4396:1: ( rule__Timeperiod__Group_3_5_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:4397:2: rule__Timeperiod__Group_3_5_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:4403:1: rule__Timeperiod__Group_3_5_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_5_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4407:1: ( ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4408:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4408:1: ( ( rule__Timeperiod__Group_3_5_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:4409:1: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1_3()); 
            // InternalBug348199TestLanguage.g:4410:1: ( rule__Timeperiod__Group_3_5_4_1_3__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==28) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4410:2: rule__Timeperiod__Group_3_5_4_1_3__0
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
    // InternalBug348199TestLanguage.g:4428:1: rule__Timeperiod__Group_3_5_4_1_3__0 : rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4432:1: ( rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1 )
            // InternalBug348199TestLanguage.g:4433:2: rule__Timeperiod__Group_3_5_4_1_3__0__Impl rule__Timeperiod__Group_3_5_4_1_3__1
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
    // InternalBug348199TestLanguage.g:4440:1: rule__Timeperiod__Group_3_5_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4444:1: ( ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4445:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4445:1: ( ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:4446:1: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:4447:1: ( rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 )
            // InternalBug348199TestLanguage.g:4447:2: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0
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
    // InternalBug348199TestLanguage.g:4457:1: rule__Timeperiod__Group_3_5_4_1_3__1 : rule__Timeperiod__Group_3_5_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4461:1: ( rule__Timeperiod__Group_3_5_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:4462:2: rule__Timeperiod__Group_3_5_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4468:1: rule__Timeperiod__Group_3_5_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_5_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4472:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4473:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4473:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4474:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4474:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4475:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4476:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4476:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4479:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4480:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:4481:1: ( RULE_NL )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_NL) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4481:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4496:1: rule__Timeperiod__Group_3_6__0 : rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 ;
    public final void rule__Timeperiod__Group_3_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4500:1: ( rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1 )
            // InternalBug348199TestLanguage.g:4501:2: rule__Timeperiod__Group_3_6__0__Impl rule__Timeperiod__Group_3_6__1
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
    // InternalBug348199TestLanguage.g:4508:1: rule__Timeperiod__Group_3_6__0__Impl : ( '7' ) ;
    public final void rule__Timeperiod__Group_3_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4512:1: ( ( '7' ) )
            // InternalBug348199TestLanguage.g:4513:1: ( '7' )
            {
            // InternalBug348199TestLanguage.g:4513:1: ( '7' )
            // InternalBug348199TestLanguage.g:4514:1: '7'
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
    // InternalBug348199TestLanguage.g:4527:1: rule__Timeperiod__Group_3_6__1 : rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 ;
    public final void rule__Timeperiod__Group_3_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4531:1: ( rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2 )
            // InternalBug348199TestLanguage.g:4532:2: rule__Timeperiod__Group_3_6__1__Impl rule__Timeperiod__Group_3_6__2
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
    // InternalBug348199TestLanguage.g:4539:1: rule__Timeperiod__Group_3_6__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4543:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:4544:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:4544:1: ( '{' )
            // InternalBug348199TestLanguage.g:4545:1: '{'
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
    // InternalBug348199TestLanguage.g:4558:1: rule__Timeperiod__Group_3_6__2 : rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 ;
    public final void rule__Timeperiod__Group_3_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4562:1: ( rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3 )
            // InternalBug348199TestLanguage.g:4563:2: rule__Timeperiod__Group_3_6__2__Impl rule__Timeperiod__Group_3_6__3
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
    // InternalBug348199TestLanguage.g:4570:1: rule__Timeperiod__Group_3_6__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4574:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4575:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4575:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4576:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4576:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4577:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4578:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4578:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 

            }

            // InternalBug348199TestLanguage.g:4581:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4582:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2()); 
            // InternalBug348199TestLanguage.g:4583:1: ( RULE_NL )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_NL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4583:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4594:1: rule__Timeperiod__Group_3_6__3 : rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 ;
    public final void rule__Timeperiod__Group_3_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4598:1: ( rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4 )
            // InternalBug348199TestLanguage.g:4599:2: rule__Timeperiod__Group_3_6__3__Impl rule__Timeperiod__Group_3_6__4
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
    // InternalBug348199TestLanguage.g:4606:1: rule__Timeperiod__Group_3_6__3__Impl : ( ( rule__Timeperiod__Group_3_6_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4610:1: ( ( ( rule__Timeperiod__Group_3_6_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4611:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4611:1: ( ( rule__Timeperiod__Group_3_6_3__0 )* )
            // InternalBug348199TestLanguage.g:4612:1: ( rule__Timeperiod__Group_3_6_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_3()); 
            // InternalBug348199TestLanguage.g:4613:1: ( rule__Timeperiod__Group_3_6_3__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==26) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4613:2: rule__Timeperiod__Group_3_6_3__0
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
    // InternalBug348199TestLanguage.g:4623:1: rule__Timeperiod__Group_3_6__4 : rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 ;
    public final void rule__Timeperiod__Group_3_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4627:1: ( rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5 )
            // InternalBug348199TestLanguage.g:4628:2: rule__Timeperiod__Group_3_6__4__Impl rule__Timeperiod__Group_3_6__5
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
    // InternalBug348199TestLanguage.g:4635:1: rule__Timeperiod__Group_3_6__4__Impl : ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) ;
    public final void rule__Timeperiod__Group_3_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4639:1: ( ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) ) )
            // InternalBug348199TestLanguage.g:4640:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            {
            // InternalBug348199TestLanguage.g:4640:1: ( ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* ) )
            // InternalBug348199TestLanguage.g:4641:1: ( ( rule__Timeperiod__Alternatives_3_6_4 ) ) ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            {
            // InternalBug348199TestLanguage.g:4641:1: ( ( rule__Timeperiod__Alternatives_3_6_4 ) )
            // InternalBug348199TestLanguage.g:4642:1: ( rule__Timeperiod__Alternatives_3_6_4 )
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4643:1: ( rule__Timeperiod__Alternatives_3_6_4 )
            // InternalBug348199TestLanguage.g:4643:2: rule__Timeperiod__Alternatives_3_6_4
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__Alternatives_3_6_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 

            }

            // InternalBug348199TestLanguage.g:4646:1: ( ( rule__Timeperiod__Alternatives_3_6_4 )* )
            // InternalBug348199TestLanguage.g:4647:1: ( rule__Timeperiod__Alternatives_3_6_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4()); 
            // InternalBug348199TestLanguage.g:4648:1: ( rule__Timeperiod__Alternatives_3_6_4 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( ((LA68_0>=17 && LA68_0<=18)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4648:2: rule__Timeperiod__Alternatives_3_6_4
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
    // InternalBug348199TestLanguage.g:4659:1: rule__Timeperiod__Group_3_6__5 : rule__Timeperiod__Group_3_6__5__Impl ;
    public final void rule__Timeperiod__Group_3_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4663:1: ( rule__Timeperiod__Group_3_6__5__Impl )
            // InternalBug348199TestLanguage.g:4664:2: rule__Timeperiod__Group_3_6__5__Impl
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
    // InternalBug348199TestLanguage.g:4670:1: rule__Timeperiod__Group_3_6__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4674:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:4675:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:4675:1: ( '}' )
            // InternalBug348199TestLanguage.g:4676:1: '}'
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
    // InternalBug348199TestLanguage.g:4701:1: rule__Timeperiod__Group_3_6_3__0 : rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 ;
    public final void rule__Timeperiod__Group_3_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4705:1: ( rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1 )
            // InternalBug348199TestLanguage.g:4706:2: rule__Timeperiod__Group_3_6_3__0__Impl rule__Timeperiod__Group_3_6_3__1
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
    // InternalBug348199TestLanguage.g:4713:1: rule__Timeperiod__Group_3_6_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4717:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4718:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4718:1: ( ( rule__Timeperiod__TimeAssignment_3_6_3_0 ) )
            // InternalBug348199TestLanguage.g:4719:1: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_3_0()); 
            // InternalBug348199TestLanguage.g:4720:1: ( rule__Timeperiod__TimeAssignment_3_6_3_0 )
            // InternalBug348199TestLanguage.g:4720:2: rule__Timeperiod__TimeAssignment_3_6_3_0
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
    // InternalBug348199TestLanguage.g:4730:1: rule__Timeperiod__Group_3_6_3__1 : rule__Timeperiod__Group_3_6_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4734:1: ( rule__Timeperiod__Group_3_6_3__1__Impl )
            // InternalBug348199TestLanguage.g:4735:2: rule__Timeperiod__Group_3_6_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4741:1: rule__Timeperiod__Group_3_6_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4745:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4746:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4746:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4747:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4747:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4748:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4749:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4749:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4752:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4753:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1()); 
            // InternalBug348199TestLanguage.g:4754:1: ( RULE_NL )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_NL) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4754:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4769:1: rule__Timeperiod__Group_3_6_4_0__0 : rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4773:1: ( rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1 )
            // InternalBug348199TestLanguage.g:4774:2: rule__Timeperiod__Group_3_6_4_0__0__Impl rule__Timeperiod__Group_3_6_4_0__1
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
    // InternalBug348199TestLanguage.g:4781:1: rule__Timeperiod__Group_3_6_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4785:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:4786:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:4786:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:4787:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:4800:1: rule__Timeperiod__Group_3_6_4_0__1 : rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 ;
    public final void rule__Timeperiod__Group_3_6_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4804:1: ( rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2 )
            // InternalBug348199TestLanguage.g:4805:2: rule__Timeperiod__Group_3_6_4_0__1__Impl rule__Timeperiod__Group_3_6_4_0__2
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
    // InternalBug348199TestLanguage.g:4812:1: rule__Timeperiod__Group_3_6_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4816:1: ( ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:4817:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:4817:1: ( ( rule__Timeperiod__NameAssignment_3_6_4_0_1 ) )
            // InternalBug348199TestLanguage.g:4818:1: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_6_4_0_1()); 
            // InternalBug348199TestLanguage.g:4819:1: ( rule__Timeperiod__NameAssignment_3_6_4_0_1 )
            // InternalBug348199TestLanguage.g:4819:2: rule__Timeperiod__NameAssignment_3_6_4_0_1
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
    // InternalBug348199TestLanguage.g:4829:1: rule__Timeperiod__Group_3_6_4_0__2 : rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 ;
    public final void rule__Timeperiod__Group_3_6_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4833:1: ( rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3 )
            // InternalBug348199TestLanguage.g:4834:2: rule__Timeperiod__Group_3_6_4_0__2__Impl rule__Timeperiod__Group_3_6_4_0__3
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
    // InternalBug348199TestLanguage.g:4841:1: rule__Timeperiod__Group_3_6_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4845:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4846:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4846:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4847:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4847:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4848:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4849:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4849:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:4852:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4853:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2()); 
            // InternalBug348199TestLanguage.g:4854:1: ( RULE_NL )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_NL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4854:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4865:1: rule__Timeperiod__Group_3_6_4_0__3 : rule__Timeperiod__Group_3_6_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4869:1: ( rule__Timeperiod__Group_3_6_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:4870:2: rule__Timeperiod__Group_3_6_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:4876:1: rule__Timeperiod__Group_3_6_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4880:1: ( ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:4881:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:4881:1: ( ( rule__Timeperiod__Group_3_6_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:4882:1: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0_3()); 
            // InternalBug348199TestLanguage.g:4883:1: ( rule__Timeperiod__Group_3_6_4_0_3__0 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4883:2: rule__Timeperiod__Group_3_6_4_0_3__0
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
    // InternalBug348199TestLanguage.g:4901:1: rule__Timeperiod__Group_3_6_4_0_3__0 : rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4905:1: ( rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1 )
            // InternalBug348199TestLanguage.g:4906:2: rule__Timeperiod__Group_3_6_4_0_3__0__Impl rule__Timeperiod__Group_3_6_4_0_3__1
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
    // InternalBug348199TestLanguage.g:4913:1: rule__Timeperiod__Group_3_6_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4917:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:4918:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:4918:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:4919:1: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:4920:1: ( rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 )
            // InternalBug348199TestLanguage.g:4920:2: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0
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
    // InternalBug348199TestLanguage.g:4930:1: rule__Timeperiod__Group_3_6_4_0_3__1 : rule__Timeperiod__Group_3_6_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4934:1: ( rule__Timeperiod__Group_3_6_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:4935:2: rule__Timeperiod__Group_3_6_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:4941:1: rule__Timeperiod__Group_3_6_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4945:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:4946:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:4946:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:4947:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:4947:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:4948:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4949:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:4949:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:4952:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:4953:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:4954:1: ( RULE_NL )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_NL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:4954:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:4969:1: rule__Timeperiod__Group_3_6_4_1__0 : rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4973:1: ( rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1 )
            // InternalBug348199TestLanguage.g:4974:2: rule__Timeperiod__Group_3_6_4_1__0__Impl rule__Timeperiod__Group_3_6_4_1__1
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
    // InternalBug348199TestLanguage.g:4981:1: rule__Timeperiod__Group_3_6_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:4985:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:4986:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:4986:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:4987:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:5000:1: rule__Timeperiod__Group_3_6_4_1__1 : rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 ;
    public final void rule__Timeperiod__Group_3_6_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5004:1: ( rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2 )
            // InternalBug348199TestLanguage.g:5005:2: rule__Timeperiod__Group_3_6_4_1__1__Impl rule__Timeperiod__Group_3_6_4_1__2
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
    // InternalBug348199TestLanguage.g:5012:1: rule__Timeperiod__Group_3_6_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5016:1: ( ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:5017:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:5017:1: ( ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 ) )
            // InternalBug348199TestLanguage.g:5018:1: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_6_4_1_1()); 
            // InternalBug348199TestLanguage.g:5019:1: ( rule__Timeperiod__AliasAssignment_3_6_4_1_1 )
            // InternalBug348199TestLanguage.g:5019:2: rule__Timeperiod__AliasAssignment_3_6_4_1_1
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
    // InternalBug348199TestLanguage.g:5029:1: rule__Timeperiod__Group_3_6_4_1__2 : rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 ;
    public final void rule__Timeperiod__Group_3_6_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5033:1: ( rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3 )
            // InternalBug348199TestLanguage.g:5034:2: rule__Timeperiod__Group_3_6_4_1__2__Impl rule__Timeperiod__Group_3_6_4_1__3
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
    // InternalBug348199TestLanguage.g:5041:1: rule__Timeperiod__Group_3_6_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5045:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5046:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5046:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5047:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5047:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5048:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:5049:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5049:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:5052:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5053:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2()); 
            // InternalBug348199TestLanguage.g:5054:1: ( RULE_NL )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_NL) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5054:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5065:1: rule__Timeperiod__Group_3_6_4_1__3 : rule__Timeperiod__Group_3_6_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5069:1: ( rule__Timeperiod__Group_3_6_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:5070:2: rule__Timeperiod__Group_3_6_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:5076:1: rule__Timeperiod__Group_3_6_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_6_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5080:1: ( ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5081:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5081:1: ( ( rule__Timeperiod__Group_3_6_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:5082:1: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1_3()); 
            // InternalBug348199TestLanguage.g:5083:1: ( rule__Timeperiod__Group_3_6_4_1_3__0 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==28) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5083:2: rule__Timeperiod__Group_3_6_4_1_3__0
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
    // InternalBug348199TestLanguage.g:5101:1: rule__Timeperiod__Group_3_6_4_1_3__0 : rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5105:1: ( rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1 )
            // InternalBug348199TestLanguage.g:5106:2: rule__Timeperiod__Group_3_6_4_1_3__0__Impl rule__Timeperiod__Group_3_6_4_1_3__1
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
    // InternalBug348199TestLanguage.g:5113:1: rule__Timeperiod__Group_3_6_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5117:1: ( ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5118:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5118:1: ( ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:5119:1: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:5120:1: ( rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 )
            // InternalBug348199TestLanguage.g:5120:2: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0
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
    // InternalBug348199TestLanguage.g:5130:1: rule__Timeperiod__Group_3_6_4_1_3__1 : rule__Timeperiod__Group_3_6_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5134:1: ( rule__Timeperiod__Group_3_6_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:5135:2: rule__Timeperiod__Group_3_6_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:5141:1: rule__Timeperiod__Group_3_6_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_6_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5145:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5146:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5146:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5147:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5147:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5148:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5149:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5149:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5152:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5153:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5154:1: ( RULE_NL )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_NL) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5154:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5169:1: rule__Timeperiod__Group_3_7__0 : rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 ;
    public final void rule__Timeperiod__Group_3_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5173:1: ( rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1 )
            // InternalBug348199TestLanguage.g:5174:2: rule__Timeperiod__Group_3_7__0__Impl rule__Timeperiod__Group_3_7__1
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
    // InternalBug348199TestLanguage.g:5181:1: rule__Timeperiod__Group_3_7__0__Impl : ( '8' ) ;
    public final void rule__Timeperiod__Group_3_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5185:1: ( ( '8' ) )
            // InternalBug348199TestLanguage.g:5186:1: ( '8' )
            {
            // InternalBug348199TestLanguage.g:5186:1: ( '8' )
            // InternalBug348199TestLanguage.g:5187:1: '8'
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
    // InternalBug348199TestLanguage.g:5200:1: rule__Timeperiod__Group_3_7__1 : rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 ;
    public final void rule__Timeperiod__Group_3_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5204:1: ( rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2 )
            // InternalBug348199TestLanguage.g:5205:2: rule__Timeperiod__Group_3_7__1__Impl rule__Timeperiod__Group_3_7__2
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
    // InternalBug348199TestLanguage.g:5212:1: rule__Timeperiod__Group_3_7__1__Impl : ( '{' ) ;
    public final void rule__Timeperiod__Group_3_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5216:1: ( ( '{' ) )
            // InternalBug348199TestLanguage.g:5217:1: ( '{' )
            {
            // InternalBug348199TestLanguage.g:5217:1: ( '{' )
            // InternalBug348199TestLanguage.g:5218:1: '{'
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
    // InternalBug348199TestLanguage.g:5231:1: rule__Timeperiod__Group_3_7__2 : rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 ;
    public final void rule__Timeperiod__Group_3_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5235:1: ( rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3 )
            // InternalBug348199TestLanguage.g:5236:2: rule__Timeperiod__Group_3_7__2__Impl rule__Timeperiod__Group_3_7__3
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
    // InternalBug348199TestLanguage.g:5243:1: rule__Timeperiod__Group_3_7__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5247:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5248:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5248:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5249:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5249:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5250:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:5251:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5251:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 

            }

            // InternalBug348199TestLanguage.g:5254:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5255:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2()); 
            // InternalBug348199TestLanguage.g:5256:1: ( RULE_NL )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_NL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5256:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5267:1: rule__Timeperiod__Group_3_7__3 : rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 ;
    public final void rule__Timeperiod__Group_3_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5271:1: ( rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4 )
            // InternalBug348199TestLanguage.g:5272:2: rule__Timeperiod__Group_3_7__3__Impl rule__Timeperiod__Group_3_7__4
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
    // InternalBug348199TestLanguage.g:5279:1: rule__Timeperiod__Group_3_7__3__Impl : ( ( rule__Timeperiod__Group_3_7_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5283:1: ( ( ( rule__Timeperiod__Group_3_7_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5284:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5284:1: ( ( rule__Timeperiod__Group_3_7_3__0 )* )
            // InternalBug348199TestLanguage.g:5285:1: ( rule__Timeperiod__Group_3_7_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_3()); 
            // InternalBug348199TestLanguage.g:5286:1: ( rule__Timeperiod__Group_3_7_3__0 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==26) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5286:2: rule__Timeperiod__Group_3_7_3__0
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
    // InternalBug348199TestLanguage.g:5296:1: rule__Timeperiod__Group_3_7__4 : rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 ;
    public final void rule__Timeperiod__Group_3_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5300:1: ( rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5 )
            // InternalBug348199TestLanguage.g:5301:2: rule__Timeperiod__Group_3_7__4__Impl rule__Timeperiod__Group_3_7__5
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
    // InternalBug348199TestLanguage.g:5308:1: rule__Timeperiod__Group_3_7__4__Impl : ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) ;
    public final void rule__Timeperiod__Group_3_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5312:1: ( ( ( rule__Timeperiod__Alternatives_3_7_4 )* ) )
            // InternalBug348199TestLanguage.g:5313:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            {
            // InternalBug348199TestLanguage.g:5313:1: ( ( rule__Timeperiod__Alternatives_3_7_4 )* )
            // InternalBug348199TestLanguage.g:5314:1: ( rule__Timeperiod__Alternatives_3_7_4 )*
            {
             before(grammarAccess.getTimeperiodAccess().getAlternatives_3_7_4()); 
            // InternalBug348199TestLanguage.g:5315:1: ( rule__Timeperiod__Alternatives_3_7_4 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=17 && LA78_0<=18)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5315:2: rule__Timeperiod__Alternatives_3_7_4
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
    // InternalBug348199TestLanguage.g:5325:1: rule__Timeperiod__Group_3_7__5 : rule__Timeperiod__Group_3_7__5__Impl ;
    public final void rule__Timeperiod__Group_3_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5329:1: ( rule__Timeperiod__Group_3_7__5__Impl )
            // InternalBug348199TestLanguage.g:5330:2: rule__Timeperiod__Group_3_7__5__Impl
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
    // InternalBug348199TestLanguage.g:5336:1: rule__Timeperiod__Group_3_7__5__Impl : ( '}' ) ;
    public final void rule__Timeperiod__Group_3_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5340:1: ( ( '}' ) )
            // InternalBug348199TestLanguage.g:5341:1: ( '}' )
            {
            // InternalBug348199TestLanguage.g:5341:1: ( '}' )
            // InternalBug348199TestLanguage.g:5342:1: '}'
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
    // InternalBug348199TestLanguage.g:5367:1: rule__Timeperiod__Group_3_7_3__0 : rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 ;
    public final void rule__Timeperiod__Group_3_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5371:1: ( rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1 )
            // InternalBug348199TestLanguage.g:5372:2: rule__Timeperiod__Group_3_7_3__0__Impl rule__Timeperiod__Group_3_7_3__1
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
    // InternalBug348199TestLanguage.g:5379:1: rule__Timeperiod__Group_3_7_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5383:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5384:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5384:1: ( ( rule__Timeperiod__TimeAssignment_3_7_3_0 ) )
            // InternalBug348199TestLanguage.g:5385:1: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_3_0()); 
            // InternalBug348199TestLanguage.g:5386:1: ( rule__Timeperiod__TimeAssignment_3_7_3_0 )
            // InternalBug348199TestLanguage.g:5386:2: rule__Timeperiod__TimeAssignment_3_7_3_0
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
    // InternalBug348199TestLanguage.g:5396:1: rule__Timeperiod__Group_3_7_3__1 : rule__Timeperiod__Group_3_7_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5400:1: ( rule__Timeperiod__Group_3_7_3__1__Impl )
            // InternalBug348199TestLanguage.g:5401:2: rule__Timeperiod__Group_3_7_3__1__Impl
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
    // InternalBug348199TestLanguage.g:5407:1: rule__Timeperiod__Group_3_7_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5411:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5412:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5412:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5413:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5413:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5414:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:5415:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5415:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5418:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5419:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1()); 
            // InternalBug348199TestLanguage.g:5420:1: ( RULE_NL )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_NL) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5420:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5435:1: rule__Timeperiod__Group_3_7_4_0__0 : rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5439:1: ( rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1 )
            // InternalBug348199TestLanguage.g:5440:2: rule__Timeperiod__Group_3_7_4_0__0__Impl rule__Timeperiod__Group_3_7_4_0__1
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
    // InternalBug348199TestLanguage.g:5447:1: rule__Timeperiod__Group_3_7_4_0__0__Impl : ( 'timeperiod_name' ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5451:1: ( ( 'timeperiod_name' ) )
            // InternalBug348199TestLanguage.g:5452:1: ( 'timeperiod_name' )
            {
            // InternalBug348199TestLanguage.g:5452:1: ( 'timeperiod_name' )
            // InternalBug348199TestLanguage.g:5453:1: 'timeperiod_name'
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
    // InternalBug348199TestLanguage.g:5466:1: rule__Timeperiod__Group_3_7_4_0__1 : rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 ;
    public final void rule__Timeperiod__Group_3_7_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5470:1: ( rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2 )
            // InternalBug348199TestLanguage.g:5471:2: rule__Timeperiod__Group_3_7_4_0__1__Impl rule__Timeperiod__Group_3_7_4_0__2
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
    // InternalBug348199TestLanguage.g:5478:1: rule__Timeperiod__Group_3_7_4_0__1__Impl : ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5482:1: ( ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) ) )
            // InternalBug348199TestLanguage.g:5483:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            {
            // InternalBug348199TestLanguage.g:5483:1: ( ( rule__Timeperiod__NameAssignment_3_7_4_0_1 ) )
            // InternalBug348199TestLanguage.g:5484:1: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getNameAssignment_3_7_4_0_1()); 
            // InternalBug348199TestLanguage.g:5485:1: ( rule__Timeperiod__NameAssignment_3_7_4_0_1 )
            // InternalBug348199TestLanguage.g:5485:2: rule__Timeperiod__NameAssignment_3_7_4_0_1
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
    // InternalBug348199TestLanguage.g:5495:1: rule__Timeperiod__Group_3_7_4_0__2 : rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 ;
    public final void rule__Timeperiod__Group_3_7_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5499:1: ( rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3 )
            // InternalBug348199TestLanguage.g:5500:2: rule__Timeperiod__Group_3_7_4_0__2__Impl rule__Timeperiod__Group_3_7_4_0__3
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
    // InternalBug348199TestLanguage.g:5507:1: rule__Timeperiod__Group_3_7_4_0__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5511:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5512:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5512:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5513:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5513:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5514:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:5515:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5515:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 

            }

            // InternalBug348199TestLanguage.g:5518:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5519:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2()); 
            // InternalBug348199TestLanguage.g:5520:1: ( RULE_NL )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_NL) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5520:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5531:1: rule__Timeperiod__Group_3_7_4_0__3 : rule__Timeperiod__Group_3_7_4_0__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5535:1: ( rule__Timeperiod__Group_3_7_4_0__3__Impl )
            // InternalBug348199TestLanguage.g:5536:2: rule__Timeperiod__Group_3_7_4_0__3__Impl
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
    // InternalBug348199TestLanguage.g:5542:1: rule__Timeperiod__Group_3_7_4_0__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5546:1: ( ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5547:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5547:1: ( ( rule__Timeperiod__Group_3_7_4_0_3__0 )* )
            // InternalBug348199TestLanguage.g:5548:1: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0_3()); 
            // InternalBug348199TestLanguage.g:5549:1: ( rule__Timeperiod__Group_3_7_4_0_3__0 )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==27) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5549:2: rule__Timeperiod__Group_3_7_4_0_3__0
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
    // InternalBug348199TestLanguage.g:5567:1: rule__Timeperiod__Group_3_7_4_0_3__0 : rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5571:1: ( rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1 )
            // InternalBug348199TestLanguage.g:5572:2: rule__Timeperiod__Group_3_7_4_0_3__0__Impl rule__Timeperiod__Group_3_7_4_0_3__1
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
    // InternalBug348199TestLanguage.g:5579:1: rule__Timeperiod__Group_3_7_4_0_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5583:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5584:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5584:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 ) )
            // InternalBug348199TestLanguage.g:5585:1: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_0_3_0()); 
            // InternalBug348199TestLanguage.g:5586:1: ( rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 )
            // InternalBug348199TestLanguage.g:5586:2: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0
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
    // InternalBug348199TestLanguage.g:5596:1: rule__Timeperiod__Group_3_7_4_0_3__1 : rule__Timeperiod__Group_3_7_4_0_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5600:1: ( rule__Timeperiod__Group_3_7_4_0_3__1__Impl )
            // InternalBug348199TestLanguage.g:5601:2: rule__Timeperiod__Group_3_7_4_0_3__1__Impl
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
    // InternalBug348199TestLanguage.g:5607:1: rule__Timeperiod__Group_3_7_4_0_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5611:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5612:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5612:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5613:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5613:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5614:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:5615:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5615:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5618:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5619:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1()); 
            // InternalBug348199TestLanguage.g:5620:1: ( RULE_NL )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_NL) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5620:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5635:1: rule__Timeperiod__Group_3_7_4_1__0 : rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5639:1: ( rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1 )
            // InternalBug348199TestLanguage.g:5640:2: rule__Timeperiod__Group_3_7_4_1__0__Impl rule__Timeperiod__Group_3_7_4_1__1
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
    // InternalBug348199TestLanguage.g:5647:1: rule__Timeperiod__Group_3_7_4_1__0__Impl : ( 'otherelement' ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5651:1: ( ( 'otherelement' ) )
            // InternalBug348199TestLanguage.g:5652:1: ( 'otherelement' )
            {
            // InternalBug348199TestLanguage.g:5652:1: ( 'otherelement' )
            // InternalBug348199TestLanguage.g:5653:1: 'otherelement'
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
    // InternalBug348199TestLanguage.g:5666:1: rule__Timeperiod__Group_3_7_4_1__1 : rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 ;
    public final void rule__Timeperiod__Group_3_7_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5670:1: ( rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2 )
            // InternalBug348199TestLanguage.g:5671:2: rule__Timeperiod__Group_3_7_4_1__1__Impl rule__Timeperiod__Group_3_7_4_1__2
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
    // InternalBug348199TestLanguage.g:5678:1: rule__Timeperiod__Group_3_7_4_1__1__Impl : ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5682:1: ( ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) ) )
            // InternalBug348199TestLanguage.g:5683:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            {
            // InternalBug348199TestLanguage.g:5683:1: ( ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 ) )
            // InternalBug348199TestLanguage.g:5684:1: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            {
             before(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_7_4_1_1()); 
            // InternalBug348199TestLanguage.g:5685:1: ( rule__Timeperiod__AliasAssignment_3_7_4_1_1 )
            // InternalBug348199TestLanguage.g:5685:2: rule__Timeperiod__AliasAssignment_3_7_4_1_1
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
    // InternalBug348199TestLanguage.g:5695:1: rule__Timeperiod__Group_3_7_4_1__2 : rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 ;
    public final void rule__Timeperiod__Group_3_7_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5699:1: ( rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3 )
            // InternalBug348199TestLanguage.g:5700:2: rule__Timeperiod__Group_3_7_4_1__2__Impl rule__Timeperiod__Group_3_7_4_1__3
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
    // InternalBug348199TestLanguage.g:5707:1: rule__Timeperiod__Group_3_7_4_1__2__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5711:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5712:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5712:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5713:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5713:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5714:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5715:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5715:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 

            }

            // InternalBug348199TestLanguage.g:5718:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5719:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2()); 
            // InternalBug348199TestLanguage.g:5720:1: ( RULE_NL )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_NL) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5720:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5731:1: rule__Timeperiod__Group_3_7_4_1__3 : rule__Timeperiod__Group_3_7_4_1__3__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5735:1: ( rule__Timeperiod__Group_3_7_4_1__3__Impl )
            // InternalBug348199TestLanguage.g:5736:2: rule__Timeperiod__Group_3_7_4_1__3__Impl
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
    // InternalBug348199TestLanguage.g:5742:1: rule__Timeperiod__Group_3_7_4_1__3__Impl : ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) ;
    public final void rule__Timeperiod__Group_3_7_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5746:1: ( ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* ) )
            // InternalBug348199TestLanguage.g:5747:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            {
            // InternalBug348199TestLanguage.g:5747:1: ( ( rule__Timeperiod__Group_3_7_4_1_3__0 )* )
            // InternalBug348199TestLanguage.g:5748:1: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            {
             before(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1_3()); 
            // InternalBug348199TestLanguage.g:5749:1: ( rule__Timeperiod__Group_3_7_4_1_3__0 )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==28) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5749:2: rule__Timeperiod__Group_3_7_4_1_3__0
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
    // InternalBug348199TestLanguage.g:5767:1: rule__Timeperiod__Group_3_7_4_1_3__0 : rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5771:1: ( rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1 )
            // InternalBug348199TestLanguage.g:5772:2: rule__Timeperiod__Group_3_7_4_1_3__0__Impl rule__Timeperiod__Group_3_7_4_1_3__1
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
    // InternalBug348199TestLanguage.g:5779:1: rule__Timeperiod__Group_3_7_4_1_3__0__Impl : ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5783:1: ( ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) ) )
            // InternalBug348199TestLanguage.g:5784:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            {
            // InternalBug348199TestLanguage.g:5784:1: ( ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 ) )
            // InternalBug348199TestLanguage.g:5785:1: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            {
             before(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_1_3_0()); 
            // InternalBug348199TestLanguage.g:5786:1: ( rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 )
            // InternalBug348199TestLanguage.g:5786:2: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0
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
    // InternalBug348199TestLanguage.g:5796:1: rule__Timeperiod__Group_3_7_4_1_3__1 : rule__Timeperiod__Group_3_7_4_1_3__1__Impl ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5800:1: ( rule__Timeperiod__Group_3_7_4_1_3__1__Impl )
            // InternalBug348199TestLanguage.g:5801:2: rule__Timeperiod__Group_3_7_4_1_3__1__Impl
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
    // InternalBug348199TestLanguage.g:5807:1: rule__Timeperiod__Group_3_7_4_1_3__1__Impl : ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) ;
    public final void rule__Timeperiod__Group_3_7_4_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5811:1: ( ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) ) )
            // InternalBug348199TestLanguage.g:5812:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            {
            // InternalBug348199TestLanguage.g:5812:1: ( ( ( RULE_NL ) ) ( ( RULE_NL )* ) )
            // InternalBug348199TestLanguage.g:5813:1: ( ( RULE_NL ) ) ( ( RULE_NL )* )
            {
            // InternalBug348199TestLanguage.g:5813:1: ( ( RULE_NL ) )
            // InternalBug348199TestLanguage.g:5814:1: ( RULE_NL )
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5815:1: ( RULE_NL )
            // InternalBug348199TestLanguage.g:5815:3: RULE_NL
            {
            match(input,RULE_NL,FollowSets000.FOLLOW_8); 

            }

             after(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 

            }

            // InternalBug348199TestLanguage.g:5818:1: ( ( RULE_NL )* )
            // InternalBug348199TestLanguage.g:5819:1: ( RULE_NL )*
            {
             before(grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1()); 
            // InternalBug348199TestLanguage.g:5820:1: ( RULE_NL )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_NL) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalBug348199TestLanguage.g:5820:3: RULE_NL
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
    // InternalBug348199TestLanguage.g:5835:1: rule__TimeDef1__Group__0 : rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 ;
    public final void rule__TimeDef1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5839:1: ( rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1 )
            // InternalBug348199TestLanguage.g:5840:2: rule__TimeDef1__Group__0__Impl rule__TimeDef1__Group__1
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
    // InternalBug348199TestLanguage.g:5847:1: rule__TimeDef1__Group__0__Impl : ( 'july' ) ;
    public final void rule__TimeDef1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5851:1: ( ( 'july' ) )
            // InternalBug348199TestLanguage.g:5852:1: ( 'july' )
            {
            // InternalBug348199TestLanguage.g:5852:1: ( 'july' )
            // InternalBug348199TestLanguage.g:5853:1: 'july'
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
    // InternalBug348199TestLanguage.g:5866:1: rule__TimeDef1__Group__1 : rule__TimeDef1__Group__1__Impl ;
    public final void rule__TimeDef1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5870:1: ( rule__TimeDef1__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5871:2: rule__TimeDef1__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:5877:1: rule__TimeDef1__Group__1__Impl : ( ( rule__TimeDef1__DayAssignment_1 ) ) ;
    public final void rule__TimeDef1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5881:1: ( ( ( rule__TimeDef1__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5882:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5882:1: ( ( rule__TimeDef1__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5883:1: ( rule__TimeDef1__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef1Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5884:1: ( rule__TimeDef1__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5884:2: rule__TimeDef1__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:5898:1: rule__TimeDef2__Group__0 : rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 ;
    public final void rule__TimeDef2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5902:1: ( rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1 )
            // InternalBug348199TestLanguage.g:5903:2: rule__TimeDef2__Group__0__Impl rule__TimeDef2__Group__1
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
    // InternalBug348199TestLanguage.g:5910:1: rule__TimeDef2__Group__0__Impl : ( 'august' ) ;
    public final void rule__TimeDef2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5914:1: ( ( 'august' ) )
            // InternalBug348199TestLanguage.g:5915:1: ( 'august' )
            {
            // InternalBug348199TestLanguage.g:5915:1: ( 'august' )
            // InternalBug348199TestLanguage.g:5916:1: 'august'
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
    // InternalBug348199TestLanguage.g:5929:1: rule__TimeDef2__Group__1 : rule__TimeDef2__Group__1__Impl ;
    public final void rule__TimeDef2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5933:1: ( rule__TimeDef2__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5934:2: rule__TimeDef2__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:5940:1: rule__TimeDef2__Group__1__Impl : ( ( rule__TimeDef2__DayAssignment_1 ) ) ;
    public final void rule__TimeDef2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5944:1: ( ( ( rule__TimeDef2__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:5945:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:5945:1: ( ( rule__TimeDef2__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:5946:1: ( rule__TimeDef2__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef2Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:5947:1: ( rule__TimeDef2__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:5947:2: rule__TimeDef2__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:5961:1: rule__TimeDef3__Group__0 : rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 ;
    public final void rule__TimeDef3__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5965:1: ( rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1 )
            // InternalBug348199TestLanguage.g:5966:2: rule__TimeDef3__Group__0__Impl rule__TimeDef3__Group__1
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
    // InternalBug348199TestLanguage.g:5973:1: rule__TimeDef3__Group__0__Impl : ( 'september' ) ;
    public final void rule__TimeDef3__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5977:1: ( ( 'september' ) )
            // InternalBug348199TestLanguage.g:5978:1: ( 'september' )
            {
            // InternalBug348199TestLanguage.g:5978:1: ( 'september' )
            // InternalBug348199TestLanguage.g:5979:1: 'september'
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
    // InternalBug348199TestLanguage.g:5992:1: rule__TimeDef3__Group__1 : rule__TimeDef3__Group__1__Impl ;
    public final void rule__TimeDef3__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:5996:1: ( rule__TimeDef3__Group__1__Impl )
            // InternalBug348199TestLanguage.g:5997:2: rule__TimeDef3__Group__1__Impl
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
    // InternalBug348199TestLanguage.g:6003:1: rule__TimeDef3__Group__1__Impl : ( ( rule__TimeDef3__DayAssignment_1 ) ) ;
    public final void rule__TimeDef3__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6007:1: ( ( ( rule__TimeDef3__DayAssignment_1 ) ) )
            // InternalBug348199TestLanguage.g:6008:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            {
            // InternalBug348199TestLanguage.g:6008:1: ( ( rule__TimeDef3__DayAssignment_1 ) )
            // InternalBug348199TestLanguage.g:6009:1: ( rule__TimeDef3__DayAssignment_1 )
            {
             before(grammarAccess.getTimeDef3Access().getDayAssignment_1()); 
            // InternalBug348199TestLanguage.g:6010:1: ( rule__TimeDef3__DayAssignment_1 )
            // InternalBug348199TestLanguage.g:6010:2: rule__TimeDef3__DayAssignment_1
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
    // InternalBug348199TestLanguage.g:6025:1: rule__Timeperiod__UnorderedGroup_3_0_3 : rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
            
        try {
            // InternalBug348199TestLanguage.g:6030:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?)
            // InternalBug348199TestLanguage.g:6031:2: rule__Timeperiod__UnorderedGroup_3_0_3__0 {...}?
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
    // InternalBug348199TestLanguage.g:6042:1: rule__Timeperiod__UnorderedGroup_3_0_3__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalBug348199TestLanguage.g:6047:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:6048:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:6048:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalBug348199TestLanguage.g:6050:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:6050:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:6051:5: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:6051:111: ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:6052:6: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug348199TestLanguage.g:6058:6: ( ( rule__Timeperiod__Group_3_0_3_0__0 ) )
                    // InternalBug348199TestLanguage.g:6060:7: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0()); 
                    // InternalBug348199TestLanguage.g:6061:7: ( rule__Timeperiod__Group_3_0_3_0__0 )
                    // InternalBug348199TestLanguage.g:6061:8: rule__Timeperiod__Group_3_0_3_0__0
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
                    // InternalBug348199TestLanguage.g:6067:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:6067:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:6068:5: {...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:6068:111: ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:6069:6: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug348199TestLanguage.g:6075:6: ( ( rule__Timeperiod__Group_3_0_3_1__0 ) )
                    // InternalBug348199TestLanguage.g:6077:7: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1()); 
                    // InternalBug348199TestLanguage.g:6078:7: ( rule__Timeperiod__Group_3_0_3_1__0 )
                    // InternalBug348199TestLanguage.g:6078:8: rule__Timeperiod__Group_3_0_3_1__0
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
    // InternalBug348199TestLanguage.g:6093:1: rule__Timeperiod__UnorderedGroup_3_0_3__0 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6097:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )? )
            // InternalBug348199TestLanguage.g:6098:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Timeperiod__UnorderedGroup_3_0_3__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:6099:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalBug348199TestLanguage.g:6099:2: rule__Timeperiod__UnorderedGroup_3_0_3__1
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
    // InternalBug348199TestLanguage.g:6106:1: rule__Timeperiod__UnorderedGroup_3_0_3__1 : rule__Timeperiod__UnorderedGroup_3_0_3__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6110:1: ( rule__Timeperiod__UnorderedGroup_3_0_3__Impl )
            // InternalBug348199TestLanguage.g:6111:2: rule__Timeperiod__UnorderedGroup_3_0_3__Impl
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
    // InternalBug348199TestLanguage.g:6122:1: rule__Timeperiod__UnorderedGroup_3_4_4 : rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
            
        try {
            // InternalBug348199TestLanguage.g:6127:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?)
            // InternalBug348199TestLanguage.g:6128:2: rule__Timeperiod__UnorderedGroup_3_4_4__0 {...}?
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
    // InternalBug348199TestLanguage.g:6139:1: rule__Timeperiod__UnorderedGroup_3_4_4__Impl : ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalBug348199TestLanguage.g:6144:1: ( ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) ) )
            // InternalBug348199TestLanguage.g:6145:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
            {
            // InternalBug348199TestLanguage.g:6145:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) ) )
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
                    // InternalBug348199TestLanguage.g:6147:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:6147:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:6148:5: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0)");
                    }
                    // InternalBug348199TestLanguage.g:6148:111: ( ( ( rule__Timeperiod__Group_3_4_4_0__0 ) ) )
                    // InternalBug348199TestLanguage.g:6149:6: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug348199TestLanguage.g:6155:6: ( ( rule__Timeperiod__Group_3_4_4_0__0 ) )
                    // InternalBug348199TestLanguage.g:6157:7: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0()); 
                    // InternalBug348199TestLanguage.g:6158:7: ( rule__Timeperiod__Group_3_4_4_0__0 )
                    // InternalBug348199TestLanguage.g:6158:8: rule__Timeperiod__Group_3_4_4_0__0
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
                    // InternalBug348199TestLanguage.g:6164:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    {
                    // InternalBug348199TestLanguage.g:6164:4: ({...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) ) )
                    // InternalBug348199TestLanguage.g:6165:5: {...}? => ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Timeperiod__UnorderedGroup_3_4_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1)");
                    }
                    // InternalBug348199TestLanguage.g:6165:111: ( ( ( rule__Timeperiod__Group_3_4_4_1__0 ) ) )
                    // InternalBug348199TestLanguage.g:6166:6: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug348199TestLanguage.g:6172:6: ( ( rule__Timeperiod__Group_3_4_4_1__0 ) )
                    // InternalBug348199TestLanguage.g:6174:7: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    {
                     before(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1()); 
                    // InternalBug348199TestLanguage.g:6175:7: ( rule__Timeperiod__Group_3_4_4_1__0 )
                    // InternalBug348199TestLanguage.g:6175:8: rule__Timeperiod__Group_3_4_4_1__0
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
    // InternalBug348199TestLanguage.g:6190:1: rule__Timeperiod__UnorderedGroup_3_4_4__0 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6194:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )? )
            // InternalBug348199TestLanguage.g:6195:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Timeperiod__UnorderedGroup_3_4_4__Impl();

            state._fsp--;

            // InternalBug348199TestLanguage.g:6196:2: ( rule__Timeperiod__UnorderedGroup_3_4_4__1 )?
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
                    // InternalBug348199TestLanguage.g:6196:2: rule__Timeperiod__UnorderedGroup_3_4_4__1
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
    // InternalBug348199TestLanguage.g:6203:1: rule__Timeperiod__UnorderedGroup_3_4_4__1 : rule__Timeperiod__UnorderedGroup_3_4_4__Impl ;
    public final void rule__Timeperiod__UnorderedGroup_3_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6207:1: ( rule__Timeperiod__UnorderedGroup_3_4_4__Impl )
            // InternalBug348199TestLanguage.g:6208:2: rule__Timeperiod__UnorderedGroup_3_4_4__Impl
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
    // InternalBug348199TestLanguage.g:6219:1: rule__Timeperiod__TimeAssignment_3_0_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6223:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6224:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6224:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6225:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6234:1: rule__Timeperiod__NameAssignment_3_0_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_0_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6238:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6239:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6239:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6240:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6249:1: rule__Timeperiod__TimeAssignment_3_0_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6253:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6254:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6254:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6255:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6264:1: rule__Timeperiod__AliasAssignment_3_0_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_0_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6268:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6269:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6269:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6270:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6279:1: rule__Timeperiod__TimeAssignment_3_0_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_0_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6283:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6284:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6284:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6285:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6294:1: rule__Timeperiod__TimeAssignment_3_1_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6298:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6299:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6299:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6300:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6309:1: rule__Timeperiod__NameAssignment_3_1_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_1_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6313:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6314:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6314:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6315:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6324:1: rule__Timeperiod__TimeAssignment_3_1_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6328:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6329:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6329:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6330:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6339:1: rule__Timeperiod__AliasAssignment_3_1_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_1_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6343:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6344:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6344:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6345:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6354:1: rule__Timeperiod__TimeAssignment_3_1_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_1_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6358:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6359:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6359:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6360:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6369:1: rule__Timeperiod__TimeAssignment_3_2_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6373:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6374:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6374:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6375:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6384:1: rule__Timeperiod__NameAssignment_3_2_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_2_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6388:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6389:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6389:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6390:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6399:1: rule__Timeperiod__TimeAssignment_3_2_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6403:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6404:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6404:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6405:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6414:1: rule__Timeperiod__AliasAssignment_3_2_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_2_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6418:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6419:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6419:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6420:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6429:1: rule__Timeperiod__TimeAssignment_3_2_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_2_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6433:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6434:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6434:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6435:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6444:1: rule__Timeperiod__TimeAssignment_3_3_2_1 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6448:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6449:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6449:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6450:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6459:1: rule__Timeperiod__NameAssignment_3_3_3_0_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_3_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6463:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6464:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6464:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6465:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6474:1: rule__Timeperiod__TimeAssignment_3_3_3_0_3_1 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6478:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6479:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6479:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6480:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6489:1: rule__Timeperiod__AliasAssignment_3_3_3_1_2 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_3_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6493:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6494:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6494:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6495:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6504:1: rule__Timeperiod__TimeAssignment_3_3_3_1_3_1 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_3_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6508:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6509:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6509:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6510:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6519:1: rule__Timeperiod__TimeAssignment_3_4_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6523:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6524:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6524:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6525:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6534:1: rule__Timeperiod__NameAssignment_3_4_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_4_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6538:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6539:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6539:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6540:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6549:1: rule__Timeperiod__TimeAssignment_3_4_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6553:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6554:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6554:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6555:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6564:1: rule__Timeperiod__AliasAssignment_3_4_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_4_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6568:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6569:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6569:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6570:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6579:1: rule__Timeperiod__TimeAssignment_3_4_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_4_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6583:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6584:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6584:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6585:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6594:1: rule__Timeperiod__TimeAssignment_3_5_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6598:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6599:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6599:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6600:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6609:1: rule__Timeperiod__NameAssignment_3_5_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_5_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6613:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6614:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6614:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6615:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6624:1: rule__Timeperiod__TimeAssignment_3_5_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6628:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6629:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6629:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6630:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6639:1: rule__Timeperiod__AliasAssignment_3_5_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_5_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6643:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6644:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6644:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6645:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6654:1: rule__Timeperiod__TimeAssignment_3_5_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_5_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6658:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6659:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6659:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6660:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6669:1: rule__Timeperiod__TimeAssignment_3_6_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6673:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6674:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6674:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6675:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6684:1: rule__Timeperiod__NameAssignment_3_6_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_6_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6688:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6689:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6689:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6690:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6699:1: rule__Timeperiod__TimeAssignment_3_6_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6703:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6704:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6704:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6705:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6714:1: rule__Timeperiod__AliasAssignment_3_6_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_6_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6718:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6719:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6719:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6720:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6729:1: rule__Timeperiod__TimeAssignment_3_6_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_6_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6733:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6734:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6734:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6735:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6744:1: rule__Timeperiod__TimeAssignment_3_7_3_0 : ( ruleTimeDef1 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6748:1: ( ( ruleTimeDef1 ) )
            // InternalBug348199TestLanguage.g:6749:1: ( ruleTimeDef1 )
            {
            // InternalBug348199TestLanguage.g:6749:1: ( ruleTimeDef1 )
            // InternalBug348199TestLanguage.g:6750:1: ruleTimeDef1
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
    // InternalBug348199TestLanguage.g:6759:1: rule__Timeperiod__NameAssignment_3_7_4_0_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__NameAssignment_3_7_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6763:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6764:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6764:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6765:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6774:1: rule__Timeperiod__TimeAssignment_3_7_4_0_3_0 : ( ruleTimeDef2 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6778:1: ( ( ruleTimeDef2 ) )
            // InternalBug348199TestLanguage.g:6779:1: ( ruleTimeDef2 )
            {
            // InternalBug348199TestLanguage.g:6779:1: ( ruleTimeDef2 )
            // InternalBug348199TestLanguage.g:6780:1: ruleTimeDef2
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
    // InternalBug348199TestLanguage.g:6789:1: rule__Timeperiod__AliasAssignment_3_7_4_1_1 : ( RULE_ID ) ;
    public final void rule__Timeperiod__AliasAssignment_3_7_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6793:1: ( ( RULE_ID ) )
            // InternalBug348199TestLanguage.g:6794:1: ( RULE_ID )
            {
            // InternalBug348199TestLanguage.g:6794:1: ( RULE_ID )
            // InternalBug348199TestLanguage.g:6795:1: RULE_ID
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
    // InternalBug348199TestLanguage.g:6804:1: rule__Timeperiod__TimeAssignment_3_7_4_1_3_0 : ( ruleTimeDef3 ) ;
    public final void rule__Timeperiod__TimeAssignment_3_7_4_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6808:1: ( ( ruleTimeDef3 ) )
            // InternalBug348199TestLanguage.g:6809:1: ( ruleTimeDef3 )
            {
            // InternalBug348199TestLanguage.g:6809:1: ( ruleTimeDef3 )
            // InternalBug348199TestLanguage.g:6810:1: ruleTimeDef3
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
    // InternalBug348199TestLanguage.g:6819:1: rule__TimeDef1__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef1__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6823:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6824:1: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6824:1: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6825:1: RULE_INT
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
    // InternalBug348199TestLanguage.g:6834:1: rule__TimeDef2__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef2__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6838:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6839:1: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6839:1: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6840:1: RULE_INT
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
    // InternalBug348199TestLanguage.g:6849:1: rule__TimeDef3__DayAssignment_1 : ( RULE_INT ) ;
    public final void rule__TimeDef3__DayAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug348199TestLanguage.g:6853:1: ( ( RULE_INT ) )
            // InternalBug348199TestLanguage.g:6854:1: ( RULE_INT )
            {
            // InternalBug348199TestLanguage.g:6854:1: ( RULE_INT )
            // InternalBug348199TestLanguage.g:6855:1: RULE_INT
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
    static final String DFA3_eotS =
        "\5\uffff";
    static final String DFA3_eofS =
        "\5\uffff";
    static final String DFA3_minS =
        "\3\4\2\uffff";
    static final String DFA3_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA3_specialS =
        "\5\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\4\1\3\1\4",
            "\1\2\13\uffff\1\4\1\3\1\4",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "230:1: rule__Timeperiod__Alternatives_3_1_3 : ( ( ( rule__Timeperiod__Group_3_1_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_1_3_1__0 )? ) );";
        }
    }
    static final String DFA2_eotS =
        "\5\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\3\4\2\uffff";
    static final String DFA2_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA2_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\5\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\3\1\uffff\1\4",
            "\1\2\13\uffff\1\3\1\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "243:1: ( rule__Timeperiod__Group_3_1_3_1__0 )?";
        }
    }
    static final String DFA4_eotS =
        "\5\uffff";
    static final String DFA4_eofS =
        "\5\uffff";
    static final String DFA4_minS =
        "\3\4\2\uffff";
    static final String DFA4_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA4_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\2\14\uffff\1\4\1\3",
            "\1\2\14\uffff\1\4\1\3",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "252:1: rule__Timeperiod__Alternatives_3_2_3 : ( ( ( rule__Timeperiod__Group_3_2_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_2_3_1__0 ) ) );";
        }
    }
    static final String DFA5_eotS =
        "\5\uffff";
    static final String DFA5_eofS =
        "\5\uffff";
    static final String DFA5_minS =
        "\3\4\2\uffff";
    static final String DFA5_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA5_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2\14\uffff\1\3\1\4",
            "\1\2\14\uffff\1\3\1\4",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "274:1: rule__Timeperiod__Alternatives_3_3_3 : ( ( ( rule__Timeperiod__Group_3_3_3_0__0 ) ) | ( ( rule__Timeperiod__Group_3_3_3_1__0 ) ) );";
        }
    }
    static final String DFA10_eotS =
        "\5\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\3\4\2\uffff";
    static final String DFA10_maxS =
        "\1\4\2\32\2\uffff";
    static final String DFA10_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 574:1: ( rule__Timeperiod__Group_3_0_2__0 )*";
        }
    }
    static final String DFA14_eotS =
        "\5\uffff";
    static final String DFA14_eofS =
        "\5\uffff";
    static final String DFA14_minS =
        "\3\4\2\uffff";
    static final String DFA14_maxS =
        "\1\4\2\33\2\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA14_specialS =
        "\5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 873:1: ( rule__Timeperiod__Group_3_0_3_0_3__0 )*";
        }
    }
    static final String DFA17_eotS =
        "\5\uffff";
    static final String DFA17_eofS =
        "\5\uffff";
    static final String DFA17_minS =
        "\3\4\2\uffff";
    static final String DFA17_maxS =
        "\1\4\2\34\2\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()* loopback of 1073:1: ( rule__Timeperiod__Group_3_0_3_1_3__0 )*";
        }
    }
    static final String DFA19_eotS =
        "\5\uffff";
    static final String DFA19_eofS =
        "\5\uffff";
    static final String DFA19_minS =
        "\3\4\2\uffff";
    static final String DFA19_maxS =
        "\1\4\2\32\2\uffff";
    static final String DFA19_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA19_specialS =
        "\5\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\4\7\uffff\1\3",
            "\1\2\13\uffff\3\4\7\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()* loopback of 1240:1: ( rule__Timeperiod__Group_3_1_2__0 )*";
        }
    }
    static final String DFA23_eotS =
        "\5\uffff";
    static final String DFA23_eofS =
        "\5\uffff";
    static final String DFA23_minS =
        "\3\4\2\uffff";
    static final String DFA23_maxS =
        "\1\4\2\33\2\uffff";
    static final String DFA23_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\3\12\uffff\1\4",
            "\1\2\13\uffff\1\3\12\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 1539:1: ( rule__Timeperiod__Group_3_1_3_0_3__0 )*";
        }
    }
    static final String DFA26_eotS =
        "\5\uffff";
    static final String DFA26_eofS =
        "\5\uffff";
    static final String DFA26_minS =
        "\3\4\2\uffff";
    static final String DFA26_maxS =
        "\1\4\2\34\2\uffff";
    static final String DFA26_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA26_specialS =
        "\5\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\4\13\uffff\1\3",
            "\1\2\13\uffff\1\4\13\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "()* loopback of 1739:1: ( rule__Timeperiod__Group_3_1_3_1_3__0 )*";
        }
    }
    static final String DFA28_eotS =
        "\5\uffff";
    static final String DFA28_eofS =
        "\5\uffff";
    static final String DFA28_minS =
        "\3\4\2\uffff";
    static final String DFA28_maxS =
        "\1\4\2\32\2\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA28_specialS =
        "\5\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "\1\2\14\uffff\2\3\7\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()* loopback of 1906:1: ( rule__Timeperiod__Group_3_2_2__0 )*";
        }
    }
    static final String DFA29_eotS =
        "\5\uffff";
    static final String DFA29_eofS =
        "\5\uffff";
    static final String DFA29_minS =
        "\3\4\2\uffff";
    static final String DFA29_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA29_specialS =
        "\5\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\3\2\4",
            "\1\2\13\uffff\1\3\2\4",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()* loopback of 1941:1: ( rule__Timeperiod__Alternatives_3_2_3 )*";
        }
    }
    static final String DFA33_eotS =
        "\5\uffff";
    static final String DFA33_eofS =
        "\5\uffff";
    static final String DFA33_minS =
        "\3\4\2\uffff";
    static final String DFA33_maxS =
        "\1\4\2\33\2\uffff";
    static final String DFA33_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\5\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\4\10\uffff\1\3",
            "\1\2\13\uffff\3\4\10\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 2212:1: ( rule__Timeperiod__Group_3_2_3_0_3__0 )*";
        }
    }
    static final String DFA36_eotS =
        "\5\uffff";
    static final String DFA36_eofS =
        "\5\uffff";
    static final String DFA36_minS =
        "\3\4\2\uffff";
    static final String DFA36_maxS =
        "\1\4\2\34\2\uffff";
    static final String DFA36_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA36_specialS =
        "\5\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\4\11\uffff\1\3",
            "\1\2\13\uffff\3\4\11\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 2412:1: ( rule__Timeperiod__Group_3_2_3_1_3__0 )*";
        }
    }
    static final String DFA38_eotS =
        "\5\uffff";
    static final String DFA38_eofS =
        "\5\uffff";
    static final String DFA38_minS =
        "\3\4\2\uffff";
    static final String DFA38_maxS =
        "\1\4\2\32\2\uffff";
    static final String DFA38_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA38_specialS =
        "\5\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\3\7\uffff\1\4",
            "\1\2\13\uffff\3\3\7\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 2579:1: ( rule__Timeperiod__Group_3_3_2__0 )*";
        }
    }
    static final String DFA39_eotS =
        "\5\uffff";
    static final String DFA39_eofS =
        "\5\uffff";
    static final String DFA39_minS =
        "\3\4\2\uffff";
    static final String DFA39_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA39_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA39_specialS =
        "\5\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\4\2\3",
            "\1\2\13\uffff\1\4\2\3",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "()* loopback of 2608:1: ( rule__Timeperiod__Alternatives_3_3_3 )*";
        }
    }
    static final String DFA43_eotS =
        "\5\uffff";
    static final String DFA43_eofS =
        "\5\uffff";
    static final String DFA43_minS =
        "\3\4\2\uffff";
    static final String DFA43_maxS =
        "\1\4\2\33\2\uffff";
    static final String DFA43_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA43_specialS =
        "\5\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "\1\2\13\uffff\3\3\10\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 2878:1: ( rule__Timeperiod__Group_3_3_3_0_3__0 )*";
        }
    }
    static final String DFA46_eotS =
        "\5\uffff";
    static final String DFA46_eofS =
        "\5\uffff";
    static final String DFA46_minS =
        "\3\4\2\uffff";
    static final String DFA46_maxS =
        "\1\4\2\34\2\uffff";
    static final String DFA46_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA46_specialS =
        "\5\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "\1\2\13\uffff\3\3\11\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 3078:1: ( rule__Timeperiod__Group_3_3_3_1_3__0 )*";
        }
    }
    static final String DFA86_eotS =
        "\5\uffff";
    static final String DFA86_eofS =
        "\5\uffff";
    static final String DFA86_minS =
        "\3\4\2\uffff";
    static final String DFA86_maxS =
        "\1\4\2\22\2\uffff";
    static final String DFA86_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA86_specialS =
        "\1\2\1\1\1\0\2\uffff}>";
    static final String[] DFA86_transitionS = {
            "\1\1",
            "\1\2\14\uffff\1\4\1\3",
            "\1\2\14\uffff\1\4\1\3",
            "",
            ""
    };

    static final short[] DFA86_eot = DFA.unpackEncodedString(DFA86_eotS);
    static final short[] DFA86_eof = DFA.unpackEncodedString(DFA86_eofS);
    static final char[] DFA86_min = DFA.unpackEncodedStringToUnsignedChars(DFA86_minS);
    static final char[] DFA86_max = DFA.unpackEncodedStringToUnsignedChars(DFA86_maxS);
    static final short[] DFA86_accept = DFA.unpackEncodedString(DFA86_acceptS);
    static final short[] DFA86_special = DFA.unpackEncodedString(DFA86_specialS);
    static final short[][] DFA86_transition;

    static {
        int numStates = DFA86_transitionS.length;
        DFA86_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA86_transition[i] = DFA.unpackEncodedString(DFA86_transitionS[i]);
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = DFA86_eot;
            this.eof = DFA86_eof;
            this.min = DFA86_min;
            this.max = DFA86_max;
            this.accept = DFA86_accept;
            this.special = DFA86_special;
            this.transition = DFA86_transition;
        }
        public String getDescription() {
            return "6048:3: ( ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Timeperiod__Group_3_0_3_1__0 ) ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_2 = input.LA(1);

                         
                        int index86_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_2 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                        else if ( LA86_2 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) ) {s = 2;}

                        else if ( LA86_2 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                         
                        input.seek(index86_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA86_1 = input.LA(1);

                         
                        int index86_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_1 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) ) {s = 2;}

                        else if ( LA86_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 3;}

                        else if ( LA86_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 4;}

                         
                        input.seek(index86_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA86_0 = input.LA(1);

                         
                        int index86_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA86_0 == RULE_NL && ( getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) ) {s = 1;}

                         
                        input.seek(index86_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 86, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\6\uffff";
    static final String DFA87_eofS =
        "\6\uffff";
    static final String DFA87_minS =
        "\3\4\3\uffff";
    static final String DFA87_maxS =
        "\1\4\2\22\3\uffff";
    static final String DFA87_acceptS =
        "\3\uffff\1\1\1\2\1\1";
    static final String DFA87_specialS =
        "\1\uffff\1\1\1\0\3\uffff}>";
    static final String[] DFA87_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\4\1\3\1\5",
            "\1\2\13\uffff\1\4\1\3\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "6099:2: ( rule__Timeperiod__UnorderedGroup_3_0_3__1 )?";
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
                        if ( (LA87_2==16) ) {s = 4;}

                        else if ( (LA87_2==RULE_NL) ) {s = 2;}

                        else if ( LA87_2 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 3;}

                        else if ( LA87_2 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 5;}

                         
                        input.seek(index87_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA87_1==RULE_NL) ) {s = 2;}

                        else if ( LA87_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 3;}

                        else if ( (LA87_1==16) ) {s = 4;}

                        else if ( LA87_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 5;}

                         
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