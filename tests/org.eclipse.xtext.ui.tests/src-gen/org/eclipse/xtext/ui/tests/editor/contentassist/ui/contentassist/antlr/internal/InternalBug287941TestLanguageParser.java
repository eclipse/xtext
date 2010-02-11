package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug287941TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug287941TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'notlike'", "'import'", "'select'", "'from'", "','", "'where'", "'.'", "'as'", "'in'", "'resources'", "'{'", "'}'", "'elements'", "'or'", "'and'", "'('", "')'", "'null'", "'withoutsubtypes'", "'not'", "'true'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int EOF=-1;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_SINGED_LONG=7;

        public InternalBug287941TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g"; }


     
     	private Bug287941TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug287941TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:76:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport128); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:104:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleMQLquery
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:116:1: entryRuleMQLquery : ruleMQLquery EOF ;
    public final void entryRuleMQLquery() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:117:1: ( ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:118:1: ruleMQLquery EOF
            {
             before(grammarAccess.getMQLqueryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_entryRuleMQLquery181);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getMQLqueryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMQLquery188); 

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
    // $ANTLR end entryRuleMQLquery


    // $ANTLR start ruleMQLquery
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:125:1: ruleMQLquery : ( ( rule__MQLquery__Group__0 ) ) ;
    public final void ruleMQLquery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:129:2: ( ( ( rule__MQLquery__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:130:1: ( ( rule__MQLquery__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:130:1: ( ( rule__MQLquery__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:131:1: ( rule__MQLquery__Group__0 )
            {
             before(grammarAccess.getMQLqueryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:132:1: ( rule__MQLquery__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:132:2: rule__MQLquery__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__0_in_ruleMQLquery214);
            rule__MQLquery__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMQLquery


    // $ANTLR start entryRuleSelectEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:144:1: entryRuleSelectEntry : ruleSelectEntry EOF ;
    public final void entryRuleSelectEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:145:1: ( ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:146:1: ruleSelectEntry EOF
            {
             before(grammarAccess.getSelectEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry241);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getSelectEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectEntry248); 

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
    // $ANTLR end entryRuleSelectEntry


    // $ANTLR start ruleSelectEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:153:1: ruleSelectEntry : ( ( rule__SelectEntry__Group__0 ) ) ;
    public final void ruleSelectEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:157:2: ( ( ( rule__SelectEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:158:1: ( ( rule__SelectEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:158:1: ( ( rule__SelectEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:159:1: ( rule__SelectEntry__Group__0 )
            {
             before(grammarAccess.getSelectEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:160:1: ( rule__SelectEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:160:2: rule__SelectEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group__0_in_ruleSelectEntry274);
            rule__SelectEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSelectEntry


    // $ANTLR start entryRuleFromEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:172:1: entryRuleFromEntry : ruleFromEntry EOF ;
    public final void entryRuleFromEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:173:1: ( ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:174:1: ruleFromEntry EOF
            {
             before(grammarAccess.getFromEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_entryRuleFromEntry301);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getFromEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFromEntry308); 

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
    // $ANTLR end entryRuleFromEntry


    // $ANTLR start ruleFromEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:181:1: ruleFromEntry : ( ( rule__FromEntry__Group__0 ) ) ;
    public final void ruleFromEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:185:2: ( ( ( rule__FromEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:186:1: ( ( rule__FromEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:186:1: ( ( rule__FromEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:187:1: ( rule__FromEntry__Group__0 )
            {
             before(grammarAccess.getFromEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:188:1: ( rule__FromEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:188:2: rule__FromEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__0_in_ruleFromEntry334);
            rule__FromEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFromEntry


    // $ANTLR start entryRuleScopeClause
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:200:1: entryRuleScopeClause : ruleScopeClause EOF ;
    public final void entryRuleScopeClause() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:201:1: ( ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:202:1: ruleScopeClause EOF
            {
             before(grammarAccess.getScopeClauseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_entryRuleScopeClause361);
            ruleScopeClause();
            _fsp--;

             after(grammarAccess.getScopeClauseRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeClause368); 

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
    // $ANTLR end entryRuleScopeClause


    // $ANTLR start ruleScopeClause
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:209:1: ruleScopeClause : ( ( rule__ScopeClause__Group__0 ) ) ;
    public final void ruleScopeClause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:213:2: ( ( ( rule__ScopeClause__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:214:1: ( ( rule__ScopeClause__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:214:1: ( ( rule__ScopeClause__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:215:1: ( rule__ScopeClause__Group__0 )
            {
             before(grammarAccess.getScopeClauseAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:216:1: ( rule__ScopeClause__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:216:2: rule__ScopeClause__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__0_in_ruleScopeClause394);
            rule__ScopeClause__Group__0();
            _fsp--;


            }

             after(grammarAccess.getScopeClauseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleScopeClause


    // $ANTLR start entryRuleScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:228:1: entryRuleScope : ruleScope EOF ;
    public final void entryRuleScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:229:1: ( ruleScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:230:1: ruleScope EOF
            {
             before(grammarAccess.getScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_entryRuleScope421);
            ruleScope();
            _fsp--;

             after(grammarAccess.getScopeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScope428); 

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
    // $ANTLR end entryRuleScope


    // $ANTLR start ruleScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:237:1: ruleScope : ( ( rule__Scope__Alternatives ) ) ;
    public final void ruleScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:241:2: ( ( ( rule__Scope__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:242:1: ( ( rule__Scope__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:242:1: ( ( rule__Scope__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:243:1: ( rule__Scope__Alternatives )
            {
             before(grammarAccess.getScopeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:244:1: ( rule__Scope__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:244:2: rule__Scope__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Scope__Alternatives_in_ruleScope454);
            rule__Scope__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getScopeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleScope


    // $ANTLR start entryRuleResourceScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:256:1: entryRuleResourceScope : ruleResourceScope EOF ;
    public final void entryRuleResourceScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:257:1: ( ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:258:1: ruleResourceScope EOF
            {
             before(grammarAccess.getResourceScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_entryRuleResourceScope481);
            ruleResourceScope();
            _fsp--;

             after(grammarAccess.getResourceScopeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceScope488); 

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
    // $ANTLR end entryRuleResourceScope


    // $ANTLR start ruleResourceScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:265:1: ruleResourceScope : ( ( rule__ResourceScope__Group__0 ) ) ;
    public final void ruleResourceScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:269:2: ( ( ( rule__ResourceScope__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:270:1: ( ( rule__ResourceScope__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:270:1: ( ( rule__ResourceScope__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:271:1: ( rule__ResourceScope__Group__0 )
            {
             before(grammarAccess.getResourceScopeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:272:1: ( rule__ResourceScope__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:272:2: rule__ResourceScope__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__0_in_ruleResourceScope514);
            rule__ResourceScope__Group__0();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleResourceScope


    // $ANTLR start entryRuleElementScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:284:1: entryRuleElementScope : ruleElementScope EOF ;
    public final void entryRuleElementScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:285:1: ( ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:286:1: ruleElementScope EOF
            {
             before(grammarAccess.getElementScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_entryRuleElementScope541);
            ruleElementScope();
            _fsp--;

             after(grammarAccess.getElementScopeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElementScope548); 

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
    // $ANTLR end entryRuleElementScope


    // $ANTLR start ruleElementScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:293:1: ruleElementScope : ( ( rule__ElementScope__Group__0 ) ) ;
    public final void ruleElementScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:297:2: ( ( ( rule__ElementScope__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:298:1: ( ( rule__ElementScope__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:298:1: ( ( rule__ElementScope__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:299:1: ( rule__ElementScope__Group__0 )
            {
             before(grammarAccess.getElementScopeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:300:1: ( rule__ElementScope__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:300:2: rule__ElementScope__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__0_in_ruleElementScope574);
            rule__ElementScope__Group__0();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleElementScope


    // $ANTLR start entryRuleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:312:1: entryRuleWhereEntry : ruleWhereEntry EOF ;
    public final void entryRuleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:313:1: ( ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:314:1: ruleWhereEntry EOF
            {
             before(grammarAccess.getWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry601);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWhereEntry608); 

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
    // $ANTLR end entryRuleWhereEntry


    // $ANTLR start ruleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:321:1: ruleWhereEntry : ( ( rule__WhereEntry__Group__0 ) ) ;
    public final void ruleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:325:2: ( ( ( rule__WhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:326:1: ( ( rule__WhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:326:1: ( ( rule__WhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:327:1: ( rule__WhereEntry__Group__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:328:1: ( rule__WhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:328:2: rule__WhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group__0_in_ruleWhereEntry634);
            rule__WhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleWhereEntry


    // $ANTLR start entryRuleAndWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:340:1: entryRuleAndWhereEntry : ruleAndWhereEntry EOF ;
    public final void entryRuleAndWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:341:1: ( ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:342:1: ruleAndWhereEntry EOF
            {
             before(grammarAccess.getAndWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry661);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndWhereEntry668); 

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
    // $ANTLR end entryRuleAndWhereEntry


    // $ANTLR start ruleAndWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:349:1: ruleAndWhereEntry : ( ( rule__AndWhereEntry__Group__0 ) ) ;
    public final void ruleAndWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:353:2: ( ( ( rule__AndWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:354:1: ( ( rule__AndWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:354:1: ( ( rule__AndWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:355:1: ( rule__AndWhereEntry__Group__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:356:1: ( rule__AndWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:356:2: rule__AndWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group__0_in_ruleAndWhereEntry694);
            rule__AndWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAndWhereEntry


    // $ANTLR start entryRuleConcreteWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:368:1: entryRuleConcreteWhereEntry : ruleConcreteWhereEntry EOF ;
    public final void entryRuleConcreteWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:369:1: ( ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:370:1: ruleConcreteWhereEntry EOF
            {
             before(grammarAccess.getConcreteWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry721);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getConcreteWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteWhereEntry728); 

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
    // $ANTLR end entryRuleConcreteWhereEntry


    // $ANTLR start ruleConcreteWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:377:1: ruleConcreteWhereEntry : ( ( rule__ConcreteWhereEntry__Alternatives ) ) ;
    public final void ruleConcreteWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:381:2: ( ( ( rule__ConcreteWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:382:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:382:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:383:1: ( rule__ConcreteWhereEntry__Alternatives )
            {
             before(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:384:1: ( rule__ConcreteWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:384:2: rule__ConcreteWhereEntry__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConcreteWhereEntry__Alternatives_in_ruleConcreteWhereEntry754);
            rule__ConcreteWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcreteWhereEntry


    // $ANTLR start entryRuleParWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:396:1: entryRuleParWhereEntry : ruleParWhereEntry EOF ;
    public final void entryRuleParWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:397:1: ( ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:398:1: ruleParWhereEntry EOF
            {
             before(grammarAccess.getParWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry781);
            ruleParWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParWhereEntry788); 

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
    // $ANTLR end entryRuleParWhereEntry


    // $ANTLR start ruleParWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:405:1: ruleParWhereEntry : ( ( rule__ParWhereEntry__Group__0 ) ) ;
    public final void ruleParWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:409:2: ( ( ( rule__ParWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:410:1: ( ( rule__ParWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:410:1: ( ( rule__ParWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:411:1: ( rule__ParWhereEntry__Group__0 )
            {
             before(grammarAccess.getParWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:412:1: ( rule__ParWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:412:2: rule__ParWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__0_in_ruleParWhereEntry814);
            rule__ParWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleParWhereEntry


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:424:1: entryRuleAttributeWhereEntry : ruleAttributeWhereEntry EOF ;
    public final void entryRuleAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:425:1: ( ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:426:1: ruleAttributeWhereEntry EOF
            {
             before(grammarAccess.getAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry841);
            ruleAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getAttributeWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeWhereEntry848); 

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
    // $ANTLR end entryRuleAttributeWhereEntry


    // $ANTLR start ruleAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:433:1: ruleAttributeWhereEntry : ( ( rule__AttributeWhereEntry__Alternatives ) ) ;
    public final void ruleAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:437:2: ( ( ( rule__AttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:438:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:438:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:439:1: ( rule__AttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:440:1: ( rule__AttributeWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:440:2: rule__AttributeWhereEntry__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry874);
            rule__AttributeWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAttributeWhereEntry


    // $ANTLR start entryRuleNumericAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:452:1: entryRuleNumericAttributeWhereEntry : ruleNumericAttributeWhereEntry EOF ;
    public final void entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:453:1: ( ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:454:1: ruleNumericAttributeWhereEntry EOF
            {
             before(grammarAccess.getNumericAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry901);
            ruleNumericAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getNumericAttributeWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry908); 

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
    // $ANTLR end entryRuleNumericAttributeWhereEntry


    // $ANTLR start ruleNumericAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:461:1: ruleNumericAttributeWhereEntry : ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) ;
    public final void ruleNumericAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:465:2: ( ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:466:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:466:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:467:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:468:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:468:2: rule__NumericAttributeWhereEntry__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry934);
            rule__NumericAttributeWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNumericAttributeWhereEntry


    // $ANTLR start entryRuleDoubleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:480:1: entryRuleDoubleWhereEntry : ruleDoubleWhereEntry EOF ;
    public final void entryRuleDoubleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:481:1: ( ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:482:1: ruleDoubleWhereEntry EOF
            {
             before(grammarAccess.getDoubleWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry961);
            ruleDoubleWhereEntry();
            _fsp--;

             after(grammarAccess.getDoubleWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleWhereEntry968); 

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
    // $ANTLR end entryRuleDoubleWhereEntry


    // $ANTLR start ruleDoubleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:489:1: ruleDoubleWhereEntry : ( ( rule__DoubleWhereEntry__Group__0 ) ) ;
    public final void ruleDoubleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:493:2: ( ( ( rule__DoubleWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:494:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:494:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:495:1: ( rule__DoubleWhereEntry__Group__0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:496:1: ( rule__DoubleWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:496:2: rule__DoubleWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry994);
            rule__DoubleWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDoubleWhereEntry


    // $ANTLR start entryRuleLongWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:508:1: entryRuleLongWhereEntry : ruleLongWhereEntry EOF ;
    public final void entryRuleLongWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:509:1: ( ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:510:1: ruleLongWhereEntry EOF
            {
             before(grammarAccess.getLongWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1021);
            ruleLongWhereEntry();
            _fsp--;

             after(grammarAccess.getLongWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLongWhereEntry1028); 

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
    // $ANTLR end entryRuleLongWhereEntry


    // $ANTLR start ruleLongWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:517:1: ruleLongWhereEntry : ( ( rule__LongWhereEntry__Group__0 ) ) ;
    public final void ruleLongWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:521:2: ( ( ( rule__LongWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:522:1: ( ( rule__LongWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:522:1: ( ( rule__LongWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:523:1: ( rule__LongWhereEntry__Group__0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:524:1: ( rule__LongWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:524:2: rule__LongWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1054);
            rule__LongWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLongWhereEntry


    // $ANTLR start entryRuleVariableWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:536:1: entryRuleVariableWhereEntry : ruleVariableWhereEntry EOF ;
    public final void entryRuleVariableWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:537:1: ( ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:538:1: ruleVariableWhereEntry EOF
            {
             before(grammarAccess.getVariableWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1081);
            ruleVariableWhereEntry();
            _fsp--;

             after(grammarAccess.getVariableWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableWhereEntry1088); 

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
    // $ANTLR end entryRuleVariableWhereEntry


    // $ANTLR start ruleVariableWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:545:1: ruleVariableWhereEntry : ( ( rule__VariableWhereEntry__Group__0 ) ) ;
    public final void ruleVariableWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:549:2: ( ( ( rule__VariableWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:550:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:550:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:551:1: ( rule__VariableWhereEntry__Group__0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:552:1: ( rule__VariableWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:552:2: rule__VariableWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1114);
            rule__VariableWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleVariableWhereEntry


    // $ANTLR start entryRuleStringAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:564:1: entryRuleStringAttributeWhereEntry : ruleStringAttributeWhereEntry EOF ;
    public final void entryRuleStringAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:565:1: ( ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:566:1: ruleStringAttributeWhereEntry EOF
            {
             before(grammarAccess.getStringAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1141);
            ruleStringAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getStringAttributeWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1148); 

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
    // $ANTLR end entryRuleStringAttributeWhereEntry


    // $ANTLR start ruleStringAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:573:1: ruleStringAttributeWhereEntry : ( ( rule__StringAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleStringAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:577:2: ( ( ( rule__StringAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:578:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:578:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:579:1: ( rule__StringAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:580:1: ( rule__StringAttributeWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:580:2: rule__StringAttributeWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1174);
            rule__StringAttributeWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringAttributeWhereEntry


    // $ANTLR start entryRuleBooleanAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:592:1: entryRuleBooleanAttributeWhereEntry : ruleBooleanAttributeWhereEntry EOF ;
    public final void entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:593:1: ( ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:594:1: ruleBooleanAttributeWhereEntry EOF
            {
             before(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1201);
            ruleBooleanAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1208); 

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
    // $ANTLR end entryRuleBooleanAttributeWhereEntry


    // $ANTLR start ruleBooleanAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:601:1: ruleBooleanAttributeWhereEntry : ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleBooleanAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:605:2: ( ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:606:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:606:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:607:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:608:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:608:2: rule__BooleanAttributeWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1234);
            rule__BooleanAttributeWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanAttributeWhereEntry


    // $ANTLR start entryRuleNullWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:620:1: entryRuleNullWhereEntry : ruleNullWhereEntry EOF ;
    public final void entryRuleNullWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:621:1: ( ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:622:1: ruleNullWhereEntry EOF
            {
             before(grammarAccess.getNullWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1261);
            ruleNullWhereEntry();
            _fsp--;

             after(grammarAccess.getNullWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullWhereEntry1268); 

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
    // $ANTLR end entryRuleNullWhereEntry


    // $ANTLR start ruleNullWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:629:1: ruleNullWhereEntry : ( ( rule__NullWhereEntry__Group__0 ) ) ;
    public final void ruleNullWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:633:2: ( ( ( rule__NullWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:634:1: ( ( rule__NullWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:634:1: ( ( rule__NullWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:635:1: ( rule__NullWhereEntry__Group__0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:636:1: ( rule__NullWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:636:2: rule__NullWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1294);
            rule__NullWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNullWhereEntry


    // $ANTLR start entryRuleReferenceAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:648:1: entryRuleReferenceAliasWhereEntry : ruleReferenceAliasWhereEntry EOF ;
    public final void entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:649:1: ( ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:650:1: ruleReferenceAliasWhereEntry EOF
            {
             before(grammarAccess.getReferenceAliasWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1321);
            ruleReferenceAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getReferenceAliasWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1328); 

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
    // $ANTLR end entryRuleReferenceAliasWhereEntry


    // $ANTLR start ruleReferenceAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:657:1: ruleReferenceAliasWhereEntry : ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) ;
    public final void ruleReferenceAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:661:2: ( ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:662:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:662:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:663:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:664:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:664:2: rule__ReferenceAliasWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1354);
            rule__ReferenceAliasWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReferenceAliasWhereEntry


    // $ANTLR start entryRuleSubselectWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:676:1: entryRuleSubselectWhereEntry : ruleSubselectWhereEntry EOF ;
    public final void entryRuleSubselectWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:677:1: ( ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:678:1: ruleSubselectWhereEntry EOF
            {
             before(grammarAccess.getSubselectWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1381);
            ruleSubselectWhereEntry();
            _fsp--;

             after(grammarAccess.getSubselectWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubselectWhereEntry1388); 

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
    // $ANTLR end entryRuleSubselectWhereEntry


    // $ANTLR start ruleSubselectWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:685:1: ruleSubselectWhereEntry : ( ( rule__SubselectWhereEntry__Group__0 ) ) ;
    public final void ruleSubselectWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:689:2: ( ( ( rule__SubselectWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:690:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:690:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:691:1: ( rule__SubselectWhereEntry__Group__0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:692:1: ( rule__SubselectWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:692:2: rule__SubselectWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1414);
            rule__SubselectWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSubselectWhereEntry


    // $ANTLR start entryRuleAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:704:1: entryRuleAliasWhereEntry : ruleAliasWhereEntry EOF ;
    public final void entryRuleAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:705:1: ( ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:706:1: ruleAliasWhereEntry EOF
            {
             before(grammarAccess.getAliasWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1441);
            ruleAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getAliasWhereEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAliasWhereEntry1448); 

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
    // $ANTLR end entryRuleAliasWhereEntry


    // $ANTLR start ruleAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:713:1: ruleAliasWhereEntry : ( ( rule__AliasWhereEntry__Group__0 ) ) ;
    public final void ruleAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:717:2: ( ( ( rule__AliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:718:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:718:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:719:1: ( rule__AliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:720:1: ( rule__AliasWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:720:2: rule__AliasWhereEntry__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1474);
            rule__AliasWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAliasWhereEntry


    // $ANTLR start ruleNumericOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:733:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:737:1: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:738:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:738:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:739:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:740:1: ( rule__NumericOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:740:2: rule__NumericOperator__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1511);
            rule__NumericOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNumericOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNumericOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:752:1: ruleStringOperator : ( ( rule__StringOperator__Alternatives ) ) ;
    public final void ruleStringOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:756:1: ( ( ( rule__StringOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:757:1: ( ( rule__StringOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:757:1: ( ( rule__StringOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:758:1: ( rule__StringOperator__Alternatives )
            {
             before(grammarAccess.getStringOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:759:1: ( rule__StringOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:759:2: rule__StringOperator__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1547);
            rule__StringOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStringOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleBooleanOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:771:1: ruleBooleanOperator : ( ( rule__BooleanOperator__Alternatives ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:775:1: ( ( ( rule__BooleanOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:776:1: ( ( rule__BooleanOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:776:1: ( ( rule__BooleanOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:777:1: ( rule__BooleanOperator__Alternatives )
            {
             before(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:778:1: ( rule__BooleanOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:778:2: rule__BooleanOperator__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1583);
            rule__BooleanOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanOperator


    // $ANTLR start rule__Scope__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:789:1: rule__Scope__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__Scope__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:793:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==28) ) {
                alt1=1;
            }
            else if ( (LA1_0==31) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("789:1: rule__Scope__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:794:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:794:1: ( ruleResourceScope )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:795:1: ruleResourceScope
                    {
                     before(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_rule__Scope__Alternatives1618);
                    ruleResourceScope();
                    _fsp--;

                     after(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:800:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:800:6: ( ruleElementScope )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:801:1: ruleElementScope
                    {
                     before(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_rule__Scope__Alternatives1635);
                    ruleElementScope();
                    _fsp--;

                     after(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1()); 

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
    // $ANTLR end rule__Scope__Alternatives


    // $ANTLR start rule__ConcreteWhereEntry__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:815:1: ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) )
            int alt2=6;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==34) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==25) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                            case 11:
                            case 39:
                                {
                                alt2=2;
                                }
                                break;
                            case 36:
                                {
                                alt2=3;
                                }
                                break;
                            case RULE_ID:
                                {
                                int LA2_11 = input.LA(6);

                                if ( (LA2_11==25) ) {
                                    alt2=2;
                                }
                                else if ( (LA2_11==EOF||LA2_11==RULE_ID||(LA2_11>=32 && LA2_11<=35)) ) {
                                    alt2=4;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 11, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            int LA2_7 = input.LA(5);

                            if ( ((LA2_7>=RULE_STRING && LA2_7<=RULE_SINGED_LONG)||LA2_7==11||LA2_7==39) ) {
                                alt2=2;
                            }
                            else if ( (LA2_7==36) ) {
                                alt2=3;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 18:
                        case 19:
                            {
                            alt2=2;
                            }
                            break;
                        case 27:
                        case 38:
                            {
                            alt2=6;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==16) ) {
                    alt2=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("811:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:816:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:816:1: ( ruleParWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:817:1: ruleParWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1667);
                    ruleParWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:822:6: ( ruleAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:822:6: ( ruleAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:823:1: ruleAttributeWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1684);
                    ruleAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:828:6: ( ruleNullWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:828:6: ( ruleNullWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:829:1: ruleNullWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1701);
                    ruleNullWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:834:6: ( ruleReferenceAliasWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:834:6: ( ruleReferenceAliasWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:835:1: ruleReferenceAliasWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1718);
                    ruleReferenceAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:840:6: ( ruleAliasWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:840:6: ( ruleAliasWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:841:1: ruleAliasWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1735);
                    ruleAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:846:6: ( ruleSubselectWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:846:6: ( ruleSubselectWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:847:1: ruleSubselectWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1752);
                    ruleSubselectWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5()); 

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
    // $ANTLR end rule__ConcreteWhereEntry__Alternatives


    // $ANTLR start rule__AttributeWhereEntry__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );
    public final void rule__AttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:861:1: ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==25) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                                {
                                alt3=2;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt3=1;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt3=4;
                                }
                                break;
                            case 11:
                            case 39:
                                {
                                alt3=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 4, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                                {
                                alt3=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt3=4;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt3=1;
                                }
                                break;
                            case 11:
                            case 39:
                                {
                                alt3=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 5, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 18:
                        case 19:
                            {
                            alt3=2;
                            }
                            break;
                        case 12:
                            {
                            int LA3_7 = input.LA(5);

                            if ( ((LA3_7>=RULE_SIGNED_DOUBLE && LA3_7<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_7==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA3_8 = input.LA(5);

                            if ( ((LA3_8>=RULE_SIGNED_DOUBLE && LA3_8<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_8==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA3_9 = input.LA(5);

                            if ( ((LA3_9>=RULE_SIGNED_DOUBLE && LA3_9<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_9==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA3_10 = input.LA(5);

                            if ( ((LA3_10>=RULE_SIGNED_DOUBLE && LA3_10<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_10==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 10, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("857:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:862:1: ( ruleNumericAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:862:1: ( ruleNumericAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:863:1: ruleNumericAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1784);
                    ruleNumericAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:868:6: ( ruleStringAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:868:6: ( ruleStringAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:869:1: ruleStringAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1801);
                    ruleStringAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:874:6: ( ruleBooleanAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:874:6: ( ruleBooleanAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:875:1: ruleBooleanAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1818);
                    ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:880:6: ( ruleVariableWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:880:6: ( ruleVariableWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:881:1: ruleVariableWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1835);
                    ruleVariableWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 

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
    // $ANTLR end rule__AttributeWhereEntry__Alternatives


    // $ANTLR start rule__NumericAttributeWhereEntry__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );
    public final void rule__NumericAttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:895:1: ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==25) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA4_4 = input.LA(5);

                            if ( (LA4_4==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_4==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA4_5 = input.LA(5);

                            if ( (LA4_5==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_5==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA4_6 = input.LA(5);

                            if ( (LA4_6==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_6==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA4_7 = input.LA(5);

                            if ( (LA4_7==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_7==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            int LA4_8 = input.LA(5);

                            if ( (LA4_8==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_8==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA4_9 = input.LA(5);

                            if ( (LA4_9==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_9==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("891:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:896:1: ( ruleDoubleWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:896:1: ( ruleDoubleWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:897:1: ruleDoubleWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1867);
                    ruleDoubleWhereEntry();
                    _fsp--;

                     after(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:902:6: ( ruleLongWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:902:6: ( ruleLongWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:903:1: ruleLongWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1884);
                    ruleLongWhereEntry();
                    _fsp--;

                     after(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 

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
    // $ANTLR end rule__NumericAttributeWhereEntry__Alternatives


    // $ANTLR start rule__BooleanAttributeWhereEntry__Alternatives_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:913:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );
    public final void rule__BooleanAttributeWhereEntry__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:917:1: ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==39) ) {
                alt5=1;
            }
            else if ( (LA5_0==11) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("913:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:918:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:918:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:919:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:920:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:920:2: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_41916);
                    rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:924:6: ( 'false' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:924:6: ( 'false' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:925:1: 'false'
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_41935); 
                     after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1()); 

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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Alternatives_4


    // $ANTLR start rule__NumericOperator__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:937:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:941:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 13:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case 15:
                {
                alt6=4;
                }
                break;
            case 16:
                {
                alt6=5;
                }
                break;
            case 17:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("937:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:942:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:942:1: ( ( '<' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:943:1: ( '<' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:944:1: ( '<' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:944:3: '<'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__NumericOperator__Alternatives1970); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:949:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:949:6: ( ( '>' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:950:1: ( '>' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:951:1: ( '>' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:951:3: '>'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__NumericOperator__Alternatives1991); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:956:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:956:6: ( ( '<=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:957:1: ( '<=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:958:1: ( '<=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:958:3: '<='
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__NumericOperator__Alternatives2012); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:963:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:963:6: ( ( '>=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:964:1: ( '>=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:965:1: ( '>=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:965:3: '>='
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__NumericOperator__Alternatives2033); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:970:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:970:6: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:971:1: ( '=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:972:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:972:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__NumericOperator__Alternatives2054); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:977:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:977:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:978:1: ( '!=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:979:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:979:3: '!='
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__NumericOperator__Alternatives2075); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 

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
    // $ANTLR end rule__NumericOperator__Alternatives


    // $ANTLR start rule__StringOperator__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:989:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );
    public final void rule__StringOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:993:1: ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            case 19:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("989:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:994:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:994:1: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:995:1: ( '=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:996:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:996:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__StringOperator__Alternatives2111); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1001:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1001:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1002:1: ( '!=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1003:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1003:3: '!='
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__StringOperator__Alternatives2132); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1008:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1008:6: ( ( 'like' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1009:1: ( 'like' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1010:1: ( 'like' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1010:3: 'like'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__StringOperator__Alternatives2153); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1015:6: ( ( 'notlike' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1015:6: ( ( 'notlike' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1016:1: ( 'notlike' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1017:1: ( 'notlike' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1017:3: 'notlike'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__StringOperator__Alternatives2174); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__StringOperator__Alternatives


    // $ANTLR start rule__BooleanOperator__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1027:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__BooleanOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1031:1: ( ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==17) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1027:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1032:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1032:1: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1033:1: ( '=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1034:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1034:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__BooleanOperator__Alternatives2210); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1039:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1039:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1040:1: ( '!=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1041:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1041:3: '!='
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__BooleanOperator__Alternatives2231); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

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
    // $ANTLR end rule__BooleanOperator__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1053:1: rule__Model__Group__0 : ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1057:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1058:1: ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1058:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1059:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1060:1: ( rule__Model__ImportsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1060:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02268);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02278);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1071:1: rule__Model__Group__1 : ( ( rule__Model__QueryAssignment_1 ) ) ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1075:1: ( ( ( rule__Model__QueryAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1076:1: ( ( rule__Model__QueryAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1076:1: ( ( rule__Model__QueryAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1077:1: ( rule__Model__QueryAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getQueryAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1078:1: ( rule__Model__QueryAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1078:2: rule__Model__QueryAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__QueryAssignment_1_in_rule__Model__Group__12306);
            rule__Model__QueryAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getQueryAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1092:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1096:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1097:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1097:1: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1098:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Import__Group__02345); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02355);
            rule__Import__Group__1();
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
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1112:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1116:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1117:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1117:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1118:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1119:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1119:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12383);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__MQLquery__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1133:1: rule__MQLquery__Group__0 : ( 'select' ) rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1137:1: ( ( 'select' ) rule__MQLquery__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1138:1: ( 'select' ) rule__MQLquery__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1138:1: ( 'select' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1139:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MQLquery__Group__02422); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02432);
            rule__MQLquery__Group__1();
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
    // $ANTLR end rule__MQLquery__Group__0


    // $ANTLR start rule__MQLquery__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1153:1: rule__MQLquery__Group__1 : ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1157:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1158:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1158:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1159:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1160:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1160:2: rule__MQLquery__SelectEntriesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12460);
            rule__MQLquery__SelectEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12469);
            rule__MQLquery__Group__2();
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
    // $ANTLR end rule__MQLquery__Group__1


    // $ANTLR start rule__MQLquery__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1171:1: rule__MQLquery__Group__2 : ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1175:1: ( ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1176:1: ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1176:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1177:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1178:1: ( rule__MQLquery__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1178:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22497);
            	    rule__MQLquery__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22507);
            rule__MQLquery__Group__3();
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
    // $ANTLR end rule__MQLquery__Group__2


    // $ANTLR start rule__MQLquery__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1189:1: rule__MQLquery__Group__3 : ( 'from' ) rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1193:1: ( ( 'from' ) rule__MQLquery__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1194:1: ( 'from' ) rule__MQLquery__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1194:1: ( 'from' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1195:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MQLquery__Group__32536); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32546);
            rule__MQLquery__Group__4();
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
    // $ANTLR end rule__MQLquery__Group__3


    // $ANTLR start rule__MQLquery__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1209:1: rule__MQLquery__Group__4 : ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1213:1: ( ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1214:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1214:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1215:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1216:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1216:2: rule__MQLquery__FromEntriesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42574);
            rule__MQLquery__FromEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42583);
            rule__MQLquery__Group__5();
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
    // $ANTLR end rule__MQLquery__Group__4


    // $ANTLR start rule__MQLquery__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1227:1: rule__MQLquery__Group__5 : ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1231:1: ( ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1232:1: ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1232:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1233:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1234:1: ( rule__MQLquery__Group_5__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1234:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52611);
            	    rule__MQLquery__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52621);
            rule__MQLquery__Group__6();
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
    // $ANTLR end rule__MQLquery__Group__5


    // $ANTLR start rule__MQLquery__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1245:1: rule__MQLquery__Group__6 : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1249:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1250:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1250:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1251:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1252:1: ( rule__MQLquery__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1252:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62649);
                    rule__MQLquery__Group_6__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMQLqueryAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__6


    // $ANTLR start rule__MQLquery__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1276:1: rule__MQLquery__Group_2__0 : ( ',' ) rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1280:1: ( ( ',' ) rule__MQLquery__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1281:1: ( ',' ) rule__MQLquery__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1281:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1282:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MQLquery__Group_2__02699); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02709);
            rule__MQLquery__Group_2__1();
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
    // $ANTLR end rule__MQLquery__Group_2__0


    // $ANTLR start rule__MQLquery__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1296:1: rule__MQLquery__Group_2__1 : ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1300:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1301:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1301:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1302:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1303:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1303:2: rule__MQLquery__SelectEntriesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12737);
            rule__MQLquery__SelectEntriesAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_2__1


    // $ANTLR start rule__MQLquery__Group_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1317:1: rule__MQLquery__Group_5__0 : ( ',' ) rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1321:1: ( ( ',' ) rule__MQLquery__Group_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1322:1: ( ',' ) rule__MQLquery__Group_5__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1322:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1323:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MQLquery__Group_5__02776); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02786);
            rule__MQLquery__Group_5__1();
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
    // $ANTLR end rule__MQLquery__Group_5__0


    // $ANTLR start rule__MQLquery__Group_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1337:1: rule__MQLquery__Group_5__1 : ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1341:1: ( ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1342:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1342:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1343:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1344:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1344:2: rule__MQLquery__FromEntriesAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__12814);
            rule__MQLquery__FromEntriesAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_5__1


    // $ANTLR start rule__MQLquery__Group_6__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1358:1: rule__MQLquery__Group_6__0 : ( 'where' ) rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1362:1: ( ( 'where' ) rule__MQLquery__Group_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1363:1: ( 'where' ) rule__MQLquery__Group_6__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1363:1: ( 'where' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1364:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__MQLquery__Group_6__02853); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__02863);
            rule__MQLquery__Group_6__1();
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
    // $ANTLR end rule__MQLquery__Group_6__0


    // $ANTLR start rule__MQLquery__Group_6__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1378:1: rule__MQLquery__Group_6__1 : ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) ) ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1382:1: ( ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1383:1: ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1383:1: ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1384:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1384:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1385:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1386:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1386:2: rule__MQLquery__WhereEntriesAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__12893);
            rule__MQLquery__WhereEntriesAssignment_6_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1389:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1390:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )*
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1391:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1391:2: rule__MQLquery__WhereEntriesAssignment_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__12905);
            	    rule__MQLquery__WhereEntriesAssignment_6_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 

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
    // $ANTLR end rule__MQLquery__Group_6__1


    // $ANTLR start rule__SelectEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1406:1: rule__SelectEntry__Group__0 : ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1410:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1411:1: ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1411:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1412:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1413:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1413:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__02946);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__02955);
            rule__SelectEntry__Group__1();
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
    // $ANTLR end rule__SelectEntry__Group__0


    // $ANTLR start rule__SelectEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1424:1: rule__SelectEntry__Group__1 : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1428:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1429:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1429:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1430:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1431:1: ( rule__SelectEntry__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1431:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__12983);
                    rule__SelectEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group__1


    // $ANTLR start rule__SelectEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1445:1: rule__SelectEntry__Group_1__0 : ( '.' ) rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1449:1: ( ( '.' ) rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1450:1: ( '.' ) rule__SelectEntry__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1450:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1451:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__SelectEntry__Group_1__03023); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03033);
            rule__SelectEntry__Group_1__1();
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
    // $ANTLR end rule__SelectEntry__Group_1__0


    // $ANTLR start rule__SelectEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1465:1: rule__SelectEntry__Group_1__1 : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1469:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1470:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1470:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1471:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1472:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1472:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13061);
            rule__SelectEntry__AttributeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group_1__1


    // $ANTLR start rule__FromEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1486:1: rule__FromEntry__Group__0 : ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1490:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1491:1: ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1491:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1492:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1493:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1493:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03099);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03108);
            rule__FromEntry__Group__1();
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
    // $ANTLR end rule__FromEntry__Group__0


    // $ANTLR start rule__FromEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1504:1: rule__FromEntry__Group__1 : ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1508:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1509:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1509:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1510:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1511:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1511:2: rule__FromEntry__WithoutsubtypesAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13136);
                    rule__FromEntry__WithoutsubtypesAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13146);
            rule__FromEntry__Group__2();
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
    // $ANTLR end rule__FromEntry__Group__1


    // $ANTLR start rule__FromEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1522:1: rule__FromEntry__Group__2 : ( 'as' ) rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1526:1: ( ( 'as' ) rule__FromEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1527:1: ( 'as' ) rule__FromEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1527:1: ( 'as' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1528:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__FromEntry__Group__23175); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23185);
            rule__FromEntry__Group__3();
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
    // $ANTLR end rule__FromEntry__Group__2


    // $ANTLR start rule__FromEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1542:1: rule__FromEntry__Group__3 : ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1546:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1547:1: ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1547:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1548:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1549:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1549:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33213);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33222);
            rule__FromEntry__Group__4();
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
    // $ANTLR end rule__FromEntry__Group__3


    // $ANTLR start rule__FromEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1560:1: rule__FromEntry__Group__4 : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1564:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1565:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1565:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1566:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1567:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27||LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1567:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43250);
                    rule__FromEntry__ScopeClauseAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__4


    // $ANTLR start rule__ScopeClause__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1587:1: rule__ScopeClause__Group__0 : ( ( rule__ScopeClause__NotInAssignment_0 )? ) rule__ScopeClause__Group__1 ;
    public final void rule__ScopeClause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1591:1: ( ( ( rule__ScopeClause__NotInAssignment_0 )? ) rule__ScopeClause__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1592:1: ( ( rule__ScopeClause__NotInAssignment_0 )? ) rule__ScopeClause__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1592:1: ( ( rule__ScopeClause__NotInAssignment_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1593:1: ( rule__ScopeClause__NotInAssignment_0 )?
            {
             before(grammarAccess.getScopeClauseAccess().getNotInAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1594:1: ( rule__ScopeClause__NotInAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1594:2: rule__ScopeClause__NotInAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__NotInAssignment_0_in_rule__ScopeClause__Group__03295);
                    rule__ScopeClause__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScopeClauseAccess().getNotInAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__1_in_rule__ScopeClause__Group__03305);
            rule__ScopeClause__Group__1();
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
    // $ANTLR end rule__ScopeClause__Group__0


    // $ANTLR start rule__ScopeClause__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1605:1: rule__ScopeClause__Group__1 : ( 'in' ) rule__ScopeClause__Group__2 ;
    public final void rule__ScopeClause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1609:1: ( ( 'in' ) rule__ScopeClause__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1610:1: ( 'in' ) rule__ScopeClause__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1610:1: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1611:1: 'in'
            {
             before(grammarAccess.getScopeClauseAccess().getInKeyword_1()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ScopeClause__Group__13334); 
             after(grammarAccess.getScopeClauseAccess().getInKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__2_in_rule__ScopeClause__Group__13344);
            rule__ScopeClause__Group__2();
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
    // $ANTLR end rule__ScopeClause__Group__1


    // $ANTLR start rule__ScopeClause__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1625:1: rule__ScopeClause__Group__2 : ( ( rule__ScopeClause__ScopeAssignment_2 ) ) ;
    public final void rule__ScopeClause__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1629:1: ( ( ( rule__ScopeClause__ScopeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1630:1: ( ( rule__ScopeClause__ScopeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1630:1: ( ( rule__ScopeClause__ScopeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1631:1: ( rule__ScopeClause__ScopeAssignment_2 )
            {
             before(grammarAccess.getScopeClauseAccess().getScopeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1632:1: ( rule__ScopeClause__ScopeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1632:2: rule__ScopeClause__ScopeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__ScopeAssignment_2_in_rule__ScopeClause__Group__23372);
            rule__ScopeClause__ScopeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getScopeClauseAccess().getScopeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ScopeClause__Group__2


    // $ANTLR start rule__ResourceScope__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1648:1: rule__ResourceScope__Group__0 : ( 'resources' ) rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1652:1: ( ( 'resources' ) rule__ResourceScope__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1653:1: ( 'resources' ) rule__ResourceScope__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1653:1: ( 'resources' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1654:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ResourceScope__Group__03413); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03423);
            rule__ResourceScope__Group__1();
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
    // $ANTLR end rule__ResourceScope__Group__0


    // $ANTLR start rule__ResourceScope__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1668:1: rule__ResourceScope__Group__1 : ( '{' ) rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1672:1: ( ( '{' ) rule__ResourceScope__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1673:1: ( '{' ) rule__ResourceScope__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1673:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1674:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ResourceScope__Group__13452); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13462);
            rule__ResourceScope__Group__2();
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
    // $ANTLR end rule__ResourceScope__Group__1


    // $ANTLR start rule__ResourceScope__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1688:1: rule__ResourceScope__Group__2 : ( ( rule__ResourceScope__UrisAssignment_2 ) ) rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1692:1: ( ( ( rule__ResourceScope__UrisAssignment_2 ) ) rule__ResourceScope__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1693:1: ( ( rule__ResourceScope__UrisAssignment_2 ) ) rule__ResourceScope__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1693:1: ( ( rule__ResourceScope__UrisAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1694:1: ( rule__ResourceScope__UrisAssignment_2 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1695:1: ( rule__ResourceScope__UrisAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1695:2: rule__ResourceScope__UrisAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__UrisAssignment_2_in_rule__ResourceScope__Group__23490);
            rule__ResourceScope__UrisAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23499);
            rule__ResourceScope__Group__3();
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
    // $ANTLR end rule__ResourceScope__Group__2


    // $ANTLR start rule__ResourceScope__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1706:1: rule__ResourceScope__Group__3 : ( ( rule__ResourceScope__Group_3__0 )* ) rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1710:1: ( ( ( rule__ResourceScope__Group_3__0 )* ) rule__ResourceScope__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1711:1: ( ( rule__ResourceScope__Group_3__0 )* ) rule__ResourceScope__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1711:1: ( ( rule__ResourceScope__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1712:1: ( rule__ResourceScope__Group_3__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1713:1: ( rule__ResourceScope__Group_3__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1713:2: rule__ResourceScope__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__0_in_rule__ResourceScope__Group__33527);
            	    rule__ResourceScope__Group_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getResourceScopeAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33537);
            rule__ResourceScope__Group__4();
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
    // $ANTLR end rule__ResourceScope__Group__3


    // $ANTLR start rule__ResourceScope__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1724:1: rule__ResourceScope__Group__4 : ( '}' ) ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1728:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1729:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1729:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1730:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ResourceScope__Group__43566); 
             after(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__4


    // $ANTLR start rule__ResourceScope__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1753:1: rule__ResourceScope__Group_3__0 : ( ',' ) rule__ResourceScope__Group_3__1 ;
    public final void rule__ResourceScope__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1757:1: ( ( ',' ) rule__ResourceScope__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1758:1: ( ',' ) rule__ResourceScope__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1758:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1759:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ResourceScope__Group_3__03612); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__1_in_rule__ResourceScope__Group_3__03622);
            rule__ResourceScope__Group_3__1();
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
    // $ANTLR end rule__ResourceScope__Group_3__0


    // $ANTLR start rule__ResourceScope__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1773:1: rule__ResourceScope__Group_3__1 : ( ( rule__ResourceScope__UrisAssignment_3_1 ) ) ;
    public final void rule__ResourceScope__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1777:1: ( ( ( rule__ResourceScope__UrisAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1778:1: ( ( rule__ResourceScope__UrisAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1778:1: ( ( rule__ResourceScope__UrisAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1779:1: ( rule__ResourceScope__UrisAssignment_3_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1780:1: ( rule__ResourceScope__UrisAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1780:2: rule__ResourceScope__UrisAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__UrisAssignment_3_1_in_rule__ResourceScope__Group_3__13650);
            rule__ResourceScope__UrisAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group_3__1


    // $ANTLR start rule__ElementScope__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1794:1: rule__ElementScope__Group__0 : ( 'elements' ) rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1798:1: ( ( 'elements' ) rule__ElementScope__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1799:1: ( 'elements' ) rule__ElementScope__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1799:1: ( 'elements' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1800:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__ElementScope__Group__03689); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03699);
            rule__ElementScope__Group__1();
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
    // $ANTLR end rule__ElementScope__Group__0


    // $ANTLR start rule__ElementScope__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1814:1: rule__ElementScope__Group__1 : ( '{' ) rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1818:1: ( ( '{' ) rule__ElementScope__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1819:1: ( '{' ) rule__ElementScope__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1819:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1820:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ElementScope__Group__13728); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13738);
            rule__ElementScope__Group__2();
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
    // $ANTLR end rule__ElementScope__Group__1


    // $ANTLR start rule__ElementScope__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1834:1: rule__ElementScope__Group__2 : ( ( rule__ElementScope__UrisAssignment_2 ) ) rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1838:1: ( ( ( rule__ElementScope__UrisAssignment_2 ) ) rule__ElementScope__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1839:1: ( ( rule__ElementScope__UrisAssignment_2 ) ) rule__ElementScope__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1839:1: ( ( rule__ElementScope__UrisAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1840:1: ( rule__ElementScope__UrisAssignment_2 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1841:1: ( rule__ElementScope__UrisAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1841:2: rule__ElementScope__UrisAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__UrisAssignment_2_in_rule__ElementScope__Group__23766);
            rule__ElementScope__UrisAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23775);
            rule__ElementScope__Group__3();
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
    // $ANTLR end rule__ElementScope__Group__2


    // $ANTLR start rule__ElementScope__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1852:1: rule__ElementScope__Group__3 : ( ( rule__ElementScope__Group_3__0 )* ) rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1856:1: ( ( ( rule__ElementScope__Group_3__0 )* ) rule__ElementScope__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1857:1: ( ( rule__ElementScope__Group_3__0 )* ) rule__ElementScope__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1857:1: ( ( rule__ElementScope__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1858:1: ( rule__ElementScope__Group_3__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1859:1: ( rule__ElementScope__Group_3__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1859:2: rule__ElementScope__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__0_in_rule__ElementScope__Group__33803);
            	    rule__ElementScope__Group_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getElementScopeAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__33813);
            rule__ElementScope__Group__4();
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
    // $ANTLR end rule__ElementScope__Group__3


    // $ANTLR start rule__ElementScope__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1870:1: rule__ElementScope__Group__4 : ( '}' ) ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1874:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1875:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1875:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1876:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ElementScope__Group__43842); 
             after(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__4


    // $ANTLR start rule__ElementScope__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1899:1: rule__ElementScope__Group_3__0 : ( ',' ) rule__ElementScope__Group_3__1 ;
    public final void rule__ElementScope__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1903:1: ( ( ',' ) rule__ElementScope__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1904:1: ( ',' ) rule__ElementScope__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1904:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1905:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ElementScope__Group_3__03888); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__1_in_rule__ElementScope__Group_3__03898);
            rule__ElementScope__Group_3__1();
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
    // $ANTLR end rule__ElementScope__Group_3__0


    // $ANTLR start rule__ElementScope__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1919:1: rule__ElementScope__Group_3__1 : ( ( rule__ElementScope__UrisAssignment_3_1 ) ) ;
    public final void rule__ElementScope__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1923:1: ( ( ( rule__ElementScope__UrisAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1924:1: ( ( rule__ElementScope__UrisAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1924:1: ( ( rule__ElementScope__UrisAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1925:1: ( rule__ElementScope__UrisAssignment_3_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1926:1: ( rule__ElementScope__UrisAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1926:2: rule__ElementScope__UrisAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__UrisAssignment_3_1_in_rule__ElementScope__Group_3__13926);
            rule__ElementScope__UrisAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group_3__1


    // $ANTLR start rule__WhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1940:1: rule__WhereEntry__Group__0 : ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1944:1: ( ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1945:1: ( ruleAndWhereEntry ) rule__WhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1945:1: ( ruleAndWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1946:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__03964);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__03972);
            rule__WhereEntry__Group__1();
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
    // $ANTLR end rule__WhereEntry__Group__0


    // $ANTLR start rule__WhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1958:1: rule__WhereEntry__Group__1 : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1962:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1963:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1963:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1964:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1965:1: ( rule__WhereEntry__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1965:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14000);
                    rule__WhereEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group__1


    // $ANTLR start rule__WhereEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1979:1: rule__WhereEntry__Group_1__0 : ( () ) rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1983:1: ( ( () ) rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1984:1: ( () ) rule__WhereEntry__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1984:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1985:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1986:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1988:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04049);
            rule__WhereEntry__Group_1__1();
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
    // $ANTLR end rule__WhereEntry__Group_1__0


    // $ANTLR start rule__WhereEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1999:1: rule__WhereEntry__Group_1__1 : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2003:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2004:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2004:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2005:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2005:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2006:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2007:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2007:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14079);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2010:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2011:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2012:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2012:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14091);
            	    rule__WhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

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
    // $ANTLR end rule__WhereEntry__Group_1__1


    // $ANTLR start rule__WhereEntry__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2027:1: rule__WhereEntry__Group_1_1__0 : ( 'or' ) rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2031:1: ( ( 'or' ) rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2032:1: ( 'or' ) rule__WhereEntry__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2032:1: ( 'or' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2033:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__WhereEntry__Group_1_1__04133); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04143);
            rule__WhereEntry__Group_1_1__1();
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
    // $ANTLR end rule__WhereEntry__Group_1_1__0


    // $ANTLR start rule__WhereEntry__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2047:1: rule__WhereEntry__Group_1_1__1 : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2051:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2052:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2052:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2053:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2054:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2054:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14171);
            rule__WhereEntry__EntriesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1_1__1


    // $ANTLR start rule__AndWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2068:1: rule__AndWhereEntry__Group__0 : ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2072:1: ( ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2073:1: ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2073:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2074:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04209);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04217);
            rule__AndWhereEntry__Group__1();
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
    // $ANTLR end rule__AndWhereEntry__Group__0


    // $ANTLR start rule__AndWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2086:1: rule__AndWhereEntry__Group__1 : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2090:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2091:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2091:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2092:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2093:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2093:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14245);
                    rule__AndWhereEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group__1


    // $ANTLR start rule__AndWhereEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2107:1: rule__AndWhereEntry__Group_1__0 : ( () ) rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2111:1: ( ( () ) rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2112:1: ( () ) rule__AndWhereEntry__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2112:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2113:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2114:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2116:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04294);
            rule__AndWhereEntry__Group_1__1();
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
    // $ANTLR end rule__AndWhereEntry__Group_1__0


    // $ANTLR start rule__AndWhereEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2127:1: rule__AndWhereEntry__Group_1__1 : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2131:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2132:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2132:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2133:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2133:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2134:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2135:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2135:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14324);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2138:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2139:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2140:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==33) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2140:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14336);
            	    rule__AndWhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

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
    // $ANTLR end rule__AndWhereEntry__Group_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2155:1: rule__AndWhereEntry__Group_1_1__0 : ( 'and' ) rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2159:1: ( ( 'and' ) rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2160:1: ( 'and' ) rule__AndWhereEntry__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2160:1: ( 'and' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2161:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__AndWhereEntry__Group_1_1__04378); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04388);
            rule__AndWhereEntry__Group_1_1__1();
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
    // $ANTLR end rule__AndWhereEntry__Group_1_1__0


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2175:1: rule__AndWhereEntry__Group_1_1__1 : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2179:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2180:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2180:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2181:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2182:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2182:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14416);
            rule__AndWhereEntry__EntriesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1


    // $ANTLR start rule__ParWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2196:1: rule__ParWhereEntry__Group__0 : ( '(' ) rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2200:1: ( ( '(' ) rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2201:1: ( '(' ) rule__ParWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2201:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2202:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__ParWhereEntry__Group__04455); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04465);
            rule__ParWhereEntry__Group__1();
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
    // $ANTLR end rule__ParWhereEntry__Group__0


    // $ANTLR start rule__ParWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2216:1: rule__ParWhereEntry__Group__1 : ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2220:1: ( ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2221:1: ( ruleWhereEntry ) rule__ParWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2221:1: ( ruleWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2222:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14493);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14501);
            rule__ParWhereEntry__Group__2();
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
    // $ANTLR end rule__ParWhereEntry__Group__1


    // $ANTLR start rule__ParWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2234:1: rule__ParWhereEntry__Group__2 : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2238:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2239:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2239:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2240:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__ParWhereEntry__Group__24530); 
             after(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__2


    // $ANTLR start rule__DoubleWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2259:1: rule__DoubleWhereEntry__Group__0 : ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 ;
    public final void rule__DoubleWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2263:1: ( ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2264:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2264:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2265:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2266:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2266:2: rule__DoubleWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04571);
            rule__DoubleWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04580);
            rule__DoubleWhereEntry__Group__1();
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
    // $ANTLR end rule__DoubleWhereEntry__Group__0


    // $ANTLR start rule__DoubleWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2277:1: rule__DoubleWhereEntry__Group__1 : ( '.' ) rule__DoubleWhereEntry__Group__2 ;
    public final void rule__DoubleWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2281:1: ( ( '.' ) rule__DoubleWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2282:1: ( '.' ) rule__DoubleWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2282:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2283:1: '.'
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__DoubleWhereEntry__Group__14609); 
             after(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14619);
            rule__DoubleWhereEntry__Group__2();
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
    // $ANTLR end rule__DoubleWhereEntry__Group__1


    // $ANTLR start rule__DoubleWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2297:1: rule__DoubleWhereEntry__Group__2 : ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 ;
    public final void rule__DoubleWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2301:1: ( ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2302:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2302:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2303:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2304:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2304:2: rule__DoubleWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__24647);
            rule__DoubleWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__24656);
            rule__DoubleWhereEntry__Group__3();
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
    // $ANTLR end rule__DoubleWhereEntry__Group__2


    // $ANTLR start rule__DoubleWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2315:1: rule__DoubleWhereEntry__Group__3 : ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 ;
    public final void rule__DoubleWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2319:1: ( ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2320:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2320:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2321:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2322:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2322:2: rule__DoubleWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__34684);
            rule__DoubleWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__34693);
            rule__DoubleWhereEntry__Group__4();
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
    // $ANTLR end rule__DoubleWhereEntry__Group__3


    // $ANTLR start rule__DoubleWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2333:1: rule__DoubleWhereEntry__Group__4 : ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__DoubleWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2337:1: ( ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2338:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2338:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2339:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2340:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2340:2: rule__DoubleWhereEntry__ValueAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__44721);
            rule__DoubleWhereEntry__ValueAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__4


    // $ANTLR start rule__LongWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2360:1: rule__LongWhereEntry__Group__0 : ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 ;
    public final void rule__LongWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2364:1: ( ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2365:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2365:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2366:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2367:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2367:2: rule__LongWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__04765);
            rule__LongWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__04774);
            rule__LongWhereEntry__Group__1();
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
    // $ANTLR end rule__LongWhereEntry__Group__0


    // $ANTLR start rule__LongWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2378:1: rule__LongWhereEntry__Group__1 : ( '.' ) rule__LongWhereEntry__Group__2 ;
    public final void rule__LongWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2382:1: ( ( '.' ) rule__LongWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2383:1: ( '.' ) rule__LongWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2383:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2384:1: '.'
            {
             before(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LongWhereEntry__Group__14803); 
             after(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__14813);
            rule__LongWhereEntry__Group__2();
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
    // $ANTLR end rule__LongWhereEntry__Group__1


    // $ANTLR start rule__LongWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2398:1: rule__LongWhereEntry__Group__2 : ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 ;
    public final void rule__LongWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2402:1: ( ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2403:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2403:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2404:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2405:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2405:2: rule__LongWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__24841);
            rule__LongWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__24850);
            rule__LongWhereEntry__Group__3();
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
    // $ANTLR end rule__LongWhereEntry__Group__2


    // $ANTLR start rule__LongWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2416:1: rule__LongWhereEntry__Group__3 : ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 ;
    public final void rule__LongWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2420:1: ( ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2421:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2421:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2422:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2423:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2423:2: rule__LongWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__34878);
            rule__LongWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__34887);
            rule__LongWhereEntry__Group__4();
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
    // $ANTLR end rule__LongWhereEntry__Group__3


    // $ANTLR start rule__LongWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2434:1: rule__LongWhereEntry__Group__4 : ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__LongWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2438:1: ( ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2439:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2439:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2440:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2441:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2441:2: rule__LongWhereEntry__ValueAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__44915);
            rule__LongWhereEntry__ValueAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__4


    // $ANTLR start rule__VariableWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2461:1: rule__VariableWhereEntry__Group__0 : ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 ;
    public final void rule__VariableWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2465:1: ( ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2466:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2466:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2467:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2468:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2468:2: rule__VariableWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__04959);
            rule__VariableWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__04968);
            rule__VariableWhereEntry__Group__1();
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
    // $ANTLR end rule__VariableWhereEntry__Group__0


    // $ANTLR start rule__VariableWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2479:1: rule__VariableWhereEntry__Group__1 : ( '.' ) rule__VariableWhereEntry__Group__2 ;
    public final void rule__VariableWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2483:1: ( ( '.' ) rule__VariableWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2484:1: ( '.' ) rule__VariableWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2484:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2485:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__VariableWhereEntry__Group__14997); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15007);
            rule__VariableWhereEntry__Group__2();
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
    // $ANTLR end rule__VariableWhereEntry__Group__1


    // $ANTLR start rule__VariableWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2499:1: rule__VariableWhereEntry__Group__2 : ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 ;
    public final void rule__VariableWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2503:1: ( ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2504:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2504:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2505:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2506:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2506:2: rule__VariableWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25035);
            rule__VariableWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25044);
            rule__VariableWhereEntry__Group__3();
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
    // $ANTLR end rule__VariableWhereEntry__Group__2


    // $ANTLR start rule__VariableWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2517:1: rule__VariableWhereEntry__Group__3 : ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 ;
    public final void rule__VariableWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2521:1: ( ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2522:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2522:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2523:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2524:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2524:2: rule__VariableWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35072);
            rule__VariableWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35081);
            rule__VariableWhereEntry__Group__4();
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
    // $ANTLR end rule__VariableWhereEntry__Group__3


    // $ANTLR start rule__VariableWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2535:1: rule__VariableWhereEntry__Group__4 : ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 ;
    public final void rule__VariableWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2539:1: ( ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2540:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2540:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2541:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2542:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2542:2: rule__VariableWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45109);
            rule__VariableWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45118);
            rule__VariableWhereEntry__Group__5();
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
    // $ANTLR end rule__VariableWhereEntry__Group__4


    // $ANTLR start rule__VariableWhereEntry__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2553:1: rule__VariableWhereEntry__Group__5 : ( '.' ) rule__VariableWhereEntry__Group__6 ;
    public final void rule__VariableWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2557:1: ( ( '.' ) rule__VariableWhereEntry__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2558:1: ( '.' ) rule__VariableWhereEntry__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2558:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2559:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__VariableWhereEntry__Group__55147); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55157);
            rule__VariableWhereEntry__Group__6();
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
    // $ANTLR end rule__VariableWhereEntry__Group__5


    // $ANTLR start rule__VariableWhereEntry__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2573:1: rule__VariableWhereEntry__Group__6 : ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) ;
    public final void rule__VariableWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2577:1: ( ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2578:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2578:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2579:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2580:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2580:2: rule__VariableWhereEntry__RightAttributeAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65185);
            rule__VariableWhereEntry__RightAttributeAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__6


    // $ANTLR start rule__StringAttributeWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2604:1: rule__StringAttributeWhereEntry__Group__0 : ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 ;
    public final void rule__StringAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2608:1: ( ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2609:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2609:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2610:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2611:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2611:2: rule__StringAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05233);
            rule__StringAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05242);
            rule__StringAttributeWhereEntry__Group__1();
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__0


    // $ANTLR start rule__StringAttributeWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2622:1: rule__StringAttributeWhereEntry__Group__1 : ( '.' ) rule__StringAttributeWhereEntry__Group__2 ;
    public final void rule__StringAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2626:1: ( ( '.' ) rule__StringAttributeWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2627:1: ( '.' ) rule__StringAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2627:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2628:1: '.'
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__StringAttributeWhereEntry__Group__15271); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15281);
            rule__StringAttributeWhereEntry__Group__2();
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__1


    // $ANTLR start rule__StringAttributeWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2642:1: rule__StringAttributeWhereEntry__Group__2 : ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 ;
    public final void rule__StringAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2646:1: ( ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2647:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2647:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2648:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2649:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2649:2: rule__StringAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25309);
            rule__StringAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25318);
            rule__StringAttributeWhereEntry__Group__3();
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__2


    // $ANTLR start rule__StringAttributeWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2660:1: rule__StringAttributeWhereEntry__Group__3 : ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 ;
    public final void rule__StringAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2664:1: ( ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2665:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2665:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2666:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2667:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2667:2: rule__StringAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35346);
            rule__StringAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35355);
            rule__StringAttributeWhereEntry__Group__4();
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__3


    // $ANTLR start rule__StringAttributeWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2678:1: rule__StringAttributeWhereEntry__Group__4 : ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2682:1: ( ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2683:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2683:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2684:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2685:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2685:2: rule__StringAttributeWhereEntry__PatternAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45383);
            rule__StringAttributeWhereEntry__PatternAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__4


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2705:1: rule__BooleanAttributeWhereEntry__Group__0 : ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 ;
    public final void rule__BooleanAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2709:1: ( ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2710:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2710:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2711:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2712:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2712:2: rule__BooleanAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05427);
            rule__BooleanAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05436);
            rule__BooleanAttributeWhereEntry__Group__1();
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__0


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2723:1: rule__BooleanAttributeWhereEntry__Group__1 : ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 ;
    public final void rule__BooleanAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2727:1: ( ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2728:1: ( '.' ) rule__BooleanAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2728:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2729:1: '.'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__BooleanAttributeWhereEntry__Group__15465); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15475);
            rule__BooleanAttributeWhereEntry__Group__2();
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__1


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2743:1: rule__BooleanAttributeWhereEntry__Group__2 : ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 ;
    public final void rule__BooleanAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2747:1: ( ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2748:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2748:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2749:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2750:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2750:2: rule__BooleanAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25503);
            rule__BooleanAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25512);
            rule__BooleanAttributeWhereEntry__Group__3();
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__2


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2761:1: rule__BooleanAttributeWhereEntry__Group__3 : ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 ;
    public final void rule__BooleanAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2765:1: ( ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2766:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2766:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2767:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2768:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2768:2: rule__BooleanAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35540);
            rule__BooleanAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35549);
            rule__BooleanAttributeWhereEntry__Group__4();
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__3


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2779:1: rule__BooleanAttributeWhereEntry__Group__4 : ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2783:1: ( ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2784:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2784:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2785:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2786:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2786:2: rule__BooleanAttributeWhereEntry__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45577);
            rule__BooleanAttributeWhereEntry__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__4


    // $ANTLR start rule__NullWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2806:1: rule__NullWhereEntry__Group__0 : ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 ;
    public final void rule__NullWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2810:1: ( ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2811:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2811:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2812:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2813:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2813:2: rule__NullWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05621);
            rule__NullWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05630);
            rule__NullWhereEntry__Group__1();
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
    // $ANTLR end rule__NullWhereEntry__Group__0


    // $ANTLR start rule__NullWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2824:1: rule__NullWhereEntry__Group__1 : ( '.' ) rule__NullWhereEntry__Group__2 ;
    public final void rule__NullWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2828:1: ( ( '.' ) rule__NullWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2829:1: ( '.' ) rule__NullWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2829:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2830:1: '.'
            {
             before(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__NullWhereEntry__Group__15659); 
             after(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__15669);
            rule__NullWhereEntry__Group__2();
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
    // $ANTLR end rule__NullWhereEntry__Group__1


    // $ANTLR start rule__NullWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2844:1: rule__NullWhereEntry__Group__2 : ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 ;
    public final void rule__NullWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2848:1: ( ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2849:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2849:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2850:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2851:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2851:2: rule__NullWhereEntry__FeatureAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__25697);
            rule__NullWhereEntry__FeatureAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__25706);
            rule__NullWhereEntry__Group__3();
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
    // $ANTLR end rule__NullWhereEntry__Group__2


    // $ANTLR start rule__NullWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2862:1: rule__NullWhereEntry__Group__3 : ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 ;
    public final void rule__NullWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2866:1: ( ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2867:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2867:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2868:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2869:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2869:2: rule__NullWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__35734);
            rule__NullWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__35743);
            rule__NullWhereEntry__Group__4();
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
    // $ANTLR end rule__NullWhereEntry__Group__3


    // $ANTLR start rule__NullWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2880:1: rule__NullWhereEntry__Group__4 : ( 'null' ) ;
    public final void rule__NullWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2884:1: ( ( 'null' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2885:1: ( 'null' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2885:1: ( 'null' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2886:1: 'null'
            {
             before(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__NullWhereEntry__Group__45772); 
             after(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__4


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2909:1: rule__ReferenceAliasWhereEntry__Group__0 : ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 ;
    public final void rule__ReferenceAliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2913:1: ( ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2914:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2914:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2915:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2916:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2916:2: rule__ReferenceAliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__05817);
            rule__ReferenceAliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__05826);
            rule__ReferenceAliasWhereEntry__Group__1();
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__0


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2927:1: rule__ReferenceAliasWhereEntry__Group__1 : ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 ;
    public final void rule__ReferenceAliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2931:1: ( ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2932:1: ( '.' ) rule__ReferenceAliasWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2932:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2933:1: '.'
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferenceAliasWhereEntry__Group__15855); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__15865);
            rule__ReferenceAliasWhereEntry__Group__2();
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__1


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2947:1: rule__ReferenceAliasWhereEntry__Group__2 : ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 ;
    public final void rule__ReferenceAliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2951:1: ( ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2952:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2952:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2953:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2954:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2954:2: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__25893);
            rule__ReferenceAliasWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__25902);
            rule__ReferenceAliasWhereEntry__Group__3();
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__2


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2965:1: rule__ReferenceAliasWhereEntry__Group__3 : ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 ;
    public final void rule__ReferenceAliasWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2969:1: ( ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2970:1: ( '=' ) rule__ReferenceAliasWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2970:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2971:1: '='
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__35931); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__35941);
            rule__ReferenceAliasWhereEntry__Group__4();
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__3


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2985:1: rule__ReferenceAliasWhereEntry__Group__4 : ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2989:1: ( ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2990:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2990:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2991:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2992:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2992:2: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__45969);
            rule__ReferenceAliasWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__4


    // $ANTLR start rule__SubselectWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3012:1: rule__SubselectWhereEntry__Group__0 : ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 ;
    public final void rule__SubselectWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3016:1: ( ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3017:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3017:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3018:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3019:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3019:2: rule__SubselectWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06013);
            rule__SubselectWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06022);
            rule__SubselectWhereEntry__Group__1();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__0


    // $ANTLR start rule__SubselectWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3030:1: rule__SubselectWhereEntry__Group__1 : ( '.' ) rule__SubselectWhereEntry__Group__2 ;
    public final void rule__SubselectWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3034:1: ( ( '.' ) rule__SubselectWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3035:1: ( '.' ) rule__SubselectWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3035:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3036:1: '.'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__SubselectWhereEntry__Group__16051); 
             after(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16061);
            rule__SubselectWhereEntry__Group__2();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__1


    // $ANTLR start rule__SubselectWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3050:1: rule__SubselectWhereEntry__Group__2 : ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 ;
    public final void rule__SubselectWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3054:1: ( ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3055:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3055:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3056:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3057:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3057:2: rule__SubselectWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26089);
            rule__SubselectWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26098);
            rule__SubselectWhereEntry__Group__3();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__2


    // $ANTLR start rule__SubselectWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3068:1: rule__SubselectWhereEntry__Group__3 : ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 ;
    public final void rule__SubselectWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3072:1: ( ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3073:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3073:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3074:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3075:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3075:2: rule__SubselectWhereEntry__NotInAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36126);
                    rule__SubselectWhereEntry__NotInAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36136);
            rule__SubselectWhereEntry__Group__4();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__3


    // $ANTLR start rule__SubselectWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3086:1: rule__SubselectWhereEntry__Group__4 : ( 'in' ) rule__SubselectWhereEntry__Group__5 ;
    public final void rule__SubselectWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3090:1: ( ( 'in' ) rule__SubselectWhereEntry__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3091:1: ( 'in' ) rule__SubselectWhereEntry__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3091:1: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3092:1: 'in'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__SubselectWhereEntry__Group__46165); 
             after(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46175);
            rule__SubselectWhereEntry__Group__5();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__4


    // $ANTLR start rule__SubselectWhereEntry__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3106:1: rule__SubselectWhereEntry__Group__5 : ( '(' ) rule__SubselectWhereEntry__Group__6 ;
    public final void rule__SubselectWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3110:1: ( ( '(' ) rule__SubselectWhereEntry__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3111:1: ( '(' ) rule__SubselectWhereEntry__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3111:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3112:1: '('
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SubselectWhereEntry__Group__56204); 
             after(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56214);
            rule__SubselectWhereEntry__Group__6();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__5


    // $ANTLR start rule__SubselectWhereEntry__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3126:1: rule__SubselectWhereEntry__Group__6 : ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 ;
    public final void rule__SubselectWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3130:1: ( ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3131:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3131:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3132:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3133:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3133:2: rule__SubselectWhereEntry__SubQueryAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66242);
            rule__SubselectWhereEntry__SubQueryAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66251);
            rule__SubselectWhereEntry__Group__7();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__6


    // $ANTLR start rule__SubselectWhereEntry__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3144:1: rule__SubselectWhereEntry__Group__7 : ( ')' ) ;
    public final void rule__SubselectWhereEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3148:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3149:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3149:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3150:1: ')'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__SubselectWhereEntry__Group__76280); 
             after(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__7


    // $ANTLR start rule__AliasWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3179:1: rule__AliasWhereEntry__Group__0 : ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 ;
    public final void rule__AliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3183:1: ( ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3184:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3184:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3185:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3186:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3186:2: rule__AliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06331);
            rule__AliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06340);
            rule__AliasWhereEntry__Group__1();
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
    // $ANTLR end rule__AliasWhereEntry__Group__0


    // $ANTLR start rule__AliasWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3197:1: rule__AliasWhereEntry__Group__1 : ( '=' ) rule__AliasWhereEntry__Group__2 ;
    public final void rule__AliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3201:1: ( ( '=' ) rule__AliasWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3202:1: ( '=' ) rule__AliasWhereEntry__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3202:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3203:1: '='
            {
             before(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__AliasWhereEntry__Group__16369); 
             after(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16379);
            rule__AliasWhereEntry__Group__2();
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
    // $ANTLR end rule__AliasWhereEntry__Group__1


    // $ANTLR start rule__AliasWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3217:1: rule__AliasWhereEntry__Group__2 : ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) ;
    public final void rule__AliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3221:1: ( ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3222:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3222:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3223:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3224:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3224:2: rule__AliasWhereEntry__RightAliasAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26407);
            rule__AliasWhereEntry__RightAliasAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__2


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3241:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3245:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3246:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3246:1: ( ruleImport )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3247:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06448);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_0


    // $ANTLR start rule__Model__QueryAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3256:1: rule__Model__QueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__QueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3260:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3261:1: ( ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3261:1: ( ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3262:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_rule__Model__QueryAssignment_16479);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__QueryAssignment_1


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3271:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3275:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3276:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3276:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3277:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16510); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3286:1: rule__MQLquery__SelectEntriesAssignment_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3290:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3291:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3291:1: ( ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3292:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_16541);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_1


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3301:1: rule__MQLquery__SelectEntriesAssignment_2_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3305:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3306:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3306:1: ( ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3307:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_16572);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_2_1


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3316:1: rule__MQLquery__FromEntriesAssignment_4 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3320:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3321:1: ( ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3321:1: ( ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3322:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_46603);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_4


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_5_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3331:1: rule__MQLquery__FromEntriesAssignment_5_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3335:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3336:1: ( ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3336:1: ( ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3337:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_16634);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_5_1


    // $ANTLR start rule__MQLquery__WhereEntriesAssignment_6_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3346:1: rule__MQLquery__WhereEntriesAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntriesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3350:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3351:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3351:1: ( ruleWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3352:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntriesAssignment_6_16665);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__WhereEntriesAssignment_6_1


    // $ANTLR start rule__SelectEntry__SelectAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3361:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3365:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3366:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3366:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3367:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3368:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3369:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_06700); 
             after(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__SelectAssignment_0


    // $ANTLR start rule__SelectEntry__AttributeAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3380:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3384:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3385:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3385:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3386:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3387:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3388:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_16739); 
             after(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__AttributeAssignment_1_1


    // $ANTLR start rule__FromEntry__TypeAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3399:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3403:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3404:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3404:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3405:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3406:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3407:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_06778); 
             after(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__TypeAssignment_0


    // $ANTLR start rule__FromEntry__WithoutsubtypesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3418:1: rule__FromEntry__WithoutsubtypesAssignment_1 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3422:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3423:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3423:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3424:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3425:1: ( 'withoutsubtypes' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3426:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__FromEntry__WithoutsubtypesAssignment_16818); 
             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__WithoutsubtypesAssignment_1


    // $ANTLR start rule__FromEntry__AliasAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3441:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3445:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3446:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3446:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3447:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_36857); 
             after(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__AliasAssignment_3


    // $ANTLR start rule__FromEntry__ScopeClauseAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3456:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3460:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3461:1: ( ruleScopeClause )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3461:1: ( ruleScopeClause )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3462:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_46888);
            ruleScopeClause();
            _fsp--;

             after(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__ScopeClauseAssignment_4


    // $ANTLR start rule__ScopeClause__NotInAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3471:1: rule__ScopeClause__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ScopeClause__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3475:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3476:1: ( ( 'not' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3476:1: ( ( 'not' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3477:1: ( 'not' )
            {
             before(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3478:1: ( 'not' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3479:1: 'not'
            {
             before(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__ScopeClause__NotInAssignment_06924); 
             after(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 

            }

             after(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ScopeClause__NotInAssignment_0


    // $ANTLR start rule__ScopeClause__ScopeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3494:1: rule__ScopeClause__ScopeAssignment_2 : ( ruleScope ) ;
    public final void rule__ScopeClause__ScopeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3498:1: ( ( ruleScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3499:1: ( ruleScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3499:1: ( ruleScope )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3500:1: ruleScope
            {
             before(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_rule__ScopeClause__ScopeAssignment_26963);
            ruleScope();
            _fsp--;

             after(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ScopeClause__ScopeAssignment_2


    // $ANTLR start rule__ResourceScope__UrisAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3509:1: rule__ResourceScope__UrisAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3513:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3514:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3514:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3515:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_26994); 
             after(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__UrisAssignment_2


    // $ANTLR start rule__ResourceScope__UrisAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3524:1: rule__ResourceScope__UrisAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3528:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3529:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3529:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3530:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_3_17025); 
             after(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__UrisAssignment_3_1


    // $ANTLR start rule__ElementScope__UrisAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3539:1: rule__ElementScope__UrisAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3543:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3544:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3544:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3545:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_27056); 
             after(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__UrisAssignment_2


    // $ANTLR start rule__ElementScope__UrisAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3554:1: rule__ElementScope__UrisAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3558:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3559:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3559:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3560:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_3_17087); 
             after(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__UrisAssignment_3_1


    // $ANTLR start rule__WhereEntry__EntriesAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3569:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3573:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3574:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3574:1: ( ruleAndWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3575:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17118);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__EntriesAssignment_1_1_1


    // $ANTLR start rule__AndWhereEntry__EntriesAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3584:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3588:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3589:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3589:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3590:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17149);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__EntriesAssignment_1_1_1


    // $ANTLR start rule__DoubleWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3599:1: rule__DoubleWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3603:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3604:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3604:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3605:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3606:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3607:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07184); 
             after(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__AliasAssignment_0


    // $ANTLR start rule__DoubleWhereEntry__AttributeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3618:1: rule__DoubleWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3622:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3623:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3623:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3624:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3625:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3626:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27223); 
             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__DoubleWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3637:1: rule__DoubleWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__DoubleWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3641:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3642:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3642:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3643:1: ruleNumericOperator
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37258);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__DoubleWhereEntry__ValueAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3652:1: rule__DoubleWhereEntry__ValueAssignment_4 : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3656:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3657:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3657:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3658:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 
            match(input,RULE_SIGNED_DOUBLE,FollowSets000.FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47289); 
             after(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__ValueAssignment_4


    // $ANTLR start rule__LongWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3667:1: rule__LongWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3671:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3672:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3672:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3673:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3674:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3675:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07324); 
             after(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__AliasAssignment_0


    // $ANTLR start rule__LongWhereEntry__AttributeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3686:1: rule__LongWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3690:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3691:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3691:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3692:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3693:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3694:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27363); 
             after(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__LongWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3705:1: rule__LongWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__LongWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3709:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3710:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3710:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3711:1: ruleNumericOperator
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37398);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__LongWhereEntry__ValueAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3720:1: rule__LongWhereEntry__ValueAssignment_4 : ( RULE_SINGED_LONG ) ;
    public final void rule__LongWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3724:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3725:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3725:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3726:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 
            match(input,RULE_SINGED_LONG,FollowSets000.FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47429); 
             after(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__ValueAssignment_4


    // $ANTLR start rule__VariableWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3735:1: rule__VariableWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3739:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3740:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3740:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3741:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3742:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3743:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07464); 
             after(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__AliasAssignment_0


    // $ANTLR start rule__VariableWhereEntry__AttributeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3754:1: rule__VariableWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3758:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3759:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3759:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3760:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3761:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3762:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27503); 
             after(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__VariableWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3773:1: rule__VariableWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__VariableWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3777:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3778:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3778:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3779:1: ruleNumericOperator
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_37538);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__VariableWhereEntry__RightAliasAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3788:1: rule__VariableWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3792:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3793:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3793:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3794:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3795:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3796:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_47573); 
             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__RightAliasAssignment_4


    // $ANTLR start rule__VariableWhereEntry__RightAttributeAssignment_6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3807:1: rule__VariableWhereEntry__RightAttributeAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAttributeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3811:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3812:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3812:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3813:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3814:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3815:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_67612); 
             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__RightAttributeAssignment_6


    // $ANTLR start rule__StringAttributeWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3826:1: rule__StringAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3830:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3831:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3831:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3832:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3833:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3834:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_07651); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__AliasAssignment_0


    // $ANTLR start rule__StringAttributeWhereEntry__AttributeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3845:1: rule__StringAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3849:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3850:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3850:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3851:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3852:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3853:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_27690); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__StringAttributeWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3864:1: rule__StringAttributeWhereEntry__OperatorAssignment_3 : ( ruleStringOperator ) ;
    public final void rule__StringAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3868:1: ( ( ruleStringOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3869:1: ( ruleStringOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3869:1: ( ruleStringOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3870:1: ruleStringOperator
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_37725);
            ruleStringOperator();
            _fsp--;

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__StringAttributeWhereEntry__PatternAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3879:1: rule__StringAttributeWhereEntry__PatternAssignment_4 : ( RULE_STRING ) ;
    public final void rule__StringAttributeWhereEntry__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3883:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3884:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3884:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3885:1: RULE_STRING
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_47756); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__PatternAssignment_4


    // $ANTLR start rule__BooleanAttributeWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3894:1: rule__BooleanAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3898:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3899:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3899:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3900:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3901:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3902:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_07791); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__AliasAssignment_0


    // $ANTLR start rule__BooleanAttributeWhereEntry__AttributeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3913:1: rule__BooleanAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3917:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3918:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3918:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3919:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3920:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3921:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_27830); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__BooleanAttributeWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3932:1: rule__BooleanAttributeWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__BooleanAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3936:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3937:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3937:1: ( ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3938:1: ruleBooleanOperator
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_37865);
            ruleBooleanOperator();
            _fsp--;

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3947:1: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3951:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3952:1: ( ( 'true' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3952:1: ( ( 'true' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3953:1: ( 'true' )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3954:1: ( 'true' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3955:1: 'true'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_07901); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0


    // $ANTLR start rule__NullWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3970:1: rule__NullWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3974:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3975:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3975:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3976:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3977:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3978:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_07944); 
             after(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__AliasAssignment_0


    // $ANTLR start rule__NullWhereEntry__FeatureAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3989:1: rule__NullWhereEntry__FeatureAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3993:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3994:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3994:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3995:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3996:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3997:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_27983); 
             after(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__FeatureAssignment_2


    // $ANTLR start rule__NullWhereEntry__OperatorAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4008:1: rule__NullWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__NullWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4012:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4013:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4013:1: ( ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4014:1: ruleBooleanOperator
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38018);
            ruleBooleanOperator();
            _fsp--;

             after(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__ReferenceAliasWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4023:1: rule__ReferenceAliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4027:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4028:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4028:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4029:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4030:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4031:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08053); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__AliasAssignment_0


    // $ANTLR start rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4042:1: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4046:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4047:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4047:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4048:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4049:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4050:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28092); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__ReferenceAssignment_2


    // $ANTLR start rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4061:1: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4065:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4066:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4066:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4067:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4068:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4069:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48131); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__RightAliasAssignment_4


    // $ANTLR start rule__SubselectWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4080:1: rule__SubselectWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4084:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4085:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4085:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4086:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4087:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4088:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08170); 
             after(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__AliasAssignment_0


    // $ANTLR start rule__SubselectWhereEntry__ReferenceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4099:1: rule__SubselectWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4103:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4104:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4104:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4105:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4106:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4107:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28209); 
             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__ReferenceAssignment_2


    // $ANTLR start rule__SubselectWhereEntry__NotInAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4118:1: rule__SubselectWhereEntry__NotInAssignment_3 : ( ( 'not' ) ) ;
    public final void rule__SubselectWhereEntry__NotInAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4122:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4123:1: ( ( 'not' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4123:1: ( ( 'not' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4124:1: ( 'not' )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4125:1: ( 'not' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4126:1: 'not'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__SubselectWhereEntry__NotInAssignment_38249); 
             after(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__NotInAssignment_3


    // $ANTLR start rule__SubselectWhereEntry__SubQueryAssignment_6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4141:1: rule__SubselectWhereEntry__SubQueryAssignment_6 : ( ruleMQLquery ) ;
    public final void rule__SubselectWhereEntry__SubQueryAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4145:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4146:1: ( ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4146:1: ( ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4147:1: ruleMQLquery
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68288);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__SubQueryAssignment_6


    // $ANTLR start rule__AliasWhereEntry__AliasAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4156:1: rule__AliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4160:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4161:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4161:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4162:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4163:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4164:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08323); 
             after(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__AliasAssignment_0


    // $ANTLR start rule__AliasWhereEntry__RightAliasAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4175:1: rule__AliasWhereEntry__RightAliasAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__RightAliasAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4179:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4180:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4180:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4181:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4182:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4183:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28362); 
             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__RightAliasAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__0_in_ruleMQLquery214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group__0_in_ruleSelectEntry274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__0_in_ruleFromEntry334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__0_in_ruleScopeClause394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScope_in_entryRuleScope421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScope428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Scope__Alternatives_in_ruleScope454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__0_in_ruleResourceScope514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElementScope548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__0_in_ruleElementScope574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group__0_in_ruleWhereEntry634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0_in_ruleAndWhereEntry694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConcreteWhereEntry__Alternatives_in_ruleConcreteWhereEntry754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0_in_ruleParWhereEntry814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry1028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry1448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_rule__Scope__Alternatives1618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_rule__Scope__Alternatives1635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_41916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_41935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives1970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives1991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives2075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__StringOperator__Alternatives2111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__StringOperator__Alternatives2132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__StringOperator__Alternatives2153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__StringOperator__Alternatives2174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__BooleanOperator__Alternatives2210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__BooleanOperator__Alternatives2231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02268 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__QueryAssignment_1_in_rule__Model__Group__12306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Import__Group__02345 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MQLquery__Group__02422 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12460 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22497 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MQLquery__Group__32536 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42574 = new BitSet(new long[]{0x0000000001800002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52611 = new BitSet(new long[]{0x0000000001800002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MQLquery__Group_2__02699 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MQLquery__Group_5__02776 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__12814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_6__02853 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__02863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__12893 = new BitSet(new long[]{0x0000000400000022L});
        public static final BitSet FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__12905 = new BitSet(new long[]{0x0000000400000022L});
        public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__02946 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__02955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__12983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SelectEntry__Group_1__03023 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03099 = new BitSet(new long[]{0x0000002004000000L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13136 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__FromEntry__Group__23175 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33213 = new BitSet(new long[]{0x0000004008000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__NotInAssignment_0_in_rule__ScopeClause__Group__03295 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__1_in_rule__ScopeClause__Group__03305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ScopeClause__Group__13334 = new BitSet(new long[]{0x0000000090000000L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__2_in_rule__ScopeClause__Group__13344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__ScopeAssignment_2_in_rule__ScopeClause__Group__23372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ResourceScope__Group__03413 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ResourceScope__Group__13452 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_2_in_rule__ResourceScope__Group__23490 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__0_in_rule__ResourceScope__Group__33527 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__43566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ResourceScope__Group_3__03612 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__1_in_rule__ResourceScope__Group_3__03622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_3_1_in_rule__ResourceScope__Group_3__13650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__03689 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ElementScope__Group__13728 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_2_in_rule__ElementScope__Group__23766 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__0_in_rule__ElementScope__Group__33803 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__33813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__43842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ElementScope__Group_3__03888 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__1_in_rule__ElementScope__Group_3__03898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_3_1_in_rule__ElementScope__Group_3__13926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__03964 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__03972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14079 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14091 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_rule__WhereEntry__Group_1_1__04133 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04209 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14324 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14336 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_rule__AndWhereEntry__Group_1_1__04378 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ParWhereEntry__Group__04455 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14493 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ParWhereEntry__Group__24530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04571 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__DoubleWhereEntry__Group__14609 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__24647 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__24656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__34684 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__34693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__44721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__04765 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__04774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LongWhereEntry__Group__14803 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__14813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__24841 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__24850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__34878 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__34887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__44915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__04959 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__04968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__VariableWhereEntry__Group__14997 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25035 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35072 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45109 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__VariableWhereEntry__Group__55147 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05233 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__StringAttributeWhereEntry__Group__15271 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25309 = new BitSet(new long[]{0x00000000000F0000L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35346 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05427 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__BooleanAttributeWhereEntry__Group__15465 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25503 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35540 = new BitSet(new long[]{0x0000008000000800L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05621 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__NullWhereEntry__Group__15659 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__15669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__25697 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__25706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__35734 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__35743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__NullWhereEntry__Group__45772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__05817 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__05826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferenceAliasWhereEntry__Group__15855 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__15865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__25893 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__25902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__35931 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__35941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__45969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06013 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SubselectWhereEntry__Group__16051 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26089 = new BitSet(new long[]{0x0000004008000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36126 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SubselectWhereEntry__Group__46165 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SubselectWhereEntry__Group__56204 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66242 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SubselectWhereEntry__Group__76280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06331 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__AliasWhereEntry__Group__16369 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__QueryAssignment_16479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_16541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_16572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_46603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_16634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntriesAssignment_6_16665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_06700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_16739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_06778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__FromEntry__WithoutsubtypesAssignment_16818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_36857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_46888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ScopeClause__NotInAssignment_06924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScope_in_rule__ScopeClause__ScopeAssignment_26963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_26994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_3_17025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_27056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_3_17087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_37538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_47573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_67612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_07651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_27690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_37725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_47756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_07791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_27830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_37865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_07901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_07944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_27983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SubselectWhereEntry__NotInAssignment_38249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28362 = new BitSet(new long[]{0x0000000000000002L});
    }


}