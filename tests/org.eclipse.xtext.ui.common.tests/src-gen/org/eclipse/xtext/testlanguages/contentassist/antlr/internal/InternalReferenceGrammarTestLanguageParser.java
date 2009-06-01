package org.eclipse.xtext.testlanguages.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'keyword'", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "','"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalReferenceGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g"; }


     
     	private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:55:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:55:21: ( ruleSpielplatz EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:56:1: ruleSpielplatz EOF
            {
             before(grammarAccess.getSpielplatzRule()); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz60);
            ruleSpielplatz();
            _fsp--;

             after(grammarAccess.getSpielplatzRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz67); 

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
    // $ANTLR end entryRuleSpielplatz


    // $ANTLR start ruleSpielplatz
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:63:1: ruleSpielplatz : ( ( rule__Spielplatz__Group )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:67:2: ( ( ( rule__Spielplatz__Group )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:68:1: ( ( rule__Spielplatz__Group )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:68:1: ( ( rule__Spielplatz__Group )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:69:1: ( rule__Spielplatz__Group )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:1: ( rule__Spielplatz__Group )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:70:2: rule__Spielplatz__Group
                    {
                    pushFollow(FOLLOW_rule__Spielplatz__Group_in_ruleSpielplatz94);
                    rule__Spielplatz__Group();
                    _fsp--;


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
    // $ANTLR end ruleSpielplatz


    // $ANTLR start entryRuleKind
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:83:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:83:15: ( ruleKind EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:84:1: ruleKind EOF
            {
             before(grammarAccess.getKindRule()); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind122);
            ruleKind();
            _fsp--;

             after(grammarAccess.getKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind129); 

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
    // $ANTLR end entryRuleKind


    // $ANTLR start ruleKind
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:91:1: ruleKind : ( ( rule__Kind__Group ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:95:2: ( ( ( rule__Kind__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:96:1: ( ( rule__Kind__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:96:1: ( ( rule__Kind__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:97:1: ( rule__Kind__Group )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:98:1: ( rule__Kind__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:98:2: rule__Kind__Group
            {
            pushFollow(FOLLOW_rule__Kind__Group_in_ruleKind156);
            rule__Kind__Group();
            _fsp--;


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
    // $ANTLR end ruleKind


    // $ANTLR start entryRuleErwachsener
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:109:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:109:22: ( ruleErwachsener EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:110:1: ruleErwachsener EOF
            {
             before(grammarAccess.getErwachsenerRule()); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener181);
            ruleErwachsener();
            _fsp--;

             after(grammarAccess.getErwachsenerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener188); 

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
    // $ANTLR end entryRuleErwachsener


    // $ANTLR start ruleErwachsener
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:117:1: ruleErwachsener : ( ( rule__Erwachsener__Group ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:121:2: ( ( ( rule__Erwachsener__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:122:1: ( ( rule__Erwachsener__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:122:1: ( ( rule__Erwachsener__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:123:1: ( rule__Erwachsener__Group )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:124:1: ( rule__Erwachsener__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:124:2: rule__Erwachsener__Group
            {
            pushFollow(FOLLOW_rule__Erwachsener__Group_in_ruleErwachsener215);
            rule__Erwachsener__Group();
            _fsp--;


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
    // $ANTLR end ruleErwachsener


    // $ANTLR start entryRuleSpielzeug
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:135:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:135:20: ( ruleSpielzeug EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:136:1: ruleSpielzeug EOF
            {
             before(grammarAccess.getSpielzeugRule()); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug240);
            ruleSpielzeug();
            _fsp--;

             after(grammarAccess.getSpielzeugRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug247); 

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
    // $ANTLR end entryRuleSpielzeug


    // $ANTLR start ruleSpielzeug
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:143:1: ruleSpielzeug : ( ( rule__Spielzeug__Group ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:147:2: ( ( ( rule__Spielzeug__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:148:1: ( ( rule__Spielzeug__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:148:1: ( ( rule__Spielzeug__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:149:1: ( rule__Spielzeug__Group )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:150:1: ( rule__Spielzeug__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:150:2: rule__Spielzeug__Group
            {
            pushFollow(FOLLOW_rule__Spielzeug__Group_in_ruleSpielzeug274);
            rule__Spielzeug__Group();
            _fsp--;


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
    // $ANTLR end ruleSpielzeug


    // $ANTLR start entryRuleFarbe
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:161:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:161:16: ( ruleFarbe EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:162:1: ruleFarbe EOF
            {
             before(grammarAccess.getFarbeRule()); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe299);
            ruleFarbe();
            _fsp--;

             after(grammarAccess.getFarbeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe306); 

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
    // $ANTLR end entryRuleFarbe


    // $ANTLR start ruleFarbe
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:169:1: ruleFarbe : ( ( rule__Farbe__Alternatives ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:173:2: ( ( ( rule__Farbe__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:174:1: ( ( rule__Farbe__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:174:1: ( ( rule__Farbe__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:175:1: ( rule__Farbe__Alternatives )
            {
             before(grammarAccess.getFarbeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:176:1: ( rule__Farbe__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:176:2: rule__Farbe__Alternatives
            {
            pushFollow(FOLLOW_rule__Farbe__Alternatives_in_ruleFarbe333);
            rule__Farbe__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getFarbeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleFamilie
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:187:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:187:18: ( ruleFamilie EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:188:1: ruleFamilie EOF
            {
             before(grammarAccess.getFamilieRule()); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie358);
            ruleFamilie();
            _fsp--;

             after(grammarAccess.getFamilieRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie365); 

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
    // $ANTLR end entryRuleFamilie


    // $ANTLR start ruleFamilie
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:195:1: ruleFamilie : ( ( rule__Familie__Group ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:199:2: ( ( ( rule__Familie__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:200:1: ( ( rule__Familie__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:200:1: ( ( rule__Familie__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:201:1: ( rule__Familie__Group )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:202:1: ( rule__Familie__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:202:2: rule__Familie__Group
            {
            pushFollow(FOLLOW_rule__Familie__Group_in_ruleFamilie392);
            rule__Familie__Group();
            _fsp--;


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
    // $ANTLR end ruleFamilie


    // $ANTLR start rule__Spielplatz__Alternatives_4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:213:1: rule__Spielplatz__Alternatives_4 : ( ( ( ( ruleKind ) ) ) | ( ( ( ruleErwachsener ) ) ) | ( ( ( ruleSpielzeug ) ) ) | ( ( ( ruleFamilie ) ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:217:1: ( ( ( ( ruleKind ) ) ) | ( ( ( ruleErwachsener ) ) ) | ( ( ( ruleSpielzeug ) ) ) | ( ( ( ruleFamilie ) ) ) )
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
                    new NoViableAltException("213:1: rule__Spielplatz__Alternatives_4 : ( ( ( ( ruleKind ) ) ) | ( ( ( ruleErwachsener ) ) ) | ( ( ( ruleSpielzeug ) ) ) | ( ( ( ruleFamilie ) ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:218:1: ( ( ( ruleKind ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:218:1: ( ( ( ruleKind ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:219:1: ( ( ruleKind ) )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:220:1: ( ( ruleKind ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:221:1: ( ruleKind )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:221:1: ( ruleKind )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:222:1: ruleKind
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 
                    pushFollow(FOLLOW_ruleKind_in_rule__Spielplatz__Alternatives_4434);
                    ruleKind();
                    _fsp--;

                     after(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 

                    }


                    }

                     after(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:229:6: ( ( ( ruleErwachsener ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:229:6: ( ( ( ruleErwachsener ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:230:1: ( ( ruleErwachsener ) )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:231:1: ( ( ruleErwachsener ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:232:1: ( ruleErwachsener )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:232:1: ( ruleErwachsener )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:233:1: ruleErwachsener
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 
                    pushFollow(FOLLOW_ruleErwachsener_in_rule__Spielplatz__Alternatives_4464);
                    ruleErwachsener();
                    _fsp--;

                     after(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 

                    }


                    }

                     after(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:240:6: ( ( ( ruleSpielzeug ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:240:6: ( ( ( ruleSpielzeug ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:241:1: ( ( ruleSpielzeug ) )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:242:1: ( ( ruleSpielzeug ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:243:1: ( ruleSpielzeug )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:243:1: ( ruleSpielzeug )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:244:1: ruleSpielzeug
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 
                    pushFollow(FOLLOW_ruleSpielzeug_in_rule__Spielplatz__Alternatives_4494);
                    ruleSpielzeug();
                    _fsp--;

                     after(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 

                    }


                    }

                     after(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:251:6: ( ( ( ruleFamilie ) ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:251:6: ( ( ( ruleFamilie ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:252:1: ( ( ruleFamilie ) )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:253:1: ( ( ruleFamilie ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:254:1: ( ruleFamilie )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:254:1: ( ruleFamilie )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:255:1: ruleFamilie
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 
                    pushFollow(FOLLOW_ruleFamilie_in_rule__Spielplatz__Alternatives_4524);
                    ruleFamilie();
                    _fsp--;

                     after(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 

                    }


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
    // $ANTLR end rule__Spielplatz__Alternatives_4


    // $ANTLR start rule__Farbe__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:268:1: rule__Farbe__Alternatives : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );
    public final void rule__Farbe__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:272:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) )
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
                    new NoViableAltException("268:1: rule__Farbe__Alternatives : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:273:1: ( 'ROT' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:273:1: ( 'ROT' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:274:1: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getROTKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__Farbe__Alternatives564); 
                     after(grammarAccess.getFarbeAccess().getROTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:280:6: ( 'BLAU' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:280:6: ( 'BLAU' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:281:1: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getBLAUKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__Farbe__Alternatives583); 
                     after(grammarAccess.getFarbeAccess().getBLAUKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:287:6: ( 'GELB' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:287:6: ( 'GELB' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:288:1: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getGELBKeyword_2()); 
                    match(input,13,FOLLOW_13_in_rule__Farbe__Alternatives602); 
                     after(grammarAccess.getFarbeAccess().getGELBKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:295:1: 'GR\\u00DCN'
                    {
                     before(grammarAccess.getFarbeAccess().getGRÜNKeyword_3()); 
                    match(input,14,FOLLOW_14_in_rule__Farbe__Alternatives621); 
                     after(grammarAccess.getFarbeAccess().getGRÜNKeyword_3()); 

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
    // $ANTLR end rule__Farbe__Alternatives


    // $ANTLR start rule__Familie__NameAlternatives_2_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:306:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:310:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
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
                    new NoViableAltException("306:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:311:1: ( 'keyword' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:311:1: ( 'keyword' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:312:1: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Familie__NameAlternatives_2_0655); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:318:6: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:318:6: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:319:1: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0673); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:323:6: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:324:1: RULE_ID
                    {
                     before(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0689); 
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
    // $ANTLR end rule__Familie__NameAlternatives_2_0


    // $ANTLR start rule__Spielplatz__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:334:1: rule__Spielplatz__Group : ( 'spielplatz' ) ( ( ( RULE_INT ) ) ) ( ( ( RULE_STRING ) )? ) ( '{' ) ( ( rule__Spielplatz__Alternatives_4 )* ) ( '}' ) ;
    public final void rule__Spielplatz__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:338:1: ( ( 'spielplatz' ) ( ( ( RULE_INT ) ) ) ( ( ( RULE_STRING ) )? ) ( '{' ) ( ( rule__Spielplatz__Alternatives_4 )* ) ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:339:1: ( 'spielplatz' ) ( ( ( RULE_INT ) ) ) ( ( ( RULE_STRING ) )? ) ( '{' ) ( ( rule__Spielplatz__Alternatives_4 )* ) ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:339:1: ( 'spielplatz' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:340:1: 'spielplatz'
            {
             before(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Spielplatz__Group722); 
             after(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:345:1: ( ( ( RULE_INT ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:346:1: ( ( RULE_INT ) )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:347:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:348:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:348:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:349:1: RULE_INT
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Spielplatz__Group741); 
             after(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:355:1: ( ( ( RULE_STRING ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:356:1: ( ( RULE_STRING ) )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:357:1: ( ( RULE_STRING ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:358:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:358:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:359:1: RULE_STRING
                    {
                     before(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Spielplatz__Group765); 
                     after(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 

                    }


                    }
                    break;

            }

             after(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:365:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:366:1: '{'
            {
             before(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,17,FOLLOW_17_in_rule__Spielplatz__Group784); 
             after(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:371:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:372:1: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:373:1: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:373:2: rule__Spielplatz__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group796);
            	    rule__Spielplatz__Alternatives_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:375:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:376:1: '}'
            {
             before(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5()); 
            match(input,18,FOLLOW_18_in_rule__Spielplatz__Group809); 
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
    // $ANTLR end rule__Spielplatz__Group


    // $ANTLR start rule__Kind__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:387:1: rule__Kind__Group : ( 'kind' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' ) ;
    public final void rule__Kind__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:391:1: ( ( 'kind' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:1: ( 'kind' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:392:1: ( 'kind' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:393:1: 'kind'
            {
             before(grammarAccess.getKindAccess().getKindKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Kind__Group843); 
             after(grammarAccess.getKindAccess().getKindKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:398:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:399:1: '('
            {
             before(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FOLLOW_20_in_rule__Kind__Group856); 
             after(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:404:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:405:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:406:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:407:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:407:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:408:1: RULE_ID
            {
             before(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Kind__Group875); 
             after(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

             after(grammarAccess.getKindAccess().getNameAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:414:1: ( ( ( RULE_INT ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:415:1: ( ( RULE_INT ) )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:416:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:417:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:417:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:418:1: RULE_INT
            {
             before(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Kind__Group899); 
             after(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 

            }


            }

             after(grammarAccess.getKindAccess().getAgeAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:424:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:425:1: ')'
            {
             before(grammarAccess.getKindAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__Kind__Group917); 
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
    // $ANTLR end rule__Kind__Group


    // $ANTLR start rule__Erwachsener__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:436:1: rule__Erwachsener__Group : ( 'erwachsener' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' ) ;
    public final void rule__Erwachsener__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:440:1: ( ( 'erwachsener' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:441:1: ( 'erwachsener' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( RULE_INT ) ) ) ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:441:1: ( 'erwachsener' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:442:1: 'erwachsener'
            {
             before(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Erwachsener__Group951); 
             after(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:447:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:448:1: '('
            {
             before(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FOLLOW_20_in_rule__Erwachsener__Group964); 
             after(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:453:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:454:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:455:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:456:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:456:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:457:1: RULE_ID
            {
             before(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Erwachsener__Group983); 
             after(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

             after(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:463:1: ( ( ( RULE_INT ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:464:1: ( ( RULE_INT ) )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:465:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:466:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:466:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:467:1: RULE_INT
            {
             before(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Erwachsener__Group1007); 
             after(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 

            }


            }

             after(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:473:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:474:1: ')'
            {
             before(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__Erwachsener__Group1025); 
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
    // $ANTLR end rule__Erwachsener__Group


    // $ANTLR start rule__Spielzeug__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:485:1: rule__Spielzeug__Group : ( 'spielzeug' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( ruleFarbe ) ) ) ( ')' ) ;
    public final void rule__Spielzeug__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:489:1: ( ( 'spielzeug' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( ruleFarbe ) ) ) ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:490:1: ( 'spielzeug' ) ( '(' ) ( ( ( RULE_ID ) ) ) ( ( ( ruleFarbe ) ) ) ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:490:1: ( 'spielzeug' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:491:1: 'spielzeug'
            {
             before(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Spielzeug__Group1059); 
             after(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:496:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:497:1: '('
            {
             before(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FOLLOW_20_in_rule__Spielzeug__Group1072); 
             after(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:502:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:503:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:504:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:505:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:505:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:506:1: RULE_ID
            {
             before(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Spielzeug__Group1091); 
             after(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

             after(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:512:1: ( ( ( ruleFarbe ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:513:1: ( ( ruleFarbe ) )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:514:1: ( ( ruleFarbe ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:515:1: ( ruleFarbe )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:515:1: ( ruleFarbe )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:516:1: ruleFarbe
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleFarbe_in_rule__Spielzeug__Group1115);
            ruleFarbe();
            _fsp--;

             after(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 

            }


            }

             after(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:522:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:523:1: ')'
            {
             before(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__Spielzeug__Group1133); 
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
    // $ANTLR end rule__Spielzeug__Group


    // $ANTLR start rule__Familie__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:534:1: rule__Familie__Group : ( 'familie' ) ( '(' ) ( ( ( ( rule__Familie__NameAlternatives_2_0 ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Familie__Group_6 )* ) ( ')' ) ;
    public final void rule__Familie__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:538:1: ( ( 'familie' ) ( '(' ) ( ( ( ( rule__Familie__NameAlternatives_2_0 ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Familie__Group_6 )* ) ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:539:1: ( 'familie' ) ( '(' ) ( ( ( ( rule__Familie__NameAlternatives_2_0 ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Familie__Group_6 )* ) ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:539:1: ( 'familie' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:540:1: 'familie'
            {
             before(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__Familie__Group1167); 
             after(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:545:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:546:1: '('
            {
             before(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FOLLOW_20_in_rule__Familie__Group1180); 
             after(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:551:1: ( ( ( ( rule__Familie__NameAlternatives_2_0 ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:552:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:553:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:554:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:554:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:555:1: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:556:1: ( rule__Familie__NameAlternatives_2_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:556:2: rule__Familie__NameAlternatives_2_0
            {
            pushFollow(FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__Group1199);
            rule__Familie__NameAlternatives_2_0();
            _fsp--;


            }

             after(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 

            }


            }

             after(grammarAccess.getFamilieAccess().getNameAssignment_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:562:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:563:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:564:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:565:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:565:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:566:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:567:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:568:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Familie__Group1229); 
             after(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 

            }


            }

             after(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:576:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:577:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:578:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:579:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:579:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:580:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:581:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:582:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Familie__Group1261); 
             after(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 

            }


            }

             after(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:590:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:591:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:592:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:593:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:593:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:594:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:595:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:596:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Familie__Group1293); 
             after(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 

            }


            }

             after(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:604:1: ( ( rule__Familie__Group_6 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:605:1: ( rule__Familie__Group_6 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:606:1: ( rule__Familie__Group_6 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:606:2: rule__Familie__Group_6
            	    {
            	    pushFollow(FOLLOW_rule__Familie__Group_6_in_rule__Familie__Group1314);
            	    rule__Familie__Group_6();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getFamilieAccess().getGroup_6()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:608:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:609:1: ')'
            {
             before(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7()); 
            match(input,21,FOLLOW_21_in_rule__Familie__Group1327); 
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
    // $ANTLR end rule__Familie__Group


    // $ANTLR start rule__Familie__Group_6
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:620:1: rule__Familie__Group_6 : ( ',' ) ( ( ( ( RULE_ID ) ) ) ) ;
    public final void rule__Familie__Group_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:624:1: ( ( ',' ) ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:625:1: ( ',' ) ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:625:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:626:1: ','
            {
             before(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 
            match(input,25,FOLLOW_25_in_rule__Familie__Group_61361); 
             after(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:631:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:632:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:633:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:634:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:634:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:635:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:636:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarTestLanguage.g:637:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Familie__Group_61384); 
             after(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 

            }


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
    // $ANTLR end rule__Familie__Group_6


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Spielplatz__Group_in_ruleSpielplatz94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Kind__Group_in_ruleKind156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Erwachsener__Group_in_ruleErwachsener215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Spielzeug__Group_in_ruleSpielzeug274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Farbe__Alternatives_in_ruleFarbe333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Familie__Group_in_ruleFamilie392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_rule__Spielplatz__Alternatives_4434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_rule__Spielplatz__Alternatives_4464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_rule__Spielplatz__Alternatives_4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_rule__Spielplatz__Alternatives_4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Farbe__Alternatives564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Farbe__Alternatives583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Farbe__Alternatives602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Farbe__Alternatives621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Familie__NameAlternatives_2_0655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Spielplatz__Group722 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Spielplatz__Group741 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Spielplatz__Group765 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rule__Spielplatz__Group784 = new BitSet(new long[]{0x0000000001CC0000L});
    public static final BitSet FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group796 = new BitSet(new long[]{0x0000000001CC0000L});
    public static final BitSet FOLLOW_18_in_rule__Spielplatz__Group809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Kind__Group843 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rule__Kind__Group856 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Kind__Group875 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Kind__Group899 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule__Kind__Group917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Erwachsener__Group951 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rule__Erwachsener__Group964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Erwachsener__Group983 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Erwachsener__Group1007 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule__Erwachsener__Group1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Spielzeug__Group1059 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rule__Spielzeug__Group1072 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Spielzeug__Group1091 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_ruleFarbe_in_rule__Spielzeug__Group1115 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule__Spielzeug__Group1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Familie__Group1167 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rule__Familie__Group1180 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__Group1199 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__Group1229 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__Group1261 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__Group1293 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_rule__Familie__Group_6_in_rule__Familie__Group1314 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_21_in_rule__Familie__Group1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Familie__Group_61361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__Group_61384 = new BitSet(new long[]{0x0000000000000002L});

}