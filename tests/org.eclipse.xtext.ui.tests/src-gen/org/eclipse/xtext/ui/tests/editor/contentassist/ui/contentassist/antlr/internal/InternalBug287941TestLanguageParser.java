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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug287941TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:76:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:77:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:77:2: rule__Model__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:89:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:90:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:91:1: ruleImport EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:98:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:102:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:103:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:103:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:104:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:105:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:105:2: rule__Import__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:117:1: entryRuleMQLquery : ruleMQLquery EOF ;
    public final void entryRuleMQLquery() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:118:1: ( ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:119:1: ruleMQLquery EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:126:1: ruleMQLquery : ( ( rule__MQLquery__Group__0 ) ) ;
    public final void ruleMQLquery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:130:2: ( ( ( rule__MQLquery__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:131:1: ( ( rule__MQLquery__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:131:1: ( ( rule__MQLquery__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:132:1: ( rule__MQLquery__Group__0 )
            {
             before(grammarAccess.getMQLqueryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:133:1: ( rule__MQLquery__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:133:2: rule__MQLquery__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:145:1: entryRuleSelectEntry : ruleSelectEntry EOF ;
    public final void entryRuleSelectEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:146:1: ( ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:147:1: ruleSelectEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:154:1: ruleSelectEntry : ( ( rule__SelectEntry__Group__0 ) ) ;
    public final void ruleSelectEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:158:2: ( ( ( rule__SelectEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:159:1: ( ( rule__SelectEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:159:1: ( ( rule__SelectEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:160:1: ( rule__SelectEntry__Group__0 )
            {
             before(grammarAccess.getSelectEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:161:1: ( rule__SelectEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:161:2: rule__SelectEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:173:1: entryRuleFromEntry : ruleFromEntry EOF ;
    public final void entryRuleFromEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:174:1: ( ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:175:1: ruleFromEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:182:1: ruleFromEntry : ( ( rule__FromEntry__Group__0 ) ) ;
    public final void ruleFromEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:186:2: ( ( ( rule__FromEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:187:1: ( ( rule__FromEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:187:1: ( ( rule__FromEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:188:1: ( rule__FromEntry__Group__0 )
            {
             before(grammarAccess.getFromEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:189:1: ( rule__FromEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:189:2: rule__FromEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:201:1: entryRuleScopeClause : ruleScopeClause EOF ;
    public final void entryRuleScopeClause() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:202:1: ( ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:203:1: ruleScopeClause EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:210:1: ruleScopeClause : ( ( rule__ScopeClause__Group__0 ) ) ;
    public final void ruleScopeClause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:214:2: ( ( ( rule__ScopeClause__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:215:1: ( ( rule__ScopeClause__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:215:1: ( ( rule__ScopeClause__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:216:1: ( rule__ScopeClause__Group__0 )
            {
             before(grammarAccess.getScopeClauseAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:217:1: ( rule__ScopeClause__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:217:2: rule__ScopeClause__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:229:1: entryRuleScope : ruleScope EOF ;
    public final void entryRuleScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:230:1: ( ruleScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:231:1: ruleScope EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:238:1: ruleScope : ( ( rule__Scope__Alternatives ) ) ;
    public final void ruleScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:242:2: ( ( ( rule__Scope__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:243:1: ( ( rule__Scope__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:243:1: ( ( rule__Scope__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:244:1: ( rule__Scope__Alternatives )
            {
             before(grammarAccess.getScopeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:245:1: ( rule__Scope__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:245:2: rule__Scope__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:257:1: entryRuleResourceScope : ruleResourceScope EOF ;
    public final void entryRuleResourceScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:258:1: ( ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:259:1: ruleResourceScope EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:266:1: ruleResourceScope : ( ( rule__ResourceScope__Group__0 ) ) ;
    public final void ruleResourceScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:270:2: ( ( ( rule__ResourceScope__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:271:1: ( ( rule__ResourceScope__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:271:1: ( ( rule__ResourceScope__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:272:1: ( rule__ResourceScope__Group__0 )
            {
             before(grammarAccess.getResourceScopeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:273:1: ( rule__ResourceScope__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:273:2: rule__ResourceScope__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:285:1: entryRuleElementScope : ruleElementScope EOF ;
    public final void entryRuleElementScope() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:286:1: ( ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:287:1: ruleElementScope EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:294:1: ruleElementScope : ( ( rule__ElementScope__Group__0 ) ) ;
    public final void ruleElementScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:298:2: ( ( ( rule__ElementScope__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:299:1: ( ( rule__ElementScope__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:299:1: ( ( rule__ElementScope__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:300:1: ( rule__ElementScope__Group__0 )
            {
             before(grammarAccess.getElementScopeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:301:1: ( rule__ElementScope__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:301:2: rule__ElementScope__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:313:1: entryRuleWhereEntry : ruleWhereEntry EOF ;
    public final void entryRuleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:314:1: ( ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:315:1: ruleWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:322:1: ruleWhereEntry : ( ( rule__WhereEntry__Group__0 ) ) ;
    public final void ruleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:326:2: ( ( ( rule__WhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:327:1: ( ( rule__WhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:327:1: ( ( rule__WhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:328:1: ( rule__WhereEntry__Group__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:329:1: ( rule__WhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:329:2: rule__WhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:341:1: entryRuleAndWhereEntry : ruleAndWhereEntry EOF ;
    public final void entryRuleAndWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:342:1: ( ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:343:1: ruleAndWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:350:1: ruleAndWhereEntry : ( ( rule__AndWhereEntry__Group__0 ) ) ;
    public final void ruleAndWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:354:2: ( ( ( rule__AndWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:355:1: ( ( rule__AndWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:355:1: ( ( rule__AndWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:356:1: ( rule__AndWhereEntry__Group__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:357:1: ( rule__AndWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:357:2: rule__AndWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:369:1: entryRuleConcreteWhereEntry : ruleConcreteWhereEntry EOF ;
    public final void entryRuleConcreteWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:370:1: ( ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:371:1: ruleConcreteWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:378:1: ruleConcreteWhereEntry : ( ( rule__ConcreteWhereEntry__Alternatives ) ) ;
    public final void ruleConcreteWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:382:2: ( ( ( rule__ConcreteWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:383:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:383:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:384:1: ( rule__ConcreteWhereEntry__Alternatives )
            {
             before(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:385:1: ( rule__ConcreteWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:385:2: rule__ConcreteWhereEntry__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:397:1: entryRuleParWhereEntry : ruleParWhereEntry EOF ;
    public final void entryRuleParWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:398:1: ( ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:399:1: ruleParWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:406:1: ruleParWhereEntry : ( ( rule__ParWhereEntry__Group__0 ) ) ;
    public final void ruleParWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:410:2: ( ( ( rule__ParWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:411:1: ( ( rule__ParWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:411:1: ( ( rule__ParWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:412:1: ( rule__ParWhereEntry__Group__0 )
            {
             before(grammarAccess.getParWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:413:1: ( rule__ParWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:413:2: rule__ParWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:425:1: entryRuleAttributeWhereEntry : ruleAttributeWhereEntry EOF ;
    public final void entryRuleAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:426:1: ( ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:427:1: ruleAttributeWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:434:1: ruleAttributeWhereEntry : ( ( rule__AttributeWhereEntry__Alternatives ) ) ;
    public final void ruleAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:438:2: ( ( ( rule__AttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:439:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:439:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:440:1: ( rule__AttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:441:1: ( rule__AttributeWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:441:2: rule__AttributeWhereEntry__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:453:1: entryRuleNumericAttributeWhereEntry : ruleNumericAttributeWhereEntry EOF ;
    public final void entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:454:1: ( ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:455:1: ruleNumericAttributeWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:462:1: ruleNumericAttributeWhereEntry : ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) ;
    public final void ruleNumericAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:466:2: ( ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:467:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:467:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:468:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:469:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:469:2: rule__NumericAttributeWhereEntry__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:481:1: entryRuleDoubleWhereEntry : ruleDoubleWhereEntry EOF ;
    public final void entryRuleDoubleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:482:1: ( ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:483:1: ruleDoubleWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:490:1: ruleDoubleWhereEntry : ( ( rule__DoubleWhereEntry__Group__0 ) ) ;
    public final void ruleDoubleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:494:2: ( ( ( rule__DoubleWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:495:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:495:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:496:1: ( rule__DoubleWhereEntry__Group__0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:497:1: ( rule__DoubleWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:497:2: rule__DoubleWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:509:1: entryRuleLongWhereEntry : ruleLongWhereEntry EOF ;
    public final void entryRuleLongWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:510:1: ( ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:511:1: ruleLongWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:518:1: ruleLongWhereEntry : ( ( rule__LongWhereEntry__Group__0 ) ) ;
    public final void ruleLongWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:522:2: ( ( ( rule__LongWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:523:1: ( ( rule__LongWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:523:1: ( ( rule__LongWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:524:1: ( rule__LongWhereEntry__Group__0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:525:1: ( rule__LongWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:525:2: rule__LongWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:537:1: entryRuleVariableWhereEntry : ruleVariableWhereEntry EOF ;
    public final void entryRuleVariableWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:538:1: ( ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:539:1: ruleVariableWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:546:1: ruleVariableWhereEntry : ( ( rule__VariableWhereEntry__Group__0 ) ) ;
    public final void ruleVariableWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:550:2: ( ( ( rule__VariableWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:551:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:551:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:552:1: ( rule__VariableWhereEntry__Group__0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:553:1: ( rule__VariableWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:553:2: rule__VariableWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:565:1: entryRuleStringAttributeWhereEntry : ruleStringAttributeWhereEntry EOF ;
    public final void entryRuleStringAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:566:1: ( ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:567:1: ruleStringAttributeWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:574:1: ruleStringAttributeWhereEntry : ( ( rule__StringAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleStringAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:578:2: ( ( ( rule__StringAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:579:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:579:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:580:1: ( rule__StringAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:581:1: ( rule__StringAttributeWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:581:2: rule__StringAttributeWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:593:1: entryRuleBooleanAttributeWhereEntry : ruleBooleanAttributeWhereEntry EOF ;
    public final void entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:594:1: ( ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:595:1: ruleBooleanAttributeWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:602:1: ruleBooleanAttributeWhereEntry : ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleBooleanAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:606:2: ( ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:607:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:607:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:608:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:609:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:609:2: rule__BooleanAttributeWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:621:1: entryRuleNullWhereEntry : ruleNullWhereEntry EOF ;
    public final void entryRuleNullWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:622:1: ( ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:623:1: ruleNullWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:630:1: ruleNullWhereEntry : ( ( rule__NullWhereEntry__Group__0 ) ) ;
    public final void ruleNullWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:634:2: ( ( ( rule__NullWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:635:1: ( ( rule__NullWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:635:1: ( ( rule__NullWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:636:1: ( rule__NullWhereEntry__Group__0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:637:1: ( rule__NullWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:637:2: rule__NullWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:649:1: entryRuleReferenceAliasWhereEntry : ruleReferenceAliasWhereEntry EOF ;
    public final void entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:650:1: ( ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:651:1: ruleReferenceAliasWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:658:1: ruleReferenceAliasWhereEntry : ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) ;
    public final void ruleReferenceAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:662:2: ( ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:663:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:663:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:664:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:665:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:665:2: rule__ReferenceAliasWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:677:1: entryRuleSubselectWhereEntry : ruleSubselectWhereEntry EOF ;
    public final void entryRuleSubselectWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:678:1: ( ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:679:1: ruleSubselectWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:686:1: ruleSubselectWhereEntry : ( ( rule__SubselectWhereEntry__Group__0 ) ) ;
    public final void ruleSubselectWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:690:2: ( ( ( rule__SubselectWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:691:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:691:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:692:1: ( rule__SubselectWhereEntry__Group__0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:693:1: ( rule__SubselectWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:693:2: rule__SubselectWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:705:1: entryRuleAliasWhereEntry : ruleAliasWhereEntry EOF ;
    public final void entryRuleAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:706:1: ( ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:707:1: ruleAliasWhereEntry EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:714:1: ruleAliasWhereEntry : ( ( rule__AliasWhereEntry__Group__0 ) ) ;
    public final void ruleAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:718:2: ( ( ( rule__AliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:719:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:719:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:720:1: ( rule__AliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:721:1: ( rule__AliasWhereEntry__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:721:2: rule__AliasWhereEntry__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:734:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:738:1: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:739:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:739:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:740:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:741:1: ( rule__NumericOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:741:2: rule__NumericOperator__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:753:1: ruleStringOperator : ( ( rule__StringOperator__Alternatives ) ) ;
    public final void ruleStringOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:757:1: ( ( ( rule__StringOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:758:1: ( ( rule__StringOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:758:1: ( ( rule__StringOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:759:1: ( rule__StringOperator__Alternatives )
            {
             before(grammarAccess.getStringOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:760:1: ( rule__StringOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:760:2: rule__StringOperator__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:772:1: ruleBooleanOperator : ( ( rule__BooleanOperator__Alternatives ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:776:1: ( ( ( rule__BooleanOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:777:1: ( ( rule__BooleanOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:777:1: ( ( rule__BooleanOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:778:1: ( rule__BooleanOperator__Alternatives )
            {
             before(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:779:1: ( rule__BooleanOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:779:2: rule__BooleanOperator__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:790:1: rule__Scope__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__Scope__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:794:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
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
                    new NoViableAltException("790:1: rule__Scope__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:795:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:795:1: ( ruleResourceScope )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:796:1: ruleResourceScope
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:801:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:801:6: ( ruleElementScope )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:802:1: ruleElementScope
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:816:1: ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) )
            int alt2=6;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==34) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==16) ) {
                    alt2=5;
                }
                else if ( (LA2_2==25) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==RULE_ID) ) {
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

                                if ( (LA2_11==EOF||LA2_11==RULE_ID||(LA2_11>=32 && LA2_11<=35)) ) {
                                    alt2=4;
                                }
                                else if ( (LA2_11==25) ) {
                                    alt2=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 11, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            int LA2_7 = input.LA(5);

                            if ( (LA2_7==36) ) {
                                alt2=3;
                            }
                            else if ( ((LA2_7>=RULE_STRING && LA2_7<=RULE_SINGED_LONG)||LA2_7==11||LA2_7==39) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 7, input);

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
                                new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("812:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleNullWhereEntry ) | ( ruleReferenceAliasWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:817:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:817:1: ( ruleParWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:818:1: ruleParWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:823:6: ( ruleAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:823:6: ( ruleAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:824:1: ruleAttributeWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:829:6: ( ruleNullWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:829:6: ( ruleNullWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:830:1: ruleNullWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:835:6: ( ruleReferenceAliasWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:835:6: ( ruleReferenceAliasWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:836:1: ruleReferenceAliasWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:841:6: ( ruleAliasWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:841:6: ( ruleAliasWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:842:1: ruleAliasWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:847:6: ( ruleSubselectWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:847:6: ( ruleSubselectWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:848:1: ruleSubselectWhereEntry
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );
    public final void rule__AttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:862:1: ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==25) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA3_4 = input.LA(5);

                            if ( (LA3_4==RULE_ID) ) {
                                alt3=4;
                            }
                            else if ( ((LA3_4>=RULE_SIGNED_DOUBLE && LA3_4<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA3_5 = input.LA(5);

                            if ( ((LA3_5>=RULE_SIGNED_DOUBLE && LA3_5<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_5==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA3_6 = input.LA(5);

                            if ( (LA3_6==RULE_ID) ) {
                                alt3=4;
                            }
                            else if ( ((LA3_6>=RULE_SIGNED_DOUBLE && LA3_6<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
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
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            switch ( input.LA(5) ) {
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
                            case RULE_STRING:
                                {
                                alt3=2;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 8, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                alt3=4;
                                }
                                break;
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
                            case 11:
                            case 39:
                                {
                                alt3=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 9, input);

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
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("858:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:863:1: ( ruleNumericAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:863:1: ( ruleNumericAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:864:1: ruleNumericAttributeWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:869:6: ( ruleStringAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:869:6: ( ruleStringAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:870:1: ruleStringAttributeWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:875:6: ( ruleBooleanAttributeWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:875:6: ( ruleBooleanAttributeWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:876:1: ruleBooleanAttributeWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:881:6: ( ruleVariableWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:881:6: ( ruleVariableWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:882:1: ruleVariableWhereEntry
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );
    public final void rule__NumericAttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:896:1: ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) )
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
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA4_5 = input.LA(5);

                            if ( (LA4_5==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_5==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 5, input);

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
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA4_7 = input.LA(5);

                            if ( (LA4_7==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_7==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            int LA4_8 = input.LA(5);

                            if ( (LA4_8==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_8==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA4_9 = input.LA(5);

                            if ( (LA4_9==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_9==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("892:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:897:1: ( ruleDoubleWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:897:1: ( ruleDoubleWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:898:1: ruleDoubleWhereEntry
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:903:6: ( ruleLongWhereEntry )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:903:6: ( ruleLongWhereEntry )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:904:1: ruleLongWhereEntry
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:914:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );
    public final void rule__BooleanAttributeWhereEntry__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:918:1: ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) )
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
                    new NoViableAltException("914:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:919:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:919:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:920:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:921:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:921:2: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:925:6: ( 'false' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:925:6: ( 'false' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:926:1: 'false'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:938:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:942:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) )
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
                    new NoViableAltException("938:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:943:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:943:1: ( ( '<' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:944:1: ( '<' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:945:1: ( '<' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:945:3: '<'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__NumericOperator__Alternatives1970); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:950:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:950:6: ( ( '>' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:951:1: ( '>' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:952:1: ( '>' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:952:3: '>'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__NumericOperator__Alternatives1991); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:957:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:957:6: ( ( '<=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:958:1: ( '<=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:959:1: ( '<=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:959:3: '<='
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__NumericOperator__Alternatives2012); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:964:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:964:6: ( ( '>=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:965:1: ( '>=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:966:1: ( '>=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:966:3: '>='
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__NumericOperator__Alternatives2033); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:971:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:971:6: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:972:1: ( '=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:973:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:973:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__NumericOperator__Alternatives2054); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:978:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:978:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:979:1: ( '!=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:980:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:980:3: '!='
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:990:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );
    public final void rule__StringOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:994:1: ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) )
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
                    new NoViableAltException("990:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:995:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:995:1: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:996:1: ( '=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:997:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:997:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__StringOperator__Alternatives2111); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1002:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1002:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1003:1: ( '!=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1004:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1004:3: '!='
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__StringOperator__Alternatives2132); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1009:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1009:6: ( ( 'like' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1010:1: ( 'like' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1011:1: ( 'like' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1011:3: 'like'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__StringOperator__Alternatives2153); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1016:6: ( ( 'notlike' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1016:6: ( ( 'notlike' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1017:1: ( 'notlike' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1018:1: ( 'notlike' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1018:3: 'notlike'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1028:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__BooleanOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1032:1: ( ( ( '=' ) ) | ( ( '!=' ) ) )
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
                    new NoViableAltException("1028:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1033:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1033:1: ( ( '=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1034:1: ( '=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1035:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1035:3: '='
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__BooleanOperator__Alternatives2210); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1040:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1040:6: ( ( '!=' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1041:1: ( '!=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1042:1: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1042:3: '!='
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1054:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1058:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1059:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02264);
            rule__Model__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02267);
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


    // $ANTLR start rule__Model__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1066:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1070:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1071:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1071:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1072:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1073:1: ( rule__Model__ImportsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1073:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl2294);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0__Impl


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1083:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1087:1: ( rule__Model__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1088:2: rule__Model__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12325);
            rule__Model__Group__1__Impl();
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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1094:1: rule__Model__Group__1__Impl : ( ( rule__Model__QueryAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1098:1: ( ( ( rule__Model__QueryAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1099:1: ( ( rule__Model__QueryAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1099:1: ( ( rule__Model__QueryAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1100:1: ( rule__Model__QueryAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getQueryAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1101:1: ( rule__Model__QueryAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1101:2: rule__Model__QueryAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__QueryAssignment_1_in_rule__Model__Group__1__Impl2352);
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
    // $ANTLR end rule__Model__Group__1__Impl


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1115:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1119:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1120:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02386);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02389);
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


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1127:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1131:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1132:1: ( 'import' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1132:1: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1133:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Import__Group__0__Impl2417); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0__Impl


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1146:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1150:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1151:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12448);
            rule__Import__Group__1__Impl();
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1157:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1161:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1162:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1162:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1163:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1164:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1164:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl2475);
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
    // $ANTLR end rule__Import__Group__1__Impl


    // $ANTLR start rule__MQLquery__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1178:1: rule__MQLquery__Group__0 : rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1182:1: ( rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1183:2: rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02509);
            rule__MQLquery__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02512);
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


    // $ANTLR start rule__MQLquery__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1190:1: rule__MQLquery__Group__0__Impl : ( 'select' ) ;
    public final void rule__MQLquery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1194:1: ( ( 'select' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1195:1: ( 'select' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1195:1: ( 'select' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1196:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MQLquery__Group__0__Impl2540); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__0__Impl


    // $ANTLR start rule__MQLquery__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1209:1: rule__MQLquery__Group__1 : rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1213:1: ( rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1214:2: rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12571);
            rule__MQLquery__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12574);
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


    // $ANTLR start rule__MQLquery__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1221:1: rule__MQLquery__Group__1__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) ;
    public final void rule__MQLquery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1225:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1226:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1226:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1227:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1228:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1228:2: rule__MQLquery__SelectEntriesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2601);
            rule__MQLquery__SelectEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__1__Impl


    // $ANTLR start rule__MQLquery__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1238:1: rule__MQLquery__Group__2 : rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1242:1: ( rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1243:2: rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22631);
            rule__MQLquery__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22634);
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


    // $ANTLR start rule__MQLquery__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1250:1: rule__MQLquery__Group__2__Impl : ( ( rule__MQLquery__Group_2__0 )* ) ;
    public final void rule__MQLquery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1254:1: ( ( ( rule__MQLquery__Group_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1255:1: ( ( rule__MQLquery__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1255:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1256:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1257:1: ( rule__MQLquery__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1257:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2661);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__2__Impl


    // $ANTLR start rule__MQLquery__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1267:1: rule__MQLquery__Group__3 : rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1271:1: ( rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1272:2: rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32692);
            rule__MQLquery__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32695);
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


    // $ANTLR start rule__MQLquery__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1279:1: rule__MQLquery__Group__3__Impl : ( 'from' ) ;
    public final void rule__MQLquery__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1283:1: ( ( 'from' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1284:1: ( 'from' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1284:1: ( 'from' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1285:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MQLquery__Group__3__Impl2723); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__3__Impl


    // $ANTLR start rule__MQLquery__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1298:1: rule__MQLquery__Group__4 : rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1302:1: ( rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1303:2: rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42754);
            rule__MQLquery__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42757);
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


    // $ANTLR start rule__MQLquery__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1310:1: rule__MQLquery__Group__4__Impl : ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) ;
    public final void rule__MQLquery__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1314:1: ( ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1315:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1315:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1316:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1317:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1317:2: rule__MQLquery__FromEntriesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2784);
            rule__MQLquery__FromEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__4__Impl


    // $ANTLR start rule__MQLquery__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1327:1: rule__MQLquery__Group__5 : rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1331:1: ( rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1332:2: rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52814);
            rule__MQLquery__Group__5__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52817);
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


    // $ANTLR start rule__MQLquery__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1339:1: rule__MQLquery__Group__5__Impl : ( ( rule__MQLquery__Group_5__0 )* ) ;
    public final void rule__MQLquery__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1343:1: ( ( ( rule__MQLquery__Group_5__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1344:1: ( ( rule__MQLquery__Group_5__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1344:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1345:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1346:1: ( rule__MQLquery__Group_5__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1346:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2844);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__5__Impl


    // $ANTLR start rule__MQLquery__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1356:1: rule__MQLquery__Group__6 : rule__MQLquery__Group__6__Impl ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1360:1: ( rule__MQLquery__Group__6__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1361:2: rule__MQLquery__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62875);
            rule__MQLquery__Group__6__Impl();
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
    // $ANTLR end rule__MQLquery__Group__6


    // $ANTLR start rule__MQLquery__Group__6__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1367:1: rule__MQLquery__Group__6__Impl : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1371:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1372:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1372:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1373:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1374:1: ( rule__MQLquery__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1374:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2902);
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
    // $ANTLR end rule__MQLquery__Group__6__Impl


    // $ANTLR start rule__MQLquery__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1398:1: rule__MQLquery__Group_2__0 : rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1402:1: ( rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1403:2: rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02947);
            rule__MQLquery__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02950);
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


    // $ANTLR start rule__MQLquery__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1410:1: rule__MQLquery__Group_2__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1414:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1415:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1415:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1416:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MQLquery__Group_2__0__Impl2978); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_2__0__Impl


    // $ANTLR start rule__MQLquery__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1429:1: rule__MQLquery__Group_2__1 : rule__MQLquery__Group_2__1__Impl ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1433:1: ( rule__MQLquery__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1434:2: rule__MQLquery__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__13009);
            rule__MQLquery__Group_2__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_2__1


    // $ANTLR start rule__MQLquery__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1440:1: rule__MQLquery__Group_2__1__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1444:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1445:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1445:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1446:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1447:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1447:2: rule__MQLquery__SelectEntriesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl3036);
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
    // $ANTLR end rule__MQLquery__Group_2__1__Impl


    // $ANTLR start rule__MQLquery__Group_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1461:1: rule__MQLquery__Group_5__0 : rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1465:1: ( rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1466:2: rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__03070);
            rule__MQLquery__Group_5__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03073);
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


    // $ANTLR start rule__MQLquery__Group_5__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1473:1: rule__MQLquery__Group_5__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1477:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1478:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1478:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1479:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MQLquery__Group_5__0__Impl3101); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_5__0__Impl


    // $ANTLR start rule__MQLquery__Group_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1492:1: rule__MQLquery__Group_5__1 : rule__MQLquery__Group_5__1__Impl ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1496:1: ( rule__MQLquery__Group_5__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1497:2: rule__MQLquery__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13132);
            rule__MQLquery__Group_5__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_5__1


    // $ANTLR start rule__MQLquery__Group_5__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1503:1: rule__MQLquery__Group_5__1__Impl : ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1507:1: ( ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1508:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1508:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1509:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1510:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1510:2: rule__MQLquery__FromEntriesAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3159);
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
    // $ANTLR end rule__MQLquery__Group_5__1__Impl


    // $ANTLR start rule__MQLquery__Group_6__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1524:1: rule__MQLquery__Group_6__0 : rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1528:1: ( rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1529:2: rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03193);
            rule__MQLquery__Group_6__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03196);
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


    // $ANTLR start rule__MQLquery__Group_6__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1536:1: rule__MQLquery__Group_6__0__Impl : ( 'where' ) ;
    public final void rule__MQLquery__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1540:1: ( ( 'where' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1541:1: ( 'where' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1541:1: ( 'where' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1542:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__MQLquery__Group_6__0__Impl3224); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_6__0__Impl


    // $ANTLR start rule__MQLquery__Group_6__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1555:1: rule__MQLquery__Group_6__1 : rule__MQLquery__Group_6__1__Impl ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1559:1: ( rule__MQLquery__Group_6__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1560:2: rule__MQLquery__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13255);
            rule__MQLquery__Group_6__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_6__1


    // $ANTLR start rule__MQLquery__Group_6__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1566:1: rule__MQLquery__Group_6__1__Impl : ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) ) ;
    public final void rule__MQLquery__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1570:1: ( ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1571:1: ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1571:1: ( ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1572:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) ) ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1572:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1573:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1574:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1574:2: rule__MQLquery__WhereEntriesAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3284);
            rule__MQLquery__WhereEntriesAssignment_6_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1577:1: ( ( rule__MQLquery__WhereEntriesAssignment_6_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1578:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )*
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1579:1: ( rule__MQLquery__WhereEntriesAssignment_6_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1579:2: rule__MQLquery__WhereEntriesAssignment_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3296);
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
    // $ANTLR end rule__MQLquery__Group_6__1__Impl


    // $ANTLR start rule__SelectEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1594:1: rule__SelectEntry__Group__0 : rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1598:1: ( rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1599:2: rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03333);
            rule__SelectEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03336);
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


    // $ANTLR start rule__SelectEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1606:1: rule__SelectEntry__Group__0__Impl : ( ( rule__SelectEntry__SelectAssignment_0 ) ) ;
    public final void rule__SelectEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1610:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1611:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1611:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1612:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1613:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1613:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3363);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group__0__Impl


    // $ANTLR start rule__SelectEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1623:1: rule__SelectEntry__Group__1 : rule__SelectEntry__Group__1__Impl ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1627:1: ( rule__SelectEntry__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1628:2: rule__SelectEntry__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13393);
            rule__SelectEntry__Group__1__Impl();
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
    // $ANTLR end rule__SelectEntry__Group__1


    // $ANTLR start rule__SelectEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1634:1: rule__SelectEntry__Group__1__Impl : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1638:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1639:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1639:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1640:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1641:1: ( rule__SelectEntry__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1641:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3420);
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
    // $ANTLR end rule__SelectEntry__Group__1__Impl


    // $ANTLR start rule__SelectEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1655:1: rule__SelectEntry__Group_1__0 : rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1659:1: ( rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1660:2: rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03455);
            rule__SelectEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03458);
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


    // $ANTLR start rule__SelectEntry__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1667:1: rule__SelectEntry__Group_1__0__Impl : ( '.' ) ;
    public final void rule__SelectEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1671:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1672:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1672:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1673:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__SelectEntry__Group_1__0__Impl3486); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group_1__0__Impl


    // $ANTLR start rule__SelectEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1686:1: rule__SelectEntry__Group_1__1 : rule__SelectEntry__Group_1__1__Impl ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1690:1: ( rule__SelectEntry__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1691:2: rule__SelectEntry__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13517);
            rule__SelectEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__SelectEntry__Group_1__1


    // $ANTLR start rule__SelectEntry__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1697:1: rule__SelectEntry__Group_1__1__Impl : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1701:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1702:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1702:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1703:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1704:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1704:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3544);
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
    // $ANTLR end rule__SelectEntry__Group_1__1__Impl


    // $ANTLR start rule__FromEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1718:1: rule__FromEntry__Group__0 : rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1722:1: ( rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1723:2: rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03578);
            rule__FromEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03581);
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


    // $ANTLR start rule__FromEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1730:1: rule__FromEntry__Group__0__Impl : ( ( rule__FromEntry__TypeAssignment_0 ) ) ;
    public final void rule__FromEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1734:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1735:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1735:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1736:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1737:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1737:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3608);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__0__Impl


    // $ANTLR start rule__FromEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1747:1: rule__FromEntry__Group__1 : rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1751:1: ( rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1752:2: rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13638);
            rule__FromEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13641);
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


    // $ANTLR start rule__FromEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1759:1: rule__FromEntry__Group__1__Impl : ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) ;
    public final void rule__FromEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1763:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1764:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1764:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1765:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1766:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1766:2: rule__FromEntry__WithoutsubtypesAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__1__Impl3668);
                    rule__FromEntry__WithoutsubtypesAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__1__Impl


    // $ANTLR start rule__FromEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1776:1: rule__FromEntry__Group__2 : rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1780:1: ( rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1781:2: rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23699);
            rule__FromEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23702);
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


    // $ANTLR start rule__FromEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1788:1: rule__FromEntry__Group__2__Impl : ( 'as' ) ;
    public final void rule__FromEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1792:1: ( ( 'as' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1793:1: ( 'as' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1793:1: ( 'as' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1794:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__FromEntry__Group__2__Impl3730); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__2__Impl


    // $ANTLR start rule__FromEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1807:1: rule__FromEntry__Group__3 : rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1811:1: ( rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1812:2: rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33761);
            rule__FromEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33764);
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


    // $ANTLR start rule__FromEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1819:1: rule__FromEntry__Group__3__Impl : ( ( rule__FromEntry__AliasAssignment_3 ) ) ;
    public final void rule__FromEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1823:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1824:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1824:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1825:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1826:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1826:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3791);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__3__Impl


    // $ANTLR start rule__FromEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1836:1: rule__FromEntry__Group__4 : rule__FromEntry__Group__4__Impl ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1840:1: ( rule__FromEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1841:2: rule__FromEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43821);
            rule__FromEntry__Group__4__Impl();
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
    // $ANTLR end rule__FromEntry__Group__4


    // $ANTLR start rule__FromEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1847:1: rule__FromEntry__Group__4__Impl : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1851:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1852:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1852:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1853:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1854:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27||LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1854:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3848);
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
    // $ANTLR end rule__FromEntry__Group__4__Impl


    // $ANTLR start rule__ScopeClause__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1874:1: rule__ScopeClause__Group__0 : rule__ScopeClause__Group__0__Impl rule__ScopeClause__Group__1 ;
    public final void rule__ScopeClause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1878:1: ( rule__ScopeClause__Group__0__Impl rule__ScopeClause__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1879:2: rule__ScopeClause__Group__0__Impl rule__ScopeClause__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__0__Impl_in_rule__ScopeClause__Group__03889);
            rule__ScopeClause__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__1_in_rule__ScopeClause__Group__03892);
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


    // $ANTLR start rule__ScopeClause__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1886:1: rule__ScopeClause__Group__0__Impl : ( ( rule__ScopeClause__NotInAssignment_0 )? ) ;
    public final void rule__ScopeClause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1890:1: ( ( ( rule__ScopeClause__NotInAssignment_0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1891:1: ( ( rule__ScopeClause__NotInAssignment_0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1891:1: ( ( rule__ScopeClause__NotInAssignment_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1892:1: ( rule__ScopeClause__NotInAssignment_0 )?
            {
             before(grammarAccess.getScopeClauseAccess().getNotInAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1893:1: ( rule__ScopeClause__NotInAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1893:2: rule__ScopeClause__NotInAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__NotInAssignment_0_in_rule__ScopeClause__Group__0__Impl3919);
                    rule__ScopeClause__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScopeClauseAccess().getNotInAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ScopeClause__Group__0__Impl


    // $ANTLR start rule__ScopeClause__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1903:1: rule__ScopeClause__Group__1 : rule__ScopeClause__Group__1__Impl rule__ScopeClause__Group__2 ;
    public final void rule__ScopeClause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1907:1: ( rule__ScopeClause__Group__1__Impl rule__ScopeClause__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1908:2: rule__ScopeClause__Group__1__Impl rule__ScopeClause__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__1__Impl_in_rule__ScopeClause__Group__13950);
            rule__ScopeClause__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__2_in_rule__ScopeClause__Group__13953);
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


    // $ANTLR start rule__ScopeClause__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1915:1: rule__ScopeClause__Group__1__Impl : ( 'in' ) ;
    public final void rule__ScopeClause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1919:1: ( ( 'in' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1920:1: ( 'in' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1920:1: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1921:1: 'in'
            {
             before(grammarAccess.getScopeClauseAccess().getInKeyword_1()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ScopeClause__Group__1__Impl3981); 
             after(grammarAccess.getScopeClauseAccess().getInKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ScopeClause__Group__1__Impl


    // $ANTLR start rule__ScopeClause__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1934:1: rule__ScopeClause__Group__2 : rule__ScopeClause__Group__2__Impl ;
    public final void rule__ScopeClause__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1938:1: ( rule__ScopeClause__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1939:2: rule__ScopeClause__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__Group__2__Impl_in_rule__ScopeClause__Group__24012);
            rule__ScopeClause__Group__2__Impl();
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
    // $ANTLR end rule__ScopeClause__Group__2


    // $ANTLR start rule__ScopeClause__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1945:1: rule__ScopeClause__Group__2__Impl : ( ( rule__ScopeClause__ScopeAssignment_2 ) ) ;
    public final void rule__ScopeClause__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1949:1: ( ( ( rule__ScopeClause__ScopeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1950:1: ( ( rule__ScopeClause__ScopeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1950:1: ( ( rule__ScopeClause__ScopeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1951:1: ( rule__ScopeClause__ScopeAssignment_2 )
            {
             before(grammarAccess.getScopeClauseAccess().getScopeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1952:1: ( rule__ScopeClause__ScopeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1952:2: rule__ScopeClause__ScopeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScopeClause__ScopeAssignment_2_in_rule__ScopeClause__Group__2__Impl4039);
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
    // $ANTLR end rule__ScopeClause__Group__2__Impl


    // $ANTLR start rule__ResourceScope__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1968:1: rule__ResourceScope__Group__0 : rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1972:1: ( rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1973:2: rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04075);
            rule__ResourceScope__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04078);
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


    // $ANTLR start rule__ResourceScope__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1980:1: rule__ResourceScope__Group__0__Impl : ( 'resources' ) ;
    public final void rule__ResourceScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1984:1: ( ( 'resources' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1985:1: ( 'resources' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1985:1: ( 'resources' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1986:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ResourceScope__Group__0__Impl4106); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__0__Impl


    // $ANTLR start rule__ResourceScope__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:1999:1: rule__ResourceScope__Group__1 : rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2003:1: ( rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2004:2: rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14137);
            rule__ResourceScope__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14140);
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


    // $ANTLR start rule__ResourceScope__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2011:1: rule__ResourceScope__Group__1__Impl : ( '{' ) ;
    public final void rule__ResourceScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2015:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2016:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2016:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2017:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ResourceScope__Group__1__Impl4168); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__1__Impl


    // $ANTLR start rule__ResourceScope__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2030:1: rule__ResourceScope__Group__2 : rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2034:1: ( rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2035:2: rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24199);
            rule__ResourceScope__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24202);
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


    // $ANTLR start rule__ResourceScope__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2042:1: rule__ResourceScope__Group__2__Impl : ( ( rule__ResourceScope__UrisAssignment_2 ) ) ;
    public final void rule__ResourceScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2046:1: ( ( ( rule__ResourceScope__UrisAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2047:1: ( ( rule__ResourceScope__UrisAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2047:1: ( ( rule__ResourceScope__UrisAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2048:1: ( rule__ResourceScope__UrisAssignment_2 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2049:1: ( rule__ResourceScope__UrisAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2049:2: rule__ResourceScope__UrisAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__UrisAssignment_2_in_rule__ResourceScope__Group__2__Impl4229);
            rule__ResourceScope__UrisAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__2__Impl


    // $ANTLR start rule__ResourceScope__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2059:1: rule__ResourceScope__Group__3 : rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2063:1: ( rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2064:2: rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34259);
            rule__ResourceScope__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34262);
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


    // $ANTLR start rule__ResourceScope__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2071:1: rule__ResourceScope__Group__3__Impl : ( ( rule__ResourceScope__Group_3__0 )* ) ;
    public final void rule__ResourceScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2075:1: ( ( ( rule__ResourceScope__Group_3__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2076:1: ( ( rule__ResourceScope__Group_3__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2076:1: ( ( rule__ResourceScope__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2077:1: ( rule__ResourceScope__Group_3__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2078:1: ( rule__ResourceScope__Group_3__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2078:2: rule__ResourceScope__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__0_in_rule__ResourceScope__Group__3__Impl4289);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__3__Impl


    // $ANTLR start rule__ResourceScope__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2088:1: rule__ResourceScope__Group__4 : rule__ResourceScope__Group__4__Impl ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2092:1: ( rule__ResourceScope__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2093:2: rule__ResourceScope__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44320);
            rule__ResourceScope__Group__4__Impl();
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
    // $ANTLR end rule__ResourceScope__Group__4


    // $ANTLR start rule__ResourceScope__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2099:1: rule__ResourceScope__Group__4__Impl : ( '}' ) ;
    public final void rule__ResourceScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2103:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2104:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2104:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2105:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ResourceScope__Group__4__Impl4348); 
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
    // $ANTLR end rule__ResourceScope__Group__4__Impl


    // $ANTLR start rule__ResourceScope__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2128:1: rule__ResourceScope__Group_3__0 : rule__ResourceScope__Group_3__0__Impl rule__ResourceScope__Group_3__1 ;
    public final void rule__ResourceScope__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2132:1: ( rule__ResourceScope__Group_3__0__Impl rule__ResourceScope__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2133:2: rule__ResourceScope__Group_3__0__Impl rule__ResourceScope__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__0__Impl_in_rule__ResourceScope__Group_3__04389);
            rule__ResourceScope__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__1_in_rule__ResourceScope__Group_3__04392);
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


    // $ANTLR start rule__ResourceScope__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2140:1: rule__ResourceScope__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ResourceScope__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2144:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2145:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2145:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2146:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ResourceScope__Group_3__0__Impl4420); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group_3__0__Impl


    // $ANTLR start rule__ResourceScope__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2159:1: rule__ResourceScope__Group_3__1 : rule__ResourceScope__Group_3__1__Impl ;
    public final void rule__ResourceScope__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2163:1: ( rule__ResourceScope__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2164:2: rule__ResourceScope__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__Group_3__1__Impl_in_rule__ResourceScope__Group_3__14451);
            rule__ResourceScope__Group_3__1__Impl();
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
    // $ANTLR end rule__ResourceScope__Group_3__1


    // $ANTLR start rule__ResourceScope__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2170:1: rule__ResourceScope__Group_3__1__Impl : ( ( rule__ResourceScope__UrisAssignment_3_1 ) ) ;
    public final void rule__ResourceScope__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2174:1: ( ( ( rule__ResourceScope__UrisAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2175:1: ( ( rule__ResourceScope__UrisAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2175:1: ( ( rule__ResourceScope__UrisAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2176:1: ( rule__ResourceScope__UrisAssignment_3_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2177:1: ( rule__ResourceScope__UrisAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2177:2: rule__ResourceScope__UrisAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ResourceScope__UrisAssignment_3_1_in_rule__ResourceScope__Group_3__1__Impl4478);
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
    // $ANTLR end rule__ResourceScope__Group_3__1__Impl


    // $ANTLR start rule__ElementScope__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2191:1: rule__ElementScope__Group__0 : rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2195:1: ( rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2196:2: rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04512);
            rule__ElementScope__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04515);
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


    // $ANTLR start rule__ElementScope__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2203:1: rule__ElementScope__Group__0__Impl : ( 'elements' ) ;
    public final void rule__ElementScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2207:1: ( ( 'elements' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2208:1: ( 'elements' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2208:1: ( 'elements' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2209:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__ElementScope__Group__0__Impl4543); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__0__Impl


    // $ANTLR start rule__ElementScope__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2222:1: rule__ElementScope__Group__1 : rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2226:1: ( rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2227:2: rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14574);
            rule__ElementScope__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14577);
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


    // $ANTLR start rule__ElementScope__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2234:1: rule__ElementScope__Group__1__Impl : ( '{' ) ;
    public final void rule__ElementScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2238:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2239:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2239:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2240:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ElementScope__Group__1__Impl4605); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__1__Impl


    // $ANTLR start rule__ElementScope__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2253:1: rule__ElementScope__Group__2 : rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2257:1: ( rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2258:2: rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__24636);
            rule__ElementScope__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24639);
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


    // $ANTLR start rule__ElementScope__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2265:1: rule__ElementScope__Group__2__Impl : ( ( rule__ElementScope__UrisAssignment_2 ) ) ;
    public final void rule__ElementScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2269:1: ( ( ( rule__ElementScope__UrisAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2270:1: ( ( rule__ElementScope__UrisAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2270:1: ( ( rule__ElementScope__UrisAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2271:1: ( rule__ElementScope__UrisAssignment_2 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2272:1: ( rule__ElementScope__UrisAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2272:2: rule__ElementScope__UrisAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__UrisAssignment_2_in_rule__ElementScope__Group__2__Impl4666);
            rule__ElementScope__UrisAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__2__Impl


    // $ANTLR start rule__ElementScope__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2282:1: rule__ElementScope__Group__3 : rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2286:1: ( rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2287:2: rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__34696);
            rule__ElementScope__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34699);
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


    // $ANTLR start rule__ElementScope__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2294:1: rule__ElementScope__Group__3__Impl : ( ( rule__ElementScope__Group_3__0 )* ) ;
    public final void rule__ElementScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2298:1: ( ( ( rule__ElementScope__Group_3__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2299:1: ( ( rule__ElementScope__Group_3__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2299:1: ( ( rule__ElementScope__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2300:1: ( rule__ElementScope__Group_3__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2301:1: ( rule__ElementScope__Group_3__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2301:2: rule__ElementScope__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__0_in_rule__ElementScope__Group__3__Impl4726);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__3__Impl


    // $ANTLR start rule__ElementScope__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2311:1: rule__ElementScope__Group__4 : rule__ElementScope__Group__4__Impl ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2315:1: ( rule__ElementScope__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2316:2: rule__ElementScope__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__44757);
            rule__ElementScope__Group__4__Impl();
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
    // $ANTLR end rule__ElementScope__Group__4


    // $ANTLR start rule__ElementScope__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2322:1: rule__ElementScope__Group__4__Impl : ( '}' ) ;
    public final void rule__ElementScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2326:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2327:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2327:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2328:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ElementScope__Group__4__Impl4785); 
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
    // $ANTLR end rule__ElementScope__Group__4__Impl


    // $ANTLR start rule__ElementScope__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2351:1: rule__ElementScope__Group_3__0 : rule__ElementScope__Group_3__0__Impl rule__ElementScope__Group_3__1 ;
    public final void rule__ElementScope__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2355:1: ( rule__ElementScope__Group_3__0__Impl rule__ElementScope__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2356:2: rule__ElementScope__Group_3__0__Impl rule__ElementScope__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__0__Impl_in_rule__ElementScope__Group_3__04826);
            rule__ElementScope__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__1_in_rule__ElementScope__Group_3__04829);
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


    // $ANTLR start rule__ElementScope__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2363:1: rule__ElementScope__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ElementScope__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2367:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2368:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2368:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2369:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ElementScope__Group_3__0__Impl4857); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group_3__0__Impl


    // $ANTLR start rule__ElementScope__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2382:1: rule__ElementScope__Group_3__1 : rule__ElementScope__Group_3__1__Impl ;
    public final void rule__ElementScope__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2386:1: ( rule__ElementScope__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2387:2: rule__ElementScope__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__Group_3__1__Impl_in_rule__ElementScope__Group_3__14888);
            rule__ElementScope__Group_3__1__Impl();
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
    // $ANTLR end rule__ElementScope__Group_3__1


    // $ANTLR start rule__ElementScope__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2393:1: rule__ElementScope__Group_3__1__Impl : ( ( rule__ElementScope__UrisAssignment_3_1 ) ) ;
    public final void rule__ElementScope__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2397:1: ( ( ( rule__ElementScope__UrisAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2398:1: ( ( rule__ElementScope__UrisAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2398:1: ( ( rule__ElementScope__UrisAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2399:1: ( rule__ElementScope__UrisAssignment_3_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2400:1: ( rule__ElementScope__UrisAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2400:2: rule__ElementScope__UrisAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ElementScope__UrisAssignment_3_1_in_rule__ElementScope__Group_3__1__Impl4915);
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
    // $ANTLR end rule__ElementScope__Group_3__1__Impl


    // $ANTLR start rule__WhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2414:1: rule__WhereEntry__Group__0 : rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2418:1: ( rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2419:2: rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__04949);
            rule__WhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04952);
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


    // $ANTLR start rule__WhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2426:1: rule__WhereEntry__Group__0__Impl : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2430:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2431:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2431:1: ( ruleAndWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2432:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl4979);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group__0__Impl


    // $ANTLR start rule__WhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2443:1: rule__WhereEntry__Group__1 : rule__WhereEntry__Group__1__Impl ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2447:1: ( rule__WhereEntry__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2448:2: rule__WhereEntry__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15008);
            rule__WhereEntry__Group__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group__1


    // $ANTLR start rule__WhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2454:1: rule__WhereEntry__Group__1__Impl : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2458:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2459:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2459:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2460:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2461:1: ( rule__WhereEntry__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2461:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5035);
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
    // $ANTLR end rule__WhereEntry__Group__1__Impl


    // $ANTLR start rule__WhereEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2475:1: rule__WhereEntry__Group_1__0 : rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2479:1: ( rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2480:2: rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05070);
            rule__WhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05073);
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


    // $ANTLR start rule__WhereEntry__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2487:1: rule__WhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__WhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2491:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2492:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2492:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2493:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2494:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2496:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1__0__Impl


    // $ANTLR start rule__WhereEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2506:1: rule__WhereEntry__Group_1__1 : rule__WhereEntry__Group_1__1__Impl ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2510:1: ( rule__WhereEntry__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2511:2: rule__WhereEntry__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15131);
            rule__WhereEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group_1__1


    // $ANTLR start rule__WhereEntry__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2517:1: rule__WhereEntry__Group_1__1__Impl : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2521:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2522:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2522:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2523:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2523:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2524:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2525:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2525:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5160);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2528:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2529:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2530:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2530:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5172);
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
    // $ANTLR end rule__WhereEntry__Group_1__1__Impl


    // $ANTLR start rule__WhereEntry__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2545:1: rule__WhereEntry__Group_1_1__0 : rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2549:1: ( rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2550:2: rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05209);
            rule__WhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05212);
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


    // $ANTLR start rule__WhereEntry__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2557:1: rule__WhereEntry__Group_1_1__0__Impl : ( 'or' ) ;
    public final void rule__WhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2561:1: ( ( 'or' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2562:1: ( 'or' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2562:1: ( 'or' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2563:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__WhereEntry__Group_1_1__0__Impl5240); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1_1__0__Impl


    // $ANTLR start rule__WhereEntry__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2576:1: rule__WhereEntry__Group_1_1__1 : rule__WhereEntry__Group_1_1__1__Impl ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2580:1: ( rule__WhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2581:2: rule__WhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15271);
            rule__WhereEntry__Group_1_1__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group_1_1__1


    // $ANTLR start rule__WhereEntry__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2587:1: rule__WhereEntry__Group_1_1__1__Impl : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2591:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2592:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2592:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2593:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2594:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2594:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5298);
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
    // $ANTLR end rule__WhereEntry__Group_1_1__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2608:1: rule__AndWhereEntry__Group__0 : rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2612:1: ( rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2613:2: rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05332);
            rule__AndWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05335);
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


    // $ANTLR start rule__AndWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2620:1: rule__AndWhereEntry__Group__0__Impl : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2624:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2625:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2625:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2626:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5362);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2637:1: rule__AndWhereEntry__Group__1 : rule__AndWhereEntry__Group__1__Impl ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2641:1: ( rule__AndWhereEntry__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2642:2: rule__AndWhereEntry__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15391);
            rule__AndWhereEntry__Group__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group__1


    // $ANTLR start rule__AndWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2648:1: rule__AndWhereEntry__Group__1__Impl : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2652:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2653:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2653:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2654:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2655:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2655:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5418);
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
    // $ANTLR end rule__AndWhereEntry__Group__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2669:1: rule__AndWhereEntry__Group_1__0 : rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2673:1: ( rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2674:2: rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05453);
            rule__AndWhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05456);
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


    // $ANTLR start rule__AndWhereEntry__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2681:1: rule__AndWhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__AndWhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2685:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2686:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2686:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2687:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2688:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2690:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2700:1: rule__AndWhereEntry__Group_1__1 : rule__AndWhereEntry__Group_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2704:1: ( rule__AndWhereEntry__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2705:2: rule__AndWhereEntry__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__15514);
            rule__AndWhereEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2711:1: rule__AndWhereEntry__Group_1__1__Impl : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2715:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2716:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2716:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2717:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2717:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2718:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2719:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2719:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl5543);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2722:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2723:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2724:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==33) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2724:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl5555);
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
    // $ANTLR end rule__AndWhereEntry__Group_1__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2739:1: rule__AndWhereEntry__Group_1_1__0 : rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2743:1: ( rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2744:2: rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__05592);
            rule__AndWhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__05595);
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


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2751:1: rule__AndWhereEntry__Group_1_1__0__Impl : ( 'and' ) ;
    public final void rule__AndWhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2755:1: ( ( 'and' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2756:1: ( 'and' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2756:1: ( 'and' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2757:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__AndWhereEntry__Group_1_1__0__Impl5623); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1_1__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2770:1: rule__AndWhereEntry__Group_1_1__1 : rule__AndWhereEntry__Group_1_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2774:1: ( rule__AndWhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2775:2: rule__AndWhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__15654);
            rule__AndWhereEntry__Group_1_1__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2781:1: rule__AndWhereEntry__Group_1_1__1__Impl : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2785:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2786:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2786:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2787:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2788:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2788:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl5681);
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
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1__Impl


    // $ANTLR start rule__ParWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2802:1: rule__ParWhereEntry__Group__0 : rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2806:1: ( rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2807:2: rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__05715);
            rule__ParWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__05718);
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


    // $ANTLR start rule__ParWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2814:1: rule__ParWhereEntry__Group__0__Impl : ( '(' ) ;
    public final void rule__ParWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2818:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2819:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2819:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2820:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__ParWhereEntry__Group__0__Impl5746); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__0__Impl


    // $ANTLR start rule__ParWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2833:1: rule__ParWhereEntry__Group__1 : rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2837:1: ( rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2838:2: rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__15777);
            rule__ParWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__15780);
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


    // $ANTLR start rule__ParWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2845:1: rule__ParWhereEntry__Group__1__Impl : ( ruleWhereEntry ) ;
    public final void rule__ParWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2849:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2850:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2850:1: ( ruleWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2851:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl5807);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__1__Impl


    // $ANTLR start rule__ParWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2862:1: rule__ParWhereEntry__Group__2 : rule__ParWhereEntry__Group__2__Impl ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2866:1: ( rule__ParWhereEntry__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2867:2: rule__ParWhereEntry__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__25836);
            rule__ParWhereEntry__Group__2__Impl();
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
    // $ANTLR end rule__ParWhereEntry__Group__2


    // $ANTLR start rule__ParWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2873:1: rule__ParWhereEntry__Group__2__Impl : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2877:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2878:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2878:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2879:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__ParWhereEntry__Group__2__Impl5864); 
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
    // $ANTLR end rule__ParWhereEntry__Group__2__Impl


    // $ANTLR start rule__DoubleWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2898:1: rule__DoubleWhereEntry__Group__0 : rule__DoubleWhereEntry__Group__0__Impl rule__DoubleWhereEntry__Group__1 ;
    public final void rule__DoubleWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2902:1: ( rule__DoubleWhereEntry__Group__0__Impl rule__DoubleWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2903:2: rule__DoubleWhereEntry__Group__0__Impl rule__DoubleWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__0__Impl_in_rule__DoubleWhereEntry__Group__05901);
            rule__DoubleWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__05904);
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


    // $ANTLR start rule__DoubleWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2910:1: rule__DoubleWhereEntry__Group__0__Impl : ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__DoubleWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2914:1: ( ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2915:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2915:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2916:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2917:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2917:2: rule__DoubleWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__0__Impl5931);
            rule__DoubleWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__0__Impl


    // $ANTLR start rule__DoubleWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2927:1: rule__DoubleWhereEntry__Group__1 : rule__DoubleWhereEntry__Group__1__Impl rule__DoubleWhereEntry__Group__2 ;
    public final void rule__DoubleWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2931:1: ( rule__DoubleWhereEntry__Group__1__Impl rule__DoubleWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2932:2: rule__DoubleWhereEntry__Group__1__Impl rule__DoubleWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__1__Impl_in_rule__DoubleWhereEntry__Group__15961);
            rule__DoubleWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__15964);
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


    // $ANTLR start rule__DoubleWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2939:1: rule__DoubleWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__DoubleWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2943:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2944:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2944:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2945:1: '.'
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__DoubleWhereEntry__Group__1__Impl5992); 
             after(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__1__Impl


    // $ANTLR start rule__DoubleWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2958:1: rule__DoubleWhereEntry__Group__2 : rule__DoubleWhereEntry__Group__2__Impl rule__DoubleWhereEntry__Group__3 ;
    public final void rule__DoubleWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2962:1: ( rule__DoubleWhereEntry__Group__2__Impl rule__DoubleWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2963:2: rule__DoubleWhereEntry__Group__2__Impl rule__DoubleWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__2__Impl_in_rule__DoubleWhereEntry__Group__26023);
            rule__DoubleWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__26026);
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


    // $ANTLR start rule__DoubleWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2970:1: rule__DoubleWhereEntry__Group__2__Impl : ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) ;
    public final void rule__DoubleWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2974:1: ( ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2975:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2975:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2976:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2977:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2977:2: rule__DoubleWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__2__Impl6053);
            rule__DoubleWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__2__Impl


    // $ANTLR start rule__DoubleWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2987:1: rule__DoubleWhereEntry__Group__3 : rule__DoubleWhereEntry__Group__3__Impl rule__DoubleWhereEntry__Group__4 ;
    public final void rule__DoubleWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2991:1: ( rule__DoubleWhereEntry__Group__3__Impl rule__DoubleWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2992:2: rule__DoubleWhereEntry__Group__3__Impl rule__DoubleWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__3__Impl_in_rule__DoubleWhereEntry__Group__36083);
            rule__DoubleWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__36086);
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


    // $ANTLR start rule__DoubleWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:2999:1: rule__DoubleWhereEntry__Group__3__Impl : ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__DoubleWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3003:1: ( ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3004:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3004:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3005:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3006:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3006:2: rule__DoubleWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__3__Impl6113);
            rule__DoubleWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__3__Impl


    // $ANTLR start rule__DoubleWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3016:1: rule__DoubleWhereEntry__Group__4 : rule__DoubleWhereEntry__Group__4__Impl ;
    public final void rule__DoubleWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3020:1: ( rule__DoubleWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3021:2: rule__DoubleWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__Group__4__Impl_in_rule__DoubleWhereEntry__Group__46143);
            rule__DoubleWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__DoubleWhereEntry__Group__4


    // $ANTLR start rule__DoubleWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3027:1: rule__DoubleWhereEntry__Group__4__Impl : ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__DoubleWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3031:1: ( ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3032:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3032:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3033:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3034:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3034:2: rule__DoubleWhereEntry__ValueAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__4__Impl6170);
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
    // $ANTLR end rule__DoubleWhereEntry__Group__4__Impl


    // $ANTLR start rule__LongWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3054:1: rule__LongWhereEntry__Group__0 : rule__LongWhereEntry__Group__0__Impl rule__LongWhereEntry__Group__1 ;
    public final void rule__LongWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3058:1: ( rule__LongWhereEntry__Group__0__Impl rule__LongWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3059:2: rule__LongWhereEntry__Group__0__Impl rule__LongWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__0__Impl_in_rule__LongWhereEntry__Group__06210);
            rule__LongWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__06213);
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


    // $ANTLR start rule__LongWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3066:1: rule__LongWhereEntry__Group__0__Impl : ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__LongWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3070:1: ( ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3071:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3071:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3072:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3073:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3073:2: rule__LongWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__0__Impl6240);
            rule__LongWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__0__Impl


    // $ANTLR start rule__LongWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3083:1: rule__LongWhereEntry__Group__1 : rule__LongWhereEntry__Group__1__Impl rule__LongWhereEntry__Group__2 ;
    public final void rule__LongWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3087:1: ( rule__LongWhereEntry__Group__1__Impl rule__LongWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3088:2: rule__LongWhereEntry__Group__1__Impl rule__LongWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__1__Impl_in_rule__LongWhereEntry__Group__16270);
            rule__LongWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__16273);
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


    // $ANTLR start rule__LongWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3095:1: rule__LongWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__LongWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3099:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3100:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3100:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3101:1: '.'
            {
             before(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LongWhereEntry__Group__1__Impl6301); 
             after(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__1__Impl


    // $ANTLR start rule__LongWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3114:1: rule__LongWhereEntry__Group__2 : rule__LongWhereEntry__Group__2__Impl rule__LongWhereEntry__Group__3 ;
    public final void rule__LongWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3118:1: ( rule__LongWhereEntry__Group__2__Impl rule__LongWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3119:2: rule__LongWhereEntry__Group__2__Impl rule__LongWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__2__Impl_in_rule__LongWhereEntry__Group__26332);
            rule__LongWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__26335);
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


    // $ANTLR start rule__LongWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3126:1: rule__LongWhereEntry__Group__2__Impl : ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) ;
    public final void rule__LongWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3130:1: ( ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3131:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3131:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3132:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3133:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3133:2: rule__LongWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__2__Impl6362);
            rule__LongWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__2__Impl


    // $ANTLR start rule__LongWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3143:1: rule__LongWhereEntry__Group__3 : rule__LongWhereEntry__Group__3__Impl rule__LongWhereEntry__Group__4 ;
    public final void rule__LongWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3147:1: ( rule__LongWhereEntry__Group__3__Impl rule__LongWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3148:2: rule__LongWhereEntry__Group__3__Impl rule__LongWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__3__Impl_in_rule__LongWhereEntry__Group__36392);
            rule__LongWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__36395);
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


    // $ANTLR start rule__LongWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3155:1: rule__LongWhereEntry__Group__3__Impl : ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__LongWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3159:1: ( ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3160:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3160:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3161:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3162:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3162:2: rule__LongWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__3__Impl6422);
            rule__LongWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__3__Impl


    // $ANTLR start rule__LongWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3172:1: rule__LongWhereEntry__Group__4 : rule__LongWhereEntry__Group__4__Impl ;
    public final void rule__LongWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3176:1: ( rule__LongWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3177:2: rule__LongWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__Group__4__Impl_in_rule__LongWhereEntry__Group__46452);
            rule__LongWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__LongWhereEntry__Group__4


    // $ANTLR start rule__LongWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3183:1: rule__LongWhereEntry__Group__4__Impl : ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__LongWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3187:1: ( ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3188:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3188:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3189:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3190:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3190:2: rule__LongWhereEntry__ValueAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__4__Impl6479);
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
    // $ANTLR end rule__LongWhereEntry__Group__4__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3210:1: rule__VariableWhereEntry__Group__0 : rule__VariableWhereEntry__Group__0__Impl rule__VariableWhereEntry__Group__1 ;
    public final void rule__VariableWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3214:1: ( rule__VariableWhereEntry__Group__0__Impl rule__VariableWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3215:2: rule__VariableWhereEntry__Group__0__Impl rule__VariableWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__0__Impl_in_rule__VariableWhereEntry__Group__06519);
            rule__VariableWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__06522);
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


    // $ANTLR start rule__VariableWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3222:1: rule__VariableWhereEntry__Group__0__Impl : ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__VariableWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3226:1: ( ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3227:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3227:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3228:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3229:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3229:2: rule__VariableWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__0__Impl6549);
            rule__VariableWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__0__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3239:1: rule__VariableWhereEntry__Group__1 : rule__VariableWhereEntry__Group__1__Impl rule__VariableWhereEntry__Group__2 ;
    public final void rule__VariableWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3243:1: ( rule__VariableWhereEntry__Group__1__Impl rule__VariableWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3244:2: rule__VariableWhereEntry__Group__1__Impl rule__VariableWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__1__Impl_in_rule__VariableWhereEntry__Group__16579);
            rule__VariableWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__16582);
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


    // $ANTLR start rule__VariableWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3251:1: rule__VariableWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__VariableWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3255:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3256:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3256:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3257:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__VariableWhereEntry__Group__1__Impl6610); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__1__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3270:1: rule__VariableWhereEntry__Group__2 : rule__VariableWhereEntry__Group__2__Impl rule__VariableWhereEntry__Group__3 ;
    public final void rule__VariableWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3274:1: ( rule__VariableWhereEntry__Group__2__Impl rule__VariableWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3275:2: rule__VariableWhereEntry__Group__2__Impl rule__VariableWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__2__Impl_in_rule__VariableWhereEntry__Group__26641);
            rule__VariableWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__26644);
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


    // $ANTLR start rule__VariableWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3282:1: rule__VariableWhereEntry__Group__2__Impl : ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) ;
    public final void rule__VariableWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3286:1: ( ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3287:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3287:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3288:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3289:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3289:2: rule__VariableWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__2__Impl6671);
            rule__VariableWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__2__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3299:1: rule__VariableWhereEntry__Group__3 : rule__VariableWhereEntry__Group__3__Impl rule__VariableWhereEntry__Group__4 ;
    public final void rule__VariableWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3303:1: ( rule__VariableWhereEntry__Group__3__Impl rule__VariableWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3304:2: rule__VariableWhereEntry__Group__3__Impl rule__VariableWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__3__Impl_in_rule__VariableWhereEntry__Group__36701);
            rule__VariableWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__36704);
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


    // $ANTLR start rule__VariableWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3311:1: rule__VariableWhereEntry__Group__3__Impl : ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__VariableWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3315:1: ( ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3316:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3316:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3317:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3318:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3318:2: rule__VariableWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__3__Impl6731);
            rule__VariableWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__3__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3328:1: rule__VariableWhereEntry__Group__4 : rule__VariableWhereEntry__Group__4__Impl rule__VariableWhereEntry__Group__5 ;
    public final void rule__VariableWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3332:1: ( rule__VariableWhereEntry__Group__4__Impl rule__VariableWhereEntry__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3333:2: rule__VariableWhereEntry__Group__4__Impl rule__VariableWhereEntry__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__4__Impl_in_rule__VariableWhereEntry__Group__46761);
            rule__VariableWhereEntry__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__46764);
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


    // $ANTLR start rule__VariableWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3340:1: rule__VariableWhereEntry__Group__4__Impl : ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) ;
    public final void rule__VariableWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3344:1: ( ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3345:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3345:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3346:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3347:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3347:2: rule__VariableWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__4__Impl6791);
            rule__VariableWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__4__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3357:1: rule__VariableWhereEntry__Group__5 : rule__VariableWhereEntry__Group__5__Impl rule__VariableWhereEntry__Group__6 ;
    public final void rule__VariableWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3361:1: ( rule__VariableWhereEntry__Group__5__Impl rule__VariableWhereEntry__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3362:2: rule__VariableWhereEntry__Group__5__Impl rule__VariableWhereEntry__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__5__Impl_in_rule__VariableWhereEntry__Group__56821);
            rule__VariableWhereEntry__Group__5__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__56824);
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


    // $ANTLR start rule__VariableWhereEntry__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3369:1: rule__VariableWhereEntry__Group__5__Impl : ( '.' ) ;
    public final void rule__VariableWhereEntry__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3373:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3374:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3374:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3375:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__VariableWhereEntry__Group__5__Impl6852); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__5__Impl


    // $ANTLR start rule__VariableWhereEntry__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3388:1: rule__VariableWhereEntry__Group__6 : rule__VariableWhereEntry__Group__6__Impl ;
    public final void rule__VariableWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3392:1: ( rule__VariableWhereEntry__Group__6__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3393:2: rule__VariableWhereEntry__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__Group__6__Impl_in_rule__VariableWhereEntry__Group__66883);
            rule__VariableWhereEntry__Group__6__Impl();
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
    // $ANTLR end rule__VariableWhereEntry__Group__6


    // $ANTLR start rule__VariableWhereEntry__Group__6__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3399:1: rule__VariableWhereEntry__Group__6__Impl : ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) ;
    public final void rule__VariableWhereEntry__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3403:1: ( ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3404:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3404:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3405:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3406:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3406:2: rule__VariableWhereEntry__RightAttributeAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__6__Impl6910);
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
    // $ANTLR end rule__VariableWhereEntry__Group__6__Impl


    // $ANTLR start rule__StringAttributeWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3430:1: rule__StringAttributeWhereEntry__Group__0 : rule__StringAttributeWhereEntry__Group__0__Impl rule__StringAttributeWhereEntry__Group__1 ;
    public final void rule__StringAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3434:1: ( rule__StringAttributeWhereEntry__Group__0__Impl rule__StringAttributeWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3435:2: rule__StringAttributeWhereEntry__Group__0__Impl rule__StringAttributeWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__0__Impl_in_rule__StringAttributeWhereEntry__Group__06954);
            rule__StringAttributeWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__06957);
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


    // $ANTLR start rule__StringAttributeWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3442:1: rule__StringAttributeWhereEntry__Group__0__Impl : ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3446:1: ( ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3447:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3447:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3448:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3449:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3449:2: rule__StringAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__0__Impl6984);
            rule__StringAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__0__Impl


    // $ANTLR start rule__StringAttributeWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3459:1: rule__StringAttributeWhereEntry__Group__1 : rule__StringAttributeWhereEntry__Group__1__Impl rule__StringAttributeWhereEntry__Group__2 ;
    public final void rule__StringAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3463:1: ( rule__StringAttributeWhereEntry__Group__1__Impl rule__StringAttributeWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3464:2: rule__StringAttributeWhereEntry__Group__1__Impl rule__StringAttributeWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__1__Impl_in_rule__StringAttributeWhereEntry__Group__17014);
            rule__StringAttributeWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__17017);
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


    // $ANTLR start rule__StringAttributeWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3471:1: rule__StringAttributeWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__StringAttributeWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3475:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3476:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3476:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3477:1: '.'
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__StringAttributeWhereEntry__Group__1__Impl7045); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__1__Impl


    // $ANTLR start rule__StringAttributeWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3490:1: rule__StringAttributeWhereEntry__Group__2 : rule__StringAttributeWhereEntry__Group__2__Impl rule__StringAttributeWhereEntry__Group__3 ;
    public final void rule__StringAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3494:1: ( rule__StringAttributeWhereEntry__Group__2__Impl rule__StringAttributeWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3495:2: rule__StringAttributeWhereEntry__Group__2__Impl rule__StringAttributeWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__2__Impl_in_rule__StringAttributeWhereEntry__Group__27076);
            rule__StringAttributeWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__27079);
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


    // $ANTLR start rule__StringAttributeWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3502:1: rule__StringAttributeWhereEntry__Group__2__Impl : ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3506:1: ( ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3507:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3507:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3508:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3509:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3509:2: rule__StringAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__2__Impl7106);
            rule__StringAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__2__Impl


    // $ANTLR start rule__StringAttributeWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3519:1: rule__StringAttributeWhereEntry__Group__3 : rule__StringAttributeWhereEntry__Group__3__Impl rule__StringAttributeWhereEntry__Group__4 ;
    public final void rule__StringAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3523:1: ( rule__StringAttributeWhereEntry__Group__3__Impl rule__StringAttributeWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3524:2: rule__StringAttributeWhereEntry__Group__3__Impl rule__StringAttributeWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__3__Impl_in_rule__StringAttributeWhereEntry__Group__37136);
            rule__StringAttributeWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__37139);
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


    // $ANTLR start rule__StringAttributeWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3531:1: rule__StringAttributeWhereEntry__Group__3__Impl : ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3535:1: ( ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3536:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3536:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3537:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3538:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3538:2: rule__StringAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__3__Impl7166);
            rule__StringAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__3__Impl


    // $ANTLR start rule__StringAttributeWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3548:1: rule__StringAttributeWhereEntry__Group__4 : rule__StringAttributeWhereEntry__Group__4__Impl ;
    public final void rule__StringAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3552:1: ( rule__StringAttributeWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3553:2: rule__StringAttributeWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__Group__4__Impl_in_rule__StringAttributeWhereEntry__Group__47196);
            rule__StringAttributeWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__4


    // $ANTLR start rule__StringAttributeWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3559:1: rule__StringAttributeWhereEntry__Group__4__Impl : ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3563:1: ( ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3564:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3564:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3565:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3566:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3566:2: rule__StringAttributeWhereEntry__PatternAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__4__Impl7223);
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
    // $ANTLR end rule__StringAttributeWhereEntry__Group__4__Impl


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3586:1: rule__BooleanAttributeWhereEntry__Group__0 : rule__BooleanAttributeWhereEntry__Group__0__Impl rule__BooleanAttributeWhereEntry__Group__1 ;
    public final void rule__BooleanAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3590:1: ( rule__BooleanAttributeWhereEntry__Group__0__Impl rule__BooleanAttributeWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3591:2: rule__BooleanAttributeWhereEntry__Group__0__Impl rule__BooleanAttributeWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__0__Impl_in_rule__BooleanAttributeWhereEntry__Group__07263);
            rule__BooleanAttributeWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__07266);
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


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3598:1: rule__BooleanAttributeWhereEntry__Group__0__Impl : ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3602:1: ( ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3603:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3603:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3604:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3605:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3605:2: rule__BooleanAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__0__Impl7293);
            rule__BooleanAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__0__Impl


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3615:1: rule__BooleanAttributeWhereEntry__Group__1 : rule__BooleanAttributeWhereEntry__Group__1__Impl rule__BooleanAttributeWhereEntry__Group__2 ;
    public final void rule__BooleanAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3619:1: ( rule__BooleanAttributeWhereEntry__Group__1__Impl rule__BooleanAttributeWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3620:2: rule__BooleanAttributeWhereEntry__Group__1__Impl rule__BooleanAttributeWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__1__Impl_in_rule__BooleanAttributeWhereEntry__Group__17323);
            rule__BooleanAttributeWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__17326);
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


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3627:1: rule__BooleanAttributeWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3631:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3632:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3632:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3633:1: '.'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__BooleanAttributeWhereEntry__Group__1__Impl7354); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__1__Impl


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3646:1: rule__BooleanAttributeWhereEntry__Group__2 : rule__BooleanAttributeWhereEntry__Group__2__Impl rule__BooleanAttributeWhereEntry__Group__3 ;
    public final void rule__BooleanAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3650:1: ( rule__BooleanAttributeWhereEntry__Group__2__Impl rule__BooleanAttributeWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3651:2: rule__BooleanAttributeWhereEntry__Group__2__Impl rule__BooleanAttributeWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__2__Impl_in_rule__BooleanAttributeWhereEntry__Group__27385);
            rule__BooleanAttributeWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__27388);
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


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3658:1: rule__BooleanAttributeWhereEntry__Group__2__Impl : ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3662:1: ( ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3663:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3663:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3664:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3665:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3665:2: rule__BooleanAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__2__Impl7415);
            rule__BooleanAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__2__Impl


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3675:1: rule__BooleanAttributeWhereEntry__Group__3 : rule__BooleanAttributeWhereEntry__Group__3__Impl rule__BooleanAttributeWhereEntry__Group__4 ;
    public final void rule__BooleanAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3679:1: ( rule__BooleanAttributeWhereEntry__Group__3__Impl rule__BooleanAttributeWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3680:2: rule__BooleanAttributeWhereEntry__Group__3__Impl rule__BooleanAttributeWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__3__Impl_in_rule__BooleanAttributeWhereEntry__Group__37445);
            rule__BooleanAttributeWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__37448);
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


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3687:1: rule__BooleanAttributeWhereEntry__Group__3__Impl : ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3691:1: ( ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3692:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3692:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3693:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3694:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3694:2: rule__BooleanAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__3__Impl7475);
            rule__BooleanAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__3__Impl


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3704:1: rule__BooleanAttributeWhereEntry__Group__4 : rule__BooleanAttributeWhereEntry__Group__4__Impl ;
    public final void rule__BooleanAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3708:1: ( rule__BooleanAttributeWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3709:2: rule__BooleanAttributeWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Group__4__Impl_in_rule__BooleanAttributeWhereEntry__Group__47505);
            rule__BooleanAttributeWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__4


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3715:1: rule__BooleanAttributeWhereEntry__Group__4__Impl : ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3719:1: ( ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3720:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3720:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3721:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3722:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3722:2: rule__BooleanAttributeWhereEntry__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__4__Impl7532);
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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__4__Impl


    // $ANTLR start rule__NullWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3742:1: rule__NullWhereEntry__Group__0 : rule__NullWhereEntry__Group__0__Impl rule__NullWhereEntry__Group__1 ;
    public final void rule__NullWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3746:1: ( rule__NullWhereEntry__Group__0__Impl rule__NullWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3747:2: rule__NullWhereEntry__Group__0__Impl rule__NullWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__0__Impl_in_rule__NullWhereEntry__Group__07572);
            rule__NullWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__07575);
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


    // $ANTLR start rule__NullWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3754:1: rule__NullWhereEntry__Group__0__Impl : ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__NullWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3758:1: ( ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3759:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3759:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3760:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3761:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3761:2: rule__NullWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__0__Impl7602);
            rule__NullWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__0__Impl


    // $ANTLR start rule__NullWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3771:1: rule__NullWhereEntry__Group__1 : rule__NullWhereEntry__Group__1__Impl rule__NullWhereEntry__Group__2 ;
    public final void rule__NullWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3775:1: ( rule__NullWhereEntry__Group__1__Impl rule__NullWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3776:2: rule__NullWhereEntry__Group__1__Impl rule__NullWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__1__Impl_in_rule__NullWhereEntry__Group__17632);
            rule__NullWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__17635);
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


    // $ANTLR start rule__NullWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3783:1: rule__NullWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__NullWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3787:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3788:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3788:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3789:1: '.'
            {
             before(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__NullWhereEntry__Group__1__Impl7663); 
             after(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__1__Impl


    // $ANTLR start rule__NullWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3802:1: rule__NullWhereEntry__Group__2 : rule__NullWhereEntry__Group__2__Impl rule__NullWhereEntry__Group__3 ;
    public final void rule__NullWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3806:1: ( rule__NullWhereEntry__Group__2__Impl rule__NullWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3807:2: rule__NullWhereEntry__Group__2__Impl rule__NullWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__2__Impl_in_rule__NullWhereEntry__Group__27694);
            rule__NullWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__27697);
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


    // $ANTLR start rule__NullWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3814:1: rule__NullWhereEntry__Group__2__Impl : ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) ;
    public final void rule__NullWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3818:1: ( ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3819:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3819:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3820:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3821:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3821:2: rule__NullWhereEntry__FeatureAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__2__Impl7724);
            rule__NullWhereEntry__FeatureAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__2__Impl


    // $ANTLR start rule__NullWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3831:1: rule__NullWhereEntry__Group__3 : rule__NullWhereEntry__Group__3__Impl rule__NullWhereEntry__Group__4 ;
    public final void rule__NullWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3835:1: ( rule__NullWhereEntry__Group__3__Impl rule__NullWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3836:2: rule__NullWhereEntry__Group__3__Impl rule__NullWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__3__Impl_in_rule__NullWhereEntry__Group__37754);
            rule__NullWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__37757);
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


    // $ANTLR start rule__NullWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3843:1: rule__NullWhereEntry__Group__3__Impl : ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) ;
    public final void rule__NullWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3847:1: ( ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3848:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3848:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3849:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3850:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3850:2: rule__NullWhereEntry__OperatorAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__3__Impl7784);
            rule__NullWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__3__Impl


    // $ANTLR start rule__NullWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3860:1: rule__NullWhereEntry__Group__4 : rule__NullWhereEntry__Group__4__Impl ;
    public final void rule__NullWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3864:1: ( rule__NullWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3865:2: rule__NullWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullWhereEntry__Group__4__Impl_in_rule__NullWhereEntry__Group__47814);
            rule__NullWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__NullWhereEntry__Group__4


    // $ANTLR start rule__NullWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3871:1: rule__NullWhereEntry__Group__4__Impl : ( 'null' ) ;
    public final void rule__NullWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3875:1: ( ( 'null' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3876:1: ( 'null' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3876:1: ( 'null' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3877:1: 'null'
            {
             before(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__NullWhereEntry__Group__4__Impl7842); 
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
    // $ANTLR end rule__NullWhereEntry__Group__4__Impl


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3900:1: rule__ReferenceAliasWhereEntry__Group__0 : rule__ReferenceAliasWhereEntry__Group__0__Impl rule__ReferenceAliasWhereEntry__Group__1 ;
    public final void rule__ReferenceAliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3904:1: ( rule__ReferenceAliasWhereEntry__Group__0__Impl rule__ReferenceAliasWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3905:2: rule__ReferenceAliasWhereEntry__Group__0__Impl rule__ReferenceAliasWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__0__Impl_in_rule__ReferenceAliasWhereEntry__Group__07883);
            rule__ReferenceAliasWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__07886);
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


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3912:1: rule__ReferenceAliasWhereEntry__Group__0__Impl : ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3916:1: ( ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3917:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3917:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3918:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3919:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3919:2: rule__ReferenceAliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__0__Impl7913);
            rule__ReferenceAliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__0__Impl


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3929:1: rule__ReferenceAliasWhereEntry__Group__1 : rule__ReferenceAliasWhereEntry__Group__1__Impl rule__ReferenceAliasWhereEntry__Group__2 ;
    public final void rule__ReferenceAliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3933:1: ( rule__ReferenceAliasWhereEntry__Group__1__Impl rule__ReferenceAliasWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3934:2: rule__ReferenceAliasWhereEntry__Group__1__Impl rule__ReferenceAliasWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__1__Impl_in_rule__ReferenceAliasWhereEntry__Group__17943);
            rule__ReferenceAliasWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__17946);
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


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3941:1: rule__ReferenceAliasWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3945:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3946:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3946:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3947:1: '.'
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferenceAliasWhereEntry__Group__1__Impl7974); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__1__Impl


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3960:1: rule__ReferenceAliasWhereEntry__Group__2 : rule__ReferenceAliasWhereEntry__Group__2__Impl rule__ReferenceAliasWhereEntry__Group__3 ;
    public final void rule__ReferenceAliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3964:1: ( rule__ReferenceAliasWhereEntry__Group__2__Impl rule__ReferenceAliasWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3965:2: rule__ReferenceAliasWhereEntry__Group__2__Impl rule__ReferenceAliasWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__2__Impl_in_rule__ReferenceAliasWhereEntry__Group__28005);
            rule__ReferenceAliasWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__28008);
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


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3972:1: rule__ReferenceAliasWhereEntry__Group__2__Impl : ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3976:1: ( ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3977:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3977:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3978:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3979:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3979:2: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__2__Impl8035);
            rule__ReferenceAliasWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__2__Impl


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3989:1: rule__ReferenceAliasWhereEntry__Group__3 : rule__ReferenceAliasWhereEntry__Group__3__Impl rule__ReferenceAliasWhereEntry__Group__4 ;
    public final void rule__ReferenceAliasWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3993:1: ( rule__ReferenceAliasWhereEntry__Group__3__Impl rule__ReferenceAliasWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:3994:2: rule__ReferenceAliasWhereEntry__Group__3__Impl rule__ReferenceAliasWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__3__Impl_in_rule__ReferenceAliasWhereEntry__Group__38065);
            rule__ReferenceAliasWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__38068);
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


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4001:1: rule__ReferenceAliasWhereEntry__Group__3__Impl : ( '=' ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4005:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4006:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4006:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4007:1: '='
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__3__Impl8096); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__3__Impl


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4020:1: rule__ReferenceAliasWhereEntry__Group__4 : rule__ReferenceAliasWhereEntry__Group__4__Impl ;
    public final void rule__ReferenceAliasWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4024:1: ( rule__ReferenceAliasWhereEntry__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4025:2: rule__ReferenceAliasWhereEntry__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__Group__4__Impl_in_rule__ReferenceAliasWhereEntry__Group__48127);
            rule__ReferenceAliasWhereEntry__Group__4__Impl();
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__4


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4031:1: rule__ReferenceAliasWhereEntry__Group__4__Impl : ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4035:1: ( ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4036:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4036:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4037:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4038:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4038:2: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__4__Impl8154);
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
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__4__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4058:1: rule__SubselectWhereEntry__Group__0 : rule__SubselectWhereEntry__Group__0__Impl rule__SubselectWhereEntry__Group__1 ;
    public final void rule__SubselectWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4062:1: ( rule__SubselectWhereEntry__Group__0__Impl rule__SubselectWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4063:2: rule__SubselectWhereEntry__Group__0__Impl rule__SubselectWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__0__Impl_in_rule__SubselectWhereEntry__Group__08194);
            rule__SubselectWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__08197);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4070:1: rule__SubselectWhereEntry__Group__0__Impl : ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__SubselectWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4074:1: ( ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4075:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4075:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4076:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4077:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4077:2: rule__SubselectWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__0__Impl8224);
            rule__SubselectWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__0__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4087:1: rule__SubselectWhereEntry__Group__1 : rule__SubselectWhereEntry__Group__1__Impl rule__SubselectWhereEntry__Group__2 ;
    public final void rule__SubselectWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4091:1: ( rule__SubselectWhereEntry__Group__1__Impl rule__SubselectWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4092:2: rule__SubselectWhereEntry__Group__1__Impl rule__SubselectWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__1__Impl_in_rule__SubselectWhereEntry__Group__18254);
            rule__SubselectWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__18257);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4099:1: rule__SubselectWhereEntry__Group__1__Impl : ( '.' ) ;
    public final void rule__SubselectWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4103:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4104:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4104:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4105:1: '.'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__SubselectWhereEntry__Group__1__Impl8285); 
             after(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__1__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4118:1: rule__SubselectWhereEntry__Group__2 : rule__SubselectWhereEntry__Group__2__Impl rule__SubselectWhereEntry__Group__3 ;
    public final void rule__SubselectWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4122:1: ( rule__SubselectWhereEntry__Group__2__Impl rule__SubselectWhereEntry__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4123:2: rule__SubselectWhereEntry__Group__2__Impl rule__SubselectWhereEntry__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__2__Impl_in_rule__SubselectWhereEntry__Group__28316);
            rule__SubselectWhereEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__28319);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4130:1: rule__SubselectWhereEntry__Group__2__Impl : ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) ;
    public final void rule__SubselectWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4134:1: ( ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4135:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4135:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4136:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4137:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4137:2: rule__SubselectWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__2__Impl8346);
            rule__SubselectWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__2__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4147:1: rule__SubselectWhereEntry__Group__3 : rule__SubselectWhereEntry__Group__3__Impl rule__SubselectWhereEntry__Group__4 ;
    public final void rule__SubselectWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4151:1: ( rule__SubselectWhereEntry__Group__3__Impl rule__SubselectWhereEntry__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4152:2: rule__SubselectWhereEntry__Group__3__Impl rule__SubselectWhereEntry__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__3__Impl_in_rule__SubselectWhereEntry__Group__38376);
            rule__SubselectWhereEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__38379);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4159:1: rule__SubselectWhereEntry__Group__3__Impl : ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) ;
    public final void rule__SubselectWhereEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4163:1: ( ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4164:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4164:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4165:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4166:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4166:2: rule__SubselectWhereEntry__NotInAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__3__Impl8406);
                    rule__SubselectWhereEntry__NotInAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__3__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4176:1: rule__SubselectWhereEntry__Group__4 : rule__SubselectWhereEntry__Group__4__Impl rule__SubselectWhereEntry__Group__5 ;
    public final void rule__SubselectWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4180:1: ( rule__SubselectWhereEntry__Group__4__Impl rule__SubselectWhereEntry__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4181:2: rule__SubselectWhereEntry__Group__4__Impl rule__SubselectWhereEntry__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__4__Impl_in_rule__SubselectWhereEntry__Group__48437);
            rule__SubselectWhereEntry__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__48440);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4188:1: rule__SubselectWhereEntry__Group__4__Impl : ( 'in' ) ;
    public final void rule__SubselectWhereEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4192:1: ( ( 'in' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4193:1: ( 'in' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4193:1: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4194:1: 'in'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__SubselectWhereEntry__Group__4__Impl8468); 
             after(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__4__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4207:1: rule__SubselectWhereEntry__Group__5 : rule__SubselectWhereEntry__Group__5__Impl rule__SubselectWhereEntry__Group__6 ;
    public final void rule__SubselectWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4211:1: ( rule__SubselectWhereEntry__Group__5__Impl rule__SubselectWhereEntry__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4212:2: rule__SubselectWhereEntry__Group__5__Impl rule__SubselectWhereEntry__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__5__Impl_in_rule__SubselectWhereEntry__Group__58499);
            rule__SubselectWhereEntry__Group__5__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__58502);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4219:1: rule__SubselectWhereEntry__Group__5__Impl : ( '(' ) ;
    public final void rule__SubselectWhereEntry__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4223:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4224:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4224:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4225:1: '('
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SubselectWhereEntry__Group__5__Impl8530); 
             after(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__5__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4238:1: rule__SubselectWhereEntry__Group__6 : rule__SubselectWhereEntry__Group__6__Impl rule__SubselectWhereEntry__Group__7 ;
    public final void rule__SubselectWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4242:1: ( rule__SubselectWhereEntry__Group__6__Impl rule__SubselectWhereEntry__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4243:2: rule__SubselectWhereEntry__Group__6__Impl rule__SubselectWhereEntry__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__6__Impl_in_rule__SubselectWhereEntry__Group__68561);
            rule__SubselectWhereEntry__Group__6__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__68564);
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


    // $ANTLR start rule__SubselectWhereEntry__Group__6__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4250:1: rule__SubselectWhereEntry__Group__6__Impl : ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) ;
    public final void rule__SubselectWhereEntry__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4254:1: ( ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4255:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4255:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4256:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4257:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4257:2: rule__SubselectWhereEntry__SubQueryAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__6__Impl8591);
            rule__SubselectWhereEntry__SubQueryAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__6__Impl


    // $ANTLR start rule__SubselectWhereEntry__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4267:1: rule__SubselectWhereEntry__Group__7 : rule__SubselectWhereEntry__Group__7__Impl ;
    public final void rule__SubselectWhereEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4271:1: ( rule__SubselectWhereEntry__Group__7__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4272:2: rule__SubselectWhereEntry__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SubselectWhereEntry__Group__7__Impl_in_rule__SubselectWhereEntry__Group__78621);
            rule__SubselectWhereEntry__Group__7__Impl();
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
    // $ANTLR end rule__SubselectWhereEntry__Group__7


    // $ANTLR start rule__SubselectWhereEntry__Group__7__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4278:1: rule__SubselectWhereEntry__Group__7__Impl : ( ')' ) ;
    public final void rule__SubselectWhereEntry__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4282:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4283:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4283:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4284:1: ')'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__SubselectWhereEntry__Group__7__Impl8649); 
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
    // $ANTLR end rule__SubselectWhereEntry__Group__7__Impl


    // $ANTLR start rule__AliasWhereEntry__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4313:1: rule__AliasWhereEntry__Group__0 : rule__AliasWhereEntry__Group__0__Impl rule__AliasWhereEntry__Group__1 ;
    public final void rule__AliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4317:1: ( rule__AliasWhereEntry__Group__0__Impl rule__AliasWhereEntry__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4318:2: rule__AliasWhereEntry__Group__0__Impl rule__AliasWhereEntry__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__0__Impl_in_rule__AliasWhereEntry__Group__08696);
            rule__AliasWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__08699);
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


    // $ANTLR start rule__AliasWhereEntry__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4325:1: rule__AliasWhereEntry__Group__0__Impl : ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) ;
    public final void rule__AliasWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4329:1: ( ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4330:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4330:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4331:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4332:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4332:2: rule__AliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__0__Impl8726);
            rule__AliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__0__Impl


    // $ANTLR start rule__AliasWhereEntry__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4342:1: rule__AliasWhereEntry__Group__1 : rule__AliasWhereEntry__Group__1__Impl rule__AliasWhereEntry__Group__2 ;
    public final void rule__AliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4346:1: ( rule__AliasWhereEntry__Group__1__Impl rule__AliasWhereEntry__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4347:2: rule__AliasWhereEntry__Group__1__Impl rule__AliasWhereEntry__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__1__Impl_in_rule__AliasWhereEntry__Group__18756);
            rule__AliasWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__18759);
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


    // $ANTLR start rule__AliasWhereEntry__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4354:1: rule__AliasWhereEntry__Group__1__Impl : ( '=' ) ;
    public final void rule__AliasWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4358:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4359:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4359:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4360:1: '='
            {
             before(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__AliasWhereEntry__Group__1__Impl8787); 
             after(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__1__Impl


    // $ANTLR start rule__AliasWhereEntry__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4373:1: rule__AliasWhereEntry__Group__2 : rule__AliasWhereEntry__Group__2__Impl ;
    public final void rule__AliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4377:1: ( rule__AliasWhereEntry__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4378:2: rule__AliasWhereEntry__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__Group__2__Impl_in_rule__AliasWhereEntry__Group__28818);
            rule__AliasWhereEntry__Group__2__Impl();
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
    // $ANTLR end rule__AliasWhereEntry__Group__2


    // $ANTLR start rule__AliasWhereEntry__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4384:1: rule__AliasWhereEntry__Group__2__Impl : ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) ;
    public final void rule__AliasWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4388:1: ( ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4389:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4389:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4390:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4391:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4391:2: rule__AliasWhereEntry__RightAliasAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__2__Impl8845);
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
    // $ANTLR end rule__AliasWhereEntry__Group__2__Impl


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4408:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4412:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4413:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4413:1: ( ruleImport )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4414:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_08886);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4423:1: rule__Model__QueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__QueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4427:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4428:1: ( ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4428:1: ( ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4429:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_rule__Model__QueryAssignment_18917);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4438:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4442:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4443:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4443:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4444:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_18948); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4453:1: rule__MQLquery__SelectEntriesAssignment_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4457:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4458:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4458:1: ( ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4459:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_18979);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4468:1: rule__MQLquery__SelectEntriesAssignment_2_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4472:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4473:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4473:1: ( ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4474:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_19010);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4483:1: rule__MQLquery__FromEntriesAssignment_4 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4487:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4488:1: ( ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4488:1: ( ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4489:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_49041);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4498:1: rule__MQLquery__FromEntriesAssignment_5_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4502:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4503:1: ( ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4503:1: ( ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4504:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_19072);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4513:1: rule__MQLquery__WhereEntriesAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntriesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4517:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4518:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4518:1: ( ruleWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4519:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntriesAssignment_6_19103);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4528:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4532:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4533:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4533:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4534:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4535:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4536:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_09138); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4547:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4551:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4552:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4552:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4553:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4554:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4555:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_19177); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4566:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4570:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4571:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4571:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4572:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4573:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4574:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_09216); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4585:1: rule__FromEntry__WithoutsubtypesAssignment_1 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4589:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4590:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4590:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4591:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4592:1: ( 'withoutsubtypes' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4593:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__FromEntry__WithoutsubtypesAssignment_19256); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4608:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4612:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4613:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4613:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4614:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_39295); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4623:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4627:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4628:1: ( ruleScopeClause )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4628:1: ( ruleScopeClause )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4629:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_49326);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4638:1: rule__ScopeClause__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ScopeClause__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4642:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4643:1: ( ( 'not' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4643:1: ( ( 'not' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4644:1: ( 'not' )
            {
             before(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4645:1: ( 'not' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4646:1: 'not'
            {
             before(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__ScopeClause__NotInAssignment_09362); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4661:1: rule__ScopeClause__ScopeAssignment_2 : ( ruleScope ) ;
    public final void rule__ScopeClause__ScopeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4665:1: ( ( ruleScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4666:1: ( ruleScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4666:1: ( ruleScope )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4667:1: ruleScope
            {
             before(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_rule__ScopeClause__ScopeAssignment_29401);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4676:1: rule__ResourceScope__UrisAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4680:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4681:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4681:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4682:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_29432); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4691:1: rule__ResourceScope__UrisAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4695:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4696:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4696:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4697:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_3_19463); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4706:1: rule__ElementScope__UrisAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4710:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4711:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4711:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4712:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_29494); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4721:1: rule__ElementScope__UrisAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4725:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4726:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4726:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4727:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_3_19525); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4736:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4740:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4741:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4741:1: ( ruleAndWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4742:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_19556);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4751:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4755:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4756:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4756:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4757:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_19587);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4766:1: rule__DoubleWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4770:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4771:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4771:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4772:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4773:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4774:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_09622); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4785:1: rule__DoubleWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4789:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4790:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4790:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4791:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4792:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4793:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_29661); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4804:1: rule__DoubleWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__DoubleWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4808:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4809:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4809:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4810:1: ruleNumericOperator
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_39696);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4819:1: rule__DoubleWhereEntry__ValueAssignment_4 : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4823:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4824:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4824:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4825:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 
            match(input,RULE_SIGNED_DOUBLE,FollowSets000.FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_49727); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4834:1: rule__LongWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4838:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4839:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4839:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4840:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4841:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4842:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_09762); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4853:1: rule__LongWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4857:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4858:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4858:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4859:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4860:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4861:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_29801); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4872:1: rule__LongWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__LongWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4876:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4877:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4877:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4878:1: ruleNumericOperator
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_39836);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4887:1: rule__LongWhereEntry__ValueAssignment_4 : ( RULE_SINGED_LONG ) ;
    public final void rule__LongWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4891:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4892:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4892:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4893:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 
            match(input,RULE_SINGED_LONG,FollowSets000.FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_49867); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4902:1: rule__VariableWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4906:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4907:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4907:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4908:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4909:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4910:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_09902); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4921:1: rule__VariableWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4925:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4926:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4926:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4927:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4928:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4929:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_29941); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4940:1: rule__VariableWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__VariableWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4944:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4945:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4945:1: ( ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4946:1: ruleNumericOperator
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_39976);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4955:1: rule__VariableWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4959:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4960:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4960:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4961:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4962:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4963:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_410011); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4974:1: rule__VariableWhereEntry__RightAttributeAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAttributeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4978:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4979:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4979:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4980:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4981:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4982:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_610050); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4993:1: rule__StringAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4997:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4998:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4998:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:4999:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5000:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5001:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_010089); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5012:1: rule__StringAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5016:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5017:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5017:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5018:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5019:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5020:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_210128); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5031:1: rule__StringAttributeWhereEntry__OperatorAssignment_3 : ( ruleStringOperator ) ;
    public final void rule__StringAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5035:1: ( ( ruleStringOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5036:1: ( ruleStringOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5036:1: ( ruleStringOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5037:1: ruleStringOperator
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_310163);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5046:1: rule__StringAttributeWhereEntry__PatternAssignment_4 : ( RULE_STRING ) ;
    public final void rule__StringAttributeWhereEntry__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5050:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5051:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5051:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5052:1: RULE_STRING
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_410194); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5061:1: rule__BooleanAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5065:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5066:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5066:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5067:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5068:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5069:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_010229); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5080:1: rule__BooleanAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5084:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5085:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5085:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5086:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5087:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5088:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_210268); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5099:1: rule__BooleanAttributeWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__BooleanAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5103:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5104:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5104:1: ( ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5105:1: ruleBooleanOperator
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_310303);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5114:1: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5118:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5119:1: ( ( 'true' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5119:1: ( ( 'true' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5120:1: ( 'true' )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5121:1: ( 'true' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5122:1: 'true'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_010339); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5137:1: rule__NullWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5141:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5142:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5142:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5143:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5144:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5145:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_010382); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5156:1: rule__NullWhereEntry__FeatureAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5160:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5161:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5161:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5162:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5163:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5164:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_210421); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5175:1: rule__NullWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__NullWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5179:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5180:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5180:1: ( ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5181:1: ruleBooleanOperator
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_310456);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5190:1: rule__ReferenceAliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5194:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5195:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5195:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5196:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5197:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5198:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_010491); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5209:1: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5213:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5214:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5214:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5215:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5216:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5217:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_210530); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5228:1: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5232:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5233:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5233:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5234:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5235:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5236:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_410569); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5247:1: rule__SubselectWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5251:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5252:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5252:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5253:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5254:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5255:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_010608); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5266:1: rule__SubselectWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5270:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5271:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5271:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5272:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5273:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5274:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_210647); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5285:1: rule__SubselectWhereEntry__NotInAssignment_3 : ( ( 'not' ) ) ;
    public final void rule__SubselectWhereEntry__NotInAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5289:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5290:1: ( ( 'not' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5290:1: ( ( 'not' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5291:1: ( 'not' )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5292:1: ( 'not' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5293:1: 'not'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__SubselectWhereEntry__NotInAssignment_310687); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5308:1: rule__SubselectWhereEntry__SubQueryAssignment_6 : ( ruleMQLquery ) ;
    public final void rule__SubselectWhereEntry__SubQueryAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5312:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5313:1: ( ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5313:1: ( ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5314:1: ruleMQLquery
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_610726);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5323:1: rule__AliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5327:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5328:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5328:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5329:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5330:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5331:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_010761); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5342:1: rule__AliasWhereEntry__RightAliasAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__RightAliasAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5346:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5347:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5347:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5348:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5349:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug287941TestLanguage.g:5350:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_210800); 
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
        public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02264 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl2294 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__QueryAssignment_1_in_rule__Model__Group__1__Impl2352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02386 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Import__Group__0__Impl2417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl2475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02509 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MQLquery__Group__0__Impl2540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12571 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22631 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2661 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32692 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MQLquery__Group__3__Impl2723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42754 = new BitSet(new long[]{0x0000000001800002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52814 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2844 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02947 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MQLquery__Group_2__0__Impl2978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__13009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl3036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__03070 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MQLquery__Group_5__0__Impl3101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03193 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_6__0__Impl3224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3284 = new BitSet(new long[]{0x0000000400000022L});
        public static final BitSet FOLLOW_rule__MQLquery__WhereEntriesAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3296 = new BitSet(new long[]{0x0000000400000022L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03333 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03455 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SelectEntry__Group_1__0__Impl3486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03578 = new BitSet(new long[]{0x0000002004000000L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13638 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__1__Impl3668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23699 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__FromEntry__Group__2__Impl3730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33761 = new BitSet(new long[]{0x0000004008000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__0__Impl_in_rule__ScopeClause__Group__03889 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__1_in_rule__ScopeClause__Group__03892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__NotInAssignment_0_in_rule__ScopeClause__Group__0__Impl3919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__1__Impl_in_rule__ScopeClause__Group__13950 = new BitSet(new long[]{0x0000000090000000L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__2_in_rule__ScopeClause__Group__13953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ScopeClause__Group__1__Impl3981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__Group__2__Impl_in_rule__ScopeClause__Group__24012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScopeClause__ScopeAssignment_2_in_rule__ScopeClause__Group__2__Impl4039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04075 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ResourceScope__Group__0__Impl4106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14137 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ResourceScope__Group__1__Impl4168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24199 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_2_in_rule__ResourceScope__Group__2__Impl4229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34259 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__0_in_rule__ResourceScope__Group__3__Impl4289 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__4__Impl4348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__0__Impl_in_rule__ResourceScope__Group_3__04389 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__1_in_rule__ResourceScope__Group_3__04392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ResourceScope__Group_3__0__Impl4420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__Group_3__1__Impl_in_rule__ResourceScope__Group_3__14451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_3_1_in_rule__ResourceScope__Group_3__1__Impl4478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04512 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__0__Impl4543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14574 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ElementScope__Group__1__Impl4605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__24636 = new BitSet(new long[]{0x0000000040800000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_2_in_rule__ElementScope__Group__2__Impl4666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__34696 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__0_in_rule__ElementScope__Group__3__Impl4726 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__44757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__4__Impl4785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__0__Impl_in_rule__ElementScope__Group_3__04826 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__1_in_rule__ElementScope__Group_3__04829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ElementScope__Group_3__0__Impl4857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__Group_3__1__Impl_in_rule__ElementScope__Group_3__14888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_3_1_in_rule__ElementScope__Group_3__1__Impl4915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__04949 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl4979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05070 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5160 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5172 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05209 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__WhereEntry__Group_1_1__0__Impl5240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05332 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05453 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__15514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl5543 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl5555 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__05592 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__05595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__AndWhereEntry__Group_1_1__0__Impl5623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__15654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl5681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__05715 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__05718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ParWhereEntry__Group__0__Impl5746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__15777 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__15780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl5807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__25836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ParWhereEntry__Group__2__Impl5864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__0__Impl_in_rule__DoubleWhereEntry__Group__05901 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__05904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__0__Impl5931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__1__Impl_in_rule__DoubleWhereEntry__Group__15961 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__15964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__DoubleWhereEntry__Group__1__Impl5992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__2__Impl_in_rule__DoubleWhereEntry__Group__26023 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__26026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__2__Impl6053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__3__Impl_in_rule__DoubleWhereEntry__Group__36083 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__36086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__3__Impl6113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__4__Impl_in_rule__DoubleWhereEntry__Group__46143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__4__Impl6170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__0__Impl_in_rule__LongWhereEntry__Group__06210 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__06213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__0__Impl6240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__1__Impl_in_rule__LongWhereEntry__Group__16270 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__16273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LongWhereEntry__Group__1__Impl6301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__2__Impl_in_rule__LongWhereEntry__Group__26332 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__26335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__2__Impl6362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__3__Impl_in_rule__LongWhereEntry__Group__36392 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__36395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__3__Impl6422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__Group__4__Impl_in_rule__LongWhereEntry__Group__46452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__4__Impl6479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__0__Impl_in_rule__VariableWhereEntry__Group__06519 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__06522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__0__Impl6549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__1__Impl_in_rule__VariableWhereEntry__Group__16579 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__16582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__VariableWhereEntry__Group__1__Impl6610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__2__Impl_in_rule__VariableWhereEntry__Group__26641 = new BitSet(new long[]{0x000000000003F000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__26644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__2__Impl6671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__3__Impl_in_rule__VariableWhereEntry__Group__36701 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__36704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__3__Impl6731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__4__Impl_in_rule__VariableWhereEntry__Group__46761 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__46764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__4__Impl6791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__5__Impl_in_rule__VariableWhereEntry__Group__56821 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__56824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__VariableWhereEntry__Group__5__Impl6852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__6__Impl_in_rule__VariableWhereEntry__Group__66883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__6__Impl6910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__0__Impl_in_rule__StringAttributeWhereEntry__Group__06954 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__06957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__0__Impl6984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__1__Impl_in_rule__StringAttributeWhereEntry__Group__17014 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__17017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__StringAttributeWhereEntry__Group__1__Impl7045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__2__Impl_in_rule__StringAttributeWhereEntry__Group__27076 = new BitSet(new long[]{0x00000000000F0000L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__27079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__2__Impl7106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__3__Impl_in_rule__StringAttributeWhereEntry__Group__37136 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__37139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__3__Impl7166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__4__Impl_in_rule__StringAttributeWhereEntry__Group__47196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__4__Impl7223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__0__Impl_in_rule__BooleanAttributeWhereEntry__Group__07263 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__07266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__0__Impl7293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__1__Impl_in_rule__BooleanAttributeWhereEntry__Group__17323 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__17326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__BooleanAttributeWhereEntry__Group__1__Impl7354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__2__Impl_in_rule__BooleanAttributeWhereEntry__Group__27385 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__27388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__2__Impl7415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__3__Impl_in_rule__BooleanAttributeWhereEntry__Group__37445 = new BitSet(new long[]{0x0000008000000800L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__37448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__3__Impl7475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__4__Impl_in_rule__BooleanAttributeWhereEntry__Group__47505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__4__Impl7532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__0__Impl_in_rule__NullWhereEntry__Group__07572 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__07575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__0__Impl7602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__1__Impl_in_rule__NullWhereEntry__Group__17632 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__17635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__NullWhereEntry__Group__1__Impl7663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__2__Impl_in_rule__NullWhereEntry__Group__27694 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__27697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__2__Impl7724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__3__Impl_in_rule__NullWhereEntry__Group__37754 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__37757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__3__Impl7784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullWhereEntry__Group__4__Impl_in_rule__NullWhereEntry__Group__47814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__NullWhereEntry__Group__4__Impl7842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__0__Impl_in_rule__ReferenceAliasWhereEntry__Group__07883 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__07886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__0__Impl7913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__1__Impl_in_rule__ReferenceAliasWhereEntry__Group__17943 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__17946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferenceAliasWhereEntry__Group__1__Impl7974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__2__Impl_in_rule__ReferenceAliasWhereEntry__Group__28005 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__28008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__2__Impl8035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__3__Impl_in_rule__ReferenceAliasWhereEntry__Group__38065 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__38068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__3__Impl8096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__4__Impl_in_rule__ReferenceAliasWhereEntry__Group__48127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__4__Impl8154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__0__Impl_in_rule__SubselectWhereEntry__Group__08194 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__08197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__0__Impl8224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__1__Impl_in_rule__SubselectWhereEntry__Group__18254 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__18257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SubselectWhereEntry__Group__1__Impl8285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__2__Impl_in_rule__SubselectWhereEntry__Group__28316 = new BitSet(new long[]{0x0000004008000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__28319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__2__Impl8346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__3__Impl_in_rule__SubselectWhereEntry__Group__38376 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__38379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__3__Impl8406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__4__Impl_in_rule__SubselectWhereEntry__Group__48437 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__48440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SubselectWhereEntry__Group__4__Impl8468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__5__Impl_in_rule__SubselectWhereEntry__Group__58499 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__58502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SubselectWhereEntry__Group__5__Impl8530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__6__Impl_in_rule__SubselectWhereEntry__Group__68561 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__68564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__6__Impl8591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__7__Impl_in_rule__SubselectWhereEntry__Group__78621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SubselectWhereEntry__Group__7__Impl8649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__0__Impl_in_rule__AliasWhereEntry__Group__08696 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__08699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__0__Impl8726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__1__Impl_in_rule__AliasWhereEntry__Group__18756 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__18759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__AliasWhereEntry__Group__1__Impl8787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__2__Impl_in_rule__AliasWhereEntry__Group__28818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__2__Impl8845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_08886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__QueryAssignment_18917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_18948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_18979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_19010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_49041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_19072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntriesAssignment_6_19103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_09138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_19177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_09216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__FromEntry__WithoutsubtypesAssignment_19256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_39295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_49326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ScopeClause__NotInAssignment_09362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScope_in_rule__ScopeClause__ScopeAssignment_29401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_29432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_3_19463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_29494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_3_19525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_19556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_19587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_09622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_29661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_39696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_49727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_09762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_29801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_39836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_49867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_09902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_29941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_39976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_410011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_610050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_010089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_210128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_310163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_410194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_010229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_210268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_310303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_010339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_010382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_210421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_310456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_010491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_210530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_410569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_010608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_210647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SubselectWhereEntry__NotInAssignment_310687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_610726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_010761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_210800 = new BitSet(new long[]{0x0000000000000002L});
    }


}