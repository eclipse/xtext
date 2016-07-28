package org.eclipse.xtext.ui.tests.testlanguages.ide.contentassist.antlr.internal;

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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalReferenceGrammarUiTestLanguage.g:53:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:54:1: ( ruleSpielplatz EOF )
            // InternalReferenceGrammarUiTestLanguage.g:55:1: ruleSpielplatz EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:62:1: ruleSpielplatz : ( ( rule__Spielplatz__Group__0 )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:66:2: ( ( ( rule__Spielplatz__Group__0 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:67:2: ( ( rule__Spielplatz__Group__0 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:67:2: ( ( rule__Spielplatz__Group__0 )? )
            // InternalReferenceGrammarUiTestLanguage.g:68:3: ( rule__Spielplatz__Group__0 )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:69:3: ( rule__Spielplatz__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:69:4: rule__Spielplatz__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:78:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:79:1: ( ruleKind EOF )
            // InternalReferenceGrammarUiTestLanguage.g:80:1: ruleKind EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:87:1: ruleKind : ( ( rule__Kind__Group__0 ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:91:2: ( ( ( rule__Kind__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:92:2: ( ( rule__Kind__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:92:2: ( ( rule__Kind__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:93:3: ( rule__Kind__Group__0 )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:94:3: ( rule__Kind__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:94:4: rule__Kind__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:103:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:104:1: ( ruleErwachsener EOF )
            // InternalReferenceGrammarUiTestLanguage.g:105:1: ruleErwachsener EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:112:1: ruleErwachsener : ( ( rule__Erwachsener__Group__0 ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:116:2: ( ( ( rule__Erwachsener__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:117:2: ( ( rule__Erwachsener__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:117:2: ( ( rule__Erwachsener__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:118:3: ( rule__Erwachsener__Group__0 )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:119:3: ( rule__Erwachsener__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:119:4: rule__Erwachsener__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:128:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:129:1: ( ruleSpielzeug EOF )
            // InternalReferenceGrammarUiTestLanguage.g:130:1: ruleSpielzeug EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:137:1: ruleSpielzeug : ( ( rule__Spielzeug__Group__0 ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:141:2: ( ( ( rule__Spielzeug__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:142:2: ( ( rule__Spielzeug__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:142:2: ( ( rule__Spielzeug__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:143:3: ( rule__Spielzeug__Group__0 )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:144:3: ( rule__Spielzeug__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:144:4: rule__Spielzeug__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:153:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:154:1: ( ruleFarbe EOF )
            // InternalReferenceGrammarUiTestLanguage.g:155:1: ruleFarbe EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:162:1: ruleFarbe : ( ( rule__Farbe__WertAssignment ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:166:2: ( ( ( rule__Farbe__WertAssignment ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:167:2: ( ( rule__Farbe__WertAssignment ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:167:2: ( ( rule__Farbe__WertAssignment ) )
            // InternalReferenceGrammarUiTestLanguage.g:168:3: ( rule__Farbe__WertAssignment )
            {
             before(grammarAccess.getFarbeAccess().getWertAssignment()); 
            // InternalReferenceGrammarUiTestLanguage.g:169:3: ( rule__Farbe__WertAssignment )
            // InternalReferenceGrammarUiTestLanguage.g:169:4: rule__Farbe__WertAssignment
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
    // InternalReferenceGrammarUiTestLanguage.g:178:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:179:1: ( ruleFamilie EOF )
            // InternalReferenceGrammarUiTestLanguage.g:180:1: ruleFamilie EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:187:1: ruleFamilie : ( ( rule__Familie__Group__0 ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:191:2: ( ( ( rule__Familie__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:192:2: ( ( rule__Familie__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:192:2: ( ( rule__Familie__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:193:3: ( rule__Familie__Group__0 )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:194:3: ( rule__Familie__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:194:4: rule__Familie__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:202:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:206:1: ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:207:2: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:207:2: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:208:3: ( rule__Spielplatz__KinderAssignment_4_0 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // InternalReferenceGrammarUiTestLanguage.g:209:3: ( rule__Spielplatz__KinderAssignment_4_0 )
                    // InternalReferenceGrammarUiTestLanguage.g:209:4: rule__Spielplatz__KinderAssignment_4_0
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
                    // InternalReferenceGrammarUiTestLanguage.g:213:2: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:213:2: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:214:3: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // InternalReferenceGrammarUiTestLanguage.g:215:3: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    // InternalReferenceGrammarUiTestLanguage.g:215:4: rule__Spielplatz__ErzieherAssignment_4_1
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
                    // InternalReferenceGrammarUiTestLanguage.g:219:2: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:219:2: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:220:3: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // InternalReferenceGrammarUiTestLanguage.g:221:3: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    // InternalReferenceGrammarUiTestLanguage.g:221:4: rule__Spielplatz__SpielzeugeAssignment_4_2
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
                    // InternalReferenceGrammarUiTestLanguage.g:225:2: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:225:2: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:226:3: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // InternalReferenceGrammarUiTestLanguage.g:227:3: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    // InternalReferenceGrammarUiTestLanguage.g:227:4: rule__Spielplatz__FamilieAssignment_4_3
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
    // InternalReferenceGrammarUiTestLanguage.g:235:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );
    public final void rule__Farbe__WertAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:239:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:240:2: ( 'ROT' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:240:2: ( 'ROT' )
                    // InternalReferenceGrammarUiTestLanguage.g:241:3: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:246:2: ( 'BLAU' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:246:2: ( 'BLAU' )
                    // InternalReferenceGrammarUiTestLanguage.g:247:3: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:252:2: ( 'GELB' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:252:2: ( 'GELB' )
                    // InternalReferenceGrammarUiTestLanguage.g:253:3: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarUiTestLanguage.g:258:2: ( 'GR\\u00DCN' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:258:2: ( 'GR\\u00DCN' )
                    // InternalReferenceGrammarUiTestLanguage.g:259:3: 'GR\\u00DCN'
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
    // InternalReferenceGrammarUiTestLanguage.g:268:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:272:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:273:2: ( 'keyword' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:273:2: ( 'keyword' )
                    // InternalReferenceGrammarUiTestLanguage.g:274:3: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:279:2: ( RULE_STRING )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:279:2: ( RULE_STRING )
                    // InternalReferenceGrammarUiTestLanguage.g:280:3: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:285:2: ( RULE_ID )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:285:2: ( RULE_ID )
                    // InternalReferenceGrammarUiTestLanguage.g:286:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:295:1: rule__Spielplatz__Group__0 : rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 ;
    public final void rule__Spielplatz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:299:1: ( rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:300:2: rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:307:1: rule__Spielplatz__Group__0__Impl : ( 'spielplatz' ) ;
    public final void rule__Spielplatz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:311:1: ( ( 'spielplatz' ) )
            // InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'spielplatz' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'spielplatz' )
            // InternalReferenceGrammarUiTestLanguage.g:313:2: 'spielplatz'
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
    // InternalReferenceGrammarUiTestLanguage.g:322:1: rule__Spielplatz__Group__1 : rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 ;
    public final void rule__Spielplatz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:326:1: ( rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:327:2: rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:334:1: rule__Spielplatz__Group__1__Impl : ( ( rule__Spielplatz__GroesseAssignment_1 ) ) ;
    public final void rule__Spielplatz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:338:1: ( ( ( rule__Spielplatz__GroesseAssignment_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:339:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:339:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:340:2: ( rule__Spielplatz__GroesseAssignment_1 )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:341:2: ( rule__Spielplatz__GroesseAssignment_1 )
            // InternalReferenceGrammarUiTestLanguage.g:341:3: rule__Spielplatz__GroesseAssignment_1
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
    // InternalReferenceGrammarUiTestLanguage.g:349:1: rule__Spielplatz__Group__2 : rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 ;
    public final void rule__Spielplatz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:353:1: ( rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:354:2: rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:361:1: rule__Spielplatz__Group__2__Impl : ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) ;
    public final void rule__Spielplatz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:365:1: ( ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:366:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:366:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            // InternalReferenceGrammarUiTestLanguage.g:367:2: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:368:2: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:368:3: rule__Spielplatz__BeschreibungAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:376:1: rule__Spielplatz__Group__3 : rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 ;
    public final void rule__Spielplatz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:380:1: ( rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:381:2: rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:388:1: rule__Spielplatz__Group__3__Impl : ( '{' ) ;
    public final void rule__Spielplatz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:392:1: ( ( '{' ) )
            // InternalReferenceGrammarUiTestLanguage.g:393:1: ( '{' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:393:1: ( '{' )
            // InternalReferenceGrammarUiTestLanguage.g:394:2: '{'
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
    // InternalReferenceGrammarUiTestLanguage.g:403:1: rule__Spielplatz__Group__4 : rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 ;
    public final void rule__Spielplatz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:407:1: ( rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:408:2: rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5
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
    // InternalReferenceGrammarUiTestLanguage.g:415:1: rule__Spielplatz__Group__4__Impl : ( ( rule__Spielplatz__Alternatives_4 )* ) ;
    public final void rule__Spielplatz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:419:1: ( ( ( rule__Spielplatz__Alternatives_4 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:420:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:420:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // InternalReferenceGrammarUiTestLanguage.g:421:2: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:422:2: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:422:3: rule__Spielplatz__Alternatives_4
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
    // InternalReferenceGrammarUiTestLanguage.g:430:1: rule__Spielplatz__Group__5 : rule__Spielplatz__Group__5__Impl ;
    public final void rule__Spielplatz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:434:1: ( rule__Spielplatz__Group__5__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:435:2: rule__Spielplatz__Group__5__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:441:1: rule__Spielplatz__Group__5__Impl : ( '}' ) ;
    public final void rule__Spielplatz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:445:1: ( ( '}' ) )
            // InternalReferenceGrammarUiTestLanguage.g:446:1: ( '}' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:446:1: ( '}' )
            // InternalReferenceGrammarUiTestLanguage.g:447:2: '}'
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
    // InternalReferenceGrammarUiTestLanguage.g:457:1: rule__Kind__Group__0 : rule__Kind__Group__0__Impl rule__Kind__Group__1 ;
    public final void rule__Kind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:461:1: ( rule__Kind__Group__0__Impl rule__Kind__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:462:2: rule__Kind__Group__0__Impl rule__Kind__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:469:1: rule__Kind__Group__0__Impl : ( 'kind' ) ;
    public final void rule__Kind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:473:1: ( ( 'kind' ) )
            // InternalReferenceGrammarUiTestLanguage.g:474:1: ( 'kind' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:474:1: ( 'kind' )
            // InternalReferenceGrammarUiTestLanguage.g:475:2: 'kind'
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
    // InternalReferenceGrammarUiTestLanguage.g:484:1: rule__Kind__Group__1 : rule__Kind__Group__1__Impl rule__Kind__Group__2 ;
    public final void rule__Kind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:488:1: ( rule__Kind__Group__1__Impl rule__Kind__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:489:2: rule__Kind__Group__1__Impl rule__Kind__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:496:1: rule__Kind__Group__1__Impl : ( '(' ) ;
    public final void rule__Kind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:500:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:501:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:501:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:502:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:511:1: rule__Kind__Group__2 : rule__Kind__Group__2__Impl rule__Kind__Group__3 ;
    public final void rule__Kind__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:515:1: ( rule__Kind__Group__2__Impl rule__Kind__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:516:2: rule__Kind__Group__2__Impl rule__Kind__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:523:1: rule__Kind__Group__2__Impl : ( ( rule__Kind__NameAssignment_2 ) ) ;
    public final void rule__Kind__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:527:1: ( ( ( rule__Kind__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:528:1: ( ( rule__Kind__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:528:1: ( ( rule__Kind__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:529:2: ( rule__Kind__NameAssignment_2 )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:530:2: ( rule__Kind__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:530:3: rule__Kind__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:538:1: rule__Kind__Group__3 : rule__Kind__Group__3__Impl rule__Kind__Group__4 ;
    public final void rule__Kind__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:542:1: ( rule__Kind__Group__3__Impl rule__Kind__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:543:2: rule__Kind__Group__3__Impl rule__Kind__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:550:1: rule__Kind__Group__3__Impl : ( ( rule__Kind__AgeAssignment_3 ) ) ;
    public final void rule__Kind__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:554:1: ( ( ( rule__Kind__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:555:1: ( ( rule__Kind__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:555:1: ( ( rule__Kind__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:556:2: ( rule__Kind__AgeAssignment_3 )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:557:2: ( rule__Kind__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:557:3: rule__Kind__AgeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:565:1: rule__Kind__Group__4 : rule__Kind__Group__4__Impl ;
    public final void rule__Kind__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:569:1: ( rule__Kind__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:570:2: rule__Kind__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:576:1: rule__Kind__Group__4__Impl : ( ')' ) ;
    public final void rule__Kind__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:580:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:581:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:581:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:582:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:592:1: rule__Erwachsener__Group__0 : rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 ;
    public final void rule__Erwachsener__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:596:1: ( rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:597:2: rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:604:1: rule__Erwachsener__Group__0__Impl : ( 'erwachsener' ) ;
    public final void rule__Erwachsener__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:608:1: ( ( 'erwachsener' ) )
            // InternalReferenceGrammarUiTestLanguage.g:609:1: ( 'erwachsener' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:609:1: ( 'erwachsener' )
            // InternalReferenceGrammarUiTestLanguage.g:610:2: 'erwachsener'
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
    // InternalReferenceGrammarUiTestLanguage.g:619:1: rule__Erwachsener__Group__1 : rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 ;
    public final void rule__Erwachsener__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:623:1: ( rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:624:2: rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:631:1: rule__Erwachsener__Group__1__Impl : ( '(' ) ;
    public final void rule__Erwachsener__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:635:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:636:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:636:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:637:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:646:1: rule__Erwachsener__Group__2 : rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 ;
    public final void rule__Erwachsener__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:650:1: ( rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:651:2: rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:658:1: rule__Erwachsener__Group__2__Impl : ( ( rule__Erwachsener__NameAssignment_2 ) ) ;
    public final void rule__Erwachsener__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:662:1: ( ( ( rule__Erwachsener__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:663:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:663:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:664:2: ( rule__Erwachsener__NameAssignment_2 )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:665:2: ( rule__Erwachsener__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:665:3: rule__Erwachsener__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:673:1: rule__Erwachsener__Group__3 : rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 ;
    public final void rule__Erwachsener__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:677:1: ( rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:678:2: rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:685:1: rule__Erwachsener__Group__3__Impl : ( ( rule__Erwachsener__AgeAssignment_3 ) ) ;
    public final void rule__Erwachsener__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:689:1: ( ( ( rule__Erwachsener__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:690:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:690:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:691:2: ( rule__Erwachsener__AgeAssignment_3 )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:692:2: ( rule__Erwachsener__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:692:3: rule__Erwachsener__AgeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:700:1: rule__Erwachsener__Group__4 : rule__Erwachsener__Group__4__Impl ;
    public final void rule__Erwachsener__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:704:1: ( rule__Erwachsener__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:705:2: rule__Erwachsener__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:711:1: rule__Erwachsener__Group__4__Impl : ( ')' ) ;
    public final void rule__Erwachsener__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:715:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:716:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:716:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:717:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:727:1: rule__Spielzeug__Group__0 : rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 ;
    public final void rule__Spielzeug__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:731:1: ( rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:732:2: rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:739:1: rule__Spielzeug__Group__0__Impl : ( 'spielzeug' ) ;
    public final void rule__Spielzeug__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:743:1: ( ( 'spielzeug' ) )
            // InternalReferenceGrammarUiTestLanguage.g:744:1: ( 'spielzeug' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:744:1: ( 'spielzeug' )
            // InternalReferenceGrammarUiTestLanguage.g:745:2: 'spielzeug'
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
    // InternalReferenceGrammarUiTestLanguage.g:754:1: rule__Spielzeug__Group__1 : rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 ;
    public final void rule__Spielzeug__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:758:1: ( rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:759:2: rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:766:1: rule__Spielzeug__Group__1__Impl : ( '(' ) ;
    public final void rule__Spielzeug__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:770:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:771:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:771:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:772:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:781:1: rule__Spielzeug__Group__2 : rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 ;
    public final void rule__Spielzeug__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:785:1: ( rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:786:2: rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:793:1: rule__Spielzeug__Group__2__Impl : ( ( rule__Spielzeug__NameAssignment_2 ) ) ;
    public final void rule__Spielzeug__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:797:1: ( ( ( rule__Spielzeug__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:798:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:798:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:799:2: ( rule__Spielzeug__NameAssignment_2 )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:800:2: ( rule__Spielzeug__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:800:3: rule__Spielzeug__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:808:1: rule__Spielzeug__Group__3 : rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 ;
    public final void rule__Spielzeug__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:812:1: ( rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:813:2: rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:820:1: rule__Spielzeug__Group__3__Impl : ( ( rule__Spielzeug__FarbeAssignment_3 ) ) ;
    public final void rule__Spielzeug__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:824:1: ( ( ( rule__Spielzeug__FarbeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:825:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:825:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:826:2: ( rule__Spielzeug__FarbeAssignment_3 )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:827:2: ( rule__Spielzeug__FarbeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:827:3: rule__Spielzeug__FarbeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:835:1: rule__Spielzeug__Group__4 : rule__Spielzeug__Group__4__Impl ;
    public final void rule__Spielzeug__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:839:1: ( rule__Spielzeug__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:840:2: rule__Spielzeug__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:846:1: rule__Spielzeug__Group__4__Impl : ( ')' ) ;
    public final void rule__Spielzeug__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:850:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:851:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:851:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:852:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:862:1: rule__Familie__Group__0 : rule__Familie__Group__0__Impl rule__Familie__Group__1 ;
    public final void rule__Familie__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:866:1: ( rule__Familie__Group__0__Impl rule__Familie__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:867:2: rule__Familie__Group__0__Impl rule__Familie__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:874:1: rule__Familie__Group__0__Impl : ( 'familie' ) ;
    public final void rule__Familie__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:878:1: ( ( 'familie' ) )
            // InternalReferenceGrammarUiTestLanguage.g:879:1: ( 'familie' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:879:1: ( 'familie' )
            // InternalReferenceGrammarUiTestLanguage.g:880:2: 'familie'
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
    // InternalReferenceGrammarUiTestLanguage.g:889:1: rule__Familie__Group__1 : rule__Familie__Group__1__Impl rule__Familie__Group__2 ;
    public final void rule__Familie__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:893:1: ( rule__Familie__Group__1__Impl rule__Familie__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:894:2: rule__Familie__Group__1__Impl rule__Familie__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:901:1: rule__Familie__Group__1__Impl : ( '(' ) ;
    public final void rule__Familie__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:905:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:906:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:906:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:907:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:916:1: rule__Familie__Group__2 : rule__Familie__Group__2__Impl rule__Familie__Group__3 ;
    public final void rule__Familie__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:920:1: ( rule__Familie__Group__2__Impl rule__Familie__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:921:2: rule__Familie__Group__2__Impl rule__Familie__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:928:1: rule__Familie__Group__2__Impl : ( ( rule__Familie__NameAssignment_2 ) ) ;
    public final void rule__Familie__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:932:1: ( ( ( rule__Familie__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:933:1: ( ( rule__Familie__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:933:1: ( ( rule__Familie__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:934:2: ( rule__Familie__NameAssignment_2 )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:935:2: ( rule__Familie__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:935:3: rule__Familie__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:943:1: rule__Familie__Group__3 : rule__Familie__Group__3__Impl rule__Familie__Group__4 ;
    public final void rule__Familie__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:947:1: ( rule__Familie__Group__3__Impl rule__Familie__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:948:2: rule__Familie__Group__3__Impl rule__Familie__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:955:1: rule__Familie__Group__3__Impl : ( ( rule__Familie__MutterAssignment_3 ) ) ;
    public final void rule__Familie__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:959:1: ( ( ( rule__Familie__MutterAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:960:1: ( ( rule__Familie__MutterAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:960:1: ( ( rule__Familie__MutterAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:961:2: ( rule__Familie__MutterAssignment_3 )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:962:2: ( rule__Familie__MutterAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:962:3: rule__Familie__MutterAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:970:1: rule__Familie__Group__4 : rule__Familie__Group__4__Impl rule__Familie__Group__5 ;
    public final void rule__Familie__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:974:1: ( rule__Familie__Group__4__Impl rule__Familie__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:975:2: rule__Familie__Group__4__Impl rule__Familie__Group__5
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
    // InternalReferenceGrammarUiTestLanguage.g:982:1: rule__Familie__Group__4__Impl : ( ( rule__Familie__VaterAssignment_4 ) ) ;
    public final void rule__Familie__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:986:1: ( ( ( rule__Familie__VaterAssignment_4 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:987:1: ( ( rule__Familie__VaterAssignment_4 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:987:1: ( ( rule__Familie__VaterAssignment_4 ) )
            // InternalReferenceGrammarUiTestLanguage.g:988:2: ( rule__Familie__VaterAssignment_4 )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:989:2: ( rule__Familie__VaterAssignment_4 )
            // InternalReferenceGrammarUiTestLanguage.g:989:3: rule__Familie__VaterAssignment_4
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
    // InternalReferenceGrammarUiTestLanguage.g:997:1: rule__Familie__Group__5 : rule__Familie__Group__5__Impl rule__Familie__Group__6 ;
    public final void rule__Familie__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1001:1: ( rule__Familie__Group__5__Impl rule__Familie__Group__6 )
            // InternalReferenceGrammarUiTestLanguage.g:1002:2: rule__Familie__Group__5__Impl rule__Familie__Group__6
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
    // InternalReferenceGrammarUiTestLanguage.g:1009:1: rule__Familie__Group__5__Impl : ( ( rule__Familie__KinderAssignment_5 ) ) ;
    public final void rule__Familie__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1013:1: ( ( ( rule__Familie__KinderAssignment_5 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1014:1: ( ( rule__Familie__KinderAssignment_5 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1014:1: ( ( rule__Familie__KinderAssignment_5 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1015:2: ( rule__Familie__KinderAssignment_5 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // InternalReferenceGrammarUiTestLanguage.g:1016:2: ( rule__Familie__KinderAssignment_5 )
            // InternalReferenceGrammarUiTestLanguage.g:1016:3: rule__Familie__KinderAssignment_5
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
    // InternalReferenceGrammarUiTestLanguage.g:1024:1: rule__Familie__Group__6 : rule__Familie__Group__6__Impl rule__Familie__Group__7 ;
    public final void rule__Familie__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1028:1: ( rule__Familie__Group__6__Impl rule__Familie__Group__7 )
            // InternalReferenceGrammarUiTestLanguage.g:1029:2: rule__Familie__Group__6__Impl rule__Familie__Group__7
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
    // InternalReferenceGrammarUiTestLanguage.g:1036:1: rule__Familie__Group__6__Impl : ( ( rule__Familie__Group_6__0 )* ) ;
    public final void rule__Familie__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1040:1: ( ( ( rule__Familie__Group_6__0 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:1041:1: ( ( rule__Familie__Group_6__0 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1041:1: ( ( rule__Familie__Group_6__0 )* )
            // InternalReferenceGrammarUiTestLanguage.g:1042:2: ( rule__Familie__Group_6__0 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // InternalReferenceGrammarUiTestLanguage.g:1043:2: ( rule__Familie__Group_6__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:1043:3: rule__Familie__Group_6__0
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
    // InternalReferenceGrammarUiTestLanguage.g:1051:1: rule__Familie__Group__7 : rule__Familie__Group__7__Impl ;
    public final void rule__Familie__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1055:1: ( rule__Familie__Group__7__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1056:2: rule__Familie__Group__7__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:1062:1: rule__Familie__Group__7__Impl : ( ')' ) ;
    public final void rule__Familie__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1066:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1067:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1067:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:1068:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:1078:1: rule__Familie__Group_6__0 : rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 ;
    public final void rule__Familie__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1082:1: ( rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 )
            // InternalReferenceGrammarUiTestLanguage.g:1083:2: rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1
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
    // InternalReferenceGrammarUiTestLanguage.g:1090:1: rule__Familie__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Familie__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1094:1: ( ( ',' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1095:1: ( ',' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1095:1: ( ',' )
            // InternalReferenceGrammarUiTestLanguage.g:1096:2: ','
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
    // InternalReferenceGrammarUiTestLanguage.g:1105:1: rule__Familie__Group_6__1 : rule__Familie__Group_6__1__Impl ;
    public final void rule__Familie__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1109:1: ( rule__Familie__Group_6__1__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1110:2: rule__Familie__Group_6__1__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:1116:1: rule__Familie__Group_6__1__Impl : ( ( rule__Familie__KinderAssignment_6_1 ) ) ;
    public final void rule__Familie__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1120:1: ( ( ( rule__Familie__KinderAssignment_6_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1121:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1121:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1122:2: ( rule__Familie__KinderAssignment_6_1 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:1123:2: ( rule__Familie__KinderAssignment_6_1 )
            // InternalReferenceGrammarUiTestLanguage.g:1123:3: rule__Familie__KinderAssignment_6_1
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
    // InternalReferenceGrammarUiTestLanguage.g:1132:1: rule__Spielplatz__GroesseAssignment_1 : ( RULE_INT ) ;
    public final void rule__Spielplatz__GroesseAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1136:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1137:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1137:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1138:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1147:1: rule__Spielplatz__BeschreibungAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Spielplatz__BeschreibungAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1151:1: ( ( RULE_STRING ) )
            // InternalReferenceGrammarUiTestLanguage.g:1152:2: ( RULE_STRING )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1152:2: ( RULE_STRING )
            // InternalReferenceGrammarUiTestLanguage.g:1153:3: RULE_STRING
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
    // InternalReferenceGrammarUiTestLanguage.g:1162:1: rule__Spielplatz__KinderAssignment_4_0 : ( ruleKind ) ;
    public final void rule__Spielplatz__KinderAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1166:1: ( ( ruleKind ) )
            // InternalReferenceGrammarUiTestLanguage.g:1167:2: ( ruleKind )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1167:2: ( ruleKind )
            // InternalReferenceGrammarUiTestLanguage.g:1168:3: ruleKind
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
    // InternalReferenceGrammarUiTestLanguage.g:1177:1: rule__Spielplatz__ErzieherAssignment_4_1 : ( ruleErwachsener ) ;
    public final void rule__Spielplatz__ErzieherAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1181:1: ( ( ruleErwachsener ) )
            // InternalReferenceGrammarUiTestLanguage.g:1182:2: ( ruleErwachsener )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1182:2: ( ruleErwachsener )
            // InternalReferenceGrammarUiTestLanguage.g:1183:3: ruleErwachsener
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
    // InternalReferenceGrammarUiTestLanguage.g:1192:1: rule__Spielplatz__SpielzeugeAssignment_4_2 : ( ruleSpielzeug ) ;
    public final void rule__Spielplatz__SpielzeugeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1196:1: ( ( ruleSpielzeug ) )
            // InternalReferenceGrammarUiTestLanguage.g:1197:2: ( ruleSpielzeug )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1197:2: ( ruleSpielzeug )
            // InternalReferenceGrammarUiTestLanguage.g:1198:3: ruleSpielzeug
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
    // InternalReferenceGrammarUiTestLanguage.g:1207:1: rule__Spielplatz__FamilieAssignment_4_3 : ( ruleFamilie ) ;
    public final void rule__Spielplatz__FamilieAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1211:1: ( ( ruleFamilie ) )
            // InternalReferenceGrammarUiTestLanguage.g:1212:2: ( ruleFamilie )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1212:2: ( ruleFamilie )
            // InternalReferenceGrammarUiTestLanguage.g:1213:3: ruleFamilie
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
    // InternalReferenceGrammarUiTestLanguage.g:1222:1: rule__Kind__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Kind__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1226:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1227:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1227:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1228:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1237:1: rule__Kind__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Kind__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1241:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1242:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1242:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1243:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1252:1: rule__Erwachsener__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Erwachsener__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1256:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1257:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1257:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1258:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1267:1: rule__Erwachsener__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Erwachsener__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1271:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1272:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1272:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1273:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1282:1: rule__Spielzeug__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Spielzeug__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1286:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1287:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1287:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1288:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1297:1: rule__Spielzeug__FarbeAssignment_3 : ( ruleFarbe ) ;
    public final void rule__Spielzeug__FarbeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1301:1: ( ( ruleFarbe ) )
            // InternalReferenceGrammarUiTestLanguage.g:1302:2: ( ruleFarbe )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1302:2: ( ruleFarbe )
            // InternalReferenceGrammarUiTestLanguage.g:1303:3: ruleFarbe
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
    // InternalReferenceGrammarUiTestLanguage.g:1312:1: rule__Farbe__WertAssignment : ( ( rule__Farbe__WertAlternatives_0 ) ) ;
    public final void rule__Farbe__WertAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1316:1: ( ( ( rule__Farbe__WertAlternatives_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1317:2: ( ( rule__Farbe__WertAlternatives_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1317:2: ( ( rule__Farbe__WertAlternatives_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1318:3: ( rule__Farbe__WertAlternatives_0 )
            {
             before(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1319:3: ( rule__Farbe__WertAlternatives_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1319:4: rule__Farbe__WertAlternatives_0
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
    // InternalReferenceGrammarUiTestLanguage.g:1327:1: rule__Familie__NameAssignment_2 : ( ( rule__Familie__NameAlternatives_2_0 ) ) ;
    public final void rule__Familie__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1331:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1332:2: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1332:2: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1333:3: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1334:3: ( rule__Familie__NameAlternatives_2_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1334:4: rule__Familie__NameAlternatives_2_0
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
    // InternalReferenceGrammarUiTestLanguage.g:1342:1: rule__Familie__MutterAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__MutterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1346:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1347:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1347:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1348:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1349:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1350:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1361:1: rule__Familie__VaterAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__VaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1365:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1366:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1366:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1367:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1368:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1369:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1380:1: rule__Familie__KinderAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1384:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1385:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1385:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1386:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1387:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1388:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1399:1: rule__Familie__KinderAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1403:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1404:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1404:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1405:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1406:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1407:4: RULE_ID
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