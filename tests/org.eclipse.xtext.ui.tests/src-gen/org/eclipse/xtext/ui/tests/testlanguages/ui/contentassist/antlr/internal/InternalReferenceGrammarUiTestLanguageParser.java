package org.eclipse.xtext.ui.tests.testlanguages.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.testlanguages.services.ReferenceGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferenceGrammarUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u2039N'", "'keyword'", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "','"
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:61:1: entryRuleSpielplatz : ruleSpielplatz EOF ;
    public final void entryRuleSpielplatz() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:62:1: ( ruleSpielplatz EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:63:1: ruleSpielplatz EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:70:1: ruleSpielplatz : ( ( rule__Spielplatz__Group__0 )? ) ;
    public final void ruleSpielplatz() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:74:2: ( ( ( rule__Spielplatz__Group__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:75:1: ( ( rule__Spielplatz__Group__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:75:1: ( ( rule__Spielplatz__Group__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:76:1: ( rule__Spielplatz__Group__0 )?
            {
             before(grammarAccess.getSpielplatzAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:77:1: ( rule__Spielplatz__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:77:2: rule__Spielplatz__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__0_in_ruleSpielplatz94);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:91:1: entryRuleKind : ruleKind EOF ;
    public final void entryRuleKind() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:92:1: ( ruleKind EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:93:1: ruleKind EOF
            {
             before(grammarAccess.getKindRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_entryRuleKind124);
            ruleKind();
            _fsp--;

             after(grammarAccess.getKindRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKind131); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:100:1: ruleKind : ( ( rule__Kind__Group__0 ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:104:2: ( ( ( rule__Kind__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:105:1: ( ( rule__Kind__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:105:1: ( ( rule__Kind__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:106:1: ( rule__Kind__Group__0 )
            {
             before(grammarAccess.getKindAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:107:1: ( rule__Kind__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:107:2: rule__Kind__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__0_in_ruleKind157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:119:1: entryRuleErwachsener : ruleErwachsener EOF ;
    public final void entryRuleErwachsener() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:120:1: ( ruleErwachsener EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:121:1: ruleErwachsener EOF
            {
             before(grammarAccess.getErwachsenerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_entryRuleErwachsener184);
            ruleErwachsener();
            _fsp--;

             after(grammarAccess.getErwachsenerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleErwachsener191); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:128:1: ruleErwachsener : ( ( rule__Erwachsener__Group__0 ) ) ;
    public final void ruleErwachsener() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:2: ( ( ( rule__Erwachsener__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:133:1: ( ( rule__Erwachsener__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:133:1: ( ( rule__Erwachsener__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:134:1: ( rule__Erwachsener__Group__0 )
            {
             before(grammarAccess.getErwachsenerAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:135:1: ( rule__Erwachsener__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:135:2: rule__Erwachsener__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__0_in_ruleErwachsener217);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:147:1: entryRuleSpielzeug : ruleSpielzeug EOF ;
    public final void entryRuleSpielzeug() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:148:1: ( ruleSpielzeug EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:149:1: ruleSpielzeug EOF
            {
             before(grammarAccess.getSpielzeugRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug244);
            ruleSpielzeug();
            _fsp--;

             after(grammarAccess.getSpielzeugRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielzeug251); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:156:1: ruleSpielzeug : ( ( rule__Spielzeug__Group__0 ) ) ;
    public final void ruleSpielzeug() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:160:2: ( ( ( rule__Spielzeug__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:161:1: ( ( rule__Spielzeug__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:161:1: ( ( rule__Spielzeug__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:162:1: ( rule__Spielzeug__Group__0 )
            {
             before(grammarAccess.getSpielzeugAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:163:1: ( rule__Spielzeug__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:163:2: rule__Spielzeug__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__0_in_ruleSpielzeug277);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:175:1: entryRuleFarbe : ruleFarbe EOF ;
    public final void entryRuleFarbe() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:176:1: ( ruleFarbe EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:177:1: ruleFarbe EOF
            {
             before(grammarAccess.getFarbeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_entryRuleFarbe304);
            ruleFarbe();
            _fsp--;

             after(grammarAccess.getFarbeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFarbe311); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:184:1: ruleFarbe : ( ( rule__Farbe__WertAssignment ) ) ;
    public final void ruleFarbe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:188:2: ( ( ( rule__Farbe__WertAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:189:1: ( ( rule__Farbe__WertAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:189:1: ( ( rule__Farbe__WertAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:190:1: ( rule__Farbe__WertAssignment )
            {
             before(grammarAccess.getFarbeAccess().getWertAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:191:1: ( rule__Farbe__WertAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:191:2: rule__Farbe__WertAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Farbe__WertAssignment_in_ruleFarbe337);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:203:1: entryRuleFamilie : ruleFamilie EOF ;
    public final void entryRuleFamilie() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:204:1: ( ruleFamilie EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:205:1: ruleFamilie EOF
            {
             before(grammarAccess.getFamilieRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_entryRuleFamilie364);
            ruleFamilie();
            _fsp--;

             after(grammarAccess.getFamilieRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFamilie371); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:212:1: ruleFamilie : ( ( rule__Familie__Group__0 ) ) ;
    public final void ruleFamilie() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:216:2: ( ( ( rule__Familie__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:217:1: ( ( rule__Familie__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:217:1: ( ( rule__Familie__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:218:1: ( rule__Familie__Group__0 )
            {
             before(grammarAccess.getFamilieAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:219:1: ( rule__Familie__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:219:2: rule__Familie__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__0_in_ruleFamilie397);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:231:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );
    public final void rule__Spielplatz__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:235:1: ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) )
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
                    new NoViableAltException("231:1: rule__Spielplatz__Alternatives_4 : ( ( ( rule__Spielplatz__KinderAssignment_4_0 ) ) | ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) ) | ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) ) | ( ( rule__Spielplatz__FamilieAssignment_4_3 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:236:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:236:1: ( ( rule__Spielplatz__KinderAssignment_4_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:237:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:238:1: ( rule__Spielplatz__KinderAssignment_4_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:238:2: rule__Spielplatz__KinderAssignment_4_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__KinderAssignment_4_0_in_rule__Spielplatz__Alternatives_4433);
                    rule__Spielplatz__KinderAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:242:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:242:6: ( ( rule__Spielplatz__ErzieherAssignment_4_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:243:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:244:1: ( rule__Spielplatz__ErzieherAssignment_4_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:244:2: rule__Spielplatz__ErzieherAssignment_4_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__ErzieherAssignment_4_1_in_rule__Spielplatz__Alternatives_4451);
                    rule__Spielplatz__ErzieherAssignment_4_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:248:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:248:6: ( ( rule__Spielplatz__SpielzeugeAssignment_4_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:249:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:250:1: ( rule__Spielplatz__SpielzeugeAssignment_4_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:250:2: rule__Spielplatz__SpielzeugeAssignment_4_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__SpielzeugeAssignment_4_2_in_rule__Spielplatz__Alternatives_4469);
                    rule__Spielplatz__SpielzeugeAssignment_4_2();
                    _fsp--;


                    }

                     after(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:254:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:254:6: ( ( rule__Spielplatz__FamilieAssignment_4_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:255:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    {
                     before(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:256:1: ( rule__Spielplatz__FamilieAssignment_4_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:256:2: rule__Spielplatz__FamilieAssignment_4_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__FamilieAssignment_4_3_in_rule__Spielplatz__Alternatives_4487);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:266:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u2039N' ) );
    public final void rule__Farbe__WertAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:270:1: ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u2039N' ) )
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
                    new NoViableAltException("266:1: rule__Farbe__WertAlternatives_0 : ( ( 'ROT' ) | ( 'BLAU' ) | ( 'GELB' ) | ( 'GR\\u2039N' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:271:1: ( 'ROT' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:271:1: ( 'ROT' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:272:1: 'ROT'
                    {
                     before(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Farbe__WertAlternatives_0522); 
                     after(grammarAccess.getFarbeAccess().getWertROTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:279:6: ( 'BLAU' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:279:6: ( 'BLAU' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:280:1: 'BLAU'
                    {
                     before(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Farbe__WertAlternatives_0542); 
                     after(grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:287:6: ( 'GELB' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:287:6: ( 'GELB' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:288:1: 'GELB'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Farbe__WertAlternatives_0562); 
                     after(grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:295:6: ( 'GR\\u2039N' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:295:6: ( 'GR\\u2039N' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:296:1: 'GR\\u2039N'
                    {
                     before(grammarAccess.getFarbeAccess().getWertGRNKeyword_0_3()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Farbe__WertAlternatives_0582); 
                     after(grammarAccess.getFarbeAccess().getWertGRNKeyword_0_3()); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:308:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Familie__NameAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:312:1: ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) )
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
                    new NoViableAltException("308:1: rule__Familie__NameAlternatives_2_0 : ( ( 'keyword' ) | ( RULE_STRING ) | ( RULE_ID ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:1: ( 'keyword' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:1: ( 'keyword' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:314:1: 'keyword'
                    {
                     before(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Familie__NameAlternatives_2_0617); 
                     after(grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:321:6: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:321:6: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:322:1: RULE_STRING
                    {
                     before(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0636); 
                     after(grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:327:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:327:6: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:328:1: RULE_ID
                    {
                     before(grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0653); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:340:1: rule__Spielplatz__Group__0 : rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 ;
    public final void rule__Spielplatz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:344:1: ( rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:345:2: rule__Spielplatz__Group__0__Impl rule__Spielplatz__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__0__Impl_in_rule__Spielplatz__Group__0683);
            rule__Spielplatz__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__1_in_rule__Spielplatz__Group__0686);
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


    // $ANTLR start rule__Spielplatz__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:352:1: rule__Spielplatz__Group__0__Impl : ( 'spielplatz' ) ;
    public final void rule__Spielplatz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:356:1: ( ( 'spielplatz' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:357:1: ( 'spielplatz' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:357:1: ( 'spielplatz' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:358:1: 'spielplatz'
            {
             before(grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Spielplatz__Group__0__Impl714); 
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
    // $ANTLR end rule__Spielplatz__Group__0__Impl


    // $ANTLR start rule__Spielplatz__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:371:1: rule__Spielplatz__Group__1 : rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 ;
    public final void rule__Spielplatz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:375:1: ( rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:376:2: rule__Spielplatz__Group__1__Impl rule__Spielplatz__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__1__Impl_in_rule__Spielplatz__Group__1745);
            rule__Spielplatz__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__2_in_rule__Spielplatz__Group__1748);
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


    // $ANTLR start rule__Spielplatz__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:383:1: rule__Spielplatz__Group__1__Impl : ( ( rule__Spielplatz__GroesseAssignment_1 ) ) ;
    public final void rule__Spielplatz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:387:1: ( ( ( rule__Spielplatz__GroesseAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:388:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:388:1: ( ( rule__Spielplatz__GroesseAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:389:1: ( rule__Spielplatz__GroesseAssignment_1 )
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:390:1: ( rule__Spielplatz__GroesseAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:390:2: rule__Spielplatz__GroesseAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__GroesseAssignment_1_in_rule__Spielplatz__Group__1__Impl775);
            rule__Spielplatz__GroesseAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__Spielplatz__Group__1__Impl


    // $ANTLR start rule__Spielplatz__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:400:1: rule__Spielplatz__Group__2 : rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 ;
    public final void rule__Spielplatz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:404:1: ( rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:405:2: rule__Spielplatz__Group__2__Impl rule__Spielplatz__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__2__Impl_in_rule__Spielplatz__Group__2805);
            rule__Spielplatz__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__3_in_rule__Spielplatz__Group__2808);
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


    // $ANTLR start rule__Spielplatz__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:412:1: rule__Spielplatz__Group__2__Impl : ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) ;
    public final void rule__Spielplatz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:416:1: ( ( ( rule__Spielplatz__BeschreibungAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:417:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:417:1: ( ( rule__Spielplatz__BeschreibungAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:418:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:419:1: ( rule__Spielplatz__BeschreibungAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:419:2: rule__Spielplatz__BeschreibungAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__BeschreibungAssignment_2_in_rule__Spielplatz__Group__2__Impl835);
                    rule__Spielplatz__BeschreibungAssignment_2();
                    _fsp--;


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
    // $ANTLR end rule__Spielplatz__Group__2__Impl


    // $ANTLR start rule__Spielplatz__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:429:1: rule__Spielplatz__Group__3 : rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 ;
    public final void rule__Spielplatz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:433:1: ( rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:434:2: rule__Spielplatz__Group__3__Impl rule__Spielplatz__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__3__Impl_in_rule__Spielplatz__Group__3866);
            rule__Spielplatz__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__4_in_rule__Spielplatz__Group__3869);
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


    // $ANTLR start rule__Spielplatz__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:441:1: rule__Spielplatz__Group__3__Impl : ( '{' ) ;
    public final void rule__Spielplatz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:445:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:446:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:446:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:447:1: '{'
            {
             before(grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Spielplatz__Group__3__Impl897); 
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
    // $ANTLR end rule__Spielplatz__Group__3__Impl


    // $ANTLR start rule__Spielplatz__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:460:1: rule__Spielplatz__Group__4 : rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 ;
    public final void rule__Spielplatz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:464:1: ( rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:465:2: rule__Spielplatz__Group__4__Impl rule__Spielplatz__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__4__Impl_in_rule__Spielplatz__Group__4928);
            rule__Spielplatz__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__5_in_rule__Spielplatz__Group__4931);
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


    // $ANTLR start rule__Spielplatz__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:472:1: rule__Spielplatz__Group__4__Impl : ( ( rule__Spielplatz__Alternatives_4 )* ) ;
    public final void rule__Spielplatz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:476:1: ( ( ( rule__Spielplatz__Alternatives_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:477:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:477:1: ( ( rule__Spielplatz__Alternatives_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:478:1: ( rule__Spielplatz__Alternatives_4 )*
            {
             before(grammarAccess.getSpielplatzAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:479:1: ( rule__Spielplatz__Alternatives_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0>=22 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:479:2: rule__Spielplatz__Alternatives_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group__4__Impl958);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Spielplatz__Group__4__Impl


    // $ANTLR start rule__Spielplatz__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:489:1: rule__Spielplatz__Group__5 : rule__Spielplatz__Group__5__Impl ;
    public final void rule__Spielplatz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:493:1: ( rule__Spielplatz__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:494:2: rule__Spielplatz__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielplatz__Group__5__Impl_in_rule__Spielplatz__Group__5989);
            rule__Spielplatz__Group__5__Impl();
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
    // $ANTLR end rule__Spielplatz__Group__5


    // $ANTLR start rule__Spielplatz__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:500:1: rule__Spielplatz__Group__5__Impl : ( '}' ) ;
    public final void rule__Spielplatz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:504:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:505:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:505:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:506:1: '}'
            {
             before(grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Spielplatz__Group__5__Impl1017); 
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
    // $ANTLR end rule__Spielplatz__Group__5__Impl


    // $ANTLR start rule__Kind__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:531:1: rule__Kind__Group__0 : rule__Kind__Group__0__Impl rule__Kind__Group__1 ;
    public final void rule__Kind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:535:1: ( rule__Kind__Group__0__Impl rule__Kind__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:536:2: rule__Kind__Group__0__Impl rule__Kind__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__0__Impl_in_rule__Kind__Group__01060);
            rule__Kind__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__1_in_rule__Kind__Group__01063);
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


    // $ANTLR start rule__Kind__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:543:1: rule__Kind__Group__0__Impl : ( 'kind' ) ;
    public final void rule__Kind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:547:1: ( ( 'kind' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:548:1: ( 'kind' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:548:1: ( 'kind' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:549:1: 'kind'
            {
             before(grammarAccess.getKindAccess().getKindKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Kind__Group__0__Impl1091); 
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
    // $ANTLR end rule__Kind__Group__0__Impl


    // $ANTLR start rule__Kind__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:562:1: rule__Kind__Group__1 : rule__Kind__Group__1__Impl rule__Kind__Group__2 ;
    public final void rule__Kind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:566:1: ( rule__Kind__Group__1__Impl rule__Kind__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:567:2: rule__Kind__Group__1__Impl rule__Kind__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__1__Impl_in_rule__Kind__Group__11122);
            rule__Kind__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__2_in_rule__Kind__Group__11125);
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


    // $ANTLR start rule__Kind__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:574:1: rule__Kind__Group__1__Impl : ( '(' ) ;
    public final void rule__Kind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:578:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:579:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:579:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:580:1: '('
            {
             before(grammarAccess.getKindAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Kind__Group__1__Impl1153); 
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
    // $ANTLR end rule__Kind__Group__1__Impl


    // $ANTLR start rule__Kind__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:593:1: rule__Kind__Group__2 : rule__Kind__Group__2__Impl rule__Kind__Group__3 ;
    public final void rule__Kind__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:597:1: ( rule__Kind__Group__2__Impl rule__Kind__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:598:2: rule__Kind__Group__2__Impl rule__Kind__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__2__Impl_in_rule__Kind__Group__21184);
            rule__Kind__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__3_in_rule__Kind__Group__21187);
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


    // $ANTLR start rule__Kind__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:605:1: rule__Kind__Group__2__Impl : ( ( rule__Kind__NameAssignment_2 ) ) ;
    public final void rule__Kind__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:609:1: ( ( ( rule__Kind__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:610:1: ( ( rule__Kind__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:610:1: ( ( rule__Kind__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:611:1: ( rule__Kind__NameAssignment_2 )
            {
             before(grammarAccess.getKindAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:612:1: ( rule__Kind__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:612:2: rule__Kind__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__NameAssignment_2_in_rule__Kind__Group__2__Impl1214);
            rule__Kind__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Kind__Group__2__Impl


    // $ANTLR start rule__Kind__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:622:1: rule__Kind__Group__3 : rule__Kind__Group__3__Impl rule__Kind__Group__4 ;
    public final void rule__Kind__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:626:1: ( rule__Kind__Group__3__Impl rule__Kind__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:627:2: rule__Kind__Group__3__Impl rule__Kind__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__3__Impl_in_rule__Kind__Group__31244);
            rule__Kind__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__4_in_rule__Kind__Group__31247);
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


    // $ANTLR start rule__Kind__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:634:1: rule__Kind__Group__3__Impl : ( ( rule__Kind__AgeAssignment_3 ) ) ;
    public final void rule__Kind__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:638:1: ( ( ( rule__Kind__AgeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:639:1: ( ( rule__Kind__AgeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:639:1: ( ( rule__Kind__AgeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:640:1: ( rule__Kind__AgeAssignment_3 )
            {
             before(grammarAccess.getKindAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:641:1: ( rule__Kind__AgeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:641:2: rule__Kind__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__AgeAssignment_3_in_rule__Kind__Group__3__Impl1274);
            rule__Kind__AgeAssignment_3();
            _fsp--;


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
    // $ANTLR end rule__Kind__Group__3__Impl


    // $ANTLR start rule__Kind__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:651:1: rule__Kind__Group__4 : rule__Kind__Group__4__Impl ;
    public final void rule__Kind__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:655:1: ( rule__Kind__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:656:2: rule__Kind__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Kind__Group__4__Impl_in_rule__Kind__Group__41304);
            rule__Kind__Group__4__Impl();
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
    // $ANTLR end rule__Kind__Group__4


    // $ANTLR start rule__Kind__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:662:1: rule__Kind__Group__4__Impl : ( ')' ) ;
    public final void rule__Kind__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:666:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:667:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:667:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:668:1: ')'
            {
             before(grammarAccess.getKindAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Kind__Group__4__Impl1332); 
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
    // $ANTLR end rule__Kind__Group__4__Impl


    // $ANTLR start rule__Erwachsener__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:691:1: rule__Erwachsener__Group__0 : rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 ;
    public final void rule__Erwachsener__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:695:1: ( rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:696:2: rule__Erwachsener__Group__0__Impl rule__Erwachsener__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__0__Impl_in_rule__Erwachsener__Group__01373);
            rule__Erwachsener__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__1_in_rule__Erwachsener__Group__01376);
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


    // $ANTLR start rule__Erwachsener__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:703:1: rule__Erwachsener__Group__0__Impl : ( 'erwachsener' ) ;
    public final void rule__Erwachsener__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:707:1: ( ( 'erwachsener' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:708:1: ( 'erwachsener' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:708:1: ( 'erwachsener' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:709:1: 'erwachsener'
            {
             before(grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Erwachsener__Group__0__Impl1404); 
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
    // $ANTLR end rule__Erwachsener__Group__0__Impl


    // $ANTLR start rule__Erwachsener__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:722:1: rule__Erwachsener__Group__1 : rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 ;
    public final void rule__Erwachsener__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:726:1: ( rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:727:2: rule__Erwachsener__Group__1__Impl rule__Erwachsener__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__1__Impl_in_rule__Erwachsener__Group__11435);
            rule__Erwachsener__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__2_in_rule__Erwachsener__Group__11438);
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


    // $ANTLR start rule__Erwachsener__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:734:1: rule__Erwachsener__Group__1__Impl : ( '(' ) ;
    public final void rule__Erwachsener__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:738:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:739:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:739:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:740:1: '('
            {
             before(grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Erwachsener__Group__1__Impl1466); 
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
    // $ANTLR end rule__Erwachsener__Group__1__Impl


    // $ANTLR start rule__Erwachsener__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:753:1: rule__Erwachsener__Group__2 : rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 ;
    public final void rule__Erwachsener__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:757:1: ( rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:758:2: rule__Erwachsener__Group__2__Impl rule__Erwachsener__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__2__Impl_in_rule__Erwachsener__Group__21497);
            rule__Erwachsener__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__3_in_rule__Erwachsener__Group__21500);
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


    // $ANTLR start rule__Erwachsener__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:765:1: rule__Erwachsener__Group__2__Impl : ( ( rule__Erwachsener__NameAssignment_2 ) ) ;
    public final void rule__Erwachsener__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:769:1: ( ( ( rule__Erwachsener__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:770:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:770:1: ( ( rule__Erwachsener__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:771:1: ( rule__Erwachsener__NameAssignment_2 )
            {
             before(grammarAccess.getErwachsenerAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:772:1: ( rule__Erwachsener__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:772:2: rule__Erwachsener__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__NameAssignment_2_in_rule__Erwachsener__Group__2__Impl1527);
            rule__Erwachsener__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Erwachsener__Group__2__Impl


    // $ANTLR start rule__Erwachsener__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:782:1: rule__Erwachsener__Group__3 : rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 ;
    public final void rule__Erwachsener__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:786:1: ( rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:787:2: rule__Erwachsener__Group__3__Impl rule__Erwachsener__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__3__Impl_in_rule__Erwachsener__Group__31557);
            rule__Erwachsener__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__4_in_rule__Erwachsener__Group__31560);
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


    // $ANTLR start rule__Erwachsener__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:794:1: rule__Erwachsener__Group__3__Impl : ( ( rule__Erwachsener__AgeAssignment_3 ) ) ;
    public final void rule__Erwachsener__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:798:1: ( ( ( rule__Erwachsener__AgeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:799:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:799:1: ( ( rule__Erwachsener__AgeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:800:1: ( rule__Erwachsener__AgeAssignment_3 )
            {
             before(grammarAccess.getErwachsenerAccess().getAgeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:801:1: ( rule__Erwachsener__AgeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:801:2: rule__Erwachsener__AgeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__AgeAssignment_3_in_rule__Erwachsener__Group__3__Impl1587);
            rule__Erwachsener__AgeAssignment_3();
            _fsp--;


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
    // $ANTLR end rule__Erwachsener__Group__3__Impl


    // $ANTLR start rule__Erwachsener__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:811:1: rule__Erwachsener__Group__4 : rule__Erwachsener__Group__4__Impl ;
    public final void rule__Erwachsener__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:815:1: ( rule__Erwachsener__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:816:2: rule__Erwachsener__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Erwachsener__Group__4__Impl_in_rule__Erwachsener__Group__41617);
            rule__Erwachsener__Group__4__Impl();
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
    // $ANTLR end rule__Erwachsener__Group__4


    // $ANTLR start rule__Erwachsener__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:822:1: rule__Erwachsener__Group__4__Impl : ( ')' ) ;
    public final void rule__Erwachsener__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:826:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:827:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:827:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:828:1: ')'
            {
             before(grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Erwachsener__Group__4__Impl1645); 
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
    // $ANTLR end rule__Erwachsener__Group__4__Impl


    // $ANTLR start rule__Spielzeug__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:851:1: rule__Spielzeug__Group__0 : rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 ;
    public final void rule__Spielzeug__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:855:1: ( rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:856:2: rule__Spielzeug__Group__0__Impl rule__Spielzeug__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__0__Impl_in_rule__Spielzeug__Group__01686);
            rule__Spielzeug__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__1_in_rule__Spielzeug__Group__01689);
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


    // $ANTLR start rule__Spielzeug__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:863:1: rule__Spielzeug__Group__0__Impl : ( 'spielzeug' ) ;
    public final void rule__Spielzeug__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:867:1: ( ( 'spielzeug' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:868:1: ( 'spielzeug' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:868:1: ( 'spielzeug' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:869:1: 'spielzeug'
            {
             before(grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Spielzeug__Group__0__Impl1717); 
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
    // $ANTLR end rule__Spielzeug__Group__0__Impl


    // $ANTLR start rule__Spielzeug__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:882:1: rule__Spielzeug__Group__1 : rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 ;
    public final void rule__Spielzeug__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:886:1: ( rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:887:2: rule__Spielzeug__Group__1__Impl rule__Spielzeug__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__1__Impl_in_rule__Spielzeug__Group__11748);
            rule__Spielzeug__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__2_in_rule__Spielzeug__Group__11751);
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


    // $ANTLR start rule__Spielzeug__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:894:1: rule__Spielzeug__Group__1__Impl : ( '(' ) ;
    public final void rule__Spielzeug__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:898:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:899:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:899:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:900:1: '('
            {
             before(grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Spielzeug__Group__1__Impl1779); 
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
    // $ANTLR end rule__Spielzeug__Group__1__Impl


    // $ANTLR start rule__Spielzeug__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:913:1: rule__Spielzeug__Group__2 : rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 ;
    public final void rule__Spielzeug__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:917:1: ( rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:918:2: rule__Spielzeug__Group__2__Impl rule__Spielzeug__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__2__Impl_in_rule__Spielzeug__Group__21810);
            rule__Spielzeug__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__3_in_rule__Spielzeug__Group__21813);
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


    // $ANTLR start rule__Spielzeug__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:925:1: rule__Spielzeug__Group__2__Impl : ( ( rule__Spielzeug__NameAssignment_2 ) ) ;
    public final void rule__Spielzeug__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:929:1: ( ( ( rule__Spielzeug__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:930:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:930:1: ( ( rule__Spielzeug__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:931:1: ( rule__Spielzeug__NameAssignment_2 )
            {
             before(grammarAccess.getSpielzeugAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:932:1: ( rule__Spielzeug__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:932:2: rule__Spielzeug__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__NameAssignment_2_in_rule__Spielzeug__Group__2__Impl1840);
            rule__Spielzeug__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Spielzeug__Group__2__Impl


    // $ANTLR start rule__Spielzeug__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:942:1: rule__Spielzeug__Group__3 : rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 ;
    public final void rule__Spielzeug__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:946:1: ( rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:947:2: rule__Spielzeug__Group__3__Impl rule__Spielzeug__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__3__Impl_in_rule__Spielzeug__Group__31870);
            rule__Spielzeug__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__4_in_rule__Spielzeug__Group__31873);
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


    // $ANTLR start rule__Spielzeug__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:954:1: rule__Spielzeug__Group__3__Impl : ( ( rule__Spielzeug__FarbeAssignment_3 ) ) ;
    public final void rule__Spielzeug__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:958:1: ( ( ( rule__Spielzeug__FarbeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:959:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:959:1: ( ( rule__Spielzeug__FarbeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:960:1: ( rule__Spielzeug__FarbeAssignment_3 )
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:961:1: ( rule__Spielzeug__FarbeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:961:2: rule__Spielzeug__FarbeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__FarbeAssignment_3_in_rule__Spielzeug__Group__3__Impl1900);
            rule__Spielzeug__FarbeAssignment_3();
            _fsp--;


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
    // $ANTLR end rule__Spielzeug__Group__3__Impl


    // $ANTLR start rule__Spielzeug__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:971:1: rule__Spielzeug__Group__4 : rule__Spielzeug__Group__4__Impl ;
    public final void rule__Spielzeug__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:975:1: ( rule__Spielzeug__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:976:2: rule__Spielzeug__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Spielzeug__Group__4__Impl_in_rule__Spielzeug__Group__41930);
            rule__Spielzeug__Group__4__Impl();
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
    // $ANTLR end rule__Spielzeug__Group__4


    // $ANTLR start rule__Spielzeug__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:982:1: rule__Spielzeug__Group__4__Impl : ( ')' ) ;
    public final void rule__Spielzeug__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:986:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:987:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:987:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:988:1: ')'
            {
             before(grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Spielzeug__Group__4__Impl1958); 
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
    // $ANTLR end rule__Spielzeug__Group__4__Impl


    // $ANTLR start rule__Familie__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1011:1: rule__Familie__Group__0 : rule__Familie__Group__0__Impl rule__Familie__Group__1 ;
    public final void rule__Familie__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1015:1: ( rule__Familie__Group__0__Impl rule__Familie__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1016:2: rule__Familie__Group__0__Impl rule__Familie__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__0__Impl_in_rule__Familie__Group__01999);
            rule__Familie__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__1_in_rule__Familie__Group__02002);
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


    // $ANTLR start rule__Familie__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1023:1: rule__Familie__Group__0__Impl : ( 'familie' ) ;
    public final void rule__Familie__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1027:1: ( ( 'familie' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1028:1: ( 'familie' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1028:1: ( 'familie' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1029:1: 'familie'
            {
             before(grammarAccess.getFamilieAccess().getFamilieKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Familie__Group__0__Impl2030); 
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
    // $ANTLR end rule__Familie__Group__0__Impl


    // $ANTLR start rule__Familie__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1042:1: rule__Familie__Group__1 : rule__Familie__Group__1__Impl rule__Familie__Group__2 ;
    public final void rule__Familie__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1046:1: ( rule__Familie__Group__1__Impl rule__Familie__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1047:2: rule__Familie__Group__1__Impl rule__Familie__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__1__Impl_in_rule__Familie__Group__12061);
            rule__Familie__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__2_in_rule__Familie__Group__12064);
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


    // $ANTLR start rule__Familie__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1054:1: rule__Familie__Group__1__Impl : ( '(' ) ;
    public final void rule__Familie__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1058:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1059:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1059:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1060:1: '('
            {
             before(grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Familie__Group__1__Impl2092); 
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
    // $ANTLR end rule__Familie__Group__1__Impl


    // $ANTLR start rule__Familie__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1073:1: rule__Familie__Group__2 : rule__Familie__Group__2__Impl rule__Familie__Group__3 ;
    public final void rule__Familie__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1077:1: ( rule__Familie__Group__2__Impl rule__Familie__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1078:2: rule__Familie__Group__2__Impl rule__Familie__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__2__Impl_in_rule__Familie__Group__22123);
            rule__Familie__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__3_in_rule__Familie__Group__22126);
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


    // $ANTLR start rule__Familie__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1085:1: rule__Familie__Group__2__Impl : ( ( rule__Familie__NameAssignment_2 ) ) ;
    public final void rule__Familie__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1089:1: ( ( ( rule__Familie__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1090:1: ( ( rule__Familie__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1090:1: ( ( rule__Familie__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1091:1: ( rule__Familie__NameAssignment_2 )
            {
             before(grammarAccess.getFamilieAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1092:1: ( rule__Familie__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1092:2: rule__Familie__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__NameAssignment_2_in_rule__Familie__Group__2__Impl2153);
            rule__Familie__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__Familie__Group__2__Impl


    // $ANTLR start rule__Familie__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1102:1: rule__Familie__Group__3 : rule__Familie__Group__3__Impl rule__Familie__Group__4 ;
    public final void rule__Familie__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1106:1: ( rule__Familie__Group__3__Impl rule__Familie__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1107:2: rule__Familie__Group__3__Impl rule__Familie__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__3__Impl_in_rule__Familie__Group__32183);
            rule__Familie__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__4_in_rule__Familie__Group__32186);
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


    // $ANTLR start rule__Familie__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1114:1: rule__Familie__Group__3__Impl : ( ( rule__Familie__MutterAssignment_3 ) ) ;
    public final void rule__Familie__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1118:1: ( ( ( rule__Familie__MutterAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1119:1: ( ( rule__Familie__MutterAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1119:1: ( ( rule__Familie__MutterAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1120:1: ( rule__Familie__MutterAssignment_3 )
            {
             before(grammarAccess.getFamilieAccess().getMutterAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1121:1: ( rule__Familie__MutterAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1121:2: rule__Familie__MutterAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__MutterAssignment_3_in_rule__Familie__Group__3__Impl2213);
            rule__Familie__MutterAssignment_3();
            _fsp--;


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
    // $ANTLR end rule__Familie__Group__3__Impl


    // $ANTLR start rule__Familie__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1131:1: rule__Familie__Group__4 : rule__Familie__Group__4__Impl rule__Familie__Group__5 ;
    public final void rule__Familie__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1135:1: ( rule__Familie__Group__4__Impl rule__Familie__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1136:2: rule__Familie__Group__4__Impl rule__Familie__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__4__Impl_in_rule__Familie__Group__42243);
            rule__Familie__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__5_in_rule__Familie__Group__42246);
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


    // $ANTLR start rule__Familie__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1143:1: rule__Familie__Group__4__Impl : ( ( rule__Familie__VaterAssignment_4 ) ) ;
    public final void rule__Familie__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1147:1: ( ( ( rule__Familie__VaterAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1148:1: ( ( rule__Familie__VaterAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1148:1: ( ( rule__Familie__VaterAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1149:1: ( rule__Familie__VaterAssignment_4 )
            {
             before(grammarAccess.getFamilieAccess().getVaterAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1150:1: ( rule__Familie__VaterAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1150:2: rule__Familie__VaterAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__VaterAssignment_4_in_rule__Familie__Group__4__Impl2273);
            rule__Familie__VaterAssignment_4();
            _fsp--;


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
    // $ANTLR end rule__Familie__Group__4__Impl


    // $ANTLR start rule__Familie__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1160:1: rule__Familie__Group__5 : rule__Familie__Group__5__Impl rule__Familie__Group__6 ;
    public final void rule__Familie__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1164:1: ( rule__Familie__Group__5__Impl rule__Familie__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1165:2: rule__Familie__Group__5__Impl rule__Familie__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__5__Impl_in_rule__Familie__Group__52303);
            rule__Familie__Group__5__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__6_in_rule__Familie__Group__52306);
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


    // $ANTLR start rule__Familie__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1172:1: rule__Familie__Group__5__Impl : ( ( rule__Familie__KinderAssignment_5 ) ) ;
    public final void rule__Familie__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1176:1: ( ( ( rule__Familie__KinderAssignment_5 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1177:1: ( ( rule__Familie__KinderAssignment_5 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1177:1: ( ( rule__Familie__KinderAssignment_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1178:1: ( rule__Familie__KinderAssignment_5 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1179:1: ( rule__Familie__KinderAssignment_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1179:2: rule__Familie__KinderAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__KinderAssignment_5_in_rule__Familie__Group__5__Impl2333);
            rule__Familie__KinderAssignment_5();
            _fsp--;


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
    // $ANTLR end rule__Familie__Group__5__Impl


    // $ANTLR start rule__Familie__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1189:1: rule__Familie__Group__6 : rule__Familie__Group__6__Impl rule__Familie__Group__7 ;
    public final void rule__Familie__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1193:1: ( rule__Familie__Group__6__Impl rule__Familie__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1194:2: rule__Familie__Group__6__Impl rule__Familie__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__6__Impl_in_rule__Familie__Group__62363);
            rule__Familie__Group__6__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__7_in_rule__Familie__Group__62366);
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


    // $ANTLR start rule__Familie__Group__6__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1201:1: rule__Familie__Group__6__Impl : ( ( rule__Familie__Group_6__0 )* ) ;
    public final void rule__Familie__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1205:1: ( ( ( rule__Familie__Group_6__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1206:1: ( ( rule__Familie__Group_6__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1206:1: ( ( rule__Familie__Group_6__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1207:1: ( rule__Familie__Group_6__0 )*
            {
             before(grammarAccess.getFamilieAccess().getGroup_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1208:1: ( rule__Familie__Group_6__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1208:2: rule__Familie__Group_6__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__0_in_rule__Familie__Group__6__Impl2393);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Familie__Group__6__Impl


    // $ANTLR start rule__Familie__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1218:1: rule__Familie__Group__7 : rule__Familie__Group__7__Impl ;
    public final void rule__Familie__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1222:1: ( rule__Familie__Group__7__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1223:2: rule__Familie__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group__7__Impl_in_rule__Familie__Group__72424);
            rule__Familie__Group__7__Impl();
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
    // $ANTLR end rule__Familie__Group__7


    // $ANTLR start rule__Familie__Group__7__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1229:1: rule__Familie__Group__7__Impl : ( ')' ) ;
    public final void rule__Familie__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1233:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1234:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1234:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1235:1: ')'
            {
             before(grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Familie__Group__7__Impl2452); 
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
    // $ANTLR end rule__Familie__Group__7__Impl


    // $ANTLR start rule__Familie__Group_6__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1264:1: rule__Familie__Group_6__0 : rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 ;
    public final void rule__Familie__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1268:1: ( rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1269:2: rule__Familie__Group_6__0__Impl rule__Familie__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__0__Impl_in_rule__Familie__Group_6__02499);
            rule__Familie__Group_6__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__1_in_rule__Familie__Group_6__02502);
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


    // $ANTLR start rule__Familie__Group_6__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1276:1: rule__Familie__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Familie__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1280:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1281:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1282:1: ','
            {
             before(grammarAccess.getFamilieAccess().getCommaKeyword_6_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Familie__Group_6__0__Impl2530); 
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
    // $ANTLR end rule__Familie__Group_6__0__Impl


    // $ANTLR start rule__Familie__Group_6__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1295:1: rule__Familie__Group_6__1 : rule__Familie__Group_6__1__Impl ;
    public final void rule__Familie__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1299:1: ( rule__Familie__Group_6__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1300:2: rule__Familie__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__Group_6__1__Impl_in_rule__Familie__Group_6__12561);
            rule__Familie__Group_6__1__Impl();
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
    // $ANTLR end rule__Familie__Group_6__1


    // $ANTLR start rule__Familie__Group_6__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1306:1: rule__Familie__Group_6__1__Impl : ( ( rule__Familie__KinderAssignment_6_1 ) ) ;
    public final void rule__Familie__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1310:1: ( ( ( rule__Familie__KinderAssignment_6_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1311:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1311:1: ( ( rule__Familie__KinderAssignment_6_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1312:1: ( rule__Familie__KinderAssignment_6_1 )
            {
             before(grammarAccess.getFamilieAccess().getKinderAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1313:1: ( rule__Familie__KinderAssignment_6_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1313:2: rule__Familie__KinderAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__KinderAssignment_6_1_in_rule__Familie__Group_6__1__Impl2588);
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
    // $ANTLR end rule__Familie__Group_6__1__Impl


    // $ANTLR start rule__Spielplatz__GroesseAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1328:1: rule__Spielplatz__GroesseAssignment_1 : ( RULE_INT ) ;
    public final void rule__Spielplatz__GroesseAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1332:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1333:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1333:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1334:1: RULE_INT
            {
             before(grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Spielplatz__GroesseAssignment_12627); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1343:1: rule__Spielplatz__BeschreibungAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Spielplatz__BeschreibungAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1347:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1348:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1348:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1349:1: RULE_STRING
            {
             before(grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Spielplatz__BeschreibungAssignment_22658); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1358:1: rule__Spielplatz__KinderAssignment_4_0 : ( ruleKind ) ;
    public final void rule__Spielplatz__KinderAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1362:1: ( ( ruleKind ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1363:1: ( ruleKind )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1363:1: ( ruleKind )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1364:1: ruleKind
            {
             before(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_rule__Spielplatz__KinderAssignment_4_02689);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1373:1: rule__Spielplatz__ErzieherAssignment_4_1 : ( ruleErwachsener ) ;
    public final void rule__Spielplatz__ErzieherAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1377:1: ( ( ruleErwachsener ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1378:1: ( ruleErwachsener )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1378:1: ( ruleErwachsener )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1379:1: ruleErwachsener
            {
             before(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_rule__Spielplatz__ErzieherAssignment_4_12720);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1388:1: rule__Spielplatz__SpielzeugeAssignment_4_2 : ( ruleSpielzeug ) ;
    public final void rule__Spielplatz__SpielzeugeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1392:1: ( ( ruleSpielzeug ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1393:1: ( ruleSpielzeug )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1393:1: ( ruleSpielzeug )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1394:1: ruleSpielzeug
            {
             before(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_rule__Spielplatz__SpielzeugeAssignment_4_22751);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1403:1: rule__Spielplatz__FamilieAssignment_4_3 : ( ruleFamilie ) ;
    public final void rule__Spielplatz__FamilieAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1407:1: ( ( ruleFamilie ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1408:1: ( ruleFamilie )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1408:1: ( ruleFamilie )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1409:1: ruleFamilie
            {
             before(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_rule__Spielplatz__FamilieAssignment_4_32782);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1418:1: rule__Kind__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Kind__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1422:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1423:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1423:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1424:1: RULE_ID
            {
             before(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Kind__NameAssignment_22813); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1433:1: rule__Kind__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Kind__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1437:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1438:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1438:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1439:1: RULE_INT
            {
             before(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Kind__AgeAssignment_32844); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1448:1: rule__Erwachsener__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Erwachsener__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1452:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1453:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1453:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1454:1: RULE_ID
            {
             before(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Erwachsener__NameAssignment_22875); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1463:1: rule__Erwachsener__AgeAssignment_3 : ( RULE_INT ) ;
    public final void rule__Erwachsener__AgeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1467:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1468:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1468:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1469:1: RULE_INT
            {
             before(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Erwachsener__AgeAssignment_32906); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1478:1: rule__Spielzeug__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Spielzeug__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1482:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1483:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1483:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1484:1: RULE_ID
            {
             before(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Spielzeug__NameAssignment_22937); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1493:1: rule__Spielzeug__FarbeAssignment_3 : ( ruleFarbe ) ;
    public final void rule__Spielzeug__FarbeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1497:1: ( ( ruleFarbe ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1498:1: ( ruleFarbe )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1498:1: ( ruleFarbe )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1499:1: ruleFarbe
            {
             before(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_rule__Spielzeug__FarbeAssignment_32968);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1508:1: rule__Farbe__WertAssignment : ( ( rule__Farbe__WertAlternatives_0 ) ) ;
    public final void rule__Farbe__WertAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1512:1: ( ( ( rule__Farbe__WertAlternatives_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1513:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1513:1: ( ( rule__Farbe__WertAlternatives_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1514:1: ( rule__Farbe__WertAlternatives_0 )
            {
             before(grammarAccess.getFarbeAccess().getWertAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1515:1: ( rule__Farbe__WertAlternatives_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1515:2: rule__Farbe__WertAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Farbe__WertAlternatives_0_in_rule__Farbe__WertAssignment2999);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1524:1: rule__Familie__NameAssignment_2 : ( ( rule__Familie__NameAlternatives_2_0 ) ) ;
    public final void rule__Familie__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1528:1: ( ( ( rule__Familie__NameAlternatives_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1529:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1529:1: ( ( rule__Familie__NameAlternatives_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1530:1: ( rule__Familie__NameAlternatives_2_0 )
            {
             before(grammarAccess.getFamilieAccess().getNameAlternatives_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1531:1: ( rule__Familie__NameAlternatives_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1531:2: rule__Familie__NameAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__NameAssignment_23032);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1540:1: rule__Familie__MutterAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__MutterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1544:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1545:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1545:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1546:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1547:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1548:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__MutterAssignment_33069); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1559:1: rule__Familie__VaterAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__VaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1563:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1564:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1564:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1565:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1566:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1567:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__VaterAssignment_43108); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1578:1: rule__Familie__KinderAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1582:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1583:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1583:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1584:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1585:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1586:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_53147); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1597:1: rule__Familie__KinderAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Familie__KinderAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1601:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1602:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1602:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1603:1: ( RULE_ID )
            {
             before(grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1604:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/ui/contentassist/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:1605:1: RULE_ID
            {
             before(grammarAccess.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_6_13186); 
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
        public static final BitSet FOLLOW_rule__Spielplatz__Group__0_in_ruleSpielplatz94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_entryRuleKind124 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKind131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__0_in_ruleKind157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__0_in_ruleErwachsener217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__0_in_ruleSpielzeug277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFarbe311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Farbe__WertAssignment_in_ruleFarbe337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie364 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFamilie371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__0_in_ruleFamilie397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__KinderAssignment_4_0_in_rule__Spielplatz__Alternatives_4433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__ErzieherAssignment_4_1_in_rule__Spielplatz__Alternatives_4451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__SpielzeugeAssignment_4_2_in_rule__Spielplatz__Alternatives_4469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__FamilieAssignment_4_3_in_rule__Spielplatz__Alternatives_4487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Farbe__WertAlternatives_0522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Farbe__WertAlternatives_0542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Farbe__WertAlternatives_0562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Farbe__WertAlternatives_0582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Familie__NameAlternatives_2_0617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Familie__NameAlternatives_2_0636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__NameAlternatives_2_0653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__0__Impl_in_rule__Spielplatz__Group__0683 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__1_in_rule__Spielplatz__Group__0686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Spielplatz__Group__0__Impl714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__1__Impl_in_rule__Spielplatz__Group__1745 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__2_in_rule__Spielplatz__Group__1748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__GroesseAssignment_1_in_rule__Spielplatz__Group__1__Impl775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__2__Impl_in_rule__Spielplatz__Group__2805 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__3_in_rule__Spielplatz__Group__2808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__BeschreibungAssignment_2_in_rule__Spielplatz__Group__2__Impl835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__3__Impl_in_rule__Spielplatz__Group__3866 = new BitSet(new long[]{0x0000000001CC0000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__4_in_rule__Spielplatz__Group__3869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Spielplatz__Group__3__Impl897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__4__Impl_in_rule__Spielplatz__Group__4928 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__5_in_rule__Spielplatz__Group__4931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Alternatives_4_in_rule__Spielplatz__Group__4__Impl958 = new BitSet(new long[]{0x0000000001C80002L});
        public static final BitSet FOLLOW_rule__Spielplatz__Group__5__Impl_in_rule__Spielplatz__Group__5989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Spielplatz__Group__5__Impl1017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__0__Impl_in_rule__Kind__Group__01060 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Kind__Group__1_in_rule__Kind__Group__01063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Kind__Group__0__Impl1091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__1__Impl_in_rule__Kind__Group__11122 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Kind__Group__2_in_rule__Kind__Group__11125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Kind__Group__1__Impl1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__2__Impl_in_rule__Kind__Group__21184 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Kind__Group__3_in_rule__Kind__Group__21187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__NameAssignment_2_in_rule__Kind__Group__2__Impl1214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__3__Impl_in_rule__Kind__Group__31244 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Kind__Group__4_in_rule__Kind__Group__31247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__AgeAssignment_3_in_rule__Kind__Group__3__Impl1274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Kind__Group__4__Impl_in_rule__Kind__Group__41304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Kind__Group__4__Impl1332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__0__Impl_in_rule__Erwachsener__Group__01373 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__1_in_rule__Erwachsener__Group__01376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Erwachsener__Group__0__Impl1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__1__Impl_in_rule__Erwachsener__Group__11435 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__2_in_rule__Erwachsener__Group__11438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Erwachsener__Group__1__Impl1466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__2__Impl_in_rule__Erwachsener__Group__21497 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__3_in_rule__Erwachsener__Group__21500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__NameAssignment_2_in_rule__Erwachsener__Group__2__Impl1527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__3__Impl_in_rule__Erwachsener__Group__31557 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__4_in_rule__Erwachsener__Group__31560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__AgeAssignment_3_in_rule__Erwachsener__Group__3__Impl1587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Erwachsener__Group__4__Impl_in_rule__Erwachsener__Group__41617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Erwachsener__Group__4__Impl1645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__0__Impl_in_rule__Spielzeug__Group__01686 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__1_in_rule__Spielzeug__Group__01689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Spielzeug__Group__0__Impl1717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__1__Impl_in_rule__Spielzeug__Group__11748 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__2_in_rule__Spielzeug__Group__11751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Spielzeug__Group__1__Impl1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__2__Impl_in_rule__Spielzeug__Group__21810 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__3_in_rule__Spielzeug__Group__21813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__NameAssignment_2_in_rule__Spielzeug__Group__2__Impl1840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__3__Impl_in_rule__Spielzeug__Group__31870 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__4_in_rule__Spielzeug__Group__31873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__FarbeAssignment_3_in_rule__Spielzeug__Group__3__Impl1900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Spielzeug__Group__4__Impl_in_rule__Spielzeug__Group__41930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Spielzeug__Group__4__Impl1958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__0__Impl_in_rule__Familie__Group__01999 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Familie__Group__1_in_rule__Familie__Group__02002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Familie__Group__0__Impl2030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__1__Impl_in_rule__Familie__Group__12061 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_rule__Familie__Group__2_in_rule__Familie__Group__12064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Familie__Group__1__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__2__Impl_in_rule__Familie__Group__22123 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__3_in_rule__Familie__Group__22126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__NameAssignment_2_in_rule__Familie__Group__2__Impl2153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__3__Impl_in_rule__Familie__Group__32183 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__4_in_rule__Familie__Group__32186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__MutterAssignment_3_in_rule__Familie__Group__3__Impl2213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__4__Impl_in_rule__Familie__Group__42243 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group__5_in_rule__Familie__Group__42246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__VaterAssignment_4_in_rule__Familie__Group__4__Impl2273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__5__Impl_in_rule__Familie__Group__52303 = new BitSet(new long[]{0x0000000002200000L});
        public static final BitSet FOLLOW_rule__Familie__Group__6_in_rule__Familie__Group__52306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__KinderAssignment_5_in_rule__Familie__Group__5__Impl2333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__6__Impl_in_rule__Familie__Group__62363 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Familie__Group__7_in_rule__Familie__Group__62366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__0_in_rule__Familie__Group__6__Impl2393 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__Familie__Group__7__Impl_in_rule__Familie__Group__72424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Familie__Group__7__Impl2452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__0__Impl_in_rule__Familie__Group_6__02499 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__1_in_rule__Familie__Group_6__02502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Familie__Group_6__0__Impl2530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__Group_6__1__Impl_in_rule__Familie__Group_6__12561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__KinderAssignment_6_1_in_rule__Familie__Group_6__1__Impl2588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Spielplatz__GroesseAssignment_12627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Spielplatz__BeschreibungAssignment_22658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_rule__Spielplatz__KinderAssignment_4_02689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_rule__Spielplatz__ErzieherAssignment_4_12720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_rule__Spielplatz__SpielzeugeAssignment_4_22751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_rule__Spielplatz__FamilieAssignment_4_32782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Kind__NameAssignment_22813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Kind__AgeAssignment_32844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Erwachsener__NameAssignment_22875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Erwachsener__AgeAssignment_32906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Spielzeug__NameAssignment_22937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_rule__Spielzeug__FarbeAssignment_32968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Farbe__WertAlternatives_0_in_rule__Farbe__WertAssignment2999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Familie__NameAlternatives_2_0_in_rule__Familie__NameAssignment_23032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__MutterAssignment_33069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__VaterAssignment_43108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_53147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Familie__KinderAssignment_6_13186 = new BitSet(new long[]{0x0000000000000002L});
    }


}