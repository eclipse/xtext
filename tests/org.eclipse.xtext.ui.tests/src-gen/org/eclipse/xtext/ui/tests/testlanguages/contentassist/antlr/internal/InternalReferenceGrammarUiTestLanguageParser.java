package org.eclipse.xtext.ui.tests.testlanguages.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.tests.testlanguages.services.ReferenceGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarUiTestLanguageParser extends AbstractInternalContentAssistParser {
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

        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g"; }


     
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




    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:60:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:61:1: ( ruleSpielplatz EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:62:1: ruleSpielplatz EOF
            {
             before(grammarAccess.getSpielplatzRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz61);
            ruleSpielplatz();
            _fsp--;

             after(grammarAccess.getSpielplatzRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielplatz68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:69:1: ruleSpielplatz : ( ( rule__Spielplatz__Group__0 )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:73:2: ( ( ( rule__Spielplatz__Group__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:74:1: ( ( rule__Spielplatz__Group__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:74:1: ( ( rule__Spielplatz__Group__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:75:1: ( rule__Spielplatz__Group__0 )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:76:1: ( rule__Spielplatz__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:76:2: rule__Spielplatz__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__0_in_ruleSpielplatz95);
                    rule__Spielplatz__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:90:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:91:1: ( ruleKind EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:92:1: ruleKind EOF
            {
             before(grammarAccess.getKindRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_entryRuleKind125);
            ruleKind();
            _fsp--;

             after(grammarAccess.getKindRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKind132); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:99:1: ruleKind : ( ( rule__Kind__Group__0 ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:103:2: ( ( ( rule__Kind__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:104:1: ( ( rule__Kind__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:104:1: ( ( rule__Kind__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:105:1: ( rule__Kind__Group__0 )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:106:1: ( rule__Kind__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:106:2: rule__Kind__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__0_in_ruleKind159);
            rule__Kind__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:118:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:119:1: ( ruleErwachsener EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:120:1: ruleErwachsener EOF
            {
             before(grammarAccess.getErwachsenerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_entryRuleErwachsener186);
            ruleErwachsener();
            _fsp--;

             after(grammarAccess.getErwachsenerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleErwachsener193); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:127:1: ruleErwachsener : ( ( rule__Erwachsener__Group__0 ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:131:2: ( ( ( rule__Erwachsener__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:1: ( ( rule__Erwachsener__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:1: ( ( rule__Erwachsener__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:133:1: ( rule__Erwachsener__Group__0 )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:134:1: ( rule__Erwachsener__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:134:2: rule__Erwachsener__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__0_in_ruleErwachsener220);
            rule__Erwachsener__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:146:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:147:1: ( ruleSpielzeug EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:148:1: ruleSpielzeug EOF
            {
             before(grammarAccess.getSpielzeugRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug247);
            ruleSpielzeug();
            _fsp--;

             after(grammarAccess.getSpielzeugRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielzeug254); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:155:1: ruleSpielzeug : ( ( rule__Spielzeug__Group__0 ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:159:2: ( ( ( rule__Spielzeug__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:160:1: ( ( rule__Spielzeug__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:160:1: ( ( rule__Spielzeug__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:161:1: ( rule__Spielzeug__Group__0 )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:162:1: ( rule__Spielzeug__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:162:2: rule__Spielzeug__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__0_in_ruleSpielzeug281);
            rule__Spielzeug__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:174:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:175:1: ( ruleFarbe EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:176:1: ruleFarbe EOF
            {
             before(grammarAccess.getFarbeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_entryRuleFarbe308);
            ruleFarbe();
            _fsp--;

             after(grammarAccess.getFarbeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFarbe315); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:183:1: ruleFarbe : ( ( rule__Farbe__WertAssignment ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:187:2: ( ( ( rule__Farbe__WertAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:188:1: ( ( rule__Farbe__WertAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:188:1: ( ( rule__Farbe__WertAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:189:1: ( rule__Farbe__WertAssignment )
            {
             before(grammarAccess.getFarbeAccess().getWertAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:190:1: ( rule__Farbe__WertAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:190:2: rule__Farbe__WertAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Farbe__WertAssignment_in_ruleFarbe342);
            rule__Farbe__WertAssignment();
            _fsp--;


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
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleFamilie
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:202:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:203:1: ( ruleFamilie EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:204:1: ruleFamilie EOF
            {
             before(grammarAccess.getFamilieRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_entryRuleFamilie369);
            ruleFamilie();
            _fsp--;

             after(grammarAccess.getFamilieRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFamilie376); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:211:1: ruleFamilie : ( ( rule__Familie__Group__0 ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:215:2: ( ( ( rule__Familie__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:216:1: ( ( rule__Familie__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:216:1: ( ( rule__Familie__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:217:1: ( rule__Familie__Group__0 )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:218:1: ( rule__Familie__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:218:2: rule__Familie__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__0_in_ruleFamilie403);
            rule__Familie__Group__0();
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:230:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:234:1: ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) )
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
                    new NoViableAltException("230:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:235:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:235:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:236:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:237:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:237:2: rule__Spielplatz__KinderAssignment_4_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__KinderAssignment_4_0_in_rule__Spielplatz__Alternatives_4439);
                    rule__Spielplatz__KinderAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:241:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:241:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:242:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:243:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:243:2: rule__Spielplatz__ErzieherAssignment_4_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__ErzieherAssignment_4_1_in_rule__Spielplatz__Alternatives_4457);
                    rule__Spielplatz__ErzieherAssignment_4_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:247:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:247:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:248:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:249:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:249:2: rule__Spielplatz__SpielzeugeAssignment_4_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__SpielzeugeAssignment_4_2_in_rule__Spielplatz__Alternatives_4475);
                    rule__Spielplatz__SpielzeugeAssignment_4_2();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:253:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:253:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:254:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:255:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:255:2: rule__Spielplatz__FamilieAssignment_4_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__FamilieAssignment_4_3_in_rule__Spielplatz__Alternatives_4493);
                    rule__Spielplatz__FamilieAssignment_4_3();
                    _fsp--;


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


    // $ANTLR start rule__Farbe__WertAlternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:265:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );
    public final void rule__Farbe__WertAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:269:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) )
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
                    new NoViableAltException("265:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u00DCN' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:270:1: ( 'ROT' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:270:1: ( 'ROT' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:271:1: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Farbe__WertAlternatives_0528); 
                     after(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:278:6: ( 'BLAU' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:278:6: ( 'BLAU' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:279:1: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Farbe__WertAlternatives_0548); 
                     after(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:286:6: ( 'GELB' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:286:6: ( 'GELB' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:287:1: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Farbe__WertAlternatives_0568); 
                     after(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:294:6: ( 'GR\\u00DCN' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:295:1: 'GR\\u00DCN'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Farbe__WertAlternatives_0588); 
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
    // $ANTLR end rule__Farbe__WertAlternatives_0


    // $ANTLR start rule__Familie__NameAlternatives_2_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:307:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:311:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
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
                    new NoViableAltException("307:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'keyword' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:312:1: ( 'keyword' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:1: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Familie__NameAlternatives_2_0623); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:320:6: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:320:6: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:321:1: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0642); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:326:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:326:6: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:327:1: RULE_ID
                    {
                     before(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0659); 
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


    // $ANTLR start rule__Spielplatz__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:339:1: rule__Spielplatz__Group__0 : ( 'spielplatz' ) rule__Spielplatz__Group__1 ;
    public final void rule__Spielplatz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:343:1: ( ( 'spielplatz' ) rule__Spielplatz__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:344:1: ( 'spielplatz' ) rule__Spielplatz__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:344:1: ( 'spielplatz' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:345:1: 'spielplatz'
            {
             before(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Spielplatz__Group__0694); 
             after(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__1_in_rule__Spielplatz__Group__0704);
            rule__Spielplatz__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__0


    // $ANTLR start rule__Spielplatz__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:359:1: rule__Spielplatz__Group__1 : ( ( rule__Spielplatz__GroesseAssignment_1 ) ) rule__Spielplatz__Group__2 ;
    public final void rule__Spielplatz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:363:1: ( ( ( rule__Spielplatz__GroesseAssignment_1 ) ) rule__Spielplatz__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:364:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) ) rule__Spielplatz__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:364:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:365:1: ( rule__Spielplatz__GroesseAssignment_1 )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:366:1: ( rule__Spielplatz__GroesseAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:366:2: rule__Spielplatz__GroesseAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__GroesseAssignment_1_in_rule__Spielplatz__Group__1732);
            rule__Spielplatz__GroesseAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__2_in_rule__Spielplatz__Group__1741);
            rule__Spielplatz__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__1


    // $ANTLR start rule__Spielplatz__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:377:1: rule__Spielplatz__Group__2 : ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) rule__Spielplatz__Group__3 ;
    public final void rule__Spielplatz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:381:1: ( ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) rule__Spielplatz__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:382:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) rule__Spielplatz__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:382:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:383:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:384:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:384:2: rule__Spielplatz__BeschreibungAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__BeschreibungAssignment_2_in_rule__Spielplatz__Group__2769);
                    rule__Spielplatz__BeschreibungAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__3_in_rule__Spielplatz__Group__2779);
            rule__Spielplatz__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__2


    // $ANTLR start rule__Spielplatz__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:395:1: rule__Spielplatz__Group__3 : ( '{' ) rule__Spielplatz__Group__4 ;
    public final void rule__Spielplatz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:399:1: ( ( '{' ) rule__Spielplatz__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:400:1: ( '{' ) rule__Spielplatz__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:400:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:401:1: '{'
            {
             before(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Spielplatz__Group__3808); 
             after(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__4_in_rule__Spielplatz__Group__3818);
            rule__Spielplatz__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__3


    // $ANTLR start rule__Spielplatz__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:415:1: rule__Spielplatz__Group__4 : ( ( rule__Spielplatz__Alternatives_4 )* ) rule__Spielplatz__Group__5 ;
    public final void rule__Spielplatz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:419:1: ( ( ( rule__Spielplatz__Alternatives_4 )* ) rule__Spielplatz__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:420:1: ( ( rule__Spielplatz__Alternatives_4 )* ) rule__Spielplatz__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:420:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:421:1: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:422:1: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:422:2: rule__Spielplatz__Alternatives_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group__4846);
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

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__5_in_rule__Spielplatz__Group__4856);
            rule__Spielplatz__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__4


    // $ANTLR start rule__Spielplatz__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:433:1: rule__Spielplatz__Group__5 : ( '}' ) ;
    public final void rule__Spielplatz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:437:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:438:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:438:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:439:1: '}'
            {
             before(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Spielplatz__Group__5885); 
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
    // $ANTLR end rule__Spielplatz__Group__5


    // $ANTLR start rule__Kind__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:464:1: rule__Kind__Group__0 : ( 'kind' ) rule__Kind__Group__1 ;
    public final void rule__Kind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:468:1: ( ( 'kind' ) rule__Kind__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:469:1: ( 'kind' ) rule__Kind__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:469:1: ( 'kind' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:470:1: 'kind'
            {
             before(grammarAccess.getKindAccess().getKindKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Kind__Group__0933); 
             after(grammarAccess.getKindAccess().getKindKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__1_in_rule__Kind__Group__0943);
            rule__Kind__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Kind__Group__0


    // $ANTLR start rule__Kind__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:484:1: rule__Kind__Group__1 : ( '(' ) rule__Kind__Group__2 ;
    public final void rule__Kind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:488:1: ( ( '(' ) rule__Kind__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:489:1: ( '(' ) rule__Kind__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:489:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:490:1: '('
            {
             before(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Kind__Group__1972); 
             after(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__2_in_rule__Kind__Group__1982);
            rule__Kind__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Kind__Group__1


    // $ANTLR start rule__Kind__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:504:1: rule__Kind__Group__2 : ( ( rule__Kind__NameAssignment_2 ) ) rule__Kind__Group__3 ;
    public final void rule__Kind__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:508:1: ( ( ( rule__Kind__NameAssignment_2 ) ) rule__Kind__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:509:1: ( ( rule__Kind__NameAssignment_2 ) ) rule__Kind__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:509:1: ( ( rule__Kind__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:510:1: ( rule__Kind__NameAssignment_2 )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:511:1: ( rule__Kind__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:511:2: rule__Kind__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__NameAssignment_2_in_rule__Kind__Group__21010);
            rule__Kind__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getKindAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__3_in_rule__Kind__Group__21019);
            rule__Kind__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Kind__Group__2


    // $ANTLR start rule__Kind__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:522:1: rule__Kind__Group__3 : ( ( rule__Kind__AgeAssignment_3 ) ) rule__Kind__Group__4 ;
    public final void rule__Kind__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:526:1: ( ( ( rule__Kind__AgeAssignment_3 ) ) rule__Kind__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:527:1: ( ( rule__Kind__AgeAssignment_3 ) ) rule__Kind__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:527:1: ( ( rule__Kind__AgeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:528:1: ( rule__Kind__AgeAssignment_3 )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:529:1: ( rule__Kind__AgeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:529:2: rule__Kind__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__AgeAssignment_3_in_rule__Kind__Group__31047);
            rule__Kind__AgeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getKindAccess().getAgeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__4_in_rule__Kind__Group__31056);
            rule__Kind__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Kind__Group__3


    // $ANTLR start rule__Kind__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:540:1: rule__Kind__Group__4 : ( ')' ) ;
    public final void rule__Kind__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:544:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:545:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:545:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:546:1: ')'
            {
             before(grammarAccess.getKindAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Kind__Group__41085); 
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
    // $ANTLR end rule__Kind__Group__4


    // $ANTLR start rule__Erwachsener__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:569:1: rule__Erwachsener__Group__0 : ( 'erwachsener' ) rule__Erwachsener__Group__1 ;
    public final void rule__Erwachsener__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:573:1: ( ( 'erwachsener' ) rule__Erwachsener__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:574:1: ( 'erwachsener' ) rule__Erwachsener__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:574:1: ( 'erwachsener' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:575:1: 'erwachsener'
            {
             before(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Erwachsener__Group__01131); 
             after(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__1_in_rule__Erwachsener__Group__01141);
            rule__Erwachsener__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Erwachsener__Group__0


    // $ANTLR start rule__Erwachsener__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:589:1: rule__Erwachsener__Group__1 : ( '(' ) rule__Erwachsener__Group__2 ;
    public final void rule__Erwachsener__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:593:1: ( ( '(' ) rule__Erwachsener__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:594:1: ( '(' ) rule__Erwachsener__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:594:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:595:1: '('
            {
             before(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Erwachsener__Group__11170); 
             after(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__2_in_rule__Erwachsener__Group__11180);
            rule__Erwachsener__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Erwachsener__Group__1


    // $ANTLR start rule__Erwachsener__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:609:1: rule__Erwachsener__Group__2 : ( ( rule__Erwachsener__NameAssignment_2 ) ) rule__Erwachsener__Group__3 ;
    public final void rule__Erwachsener__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:613:1: ( ( ( rule__Erwachsener__NameAssignment_2 ) ) rule__Erwachsener__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:614:1: ( ( rule__Erwachsener__NameAssignment_2 ) ) rule__Erwachsener__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:614:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:615:1: ( rule__Erwachsener__NameAssignment_2 )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:616:1: ( rule__Erwachsener__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:616:2: rule__Erwachsener__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__NameAssignment_2_in_rule__Erwachsener__Group__21208);
            rule__Erwachsener__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__3_in_rule__Erwachsener__Group__21217);
            rule__Erwachsener__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Erwachsener__Group__2


    // $ANTLR start rule__Erwachsener__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:627:1: rule__Erwachsener__Group__3 : ( ( rule__Erwachsener__AgeAssignment_3 ) ) rule__Erwachsener__Group__4 ;
    public final void rule__Erwachsener__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:631:1: ( ( ( rule__Erwachsener__AgeAssignment_3 ) ) rule__Erwachsener__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:632:1: ( ( rule__Erwachsener__AgeAssignment_3 ) ) rule__Erwachsener__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:632:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:633:1: ( rule__Erwachsener__AgeAssignment_3 )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:634:1: ( rule__Erwachsener__AgeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:634:2: rule__Erwachsener__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__AgeAssignment_3_in_rule__Erwachsener__Group__31245);
            rule__Erwachsener__AgeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__4_in_rule__Erwachsener__Group__31254);
            rule__Erwachsener__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Erwachsener__Group__3


    // $ANTLR start rule__Erwachsener__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:645:1: rule__Erwachsener__Group__4 : ( ')' ) ;
    public final void rule__Erwachsener__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:649:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:650:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:650:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:651:1: ')'
            {
             before(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Erwachsener__Group__41283); 
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
    // $ANTLR end rule__Erwachsener__Group__4


    // $ANTLR start rule__Spielzeug__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:674:1: rule__Spielzeug__Group__0 : ( 'spielzeug' ) rule__Spielzeug__Group__1 ;
    public final void rule__Spielzeug__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:678:1: ( ( 'spielzeug' ) rule__Spielzeug__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:679:1: ( 'spielzeug' ) rule__Spielzeug__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:679:1: ( 'spielzeug' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:680:1: 'spielzeug'
            {
             before(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Spielzeug__Group__01329); 
             after(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__1_in_rule__Spielzeug__Group__01339);
            rule__Spielzeug__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielzeug__Group__0


    // $ANTLR start rule__Spielzeug__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:694:1: rule__Spielzeug__Group__1 : ( '(' ) rule__Spielzeug__Group__2 ;
    public final void rule__Spielzeug__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:698:1: ( ( '(' ) rule__Spielzeug__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:699:1: ( '(' ) rule__Spielzeug__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:699:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:700:1: '('
            {
             before(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Spielzeug__Group__11368); 
             after(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__2_in_rule__Spielzeug__Group__11378);
            rule__Spielzeug__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielzeug__Group__1


    // $ANTLR start rule__Spielzeug__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:714:1: rule__Spielzeug__Group__2 : ( ( rule__Spielzeug__NameAssignment_2 ) ) rule__Spielzeug__Group__3 ;
    public final void rule__Spielzeug__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:718:1: ( ( ( rule__Spielzeug__NameAssignment_2 ) ) rule__Spielzeug__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:719:1: ( ( rule__Spielzeug__NameAssignment_2 ) ) rule__Spielzeug__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:719:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:720:1: ( rule__Spielzeug__NameAssignment_2 )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:721:1: ( rule__Spielzeug__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:721:2: rule__Spielzeug__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__NameAssignment_2_in_rule__Spielzeug__Group__21406);
            rule__Spielzeug__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__3_in_rule__Spielzeug__Group__21415);
            rule__Spielzeug__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielzeug__Group__2


    // $ANTLR start rule__Spielzeug__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:732:1: rule__Spielzeug__Group__3 : ( ( rule__Spielzeug__FarbeAssignment_3 ) ) rule__Spielzeug__Group__4 ;
    public final void rule__Spielzeug__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:736:1: ( ( ( rule__Spielzeug__FarbeAssignment_3 ) ) rule__Spielzeug__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:737:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) ) rule__Spielzeug__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:737:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:738:1: ( rule__Spielzeug__FarbeAssignment_3 )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:739:1: ( rule__Spielzeug__FarbeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:739:2: rule__Spielzeug__FarbeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__FarbeAssignment_3_in_rule__Spielzeug__Group__31443);
            rule__Spielzeug__FarbeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__4_in_rule__Spielzeug__Group__31452);
            rule__Spielzeug__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielzeug__Group__3


    // $ANTLR start rule__Spielzeug__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:750:1: rule__Spielzeug__Group__4 : ( ')' ) ;
    public final void rule__Spielzeug__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:754:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:755:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:755:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:756:1: ')'
            {
             before(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Spielzeug__Group__41481); 
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
    // $ANTLR end rule__Spielzeug__Group__4


    // $ANTLR start rule__Familie__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:779:1: rule__Familie__Group__0 : ( 'familie' ) rule__Familie__Group__1 ;
    public final void rule__Familie__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:783:1: ( ( 'familie' ) rule__Familie__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:784:1: ( 'familie' ) rule__Familie__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:784:1: ( 'familie' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:785:1: 'familie'
            {
             before(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Familie__Group__01527); 
             after(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__1_in_rule__Familie__Group__01537);
            rule__Familie__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__0


    // $ANTLR start rule__Familie__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:799:1: rule__Familie__Group__1 : ( '(' ) rule__Familie__Group__2 ;
    public final void rule__Familie__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:803:1: ( ( '(' ) rule__Familie__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:804:1: ( '(' ) rule__Familie__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:804:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:805:1: '('
            {
             before(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Familie__Group__11566); 
             after(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__2_in_rule__Familie__Group__11576);
            rule__Familie__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__1


    // $ANTLR start rule__Familie__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:819:1: rule__Familie__Group__2 : ( ( rule__Familie__NameAssignment_2 ) ) rule__Familie__Group__3 ;
    public final void rule__Familie__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:823:1: ( ( ( rule__Familie__NameAssignment_2 ) ) rule__Familie__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:824:1: ( ( rule__Familie__NameAssignment_2 ) ) rule__Familie__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:824:1: ( ( rule__Familie__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:825:1: ( rule__Familie__NameAssignment_2 )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:826:1: ( rule__Familie__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:826:2: rule__Familie__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__NameAssignment_2_in_rule__Familie__Group__21604);
            rule__Familie__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getFamilieAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__3_in_rule__Familie__Group__21613);
            rule__Familie__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__2


    // $ANTLR start rule__Familie__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:837:1: rule__Familie__Group__3 : ( ( rule__Familie__MutterAssignment_3 ) ) rule__Familie__Group__4 ;
    public final void rule__Familie__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:841:1: ( ( ( rule__Familie__MutterAssignment_3 ) ) rule__Familie__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:842:1: ( ( rule__Familie__MutterAssignment_3 ) ) rule__Familie__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:842:1: ( ( rule__Familie__MutterAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:843:1: ( rule__Familie__MutterAssignment_3 )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:844:1: ( rule__Familie__MutterAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:844:2: rule__Familie__MutterAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__MutterAssignment_3_in_rule__Familie__Group__31641);
            rule__Familie__MutterAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__4_in_rule__Familie__Group__31650);
            rule__Familie__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__3


    // $ANTLR start rule__Familie__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:855:1: rule__Familie__Group__4 : ( ( rule__Familie__VaterAssignment_4 ) ) rule__Familie__Group__5 ;
    public final void rule__Familie__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:859:1: ( ( ( rule__Familie__VaterAssignment_4 ) ) rule__Familie__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:860:1: ( ( rule__Familie__VaterAssignment_4 ) ) rule__Familie__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:860:1: ( ( rule__Familie__VaterAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:861:1: ( rule__Familie__VaterAssignment_4 )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:862:1: ( rule__Familie__VaterAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:862:2: rule__Familie__VaterAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__VaterAssignment_4_in_rule__Familie__Group__41678);
            rule__Familie__VaterAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__5_in_rule__Familie__Group__41687);
            rule__Familie__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__4


    // $ANTLR start rule__Familie__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:873:1: rule__Familie__Group__5 : ( ( rule__Familie__KinderAssignment_5 ) ) rule__Familie__Group__6 ;
    public final void rule__Familie__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:877:1: ( ( ( rule__Familie__KinderAssignment_5 ) ) rule__Familie__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:878:1: ( ( rule__Familie__KinderAssignment_5 ) ) rule__Familie__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:878:1: ( ( rule__Familie__KinderAssignment_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:879:1: ( rule__Familie__KinderAssignment_5 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:880:1: ( rule__Familie__KinderAssignment_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:880:2: rule__Familie__KinderAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__KinderAssignment_5_in_rule__Familie__Group__51715);
            rule__Familie__KinderAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__6_in_rule__Familie__Group__51724);
            rule__Familie__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__5


    // $ANTLR start rule__Familie__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:891:1: rule__Familie__Group__6 : ( ( rule__Familie__Group_6__0 )* ) rule__Familie__Group__7 ;
    public final void rule__Familie__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:895:1: ( ( ( rule__Familie__Group_6__0 )* ) rule__Familie__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:896:1: ( ( rule__Familie__Group_6__0 )* ) rule__Familie__Group__7
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:896:1: ( ( rule__Familie__Group_6__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:897:1: ( rule__Familie__Group_6__0 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:898:1: ( rule__Familie__Group_6__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:898:2: rule__Familie__Group_6__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__0_in_rule__Familie__Group__61752);
            	    rule__Familie__Group_6__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getFamilieAccess().getGroup_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__7_in_rule__Familie__Group__61762);
            rule__Familie__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__6


    // $ANTLR start rule__Familie__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:909:1: rule__Familie__Group__7 : ( ')' ) ;
    public final void rule__Familie__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:913:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:914:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:914:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:915:1: ')'
            {
             before(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Familie__Group__71791); 
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
    // $ANTLR end rule__Familie__Group__7


    // $ANTLR start rule__Familie__Group_6__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:944:1: rule__Familie__Group_6__0 : ( ',' ) rule__Familie__Group_6__1 ;
    public final void rule__Familie__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:948:1: ( ( ',' ) rule__Familie__Group_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:949:1: ( ',' ) rule__Familie__Group_6__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:949:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:950:1: ','
            {
             before(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Familie__Group_6__01843); 
             after(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__1_in_rule__Familie__Group_6__01853);
            rule__Familie__Group_6__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group_6__0


    // $ANTLR start rule__Familie__Group_6__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:964:1: rule__Familie__Group_6__1 : ( ( rule__Familie__KinderAssignment_6_1 ) ) ;
    public final void rule__Familie__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:968:1: ( ( ( rule__Familie__KinderAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:969:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:969:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:970:1: ( rule__Familie__KinderAssignment_6_1 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:971:1: ( rule__Familie__KinderAssignment_6_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:971:2: rule__Familie__KinderAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__KinderAssignment_6_1_in_rule__Familie__Group_6__11881);
            rule__Familie__KinderAssignment_6_1();
            _fsp--;


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
    // $ANTLR end rule__Familie__Group_6__1


    // $ANTLR start rule__Spielplatz__GroesseAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:986:1: rule__Spielplatz__GroesseAssignment_1 : ( RULE_INT ) ;
    public final void rule__Spielplatz__GroesseAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:990:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:991:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:991:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:992:1: RULE_INT
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Spielplatz__GroesseAssignment_11920); 
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
    // $ANTLR end rule__Spielplatz__GroesseAssignment_1


    // $ANTLR start rule__Spielplatz__BeschreibungAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1001:1: rule__Spielplatz__BeschreibungAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Spielplatz__BeschreibungAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1005:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1006:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1006:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1007:1: RULE_STRING
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Spielplatz__BeschreibungAssignment_21951); 
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
    // $ANTLR end rule__Spielplatz__BeschreibungAssignment_2


    // $ANTLR start rule__Spielplatz__KinderAssignment_4_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1016:1: rule__Spielplatz__KinderAssignment_4_0 : ( ruleKind ) ;
    public final void rule__Spielplatz__KinderAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1020:1: ( ( ruleKind ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1021:1: ( ruleKind )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1021:1: ( ruleKind )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1022:1: ruleKind
            {
             before(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_rule__Spielplatz__KinderAssignment_4_01982);
            ruleKind();
            _fsp--;

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
    // $ANTLR end rule__Spielplatz__KinderAssignment_4_0


    // $ANTLR start rule__Spielplatz__ErzieherAssignment_4_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1031:1: rule__Spielplatz__ErzieherAssignment_4_1 : ( ruleErwachsener ) ;
    public final void rule__Spielplatz__ErzieherAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1035:1: ( ( ruleErwachsener ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1036:1: ( ruleErwachsener )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1036:1: ( ruleErwachsener )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1037:1: ruleErwachsener
            {
             before(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_rule__Spielplatz__ErzieherAssignment_4_12013);
            ruleErwachsener();
            _fsp--;

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
    // $ANTLR end rule__Spielplatz__ErzieherAssignment_4_1


    // $ANTLR start rule__Spielplatz__SpielzeugeAssignment_4_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1046:1: rule__Spielplatz__SpielzeugeAssignment_4_2 : ( ruleSpielzeug ) ;
    public final void rule__Spielplatz__SpielzeugeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1050:1: ( ( ruleSpielzeug ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1051:1: ( ruleSpielzeug )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1051:1: ( ruleSpielzeug )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1052:1: ruleSpielzeug
            {
             before(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_rule__Spielplatz__SpielzeugeAssignment_4_22044);
            ruleSpielzeug();
            _fsp--;

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
    // $ANTLR end rule__Spielplatz__SpielzeugeAssignment_4_2


    // $ANTLR start rule__Spielplatz__FamilieAssignment_4_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1061:1: rule__Spielplatz__FamilieAssignment_4_3 : ( ruleFamilie ) ;
    public final void rule__Spielplatz__FamilieAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1065:1: ( ( ruleFamilie ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1066:1: ( ruleFamilie )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1066:1: ( ruleFamilie )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1067:1: ruleFamilie
            {
             before(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_rule__Spielplatz__FamilieAssignment_4_32075);
            ruleFamilie();
            _fsp--;

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
    // $ANTLR end rule__Spielplatz__FamilieAssignment_4_3


    // $ANTLR start rule__Kind__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1076:1: rule__Kind__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Kind__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1080:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1081:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1081:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1082:1: RULE_ID
            {
             before(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Kind__NameAssignment_22106); 
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
    // $ANTLR end rule__Kind__NameAssignment_2


    // $ANTLR start rule__Kind__AgeAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1091:1: rule__Kind__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Kind__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1095:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1096:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1096:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1097:1: RULE_INT
            {
             before(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Kind__AgeAssignment_32137); 
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
    // $ANTLR end rule__Kind__AgeAssignment_3


    // $ANTLR start rule__Erwachsener__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1106:1: rule__Erwachsener__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Erwachsener__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1110:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1111:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1111:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1112:1: RULE_ID
            {
             before(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Erwachsener__NameAssignment_22168); 
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
    // $ANTLR end rule__Erwachsener__NameAssignment_2


    // $ANTLR start rule__Erwachsener__AgeAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1121:1: rule__Erwachsener__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Erwachsener__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1125:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1126:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1126:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1127:1: RULE_INT
            {
             before(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Erwachsener__AgeAssignment_32199); 
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
    // $ANTLR end rule__Erwachsener__AgeAssignment_3


    // $ANTLR start rule__Spielzeug__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1136:1: rule__Spielzeug__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Spielzeug__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1140:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1141:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1141:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1142:1: RULE_ID
            {
             before(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Spielzeug__NameAssignment_22230); 
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
    // $ANTLR end rule__Spielzeug__NameAssignment_2


    // $ANTLR start rule__Spielzeug__FarbeAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1151:1: rule__Spielzeug__FarbeAssignment_3 : ( ruleFarbe ) ;
    public final void rule__Spielzeug__FarbeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1155:1: ( ( ruleFarbe ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1156:1: ( ruleFarbe )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1156:1: ( ruleFarbe )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1157:1: ruleFarbe
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_rule__Spielzeug__FarbeAssignment_32261);
            ruleFarbe();
            _fsp--;

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
    // $ANTLR end rule__Spielzeug__FarbeAssignment_3


    // $ANTLR start rule__Farbe__WertAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1166:1: rule__Farbe__WertAssignment : ( ( rule__Farbe__WertAlternatives_0 ) ) ;
    public final void rule__Farbe__WertAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1170:1: ( ( ( rule__Farbe__WertAlternatives_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1171:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1171:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1172:1: ( rule__Farbe__WertAlternatives_0 )
            {
             before(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1173:1: ( rule__Farbe__WertAlternatives_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1173:2: rule__Farbe__WertAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Farbe__WertAlternatives_0_in_rule__Farbe__WertAssignment2292);
            rule__Farbe__WertAlternatives_0();
            _fsp--;


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
    // $ANTLR end rule__Farbe__WertAssignment


    // $ANTLR start rule__Familie__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1182:1: rule__Familie__NameAssignment_2 : ( ( rule__Familie__NameAlternatives_2_0 ) ) ;
    public final void rule__Familie__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1186:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1187:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1187:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1188:1: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1189:1: ( rule__Familie__NameAlternatives_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1189:2: rule__Familie__NameAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__NameAssignment_22325);
            rule__Familie__NameAlternatives_2_0();
            _fsp--;


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
    // $ANTLR end rule__Familie__NameAssignment_2


    // $ANTLR start rule__Familie__MutterAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1198:1: rule__Familie__MutterAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__MutterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1202:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1203:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1203:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1204:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1205:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1206:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__MutterAssignment_32362); 
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
    // $ANTLR end rule__Familie__MutterAssignment_3


    // $ANTLR start rule__Familie__VaterAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1217:1: rule__Familie__VaterAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__VaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1221:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1222:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1222:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1223:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1224:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1225:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__VaterAssignment_42401); 
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
    // $ANTLR end rule__Familie__VaterAssignment_4


    // $ANTLR start rule__Familie__KinderAssignment_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1236:1: rule__Familie__KinderAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1240:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1241:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1241:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1242:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1243:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1244:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_52440); 
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
    // $ANTLR end rule__Familie__KinderAssignment_5


    // $ANTLR start rule__Familie__KinderAssignment_6_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1255:1: rule__Familie__KinderAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1259:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1260:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1260:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1261:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1262:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1263:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_6_12479); 
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
    // $ANTLR end rule__Familie__KinderAssignment_6_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__0_in_ruleSpielplatz95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_entryRuleKind125 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKind132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__0_in_ruleKind159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__0_in_ruleErwachsener220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__0_in_ruleSpielzeug281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFarbe315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Farbe__WertAssignment_in_ruleFarbe342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFamilie376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__0_in_ruleFamilie403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__KinderAssignment_4_0_in_rule__Spielplatz__Alternatives_4439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__ErzieherAssignment_4_1_in_rule__Spielplatz__Alternatives_4457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__SpielzeugeAssignment_4_2_in_rule__Spielplatz__Alternatives_4475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__FamilieAssignment_4_3_in_rule__Spielplatz__Alternatives_4493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Farbe__WertAlternatives_0528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Farbe__WertAlternatives_0548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Farbe__WertAlternatives_0568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Farbe__WertAlternatives_0588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Familie__NameAlternatives_2_0623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Spielplatz__Group__0694 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__1_in_rule__Spielplatz__Group__0704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__GroesseAssignment_1_in_rule__Spielplatz__Group__1732 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__2_in_rule__Spielplatz__Group__1741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__BeschreibungAssignment_2_in_rule__Spielplatz__Group__2769 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__3_in_rule__Spielplatz__Group__2779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Spielplatz__Group__3808 = new BitSet(new long[]{0x0000000001CC0000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__4_in_rule__Spielplatz__Group__3818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group__4846 = new BitSet(new long[]{0x0000000001CC0000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__5_in_rule__Spielplatz__Group__4856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Spielplatz__Group__5885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Kind__Group__0933 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Kind__Group__1_in_rule__Kind__Group__0943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Kind__Group__1972 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Kind__Group__2_in_rule__Kind__Group__1982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__NameAssignment_2_in_rule__Kind__Group__21010 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Kind__Group__3_in_rule__Kind__Group__21019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__AgeAssignment_3_in_rule__Kind__Group__31047 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Kind__Group__4_in_rule__Kind__Group__31056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Kind__Group__41085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Erwachsener__Group__01131 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__1_in_rule__Erwachsener__Group__01141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Erwachsener__Group__11170 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__2_in_rule__Erwachsener__Group__11180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__NameAssignment_2_in_rule__Erwachsener__Group__21208 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__3_in_rule__Erwachsener__Group__21217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__AgeAssignment_3_in_rule__Erwachsener__Group__31245 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__4_in_rule__Erwachsener__Group__31254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Erwachsener__Group__41283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Spielzeug__Group__01329 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__1_in_rule__Spielzeug__Group__01339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Spielzeug__Group__11368 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__2_in_rule__Spielzeug__Group__11378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__NameAssignment_2_in_rule__Spielzeug__Group__21406 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__3_in_rule__Spielzeug__Group__21415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__FarbeAssignment_3_in_rule__Spielzeug__Group__31443 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__4_in_rule__Spielzeug__Group__31452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Spielzeug__Group__41481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Familie__Group__01527 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Familie__Group__1_in_rule__Familie__Group__01537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Familie__Group__11566 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_rule__Familie__Group__2_in_rule__Familie__Group__11576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__NameAssignment_2_in_rule__Familie__Group__21604 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__3_in_rule__Familie__Group__21613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__MutterAssignment_3_in_rule__Familie__Group__31641 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__4_in_rule__Familie__Group__31650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__VaterAssignment_4_in_rule__Familie__Group__41678 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__5_in_rule__Familie__Group__41687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__KinderAssignment_5_in_rule__Familie__Group__51715 = new BitSet(new long[]{0x0000000002200000L});
        public static final BitSet FOLLOW_rule__Familie__Group__6_in_rule__Familie__Group__51724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__0_in_rule__Familie__Group__61752 = new BitSet(new long[]{0x0000000002200000L});
        public static final BitSet FOLLOW_rule__Familie__Group__7_in_rule__Familie__Group__61762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Familie__Group__71791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Familie__Group_6__01843 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__1_in_rule__Familie__Group_6__01853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__KinderAssignment_6_1_in_rule__Familie__Group_6__11881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Spielplatz__GroesseAssignment_11920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Spielplatz__BeschreibungAssignment_21951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_rule__Spielplatz__KinderAssignment_4_01982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_rule__Spielplatz__ErzieherAssignment_4_12013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_rule__Spielplatz__SpielzeugeAssignment_4_22044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_rule__Spielplatz__FamilieAssignment_4_32075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Kind__NameAssignment_22106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Kind__AgeAssignment_32137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Erwachsener__NameAssignment_22168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Erwachsener__AgeAssignment_32199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Spielzeug__NameAssignment_22230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_rule__Spielzeug__FarbeAssignment_32261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Farbe__WertAlternatives_0_in_rule__Farbe__WertAssignment2292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__NameAssignment_22325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__MutterAssignment_32362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__VaterAssignment_42401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_52440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_6_12479 = new BitSet(new long[]{0x0000000000000002L});
    }


}