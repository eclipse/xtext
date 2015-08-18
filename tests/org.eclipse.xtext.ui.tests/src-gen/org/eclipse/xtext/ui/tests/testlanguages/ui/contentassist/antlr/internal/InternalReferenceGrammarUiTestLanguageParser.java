package org.eclipse.xtext.ui.tests.testlanguages.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.testlanguages.services.ReferenceGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferenceGrammarUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'keyword'", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "','"
    };
    public static final int RULE_ID=5;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferenceGrammarUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferenceGrammarUiTestLanguage.g"; }


     
     	private ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleSpielplatz"
    // InternalReferenceGrammarUiTestLanguage.g:60:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:61:1: ( ruleSpielplatz EOF )
            // InternalReferenceGrammarUiTestLanguage.g:62:1: ruleSpielplatz EOF
            {
             before(grammarAccess.getSpielplatzRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSpielplatz();

            state._fsp--;

             after(grammarAccess.getSpielplatzRule()); 
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
    // $ANTLR end "entryRuleSpielplatz"


    // $ANTLR start "ruleSpielplatz"
    // InternalReferenceGrammarUiTestLanguage.g:69:1: ruleSpielplatz : ( ( rule__Spielplatz__Group__0 )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:73:2: ( ( ( rule__Spielplatz__Group__0 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:74:1: ( ( rule__Spielplatz__Group__0 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:74:1: ( ( rule__Spielplatz__Group__0 )? )
            // InternalReferenceGrammarUiTestLanguage.g:75:1: ( rule__Spielplatz__Group__0 )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:76:1: ( rule__Spielplatz__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:76:2: rule__Spielplatz__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpielplatzAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpielplatz"


    // $ANTLR start "entryRuleKind"
    // InternalReferenceGrammarUiTestLanguage.g:90:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:91:1: ( ruleKind EOF )
            // InternalReferenceGrammarUiTestLanguage.g:92:1: ruleKind EOF
            {
             before(grammarAccess.getKindRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKind();

            state._fsp--;

             after(grammarAccess.getKindRule()); 
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
    // $ANTLR end "entryRuleKind"


    // $ANTLR start "ruleKind"
    // InternalReferenceGrammarUiTestLanguage.g:99:1: ruleKind : ( ( rule__Kind__Group__0 ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:103:2: ( ( ( rule__Kind__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:104:1: ( ( rule__Kind__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:104:1: ( ( rule__Kind__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:105:1: ( rule__Kind__Group__0 )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:106:1: ( rule__Kind__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:106:2: rule__Kind__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKindAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKind"


    // $ANTLR start "entryRuleErwachsener"
    // InternalReferenceGrammarUiTestLanguage.g:118:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:119:1: ( ruleErwachsener EOF )
            // InternalReferenceGrammarUiTestLanguage.g:120:1: ruleErwachsener EOF
            {
             before(grammarAccess.getErwachsenerRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleErwachsener();

            state._fsp--;

             after(grammarAccess.getErwachsenerRule()); 
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
    // $ANTLR end "entryRuleErwachsener"


    // $ANTLR start "ruleErwachsener"
    // InternalReferenceGrammarUiTestLanguage.g:127:1: ruleErwachsener : ( ( rule__Erwachsener__Group__0 ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:131:2: ( ( ( rule__Erwachsener__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:132:1: ( ( rule__Erwachsener__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:132:1: ( ( rule__Erwachsener__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:133:1: ( rule__Erwachsener__Group__0 )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:134:1: ( rule__Erwachsener__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:134:2: rule__Erwachsener__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getErwachsenerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleErwachsener"


    // $ANTLR start "entryRuleSpielzeug"
    // InternalReferenceGrammarUiTestLanguage.g:146:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:147:1: ( ruleSpielzeug EOF )
            // InternalReferenceGrammarUiTestLanguage.g:148:1: ruleSpielzeug EOF
            {
             before(grammarAccess.getSpielzeugRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSpielzeug();

            state._fsp--;

             after(grammarAccess.getSpielzeugRule()); 
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
    // $ANTLR end "entryRuleSpielzeug"


    // $ANTLR start "ruleSpielzeug"
    // InternalReferenceGrammarUiTestLanguage.g:155:1: ruleSpielzeug : ( ( rule__Spielzeug__Group__0 ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:159:2: ( ( ( rule__Spielzeug__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:160:1: ( ( rule__Spielzeug__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:160:1: ( ( rule__Spielzeug__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:161:1: ( rule__Spielzeug__Group__0 )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:162:1: ( rule__Spielzeug__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:162:2: rule__Spielzeug__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpielzeugAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpielzeug"


    // $ANTLR start "entryRuleFarbe"
    // InternalReferenceGrammarUiTestLanguage.g:174:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:175:1: ( ruleFarbe EOF )
            // InternalReferenceGrammarUiTestLanguage.g:176:1: ruleFarbe EOF
            {
             before(grammarAccess.getFarbeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFarbe();

            state._fsp--;

             after(grammarAccess.getFarbeRule()); 
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
    // $ANTLR end "entryRuleFarbe"


    // $ANTLR start "ruleFarbe"
    // InternalReferenceGrammarUiTestLanguage.g:183:1: ruleFarbe : ( ( rule__Farbe__WertAssignment ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:187:2: ( ( ( rule__Farbe__WertAssignment ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:188:1: ( ( rule__Farbe__WertAssignment ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:188:1: ( ( rule__Farbe__WertAssignment ) )
            // InternalReferenceGrammarUiTestLanguage.g:189:1: ( rule__Farbe__WertAssignment )
            {
             before(grammarAccess.getFarbeAccess().getWertAssignment()); 
            // InternalReferenceGrammarUiTestLanguage.g:190:1: ( rule__Farbe__WertAssignment )
            // InternalReferenceGrammarUiTestLanguage.g:190:2: rule__Farbe__WertAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Farbe__WertAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFarbeAccess().getWertAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFarbe"


    // $ANTLR start "entryRuleFamilie"
    // InternalReferenceGrammarUiTestLanguage.g:202:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:203:1: ( ruleFamilie EOF )
            // InternalReferenceGrammarUiTestLanguage.g:204:1: ruleFamilie EOF
            {
             before(grammarAccess.getFamilieRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFamilie();

            state._fsp--;

             after(grammarAccess.getFamilieRule()); 
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
    // $ANTLR end "entryRuleFamilie"


    // $ANTLR start "ruleFamilie"
    // InternalReferenceGrammarUiTestLanguage.g:211:1: ruleFamilie : ( ( rule__Familie__Group__0 ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:215:2: ( ( ( rule__Familie__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:216:1: ( ( rule__Familie__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:216:1: ( ( rule__Familie__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:217:1: ( rule__Familie__Group__0 )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:218:1: ( rule__Familie__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:218:2: rule__Familie__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFamilie"


    // $ANTLR start "rule__Spielplatz__Alternatives_4"
    // InternalReferenceGrammarUiTestLanguage.g:230:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:234:1: ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt2=1;
                }
                break;
            case 22:
                {
                alt2=2;
                }
                break;
            case 23:
                {
                alt2=3;
                }
                break;
            case 24:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:235:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:235:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:236:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // InternalReferenceGrammarUiTestLanguage.g:237:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    // InternalReferenceGrammarUiTestLanguage.g:237:2: rule__Spielplatz__KinderAssignment_4_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__KinderAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:241:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:241:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:242:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // InternalReferenceGrammarUiTestLanguage.g:243:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    // InternalReferenceGrammarUiTestLanguage.g:243:2: rule__Spielplatz__ErzieherAssignment_4_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__ErzieherAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:247:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:247:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:248:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // InternalReferenceGrammarUiTestLanguage.g:249:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    // InternalReferenceGrammarUiTestLanguage.g:249:2: rule__Spielplatz__SpielzeugeAssignment_4_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__SpielzeugeAssignment_4_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarUiTestLanguage.g:253:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:253:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:254:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // InternalReferenceGrammarUiTestLanguage.g:255:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    // InternalReferenceGrammarUiTestLanguage.g:255:2: rule__Spielplatz__FamilieAssignment_4_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__FamilieAssignment_4_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 

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
    // $ANTLR end "rule__Spielplatz__Alternatives_4"


    // $ANTLR start "rule__Farbe__WertAlternatives_0"
    // InternalReferenceGrammarUiTestLanguage.g:265:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );
    public final void rule__Farbe__WertAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:269:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            case 14:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:270:1: ( 'ROT' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:270:1: ( 'ROT' )
                    // InternalReferenceGrammarUiTestLanguage.g:271:1: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:278:6: ( 'BLAU' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:278:6: ( 'BLAU' )
                    // InternalReferenceGrammarUiTestLanguage.g:279:1: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:286:6: ( 'GELB' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:286:6: ( 'GELB' )
                    // InternalReferenceGrammarUiTestLanguage.g:287:1: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarUiTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    // InternalReferenceGrammarUiTestLanguage.g:295:1: 'GR\\u00DCN'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3()); 

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
    // $ANTLR end "rule__Farbe__WertAlternatives_0"


    // $ANTLR start "rule__Familie__NameAlternatives_2_0"
    // InternalReferenceGrammarUiTestLanguage.g:307:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:311:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case RULE_STRING:
                {
                alt4=2;
                }
                break;
            case RULE_ID:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'keyword' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'keyword' )
                    // InternalReferenceGrammarUiTestLanguage.g:313:1: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:320:6: ( RULE_STRING )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:320:6: ( RULE_STRING )
                    // InternalReferenceGrammarUiTestLanguage.g:321:1: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:326:6: ( RULE_ID )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:326:6: ( RULE_ID )
                    // InternalReferenceGrammarUiTestLanguage.g:327:1: RULE_ID
                    {
                     before(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 

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
    // $ANTLR end "rule__Familie__NameAlternatives_2_0"


    // $ANTLR start "rule__Spielplatz__Group__0"
    // InternalReferenceGrammarUiTestLanguage.g:339:1: rule__Spielplatz__Group__0 : rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 ;
    public final void rule__Spielplatz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:343:1: ( rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:344:2: rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Spielplatz__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__0"


    // $ANTLR start "rule__Spielplatz__Group__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:351:1: rule__Spielplatz__Group__0__Impl : ( 'spielplatz' ) ;
    public final void rule__Spielplatz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:355:1: ( ( 'spielplatz' ) )
            // InternalReferenceGrammarUiTestLanguage.g:356:1: ( 'spielplatz' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:356:1: ( 'spielplatz' )
            // InternalReferenceGrammarUiTestLanguage.g:357:1: 'spielplatz'
            {
             before(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__0__Impl"


    // $ANTLR start "rule__Spielplatz__Group__1"
    // InternalReferenceGrammarUiTestLanguage.g:370:1: rule__Spielplatz__Group__1 : rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 ;
    public final void rule__Spielplatz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:374:1: ( rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:375:2: rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Spielplatz__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__1"


    // $ANTLR start "rule__Spielplatz__Group__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:382:1: rule__Spielplatz__Group__1__Impl : ( ( rule__Spielplatz__GroesseAssignment_1 ) ) ;
    public final void rule__Spielplatz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:386:1: ( ( ( rule__Spielplatz__GroesseAssignment_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:387:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:387:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:388:1: ( rule__Spielplatz__GroesseAssignment_1 )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:389:1: ( rule__Spielplatz__GroesseAssignment_1 )
            // InternalReferenceGrammarUiTestLanguage.g:389:2: rule__Spielplatz__GroesseAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__GroesseAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__1__Impl"


    // $ANTLR start "rule__Spielplatz__Group__2"
    // InternalReferenceGrammarUiTestLanguage.g:399:1: rule__Spielplatz__Group__2 : rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 ;
    public final void rule__Spielplatz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:403:1: ( rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:404:2: rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Spielplatz__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__2"


    // $ANTLR start "rule__Spielplatz__Group__2__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:411:1: rule__Spielplatz__Group__2__Impl : ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) ;
    public final void rule__Spielplatz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:415:1: ( ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:416:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:416:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            // InternalReferenceGrammarUiTestLanguage.g:417:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:418:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:418:2: rule__Spielplatz__BeschreibungAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Spielplatz__BeschreibungAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__2__Impl"


    // $ANTLR start "rule__Spielplatz__Group__3"
    // InternalReferenceGrammarUiTestLanguage.g:428:1: rule__Spielplatz__Group__3 : rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 ;
    public final void rule__Spielplatz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:432:1: ( rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:433:2: rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Spielplatz__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__3"


    // $ANTLR start "rule__Spielplatz__Group__3__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:440:1: rule__Spielplatz__Group__3__Impl : ( '{' ) ;
    public final void rule__Spielplatz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:444:1: ( ( '{' ) )
            // InternalReferenceGrammarUiTestLanguage.g:445:1: ( '{' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:445:1: ( '{' )
            // InternalReferenceGrammarUiTestLanguage.g:446:1: '{'
            {
             before(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__3__Impl"


    // $ANTLR start "rule__Spielplatz__Group__4"
    // InternalReferenceGrammarUiTestLanguage.g:459:1: rule__Spielplatz__Group__4 : rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 ;
    public final void rule__Spielplatz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:463:1: ( rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:464:2: rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Spielplatz__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__4"


    // $ANTLR start "rule__Spielplatz__Group__4__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:471:1: rule__Spielplatz__Group__4__Impl : ( ( rule__Spielplatz__Alternatives_4 )* ) ;
    public final void rule__Spielplatz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:475:1: ( ( ( rule__Spielplatz__Alternatives_4 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:476:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:476:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // InternalReferenceGrammarUiTestLanguage.g:477:1: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:478:1: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:478:2: rule__Spielplatz__Alternatives_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__Spielplatz__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__4__Impl"


    // $ANTLR start "rule__Spielplatz__Group__5"
    // InternalReferenceGrammarUiTestLanguage.g:488:1: rule__Spielplatz__Group__5 : rule__Spielplatz__Group__5__Impl ;
    public final void rule__Spielplatz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:492:1: ( rule__Spielplatz__Group__5__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:493:2: rule__Spielplatz__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielplatz__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__5"


    // $ANTLR start "rule__Spielplatz__Group__5__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:499:1: rule__Spielplatz__Group__5__Impl : ( '}' ) ;
    public final void rule__Spielplatz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:503:1: ( ( '}' ) )
            // InternalReferenceGrammarUiTestLanguage.g:504:1: ( '}' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:504:1: ( '}' )
            // InternalReferenceGrammarUiTestLanguage.g:505:1: '}'
            {
             before(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__Group__5__Impl"


    // $ANTLR start "rule__Kind__Group__0"
    // InternalReferenceGrammarUiTestLanguage.g:530:1: rule__Kind__Group__0 : rule__Kind__Group__0__Impl rule__Kind__Group__1 ;
    public final void rule__Kind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:534:1: ( rule__Kind__Group__0__Impl rule__Kind__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:535:2: rule__Kind__Group__0__Impl rule__Kind__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Kind__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__0"


    // $ANTLR start "rule__Kind__Group__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:542:1: rule__Kind__Group__0__Impl : ( 'kind' ) ;
    public final void rule__Kind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:546:1: ( ( 'kind' ) )
            // InternalReferenceGrammarUiTestLanguage.g:547:1: ( 'kind' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:547:1: ( 'kind' )
            // InternalReferenceGrammarUiTestLanguage.g:548:1: 'kind'
            {
             before(grammarAccess.getKindAccess().getKindKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKindAccess().getKindKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__0__Impl"


    // $ANTLR start "rule__Kind__Group__1"
    // InternalReferenceGrammarUiTestLanguage.g:561:1: rule__Kind__Group__1 : rule__Kind__Group__1__Impl rule__Kind__Group__2 ;
    public final void rule__Kind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:565:1: ( rule__Kind__Group__1__Impl rule__Kind__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:566:2: rule__Kind__Group__1__Impl rule__Kind__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Kind__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__1"


    // $ANTLR start "rule__Kind__Group__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:573:1: rule__Kind__Group__1__Impl : ( '(' ) ;
    public final void rule__Kind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:577:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:578:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:578:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:579:1: '('
            {
             before(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__1__Impl"


    // $ANTLR start "rule__Kind__Group__2"
    // InternalReferenceGrammarUiTestLanguage.g:592:1: rule__Kind__Group__2 : rule__Kind__Group__2__Impl rule__Kind__Group__3 ;
    public final void rule__Kind__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:596:1: ( rule__Kind__Group__2__Impl rule__Kind__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:597:2: rule__Kind__Group__2__Impl rule__Kind__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Kind__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__2"


    // $ANTLR start "rule__Kind__Group__2__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:604:1: rule__Kind__Group__2__Impl : ( ( rule__Kind__NameAssignment_2 ) ) ;
    public final void rule__Kind__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:608:1: ( ( ( rule__Kind__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:609:1: ( ( rule__Kind__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:609:1: ( ( rule__Kind__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:610:1: ( rule__Kind__NameAssignment_2 )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:611:1: ( rule__Kind__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:611:2: rule__Kind__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getKindAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__2__Impl"


    // $ANTLR start "rule__Kind__Group__3"
    // InternalReferenceGrammarUiTestLanguage.g:621:1: rule__Kind__Group__3 : rule__Kind__Group__3__Impl rule__Kind__Group__4 ;
    public final void rule__Kind__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:625:1: ( rule__Kind__Group__3__Impl rule__Kind__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:626:2: rule__Kind__Group__3__Impl rule__Kind__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Kind__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__3"


    // $ANTLR start "rule__Kind__Group__3__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:633:1: rule__Kind__Group__3__Impl : ( ( rule__Kind__AgeAssignment_3 ) ) ;
    public final void rule__Kind__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:637:1: ( ( ( rule__Kind__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:638:1: ( ( rule__Kind__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:638:1: ( ( rule__Kind__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:639:1: ( rule__Kind__AgeAssignment_3 )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:640:1: ( rule__Kind__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:640:2: rule__Kind__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__AgeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getKindAccess().getAgeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__3__Impl"


    // $ANTLR start "rule__Kind__Group__4"
    // InternalReferenceGrammarUiTestLanguage.g:650:1: rule__Kind__Group__4 : rule__Kind__Group__4__Impl ;
    public final void rule__Kind__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:654:1: ( rule__Kind__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:655:2: rule__Kind__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Kind__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__4"


    // $ANTLR start "rule__Kind__Group__4__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:661:1: rule__Kind__Group__4__Impl : ( ')' ) ;
    public final void rule__Kind__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:665:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:666:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:666:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:667:1: ')'
            {
             before(grammarAccess.getKindAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKindAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__Group__4__Impl"


    // $ANTLR start "rule__Erwachsener__Group__0"
    // InternalReferenceGrammarUiTestLanguage.g:690:1: rule__Erwachsener__Group__0 : rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 ;
    public final void rule__Erwachsener__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:694:1: ( rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:695:2: rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Erwachsener__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__0"


    // $ANTLR start "rule__Erwachsener__Group__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:702:1: rule__Erwachsener__Group__0__Impl : ( 'erwachsener' ) ;
    public final void rule__Erwachsener__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:706:1: ( ( 'erwachsener' ) )
            // InternalReferenceGrammarUiTestLanguage.g:707:1: ( 'erwachsener' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:707:1: ( 'erwachsener' )
            // InternalReferenceGrammarUiTestLanguage.g:708:1: 'erwachsener'
            {
             before(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__0__Impl"


    // $ANTLR start "rule__Erwachsener__Group__1"
    // InternalReferenceGrammarUiTestLanguage.g:721:1: rule__Erwachsener__Group__1 : rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 ;
    public final void rule__Erwachsener__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:725:1: ( rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:726:2: rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Erwachsener__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__1"


    // $ANTLR start "rule__Erwachsener__Group__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:733:1: rule__Erwachsener__Group__1__Impl : ( '(' ) ;
    public final void rule__Erwachsener__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:737:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:738:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:738:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:739:1: '('
            {
             before(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__1__Impl"


    // $ANTLR start "rule__Erwachsener__Group__2"
    // InternalReferenceGrammarUiTestLanguage.g:752:1: rule__Erwachsener__Group__2 : rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 ;
    public final void rule__Erwachsener__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:756:1: ( rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:757:2: rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Erwachsener__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__2"


    // $ANTLR start "rule__Erwachsener__Group__2__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:764:1: rule__Erwachsener__Group__2__Impl : ( ( rule__Erwachsener__NameAssignment_2 ) ) ;
    public final void rule__Erwachsener__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:768:1: ( ( ( rule__Erwachsener__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:769:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:769:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:770:1: ( rule__Erwachsener__NameAssignment_2 )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:771:1: ( rule__Erwachsener__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:771:2: rule__Erwachsener__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__2__Impl"


    // $ANTLR start "rule__Erwachsener__Group__3"
    // InternalReferenceGrammarUiTestLanguage.g:781:1: rule__Erwachsener__Group__3 : rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 ;
    public final void rule__Erwachsener__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:785:1: ( rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:786:2: rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Erwachsener__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__3"


    // $ANTLR start "rule__Erwachsener__Group__3__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:793:1: rule__Erwachsener__Group__3__Impl : ( ( rule__Erwachsener__AgeAssignment_3 ) ) ;
    public final void rule__Erwachsener__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:797:1: ( ( ( rule__Erwachsener__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:798:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:798:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:799:1: ( rule__Erwachsener__AgeAssignment_3 )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:800:1: ( rule__Erwachsener__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:800:2: rule__Erwachsener__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__AgeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__3__Impl"


    // $ANTLR start "rule__Erwachsener__Group__4"
    // InternalReferenceGrammarUiTestLanguage.g:810:1: rule__Erwachsener__Group__4 : rule__Erwachsener__Group__4__Impl ;
    public final void rule__Erwachsener__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:814:1: ( rule__Erwachsener__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:815:2: rule__Erwachsener__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Erwachsener__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__4"


    // $ANTLR start "rule__Erwachsener__Group__4__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:821:1: rule__Erwachsener__Group__4__Impl : ( ')' ) ;
    public final void rule__Erwachsener__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:825:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:826:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:826:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:827:1: ')'
            {
             before(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__Group__4__Impl"


    // $ANTLR start "rule__Spielzeug__Group__0"
    // InternalReferenceGrammarUiTestLanguage.g:850:1: rule__Spielzeug__Group__0 : rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 ;
    public final void rule__Spielzeug__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:854:1: ( rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:855:2: rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Spielzeug__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__0"


    // $ANTLR start "rule__Spielzeug__Group__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:862:1: rule__Spielzeug__Group__0__Impl : ( 'spielzeug' ) ;
    public final void rule__Spielzeug__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:866:1: ( ( 'spielzeug' ) )
            // InternalReferenceGrammarUiTestLanguage.g:867:1: ( 'spielzeug' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:867:1: ( 'spielzeug' )
            // InternalReferenceGrammarUiTestLanguage.g:868:1: 'spielzeug'
            {
             before(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__0__Impl"


    // $ANTLR start "rule__Spielzeug__Group__1"
    // InternalReferenceGrammarUiTestLanguage.g:881:1: rule__Spielzeug__Group__1 : rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 ;
    public final void rule__Spielzeug__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:885:1: ( rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:886:2: rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Spielzeug__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__1"


    // $ANTLR start "rule__Spielzeug__Group__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:893:1: rule__Spielzeug__Group__1__Impl : ( '(' ) ;
    public final void rule__Spielzeug__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:897:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:898:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:898:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:899:1: '('
            {
             before(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__1__Impl"


    // $ANTLR start "rule__Spielzeug__Group__2"
    // InternalReferenceGrammarUiTestLanguage.g:912:1: rule__Spielzeug__Group__2 : rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 ;
    public final void rule__Spielzeug__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:916:1: ( rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:917:2: rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Spielzeug__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__2"


    // $ANTLR start "rule__Spielzeug__Group__2__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:924:1: rule__Spielzeug__Group__2__Impl : ( ( rule__Spielzeug__NameAssignment_2 ) ) ;
    public final void rule__Spielzeug__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:928:1: ( ( ( rule__Spielzeug__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:929:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:929:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:930:1: ( rule__Spielzeug__NameAssignment_2 )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:931:1: ( rule__Spielzeug__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:931:2: rule__Spielzeug__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__2__Impl"


    // $ANTLR start "rule__Spielzeug__Group__3"
    // InternalReferenceGrammarUiTestLanguage.g:941:1: rule__Spielzeug__Group__3 : rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 ;
    public final void rule__Spielzeug__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:945:1: ( rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:946:2: rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Spielzeug__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__3"


    // $ANTLR start "rule__Spielzeug__Group__3__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:953:1: rule__Spielzeug__Group__3__Impl : ( ( rule__Spielzeug__FarbeAssignment_3 ) ) ;
    public final void rule__Spielzeug__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:957:1: ( ( ( rule__Spielzeug__FarbeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:958:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:958:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:959:1: ( rule__Spielzeug__FarbeAssignment_3 )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:960:1: ( rule__Spielzeug__FarbeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:960:2: rule__Spielzeug__FarbeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__FarbeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__3__Impl"


    // $ANTLR start "rule__Spielzeug__Group__4"
    // InternalReferenceGrammarUiTestLanguage.g:970:1: rule__Spielzeug__Group__4 : rule__Spielzeug__Group__4__Impl ;
    public final void rule__Spielzeug__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:974:1: ( rule__Spielzeug__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:975:2: rule__Spielzeug__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Spielzeug__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__4"


    // $ANTLR start "rule__Spielzeug__Group__4__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:981:1: rule__Spielzeug__Group__4__Impl : ( ')' ) ;
    public final void rule__Spielzeug__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:985:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:986:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:986:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:987:1: ')'
            {
             before(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__Group__4__Impl"


    // $ANTLR start "rule__Familie__Group__0"
    // InternalReferenceGrammarUiTestLanguage.g:1010:1: rule__Familie__Group__0 : rule__Familie__Group__0__Impl rule__Familie__Group__1 ;
    public final void rule__Familie__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1014:1: ( rule__Familie__Group__0__Impl rule__Familie__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:1015:2: rule__Familie__Group__0__Impl rule__Familie__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Familie__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__0"


    // $ANTLR start "rule__Familie__Group__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1022:1: rule__Familie__Group__0__Impl : ( 'familie' ) ;
    public final void rule__Familie__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1026:1: ( ( 'familie' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1027:1: ( 'familie' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1027:1: ( 'familie' )
            // InternalReferenceGrammarUiTestLanguage.g:1028:1: 'familie'
            {
             before(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__0__Impl"


    // $ANTLR start "rule__Familie__Group__1"
    // InternalReferenceGrammarUiTestLanguage.g:1041:1: rule__Familie__Group__1 : rule__Familie__Group__1__Impl rule__Familie__Group__2 ;
    public final void rule__Familie__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1045:1: ( rule__Familie__Group__1__Impl rule__Familie__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:1046:2: rule__Familie__Group__1__Impl rule__Familie__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Familie__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__1"


    // $ANTLR start "rule__Familie__Group__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1053:1: rule__Familie__Group__1__Impl : ( '(' ) ;
    public final void rule__Familie__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1057:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1058:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1058:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:1059:1: '('
            {
             before(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__1__Impl"


    // $ANTLR start "rule__Familie__Group__2"
    // InternalReferenceGrammarUiTestLanguage.g:1072:1: rule__Familie__Group__2 : rule__Familie__Group__2__Impl rule__Familie__Group__3 ;
    public final void rule__Familie__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1076:1: ( rule__Familie__Group__2__Impl rule__Familie__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:1077:2: rule__Familie__Group__2__Impl rule__Familie__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Familie__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__2"


    // $ANTLR start "rule__Familie__Group__2__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1084:1: rule__Familie__Group__2__Impl : ( ( rule__Familie__NameAssignment_2 ) ) ;
    public final void rule__Familie__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1088:1: ( ( ( rule__Familie__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1089:1: ( ( rule__Familie__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1089:1: ( ( rule__Familie__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1090:1: ( rule__Familie__NameAssignment_2 )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:1091:1: ( rule__Familie__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:1091:2: rule__Familie__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__2__Impl"


    // $ANTLR start "rule__Familie__Group__3"
    // InternalReferenceGrammarUiTestLanguage.g:1101:1: rule__Familie__Group__3 : rule__Familie__Group__3__Impl rule__Familie__Group__4 ;
    public final void rule__Familie__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1105:1: ( rule__Familie__Group__3__Impl rule__Familie__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:1106:2: rule__Familie__Group__3__Impl rule__Familie__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Familie__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__3"


    // $ANTLR start "rule__Familie__Group__3__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1113:1: rule__Familie__Group__3__Impl : ( ( rule__Familie__MutterAssignment_3 ) ) ;
    public final void rule__Familie__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1117:1: ( ( ( rule__Familie__MutterAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1118:1: ( ( rule__Familie__MutterAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1118:1: ( ( rule__Familie__MutterAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1119:1: ( rule__Familie__MutterAssignment_3 )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:1120:1: ( rule__Familie__MutterAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:1120:2: rule__Familie__MutterAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__MutterAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__3__Impl"


    // $ANTLR start "rule__Familie__Group__4"
    // InternalReferenceGrammarUiTestLanguage.g:1130:1: rule__Familie__Group__4 : rule__Familie__Group__4__Impl rule__Familie__Group__5 ;
    public final void rule__Familie__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1134:1: ( rule__Familie__Group__4__Impl rule__Familie__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:1135:2: rule__Familie__Group__4__Impl rule__Familie__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Familie__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__4"


    // $ANTLR start "rule__Familie__Group__4__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1142:1: rule__Familie__Group__4__Impl : ( ( rule__Familie__VaterAssignment_4 ) ) ;
    public final void rule__Familie__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1146:1: ( ( ( rule__Familie__VaterAssignment_4 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1147:1: ( ( rule__Familie__VaterAssignment_4 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1147:1: ( ( rule__Familie__VaterAssignment_4 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1148:1: ( rule__Familie__VaterAssignment_4 )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:1149:1: ( rule__Familie__VaterAssignment_4 )
            // InternalReferenceGrammarUiTestLanguage.g:1149:2: rule__Familie__VaterAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__VaterAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__4__Impl"


    // $ANTLR start "rule__Familie__Group__5"
    // InternalReferenceGrammarUiTestLanguage.g:1159:1: rule__Familie__Group__5 : rule__Familie__Group__5__Impl rule__Familie__Group__6 ;
    public final void rule__Familie__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1163:1: ( rule__Familie__Group__5__Impl rule__Familie__Group__6 )
            // InternalReferenceGrammarUiTestLanguage.g:1164:2: rule__Familie__Group__5__Impl rule__Familie__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Familie__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__5"


    // $ANTLR start "rule__Familie__Group__5__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1171:1: rule__Familie__Group__5__Impl : ( ( rule__Familie__KinderAssignment_5 ) ) ;
    public final void rule__Familie__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1175:1: ( ( ( rule__Familie__KinderAssignment_5 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1176:1: ( ( rule__Familie__KinderAssignment_5 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1176:1: ( ( rule__Familie__KinderAssignment_5 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1177:1: ( rule__Familie__KinderAssignment_5 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // InternalReferenceGrammarUiTestLanguage.g:1178:1: ( rule__Familie__KinderAssignment_5 )
            // InternalReferenceGrammarUiTestLanguage.g:1178:2: rule__Familie__KinderAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__KinderAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__5__Impl"


    // $ANTLR start "rule__Familie__Group__6"
    // InternalReferenceGrammarUiTestLanguage.g:1188:1: rule__Familie__Group__6 : rule__Familie__Group__6__Impl rule__Familie__Group__7 ;
    public final void rule__Familie__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1192:1: ( rule__Familie__Group__6__Impl rule__Familie__Group__7 )
            // InternalReferenceGrammarUiTestLanguage.g:1193:2: rule__Familie__Group__6__Impl rule__Familie__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Familie__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__6"


    // $ANTLR start "rule__Familie__Group__6__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1200:1: rule__Familie__Group__6__Impl : ( ( rule__Familie__Group_6__0 )* ) ;
    public final void rule__Familie__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1204:1: ( ( ( rule__Familie__Group_6__0 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:1205:1: ( ( rule__Familie__Group_6__0 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1205:1: ( ( rule__Familie__Group_6__0 )* )
            // InternalReferenceGrammarUiTestLanguage.g:1206:1: ( rule__Familie__Group_6__0 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // InternalReferenceGrammarUiTestLanguage.g:1207:1: ( rule__Familie__Group_6__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:1207:2: rule__Familie__Group_6__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    rule__Familie__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getFamilieAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__6__Impl"


    // $ANTLR start "rule__Familie__Group__7"
    // InternalReferenceGrammarUiTestLanguage.g:1217:1: rule__Familie__Group__7 : rule__Familie__Group__7__Impl ;
    public final void rule__Familie__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1221:1: ( rule__Familie__Group__7__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1222:2: rule__Familie__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__7"


    // $ANTLR start "rule__Familie__Group__7__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1228:1: rule__Familie__Group__7__Impl : ( ')' ) ;
    public final void rule__Familie__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1232:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1233:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1233:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:1234:1: ')'
            {
             before(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group__7__Impl"


    // $ANTLR start "rule__Familie__Group_6__0"
    // InternalReferenceGrammarUiTestLanguage.g:1263:1: rule__Familie__Group_6__0 : rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 ;
    public final void rule__Familie__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1267:1: ( rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 )
            // InternalReferenceGrammarUiTestLanguage.g:1268:2: rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Familie__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group_6__0"


    // $ANTLR start "rule__Familie__Group_6__0__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1275:1: rule__Familie__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Familie__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1279:1: ( ( ',' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1280:1: ( ',' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1280:1: ( ',' )
            // InternalReferenceGrammarUiTestLanguage.g:1281:1: ','
            {
             before(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group_6__0__Impl"


    // $ANTLR start "rule__Familie__Group_6__1"
    // InternalReferenceGrammarUiTestLanguage.g:1294:1: rule__Familie__Group_6__1 : rule__Familie__Group_6__1__Impl ;
    public final void rule__Familie__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1298:1: ( rule__Familie__Group_6__1__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1299:2: rule__Familie__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group_6__1"


    // $ANTLR start "rule__Familie__Group_6__1__Impl"
    // InternalReferenceGrammarUiTestLanguage.g:1305:1: rule__Familie__Group_6__1__Impl : ( ( rule__Familie__KinderAssignment_6_1 ) ) ;
    public final void rule__Familie__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1309:1: ( ( ( rule__Familie__KinderAssignment_6_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1310:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1310:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1311:1: ( rule__Familie__KinderAssignment_6_1 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:1312:1: ( rule__Familie__KinderAssignment_6_1 )
            // InternalReferenceGrammarUiTestLanguage.g:1312:2: rule__Familie__KinderAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__KinderAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__Group_6__1__Impl"


    // $ANTLR start "rule__Spielplatz__GroesseAssignment_1"
    // InternalReferenceGrammarUiTestLanguage.g:1327:1: rule__Spielplatz__GroesseAssignment_1 : ( RULE_INT ) ;
    public final void rule__Spielplatz__GroesseAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1331:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1332:1: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1332:1: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1333:1: RULE_INT
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__GroesseAssignment_1"


    // $ANTLR start "rule__Spielplatz__BeschreibungAssignment_2"
    // InternalReferenceGrammarUiTestLanguage.g:1342:1: rule__Spielplatz__BeschreibungAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Spielplatz__BeschreibungAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1346:1: ( ( RULE_STRING ) )
            // InternalReferenceGrammarUiTestLanguage.g:1347:1: ( RULE_STRING )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1347:1: ( RULE_STRING )
            // InternalReferenceGrammarUiTestLanguage.g:1348:1: RULE_STRING
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__BeschreibungAssignment_2"


    // $ANTLR start "rule__Spielplatz__KinderAssignment_4_0"
    // InternalReferenceGrammarUiTestLanguage.g:1357:1: rule__Spielplatz__KinderAssignment_4_0 : ( ruleKind ) ;
    public final void rule__Spielplatz__KinderAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1361:1: ( ( ruleKind ) )
            // InternalReferenceGrammarUiTestLanguage.g:1362:1: ( ruleKind )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1362:1: ( ruleKind )
            // InternalReferenceGrammarUiTestLanguage.g:1363:1: ruleKind
            {
             before(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKind();

            state._fsp--;

             after(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__KinderAssignment_4_0"


    // $ANTLR start "rule__Spielplatz__ErzieherAssignment_4_1"
    // InternalReferenceGrammarUiTestLanguage.g:1372:1: rule__Spielplatz__ErzieherAssignment_4_1 : ( ruleErwachsener ) ;
    public final void rule__Spielplatz__ErzieherAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1376:1: ( ( ruleErwachsener ) )
            // InternalReferenceGrammarUiTestLanguage.g:1377:1: ( ruleErwachsener )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1377:1: ( ruleErwachsener )
            // InternalReferenceGrammarUiTestLanguage.g:1378:1: ruleErwachsener
            {
             before(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleErwachsener();

            state._fsp--;

             after(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__ErzieherAssignment_4_1"


    // $ANTLR start "rule__Spielplatz__SpielzeugeAssignment_4_2"
    // InternalReferenceGrammarUiTestLanguage.g:1387:1: rule__Spielplatz__SpielzeugeAssignment_4_2 : ( ruleSpielzeug ) ;
    public final void rule__Spielplatz__SpielzeugeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1391:1: ( ( ruleSpielzeug ) )
            // InternalReferenceGrammarUiTestLanguage.g:1392:1: ( ruleSpielzeug )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1392:1: ( ruleSpielzeug )
            // InternalReferenceGrammarUiTestLanguage.g:1393:1: ruleSpielzeug
            {
             before(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSpielzeug();

            state._fsp--;

             after(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__SpielzeugeAssignment_4_2"


    // $ANTLR start "rule__Spielplatz__FamilieAssignment_4_3"
    // InternalReferenceGrammarUiTestLanguage.g:1402:1: rule__Spielplatz__FamilieAssignment_4_3 : ( ruleFamilie ) ;
    public final void rule__Spielplatz__FamilieAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1406:1: ( ( ruleFamilie ) )
            // InternalReferenceGrammarUiTestLanguage.g:1407:1: ( ruleFamilie )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1407:1: ( ruleFamilie )
            // InternalReferenceGrammarUiTestLanguage.g:1408:1: ruleFamilie
            {
             before(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFamilie();

            state._fsp--;

             after(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielplatz__FamilieAssignment_4_3"


    // $ANTLR start "rule__Kind__NameAssignment_2"
    // InternalReferenceGrammarUiTestLanguage.g:1417:1: rule__Kind__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Kind__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1421:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1422:1: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1422:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1423:1: RULE_ID
            {
             before(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__NameAssignment_2"


    // $ANTLR start "rule__Kind__AgeAssignment_3"
    // InternalReferenceGrammarUiTestLanguage.g:1432:1: rule__Kind__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Kind__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1436:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1437:1: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1437:1: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1438:1: RULE_INT
            {
             before(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Kind__AgeAssignment_3"


    // $ANTLR start "rule__Erwachsener__NameAssignment_2"
    // InternalReferenceGrammarUiTestLanguage.g:1447:1: rule__Erwachsener__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Erwachsener__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1451:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1452:1: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1452:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1453:1: RULE_ID
            {
             before(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__NameAssignment_2"


    // $ANTLR start "rule__Erwachsener__AgeAssignment_3"
    // InternalReferenceGrammarUiTestLanguage.g:1462:1: rule__Erwachsener__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Erwachsener__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1466:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1467:1: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1467:1: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1468:1: RULE_INT
            {
             before(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Erwachsener__AgeAssignment_3"


    // $ANTLR start "rule__Spielzeug__NameAssignment_2"
    // InternalReferenceGrammarUiTestLanguage.g:1477:1: rule__Spielzeug__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Spielzeug__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1481:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1482:1: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1482:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1483:1: RULE_ID
            {
             before(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__NameAssignment_2"


    // $ANTLR start "rule__Spielzeug__FarbeAssignment_3"
    // InternalReferenceGrammarUiTestLanguage.g:1492:1: rule__Spielzeug__FarbeAssignment_3 : ( ruleFarbe ) ;
    public final void rule__Spielzeug__FarbeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1496:1: ( ( ruleFarbe ) )
            // InternalReferenceGrammarUiTestLanguage.g:1497:1: ( ruleFarbe )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1497:1: ( ruleFarbe )
            // InternalReferenceGrammarUiTestLanguage.g:1498:1: ruleFarbe
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFarbe();

            state._fsp--;

             after(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Spielzeug__FarbeAssignment_3"


    // $ANTLR start "rule__Farbe__WertAssignment"
    // InternalReferenceGrammarUiTestLanguage.g:1507:1: rule__Farbe__WertAssignment : ( ( rule__Farbe__WertAlternatives_0 ) ) ;
    public final void rule__Farbe__WertAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1511:1: ( ( ( rule__Farbe__WertAlternatives_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1512:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1512:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1513:1: ( rule__Farbe__WertAlternatives_0 )
            {
             before(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1514:1: ( rule__Farbe__WertAlternatives_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1514:2: rule__Farbe__WertAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Farbe__WertAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Farbe__WertAssignment"


    // $ANTLR start "rule__Familie__NameAssignment_2"
    // InternalReferenceGrammarUiTestLanguage.g:1523:1: rule__Familie__NameAssignment_2 : ( ( rule__Familie__NameAlternatives_2_0 ) ) ;
    public final void rule__Familie__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1527:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1528:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1528:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1529:1: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1530:1: ( rule__Familie__NameAlternatives_2_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1530:2: rule__Familie__NameAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Familie__NameAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__NameAssignment_2"


    // $ANTLR start "rule__Familie__MutterAssignment_3"
    // InternalReferenceGrammarUiTestLanguage.g:1539:1: rule__Familie__MutterAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__MutterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1543:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1544:1: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1544:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1545:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1546:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1547:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__MutterAssignment_3"


    // $ANTLR start "rule__Familie__VaterAssignment_4"
    // InternalReferenceGrammarUiTestLanguage.g:1558:1: rule__Familie__VaterAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__VaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1562:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1563:1: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1563:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1564:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1565:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1566:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__VaterAssignment_4"


    // $ANTLR start "rule__Familie__KinderAssignment_5"
    // InternalReferenceGrammarUiTestLanguage.g:1577:1: rule__Familie__KinderAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1581:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1582:1: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1582:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1583:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1584:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1585:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__KinderAssignment_5"


    // $ANTLR start "rule__Familie__KinderAssignment_6_1"
    // InternalReferenceGrammarUiTestLanguage.g:1596:1: rule__Familie__KinderAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1600:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1601:1: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1601:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1602:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1603:1: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1604:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Familie__KinderAssignment_6_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001CC0000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001C80002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002200000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000002L});
    }


}