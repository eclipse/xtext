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

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
    // InternalReferenceGrammarUiTestLanguage.g:58:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:59:1: ( ruleSpielplatz EOF )
            // InternalReferenceGrammarUiTestLanguage.g:60:1: ruleSpielplatz EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:67:1: ruleSpielplatz : ( ( rule__Spielplatz__Group__0 )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:71:2: ( ( ( rule__Spielplatz__Group__0 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:72:2: ( ( rule__Spielplatz__Group__0 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:72:2: ( ( rule__Spielplatz__Group__0 )? )
            // InternalReferenceGrammarUiTestLanguage.g:73:3: ( rule__Spielplatz__Group__0 )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:74:3: ( rule__Spielplatz__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:74:4: rule__Spielplatz__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:83:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:84:1: ( ruleKind EOF )
            // InternalReferenceGrammarUiTestLanguage.g:85:1: ruleKind EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:92:1: ruleKind : ( ( rule__Kind__Group__0 ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:96:2: ( ( ( rule__Kind__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:97:2: ( ( rule__Kind__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:97:2: ( ( rule__Kind__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:98:3: ( rule__Kind__Group__0 )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:99:3: ( rule__Kind__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:99:4: rule__Kind__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:108:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:109:1: ( ruleErwachsener EOF )
            // InternalReferenceGrammarUiTestLanguage.g:110:1: ruleErwachsener EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:117:1: ruleErwachsener : ( ( rule__Erwachsener__Group__0 ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:121:2: ( ( ( rule__Erwachsener__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:122:2: ( ( rule__Erwachsener__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:122:2: ( ( rule__Erwachsener__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:123:3: ( rule__Erwachsener__Group__0 )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:124:3: ( rule__Erwachsener__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:124:4: rule__Erwachsener__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:133:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:134:1: ( ruleSpielzeug EOF )
            // InternalReferenceGrammarUiTestLanguage.g:135:1: ruleSpielzeug EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:142:1: ruleSpielzeug : ( ( rule__Spielzeug__Group__0 ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:146:2: ( ( ( rule__Spielzeug__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:147:2: ( ( rule__Spielzeug__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:147:2: ( ( rule__Spielzeug__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:148:3: ( rule__Spielzeug__Group__0 )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:149:3: ( rule__Spielzeug__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:149:4: rule__Spielzeug__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:158:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:159:1: ( ruleFarbe EOF )
            // InternalReferenceGrammarUiTestLanguage.g:160:1: ruleFarbe EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:167:1: ruleFarbe : ( ( rule__Farbe__WertAssignment ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:171:2: ( ( ( rule__Farbe__WertAssignment ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:172:2: ( ( rule__Farbe__WertAssignment ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:172:2: ( ( rule__Farbe__WertAssignment ) )
            // InternalReferenceGrammarUiTestLanguage.g:173:3: ( rule__Farbe__WertAssignment )
            {
             before(grammarAccess.getFarbeAccess().getWertAssignment()); 
            // InternalReferenceGrammarUiTestLanguage.g:174:3: ( rule__Farbe__WertAssignment )
            // InternalReferenceGrammarUiTestLanguage.g:174:4: rule__Farbe__WertAssignment
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
    // InternalReferenceGrammarUiTestLanguage.g:183:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // InternalReferenceGrammarUiTestLanguage.g:184:1: ( ruleFamilie EOF )
            // InternalReferenceGrammarUiTestLanguage.g:185:1: ruleFamilie EOF
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
    // InternalReferenceGrammarUiTestLanguage.g:192:1: ruleFamilie : ( ( rule__Familie__Group__0 ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:196:2: ( ( ( rule__Familie__Group__0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:197:2: ( ( rule__Familie__Group__0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:197:2: ( ( rule__Familie__Group__0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:198:3: ( rule__Familie__Group__0 )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // InternalReferenceGrammarUiTestLanguage.g:199:3: ( rule__Familie__Group__0 )
            // InternalReferenceGrammarUiTestLanguage.g:199:4: rule__Familie__Group__0
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
    // InternalReferenceGrammarUiTestLanguage.g:207:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:211:1: ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:212:2: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:212:2: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:213:3: ( rule__Spielplatz__KinderAssignment_4_0 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // InternalReferenceGrammarUiTestLanguage.g:214:3: ( rule__Spielplatz__KinderAssignment_4_0 )
                    // InternalReferenceGrammarUiTestLanguage.g:214:4: rule__Spielplatz__KinderAssignment_4_0
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
                    // InternalReferenceGrammarUiTestLanguage.g:218:2: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:218:2: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:219:3: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // InternalReferenceGrammarUiTestLanguage.g:220:3: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    // InternalReferenceGrammarUiTestLanguage.g:220:4: rule__Spielplatz__ErzieherAssignment_4_1
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
                    // InternalReferenceGrammarUiTestLanguage.g:224:2: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:224:2: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:225:3: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // InternalReferenceGrammarUiTestLanguage.g:226:3: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    // InternalReferenceGrammarUiTestLanguage.g:226:4: rule__Spielplatz__SpielzeugeAssignment_4_2
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
                    // InternalReferenceGrammarUiTestLanguage.g:230:2: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:230:2: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    // InternalReferenceGrammarUiTestLanguage.g:231:3: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // InternalReferenceGrammarUiTestLanguage.g:232:3: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    // InternalReferenceGrammarUiTestLanguage.g:232:4: rule__Spielplatz__FamilieAssignment_4_3
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
    // InternalReferenceGrammarUiTestLanguage.g:240:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );
    public final void rule__Farbe__WertAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:244:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:245:2: ( 'ROT' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:245:2: ( 'ROT' )
                    // InternalReferenceGrammarUiTestLanguage.g:246:3: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:251:2: ( 'BLAU' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:251:2: ( 'BLAU' )
                    // InternalReferenceGrammarUiTestLanguage.g:252:3: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:257:2: ( 'GELB' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:257:2: ( 'GELB' )
                    // InternalReferenceGrammarUiTestLanguage.g:258:3: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarUiTestLanguage.g:263:2: ( 'GR\\u00DCN' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:263:2: ( 'GR\\u00DCN' )
                    // InternalReferenceGrammarUiTestLanguage.g:264:3: 'GR\\u00DCN'
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
    // InternalReferenceGrammarUiTestLanguage.g:273:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:277:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalReferenceGrammarUiTestLanguage.g:278:2: ( 'keyword' )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:278:2: ( 'keyword' )
                    // InternalReferenceGrammarUiTestLanguage.g:279:3: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarUiTestLanguage.g:284:2: ( RULE_STRING )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:284:2: ( RULE_STRING )
                    // InternalReferenceGrammarUiTestLanguage.g:285:3: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarUiTestLanguage.g:290:2: ( RULE_ID )
                    {
                    // InternalReferenceGrammarUiTestLanguage.g:290:2: ( RULE_ID )
                    // InternalReferenceGrammarUiTestLanguage.g:291:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:300:1: rule__Spielplatz__Group__0 : rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 ;
    public final void rule__Spielplatz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:304:1: ( rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:305:2: rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:312:1: rule__Spielplatz__Group__0__Impl : ( 'spielplatz' ) ;
    public final void rule__Spielplatz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:316:1: ( ( 'spielplatz' ) )
            // InternalReferenceGrammarUiTestLanguage.g:317:1: ( 'spielplatz' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:317:1: ( 'spielplatz' )
            // InternalReferenceGrammarUiTestLanguage.g:318:2: 'spielplatz'
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
    // InternalReferenceGrammarUiTestLanguage.g:327:1: rule__Spielplatz__Group__1 : rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 ;
    public final void rule__Spielplatz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:331:1: ( rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:332:2: rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:339:1: rule__Spielplatz__Group__1__Impl : ( ( rule__Spielplatz__GroesseAssignment_1 ) ) ;
    public final void rule__Spielplatz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:343:1: ( ( ( rule__Spielplatz__GroesseAssignment_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:344:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:344:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:345:2: ( rule__Spielplatz__GroesseAssignment_1 )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:346:2: ( rule__Spielplatz__GroesseAssignment_1 )
            // InternalReferenceGrammarUiTestLanguage.g:346:3: rule__Spielplatz__GroesseAssignment_1
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
    // InternalReferenceGrammarUiTestLanguage.g:354:1: rule__Spielplatz__Group__2 : rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 ;
    public final void rule__Spielplatz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:358:1: ( rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:359:2: rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:366:1: rule__Spielplatz__Group__2__Impl : ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) ;
    public final void rule__Spielplatz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:370:1: ( ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) )
            // InternalReferenceGrammarUiTestLanguage.g:371:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            {
            // InternalReferenceGrammarUiTestLanguage.g:371:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            // InternalReferenceGrammarUiTestLanguage.g:372:2: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:373:2: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReferenceGrammarUiTestLanguage.g:373:3: rule__Spielplatz__BeschreibungAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:381:1: rule__Spielplatz__Group__3 : rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 ;
    public final void rule__Spielplatz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:385:1: ( rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:386:2: rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:393:1: rule__Spielplatz__Group__3__Impl : ( '{' ) ;
    public final void rule__Spielplatz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:397:1: ( ( '{' ) )
            // InternalReferenceGrammarUiTestLanguage.g:398:1: ( '{' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:398:1: ( '{' )
            // InternalReferenceGrammarUiTestLanguage.g:399:2: '{'
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
    // InternalReferenceGrammarUiTestLanguage.g:408:1: rule__Spielplatz__Group__4 : rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 ;
    public final void rule__Spielplatz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:412:1: ( rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:413:2: rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5
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
    // InternalReferenceGrammarUiTestLanguage.g:420:1: rule__Spielplatz__Group__4__Impl : ( ( rule__Spielplatz__Alternatives_4 )* ) ;
    public final void rule__Spielplatz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:424:1: ( ( ( rule__Spielplatz__Alternatives_4 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:425:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:425:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // InternalReferenceGrammarUiTestLanguage.g:426:2: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:427:2: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:427:3: rule__Spielplatz__Alternatives_4
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
    // InternalReferenceGrammarUiTestLanguage.g:435:1: rule__Spielplatz__Group__5 : rule__Spielplatz__Group__5__Impl ;
    public final void rule__Spielplatz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:439:1: ( rule__Spielplatz__Group__5__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:440:2: rule__Spielplatz__Group__5__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:446:1: rule__Spielplatz__Group__5__Impl : ( '}' ) ;
    public final void rule__Spielplatz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:450:1: ( ( '}' ) )
            // InternalReferenceGrammarUiTestLanguage.g:451:1: ( '}' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:451:1: ( '}' )
            // InternalReferenceGrammarUiTestLanguage.g:452:2: '}'
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
    // InternalReferenceGrammarUiTestLanguage.g:462:1: rule__Kind__Group__0 : rule__Kind__Group__0__Impl rule__Kind__Group__1 ;
    public final void rule__Kind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:466:1: ( rule__Kind__Group__0__Impl rule__Kind__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:467:2: rule__Kind__Group__0__Impl rule__Kind__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:474:1: rule__Kind__Group__0__Impl : ( 'kind' ) ;
    public final void rule__Kind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:478:1: ( ( 'kind' ) )
            // InternalReferenceGrammarUiTestLanguage.g:479:1: ( 'kind' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:479:1: ( 'kind' )
            // InternalReferenceGrammarUiTestLanguage.g:480:2: 'kind'
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
    // InternalReferenceGrammarUiTestLanguage.g:489:1: rule__Kind__Group__1 : rule__Kind__Group__1__Impl rule__Kind__Group__2 ;
    public final void rule__Kind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:493:1: ( rule__Kind__Group__1__Impl rule__Kind__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:494:2: rule__Kind__Group__1__Impl rule__Kind__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:501:1: rule__Kind__Group__1__Impl : ( '(' ) ;
    public final void rule__Kind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:505:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:506:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:506:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:507:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:516:1: rule__Kind__Group__2 : rule__Kind__Group__2__Impl rule__Kind__Group__3 ;
    public final void rule__Kind__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:520:1: ( rule__Kind__Group__2__Impl rule__Kind__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:521:2: rule__Kind__Group__2__Impl rule__Kind__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:528:1: rule__Kind__Group__2__Impl : ( ( rule__Kind__NameAssignment_2 ) ) ;
    public final void rule__Kind__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:532:1: ( ( ( rule__Kind__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:533:1: ( ( rule__Kind__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:533:1: ( ( rule__Kind__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:534:2: ( rule__Kind__NameAssignment_2 )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:535:2: ( rule__Kind__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:535:3: rule__Kind__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:543:1: rule__Kind__Group__3 : rule__Kind__Group__3__Impl rule__Kind__Group__4 ;
    public final void rule__Kind__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:547:1: ( rule__Kind__Group__3__Impl rule__Kind__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:548:2: rule__Kind__Group__3__Impl rule__Kind__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:555:1: rule__Kind__Group__3__Impl : ( ( rule__Kind__AgeAssignment_3 ) ) ;
    public final void rule__Kind__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:559:1: ( ( ( rule__Kind__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:560:1: ( ( rule__Kind__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:560:1: ( ( rule__Kind__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:561:2: ( rule__Kind__AgeAssignment_3 )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:562:2: ( rule__Kind__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:562:3: rule__Kind__AgeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:570:1: rule__Kind__Group__4 : rule__Kind__Group__4__Impl ;
    public final void rule__Kind__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:574:1: ( rule__Kind__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:575:2: rule__Kind__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:581:1: rule__Kind__Group__4__Impl : ( ')' ) ;
    public final void rule__Kind__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:585:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:586:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:586:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:587:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:597:1: rule__Erwachsener__Group__0 : rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 ;
    public final void rule__Erwachsener__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:601:1: ( rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:602:2: rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:609:1: rule__Erwachsener__Group__0__Impl : ( 'erwachsener' ) ;
    public final void rule__Erwachsener__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:613:1: ( ( 'erwachsener' ) )
            // InternalReferenceGrammarUiTestLanguage.g:614:1: ( 'erwachsener' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:614:1: ( 'erwachsener' )
            // InternalReferenceGrammarUiTestLanguage.g:615:2: 'erwachsener'
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
    // InternalReferenceGrammarUiTestLanguage.g:624:1: rule__Erwachsener__Group__1 : rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 ;
    public final void rule__Erwachsener__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:628:1: ( rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:629:2: rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:636:1: rule__Erwachsener__Group__1__Impl : ( '(' ) ;
    public final void rule__Erwachsener__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:640:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:641:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:641:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:642:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:651:1: rule__Erwachsener__Group__2 : rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 ;
    public final void rule__Erwachsener__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:655:1: ( rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:656:2: rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:663:1: rule__Erwachsener__Group__2__Impl : ( ( rule__Erwachsener__NameAssignment_2 ) ) ;
    public final void rule__Erwachsener__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:667:1: ( ( ( rule__Erwachsener__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:668:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:668:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:669:2: ( rule__Erwachsener__NameAssignment_2 )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:670:2: ( rule__Erwachsener__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:670:3: rule__Erwachsener__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:678:1: rule__Erwachsener__Group__3 : rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 ;
    public final void rule__Erwachsener__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:682:1: ( rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:683:2: rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:690:1: rule__Erwachsener__Group__3__Impl : ( ( rule__Erwachsener__AgeAssignment_3 ) ) ;
    public final void rule__Erwachsener__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:694:1: ( ( ( rule__Erwachsener__AgeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:695:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:695:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:696:2: ( rule__Erwachsener__AgeAssignment_3 )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:697:2: ( rule__Erwachsener__AgeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:697:3: rule__Erwachsener__AgeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:705:1: rule__Erwachsener__Group__4 : rule__Erwachsener__Group__4__Impl ;
    public final void rule__Erwachsener__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:709:1: ( rule__Erwachsener__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:710:2: rule__Erwachsener__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:716:1: rule__Erwachsener__Group__4__Impl : ( ')' ) ;
    public final void rule__Erwachsener__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:720:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:721:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:721:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:722:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:732:1: rule__Spielzeug__Group__0 : rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 ;
    public final void rule__Spielzeug__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:736:1: ( rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:737:2: rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:744:1: rule__Spielzeug__Group__0__Impl : ( 'spielzeug' ) ;
    public final void rule__Spielzeug__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:748:1: ( ( 'spielzeug' ) )
            // InternalReferenceGrammarUiTestLanguage.g:749:1: ( 'spielzeug' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:749:1: ( 'spielzeug' )
            // InternalReferenceGrammarUiTestLanguage.g:750:2: 'spielzeug'
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
    // InternalReferenceGrammarUiTestLanguage.g:759:1: rule__Spielzeug__Group__1 : rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 ;
    public final void rule__Spielzeug__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:763:1: ( rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:764:2: rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:771:1: rule__Spielzeug__Group__1__Impl : ( '(' ) ;
    public final void rule__Spielzeug__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:775:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:776:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:776:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:777:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:786:1: rule__Spielzeug__Group__2 : rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 ;
    public final void rule__Spielzeug__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:790:1: ( rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:791:2: rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:798:1: rule__Spielzeug__Group__2__Impl : ( ( rule__Spielzeug__NameAssignment_2 ) ) ;
    public final void rule__Spielzeug__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:802:1: ( ( ( rule__Spielzeug__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:803:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:803:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:804:2: ( rule__Spielzeug__NameAssignment_2 )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:805:2: ( rule__Spielzeug__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:805:3: rule__Spielzeug__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:813:1: rule__Spielzeug__Group__3 : rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 ;
    public final void rule__Spielzeug__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:817:1: ( rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:818:2: rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:825:1: rule__Spielzeug__Group__3__Impl : ( ( rule__Spielzeug__FarbeAssignment_3 ) ) ;
    public final void rule__Spielzeug__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:829:1: ( ( ( rule__Spielzeug__FarbeAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:830:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:830:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:831:2: ( rule__Spielzeug__FarbeAssignment_3 )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:832:2: ( rule__Spielzeug__FarbeAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:832:3: rule__Spielzeug__FarbeAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:840:1: rule__Spielzeug__Group__4 : rule__Spielzeug__Group__4__Impl ;
    public final void rule__Spielzeug__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:844:1: ( rule__Spielzeug__Group__4__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:845:2: rule__Spielzeug__Group__4__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:851:1: rule__Spielzeug__Group__4__Impl : ( ')' ) ;
    public final void rule__Spielzeug__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:855:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:856:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:856:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:857:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:867:1: rule__Familie__Group__0 : rule__Familie__Group__0__Impl rule__Familie__Group__1 ;
    public final void rule__Familie__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:871:1: ( rule__Familie__Group__0__Impl rule__Familie__Group__1 )
            // InternalReferenceGrammarUiTestLanguage.g:872:2: rule__Familie__Group__0__Impl rule__Familie__Group__1
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
    // InternalReferenceGrammarUiTestLanguage.g:879:1: rule__Familie__Group__0__Impl : ( 'familie' ) ;
    public final void rule__Familie__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:883:1: ( ( 'familie' ) )
            // InternalReferenceGrammarUiTestLanguage.g:884:1: ( 'familie' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:884:1: ( 'familie' )
            // InternalReferenceGrammarUiTestLanguage.g:885:2: 'familie'
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
    // InternalReferenceGrammarUiTestLanguage.g:894:1: rule__Familie__Group__1 : rule__Familie__Group__1__Impl rule__Familie__Group__2 ;
    public final void rule__Familie__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:898:1: ( rule__Familie__Group__1__Impl rule__Familie__Group__2 )
            // InternalReferenceGrammarUiTestLanguage.g:899:2: rule__Familie__Group__1__Impl rule__Familie__Group__2
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
    // InternalReferenceGrammarUiTestLanguage.g:906:1: rule__Familie__Group__1__Impl : ( '(' ) ;
    public final void rule__Familie__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:910:1: ( ( '(' ) )
            // InternalReferenceGrammarUiTestLanguage.g:911:1: ( '(' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:911:1: ( '(' )
            // InternalReferenceGrammarUiTestLanguage.g:912:2: '('
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
    // InternalReferenceGrammarUiTestLanguage.g:921:1: rule__Familie__Group__2 : rule__Familie__Group__2__Impl rule__Familie__Group__3 ;
    public final void rule__Familie__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:925:1: ( rule__Familie__Group__2__Impl rule__Familie__Group__3 )
            // InternalReferenceGrammarUiTestLanguage.g:926:2: rule__Familie__Group__2__Impl rule__Familie__Group__3
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
    // InternalReferenceGrammarUiTestLanguage.g:933:1: rule__Familie__Group__2__Impl : ( ( rule__Familie__NameAssignment_2 ) ) ;
    public final void rule__Familie__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:937:1: ( ( ( rule__Familie__NameAssignment_2 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:938:1: ( ( rule__Familie__NameAssignment_2 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:938:1: ( ( rule__Familie__NameAssignment_2 ) )
            // InternalReferenceGrammarUiTestLanguage.g:939:2: ( rule__Familie__NameAssignment_2 )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // InternalReferenceGrammarUiTestLanguage.g:940:2: ( rule__Familie__NameAssignment_2 )
            // InternalReferenceGrammarUiTestLanguage.g:940:3: rule__Familie__NameAssignment_2
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
    // InternalReferenceGrammarUiTestLanguage.g:948:1: rule__Familie__Group__3 : rule__Familie__Group__3__Impl rule__Familie__Group__4 ;
    public final void rule__Familie__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:952:1: ( rule__Familie__Group__3__Impl rule__Familie__Group__4 )
            // InternalReferenceGrammarUiTestLanguage.g:953:2: rule__Familie__Group__3__Impl rule__Familie__Group__4
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
    // InternalReferenceGrammarUiTestLanguage.g:960:1: rule__Familie__Group__3__Impl : ( ( rule__Familie__MutterAssignment_3 ) ) ;
    public final void rule__Familie__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:964:1: ( ( ( rule__Familie__MutterAssignment_3 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:965:1: ( ( rule__Familie__MutterAssignment_3 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:965:1: ( ( rule__Familie__MutterAssignment_3 ) )
            // InternalReferenceGrammarUiTestLanguage.g:966:2: ( rule__Familie__MutterAssignment_3 )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // InternalReferenceGrammarUiTestLanguage.g:967:2: ( rule__Familie__MutterAssignment_3 )
            // InternalReferenceGrammarUiTestLanguage.g:967:3: rule__Familie__MutterAssignment_3
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
    // InternalReferenceGrammarUiTestLanguage.g:975:1: rule__Familie__Group__4 : rule__Familie__Group__4__Impl rule__Familie__Group__5 ;
    public final void rule__Familie__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:979:1: ( rule__Familie__Group__4__Impl rule__Familie__Group__5 )
            // InternalReferenceGrammarUiTestLanguage.g:980:2: rule__Familie__Group__4__Impl rule__Familie__Group__5
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
    // InternalReferenceGrammarUiTestLanguage.g:987:1: rule__Familie__Group__4__Impl : ( ( rule__Familie__VaterAssignment_4 ) ) ;
    public final void rule__Familie__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:991:1: ( ( ( rule__Familie__VaterAssignment_4 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:992:1: ( ( rule__Familie__VaterAssignment_4 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:992:1: ( ( rule__Familie__VaterAssignment_4 ) )
            // InternalReferenceGrammarUiTestLanguage.g:993:2: ( rule__Familie__VaterAssignment_4 )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // InternalReferenceGrammarUiTestLanguage.g:994:2: ( rule__Familie__VaterAssignment_4 )
            // InternalReferenceGrammarUiTestLanguage.g:994:3: rule__Familie__VaterAssignment_4
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
    // InternalReferenceGrammarUiTestLanguage.g:1002:1: rule__Familie__Group__5 : rule__Familie__Group__5__Impl rule__Familie__Group__6 ;
    public final void rule__Familie__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1006:1: ( rule__Familie__Group__5__Impl rule__Familie__Group__6 )
            // InternalReferenceGrammarUiTestLanguage.g:1007:2: rule__Familie__Group__5__Impl rule__Familie__Group__6
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
    // InternalReferenceGrammarUiTestLanguage.g:1014:1: rule__Familie__Group__5__Impl : ( ( rule__Familie__KinderAssignment_5 ) ) ;
    public final void rule__Familie__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1018:1: ( ( ( rule__Familie__KinderAssignment_5 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1019:1: ( ( rule__Familie__KinderAssignment_5 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1019:1: ( ( rule__Familie__KinderAssignment_5 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1020:2: ( rule__Familie__KinderAssignment_5 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // InternalReferenceGrammarUiTestLanguage.g:1021:2: ( rule__Familie__KinderAssignment_5 )
            // InternalReferenceGrammarUiTestLanguage.g:1021:3: rule__Familie__KinderAssignment_5
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
    // InternalReferenceGrammarUiTestLanguage.g:1029:1: rule__Familie__Group__6 : rule__Familie__Group__6__Impl rule__Familie__Group__7 ;
    public final void rule__Familie__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1033:1: ( rule__Familie__Group__6__Impl rule__Familie__Group__7 )
            // InternalReferenceGrammarUiTestLanguage.g:1034:2: rule__Familie__Group__6__Impl rule__Familie__Group__7
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
    // InternalReferenceGrammarUiTestLanguage.g:1041:1: rule__Familie__Group__6__Impl : ( ( rule__Familie__Group_6__0 )* ) ;
    public final void rule__Familie__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1045:1: ( ( ( rule__Familie__Group_6__0 )* ) )
            // InternalReferenceGrammarUiTestLanguage.g:1046:1: ( ( rule__Familie__Group_6__0 )* )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1046:1: ( ( rule__Familie__Group_6__0 )* )
            // InternalReferenceGrammarUiTestLanguage.g:1047:2: ( rule__Familie__Group_6__0 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // InternalReferenceGrammarUiTestLanguage.g:1048:2: ( rule__Familie__Group_6__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReferenceGrammarUiTestLanguage.g:1048:3: rule__Familie__Group_6__0
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
    // InternalReferenceGrammarUiTestLanguage.g:1056:1: rule__Familie__Group__7 : rule__Familie__Group__7__Impl ;
    public final void rule__Familie__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1060:1: ( rule__Familie__Group__7__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1061:2: rule__Familie__Group__7__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:1067:1: rule__Familie__Group__7__Impl : ( ')' ) ;
    public final void rule__Familie__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1071:1: ( ( ')' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1072:1: ( ')' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1072:1: ( ')' )
            // InternalReferenceGrammarUiTestLanguage.g:1073:2: ')'
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
    // InternalReferenceGrammarUiTestLanguage.g:1083:1: rule__Familie__Group_6__0 : rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 ;
    public final void rule__Familie__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1087:1: ( rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 )
            // InternalReferenceGrammarUiTestLanguage.g:1088:2: rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1
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
    // InternalReferenceGrammarUiTestLanguage.g:1095:1: rule__Familie__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Familie__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1099:1: ( ( ',' ) )
            // InternalReferenceGrammarUiTestLanguage.g:1100:1: ( ',' )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1100:1: ( ',' )
            // InternalReferenceGrammarUiTestLanguage.g:1101:2: ','
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
    // InternalReferenceGrammarUiTestLanguage.g:1110:1: rule__Familie__Group_6__1 : rule__Familie__Group_6__1__Impl ;
    public final void rule__Familie__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1114:1: ( rule__Familie__Group_6__1__Impl )
            // InternalReferenceGrammarUiTestLanguage.g:1115:2: rule__Familie__Group_6__1__Impl
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
    // InternalReferenceGrammarUiTestLanguage.g:1121:1: rule__Familie__Group_6__1__Impl : ( ( rule__Familie__KinderAssignment_6_1 ) ) ;
    public final void rule__Familie__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1125:1: ( ( ( rule__Familie__KinderAssignment_6_1 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1126:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1126:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1127:2: ( rule__Familie__KinderAssignment_6_1 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // InternalReferenceGrammarUiTestLanguage.g:1128:2: ( rule__Familie__KinderAssignment_6_1 )
            // InternalReferenceGrammarUiTestLanguage.g:1128:3: rule__Familie__KinderAssignment_6_1
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
    // InternalReferenceGrammarUiTestLanguage.g:1137:1: rule__Spielplatz__GroesseAssignment_1 : ( RULE_INT ) ;
    public final void rule__Spielplatz__GroesseAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1141:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1142:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1142:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1143:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1152:1: rule__Spielplatz__BeschreibungAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Spielplatz__BeschreibungAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1156:1: ( ( RULE_STRING ) )
            // InternalReferenceGrammarUiTestLanguage.g:1157:2: ( RULE_STRING )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1157:2: ( RULE_STRING )
            // InternalReferenceGrammarUiTestLanguage.g:1158:3: RULE_STRING
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
    // InternalReferenceGrammarUiTestLanguage.g:1167:1: rule__Spielplatz__KinderAssignment_4_0 : ( ruleKind ) ;
    public final void rule__Spielplatz__KinderAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1171:1: ( ( ruleKind ) )
            // InternalReferenceGrammarUiTestLanguage.g:1172:2: ( ruleKind )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1172:2: ( ruleKind )
            // InternalReferenceGrammarUiTestLanguage.g:1173:3: ruleKind
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
    // InternalReferenceGrammarUiTestLanguage.g:1182:1: rule__Spielplatz__ErzieherAssignment_4_1 : ( ruleErwachsener ) ;
    public final void rule__Spielplatz__ErzieherAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1186:1: ( ( ruleErwachsener ) )
            // InternalReferenceGrammarUiTestLanguage.g:1187:2: ( ruleErwachsener )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1187:2: ( ruleErwachsener )
            // InternalReferenceGrammarUiTestLanguage.g:1188:3: ruleErwachsener
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
    // InternalReferenceGrammarUiTestLanguage.g:1197:1: rule__Spielplatz__SpielzeugeAssignment_4_2 : ( ruleSpielzeug ) ;
    public final void rule__Spielplatz__SpielzeugeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1201:1: ( ( ruleSpielzeug ) )
            // InternalReferenceGrammarUiTestLanguage.g:1202:2: ( ruleSpielzeug )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1202:2: ( ruleSpielzeug )
            // InternalReferenceGrammarUiTestLanguage.g:1203:3: ruleSpielzeug
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
    // InternalReferenceGrammarUiTestLanguage.g:1212:1: rule__Spielplatz__FamilieAssignment_4_3 : ( ruleFamilie ) ;
    public final void rule__Spielplatz__FamilieAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1216:1: ( ( ruleFamilie ) )
            // InternalReferenceGrammarUiTestLanguage.g:1217:2: ( ruleFamilie )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1217:2: ( ruleFamilie )
            // InternalReferenceGrammarUiTestLanguage.g:1218:3: ruleFamilie
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
    // InternalReferenceGrammarUiTestLanguage.g:1227:1: rule__Kind__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Kind__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1231:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1232:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1232:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1233:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1242:1: rule__Kind__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Kind__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1246:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1247:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1247:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1248:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1257:1: rule__Erwachsener__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Erwachsener__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1261:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1262:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1262:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1263:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1272:1: rule__Erwachsener__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Erwachsener__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1276:1: ( ( RULE_INT ) )
            // InternalReferenceGrammarUiTestLanguage.g:1277:2: ( RULE_INT )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1277:2: ( RULE_INT )
            // InternalReferenceGrammarUiTestLanguage.g:1278:3: RULE_INT
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
    // InternalReferenceGrammarUiTestLanguage.g:1287:1: rule__Spielzeug__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Spielzeug__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1291:1: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1292:2: ( RULE_ID )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1292:2: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1293:3: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1302:1: rule__Spielzeug__FarbeAssignment_3 : ( ruleFarbe ) ;
    public final void rule__Spielzeug__FarbeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1306:1: ( ( ruleFarbe ) )
            // InternalReferenceGrammarUiTestLanguage.g:1307:2: ( ruleFarbe )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1307:2: ( ruleFarbe )
            // InternalReferenceGrammarUiTestLanguage.g:1308:3: ruleFarbe
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
    // InternalReferenceGrammarUiTestLanguage.g:1317:1: rule__Farbe__WertAssignment : ( ( rule__Farbe__WertAlternatives_0 ) ) ;
    public final void rule__Farbe__WertAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1321:1: ( ( ( rule__Farbe__WertAlternatives_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1322:2: ( ( rule__Farbe__WertAlternatives_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1322:2: ( ( rule__Farbe__WertAlternatives_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1323:3: ( rule__Farbe__WertAlternatives_0 )
            {
             before(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1324:3: ( rule__Farbe__WertAlternatives_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1324:4: rule__Farbe__WertAlternatives_0
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
    // InternalReferenceGrammarUiTestLanguage.g:1332:1: rule__Familie__NameAssignment_2 : ( ( rule__Familie__NameAlternatives_2_0 ) ) ;
    public final void rule__Familie__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1336:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1337:2: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1337:2: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // InternalReferenceGrammarUiTestLanguage.g:1338:3: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1339:3: ( rule__Familie__NameAlternatives_2_0 )
            // InternalReferenceGrammarUiTestLanguage.g:1339:4: rule__Familie__NameAlternatives_2_0
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
    // InternalReferenceGrammarUiTestLanguage.g:1347:1: rule__Familie__MutterAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__MutterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1351:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1352:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1352:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1353:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1354:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1355:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1366:1: rule__Familie__VaterAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__VaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1370:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1371:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1371:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1372:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1373:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1374:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1385:1: rule__Familie__KinderAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1389:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1390:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1390:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1391:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1392:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1393:4: RULE_ID
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
    // InternalReferenceGrammarUiTestLanguage.g:1404:1: rule__Familie__KinderAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferenceGrammarUiTestLanguage.g:1408:1: ( ( ( RULE_ID ) ) )
            // InternalReferenceGrammarUiTestLanguage.g:1409:2: ( ( RULE_ID ) )
            {
            // InternalReferenceGrammarUiTestLanguage.g:1409:2: ( ( RULE_ID ) )
            // InternalReferenceGrammarUiTestLanguage.g:1410:3: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // InternalReferenceGrammarUiTestLanguage.g:1411:3: ( RULE_ID )
            // InternalReferenceGrammarUiTestLanguage.g:1412:4: RULE_ID
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